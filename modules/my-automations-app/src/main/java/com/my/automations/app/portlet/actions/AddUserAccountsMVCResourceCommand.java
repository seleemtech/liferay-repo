package com.my.automations.app.portlet.actions;

import api.master.slayer.model.ConnectedAccounts;
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
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
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
import com.my.automations.app.constants.MyAutomationsAppPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Date;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + MyAutomationsAppPortletKeys.MYAUTOMATIONSAPP,
                "mvc.command.name=add/user/accounts"
        },
        service = MVCResourceCommand.class
)
public class AddUserAccountsMVCResourceCommand extends BaseMVCResourceCommand {
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String SCOPE = DriveScopes.DRIVE;

    private static final String USERDETAILSURL = "https://www.googleapis.com/drive/v3/about?fields=user(displayName,emailAddress)";

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        String accessCode = ParamUtil.getString(resourceRequest, "accessCode");
        String appName = "Google Sheet";
        System.out.println("appName::::" + ParamUtil.getString(resourceRequest, "appName"));
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Layout layout = themeDisplay.getLayout();
        System.out.println("layout url" + layout.getFriendlyURL());
        if (Validator.isNotNull(accessCode)) {
            try {
                GoogleConfigurationSection googleConfigurationSection = ConfigurationProviderUtil
                        .getGroupConfiguration(GoogleConfigurationSection.class, themeDisplay.getScopeGroupId());
                Credential credential = getAccessTokenResponse(googleConfigurationSection, accessCode);
                if (null != credential.getRefreshToken()) {
                    HttpResponse<String> userDetailsResponse = getMethod(USERDETAILSURL, credential.getAccessToken());
                    if (userDetailsResponse.getCode() == 200) {
                        String emailAddress = JsonUtil.getUserEmailAddressFromJson(userDetailsResponse.getBody().toString());
                        boolean accountFound = updateAccounts(emailAddress, appName, credential.getRefreshToken());
                        if (!accountFound) {
                            addAccounts(themeDisplay, credential.getRefreshToken(), emailAddress, appName);
                        }
                    }
                }
                JSONObject jsonObject = _jsonFactory.createJSONObject();
                jsonObject.put("redirectUrl", themeDisplay.getPortalURL() + layout.getFriendlyURL());
                JSONPortletResponseUtil.writeJSON(
                        resourceRequest, resourceResponse, jsonObject);
            } catch (ConfigurationException | UnirestException | GeneralSecurityException e) {
                if (_log.isDebugEnabled()) {
                    _log.debug(e);
                }
            }
        }
    }

    private boolean updateAccounts(String emailAddress, String appName, String refreshToken) {
        ConnectedAccounts connectedAccounts = _connectedAccountsLocalService.getAccountByEmailAndAppName(appName, emailAddress);
        boolean accountFound = false;
        if (null != connectedAccounts) {
            connectedAccounts.setRefreshToken(refreshToken);
            connectedAccounts.setCreateDate(new Date());
            _connectedAccountsLocalService.updateConnectedAccounts(connectedAccounts);
            accountFound = true;
        }
        return accountFound;
    }

    private void addAccounts(ThemeDisplay themeDisplay, String refreshToken, String emailAddress, String appName) {
        ConnectedAccounts connectedAccounts = _connectedAccountsLocalService.createConnectedAccounts(_counterLocalService.increment());
        connectedAccounts.setAppName(appName);
        connectedAccounts.setEmailAddress(emailAddress);
        connectedAccounts.setRefreshToken(refreshToken);
        connectedAccounts.setUserId(themeDisplay.getUserId());
        connectedAccounts.setCompanyId(themeDisplay.getCompanyId());
        connectedAccounts.setCreateDate(new Date());
        _connectedAccountsLocalService.addConnectedAccounts(connectedAccounts);
    }

    public static HttpResponse<String> getMethod(String url, String accessToken) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        return Unirest.get(url)
                .header("Authorization", "Bearer " + accessToken)
                .asString();
    }

    private static Credential getAccessTokenResponse(GoogleConfigurationSection googleConfigurationSection,
                                                     String accessCode) throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        AuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
                googleConfigurationSection.clientId(), googleConfigurationSection.clientKey(), Arrays.asList(SCOPE))
                .setAccessType("offline").build();
        GoogleAuthorizationCodeTokenRequest tokenRequest = (GoogleAuthorizationCodeTokenRequest) flow
                .newTokenRequest(accessCode);
        tokenRequest.setRedirectUri(googleConfigurationSection.getThirdRedirectUrl());
        TokenResponse tokenResponse = tokenRequest.execute();

        return flow.createAndStoreCredential(tokenResponse, null);
    }


    private static final Log _log = LogFactoryUtil.getLog(AddUserAccountsMVCResourceCommand.class);
    @Reference
    private JSONFactory _jsonFactory;

    @Reference
    private ConnectedAccountsLocalService _connectedAccountsLocalService;
    @Reference
    private CounterLocalService _counterLocalService;
}