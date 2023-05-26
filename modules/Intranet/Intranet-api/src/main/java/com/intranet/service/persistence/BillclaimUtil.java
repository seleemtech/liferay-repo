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

import com.intranet.model.Billclaim;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the billclaim service. This utility wraps <code>com.intranet.service.persistence.impl.BillclaimPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BillclaimPersistence
 * @generated
 */
public class BillclaimUtil {

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
	public static void clearCache(Billclaim billclaim) {
		getPersistence().clearCache(billclaim);
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
	public static Map<Serializable, Billclaim> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Billclaim> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Billclaim> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Billclaim> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Billclaim> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Billclaim update(Billclaim billclaim) {
		return getPersistence().update(billclaim);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Billclaim update(
		Billclaim billclaim, ServiceContext serviceContext) {

		return getPersistence().update(billclaim, serviceContext);
	}

	/**
	 * Returns all the billclaims where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching billclaims
	 */
	public static List<Billclaim> findByuserName(String userName) {
		return getPersistence().findByuserName(userName);
	}

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
	public static List<Billclaim> findByuserName(
		String userName, int start, int end) {

		return getPersistence().findByuserName(userName, start, end);
	}

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
	public static List<Billclaim> findByuserName(
		String userName, int start, int end,
		OrderByComparator<Billclaim> orderByComparator) {

		return getPersistence().findByuserName(
			userName, start, end, orderByComparator);
	}

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
	public static List<Billclaim> findByuserName(
		String userName, int start, int end,
		OrderByComparator<Billclaim> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserName(
			userName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billclaim
	 * @throws NoSuchBillclaimException if a matching billclaim could not be found
	 */
	public static Billclaim findByuserName_First(
			String userName, OrderByComparator<Billclaim> orderByComparator)
		throws com.intranet.exception.NoSuchBillclaimException {

		return getPersistence().findByuserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the first billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching billclaim, or <code>null</code> if a matching billclaim could not be found
	 */
	public static Billclaim fetchByuserName_First(
		String userName, OrderByComparator<Billclaim> orderByComparator) {

		return getPersistence().fetchByuserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the last billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billclaim
	 * @throws NoSuchBillclaimException if a matching billclaim could not be found
	 */
	public static Billclaim findByuserName_Last(
			String userName, OrderByComparator<Billclaim> orderByComparator)
		throws com.intranet.exception.NoSuchBillclaimException {

		return getPersistence().findByuserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Returns the last billclaim in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching billclaim, or <code>null</code> if a matching billclaim could not be found
	 */
	public static Billclaim fetchByuserName_Last(
		String userName, OrderByComparator<Billclaim> orderByComparator) {

		return getPersistence().fetchByuserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Returns the billclaims before and after the current billclaim in the ordered set where userName = &#63;.
	 *
	 * @param fooId the primary key of the current billclaim
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next billclaim
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	public static Billclaim[] findByuserName_PrevAndNext(
			long fooId, String userName,
			OrderByComparator<Billclaim> orderByComparator)
		throws com.intranet.exception.NoSuchBillclaimException {

		return getPersistence().findByuserName_PrevAndNext(
			fooId, userName, orderByComparator);
	}

	/**
	 * Removes all the billclaims where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public static void removeByuserName(String userName) {
		getPersistence().removeByuserName(userName);
	}

	/**
	 * Returns the number of billclaims where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching billclaims
	 */
	public static int countByuserName(String userName) {
		return getPersistence().countByuserName(userName);
	}

	/**
	 * Caches the billclaim in the entity cache if it is enabled.
	 *
	 * @param billclaim the billclaim
	 */
	public static void cacheResult(Billclaim billclaim) {
		getPersistence().cacheResult(billclaim);
	}

	/**
	 * Caches the billclaims in the entity cache if it is enabled.
	 *
	 * @param billclaims the billclaims
	 */
	public static void cacheResult(List<Billclaim> billclaims) {
		getPersistence().cacheResult(billclaims);
	}

	/**
	 * Creates a new billclaim with the primary key. Does not add the billclaim to the database.
	 *
	 * @param fooId the primary key for the new billclaim
	 * @return the new billclaim
	 */
	public static Billclaim create(long fooId) {
		return getPersistence().create(fooId);
	}

	/**
	 * Removes the billclaim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the billclaim
	 * @return the billclaim that was removed
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	public static Billclaim remove(long fooId)
		throws com.intranet.exception.NoSuchBillclaimException {

		return getPersistence().remove(fooId);
	}

	public static Billclaim updateImpl(Billclaim billclaim) {
		return getPersistence().updateImpl(billclaim);
	}

	/**
	 * Returns the billclaim with the primary key or throws a <code>NoSuchBillclaimException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the billclaim
	 * @return the billclaim
	 * @throws NoSuchBillclaimException if a billclaim with the primary key could not be found
	 */
	public static Billclaim findByPrimaryKey(long fooId)
		throws com.intranet.exception.NoSuchBillclaimException {

		return getPersistence().findByPrimaryKey(fooId);
	}

	/**
	 * Returns the billclaim with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the billclaim
	 * @return the billclaim, or <code>null</code> if a billclaim with the primary key could not be found
	 */
	public static Billclaim fetchByPrimaryKey(long fooId) {
		return getPersistence().fetchByPrimaryKey(fooId);
	}

	/**
	 * Returns all the billclaims.
	 *
	 * @return the billclaims
	 */
	public static List<Billclaim> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Billclaim> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Billclaim> findAll(
		int start, int end, OrderByComparator<Billclaim> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Billclaim> findAll(
		int start, int end, OrderByComparator<Billclaim> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the billclaims from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of billclaims.
	 *
	 * @return the number of billclaims
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BillclaimPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BillclaimPersistence _persistence;

}