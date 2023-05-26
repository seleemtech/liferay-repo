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

import com.prime.data.service.model.DocumentMapper;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DocumentMapper in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentMapperCacheModel
	implements CacheModel<DocumentMapper>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentMapperCacheModel)) {
			return false;
		}

		DocumentMapperCacheModel documentMapperCacheModel =
			(DocumentMapperCacheModel)object;

		if (recordId == documentMapperCacheModel.recordId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, recordId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", recordId=");
		sb.append(recordId);
		sb.append(", moduleName=");
		sb.append(moduleName);
		sb.append(", classPk=");
		sb.append(classPk);
		sb.append(", documentName=");
		sb.append(documentName);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DocumentMapper toEntityModel() {
		DocumentMapperImpl documentMapperImpl = new DocumentMapperImpl();

		if (uuid == null) {
			documentMapperImpl.setUuid("");
		}
		else {
			documentMapperImpl.setUuid(uuid);
		}

		documentMapperImpl.setRecordId(recordId);

		if (moduleName == null) {
			documentMapperImpl.setModuleName("");
		}
		else {
			documentMapperImpl.setModuleName(moduleName);
		}

		documentMapperImpl.setClassPk(classPk);

		if (documentName == null) {
			documentMapperImpl.setDocumentName("");
		}
		else {
			documentMapperImpl.setDocumentName(documentName);
		}

		documentMapperImpl.setDocumentId(documentId);

		if (createdDate == Long.MIN_VALUE) {
			documentMapperImpl.setCreatedDate(null);
		}
		else {
			documentMapperImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentMapperImpl.setModifiedDate(null);
		}
		else {
			documentMapperImpl.setModifiedDate(new Date(modifiedDate));
		}

		documentMapperImpl.setUserId(userId);

		documentMapperImpl.resetOriginalValues();

		return documentMapperImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		recordId = objectInput.readLong();
		moduleName = objectInput.readUTF();

		classPk = objectInput.readLong();
		documentName = objectInput.readUTF();

		documentId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(recordId);

		if (moduleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moduleName);
		}

		objectOutput.writeLong(classPk);

		if (documentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentName);
		}

		objectOutput.writeLong(documentId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(userId);
	}

	public String uuid;
	public long recordId;
	public String moduleName;
	public long classPk;
	public String documentName;
	public long documentId;
	public long createdDate;
	public long modifiedDate;
	public long userId;

}