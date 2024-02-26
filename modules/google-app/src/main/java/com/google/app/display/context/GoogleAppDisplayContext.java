package com.google.app.display.context;

import api.master.slayer.model.ConnectedAccounts;
import api.master.slayer.service.ConnectedAccountsLocalServiceUtil;
import com.google.app.step.CustomStepModel;
import com.liferay.connected.app.ConnectedApp;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GoogleAppDisplayContext {
    public GoogleAppDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {
        _renderRequest = renderRequest;
        _renderResponse = renderResponse;
    }


    public List<CustomStepModel> getMultiSteps(String firstAppName, String secondAppName) {
        List<CustomStepModel> steps = new ArrayList<>();
        steps.add(createStepModel("1", "firstConnection", firstAppName));
        steps.add(createStepModel("2", "secondConnection", secondAppName));
        steps.add(createStepModel("3", "thirdConnection", "Customize & Live"));
        return steps;
    }

    public List<ConnectedAccounts> getAccountsByUserId(long userId,String firstAppName) {
        List<ConnectedAccounts> accounts = ConnectedAccountsLocalServiceUtil.getAccountsByUserId(userId);
        return accounts.stream().filter(account -> firstAppName.equalsIgnoreCase(account.getAppName())).collect(Collectors.toList());
    }

    private CustomStepModel createStepModel(String index, String pageName, String appName) {
        CustomStepModel step = new CustomStepModel();
        step.setIndex(index);
        step.setPageName(pageName);
        step.setAppName(appName);
        return step;
    }

    public Map<String, List<String>> getIntegratyKeys(List<String> linkedInKeyList, List<String> zohoKeyList) {
        Map<String, List<String>> integrityKeys = new HashMap<>();
        linkedInKeyList.stream().forEach(linkedInKey -> integrityKeys.put(linkedInKey, zohoKeyList));
        return integrityKeys;
    }

    public List<String> getLinkedInKey(String jsonString) throws JSONException {
        JSONObject jsonObject = getLastJsonObject(jsonString);
        List<String> keyList = getKeyList(jsonObject);
        return keyList;
    }

    public List<String> getZohoKeys(String jsonString) throws JSONException {
        JSONObject jsonObject = getLastJsonObject(jsonString);
        List<String> keyList = getKeyList(jsonObject);
        return keyList;
    }

    public Map<String, String> getZohoKeyValues(String jsonString) throws JSONException {
        JSONObject jsonObject = getLastJsonObject(jsonString);
        Map<String, String> keyValues = getKeyValues(jsonObject);
        return keyValues;
    }


    private JSONObject getLastJsonObject(String jsonString) throws JSONException {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
        return jsonArray.getJSONObject(jsonArray.length() - 1);
    }

    private List<String> getKeyList(JSONObject jsonObject) {
        List<String> keyLists = new ArrayList<>();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            keyLists.add(key);
        }
        return keyLists;
    }


    private Map<String, String> getKeyValues(JSONObject jsonObject) throws JSONException {
        Iterator<String> keys = jsonObject.keys();
        Map<String, String> keyValues = new HashMap<>();
        while (keys.hasNext()) {
            String key = keys.next();
            String value = jsonObject.getString(key);
            keyValues.put(key, value);
        }
        return keyValues;
    }

    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
}
