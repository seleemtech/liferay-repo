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

package com.student.info.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CourseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CourseLocalService
 * @generated
 */
public class CourseLocalServiceWrapper
	implements CourseLocalService, ServiceWrapper<CourseLocalService> {

	public CourseLocalServiceWrapper() {
		this(null);
	}

	public CourseLocalServiceWrapper(CourseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}

	/**
	 * Adds the course to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param course the course
	 * @return the course that was added
	 */
	@Override
	public com.student.info.service.model.Course addCourse(
		com.student.info.service.model.Course course) {

		return _courseLocalService.addCourse(course);
	}

	@Override
	public com.student.info.service.model.Course addCourse(
		long courseId, String courseName, long companyId, String subject) {

		return _courseLocalService.addCourse(
			courseId, courseName, companyId, subject);
	}

	@Override
	public void addStudentCourse(
		long studentId, com.student.info.service.model.Course course) {

		_courseLocalService.addStudentCourse(studentId, course);
	}

	@Override
	public void addStudentCourse(long studentId, long courseId) {
		_courseLocalService.addStudentCourse(studentId, courseId);
	}

	@Override
	public void addStudentCourses(
		long studentId,
		java.util.List<com.student.info.service.model.Course> courses) {

		_courseLocalService.addStudentCourses(studentId, courses);
	}

	@Override
	public void addStudentCourses(long studentId, long[] courseIds) {
		_courseLocalService.addStudentCourses(studentId, courseIds);
	}

	@Override
	public void addTeacherCourse(
		long teacherId, com.student.info.service.model.Course course) {

		_courseLocalService.addTeacherCourse(teacherId, course);
	}

	@Override
	public void addTeacherCourse(long teacherId, long courseId) {
		_courseLocalService.addTeacherCourse(teacherId, courseId);
	}

	@Override
	public void addTeacherCourses(
		long teacherId,
		java.util.List<com.student.info.service.model.Course> courses) {

		_courseLocalService.addTeacherCourses(teacherId, courses);
	}

	@Override
	public void addTeacherCourses(long teacherId, long[] courseIds) {
		_courseLocalService.addTeacherCourses(teacherId, courseIds);
	}

	@Override
	public void clearStudentCourses(long studentId) {
		_courseLocalService.clearStudentCourses(studentId);
	}

	@Override
	public void clearTeacherCourses(long teacherId) {
		_courseLocalService.clearTeacherCourses(teacherId);
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	@Override
	public com.student.info.service.model.Course createCourse(long courseId) {
		return _courseLocalService.createCourse(courseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the course from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param course the course
	 * @return the course that was removed
	 */
	@Override
	public com.student.info.service.model.Course deleteCourse(
		com.student.info.service.model.Course course) {

		return _courseLocalService.deleteCourse(course);
	}

	/**
	 * Deletes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param courseId the primary key of the course
	 * @return the course that was removed
	 * @throws PortalException if a course with the primary key could not be found
	 */
	@Override
	public com.student.info.service.model.Course deleteCourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.deleteCourse(courseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteStudentCourse(
		long studentId, com.student.info.service.model.Course course) {

		_courseLocalService.deleteStudentCourse(studentId, course);
	}

	@Override
	public void deleteStudentCourse(long studentId, long courseId) {
		_courseLocalService.deleteStudentCourse(studentId, courseId);
	}

	@Override
	public void deleteStudentCourses(
		long studentId,
		java.util.List<com.student.info.service.model.Course> courses) {

		_courseLocalService.deleteStudentCourses(studentId, courses);
	}

	@Override
	public void deleteStudentCourses(long studentId, long[] courseIds) {
		_courseLocalService.deleteStudentCourses(studentId, courseIds);
	}

	@Override
	public void deleteTeacherCourse(
		long teacherId, com.student.info.service.model.Course course) {

		_courseLocalService.deleteTeacherCourse(teacherId, course);
	}

	@Override
	public void deleteTeacherCourse(long teacherId, long courseId) {
		_courseLocalService.deleteTeacherCourse(teacherId, courseId);
	}

	@Override
	public void deleteTeacherCourses(
		long teacherId,
		java.util.List<com.student.info.service.model.Course> courses) {

		_courseLocalService.deleteTeacherCourses(teacherId, courses);
	}

	@Override
	public void deleteTeacherCourses(long teacherId, long[] courseIds) {
		_courseLocalService.deleteTeacherCourses(teacherId, courseIds);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _courseLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _courseLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _courseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.CourseModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _courseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.CourseModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _courseLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _courseLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _courseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.student.info.service.model.Course fetchCourse(long courseId) {
		return _courseLocalService.fetchCourse(courseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _courseLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the course with the primary key.
	 *
	 * @param courseId the primary key of the course
	 * @return the course
	 * @throws PortalException if a course with the primary key could not be found
	 */
	@Override
	public com.student.info.service.model.Course getCourse(long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.getCourse(courseId);
	}

	/**
	 * Returns a range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.CourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of courses
	 */
	@Override
	public java.util.List<com.student.info.service.model.Course> getCourses(
		int start, int end) {

		return _courseLocalService.getCourses(start, end);
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
	 */
	@Override
	public int getCoursesCount() {
		return _courseLocalService.getCoursesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _courseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _courseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.student.info.service.model.Course>
		getStudentCourses(long studentId) {

		return _courseLocalService.getStudentCourses(studentId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Course>
		getStudentCourses(long studentId, int start, int end) {

		return _courseLocalService.getStudentCourses(studentId, start, end);
	}

	@Override
	public java.util.List<com.student.info.service.model.Course>
		getStudentCourses(
			long studentId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.student.info.service.model.Course> orderByComparator) {

		return _courseLocalService.getStudentCourses(
			studentId, start, end, orderByComparator);
	}

	@Override
	public int getStudentCoursesCount(long studentId) {
		return _courseLocalService.getStudentCoursesCount(studentId);
	}

	/**
	 * Returns the studentIds of the students associated with the course.
	 *
	 * @param courseId the courseId of the course
	 * @return long[] the studentIds of students associated with the course
	 */
	@Override
	public long[] getStudentPrimaryKeys(long courseId) {
		return _courseLocalService.getStudentPrimaryKeys(courseId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Course>
		getTeacherCourses(long teacherId) {

		return _courseLocalService.getTeacherCourses(teacherId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Course>
		getTeacherCourses(long teacherId, int start, int end) {

		return _courseLocalService.getTeacherCourses(teacherId, start, end);
	}

	@Override
	public java.util.List<com.student.info.service.model.Course>
		getTeacherCourses(
			long teacherId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.student.info.service.model.Course> orderByComparator) {

		return _courseLocalService.getTeacherCourses(
			teacherId, start, end, orderByComparator);
	}

	@Override
	public int getTeacherCoursesCount(long teacherId) {
		return _courseLocalService.getTeacherCoursesCount(teacherId);
	}

	/**
	 * Returns the teacherIds of the teachers associated with the course.
	 *
	 * @param courseId the courseId of the course
	 * @return long[] the teacherIds of teachers associated with the course
	 */
	@Override
	public long[] getTeacherPrimaryKeys(long courseId) {
		return _courseLocalService.getTeacherPrimaryKeys(courseId);
	}

	@Override
	public boolean hasStudentCourse(long studentId, long courseId) {
		return _courseLocalService.hasStudentCourse(studentId, courseId);
	}

	@Override
	public boolean hasStudentCourses(long studentId) {
		return _courseLocalService.hasStudentCourses(studentId);
	}

	@Override
	public boolean hasTeacherCourse(long teacherId, long courseId) {
		return _courseLocalService.hasTeacherCourse(teacherId, courseId);
	}

	@Override
	public boolean hasTeacherCourses(long teacherId) {
		return _courseLocalService.hasTeacherCourses(teacherId);
	}

	@Override
	public void setStudentCourses(long studentId, long[] courseIds) {
		_courseLocalService.setStudentCourses(studentId, courseIds);
	}

	@Override
	public void setTeacherCourses(long teacherId, long[] courseIds) {
		_courseLocalService.setTeacherCourses(teacherId, courseIds);
	}

	/**
	 * Updates the course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CourseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param course the course
	 * @return the course that was updated
	 */
	@Override
	public com.student.info.service.model.Course updateCourse(
		com.student.info.service.model.Course course) {

		return _courseLocalService.updateCourse(course);
	}

	@Override
	public com.student.info.service.model.Course UpdateCourse(
		long courseId, String courseName, String subject) {

		return _courseLocalService.UpdateCourse(courseId, courseName, subject);
	}

	@Override
	public CourseLocalService getWrappedService() {
		return _courseLocalService;
	}

	@Override
	public void setWrappedService(CourseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}

	private CourseLocalService _courseLocalService;

}