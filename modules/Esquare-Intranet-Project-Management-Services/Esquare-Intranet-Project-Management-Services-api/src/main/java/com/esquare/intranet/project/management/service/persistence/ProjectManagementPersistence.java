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

import com.esquare.intranet.project.management.exception.NoSuchProjectManagementException;
import com.esquare.intranet.project.management.model.ProjectManagement;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @see ProjectManagementUtil
 * @generated
 */
@ProviderType
public interface ProjectManagementPersistence
	extends BasePersistence<ProjectManagement> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectManagementUtil} to access the project management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the project managements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project managements
	 */
	public java.util.List<ProjectManagement> findByUuid(String uuid);

	/**
	 * Returns a range of all the project managements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @return the range of matching project managements
	 */
	public java.util.List<ProjectManagement> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the project managements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project managements
	 */
	public java.util.List<ProjectManagement> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project managements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project managements
	 */
	public java.util.List<ProjectManagement> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project management
	 * @throws NoSuchProjectManagementException if a matching project management could not be found
	 */
	public ProjectManagement findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
				orderByComparator)
		throws NoSuchProjectManagementException;

	/**
	 * Returns the first project management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project management, or <code>null</code> if a matching project management could not be found
	 */
	public ProjectManagement fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
			orderByComparator);

	/**
	 * Returns the last project management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project management
	 * @throws NoSuchProjectManagementException if a matching project management could not be found
	 */
	public ProjectManagement findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
				orderByComparator)
		throws NoSuchProjectManagementException;

	/**
	 * Returns the last project management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project management, or <code>null</code> if a matching project management could not be found
	 */
	public ProjectManagement fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
			orderByComparator);

	/**
	 * Returns the project managements before and after the current project management in the ordered set where uuid = &#63;.
	 *
	 * @param projectMgmtId the primary key of the current project management
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project management
	 * @throws NoSuchProjectManagementException if a project management with the primary key could not be found
	 */
	public ProjectManagement[] findByUuid_PrevAndNext(
			long projectMgmtId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
				orderByComparator)
		throws NoSuchProjectManagementException;

	/**
	 * Removes all the project managements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of project managements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project managements
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the project management where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectManagementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project management
	 * @throws NoSuchProjectManagementException if a matching project management could not be found
	 */
	public ProjectManagement findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectManagementException;

	/**
	 * Returns the project management where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project management, or <code>null</code> if a matching project management could not be found
	 */
	public ProjectManagement fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the project management where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project management, or <code>null</code> if a matching project management could not be found
	 */
	public ProjectManagement fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the project management where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project management that was removed
	 */
	public ProjectManagement removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectManagementException;

	/**
	 * Returns the number of project managements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project managements
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the project managements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project managements
	 */
	public java.util.List<ProjectManagement> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the project managements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @return the range of matching project managements
	 */
	public java.util.List<ProjectManagement> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the project managements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project managements
	 */
	public java.util.List<ProjectManagement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project managements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project managements
	 */
	public java.util.List<ProjectManagement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project management
	 * @throws NoSuchProjectManagementException if a matching project management could not be found
	 */
	public ProjectManagement findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
				orderByComparator)
		throws NoSuchProjectManagementException;

	/**
	 * Returns the first project management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project management, or <code>null</code> if a matching project management could not be found
	 */
	public ProjectManagement fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
			orderByComparator);

	/**
	 * Returns the last project management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project management
	 * @throws NoSuchProjectManagementException if a matching project management could not be found
	 */
	public ProjectManagement findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
				orderByComparator)
		throws NoSuchProjectManagementException;

	/**
	 * Returns the last project management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project management, or <code>null</code> if a matching project management could not be found
	 */
	public ProjectManagement fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
			orderByComparator);

	/**
	 * Returns the project managements before and after the current project management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectMgmtId the primary key of the current project management
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project management
	 * @throws NoSuchProjectManagementException if a project management with the primary key could not be found
	 */
	public ProjectManagement[] findByUuid_C_PrevAndNext(
			long projectMgmtId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
				orderByComparator)
		throws NoSuchProjectManagementException;

	/**
	 * Removes all the project managements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of project managements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project managements
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the project management in the entity cache if it is enabled.
	 *
	 * @param projectManagement the project management
	 */
	public void cacheResult(ProjectManagement projectManagement);

	/**
	 * Caches the project managements in the entity cache if it is enabled.
	 *
	 * @param projectManagements the project managements
	 */
	public void cacheResult(
		java.util.List<ProjectManagement> projectManagements);

	/**
	 * Creates a new project management with the primary key. Does not add the project management to the database.
	 *
	 * @param projectMgmtId the primary key for the new project management
	 * @return the new project management
	 */
	public ProjectManagement create(long projectMgmtId);

	/**
	 * Removes the project management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectMgmtId the primary key of the project management
	 * @return the project management that was removed
	 * @throws NoSuchProjectManagementException if a project management with the primary key could not be found
	 */
	public ProjectManagement remove(long projectMgmtId)
		throws NoSuchProjectManagementException;

	public ProjectManagement updateImpl(ProjectManagement projectManagement);

	/**
	 * Returns the project management with the primary key or throws a <code>NoSuchProjectManagementException</code> if it could not be found.
	 *
	 * @param projectMgmtId the primary key of the project management
	 * @return the project management
	 * @throws NoSuchProjectManagementException if a project management with the primary key could not be found
	 */
	public ProjectManagement findByPrimaryKey(long projectMgmtId)
		throws NoSuchProjectManagementException;

	/**
	 * Returns the project management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectMgmtId the primary key of the project management
	 * @return the project management, or <code>null</code> if a project management with the primary key could not be found
	 */
	public ProjectManagement fetchByPrimaryKey(long projectMgmtId);

	/**
	 * Returns all the project managements.
	 *
	 * @return the project managements
	 */
	public java.util.List<ProjectManagement> findAll();

	/**
	 * Returns a range of all the project managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @return the range of project managements
	 */
	public java.util.List<ProjectManagement> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the project managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project managements
	 */
	public java.util.List<ProjectManagement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the project managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project managements
	 */
	public java.util.List<ProjectManagement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectManagement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the project managements from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of project managements.
	 *
	 * @return the number of project managements
	 */
	public int countAll();

}