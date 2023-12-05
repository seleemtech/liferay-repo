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

import com.esquare.intranet.project.management.exception.NoSuchProjectsException;
import com.esquare.intranet.project.management.model.Projects;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the projects service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @see ProjectsUtil
 * @generated
 */
@ProviderType
public interface ProjectsPersistence extends BasePersistence<Projects> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectsUtil} to access the projects persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the projectses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching projectses
	 */
	public java.util.List<Projects> findByUuid(String uuid);

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
	public java.util.List<Projects> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Projects> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Projects>
			orderByComparator);

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
	public java.util.List<Projects> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Projects>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first projects in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projects
	 * @throws NoSuchProjectsException if a matching projects could not be found
	 */
	public Projects findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Projects>
				orderByComparator)
		throws NoSuchProjectsException;

	/**
	 * Returns the first projects in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public Projects fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Projects>
			orderByComparator);

	/**
	 * Returns the last projects in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projects
	 * @throws NoSuchProjectsException if a matching projects could not be found
	 */
	public Projects findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Projects>
				orderByComparator)
		throws NoSuchProjectsException;

	/**
	 * Returns the last projects in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public Projects fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Projects>
			orderByComparator);

	/**
	 * Returns the projectses before and after the current projects in the ordered set where uuid = &#63;.
	 *
	 * @param projectId the primary key of the current projects
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next projects
	 * @throws NoSuchProjectsException if a projects with the primary key could not be found
	 */
	public Projects[] findByUuid_PrevAndNext(
			long projectId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Projects>
				orderByComparator)
		throws NoSuchProjectsException;

	/**
	 * Removes all the projectses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of projectses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching projectses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the projects where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching projects
	 * @throws NoSuchProjectsException if a matching projects could not be found
	 */
	public Projects findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectsException;

	/**
	 * Returns the projects where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public Projects fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the projects where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public Projects fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the projects where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the projects that was removed
	 */
	public Projects removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectsException;

	/**
	 * Returns the number of projectses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching projectses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the projectses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching projectses
	 */
	public java.util.List<Projects> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Projects> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Projects> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Projects>
			orderByComparator);

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
	public java.util.List<Projects> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Projects>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first projects in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projects
	 * @throws NoSuchProjectsException if a matching projects could not be found
	 */
	public Projects findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Projects>
				orderByComparator)
		throws NoSuchProjectsException;

	/**
	 * Returns the first projects in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public Projects fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Projects>
			orderByComparator);

	/**
	 * Returns the last projects in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projects
	 * @throws NoSuchProjectsException if a matching projects could not be found
	 */
	public Projects findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Projects>
				orderByComparator)
		throws NoSuchProjectsException;

	/**
	 * Returns the last projects in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching projects, or <code>null</code> if a matching projects could not be found
	 */
	public Projects fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Projects>
			orderByComparator);

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
	public Projects[] findByUuid_C_PrevAndNext(
			long projectId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Projects>
				orderByComparator)
		throws NoSuchProjectsException;

	/**
	 * Removes all the projectses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of projectses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching projectses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the projects in the entity cache if it is enabled.
	 *
	 * @param projects the projects
	 */
	public void cacheResult(Projects projects);

	/**
	 * Caches the projectses in the entity cache if it is enabled.
	 *
	 * @param projectses the projectses
	 */
	public void cacheResult(java.util.List<Projects> projectses);

	/**
	 * Creates a new projects with the primary key. Does not add the projects to the database.
	 *
	 * @param projectId the primary key for the new projects
	 * @return the new projects
	 */
	public Projects create(long projectId);

	/**
	 * Removes the projects with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the projects
	 * @return the projects that was removed
	 * @throws NoSuchProjectsException if a projects with the primary key could not be found
	 */
	public Projects remove(long projectId) throws NoSuchProjectsException;

	public Projects updateImpl(Projects projects);

	/**
	 * Returns the projects with the primary key or throws a <code>NoSuchProjectsException</code> if it could not be found.
	 *
	 * @param projectId the primary key of the projects
	 * @return the projects
	 * @throws NoSuchProjectsException if a projects with the primary key could not be found
	 */
	public Projects findByPrimaryKey(long projectId)
		throws NoSuchProjectsException;

	/**
	 * Returns the projects with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the projects
	 * @return the projects, or <code>null</code> if a projects with the primary key could not be found
	 */
	public Projects fetchByPrimaryKey(long projectId);

	/**
	 * Returns all the projectses.
	 *
	 * @return the projectses
	 */
	public java.util.List<Projects> findAll();

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
	public java.util.List<Projects> findAll(int start, int end);

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
	public java.util.List<Projects> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Projects>
			orderByComparator);

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
	public java.util.List<Projects> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Projects>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the projectses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of projectses.
	 *
	 * @return the number of projectses
	 */
	public int countAll();

}