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

import com.intranet.exception.NoSuchEmployeeDetailsException;
import com.intranet.model.EmployeeDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the employee details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsUtil
 * @generated
 */
@ProviderType
public interface EmployeeDetailsPersistence
	extends BasePersistence<EmployeeDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeDetailsUtil} to access the employee details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the employee detailses where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @return the matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByemployeeID(long employeeID);

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
	public java.util.List<EmployeeDetails> findByemployeeID(
		long employeeID, int start, int end);

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
	public java.util.List<EmployeeDetails> findByemployeeID(
		long employeeID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

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
	public java.util.List<EmployeeDetails> findByemployeeID(
		long employeeID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByemployeeID_First(
			long employeeID,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the first employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByemployeeID_First(
		long employeeID,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByemployeeID_Last(
			long employeeID,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the last employee details in the ordered set where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByemployeeID_Last(
		long employeeID,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Removes all the employee detailses where employeeID = &#63; from the database.
	 *
	 * @param employeeID the employee ID
	 */
	public void removeByemployeeID(long employeeID);

	/**
	 * Returns the number of employee detailses where employeeID = &#63;.
	 *
	 * @param employeeID the employee ID
	 * @return the number of matching employee detailses
	 */
	public int countByemployeeID(long employeeID);

	/**
	 * Returns all the employee detailses where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @return the matching employee detailses
	 */
	public java.util.List<EmployeeDetails> findByemployeename(
		String employeename);

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
	public java.util.List<EmployeeDetails> findByemployeename(
		String employeename, int start, int end);

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
	public java.util.List<EmployeeDetails> findByemployeename(
		String employeename, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

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
	public java.util.List<EmployeeDetails> findByemployeename(
		String employeename, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByemployeename_First(
			String employeename,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the first employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByemployeename_First(
		String employeename,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the last employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details
	 * @throws NoSuchEmployeeDetailsException if a matching employee details could not be found
	 */
	public EmployeeDetails findByemployeename_Last(
			String employeename,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the last employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee details, or <code>null</code> if a matching employee details could not be found
	 */
	public EmployeeDetails fetchByemployeename_Last(
		String employeename,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

	/**
	 * Returns the employee detailses before and after the current employee details in the ordered set where employeename = &#63;.
	 *
	 * @param employeeID the primary key of the current employee details
	 * @param employeename the employeename
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public EmployeeDetails[] findByemployeename_PrevAndNext(
			long employeeID, String employeename,
			com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
				orderByComparator)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Removes all the employee detailses where employeename = &#63; from the database.
	 *
	 * @param employeename the employeename
	 */
	public void removeByemployeename(String employeename);

	/**
	 * Returns the number of employee detailses where employeename = &#63;.
	 *
	 * @param employeename the employeename
	 * @return the number of matching employee detailses
	 */
	public int countByemployeename(String employeename);

	/**
	 * Caches the employee details in the entity cache if it is enabled.
	 *
	 * @param employeeDetails the employee details
	 */
	public void cacheResult(EmployeeDetails employeeDetails);

	/**
	 * Caches the employee detailses in the entity cache if it is enabled.
	 *
	 * @param employeeDetailses the employee detailses
	 */
	public void cacheResult(java.util.List<EmployeeDetails> employeeDetailses);

	/**
	 * Creates a new employee details with the primary key. Does not add the employee details to the database.
	 *
	 * @param employeeID the primary key for the new employee details
	 * @return the new employee details
	 */
	public EmployeeDetails create(long employeeID);

	/**
	 * Removes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public EmployeeDetails remove(long employeeID)
		throws NoSuchEmployeeDetailsException;

	public EmployeeDetails updateImpl(EmployeeDetails employeeDetails);

	/**
	 * Returns the employee details with the primary key or throws a <code>NoSuchEmployeeDetailsException</code> if it could not be found.
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details
	 * @throws NoSuchEmployeeDetailsException if a employee details with the primary key could not be found
	 */
	public EmployeeDetails findByPrimaryKey(long employeeID)
		throws NoSuchEmployeeDetailsException;

	/**
	 * Returns the employee details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details, or <code>null</code> if a employee details with the primary key could not be found
	 */
	public EmployeeDetails fetchByPrimaryKey(long employeeID);

	/**
	 * Returns all the employee detailses.
	 *
	 * @return the employee detailses
	 */
	public java.util.List<EmployeeDetails> findAll();

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
	public java.util.List<EmployeeDetails> findAll(int start, int end);

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
	public java.util.List<EmployeeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator);

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
	public java.util.List<EmployeeDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EmployeeDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the employee detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of employee detailses.
	 *
	 * @return the number of employee detailses
	 */
	public int countAll();

}