package com.student.info.sys.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.student.info.service.model.Course;
import com.student.info.service.model.Teacher;
import com.student.info.service.service.CourseLocalServiceUtil;
import com.student.info.service.service.TeacherLocalServiceUtil;
import com.student.info.sys.constants.StudentInfoSysPortletKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + StudentInfoSysPortletKeys.STUDENTINFOSYS,
		"mvc.command.name=/addTeacher" }, service = MVCActionCommand.class)
public class AddTeacherCourse extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub

		long teacherId = ParamUtil.getLong(actionRequest, "teacherId");
		String teacherName = ParamUtil.getString(actionRequest, "teacherName");
		String teacherEmail = ParamUtil.getString(actionRequest, "teacherEmail");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long courseId = ParamUtil.getLong(actionRequest, "courseId");
		long companyId = themeDisplay.getCompanyId();
		Teacher teacher = null;
		if (teacherId > 0) {
			teacher = TeacherLocalServiceUtil.updateTeacher(teacherId, teacherName, teacherEmail);
			List<Course> couses = CourseLocalServiceUtil.getTeacherCourses(teacherId);
			for (Course course : couses) {
				if (courseId != course.getCourseId()) {
					TeacherLocalServiceUtil.deleteCourseTeacher(course.getCourseId(), teacherId);
					TeacherLocalServiceUtil.addCourseTeacher(courseId, teacher.getTeacherId());
				} else if (courseId == course.getCourseId()) {
					System.out.println(" equal to old courseId::::::");
				}
			}
			List<Teacher> teachsss = TeacherLocalServiceUtil.getTeachers(-1, -1);	
			couses.stream().filter(p -> p.getCourseId() == courseId)
					.forEach(p -> System.out.println("Some " + p.getCourseName()));

		} else {
			teacherId = CounterLocalServiceUtil.increment();
			teacher = TeacherLocalServiceUtil.addTeacher(teacherId, teacherName, teacherEmail, companyId);
			if (Validator.isNotNull(teacher)) {
				TeacherLocalServiceUtil.addCourseTeacher(courseId, teacher.getTeacherId());
			}
		}

	}

}
