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

package com.esquare.intranet.project.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectManagementService}.
 *
 * @author Mahammed Seleem
 * @see ProjectManagementService
 * @generated
 */
public class ProjectManagementServiceWrapper
	implements ProjectManagementService,
			   ServiceWrapper<ProjectManagementService> {

	public ProjectManagementServiceWrapper() {
		this(null);
	}

	public ProjectManagementServiceWrapper(
		ProjectManagementService projectManagementService) {

		_projectManagementService = projectManagementService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectManagementService.getOSGiServiceIdentifier();
	}

	@Override
	public com.esquare.intranet.project.management.model.ProjectManagement
			getProjectMnt(long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectManagementService.getProjectMnt(projectId);
	}

	@Override
	public ProjectManagementService getWrappedService() {
		return _projectManagementService;
	}

	@Override
	public void setWrappedService(
		ProjectManagementService projectManagementService) {

		_projectManagementService = projectManagementService;
	}

	private ProjectManagementService _projectManagementService;

}