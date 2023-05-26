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

import com.prime.data.service.model.CurrJobTitle;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CurrJobTitle in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CurrJobTitleCacheModel
	implements CacheModel<CurrJobTitle>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CurrJobTitleCacheModel)) {
			return false;
		}

		CurrJobTitleCacheModel currJobTitleCacheModel =
			(CurrJobTitleCacheModel)object;

		if (currJobTitleId == currJobTitleCacheModel.currJobTitleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, currJobTitleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", currJobTitleId=");
		sb.append(currJobTitleId);
		sb.append(", currentJobTitle=");
		sb.append(currentJobTitle);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CurrJobTitle toEntityModel() {
		CurrJobTitleImpl currJobTitleImpl = new CurrJobTitleImpl();

		if (uuid == null) {
			currJobTitleImpl.setUuid("");
		}
		else {
			currJobTitleImpl.setUuid(uuid);
		}

		currJobTitleImpl.setCurrJobTitleId(currJobTitleId);

		if (currentJobTitle == null) {
			currJobTitleImpl.setCurrentJobTitle("");
		}
		else {
			currJobTitleImpl.setCurrentJobTitle(currentJobTitle);
		}

		currJobTitleImpl.resetOriginalValues();

		return currJobTitleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		currJobTitleId = objectInput.readLong();
		currentJobTitle = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(currJobTitleId);

		if (currentJobTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currentJobTitle);
		}
	}

	public String uuid;
	public long currJobTitleId;
	public String currentJobTitle;

}