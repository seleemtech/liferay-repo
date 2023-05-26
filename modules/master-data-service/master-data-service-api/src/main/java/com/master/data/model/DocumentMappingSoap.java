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

package com.master.data.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.master.data.service.http.DocumentMappingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DocumentMappingSoap implements Serializable {

	public static DocumentMappingSoap toSoapModel(DocumentMapping model) {
		DocumentMappingSoap soapModel = new DocumentMappingSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRecordId(model.getRecordId());
		soapModel.setModuleName(model.getModuleName());
		soapModel.setClassPk(model.getClassPk());
		soapModel.setDocumentName(model.getDocumentName());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static DocumentMappingSoap[] toSoapModels(DocumentMapping[] models) {
		DocumentMappingSoap[] soapModels =
			new DocumentMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocumentMappingSoap[][] toSoapModels(
		DocumentMapping[][] models) {

		DocumentMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DocumentMappingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocumentMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocumentMappingSoap[] toSoapModels(
		List<DocumentMapping> models) {

		List<DocumentMappingSoap> soapModels =
			new ArrayList<DocumentMappingSoap>(models.size());

		for (DocumentMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DocumentMappingSoap[soapModels.size()]);
	}

	public DocumentMappingSoap() {
	}

	public long getPrimaryKey() {
		return _recordId;
	}

	public void setPrimaryKey(long pk) {
		setRecordId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRecordId() {
		return _recordId;
	}

	public void setRecordId(long recordId) {
		_recordId = recordId;
	}

	public String getModuleName() {
		return _moduleName;
	}

	public void setModuleName(String moduleName) {
		_moduleName = moduleName;
	}

	public long getClassPk() {
		return _classPk;
	}

	public void setClassPk(long classPk) {
		_classPk = classPk;
	}

	public String getDocumentName() {
		return _documentName;
	}

	public void setDocumentName(String documentName) {
		_documentName = documentName;
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private String _uuid;
	private long _recordId;
	private String _moduleName;
	private long _classPk;
	private String _documentName;
	private long _documentId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _userId;

}