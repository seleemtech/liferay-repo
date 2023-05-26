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

import com.prime.data.service.model.JobOpeningStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing JobOpeningStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JobOpeningStatusCacheModel
	implements CacheModel<JobOpeningStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JobOpeningStatusCacheModel)) {
			return false;
		}

		JobOpeningStatusCacheModel jobOpeningStatusCacheModel =
			(JobOpeningStatusCacheModel)object;

		if (jobStatusId == jobOpeningStatusCacheModel.jobStatusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, jobStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", jobStatusId=");
		sb.append(jobStatusId);
		sb.append(", jobOpeningStatus=");
		sb.append(jobOpeningStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public JobOpeningStatus toEntityModel() {
		JobOpeningStatusImpl jobOpeningStatusImpl = new JobOpeningStatusImpl();

		if (uuid == null) {
			jobOpeningStatusImpl.setUuid("");
		}
		else {
			jobOpeningStatusImpl.setUuid(uuid);
		}

		jobOpeningStatusImpl.setJobStatusId(jobStatusId);

		if (jobOpeningStatus == null) {
			jobOpeningStatusImpl.setJobOpeningStatus("");
		}
		else {
			jobOpeningStatusImpl.setJobOpeningStatus(jobOpeningStatus);
		}

		jobOpeningStatusImpl.resetOriginalValues();

		return jobOpeningStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		jobStatusId = objectInput.readLong();
		jobOpeningStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(jobStatusId);

		if (jobOpeningStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobOpeningStatus);
		}
	}

	public String uuid;
	public long jobStatusId;
	public String jobOpeningStatus;

}