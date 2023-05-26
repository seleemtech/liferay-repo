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

import com.prime.data.service.model.SkillSet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SkillSet in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SkillSetCacheModel
	implements CacheModel<SkillSet>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SkillSetCacheModel)) {
			return false;
		}

		SkillSetCacheModel skillSetCacheModel = (SkillSetCacheModel)object;

		if (skillSetId == skillSetCacheModel.skillSetId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, skillSetId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", skillSetId=");
		sb.append(skillSetId);
		sb.append(", skillCategory=");
		sb.append(skillCategory);
		sb.append(", skillCategoryTools=");
		sb.append(skillCategoryTools);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SkillSet toEntityModel() {
		SkillSetImpl skillSetImpl = new SkillSetImpl();

		if (uuid == null) {
			skillSetImpl.setUuid("");
		}
		else {
			skillSetImpl.setUuid(uuid);
		}

		skillSetImpl.setSkillSetId(skillSetId);

		if (skillCategory == null) {
			skillSetImpl.setSkillCategory("");
		}
		else {
			skillSetImpl.setSkillCategory(skillCategory);
		}

		if (skillCategoryTools == null) {
			skillSetImpl.setSkillCategoryTools("");
		}
		else {
			skillSetImpl.setSkillCategoryTools(skillCategoryTools);
		}

		skillSetImpl.resetOriginalValues();

		return skillSetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		skillSetId = objectInput.readLong();
		skillCategory = objectInput.readUTF();
		skillCategoryTools = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(skillSetId);

		if (skillCategory == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skillCategory);
		}

		if (skillCategoryTools == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skillCategoryTools);
		}
	}

	public String uuid;
	public long skillSetId;
	public String skillCategory;
	public String skillCategoryTools;

}