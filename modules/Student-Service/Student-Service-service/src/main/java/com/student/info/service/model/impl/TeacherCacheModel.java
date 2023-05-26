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

import com.student.info.service.model.Teacher;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Teacher in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TeacherCacheModel implements CacheModel<Teacher>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TeacherCacheModel)) {
			return false;
		}

		TeacherCacheModel teacherCacheModel = (TeacherCacheModel)object;

		if (teacherId == teacherCacheModel.teacherId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, teacherId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{teacherId=");
		sb.append(teacherId);
		sb.append(", teacherName=");
		sb.append(teacherName);
		sb.append(", teacherEmail=");
		sb.append(teacherEmail);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Teacher toEntityModel() {
		TeacherImpl teacherImpl = new TeacherImpl();

		teacherImpl.setTeacherId(teacherId);

		if (teacherName == null) {
			teacherImpl.setTeacherName("");
		}
		else {
			teacherImpl.setTeacherName(teacherName);
		}

		if (teacherEmail == null) {
			teacherImpl.setTeacherEmail("");
		}
		else {
			teacherImpl.setTeacherEmail(teacherEmail);
		}

		if (subject == null) {
			teacherImpl.setSubject("");
		}
		else {
			teacherImpl.setSubject(subject);
		}

		teacherImpl.setCompanyId(companyId);

		teacherImpl.resetOriginalValues();

		return teacherImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		teacherId = objectInput.readLong();
		teacherName = objectInput.readUTF();
		teacherEmail = objectInput.readUTF();
		subject = objectInput.readUTF();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(teacherId);

		if (teacherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(teacherName);
		}

		if (teacherEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(teacherEmail);
		}

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		objectOutput.writeLong(companyId);
	}

	public long teacherId;
	public String teacherName;
	public String teacherEmail;
	public String subject;
	public long companyId;

}