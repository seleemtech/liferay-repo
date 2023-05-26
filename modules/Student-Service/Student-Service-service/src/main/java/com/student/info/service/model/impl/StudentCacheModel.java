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

import com.student.info.service.model.Student;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StudentCacheModel)) {
			return false;
		}

		StudentCacheModel studentCacheModel = (StudentCacheModel)object;

		if (studentId == studentCacheModel.studentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{studentId=");
		sb.append(studentId);
		sb.append(", studentName=");
		sb.append(studentName);
		sb.append(", studentPlace=");
		sb.append(studentPlace);
		sb.append(", studentEmail=");
		sb.append(studentEmail);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setStudentId(studentId);

		if (studentName == null) {
			studentImpl.setStudentName("");
		}
		else {
			studentImpl.setStudentName(studentName);
		}

		if (studentPlace == null) {
			studentImpl.setStudentPlace("");
		}
		else {
			studentImpl.setStudentPlace(studentPlace);
		}

		if (studentEmail == null) {
			studentImpl.setStudentEmail("");
		}
		else {
			studentImpl.setStudentEmail(studentEmail);
		}

		studentImpl.setCompanyId(companyId);

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		studentId = objectInput.readLong();
		studentName = objectInput.readUTF();
		studentPlace = objectInput.readUTF();
		studentEmail = objectInput.readUTF();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(studentId);

		if (studentName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(studentName);
		}

		if (studentPlace == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(studentPlace);
		}

		if (studentEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(studentEmail);
		}

		objectOutput.writeLong(companyId);
	}

	public long studentId;
	public String studentName;
	public String studentPlace;
	public String studentEmail;
	public long companyId;

}