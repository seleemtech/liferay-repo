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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TeamMembers service. Represents a row in the &quot;Esquare_TeamMembers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.esquare.intranet.project.management.model.impl.TeamMembersModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.esquare.intranet.project.management.model.impl.TeamMembersImpl</code>.
 * </p>
 *
 * @author Mahammed Seleem
 * @see TeamMembers
 * @generated
 */
@ProviderType
public interface TeamMembersModel extends BaseModel<TeamMembers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a team members model instance should use the {@link TeamMembers} interface instead.
	 */

	/**
	 * Returns the primary key of this team members.
	 *
	 * @return the primary key of this team members
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this team members.
	 *
	 * @param primaryKey the primary key of this team members
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this team members.
	 *
	 * @return the uuid of this team members
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this team members.
	 *
	 * @param uuid the uuid of this team members
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the member ID of this team members.
	 *
	 * @return the member ID of this team members
	 */
	public long getMemberId();

	/**
	 * Sets the member ID of this team members.
	 *
	 * @param memberId the member ID of this team members
	 */
	public void setMemberId(long memberId);

	/**
	 * Returns the name of this team members.
	 *
	 * @return the name of this team members
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this team members.
	 *
	 * @param name the name of this team members
	 */
	public void setName(String name);

	/**
	 * Returns the member role of this team members.
	 *
	 * @return the member role of this team members
	 */
	@AutoEscape
	public String getMemberRole();

	/**
	 * Sets the member role of this team members.
	 *
	 * @param memberRole the member role of this team members
	 */
	public void setMemberRole(String memberRole);

	/**
	 * Returns the user ID of this team members.
	 *
	 * @return the user ID of this team members
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this team members.
	 *
	 * @param userId the user ID of this team members
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this team members.
	 *
	 * @return the user uuid of this team members
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this team members.
	 *
	 * @param userUuid the user uuid of this team members
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the project ID of this team members.
	 *
	 * @return the project ID of this team members
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this team members.
	 *
	 * @param projectId the project ID of this team members
	 */
	public void setProjectId(long projectId);

	@Override
	public TeamMembers cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}