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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.SalaryRangeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SalaryRangeSoap implements Serializable {

	public static SalaryRangeSoap toSoapModel(SalaryRange model) {
		SalaryRangeSoap soapModel = new SalaryRangeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSalaryRangeId(model.getSalaryRangeId());
		soapModel.setSalaryRange(model.getSalaryRange());

		return soapModel;
	}

	public static SalaryRangeSoap[] toSoapModels(SalaryRange[] models) {
		SalaryRangeSoap[] soapModels = new SalaryRangeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SalaryRangeSoap[][] toSoapModels(SalaryRange[][] models) {
		SalaryRangeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SalaryRangeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SalaryRangeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SalaryRangeSoap[] toSoapModels(List<SalaryRange> models) {
		List<SalaryRangeSoap> soapModels = new ArrayList<SalaryRangeSoap>(
			models.size());

		for (SalaryRange model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SalaryRangeSoap[soapModels.size()]);
	}

	public SalaryRangeSoap() {
	}

	public long getPrimaryKey() {
		return _salaryRangeId;
	}

	public void setPrimaryKey(long pk) {
		setSalaryRangeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSalaryRangeId() {
		return _salaryRangeId;
	}

	public void setSalaryRangeId(long salaryRangeId) {
		_salaryRangeId = salaryRangeId;
	}

	public String getSalaryRange() {
		return _salaryRange;
	}

	public void setSalaryRange(String salaryRange) {
		_salaryRange = salaryRange;
	}

	private String _uuid;
	private long _salaryRangeId;
	private String _salaryRange;

}