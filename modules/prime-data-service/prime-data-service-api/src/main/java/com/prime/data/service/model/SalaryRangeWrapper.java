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
 * This class is a wrapper for {@link SalaryRange}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaryRange
 * @generated
 */
public class SalaryRangeWrapper
	extends BaseModelWrapper<SalaryRange>
	implements ModelWrapper<SalaryRange>, SalaryRange {

	public SalaryRangeWrapper(SalaryRange salaryRange) {
		super(salaryRange);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("salaryRangeId", getSalaryRangeId());
		attributes.put("salaryRange", getSalaryRange());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long salaryRangeId = (Long)attributes.get("salaryRangeId");

		if (salaryRangeId != null) {
			setSalaryRangeId(salaryRangeId);
		}

		String salaryRange = (String)attributes.get("salaryRange");

		if (salaryRange != null) {
			setSalaryRange(salaryRange);
		}
	}

	@Override
	public SalaryRange cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this salary range.
	 *
	 * @return the primary key of this salary range
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the salary range of this salary range.
	 *
	 * @return the salary range of this salary range
	 */
	@Override
	public String getSalaryRange() {
		return model.getSalaryRange();
	}

	/**
	 * Returns the salary range ID of this salary range.
	 *
	 * @return the salary range ID of this salary range
	 */
	@Override
	public long getSalaryRangeId() {
		return model.getSalaryRangeId();
	}

	/**
	 * Returns the uuid of this salary range.
	 *
	 * @return the uuid of this salary range
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
	 * Sets the primary key of this salary range.
	 *
	 * @param primaryKey the primary key of this salary range
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the salary range of this salary range.
	 *
	 * @param salaryRange the salary range of this salary range
	 */
	@Override
	public void setSalaryRange(String salaryRange) {
		model.setSalaryRange(salaryRange);
	}

	/**
	 * Sets the salary range ID of this salary range.
	 *
	 * @param salaryRangeId the salary range ID of this salary range
	 */
	@Override
	public void setSalaryRangeId(long salaryRangeId) {
		model.setSalaryRangeId(salaryRangeId);
	}

	/**
	 * Sets the uuid of this salary range.
	 *
	 * @param uuid the uuid of this salary range
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected SalaryRangeWrapper wrap(SalaryRange salaryRange) {
		return new SalaryRangeWrapper(salaryRange);
	}

}