package com.my.automations.app.portlet.actions;

import api.master.slayer.service.ConnectedAccountsLocalService;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;
import com.google.app.configuration.section.GoogleConfigurationSection;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.exception.PortalException;
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
                "mvc.command.name=revoke/accounts"
        },
        service = MVCResourceCommand.class
)
public class RevokeAccountsMVCResourceCommand extends BaseMVCResourceCommand {

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
        String accountId = ParamUtil.getString(resourceRequest, "accountId");
        System.out.println("accountId" + accountId);
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        JSONObject jsonObject = _jsonFactory.createJSONObject();
        Layout layout = themeDisplay.getLayout();
        System.out.println("layout url" + layout.getFriendlyURL());
        boolean isRemoved = removeConnectedAccounts(Long.parseLong(accountId));
        if (isRemoved) {
            jsonObject.put("message", "Account Deleted Successfully");
        }

        jsonObject.put("URL", themeDisplay.getPortalURL() + layout.getFriendlyURL());
        JSONPortletResponseUtil.writeJSON(
                resourceRequest, resourceResponse, jsonObject);
    }

    private boolean removeConnectedAccounts(long accountId) {
        try {
            _connectedAccountsLocalService.deleteConnectedAccounts(accountId);
            return true;
        } catch (PortalException e) {
            _log.debug(e);
            return false;
        }
    }


    private static final Log _log = LogFactoryUtil.getLog(RevokeAccountsMVCResourceCommand.class);
    @Reference
    private JSONFactory _jsonFactory;
    @Reference
    private ConnectedAccountsLocalService _connectedAccountsLocalService;
}