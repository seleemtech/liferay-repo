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
 * Provides a wrapper for {@link TasksService}.
 *
 * @author Mahammed Seleem
 * @see TasksService
 * @generated
 */
public class TasksServiceWrapper
	implements ServiceWrapper<TasksService>, TasksService {

	public TasksServiceWrapper() {
		this(null);
	}

	public TasksServiceWrapper(TasksService tasksService) {
		_tasksService = tasksService;
	}

	@Override
	public com.esquare.intranet.project.management.model.Tasks addTasks(
		long projectId, String name, String description) {

		return _tasksService.addTasks(projectId, name, description);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tasksService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.esquare.intranet.project.management.model.Tasks>
		getTasksByProjectId(long projectId) {

		return _tasksService.getTasksByProjectId(projectId);
	}

	@Override
	public com.esquare.intranet.project.management.model.Tasks updateTask(
		long taskId, String taskName, String taskDesc,
		String developmentTeamIds, String testerTeamIds,
		java.util.Date startDate, java.util.Date endDate) {

		return _tasksService.updateTask(
			taskId, taskName, taskDesc, developmentTeamIds, testerTeamIds,
			startDate, endDate);
	}

	@Override
	public TasksService getWrappedService() {
		return _tasksService;
	}

	@Override
	public void setWrappedService(TasksService tasksService) {
		_tasksService = tasksService;
	}

	private TasksService _tasksService;

}