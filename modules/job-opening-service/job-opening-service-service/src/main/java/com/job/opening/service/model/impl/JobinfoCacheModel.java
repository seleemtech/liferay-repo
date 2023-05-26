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

import com.job.opening.service.model.Jobinfo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Jobinfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JobinfoCacheModel implements CacheModel<Jobinfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JobinfoCacheModel)) {
			return false;
		}

		JobinfoCacheModel jobinfoCacheModel = (JobinfoCacheModel)object;

		if (jobId == jobinfoCacheModel.jobId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, jobId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", jobId=");
		sb.append(jobId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", postingTitle=");
		sb.append(postingTitle);
		sb.append(", title=");
		sb.append(title);
		sb.append(", assignedRecruiter=");
		sb.append(assignedRecruiter);
		sb.append(", targetDate=");
		sb.append(targetDate);
		sb.append(", jobopeningStatus=");
		sb.append(jobopeningStatus);
		sb.append(", industry=");
		sb.append(industry);
		sb.append(", jobResource=");
		sb.append(jobResource);
		sb.append(", hiringManager=");
		sb.append(hiringManager);
		sb.append(", clientName=");
		sb.append(clientName);
		sb.append(", positions=");
		sb.append(positions);
		sb.append(", dateOpened=");
		sb.append(dateOpened);
		sb.append(", jobType=");
		sb.append(jobType);
		sb.append(", workExperience=");
		sb.append(workExperience);
		sb.append(", skillSet=");
		sb.append(skillSet);
		sb.append(", projectStatus=");
		sb.append(projectStatus);
		sb.append(", summaryId=");
		sb.append(summaryId);
		sb.append(", otherId=");
		sb.append(otherId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Jobinfo toEntityModel() {
		JobinfoImpl jobinfoImpl = new JobinfoImpl();

		if (uuid == null) {
			jobinfoImpl.setUuid("");
		}
		else {
			jobinfoImpl.setUuid(uuid);
		}

		jobinfoImpl.setJobId(jobId);
		jobinfoImpl.setGroupId(groupId);
		jobinfoImpl.setCompanyId(companyId);
		jobinfoImpl.setUserId(userId);

		if (userName == null) {
			jobinfoImpl.setUserName("");
		}
		else {
			jobinfoImpl.setUserName(userName);
		}

		if (modifiedDate == Long.MIN_VALUE) {
			jobinfoImpl.setModifiedDate(null);
		}
		else {
			jobinfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (postingTitle == null) {
			jobinfoImpl.setPostingTitle("");
		}
		else {
			jobinfoImpl.setPostingTitle(postingTitle);
		}

		if (title == null) {
			jobinfoImpl.setTitle("");
		}
		else {
			jobinfoImpl.setTitle(title);
		}

		if (assignedRecruiter == null) {
			jobinfoImpl.setAssignedRecruiter("");
		}
		else {
			jobinfoImpl.setAssignedRecruiter(assignedRecruiter);
		}

		if (targetDate == Long.MIN_VALUE) {
			jobinfoImpl.setTargetDate(null);
		}
		else {
			jobinfoImpl.setTargetDate(new Date(targetDate));
		}

		if (jobopeningStatus == null) {
			jobinfoImpl.setJobopeningStatus("");
		}
		else {
			jobinfoImpl.setJobopeningStatus(jobopeningStatus);
		}

		if (industry == null) {
			jobinfoImpl.setIndustry("");
		}
		else {
			jobinfoImpl.setIndustry(industry);
		}

		if (jobResource == null) {
			jobinfoImpl.setJobResource("");
		}
		else {
			jobinfoImpl.setJobResource(jobResource);
		}

		if (hiringManager == null) {
			jobinfoImpl.setHiringManager("");
		}
		else {
			jobinfoImpl.setHiringManager(hiringManager);
		}

		if (clientName == null) {
			jobinfoImpl.setClientName("");
		}
		else {
			jobinfoImpl.setClientName(clientName);
		}

		if (positions == null) {
			jobinfoImpl.setPositions("");
		}
		else {
			jobinfoImpl.setPositions(positions);
		}

		if (dateOpened == Long.MIN_VALUE) {
			jobinfoImpl.setDateOpened(null);
		}
		else {
			jobinfoImpl.setDateOpened(new Date(dateOpened));
		}

		if (jobType == null) {
			jobinfoImpl.setJobType("");
		}
		else {
			jobinfoImpl.setJobType(jobType);
		}

		if (workExperience == null) {
			jobinfoImpl.setWorkExperience("");
		}
		else {
			jobinfoImpl.setWorkExperience(workExperience);
		}

		if (skillSet == null) {
			jobinfoImpl.setSkillSet("");
		}
		else {
			jobinfoImpl.setSkillSet(skillSet);
		}

		if (projectStatus == null) {
			jobinfoImpl.setProjectStatus("");
		}
		else {
			jobinfoImpl.setProjectStatus(projectStatus);
		}

		jobinfoImpl.setSummaryId(summaryId);
		jobinfoImpl.setOtherId(otherId);

		jobinfoImpl.resetOriginalValues();

		return jobinfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		jobId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		modifiedDate = objectInput.readLong();
		postingTitle = objectInput.readUTF();
		title = objectInput.readUTF();
		assignedRecruiter = objectInput.readUTF();
		targetDate = objectInput.readLong();
		jobopeningStatus = objectInput.readUTF();
		industry = objectInput.readUTF();
		jobResource = objectInput.readUTF();
		hiringManager = objectInput.readUTF();
		clientName = objectInput.readUTF();
		positions = objectInput.readUTF();
		dateOpened = objectInput.readLong();
		jobType = objectInput.readUTF();
		workExperience = objectInput.readUTF();
		skillSet = objectInput.readUTF();
		projectStatus = objectInput.readUTF();

		summaryId = objectInput.readLong();

		otherId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(jobId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(modifiedDate);

		if (postingTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(postingTitle);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (assignedRecruiter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(assignedRecruiter);
		}

		objectOutput.writeLong(targetDate);

		if (jobopeningStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobopeningStatus);
		}

		if (industry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(industry);
		}

		if (jobResource == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobResource);
		}

		if (hiringManager == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hiringManager);
		}

		if (clientName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(clientName);
		}

		if (positions == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(positions);
		}

		objectOutput.writeLong(dateOpened);

		if (jobType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(jobType);
		}

		if (workExperience == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(workExperience);
		}

		if (skillSet == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skillSet);
		}

		if (projectStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectStatus);
		}

		objectOutput.writeLong(summaryId);

		objectOutput.writeLong(otherId);
	}

	public String uuid;
	public long jobId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long modifiedDate;
	public String postingTitle;
	public String title;
	public String assignedRecruiter;
	public long targetDate;
	public String jobopeningStatus;
	public String industry;
	public String jobResource;
	public String hiringManager;
	public String clientName;
	public String positions;
	public long dateOpened;
	public String jobType;
	public String workExperience;
	public String skillSet;
	public String projectStatus;
	public long summaryId;
	public long otherId;

}