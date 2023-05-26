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

import com.intranet.exception.NoSuchBillclaimException;
import com.intranet.model.Billclaim;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the billclaim service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BillclaimUtil
 * @generated
 */
@ProviderType
public interface BillclaimPersistence extends BasePersistence<Billclaim> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BillclaimUtil} to access the billclaim persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the billclaims where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching billclaims
	 */
	public java.util.List<Billclaim> findByuserName(String userName);

	/**
	 * Returns a range of all the billclaims where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @return the range of matching billclaims
	 */
	public java.util.List<Billclaim> findByuserName(
		String userName, int start, int end);

	/**
	 * Returns an ordered range of all the billclaims where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching billclaims
	 */
	public java.util.List<Billclaim> findByuserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billclaim>
			orderByComparator);

	/**
	 * Returns an ordered range of all the billclaims where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching billclaims
	 */
	public java.util.List<Billclaim> findByuserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billclaim>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billclaim
	 * @throws NoSuchBillclaimException if a matching billclaim could not be found
	 */
	public Billclaim findByuserName_First(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Billclaim>
				orderByComparator)
		throws NoSuchBillclaimException;

	/**
	 * Returns the first billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billclaim, or <code>null</code> if a matching billclaim could not be found
	 */
	public Billclaim fetchByuserName_First(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Billclaim>
			orderByComparator);

	/**
	 * Returns the last billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billclaim
	 * @throws NoSuchBillclaimException if a matching billclaim could not be found
	 */
	public Billclaim findByuserName_Last(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Billclaim>
				orderByComparator)
		throws NoSuchBillclaimException;

	/**
	 * Returns the last billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billclaim, or <code>null</code> if a matching billclaim could not be found
	 */
	public Billclaim fetchByuserName_Last(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Billclaim>
			orderByComparator);

	/**
	 * Returns the billclaims before and after the current billclaim in the ordered set where userName = &#63;.
	 *
	 * @param fooId the primary key of the current billclaim
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next billclaim
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	public Billclaim[] findByuserName_PrevAndNext(
			long fooId, String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Billclaim>
				orderByComparator)
		throws NoSuchBillclaimException;

	/**
	 * Removes all the billclaims where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public void removeByuserName(String userName);

	/**
	 * Returns the number of billclaims where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching billclaims
	 */
	public int countByuserName(String userName);

	/**
	 * Caches the billclaim in the entity cache if it is enabled.
	 *
	 * @param billclaim the billclaim
	 */
	public void cacheResult(Billclaim billclaim);

	/**
	 * Caches the billclaims in the entity cache if it is enabled.
	 *
	 * @param billclaims the billclaims
	 */
	public void cacheResult(java.util.List<Billclaim> billclaims);

	/**
	 * Creates a new billclaim with the primary key. Does not add the billclaim to the database.
	 *
	 * @param fooId the primary key for the new billclaim
	 * @return the new billclaim
	 */
	public Billclaim create(long fooId);

	/**
	 * Removes the billclaim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the billclaim
	 * @return the billclaim that was removed
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	public Billclaim remove(long fooId) throws NoSuchBillclaimException;

	public Billclaim updateImpl(Billclaim billclaim);

	/**
	 * Returns the billclaim with the primary key or throws a <code>NoSuchBillclaimException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the billclaim
	 * @return the billclaim
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	public Billclaim findByPrimaryKey(long fooId)
		throws NoSuchBillclaimException;

	/**
	 * Returns the billclaim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the billclaim
	 * @return the billclaim, or <code>null</code> if a billclaim with the primary key could not be found
	 */
	public Billclaim fetchByPrimaryKey(long fooId);

	/**
	 * Returns all the billclaims.
	 *
	 * @return the billclaims
	 */
	public java.util.List<Billclaim> findAll();

	/**
	 * Returns a range of all the billclaims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @return the range of billclaims
	 */
	public java.util.List<Billclaim> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the billclaims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of billclaims
	 */
	public java.util.List<Billclaim> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billclaim>
			orderByComparator);

	/**
	 * Returns an ordered range of all the billclaims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BillclaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of billclaims
	 * @param end the upper bound of the range of billclaims (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of billclaims
	 */
	public java.util.List<Billclaim> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Billclaim>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the billclaims from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of billclaims.
	 *
	 * @return the number of billclaims
	 */
	public int countAll();

}