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

import com.esquare.intranet.project.management.model.Projects;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the projects service. This utility wraps <code>com.esquare.intranet.project.management.service.persistence.impl.ProjectsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @see ProjectsPersistence
 * @generated
 */
public class ProjectsUtil {

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
	public static void clearCache(Projects projects) {
		getPersistence().clearCache(projects);
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
	public static Map<Serializable, Projects> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Projects> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Projects> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Projects> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Projects> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Projects update(Projects projects) {
		return getPersistence().update(projects);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Projects update(
		Projects projects, ServiceContext serviceContext) {

		return getPersistence().update(projects, serviceContext);
	}

	/**
	 * Returns all the projectses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching projectses
	 */
	public static List<Projects> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the projectses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @return the range of matching projectses
	 */
	public static List<Projects> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the projectses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projectses
	 */
	public static List<Projects> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Projects> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the projectses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching projectses
	 */
	public static List<Projects> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Projects> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first projects in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projects
	 * @throws NoSuchProjectsException if a matching projects could not be found
	 */
	public static Projects findByUuid_First(
			String uuid, OrderByComparator<Projects> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first projects in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public static Projects fetchByUuid_First(
		String uuid, OrderByComparator<Projects> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last projects in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projects
	 * @throws NoSuchProjectsException if a matching projects could not be found
	 */
	public static Projects findByUuid_Last(
			String uuid, OrderByComparator<Projects> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last projects in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public static Projects fetchByUuid_Last(
		String uuid, OrderByComparator<Projects> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the projectses before and after the current projects in the ordered set where uuid = &#63;.
	 *
	 * @param projectId the primary key of the current projects
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next projects
	 * @throws NoSuchProjectsException if a projects with the primary key could not be found
	 */
	public static Projects[] findByUuid_PrevAndNext(
			long projectId, String uuid,
			OrderByComparator<Projects> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getPersistence().findByUuid_PrevAndNext(
			projectId, uuid, orderByComparator);
	}

	/**
	 * Removes all the projectses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of projectses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching projectses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the projects where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching projects
	 * @throws NoSuchProjectsException if a matching projects could not be found
	 */
	public static Projects findByUUID_G(String uuid, long groupId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the projects where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public static Projects fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the projects where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public static Projects fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the projects where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the projects that was removed
	 */
	public static Projects removeByUUID_G(String uuid, long groupId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of projectses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching projectses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the projectses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching projectses
	 */
	public static List<Projects> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the projectses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @return the range of matching projectses
	 */
	public static List<Projects> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the projectses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching projectses
	 */
	public static List<Projects> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Projects> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the projectses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching projectses
	 */
	public static List<Projects> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Projects> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first projects in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projects
	 * @throws NoSuchProjectsException if a matching projects could not be found
	 */
	public static Projects findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Projects> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first projects in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public static Projects fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Projects> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last projects in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projects
	 * @throws NoSuchProjectsException if a matching projects could not be found
	 */
	public static Projects findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Projects> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last projects in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public static Projects fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Projects> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the projectses before and after the current projects in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectId the primary key of the current projects
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next projects
	 * @throws NoSuchProjectsException if a projects with the primary key could not be found
	 */
	public static Projects[] findByUuid_C_PrevAndNext(
			long projectId, String uuid, long companyId,
			OrderByComparator<Projects> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			projectId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the projectses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of projectses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching projectses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the projects in the entity cache if it is enabled.
	 *
	 * @param projects the projects
	 */
	public static void cacheResult(Projects projects) {
		getPersistence().cacheResult(projects);
	}

	/**
	 * Caches the projectses in the entity cache if it is enabled.
	 *
	 * @param projectses the projectses
	 */
	public static void cacheResult(List<Projects> projectses) {
		getPersistence().cacheResult(projectses);
	}

	/**
	 * Creates a new projects with the primary key. Does not add the projects to the database.
	 *
	 * @param projectId the primary key for the new projects
	 * @return the new projects
	 */
	public static Projects create(long projectId) {
		return getPersistence().create(projectId);
	}

	/**
	 * Removes the projects with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the projects
	 * @return the projects that was removed
	 * @throws NoSuchProjectsException if a projects with the primary key could not be found
	 */
	public static Projects remove(long projectId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getPersistence().remove(projectId);
	}

	public static Projects updateImpl(Projects projects) {
		return getPersistence().updateImpl(projects);
	}

	/**
	 * Returns the projects with the primary key or throws a <code>NoSuchProjectsException</code> if it could not be found.
	 *
	 * @param projectId the primary key of the projects
	 * @return the projects
	 * @throws NoSuchProjectsException if a projects with the primary key could not be found
	 */
	public static Projects findByPrimaryKey(long projectId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return getPersistence().findByPrimaryKey(projectId);
	}

	/**
	 * Returns the projects with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the projects
	 * @return the projects, or <code>null</code> if a projects with the primary key could not be found
	 */
	public static Projects fetchByPrimaryKey(long projectId) {
		return getPersistence().fetchByPrimaryKey(projectId);
	}

	/**
	 * Returns all the projectses.
	 *
	 * @return the projectses
	 */
	public static List<Projects> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the projectses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @return the range of projectses
	 */
	public static List<Projects> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the projectses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of projectses
	 */
	public static List<Projects> findAll(
		int start, int end, OrderByComparator<Projects> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the projectses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of projectses
	 */
	public static List<Projects> findAll(
		int start, int end, OrderByComparator<Projects> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the projectses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of projectses.
	 *
	 * @return the number of projectses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProjectsPersistence _persistence;

}