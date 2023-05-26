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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.SalesStageServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SalesStageSoap implements Serializable {

	public static SalesStageSoap toSoapModel(SalesStage model) {
		SalesStageSoap soapModel = new SalesStageSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSalesStageId(model.getSalesStageId());
		soapModel.setSalesStage(model.getSalesStage());

		return soapModel;
	}

	public static SalesStageSoap[] toSoapModels(SalesStage[] models) {
		SalesStageSoap[] soapModels = new SalesStageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SalesStageSoap[][] toSoapModels(SalesStage[][] models) {
		SalesStageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SalesStageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SalesStageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SalesStageSoap[] toSoapModels(List<SalesStage> models) {
		List<SalesStageSoap> soapModels = new ArrayList<SalesStageSoap>(
			models.size());

		for (SalesStage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SalesStageSoap[soapModels.size()]);
	}

	public SalesStageSoap() {
	}

	public long getPrimaryKey() {
		return _salesStageId;
	}

	public void setPrimaryKey(long pk) {
		setSalesStageId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSalesStageId() {
		return _salesStageId;
	}

	public void setSalesStageId(long salesStageId) {
		_salesStageId = salesStageId;
	}

	public String getSalesStage() {
		return _salesStage;
	}

	public void setSalesStage(String salesStage) {
		_salesStage = salesStage;
	}

	private String _uuid;
	private long _salesStageId;
	private String _salesStage;

}