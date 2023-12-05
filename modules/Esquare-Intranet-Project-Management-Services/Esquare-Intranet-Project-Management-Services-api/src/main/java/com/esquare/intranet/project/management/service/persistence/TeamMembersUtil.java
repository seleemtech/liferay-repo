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

import com.esquare.intranet.project.management.model.TeamMembers;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the team members service. This utility wraps <code>com.esquare.intranet.project.management.service.persistence.impl.TeamMembersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @see TeamMembersPersistence
 * @generated
 */
public class TeamMembersUtil {

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
	public static void clearCache(TeamMembers teamMembers) {
		getPersistence().clearCache(teamMembers);
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
	public static Map<Serializable, TeamMembers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TeamMembers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TeamMembers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TeamMembers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TeamMembers> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TeamMembers update(TeamMembers teamMembers) {
		return getPersistence().update(teamMembers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TeamMembers update(
		TeamMembers teamMembers, ServiceContext serviceContext) {

		return getPersistence().update(teamMembers, serviceContext);
	}

	/**
	 * Returns all the team memberses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team memberses
	 */
	public static List<TeamMembers> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<TeamMembers> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<TeamMembers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamMembers> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<TeamMembers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamMembers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	public static TeamMembers findByUuid_First(
			String uuid, OrderByComparator<TeamMembers> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTeamMembersException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public static TeamMembers fetchByUuid_First(
		String uuid, OrderByComparator<TeamMembers> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	public static TeamMembers findByUuid_Last(
			String uuid, OrderByComparator<TeamMembers> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTeamMembersException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public static TeamMembers fetchByUuid_Last(
		String uuid, OrderByComparator<TeamMembers> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the team memberses before and after the current team members in the ordered set where uuid = &#63;.
	 *
	 * @param memberId the primary key of the current team members
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team members
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	public static TeamMembers[] findByUuid_PrevAndNext(
			long memberId, String uuid,
			OrderByComparator<TeamMembers> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTeamMembersException {

		return getPersistence().findByUuid_PrevAndNext(
			memberId, uuid, orderByComparator);
	}

	/**
	 * Removes all the team memberses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of team memberses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team memberses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the team memberses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching team memberses
	 */
	public static List<TeamMembers> findByProjectId(long projectId) {
		return getPersistence().findByProjectId(projectId);
	}

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
	public static List<TeamMembers> findByProjectId(
		long projectId, int start, int end) {

		return getPersistence().findByProjectId(projectId, start, end);
	}

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
	public static List<TeamMembers> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<TeamMembers> orderByComparator) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator);
	}

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
	public static List<TeamMembers> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<TeamMembers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProjectId(
			projectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	public static TeamMembers findByProjectId_First(
			long projectId, OrderByComparator<TeamMembers> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTeamMembersException {

		return getPersistence().findByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the first team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public static TeamMembers fetchByProjectId_First(
		long projectId, OrderByComparator<TeamMembers> orderByComparator) {

		return getPersistence().fetchByProjectId_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	public static TeamMembers findByProjectId_Last(
			long projectId, OrderByComparator<TeamMembers> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTeamMembersException {

		return getPersistence().findByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public static TeamMembers fetchByProjectId_Last(
		long projectId, OrderByComparator<TeamMembers> orderByComparator) {

		return getPersistence().fetchByProjectId_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the team memberses before and after the current team members in the ordered set where projectId = &#63;.
	 *
	 * @param memberId the primary key of the current team members
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team members
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	public static TeamMembers[] findByProjectId_PrevAndNext(
			long memberId, long projectId,
			OrderByComparator<TeamMembers> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTeamMembersException {

		return getPersistence().findByProjectId_PrevAndNext(
			memberId, projectId, orderByComparator);
	}

	/**
	 * Removes all the team memberses where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public static void removeByProjectId(long projectId) {
		getPersistence().removeByProjectId(projectId);
	}

	/**
	 * Returns the number of team memberses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching team memberses
	 */
	public static int countByProjectId(long projectId) {
		return getPersistence().countByProjectId(projectId);
	}

	/**
	 * Returns the team members where userId = &#63; or throws a <code>NoSuchTeamMembersException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	public static TeamMembers findByUserId(long userId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTeamMembersException {

		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns the team members where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public static TeamMembers fetchByUserId(long userId) {
		return getPersistence().fetchByUserId(userId);
	}

	/**
	 * Returns the team members where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team members, or <code>null</code> if a matching team members could not be found
	 */
	public static TeamMembers fetchByUserId(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByUserId(userId, useFinderCache);
	}

	/**
	 * Removes the team members where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the team members that was removed
	 */
	public static TeamMembers removeByUserId(long userId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTeamMembersException {

		return getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of team memberses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching team memberses
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the team members in the entity cache if it is enabled.
	 *
	 * @param teamMembers the team members
	 */
	public static void cacheResult(TeamMembers teamMembers) {
		getPersistence().cacheResult(teamMembers);
	}

	/**
	 * Caches the team memberses in the entity cache if it is enabled.
	 *
	 * @param teamMemberses the team memberses
	 */
	public static void cacheResult(List<TeamMembers> teamMemberses) {
		getPersistence().cacheResult(teamMemberses);
	}

	/**
	 * Creates a new team members with the primary key. Does not add the team members to the database.
	 *
	 * @param memberId the primary key for the new team members
	 * @return the new team members
	 */
	public static TeamMembers create(long memberId) {
		return getPersistence().create(memberId);
	}

	/**
	 * Removes the team members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members that was removed
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	public static TeamMembers remove(long memberId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTeamMembersException {

		return getPersistence().remove(memberId);
	}

	public static TeamMembers updateImpl(TeamMembers teamMembers) {
		return getPersistence().updateImpl(teamMembers);
	}

	/**
	 * Returns the team members with the primary key or throws a <code>NoSuchTeamMembersException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	public static TeamMembers findByPrimaryKey(long memberId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchTeamMembersException {

		return getPersistence().findByPrimaryKey(memberId);
	}

	/**
	 * Returns the team members with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members, or <code>null</code> if a team members with the primary key could not be found
	 */
	public static TeamMembers fetchByPrimaryKey(long memberId) {
		return getPersistence().fetchByPrimaryKey(memberId);
	}

	/**
	 * Returns all the team memberses.
	 *
	 * @return the team memberses
	 */
	public static List<TeamMembers> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<TeamMembers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<TeamMembers> findAll(
		int start, int end, OrderByComparator<TeamMembers> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<TeamMembers> findAll(
		int start, int end, OrderByComparator<TeamMembers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the team memberses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of team memberses.
	 *
	 * @return the number of team memberses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TeamMembersPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TeamMembersPersistence _persistence;

}