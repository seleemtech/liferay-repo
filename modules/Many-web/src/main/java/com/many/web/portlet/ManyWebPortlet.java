package com.many.web.portlet;

import com.many.model.Course;
import com.many.model.Student;
import com.many.service.CourseLocalService;
import com.many.service.CourseLocalServiceUtil;
import com.many.service.StudentLocalService;
import com.many.service.StudentLocalServiceUtil;
import com.many.web.constants.ManyWebPortletKeys;

import java.io.IOException;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author DELL
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ManyWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view_pop.jsp",
		"javax.portlet.name=" + ManyWebPortletKeys.MANYWEB,
		"javax.portlet.resource-bundle=content.Language",
		 "com.liferay.portlet.footer-portlet-javascript=/main.js?a=5",
		"javax.portlet.security-role-ref=power-user,user"
		
	},
	service = Portlet.class
)
public class ManyWebPortlet extends MVCPortlet {
	@Override
		public void render(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			// TODO Auto-generated method stub
		
		super.render(renderRequest, renderResponse);
		}
	
	public void addStudent(ActionRequest actionRequest,ActionResponse actionResponse) {
		String studentName=ParamUtil.getString(actionRequest, "studentName");
		String studentPlace=ParamUtil.getString(actionRequest, "studentPlace");
		String studentCollege=ParamUtil.getString(actionRequest, "studentCollege");
		 
		Student stud=studentLocalService.createStudent(counterLocalService.increment());
		stud.setStudentName(studentName);
		stud.setStudentPlace(studentPlace);
		stud.setStudentCollege(studentCollege);
//		stud.setCompanyId(serviceContext.getCompanyId());
//		stud.setGroupId(serviceContext.getScopeGroupId());
		studentLocalService.updateStudent(stud);
		Course cor=courseLocalService.createCourse(counterLocalService.increment());
		cor.setCourseName(studentName);
		cor.setCourseGroup(studentPlace);
		courseLocalService.updateCourse(cor);
		studentLocalService.addCourseStudent(stud.getStudentId(), cor.getCourseId());
		
	}
	
	
	@Reference 
	private StudentLocalService  studentLocalService;
	
	
	@Reference 
	private CourseLocalService  courseLocalService;
	
	@Reference 
	private CounterLocalService counterLocalService;
}