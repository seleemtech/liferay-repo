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
 * This class is a wrapper for {@link SourceBy}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SourceBy
 * @generated
 */
public class SourceByWrapper
	extends BaseModelWrapper<SourceBy>
	implements ModelWrapper<SourceBy>, SourceBy {

	public SourceByWrapper(SourceBy sourceBy) {
		super(sourceBy);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sourceId", getSourceId());
		attributes.put("sourceBy", getSourceBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long sourceId = (Long)attributes.get("sourceId");

		if (sourceId != null) {
			setSourceId(sourceId);
		}

		String sourceBy = (String)attributes.get("sourceBy");

		if (sourceBy != null) {
			setSourceBy(sourceBy);
		}
	}

	@Override
	public SourceBy cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this source by.
	 *
	 * @return the primary key of this source by
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the source by of this source by.
	 *
	 * @return the source by of this source by
	 */
	@Override
	public String getSourceBy() {
		return model.getSourceBy();
	}

	/**
	 * Returns the source ID of this source by.
	 *
	 * @return the source ID of this source by
	 */
	@Override
	public long getSourceId() {
		return model.getSourceId();
	}

	/**
	 * Returns the uuid of this source by.
	 *
	 * @return the uuid of this source by
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
	 * Sets the primary key of this source by.
	 *
	 * @param primaryKey the primary key of this source by
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the source by of this source by.
	 *
	 * @param sourceBy the source by of this source by
	 */
	@Override
	public void setSourceBy(String sourceBy) {
		model.setSourceBy(sourceBy);
	}

	/**
	 * Sets the source ID of this source by.
	 *
	 * @param sourceId the source ID of this source by
	 */
	@Override
	public void setSourceId(long sourceId) {
		model.setSourceId(sourceId);
	}

	/**
	 * Sets the uuid of this source by.
	 *
	 * @param uuid the uuid of this source by
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected SourceByWrapper wrap(SourceBy sourceBy) {
		return new SourceByWrapper(sourceBy);
	}

}