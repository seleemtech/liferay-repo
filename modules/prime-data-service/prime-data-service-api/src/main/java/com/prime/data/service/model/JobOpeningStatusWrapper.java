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
 * This class is a wrapper for {@link JobOpeningStatus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobOpeningStatus
 * @generated
 */
public class JobOpeningStatusWrapper
	extends BaseModelWrapper<JobOpeningStatus>
	implements JobOpeningStatus, ModelWrapper<JobOpeningStatus> {

	public JobOpeningStatusWrapper(JobOpeningStatus jobOpeningStatus) {
		super(jobOpeningStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("jobStatusId", getJobStatusId());
		attributes.put("jobOpeningStatus", getJobOpeningStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long jobStatusId = (Long)attributes.get("jobStatusId");

		if (jobStatusId != null) {
			setJobStatusId(jobStatusId);
		}

		String jobOpeningStatus = (String)attributes.get("jobOpeningStatus");

		if (jobOpeningStatus != null) {
			setJobOpeningStatus(jobOpeningStatus);
		}
	}

	@Override
	public JobOpeningStatus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the job opening status of this job opening status.
	 *
	 * @return the job opening status of this job opening status
	 */
	@Override
	public String getJobOpeningStatus() {
		return model.getJobOpeningStatus();
	}

	/**
	 * Returns the job status ID of this job opening status.
	 *
	 * @return the job status ID of this job opening status
	 */
	@Override
	public long getJobStatusId() {
		return model.getJobStatusId();
	}

	/**
	 * Returns the primary key of this job opening status.
	 *
	 * @return the primary key of this job opening status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this job opening status.
	 *
	 * @return the uuid of this job opening status
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
	 * Sets the job opening status of this job opening status.
	 *
	 * @param jobOpeningStatus the job opening status of this job opening status
	 */
	@Override
	public void setJobOpeningStatus(String jobOpeningStatus) {
		model.setJobOpeningStatus(jobOpeningStatus);
	}

	/**
	 * Sets the job status ID of this job opening status.
	 *
	 * @param jobStatusId the job status ID of this job opening status
	 */
	@Override
	public void setJobStatusId(long jobStatusId) {
		model.setJobStatusId(jobStatusId);
	}

	/**
	 * Sets the primary key of this job opening status.
	 *
	 * @param primaryKey the primary key of this job opening status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this job opening status.
	 *
	 * @param uuid the uuid of this job opening status
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected JobOpeningStatusWrapper wrap(JobOpeningStatus jobOpeningStatus) {
		return new JobOpeningStatusWrapper(jobOpeningStatus);
	}

}