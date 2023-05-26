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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.HighQualHeldServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HighQualHeldSoap implements Serializable {

	public static HighQualHeldSoap toSoapModel(HighQualHeld model) {
		HighQualHeldSoap soapModel = new HighQualHeldSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setHighQualHeldId(model.getHighQualHeldId());
		soapModel.setHighQualHeld(model.getHighQualHeld());

		return soapModel;
	}

	public static HighQualHeldSoap[] toSoapModels(HighQualHeld[] models) {
		HighQualHeldSoap[] soapModels = new HighQualHeldSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HighQualHeldSoap[][] toSoapModels(HighQualHeld[][] models) {
		HighQualHeldSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HighQualHeldSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HighQualHeldSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HighQualHeldSoap[] toSoapModels(List<HighQualHeld> models) {
		List<HighQualHeldSoap> soapModels = new ArrayList<HighQualHeldSoap>(
			models.size());

		for (HighQualHeld model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HighQualHeldSoap[soapModels.size()]);
	}

	public HighQualHeldSoap() {
	}

	public long getPrimaryKey() {
		return _highQualHeldId;
	}

	public void setPrimaryKey(long pk) {
		setHighQualHeldId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getHighQualHeldId() {
		return _highQualHeldId;
	}

	public void setHighQualHeldId(long highQualHeldId) {
		_highQualHeldId = highQualHeldId;
	}

	public String getHighQualHeld() {
		return _highQualHeld;
	}

	public void setHighQualHeld(String highQualHeld) {
		_highQualHeld = highQualHeld;
	}

	private String _uuid;
	private long _highQualHeldId;
	private String _highQualHeld;

}