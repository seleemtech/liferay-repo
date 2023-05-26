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
 * Provides a wrapper for {@link StudentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudentLocalService
 * @generated
 */
public class StudentLocalServiceWrapper
	implements ServiceWrapper<StudentLocalService>, StudentLocalService {

	public StudentLocalServiceWrapper() {
		this(null);
	}

	public StudentLocalServiceWrapper(StudentLocalService studentLocalService) {
		_studentLocalService = studentLocalService;
	}

	@Override
	public void addCourseStudent(long courseId, long studentId) {
		_studentLocalService.addCourseStudent(courseId, studentId);
	}

	@Override
	public void addCourseStudent(
		long courseId, com.student.info.service.model.Student student) {

		_studentLocalService.addCourseStudent(courseId, student);
	}

	@Override
	public void addCourseStudents(
		long courseId,
		java.util.List<com.student.info.service.model.Student> students) {

		_studentLocalService.addCourseStudents(courseId, students);
	}

	@Override
	public void addCourseStudents(long courseId, long[] studentIds) {
		_studentLocalService.addCourseStudents(courseId, studentIds);
	}

	@Override
	public void addParentStudent(long parentId, long studentId) {
		_studentLocalService.addParentStudent(parentId, studentId);
	}

	@Override
	public void addParentStudent(
		long parentId, com.student.info.service.model.Student student) {

		_studentLocalService.addParentStudent(parentId, student);
	}

	@Override
	public void addParentStudents(
		long parentId,
		java.util.List<com.student.info.service.model.Student> students) {

		_studentLocalService.addParentStudents(parentId, students);
	}

	@Override
	public void addParentStudents(long parentId, long[] studentIds) {
		_studentLocalService.addParentStudents(parentId, studentIds);
	}

	@Override
	public com.student.info.service.model.Student addStudent(
		long studentId, String studentName, String studentPlace,
		String studentEmail, long companyId) {

		return _studentLocalService.addStudent(
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
	@Override
	public com.student.info.service.model.Student addStudent(
		com.student.info.service.model.Student student) {

		return _studentLocalService.addStudent(student);
	}

	@Override
	public void addTeacherStudent(long teacherId, long studentId) {
		_studentLocalService.addTeacherStudent(teacherId, studentId);
	}

	@Override
	public void addTeacherStudent(
		long teacherId, com.student.info.service.model.Student student) {

		_studentLocalService.addTeacherStudent(teacherId, student);
	}

	@Override
	public void addTeacherStudents(
		long teacherId,
		java.util.List<com.student.info.service.model.Student> students) {

		_studentLocalService.addTeacherStudents(teacherId, students);
	}

	@Override
	public void addTeacherStudents(long teacherId, long[] studentIds) {
		_studentLocalService.addTeacherStudents(teacherId, studentIds);
	}

	@Override
	public void clearCourseStudents(long courseId) {
		_studentLocalService.clearCourseStudents(courseId);
	}

	@Override
	public void clearParentStudents(long parentId) {
		_studentLocalService.clearParentStudents(parentId);
	}

	@Override
	public void clearTeacherStudents(long teacherId) {
		_studentLocalService.clearTeacherStudents(teacherId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	@Override
	public com.student.info.service.model.Student createStudent(
		long studentId) {

		return _studentLocalService.createStudent(studentId);
	}

	@Override
	public void deleteCourseStudent(long courseId, long studentId) {
		_studentLocalService.deleteCourseStudent(courseId, studentId);
	}

	@Override
	public void deleteCourseStudent(
		long courseId, com.student.info.service.model.Student student) {

		_studentLocalService.deleteCourseStudent(courseId, student);
	}

	@Override
	public void deleteCourseStudents(
		long courseId,
		java.util.List<com.student.info.service.model.Student> students) {

		_studentLocalService.deleteCourseStudents(courseId, students);
	}

	@Override
	public void deleteCourseStudents(long courseId, long[] studentIds) {
		_studentLocalService.deleteCourseStudents(courseId, studentIds);
	}

	@Override
	public void deleteParentStudent(long parentId, long studentId) {
		_studentLocalService.deleteParentStudent(parentId, studentId);
	}

	@Override
	public void deleteParentStudent(
		long parentId, com.student.info.service.model.Student student) {

		_studentLocalService.deleteParentStudent(parentId, student);
	}

	@Override
	public void deleteParentStudents(
		long parentId,
		java.util.List<com.student.info.service.model.Student> students) {

		_studentLocalService.deleteParentStudents(parentId, students);
	}

	@Override
	public void deleteParentStudents(long parentId, long[] studentIds) {
		_studentLocalService.deleteParentStudents(parentId, studentIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.student.info.service.model.Student deleteStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentLocalService.deleteStudent(studentId);
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
	@Override
	public com.student.info.service.model.Student deleteStudent(
		com.student.info.service.model.Student student) {

		return _studentLocalService.deleteStudent(student);
	}

	@Override
	public void deleteTeacherStudent(long teacherId, long studentId) {
		_studentLocalService.deleteTeacherStudent(teacherId, studentId);
	}

	@Override
	public void deleteTeacherStudent(
		long teacherId, com.student.info.service.model.Student student) {

		_studentLocalService.deleteTeacherStudent(teacherId, student);
	}

	@Override
	public void deleteTeacherStudents(
		long teacherId,
		java.util.List<com.student.info.service.model.Student> students) {

		_studentLocalService.deleteTeacherStudents(teacherId, students);
	}

	@Override
	public void deleteTeacherStudents(long teacherId, long[] studentIds) {
		_studentLocalService.deleteTeacherStudents(teacherId, studentIds);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _studentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _studentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studentLocalService.dynamicQuery();
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

		return _studentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _studentLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _studentLocalService.dynamicQuery(
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

		return _studentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _studentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.student.info.service.model.Student fetchStudent(long studentId) {
		return _studentLocalService.fetchStudent(studentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _studentLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the courseIds of the courses associated with the student.
	 *
	 * @param studentId the studentId of the student
	 * @return long[] the courseIds of courses associated with the student
	 */
	@Override
	public long[] getCoursePrimaryKeys(long studentId) {
		return _studentLocalService.getCoursePrimaryKeys(studentId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Student>
		getCourseStudents(long courseId) {

		return _studentLocalService.getCourseStudents(courseId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Student>
		getCourseStudents(long courseId, int start, int end) {

		return _studentLocalService.getCourseStudents(courseId, start, end);
	}

	@Override
	public java.util.List<com.student.info.service.model.Student>
		getCourseStudents(
			long courseId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.student.info.service.model.Student> orderByComparator) {

		return _studentLocalService.getCourseStudents(
			courseId, start, end, orderByComparator);
	}

	@Override
	public int getCourseStudentsCount(long courseId) {
		return _studentLocalService.getCourseStudentsCount(courseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _studentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _studentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the parentIds of the parents associated with the student.
	 *
	 * @param studentId the studentId of the student
	 * @return long[] the parentIds of parents associated with the student
	 */
	@Override
	public long[] getParentPrimaryKeys(long studentId) {
		return _studentLocalService.getParentPrimaryKeys(studentId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Student>
		getParentStudents(long parentId) {

		return _studentLocalService.getParentStudents(parentId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Student>
		getParentStudents(long parentId, int start, int end) {

		return _studentLocalService.getParentStudents(parentId, start, end);
	}

	@Override
	public java.util.List<com.student.info.service.model.Student>
		getParentStudents(
			long parentId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.student.info.service.model.Student> orderByComparator) {

		return _studentLocalService.getParentStudents(
			parentId, start, end, orderByComparator);
	}

	@Override
	public int getParentStudentsCount(long parentId) {
		return _studentLocalService.getParentStudentsCount(parentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the student with the primary key.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws PortalException if a student with the primary key could not be found
	 */
	@Override
	public com.student.info.service.model.Student getStudent(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studentLocalService.getStudent(studentId);
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
	@Override
	public java.util.List<com.student.info.service.model.Student> getStudents(
		int start, int end) {

		return _studentLocalService.getStudents(start, end);
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 */
	@Override
	public int getStudentsCount() {
		return _studentLocalService.getStudentsCount();
	}

	/**
	 * Returns the teacherIds of the teachers associated with the student.
	 *
	 * @param studentId the studentId of the student
	 * @return long[] the teacherIds of teachers associated with the student
	 */
	@Override
	public long[] getTeacherPrimaryKeys(long studentId) {
		return _studentLocalService.getTeacherPrimaryKeys(studentId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Student>
		getTeacherStudents(long teacherId) {

		return _studentLocalService.getTeacherStudents(teacherId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Student>
		getTeacherStudents(long teacherId, int start, int end) {

		return _studentLocalService.getTeacherStudents(teacherId, start, end);
	}

	@Override
	public java.util.List<com.student.info.service.model.Student>
		getTeacherStudents(
			long teacherId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.student.info.service.model.Student> orderByComparator) {

		return _studentLocalService.getTeacherStudents(
			teacherId, start, end, orderByComparator);
	}

	@Override
	public int getTeacherStudentsCount(long teacherId) {
		return _studentLocalService.getTeacherStudentsCount(teacherId);
	}

	@Override
	public boolean hasCourseStudent(long courseId, long studentId) {
		return _studentLocalService.hasCourseStudent(courseId, studentId);
	}

	@Override
	public boolean hasCourseStudents(long courseId) {
		return _studentLocalService.hasCourseStudents(courseId);
	}

	@Override
	public boolean hasParentStudent(long parentId, long studentId) {
		return _studentLocalService.hasParentStudent(parentId, studentId);
	}

	@Override
	public boolean hasParentStudents(long parentId) {
		return _studentLocalService.hasParentStudents(parentId);
	}

	@Override
	public boolean hasTeacherStudent(long teacherId, long studentId) {
		return _studentLocalService.hasTeacherStudent(teacherId, studentId);
	}

	@Override
	public boolean hasTeacherStudents(long teacherId) {
		return _studentLocalService.hasTeacherStudents(teacherId);
	}

	@Override
	public void setCourseStudents(long courseId, long[] studentIds) {
		_studentLocalService.setCourseStudents(courseId, studentIds);
	}

	@Override
	public void setParentStudents(long parentId, long[] studentIds) {
		_studentLocalService.setParentStudents(parentId, studentIds);
	}

	@Override
	public void setTeacherStudents(long teacherId, long[] studentIds) {
		_studentLocalService.setTeacherStudents(teacherId, studentIds);
	}

	@Override
	public com.student.info.service.model.Student updateStudent(
		long studentId, String studentName, String studentPlace,
		String studentEmail) {

		return _studentLocalService.updateStudent(
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
	@Override
	public com.student.info.service.model.Student updateStudent(
		com.student.info.service.model.Student student) {

		return _studentLocalService.updateStudent(student);
	}

	@Override
	public StudentLocalService getWrappedService() {
		return _studentLocalService;
	}

	@Override
	public void setWrappedService(StudentLocalService studentLocalService) {
		_studentLocalService = studentLocalService;
	}

	private StudentLocalService _studentLocalService;

}