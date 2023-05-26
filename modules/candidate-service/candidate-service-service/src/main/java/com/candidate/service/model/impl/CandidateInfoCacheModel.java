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

package com.candidate.service.model.impl;

import com.candidate.service.model.CandidateInfo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CandidateInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CandidateInfoCacheModel
	implements CacheModel<CandidateInfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CandidateInfoCacheModel)) {
			return false;
		}

		CandidateInfoCacheModel candidateInfoCacheModel =
			(CandidateInfoCacheModel)object;

		if (candidateId == candidateInfoCacheModel.candidateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, candidateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", candidateId=");
		sb.append(candidateId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", secondaryEmail=");
		sb.append(secondaryEmail);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", street=");
		sb.append(street);
		sb.append(", country=");
		sb.append(country);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", houseNumber=");
		sb.append(houseNumber);
		sb.append(", website=");
		sb.append(website);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CandidateInfo toEntityModel() {
		CandidateInfoImpl candidateInfoImpl = new CandidateInfoImpl();

		if (uuid == null) {
			candidateInfoImpl.setUuid("");
		}
		else {
			candidateInfoImpl.setUuid(uuid);
		}

		candidateInfoImpl.setCandidateId(candidateId);

		if (firstName == null) {
			candidateInfoImpl.setFirstName("");
		}
		else {
			candidateInfoImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			candidateInfoImpl.setLastName("");
		}
		else {
			candidateInfoImpl.setLastName(lastName);
		}

		if (email == null) {
			candidateInfoImpl.setEmail("");
		}
		else {
			candidateInfoImpl.setEmail(email);
		}

		if (secondaryEmail == null) {
			candidateInfoImpl.setSecondaryEmail("");
		}
		else {
			candidateInfoImpl.setSecondaryEmail(secondaryEmail);
		}

		if (mobileNumber == null) {
			candidateInfoImpl.setMobileNumber("");
		}
		else {
			candidateInfoImpl.setMobileNumber(mobileNumber);
		}

		if (street == null) {
			candidateInfoImpl.setStreet("");
		}
		else {
			candidateInfoImpl.setStreet(street);
		}

		if (country == null) {
			candidateInfoImpl.setCountry("");
		}
		else {
			candidateInfoImpl.setCountry(country);
		}

		if (city == null) {
			candidateInfoImpl.setCity("");
		}
		else {
			candidateInfoImpl.setCity(city);
		}

		if (state == null) {
			candidateInfoImpl.setState("");
		}
		else {
			candidateInfoImpl.setState(state);
		}

		if (zipCode == null) {
			candidateInfoImpl.setZipCode("");
		}
		else {
			candidateInfoImpl.setZipCode(zipCode);
		}

		if (houseNumber == null) {
			candidateInfoImpl.setHouseNumber("");
		}
		else {
			candidateInfoImpl.setHouseNumber(houseNumber);
		}

		if (website == null) {
			candidateInfoImpl.setWebsite("");
		}
		else {
			candidateInfoImpl.setWebsite(website);
		}

		candidateInfoImpl.setCompanyId(companyId);
		candidateInfoImpl.setUserId(userId);

		candidateInfoImpl.resetOriginalValues();

		return candidateInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		candidateId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		email = objectInput.readUTF();
		secondaryEmail = objectInput.readUTF();
		mobileNumber = objectInput.readUTF();
		street = objectInput.readUTF();
		country = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		houseNumber = objectInput.readUTF();
		website = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(candidateId);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (secondaryEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(secondaryEmail);
		}

		if (mobileNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobileNumber);
		}

		if (street == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(street);
		}

		if (country == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (houseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(houseNumber);
		}

		if (website == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(website);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
	}

	public String uuid;
	public long candidateId;
	public String firstName;
	public String lastName;
	public String email;
	public String secondaryEmail;
	public String mobileNumber;
	public String street;
	public String country;
	public String city;
	public String state;
	public String zipCode;
	public String houseNumber;
	public String website;
	public long companyId;
	public long userId;

}