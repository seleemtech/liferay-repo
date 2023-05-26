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

package com.prime.data.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.prime.data.service.model.Priority;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the priority service. This utility wraps <code>com.prime.data.service.service.persistence.impl.PriorityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PriorityPersistence
 * @generated
 */
public class PriorityUtil {

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
	public static void clearCache(Priority priority) {
		getPersistence().clearCache(priority);
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
	public static Map<Serializable, Priority> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Priority> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Priority> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Priority> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Priority> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Priority update(Priority priority) {
		return getPersistence().update(priority);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Priority update(
		Priority priority, ServiceContext serviceContext) {

		return getPersistence().update(priority, serviceContext);
	}

	/**
	 * Returns all the priorities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching priorities
	 */
	public static List<Priority> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the priorities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @return the range of matching priorities
	 */
	public static List<Priority> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the priorities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching priorities
	 */
	public static List<Priority> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Priority> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the priorities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching priorities
	 */
	public static List<Priority> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Priority> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching priority
	 * @throws NoSuchPriorityException if a matching priority could not be found
	 */
	public static Priority findByUuid_First(
			String uuid, OrderByComparator<Priority> orderByComparator)
		throws com.prime.data.service.exception.NoSuchPriorityException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching priority, or <code>null</code> if a matching priority could not be found
	 */
	public static Priority fetchByUuid_First(
		String uuid, OrderByComparator<Priority> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching priority
	 * @throws NoSuchPriorityException if a matching priority could not be found
	 */
	public static Priority findByUuid_Last(
			String uuid, OrderByComparator<Priority> orderByComparator)
		throws com.prime.data.service.exception.NoSuchPriorityException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching priority, or <code>null</code> if a matching priority could not be found
	 */
	public static Priority fetchByUuid_Last(
		String uuid, OrderByComparator<Priority> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the priorities before and after the current priority in the ordered set where uuid = &#63;.
	 *
	 * @param priorityId the primary key of the current priority
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next priority
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	public static Priority[] findByUuid_PrevAndNext(
			long priorityId, String uuid,
			OrderByComparator<Priority> orderByComparator)
		throws com.prime.data.service.exception.NoSuchPriorityException {

		return getPersistence().findByUuid_PrevAndNext(
			priorityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the priorities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of priorities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching priorities
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the priority in the entity cache if it is enabled.
	 *
	 * @param priority the priority
	 */
	public static void cacheResult(Priority priority) {
		getPersistence().cacheResult(priority);
	}

	/**
	 * Caches the priorities in the entity cache if it is enabled.
	 *
	 * @param priorities the priorities
	 */
	public static void cacheResult(List<Priority> priorities) {
		getPersistence().cacheResult(priorities);
	}

	/**
	 * Creates a new priority with the primary key. Does not add the priority to the database.
	 *
	 * @param priorityId the primary key for the new priority
	 * @return the new priority
	 */
	public static Priority create(long priorityId) {
		return getPersistence().create(priorityId);
	}

	/**
	 * Removes the priority with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param priorityId the primary key of the priority
	 * @return the priority that was removed
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	public static Priority remove(long priorityId)
		throws com.prime.data.service.exception.NoSuchPriorityException {

		return getPersistence().remove(priorityId);
	}

	public static Priority updateImpl(Priority priority) {
		return getPersistence().updateImpl(priority);
	}

	/**
	 * Returns the priority with the primary key or throws a <code>NoSuchPriorityException</code> if it could not be found.
	 *
	 * @param priorityId the primary key of the priority
	 * @return the priority
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	public static Priority findByPrimaryKey(long priorityId)
		throws com.prime.data.service.exception.NoSuchPriorityException {

		return getPersistence().findByPrimaryKey(priorityId);
	}

	/**
	 * Returns the priority with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param priorityId the primary key of the priority
	 * @return the priority, or <code>null</code> if a priority with the primary key could not be found
	 */
	public static Priority fetchByPrimaryKey(long priorityId) {
		return getPersistence().fetchByPrimaryKey(priorityId);
	}

	/**
	 * Returns all the priorities.
	 *
	 * @return the priorities
	 */
	public static List<Priority> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @return the range of priorities
	 */
	public static List<Priority> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of priorities
	 */
	public static List<Priority> findAll(
		int start, int end, OrderByComparator<Priority> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of priorities
	 */
	public static List<Priority> findAll(
		int start, int end, OrderByComparator<Priority> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the priorities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of priorities.
	 *
	 * @return the number of priorities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PriorityPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PriorityPersistence _persistence;

}