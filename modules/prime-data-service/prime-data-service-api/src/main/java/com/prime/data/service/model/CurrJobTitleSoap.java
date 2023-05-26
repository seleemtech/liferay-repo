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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.CurrJobTitleServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CurrJobTitleSoap implements Serializable {

	public static CurrJobTitleSoap toSoapModel(CurrJobTitle model) {
		CurrJobTitleSoap soapModel = new CurrJobTitleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCurrJobTitleId(model.getCurrJobTitleId());
		soapModel.setCurrentJobTitle(model.getCurrentJobTitle());

		return soapModel;
	}

	public static CurrJobTitleSoap[] toSoapModels(CurrJobTitle[] models) {
		CurrJobTitleSoap[] soapModels = new CurrJobTitleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CurrJobTitleSoap[][] toSoapModels(CurrJobTitle[][] models) {
		CurrJobTitleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CurrJobTitleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CurrJobTitleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CurrJobTitleSoap[] toSoapModels(List<CurrJobTitle> models) {
		List<CurrJobTitleSoap> soapModels = new ArrayList<CurrJobTitleSoap>(
			models.size());

		for (CurrJobTitle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CurrJobTitleSoap[soapModels.size()]);
	}

	public CurrJobTitleSoap() {
	}

	public long getPrimaryKey() {
		return _currJobTitleId;
	}

	public void setPrimaryKey(long pk) {
		setCurrJobTitleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCurrJobTitleId() {
		return _currJobTitleId;
	}

	public void setCurrJobTitleId(long currJobTitleId) {
		_currJobTitleId = currJobTitleId;
	}

	public String getCurrentJobTitle() {
		return _currentJobTitle;
	}

	public void setCurrentJobTitle(String currentJobTitle) {
		_currentJobTitle = currentJobTitle;
	}

	private String _uuid;
	private long _currJobTitleId;
	private String _currentJobTitle;

}