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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.NamePrefixServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class NamePrefixSoap implements Serializable {

	public static NamePrefixSoap toSoapModel(NamePrefix model) {
		NamePrefixSoap soapModel = new NamePrefixSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setNamePrefixId(model.getNamePrefixId());
		soapModel.setNamePrefix(model.getNamePrefix());

		return soapModel;
	}

	public static NamePrefixSoap[] toSoapModels(NamePrefix[] models) {
		NamePrefixSoap[] soapModels = new NamePrefixSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NamePrefixSoap[][] toSoapModels(NamePrefix[][] models) {
		NamePrefixSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NamePrefixSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NamePrefixSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NamePrefixSoap[] toSoapModels(List<NamePrefix> models) {
		List<NamePrefixSoap> soapModels = new ArrayList<NamePrefixSoap>(
			models.size());

		for (NamePrefix model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NamePrefixSoap[soapModels.size()]);
	}

	public NamePrefixSoap() {
	}

	public long getPrimaryKey() {
		return _namePrefixId;
	}

	public void setPrimaryKey(long pk) {
		setNamePrefixId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getNamePrefixId() {
		return _namePrefixId;
	}

	public void setNamePrefixId(long namePrefixId) {
		_namePrefixId = namePrefixId;
	}

	public String getNamePrefix() {
		return _namePrefix;
	}

	public void setNamePrefix(String namePrefix) {
		_namePrefix = namePrefix;
	}

	private String _uuid;
	private long _namePrefixId;
	private String _namePrefix;

}