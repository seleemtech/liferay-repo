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

import Example.exception.NoSuchFirstTableException;

import Example.model.FirstTable;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the first table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FirstTableUtil
 * @generated
 */
@ProviderType
public interface FirstTablePersistence extends BasePersistence<FirstTable> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FirstTableUtil} to access the first table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the first table in the entity cache if it is enabled.
	 *
	 * @param firstTable the first table
	 */
	public void cacheResult(FirstTable firstTable);

	/**
	 * Caches the first tables in the entity cache if it is enabled.
	 *
	 * @param firstTables the first tables
	 */
	public void cacheResult(java.util.List<FirstTable> firstTables);

	/**
	 * Creates a new first table with the primary key. Does not add the first table to the database.
	 *
	 * @param soId the primary key for the new first table
	 * @return the new first table
	 */
	public FirstTable create(long soId);

	/**
	 * Removes the first table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table that was removed
	 * @throws NoSuchFirstTableException if a first table with the primary key could not be found
	 */
	public FirstTable remove(long soId) throws NoSuchFirstTableException;

	public FirstTable updateImpl(FirstTable firstTable);

	/**
	 * Returns the first table with the primary key or throws a <code>NoSuchFirstTableException</code> if it could not be found.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table
	 * @throws NoSuchFirstTableException if a first table with the primary key could not be found
	 */
	public FirstTable findByPrimaryKey(long soId)
		throws NoSuchFirstTableException;

	/**
	 * Returns the first table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table, or <code>null</code> if a first table with the primary key could not be found
	 */
	public FirstTable fetchByPrimaryKey(long soId);

	/**
	 * Returns all the first tables.
	 *
	 * @return the first tables
	 */
	public java.util.List<FirstTable> findAll();

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
	public java.util.List<FirstTable> findAll(int start, int end);

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
	public java.util.List<FirstTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FirstTable>
			orderByComparator);

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
	public java.util.List<FirstTable> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FirstTable>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the first tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of first tables.
	 *
	 * @return the number of first tables
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of second tables associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @return long[] of the primaryKeys of second tables associated with the first table
	 */
	public long[] getSecondTablePrimaryKeys(long pk);

	/**
	 * Returns all the first table associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @return the first tables associated with the second table
	 */
	public java.util.List<FirstTable> getSecondTableFirstTables(long pk);

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
	public java.util.List<FirstTable> getSecondTableFirstTables(
		long pk, int start, int end);

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
	public java.util.List<FirstTable> getSecondTableFirstTables(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FirstTable>
			orderByComparator);

	/**
	 * Returns the number of second tables associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @return the number of second tables associated with the first table
	 */
	public int getSecondTablesSize(long pk);

	/**
	 * Returns <code>true</code> if the second table is associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePK the primary key of the second table
	 * @return <code>true</code> if the second table is associated with the first table; <code>false</code> otherwise
	 */
	public boolean containsSecondTable(long pk, long secondTablePK);

	/**
	 * Returns <code>true</code> if the first table has any second tables associated with it.
	 *
	 * @param pk the primary key of the first table to check for associations with second tables
	 * @return <code>true</code> if the first table has any second tables associated with it; <code>false</code> otherwise
	 */
	public boolean containsSecondTables(long pk);

	/**
	 * Adds an association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePK the primary key of the second table
	 */
	public void addSecondTable(long pk, long secondTablePK);

	/**
	 * Adds an association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTable the second table
	 */
	public void addSecondTable(long pk, Example.model.SecondTable secondTable);

	/**
	 * Adds an association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePKs the primary keys of the second tables
	 */
	public void addSecondTables(long pk, long[] secondTablePKs);

	/**
	 * Adds an association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTables the second tables
	 */
	public void addSecondTables(
		long pk, java.util.List<Example.model.SecondTable> secondTables);

	/**
	 * Clears all associations between the first table and its second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table to clear the associated second tables from
	 */
	public void clearSecondTables(long pk);

	/**
	 * Removes the association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePK the primary key of the second table
	 */
	public void removeSecondTable(long pk, long secondTablePK);

	/**
	 * Removes the association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTable the second table
	 */
	public void removeSecondTable(
		long pk, Example.model.SecondTable secondTable);

	/**
	 * Removes the association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePKs the primary keys of the second tables
	 */
	public void removeSecondTables(long pk, long[] secondTablePKs);

	/**
	 * Removes the association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTables the second tables
	 */
	public void removeSecondTables(
		long pk, java.util.List<Example.model.SecondTable> secondTables);

	/**
	 * Sets the second tables associated with the first table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePKs the primary keys of the second tables to be associated with the first table
	 */
	public void setSecondTables(long pk, long[] secondTablePKs);

	/**
	 * Sets the second tables associated with the first table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTables the second tables to be associated with the first table
	 */
	public void setSecondTables(
		long pk, java.util.List<Example.model.SecondTable> secondTables);

}