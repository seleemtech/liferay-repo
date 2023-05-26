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

package com.rms.dynamic.data.mapping.form.web.internal.tab.item;

import com.dynamic.mapping.form.web.constants.DynamicDataMappingWebPortletKeys;
import com.liferay.dynamic.data.mapping.constants.DDMPortletKeys;
import com.liferay.dynamic.data.mapping.util.DDMDisplayTabItem;
import com.liferay.petra.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mahammed Seleem
 */
@Component(
	property = "javax.portlet.name=" + DynamicDataMappingWebPortletKeys.DYNAMICDATAMAPPINGWEB,
	service = {DDMDisplayTabItem.class, DDMFormAdminTabItem.class}
)
public class DDMFormAdminTabItem implements DDMDisplayTabItem {

	@Override
	public String getTitle(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		return language.get(
			liferayPortletRequest.getHttpServletRequest(), "forms");
	}

	@Override
	public String getURL(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		return PortletURLBuilder.create(
			getPortletURL(liferayPortletRequest, liferayPortletResponse)
		).setParameter(
			"currentTab", "forms"
		).buildString();
	}

	protected PortletURL getPortletURL(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		return PortletURLBuilder.create(
			PortletURLFactoryUtil.create(
				liferayPortletRequest,
				DynamicDataMappingWebPortletKeys.DYNAMICDATAMAPPINGWEB,
				PortletRequest.RENDER_PHASE)
		).setBackURL(
			themeDisplay.getURLCurrent()
		).setParameter(
			"groupId", themeDisplay.getScopeGroupId()
		).setParameter(
			"refererPortletName", DynamicDataMappingWebPortletKeys.DYNAMICDATAMAPPINGWEB
		).buildPortletURL();
	}

	@Reference
	protected Language language;

}