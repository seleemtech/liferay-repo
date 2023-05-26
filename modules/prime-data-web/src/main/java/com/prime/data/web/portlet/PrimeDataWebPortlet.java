package com.prime.data.web.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletMode;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Base64;
import com.prime.data.service.service.MainTableLocalServiceUtil;
import com.prime.data.web.constants.PrimeDataWebPortletKeys;
import com.prime.data.web.util.PrimeDataUtil;

/**
 * @author Vinoth-kumar
 */

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PrimeDataWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PrimeDataWebPortletKeys.PRIMEDATAWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class

)
public class PrimeDataWebPortlet extends MVCPortlet {

public void addCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addCategory(actionRequest);
}
public void addJobType(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addJobType(actionRequest);
}
public void addJobOpeningStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addJobOpeningStatus(actionRequest);
}
public void addProjectStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addProjectStatus(actionRequest);
}
public void addIndustry(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addIndustry(actionRequest);
}
public void addSalaryRange(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addSalaryRange(actionRequest);
}
public void addWorkExperience(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addWorkExperience(actionRequest);
}
public void addSalesStage(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addSalesStage(actionRequest);
}
public void addNamePrefix(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addNamePrefix(actionRequest);
}
public void addHighQualHeld(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addHighQualHeld(actionRequest);
}
public void addCurrJobTitle(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addCurrJobTitle(actionRequest);
}
public void addSkillSet(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addSkillSet(actionRequest);
}
public void addCandidateStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addCandidateStatus(actionRequest);
}
public void addSource(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addSource(actionRequest);
}
public void addPriority(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addPriority(actionRequest);
}
public void addWorkType(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addWorkType(actionRequest);
}
public void addInterviewName(ActionRequest actionRequest, ActionResponse actionResponse) {
	PrimeDataUtil.addInterviewName(actionRequest);
}
}