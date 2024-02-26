package com.my.automations.app.display.context;

import api.master.slayer.constant.Constant;
import api.master.slayer.model.ApiMapKey;
import api.master.slayer.model.ConnectedAccounts;
import api.master.slayer.service.ApiMapKeyLocalServiceUtil;
import api.master.slayer.service.ConnectedAccountsLocalServiceUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

public class MyAutomationDisplayContext {
    public MyAutomationDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {
        _renderRequest = renderRequest;
        _renderResponse = renderResponse;

    }

    public List<ConnectedAccounts> getAccountsByUserId(long userId) {
        List<ConnectedAccounts> accounts = ConnectedAccountsLocalServiceUtil.getAccountsByUserId(userId);
        return accounts;
    }

    public boolean isIdPresent(long c_a_Id, long userId) {
        List<ApiMapKey> apiMapKeys = ApiMapKeyLocalServiceUtil.getApiMapKeysByUserId(userId);

        return apiMapKeys.stream()
                .map(ApiMapKey::getTypeSettings)
                .map(typeSettings -> {
                    UnicodeProperties unicodeProperties = new UnicodeProperties();
                    unicodeProperties.fastLoad((String) typeSettings);
                    return unicodeProperties;
                })
                .anyMatch(typeSetting -> {
                    long secondAppC_a_Id = Long.parseLong(typeSetting.getProperty(Constant.SECOND_APP_C_A_ID, "0"));
                    long firstAppC_a_Id = Long.parseLong(typeSetting.getProperty(Constant.FIRST_APP_C_A_ID, "0"));

                    return secondAppC_a_Id == c_a_Id || firstAppC_a_Id == c_a_Id;
                });
    }

    public long countIdsPresent(long c_a_Id, long userId) {
        List<ApiMapKey> apiMapKeys = ApiMapKeyLocalServiceUtil.getApiMapKeysByUserId(userId);

        return apiMapKeys.stream()
                .map(ApiMapKey::getTypeSettings)
                .map(typeSettings -> {
                    UnicodeProperties unicodeProperties = new UnicodeProperties();
                    unicodeProperties.fastLoad((String) typeSettings);
                    return unicodeProperties;
                })
                .filter(typeSetting -> {
                    long secondAppC_a_Id = Long.parseLong(typeSetting.getProperty(Constant.SECOND_APP_C_A_ID, "0"));
                    long firstAppC_a_Id = Long.parseLong(typeSetting.getProperty(Constant.FIRST_APP_C_A_ID, "0"));

                    return secondAppC_a_Id == c_a_Id || firstAppC_a_Id == c_a_Id;
                })
                .count();
    }


    private RenderRequest _renderRequest;
    private RenderResponse _renderResponse;
}
