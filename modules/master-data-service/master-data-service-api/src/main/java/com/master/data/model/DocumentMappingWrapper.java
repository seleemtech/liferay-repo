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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DocumentMapping}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMapping
 * @generated
 */
public class DocumentMappingWrapper
	extends BaseModelWrapper<DocumentMapping>
	implements DocumentMapping, ModelWrapper<DocumentMapping> {

	public DocumentMappingWrapper(DocumentMapping documentMapping) {
		super(documentMapping);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("recordId", getRecordId());
		attributes.put("moduleName", getModuleName());
		attributes.put("classPk", getClassPk());
		attributes.put("documentName", getDocumentName());
		attributes.put("documentId", getDocumentId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long recordId = (Long)attributes.get("recordId");

		if (recordId != null) {
			setRecordId(recordId);
		}

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}

		Long classPk = (Long)attributes.get("classPk");

		if (classPk != null) {
			setClassPk(classPk);
		}

		String documentName = (String)attributes.get("documentName");

		if (documentName != null) {
			setDocumentName(documentName);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public DocumentMapping cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the class pk of this document mapping.
	 *
	 * @return the class pk of this document mapping
	 */
	@Override
	public long getClassPk() {
		return model.getClassPk();
	}

	/**
	 * Returns the created date of this document mapping.
	 *
	 * @return the created date of this document mapping
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the document ID of this document mapping.
	 *
	 * @return the document ID of this document mapping
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the document name of this document mapping.
	 *
	 * @return the document name of this document mapping
	 */
	@Override
	public String getDocumentName() {
		return model.getDocumentName();
	}

	/**
	 * Returns the modified date of this document mapping.
	 *
	 * @return the modified date of this document mapping
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the module name of this document mapping.
	 *
	 * @return the module name of this document mapping
	 */
	@Override
	public String getModuleName() {
		return model.getModuleName();
	}

	/**
	 * Returns the primary key of this document mapping.
	 *
	 * @return the primary key of this document mapping
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the record ID of this document mapping.
	 *
	 * @return the record ID of this document mapping
	 */
	@Override
	public long getRecordId() {
		return model.getRecordId();
	}

	/**
	 * Returns the user ID of this document mapping.
	 *
	 * @return the user ID of this document mapping
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this document mapping.
	 *
	 * @return the user uuid of this document mapping
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this document mapping.
	 *
	 * @return the uuid of this document mapping
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the class pk of this document mapping.
	 *
	 * @param classPk the class pk of this document mapping
	 */
	@Override
	public void setClassPk(long classPk) {
		model.setClassPk(classPk);
	}

	/**
	 * Sets the created date of this document mapping.
	 *
	 * @param createdDate the created date of this document mapping
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the document ID of this document mapping.
	 *
	 * @param documentId the document ID of this document mapping
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the document name of this document mapping.
	 *
	 * @param documentName the document name of this document mapping
	 */
	@Override
	public void setDocumentName(String documentName) {
		model.setDocumentName(documentName);
	}

	/**
	 * Sets the modified date of this document mapping.
	 *
	 * @param modifiedDate the modified date of this document mapping
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the module name of this document mapping.
	 *
	 * @param moduleName the module name of this document mapping
	 */
	@Override
	public void setModuleName(String moduleName) {
		model.setModuleName(moduleName);
	}

	/**
	 * Sets the primary key of this document mapping.
	 *
	 * @param primaryKey the primary key of this document mapping
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the record ID of this document mapping.
	 *
	 * @param recordId the record ID of this document mapping
	 */
	@Override
	public void setRecordId(long recordId) {
		model.setRecordId(recordId);
	}

	/**
	 * Sets the user ID of this document mapping.
	 *
	 * @param userId the user ID of this document mapping
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this document mapping.
	 *
	 * @param userUuid the user uuid of this document mapping
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this document mapping.
	 *
	 * @param uuid the uuid of this document mapping
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected DocumentMappingWrapper wrap(DocumentMapping documentMapping) {
		return new DocumentMappingWrapper(documentMapping);
	}

}