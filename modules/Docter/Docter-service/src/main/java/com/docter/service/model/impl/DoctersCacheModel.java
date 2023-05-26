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

package com.docter.service.model.impl;

import com.docter.service.model.Docters;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Docters in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DoctersCacheModel implements CacheModel<Docters>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DoctersCacheModel)) {
			return false;
		}

		DoctersCacheModel doctersCacheModel = (DoctersCacheModel)object;

		if (docterId == doctersCacheModel.docterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, docterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", docterId=");
		sb.append(docterId);
		sb.append(", docterName=");
		sb.append(docterName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Docters toEntityModel() {
		DoctersImpl doctersImpl = new DoctersImpl();

		if (uuid == null) {
			doctersImpl.setUuid("");
		}
		else {
			doctersImpl.setUuid(uuid);
		}

		doctersImpl.setDocterId(docterId);

		if (docterName == null) {
			doctersImpl.setDocterName("");
		}
		else {
			doctersImpl.setDocterName(docterName);
		}

		doctersImpl.setGroupId(groupId);
		doctersImpl.setCompanyId(companyId);
		doctersImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			doctersImpl.setCreateDate(null);
		}
		else {
			doctersImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			doctersImpl.setModifiedDate(null);
		}
		else {
			doctersImpl.setModifiedDate(new Date(modifiedDate));
		}

		doctersImpl.setStatus(status);
		doctersImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			doctersImpl.setStatusByUserName("");
		}
		else {
			doctersImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			doctersImpl.setStatusDate(null);
		}
		else {
			doctersImpl.setStatusDate(new Date(statusDate));
		}

		doctersImpl.resetOriginalValues();

		return doctersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		docterId = objectInput.readLong();
		docterName = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(docterId);

		if (docterName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(docterName);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long docterId;
	public String docterName;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}