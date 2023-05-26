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
import com.student.info.service.model.Course;
import com.student.info.service.service.base.CourseLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.student.info.service.model.Course", service = AopService.class)
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {
	public Course addCourse(long courseId, String courseName, long companyId, String subject) {

		Course course = coursePersistence.create(courseId);
		course.setCourseName(courseName);
		course.setCompanyId(companyId);
		course.setSubject(subject);
		coursePersistence.update(course);
		return course;
	}
	
	public Course UpdateCourse(long courseId,String courseName,String subject) {
		Course course=coursePersistence.fetchByPrimaryKey(courseId);
		course.setCourseName(courseName);
		course.setSubject(subject);
		coursePersistence.update(course);
		return course;
		
	}
}