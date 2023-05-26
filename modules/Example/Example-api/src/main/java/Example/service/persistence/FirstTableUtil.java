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

package Example.service.persistence;

import Example.model.FirstTable;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the first table service. This utility wraps <code>Example.service.persistence.impl.FirstTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FirstTablePersistence
 * @generated
 */
public class FirstTableUtil {

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
	public static void clearCache(FirstTable firstTable) {
		getPersistence().clearCache(firstTable);
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
	public static Map<Serializable, FirstTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FirstTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FirstTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FirstTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FirstTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FirstTable update(FirstTable firstTable) {
		return getPersistence().update(firstTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FirstTable update(
		FirstTable firstTable, ServiceContext serviceContext) {

		return getPersistence().update(firstTable, serviceContext);
	}

	/**
	 * Caches the first table in the entity cache if it is enabled.
	 *
	 * @param firstTable the first table
	 */
	public static void cacheResult(FirstTable firstTable) {
		getPersistence().cacheResult(firstTable);
	}

	/**
	 * Caches the first tables in the entity cache if it is enabled.
	 *
	 * @param firstTables the first tables
	 */
	public static void cacheResult(List<FirstTable> firstTables) {
		getPersistence().cacheResult(firstTables);
	}

	/**
	 * Creates a new first table with the primary key. Does not add the first table to the database.
	 *
	 * @param soId the primary key for the new first table
	 * @return the new first table
	 */
	public static FirstTable create(long soId) {
		return getPersistence().create(soId);
	}

	/**
	 * Removes the first table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table that was removed
	 * @throws NoSuchFirstTableException if a first table with the primary key could not be found
	 */
	public static FirstTable remove(long soId)
		throws Example.exception.NoSuchFirstTableException {

		return getPersistence().remove(soId);
	}

	public static FirstTable updateImpl(FirstTable firstTable) {
		return getPersistence().updateImpl(firstTable);
	}

	/**
	 * Returns the first table with the primary key or throws a <code>NoSuchFirstTableException</code> if it could not be found.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table
	 * @throws NoSuchFirstTableException if a first table with the primary key could not be found
	 */
	public static FirstTable findByPrimaryKey(long soId)
		throws Example.exception.NoSuchFirstTableException {

		return getPersistence().findByPrimaryKey(soId);
	}

	/**
	 * Returns the first table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table, or <code>null</code> if a first table with the primary key could not be found
	 */
	public static FirstTable fetchByPrimaryKey(long soId) {
		return getPersistence().fetchByPrimaryKey(soId);
	}

	/**
	 * Returns all the first tables.
	 *
	 * @return the first tables
	 */
	public static List<FirstTable> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the first tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FirstTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of first tables
	 * @param end the upper bound of the range of first tables (not inclusive)
	 * @return the range of first tables
	 */
	public static List<FirstTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the first tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FirstTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of first tables
	 * @param end the upper bound of the range of first tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of first tables
	 */
	public static List<FirstTable> findAll(
		int start, int end, OrderByComparator<FirstTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the first tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FirstTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of first tables
	 * @param end the upper bound of the range of first tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of first tables
	 */
	public static List<FirstTable> findAll(
		int start, int end, OrderByComparator<FirstTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the first tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of first tables.
	 *
	 * @return the number of first tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of second tables associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @return long[] of the primaryKeys of second tables associated with the first table
	 */
	public static long[] getSecondTablePrimaryKeys(long pk) {
		return getPersistence().getSecondTablePrimaryKeys(pk);
	}

	/**
	 * Returns all the first table associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @return the first tables associated with the second table
	 */
	public static List<FirstTable> getSecondTableFirstTables(long pk) {
		return getPersistence().getSecondTableFirstTables(pk);
	}

	/**
	 * Returns all the first table associated with the second table.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FirstTableModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the second table
	 * @param start the lower bound of the range of second tables
	 * @param end the upper bound of the range of second tables (not inclusive)
	 * @return the range of first tables associated with the second table
	 */
	public static List<FirstTable> getSecondTableFirstTables(
		long pk, int start, int end) {

		return getPersistence().getSecondTableFirstTables(pk, start, end);
	}

	/**
	 * Returns all the first table associated with the second table.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FirstTableModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the second table
	 * @param start the lower bound of the range of second tables
	 * @param end the upper bound of the range of second tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of first tables associated with the second table
	 */
	public static List<FirstTable> getSecondTableFirstTables(
		long pk, int start, int end,
		OrderByComparator<FirstTable> orderByComparator) {

		return getPersistence().getSecondTableFirstTables(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of second tables associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @return the number of second tables associated with the first table
	 */
	public static int getSecondTablesSize(long pk) {
		return getPersistence().getSecondTablesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the second table is associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePK the primary key of the second table
	 * @return <code>true</code> if the second table is associated with the first table; <code>false</code> otherwise
	 */
	public static boolean containsSecondTable(long pk, long secondTablePK) {
		return getPersistence().containsSecondTable(pk, secondTablePK);
	}

	/**
	 * Returns <code>true</code> if the first table has any second tables associated with it.
	 *
	 * @param pk the primary key of the first table to check for associations with second tables
	 * @return <code>true</code> if the first table has any second tables associated with it; <code>false</code> otherwise
	 */
	public static boolean containsSecondTables(long pk) {
		return getPersistence().containsSecondTables(pk);
	}

	/**
	 * Adds an association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePK the primary key of the second table
	 */
	public static void addSecondTable(long pk, long secondTablePK) {
		getPersistence().addSecondTable(pk, secondTablePK);
	}

	/**
	 * Adds an association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTable the second table
	 */
	public static void addSecondTable(
		long pk, Example.model.SecondTable secondTable) {

		getPersistence().addSecondTable(pk, secondTable);
	}

	/**
	 * Adds an association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePKs the primary keys of the second tables
	 */
	public static void addSecondTables(long pk, long[] secondTablePKs) {
		getPersistence().addSecondTables(pk, secondTablePKs);
	}

	/**
	 * Adds an association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTables the second tables
	 */
	public static void addSecondTables(
		long pk, List<Example.model.SecondTable> secondTables) {

		getPersistence().addSecondTables(pk, secondTables);
	}

	/**
	 * Clears all associations between the first table and its second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table to clear the associated second tables from
	 */
	public static void clearSecondTables(long pk) {
		getPersistence().clearSecondTables(pk);
	}

	/**
	 * Removes the association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePK the primary key of the second table
	 */
	public static void removeSecondTable(long pk, long secondTablePK) {
		getPersistence().removeSecondTable(pk, secondTablePK);
	}

	/**
	 * Removes the association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTable the second table
	 */
	public static void removeSecondTable(
		long pk, Example.model.SecondTable secondTable) {

		getPersistence().removeSecondTable(pk, secondTable);
	}

	/**
	 * Removes the association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePKs the primary keys of the second tables
	 */
	public static void removeSecondTables(long pk, long[] secondTablePKs) {
		getPersistence().removeSecondTables(pk, secondTablePKs);
	}

	/**
	 * Removes the association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTables the second tables
	 */
	public static void removeSecondTables(
		long pk, List<Example.model.SecondTable> secondTables) {

		getPersistence().removeSecondTables(pk, secondTables);
	}

	/**
	 * Sets the second tables associated with the first table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePKs the primary keys of the second tables to be associated with the first table
	 */
	public static void setSecondTables(long pk, long[] secondTablePKs) {
		getPersistence().setSecondTables(pk, secondTablePKs);
	}

	/**
	 * Sets the second tables associated with the first table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTables the second tables to be associated with the first table
	 */
	public static void setSecondTables(
		long pk, List<Example.model.SecondTable> secondTables) {

		getPersistence().setSecondTables(pk, secondTables);
	}

	public static FirstTablePersistence getPersistence() {
		return _persistence;
	}

	private static volatile FirstTablePersistence _persistence;

}