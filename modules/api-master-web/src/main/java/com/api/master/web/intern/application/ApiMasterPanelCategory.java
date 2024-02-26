/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.api.master.web.intern.application;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.language.Language;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mahammed Seleem
 */
@Component(
	property = {
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION,
		"panel.category.order:Integer=500"
	},
	service = PanelCategory.class
)
public class ApiMasterPanelCategory extends BasePanelCategory {

	@Override
	public String getKey() {
		return "site_administration.api_master";
	}

	@Override
	public String getLabel(Locale locale) {
		return "Api Integration";
	}

	@Reference
	private Language _language;

}