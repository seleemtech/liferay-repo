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

import com.intranet.model.Graduation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Graduation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GraduationCacheModel
	implements CacheModel<Graduation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GraduationCacheModel)) {
			return false;
		}

		GraduationCacheModel graduationCacheModel =
			(GraduationCacheModel)object;

		if (graduationCode.equals(graduationCacheModel.graduationCode)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, graduationCode);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{graduationCode=");
		sb.append(graduationCode);
		sb.append(", graduationName=");
		sb.append(graduationName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Graduation toEntityModel() {
		GraduationImpl graduationImpl = new GraduationImpl();

		if (graduationCode == null) {
			graduationImpl.setGraduationCode("");
		}
		else {
			graduationImpl.setGraduationCode(graduationCode);
		}

		if (graduationName == null) {
			graduationImpl.setGraduationName("");
		}
		else {
			graduationImpl.setGraduationName(graduationName);
		}

		graduationImpl.resetOriginalValues();

		return graduationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		graduationCode = objectInput.readUTF();
		graduationName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (graduationCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(graduationCode);
		}

		if (graduationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(graduationName);
		}
	}

	public String graduationCode;
	public String graduationName;

}