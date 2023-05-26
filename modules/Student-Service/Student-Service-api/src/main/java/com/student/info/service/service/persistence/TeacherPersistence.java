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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.student.info.service.exception.NoSuchTeacherException;
import com.student.info.service.model.Teacher;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the teacher service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeacherUtil
 * @generated
 */
@ProviderType
public interface TeacherPersistence extends BasePersistence<Teacher> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TeacherUtil} to access the teacher persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the teacher in the entity cache if it is enabled.
	 *
	 * @param teacher the teacher
	 */
	public void cacheResult(Teacher teacher);

	/**
	 * Caches the teachers in the entity cache if it is enabled.
	 *
	 * @param teachers the teachers
	 */
	public void cacheResult(java.util.List<Teacher> teachers);

	/**
	 * Creates a new teacher with the primary key. Does not add the teacher to the database.
	 *
	 * @param teacherId the primary key for the new teacher
	 * @return the new teacher
	 */
	public Teacher create(long teacherId);

	/**
	 * Removes the teacher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher that was removed
	 * @throws NoSuchTeacherException if a teacher with the primary key could not be found
	 */
	public Teacher remove(long teacherId) throws NoSuchTeacherException;

	public Teacher updateImpl(Teacher teacher);

	/**
	 * Returns the teacher with the primary key or throws a <code>NoSuchTeacherException</code> if it could not be found.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher
	 * @throws NoSuchTeacherException if a teacher with the primary key could not be found
	 */
	public Teacher findByPrimaryKey(long teacherId)
		throws NoSuchTeacherException;

	/**
	 * Returns the teacher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param teacherId the primary key of the teacher
	 * @return the teacher, or <code>null</code> if a teacher with the primary key could not be found
	 */
	public Teacher fetchByPrimaryKey(long teacherId);

	/**
	 * Returns all the teachers.
	 *
	 * @return the teachers
	 */
	public java.util.List<Teacher> findAll();

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
	public java.util.List<Teacher> findAll(int start, int end);

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
	public java.util.List<Teacher> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Teacher>
			orderByComparator);

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
	public java.util.List<Teacher> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Teacher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the teachers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of teachers.
	 *
	 * @return the number of teachers
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of students associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return long[] of the primaryKeys of students associated with the teacher
	 */
	public long[] getStudentPrimaryKeys(long pk);

	/**
	 * Returns all the teacher associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the teachers associated with the student
	 */
	public java.util.List<Teacher> getStudentTeachers(long pk);

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
	public java.util.List<Teacher> getStudentTeachers(
		long pk, int start, int end);

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
	public java.util.List<Teacher> getStudentTeachers(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Teacher>
			orderByComparator);

	/**
	 * Returns the number of students associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return the number of students associated with the teacher
	 */
	public int getStudentsSize(long pk);

	/**
	 * Returns <code>true</code> if the student is associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPK the primary key of the student
	 * @return <code>true</code> if the student is associated with the teacher; <code>false</code> otherwise
	 */
	public boolean containsStudent(long pk, long studentPK);

	/**
	 * Returns <code>true</code> if the teacher has any students associated with it.
	 *
	 * @param pk the primary key of the teacher to check for associations with students
	 * @return <code>true</code> if the teacher has any students associated with it; <code>false</code> otherwise
	 */
	public boolean containsStudents(long pk);

	/**
	 * Adds an association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPK the primary key of the student
	 */
	public void addStudent(long pk, long studentPK);

	/**
	 * Adds an association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param student the student
	 */
	public void addStudent(
		long pk, com.student.info.service.model.Student student);

	/**
	 * Adds an association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPKs the primary keys of the students
	 */
	public void addStudents(long pk, long[] studentPKs);

	/**
	 * Adds an association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param students the students
	 */
	public void addStudents(
		long pk,
		java.util.List<com.student.info.service.model.Student> students);

	/**
	 * Clears all associations between the teacher and its students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher to clear the associated students from
	 */
	public void clearStudents(long pk);

	/**
	 * Removes the association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPK the primary key of the student
	 */
	public void removeStudent(long pk, long studentPK);

	/**
	 * Removes the association between the teacher and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param student the student
	 */
	public void removeStudent(
		long pk, com.student.info.service.model.Student student);

	/**
	 * Removes the association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPKs the primary keys of the students
	 */
	public void removeStudents(long pk, long[] studentPKs);

	/**
	 * Removes the association between the teacher and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param students the students
	 */
	public void removeStudents(
		long pk,
		java.util.List<com.student.info.service.model.Student> students);

	/**
	 * Sets the students associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param studentPKs the primary keys of the students to be associated with the teacher
	 */
	public void setStudents(long pk, long[] studentPKs);

	/**
	 * Sets the students associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param students the students to be associated with the teacher
	 */
	public void setStudents(
		long pk,
		java.util.List<com.student.info.service.model.Student> students);

	/**
	 * Returns the primaryKeys of courses associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return long[] of the primaryKeys of courses associated with the teacher
	 */
	public long[] getCoursePrimaryKeys(long pk);

	/**
	 * Returns all the teacher associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the teachers associated with the course
	 */
	public java.util.List<Teacher> getCourseTeachers(long pk);

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
	public java.util.List<Teacher> getCourseTeachers(
		long pk, int start, int end);

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
	public java.util.List<Teacher> getCourseTeachers(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Teacher>
			orderByComparator);

	/**
	 * Returns the number of courses associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return the number of courses associated with the teacher
	 */
	public int getCoursesSize(long pk);

	/**
	 * Returns <code>true</code> if the course is associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePK the primary key of the course
	 * @return <code>true</code> if the course is associated with the teacher; <code>false</code> otherwise
	 */
	public boolean containsCourse(long pk, long coursePK);

	/**
	 * Returns <code>true</code> if the teacher has any courses associated with it.
	 *
	 * @param pk the primary key of the teacher to check for associations with courses
	 * @return <code>true</code> if the teacher has any courses associated with it; <code>false</code> otherwise
	 */
	public boolean containsCourses(long pk);

	/**
	 * Adds an association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePK the primary key of the course
	 */
	public void addCourse(long pk, long coursePK);

	/**
	 * Adds an association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param course the course
	 */
	public void addCourse(
		long pk, com.student.info.service.model.Course course);

	/**
	 * Adds an association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePKs the primary keys of the courses
	 */
	public void addCourses(long pk, long[] coursePKs);

	/**
	 * Adds an association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param courses the courses
	 */
	public void addCourses(
		long pk, java.util.List<com.student.info.service.model.Course> courses);

	/**
	 * Clears all associations between the teacher and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher to clear the associated courses from
	 */
	public void clearCourses(long pk);

	/**
	 * Removes the association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePK the primary key of the course
	 */
	public void removeCourse(long pk, long coursePK);

	/**
	 * Removes the association between the teacher and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param course the course
	 */
	public void removeCourse(
		long pk, com.student.info.service.model.Course course);

	/**
	 * Removes the association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePKs the primary keys of the courses
	 */
	public void removeCourses(long pk, long[] coursePKs);

	/**
	 * Removes the association between the teacher and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param courses the courses
	 */
	public void removeCourses(
		long pk, java.util.List<com.student.info.service.model.Course> courses);

	/**
	 * Sets the courses associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param coursePKs the primary keys of the courses to be associated with the teacher
	 */
	public void setCourses(long pk, long[] coursePKs);

	/**
	 * Sets the courses associated with the teacher, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the teacher
	 * @param courses the courses to be associated with the teacher
	 */
	public void setCourses(
		long pk, java.util.List<com.student.info.service.model.Course> courses);

}