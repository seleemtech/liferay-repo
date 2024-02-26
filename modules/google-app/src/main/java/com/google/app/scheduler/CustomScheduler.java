package com.google.app.scheduler;

import api.master.slayer.constant.Constant;
import api.master.slayer.model.ApiMapKey;
import api.master.slayer.model.ConnectedAccounts;
import api.master.slayer.service.ApiMapKeyLocalServiceUtil;
import api.master.slayer.service.ConnectedAccountsLocalServiceUtil;
import com.google.app.Util.APIUtil;
import com.google.app.Util.JsonUtil;
import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Component(
        property = {
                "dispatch.task.executor.name=Custom scheduler name", "dispatch.task.executor.type=Custom scheduler type"
        },
        service = DispatchTaskExecutor.class
)
public class CustomScheduler extends BaseDispatchTaskExecutor {
    @Override
    public void doExecute(
            DispatchTrigger dispatchTrigger,
            DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
            throws IOException, PortalException, GeneralSecurityException, UnirestException {
        UnicodeProperties unicodeProperties = dispatchTrigger.getDispatchTaskSettingsUnicodeProperties();
        try {
            _log.info("Scheduler Execution Started");

            // Get AppMapKeyId from unicodeProperties and get apiMapKey Object
            ApiMapKey apiMapKey = ApiMapKeyLocalServiceUtil.fetchApiMapKey(Long.parseLong(unicodeProperties.getProperty(Constant.APP_MAP_KEY_ID)));
            if (apiMapKey == null) {
                _log.error("Failed to fetch ApiMapKey with ID: {}" + unicodeProperties.getProperty(Constant.APP_MAP_KEY_ID));
                return;
            }

            if (_log.isDebugEnabled()) {
                _log.debug("ApiMapKey details: " + apiMapKey);
            }

            UnicodeProperties apiMapKeyTypeSettings = new UnicodeProperties();
            apiMapKeyTypeSettings.fastLoad(apiMapKey.getTypeSettings());

            // From the apiMapKey object get type setting column from that get Connected Account Id
            // From the Connected Account Id get the refesh Token.
            String firstAppRefreshToken = getRefreshTokenFromC_A(Long.parseLong(apiMapKeyTypeSettings.getProperty(Constant.FIRST_APP_C_A_ID)));
            String secondAppRefreshToken = getRefreshTokenFromC_A(Long.parseLong(apiMapKeyTypeSettings.getProperty(Constant.SECOND_APP_C_A_ID)));

            //First Url Used to get all data from first app
            //Second Url used to get all keys from second app
            //Third url is used to post data to second app
            String firstAppUrl = "https://sheets.googleapis.com/v4/spreadsheets/" + apiMapKeyTypeSettings.getProperty(Constant.FIRST_APP_SPREADSHEET_ID) + "/values/" + apiMapKeyTypeSettings.getProperty(Constant.FIRST_APP_WORKSHEET_NAME) + "!A1:Z";
            String secondAppUrl = "https://sheets.googleapis.com/v4/spreadsheets/" + apiMapKeyTypeSettings.getProperty(Constant.SECOND_APP_SPREADSHEET_ID) + "/values/" + apiMapKeyTypeSettings.getProperty(Constant.SECOND_APP_WORKSHEET_NAME) + "!A1:Z";
            String postUrl = "https://sheets.googleapis.com/v4/spreadsheets/" + apiMapKeyTypeSettings.getProperty(Constant.SECOND_APP_SPREADSHEET_ID) + "/values/" + apiMapKeyTypeSettings.getProperty(Constant.SECOND_APP_WORKSHEET_NAME) + "!A1:Z:append?valueInputOption=USER_ENTERED&insertDataOption=INSERT_ROWS";

            //Get mapped key from value from apiMapKey object and convert into json object.
            JSONObject mapKeyObject = _jsonFactory.createJSONObject(apiMapKey.getKey());

            JSONArray valuesArray = JSONFactoryUtil.createJSONArray();
            String firstAppAccessToken = APIUtil.getAccessTokenByGroupId(apiMapKey.getGroupId(), firstAppRefreshToken);
            String secondAppAccessToken = APIUtil.getAccessTokenByGroupId(apiMapKey.getGroupId(), secondAppRefreshToken);

            HttpResponse<String> firstAppFinalResponse = APIUtil.getMethod(firstAppUrl, firstAppAccessToken);
            HttpResponse<String> secondAppFinalResponse = APIUtil.getMethod(secondAppUrl, secondAppAccessToken);

            List<String> postKeyList = JsonUtil.getPostListKey(secondAppFinalResponse.getBody());

            JSONArray firstAppJsonArray = _jsonFactory.createJSONArray(JsonUtil.getSheetData(firstAppFinalResponse.getBody()));
            JSONObject firstAppLastJsonObject = JsonUtil.getLastJsonObject(firstAppJsonArray.toString());
            boolean updatedCountBoolean = false;
            for (int i = Integer.parseInt(apiMapKeyTypeSettings.getProperty(Constant.COUNT)); i < firstAppJsonArray.length(); i++) {
                updatedCountBoolean = true;
                JSONObject firstAppItem = firstAppJsonArray.getJSONObject(i);
                JSONArray rowArray = JSONFactoryUtil.createJSONArray();
                for (String postKey : postKeyList) {
                    boolean keyMapped = false;
                    for (String getKey : firstAppLastJsonObject.keySet()) {
                        if (mapKeyObject.has(postKey) && mapKeyObject.getString(postKey).equals(getKey)) {
                            rowArray.put(firstAppItem.getString(getKey));
                            keyMapped = true;
                            break;
                        }
                    }
                    if (!keyMapped) {
                        rowArray.put("");
                    }
                }
                valuesArray.put(rowArray);
            }
            if (updatedCountBoolean) {
                _log.info("New value found: ");
                long updatedCount = Long.parseLong(apiMapKeyTypeSettings.getProperty(Constant.COUNT)) + valuesArray.length();
                apiMapKeyTypeSettings.put(Constant.COUNT, String.valueOf(updatedCount));
                apiMapKey.setTypeSettings(apiMapKeyTypeSettings.toString());
                ApiMapKeyLocalServiceUtil.updateApiMapKey(apiMapKey);
                JSONObject postDataObject = JSONFactoryUtil.createJSONObject();
                postDataObject.put("values", valuesArray);
                HttpResponse<String> postResponse = APIUtil.postMethod(postUrl, secondAppAccessToken, postDataObject.toString());
                _log.info("Value posted: ");
                _log.info("Response code: " + postResponse.getCode());
                if (_log.isDebugEnabled()){
                    _log.debug("Post Key List::"+postKeyList);
                    _log.debug("Post Values::"+postDataObject);
                }
            } else {
                _log.info("New value not found: ");
            }
        } catch (Exception e) {
            _log.error("Error occurred during scheduler execution: {}", e);
        }
        _log.info("Scheduler Execution End");
    }

    private String getRefreshTokenFromC_A(long c_a_Id) {
        ConnectedAccounts connectedAccounts = ConnectedAccountsLocalServiceUtil.fetchConnectedAccounts(c_a_Id);
        return connectedAccounts.getRefreshToken();
    }

    @Override
    public String getName() {
        return "Custom scheduler";
    }

    @Reference
    private JSONFactory _jsonFactory;
    private static final Log _log = LogFactoryUtil.getLog(
            CustomScheduler.class);
}