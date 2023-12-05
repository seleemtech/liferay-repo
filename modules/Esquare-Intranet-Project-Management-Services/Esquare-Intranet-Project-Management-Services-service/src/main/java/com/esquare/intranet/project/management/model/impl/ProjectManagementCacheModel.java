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

import com.esquare.intranet.project.management.model.ProjectManagement;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProjectManagement in entity cache.
 *
 * @author Mahammed Seleem
 * @generated
 */
public class ProjectManagementCacheModel
	implements CacheModel<ProjectManagement>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectManagementCacheModel)) {
			return false;
		}

		ProjectManagementCacheModel projectManagementCacheModel =
			(ProjectManagementCacheModel)object;

		if (projectMgmtId == projectManagementCacheModel.projectMgmtId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectMgmtId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", projectMgmtId=");
		sb.append(projectMgmtId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", contactEmail=");
		sb.append(contactEmail);
		sb.append(", projectName=");
		sb.append(projectName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectManagement toEntityModel() {
		ProjectManagementImpl projectManagementImpl =
			new ProjectManagementImpl();

		if (uuid == null) {
			projectManagementImpl.setUuid("");
		}
		else {
			projectManagementImpl.setUuid(uuid);
		}

		projectManagementImpl.setProjectMgmtId(projectMgmtId);

		if (name == null) {
			projectManagementImpl.setName("");
		}
		else {
			projectManagementImpl.setName(name);
		}

		if (contactNumber == null) {
			projectManagementImpl.setContactNumber("");
		}
		else {
			projectManagementImpl.setContactNumber(contactNumber);
		}

		if (contactEmail == null) {
			projectManagementImpl.setContactEmail("");
		}
		else {
			projectManagementImpl.setContactEmail(contactEmail);
		}

		if (projectName == null) {
			projectManagementImpl.setProjectName("");
		}
		else {
			projectManagementImpl.setProjectName(projectName);
		}

		if (description == null) {
			projectManagementImpl.setDescription("");
		}
		else {
			projectManagementImpl.setDescription(description);
		}

		projectManagementImpl.setGroupId(groupId);
		projectManagementImpl.setCompanyId(companyId);
		projectManagementImpl.setUserId(userId);

		if (userName == null) {
			projectManagementImpl.setUserName("");
		}
		else {
			projectManagementImpl.setUserName(userName);
		}

		projectManagementImpl.resetOriginalValues();

		return projectManagementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		projectMgmtId = objectInput.readLong();
		name = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		contactEmail = objectInput.readUTF();
		projectName = objectInput.readUTF();
		description = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(projectMgmtId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}

		if (contactEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactEmail);
		}

		if (projectName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectName);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}
	}

	public String uuid;
	public long projectMgmtId;
	public String name;
	public String contactNumber;
	public String contactEmail;
	public String projectName;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;

}