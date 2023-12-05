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
 * Provides a wrapper for {@link TasksLocalService}.
 *
 * @author Mahammed Seleem
 * @see TasksLocalService
 * @generated
 */
public class TasksLocalServiceWrapper
	implements ServiceWrapper<TasksLocalService>, TasksLocalService {

	public TasksLocalServiceWrapper() {
		this(null);
	}

	public TasksLocalServiceWrapper(TasksLocalService tasksLocalService) {
		_tasksLocalService = tasksLocalService;
	}

	@Override
	public com.esquare.intranet.project.management.model.Tasks addTasks(
		long projectId, String name, String description) {

		return _tasksLocalService.addTasks(projectId, name, description);
	}

	/**
	 * Adds the tasks to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TasksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tasks the tasks
	 * @return the tasks that was added
	 */
	@Override
	public com.esquare.intranet.project.management.model.Tasks addTasks(
		com.esquare.intranet.project.management.model.Tasks tasks) {

		return _tasksLocalService.addTasks(tasks);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tasksLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new tasks with the primary key. Does not add the tasks to the database.
	 *
	 * @param taskId the primary key for the new tasks
	 * @return the new tasks
	 */
	@Override
	public com.esquare.intranet.project.management.model.Tasks createTasks(
		long taskId) {

		return _tasksLocalService.createTasks(taskId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tasksLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the tasks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TasksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks that was removed
	 * @throws PortalException if a tasks with the primary key could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.Tasks deleteTasks(
			long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tasksLocalService.deleteTasks(taskId);
	}

	/**
	 * Deletes the tasks from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TasksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tasks the tasks
	 * @return the tasks that was removed
	 */
	@Override
	public com.esquare.intranet.project.management.model.Tasks deleteTasks(
		com.esquare.intranet.project.management.model.Tasks tasks) {

		return _tasksLocalService.deleteTasks(tasks);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _tasksLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _tasksLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tasksLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tasksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.TasksModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _tasksLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.TasksModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _tasksLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _tasksLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _tasksLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.esquare.intranet.project.management.model.Tasks fetchTasks(
		long taskId) {

		return _tasksLocalService.fetchTasks(taskId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tasksLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tasksLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tasksLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tasksLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the tasks with the primary key.
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks
	 * @throws PortalException if a tasks with the primary key could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.Tasks getTasks(
			long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tasksLocalService.getTasks(taskId);
	}

	@Override
	public java.util.List<com.esquare.intranet.project.management.model.Tasks>
		getTasksByProjectId(long projectId) {

		return _tasksLocalService.getTasksByProjectId(projectId);
	}

	/**
	 * Returns a range of all the taskses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.TasksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @return the range of taskses
	 */
	@Override
	public java.util.List<com.esquare.intranet.project.management.model.Tasks>
		getTaskses(int start, int end) {

		return _tasksLocalService.getTaskses(start, end);
	}

	/**
	 * Returns the number of taskses.
	 *
	 * @return the number of taskses
	 */
	@Override
	public int getTasksesCount() {
		return _tasksLocalService.getTasksesCount();
	}

	@Override
	public com.esquare.intranet.project.management.model.Tasks updateTasks(
		long taskId, String taskName, String taskDesc,
		String developmentTeamIds, String testerTeamIds,
		java.util.Date startDate, java.util.Date endDate) {

		return _tasksLocalService.updateTasks(
			taskId, taskName, taskDesc, developmentTeamIds, testerTeamIds,
			startDate, endDate);
	}

	/**
	 * Updates the tasks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TasksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tasks the tasks
	 * @return the tasks that was updated
	 */
	@Override
	public com.esquare.intranet.project.management.model.Tasks updateTasks(
		com.esquare.intranet.project.management.model.Tasks tasks) {

		return _tasksLocalService.updateTasks(tasks);
	}

	@Override
	public TasksLocalService getWrappedService() {
		return _tasksLocalService;
	}

	@Override
	public void setWrappedService(TasksLocalService tasksLocalService) {
		_tasksLocalService = tasksLocalService;
	}

	private TasksLocalService _tasksLocalService;

}