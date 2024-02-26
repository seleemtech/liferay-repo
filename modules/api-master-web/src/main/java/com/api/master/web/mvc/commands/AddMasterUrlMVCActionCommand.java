package com.api.master.web.mvc.commands;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.api.master.web.constants.ApiMasterWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import api.master.slayer.model.MasterUrl;
import api.master.slayer.service.MasterUrlLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + ApiMasterWebPortletKeys.APIMASTERWEB,
	        "mvc.command.name=/add/masterapplication"
	    },
	    service = MVCActionCommand.class
	)

public class AddMasterUrlMVCActionCommand implements MVCActionCommand {
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String appName = ParamUtil.getString(actionRequest, "appName");
		String baseUrl = ParamUtil.getString(actionRequest, "baseUrl");
		String svgIcon = ParamUtil.getString(actionRequest, "svgIcon");
		MasterUrl masterUrl = MasterUrlLocalServiceUtil.createMasterUrl(0);
		masterUrl.setAppName(appName);
		masterUrl.setBaseUrl(baseUrl);
		masterUrl.setSvgIcon(svgIcon);
		MasterUrlLocalServiceUtil.addMasterUrl(masterUrl);
		logger.info("Added Base URL::: "+masterUrl);
		return false;
	}
	private static final Log logger = LogFactoryUtil.getLog(AddMasterUrlMVCActionCommand.class);
}
