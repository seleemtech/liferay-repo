/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.att.hr.onestop.news.publication.asset;

import com.att.hr.onestop.news.publication.portlet.NewsPortletKeys;
import com.att.hr.onestop.services.model.NewsEntry;
import com.att.hr.onestop.services.service.NewsEntryLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;

import javax.servlet.ServletContext;

import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jorge Ferrer
 * @author Juan Fern??ndez
 * @author Raymond Aug??
 * @author Sergio Gonz??lez
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + NewsPortletKeys.NewsPortletName }, service = AssetRendererFactory.class)
public class NewsEntryAssetRendererFactory extends BaseAssetRendererFactory<NewsEntry> {

	private NewsEntryLocalService _newsEntryService;
	private ResourceBundleLoader _resourceBundleLoader;
	private ServletContext _servletContext;

	public static final String TYPE = "newsEntry";

	public NewsEntryAssetRendererFactory() {
		setClassName(NewsEntry.class.getName());
		setCategorizable(true); // maybe
		setLinkable(true); // doubtful
		setPortletId(NewsPortletKeys.NewsPortletName);
		setSearchable(true); // doubtful
		setSelectable(true); // maybe
	}

	@Override
	public AssetRenderer<NewsEntry> getAssetRenderer(long classPK, int type) throws PortalException {
		NewsEntry request = _newsEntryService.getNewsEntry(classPK);

		NewsEntryAssetRenderer newsEntryAssetRenderer = new NewsEntryAssetRenderer(request, _resourceBundleLoader);

		newsEntryAssetRenderer.setAssetRendererType(type);
		newsEntryAssetRenderer.setServletContext(_servletContext);

		return newsEntryAssetRenderer;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public String getClassName() {
		return NewsEntry.class.getName();
	}

	@Override
	public String getIconCssClass() {
		return "link";
	}

	@Reference(unbind = "-")
	protected void setNewsEntryLocalService(NewsEntryLocalService searchRequestLocalService) {
		_newsEntryService = searchRequestLocalService;
	}

	@Reference(target = "(bundle.symbolic.name=com.att.hr.onestop.news.publication.portlet)", unbind = "-")
	public void setResourceBundleLoader(ResourceBundleLoader resourceBundleLoader) {
		_resourceBundleLoader = resourceBundleLoader;
	}
	
	@Reference(target = "(osgi.web.symbolicname=com.att.hr.onestop.news.publication.portlet)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

}