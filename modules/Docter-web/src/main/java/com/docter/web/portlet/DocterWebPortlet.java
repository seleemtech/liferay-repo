package com.docter.web.portlet;

import com.docter.service.model.Docters;
import com.docter.service.service.DoctersLocalService;
import com.docter.service.service.DoctersLocalServiceUtil;
import com.docter.web.constants.DocterWebPortletKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author DELL
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=DocterWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DocterWebPortletKeys.DocterPortletName,
		"javax.portlet.resource-bundle=content.Language", "com.liferay.portlet.add-default-resource=true",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DocterWebPortlet extends MVCPortlet {

	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Docters> crd = DoctersLocalServiceUtil.getDocterses(-1, -1);
		renderRequest.setAttribute("crd", crd);
		super.render(renderRequest, renderResponse);
	}

	public void editNewsEntry(ActionRequest actionRequest, ActionResponse actionResponse) {
		long docterId = ParamUtil.getLong(actionRequest, "docterId", 0l);
		String docterName = ParamUtil.getString(actionRequest, "docterName");
		ServiceContext serviceContext = new ServiceContext();

		try {
			serviceContext = ServiceContextFactory.getInstance(Docters.class.getName(), actionRequest);
			_doctersLocalService.updatedocter(docterId, docterName, serviceContext);
			actionResponse.setRenderParameter("courseId", Long.toString(docterId));
		} catch (SystemException | PortalException e) {
			e.printStackTrace();
		}
	}

	public void groupAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// TODO Auto-generated method stub
		long[] docterIds = StringUtil.split(ParamUtil.getString(actionRequest, "docterIds"), 0L);
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String tabs1 = ParamUtil.getString(actionRequest, "tabs1");
		if (cmd.equalsIgnoreCase(Constants.DELETE)) {
			try {
				for (long docterId : docterIds) {
					System.out.println("Before Delete");
					DoctersLocalServiceUtil.deleteDocters(docterId);
					System.out.println("After Delete");
				}
			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
		}
		actionResponse.setRenderParameter("tabs1", tabs1);
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		String name = resourceRequest.getParameter("axaxName");
		JSONObject obj = JSONFactoryUtil.createJSONObject();
		obj.put("axaxName", name);
		PrintWriter printout = resourceResponse.getWriter();
		printout.print(obj.toString());

	}

	@Reference
	private DoctersLocalService _doctersLocalService;
}