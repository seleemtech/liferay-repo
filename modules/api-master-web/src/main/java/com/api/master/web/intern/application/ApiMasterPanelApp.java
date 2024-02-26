/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.api.master.web.intern.application;

import com.api.master.web.constants.ApiMasterWebPortletKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.blogs.constants.BlogsPortletKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

/**
 * @author Mahammed Seleem
 */
@Component(
	property = {
		"panel.app.order:Integer=200",
		"panel.category.key=" + "site_administration.api_master"
	},
	service = PanelApp.class
)
public class ApiMasterPanelApp extends BasePanelApp {

	@Override
	public Portlet getPortlet() {
		return _portlet;
	}

	@Override
	public String getLabel(Locale locale) {
		return "Master";
	}

	@Override
	public String getPortletId() {
		return ApiMasterWebPortletKeys.APIMASTERWEB;
	}

	@Reference(
		target = "(javax.portlet.name=" + ApiMasterWebPortletKeys.APIMASTERWEB + ")"
	)
	private Portlet _portlet;

}