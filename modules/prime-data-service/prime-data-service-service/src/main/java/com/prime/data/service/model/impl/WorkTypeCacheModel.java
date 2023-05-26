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

import com.prime.data.service.model.WorkType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WorkType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkTypeCacheModel
	implements CacheModel<WorkType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkTypeCacheModel)) {
			return false;
		}

		WorkTypeCacheModel workTypeCacheModel = (WorkTypeCacheModel)object;

		if (workTypeId == workTypeCacheModel.workTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", workTypeId=");
		sb.append(workTypeId);
		sb.append(", workTypeName=");
		sb.append(workTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkType toEntityModel() {
		WorkTypeImpl workTypeImpl = new WorkTypeImpl();

		if (uuid == null) {
			workTypeImpl.setUuid("");
		}
		else {
			workTypeImpl.setUuid(uuid);
		}

		workTypeImpl.setWorkTypeId(workTypeId);

		if (workTypeName == null) {
			workTypeImpl.setWorkTypeName("");
		}
		else {
			workTypeImpl.setWorkTypeName(workTypeName);
		}

		workTypeImpl.resetOriginalValues();

		return workTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		workTypeId = objectInput.readLong();
		workTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(workTypeId);

		if (workTypeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workTypeName);
		}
	}

	public String uuid;
	public long workTypeId;
	public String workTypeName;

}