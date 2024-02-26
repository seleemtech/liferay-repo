package com.google.app.Util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.*;

public class JsonUtil {
    public static String getSheetData(String responseBody) throws JSONException {
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(responseBody);
        JSONArray valuesArray = jsonObject.getJSONArray("values");
        JSONArray keysArray = JSONFactoryUtil.createJSONArray();

        // Find the index of the first non-empty array, which might contain the keys
        int startIndex = -1;
        for (int i = 0; i < valuesArray.length(); i++) {
            JSONArray rowArray = valuesArray.getJSONArray(i);
            if (rowArray.length() > 0) {
                keysArray = rowArray;
                startIndex = i + 1; // Start iterating from the next array
                break;
            }
        }
        LinkedHashMap<String, String> rowMap = new LinkedHashMap<>();
        JSONArray resultArray = JSONFactoryUtil.createJSONArray();
        for (int i = startIndex; i < valuesArray.length(); i++) {
            JSONArray rowArray = valuesArray.getJSONArray(i);
            // Skip empty arrays
            if (rowArray.length() == 0) {
                continue;
            }

            JSONObject rowObject = JSONFactoryUtil.createJSONObject();
            for (int j = 0; j < rowArray.length(); j++) {
                String key = keysArray.getString(j);
                String value = rowArray.isNull(j) ? null : rowArray.getString(j);


                rowObject.put(key, value);
                rowMap.put(key, value);

            }
            resultArray.put(rowObject);
        }


        return resultArray.toString();
    }

    public static String getUserEmailAddressFromJson(String jsonObjectString) throws JSONException {
        String emailAddress = StringPool.BLANK;
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonObjectString);
        JSONObject userObject = JSONFactoryUtil.createJSONObject(jsonObject.getJSONObject("user").toString());

        if (null != userObject) {
            emailAddress = userObject.getString("emailAddress");
        }
        return emailAddress;
    }

    public static JSONObject getJsonObjectKey(String responseBody) throws JSONException {
        JSONObject keysObject = JSONFactoryUtil.createJSONObject();

        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(responseBody);
        JSONArray valuesArray = jsonObject.getJSONArray("values");

        int startIndex = -1;
        for (int i = 0; i < valuesArray.length(); i++) {
            JSONArray rowArray = valuesArray.getJSONArray(i);
            if (rowArray.length() > 0) {
                JSONArray keysArray = rowArray;
                startIndex = i + 1; // Start iterating from the next array
                // Extract keys from keysArray and add them to keysList
                for (int j = 0; j < keysArray.length(); j++) {
                    keysObject.put(keysArray.getString(j), "");
                }
                break;
            }
        }

        return keysObject;
    }

    public static List<String> getPostListKey(String responseBody) throws JSONException {
        List<String> keysList = new ArrayList<>();

        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(responseBody);
        JSONArray valuesArray = jsonObject.getJSONArray("values");

        int startIndex = -1;
        for (int i = 0; i < valuesArray.length(); i++) {
            JSONArray rowArray = valuesArray.getJSONArray(i);
            if (rowArray.length() > 0) {
                JSONArray keysArray = rowArray;
                startIndex = i + 1; // Start iterating from the next array
                // Extract keys from keysArray and add them to keysList
                for (int j = 0; j < keysArray.length(); j++) {
                    keysList.add(keysArray.getString(j));
                }
                break;
            }
        }

        return keysList;
    }

    public static String getSheetTestData(String responseBody) throws JSONException {
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject(responseBody);
        JSONArray valuesArray = jsonObject.getJSONArray("values");
        JSONArray keysArray = null;

        // Find the index of the first non-empty array, which might contain the keys
        int startIndex = -1;
        for (int i = 0; i < valuesArray.length(); i++) {
            JSONArray rowArray = valuesArray.getJSONArray(i);
            if (rowArray.length() > 0) {
                keysArray = rowArray;
                startIndex = i + 1; // Start iterating from the next array
                break;
            }
        }
        LinkedHashMap<String, String> rowMap = new LinkedHashMap<>();
        JSONArray resultArray = JSONFactoryUtil.createJSONArray();
        for (int i = startIndex; i < valuesArray.length(); i++) {
            JSONArray rowArray = valuesArray.getJSONArray(i);
            // Skip empty arrays
            if (rowArray.length() == 0) {
                continue;
            }

            JSONObject rowObject = JSONFactoryUtil.createJSONObject();
            for (int j = 0; j < rowArray.length(); j++) {
                String key = keysArray.getString(j);
                String value = rowArray.isNull(j) ? null : rowArray.getString(j);
                rowObject.put(key, value);
                rowMap.put(key, value);

            }
            resultArray.put(rowMap);
        }

        return resultArray.toString();
    }


    public static JSONObject getLastJsonObject(String jsonString) throws JSONException {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
        return jsonArray.getJSONObject(jsonArray.length() - 1);
    }

    public static JSONObject getJsonObjectKeys(String jsonString) throws JSONException {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        JSONObject keysObject = JSONFactoryUtil.createJSONObject();
        for (String key : jsonObject.keySet()) {
            keysObject.put(key, ""); // Add the key with an empty value
        }
        return keysObject;
    }


}
