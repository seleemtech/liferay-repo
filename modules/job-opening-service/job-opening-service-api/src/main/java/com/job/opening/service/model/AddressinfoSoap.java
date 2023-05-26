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

package com.job.opening.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.job.opening.service.service.http.AddressinfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AddressinfoSoap implements Serializable {

	public static AddressinfoSoap toSoapModel(Addressinfo model) {
		AddressinfoSoap soapModel = new AddressinfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setJobId(model.getJobId());
		soapModel.setRemote(model.isRemote());
		soapModel.setCity(model.getCity());
		soapModel.setCountry(model.getCountry());
		soapModel.setState(model.getState());
		soapModel.setPostalCode(model.getPostalCode());

		return soapModel;
	}

	public static AddressinfoSoap[] toSoapModels(Addressinfo[] models) {
		AddressinfoSoap[] soapModels = new AddressinfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AddressinfoSoap[][] toSoapModels(Addressinfo[][] models) {
		AddressinfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AddressinfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AddressinfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AddressinfoSoap[] toSoapModels(List<Addressinfo> models) {
		List<AddressinfoSoap> soapModels = new ArrayList<AddressinfoSoap>(
			models.size());

		for (Addressinfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AddressinfoSoap[soapModels.size()]);
	}

	public AddressinfoSoap() {
	}

	public long getPrimaryKey() {
		return _addressId;
	}

	public void setPrimaryKey(long pk) {
		setAddressId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
	}

	public long getJobId() {
		return _jobId;
	}

	public void setJobId(long jobId) {
		_jobId = jobId;
	}

	public boolean getRemote() {
		return _remote;
	}

	public boolean isRemote() {
		return _remote;
	}

	public void setRemote(boolean remote) {
		_remote = remote;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public long getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(long postalCode) {
		_postalCode = postalCode;
	}

	private String _uuid;
	private long _addressId;
	private long _jobId;
	private boolean _remote;
	private String _city;
	private String _country;
	private String _state;
	private long _postalCode;

}