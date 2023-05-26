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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the DocumentMapper service. Represents a row in the &quot;PRIME_DocumentMapper&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.prime.data.service.model.impl.DocumentMapperModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.prime.data.service.model.impl.DocumentMapperImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMapper
 * @generated
 */
@ProviderType
public interface DocumentMapperModel extends BaseModel<DocumentMapper> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a document mapper model instance should use the {@link DocumentMapper} interface instead.
	 */

	/**
	 * Returns the primary key of this document mapper.
	 *
	 * @return the primary key of this document mapper
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this document mapper.
	 *
	 * @param primaryKey the primary key of this document mapper
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this document mapper.
	 *
	 * @return the uuid of this document mapper
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this document mapper.
	 *
	 * @param uuid the uuid of this document mapper
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the record ID of this document mapper.
	 *
	 * @return the record ID of this document mapper
	 */
	public long getRecordId();

	/**
	 * Sets the record ID of this document mapper.
	 *
	 * @param recordId the record ID of this document mapper
	 */
	public void setRecordId(long recordId);

	/**
	 * Returns the module name of this document mapper.
	 *
	 * @return the module name of this document mapper
	 */
	@AutoEscape
	public String getModuleName();

	/**
	 * Sets the module name of this document mapper.
	 *
	 * @param moduleName the module name of this document mapper
	 */
	public void setModuleName(String moduleName);

	/**
	 * Returns the class pk of this document mapper.
	 *
	 * @return the class pk of this document mapper
	 */
	public long getClassPk();

	/**
	 * Sets the class pk of this document mapper.
	 *
	 * @param classPk the class pk of this document mapper
	 */
	public void setClassPk(long classPk);

	/**
	 * Returns the document name of this document mapper.
	 *
	 * @return the document name of this document mapper
	 */
	@AutoEscape
	public String getDocumentName();

	/**
	 * Sets the document name of this document mapper.
	 *
	 * @param documentName the document name of this document mapper
	 */
	public void setDocumentName(String documentName);

	/**
	 * Returns the document ID of this document mapper.
	 *
	 * @return the document ID of this document mapper
	 */
	public long getDocumentId();

	/**
	 * Sets the document ID of this document mapper.
	 *
	 * @param documentId the document ID of this document mapper
	 */
	public void setDocumentId(long documentId);

	/**
	 * Returns the created date of this document mapper.
	 *
	 * @return the created date of this document mapper
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this document mapper.
	 *
	 * @param createdDate the created date of this document mapper
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified date of this document mapper.
	 *
	 * @return the modified date of this document mapper
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this document mapper.
	 *
	 * @param modifiedDate the modified date of this document mapper
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this document mapper.
	 *
	 * @return the user ID of this document mapper
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this document mapper.
	 *
	 * @param userId the user ID of this document mapper
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this document mapper.
	 *
	 * @return the user uuid of this document mapper
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this document mapper.
	 *
	 * @param userUuid the user uuid of this document mapper
	 */
	public void setUserUuid(String userUuid);

	@Override
	public DocumentMapper cloneWithOriginalValues();

}