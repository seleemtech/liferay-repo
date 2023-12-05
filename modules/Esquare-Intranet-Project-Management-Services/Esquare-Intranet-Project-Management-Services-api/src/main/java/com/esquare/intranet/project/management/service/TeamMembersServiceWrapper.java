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
 * Provides a wrapper for {@link TeamMembersService}.
 *
 * @author Mahammed Seleem
 * @see TeamMembersService
 * @generated
 */
public class TeamMembersServiceWrapper
	implements ServiceWrapper<TeamMembersService>, TeamMembersService {

	public TeamMembersServiceWrapper() {
		this(null);
	}

	public TeamMembersServiceWrapper(TeamMembersService teamMembersService) {
		_teamMembersService = teamMembersService;
	}

	@Override
	public String getAssignedMemberName(long memberId) {
		return _teamMembersService.getAssignedMemberName(memberId);
	}

	@Override
	public String getMemberNameByUserId(long userId) {
		return _teamMembersService.getMemberNameByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _teamMembersService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List
		<com.esquare.intranet.project.management.model.TeamMembers>
			getTeamMembersByProjectId(long projectId) {

		return _teamMembersService.getTeamMembersByProjectId(projectId);
	}

	@Override
	public TeamMembersService getWrappedService() {
		return _teamMembersService;
	}

	@Override
	public void setWrappedService(TeamMembersService teamMembersService) {
		_teamMembersService = teamMembersService;
	}

	private TeamMembersService _teamMembersService;

}