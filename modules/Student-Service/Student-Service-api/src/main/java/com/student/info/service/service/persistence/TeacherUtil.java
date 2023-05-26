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

package com.student.info.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.student.info.service.model.Teacher;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the teacher service. This utility wraps <code>com.student.info.service.service.persistence.impl.TeacherPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeacherPersistence
 * @generated
 */
public class TeacherUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Teacher teacher) {
		getPersistence().clearCache(teacher);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Teacher> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Teacher> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Teacher> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Teacher> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Teacher> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Teacher update(Teacher teacher) {
		return getPersistence().update(teacher);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Teacher update(
		Teacher teacher, ServiceContext serviceContext) {

		return getPersistence().update(teacher, serviceContext);
	}

	/**
	 * Caches the teacher in the entity cache if it is enabled.
	 *
	 * @param teacher the teacher
	 */
	public static void cacheResult(Teacher teacher) {
		getPersistence().cacheResult(teacher);
	}

	/**
	 * Caches the teachers in the entity cache if it is enabled.
	 *
	 * @param teachers the teachers
	 */
	public static void cacheResult(List<Teacher> teachers) {
		getPersistence().cacheResult(teachers);
	}

	/**
	 * Creates a new teacher with the primary key. Does not add the teacher to the database.
	 *
	 * @param teacherId the primary key for the new teacher
	 * @return the new teacher
	 */
	public static Teacher create(long teacherId) {
		return getPersistence().create(teacherId);
	}

	/**
	 * Removes the teacher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher that was removed
	 * @throws NoSuchTeacherException if a teacher with the primary key could not be found
	 */
	public static Teacher remove(long teacherId)
		throws com.student.info.service.exception.NoSuchTeacherException {

		return getPersistence().remove(teacherId);
	}

	public static Teacher updateImpl(Teacher teacher) {
		return getPersistence().updateImpl(teacher);
	}

	/**
	 * Returns the teacher with the primary key or throws a <code>NoSuchTeacherException</code> if it could not be found.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher
	 * @throws NoSuchTeacherException if a teacher with the primary key could not be found
	 */
	public static Teacher findByPrimaryKey(long teacherId)
		throws com.student.info.service.exception.NoSuchTeacherException {

		return getPersistence().findByPrimaryKey(teacherId);
	}

	/**
	 * Returns the teacher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher, or <code>null</code> if a teacher with the primary key could not be found
	 */
	public static Teacher fetchByPrimaryKey(long teacherId) {
		return getPersistence().fetchByPrimaryKey(teacherId);
	}

	/**
	 * Returns all the teachers.
	 *
	 * @return the teachers
	 */
	public static List<Teacher> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the teachers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @return the range of teachers
	 */
	public static List<Teacher> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the teachers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of teachers
	 */
	public static List<Teacher> findAll(
		int start, int end, OrderByComparator<Teacher> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the teachers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of teachers
	 */
	public static List<Teacher> findAll(
		int start, int end, OrderByComparator<Teacher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the teachers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of teachers.
	 *
	 * @return the number of teachers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of students associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return long[] of the primaryKeys of students associated with the teacher
	 */
	public static long[] getStudentPrimaryKeys(long pk) {
		return getPersistence().getStudentPrimaryKeys(pk);
	}

	/**
	 * Returns all the teacher associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the teachers associated with the student
	 */
	public static List<Teacher> getStudentTeachers(long pk) {
		return getPersistence().getStudentTeachers(pk);
	}

	/**
	 * Returns all the teacher associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of teachers associated with the student
	 */
	public static List<Teacher> getStudentTeachers(
		long pk, int start, int end) {

		return getPersistence().getStudentTeachers(pk, start, end);
	}

	/**
	 * Returns all the teacher associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of teachers associated with the student
	 */
	public static List<Teacher> getStudentTeachers(
		long pk, int start, int end,
		OrderByComparator<Teacher> orderByComparator) {

		return getPersistence().getStudentTeachers(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of students associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return the number of students associated with the teacher
	 */
	public static int getStudentsSize(long pk) {
		return getPersistence().getStudentsSize(pk);
	}

	/**
	 * Returns <code>true</code> if the student is associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPK the primary key of the student
	 * @return <code>true</code> if the student is associated with the teacher; <code>false</code> otherwise
	 */
	public static boolean containsStudent(long pk, long studentPK) {
		return getPersistence().containsStudent(pk, studentPK);
	}

	/**
	 * Returns <code>true</code> if the teacher has any students associated with it.
	 *
	 * @param pk the primary key of the teacher to check for associations with students
	 * @return <code>true</code> if the teacher has any students associated with it; <code>false</code> otherwise
	 */
	public static boolean containsStudents(long pk) {
		return getPersistence().containsStudents(pk);
	}

	/**
	 * Adds an association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPK the primary key of the student
	 */
	public static void addStudent(long pk, long studentPK) {
		getPersistence().addStudent(pk, studentPK);
	}

	/**
	 * Adds an association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param student the student
	 */
	public static void addStudent(
		long pk, com.student.info.service.model.Student student) {

		getPersistence().addStudent(pk, student);
	}

	/**
	 * Adds an association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPKs the primary keys of the students
	 */
	public static void addStudents(long pk, long[] studentPKs) {
		getPersistence().addStudents(pk, studentPKs);
	}

	/**
	 * Adds an association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param students the students
	 */
	public static void addStudents(
		long pk, List<com.student.info.service.model.Student> students) {

		getPersistence().addStudents(pk, students);
	}

	/**
	 * Clears all associations between the teacher and its students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher to clear the associated students from
	 */
	public static void clearStudents(long pk) {
		getPersistence().clearStudents(pk);
	}

	/**
	 * Removes the association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPK the primary key of the student
	 */
	public static void removeStudent(long pk, long studentPK) {
		getPersistence().removeStudent(pk, studentPK);
	}

	/**
	 * Removes the association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param student the student
	 */
	public static void removeStudent(
		long pk, com.student.info.service.model.Student student) {

		getPersistence().removeStudent(pk, student);
	}

	/**
	 * Removes the association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPKs the primary keys of the students
	 */
	public static void removeStudents(long pk, long[] studentPKs) {
		getPersistence().removeStudents(pk, studentPKs);
	}

	/**
	 * Removes the association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param students the students
	 */
	public static void removeStudents(
		long pk, List<com.student.info.service.model.Student> students) {

		getPersistence().removeStudents(pk, students);
	}

	/**
	 * Sets the students associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPKs the primary keys of the students to be associated with the teacher
	 */
	public static void setStudents(long pk, long[] studentPKs) {
		getPersistence().setStudents(pk, studentPKs);
	}

	/**
	 * Sets the students associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param students the students to be associated with the teacher
	 */
	public static void setStudents(
		long pk, List<com.student.info.service.model.Student> students) {

		getPersistence().setStudents(pk, students);
	}

	/**
	 * Returns the primaryKeys of courses associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return long[] of the primaryKeys of courses associated with the teacher
	 */
	public static long[] getCoursePrimaryKeys(long pk) {
		return getPersistence().getCoursePrimaryKeys(pk);
	}

	/**
	 * Returns all the teacher associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the teachers associated with the course
	 */
	public static List<Teacher> getCourseTeachers(long pk) {
		return getPersistence().getCourseTeachers(pk);
	}

	/**
	 * Returns all the teacher associated with the course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the course
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of teachers associated with the course
	 */
	public static List<Teacher> getCourseTeachers(long pk, int start, int end) {
		return getPersistence().getCourseTeachers(pk, start, end);
	}

	/**
	 * Returns all the teacher associated with the course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeacherModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the course
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of teachers associated with the course
	 */
	public static List<Teacher> getCourseTeachers(
		long pk, int start, int end,
		OrderByComparator<Teacher> orderByComparator) {

		return getPersistence().getCourseTeachers(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of courses associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return the number of courses associated with the teacher
	 */
	public static int getCoursesSize(long pk) {
		return getPersistence().getCoursesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the course is associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePK the primary key of the course
	 * @return <code>true</code> if the course is associated with the teacher; <code>false</code> otherwise
	 */
	public static boolean containsCourse(long pk, long coursePK) {
		return getPersistence().containsCourse(pk, coursePK);
	}

	/**
	 * Returns <code>true</code> if the teacher has any courses associated with it.
	 *
	 * @param pk the primary key of the teacher to check for associations with courses
	 * @return <code>true</code> if the teacher has any courses associated with it; <code>false</code> otherwise
	 */
	public static boolean containsCourses(long pk) {
		return getPersistence().containsCourses(pk);
	}

	/**
	 * Adds an association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePK the primary key of the course
	 */
	public static void addCourse(long pk, long coursePK) {
		getPersistence().addCourse(pk, coursePK);
	}

	/**
	 * Adds an association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param course the course
	 */
	public static void addCourse(
		long pk, com.student.info.service.model.Course course) {

		getPersistence().addCourse(pk, course);
	}

	/**
	 * Adds an association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePKs the primary keys of the courses
	 */
	public static void addCourses(long pk, long[] coursePKs) {
		getPersistence().addCourses(pk, coursePKs);
	}

	/**
	 * Adds an association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param courses the courses
	 */
	public static void addCourses(
		long pk, List<com.student.info.service.model.Course> courses) {

		getPersistence().addCourses(pk, courses);
	}

	/**
	 * Clears all associations between the teacher and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher to clear the associated courses from
	 */
	public static void clearCourses(long pk) {
		getPersistence().clearCourses(pk);
	}

	/**
	 * Removes the association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePK the primary key of the course
	 */
	public static void removeCourse(long pk, long coursePK) {
		getPersistence().removeCourse(pk, coursePK);
	}

	/**
	 * Removes the association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param course the course
	 */
	public static void removeCourse(
		long pk, com.student.info.service.model.Course course) {

		getPersistence().removeCourse(pk, course);
	}

	/**
	 * Removes the association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePKs the primary keys of the courses
	 */
	public static void removeCourses(long pk, long[] coursePKs) {
		getPersistence().removeCourses(pk, coursePKs);
	}

	/**
	 * Removes the association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param courses the courses
	 */
	public static void removeCourses(
		long pk, List<com.student.info.service.model.Course> courses) {

		getPersistence().removeCourses(pk, courses);
	}

	/**
	 * Sets the courses associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePKs the primary keys of the courses to be associated with the teacher
	 */
	public static void setCourses(long pk, long[] coursePKs) {
		getPersistence().setCourses(pk, coursePKs);
	}

	/**
	 * Sets the courses associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param courses the courses to be associated with the teacher
	 */
	public static void setCourses(
		long pk, List<com.student.info.service.model.Course> courses) {

		getPersistence().setCourses(pk, courses);
	}

	public static TeacherPersistence getPersistence() {
		return _persistence;
	}

	private static volatile TeacherPersistence _persistence;

}