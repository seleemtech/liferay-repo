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

package com.candidate.service.model.impl;

import com.candidate.service.model.ProfessionalDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProfessionalDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProfessionalDetailsCacheModel
	implements CacheModel<ProfessionalDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProfessionalDetailsCacheModel)) {
			return false;
		}

		ProfessionalDetailsCacheModel professionalDetailsCacheModel =
			(ProfessionalDetailsCacheModel)object;

		if (professionalDetailsId ==
				professionalDetailsCacheModel.professionalDetailsId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, professionalDetailsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", professionalDetailsId=");
		sb.append(professionalDetailsId);
		sb.append(", candidateId=");
		sb.append(candidateId);
		sb.append(", expectedSalary=");
		sb.append(expectedSalary);
		sb.append(", currentSalary=");
		sb.append(currentSalary);
		sb.append(", skillSet=");
		sb.append(skillSet);
		sb.append(", additionalInfo=");
		sb.append(additionalInfo);
		sb.append(", currentEmployer=");
		sb.append(currentEmployer);
		sb.append(", workType=");
		sb.append(workType);
		sb.append(", experience =");
		sb.append(experience);
		sb.append(", qualification=");
		sb.append(qualification);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProfessionalDetails toEntityModel() {
		ProfessionalDetailsImpl professionalDetailsImpl =
			new ProfessionalDetailsImpl();

		if (uuid == null) {
			professionalDetailsImpl.setUuid("");
		}
		else {
			professionalDetailsImpl.setUuid(uuid);
		}

		professionalDetailsImpl.setProfessionalDetailsId(professionalDetailsId);
		professionalDetailsImpl.setCandidateId(candidateId);
		professionalDetailsImpl.setExpectedSalary(expectedSalary);
		professionalDetailsImpl.setCurrentSalary(currentSalary);

		if (skillSet == null) {
			professionalDetailsImpl.setSkillSet("");
		}
		else {
			professionalDetailsImpl.setSkillSet(skillSet);
		}

		if (additionalInfo == null) {
			professionalDetailsImpl.setAdditionalInfo("");
		}
		else {
			professionalDetailsImpl.setAdditionalInfo(additionalInfo);
		}

		if (currentEmployer == null) {
			professionalDetailsImpl.setCurrentEmployer("");
		}
		else {
			professionalDetailsImpl.setCurrentEmployer(currentEmployer);
		}

		if (workType == null) {
			professionalDetailsImpl.setWorkType("");
		}
		else {
			professionalDetailsImpl.setWorkType(workType);
		}

		if (experience == null) {
			professionalDetailsImpl.setExperience("");
		}
		else {
			professionalDetailsImpl.setExperience(experience);
		}

		if (qualification == null) {
			professionalDetailsImpl.setQualification("");
		}
		else {
			professionalDetailsImpl.setQualification(qualification);
		}

		if (jobTitle == null) {
			professionalDetailsImpl.setJobTitle("");
		}
		else {
			professionalDetailsImpl.setJobTitle(jobTitle);
		}

		professionalDetailsImpl.setCompanyId(companyId);
		professionalDetailsImpl.setUserId(userId);

		professionalDetailsImpl.resetOriginalValues();

		return professionalDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		professionalDetailsId = objectInput.readLong();

		candidateId = objectInput.readLong();

		expectedSalary = objectInput.readDouble();

		currentSalary = objectInput.readDouble();
		skillSet = objectInput.readUTF();
		additionalInfo = objectInput.readUTF();
		currentEmployer = objectInput.readUTF();
		workType = objectInput.readUTF();
		experience = objectInput.readUTF();
		qualification = objectInput.readUTF();
		jobTitle = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(professionalDetailsId);

		objectOutput.writeLong(candidateId);

		objectOutput.writeDouble(expectedSalary);

		objectOutput.writeDouble(currentSalary);

		if (skillSet == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skillSet);
		}

		if (additionalInfo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(additionalInfo);
		}

		if (currentEmployer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currentEmployer);
		}

		if (workType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workType);
		}

		if (experience == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(experience);
		}

		if (qualification == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(qualification);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
	}

	public String uuid;
	public long professionalDetailsId;
	public long candidateId;
	public double expectedSalary;
	public double currentSalary;
	public String skillSet;
	public String additionalInfo;
	public String currentEmployer;
	public String workType;
	public String experience;
	public String qualification;
	public String jobTitle;
	public long companyId;
	public long userId;

}