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

import com.esquare.intranet.project.management.exception.NoSuchTeamMembersException;
import com.esquare.intranet.project.management.model.TeamMembers;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the team members service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @see TeamMembersUtil
 * @generated
 */
@ProviderType
public interface TeamMembersPersistence extends BasePersistence<TeamMembers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TeamMembersUtil} to access the team members persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the team memberses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team memberses
	 */
	public java.util.List<TeamMembers> findByUuid(String uuid);

	/**
	 * Returns a range of all the team memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @return the range of matching team memberses
	 */
	public java.util.List<TeamMembers> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the team memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team memberses
	 */
	public java.util.List<TeamMembers> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the team memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team memberses
	 */
	public java.util.List<TeamMembers> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	public TeamMembers findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
				orderByComparator)
		throws NoSuchTeamMembersException;

	/**
	 * Returns the first team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public TeamMembers fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
			orderByComparator);

	/**
	 * Returns the last team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	public TeamMembers findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
				orderByComparator)
		throws NoSuchTeamMembersException;

	/**
	 * Returns the last team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public TeamMembers fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
			orderByComparator);

	/**
	 * Returns the team memberses before and after the current team members in the ordered set where uuid = &#63;.
	 *
	 * @param memberId the primary key of the current team members
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team members
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	public TeamMembers[] findByUuid_PrevAndNext(
			long memberId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
				orderByComparator)
		throws NoSuchTeamMembersException;

	/**
	 * Removes all the team memberses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of team memberses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team memberses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the team memberses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching team memberses
	 */
	public java.util.List<TeamMembers> findByProjectId(long projectId);

	/**
	 * Returns a range of all the team memberses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @return the range of matching team memberses
	 */
	public java.util.List<TeamMembers> findByProjectId(
		long projectId, int start, int end);

	/**
	 * Returns an ordered range of all the team memberses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team memberses
	 */
	public java.util.List<TeamMembers> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the team memberses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team memberses
	 */
	public java.util.List<TeamMembers> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	public TeamMembers findByProjectId_First(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
				orderByComparator)
		throws NoSuchTeamMembersException;

	/**
	 * Returns the first team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public TeamMembers fetchByProjectId_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
			orderByComparator);

	/**
	 * Returns the last team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	public TeamMembers findByProjectId_Last(
			long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
				orderByComparator)
		throws NoSuchTeamMembersException;

	/**
	 * Returns the last team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public TeamMembers fetchByProjectId_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
			orderByComparator);

	/**
	 * Returns the team memberses before and after the current team members in the ordered set where projectId = &#63;.
	 *
	 * @param memberId the primary key of the current team members
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team members
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	public TeamMembers[] findByProjectId_PrevAndNext(
			long memberId, long projectId,
			com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
				orderByComparator)
		throws NoSuchTeamMembersException;

	/**
	 * Removes all the team memberses where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public void removeByProjectId(long projectId);

	/**
	 * Returns the number of team memberses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching team memberses
	 */
	public int countByProjectId(long projectId);

	/**
	 * Returns the team members where userId = &#63; or throws a <code>NoSuchTeamMembersException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	public TeamMembers findByUserId(long userId)
		throws NoSuchTeamMembersException;

	/**
	 * Returns the team members where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public TeamMembers fetchByUserId(long userId);

	/**
	 * Returns the team members where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public TeamMembers fetchByUserId(long userId, boolean useFinderCache);

	/**
	 * Removes the team members where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the team members that was removed
	 */
	public TeamMembers removeByUserId(long userId)
		throws NoSuchTeamMembersException;

	/**
	 * Returns the number of team memberses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching team memberses
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the team members in the entity cache if it is enabled.
	 *
	 * @param teamMembers the team members
	 */
	public void cacheResult(TeamMembers teamMembers);

	/**
	 * Caches the team memberses in the entity cache if it is enabled.
	 *
	 * @param teamMemberses the team memberses
	 */
	public void cacheResult(java.util.List<TeamMembers> teamMemberses);

	/**
	 * Creates a new team members with the primary key. Does not add the team members to the database.
	 *
	 * @param memberId the primary key for the new team members
	 * @return the new team members
	 */
	public TeamMembers create(long memberId);

	/**
	 * Removes the team members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members that was removed
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	public TeamMembers remove(long memberId) throws NoSuchTeamMembersException;

	public TeamMembers updateImpl(TeamMembers teamMembers);

	/**
	 * Returns the team members with the primary key or throws a <code>NoSuchTeamMembersException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	public TeamMembers findByPrimaryKey(long memberId)
		throws NoSuchTeamMembersException;

	/**
	 * Returns the team members with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members, or <code>null</code> if a team members with the primary key could not be found
	 */
	public TeamMembers fetchByPrimaryKey(long memberId);

	/**
	 * Returns all the team memberses.
	 *
	 * @return the team memberses
	 */
	public java.util.List<TeamMembers> findAll();

	/**
	 * Returns a range of all the team memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @return the range of team memberses
	 */
	public java.util.List<TeamMembers> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the team memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of team memberses
	 */
	public java.util.List<TeamMembers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the team memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of team memberses
	 */
	public java.util.List<TeamMembers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TeamMembers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the team memberses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of team memberses.
	 *
	 * @return the number of team memberses
	 */
	public int countAll();

}