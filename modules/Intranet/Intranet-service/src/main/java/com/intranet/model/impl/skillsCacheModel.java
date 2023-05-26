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

package com.intranet.model.impl;

import com.intranet.model.skills;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing skills in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class skillsCacheModel implements CacheModel<skills>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof skillsCacheModel)) {
			return false;
		}

		skillsCacheModel skillsCacheModel = (skillsCacheModel)object;

		if (skillId == skillsCacheModel.skillId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, skillId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{skillId=");
		sb.append(skillId);
		sb.append(", employeeID=");
		sb.append(employeeID);
		sb.append(", skill=");
		sb.append(skill);
		sb.append(", version=");
		sb.append(version);
		sb.append(", certification=");
		sb.append(certification);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public skills toEntityModel() {
		skillsImpl skillsImpl = new skillsImpl();

		skillsImpl.setSkillId(skillId);
		skillsImpl.setEmployeeID(employeeID);

		if (skill == null) {
			skillsImpl.setSkill("");
		}
		else {
			skillsImpl.setSkill(skill);
		}

		if (version == null) {
			skillsImpl.setVersion("");
		}
		else {
			skillsImpl.setVersion(version);
		}

		skillsImpl.setCertification(certification);

		skillsImpl.resetOriginalValues();

		return skillsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		skillId = objectInput.readLong();

		employeeID = objectInput.readLong();
		skill = objectInput.readUTF();
		version = objectInput.readUTF();

		certification = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(skillId);

		objectOutput.writeLong(employeeID);

		if (skill == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(skill);
		}

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeBoolean(certification);
	}

	public long skillId;
	public long employeeID;
	public String skill;
	public String version;
	public boolean certification;

}