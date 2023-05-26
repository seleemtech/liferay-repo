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

package com.job.opening.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.job.opening.service.service.http.DescriptiveinfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DescriptiveinfoSoap implements Serializable {

	public static DescriptiveinfoSoap toSoapModel(Descriptiveinfo model) {
		DescriptiveinfoSoap soapModel = new DescriptiveinfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDescriptiveId(model.getDescriptiveId());
		soapModel.setJobId(model.getJobId());
		soapModel.setJobDescription(model.getJobDescription());
		soapModel.setRequirements(model.getRequirements());
		soapModel.setBenefits(model.getBenefits());

		return soapModel;
	}

	public static DescriptiveinfoSoap[] toSoapModels(Descriptiveinfo[] models) {
		DescriptiveinfoSoap[] soapModels =
			new DescriptiveinfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DescriptiveinfoSoap[][] toSoapModels(
		Descriptiveinfo[][] models) {

		DescriptiveinfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DescriptiveinfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DescriptiveinfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DescriptiveinfoSoap[] toSoapModels(
		List<Descriptiveinfo> models) {

		List<DescriptiveinfoSoap> soapModels =
			new ArrayList<DescriptiveinfoSoap>(models.size());

		for (Descriptiveinfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DescriptiveinfoSoap[soapModels.size()]);
	}

	public DescriptiveinfoSoap() {
	}

	public long getPrimaryKey() {
		return _descriptiveId;
	}

	public void setPrimaryKey(long pk) {
		setDescriptiveId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDescriptiveId() {
		return _descriptiveId;
	}

	public void setDescriptiveId(long descriptiveId) {
		_descriptiveId = descriptiveId;
	}

	public long getJobId() {
		return _jobId;
	}

	public void setJobId(long jobId) {
		_jobId = jobId;
	}

	public String getJobDescription() {
		return _jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		_jobDescription = jobDescription;
	}

	public String getRequirements() {
		return _requirements;
	}

	public void setRequirements(String requirements) {
		_requirements = requirements;
	}

	public String getBenefits() {
		return _benefits;
	}

	public void setBenefits(String benefits) {
		_benefits = benefits;
	}

	private String _uuid;
	private long _descriptiveId;
	private long _jobId;
	private String _jobDescription;
	private String _requirements;
	private String _benefits;

}