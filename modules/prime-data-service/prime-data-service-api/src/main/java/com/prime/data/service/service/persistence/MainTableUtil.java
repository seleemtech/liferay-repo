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

import com.prime.data.service.model.MainTable;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the main table service. This utility wraps <code>com.prime.data.service.service.persistence.impl.MainTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MainTablePersistence
 * @generated
 */
public class MainTableUtil {

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
	public static void clearCache(MainTable mainTable) {
		getPersistence().clearCache(mainTable);
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
	public static Map<Serializable, MainTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MainTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MainTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MainTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MainTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MainTable update(MainTable mainTable) {
		return getPersistence().update(mainTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MainTable update(
		MainTable mainTable, ServiceContext serviceContext) {

		return getPersistence().update(mainTable, serviceContext);
	}

	/**
	 * Returns all the main tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching main tables
	 */
	public static List<MainTable> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the main tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @return the range of matching main tables
	 */
	public static List<MainTable> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the main tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching main tables
	 */
	public static List<MainTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MainTable> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the main tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching main tables
	 */
	public static List<MainTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MainTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	public static MainTable findByUuid_First(
			String uuid, OrderByComparator<MainTable> orderByComparator)
		throws com.prime.data.service.exception.NoSuchMainTableException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table, or <code>null</code> if a matching main table could not be found
	 */
	public static MainTable fetchByUuid_First(
		String uuid, OrderByComparator<MainTable> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	public static MainTable findByUuid_Last(
			String uuid, OrderByComparator<MainTable> orderByComparator)
		throws com.prime.data.service.exception.NoSuchMainTableException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table, or <code>null</code> if a matching main table could not be found
	 */
	public static MainTable fetchByUuid_Last(
		String uuid, OrderByComparator<MainTable> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the main tables before and after the current main table in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current main table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next main table
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	public static MainTable[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			OrderByComparator<MainTable> orderByComparator)
		throws com.prime.data.service.exception.NoSuchMainTableException {

		return getPersistence().findByUuid_PrevAndNext(
			categoryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the main tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of main tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching main tables
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the main tables where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching main tables
	 */
	public static List<MainTable> findByCategory(String category) {
		return getPersistence().findByCategory(category);
	}

	/**
	 * Returns a range of all the main tables where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @return the range of matching main tables
	 */
	public static List<MainTable> findByCategory(
		String category, int start, int end) {

		return getPersistence().findByCategory(category, start, end);
	}

	/**
	 * Returns an ordered range of all the main tables where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching main tables
	 */
	public static List<MainTable> findByCategory(
		String category, int start, int end,
		OrderByComparator<MainTable> orderByComparator) {

		return getPersistence().findByCategory(
			category, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the main tables where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching main tables
	 */
	public static List<MainTable> findByCategory(
		String category, int start, int end,
		OrderByComparator<MainTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCategory(
			category, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	public static MainTable findByCategory_First(
			String category, OrderByComparator<MainTable> orderByComparator)
		throws com.prime.data.service.exception.NoSuchMainTableException {

		return getPersistence().findByCategory_First(
			category, orderByComparator);
	}

	/**
	 * Returns the first main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table, or <code>null</code> if a matching main table could not be found
	 */
	public static MainTable fetchByCategory_First(
		String category, OrderByComparator<MainTable> orderByComparator) {

		return getPersistence().fetchByCategory_First(
			category, orderByComparator);
	}

	/**
	 * Returns the last main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	public static MainTable findByCategory_Last(
			String category, OrderByComparator<MainTable> orderByComparator)
		throws com.prime.data.service.exception.NoSuchMainTableException {

		return getPersistence().findByCategory_Last(
			category, orderByComparator);
	}

	/**
	 * Returns the last main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table, or <code>null</code> if a matching main table could not be found
	 */
	public static MainTable fetchByCategory_Last(
		String category, OrderByComparator<MainTable> orderByComparator) {

		return getPersistence().fetchByCategory_Last(
			category, orderByComparator);
	}

	/**
	 * Returns the main tables before and after the current main table in the ordered set where category = &#63;.
	 *
	 * @param categoryId the primary key of the current main table
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next main table
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	public static MainTable[] findByCategory_PrevAndNext(
			long categoryId, String category,
			OrderByComparator<MainTable> orderByComparator)
		throws com.prime.data.service.exception.NoSuchMainTableException {

		return getPersistence().findByCategory_PrevAndNext(
			categoryId, category, orderByComparator);
	}

	/**
	 * Removes all the main tables where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public static void removeByCategory(String category) {
		getPersistence().removeByCategory(category);
	}

	/**
	 * Returns the number of main tables where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching main tables
	 */
	public static int countByCategory(String category) {
		return getPersistence().countByCategory(category);
	}

	/**
	 * Caches the main table in the entity cache if it is enabled.
	 *
	 * @param mainTable the main table
	 */
	public static void cacheResult(MainTable mainTable) {
		getPersistence().cacheResult(mainTable);
	}

	/**
	 * Caches the main tables in the entity cache if it is enabled.
	 *
	 * @param mainTables the main tables
	 */
	public static void cacheResult(List<MainTable> mainTables) {
		getPersistence().cacheResult(mainTables);
	}

	/**
	 * Creates a new main table with the primary key. Does not add the main table to the database.
	 *
	 * @param categoryId the primary key for the new main table
	 * @return the new main table
	 */
	public static MainTable create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	 * Removes the main table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table that was removed
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	public static MainTable remove(long categoryId)
		throws com.prime.data.service.exception.NoSuchMainTableException {

		return getPersistence().remove(categoryId);
	}

	public static MainTable updateImpl(MainTable mainTable) {
		return getPersistence().updateImpl(mainTable);
	}

	/**
	 * Returns the main table with the primary key or throws a <code>NoSuchMainTableException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	public static MainTable findByPrimaryKey(long categoryId)
		throws com.prime.data.service.exception.NoSuchMainTableException {

		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	 * Returns the main table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table, or <code>null</code> if a main table with the primary key could not be found
	 */
	public static MainTable fetchByPrimaryKey(long categoryId) {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	 * Returns all the main tables.
	 *
	 * @return the main tables
	 */
	public static List<MainTable> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the main tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @return the range of main tables
	 */
	public static List<MainTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the main tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of main tables
	 */
	public static List<MainTable> findAll(
		int start, int end, OrderByComparator<MainTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the main tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of main tables
	 */
	public static List<MainTable> findAll(
		int start, int end, OrderByComparator<MainTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the main tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of main tables.
	 *
	 * @return the number of main tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MainTablePersistence getPersistence() {
		return _persistence;
	}

	private static volatile MainTablePersistence _persistence;

}