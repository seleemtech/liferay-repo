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

package com.job.opening.service.model.impl;

import com.job.opening.service.model.Descriptiveinfo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Descriptiveinfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DescriptiveinfoCacheModel
	implements CacheModel<Descriptiveinfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DescriptiveinfoCacheModel)) {
			return false;
		}

		DescriptiveinfoCacheModel descriptiveinfoCacheModel =
			(DescriptiveinfoCacheModel)object;

		if (descriptiveId == descriptiveinfoCacheModel.descriptiveId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, descriptiveId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", descriptiveId=");
		sb.append(descriptiveId);
		sb.append(", jobId=");
		sb.append(jobId);
		sb.append(", jobDescription=");
		sb.append(jobDescription);
		sb.append(", requirements=");
		sb.append(requirements);
		sb.append(", benefits=");
		sb.append(benefits);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Descriptiveinfo toEntityModel() {
		DescriptiveinfoImpl descriptiveinfoImpl = new DescriptiveinfoImpl();

		if (uuid == null) {
			descriptiveinfoImpl.setUuid("");
		}
		else {
			descriptiveinfoImpl.setUuid(uuid);
		}

		descriptiveinfoImpl.setDescriptiveId(descriptiveId);
		descriptiveinfoImpl.setJobId(jobId);

		if (jobDescription == null) {
			descriptiveinfoImpl.setJobDescription("");
		}
		else {
			descriptiveinfoImpl.setJobDescription(jobDescription);
		}

		if (requirements == null) {
			descriptiveinfoImpl.setRequirements("");
		}
		else {
			descriptiveinfoImpl.setRequirements(requirements);
		}

		if (benefits == null) {
			descriptiveinfoImpl.setBenefits("");
		}
		else {
			descriptiveinfoImpl.setBenefits(benefits);
		}

		descriptiveinfoImpl.resetOriginalValues();

		return descriptiveinfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		descriptiveId = objectInput.readLong();

		jobId = objectInput.readLong();
		jobDescription = objectInput.readUTF();
		requirements = objectInput.readUTF();
		benefits = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(descriptiveId);

		objectOutput.writeLong(jobId);

		if (jobDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobDescription);
		}

		if (requirements == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requirements);
		}

		if (benefits == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(benefits);
		}
	}

	public String uuid;
	public long descriptiveId;
	public long jobId;
	public String jobDescription;
	public String requirements;
	public String benefits;

}