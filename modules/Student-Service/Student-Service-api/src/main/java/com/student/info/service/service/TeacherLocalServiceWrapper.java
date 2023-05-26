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
 * Provides a wrapper for {@link TeacherLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TeacherLocalService
 * @generated
 */
public class TeacherLocalServiceWrapper
	implements ServiceWrapper<TeacherLocalService>, TeacherLocalService {

	public TeacherLocalServiceWrapper() {
		this(null);
	}

	public TeacherLocalServiceWrapper(TeacherLocalService teacherLocalService) {
		_teacherLocalService = teacherLocalService;
	}

	@Override
	public void addCourseTeacher(long courseId, long teacherId) {
		_teacherLocalService.addCourseTeacher(courseId, teacherId);
	}

	@Override
	public void addCourseTeacher(
		long courseId, com.student.info.service.model.Teacher teacher) {

		_teacherLocalService.addCourseTeacher(courseId, teacher);
	}

	@Override
	public void addCourseTeachers(
		long courseId,
		java.util.List<com.student.info.service.model.Teacher> teachers) {

		_teacherLocalService.addCourseTeachers(courseId, teachers);
	}

	@Override
	public void addCourseTeachers(long courseId, long[] teacherIds) {
		_teacherLocalService.addCourseTeachers(courseId, teacherIds);
	}

	@Override
	public void addStudentTeacher(long studentId, long teacherId) {
		_teacherLocalService.addStudentTeacher(studentId, teacherId);
	}

	@Override
	public void addStudentTeacher(
		long studentId, com.student.info.service.model.Teacher teacher) {

		_teacherLocalService.addStudentTeacher(studentId, teacher);
	}

	@Override
	public void addStudentTeachers(
		long studentId,
		java.util.List<com.student.info.service.model.Teacher> teachers) {

		_teacherLocalService.addStudentTeachers(studentId, teachers);
	}

	@Override
	public void addStudentTeachers(long studentId, long[] teacherIds) {
		_teacherLocalService.addStudentTeachers(studentId, teacherIds);
	}

	@Override
	public com.student.info.service.model.Teacher addTeacher(
		long teacherId, String teacherName, String teacherEmail,
		long companyId) {

		return _teacherLocalService.addTeacher(
			teacherId, teacherName, teacherEmail, companyId);
	}

	/**
	 * Adds the teacher to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacher the teacher
	 * @return the teacher that was added
	 */
	@Override
	public com.student.info.service.model.Teacher addTeacher(
		com.student.info.service.model.Teacher teacher) {

		return _teacherLocalService.addTeacher(teacher);
	}

	@Override
	public void clearCourseTeachers(long courseId) {
		_teacherLocalService.clearCourseTeachers(courseId);
	}

	@Override
	public void clearStudentTeachers(long studentId) {
		_teacherLocalService.clearStudentTeachers(studentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new teacher with the primary key. Does not add the teacher to the database.
	 *
	 * @param teacherId the primary key for the new teacher
	 * @return the new teacher
	 */
	@Override
	public com.student.info.service.model.Teacher createTeacher(
		long teacherId) {

		return _teacherLocalService.createTeacher(teacherId);
	}

	@Override
	public void deleteCourseTeacher(long courseId, long teacherId) {
		_teacherLocalService.deleteCourseTeacher(courseId, teacherId);
	}

	@Override
	public void deleteCourseTeacher(
		long courseId, com.student.info.service.model.Teacher teacher) {

		_teacherLocalService.deleteCourseTeacher(courseId, teacher);
	}

	@Override
	public void deleteCourseTeachers(
		long courseId,
		java.util.List<com.student.info.service.model.Teacher> teachers) {

		_teacherLocalService.deleteCourseTeachers(courseId, teachers);
	}

	@Override
	public void deleteCourseTeachers(long courseId, long[] teacherIds) {
		_teacherLocalService.deleteCourseTeachers(courseId, teacherIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteStudentTeacher(long studentId, long teacherId) {
		_teacherLocalService.deleteStudentTeacher(studentId, teacherId);
	}

	@Override
	public void deleteStudentTeacher(
		long studentId, com.student.info.service.model.Teacher teacher) {

		_teacherLocalService.deleteStudentTeacher(studentId, teacher);
	}

	@Override
	public void deleteStudentTeachers(
		long studentId,
		java.util.List<com.student.info.service.model.Teacher> teachers) {

		_teacherLocalService.deleteStudentTeachers(studentId, teachers);
	}

	@Override
	public void deleteStudentTeachers(long studentId, long[] teacherIds) {
		_teacherLocalService.deleteStudentTeachers(studentId, teacherIds);
	}

	/**
	 * Deletes the teacher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher that was removed
	 * @throws PortalException if a teacher with the primary key could not be found
	 */
	@Override
	public com.student.info.service.model.Teacher deleteTeacher(long teacherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.deleteTeacher(teacherId);
	}

	/**
	 * Deletes the teacher from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacher the teacher
	 * @return the teacher that was removed
	 */
	@Override
	public com.student.info.service.model.Teacher deleteTeacher(
		com.student.info.service.model.Teacher teacher) {

		return _teacherLocalService.deleteTeacher(teacher);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _teacherLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _teacherLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _teacherLocalService.dynamicQuery();
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

		return _teacherLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.TeacherModelImpl</code>.
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

		return _teacherLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.TeacherModelImpl</code>.
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

		return _teacherLocalService.dynamicQuery(
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

		return _teacherLocalService.dynamicQueryCount(dynamicQuery);
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

		return _teacherLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.student.info.service.model.Teacher fetchTeacher(long teacherId) {
		return _teacherLocalService.fetchTeacher(teacherId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _teacherLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the courseIds of the courses associated with the teacher.
	 *
	 * @param teacherId the teacherId of the teacher
	 * @return long[] the courseIds of courses associated with the teacher
	 */
	@Override
	public long[] getCoursePrimaryKeys(long teacherId) {
		return _teacherLocalService.getCoursePrimaryKeys(teacherId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Teacher>
		getCourseTeachers(long courseId) {

		return _teacherLocalService.getCourseTeachers(courseId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Teacher>
		getCourseTeachers(long courseId, int start, int end) {

		return _teacherLocalService.getCourseTeachers(courseId, start, end);
	}

	@Override
	public java.util.List<com.student.info.service.model.Teacher>
		getCourseTeachers(
			long courseId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.student.info.service.model.Teacher> orderByComparator) {

		return _teacherLocalService.getCourseTeachers(
			courseId, start, end, orderByComparator);
	}

	@Override
	public int getCourseTeachersCount(long courseId) {
		return _teacherLocalService.getCourseTeachersCount(courseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _teacherLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _teacherLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the studentIds of the students associated with the teacher.
	 *
	 * @param teacherId the teacherId of the teacher
	 * @return long[] the studentIds of students associated with the teacher
	 */
	@Override
	public long[] getStudentPrimaryKeys(long teacherId) {
		return _teacherLocalService.getStudentPrimaryKeys(teacherId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Teacher>
		getStudentTeachers(long studentId) {

		return _teacherLocalService.getStudentTeachers(studentId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Teacher>
		getStudentTeachers(long studentId, int start, int end) {

		return _teacherLocalService.getStudentTeachers(studentId, start, end);
	}

	@Override
	public java.util.List<com.student.info.service.model.Teacher>
		getStudentTeachers(
			long studentId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.student.info.service.model.Teacher> orderByComparator) {

		return _teacherLocalService.getStudentTeachers(
			studentId, start, end, orderByComparator);
	}

	@Override
	public int getStudentTeachersCount(long studentId) {
		return _teacherLocalService.getStudentTeachersCount(studentId);
	}

	/**
	 * Returns the teacher with the primary key.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher
	 * @throws PortalException if a teacher with the primary key could not be found
	 */
	@Override
	public com.student.info.service.model.Teacher getTeacher(long teacherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _teacherLocalService.getTeacher(teacherId);
	}

	/**
	 * Returns a range of all the teachers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @return the range of teachers
	 */
	@Override
	public java.util.List<com.student.info.service.model.Teacher> getTeachers(
		int start, int end) {

		return _teacherLocalService.getTeachers(start, end);
	}

	/**
	 * Returns the number of teachers.
	 *
	 * @return the number of teachers
	 */
	@Override
	public int getTeachersCount() {
		return _teacherLocalService.getTeachersCount();
	}

	@Override
	public boolean hasCourseTeacher(long courseId, long teacherId) {
		return _teacherLocalService.hasCourseTeacher(courseId, teacherId);
	}

	@Override
	public boolean hasCourseTeachers(long courseId) {
		return _teacherLocalService.hasCourseTeachers(courseId);
	}

	@Override
	public boolean hasStudentTeacher(long studentId, long teacherId) {
		return _teacherLocalService.hasStudentTeacher(studentId, teacherId);
	}

	@Override
	public boolean hasStudentTeachers(long studentId) {
		return _teacherLocalService.hasStudentTeachers(studentId);
	}

	@Override
	public void setCourseTeachers(long courseId, long[] teacherIds) {
		_teacherLocalService.setCourseTeachers(courseId, teacherIds);
	}

	@Override
	public void setStudentTeachers(long studentId, long[] teacherIds) {
		_teacherLocalService.setStudentTeachers(studentId, teacherIds);
	}

	@Override
	public com.student.info.service.model.Teacher updateTeacher(
		long teacherId, String teacherName, String teacherEmail) {

		return _teacherLocalService.updateTeacher(
			teacherId, teacherName, teacherEmail);
	}

	/**
	 * Updates the teacher in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TeacherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param teacher the teacher
	 * @return the teacher that was updated
	 */
	@Override
	public com.student.info.service.model.Teacher updateTeacher(
		com.student.info.service.model.Teacher teacher) {

		return _teacherLocalService.updateTeacher(teacher);
	}

	@Override
	public TeacherLocalService getWrappedService() {
		return _teacherLocalService;
	}

	@Override
	public void setWrappedService(TeacherLocalService teacherLocalService) {
		_teacherLocalService = teacherLocalService;
	}

	private TeacherLocalService _teacherLocalService;

}