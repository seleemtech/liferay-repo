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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.prime.data.service.exception.NoSuchMainTableException;
import com.prime.data.service.model.MainTable;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the main table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MainTableUtil
 * @generated
 */
@ProviderType
public interface MainTablePersistence extends BasePersistence<MainTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MainTableUtil} to access the main table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the main tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching main tables
	 */
	public java.util.List<MainTable> findByUuid(String uuid);

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
	public java.util.List<MainTable> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<MainTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MainTable>
			orderByComparator);

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
	public java.util.List<MainTable> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MainTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	public MainTable findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MainTable>
				orderByComparator)
		throws NoSuchMainTableException;

	/**
	 * Returns the first main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table, or <code>null</code> if a matching main table could not be found
	 */
	public MainTable fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MainTable>
			orderByComparator);

	/**
	 * Returns the last main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	public MainTable findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MainTable>
				orderByComparator)
		throws NoSuchMainTableException;

	/**
	 * Returns the last main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table, or <code>null</code> if a matching main table could not be found
	 */
	public MainTable fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MainTable>
			orderByComparator);

	/**
	 * Returns the main tables before and after the current main table in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current main table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next main table
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	public MainTable[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MainTable>
				orderByComparator)
		throws NoSuchMainTableException;

	/**
	 * Removes all the main tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of main tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching main tables
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the main tables where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching main tables
	 */
	public java.util.List<MainTable> findByCategory(String category);

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
	public java.util.List<MainTable> findByCategory(
		String category, int start, int end);

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
	public java.util.List<MainTable> findByCategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MainTable>
			orderByComparator);

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
	public java.util.List<MainTable> findByCategory(
		String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MainTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	public MainTable findByCategory_First(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<MainTable>
				orderByComparator)
		throws NoSuchMainTableException;

	/**
	 * Returns the first main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table, or <code>null</code> if a matching main table could not be found
	 */
	public MainTable fetchByCategory_First(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<MainTable>
			orderByComparator);

	/**
	 * Returns the last main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	public MainTable findByCategory_Last(
			String category,
			com.liferay.portal.kernel.util.OrderByComparator<MainTable>
				orderByComparator)
		throws NoSuchMainTableException;

	/**
	 * Returns the last main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table, or <code>null</code> if a matching main table could not be found
	 */
	public MainTable fetchByCategory_Last(
		String category,
		com.liferay.portal.kernel.util.OrderByComparator<MainTable>
			orderByComparator);

	/**
	 * Returns the main tables before and after the current main table in the ordered set where category = &#63;.
	 *
	 * @param categoryId the primary key of the current main table
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next main table
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	public MainTable[] findByCategory_PrevAndNext(
			long categoryId, String category,
			com.liferay.portal.kernel.util.OrderByComparator<MainTable>
				orderByComparator)
		throws NoSuchMainTableException;

	/**
	 * Removes all the main tables where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	public void removeByCategory(String category);

	/**
	 * Returns the number of main tables where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching main tables
	 */
	public int countByCategory(String category);

	/**
	 * Caches the main table in the entity cache if it is enabled.
	 *
	 * @param mainTable the main table
	 */
	public void cacheResult(MainTable mainTable);

	/**
	 * Caches the main tables in the entity cache if it is enabled.
	 *
	 * @param mainTables the main tables
	 */
	public void cacheResult(java.util.List<MainTable> mainTables);

	/**
	 * Creates a new main table with the primary key. Does not add the main table to the database.
	 *
	 * @param categoryId the primary key for the new main table
	 * @return the new main table
	 */
	public MainTable create(long categoryId);

	/**
	 * Removes the main table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table that was removed
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	public MainTable remove(long categoryId) throws NoSuchMainTableException;

	public MainTable updateImpl(MainTable mainTable);

	/**
	 * Returns the main table with the primary key or throws a <code>NoSuchMainTableException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	public MainTable findByPrimaryKey(long categoryId)
		throws NoSuchMainTableException;

	/**
	 * Returns the main table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table, or <code>null</code> if a main table with the primary key could not be found
	 */
	public MainTable fetchByPrimaryKey(long categoryId);

	/**
	 * Returns all the main tables.
	 *
	 * @return the main tables
	 */
	public java.util.List<MainTable> findAll();

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
	public java.util.List<MainTable> findAll(int start, int end);

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
	public java.util.List<MainTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MainTable>
			orderByComparator);

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
	public java.util.List<MainTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MainTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the main tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of main tables.
	 *
	 * @return the number of main tables
	 */
	public int countAll();

}