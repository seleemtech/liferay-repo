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
import com.google.app.Util.JsonUtil;
import com.google.app.configuration.section.GoogleConfigurationSection;
import com.google.app.constants.GoogleAppPortletKeys;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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
                "mvc.command.name=app/work/sheets/data"
        },
        service = MVCResourceCommand.class
)
public class AppWorkSheetDataMVCResourceCommand extends BaseMVCResourceCommand {
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String SCOPE = DriveScopes.DRIVE;

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        String firstAppSpreadSheetId = ParamUtil.getString(resourceRequest, "firstAppSpreadSheetId");
        String firstAppRefreshToken = ParamUtil.getString(resourceRequest, "firstAppRefreshToken");
        String firstAppWorkSheetName = ParamUtil.getString(resourceRequest, "firstAppWorkSheetName");

        String secondAppSpreadSheetId = ParamUtil.getString(resourceRequest, "secondAppSpreadSheetId");
        String secondAppRefreshToken = ParamUtil.getString(resourceRequest, "secondAppRefreshToken");
        String secondAppWorkSheetName = ParamUtil.getString(resourceRequest, "secondAppWorkSheetName");

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String firstAppUrl = "https://sheets.googleapis.com/v4/spreadsheets/" + firstAppSpreadSheetId + "/values/" + firstAppWorkSheetName + "!A1:Z";
        String secondAppUrl = "https://sheets.googleapis.com/v4/spreadsheets/" + secondAppSpreadSheetId + "/values/" + secondAppWorkSheetName + "!A1:Z";
        if (Validator.isNotNull(firstAppRefreshToken) && Validator.isNotNull(secondAppRefreshToken)) {
            try {
                String firstAppAccessToken = APIUtil.getAccessToken(themeDisplay, firstAppRefreshToken);
                String secondAppAccessToken= APIUtil.getAccessToken(themeDisplay, secondAppRefreshToken);
                HttpResponse<String> firstAppResponse = APIUtil.getMethod(firstAppUrl, firstAppAccessToken);
                HttpResponse<String> secondAppResponse = APIUtil.getMethod(secondAppUrl, secondAppAccessToken);
                JSONObject jsonObject = _jsonFactory.createJSONObject();
                jsonObject.put("firstAppLastJsonObject", JsonUtil.getLastJsonObject(JsonUtil.getSheetData(firstAppResponse.getBody())).toString());
                jsonObject.put("firstAppJsonObjectKeys", JsonUtil.getJsonObjectKey(firstAppResponse.getBody()).toString());
                jsonObject.put("secondAppJsonObjectKeys", JsonUtil.getJsonObjectKey(secondAppResponse.getBody()).toString());
                JSONPortletResponseUtil.writeJSON(
                        resourceRequest, resourceResponse, jsonObject);
            } catch (UnirestException e) {
                if (_log.isDebugEnabled()) {
                    _log.debug(e);
                }
            }
        }
    }

    private static final Log _log = LogFactoryUtil.getLog(AppWorkSheetDataMVCResourceCommand.class);
    @Reference
    private JSONFactory _jsonFactory;
}