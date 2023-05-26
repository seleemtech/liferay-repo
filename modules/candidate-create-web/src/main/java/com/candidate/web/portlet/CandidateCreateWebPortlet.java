package com.candidate.web.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.candidate.web.constants.CandidateCreateWebPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RegionLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author E2Software-011
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CandidateCreateWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CandidateCreateWebPortletKeys.CANDIDATECREATEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class CandidateCreateWebPortlet extends MVCPortlet {

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		long countryId = ParamUtil.getLong(resourceRequest, "countryId");
		List<Region> regionList = null;
		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		try {
			regionList = RegionLocalServiceUtil.getRegions(countryId, true);
			for (Region region : regionList) {
				JSONObject regionJson = JSONFactoryUtil.createJSONObject();
				regionJson.put("id", region.getRegionId());
				regionJson.put("name", region.getName());
				jsonArray.put(regionJson);
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

		jsonResponse.put("StateValue", jsonArray);
		try {
			resourceResponse.getWriter().write(jsonResponse.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}