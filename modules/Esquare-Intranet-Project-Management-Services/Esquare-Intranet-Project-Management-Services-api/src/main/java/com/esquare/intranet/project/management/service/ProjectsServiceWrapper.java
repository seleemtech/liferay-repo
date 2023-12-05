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
 * Provides a wrapper for {@link ProjectsService}.
 *
 * @author Mahammed Seleem
 * @see ProjectsService
 * @generated
 */
public class ProjectsServiceWrapper
	implements ProjectsService, ServiceWrapper<ProjectsService> {

	public ProjectsServiceWrapper() {
		this(null);
	}

	public ProjectsServiceWrapper(ProjectsService projectsService) {
		_projectsService = projectsService;
	}

	@Override
	public com.esquare.intranet.project.management.model.Projects
			addResourceIdSetting(
				long projectId, long pmId, long dlId, long opId, long qaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsService.addResourceIdSetting(
			projectId, pmId, dlId, opId, qaId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectsService.getOSGiServiceIdentifier();
	}

	/**
	 * Getting project details based on the projectId
	 */
	@Override
	public com.esquare.intranet.project.management.model.Projects getProject(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsService.getProject(projectId);
	}

	@Override
	public com.esquare.intranet.project.management.model.Projects updateStatus(
			long projectId, int status)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return _projectsService.updateStatus(projectId, status);
	}

	@Override
	public ProjectsService getWrappedService() {
		return _projectsService;
	}

	@Override
	public void setWrappedService(ProjectsService projectsService) {
		_projectsService = projectsService;
	}

	private ProjectsService _projectsService;

}