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

package com.rigistration.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.rigistration.service.model.Register;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Register in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RegisterCacheModel
	implements CacheModel<Register>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RegisterCacheModel)) {
			return false;
		}

		RegisterCacheModel registerCacheModel = (RegisterCacheModel)object;

		if (registerId == registerCacheModel.registerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, registerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", registerId=");
		sb.append(registerId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", password=");
		sb.append(password);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Register toEntityModel() {
		RegisterImpl registerImpl = new RegisterImpl();

		if (uuid == null) {
			registerImpl.setUuid("");
		}
		else {
			registerImpl.setUuid(uuid);
		}

		registerImpl.setRegisterId(registerId);

		if (firstName == null) {
			registerImpl.setFirstName("");
		}
		else {
			registerImpl.setFirstName(firstName);
		}

		registerImpl.setPhone(phone);

		if (userName == null) {
			registerImpl.setUserName("");
		}
		else {
			registerImpl.setUserName(userName);
		}

		if (password == null) {
			registerImpl.setPassword("");
		}
		else {
			registerImpl.setPassword(password);
		}

		registerImpl.resetOriginalValues();

		return registerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		registerId = objectInput.readLong();
		firstName = objectInput.readUTF();

		phone = objectInput.readLong();
		userName = objectInput.readUTF();
		password = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(registerId);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		objectOutput.writeLong(phone);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}
	}

	public String uuid;
	public long registerId;
	public String firstName;
	public long phone;
	public String userName;
	public String password;

}