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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.SourceByServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SourceBySoap implements Serializable {

	public static SourceBySoap toSoapModel(SourceBy model) {
		SourceBySoap soapModel = new SourceBySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSourceId(model.getSourceId());
		soapModel.setSourceBy(model.getSourceBy());

		return soapModel;
	}

	public static SourceBySoap[] toSoapModels(SourceBy[] models) {
		SourceBySoap[] soapModels = new SourceBySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SourceBySoap[][] toSoapModels(SourceBy[][] models) {
		SourceBySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SourceBySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SourceBySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SourceBySoap[] toSoapModels(List<SourceBy> models) {
		List<SourceBySoap> soapModels = new ArrayList<SourceBySoap>(
			models.size());

		for (SourceBy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SourceBySoap[soapModels.size()]);
	}

	public SourceBySoap() {
	}

	public long getPrimaryKey() {
		return _sourceId;
	}

	public void setPrimaryKey(long pk) {
		setSourceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSourceId() {
		return _sourceId;
	}

	public void setSourceId(long sourceId) {
		_sourceId = sourceId;
	}

	public String getSourceBy() {
		return _sourceBy;
	}

	public void setSourceBy(String sourceBy) {
		_sourceBy = sourceBy;
	}

	private String _uuid;
	private long _sourceId;
	private String _sourceBy;

}