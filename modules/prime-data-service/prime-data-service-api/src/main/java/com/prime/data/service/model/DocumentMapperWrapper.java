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

package com.prime.data.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DocumentMapper}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMapper
 * @generated
 */
public class DocumentMapperWrapper
	extends BaseModelWrapper<DocumentMapper>
	implements DocumentMapper, ModelWrapper<DocumentMapper> {

	public DocumentMapperWrapper(DocumentMapper documentMapper) {
		super(documentMapper);
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
	public DocumentMapper cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the class pk of this document mapper.
	 *
	 * @return the class pk of this document mapper
	 */
	@Override
	public long getClassPk() {
		return model.getClassPk();
	}

	/**
	 * Returns the created date of this document mapper.
	 *
	 * @return the created date of this document mapper
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the document ID of this document mapper.
	 *
	 * @return the document ID of this document mapper
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the document name of this document mapper.
	 *
	 * @return the document name of this document mapper
	 */
	@Override
	public String getDocumentName() {
		return model.getDocumentName();
	}

	/**
	 * Returns the modified date of this document mapper.
	 *
	 * @return the modified date of this document mapper
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the module name of this document mapper.
	 *
	 * @return the module name of this document mapper
	 */
	@Override
	public String getModuleName() {
		return model.getModuleName();
	}

	/**
	 * Returns the primary key of this document mapper.
	 *
	 * @return the primary key of this document mapper
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the record ID of this document mapper.
	 *
	 * @return the record ID of this document mapper
	 */
	@Override
	public long getRecordId() {
		return model.getRecordId();
	}

	/**
	 * Returns the user ID of this document mapper.
	 *
	 * @return the user ID of this document mapper
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this document mapper.
	 *
	 * @return the user uuid of this document mapper
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this document mapper.
	 *
	 * @return the uuid of this document mapper
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
	 * Sets the class pk of this document mapper.
	 *
	 * @param classPk the class pk of this document mapper
	 */
	@Override
	public void setClassPk(long classPk) {
		model.setClassPk(classPk);
	}

	/**
	 * Sets the created date of this document mapper.
	 *
	 * @param createdDate the created date of this document mapper
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the document ID of this document mapper.
	 *
	 * @param documentId the document ID of this document mapper
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the document name of this document mapper.
	 *
	 * @param documentName the document name of this document mapper
	 */
	@Override
	public void setDocumentName(String documentName) {
		model.setDocumentName(documentName);
	}

	/**
	 * Sets the modified date of this document mapper.
	 *
	 * @param modifiedDate the modified date of this document mapper
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the module name of this document mapper.
	 *
	 * @param moduleName the module name of this document mapper
	 */
	@Override
	public void setModuleName(String moduleName) {
		model.setModuleName(moduleName);
	}

	/**
	 * Sets the primary key of this document mapper.
	 *
	 * @param primaryKey the primary key of this document mapper
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the record ID of this document mapper.
	 *
	 * @param recordId the record ID of this document mapper
	 */
	@Override
	public void setRecordId(long recordId) {
		model.setRecordId(recordId);
	}

	/**
	 * Sets the user ID of this document mapper.
	 *
	 * @param userId the user ID of this document mapper
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this document mapper.
	 *
	 * @param userUuid the user uuid of this document mapper
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this document mapper.
	 *
	 * @param uuid the uuid of this document mapper
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected DocumentMapperWrapper wrap(DocumentMapper documentMapper) {
		return new DocumentMapperWrapper(documentMapper);
	}

}