package com.google.app.portlet.actions;

import api.master.slayer.constant.Constant;
import api.master.slayer.model.ApiMapKey;
import api.master.slayer.model.ConnectedAccounts;
import api.master.slayer.service.ApiMapKeyLocalService;
import api.master.slayer.service.ApiMapKeyLocalServiceUtil;
import api.master.slayer.service.ConnectedAccountsLocalService;
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
import com.google.app.Util.JsonUtil;
import com.google.app.configuration.section.GoogleConfigurationSection;
import com.google.app.constants.GoogleAppPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.dispatch.executor.DispatchTaskClusterMode;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.dispatch.service.DispatchTriggerLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + GoogleAppPortletKeys.GOOGLEAPP,
                "mvc.command.name=add/app/map/key/data"
        },
        service = MVCResourceCommand.class
)
public class AddAppKeysDatatMVCResourceCommand extends BaseMVCResourceCommand {
    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        String keys = ParamUtil.getString(resourceRequest, "keys");
        String firstAppSpreadSheetId = ParamUtil.getString(resourceRequest, "firstAppSpreadSheetId");
        String secondAppSpreadSheetId = ParamUtil.getString(resourceRequest, "secondAppSpreadSheetId");
        String firstAppWorkSheetName = ParamUtil.getString(resourceRequest, "firstAppWorkSheetName");
        String secondAppWorkSheetName = ParamUtil.getString(resourceRequest, "secondAppWorkSheetName");

        String firstAppName = ParamUtil.getString(resourceRequest, "firstAppName");
        String secondAppName = ParamUtil.getString(resourceRequest, "secondAppName");

        String firstAppUserEmailAddress = ParamUtil.getString(resourceRequest,"firstAppUserEmailAddress");
        String secondAppUserEmailAddress = ParamUtil.getString(resourceRequest,"secondAppUserEmailAddress");

        String appName = firstAppName + StringPool.AMPERSAND + secondAppName;

        JSONObject keyJsonObject = _jsonFactory.createJSONObject(keys);
        JSONObject mapKeyObject = _jsonFactory.createJSONObject();
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        UnicodeProperties typeSettings = new UnicodeProperties();
        typeSettings.put(Constant.FIRST_APP_SPREADSHEET_ID, firstAppSpreadSheetId);
        typeSettings.put(Constant.SECOND_APP_SPREADSHEET_ID, secondAppSpreadSheetId);
        typeSettings.put(Constant.FIRST_APP_WORKSHEET_NAME, firstAppWorkSheetName);
        typeSettings.put(Constant.SECOND_APP_WORKSHEET_NAME, secondAppWorkSheetName);
        typeSettings.put(Constant.FIRST_APP_C_A_ID, getConnectedAccountByAppNameAndEmailAddress(firstAppName,firstAppUserEmailAddress));
        typeSettings.put(Constant.SECOND_APP_C_A_ID, getConnectedAccountByAppNameAndEmailAddress(secondAppName,secondAppUserEmailAddress));
        typeSettings.put(Constant.COUNT, "0");

        for (String jsonKey : keyJsonObject.keySet()) {
            mapKeyObject.put(jsonKey, ParamUtil.getString(resourceRequest, jsonKey));
        }

        ApiMapKey apiMapKey = createAppKeyData(mapKeyObject.toString(),appName,typeSettings.toString(),themeDisplay);

        if(null != apiMapKey){
            createSheduler(resourceRequest, apiMapKey.getApiMapKeyId());
        }
        JSONObject jsonObject = _jsonFactory.createJSONObject();
        jsonObject.put("url", themeDisplay.getPortalURL());
        JSONPortletResponseUtil.writeJSON(
                resourceRequest, resourceResponse, jsonObject);

    }

    private String getConnectedAccountByAppNameAndEmailAddress(String appName, String emailAddress) {
        ConnectedAccounts connectedAccounts = _connectedAccountsLocalService.getAccountByEmailAndAppName(appName, emailAddress);
        return String.valueOf(connectedAccounts.getC_accountId());
    }

    public void createSheduler(ResourceRequest resourceRequest, long apiMapKeyId) throws PortalException {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        try {

            UnicodeProperties unicodeProperties = new UnicodeProperties();
            unicodeProperties.setProperty(Constant.APP_MAP_KEY_ID, String.valueOf(apiMapKeyId));
            DispatchTrigger dispatchTrigger = _dispatchTriggerLocalService.addDispatchTrigger(
                    StringPool.BLANK, themeDisplay.getUserId(), "Custom scheduler type", unicodeProperties,
                    String.valueOf(apiMapKeyId), false);
            LocalDateTime localDateTime = LocalDateTime.now();

            _dispatchTriggerLocalService.updateDispatchTrigger(
                    dispatchTrigger.getDispatchTriggerId(), true, "0 0/1 * 1/1 * ? *",
                    DispatchTaskClusterMode.NOT_APPLICABLE, 0, 0, 0, 0, 0, true,
                    false, localDateTime.getMonthValue() - 1,
                    localDateTime.getDayOfMonth(), localDateTime.getYear(),
                    localDateTime.getHour(), localDateTime.getMinute(), "UTC");

        } catch (Exception e) {
           if (_log.isErrorEnabled()){
               _log.error("Error While Creating Scheduler::",e);
           }
        }

    }

    private ApiMapKey createAppKeyData(String key, String appName, String typeSettings, ThemeDisplay themeDisplay) {
        ApiMapKey apiMapKey = _apiMapKeyLocalService.createApiMapKey(_counterLocalService.increment());

        apiMapKey.setKey(key);
        apiMapKey.setName(appName);
        apiMapKey.setTypeSettings(typeSettings);
        apiMapKey.setUserId(themeDisplay.getUserId());
        apiMapKey.setGroupId(themeDisplay.getScopeGroupId());
        _apiMapKeyLocalService.updateApiMapKey(apiMapKey);
        return apiMapKey;
    }

    private static final Log _log = LogFactoryUtil.getLog(AddAppKeysDatatMVCResourceCommand.class);
    @Reference
    private JSONFactory _jsonFactory;
    @Reference
    private ApiMapKeyLocalService _apiMapKeyLocalService;
    @Reference
    private DispatchTriggerLocalService _dispatchTriggerLocalService;
    @Reference
    private CounterLocalService _counterLocalService;
    @Reference
    private ConnectedAccountsLocalService _connectedAccountsLocalService;
}