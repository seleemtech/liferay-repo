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

package com.prime.data.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.prime.data.service.model.ProjectStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProjectStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectStatusCacheModel
	implements CacheModel<ProjectStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectStatusCacheModel)) {
			return false;
		}

		ProjectStatusCacheModel projectStatusCacheModel =
			(ProjectStatusCacheModel)object;

		if (projectStatusId == projectStatusCacheModel.projectStatusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", projectStatusId=");
		sb.append(projectStatusId);
		sb.append(", projectStatus=");
		sb.append(projectStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectStatus toEntityModel() {
		ProjectStatusImpl projectStatusImpl = new ProjectStatusImpl();

		if (uuid == null) {
			projectStatusImpl.setUuid("");
		}
		else {
			projectStatusImpl.setUuid(uuid);
		}

		projectStatusImpl.setProjectStatusId(projectStatusId);

		if (projectStatus == null) {
			projectStatusImpl.setProjectStatus("");
		}
		else {
			projectStatusImpl.setProjectStatus(projectStatus);
		}

		projectStatusImpl.resetOriginalValues();

		return projectStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		projectStatusId = objectInput.readLong();
		projectStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(projectStatusId);

		if (projectStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectStatus);
		}
	}

	public String uuid;
	public long projectStatusId;
	public String projectStatus;

}