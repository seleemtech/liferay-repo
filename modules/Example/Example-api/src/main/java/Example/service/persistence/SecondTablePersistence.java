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

import Example.exception.NoSuchSecondTableException;

import Example.model.SecondTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the second table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SecondTableUtil
 * @generated
 */
@ProviderType
public interface SecondTablePersistence extends BasePersistence<SecondTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SecondTableUtil} to access the second table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the second table in the entity cache if it is enabled.
	 *
	 * @param secondTable the second table
	 */
	public void cacheResult(SecondTable secondTable);

	/**
	 * Caches the second tables in the entity cache if it is enabled.
	 *
	 * @param secondTables the second tables
	 */
	public void cacheResult(java.util.List<SecondTable> secondTables);

	/**
	 * Creates a new second table with the primary key. Does not add the second table to the database.
	 *
	 * @param coId the primary key for the new second table
	 * @return the new second table
	 */
	public SecondTable create(long coId);

	/**
	 * Removes the second table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table that was removed
	 * @throws NoSuchSecondTableException if a second table with the primary key could not be found
	 */
	public SecondTable remove(long coId) throws NoSuchSecondTableException;

	public SecondTable updateImpl(SecondTable secondTable);

	/**
	 * Returns the second table with the primary key or throws a <code>NoSuchSecondTableException</code> if it could not be found.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table
	 * @throws NoSuchSecondTableException if a second table with the primary key could not be found
	 */
	public SecondTable findByPrimaryKey(long coId)
		throws NoSuchSecondTableException;

	/**
	 * Returns the second table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table, or <code>null</code> if a second table with the primary key could not be found
	 */
	public SecondTable fetchByPrimaryKey(long coId);

	/**
	 * Returns all the second tables.
	 *
	 * @return the second tables
	 */
	public java.util.List<SecondTable> findAll();

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
	public java.util.List<SecondTable> findAll(int start, int end);

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
	public java.util.List<SecondTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SecondTable>
			orderByComparator);

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
	public java.util.List<SecondTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SecondTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the second tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of second tables.
	 *
	 * @return the number of second tables
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of first tables associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @return long[] of the primaryKeys of first tables associated with the second table
	 */
	public long[] getFirstTablePrimaryKeys(long pk);

	/**
	 * Returns all the second table associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @return the second tables associated with the first table
	 */
	public java.util.List<SecondTable> getFirstTableSecondTables(long pk);

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
	public java.util.List<SecondTable> getFirstTableSecondTables(
		long pk, int start, int end);

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
	public java.util.List<SecondTable> getFirstTableSecondTables(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SecondTable>
			orderByComparator);

	/**
	 * Returns the number of first tables associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @return the number of first tables associated with the second table
	 */
	public int getFirstTablesSize(long pk);

	/**
	 * Returns <code>true</code> if the first table is associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePK the primary key of the first table
	 * @return <code>true</code> if the first table is associated with the second table; <code>false</code> otherwise
	 */
	public boolean containsFirstTable(long pk, long firstTablePK);

	/**
	 * Returns <code>true</code> if the second table has any first tables associated with it.
	 *
	 * @param pk the primary key of the second table to check for associations with first tables
	 * @return <code>true</code> if the second table has any first tables associated with it; <code>false</code> otherwise
	 */
	public boolean containsFirstTables(long pk);

	/**
	 * Adds an association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePK the primary key of the first table
	 */
	public void addFirstTable(long pk, long firstTablePK);

	/**
	 * Adds an association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTable the first table
	 */
	public void addFirstTable(long pk, Example.model.FirstTable firstTable);

	/**
	 * Adds an association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePKs the primary keys of the first tables
	 */
	public void addFirstTables(long pk, long[] firstTablePKs);

	/**
	 * Adds an association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTables the first tables
	 */
	public void addFirstTables(
		long pk, java.util.List<Example.model.FirstTable> firstTables);

	/**
	 * Clears all associations between the second table and its first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table to clear the associated first tables from
	 */
	public void clearFirstTables(long pk);

	/**
	 * Removes the association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePK the primary key of the first table
	 */
	public void removeFirstTable(long pk, long firstTablePK);

	/**
	 * Removes the association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTable the first table
	 */
	public void removeFirstTable(long pk, Example.model.FirstTable firstTable);

	/**
	 * Removes the association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePKs the primary keys of the first tables
	 */
	public void removeFirstTables(long pk, long[] firstTablePKs);

	/**
	 * Removes the association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTables the first tables
	 */
	public void removeFirstTables(
		long pk, java.util.List<Example.model.FirstTable> firstTables);

	/**
	 * Sets the first tables associated with the second table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePKs the primary keys of the first tables to be associated with the second table
	 */
	public void setFirstTables(long pk, long[] firstTablePKs);

	/**
	 * Sets the first tables associated with the second table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTables the first tables to be associated with the second table
	 */
	public void setFirstTables(
		long pk, java.util.List<Example.model.FirstTable> firstTables);

}