package com.job.opening.action;

import com.job.opening.constants.JobOpeningPortletKeys;
import com.job.opening.service.model.Jobinfo;
import com.job.opening.service.service.AddressinfoLocalServiceUtil;
import com.job.opening.service.service.DescriptiveinfoLocalServiceUtil;
import com.job.opening.service.service.JobinfoLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(property = { "javax.portlet.name=" + JobOpeningPortletKeys.JOBOPENING,
		"mvc.command.name=createorupdateJob" }, service = MVCActionCommand.class)
public class MvcActionCommand extends BaseMVCActionCommand {

	Log log = LogFactoryUtil.getLog(MvcActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();
		long userId = themeDisplay.getUserId();
		User user = themeDisplay.getUser();
		String userName = user.getFullName();
		long jobId = ParamUtil.getLong(actionRequest, "jobId");
		String postingTitle = ParamUtil.getString(actionRequest, "postingTitle");
		String title = ParamUtil.getString(actionRequest, "title");
		String assignedRecruiter = ParamUtil.getString(actionRequest, "assignedRecruiter");
		String clientName = ParamUtil.getString(actionRequest, "clientName");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date targetDate = ParamUtil.getDate(actionRequest, "targetDate", df);
		Date dateOpened = ParamUtil.getDate(actionRequest, "dateOpened", df);
		String jobopeningStatus = ParamUtil.getString(actionRequest, "jobopeningStatus");
		String industry = ParamUtil.getString(actionRequest, "industry");
		String jobResource = ParamUtil.getString(actionRequest, "jobResource");
		String hiringManager = ParamUtil.getString(actionRequest, "hiringManager");
		String positions = ParamUtil.getString(actionRequest, "positions");
		String jobType = ParamUtil.getString(actionRequest, "jobType");
		String workExperience = ParamUtil.getString(actionRequest, "workExperience");
		String skillSet = ParamUtil.getString(actionRequest, "skillSet");
		String projectStatus = ParamUtil.getString(actionRequest, "projectStatus");
		String jobsummaryvalue = ParamUtil.getString(actionRequest, "jobSummary");
		log.info("jobsummaryvalue>>>>>>> " + jobsummaryvalue);
		String otvalue = ParamUtil.getString(actionRequest, "others");
		log.info("otvalue>>>>>>> " + otvalue);

		String city = ParamUtil.getString(actionRequest, "city");
		String country = ParamUtil.getString(actionRequest, "country");
		String state = ParamUtil.getString(actionRequest, "state");
		long postalCode = ParamUtil.getLong(actionRequest, "postalCode");

		String origionaljobDescription = ParamUtil.getString(actionRequest, "jobDescription");
		String jobDescription = origionaljobDescription.replace("<p>", "").replace("</p>", "");
		String origionalrequirements = ParamUtil.getString(actionRequest, "requirements");
		String requirements = origionalrequirements.replace("<p>", "").replace("</p>", "");
		String origionalbenefits = ParamUtil.getString(actionRequest, "benefits");
		String benefits = origionalbenefits.replace("<p>", "").replace("</p>", "");
		if (jobId > 0) {
			try {
				log.info("Inside Update Method ");
				long summaryId = Uploadfile.uploadfileIntoMemeberFolder(postingTitle, jobsummaryvalue, actionRequest);
				long otherId = Uploadfile.uploadfileIntoMemeberFolder(postingTitle, otvalue, actionRequest);
				Jobinfo job = JobinfoLocalServiceUtil.updateJob(groupId, companyId, userId, userName, jobId,
						postingTitle, title, assignedRecruiter, clientName, targetDate, jobopeningStatus, industry,
						jobResource, hiringManager, positions, dateOpened, jobType, workExperience, skillSet,
						projectStatus, summaryId, otherId);
				long jobId1 = job.getJobId();
				AddressinfoLocalServiceUtil.updateAddress(city, country, state, postalCode, jobId1);
				DescriptiveinfoLocalServiceUtil.updateDescription(jobDescription, requirements, benefits, jobId1);
				SessionMessages.add(actionRequest, "entryUpdated");
			} catch (Exception e) {
				log.info(e);
			}
		}

		else {
			try {
				log.info("Inside create Method ");
				long summaryId = Uploadfile.uploadfileIntoMemeberFolder(postingTitle, "jobsummary", actionRequest);
				long otherId = Uploadfile.uploadfileIntoMemeberFolder(postingTitle, "others", actionRequest);
				Jobinfo job = JobinfoLocalServiceUtil.createJob(groupId, companyId, userId, userName, postingTitle,
						title, assignedRecruiter, clientName, targetDate, jobopeningStatus, industry, jobResource,
						hiringManager, positions, dateOpened, jobType, workExperience, skillSet, projectStatus,
						summaryId, otherId);

				long jobId1 = job.getJobId();

				AddressinfoLocalServiceUtil.createAddress(city, country, state, postalCode, jobId1);

				DescriptiveinfoLocalServiceUtil.createDescription(jobDescription, requirements, benefits, jobId1);

				SessionMessages.add(actionRequest, "entryAdded");
			} catch (Exception e) {
				log.info(e);
			}
		}
	}

}
