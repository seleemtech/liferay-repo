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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CandidateInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateInfo
 * @generated
 */
public class CandidateInfoWrapper
	extends BaseModelWrapper<CandidateInfo>
	implements CandidateInfo, ModelWrapper<CandidateInfo> {

	public CandidateInfoWrapper(CandidateInfo candidateInfo) {
		super(candidateInfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("candidateId", getCandidateId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("secondaryEmail", getSecondaryEmail());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("street", getStreet());
		attributes.put("country", getCountry());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zipCode", getZipCode());
		attributes.put("houseNumber", getHouseNumber());
		attributes.put("website", getWebsite());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String secondaryEmail = (String)attributes.get("secondaryEmail");

		if (secondaryEmail != null) {
			setSecondaryEmail(secondaryEmail);
		}

		String mobileNumber = (String)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		String street = (String)attributes.get("street");

		if (street != null) {
			setStreet(street);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String houseNumber = (String)attributes.get("houseNumber");

		if (houseNumber != null) {
			setHouseNumber(houseNumber);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public CandidateInfo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the candidate ID of this candidate info.
	 *
	 * @return the candidate ID of this candidate info
	 */
	@Override
	public long getCandidateId() {
		return model.getCandidateId();
	}

	/**
	 * Returns the city of this candidate info.
	 *
	 * @return the city of this candidate info
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this candidate info.
	 *
	 * @return the company ID of this candidate info
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the country of this candidate info.
	 *
	 * @return the country of this candidate info
	 */
	@Override
	public String getCountry() {
		return model.getCountry();
	}

	/**
	 * Returns the email of this candidate info.
	 *
	 * @return the email of this candidate info
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the first name of this candidate info.
	 *
	 * @return the first name of this candidate info
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the house number of this candidate info.
	 *
	 * @return the house number of this candidate info
	 */
	@Override
	public String getHouseNumber() {
		return model.getHouseNumber();
	}

	/**
	 * Returns the last name of this candidate info.
	 *
	 * @return the last name of this candidate info
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the mobile number of this candidate info.
	 *
	 * @return the mobile number of this candidate info
	 */
	@Override
	public String getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the primary key of this candidate info.
	 *
	 * @return the primary key of this candidate info
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the secondary email of this candidate info.
	 *
	 * @return the secondary email of this candidate info
	 */
	@Override
	public String getSecondaryEmail() {
		return model.getSecondaryEmail();
	}

	/**
	 * Returns the state of this candidate info.
	 *
	 * @return the state of this candidate info
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the street of this candidate info.
	 *
	 * @return the street of this candidate info
	 */
	@Override
	public String getStreet() {
		return model.getStreet();
	}

	/**
	 * Returns the user ID of this candidate info.
	 *
	 * @return the user ID of this candidate info
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this candidate info.
	 *
	 * @return the user uuid of this candidate info
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this candidate info.
	 *
	 * @return the uuid of this candidate info
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the website of this candidate info.
	 *
	 * @return the website of this candidate info
	 */
	@Override
	public String getWebsite() {
		return model.getWebsite();
	}

	/**
	 * Returns the zip code of this candidate info.
	 *
	 * @return the zip code of this candidate info
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the candidate ID of this candidate info.
	 *
	 * @param candidateId the candidate ID of this candidate info
	 */
	@Override
	public void setCandidateId(long candidateId) {
		model.setCandidateId(candidateId);
	}

	/**
	 * Sets the city of this candidate info.
	 *
	 * @param city the city of this candidate info
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this candidate info.
	 *
	 * @param companyId the company ID of this candidate info
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the country of this candidate info.
	 *
	 * @param country the country of this candidate info
	 */
	@Override
	public void setCountry(String country) {
		model.setCountry(country);
	}

	/**
	 * Sets the email of this candidate info.
	 *
	 * @param email the email of this candidate info
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the first name of this candidate info.
	 *
	 * @param firstName the first name of this candidate info
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the house number of this candidate info.
	 *
	 * @param houseNumber the house number of this candidate info
	 */
	@Override
	public void setHouseNumber(String houseNumber) {
		model.setHouseNumber(houseNumber);
	}

	/**
	 * Sets the last name of this candidate info.
	 *
	 * @param lastName the last name of this candidate info
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets the mobile number of this candidate info.
	 *
	 * @param mobileNumber the mobile number of this candidate info
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the primary key of this candidate info.
	 *
	 * @param primaryKey the primary key of this candidate info
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the secondary email of this candidate info.
	 *
	 * @param secondaryEmail the secondary email of this candidate info
	 */
	@Override
	public void setSecondaryEmail(String secondaryEmail) {
		model.setSecondaryEmail(secondaryEmail);
	}

	/**
	 * Sets the state of this candidate info.
	 *
	 * @param state the state of this candidate info
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the street of this candidate info.
	 *
	 * @param street the street of this candidate info
	 */
	@Override
	public void setStreet(String street) {
		model.setStreet(street);
	}

	/**
	 * Sets the user ID of this candidate info.
	 *
	 * @param userId the user ID of this candidate info
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this candidate info.
	 *
	 * @param userUuid the user uuid of this candidate info
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this candidate info.
	 *
	 * @param uuid the uuid of this candidate info
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the website of this candidate info.
	 *
	 * @param website the website of this candidate info
	 */
	@Override
	public void setWebsite(String website) {
		model.setWebsite(website);
	}

	/**
	 * Sets the zip code of this candidate info.
	 *
	 * @param zipCode the zip code of this candidate info
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected CandidateInfoWrapper wrap(CandidateInfo candidateInfo) {
		return new CandidateInfoWrapper(candidateInfo);
	}

}