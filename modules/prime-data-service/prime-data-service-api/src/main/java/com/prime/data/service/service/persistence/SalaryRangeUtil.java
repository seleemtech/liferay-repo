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

import com.prime.data.service.model.SalaryRange;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the salary range service. This utility wraps <code>com.prime.data.service.service.persistence.impl.SalaryRangePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaryRangePersistence
 * @generated
 */
public class SalaryRangeUtil {

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
	public static void clearCache(SalaryRange salaryRange) {
		getPersistence().clearCache(salaryRange);
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
	public static Map<Serializable, SalaryRange> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SalaryRange> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SalaryRange> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SalaryRange> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SalaryRange> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SalaryRange update(SalaryRange salaryRange) {
		return getPersistence().update(salaryRange);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SalaryRange update(
		SalaryRange salaryRange, ServiceContext serviceContext) {

		return getPersistence().update(salaryRange, serviceContext);
	}

	/**
	 * Returns all the salary ranges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching salary ranges
	 */
	public static List<SalaryRange> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the salary ranges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @return the range of matching salary ranges
	 */
	public static List<SalaryRange> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the salary ranges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching salary ranges
	 */
	public static List<SalaryRange> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalaryRange> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the salary ranges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching salary ranges
	 */
	public static List<SalaryRange> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalaryRange> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching salary range
	 * @throws NoSuchSalaryRangeException if a matching salary range could not be found
	 */
	public static SalaryRange findByUuid_First(
			String uuid, OrderByComparator<SalaryRange> orderByComparator)
		throws com.prime.data.service.exception.NoSuchSalaryRangeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching salary range, or <code>null</code> if a matching salary range could not be found
	 */
	public static SalaryRange fetchByUuid_First(
		String uuid, OrderByComparator<SalaryRange> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching salary range
	 * @throws NoSuchSalaryRangeException if a matching salary range could not be found
	 */
	public static SalaryRange findByUuid_Last(
			String uuid, OrderByComparator<SalaryRange> orderByComparator)
		throws com.prime.data.service.exception.NoSuchSalaryRangeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching salary range, or <code>null</code> if a matching salary range could not be found
	 */
	public static SalaryRange fetchByUuid_Last(
		String uuid, OrderByComparator<SalaryRange> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the salary ranges before and after the current salary range in the ordered set where uuid = &#63;.
	 *
	 * @param salaryRangeId the primary key of the current salary range
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next salary range
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	public static SalaryRange[] findByUuid_PrevAndNext(
			long salaryRangeId, String uuid,
			OrderByComparator<SalaryRange> orderByComparator)
		throws com.prime.data.service.exception.NoSuchSalaryRangeException {

		return getPersistence().findByUuid_PrevAndNext(
			salaryRangeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the salary ranges where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of salary ranges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching salary ranges
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the salary range in the entity cache if it is enabled.
	 *
	 * @param salaryRange the salary range
	 */
	public static void cacheResult(SalaryRange salaryRange) {
		getPersistence().cacheResult(salaryRange);
	}

	/**
	 * Caches the salary ranges in the entity cache if it is enabled.
	 *
	 * @param salaryRanges the salary ranges
	 */
	public static void cacheResult(List<SalaryRange> salaryRanges) {
		getPersistence().cacheResult(salaryRanges);
	}

	/**
	 * Creates a new salary range with the primary key. Does not add the salary range to the database.
	 *
	 * @param salaryRangeId the primary key for the new salary range
	 * @return the new salary range
	 */
	public static SalaryRange create(long salaryRangeId) {
		return getPersistence().create(salaryRangeId);
	}

	/**
	 * Removes the salary range with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salaryRangeId the primary key of the salary range
	 * @return the salary range that was removed
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	public static SalaryRange remove(long salaryRangeId)
		throws com.prime.data.service.exception.NoSuchSalaryRangeException {

		return getPersistence().remove(salaryRangeId);
	}

	public static SalaryRange updateImpl(SalaryRange salaryRange) {
		return getPersistence().updateImpl(salaryRange);
	}

	/**
	 * Returns the salary range with the primary key or throws a <code>NoSuchSalaryRangeException</code> if it could not be found.
	 *
	 * @param salaryRangeId the primary key of the salary range
	 * @return the salary range
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	public static SalaryRange findByPrimaryKey(long salaryRangeId)
		throws com.prime.data.service.exception.NoSuchSalaryRangeException {

		return getPersistence().findByPrimaryKey(salaryRangeId);
	}

	/**
	 * Returns the salary range with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salaryRangeId the primary key of the salary range
	 * @return the salary range, or <code>null</code> if a salary range with the primary key could not be found
	 */
	public static SalaryRange fetchByPrimaryKey(long salaryRangeId) {
		return getPersistence().fetchByPrimaryKey(salaryRangeId);
	}

	/**
	 * Returns all the salary ranges.
	 *
	 * @return the salary ranges
	 */
	public static List<SalaryRange> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the salary ranges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @return the range of salary ranges
	 */
	public static List<SalaryRange> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the salary ranges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of salary ranges
	 */
	public static List<SalaryRange> findAll(
		int start, int end, OrderByComparator<SalaryRange> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the salary ranges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of salary ranges
	 */
	public static List<SalaryRange> findAll(
		int start, int end, OrderByComparator<SalaryRange> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the salary ranges from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of salary ranges.
	 *
	 * @return the number of salary ranges
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SalaryRangePersistence getPersistence() {
		return _persistence;
	}

	private static volatile SalaryRangePersistence _persistence;

}