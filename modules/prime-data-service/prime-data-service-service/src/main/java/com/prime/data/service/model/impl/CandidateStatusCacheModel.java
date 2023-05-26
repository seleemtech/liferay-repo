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

import com.prime.data.service.model.CandidateStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CandidateStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CandidateStatusCacheModel
	implements CacheModel<CandidateStatus>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CandidateStatusCacheModel)) {
			return false;
		}

		CandidateStatusCacheModel candidateStatusCacheModel =
			(CandidateStatusCacheModel)object;

		if (candidateStatusId == candidateStatusCacheModel.candidateStatusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, candidateStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", candidateStatusId=");
		sb.append(candidateStatusId);
		sb.append(", candidateStatus=");
		sb.append(candidateStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CandidateStatus toEntityModel() {
		CandidateStatusImpl candidateStatusImpl = new CandidateStatusImpl();

		if (uuid == null) {
			candidateStatusImpl.setUuid("");
		}
		else {
			candidateStatusImpl.setUuid(uuid);
		}

		candidateStatusImpl.setCandidateStatusId(candidateStatusId);

		if (candidateStatus == null) {
			candidateStatusImpl.setCandidateStatus("");
		}
		else {
			candidateStatusImpl.setCandidateStatus(candidateStatus);
		}

		candidateStatusImpl.resetOriginalValues();

		return candidateStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		candidateStatusId = objectInput.readLong();
		candidateStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(candidateStatusId);

		if (candidateStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(candidateStatus);
		}
	}

	public String uuid;
	public long candidateStatusId;
	public String candidateStatus;

}