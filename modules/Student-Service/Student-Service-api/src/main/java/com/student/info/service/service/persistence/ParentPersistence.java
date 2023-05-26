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

import com.student.info.service.exception.NoSuchParentException;
import com.student.info.service.model.Parent;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the parent service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ParentUtil
 * @generated
 */
@ProviderType
public interface ParentPersistence extends BasePersistence<Parent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParentUtil} to access the parent persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the parent in the entity cache if it is enabled.
	 *
	 * @param parent the parent
	 */
	public void cacheResult(Parent parent);

	/**
	 * Caches the parents in the entity cache if it is enabled.
	 *
	 * @param parents the parents
	 */
	public void cacheResult(java.util.List<Parent> parents);

	/**
	 * Creates a new parent with the primary key. Does not add the parent to the database.
	 *
	 * @param parentId the primary key for the new parent
	 * @return the new parent
	 */
	public Parent create(long parentId);

	/**
	 * Removes the parent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent that was removed
	 * @throws NoSuchParentException if a parent with the primary key could not be found
	 */
	public Parent remove(long parentId) throws NoSuchParentException;

	public Parent updateImpl(Parent parent);

	/**
	 * Returns the parent with the primary key or throws a <code>NoSuchParentException</code> if it could not be found.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent
	 * @throws NoSuchParentException if a parent with the primary key could not be found
	 */
	public Parent findByPrimaryKey(long parentId) throws NoSuchParentException;

	/**
	 * Returns the parent with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent, or <code>null</code> if a parent with the primary key could not be found
	 */
	public Parent fetchByPrimaryKey(long parentId);

	/**
	 * Returns all the parents.
	 *
	 * @return the parents
	 */
	public java.util.List<Parent> findAll();

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
	public java.util.List<Parent> findAll(int start, int end);

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
	public java.util.List<Parent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parent>
			orderByComparator);

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
	public java.util.List<Parent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the parents from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of parents.
	 *
	 * @return the number of parents
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of students associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @return long[] of the primaryKeys of students associated with the parent
	 */
	public long[] getStudentPrimaryKeys(long pk);

	/**
	 * Returns all the parent associated with the student.
	 *
	 * @param pk the primary key of the student
	 * @return the parents associated with the student
	 */
	public java.util.List<Parent> getStudentParents(long pk);

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
	public java.util.List<Parent> getStudentParents(
		long pk, int start, int end);

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
	public java.util.List<Parent> getStudentParents(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Parent>
			orderByComparator);

	/**
	 * Returns the number of students associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @return the number of students associated with the parent
	 */
	public int getStudentsSize(long pk);

	/**
	 * Returns <code>true</code> if the student is associated with the parent.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPK the primary key of the student
	 * @return <code>true</code> if the student is associated with the parent; <code>false</code> otherwise
	 */
	public boolean containsStudent(long pk, long studentPK);

	/**
	 * Returns <code>true</code> if the parent has any students associated with it.
	 *
	 * @param pk the primary key of the parent to check for associations with students
	 * @return <code>true</code> if the parent has any students associated with it; <code>false</code> otherwise
	 */
	public boolean containsStudents(long pk);

	/**
	 * Adds an association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPK the primary key of the student
	 */
	public void addStudent(long pk, long studentPK);

	/**
	 * Adds an association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param student the student
	 */
	public void addStudent(
		long pk, com.student.info.service.model.Student student);

	/**
	 * Adds an association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPKs the primary keys of the students
	 */
	public void addStudents(long pk, long[] studentPKs);

	/**
	 * Adds an association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param students the students
	 */
	public void addStudents(
		long pk,
		java.util.List<com.student.info.service.model.Student> students);

	/**
	 * Clears all associations between the parent and its students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent to clear the associated students from
	 */
	public void clearStudents(long pk);

	/**
	 * Removes the association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPK the primary key of the student
	 */
	public void removeStudent(long pk, long studentPK);

	/**
	 * Removes the association between the parent and the student. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param student the student
	 */
	public void removeStudent(
		long pk, com.student.info.service.model.Student student);

	/**
	 * Removes the association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPKs the primary keys of the students
	 */
	public void removeStudents(long pk, long[] studentPKs);

	/**
	 * Removes the association between the parent and the students. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param students the students
	 */
	public void removeStudents(
		long pk,
		java.util.List<com.student.info.service.model.Student> students);

	/**
	 * Sets the students associated with the parent, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param studentPKs the primary keys of the students to be associated with the parent
	 */
	public void setStudents(long pk, long[] studentPKs);

	/**
	 * Sets the students associated with the parent, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the parent
	 * @param students the students to be associated with the parent
	 */
	public void setStudents(
		long pk,
		java.util.List<com.student.info.service.model.Student> students);

}