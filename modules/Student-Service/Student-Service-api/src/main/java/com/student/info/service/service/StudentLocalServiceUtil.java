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

import com.student.info.service.model.Student;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Student. This utility wraps
 * <code>com.student.info.service.service.impl.StudentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StudentLocalService
 * @generated
 */
public class StudentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.student.info.service.service.impl.StudentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addCourseStudent(long courseId, long studentId) {
		getService().addCourseStudent(courseId, studentId);
	}

	public static void addCourseStudent(long courseId, Student student) {
		getService().addCourseStudent(courseId, student);
	}

	public static void addCourseStudents(
		long courseId, List<Student> students) {

		getService().addCourseStudents(courseId, students);
	}

	public static void addCourseStudents(long courseId, long[] studentIds) {
		getService().addCourseStudents(courseId, studentIds);
	}

	public static void addParentStudent(long parentId, long studentId) {
		getService().addParentStudent(parentId, studentId);
	}

	public static void addParentStudent(long parentId, Student student) {
		getService().addParentStudent(parentId, student);
	}

	public static void addParentStudents(
		long parentId, List<Student> students) {

		getService().addParentStudents(parentId, students);
	}

	public static void addParentStudents(long parentId, long[] studentIds) {
		getService().addParentStudents(parentId, studentIds);
	}

	public static Student addStudent(
		long studentId, String studentName, String studentPlace,
		String studentEmail, long companyId) {

		return getService().addStudent(
			studentId, studentName, studentPlace, studentEmail, companyId);
	}

	/**
	 * Adds the student to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param student the student
	 * @return the student that was added
	 */
	public static Student addStudent(Student student) {
		return getService().addStudent(student);
	}

	public static void addTeacherStudent(long teacherId, long studentId) {
		getService().addTeacherStudent(teacherId, studentId);
	}

	public static void addTeacherStudent(long teacherId, Student student) {
		getService().addTeacherStudent(teacherId, student);
	}

	public static void addTeacherStudents(
		long teacherId, List<Student> students) {

		getService().addTeacherStudents(teacherId, students);
	}

	public static void addTeacherStudents(long teacherId, long[] studentIds) {
		getService().addTeacherStudents(teacherId, studentIds);
	}

	public static void clearCourseStudents(long courseId) {
		getService().clearCourseStudents(courseId);
	}

	public static void clearParentStudents(long parentId) {
		getService().clearParentStudents(parentId);
	}

	public static void clearTeacherStudents(long teacherId) {
		getService().clearTeacherStudents(teacherId);
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
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	public static Student createStudent(long studentId) {
		return getService().createStudent(studentId);
	}

	public static void deleteCourseStudent(long courseId, long studentId) {
		getService().deleteCourseStudent(courseId, studentId);
	}

	public static void deleteCourseStudent(long courseId, Student student) {
		getService().deleteCourseStudent(courseId, student);
	}

	public static void deleteCourseStudents(
		long courseId, List<Student> students) {

		getService().deleteCourseStudents(courseId, students);
	}

	public static void deleteCourseStudents(long courseId, long[] studentIds) {
		getService().deleteCourseStudents(courseId, studentIds);
	}

	public static void deleteParentStudent(long parentId, long studentId) {
		getService().deleteParentStudent(parentId, studentId);
	}

	public static void deleteParentStudent(long parentId, Student student) {
		getService().deleteParentStudent(parentId, student);
	}

	public static void deleteParentStudents(
		long parentId, List<Student> students) {

		getService().deleteParentStudents(parentId, students);
	}

	public static void deleteParentStudents(long parentId, long[] studentIds) {
		getService().deleteParentStudents(parentId, studentIds);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studentId the primary key of the student
	 * @return the student that was removed
	 * @throws PortalException if a student with the primary key could not be found
	 */
	public static Student deleteStudent(long studentId) throws PortalException {
		return getService().deleteStudent(studentId);
	}

	/**
	 * Deletes the student from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param student the student
	 * @return the student that was removed
	 */
	public static Student deleteStudent(Student student) {
		return getService().deleteStudent(student);
	}

	public static void deleteTeacherStudent(long teacherId, long studentId) {
		getService().deleteTeacherStudent(teacherId, studentId);
	}

	public static void deleteTeacherStudent(long teacherId, Student student) {
		getService().deleteTeacherStudent(teacherId, student);
	}

	public static void deleteTeacherStudents(
		long teacherId, List<Student> students) {

		getService().deleteTeacherStudents(teacherId, students);
	}

	public static void deleteTeacherStudents(
		long teacherId, long[] studentIds) {

		getService().deleteTeacherStudents(teacherId, studentIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.StudentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.StudentModelImpl</code>.
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

	public static Student fetchStudent(long studentId) {
		return getService().fetchStudent(studentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the courseIds of the courses associated with the student.
	 *
	 * @param studentId the studentId of the student
	 * @return long[] the courseIds of courses associated with the student
	 */
	public static long[] getCoursePrimaryKeys(long studentId) {
		return getService().getCoursePrimaryKeys(studentId);
	}

	public static List<Student> getCourseStudents(long courseId) {
		return getService().getCourseStudents(courseId);
	}

	public static List<Student> getCourseStudents(
		long courseId, int start, int end) {

		return getService().getCourseStudents(courseId, start, end);
	}

	public static List<Student> getCourseStudents(
		long courseId, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return getService().getCourseStudents(
			courseId, start, end, orderByComparator);
	}

	public static int getCourseStudentsCount(long courseId) {
		return getService().getCourseStudentsCount(courseId);
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
	 * Returns the parentIds of the parents associated with the student.
	 *
	 * @param studentId the studentId of the student
	 * @return long[] the parentIds of parents associated with the student
	 */
	public static long[] getParentPrimaryKeys(long studentId) {
		return getService().getParentPrimaryKeys(studentId);
	}

	public static List<Student> getParentStudents(long parentId) {
		return getService().getParentStudents(parentId);
	}

	public static List<Student> getParentStudents(
		long parentId, int start, int end) {

		return getService().getParentStudents(parentId, start, end);
	}

	public static List<Student> getParentStudents(
		long parentId, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return getService().getParentStudents(
			parentId, start, end, orderByComparator);
	}

	public static int getParentStudentsCount(long parentId) {
		return getService().getParentStudentsCount(parentId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the student with the primary key.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws PortalException if a student with the primary key could not be found
	 */
	public static Student getStudent(long studentId) throws PortalException {
		return getService().getStudent(studentId);
	}

	/**
	 * Returns a range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.StudentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of students
	 */
	public static List<Student> getStudents(int start, int end) {
		return getService().getStudents(start, end);
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 */
	public static int getStudentsCount() {
		return getService().getStudentsCount();
	}

	/**
	 * Returns the teacherIds of the teachers associated with the student.
	 *
	 * @param studentId the studentId of the student
	 * @return long[] the teacherIds of teachers associated with the student
	 */
	public static long[] getTeacherPrimaryKeys(long studentId) {
		return getService().getTeacherPrimaryKeys(studentId);
	}

	public static List<Student> getTeacherStudents(long teacherId) {
		return getService().getTeacherStudents(teacherId);
	}

	public static List<Student> getTeacherStudents(
		long teacherId, int start, int end) {

		return getService().getTeacherStudents(teacherId, start, end);
	}

	public static List<Student> getTeacherStudents(
		long teacherId, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return getService().getTeacherStudents(
			teacherId, start, end, orderByComparator);
	}

	public static int getTeacherStudentsCount(long teacherId) {
		return getService().getTeacherStudentsCount(teacherId);
	}

	public static boolean hasCourseStudent(long courseId, long studentId) {
		return getService().hasCourseStudent(courseId, studentId);
	}

	public static boolean hasCourseStudents(long courseId) {
		return getService().hasCourseStudents(courseId);
	}

	public static boolean hasParentStudent(long parentId, long studentId) {
		return getService().hasParentStudent(parentId, studentId);
	}

	public static boolean hasParentStudents(long parentId) {
		return getService().hasParentStudents(parentId);
	}

	public static boolean hasTeacherStudent(long teacherId, long studentId) {
		return getService().hasTeacherStudent(teacherId, studentId);
	}

	public static boolean hasTeacherStudents(long teacherId) {
		return getService().hasTeacherStudents(teacherId);
	}

	public static void setCourseStudents(long courseId, long[] studentIds) {
		getService().setCourseStudents(courseId, studentIds);
	}

	public static void setParentStudents(long parentId, long[] studentIds) {
		getService().setParentStudents(parentId, studentIds);
	}

	public static void setTeacherStudents(long teacherId, long[] studentIds) {
		getService().setTeacherStudents(teacherId, studentIds);
	}

	public static Student updateStudent(
		long studentId, String studentName, String studentPlace,
		String studentEmail) {

		return getService().updateStudent(
			studentId, studentName, studentPlace, studentEmail);
	}

	/**
	 * Updates the student in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param student the student
	 * @return the student that was updated
	 */
	public static Student updateStudent(Student student) {
		return getService().updateStudent(student);
	}

	public static StudentLocalService getService() {
		return _service;
	}

	private static volatile StudentLocalService _service;

}