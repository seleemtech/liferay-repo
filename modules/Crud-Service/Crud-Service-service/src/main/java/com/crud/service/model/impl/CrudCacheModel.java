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

package com.crud.service.model.impl;

import com.crud.service.model.Crud;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Crud in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CrudCacheModel implements CacheModel<Crud>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CrudCacheModel)) {
			return false;
		}

		CrudCacheModel crudCacheModel = (CrudCacheModel)object;

		if (crudId == crudCacheModel.crudId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, crudId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", crudId=");
		sb.append(crudId);
		sb.append(", crudNo=");
		sb.append(crudNo);
		sb.append(", crudName=");
		sb.append(crudName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Crud toEntityModel() {
		CrudImpl crudImpl = new CrudImpl();

		if (uuid == null) {
			crudImpl.setUuid("");
		}
		else {
			crudImpl.setUuid(uuid);
		}

		crudImpl.setCrudId(crudId);
		crudImpl.setCrudNo(crudNo);

		if (crudName == null) {
			crudImpl.setCrudName("");
		}
		else {
			crudImpl.setCrudName(crudName);
		}

		crudImpl.resetOriginalValues();

		return crudImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		crudId = objectInput.readLong();

		crudNo = objectInput.readLong();
		crudName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(crudId);

		objectOutput.writeLong(crudNo);

		if (crudName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(crudName);
		}
	}

	public String uuid;
	public long crudId;
	public long crudNo;
	public String crudName;

}