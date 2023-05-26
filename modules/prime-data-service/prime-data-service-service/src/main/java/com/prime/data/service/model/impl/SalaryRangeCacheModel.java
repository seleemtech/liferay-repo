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

import com.prime.data.service.model.SalaryRange;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SalaryRange in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SalaryRangeCacheModel
	implements CacheModel<SalaryRange>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SalaryRangeCacheModel)) {
			return false;
		}

		SalaryRangeCacheModel salaryRangeCacheModel =
			(SalaryRangeCacheModel)object;

		if (salaryRangeId == salaryRangeCacheModel.salaryRangeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, salaryRangeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", salaryRangeId=");
		sb.append(salaryRangeId);
		sb.append(", salaryRange=");
		sb.append(salaryRange);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SalaryRange toEntityModel() {
		SalaryRangeImpl salaryRangeImpl = new SalaryRangeImpl();

		if (uuid == null) {
			salaryRangeImpl.setUuid("");
		}
		else {
			salaryRangeImpl.setUuid(uuid);
		}

		salaryRangeImpl.setSalaryRangeId(salaryRangeId);

		if (salaryRange == null) {
			salaryRangeImpl.setSalaryRange("");
		}
		else {
			salaryRangeImpl.setSalaryRange(salaryRange);
		}

		salaryRangeImpl.resetOriginalValues();

		return salaryRangeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		salaryRangeId = objectInput.readLong();
		salaryRange = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(salaryRangeId);

		if (salaryRange == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salaryRange);
		}
	}

	public String uuid;
	public long salaryRangeId;
	public String salaryRange;

}