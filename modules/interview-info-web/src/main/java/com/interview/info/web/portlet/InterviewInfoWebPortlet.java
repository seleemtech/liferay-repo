package com.interview.info.web.portlet;

import java.io.File;
import java.text.ParseException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.interview.info.web.constants.InterviewInfoWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author E2Software-011
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=InterviewInfoWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + InterviewInfoWebPortletKeys.INTERVIEWINFOWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class InterviewInfoWebPortlet extends MVCPortlet {
	private static final Log logger = LogFactoryUtil.getLog(InterviewInfoWebPortlet.class);
	public void addInterview(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException {
		ThemeDisplay themeDisplay= (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String interviewName = ParamUtil.getString(actionRequest, "interviewName");
		long clientName = ParamUtil.getLong(actionRequest, "clientName");
		String fromTime = ParamUtil.getString(actionRequest, "fromTime");
		String[] interviewers = ParamUtil.getStringValues(actionRequest, "interviewers");
		String location = ParamUtil.getString(actionRequest, "location");
		long candidateName = ParamUtil.getLong(actionRequest, "candidateName");
		long postingTitle = ParamUtil.getLong(actionRequest, "postingTitle");
		String toTime = ParamUtil.getString(actionRequest, "toTime");
		long interviewOwner = ParamUtil.getLong(actionRequest, "interviewOwner");
		String scheduleComments = ParamUtil.getString(actionRequest, "scheduleComments");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile("documentId");
		long convertedFrom;
		logger.info(interviewName);
	}
}