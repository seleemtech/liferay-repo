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

import Example.model.SecondTable;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the second table service. This utility wraps <code>Example.service.persistence.impl.SecondTablePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SecondTablePersistence
 * @generated
 */
public class SecondTableUtil {

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
	public static void clearCache(SecondTable secondTable) {
		getPersistence().clearCache(secondTable);
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
	public static Map<Serializable, SecondTable> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SecondTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SecondTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SecondTable> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SecondTable> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SecondTable update(SecondTable secondTable) {
		return getPersistence().update(secondTable);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SecondTable update(
		SecondTable secondTable, ServiceContext serviceContext) {

		return getPersistence().update(secondTable, serviceContext);
	}

	/**
	 * Caches the second table in the entity cache if it is enabled.
	 *
	 * @param secondTable the second table
	 */
	public static void cacheResult(SecondTable secondTable) {
		getPersistence().cacheResult(secondTable);
	}

	/**
	 * Caches the second tables in the entity cache if it is enabled.
	 *
	 * @param secondTables the second tables
	 */
	public static void cacheResult(List<SecondTable> secondTables) {
		getPersistence().cacheResult(secondTables);
	}

	/**
	 * Creates a new second table with the primary key. Does not add the second table to the database.
	 *
	 * @param coId the primary key for the new second table
	 * @return the new second table
	 */
	public static SecondTable create(long coId) {
		return getPersistence().create(coId);
	}

	/**
	 * Removes the second table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table that was removed
	 * @throws NoSuchSecondTableException if a second table with the primary key could not be found
	 */
	public static SecondTable remove(long coId)
		throws Example.exception.NoSuchSecondTableException {

		return getPersistence().remove(coId);
	}

	public static SecondTable updateImpl(SecondTable secondTable) {
		return getPersistence().updateImpl(secondTable);
	}

	/**
	 * Returns the second table with the primary key or throws a <code>NoSuchSecondTableException</code> if it could not be found.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table
	 * @throws NoSuchSecondTableException if a second table with the primary key could not be found
	 */
	public static SecondTable findByPrimaryKey(long coId)
		throws Example.exception.NoSuchSecondTableException {

		return getPersistence().findByPrimaryKey(coId);
	}

	/**
	 * Returns the second table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table, or <code>null</code> if a second table with the primary key could not be found
	 */
	public static SecondTable fetchByPrimaryKey(long coId) {
		return getPersistence().fetchByPrimaryKey(coId);
	}

	/**
	 * Returns all the second tables.
	 *
	 * @return the second tables
	 */
	public static List<SecondTable> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the second tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SecondTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of second tables
	 * @param end the upper bound of the range of second tables (not inclusive)
	 * @return the range of second tables
	 */
	public static List<SecondTable> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the second tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SecondTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of second tables
	 * @param end the upper bound of the range of second tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of second tables
	 */
	public static List<SecondTable> findAll(
		int start, int end, OrderByComparator<SecondTable> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the second tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SecondTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of second tables
	 * @param end the upper bound of the range of second tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of second tables
	 */
	public static List<SecondTable> findAll(
		int start, int end, OrderByComparator<SecondTable> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the second tables from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of second tables.
	 *
	 * @return the number of second tables
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of first tables associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @return long[] of the primaryKeys of first tables associated with the second table
	 */
	public static long[] getFirstTablePrimaryKeys(long pk) {
		return getPersistence().getFirstTablePrimaryKeys(pk);
	}

	/**
	 * Returns all the second table associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @return the second tables associated with the first table
	 */
	public static List<SecondTable> getFirstTableSecondTables(long pk) {
		return getPersistence().getFirstTableSecondTables(pk);
	}

	/**
	 * Returns all the second table associated with the first table.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SecondTableModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the first table
	 * @param start the lower bound of the range of first tables
	 * @param end the upper bound of the range of first tables (not inclusive)
	 * @return the range of second tables associated with the first table
	 */
	public static List<SecondTable> getFirstTableSecondTables(
		long pk, int start, int end) {

		return getPersistence().getFirstTableSecondTables(pk, start, end);
	}

	/**
	 * Returns all the second table associated with the first table.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SecondTableModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the first table
	 * @param start the lower bound of the range of first tables
	 * @param end the upper bound of the range of first tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of second tables associated with the first table
	 */
	public static List<SecondTable> getFirstTableSecondTables(
		long pk, int start, int end,
		OrderByComparator<SecondTable> orderByComparator) {

		return getPersistence().getFirstTableSecondTables(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of first tables associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @return the number of first tables associated with the second table
	 */
	public static int getFirstTablesSize(long pk) {
		return getPersistence().getFirstTablesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the first table is associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePK the primary key of the first table
	 * @return <code>true</code> if the first table is associated with the second table; <code>false</code> otherwise
	 */
	public static boolean containsFirstTable(long pk, long firstTablePK) {
		return getPersistence().containsFirstTable(pk, firstTablePK);
	}

	/**
	 * Returns <code>true</code> if the second table has any first tables associated with it.
	 *
	 * @param pk the primary key of the second table to check for associations with first tables
	 * @return <code>true</code> if the second table has any first tables associated with it; <code>false</code> otherwise
	 */
	public static boolean containsFirstTables(long pk) {
		return getPersistence().containsFirstTables(pk);
	}

	/**
	 * Adds an association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePK the primary key of the first table
	 */
	public static void addFirstTable(long pk, long firstTablePK) {
		getPersistence().addFirstTable(pk, firstTablePK);
	}

	/**
	 * Adds an association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTable the first table
	 */
	public static void addFirstTable(
		long pk, Example.model.FirstTable firstTable) {

		getPersistence().addFirstTable(pk, firstTable);
	}

	/**
	 * Adds an association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePKs the primary keys of the first tables
	 */
	public static void addFirstTables(long pk, long[] firstTablePKs) {
		getPersistence().addFirstTables(pk, firstTablePKs);
	}

	/**
	 * Adds an association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTables the first tables
	 */
	public static void addFirstTables(
		long pk, List<Example.model.FirstTable> firstTables) {

		getPersistence().addFirstTables(pk, firstTables);
	}

	/**
	 * Clears all associations between the second table and its first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table to clear the associated first tables from
	 */
	public static void clearFirstTables(long pk) {
		getPersistence().clearFirstTables(pk);
	}

	/**
	 * Removes the association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePK the primary key of the first table
	 */
	public static void removeFirstTable(long pk, long firstTablePK) {
		getPersistence().removeFirstTable(pk, firstTablePK);
	}

	/**
	 * Removes the association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTable the first table
	 */
	public static void removeFirstTable(
		long pk, Example.model.FirstTable firstTable) {

		getPersistence().removeFirstTable(pk, firstTable);
	}

	/**
	 * Removes the association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePKs the primary keys of the first tables
	 */
	public static void removeFirstTables(long pk, long[] firstTablePKs) {
		getPersistence().removeFirstTables(pk, firstTablePKs);
	}

	/**
	 * Removes the association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTables the first tables
	 */
	public static void removeFirstTables(
		long pk, List<Example.model.FirstTable> firstTables) {

		getPersistence().removeFirstTables(pk, firstTables);
	}

	/**
	 * Sets the first tables associated with the second table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePKs the primary keys of the first tables to be associated with the second table
	 */
	public static void setFirstTables(long pk, long[] firstTablePKs) {
		getPersistence().setFirstTables(pk, firstTablePKs);
	}

	/**
	 * Sets the first tables associated with the second table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTables the first tables to be associated with the second table
	 */
	public static void setFirstTables(
		long pk, List<Example.model.FirstTable> firstTables) {

		getPersistence().setFirstTables(pk, firstTables);
	}

	public static SecondTablePersistence getPersistence() {
		return _persistence;
	}

	private static volatile SecondTablePersistence _persistence;

}