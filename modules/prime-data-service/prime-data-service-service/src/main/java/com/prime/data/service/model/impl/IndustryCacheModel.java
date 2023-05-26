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

import com.prime.data.service.model.Industry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Industry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class IndustryCacheModel
	implements CacheModel<Industry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IndustryCacheModel)) {
			return false;
		}

		IndustryCacheModel industryCacheModel = (IndustryCacheModel)object;

		if (industryId == industryCacheModel.industryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, industryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", industryId=");
		sb.append(industryId);
		sb.append(", industryName=");
		sb.append(industryName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Industry toEntityModel() {
		IndustryImpl industryImpl = new IndustryImpl();

		if (uuid == null) {
			industryImpl.setUuid("");
		}
		else {
			industryImpl.setUuid(uuid);
		}

		industryImpl.setIndustryId(industryId);

		if (industryName == null) {
			industryImpl.setIndustryName("");
		}
		else {
			industryImpl.setIndustryName(industryName);
		}

		industryImpl.resetOriginalValues();

		return industryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		industryId = objectInput.readLong();
		industryName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(industryId);

		if (industryName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(industryName);
		}
	}

	public String uuid;
	public long industryId;
	public String industryName;

}