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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.student.info.service.model.Course;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Course. This utility wraps
 * <code>com.student.info.service.service.impl.CourseLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CourseLocalService
 * @generated
 */
public class CourseLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.student.info.service.service.impl.CourseLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Course addCourse(Course course) {
		return getService().addCourse(course);
	}

	public static Course addCourse(
		long courseId, String courseName, long companyId, String subject) {

		return getService().addCourse(courseId, courseName, companyId, subject);
	}

	public static void addStudentCourse(long studentId, Course course) {
		getService().addStudentCourse(studentId, course);
	}

	public static void addStudentCourse(long studentId, long courseId) {
		getService().addStudentCourse(studentId, courseId);
	}

	public static void addStudentCourses(long studentId, List<Course> courses) {
		getService().addStudentCourses(studentId, courses);
	}

	public static void addStudentCourses(long studentId, long[] courseIds) {
		getService().addStudentCourses(studentId, courseIds);
	}

	public static void addTeacherCourse(long teacherId, Course course) {
		getService().addTeacherCourse(teacherId, course);
	}

	public static void addTeacherCourse(long teacherId, long courseId) {
		getService().addTeacherCourse(teacherId, courseId);
	}

	public static void addTeacherCourses(long teacherId, List<Course> courses) {
		getService().addTeacherCourses(teacherId, courses);
	}

	public static void addTeacherCourses(long teacherId, long[] courseIds) {
		getService().addTeacherCourses(teacherId, courseIds);
	}

	public static void clearStudentCourses(long studentId) {
		getService().clearStudentCourses(studentId);
	}

	public static void clearTeacherCourses(long teacherId) {
		getService().clearTeacherCourses(teacherId);
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	public static Course createCourse(long courseId) {
		return getService().createCourse(courseId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static Course deleteCourse(Course course) {
		return getService().deleteCourse(course);
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
	public static Course deleteCourse(long courseId) throws PortalException {
		return getService().deleteCourse(courseId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteStudentCourse(long studentId, Course course) {
		getService().deleteStudentCourse(studentId, course);
	}

	public static void deleteStudentCourse(long studentId, long courseId) {
		getService().deleteStudentCourse(studentId, courseId);
	}

	public static void deleteStudentCourses(
		long studentId, List<Course> courses) {

		getService().deleteStudentCourses(studentId, courses);
	}

	public static void deleteStudentCourses(long studentId, long[] courseIds) {
		getService().deleteStudentCourses(studentId, courseIds);
	}

	public static void deleteTeacherCourse(long teacherId, Course course) {
		getService().deleteTeacherCourse(teacherId, course);
	}

	public static void deleteTeacherCourse(long teacherId, long courseId) {
		getService().deleteTeacherCourse(teacherId, courseId);
	}

	public static void deleteTeacherCourses(
		long teacherId, List<Course> courses) {

		getService().deleteTeacherCourses(teacherId, courses);
	}

	public static void deleteTeacherCourses(long teacherId, long[] courseIds) {
		getService().deleteTeacherCourses(teacherId, courseIds);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Course fetchCourse(long courseId) {
		return getService().fetchCourse(courseId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the course with the primary key.
	 *
	 * @param courseId the primary key of the course
	 * @return the course
	 * @throws PortalException if a course with the primary key could not be found
	 */
	public static Course getCourse(long courseId) throws PortalException {
		return getService().getCourse(courseId);
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
	public static List<Course> getCourses(int start, int end) {
		return getService().getCourses(start, end);
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
	 */
	public static int getCoursesCount() {
		return getService().getCoursesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static List<Course> getStudentCourses(long studentId) {
		return getService().getStudentCourses(studentId);
	}

	public static List<Course> getStudentCourses(
		long studentId, int start, int end) {

		return getService().getStudentCourses(studentId, start, end);
	}

	public static List<Course> getStudentCourses(
		long studentId, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return getService().getStudentCourses(
			studentId, start, end, orderByComparator);
	}

	public static int getStudentCoursesCount(long studentId) {
		return getService().getStudentCoursesCount(studentId);
	}

	/**
	 * Returns the studentIds of the students associated with the course.
	 *
	 * @param courseId the courseId of the course
	 * @return long[] the studentIds of students associated with the course
	 */
	public static long[] getStudentPrimaryKeys(long courseId) {
		return getService().getStudentPrimaryKeys(courseId);
	}

	public static List<Course> getTeacherCourses(long teacherId) {
		return getService().getTeacherCourses(teacherId);
	}

	public static List<Course> getTeacherCourses(
		long teacherId, int start, int end) {

		return getService().getTeacherCourses(teacherId, start, end);
	}

	public static List<Course> getTeacherCourses(
		long teacherId, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return getService().getTeacherCourses(
			teacherId, start, end, orderByComparator);
	}

	public static int getTeacherCoursesCount(long teacherId) {
		return getService().getTeacherCoursesCount(teacherId);
	}

	/**
	 * Returns the teacherIds of the teachers associated with the course.
	 *
	 * @param courseId the courseId of the course
	 * @return long[] the teacherIds of teachers associated with the course
	 */
	public static long[] getTeacherPrimaryKeys(long courseId) {
		return getService().getTeacherPrimaryKeys(courseId);
	}

	public static boolean hasStudentCourse(long studentId, long courseId) {
		return getService().hasStudentCourse(studentId, courseId);
	}

	public static boolean hasStudentCourses(long studentId) {
		return getService().hasStudentCourses(studentId);
	}

	public static boolean hasTeacherCourse(long teacherId, long courseId) {
		return getService().hasTeacherCourse(teacherId, courseId);
	}

	public static boolean hasTeacherCourses(long teacherId) {
		return getService().hasTeacherCourses(teacherId);
	}

	public static void setStudentCourses(long studentId, long[] courseIds) {
		getService().setStudentCourses(studentId, courseIds);
	}

	public static void setTeacherCourses(long teacherId, long[] courseIds) {
		getService().setTeacherCourses(teacherId, courseIds);
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
	public static Course updateCourse(Course course) {
		return getService().updateCourse(course);
	}

	public static Course UpdateCourse(
		long courseId, String courseName, String subject) {

		return getService().UpdateCourse(courseId, courseName, subject);
	}

	public static CourseLocalService getService() {
		return _service;
	}

	private static volatile CourseLocalService _service;

}