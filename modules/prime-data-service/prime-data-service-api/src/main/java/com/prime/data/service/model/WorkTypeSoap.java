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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.WorkTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class WorkTypeSoap implements Serializable {

	public static WorkTypeSoap toSoapModel(WorkType model) {
		WorkTypeSoap soapModel = new WorkTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setWorkTypeId(model.getWorkTypeId());
		soapModel.setWorkTypeName(model.getWorkTypeName());

		return soapModel;
	}

	public static WorkTypeSoap[] toSoapModels(WorkType[] models) {
		WorkTypeSoap[] soapModels = new WorkTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkTypeSoap[][] toSoapModels(WorkType[][] models) {
		WorkTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkTypeSoap[] toSoapModels(List<WorkType> models) {
		List<WorkTypeSoap> soapModels = new ArrayList<WorkTypeSoap>(
			models.size());

		for (WorkType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkTypeSoap[soapModels.size()]);
	}

	public WorkTypeSoap() {
	}

	public long getPrimaryKey() {
		return _workTypeId;
	}

	public void setPrimaryKey(long pk) {
		setWorkTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getWorkTypeId() {
		return _workTypeId;
	}

	public void setWorkTypeId(long workTypeId) {
		_workTypeId = workTypeId;
	}

	public String getWorkTypeName() {
		return _workTypeName;
	}

	public void setWorkTypeName(String workTypeName) {
		_workTypeName = workTypeName;
	}

	private String _uuid;
	private long _workTypeId;
	private String _workTypeName;

}