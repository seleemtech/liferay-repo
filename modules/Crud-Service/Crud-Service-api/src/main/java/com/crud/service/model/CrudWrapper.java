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

package com.crud.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Crud}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Crud
 * @generated
 */
public class CrudWrapper
	extends BaseModelWrapper<Crud> implements Crud, ModelWrapper<Crud> {

	public CrudWrapper(Crud crud) {
		super(crud);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("crudId", getCrudId());
		attributes.put("crudNo", getCrudNo());
		attributes.put("crudName", getCrudName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long crudId = (Long)attributes.get("crudId");

		if (crudId != null) {
			setCrudId(crudId);
		}

		Long crudNo = (Long)attributes.get("crudNo");

		if (crudNo != null) {
			setCrudNo(crudNo);
		}

		String crudName = (String)attributes.get("crudName");

		if (crudName != null) {
			setCrudName(crudName);
		}
	}

	@Override
	public Crud cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the crud ID of this crud.
	 *
	 * @return the crud ID of this crud
	 */
	@Override
	public long getCrudId() {
		return model.getCrudId();
	}

	/**
	 * Returns the crud name of this crud.
	 *
	 * @return the crud name of this crud
	 */
	@Override
	public String getCrudName() {
		return model.getCrudName();
	}

	/**
	 * Returns the crud no of this crud.
	 *
	 * @return the crud no of this crud
	 */
	@Override
	public long getCrudNo() {
		return model.getCrudNo();
	}

	/**
	 * Returns the primary key of this crud.
	 *
	 * @return the primary key of this crud
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this crud.
	 *
	 * @return the uuid of this crud
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
	 * Sets the crud ID of this crud.
	 *
	 * @param crudId the crud ID of this crud
	 */
	@Override
	public void setCrudId(long crudId) {
		model.setCrudId(crudId);
	}

	/**
	 * Sets the crud name of this crud.
	 *
	 * @param crudName the crud name of this crud
	 */
	@Override
	public void setCrudName(String crudName) {
		model.setCrudName(crudName);
	}

	/**
	 * Sets the crud no of this crud.
	 *
	 * @param crudNo the crud no of this crud
	 */
	@Override
	public void setCrudNo(long crudNo) {
		model.setCrudNo(crudNo);
	}

	/**
	 * Sets the primary key of this crud.
	 *
	 * @param primaryKey the primary key of this crud
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this crud.
	 *
	 * @param uuid the uuid of this crud
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CrudWrapper wrap(Crud crud) {
		return new CrudWrapper(crud);
	}

}