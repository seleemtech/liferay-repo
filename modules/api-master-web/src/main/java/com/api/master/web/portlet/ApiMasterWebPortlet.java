package com.api.master.web.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.api.master.web.constants.ApiMasterWebPortletKeys;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import api.master.slayer.model.MasterUrl;
import api.master.slayer.service.MasterUrlLocalServiceUtil;

/**
 * @author Vinoth-kumar
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ApiMasterWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ApiMasterWebPortletKeys.APIMASTERWEB, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"}, service = Portlet.class)
public class ApiMasterWebPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<MasterUrl> masterUrls = MasterUrlLocalServiceUtil.getMasterUrls(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("MasterUrlList", masterUrls);
		super.doView(renderRequest, renderResponse);
	}
	private static final Log logger = LogFactoryUtil.getLog(ApiMasterWebPortlet.class);
}