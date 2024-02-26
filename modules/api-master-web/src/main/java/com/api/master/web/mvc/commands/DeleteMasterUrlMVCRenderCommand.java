package com.api.master.web.mvc.commands;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.api.master.web.constants.ApiMasterWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import api.master.slayer.service.MasterUrlLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + ApiMasterWebPortletKeys.APIMASTERWEB,
	    		"mvc.command.name=/delete/masterapplication"
	    },
	    service = MVCRenderCommand.class
	)
public class DeleteMasterUrlMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long masterUrlId = ParamUtil.getLong(renderRequest, "masterUrlId");
		try {
			MasterUrlLocalServiceUtil.deleteMasterUrl(masterUrlId);
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	private static final Log logger = LogFactoryUtil.getLog(DeleteMasterUrlMVCRenderCommand.class);
}
