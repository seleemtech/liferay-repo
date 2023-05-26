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

package com.intranet.model.impl;

import com.intranet.model.Specialization;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Specialization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SpecializationCacheModel
	implements CacheModel<Specialization>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SpecializationCacheModel)) {
			return false;
		}

		SpecializationCacheModel specializationCacheModel =
			(SpecializationCacheModel)object;

		if (spCode == specializationCacheModel.spCode) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, spCode);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{graduationCode=");
		sb.append(graduationCode);
		sb.append(", specializationName=");
		sb.append(specializationName);
		sb.append(", spCode=");
		sb.append(spCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Specialization toEntityModel() {
		SpecializationImpl specializationImpl = new SpecializationImpl();

		if (graduationCode == null) {
			specializationImpl.setGraduationCode("");
		}
		else {
			specializationImpl.setGraduationCode(graduationCode);
		}

		if (specializationName == null) {
			specializationImpl.setSpecializationName("");
		}
		else {
			specializationImpl.setSpecializationName(specializationName);
		}

		specializationImpl.setSpCode(spCode);

		specializationImpl.resetOriginalValues();

		return specializationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		graduationCode = objectInput.readUTF();
		specializationName = objectInput.readUTF();

		spCode = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (graduationCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(graduationCode);
		}

		if (specializationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specializationName);
		}

		objectOutput.writeLong(spCode);
	}

	public String graduationCode;
	public String specializationName;
	public long spCode;

}