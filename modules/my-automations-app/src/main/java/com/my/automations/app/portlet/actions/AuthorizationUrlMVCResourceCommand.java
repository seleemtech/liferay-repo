package com.my.automations.app.portlet.actions;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;
import com.google.app.configuration.section.GoogleConfigurationSection;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
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

import com.my.automations.app.constants.MyAutomationsAppPortletKeys;
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
                "javax.portlet.name=" + MyAutomationsAppPortletKeys.MYAUTOMATIONSAPP,
                "mvc.command.name=get/authorization/url"
        },
        service = MVCResourceCommand.class
)
public class AuthorizationUrlMVCResourceCommand extends BaseMVCResourceCommand {
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String SCOPE = DriveScopes.DRIVE;

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        String appName = ParamUtil.getString(resourceRequest, "appName");
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        JSONObject jsonObject = _jsonFactory.createJSONObject();
        if (Validator.isNotNull(appName)) {
            String authorizationUrl = getAuthorizationUrl(themeDisplay, appName);
            jsonObject.put("url", authorizationUrl);
        }
        JSONPortletResponseUtil.writeJSON(
                resourceRequest, resourceResponse, jsonObject);
    }

    private static String getAuthorizationUrl(ThemeDisplay themeDisplay, String appName)
            throws IOException, ConfigurationException, GeneralSecurityException {
        GoogleConfigurationSection googleConfigurationSection = ConfigurationProviderUtil
                .getGroupConfiguration(GoogleConfigurationSection.class, themeDisplay.getScopeGroupId());
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

        //Based on the appName we need provide scope as of now I am using google sheet without checking condition.
        AuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
                googleConfigurationSection.clientId(), googleConfigurationSection.clientKey(), Arrays.asList(SCOPE))
                .setAccessType("offline").build();
        String url = flow.newAuthorizationUrl().setRedirectUri(googleConfigurationSection.getThirdRedirectUrl()).build()
                + "&login_hint=";
        _log.info("Opening the following URL from Browser:::" + url);
        return url;
    }


    private static final Log _log = LogFactoryUtil.getLog(AuthorizationUrlMVCResourceCommand.class);
    @Reference
    private JSONFactory _jsonFactory;
}