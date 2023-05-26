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

package com.prime.data.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.prime.data.service.model.NamePrefix;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing NamePrefix in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NamePrefixCacheModel
	implements CacheModel<NamePrefix>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NamePrefixCacheModel)) {
			return false;
		}

		NamePrefixCacheModel namePrefixCacheModel =
			(NamePrefixCacheModel)object;

		if (namePrefixId == namePrefixCacheModel.namePrefixId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, namePrefixId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", namePrefixId=");
		sb.append(namePrefixId);
		sb.append(", namePrefix=");
		sb.append(namePrefix);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NamePrefix toEntityModel() {
		NamePrefixImpl namePrefixImpl = new NamePrefixImpl();

		if (uuid == null) {
			namePrefixImpl.setUuid("");
		}
		else {
			namePrefixImpl.setUuid(uuid);
		}

		namePrefixImpl.setNamePrefixId(namePrefixId);

		if (namePrefix == null) {
			namePrefixImpl.setNamePrefix("");
		}
		else {
			namePrefixImpl.setNamePrefix(namePrefix);
		}

		namePrefixImpl.resetOriginalValues();

		return namePrefixImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		namePrefixId = objectInput.readLong();
		namePrefix = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(namePrefixId);

		if (namePrefix == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(namePrefix);
		}
	}

	public String uuid;
	public long namePrefixId;
	public String namePrefix;

}