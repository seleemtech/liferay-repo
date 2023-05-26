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
 * This class is a wrapper for {@link Priority}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Priority
 * @generated
 */
public class PriorityWrapper
	extends BaseModelWrapper<Priority>
	implements ModelWrapper<Priority>, Priority {

	public PriorityWrapper(Priority priority) {
		super(priority);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("priorityId", getPriorityId());
		attributes.put("priorityName", getPriorityName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long priorityId = (Long)attributes.get("priorityId");

		if (priorityId != null) {
			setPriorityId(priorityId);
		}

		String priorityName = (String)attributes.get("priorityName");

		if (priorityName != null) {
			setPriorityName(priorityName);
		}
	}

	@Override
	public Priority cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this priority.
	 *
	 * @return the primary key of this priority
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the priority ID of this priority.
	 *
	 * @return the priority ID of this priority
	 */
	@Override
	public long getPriorityId() {
		return model.getPriorityId();
	}

	/**
	 * Returns the priority name of this priority.
	 *
	 * @return the priority name of this priority
	 */
	@Override
	public String getPriorityName() {
		return model.getPriorityName();
	}

	/**
	 * Returns the uuid of this priority.
	 *
	 * @return the uuid of this priority
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
	 * Sets the primary key of this priority.
	 *
	 * @param primaryKey the primary key of this priority
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the priority ID of this priority.
	 *
	 * @param priorityId the priority ID of this priority
	 */
	@Override
	public void setPriorityId(long priorityId) {
		model.setPriorityId(priorityId);
	}

	/**
	 * Sets the priority name of this priority.
	 *
	 * @param priorityName the priority name of this priority
	 */
	@Override
	public void setPriorityName(String priorityName) {
		model.setPriorityName(priorityName);
	}

	/**
	 * Sets the uuid of this priority.
	 *
	 * @param uuid the uuid of this priority
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PriorityWrapper wrap(Priority priority) {
		return new PriorityWrapper(priority);
	}

}