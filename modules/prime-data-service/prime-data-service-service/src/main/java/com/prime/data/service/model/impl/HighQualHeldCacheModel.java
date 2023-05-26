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

import com.prime.data.service.model.HighQualHeld;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing HighQualHeld in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class HighQualHeldCacheModel
	implements CacheModel<HighQualHeld>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HighQualHeldCacheModel)) {
			return false;
		}

		HighQualHeldCacheModel highQualHeldCacheModel =
			(HighQualHeldCacheModel)object;

		if (highQualHeldId == highQualHeldCacheModel.highQualHeldId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, highQualHeldId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", highQualHeldId=");
		sb.append(highQualHeldId);
		sb.append(", highQualHeld=");
		sb.append(highQualHeld);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HighQualHeld toEntityModel() {
		HighQualHeldImpl highQualHeldImpl = new HighQualHeldImpl();

		if (uuid == null) {
			highQualHeldImpl.setUuid("");
		}
		else {
			highQualHeldImpl.setUuid(uuid);
		}

		highQualHeldImpl.setHighQualHeldId(highQualHeldId);

		if (highQualHeld == null) {
			highQualHeldImpl.setHighQualHeld("");
		}
		else {
			highQualHeldImpl.setHighQualHeld(highQualHeld);
		}

		highQualHeldImpl.resetOriginalValues();

		return highQualHeldImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		highQualHeldId = objectInput.readLong();
		highQualHeld = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(highQualHeldId);

		if (highQualHeld == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(highQualHeld);
		}
	}

	public String uuid;
	public long highQualHeldId;
	public String highQualHeld;

}