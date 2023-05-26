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

package com.interview.info.model.impl;

import com.interview.info.model.InterviewInfo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing InterviewInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InterviewInfoCacheModel
	implements CacheModel<InterviewInfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InterviewInfoCacheModel)) {
			return false;
		}

		InterviewInfoCacheModel interviewInfoCacheModel =
			(InterviewInfoCacheModel)object;

		if (interviewId == interviewInfoCacheModel.interviewId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, interviewId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", interviewId=");
		sb.append(interviewId);
		sb.append(", interviewName=");
		sb.append(interviewName);
		sb.append(", postingTitleId=");
		sb.append(postingTitleId);
		sb.append(", candidateId=");
		sb.append(candidateId);
		sb.append(", clientId=");
		sb.append(clientId);
		sb.append(", interviewFrom=");
		sb.append(interviewFrom);
		sb.append(", interviewTo=");
		sb.append(interviewTo);
		sb.append(", interviewers=");
		sb.append(interviewers);
		sb.append(", interviewOwner=");
		sb.append(interviewOwner);
		sb.append(", scheduleComments=");
		sb.append(scheduleComments);
		sb.append(", location=");
		sb.append(location);
		sb.append(", attachmentId=");
		sb.append(attachmentId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InterviewInfo toEntityModel() {
		InterviewInfoImpl interviewInfoImpl = new InterviewInfoImpl();

		if (uuid == null) {
			interviewInfoImpl.setUuid("");
		}
		else {
			interviewInfoImpl.setUuid(uuid);
		}

		interviewInfoImpl.setInterviewId(interviewId);

		if (interviewName == null) {
			interviewInfoImpl.setInterviewName("");
		}
		else {
			interviewInfoImpl.setInterviewName(interviewName);
		}

		interviewInfoImpl.setPostingTitleId(postingTitleId);
		interviewInfoImpl.setCandidateId(candidateId);
		interviewInfoImpl.setClientId(clientId);
		interviewInfoImpl.setInterviewFrom(interviewFrom);
		interviewInfoImpl.setInterviewTo(interviewTo);

		if (interviewers == null) {
			interviewInfoImpl.setInterviewers("");
		}
		else {
			interviewInfoImpl.setInterviewers(interviewers);
		}

		interviewInfoImpl.setInterviewOwner(interviewOwner);

		if (scheduleComments == null) {
			interviewInfoImpl.setScheduleComments("");
		}
		else {
			interviewInfoImpl.setScheduleComments(scheduleComments);
		}

		if (location == null) {
			interviewInfoImpl.setLocation("");
		}
		else {
			interviewInfoImpl.setLocation(location);
		}

		interviewInfoImpl.setAttachmentId(attachmentId);
		interviewInfoImpl.setCreatedBy(createdBy);
		interviewInfoImpl.setCreatedDate(createdDate);
		interviewInfoImpl.setModifiedBy(modifiedBy);
		interviewInfoImpl.setModifiedDate(modifiedDate);

		interviewInfoImpl.resetOriginalValues();

		return interviewInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		interviewId = objectInput.readLong();
		interviewName = objectInput.readUTF();

		postingTitleId = objectInput.readLong();

		candidateId = objectInput.readLong();

		clientId = objectInput.readLong();

		interviewFrom = objectInput.readLong();

		interviewTo = objectInput.readLong();
		interviewers = objectInput.readUTF();

		interviewOwner = objectInput.readLong();
		scheduleComments = objectInput.readUTF();
		location = objectInput.readUTF();

		attachmentId = objectInput.readLong();

		createdBy = objectInput.readLong();

		createdDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(interviewId);

		if (interviewName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(interviewName);
		}

		objectOutput.writeLong(postingTitleId);

		objectOutput.writeLong(candidateId);

		objectOutput.writeLong(clientId);

		objectOutput.writeLong(interviewFrom);

		objectOutput.writeLong(interviewTo);

		if (interviewers == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(interviewers);
		}

		objectOutput.writeLong(interviewOwner);

		if (scheduleComments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scheduleComments);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		objectOutput.writeLong(attachmentId);

		objectOutput.writeLong(createdBy);

		objectOutput.writeLong(createdDate);

		objectOutput.writeLong(modifiedBy);

		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long interviewId;
	public String interviewName;
	public long postingTitleId;
	public long candidateId;
	public long clientId;
	public long interviewFrom;
	public long interviewTo;
	public String interviewers;
	public long interviewOwner;
	public String scheduleComments;
	public String location;
	public long attachmentId;
	public long createdBy;
	public long createdDate;
	public long modifiedBy;
	public long modifiedDate;

}