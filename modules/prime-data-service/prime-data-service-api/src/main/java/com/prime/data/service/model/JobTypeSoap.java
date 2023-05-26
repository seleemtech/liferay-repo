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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.JobTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class JobTypeSoap implements Serializable {

	public static JobTypeSoap toSoapModel(JobType model) {
		JobTypeSoap soapModel = new JobTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setJobTypeId(model.getJobTypeId());
		soapModel.setJobType(model.getJobType());

		return soapModel;
	}

	public static JobTypeSoap[] toSoapModels(JobType[] models) {
		JobTypeSoap[] soapModels = new JobTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobTypeSoap[][] toSoapModels(JobType[][] models) {
		JobTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobTypeSoap[] toSoapModels(List<JobType> models) {
		List<JobTypeSoap> soapModels = new ArrayList<JobTypeSoap>(
			models.size());

		for (JobType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobTypeSoap[soapModels.size()]);
	}

	public JobTypeSoap() {
	}

	public long getPrimaryKey() {
		return _jobTypeId;
	}

	public void setPrimaryKey(long pk) {
		setJobTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getJobTypeId() {
		return _jobTypeId;
	}

	public void setJobTypeId(long jobTypeId) {
		_jobTypeId = jobTypeId;
	}

	public String getJobType() {
		return _jobType;
	}

	public void setJobType(String jobType) {
		_jobType = jobType;
	}

	private String _uuid;
	private long _jobTypeId;
	private String _jobType;

}