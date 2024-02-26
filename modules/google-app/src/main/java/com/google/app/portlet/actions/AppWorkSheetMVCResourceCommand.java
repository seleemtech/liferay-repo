package com.google.app.portlet.actions;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;
import com.google.app.Util.APIUtil;
import com.google.app.configuration.section.GoogleConfigurationSection;
import com.google.app.constants.GoogleAppPortletKeys;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + GoogleAppPortletKeys.GOOGLEAPP,
                "mvc.command.name=app/work/sheets"
        },
        service = MVCResourceCommand.class
)
public class AppWorkSheetMVCResourceCommand extends BaseMVCResourceCommand {

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        String spreadSheetKey = ParamUtil.getString(resourceRequest, "spreadSheetKey");
        String refreshToken = ParamUtil.getString(resourceRequest, "refreshToken");
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (Validator.isNotNull(refreshToken)) {
            try {
                String accessToken = APIUtil.getAccessToken(themeDisplay,refreshToken);
                HttpResponse<String> finalResponse = getFinalResponse(accessToken,spreadSheetKey);
                JSONObject jsonObject = _jsonFactory.createJSONObject();
                jsonObject.put("workSheet", getSheetName(finalResponse.getBody()));
                JSONPortletResponseUtil.writeJSON(
                        resourceRequest, resourceResponse, jsonObject);
            } catch (UnirestException e) {
                if (_log.isDebugEnabled()){
                    _log.debug(e);
                }
            }
        }
    }

    private static HttpResponse<String> getFinalResponse(String accessToken, String spreadsheetId) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        String url = "https://sheets.googleapis.com/v4/spreadsheets/" + spreadsheetId + "?fields=sheets.properties";
        return Unirest.get(url)
                .header("Authorization", "Bearer " +accessToken)
                .asString();
    }

    private String getSheetName(String responseBody) throws JSONException {
        JSONObject jsonResponse = _jsonFactory.createJSONObject(responseBody);
        JSONArray sheetsArray = jsonResponse.getJSONArray("sheets");
        JSONArray simplifiedSheetsArray = _jsonFactory.createJSONArray();

        for (int i = 0; i < sheetsArray.length(); i++) {
            JSONObject sheetObject = sheetsArray.getJSONObject(i);

            int sheetId = sheetObject.getJSONObject("properties").getInt("sheetId");
            String sheetName = sheetObject.getJSONObject("properties").getString("title");

            JSONObject simplifiedSheetObject = _jsonFactory.createJSONObject();
            simplifiedSheetObject.put("sheetId", sheetId);
            simplifiedSheetObject.put("sheetName", sheetName);

            simplifiedSheetsArray.put(simplifiedSheetObject);
        }

        return simplifiedSheetsArray.toString();
    }


    private static final Log _log = LogFactoryUtil.getLog(AppWorkSheetMVCResourceCommand.class);
    @Reference
    private JSONFactory _jsonFactory;
}