package com.student.info.sys.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.student.info.service.model.Parent;
import com.student.info.service.model.Student;
import com.student.info.service.model.Teacher;
import com.student.info.service.service.ParentLocalServiceUtil;
import com.student.info.service.service.StudentLocalServiceUtil;
import com.student.info.service.service.TeacherLocalServiceUtil;
import com.student.info.sys.constants.StudentInfoSysPortletKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + StudentInfoSysPortletKeys.STUDENTINFOSYS,
		"mvc.command.name=/addStudentParent" }, service = MVCActionCommand.class)
public class AddStudentParent extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		long studentId = CounterLocalServiceUtil.increment();
		long parentId = CounterLocalServiceUtil.increment();
		String studentName = ParamUtil.getString(actionRequest, "studentName");
		String studentPlace = ParamUtil.getString(actionRequest, "studentPlace");
		String studentEmail = ParamUtil.getString(actionRequest, "studentEmail");
		String parentName = ParamUtil.getString(actionRequest, "parentName");
		long parentContact = ParamUtil.getLong(actionRequest, "parentContact");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();
		long courseId = ParamUtil.getLong(actionRequest, "courseId");
		// now read your parameters, e.g. like this:
		// long someParameter = ParamUtil.getLong(request, "someParameter");

		Student std = StudentLocalServiceUtil.addStudent(studentId, studentName, studentPlace, studentEmail, companyId);
		Parent parent = ParentLocalServiceUtil.addParent(parentId, parentName, parentContact, companyId);
		if (Validator.isNotNull(parent)) {
			List<Teacher> teacher = TeacherLocalServiceUtil.getCourseTeachers(courseId);
			for (Teacher teacher2 : teacher) {
				StudentLocalServiceUtil.addTeacherStudent(teacher2.getTeacherId(), std.getStudentId());
			}
			StudentLocalServiceUtil.addCourseStudent(courseId, std.getStudentId());
			StudentLocalServiceUtil.addParentStudent(parent.getParentId(), std.getStudentId());
		}

	}

}
