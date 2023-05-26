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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Teacher service. Represents a row in the &quot;ST_Teacher&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.student.info.service.model.impl.TeacherModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.student.info.service.model.impl.TeacherImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Teacher
 * @generated
 */
@ProviderType
public interface TeacherModel extends BaseModel<Teacher>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a teacher model instance should use the {@link Teacher} interface instead.
	 */

	/**
	 * Returns the primary key of this teacher.
	 *
	 * @return the primary key of this teacher
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this teacher.
	 *
	 * @param primaryKey the primary key of this teacher
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the teacher ID of this teacher.
	 *
	 * @return the teacher ID of this teacher
	 */
	public long getTeacherId();

	/**
	 * Sets the teacher ID of this teacher.
	 *
	 * @param teacherId the teacher ID of this teacher
	 */
	public void setTeacherId(long teacherId);

	/**
	 * Returns the teacher name of this teacher.
	 *
	 * @return the teacher name of this teacher
	 */
	@AutoEscape
	public String getTeacherName();

	/**
	 * Sets the teacher name of this teacher.
	 *
	 * @param teacherName the teacher name of this teacher
	 */
	public void setTeacherName(String teacherName);

	/**
	 * Returns the teacher email of this teacher.
	 *
	 * @return the teacher email of this teacher
	 */
	@AutoEscape
	public String getTeacherEmail();

	/**
	 * Sets the teacher email of this teacher.
	 *
	 * @param teacherEmail the teacher email of this teacher
	 */
	public void setTeacherEmail(String teacherEmail);

	/**
	 * Returns the subject of this teacher.
	 *
	 * @return the subject of this teacher
	 */
	@AutoEscape
	public String getSubject();

	/**
	 * Sets the subject of this teacher.
	 *
	 * @param subject the subject of this teacher
	 */
	public void setSubject(String subject);

	/**
	 * Returns the company ID of this teacher.
	 *
	 * @return the company ID of this teacher
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this teacher.
	 *
	 * @param companyId the company ID of this teacher
	 */
	@Override
	public void setCompanyId(long companyId);

	@Override
	public Teacher cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}