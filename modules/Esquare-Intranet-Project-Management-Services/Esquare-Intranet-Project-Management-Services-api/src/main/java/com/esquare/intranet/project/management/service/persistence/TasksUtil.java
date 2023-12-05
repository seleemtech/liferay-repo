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

package com.esquare.intranet.project.management.service.persistence;

import com.esquare.intranet.project.management.model.Tasks;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the tasks service. This utility wraps <code>com.esquare.intranet.project.management.service.persistence.impl.TasksPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @see TasksPersistence
 * @generated
 */
public class TasksUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Tasks tasks) {
		getPersistence().clearCache(tasks);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Tasks> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Tasks> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Tasks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Tasks> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Tasks> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Tasks update(Tasks tasks) {
		return getPersistence().update(tasks);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Tasks update(Tasks tasks, ServiceContext serviceContext) {
		return getPersistence().update(tasks, serviceContext);
	}

	/**
	 * Returns all the taskses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching taskses
	 */
	public static List<Tasks> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the taskses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @return the range of matching taskses
	 */
	public static List<Tasks> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the taskses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching taskses
	 */
	public static List<Tasks> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Tasks> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the taskses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching taskses
	 */
	public static List<Tasks> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Tasks> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	public static Tasks findByUuid_First(
			String uuid, OrderByComparator<Tasks> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTasksException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	public static Tasks fetchByUuid_First(
		String uuid, OrderByComparator<Tasks> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	public static Tasks findByUuid_Last(
			String uuid, OrderByComparator<Tasks> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTasksException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	public static Tasks fetchByUuid_Last(
		String uuid, OrderByComparator<Tasks> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the taskses before and after the current tasks in the ordered set where uuid = &#63;.
	 *
	 * @param taskId the primary key of the current tasks
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tasks
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	public static Tasks[] findByUuid_PrevAndNext(
			long taskId, String uuid,
			OrderByComparator<Tasks> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTasksException {

		return getPersistence().findByUuid_PrevAndNext(
			taskId, uuid, orderByComparator);
	}

	/**
	 * Removes all the taskses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of taskses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching taskses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the taskses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching taskses
	 */
	public static List<Tasks> findByProjectId(long projectId) {
		return getPersistence().findByProjectId(projectId);
	}

	/**
	 * Returns a range of all the taskses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @return the range of matching taskses
	 */
	public static List<Tasks> findByProjectId(
		long projectId, int start, int end) {

		return getPersistence().findByProjectId(projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the taskses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching taskses
	 */
	public static List<Tasks> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<Tasks> orderByComparator) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the taskses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching taskses
	 */
	public static List<Tasks> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<Tasks> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	public static Tasks findByProjectId_First(
			long projectId, OrderByComparator<Tasks> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTasksException {

		return getPersistence().findByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the first tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	public static Tasks fetchByProjectId_First(
		long projectId, OrderByComparator<Tasks> orderByComparator) {

		return getPersistence().fetchByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	public static Tasks findByProjectId_Last(
			long projectId, OrderByComparator<Tasks> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTasksException {

		return getPersistence().findByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	public static Tasks fetchByProjectId_Last(
		long projectId, OrderByComparator<Tasks> orderByComparator) {

		return getPersistence().fetchByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the taskses before and after the current tasks in the ordered set where projectId = &#63;.
	 *
	 * @param taskId the primary key of the current tasks
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tasks
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	public static Tasks[] findByProjectId_PrevAndNext(
			long taskId, long projectId,
			OrderByComparator<Tasks> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTasksException {

		return getPersistence().findByProjectId_PrevAndNext(
			taskId, projectId, orderByComparator);
	}

	/**
	 * Removes all the taskses where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public static void removeByProjectId(long projectId) {
		getPersistence().removeByProjectId(projectId);
	}

	/**
	 * Returns the number of taskses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching taskses
	 */
	public static int countByProjectId(long projectId) {
		return getPersistence().countByProjectId(projectId);
	}

	/**
	 * Caches the tasks in the entity cache if it is enabled.
	 *
	 * @param tasks the tasks
	 */
	public static void cacheResult(Tasks tasks) {
		getPersistence().cacheResult(tasks);
	}

	/**
	 * Caches the taskses in the entity cache if it is enabled.
	 *
	 * @param taskses the taskses
	 */
	public static void cacheResult(List<Tasks> taskses) {
		getPersistence().cacheResult(taskses);
	}

	/**
	 * Creates a new tasks with the primary key. Does not add the tasks to the database.
	 *
	 * @param taskId the primary key for the new tasks
	 * @return the new tasks
	 */
	public static Tasks create(long taskId) {
		return getPersistence().create(taskId);
	}

	/**
	 * Removes the tasks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks that was removed
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	public static Tasks remove(long taskId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTasksException {

		return getPersistence().remove(taskId);
	}

	public static Tasks updateImpl(Tasks tasks) {
		return getPersistence().updateImpl(tasks);
	}

	/**
	 * Returns the tasks with the primary key or throws a <code>NoSuchTasksException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	public static Tasks findByPrimaryKey(long taskId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTasksException {

		return getPersistence().findByPrimaryKey(taskId);
	}

	/**
	 * Returns the tasks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks, or <code>null</code> if a tasks with the primary key could not be found
	 */
	public static Tasks fetchByPrimaryKey(long taskId) {
		return getPersistence().fetchByPrimaryKey(taskId);
	}

	/**
	 * Returns all the taskses.
	 *
	 * @return the taskses
	 */
	public static List<Tasks> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the taskses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @return the range of taskses
	 */
	public static List<Tasks> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the taskses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of taskses
	 */
	public static List<Tasks> findAll(
		int start, int end, OrderByComparator<Tasks> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the taskses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of taskses
	 */
	public static List<Tasks> findAll(
		int start, int end, OrderByComparator<Tasks> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the taskses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of taskses.
	 *
	 * @return the number of taskses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TasksPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TasksPersistence _persistence;

}