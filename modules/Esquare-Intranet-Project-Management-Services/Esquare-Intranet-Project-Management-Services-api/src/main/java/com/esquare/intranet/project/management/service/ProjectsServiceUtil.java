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

import com.esquare.intranet.project.management.model.Projects;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for Projects. This utility wraps
 * <code>com.esquare.intranet.project.management.service.impl.ProjectsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Mahammed Seleem
 * @see ProjectsService
 * @generated
 */
public class ProjectsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.esquare.intranet.project.management.service.impl.ProjectsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Projects addResourceIdSetting(
			long projectId, long pmId, long dlId, long opId, long qaId)
		throws PortalException {

		return getService().addResourceIdSetting(
			projectId, pmId, dlId, opId, qaId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Getting project details based on the projectId
	 */
	public static Projects getProject(long projectId) throws PortalException {
		return getService().getProject(projectId);
	}

	public static Projects updateStatus(long projectId, int status)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getService().updateStatus(projectId, status);
	}

	public static ProjectsService getService() {
		return _service;
	}

	private static volatile ProjectsService _service;

}