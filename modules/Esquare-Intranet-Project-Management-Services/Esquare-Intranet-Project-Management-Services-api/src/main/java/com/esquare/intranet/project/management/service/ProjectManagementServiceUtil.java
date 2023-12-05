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

import com.esquare.intranet.project.management.model.ProjectManagement;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for ProjectManagement. This utility wraps
 * <code>com.esquare.intranet.project.management.service.impl.ProjectManagementServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Mahammed Seleem
 * @see ProjectManagementService
 * @generated
 */
public class ProjectManagementServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.esquare.intranet.project.management.service.impl.ProjectManagementServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ProjectManagement getProjectMnt(long projectId)
		throws PortalException {

		return getService().getProjectMnt(projectId);
	}

	public static ProjectManagementService getService() {
		return _service;
	}

	private static volatile ProjectManagementService _service;

}