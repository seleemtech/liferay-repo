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

package com.esquare.intranet.project.management.model.impl;

import com.esquare.intranet.project.management.model.TeamMembers;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TeamMembers in entity cache.
 *
 * @author Mahammed Seleem
 * @generated
 */
public class TeamMembersCacheModel
	implements CacheModel<TeamMembers>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TeamMembersCacheModel)) {
			return false;
		}

		TeamMembersCacheModel teamMembersCacheModel =
			(TeamMembersCacheModel)object;

		if (memberId == teamMembersCacheModel.memberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, memberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", memberId=");
		sb.append(memberId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", memberRole=");
		sb.append(memberRole);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TeamMembers toEntityModel() {
		TeamMembersImpl teamMembersImpl = new TeamMembersImpl();

		if (uuid == null) {
			teamMembersImpl.setUuid("");
		}
		else {
			teamMembersImpl.setUuid(uuid);
		}

		teamMembersImpl.setMemberId(memberId);

		if (name == null) {
			teamMembersImpl.setName("");
		}
		else {
			teamMembersImpl.setName(name);
		}

		if (memberRole == null) {
			teamMembersImpl.setMemberRole("");
		}
		else {
			teamMembersImpl.setMemberRole(memberRole);
		}

		teamMembersImpl.setUserId(userId);
		teamMembersImpl.setProjectId(projectId);

		teamMembersImpl.resetOriginalValues();

		return teamMembersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		memberId = objectInput.readLong();
		name = objectInput.readUTF();
		memberRole = objectInput.readUTF();

		userId = objectInput.readLong();

		projectId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(memberId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (memberRole == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(memberRole);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(projectId);
	}

	public String uuid;
	public long memberId;
	public String name;
	public String memberRole;
	public long userId;
	public long projectId;

}