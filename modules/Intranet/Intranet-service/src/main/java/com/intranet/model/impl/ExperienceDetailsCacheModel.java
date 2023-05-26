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

import com.intranet.model.ExperienceDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExperienceDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ExperienceDetailsCacheModel
	implements CacheModel<ExperienceDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExperienceDetailsCacheModel)) {
			return false;
		}

		ExperienceDetailsCacheModel experienceDetailsCacheModel =
			(ExperienceDetailsCacheModel)object;

		if (experienceId == experienceDetailsCacheModel.experienceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, experienceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{experienceId=");
		sb.append(experienceId);
		sb.append(", employeeID=");
		sb.append(employeeID);
		sb.append(", organization=");
		sb.append(organization);
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExperienceDetails toEntityModel() {
		ExperienceDetailsImpl experienceDetailsImpl =
			new ExperienceDetailsImpl();

		experienceDetailsImpl.setExperienceId(experienceId);
		experienceDetailsImpl.setEmployeeID(employeeID);

		if (organization == null) {
			experienceDetailsImpl.setOrganization("");
		}
		else {
			experienceDetailsImpl.setOrganization(organization);
		}

		if (designation == null) {
			experienceDetailsImpl.setDesignation("");
		}
		else {
			experienceDetailsImpl.setDesignation(designation);
		}

		if (startDate == Long.MIN_VALUE) {
			experienceDetailsImpl.setStartDate(null);
		}
		else {
			experienceDetailsImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			experienceDetailsImpl.setEndDate(null);
		}
		else {
			experienceDetailsImpl.setEndDate(new Date(endDate));
		}

		experienceDetailsImpl.resetOriginalValues();

		return experienceDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		experienceId = objectInput.readLong();

		employeeID = objectInput.readLong();
		organization = objectInput.readUTF();
		designation = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(experienceId);

		objectOutput.writeLong(employeeID);

		if (organization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(organization);
		}

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
	}

	public long experienceId;
	public long employeeID;
	public String organization;
	public String designation;
	public long startDate;
	public long endDate;

}