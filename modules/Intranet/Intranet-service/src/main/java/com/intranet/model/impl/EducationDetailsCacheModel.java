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

import com.intranet.model.EducationDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EducationDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EducationDetailsCacheModel
	implements CacheModel<EducationDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EducationDetailsCacheModel)) {
			return false;
		}

		EducationDetailsCacheModel educationDetailsCacheModel =
			(EducationDetailsCacheModel)object;

		if (educationId == educationDetailsCacheModel.educationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, educationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{educationId=");
		sb.append(educationId);
		sb.append(", employeeID=");
		sb.append(employeeID);
		sb.append(", pgGraduation=");
		sb.append(pgGraduation);
		sb.append(", pgSpecialization=");
		sb.append(pgSpecialization);
		sb.append(", pgUniversity=");
		sb.append(pgUniversity);
		sb.append(", pgPassout=");
		sb.append(pgPassout);
		sb.append(", pgPercentage=");
		sb.append(pgPercentage);
		sb.append(", graduation=");
		sb.append(graduation);
		sb.append(", specialization=");
		sb.append(specialization);
		sb.append(", university=");
		sb.append(university);
		sb.append(", passout=");
		sb.append(passout);
		sb.append(", percentage=");
		sb.append(percentage);
		sb.append(", hscSchool=");
		sb.append(hscSchool);
		sb.append(", hscPassout=");
		sb.append(hscPassout);
		sb.append(", hscPercentage=");
		sb.append(hscPercentage);
		sb.append(", sslcSchool=");
		sb.append(sslcSchool);
		sb.append(", sslcPassout=");
		sb.append(sslcPassout);
		sb.append(", sslcPercentage=");
		sb.append(sslcPercentage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EducationDetails toEntityModel() {
		EducationDetailsImpl educationDetailsImpl = new EducationDetailsImpl();

		educationDetailsImpl.setEducationId(educationId);
		educationDetailsImpl.setEmployeeID(employeeID);

		if (pgGraduation == null) {
			educationDetailsImpl.setPgGraduation("");
		}
		else {
			educationDetailsImpl.setPgGraduation(pgGraduation);
		}

		if (pgSpecialization == null) {
			educationDetailsImpl.setPgSpecialization("");
		}
		else {
			educationDetailsImpl.setPgSpecialization(pgSpecialization);
		}

		if (pgUniversity == null) {
			educationDetailsImpl.setPgUniversity("");
		}
		else {
			educationDetailsImpl.setPgUniversity(pgUniversity);
		}

		if (pgPassout == null) {
			educationDetailsImpl.setPgPassout("");
		}
		else {
			educationDetailsImpl.setPgPassout(pgPassout);
		}

		if (pgPercentage == null) {
			educationDetailsImpl.setPgPercentage("");
		}
		else {
			educationDetailsImpl.setPgPercentage(pgPercentage);
		}

		if (graduation == null) {
			educationDetailsImpl.setGraduation("");
		}
		else {
			educationDetailsImpl.setGraduation(graduation);
		}

		if (specialization == null) {
			educationDetailsImpl.setSpecialization("");
		}
		else {
			educationDetailsImpl.setSpecialization(specialization);
		}

		if (university == null) {
			educationDetailsImpl.setUniversity("");
		}
		else {
			educationDetailsImpl.setUniversity(university);
		}

		if (passout == null) {
			educationDetailsImpl.setPassout("");
		}
		else {
			educationDetailsImpl.setPassout(passout);
		}

		if (percentage == null) {
			educationDetailsImpl.setPercentage("");
		}
		else {
			educationDetailsImpl.setPercentage(percentage);
		}

		if (hscSchool == null) {
			educationDetailsImpl.setHscSchool("");
		}
		else {
			educationDetailsImpl.setHscSchool(hscSchool);
		}

		if (hscPassout == null) {
			educationDetailsImpl.setHscPassout("");
		}
		else {
			educationDetailsImpl.setHscPassout(hscPassout);
		}

		if (hscPercentage == null) {
			educationDetailsImpl.setHscPercentage("");
		}
		else {
			educationDetailsImpl.setHscPercentage(hscPercentage);
		}

		if (sslcSchool == null) {
			educationDetailsImpl.setSslcSchool("");
		}
		else {
			educationDetailsImpl.setSslcSchool(sslcSchool);
		}

		if (sslcPassout == null) {
			educationDetailsImpl.setSslcPassout("");
		}
		else {
			educationDetailsImpl.setSslcPassout(sslcPassout);
		}

		if (sslcPercentage == null) {
			educationDetailsImpl.setSslcPercentage("");
		}
		else {
			educationDetailsImpl.setSslcPercentage(sslcPercentage);
		}

		educationDetailsImpl.resetOriginalValues();

		return educationDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		educationId = objectInput.readLong();

		employeeID = objectInput.readLong();
		pgGraduation = objectInput.readUTF();
		pgSpecialization = objectInput.readUTF();
		pgUniversity = objectInput.readUTF();
		pgPassout = objectInput.readUTF();
		pgPercentage = objectInput.readUTF();
		graduation = objectInput.readUTF();
		specialization = objectInput.readUTF();
		university = objectInput.readUTF();
		passout = objectInput.readUTF();
		percentage = objectInput.readUTF();
		hscSchool = objectInput.readUTF();
		hscPassout = objectInput.readUTF();
		hscPercentage = objectInput.readUTF();
		sslcSchool = objectInput.readUTF();
		sslcPassout = objectInput.readUTF();
		sslcPercentage = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(educationId);

		objectOutput.writeLong(employeeID);

		if (pgGraduation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pgGraduation);
		}

		if (pgSpecialization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pgSpecialization);
		}

		if (pgUniversity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pgUniversity);
		}

		if (pgPassout == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pgPassout);
		}

		if (pgPercentage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pgPercentage);
		}

		if (graduation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(graduation);
		}

		if (specialization == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(specialization);
		}

		if (university == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(university);
		}

		if (passout == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(passout);
		}

		if (percentage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(percentage);
		}

		if (hscSchool == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hscSchool);
		}

		if (hscPassout == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hscPassout);
		}

		if (hscPercentage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hscPercentage);
		}

		if (sslcSchool == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sslcSchool);
		}

		if (sslcPassout == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sslcPassout);
		}

		if (sslcPercentage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sslcPercentage);
		}
	}

	public long educationId;
	public long employeeID;
	public String pgGraduation;
	public String pgSpecialization;
	public String pgUniversity;
	public String pgPassout;
	public String pgPercentage;
	public String graduation;
	public String specialization;
	public String university;
	public String passout;
	public String percentage;
	public String hscSchool;
	public String hscPassout;
	public String hscPercentage;
	public String sslcSchool;
	public String sslcPassout;
	public String sslcPercentage;

}