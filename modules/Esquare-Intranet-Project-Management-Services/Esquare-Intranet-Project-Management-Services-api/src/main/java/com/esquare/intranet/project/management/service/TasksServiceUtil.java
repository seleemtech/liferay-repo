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

import com.esquare.intranet.project.management.model.Tasks;

import java.util.List;

/**
 * Provides the remote service utility for Tasks. This utility wraps
 * <code>com.esquare.intranet.project.management.service.impl.TasksServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Mahammed Seleem
 * @see TasksService
 * @generated
 */
public class TasksServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.esquare.intranet.project.management.service.impl.TasksServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Tasks addTasks(
		long projectId, String name, String description) {

		return getService().addTasks(projectId, name, description);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<Tasks> getTasksByProjectId(long projectId) {
		return getService().getTasksByProjectId(projectId);
	}

	public static Tasks updateTask(
		long taskId, String taskName, String taskDesc,
		String developmentTeamIds, String testerTeamIds,
		java.util.Date startDate, java.util.Date endDate) {

		return getService().updateTask(
			taskId, taskName, taskDesc, developmentTeamIds, testerTeamIds,
			startDate, endDate);
	}

	public static TasksService getService() {
		return _service;
	}

	private static volatile TasksService _service;

}