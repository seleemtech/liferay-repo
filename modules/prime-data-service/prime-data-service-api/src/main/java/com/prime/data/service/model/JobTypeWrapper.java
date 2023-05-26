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
 * This class is a wrapper for {@link JobType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobType
 * @generated
 */
public class JobTypeWrapper
	extends BaseModelWrapper<JobType>
	implements JobType, ModelWrapper<JobType> {

	public JobTypeWrapper(JobType jobType) {
		super(jobType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("jobTypeId", getJobTypeId());
		attributes.put("jobType", getJobType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long jobTypeId = (Long)attributes.get("jobTypeId");

		if (jobTypeId != null) {
			setJobTypeId(jobTypeId);
		}

		String jobType = (String)attributes.get("jobType");

		if (jobType != null) {
			setJobType(jobType);
		}
	}

	@Override
	public JobType cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the job type of this job type.
	 *
	 * @return the job type of this job type
	 */
	@Override
	public String getJobType() {
		return model.getJobType();
	}

	/**
	 * Returns the job type ID of this job type.
	 *
	 * @return the job type ID of this job type
	 */
	@Override
	public long getJobTypeId() {
		return model.getJobTypeId();
	}

	/**
	 * Returns the primary key of this job type.
	 *
	 * @return the primary key of this job type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this job type.
	 *
	 * @return the uuid of this job type
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
	 * Sets the job type of this job type.
	 *
	 * @param jobType the job type of this job type
	 */
	@Override
	public void setJobType(String jobType) {
		model.setJobType(jobType);
	}

	/**
	 * Sets the job type ID of this job type.
	 *
	 * @param jobTypeId the job type ID of this job type
	 */
	@Override
	public void setJobTypeId(long jobTypeId) {
		model.setJobTypeId(jobTypeId);
	}

	/**
	 * Sets the primary key of this job type.
	 *
	 * @param primaryKey the primary key of this job type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this job type.
	 *
	 * @param uuid the uuid of this job type
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected JobTypeWrapper wrap(JobType jobType) {
		return new JobTypeWrapper(jobType);
	}

}