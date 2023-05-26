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

import com.prime.data.service.model.WorkExperience;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing WorkExperience in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkExperienceCacheModel
	implements CacheModel<WorkExperience>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkExperienceCacheModel)) {
			return false;
		}

		WorkExperienceCacheModel workExperienceCacheModel =
			(WorkExperienceCacheModel)object;

		if (workExpId == workExperienceCacheModel.workExpId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, workExpId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", workExpId=");
		sb.append(workExpId);
		sb.append(", workExpRange=");
		sb.append(workExpRange);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkExperience toEntityModel() {
		WorkExperienceImpl workExperienceImpl = new WorkExperienceImpl();

		if (uuid == null) {
			workExperienceImpl.setUuid("");
		}
		else {
			workExperienceImpl.setUuid(uuid);
		}

		workExperienceImpl.setWorkExpId(workExpId);

		if (workExpRange == null) {
			workExperienceImpl.setWorkExpRange("");
		}
		else {
			workExperienceImpl.setWorkExpRange(workExpRange);
		}

		workExperienceImpl.resetOriginalValues();

		return workExperienceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		workExpId = objectInput.readLong();
		workExpRange = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(workExpId);

		if (workExpRange == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workExpRange);
		}
	}

	public String uuid;
	public long workExpId;
	public String workExpRange;

}