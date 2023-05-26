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
 * This class is a wrapper for {@link Industry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Industry
 * @generated
 */
public class IndustryWrapper
	extends BaseModelWrapper<Industry>
	implements Industry, ModelWrapper<Industry> {

	public IndustryWrapper(Industry industry) {
		super(industry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("industryId", getIndustryId());
		attributes.put("industryName", getIndustryName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long industryId = (Long)attributes.get("industryId");

		if (industryId != null) {
			setIndustryId(industryId);
		}

		String industryName = (String)attributes.get("industryName");

		if (industryName != null) {
			setIndustryName(industryName);
		}
	}

	@Override
	public Industry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the industry ID of this industry.
	 *
	 * @return the industry ID of this industry
	 */
	@Override
	public long getIndustryId() {
		return model.getIndustryId();
	}

	/**
	 * Returns the industry name of this industry.
	 *
	 * @return the industry name of this industry
	 */
	@Override
	public String getIndustryName() {
		return model.getIndustryName();
	}

	/**
	 * Returns the primary key of this industry.
	 *
	 * @return the primary key of this industry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this industry.
	 *
	 * @return the uuid of this industry
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
	 * Sets the industry ID of this industry.
	 *
	 * @param industryId the industry ID of this industry
	 */
	@Override
	public void setIndustryId(long industryId) {
		model.setIndustryId(industryId);
	}

	/**
	 * Sets the industry name of this industry.
	 *
	 * @param industryName the industry name of this industry
	 */
	@Override
	public void setIndustryName(String industryName) {
		model.setIndustryName(industryName);
	}

	/**
	 * Sets the primary key of this industry.
	 *
	 * @param primaryKey the primary key of this industry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this industry.
	 *
	 * @param uuid the uuid of this industry
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected IndustryWrapper wrap(Industry industry) {
		return new IndustryWrapper(industry);
	}

}