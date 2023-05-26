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

import com.prime.data.service.model.JobType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing JobType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JobTypeCacheModel implements CacheModel<JobType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JobTypeCacheModel)) {
			return false;
		}

		JobTypeCacheModel jobTypeCacheModel = (JobTypeCacheModel)object;

		if (jobTypeId == jobTypeCacheModel.jobTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, jobTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", jobTypeId=");
		sb.append(jobTypeId);
		sb.append(", jobType=");
		sb.append(jobType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobType toEntityModel() {
		JobTypeImpl jobTypeImpl = new JobTypeImpl();

		if (uuid == null) {
			jobTypeImpl.setUuid("");
		}
		else {
			jobTypeImpl.setUuid(uuid);
		}

		jobTypeImpl.setJobTypeId(jobTypeId);

		if (jobType == null) {
			jobTypeImpl.setJobType("");
		}
		else {
			jobTypeImpl.setJobType(jobType);
		}

		jobTypeImpl.resetOriginalValues();

		return jobTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		jobTypeId = objectInput.readLong();
		jobType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(jobTypeId);

		if (jobType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobType);
		}
	}

	public String uuid;
	public long jobTypeId;
	public String jobType;

}