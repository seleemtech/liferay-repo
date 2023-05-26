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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.JobOpeningStatusServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class JobOpeningStatusSoap implements Serializable {

	public static JobOpeningStatusSoap toSoapModel(JobOpeningStatus model) {
		JobOpeningStatusSoap soapModel = new JobOpeningStatusSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setJobStatusId(model.getJobStatusId());
		soapModel.setJobOpeningStatus(model.getJobOpeningStatus());

		return soapModel;
	}

	public static JobOpeningStatusSoap[] toSoapModels(
		JobOpeningStatus[] models) {

		JobOpeningStatusSoap[] soapModels =
			new JobOpeningStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobOpeningStatusSoap[][] toSoapModels(
		JobOpeningStatus[][] models) {

		JobOpeningStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new JobOpeningStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobOpeningStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobOpeningStatusSoap[] toSoapModels(
		List<JobOpeningStatus> models) {

		List<JobOpeningStatusSoap> soapModels =
			new ArrayList<JobOpeningStatusSoap>(models.size());

		for (JobOpeningStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobOpeningStatusSoap[soapModels.size()]);
	}

	public JobOpeningStatusSoap() {
	}

	public long getPrimaryKey() {
		return _jobStatusId;
	}

	public void setPrimaryKey(long pk) {
		setJobStatusId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getJobStatusId() {
		return _jobStatusId;
	}

	public void setJobStatusId(long jobStatusId) {
		_jobStatusId = jobStatusId;
	}

	public String getJobOpeningStatus() {
		return _jobOpeningStatus;
	}

	public void setJobOpeningStatus(String jobOpeningStatus) {
		_jobOpeningStatus = jobOpeningStatus;
	}

	private String _uuid;
	private long _jobStatusId;
	private String _jobOpeningStatus;

}