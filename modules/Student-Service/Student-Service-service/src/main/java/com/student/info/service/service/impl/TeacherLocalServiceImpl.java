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

package com.student.info.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.student.info.service.model.Teacher;
import com.student.info.service.service.base.TeacherLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.student.info.service.model.Teacher",
	service = AopService.class
)
public class TeacherLocalServiceImpl extends TeacherLocalServiceBaseImpl {
	public Teacher addTeacher(long teacherId,String teacherName,String teacherEmail,long companyId) {
		
		Teacher teacher=teacherPersistence.create(teacherId);
		teacher.setTeacherName(teacherName);
		teacher.setTeacherEmail(teacherEmail);
		teacher.setCompanyId(companyId);
		teacherPersistence.update(teacher);
		return teacher;
		
	}
public Teacher updateTeacher(long teacherId,String teacherName,String teacherEmail) {
		
		Teacher teacher=teacherPersistence.fetchByPrimaryKey(teacherId);
		teacher.setTeacherName(teacherName);
		teacher.setTeacherEmail(teacherEmail);
		teacherPersistence.update(teacher);
		return teacher;
		
	}
}