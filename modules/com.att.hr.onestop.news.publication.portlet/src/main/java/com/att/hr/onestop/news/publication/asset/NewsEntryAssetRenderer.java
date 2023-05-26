/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.att.hr.onestop.news.publication.asset;

import com.att.hr.onestop.services.model.NewsEntry;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.resource.bundle.ResourceBundleLoader;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jorge Ferrer
 * @author Juan Fernández
 * @author Sergio González
 * @author Zsolt Berentey
 */
public class NewsEntryAssetRenderer extends BaseJSPAssetRenderer<NewsEntry> implements TrashRenderer {
	private final NewsEntry _entry;
	private final ResourceBundleLoader _resourceBundleLoader;

	public NewsEntryAssetRenderer(NewsEntry request, ResourceBundleLoader resourceBundleLoader) {

		_entry = request;
		_resourceBundleLoader = resourceBundleLoader;
	}

	@Override
	public String getClassName() {
		return NewsEntry.class.getName();
	}

	@Override
	public long getClassPK() {
		return _entry.getNewsEntryId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {

		String summary = _entry.getNewsSummary();

		if (Validator.isNull(summary)) {
			summary = HtmlUtil.stripHtml(StringUtil.shorten(_entry.getNewsContent()));
		}
		//
		// return summary;
		return _entry.getNewsSummary();
	}

	@Override
	public String getTitle(Locale locale) {
		return _entry.getNewsTitle();
	}

	@Override
	public NewsEntry getAssetObject() {
		return _entry;
	}

	@Override
	public long getGroupId() {
		return _entry.getGroupId();
	}

	@Override
	public long getUserId() {
		return _entry.getUserId();
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		String userName = null;
		try {
			userName = UserLocalServiceUtil.getUser(_entry.getUserId()).getFullName();
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
	public String getPortletId() {
		AssetRendererFactory<NewsEntry> assetRendererFactory = getAssetRendererFactory();

		return assetRendererFactory.getPortletId();
	}

	@Override
	public String getType() {
		return NewsEntryAssetRendererFactory.TYPE;
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		return "/asset/viewNewsEntry.jsp";
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
		request.setAttribute("newsEntry", _entry);
		return super.include(request, response, template);
	}

	@Override
	public int getStatus() {
		return _entry.getStatus();
	}

}