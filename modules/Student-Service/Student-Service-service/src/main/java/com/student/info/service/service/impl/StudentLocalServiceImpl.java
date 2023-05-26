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
import com.student.info.service.model.Student;
import com.student.info.service.service.base.StudentLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.student.info.service.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	public Student addStudent(long studentId,String studentName,String studentPlace,String studentEmail,long companyId) {
		Student student=studentPersistence.create(studentId);
		student.setStudentName(studentName);
		student.setStudentPlace(studentPlace);
		student.setStudentEmail(studentEmail);
		student.setCompanyId(companyId);
		studentPersistence.update(student);
		
		return student;
		
	}
	public Student updateStudent(long studentId,String studentName,String studentPlace,String studentEmail) {
		Student student=studentPersistence.fetchByPrimaryKey(studentId);
		student.setStudentName(studentName);
		student.setStudentPlace(studentPlace);
		student.setStudentEmail(studentEmail);
		studentPersistence.update(student);
		
		return student;
		
	}
}