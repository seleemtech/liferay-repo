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

import com.esquare.intranet.project.management.exception.NoSuchTasksException;
import com.esquare.intranet.project.management.model.Tasks;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the tasks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @see TasksUtil
 * @generated
 */
@ProviderType
public interface TasksPersistence extends BasePersistence<Tasks> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TasksUtil} to access the tasks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the taskses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching taskses
	 */
	public java.util.List<Tasks> findByUuid(String uuid);

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
	public java.util.List<Tasks> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Tasks> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tasks>
			orderByComparator);

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
	public java.util.List<Tasks> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tasks>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	public Tasks findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Tasks>
				orderByComparator)
		throws NoSuchTasksException;

	/**
	 * Returns the first tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	public Tasks fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tasks>
			orderByComparator);

	/**
	 * Returns the last tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	public Tasks findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Tasks>
				orderByComparator)
		throws NoSuchTasksException;

	/**
	 * Returns the last tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	public Tasks fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Tasks>
			orderByComparator);

	/**
	 * Returns the taskses before and after the current tasks in the ordered set where uuid = &#63;.
	 *
	 * @param taskId the primary key of the current tasks
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tasks
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	public Tasks[] findByUuid_PrevAndNext(
			long taskId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Tasks>
				orderByComparator)
		throws NoSuchTasksException;

	/**
	 * Removes all the taskses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of taskses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching taskses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the taskses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching taskses
	 */
	public java.util.List<Tasks> findByProjectId(long projectId);

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
	public java.util.List<Tasks> findByProjectId(
		long projectId, int start, int end);

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
	public java.util.List<Tasks> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tasks>
			orderByComparator);

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
	public java.util.List<Tasks> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tasks>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	public Tasks findByProjectId_First(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<Tasks>
				orderByComparator)
		throws NoSuchTasksException;

	/**
	 * Returns the first tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	public Tasks fetchByProjectId_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<Tasks>
			orderByComparator);

	/**
	 * Returns the last tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	public Tasks findByProjectId_Last(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<Tasks>
				orderByComparator)
		throws NoSuchTasksException;

	/**
	 * Returns the last tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	public Tasks fetchByProjectId_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<Tasks>
			orderByComparator);

	/**
	 * Returns the taskses before and after the current tasks in the ordered set where projectId = &#63;.
	 *
	 * @param taskId the primary key of the current tasks
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tasks
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	public Tasks[] findByProjectId_PrevAndNext(
			long taskId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<Tasks>
				orderByComparator)
		throws NoSuchTasksException;

	/**
	 * Removes all the taskses where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public void removeByProjectId(long projectId);

	/**
	 * Returns the number of taskses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching taskses
	 */
	public int countByProjectId(long projectId);

	/**
	 * Caches the tasks in the entity cache if it is enabled.
	 *
	 * @param tasks the tasks
	 */
	public void cacheResult(Tasks tasks);

	/**
	 * Caches the taskses in the entity cache if it is enabled.
	 *
	 * @param taskses the taskses
	 */
	public void cacheResult(java.util.List<Tasks> taskses);

	/**
	 * Creates a new tasks with the primary key. Does not add the tasks to the database.
	 *
	 * @param taskId the primary key for the new tasks
	 * @return the new tasks
	 */
	public Tasks create(long taskId);

	/**
	 * Removes the tasks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks that was removed
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	public Tasks remove(long taskId) throws NoSuchTasksException;

	public Tasks updateImpl(Tasks tasks);

	/**
	 * Returns the tasks with the primary key or throws a <code>NoSuchTasksException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	public Tasks findByPrimaryKey(long taskId) throws NoSuchTasksException;

	/**
	 * Returns the tasks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks, or <code>null</code> if a tasks with the primary key could not be found
	 */
	public Tasks fetchByPrimaryKey(long taskId);

	/**
	 * Returns all the taskses.
	 *
	 * @return the taskses
	 */
	public java.util.List<Tasks> findAll();

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
	public java.util.List<Tasks> findAll(int start, int end);

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
	public java.util.List<Tasks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tasks>
			orderByComparator);

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
	public java.util.List<Tasks> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Tasks>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the taskses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of taskses.
	 *
	 * @return the number of taskses
	 */
	public int countAll();

}