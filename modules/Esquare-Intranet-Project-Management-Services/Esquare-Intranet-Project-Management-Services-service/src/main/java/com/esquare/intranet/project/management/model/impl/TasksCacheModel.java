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

import com.esquare.intranet.project.management.model.Tasks;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Tasks in entity cache.
 *
 * @author Mahammed Seleem
 * @generated
 */
public class TasksCacheModel implements CacheModel<Tasks>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TasksCacheModel)) {
			return false;
		}

		TasksCacheModel tasksCacheModel = (TasksCacheModel)object;

		if (taskId == tasksCacheModel.taskId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", taskId=");
		sb.append(taskId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", developerTeam=");
		sb.append(developerTeam);
		sb.append(", testerTeam=");
		sb.append(testerTeam);
		sb.append(", taskStartDate=");
		sb.append(taskStartDate);
		sb.append(", taskEndDate=");
		sb.append(taskEndDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Tasks toEntityModel() {
		TasksImpl tasksImpl = new TasksImpl();

		if (uuid == null) {
			tasksImpl.setUuid("");
		}
		else {
			tasksImpl.setUuid(uuid);
		}

		tasksImpl.setTaskId(taskId);

		if (name == null) {
			tasksImpl.setName("");
		}
		else {
			tasksImpl.setName(name);
		}

		if (description == null) {
			tasksImpl.setDescription("");
		}
		else {
			tasksImpl.setDescription(description);
		}

		if (developerTeam == null) {
			tasksImpl.setDeveloperTeam("");
		}
		else {
			tasksImpl.setDeveloperTeam(developerTeam);
		}

		if (testerTeam == null) {
			tasksImpl.setTesterTeam("");
		}
		else {
			tasksImpl.setTesterTeam(testerTeam);
		}

		if (taskStartDate == Long.MIN_VALUE) {
			tasksImpl.setTaskStartDate(null);
		}
		else {
			tasksImpl.setTaskStartDate(new Date(taskStartDate));
		}

		if (taskEndDate == Long.MIN_VALUE) {
			tasksImpl.setTaskEndDate(null);
		}
		else {
			tasksImpl.setTaskEndDate(new Date(taskEndDate));
		}

		tasksImpl.setStatus(status);
		tasksImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			tasksImpl.setStatusByUserName("");
		}
		else {
			tasksImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			tasksImpl.setStatusDate(null);
		}
		else {
			tasksImpl.setStatusDate(new Date(statusDate));
		}

		tasksImpl.setProjectId(projectId);

		tasksImpl.resetOriginalValues();

		return tasksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		taskId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		developerTeam = objectInput.readUTF();
		testerTeam = objectInput.readUTF();
		taskStartDate = objectInput.readLong();
		taskEndDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

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

		objectOutput.writeLong(taskId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (developerTeam == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(developerTeam);
		}

		if (testerTeam == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testerTeam);
		}

		objectOutput.writeLong(taskStartDate);
		objectOutput.writeLong(taskEndDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(projectId);
	}

	public String uuid;
	public long taskId;
	public String name;
	public String description;
	public String developerTeam;
	public String testerTeam;
	public long taskStartDate;
	public long taskEndDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long projectId;

}