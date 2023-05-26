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

import com.student.info.service.model.Student;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the student service. This utility wraps <code>com.student.info.service.service.persistence.impl.StudentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentPersistence
 * @generated
 */
public class StudentUtil {

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
	public static void clearCache(Student student) {
		getPersistence().clearCache(student);
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
	public static Map<Serializable, Student> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Student> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Student> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Student> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Student update(Student student) {
		return getPersistence().update(student);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Student update(
		Student student, ServiceContext serviceContext) {

		return getPersistence().update(student, serviceContext);
	}

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	public static void cacheResult(Student student) {
		getPersistence().cacheResult(student);
	}

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	public static void cacheResult(List<Student> students) {
		getPersistence().cacheResult(students);
	}

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	public static Student create(long studentId) {
		return getPersistence().create(studentId);
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	public static Student remove(long studentId)
		throws com.student.info.service.exception.NoSuchStudentException {

		return getPersistence().remove(studentId);
	}

	public static Student updateImpl(Student student) {
		return getPersistence().updateImpl(student);
	}

	/**
	 * Returns the student with the primary key or throws a <code>NoSuchStudentException</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	public static Student findByPrimaryKey(long studentId)
		throws com.student.info.service.exception.NoSuchStudentException {

		return getPersistence().findByPrimaryKey(studentId);
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 */
	public static Student fetchByPrimaryKey(long studentId) {
		return getPersistence().fetchByPrimaryKey(studentId);
	}

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 */
	public static List<Student> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of students
	 */
	public static List<Student> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students
	 */
	public static List<Student> findAll(
		int start, int end, OrderByComparator<Student> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of students
	 */
	public static List<Student> findAll(
		int start, int end, OrderByComparator<Student> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the students from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of parents associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return long[] of the primaryKeys of parents associated with the student
	 */
	public static long[] getParentPrimaryKeys(long pk) {
		return getPersistence().getParentPrimaryKeys(pk);
	}

	/**
	 * Returns all the student associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @return the students associated with the parent
	 */
	public static List<Student> getParentStudents(long pk) {
		return getPersistence().getParentStudents(pk);
	}

	/**
	 * Returns all the student associated with the parent.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the parent
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @return the range of students associated with the parent
	 */
	public static List<Student> getParentStudents(long pk, int start, int end) {
		return getPersistence().getParentStudents(pk, start, end);
	}

	/**
	 * Returns all the student associated with the parent.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the parent
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students associated with the parent
	 */
	public static List<Student> getParentStudents(
		long pk, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return getPersistence().getParentStudents(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of parents associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the number of parents associated with the student
	 */
	public static int getParentsSize(long pk) {
		return getPersistence().getParentsSize(pk);
	}

	/**
	 * Returns <code>true</code> if the parent is associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @param parentPK the primary key of the parent
	 * @return <code>true</code> if the parent is associated with the student; <code>false</code> otherwise
	 */
	public static boolean containsParent(long pk, long parentPK) {
		return getPersistence().containsParent(pk, parentPK);
	}

	/**
	 * Returns <code>true</code> if the student has any parents associated with it.
	 *
	 * @param pk the primary key of the student to check for associations with parents
	 * @return <code>true</code> if the student has any parents associated with it; <code>false</code> otherwise
	 */
	public static boolean containsParents(long pk) {
		return getPersistence().containsParents(pk);
	}

	/**
	 * Adds an association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPK the primary key of the parent
	 */
	public static void addParent(long pk, long parentPK) {
		getPersistence().addParent(pk, parentPK);
	}

	/**
	 * Adds an association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parent the parent
	 */
	public static void addParent(
		long pk, com.student.info.service.model.Parent parent) {

		getPersistence().addParent(pk, parent);
	}

	/**
	 * Adds an association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPKs the primary keys of the parents
	 */
	public static void addParents(long pk, long[] parentPKs) {
		getPersistence().addParents(pk, parentPKs);
	}

	/**
	 * Adds an association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parents the parents
	 */
	public static void addParents(
		long pk, List<com.student.info.service.model.Parent> parents) {

		getPersistence().addParents(pk, parents);
	}

	/**
	 * Clears all associations between the student and its parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student to clear the associated parents from
	 */
	public static void clearParents(long pk) {
		getPersistence().clearParents(pk);
	}

	/**
	 * Removes the association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPK the primary key of the parent
	 */
	public static void removeParent(long pk, long parentPK) {
		getPersistence().removeParent(pk, parentPK);
	}

	/**
	 * Removes the association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parent the parent
	 */
	public static void removeParent(
		long pk, com.student.info.service.model.Parent parent) {

		getPersistence().removeParent(pk, parent);
	}

	/**
	 * Removes the association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPKs the primary keys of the parents
	 */
	public static void removeParents(long pk, long[] parentPKs) {
		getPersistence().removeParents(pk, parentPKs);
	}

	/**
	 * Removes the association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parents the parents
	 */
	public static void removeParents(
		long pk, List<com.student.info.service.model.Parent> parents) {

		getPersistence().removeParents(pk, parents);
	}

	/**
	 * Sets the parents associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPKs the primary keys of the parents to be associated with the student
	 */
	public static void setParents(long pk, long[] parentPKs) {
		getPersistence().setParents(pk, parentPKs);
	}

	/**
	 * Sets the parents associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parents the parents to be associated with the student
	 */
	public static void setParents(
		long pk, List<com.student.info.service.model.Parent> parents) {

		getPersistence().setParents(pk, parents);
	}

	/**
	 * Returns the primaryKeys of courses associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return long[] of the primaryKeys of courses associated with the student
	 */
	public static long[] getCoursePrimaryKeys(long pk) {
		return getPersistence().getCoursePrimaryKeys(pk);
	}

	/**
	 * Returns all the student associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the students associated with the course
	 */
	public static List<Student> getCourseStudents(long pk) {
		return getPersistence().getCourseStudents(pk);
	}

	/**
	 * Returns all the student associated with the course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the course
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of students associated with the course
	 */
	public static List<Student> getCourseStudents(long pk, int start, int end) {
		return getPersistence().getCourseStudents(pk, start, end);
	}

	/**
	 * Returns all the student associated with the course.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the course
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students associated with the course
	 */
	public static List<Student> getCourseStudents(
		long pk, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return getPersistence().getCourseStudents(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of courses associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the number of courses associated with the student
	 */
	public static int getCoursesSize(long pk) {
		return getPersistence().getCoursesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the course is associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @param coursePK the primary key of the course
	 * @return <code>true</code> if the course is associated with the student; <code>false</code> otherwise
	 */
	public static boolean containsCourse(long pk, long coursePK) {
		return getPersistence().containsCourse(pk, coursePK);
	}

	/**
	 * Returns <code>true</code> if the student has any courses associated with it.
	 *
	 * @param pk the primary key of the student to check for associations with courses
	 * @return <code>true</code> if the student has any courses associated with it; <code>false</code> otherwise
	 */
	public static boolean containsCourses(long pk) {
		return getPersistence().containsCourses(pk);
	}

	/**
	 * Adds an association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePK the primary key of the course
	 */
	public static void addCourse(long pk, long coursePK) {
		getPersistence().addCourse(pk, coursePK);
	}

	/**
	 * Adds an association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param course the course
	 */
	public static void addCourse(
		long pk, com.student.info.service.model.Course course) {

		getPersistence().addCourse(pk, course);
	}

	/**
	 * Adds an association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePKs the primary keys of the courses
	 */
	public static void addCourses(long pk, long[] coursePKs) {
		getPersistence().addCourses(pk, coursePKs);
	}

	/**
	 * Adds an association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param courses the courses
	 */
	public static void addCourses(
		long pk, List<com.student.info.service.model.Course> courses) {

		getPersistence().addCourses(pk, courses);
	}

	/**
	 * Clears all associations between the student and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student to clear the associated courses from
	 */
	public static void clearCourses(long pk) {
		getPersistence().clearCourses(pk);
	}

	/**
	 * Removes the association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePK the primary key of the course
	 */
	public static void removeCourse(long pk, long coursePK) {
		getPersistence().removeCourse(pk, coursePK);
	}

	/**
	 * Removes the association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param course the course
	 */
	public static void removeCourse(
		long pk, com.student.info.service.model.Course course) {

		getPersistence().removeCourse(pk, course);
	}

	/**
	 * Removes the association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePKs the primary keys of the courses
	 */
	public static void removeCourses(long pk, long[] coursePKs) {
		getPersistence().removeCourses(pk, coursePKs);
	}

	/**
	 * Removes the association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param courses the courses
	 */
	public static void removeCourses(
		long pk, List<com.student.info.service.model.Course> courses) {

		getPersistence().removeCourses(pk, courses);
	}

	/**
	 * Sets the courses associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePKs the primary keys of the courses to be associated with the student
	 */
	public static void setCourses(long pk, long[] coursePKs) {
		getPersistence().setCourses(pk, coursePKs);
	}

	/**
	 * Sets the courses associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param courses the courses to be associated with the student
	 */
	public static void setCourses(
		long pk, List<com.student.info.service.model.Course> courses) {

		getPersistence().setCourses(pk, courses);
	}

	/**
	 * Returns the primaryKeys of teachers associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return long[] of the primaryKeys of teachers associated with the student
	 */
	public static long[] getTeacherPrimaryKeys(long pk) {
		return getPersistence().getTeacherPrimaryKeys(pk);
	}

	/**
	 * Returns all the student associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return the students associated with the teacher
	 */
	public static List<Student> getTeacherStudents(long pk) {
		return getPersistence().getTeacherStudents(pk);
	}

	/**
	 * Returns all the student associated with the teacher.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the teacher
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @return the range of students associated with the teacher
	 */
	public static List<Student> getTeacherStudents(
		long pk, int start, int end) {

		return getPersistence().getTeacherStudents(pk, start, end);
	}

	/**
	 * Returns all the student associated with the teacher.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the teacher
	 * @param start the lower bound of the range of teachers
	 * @param end the upper bound of the range of teachers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students associated with the teacher
	 */
	public static List<Student> getTeacherStudents(
		long pk, int start, int end,
		OrderByComparator<Student> orderByComparator) {

		return getPersistence().getTeacherStudents(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of teachers associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the number of teachers associated with the student
	 */
	public static int getTeachersSize(long pk) {
		return getPersistence().getTeachersSize(pk);
	}

	/**
	 * Returns <code>true</code> if the teacher is associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPK the primary key of the teacher
	 * @return <code>true</code> if the teacher is associated with the student; <code>false</code> otherwise
	 */
	public static boolean containsTeacher(long pk, long teacherPK) {
		return getPersistence().containsTeacher(pk, teacherPK);
	}

	/**
	 * Returns <code>true</code> if the student has any teachers associated with it.
	 *
	 * @param pk the primary key of the student to check for associations with teachers
	 * @return <code>true</code> if the student has any teachers associated with it; <code>false</code> otherwise
	 */
	public static boolean containsTeachers(long pk) {
		return getPersistence().containsTeachers(pk);
	}

	/**
	 * Adds an association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPK the primary key of the teacher
	 */
	public static void addTeacher(long pk, long teacherPK) {
		getPersistence().addTeacher(pk, teacherPK);
	}

	/**
	 * Adds an association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacher the teacher
	 */
	public static void addTeacher(
		long pk, com.student.info.service.model.Teacher teacher) {

		getPersistence().addTeacher(pk, teacher);
	}

	/**
	 * Adds an association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPKs the primary keys of the teachers
	 */
	public static void addTeachers(long pk, long[] teacherPKs) {
		getPersistence().addTeachers(pk, teacherPKs);
	}

	/**
	 * Adds an association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teachers the teachers
	 */
	public static void addTeachers(
		long pk, List<com.student.info.service.model.Teacher> teachers) {

		getPersistence().addTeachers(pk, teachers);
	}

	/**
	 * Clears all associations between the student and its teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student to clear the associated teachers from
	 */
	public static void clearTeachers(long pk) {
		getPersistence().clearTeachers(pk);
	}

	/**
	 * Removes the association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPK the primary key of the teacher
	 */
	public static void removeTeacher(long pk, long teacherPK) {
		getPersistence().removeTeacher(pk, teacherPK);
	}

	/**
	 * Removes the association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacher the teacher
	 */
	public static void removeTeacher(
		long pk, com.student.info.service.model.Teacher teacher) {

		getPersistence().removeTeacher(pk, teacher);
	}

	/**
	 * Removes the association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPKs the primary keys of the teachers
	 */
	public static void removeTeachers(long pk, long[] teacherPKs) {
		getPersistence().removeTeachers(pk, teacherPKs);
	}

	/**
	 * Removes the association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teachers the teachers
	 */
	public static void removeTeachers(
		long pk, List<com.student.info.service.model.Teacher> teachers) {

		getPersistence().removeTeachers(pk, teachers);
	}

	/**
	 * Sets the teachers associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPKs the primary keys of the teachers to be associated with the student
	 */
	public static void setTeachers(long pk, long[] teacherPKs) {
		getPersistence().setTeachers(pk, teacherPKs);
	}

	/**
	 * Sets the teachers associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teachers the teachers to be associated with the student
	 */
	public static void setTeachers(
		long pk, List<com.student.info.service.model.Teacher> teachers) {

		getPersistence().setTeachers(pk, teachers);
	}

	public static StudentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile StudentPersistence _persistence;

}