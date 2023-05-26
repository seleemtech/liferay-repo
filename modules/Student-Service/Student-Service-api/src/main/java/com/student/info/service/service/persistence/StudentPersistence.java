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

import com.student.info.service.exception.NoSuchStudentException;
import com.student.info.service.model.Student;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentUtil
 * @generated
 */
@ProviderType
public interface StudentPersistence extends BasePersistence<Student> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	public void cacheResult(Student student);

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	public void cacheResult(java.util.List<Student> students);

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	public Student create(long studentId);

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	public Student remove(long studentId) throws NoSuchStudentException;

	public Student updateImpl(Student student);

	/**
	 * Returns the student with the primary key or throws a <code>NoSuchStudentException</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws NoSuchStudentException if a student with the primary key could not be found
	 */
	public Student findByPrimaryKey(long studentId)
		throws NoSuchStudentException;

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 */
	public Student fetchByPrimaryKey(long studentId);

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 */
	public java.util.List<Student> findAll();

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
	public java.util.List<Student> findAll(int start, int end);

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
	public java.util.List<Student> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

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
	public java.util.List<Student> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the students from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of parents associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return long[] of the primaryKeys of parents associated with the student
	 */
	public long[] getParentPrimaryKeys(long pk);

	/**
	 * Returns all the student associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @return the students associated with the parent
	 */
	public java.util.List<Student> getParentStudents(long pk);

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
	public java.util.List<Student> getParentStudents(
		long pk, int start, int end);

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
	public java.util.List<Student> getParentStudents(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

	/**
	 * Returns the number of parents associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the number of parents associated with the student
	 */
	public int getParentsSize(long pk);

	/**
	 * Returns <code>true</code> if the parent is associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @param parentPK the primary key of the parent
	 * @return <code>true</code> if the parent is associated with the student; <code>false</code> otherwise
	 */
	public boolean containsParent(long pk, long parentPK);

	/**
	 * Returns <code>true</code> if the student has any parents associated with it.
	 *
	 * @param pk the primary key of the student to check for associations with parents
	 * @return <code>true</code> if the student has any parents associated with it; <code>false</code> otherwise
	 */
	public boolean containsParents(long pk);

	/**
	 * Adds an association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPK the primary key of the parent
	 */
	public void addParent(long pk, long parentPK);

	/**
	 * Adds an association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parent the parent
	 */
	public void addParent(
		long pk, com.student.info.service.model.Parent parent);

	/**
	 * Adds an association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPKs the primary keys of the parents
	 */
	public void addParents(long pk, long[] parentPKs);

	/**
	 * Adds an association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parents the parents
	 */
	public void addParents(
		long pk, java.util.List<com.student.info.service.model.Parent> parents);

	/**
	 * Clears all associations between the student and its parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student to clear the associated parents from
	 */
	public void clearParents(long pk);

	/**
	 * Removes the association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPK the primary key of the parent
	 */
	public void removeParent(long pk, long parentPK);

	/**
	 * Removes the association between the student and the parent. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parent the parent
	 */
	public void removeParent(
		long pk, com.student.info.service.model.Parent parent);

	/**
	 * Removes the association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPKs the primary keys of the parents
	 */
	public void removeParents(long pk, long[] parentPKs);

	/**
	 * Removes the association between the student and the parents. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parents the parents
	 */
	public void removeParents(
		long pk, java.util.List<com.student.info.service.model.Parent> parents);

	/**
	 * Sets the parents associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parentPKs the primary keys of the parents to be associated with the student
	 */
	public void setParents(long pk, long[] parentPKs);

	/**
	 * Sets the parents associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param parents the parents to be associated with the student
	 */
	public void setParents(
		long pk, java.util.List<com.student.info.service.model.Parent> parents);

	/**
	 * Returns the primaryKeys of courses associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return long[] of the primaryKeys of courses associated with the student
	 */
	public long[] getCoursePrimaryKeys(long pk);

	/**
	 * Returns all the student associated with the course.
	 *
	 * @param pk the primary key of the course
	 * @return the students associated with the course
	 */
	public java.util.List<Student> getCourseStudents(long pk);

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
	public java.util.List<Student> getCourseStudents(
		long pk, int start, int end);

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
	public java.util.List<Student> getCourseStudents(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

	/**
	 * Returns the number of courses associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the number of courses associated with the student
	 */
	public int getCoursesSize(long pk);

	/**
	 * Returns <code>true</code> if the course is associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @param coursePK the primary key of the course
	 * @return <code>true</code> if the course is associated with the student; <code>false</code> otherwise
	 */
	public boolean containsCourse(long pk, long coursePK);

	/**
	 * Returns <code>true</code> if the student has any courses associated with it.
	 *
	 * @param pk the primary key of the student to check for associations with courses
	 * @return <code>true</code> if the student has any courses associated with it; <code>false</code> otherwise
	 */
	public boolean containsCourses(long pk);

	/**
	 * Adds an association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePK the primary key of the course
	 */
	public void addCourse(long pk, long coursePK);

	/**
	 * Adds an association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param course the course
	 */
	public void addCourse(
		long pk, com.student.info.service.model.Course course);

	/**
	 * Adds an association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePKs the primary keys of the courses
	 */
	public void addCourses(long pk, long[] coursePKs);

	/**
	 * Adds an association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param courses the courses
	 */
	public void addCourses(
		long pk, java.util.List<com.student.info.service.model.Course> courses);

	/**
	 * Clears all associations between the student and its courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student to clear the associated courses from
	 */
	public void clearCourses(long pk);

	/**
	 * Removes the association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePK the primary key of the course
	 */
	public void removeCourse(long pk, long coursePK);

	/**
	 * Removes the association between the student and the course. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param course the course
	 */
	public void removeCourse(
		long pk, com.student.info.service.model.Course course);

	/**
	 * Removes the association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePKs the primary keys of the courses
	 */
	public void removeCourses(long pk, long[] coursePKs);

	/**
	 * Removes the association between the student and the courses. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param courses the courses
	 */
	public void removeCourses(
		long pk, java.util.List<com.student.info.service.model.Course> courses);

	/**
	 * Sets the courses associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param coursePKs the primary keys of the courses to be associated with the student
	 */
	public void setCourses(long pk, long[] coursePKs);

	/**
	 * Sets the courses associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param courses the courses to be associated with the student
	 */
	public void setCourses(
		long pk, java.util.List<com.student.info.service.model.Course> courses);

	/**
	 * Returns the primaryKeys of teachers associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return long[] of the primaryKeys of teachers associated with the student
	 */
	public long[] getTeacherPrimaryKeys(long pk);

	/**
	 * Returns all the student associated with the teacher.
	 *
	 * @param pk the primary key of the teacher
	 * @return the students associated with the teacher
	 */
	public java.util.List<Student> getTeacherStudents(long pk);

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
	public java.util.List<Student> getTeacherStudents(
		long pk, int start, int end);

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
	public java.util.List<Student> getTeacherStudents(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student>
			orderByComparator);

	/**
	 * Returns the number of teachers associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the number of teachers associated with the student
	 */
	public int getTeachersSize(long pk);

	/**
	 * Returns <code>true</code> if the teacher is associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPK the primary key of the teacher
	 * @return <code>true</code> if the teacher is associated with the student; <code>false</code> otherwise
	 */
	public boolean containsTeacher(long pk, long teacherPK);

	/**
	 * Returns <code>true</code> if the student has any teachers associated with it.
	 *
	 * @param pk the primary key of the student to check for associations with teachers
	 * @return <code>true</code> if the student has any teachers associated with it; <code>false</code> otherwise
	 */
	public boolean containsTeachers(long pk);

	/**
	 * Adds an association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPK the primary key of the teacher
	 */
	public void addTeacher(long pk, long teacherPK);

	/**
	 * Adds an association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacher the teacher
	 */
	public void addTeacher(
		long pk, com.student.info.service.model.Teacher teacher);

	/**
	 * Adds an association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPKs the primary keys of the teachers
	 */
	public void addTeachers(long pk, long[] teacherPKs);

	/**
	 * Adds an association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teachers the teachers
	 */
	public void addTeachers(
		long pk,
		java.util.List<com.student.info.service.model.Teacher> teachers);

	/**
	 * Clears all associations between the student and its teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student to clear the associated teachers from
	 */
	public void clearTeachers(long pk);

	/**
	 * Removes the association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPK the primary key of the teacher
	 */
	public void removeTeacher(long pk, long teacherPK);

	/**
	 * Removes the association between the student and the teacher. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacher the teacher
	 */
	public void removeTeacher(
		long pk, com.student.info.service.model.Teacher teacher);

	/**
	 * Removes the association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPKs the primary keys of the teachers
	 */
	public void removeTeachers(long pk, long[] teacherPKs);

	/**
	 * Removes the association between the student and the teachers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teachers the teachers
	 */
	public void removeTeachers(
		long pk,
		java.util.List<com.student.info.service.model.Teacher> teachers);

	/**
	 * Sets the teachers associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teacherPKs the primary keys of the teachers to be associated with the student
	 */
	public void setTeachers(long pk, long[] teacherPKs);

	/**
	 * Sets the teachers associated with the student, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the student
	 * @param teachers the teachers to be associated with the student
	 */
	public void setTeachers(
		long pk,
		java.util.List<com.student.info.service.model.Teacher> teachers);

}