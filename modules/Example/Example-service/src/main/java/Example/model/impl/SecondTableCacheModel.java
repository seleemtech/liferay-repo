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

package Example.model.impl;

import Example.model.SecondTable;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SecondTable in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SecondTableCacheModel
	implements CacheModel<SecondTable>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SecondTableCacheModel)) {
			return false;
		}

		SecondTableCacheModel secondTableCacheModel =
			(SecondTableCacheModel)object;

		if (coId == secondTableCacheModel.coId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, coId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{coId=");
		sb.append(coId);
		sb.append(", coName=");
		sb.append(coName);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SecondTable toEntityModel() {
		SecondTableImpl secondTableImpl = new SecondTableImpl();

		secondTableImpl.setCoId(coId);

		if (coName == null) {
			secondTableImpl.setCoName("");
		}
		else {
			secondTableImpl.setCoName(coName);
		}

		secondTableImpl.setCompanyId(companyId);

		secondTableImpl.resetOriginalValues();

		return secondTableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		coId = objectInput.readLong();
		coName = objectInput.readUTF();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(coId);

		if (coName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coName);
		}

		objectOutput.writeLong(companyId);
	}

	public long coId;
	public String coName;
	public long companyId;

}