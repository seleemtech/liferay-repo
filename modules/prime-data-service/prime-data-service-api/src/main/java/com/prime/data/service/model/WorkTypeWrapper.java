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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WorkType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkType
 * @generated
 */
public class WorkTypeWrapper
	extends BaseModelWrapper<WorkType>
	implements ModelWrapper<WorkType>, WorkType {

	public WorkTypeWrapper(WorkType workType) {
		super(workType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("workTypeId", getWorkTypeId());
		attributes.put("workTypeName", getWorkTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long workTypeId = (Long)attributes.get("workTypeId");

		if (workTypeId != null) {
			setWorkTypeId(workTypeId);
		}

		String workTypeName = (String)attributes.get("workTypeName");

		if (workTypeName != null) {
			setWorkTypeName(workTypeName);
		}
	}

	@Override
	public WorkType cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this work type.
	 *
	 * @return the primary key of this work type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this work type.
	 *
	 * @return the uuid of this work type
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work type ID of this work type.
	 *
	 * @return the work type ID of this work type
	 */
	@Override
	public long getWorkTypeId() {
		return model.getWorkTypeId();
	}

	/**
	 * Returns the work type name of this work type.
	 *
	 * @return the work type name of this work type
	 */
	@Override
	public String getWorkTypeName() {
		return model.getWorkTypeName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this work type.
	 *
	 * @param primaryKey the primary key of this work type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this work type.
	 *
	 * @param uuid the uuid of this work type
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work type ID of this work type.
	 *
	 * @param workTypeId the work type ID of this work type
	 */
	@Override
	public void setWorkTypeId(long workTypeId) {
		model.setWorkTypeId(workTypeId);
	}

	/**
	 * Sets the work type name of this work type.
	 *
	 * @param workTypeName the work type name of this work type
	 */
	@Override
	public void setWorkTypeName(String workTypeName) {
		model.setWorkTypeName(workTypeName);
	}

	@Override
	protected WorkTypeWrapper wrap(WorkType workType) {
		return new WorkTypeWrapper(workType);
	}

}