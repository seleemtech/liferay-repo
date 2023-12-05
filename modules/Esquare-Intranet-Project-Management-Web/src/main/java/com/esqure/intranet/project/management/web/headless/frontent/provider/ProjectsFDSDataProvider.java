/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 *//*


package com.esqure.intranet.project.management.web.headless.frontent.provider;

import com.esquare.intranet.project.management.service.model.Projects;
import com.esquare.intranet.project.management.service.service.ProjectsLocalService;
import com.esqure.intranet.project.management.web.Classic.context.model.Project;
import com.liferay.frontend.data.set.provider.FDSDataProvider;
import com.liferay.frontend.data.set.provider.search.FDSKeywords;
import com.liferay.frontend.data.set.provider.search.FDSPagination;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

*
 * @author Mahammed Seleem
@Component(
	property = "fds.data.provider.key=" + ProjectConstant.PTOJECT_TABLE,
	service = FDSDataProvider.class
)
public class ProjectsFDSDataProvider
	implements FDSDataProvider<Projects> {

	@Override
	public List<Projects> getItems(
			FDSKeywords fdsKeywords, FDSPagination fdsPagination,
			HttpServletRequest httpServletRequest, Sort sort)
		throws PortalException {

		List<Projects> projects = new ArrayList<>();

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		*/
/** classic display code *//*


*/
/*		List<Projects> projectMngmt = _projectsLocalService.search(
			themeDisplay.getCompanyId(), fdsKeywords.getKeywords(),
			fdsPagination.getStartPosition(), fdsPagination.getEndPosition(),
			new Sort(Field.NAME, false));

		for (Projects project : projectMngmt) {
			projects.add(
					(Projects) new Project(
							project.getProjectId(),
							project.getName(),
							project.getDescription(),
							project.getCode()));
		}*//*


		return projects;
	}

	@Override
	public int getItemsCount(
			FDSKeywords fdsKeywords, HttpServletRequest httpServletRequest)
		throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		*/
/*return _projectsLocalService.searchProjectCount(
			themeDisplay.getCompanyId(), fdsKeywords.getKeywords());*//*

		return 0;
	}

	@Reference
	private ProjectsLocalService _projectsLocalService;

}*/
