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

import com.prime.data.service.model.SourceBy;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SourceBy in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SourceByCacheModel
	implements CacheModel<SourceBy>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SourceByCacheModel)) {
			return false;
		}

		SourceByCacheModel sourceByCacheModel = (SourceByCacheModel)object;

		if (sourceId == sourceByCacheModel.sourceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sourceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sourceId=");
		sb.append(sourceId);
		sb.append(", sourceBy=");
		sb.append(sourceBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SourceBy toEntityModel() {
		SourceByImpl sourceByImpl = new SourceByImpl();

		if (uuid == null) {
			sourceByImpl.setUuid("");
		}
		else {
			sourceByImpl.setUuid(uuid);
		}

		sourceByImpl.setSourceId(sourceId);

		if (sourceBy == null) {
			sourceByImpl.setSourceBy("");
		}
		else {
			sourceByImpl.setSourceBy(sourceBy);
		}

		sourceByImpl.resetOriginalValues();

		return sourceByImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		sourceId = objectInput.readLong();
		sourceBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(sourceId);

		if (sourceBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sourceBy);
		}
	}

	public String uuid;
	public long sourceId;
	public String sourceBy;

}