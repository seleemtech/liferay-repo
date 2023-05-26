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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.prime.data.service.model.ProjectStatus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the project status service. This utility wraps <code>com.prime.data.service.service.persistence.impl.ProjectStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectStatusPersistence
 * @generated
 */
public class ProjectStatusUtil {

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
	public static void clearCache(ProjectStatus projectStatus) {
		getPersistence().clearCache(projectStatus);
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
	public static Map<Serializable, ProjectStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProjectStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectStatus update(ProjectStatus projectStatus) {
		return getPersistence().update(projectStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectStatus update(
		ProjectStatus projectStatus, ServiceContext serviceContext) {

		return getPersistence().update(projectStatus, serviceContext);
	}

	/**
	 * Returns all the project statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project statuses
	 */
	public static List<ProjectStatus> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ProjectStatus> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ProjectStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ProjectStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project status
	 * @throws NoSuchProjectStatusException if a matching project status could not be found
	 */
	public static ProjectStatus findByUuid_First(
			String uuid, OrderByComparator<ProjectStatus> orderByComparator)
		throws com.prime.data.service.exception.NoSuchProjectStatusException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project status, or <code>null</code> if a matching project status could not be found
	 */
	public static ProjectStatus fetchByUuid_First(
		String uuid, OrderByComparator<ProjectStatus> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project status
	 * @throws NoSuchProjectStatusException if a matching project status could not be found
	 */
	public static ProjectStatus findByUuid_Last(
			String uuid, OrderByComparator<ProjectStatus> orderByComparator)
		throws com.prime.data.service.exception.NoSuchProjectStatusException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project status, or <code>null</code> if a matching project status could not be found
	 */
	public static ProjectStatus fetchByUuid_Last(
		String uuid, OrderByComparator<ProjectStatus> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the project statuses before and after the current project status in the ordered set where uuid = &#63;.
	 *
	 * @param projectStatusId the primary key of the current project status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project status
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	public static ProjectStatus[] findByUuid_PrevAndNext(
			long projectStatusId, String uuid,
			OrderByComparator<ProjectStatus> orderByComparator)
		throws com.prime.data.service.exception.NoSuchProjectStatusException {

		return getPersistence().findByUuid_PrevAndNext(
			projectStatusId, uuid, orderByComparator);
	}

	/**
	 * Removes all the project statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of project statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project statuses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the project status in the entity cache if it is enabled.
	 *
	 * @param projectStatus the project status
	 */
	public static void cacheResult(ProjectStatus projectStatus) {
		getPersistence().cacheResult(projectStatus);
	}

	/**
	 * Caches the project statuses in the entity cache if it is enabled.
	 *
	 * @param projectStatuses the project statuses
	 */
	public static void cacheResult(List<ProjectStatus> projectStatuses) {
		getPersistence().cacheResult(projectStatuses);
	}

	/**
	 * Creates a new project status with the primary key. Does not add the project status to the database.
	 *
	 * @param projectStatusId the primary key for the new project status
	 * @return the new project status
	 */
	public static ProjectStatus create(long projectStatusId) {
		return getPersistence().create(projectStatusId);
	}

	/**
	 * Removes the project status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status that was removed
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	public static ProjectStatus remove(long projectStatusId)
		throws com.prime.data.service.exception.NoSuchProjectStatusException {

		return getPersistence().remove(projectStatusId);
	}

	public static ProjectStatus updateImpl(ProjectStatus projectStatus) {
		return getPersistence().updateImpl(projectStatus);
	}

	/**
	 * Returns the project status with the primary key or throws a <code>NoSuchProjectStatusException</code> if it could not be found.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	public static ProjectStatus findByPrimaryKey(long projectStatusId)
		throws com.prime.data.service.exception.NoSuchProjectStatusException {

		return getPersistence().findByPrimaryKey(projectStatusId);
	}

	/**
	 * Returns the project status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status, or <code>null</code> if a project status with the primary key could not be found
	 */
	public static ProjectStatus fetchByPrimaryKey(long projectStatusId) {
		return getPersistence().fetchByPrimaryKey(projectStatusId);
	}

	/**
	 * Returns all the project statuses.
	 *
	 * @return the project statuses
	 */
	public static List<ProjectStatus> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ProjectStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ProjectStatus> findAll(
		int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ProjectStatus> findAll(
		int start, int end, OrderByComparator<ProjectStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the project statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of project statuses.
	 *
	 * @return the number of project statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectStatusPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProjectStatusPersistence _persistence;

}