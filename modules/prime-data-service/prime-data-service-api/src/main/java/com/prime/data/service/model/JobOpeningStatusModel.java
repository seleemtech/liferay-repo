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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the JobOpeningStatus service. Represents a row in the &quot;PRIME_JobOpeningStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.prime.data.service.model.impl.JobOpeningStatusModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.prime.data.service.model.impl.JobOpeningStatusImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobOpeningStatus
 * @generated
 */
@ProviderType
public interface JobOpeningStatusModel extends BaseModel<JobOpeningStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a job opening status model instance should use the {@link JobOpeningStatus} interface instead.
	 */

	/**
	 * Returns the primary key of this job opening status.
	 *
	 * @return the primary key of this job opening status
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this job opening status.
	 *
	 * @param primaryKey the primary key of this job opening status
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this job opening status.
	 *
	 * @return the uuid of this job opening status
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this job opening status.
	 *
	 * @param uuid the uuid of this job opening status
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the job status ID of this job opening status.
	 *
	 * @return the job status ID of this job opening status
	 */
	public long getJobStatusId();

	/**
	 * Sets the job status ID of this job opening status.
	 *
	 * @param jobStatusId the job status ID of this job opening status
	 */
	public void setJobStatusId(long jobStatusId);

	/**
	 * Returns the job opening status of this job opening status.
	 *
	 * @return the job opening status of this job opening status
	 */
	@AutoEscape
	public String getJobOpeningStatus();

	/**
	 * Sets the job opening status of this job opening status.
	 *
	 * @param jobOpeningStatus the job opening status of this job opening status
	 */
	public void setJobOpeningStatus(String jobOpeningStatus);

	@Override
	public JobOpeningStatus cloneWithOriginalValues();

}