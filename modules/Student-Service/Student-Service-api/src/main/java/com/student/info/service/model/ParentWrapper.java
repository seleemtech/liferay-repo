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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Parent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Parent
 * @generated
 */
public class ParentWrapper
	extends BaseModelWrapper<Parent> implements ModelWrapper<Parent>, Parent {

	public ParentWrapper(Parent parent) {
		super(parent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parentId", getParentId());
		attributes.put("parentName", getParentName());
		attributes.put("parentContact", getParentContact());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String parentName = (String)attributes.get("parentName");

		if (parentName != null) {
			setParentName(parentName);
		}

		Long parentContact = (Long)attributes.get("parentContact");

		if (parentContact != null) {
			setParentContact(parentContact);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public Parent cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this parent.
	 *
	 * @return the company ID of this parent
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the parent contact of this parent.
	 *
	 * @return the parent contact of this parent
	 */
	@Override
	public long getParentContact() {
		return model.getParentContact();
	}

	/**
	 * Returns the parent ID of this parent.
	 *
	 * @return the parent ID of this parent
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the parent name of this parent.
	 *
	 * @return the parent name of this parent
	 */
	@Override
	public String getParentName() {
		return model.getParentName();
	}

	/**
	 * Returns the primary key of this parent.
	 *
	 * @return the primary key of this parent
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this parent.
	 *
	 * @param companyId the company ID of this parent
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the parent contact of this parent.
	 *
	 * @param parentContact the parent contact of this parent
	 */
	@Override
	public void setParentContact(long parentContact) {
		model.setParentContact(parentContact);
	}

	/**
	 * Sets the parent ID of this parent.
	 *
	 * @param parentId the parent ID of this parent
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the parent name of this parent.
	 *
	 * @param parentName the parent name of this parent
	 */
	@Override
	public void setParentName(String parentName) {
		model.setParentName(parentName);
	}

	/**
	 * Sets the primary key of this parent.
	 *
	 * @param primaryKey the primary key of this parent
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ParentWrapper wrap(Parent parent) {
		return new ParentWrapper(parent);
	}

}