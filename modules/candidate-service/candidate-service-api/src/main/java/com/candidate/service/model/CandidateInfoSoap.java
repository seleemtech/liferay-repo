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

package com.candidate.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.candidate.service.service.http.CandidateInfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CandidateInfoSoap implements Serializable {

	public static CandidateInfoSoap toSoapModel(CandidateInfo model) {
		CandidateInfoSoap soapModel = new CandidateInfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmail(model.getEmail());
		soapModel.setSecondaryEmail(model.getSecondaryEmail());
		soapModel.setMobileNumber(model.getMobileNumber());
		soapModel.setStreet(model.getStreet());
		soapModel.setCountry(model.getCountry());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setHouseNumber(model.getHouseNumber());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static CandidateInfoSoap[] toSoapModels(CandidateInfo[] models) {
		CandidateInfoSoap[] soapModels = new CandidateInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateInfoSoap[][] toSoapModels(CandidateInfo[][] models) {
		CandidateInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateInfoSoap[] toSoapModels(List<CandidateInfo> models) {
		List<CandidateInfoSoap> soapModels = new ArrayList<CandidateInfoSoap>(
			models.size());

		for (CandidateInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateInfoSoap[soapModels.size()]);
	}

	public CandidateInfoSoap() {
	}

	public long getPrimaryKey() {
		return _candidateId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getSecondaryEmail() {
		return _secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		_secondaryEmail = secondaryEmail;
	}

	public String getMobileNumber() {
		return _mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		_mobileNumber = mobileNumber;
	}

	public String getStreet() {
		return _street;
	}

	public void setStreet(String street) {
		_street = street;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public String getHouseNumber() {
		return _houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		_houseNumber = houseNumber;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private String _uuid;
	private long _candidateId;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _secondaryEmail;
	private String _mobileNumber;
	private String _street;
	private String _country;
	private String _city;
	private String _state;
	private String _zipCode;
	private String _houseNumber;
	private String _website;
	private long _companyId;
	private long _userId;

}