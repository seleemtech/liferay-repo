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
 * This class is a wrapper for {@link WorkExperience}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkExperience
 * @generated
 */
public class WorkExperienceWrapper
	extends BaseModelWrapper<WorkExperience>
	implements ModelWrapper<WorkExperience>, WorkExperience {

	public WorkExperienceWrapper(WorkExperience workExperience) {
		super(workExperience);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("workExpId", getWorkExpId());
		attributes.put("workExpRange", getWorkExpRange());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long workExpId = (Long)attributes.get("workExpId");

		if (workExpId != null) {
			setWorkExpId(workExpId);
		}

		String workExpRange = (String)attributes.get("workExpRange");

		if (workExpRange != null) {
			setWorkExpRange(workExpRange);
		}
	}

	@Override
	public WorkExperience cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this work experience.
	 *
	 * @return the primary key of this work experience
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this work experience.
	 *
	 * @return the uuid of this work experience
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work exp ID of this work experience.
	 *
	 * @return the work exp ID of this work experience
	 */
	@Override
	public long getWorkExpId() {
		return model.getWorkExpId();
	}

	/**
	 * Returns the work exp range of this work experience.
	 *
	 * @return the work exp range of this work experience
	 */
	@Override
	public String getWorkExpRange() {
		return model.getWorkExpRange();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this work experience.
	 *
	 * @param primaryKey the primary key of this work experience
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this work experience.
	 *
	 * @param uuid the uuid of this work experience
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work exp ID of this work experience.
	 *
	 * @param workExpId the work exp ID of this work experience
	 */
	@Override
	public void setWorkExpId(long workExpId) {
		model.setWorkExpId(workExpId);
	}

	/**
	 * Sets the work exp range of this work experience.
	 *
	 * @param workExpRange the work exp range of this work experience
	 */
	@Override
	public void setWorkExpRange(String workExpRange) {
		model.setWorkExpRange(workExpRange);
	}

	@Override
	protected WorkExperienceWrapper wrap(WorkExperience workExperience) {
		return new WorkExperienceWrapper(workExperience);
	}

}