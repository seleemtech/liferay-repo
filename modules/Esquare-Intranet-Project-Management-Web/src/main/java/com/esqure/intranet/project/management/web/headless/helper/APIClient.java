package com.esqure.intranet.project.management.web.headless.helper;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIClient {
    public static Map<Long, Integer> apiGet(String apiURL, ThemeDisplay themeDisplay) {
        Map<Long, Integer> projectStatusList = new HashMap<>();
        try {
            String apiUrl = "/o/esquare/intranet/project/headless/v1.0/projects-management";
            String apiEndpoint = themeDisplay.getPortalURL() + apiUrl; // Replace with your actual base URL
            System.out.println("apiEndpoint" + apiEndpoint);
            String email = "admin@esquare.com";
            String password = "test";
            String authCredentials = email + ":" + password;
            String encodedCredentials = Base64.getEncoder().encodeToString(authCredentials.getBytes());
            URL url = new URL(apiEndpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                JSONObject responseJson = JSONFactoryUtil.createJSONObject(content.toString());
                JSONArray items = JSONFactoryUtil.createJSONArray(responseJson.getString("items"));
                for (int i = 0; i < items.length(); i++) {
                    JSONObject project = items.getJSONObject(i);
                    long projectId = project.getLong("id");
                    JSONObject statusObject = project.getJSONObject("status");

                    int statusCode = statusObject.getInt("code");
                    projectStatusList.put(projectId,statusCode);
                }
            } else {
                System.out.println("API request failed. Response Code: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("API request failed. Response Code: " + projectStatusList);
        return projectStatusList;
    }
}
