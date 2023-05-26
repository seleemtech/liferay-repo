package com.job.opening.portlet;

import com.job.opening.constants.JobOpeningPortletKeys;
import com.job.opening.service.model.Addressinfo;
import com.job.opening.service.model.Descriptiveinfo;
import com.job.opening.service.model.Jobinfo;
import com.job.opening.service.service.AddressinfoLocalServiceUtil;
import com.job.opening.service.service.DescriptiveinfoLocalServiceUtil;
import com.job.opening.service.service.JobinfoLocalServiceUtil;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author param
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=JobOpening", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + JobOpeningPortletKeys.JOBOPENING,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class JobOpeningPortlet extends MVCPortlet {
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		

		List<Jobinfo> jobList = JobinfoLocalServiceUtil.getJobinfos(-1, -1);
		long jobId = ParamUtil.getLong(renderRequest, "jobId");
		renderRequest.setAttribute("jobId", jobId);
		if (jobId > 0) {
			Jobinfo job = null;

			try {
				job = JobinfoLocalServiceUtil.getJobinfo(jobId);
			} catch (PortalException e) { 
				e.printStackTrace();
			}

			renderRequest.setAttribute("job", job);
		}
		renderRequest.setAttribute("jobattribute", jobList);

		try {
			super.render(renderRequest, renderResponse);
		} catch (java.io.IOException e) { 
			e.printStackTrace();
		}

	}

	public void deletejob(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long jobId = ParamUtil.getLong(actionRequest, "jobId");
		try {
			System.out.println("from delete");
			Jobinfo job = JobinfoLocalServiceUtil.getJobinfo(jobId);

			// DLFileEntryLocalServiceUtil.deleteDLFileEntry(job.getSummaryId());
			// DLFileEntryLocalServiceUtil.deleteDLFileEntry(job.getOtherId());

			Addressinfo addressinfo = AddressinfoLocalServiceUtil.findByjobId(jobId);
			System.out.println(addressinfo);
			AddressinfoLocalServiceUtil.deleteAddressinfo(addressinfo.getAddressId());

			Descriptiveinfo descriptiveinfo = DescriptiveinfoLocalServiceUtil.findByjobId(jobId);
			System.out.println(descriptiveinfo);
			DescriptiveinfoLocalServiceUtil.deleteDescriptiveinfo(descriptiveinfo.getDescriptiveId());
			JobinfoLocalServiceUtil.deleteJobinfo(jobId);

			SessionMessages.add(actionRequest, "entryDeleted");
		} catch (Exception e) {
<<<<<<< Updated upstream
			e.printStackTrace();
=======
>>>>>>> Stashed changes
		}
	}
}