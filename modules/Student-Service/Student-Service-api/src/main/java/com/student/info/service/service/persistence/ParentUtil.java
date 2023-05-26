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

import com.student.info.service.model.Parent;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the parent service. This utility wraps <code>com.student.info.service.service.persistence.impl.ParentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ParentPersistence
 * @generated
 */
public class ParentUtil {

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
	public static void clearCache(Parent parent) {
		getPersistence().clearCache(parent);
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
	public static Map<Serializable, Parent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Parent> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Parent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Parent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Parent> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Parent update(Parent parent) {
		return getPersistence().update(parent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Parent update(Parent parent, ServiceContext serviceContext) {
		return getPersistence().update(parent, serviceContext);
	}

	/**
	 * Caches the parent in the entity cache if it is enabled.
	 *
	 * @param parent the parent
	 */
	public static void cacheResult(Parent parent) {
		getPersistence().cacheResult(parent);
	}

	/**
	 * Caches the parents in the entity cache if it is enabled.
	 *
	 * @param parents the parents
	 */
	public static void cacheResult(List<Parent> parents) {
		getPersistence().cacheResult(parents);
	}

	/**
	 * Creates a new parent with the primary key. Does not add the parent to the database.
	 *
	 * @param parentId the primary key for the new parent
	 * @return the new parent
	 */
	public static Parent create(long parentId) {
		return getPersistence().create(parentId);
	}

	/**
	 * Removes the parent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent that was removed
	 * @throws NoSuchParentException if a parent with the primary key could not be found
	 */
	public static Parent remove(long parentId)
		throws com.student.info.service.exception.NoSuchParentException {

		return getPersistence().remove(parentId);
	}

	public static Parent updateImpl(Parent parent) {
		return getPersistence().updateImpl(parent);
	}

	/**
	 * Returns the parent with the primary key or throws a <code>NoSuchParentException</code> if it could not be found.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent
	 * @throws NoSuchParentException if a parent with the primary key could not be found
	 */
	public static Parent findByPrimaryKey(long parentId)
		throws com.student.info.service.exception.NoSuchParentException {

		return getPersistence().findByPrimaryKey(parentId);
	}

	/**
	 * Returns the parent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent, or <code>null</code> if a parent with the primary key could not be found
	 */
	public static Parent fetchByPrimaryKey(long parentId) {
		return getPersistence().fetchByPrimaryKey(parentId);
	}

	/**
	 * Returns all the parents.
	 *
	 * @return the parents
	 */
	public static List<Parent> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @return the range of parents
	 */
	public static List<Parent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parents
	 */
	public static List<Parent> findAll(
		int start, int end, OrderByComparator<Parent> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of parents
	 */
	public static List<Parent> findAll(
		int start, int end, OrderByComparator<Parent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the parents from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of parents.
	 *
	 * @return the number of parents
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of students associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @return long[] of the primaryKeys of students associated with the parent
	 */
	public static long[] getStudentPrimaryKeys(long pk) {
		return getPersistence().getStudentPrimaryKeys(pk);
	}

	/**
	 * Returns all the parent associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the parents associated with the student
	 */
	public static List<Parent> getStudentParents(long pk) {
		return getPersistence().getStudentParents(pk);
	}

	/**
	 * Returns all the parent associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of parents associated with the student
	 */
	public static List<Parent> getStudentParents(long pk, int start, int end) {
		return getPersistence().getStudentParents(pk, start, end);
	}

	/**
	 * Returns all the parent associated with the student.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ParentModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the student
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parents associated with the student
	 */
	public static List<Parent> getStudentParents(
		long pk, int start, int end,
		OrderByComparator<Parent> orderByComparator) {

		return getPersistence().getStudentParents(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of students associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @return the number of students associated with the parent
	 */
	public static int getStudentsSize(long pk) {
		return getPersistence().getStudentsSize(pk);
	}

	/**
	 * Returns <code>true</code> if the student is associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPK the primary key of the student
	 * @return <code>true</code> if the student is associated with the parent; <code>false</code> otherwise
	 */
	public static boolean containsStudent(long pk, long studentPK) {
		return getPersistence().containsStudent(pk, studentPK);
	}

	/**
	 * Returns <code>true</code> if the parent has any students associated with it.
	 *
	 * @param pk the primary key of the parent to check for associations with students
	 * @return <code>true</code> if the parent has any students associated with it; <code>false</code> otherwise
	 */
	public static boolean containsStudents(long pk) {
		return getPersistence().containsStudents(pk);
	}

	/**
	 * Adds an association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPK the primary key of the student
	 */
	public static void addStudent(long pk, long studentPK) {
		getPersistence().addStudent(pk, studentPK);
	}

	/**
	 * Adds an association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param student the student
	 */
	public static void addStudent(
		long pk, com.student.info.service.model.Student student) {

		getPersistence().addStudent(pk, student);
	}

	/**
	 * Adds an association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPKs the primary keys of the students
	 */
	public static void addStudents(long pk, long[] studentPKs) {
		getPersistence().addStudents(pk, studentPKs);
	}

	/**
	 * Adds an association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param students the students
	 */
	public static void addStudents(
		long pk, List<com.student.info.service.model.Student> students) {

		getPersistence().addStudents(pk, students);
	}

	/**
	 * Clears all associations between the parent and its students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent to clear the associated students from
	 */
	public static void clearStudents(long pk) {
		getPersistence().clearStudents(pk);
	}

	/**
	 * Removes the association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPK the primary key of the student
	 */
	public static void removeStudent(long pk, long studentPK) {
		getPersistence().removeStudent(pk, studentPK);
	}

	/**
	 * Removes the association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param student the student
	 */
	public static void removeStudent(
		long pk, com.student.info.service.model.Student student) {

		getPersistence().removeStudent(pk, student);
	}

	/**
	 * Removes the association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPKs the primary keys of the students
	 */
	public static void removeStudents(long pk, long[] studentPKs) {
		getPersistence().removeStudents(pk, studentPKs);
	}

	/**
	 * Removes the association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param students the students
	 */
	public static void removeStudents(
		long pk, List<com.student.info.service.model.Student> students) {

		getPersistence().removeStudents(pk, students);
	}

	/**
	 * Sets the students associated with the parent, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPKs the primary keys of the students to be associated with the parent
	 */
	public static void setStudents(long pk, long[] studentPKs) {
		getPersistence().setStudents(pk, studentPKs);
	}

	/**
	 * Sets the students associated with the parent, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param students the students to be associated with the parent
	 */
	public static void setStudents(
		long pk, List<com.student.info.service.model.Student> students) {

		getPersistence().setStudents(pk, students);
	}

	public static ParentPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ParentPersistence _persistence;

}