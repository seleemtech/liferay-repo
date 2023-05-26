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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.WorkExperienceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class WorkExperienceSoap implements Serializable {

	public static WorkExperienceSoap toSoapModel(WorkExperience model) {
		WorkExperienceSoap soapModel = new WorkExperienceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setWorkExpId(model.getWorkExpId());
		soapModel.setWorkExpRange(model.getWorkExpRange());

		return soapModel;
	}

	public static WorkExperienceSoap[] toSoapModels(WorkExperience[] models) {
		WorkExperienceSoap[] soapModels = new WorkExperienceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkExperienceSoap[][] toSoapModels(
		WorkExperience[][] models) {

		WorkExperienceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new WorkExperienceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkExperienceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkExperienceSoap[] toSoapModels(
		List<WorkExperience> models) {

		List<WorkExperienceSoap> soapModels = new ArrayList<WorkExperienceSoap>(
			models.size());

		for (WorkExperience model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkExperienceSoap[soapModels.size()]);
	}

	public WorkExperienceSoap() {
	}

	public long getPrimaryKey() {
		return _workExpId;
	}

	public void setPrimaryKey(long pk) {
		setWorkExpId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getWorkExpId() {
		return _workExpId;
	}

	public void setWorkExpId(long workExpId) {
		_workExpId = workExpId;
	}

	public String getWorkExpRange() {
		return _workExpRange;
	}

	public void setWorkExpRange(String workExpRange) {
		_workExpRange = workExpRange;
	}

	private String _uuid;
	private long _workExpId;
	private String _workExpRange;

}