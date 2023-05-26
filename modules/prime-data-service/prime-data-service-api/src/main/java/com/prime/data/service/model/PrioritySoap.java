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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.PriorityServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PrioritySoap implements Serializable {

	public static PrioritySoap toSoapModel(Priority model) {
		PrioritySoap soapModel = new PrioritySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPriorityId(model.getPriorityId());
		soapModel.setPriorityName(model.getPriorityName());

		return soapModel;
	}

	public static PrioritySoap[] toSoapModels(Priority[] models) {
		PrioritySoap[] soapModels = new PrioritySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PrioritySoap[][] toSoapModels(Priority[][] models) {
		PrioritySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PrioritySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PrioritySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PrioritySoap[] toSoapModels(List<Priority> models) {
		List<PrioritySoap> soapModels = new ArrayList<PrioritySoap>(
			models.size());

		for (Priority model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PrioritySoap[soapModels.size()]);
	}

	public PrioritySoap() {
	}

	public long getPrimaryKey() {
		return _priorityId;
	}

	public void setPrimaryKey(long pk) {
		setPriorityId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPriorityId() {
		return _priorityId;
	}

	public void setPriorityId(long priorityId) {
		_priorityId = priorityId;
	}

	public String getPriorityName() {
		return _priorityName;
	}

	public void setPriorityName(String priorityName) {
		_priorityName = priorityName;
	}

	private String _uuid;
	private long _priorityId;
	private String _priorityName;

}