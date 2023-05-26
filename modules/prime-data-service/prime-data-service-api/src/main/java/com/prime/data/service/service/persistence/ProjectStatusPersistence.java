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

package com.prime.data.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.prime.data.service.exception.NoSuchProjectStatusException;
import com.prime.data.service.model.ProjectStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectStatusUtil
 * @generated
 */
@ProviderType
public interface ProjectStatusPersistence
	extends BasePersistence<ProjectStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectStatusUtil} to access the project status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the project statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project statuses
	 */
	public java.util.List<ProjectStatus> findByUuid(String uuid);

	/**
	 * Returns a range of all the project statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @return the range of matching project statuses
	 */
	public java.util.List<ProjectStatus> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the project statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project statuses
	 */
	public java.util.List<ProjectStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project statuses
	 */
	public java.util.List<ProjectStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project status
	 * @throws NoSuchProjectStatusException if a matching project status could not be found
	 */
	public ProjectStatus findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus>
				orderByComparator)
		throws NoSuchProjectStatusException;

	/**
	 * Returns the first project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project status, or <code>null</code> if a matching project status could not be found
	 */
	public ProjectStatus fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus>
			orderByComparator);

	/**
	 * Returns the last project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project status
	 * @throws NoSuchProjectStatusException if a matching project status could not be found
	 */
	public ProjectStatus findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus>
				orderByComparator)
		throws NoSuchProjectStatusException;

	/**
	 * Returns the last project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project status, or <code>null</code> if a matching project status could not be found
	 */
	public ProjectStatus fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus>
			orderByComparator);

	/**
	 * Returns the project statuses before and after the current project status in the ordered set where uuid = &#63;.
	 *
	 * @param projectStatusId the primary key of the current project status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project status
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	public ProjectStatus[] findByUuid_PrevAndNext(
			long projectStatusId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus>
				orderByComparator)
		throws NoSuchProjectStatusException;

	/**
	 * Removes all the project statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of project statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project statuses
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the project status in the entity cache if it is enabled.
	 *
	 * @param projectStatus the project status
	 */
	public void cacheResult(ProjectStatus projectStatus);

	/**
	 * Caches the project statuses in the entity cache if it is enabled.
	 *
	 * @param projectStatuses the project statuses
	 */
	public void cacheResult(java.util.List<ProjectStatus> projectStatuses);

	/**
	 * Creates a new project status with the primary key. Does not add the project status to the database.
	 *
	 * @param projectStatusId the primary key for the new project status
	 * @return the new project status
	 */
	public ProjectStatus create(long projectStatusId);

	/**
	 * Removes the project status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status that was removed
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	public ProjectStatus remove(long projectStatusId)
		throws NoSuchProjectStatusException;

	public ProjectStatus updateImpl(ProjectStatus projectStatus);

	/**
	 * Returns the project status with the primary key or throws a <code>NoSuchProjectStatusException</code> if it could not be found.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	public ProjectStatus findByPrimaryKey(long projectStatusId)
		throws NoSuchProjectStatusException;

	/**
	 * Returns the project status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status, or <code>null</code> if a project status with the primary key could not be found
	 */
	public ProjectStatus fetchByPrimaryKey(long projectStatusId);

	/**
	 * Returns all the project statuses.
	 *
	 * @return the project statuses
	 */
	public java.util.List<ProjectStatus> findAll();

	/**
	 * Returns a range of all the project statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @return the range of project statuses
	 */
	public java.util.List<ProjectStatus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the project statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project statuses
	 */
	public java.util.List<ProjectStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project statuses
	 */
	public java.util.List<ProjectStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the project statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of project statuses.
	 *
	 * @return the number of project statuses
	 */
	public int countAll();

}