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

import com.prime.data.service.model.Priority;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Priority in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PriorityCacheModel
	implements CacheModel<Priority>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PriorityCacheModel)) {
			return false;
		}

		PriorityCacheModel priorityCacheModel = (PriorityCacheModel)object;

		if (priorityId == priorityCacheModel.priorityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, priorityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", priorityId=");
		sb.append(priorityId);
		sb.append(", priorityName=");
		sb.append(priorityName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Priority toEntityModel() {
		PriorityImpl priorityImpl = new PriorityImpl();

		if (uuid == null) {
			priorityImpl.setUuid("");
		}
		else {
			priorityImpl.setUuid(uuid);
		}

		priorityImpl.setPriorityId(priorityId);

		if (priorityName == null) {
			priorityImpl.setPriorityName("");
		}
		else {
			priorityImpl.setPriorityName(priorityName);
		}

		priorityImpl.resetOriginalValues();

		return priorityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		priorityId = objectInput.readLong();
		priorityName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(priorityId);

		if (priorityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(priorityName);
		}
	}

	public String uuid;
	public long priorityId;
	public String priorityName;

}