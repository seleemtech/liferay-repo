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
 * This class is used by SOAP remote services, specifically {@link com.prime.data.service.service.http.InterviewNameServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class InterviewNameSoap implements Serializable {

	public static InterviewNameSoap toSoapModel(InterviewName model) {
		InterviewNameSoap soapModel = new InterviewNameSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setInterviewNameId(model.getInterviewNameId());
		soapModel.setInterviewName(model.getInterviewName());

		return soapModel;
	}

	public static InterviewNameSoap[] toSoapModels(InterviewName[] models) {
		InterviewNameSoap[] soapModels = new InterviewNameSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InterviewNameSoap[][] toSoapModels(InterviewName[][] models) {
		InterviewNameSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InterviewNameSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InterviewNameSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InterviewNameSoap[] toSoapModels(List<InterviewName> models) {
		List<InterviewNameSoap> soapModels = new ArrayList<InterviewNameSoap>(
			models.size());

		for (InterviewName model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InterviewNameSoap[soapModels.size()]);
	}

	public InterviewNameSoap() {
	}

	public long getPrimaryKey() {
		return _interviewNameId;
	}

	public void setPrimaryKey(long pk) {
		setInterviewNameId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getInterviewNameId() {
		return _interviewNameId;
	}

	public void setInterviewNameId(long interviewNameId) {
		_interviewNameId = interviewNameId;
	}

	public String getInterviewName() {
		return _interviewName;
	}

	public void setInterviewName(String interviewName) {
		_interviewName = interviewName;
	}

	private String _uuid;
	private long _interviewNameId;
	private String _interviewName;

}