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

import com.candidate.service.model.CandidateOtherInfo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CandidateOtherInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CandidateOtherInfoCacheModel
	implements CacheModel<CandidateOtherInfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CandidateOtherInfoCacheModel)) {
			return false;
		}

		CandidateOtherInfoCacheModel candidateOtherInfoCacheModel =
			(CandidateOtherInfoCacheModel)object;

		if (candidateOtherInfoId ==
				candidateOtherInfoCacheModel.candidateOtherInfoId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, candidateOtherInfoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", candidateOtherInfoId=");
		sb.append(candidateOtherInfoId);
		sb.append(", candidateId=");
		sb.append(candidateId);
		sb.append(", candidateStatus=");
		sb.append(candidateStatus);
		sb.append(", candidateStage=");
		sb.append(candidateStage);
		sb.append(", source=");
		sb.append(source);
		sb.append(", candidateOwner=");
		sb.append(candidateOwner);
		sb.append(", institute=");
		sb.append(institute);
		sb.append(", department=");
		sb.append(department);
		sb.append(", degree=");
		sb.append(degree);
		sb.append(", fromDuration=");
		sb.append(fromDuration);
		sb.append(", toDuration=");
		sb.append(toDuration);
		sb.append(", occupation=");
		sb.append(occupation);
		sb.append(", company=");
		sb.append(company);
		sb.append(", summary=");
		sb.append(summary);
		sb.append(", fromWorkDuration=");
		sb.append(fromWorkDuration);
		sb.append(", toWorkDuration=");
		sb.append(toWorkDuration);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CandidateOtherInfo toEntityModel() {
		CandidateOtherInfoImpl candidateOtherInfoImpl =
			new CandidateOtherInfoImpl();

		if (uuid == null) {
			candidateOtherInfoImpl.setUuid("");
		}
		else {
			candidateOtherInfoImpl.setUuid(uuid);
		}

		candidateOtherInfoImpl.setCandidateOtherInfoId(candidateOtherInfoId);
		candidateOtherInfoImpl.setCandidateId(candidateId);

		if (candidateStatus == null) {
			candidateOtherInfoImpl.setCandidateStatus("");
		}
		else {
			candidateOtherInfoImpl.setCandidateStatus(candidateStatus);
		}

		if (candidateStage == null) {
			candidateOtherInfoImpl.setCandidateStage("");
		}
		else {
			candidateOtherInfoImpl.setCandidateStage(candidateStage);
		}

		if (source == null) {
			candidateOtherInfoImpl.setSource("");
		}
		else {
			candidateOtherInfoImpl.setSource(source);
		}

		if (candidateOwner == null) {
			candidateOtherInfoImpl.setCandidateOwner("");
		}
		else {
			candidateOtherInfoImpl.setCandidateOwner(candidateOwner);
		}

		if (institute == null) {
			candidateOtherInfoImpl.setInstitute("");
		}
		else {
			candidateOtherInfoImpl.setInstitute(institute);
		}

		if (department == null) {
			candidateOtherInfoImpl.setDepartment("");
		}
		else {
			candidateOtherInfoImpl.setDepartment(department);
		}

		if (degree == null) {
			candidateOtherInfoImpl.setDegree("");
		}
		else {
			candidateOtherInfoImpl.setDegree(degree);
		}

		if (fromDuration == null) {
			candidateOtherInfoImpl.setFromDuration("");
		}
		else {
			candidateOtherInfoImpl.setFromDuration(fromDuration);
		}

		if (toDuration == null) {
			candidateOtherInfoImpl.setToDuration("");
		}
		else {
			candidateOtherInfoImpl.setToDuration(toDuration);
		}

		if (occupation == null) {
			candidateOtherInfoImpl.setOccupation("");
		}
		else {
			candidateOtherInfoImpl.setOccupation(occupation);
		}

		if (company == null) {
			candidateOtherInfoImpl.setCompany("");
		}
		else {
			candidateOtherInfoImpl.setCompany(company);
		}

		if (summary == null) {
			candidateOtherInfoImpl.setSummary("");
		}
		else {
			candidateOtherInfoImpl.setSummary(summary);
		}

		if (fromWorkDuration == null) {
			candidateOtherInfoImpl.setFromWorkDuration("");
		}
		else {
			candidateOtherInfoImpl.setFromWorkDuration(fromWorkDuration);
		}

		if (toWorkDuration == null) {
			candidateOtherInfoImpl.setToWorkDuration("");
		}
		else {
			candidateOtherInfoImpl.setToWorkDuration(toWorkDuration);
		}

		candidateOtherInfoImpl.setCompanyId(companyId);
		candidateOtherInfoImpl.setUserId(userId);
		candidateOtherInfoImpl.setFolderId(folderId);

		candidateOtherInfoImpl.resetOriginalValues();

		return candidateOtherInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		candidateOtherInfoId = objectInput.readLong();

		candidateId = objectInput.readLong();
		candidateStatus = objectInput.readUTF();
		candidateStage = objectInput.readUTF();
		source = objectInput.readUTF();
		candidateOwner = objectInput.readUTF();
		institute = objectInput.readUTF();
		department = objectInput.readUTF();
		degree = objectInput.readUTF();
		fromDuration = objectInput.readUTF();
		toDuration = objectInput.readUTF();
		occupation = objectInput.readUTF();
		company = objectInput.readUTF();
		summary = objectInput.readUTF();
		fromWorkDuration = objectInput.readUTF();
		toWorkDuration = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();

		folderId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(candidateOtherInfoId);

		objectOutput.writeLong(candidateId);

		if (candidateStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(candidateStatus);
		}

		if (candidateStage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(candidateStage);
		}

		if (source == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(source);
		}

		if (candidateOwner == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(candidateOwner);
		}

		if (institute == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(institute);
		}

		if (department == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(department);
		}

		if (degree == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(degree);
		}

		if (fromDuration == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fromDuration);
		}

		if (toDuration == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(toDuration);
		}

		if (occupation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(occupation);
		}

		if (company == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (summary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(summary);
		}

		if (fromWorkDuration == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fromWorkDuration);
		}

		if (toWorkDuration == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(toWorkDuration);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(folderId);
	}

	public String uuid;
	public long candidateOtherInfoId;
	public long candidateId;
	public String candidateStatus;
	public String candidateStage;
	public String source;
	public String candidateOwner;
	public String institute;
	public String department;
	public String degree;
	public String fromDuration;
	public String toDuration;
	public String occupation;
	public String company;
	public String summary;
	public String fromWorkDuration;
	public String toWorkDuration;
	public long companyId;
	public long userId;
	public long folderId;

}