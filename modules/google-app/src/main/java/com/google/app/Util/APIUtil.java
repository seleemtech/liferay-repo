package com.google.app.Util;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleRefreshTokenRequest;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;
import com.google.app.configuration.section.GoogleConfigurationSection;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class APIUtil {
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String SCOPE = DriveScopes.DRIVE;

    public static HttpResponse<String> getMethod(String url, String accessToken) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        return Unirest.get(url)
                .header("Authorization", "Bearer " + accessToken)
                .asString();
    }

    public static String Test() {
        return "testing api package";
    }

    public static HttpResponse<String> postMethod(String url, String accessToken, String bodyData) throws UnirestException {
        Unirest.setTimeouts(0, 0);
        return Unirest.post(url)
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .body(bodyData)
                .asString();
    }

    public static Credential getAccessTokenResponse(GoogleConfigurationSection googleConfigurationSection,
                                                    String accessCode) throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        AuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
                googleConfigurationSection.clientId(), googleConfigurationSection.clientKey(), Arrays.asList(SCOPE))
                .setAccessType("offline").build();
        GoogleAuthorizationCodeTokenRequest tokenRequest = (GoogleAuthorizationCodeTokenRequest) flow
                .newTokenRequest(accessCode);
        tokenRequest.setRedirectUri(googleConfigurationSection.getRedirectUrl());
        TokenResponse tokenResponse = tokenRequest.execute();
        return flow.createAndStoreCredential(tokenResponse, null);
    }

    public static String getAccessToken(ThemeDisplay themeDisplay, String refreshToken)
            throws IOException, ConfigurationException, GeneralSecurityException, UnirestException {

        // Create a new GoogleRefreshTokenRequest with the client ID, client secret, and refresh token
        GoogleConfigurationSection googleConfigurationSection = ConfigurationProviderUtil
                .getGroupConfiguration(GoogleConfigurationSection.class, themeDisplay.getScopeGroupId());

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        GoogleRefreshTokenRequest refreshTokenRequest = new GoogleRefreshTokenRequest(
                HTTP_TRANSPORT,
                JSON_FACTORY,
                refreshToken,
                googleConfigurationSection.clientId(),
                googleConfigurationSection.clientKey()
        );


        TokenResponse tokenResponse = refreshTokenRequest.execute();

        return tokenResponse.getAccessToken();
    }

    public static String getAccessTokenByGroupId(long groupId, String refreshToken)
            throws IOException, ConfigurationException, GeneralSecurityException, UnirestException {

        // Create a new GoogleRefreshTokenRequest with the client ID, client secret, and refresh token
        GoogleConfigurationSection googleConfigurationSection = ConfigurationProviderUtil
                .getGroupConfiguration(GoogleConfigurationSection.class, groupId);

        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        GoogleRefreshTokenRequest refreshTokenRequest = new GoogleRefreshTokenRequest(
                HTTP_TRANSPORT,
                JSON_FACTORY,
                refreshToken,
                googleConfigurationSection.clientId(),
                googleConfigurationSection.clientKey()
        );


        TokenResponse tokenResponse = refreshTokenRequest.execute();

        return tokenResponse.getAccessToken();
    }



}
