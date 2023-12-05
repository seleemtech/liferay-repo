/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.esquare.intranet.project.management.service.impl;

import com.esquare.intranet.project.management.model.TeamMembers;
import com.esquare.intranet.project.management.service.base.TeamMembersLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Mahammed Seleem
 */
@Component(
        property = "model.class.name=com.esquare.intranet.project.management.model.TeamMembers",
        service = AopService.class
)
public class TeamMembersLocalServiceImpl
        extends TeamMembersLocalServiceBaseImpl {

    public TeamMembers addTeamMenber(String roleName, long userId, String Name, long projectId) throws PortalException {
        TeamMembers teamMembers = teamMembersPersistence.create(counterLocalService.increment());
        teamMembers.setMemberRole(roleName);
        teamMembers.setName(Name);
        teamMembers.setProjectId(projectId);
        teamMembers.setUserId(userId);
        teamMembersPersistence.update(teamMembers);
        return teamMembers;
    }

    public List<TeamMembers> getTeamMembersByProjectId(long projectId) {
        return teamMembersPersistence.findByProjectId(projectId);
    }

    public TeamMembers getTeamMemberByUserId(long userId) {
        return teamMembersPersistence.fetchByUserId(userId);
    }
}