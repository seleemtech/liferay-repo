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
 * Provides a wrapper for {@link TeamMembersLocalService}.
 *
 * @author Mahammed Seleem
 * @see TeamMembersLocalService
 * @generated
 */
public class TeamMembersLocalServiceWrapper
	implements ServiceWrapper<TeamMembersLocalService>,
			   TeamMembersLocalService {

	public TeamMembersLocalServiceWrapper() {
		this(null);
	}

	public TeamMembersLocalServiceWrapper(
		TeamMembersLocalService teamMembersLocalService) {

		_teamMembersLocalService = teamMembersLocalService;
	}

	/**
	 * Adds the team members to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMembersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMembers the team members
	 * @return the team members that was added
	 */
	@Override
	public com.esquare.intranet.project.management.model.TeamMembers
		addTeamMembers(
			com.esquare.intranet.project.management.model.TeamMembers
				teamMembers) {

		return _teamMembersLocalService.addTeamMembers(teamMembers);
	}

	@Override
	public com.esquare.intranet.project.management.model.TeamMembers
			addTeamMenber(
				String roleName, long userId, String Name, long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMembersLocalService.addTeamMenber(
			roleName, userId, Name, projectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMembersLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new team members with the primary key. Does not add the team members to the database.
	 *
	 * @param memberId the primary key for the new team members
	 * @return the new team members
	 */
	@Override
	public com.esquare.intranet.project.management.model.TeamMembers
		createTeamMembers(long memberId) {

		return _teamMembersLocalService.createTeamMembers(memberId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMembersLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the team members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMembersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members that was removed
	 * @throws PortalException if a team members with the primary key could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.TeamMembers
			deleteTeamMembers(long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMembersLocalService.deleteTeamMembers(memberId);
	}

	/**
	 * Deletes the team members from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMembersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMembers the team members
	 * @return the team members that was removed
	 */
	@Override
	public com.esquare.intranet.project.management.model.TeamMembers
		deleteTeamMembers(
			com.esquare.intranet.project.management.model.TeamMembers
				teamMembers) {

		return _teamMembersLocalService.deleteTeamMembers(teamMembers);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _teamMembersLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _teamMembersLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _teamMembersLocalService.dynamicQuery();
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

		return _teamMembersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.TeamMembersModelImpl</code>.
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

		return _teamMembersLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.TeamMembersModelImpl</code>.
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

		return _teamMembersLocalService.dynamicQuery(
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

		return _teamMembersLocalService.dynamicQueryCount(dynamicQuery);
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

		return _teamMembersLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esquare.intranet.project.management.model.TeamMembers
		fetchTeamMembers(long memberId) {

		return _teamMembersLocalService.fetchTeamMembers(memberId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _teamMembersLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _teamMembersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _teamMembersLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMembersLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.esquare.intranet.project.management.model.TeamMembers
		getTeamMemberByUserId(long userId) {

		return _teamMembersLocalService.getTeamMemberByUserId(userId);
	}

	/**
	 * Returns the team members with the primary key.
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members
	 * @throws PortalException if a team members with the primary key could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.TeamMembers
			getTeamMembers(long memberId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teamMembersLocalService.getTeamMembers(memberId);
	}

	@Override
	public java.util.List
		<com.esquare.intranet.project.management.model.TeamMembers>
			getTeamMembersByProjectId(long projectId) {

		return _teamMembersLocalService.getTeamMembersByProjectId(projectId);
	}

	/**
	 * Returns a range of all the team memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @return the range of team memberses
	 */
	@Override
	public java.util.List
		<com.esquare.intranet.project.management.model.TeamMembers>
			getTeamMemberses(int start, int end) {

		return _teamMembersLocalService.getTeamMemberses(start, end);
	}

	/**
	 * Returns the number of team memberses.
	 *
	 * @return the number of team memberses
	 */
	@Override
	public int getTeamMembersesCount() {
		return _teamMembersLocalService.getTeamMembersesCount();
	}

	/**
	 * Updates the team members in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeamMembersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teamMembers the team members
	 * @return the team members that was updated
	 */
	@Override
	public com.esquare.intranet.project.management.model.TeamMembers
		updateTeamMembers(
			com.esquare.intranet.project.management.model.TeamMembers
				teamMembers) {

		return _teamMembersLocalService.updateTeamMembers(teamMembers);
	}

	@Override
	public TeamMembersLocalService getWrappedService() {
		return _teamMembersLocalService;
	}

	@Override
	public void setWrappedService(
		TeamMembersLocalService teamMembersLocalService) {

		_teamMembersLocalService = teamMembersLocalService;
	}

	private TeamMembersLocalService _teamMembersLocalService;

}