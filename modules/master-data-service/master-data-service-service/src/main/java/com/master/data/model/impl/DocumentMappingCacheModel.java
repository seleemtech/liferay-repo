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

package com.master.data.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.master.data.model.DocumentMapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DocumentMapping in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DocumentMappingCacheModel
	implements CacheModel<DocumentMapping>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DocumentMappingCacheModel)) {
			return false;
		}

		DocumentMappingCacheModel documentMappingCacheModel =
			(DocumentMappingCacheModel)object;

		if (recordId == documentMappingCacheModel.recordId) {
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
	public DocumentMapping toEntityModel() {
		DocumentMappingImpl documentMappingImpl = new DocumentMappingImpl();

		if (uuid == null) {
			documentMappingImpl.setUuid("");
		}
		else {
			documentMappingImpl.setUuid(uuid);
		}

		documentMappingImpl.setRecordId(recordId);

		if (moduleName == null) {
			documentMappingImpl.setModuleName("");
		}
		else {
			documentMappingImpl.setModuleName(moduleName);
		}

		documentMappingImpl.setClassPk(classPk);

		if (documentName == null) {
			documentMappingImpl.setDocumentName("");
		}
		else {
			documentMappingImpl.setDocumentName(documentName);
		}

		documentMappingImpl.setDocumentId(documentId);

		if (createdDate == Long.MIN_VALUE) {
			documentMappingImpl.setCreatedDate(null);
		}
		else {
			documentMappingImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentMappingImpl.setModifiedDate(null);
		}
		else {
			documentMappingImpl.setModifiedDate(new Date(modifiedDate));
		}

		documentMappingImpl.setUserId(userId);

		documentMappingImpl.resetOriginalValues();

		return documentMappingImpl;
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