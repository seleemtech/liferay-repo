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

import com.esquare.intranet.project.management.exception.NoSuchTeamMembersException;
import com.esquare.intranet.project.management.model.TeamMembers;
import com.esquare.intranet.project.management.service.base.TeamMembersServiceBaseImpl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Mahammed Seleem
 */
@Component(
        property = {
                "json.web.service.context.name=esquare",
                "json.web.service.context.path=TeamMembers"
        },
        service = AopService.class
)
public class TeamMembersServiceImpl extends TeamMembersServiceBaseImpl {

    public String getAssignedMemberName(long memberId) {
        String memberName = StringPool.BLANK;
        if (memberId > 0) {
            try {
                TeamMembers teamMembers = teamMembersPersistence.findByPrimaryKey(memberId);
                memberName = teamMembers.getName();
            } catch (NoSuchTeamMembersException e) {
                throw new RuntimeException(e);
            }
        }
        return memberName;
    }

    public String getMemberNameByUserId(long userId) {
        String memberName = StringPool.BLANK;
        if (userId > 0) {
            TeamMembers teamMembers = teamMembersLocalService.getTeamMemberByUserId(userId);
            memberName = teamMembers.getName();
        }
        return memberName;
    }

    public List<TeamMembers> getTeamMembersByProjectId(long projectId) {
        return teamMembersPersistence.findByProjectId(projectId);
    }
}