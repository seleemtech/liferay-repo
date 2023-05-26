package com.student.info.sys.action;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.student.info.service.model.Course;
import com.student.info.service.service.CourseLocalServiceUtil;
import com.student.info.sys.constants.StudentInfoSysPortletKeys;

import java.net.URLEncoder;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + StudentInfoSysPortletKeys.STUDENTINFOSYS,
		"mvc.command.name=/addCourse" }, service = MVCActionCommand.class)
public class AddCourse extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
	
		String[] subjects = ParamUtil.getStringValues(actionRequest, "subject");
		long courseId = ParamUtil.getLong(actionRequest, "courseId");
		String courseName = ParamUtil.getString(actionRequest, "courseName");
		StringBuilder sb = new StringBuilder();

		for (String subject : subjects) {
			sb.append(URLEncoder.encode(subject, "UTF-8"));
			sb.append("&");
		}

		String encodedString = sb.toString();
		if (encodedString.endsWith("&")) {
			encodedString = encodedString.substring(0, encodedString.length() - 1);
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId();
		Course course =null;
		if (courseId > 0) {
			course=CourseLocalServiceUtil.UpdateCourse(courseId, courseName, encodedString);

		} else {

			courseId = CounterLocalServiceUtil.increment();

			 course = CourseLocalServiceUtil.addCourse(courseId, courseName, companyId, encodedString);
		}
	}

}
