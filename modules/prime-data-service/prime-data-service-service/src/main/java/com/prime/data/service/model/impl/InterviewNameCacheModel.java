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

import com.prime.data.service.model.InterviewName;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing InterviewName in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InterviewNameCacheModel
	implements CacheModel<InterviewName>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InterviewNameCacheModel)) {
			return false;
		}

		InterviewNameCacheModel interviewNameCacheModel =
			(InterviewNameCacheModel)object;

		if (interviewNameId == interviewNameCacheModel.interviewNameId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, interviewNameId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", interviewNameId=");
		sb.append(interviewNameId);
		sb.append(", interviewName=");
		sb.append(interviewName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InterviewName toEntityModel() {
		InterviewNameImpl interviewNameImpl = new InterviewNameImpl();

		if (uuid == null) {
			interviewNameImpl.setUuid("");
		}
		else {
			interviewNameImpl.setUuid(uuid);
		}

		interviewNameImpl.setInterviewNameId(interviewNameId);

		if (interviewName == null) {
			interviewNameImpl.setInterviewName("");
		}
		else {
			interviewNameImpl.setInterviewName(interviewName);
		}

		interviewNameImpl.resetOriginalValues();

		return interviewNameImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		interviewNameId = objectInput.readLong();
		interviewName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(interviewNameId);

		if (interviewName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(interviewName);
		}
	}

	public String uuid;
	public long interviewNameId;
	public String interviewName;

}