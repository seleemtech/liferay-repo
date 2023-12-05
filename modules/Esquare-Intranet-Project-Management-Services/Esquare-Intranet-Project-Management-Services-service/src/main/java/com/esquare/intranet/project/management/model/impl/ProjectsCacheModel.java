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

import com.esquare.intranet.project.management.model.Projects;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Projects in entity cache.
 *
 * @author Mahammed Seleem
 * @generated
 */
public class ProjectsCacheModel
	implements CacheModel<Projects>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectsCacheModel)) {
			return false;
		}

		ProjectsCacheModel projectsCacheModel = (ProjectsCacheModel)object;

		if (projectId == projectsCacheModel.projectId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", projectName=");
		sb.append(projectName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", proposedDate=");
		sb.append(proposedDate);
		sb.append(", confirmedDate=");
		sb.append(confirmedDate);
		sb.append(", developmentStartDate=");
		sb.append(developmentStartDate);
		sb.append(", estimatedDate=");
		sb.append(estimatedDate);
		sb.append(", durationDate=");
		sb.append(durationDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", code=");
		sb.append(code);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", resourceIdSettings=");
		sb.append(resourceIdSettings);
		sb.append(", name=");
		sb.append(name);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", contactEmail=");
		sb.append(contactEmail);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Projects toEntityModel() {
		ProjectsImpl projectsImpl = new ProjectsImpl();

		if (uuid == null) {
			projectsImpl.setUuid("");
		}
		else {
			projectsImpl.setUuid(uuid);
		}

		projectsImpl.setProjectId(projectId);
		projectsImpl.setGroupId(groupId);
		projectsImpl.setCompanyId(companyId);
		projectsImpl.setUserId(userId);

		if (userName == null) {
			projectsImpl.setUserName("");
		}
		else {
			projectsImpl.setUserName(userName);
		}

		if (projectName == null) {
			projectsImpl.setProjectName("");
		}
		else {
			projectsImpl.setProjectName(projectName);
		}

		if (description == null) {
			projectsImpl.setDescription("");
		}
		else {
			projectsImpl.setDescription(description);
		}

		if (proposedDate == Long.MIN_VALUE) {
			projectsImpl.setProposedDate(null);
		}
		else {
			projectsImpl.setProposedDate(new Date(proposedDate));
		}

		if (confirmedDate == Long.MIN_VALUE) {
			projectsImpl.setConfirmedDate(null);
		}
		else {
			projectsImpl.setConfirmedDate(new Date(confirmedDate));
		}

		if (developmentStartDate == Long.MIN_VALUE) {
			projectsImpl.setDevelopmentStartDate(null);
		}
		else {
			projectsImpl.setDevelopmentStartDate(
				new Date(developmentStartDate));
		}

		if (estimatedDate == Long.MIN_VALUE) {
			projectsImpl.setEstimatedDate(null);
		}
		else {
			projectsImpl.setEstimatedDate(new Date(estimatedDate));
		}

		if (durationDate == null) {
			projectsImpl.setDurationDate("");
		}
		else {
			projectsImpl.setDurationDate(durationDate);
		}

		projectsImpl.setStatus(status);
		projectsImpl.setCode(code);
		projectsImpl.setDocumentId(documentId);

		if (resourceIdSettings == null) {
			projectsImpl.setResourceIdSettings("");
		}
		else {
			projectsImpl.setResourceIdSettings(resourceIdSettings);
		}

		if (name == null) {
			projectsImpl.setName("");
		}
		else {
			projectsImpl.setName(name);
		}

		if (contactNumber == null) {
			projectsImpl.setContactNumber("");
		}
		else {
			projectsImpl.setContactNumber(contactNumber);
		}

		if (contactEmail == null) {
			projectsImpl.setContactEmail("");
		}
		else {
			projectsImpl.setContactEmail(contactEmail);
		}

		projectsImpl.resetOriginalValues();

		return projectsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		projectId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		projectName = objectInput.readUTF();
		description = objectInput.readUTF();
		proposedDate = objectInput.readLong();
		confirmedDate = objectInput.readLong();
		developmentStartDate = objectInput.readLong();
		estimatedDate = objectInput.readLong();
		durationDate = objectInput.readUTF();

		status = objectInput.readInt();

		code = objectInput.readInt();

		documentId = objectInput.readLong();
		resourceIdSettings = objectInput.readUTF();
		name = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		contactEmail = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
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

		objectOutput.writeLong(proposedDate);
		objectOutput.writeLong(confirmedDate);
		objectOutput.writeLong(developmentStartDate);
		objectOutput.writeLong(estimatedDate);

		if (durationDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(durationDate);
		}

		objectOutput.writeInt(status);

		objectOutput.writeInt(code);

		objectOutput.writeLong(documentId);

		if (resourceIdSettings == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(resourceIdSettings);
		}

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
	}

	public String uuid;
	public long projectId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public String projectName;
	public String description;
	public long proposedDate;
	public long confirmedDate;
	public long developmentStartDate;
	public long estimatedDate;
	public String durationDate;
	public int status;
	public int code;
	public long documentId;
	public String resourceIdSettings;
	public String name;
	public String contactNumber;
	public String contactEmail;

}