package com.docter.web.asset;


import com.docter.service.model.Docters;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;


import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoctersAssetRenderer extends BaseJSPAssetRenderer<Docters> {
	private final Docters _docter;
	private final ResourceBundleLoader _resourceBundleLoader;
	
	public DoctersAssetRenderer(Docters request, ResourceBundleLoader resourceBundleLoader) {

		_docter = request;
		_resourceBundleLoader = resourceBundleLoader;
	}
	
	@Override
	public Docters getAssetObject() {
		// TODO Auto-generated method stub
		return _docter;
	}

	@Override
	public long getGroupId() {
		// TODO Auto-generated method stub
		return _docter.getGroupId();
	}

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return _docter.getUserId();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		String userName = null;
		try {
			userName = UserLocalServiceUtil.getUser(_docter.getUserId()).getFullName();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return userName;
		}
		return userName;
	}

	@Override
	public String getUuid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return Docters.class.getName();
	}

	@Override
	public long getClassPK() {
		// TODO Auto-generated method stub
		return _docter.getDocterId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		// TODO Auto-generated method stub
		String summary = _docter.getDocterName();
		
		
		return summary;
	}

	@Override
	public String getTitle(Locale locale) {
		// TODO Auto-generated method stub
		return _docter.getDocterName();
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {
		// TODO Auto-generated method stub
		return "/asset/assetview.jsp";
	}
	


	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
		request.setAttribute("docter", _docter);
		return super.include(request, response, template);
	}
	


}
