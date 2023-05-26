package com.student.info.sys.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.student.info.service.model.Course;
import com.student.info.service.model.Student;
import com.student.info.service.model.Teacher;
import com.student.info.service.service.CourseLocalServiceUtil;
import com.student.info.service.service.StudentLocalServiceUtil;
import com.student.info.service.service.TeacherLocalServiceUtil;
import com.student.info.sys.constants.StudentInfoSysPortletKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
@Component(immediate = true, property = { "javax.portlet.name=" + StudentInfoSysPortletKeys.STUDENTINFOSYS,
"mvc.command.name=/updateStudent" }, service = MVCActionCommand.class)
public class UpdateStudent extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		String studentName = ParamUtil.getString(actionRequest, "studentName");
		String studentPlace = ParamUtil.getString(actionRequest, "studentPlace");
		String studentEmail = ParamUtil.getString(actionRequest, "studentEmail");
		long studentId=ParamUtil.getLong(actionRequest, "studentId");
		long courseId=ParamUtil.getLong(actionRequest, "courseId");
		Student student=StudentLocalServiceUtil.updateStudent(studentId, studentName, studentPlace, studentEmail);
		
		List<Course> course=CourseLocalServiceUtil.getStudentCourses(studentId);
		for (Course course2 : course) {
			if(courseId!=course2.getCourseId()) {
				StudentLocalServiceUtil.deleteCourseStudent(course2.getCourseId(), studentId);
				StudentLocalServiceUtil.addCourseStudent(courseId, studentId);
				List<Teacher> teachers=TeacherLocalServiceUtil.getCourseTeachers(course2.getCourseId());
				for (Teacher teachers1 : teachers) {
					StudentLocalServiceUtil.deleteTeacherStudent(teachers1.getTeacherId(), studentId);
					
				}
				List<Teacher> teacher=TeacherLocalServiceUtil.getCourseTeachers(courseId);
				for (Teacher Addteacher : teacher) {
					StudentLocalServiceUtil.addTeacherStudent(Addteacher.getTeacherId(), studentId);
					
				}
				System.out.println("Id is  same");
			}else {
				System.out.println("Id is not same");
			}
		}
	}

}
