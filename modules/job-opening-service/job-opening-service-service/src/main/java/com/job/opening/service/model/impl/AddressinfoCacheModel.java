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

package com.job.opening.service.model.impl;

import com.job.opening.service.model.Addressinfo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Addressinfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AddressinfoCacheModel
	implements CacheModel<Addressinfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AddressinfoCacheModel)) {
			return false;
		}

		AddressinfoCacheModel addressinfoCacheModel =
			(AddressinfoCacheModel)object;

		if (addressId == addressinfoCacheModel.addressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", addressId=");
		sb.append(addressId);
		sb.append(", jobId=");
		sb.append(jobId);
		sb.append(", remote=");
		sb.append(remote);
		sb.append(", city=");
		sb.append(city);
		sb.append(", country=");
		sb.append(country);
		sb.append(", state=");
		sb.append(state);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Addressinfo toEntityModel() {
		AddressinfoImpl addressinfoImpl = new AddressinfoImpl();

		if (uuid == null) {
			addressinfoImpl.setUuid("");
		}
		else {
			addressinfoImpl.setUuid(uuid);
		}

		addressinfoImpl.setAddressId(addressId);
		addressinfoImpl.setJobId(jobId);
		addressinfoImpl.setRemote(remote);

		if (city == null) {
			addressinfoImpl.setCity("");
		}
		else {
			addressinfoImpl.setCity(city);
		}

		if (country == null) {
			addressinfoImpl.setCountry("");
		}
		else {
			addressinfoImpl.setCountry(country);
		}

		if (state == null) {
			addressinfoImpl.setState("");
		}
		else {
			addressinfoImpl.setState(state);
		}

		addressinfoImpl.setPostalCode(postalCode);

		addressinfoImpl.resetOriginalValues();

		return addressinfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		addressId = objectInput.readLong();

		jobId = objectInput.readLong();

		remote = objectInput.readBoolean();
		city = objectInput.readUTF();
		country = objectInput.readUTF();
		state = objectInput.readUTF();

		postalCode = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(addressId);

		objectOutput.writeLong(jobId);

		objectOutput.writeBoolean(remote);

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (country == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeLong(postalCode);
	}

	public String uuid;
	public long addressId;
	public long jobId;
	public boolean remote;
	public String city;
	public String country;
	public String state;
	public long postalCode;

}