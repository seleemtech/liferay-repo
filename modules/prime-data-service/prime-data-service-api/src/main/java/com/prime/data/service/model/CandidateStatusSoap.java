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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.CandidateStatusServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CandidateStatusSoap implements Serializable {

	public static CandidateStatusSoap toSoapModel(CandidateStatus model) {
		CandidateStatusSoap soapModel = new CandidateStatusSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCandidateStatusId(model.getCandidateStatusId());
		soapModel.setCandidateStatus(model.getCandidateStatus());

		return soapModel;
	}

	public static CandidateStatusSoap[] toSoapModels(CandidateStatus[] models) {
		CandidateStatusSoap[] soapModels =
			new CandidateStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateStatusSoap[][] toSoapModels(
		CandidateStatus[][] models) {

		CandidateStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CandidateStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateStatusSoap[] toSoapModels(
		List<CandidateStatus> models) {

		List<CandidateStatusSoap> soapModels =
			new ArrayList<CandidateStatusSoap>(models.size());

		for (CandidateStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateStatusSoap[soapModels.size()]);
	}

	public CandidateStatusSoap() {
	}

	public long getPrimaryKey() {
		return _candidateStatusId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateStatusId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCandidateStatusId() {
		return _candidateStatusId;
	}

	public void setCandidateStatusId(long candidateStatusId) {
		_candidateStatusId = candidateStatusId;
	}

	public String getCandidateStatus() {
		return _candidateStatus;
	}

	public void setCandidateStatus(String candidateStatus) {
		_candidateStatus = candidateStatus;
	}

	private String _uuid;
	private long _candidateStatusId;
	private String _candidateStatus;

}