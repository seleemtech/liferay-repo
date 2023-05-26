package com.student.info.sys.action;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.student.info.service.service.CourseLocalServiceUtil;
import com.student.info.sys.constants.StudentInfoSysPortletKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = { "javax.portlet.name=" + StudentInfoSysPortletKeys.STUDENTINFOSYS,
		"mvc.command.name=/getSubjects" }, service = MVCResourceCommand.class)
public class GetSubjectMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		// TODO Auto-generated method stub
		long courseId = ParamUtil.getLong(resourceRequest, "courseId");
		DynamicQuery dynamicQuery = CourseLocalServiceUtil.dynamicQuery();

		dynamicQuery.add(RestrictionsFactoryUtil.eq("courseId", courseId));
		Projection projection = ProjectionFactoryUtil.property("subject");
		dynamicQuery.setProjection(projection);
		List<String> subjects = CourseLocalServiceUtil.dynamicQuery(dynamicQuery);
		System.out.println("ss" + subjects.get(0));
		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		jsonResponse.put("studentName", subjects.get(0));
		try {
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			resourceResponse.setCharacterEncoding("UTF-8");
			resourceResponse.getWriter().write(jsonResponse.toString());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	/*
	 * @Override protected void doServeResource(ResourceRequest resourceRequest,
	 * ResourceResponse resourceResponse) throws Exception { // TODO Auto-generated
	 * method stub System.out.println("Came here for getting subject "); long
	 * courseId = ParamUtil.getLong(resourceRequest, "courseId");
	 * System.out.println("CourseId is coming" + courseId);
	 * 
	 * try { JSONPortletResponseUtil.writeJSON( resourceRequest, resourceResponse,
	 * _getJSONObject(courseId)); } catch (Exception e) { // TODO: handle exception
	 * }
	 * 
	 * 
	 * }
	 * 
	 * private JSONObject _getJSONObject(long courseId) {
	 * 
	 * DynamicQuery dynamicQuery = CourseLocalServiceUtil.dynamicQuery();
	 * 
	 * dynamicQuery.add(RestrictionsFactoryUtil.eq("courseId", courseId));
	 * Projection projection = ProjectionFactoryUtil.property("subject");
	 * dynamicQuery.setProjection(projection); List<String> subjects =
	 * CourseLocalServiceUtil.dynamicQuery(dynamicQuery);
	 * System.out.println("ss"+subjects.get(0)); return JSONUtil.put("subjectName",
	 * subjects.get(0)
	 * 
	 * ); }
	 * 
	 * @Reference private Portal _portal;
	 * 
	 * @Reference private JSONFactory _jsonFactory;
	 */
}
