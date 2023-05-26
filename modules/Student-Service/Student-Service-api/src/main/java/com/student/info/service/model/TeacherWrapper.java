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

package com.student.info.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Teacher}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Teacher
 * @generated
 */
public class TeacherWrapper
	extends BaseModelWrapper<Teacher>
	implements ModelWrapper<Teacher>, Teacher {

	public TeacherWrapper(Teacher teacher) {
		super(teacher);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("teacherId", getTeacherId());
		attributes.put("teacherName", getTeacherName());
		attributes.put("teacherEmail", getTeacherEmail());
		attributes.put("subject", getSubject());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long teacherId = (Long)attributes.get("teacherId");

		if (teacherId != null) {
			setTeacherId(teacherId);
		}

		String teacherName = (String)attributes.get("teacherName");

		if (teacherName != null) {
			setTeacherName(teacherName);
		}

		String teacherEmail = (String)attributes.get("teacherEmail");

		if (teacherEmail != null) {
			setTeacherEmail(teacherEmail);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	@Override
	public Teacher cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this teacher.
	 *
	 * @return the company ID of this teacher
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the primary key of this teacher.
	 *
	 * @return the primary key of this teacher
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the subject of this teacher.
	 *
	 * @return the subject of this teacher
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the teacher email of this teacher.
	 *
	 * @return the teacher email of this teacher
	 */
	@Override
	public String getTeacherEmail() {
		return model.getTeacherEmail();
	}

	/**
	 * Returns the teacher ID of this teacher.
	 *
	 * @return the teacher ID of this teacher
	 */
	@Override
	public long getTeacherId() {
		return model.getTeacherId();
	}

	/**
	 * Returns the teacher name of this teacher.
	 *
	 * @return the teacher name of this teacher
	 */
	@Override
	public String getTeacherName() {
		return model.getTeacherName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this teacher.
	 *
	 * @param companyId the company ID of this teacher
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the primary key of this teacher.
	 *
	 * @param primaryKey the primary key of this teacher
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the subject of this teacher.
	 *
	 * @param subject the subject of this teacher
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the teacher email of this teacher.
	 *
	 * @param teacherEmail the teacher email of this teacher
	 */
	@Override
	public void setTeacherEmail(String teacherEmail) {
		model.setTeacherEmail(teacherEmail);
	}

	/**
	 * Sets the teacher ID of this teacher.
	 *
	 * @param teacherId the teacher ID of this teacher
	 */
	@Override
	public void setTeacherId(long teacherId) {
		model.setTeacherId(teacherId);
	}

	/**
	 * Sets the teacher name of this teacher.
	 *
	 * @param teacherName the teacher name of this teacher
	 */
	@Override
	public void setTeacherName(String teacherName) {
		model.setTeacherName(teacherName);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TeacherWrapper wrap(Teacher teacher) {
		return new TeacherWrapper(teacher);
	}

}