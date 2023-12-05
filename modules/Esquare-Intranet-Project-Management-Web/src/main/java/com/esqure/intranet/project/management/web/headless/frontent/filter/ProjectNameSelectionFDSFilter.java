/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.esqure.intranet.project.management.web.headless.frontent.filter;

import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.liferay.frontend.data.set.constants.FDSEntityFieldTypes;
import com.liferay.frontend.data.set.filter.BaseSelectionFDSFilter;
import com.liferay.frontend.data.set.filter.FDSFilter;
import org.osgi.service.component.annotations.Component;

/**
 * @author Mahammed Seleem
 * @Descriptions: This class is used for listing the project Name column for filters.
 */
@Component(
	property = "frontend.data.set.name=" + ProjectConstant.PTOJECT_TABLE,
	service = FDSFilter.class
)
public class ProjectNameSelectionFDSFilter extends BaseSelectionFDSFilter {

	@Override
	public String getAPIURL() {
		return "/o/esquare/intranet/project/headless/v1.0/projects-management?sort=name:asc";
	}
	@Override
	public String getEntityFieldType() {
		return FDSEntityFieldTypes.COLLECTION;
	}
	@Override
	public String getId() {
		return "projectId";
	}

	@Override
	public String getItemKey() {
		return "id";
	}

	@Override
	public String getItemLabel() {
		return "name";
	} // key

	@Override
	public String getLabel() {
		return "Project Name";
	}

	@Override
	public boolean isAutocompleteEnabled() {
		return true;
	}

	@Override
	public boolean isMultiple() {
		return false;
	}

}