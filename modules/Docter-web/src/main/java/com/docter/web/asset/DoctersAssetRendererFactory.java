package com.docter.web.asset;

import com.docter.service.model.Docters;
import com.docter.service.service.DoctersLocalService;
import com.docter.web.constants.DocterWebPortletKeys;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + DocterWebPortletKeys.DocterPortletName }, service = AssetRendererFactory.class)
public class DoctersAssetRendererFactory extends BaseAssetRendererFactory<Docters> {

	private DoctersLocalService _doctersLocalService;
	private ResourceBundleLoader _resourceBundleLoader;
	private ServletContext _servletContext;
	public static final String TYPE = "docter";

	public DoctersAssetRendererFactory() {
		setClassName(Docters.class.getName());
		setCategorizable(true); 
		setLinkable(true); 
		setPortletId(DocterWebPortletKeys.DocterPortletName);
		setSearchable(true); 
		setSelectable(true);
	}

	@Override
	public AssetRenderer<Docters> getAssetRenderer(long classPK, int type) throws PortalException {
		Docters request = _doctersLocalService.getDocters(classPK);

		DoctersAssetRenderer doctersAssetRenderer = new DoctersAssetRenderer(request, _resourceBundleLoader);

		doctersAssetRenderer.setAssetRendererType(type);
		doctersAssetRenderer.setServletContext(_servletContext);

		return doctersAssetRenderer;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return TYPE;
	}
	
	@Override
	public String getClassName() {
		return Docters.class.getName();
	}

	@Override
	public String getIconCssClass() {
		return "link";
	}

	@Reference(unbind = "-")
	protected void setDoctersLocalService(DoctersLocalService searchRequestLocalService) {
		_doctersLocalService = searchRequestLocalService;
	}

	@Reference(target = "(bundle.symbolic.name=com.docter.web.DocterWebPortlet)", unbind = "-")
	public void setResourceBundleLoader(ResourceBundleLoader resourceBundleLoader) {
		_resourceBundleLoader = resourceBundleLoader;
	}

	@Reference(target = "(osgi.web.symbolicname=com.docter.web.DocterWebPortlet)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

}
