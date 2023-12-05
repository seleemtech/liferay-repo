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

package com.esquare.intranet.project.management.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TeamMembers}.
 * </p>
 *
 * @author Mahammed Seleem
 * @see TeamMembers
 * @generated
 */
public class TeamMembersWrapper
	extends BaseModelWrapper<TeamMembers>
	implements ModelWrapper<TeamMembers>, TeamMembers {

	public TeamMembersWrapper(TeamMembers teamMembers) {
		super(teamMembers);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("memberId", getMemberId());
		attributes.put("name", getName());
		attributes.put("memberRole", getMemberRole());
		attributes.put("userId", getUserId());
		attributes.put("projectId", getProjectId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String memberRole = (String)attributes.get("memberRole");

		if (memberRole != null) {
			setMemberRole(memberRole);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}
	}

	@Override
	public TeamMembers cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the member ID of this team members.
	 *
	 * @return the member ID of this team members
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the member role of this team members.
	 *
	 * @return the member role of this team members
	 */
	@Override
	public String getMemberRole() {
		return model.getMemberRole();
	}

	/**
	 * Returns the name of this team members.
	 *
	 * @return the name of this team members
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this team members.
	 *
	 * @return the primary key of this team members
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this team members.
	 *
	 * @return the project ID of this team members
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the user ID of this team members.
	 *
	 * @return the user ID of this team members
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this team members.
	 *
	 * @return the user uuid of this team members
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this team members.
	 *
	 * @return the uuid of this team members
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the member ID of this team members.
	 *
	 * @param memberId the member ID of this team members
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the member role of this team members.
	 *
	 * @param memberRole the member role of this team members
	 */
	@Override
	public void setMemberRole(String memberRole) {
		model.setMemberRole(memberRole);
	}

	/**
	 * Sets the name of this team members.
	 *
	 * @param name the name of this team members
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this team members.
	 *
	 * @param primaryKey the primary key of this team members
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this team members.
	 *
	 * @param projectId the project ID of this team members
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the user ID of this team members.
	 *
	 * @param userId the user ID of this team members
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this team members.
	 *
	 * @param userUuid the user uuid of this team members
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this team members.
	 *
	 * @param uuid the uuid of this team members
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TeamMembersWrapper wrap(TeamMembers teamMembers) {
		return new TeamMembersWrapper(teamMembers);
	}

}