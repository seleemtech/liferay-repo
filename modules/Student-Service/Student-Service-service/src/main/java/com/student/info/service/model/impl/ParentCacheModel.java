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

package com.student.info.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.student.info.service.model.Parent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Parent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ParentCacheModel implements CacheModel<Parent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ParentCacheModel)) {
			return false;
		}

		ParentCacheModel parentCacheModel = (ParentCacheModel)object;

		if (parentId == parentCacheModel.parentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, parentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{parentId=");
		sb.append(parentId);
		sb.append(", parentName=");
		sb.append(parentName);
		sb.append(", parentContact=");
		sb.append(parentContact);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Parent toEntityModel() {
		ParentImpl parentImpl = new ParentImpl();

		parentImpl.setParentId(parentId);

		if (parentName == null) {
			parentImpl.setParentName("");
		}
		else {
			parentImpl.setParentName(parentName);
		}

		parentImpl.setParentContact(parentContact);
		parentImpl.setCompanyId(companyId);

		parentImpl.resetOriginalValues();

		return parentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		parentId = objectInput.readLong();
		parentName = objectInput.readUTF();

		parentContact = objectInput.readLong();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(parentId);

		if (parentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(parentName);
		}

		objectOutput.writeLong(parentContact);

		objectOutput.writeLong(companyId);
	}

	public long parentId;
	public String parentName;
	public long parentContact;
	public long companyId;

}