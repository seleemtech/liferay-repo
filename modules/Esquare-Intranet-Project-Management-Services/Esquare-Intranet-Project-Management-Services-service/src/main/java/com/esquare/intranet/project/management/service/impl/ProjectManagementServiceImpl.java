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

package com.esquare.intranet.project.management.service.impl;

import com.esquare.intranet.project.management.model.ProjectManagement;
import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.service.base.ProjectManagementServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import org.osgi.service.component.annotations.Component;

/**
 * @author Mahammed Seleem
 */
@Component(
	property = {
		"json.web.service.context.name=esquare",
		"json.web.service.context.path=ProjectManagement"
	},
	service = AopService.class
)
public class ProjectManagementServiceImpl
	extends ProjectManagementServiceBaseImpl {


	public ProjectManagement getProjectMnt(long projectId)
			throws PortalException {

		/** Before getting project details checking the permission  */
		/*_projectsModelResourcePermission.check(
				getPermissionChecker(), projectId, ActionKeys.VIEW);*/

		return projectManagementLocalService.fetchProjectManagement(
				projectId);
	}
}