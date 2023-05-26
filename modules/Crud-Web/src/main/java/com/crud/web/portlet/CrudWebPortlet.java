package com.crud.web.portlet;

import com.crud.service.model.Crud;
import com.crud.service.service.CrudLocalService;
import com.crud.service.service.CrudLocalServiceUtil;
import com.crud.web.constants.CrudWebPortletKeys;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLayoutLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.test.util.search.JournalArticleContent;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CrudWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + CrudWebPortletKeys.CRUDWEB,
		"javax.portlet.resource-bundle=content.Language", 
		"com.liferay.portlet.footer-portlet-javascript=/main.js?a=19",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class CrudWebPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ClassLoader classloader = getClass().getClassLoader();

		List<Crud> crd = CrudLocalServiceUtil.getCruds(-1, -1);
		List<Crud> find = CrudLocalServiceUtil.findByName("seleem");
		List<Crud> findCutomQuery = CrudLocalServiceUtil.getByCrudNameAndCrudNo("sss", 11);
		System.out.println("FindeCustomQuery" + findCutomQuery);

		/*
		 * DynamicQuery dynamicquery = DynamicQueryFactoryUtil.forClass(Crud.class,
		 * classloader);
		 * dynamicquery.add(PropertyFactoryUtil.forName("crudName").eq("sss")); //
		 * dynamicquery.addOrder(OrderFactoryUtil.asc("empName")); Projection projection
		 * = ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("crudNo"));
		 * dynamicquery.setProjection(projection); List<Crud> dynlist =
		 * CrudLocalServiceUtil.dynamicQuery(dynamicquery); System.out.println("dynamic"
		 * + dynlist);
		 */
		// System.out.println(find);

		renderRequest.setAttribute("crd", crd);
		// TODO Auto-generated method stub
		super.render(renderRequest, renderResponse);
	}

	public void searchstudent(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, SystemException, PortalException {
		String crudName = ParamUtil.getString(request, "crudName");
		if (crudName.equals("")) {
			response.setRenderParameter("jspPage", "/view.jsp");
		} else {
			List<Crud> Findstud = CrudLocalServiceUtil.findByName(crudName);
			request.setAttribute("Findstud", Findstud);
			response.setRenderParameter("jspPage", "/view.jsp");
		}
	}

	public void updateData(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// TODO Auto-generated method stub
		long crudId = ParamUtil.getLong(actionRequest, "crudId");
		String crudName = ParamUtil.getString(actionRequest, "crudName");
		long crudNo = ParamUtil.getLong(actionRequest, "crudNo"); 
				if (crudId > 0) {
			try {
				_crudLocalService.updateData(crudId, crudName, crudNo);
				actionResponse.setRenderParameter("crudId", Long.toString(crudId));
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			try {
				_crudLocalService.addData(crudName, crudNo);
				actionResponse.setRenderParameter("crudId", Long.toString(crudId));

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public void deleteData(ActionRequest actionRequest, ActionResponse actionResponse) {
		// TODO Auto-generated method stub
		long crudId = ParamUtil.getLong(actionRequest, "crudId");
		try {
			_crudLocalService.deleteCrud(crudId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addArticle(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		String dynaTitle = ParamUtil.getString(actionRequest, "dynaTitle");
		System.out.println("Got content"+dynaTitle);
		Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(dynaTitle);
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(dynaTitle);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
		
		String content = "<?xml version=\"1.0\"?> <root available-locales=\"en_US\" default-locale=\"en_US\" version=\"1.0\"> <dynamic-element field-reference=\"FieldsGroup04920743\" index-type=\"\" instance-id=\"HRk1SWeZ\" name=\"FieldsGroup04920743\" type=\"fieldset\"> <dynamic-element field-reference=\"Text35892390\" index-type=\"keyword\" instance-id=\"9FGaOQ3X\" name=\"Text35892390\" type=\"text\"> <dynamic-content language-id=\"en_US\"><![CDATA[Hello this is web content from mvc hello]]></dynamic-content> </dynamic-element> </dynamic-element> </root>";
		
		JournalArticleLocalServiceUtil.addArticle(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), 0, titleMap, descriptionMap, content, "BASIC-WEB-CONTENT", "BASIC-WEB-CONTENT", serviceContext);

		
	}

	@Reference
	private CrudLocalService _crudLocalService;
}