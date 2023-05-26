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

package com.intranet.service.persistence;

import com.intranet.model.EmployeeDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee details service. This utility wraps <code>com.intranet.service.persistence.impl.EmployeeDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsPersistence
 * @generated
 */
public class EmployeeDetailsUtil {

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
	public static void clearCache(EmployeeDetails employeeDetails) {
		getPersistence().clearCache(employeeDetails);
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
	public static Map<Serializable, EmployeeDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmployeeDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EmployeeDetails update(EmployeeDetails employeeDetails) {
		return getPersistence().update(employeeDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EmployeeDetails update(
		EmployeeDetails employeeDetails, ServiceContext serviceContext) {

		return getPersistence().update(employeeDetails, serviceContext);
	}

	/**
	 * Returns all the employee detailses where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @return the matching employee detailses
	 */
	public static List<EmployeeDetails> findByemployeeID(long employeeID) {
		return getPersistence().findByemployeeID(employeeID);
	}

	/**
	 * Returns a range of all the employee detailses where employeeID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeID the employee ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByemployeeID(
		long employeeID, int start, int end) {

		return getPersistence().findByemployeeID(employeeID, start, end);
	}

	/**
	 * Returns an ordered range of all the employee detailses where employeeID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeID the employee ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByemployeeID(
		long employeeID, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findByemployeeID(
			employeeID, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee detailses where employeeID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeeID the employee ID
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByemployeeID(
		long employeeID, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByemployeeID(
			employeeID, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByemployeeID_First(
			long employeeID,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.intranet.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByemployeeID_First(
			employeeID, orderByComparator);
	}

	/**
	 * Returns the first employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByemployeeID_First(
		long employeeID, OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByemployeeID_First(
			employeeID, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByemployeeID_Last(
			long employeeID,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.intranet.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByemployeeID_Last(
			employeeID, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByemployeeID_Last(
		long employeeID, OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByemployeeID_Last(
			employeeID, orderByComparator);
	}

	/**
	 * Removes all the employee detailses where employeeID = &#63; from the database.
	 *
	 * @param employeeID the employee ID
	 */
	public static void removeByemployeeID(long employeeID) {
		getPersistence().removeByemployeeID(employeeID);
	}

	/**
	 * Returns the number of employee detailses where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @return the number of matching employee detailses
	 */
	public static int countByemployeeID(long employeeID) {
		return getPersistence().countByemployeeID(employeeID);
	}

	/**
	 * Returns all the employee detailses where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @return the matching employee detailses
	 */
	public static List<EmployeeDetails> findByemployeename(
		String employeename) {

		return getPersistence().findByemployeename(employeename);
	}

	/**
	 * Returns a range of all the employee detailses where employeename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeename the employeename
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByemployeename(
		String employeename, int start, int end) {

		return getPersistence().findByemployeename(employeename, start, end);
	}

	/**
	 * Returns an ordered range of all the employee detailses where employeename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeename the employeename
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByemployeename(
		String employeename, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findByemployeename(
			employeename, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee detailses where employeename = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param employeename the employeename
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employee detailses
	 */
	public static List<EmployeeDetails> findByemployeename(
		String employeename, int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByemployeename(
			employeename, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByemployeename_First(
			String employeename,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.intranet.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByemployeename_First(
			employeename, orderByComparator);
	}

	/**
	 * Returns the first employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByemployeename_First(
		String employeename,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByemployeename_First(
			employeename, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public static EmployeeDetails findByemployeename_Last(
			String employeename,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.intranet.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByemployeename_Last(
			employeename, orderByComparator);
	}

	/**
	 * Returns the last employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public static EmployeeDetails fetchByemployeename_Last(
		String employeename,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().fetchByemployeename_Last(
			employeename, orderByComparator);
	}

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeeID the primary key of the current employee details
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails[] findByemployeename_PrevAndNext(
			long employeeID, String employeename,
			OrderByComparator<EmployeeDetails> orderByComparator)
		throws com.intranet.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByemployeename_PrevAndNext(
			employeeID, employeename, orderByComparator);
	}

	/**
	 * Removes all the employee detailses where employeename = &#63; from the database.
	 *
	 * @param employeename the employeename
	 */
	public static void removeByemployeename(String employeename) {
		getPersistence().removeByemployeename(employeename);
	}

	/**
	 * Returns the number of employee detailses where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @return the number of matching employee detailses
	 */
	public static int countByemployeename(String employeename) {
		return getPersistence().countByemployeename(employeename);
	}

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	public static void cacheResult(EmployeeDetails employeeDetails) {
		getPersistence().cacheResult(employeeDetails);
	}

	/**
	 * Caches the employee detailses in the entity cache if it is enabled.
	 *
	 * @param employeeDetailses the employee detailses
	 */
	public static void cacheResult(List<EmployeeDetails> employeeDetailses) {
		getPersistence().cacheResult(employeeDetailses);
	}

	/**
	 * Creates a new employee details with the primary key. Does not add the employee details to the database.
	 *
	 * @param employeeID the primary key for the new employee details
	 * @return the new employee details
	 */
	public static EmployeeDetails create(long employeeID) {
		return getPersistence().create(employeeID);
	}

	/**
	 * Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails remove(long employeeID)
		throws com.intranet.exception.NoSuchEmployeeDetailsException {

		return getPersistence().remove(employeeID);
	}

	public static EmployeeDetails updateImpl(EmployeeDetails employeeDetails) {
		return getPersistence().updateImpl(employeeDetails);
	}

	/**
	 * Returns the employee details with the primary key or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails findByPrimaryKey(long employeeID)
		throws com.intranet.exception.NoSuchEmployeeDetailsException {

		return getPersistence().findByPrimaryKey(employeeID);
	}

	/**
	 * Returns the employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details, or <code>null</code> if a employee details with the primary key could not be found
	 */
	public static EmployeeDetails fetchByPrimaryKey(long employeeID) {
		return getPersistence().fetchByPrimaryKey(employeeID);
	}

	/**
	 * Returns all the employee detailses.
	 *
	 * @return the employee detailses
	 */
	public static List<EmployeeDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of employee detailses
	 */
	public static List<EmployeeDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee detailses
	 */
	public static List<EmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employee detailses
	 */
	public static List<EmployeeDetails> findAll(
		int start, int end,
		OrderByComparator<EmployeeDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employee detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employee detailses.
	 *
	 * @return the number of employee detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeeDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EmployeeDetailsPersistence _persistence;

}