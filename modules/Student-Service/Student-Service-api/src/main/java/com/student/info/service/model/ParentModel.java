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

package com.student.info.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Parent service. Represents a row in the &quot;ST_Parent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.student.info.service.model.impl.ParentModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.student.info.service.model.impl.ParentImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Parent
 * @generated
 */
@ProviderType
public interface ParentModel extends BaseModel<Parent>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a parent model instance should use the {@link Parent} interface instead.
	 */

	/**
	 * Returns the primary key of this parent.
	 *
	 * @return the primary key of this parent
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this parent.
	 *
	 * @param primaryKey the primary key of this parent
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the parent ID of this parent.
	 *
	 * @return the parent ID of this parent
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this parent.
	 *
	 * @param parentId the parent ID of this parent
	 */
	public void setParentId(long parentId);

	/**
	 * Returns the parent name of this parent.
	 *
	 * @return the parent name of this parent
	 */
	@AutoEscape
	public String getParentName();

	/**
	 * Sets the parent name of this parent.
	 *
	 * @param parentName the parent name of this parent
	 */
	public void setParentName(String parentName);

	/**
	 * Returns the parent contact of this parent.
	 *
	 * @return the parent contact of this parent
	 */
	public long getParentContact();

	/**
	 * Sets the parent contact of this parent.
	 *
	 * @param parentContact the parent contact of this parent
	 */
	public void setParentContact(long parentContact);

	/**
	 * Returns the company ID of this parent.
	 *
	 * @return the company ID of this parent
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this parent.
	 *
	 * @param companyId the company ID of this parent
	 */
	@Override
	public void setCompanyId(long companyId);

	@Override
	public Parent cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}