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

package Example.service.persistence.impl;

import Example.exception.NoSuchFirstTableException;

import Example.model.FirstTable;
import Example.model.FirstTableTable;
import Example.model.SecondTable;
import Example.model.impl.FirstTableImpl;
import Example.model.impl.FirstTableModelImpl;

import Example.service.persistence.FirstTablePersistence;
import Example.service.persistence.FirstTableUtil;
import Example.service.persistence.impl.constants.FOOPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the first table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FirstTablePersistence.class)
public class FirstTablePersistenceImpl
	extends BasePersistenceImpl<FirstTable> implements FirstTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FirstTableUtil</code> to access the first table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FirstTableImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public FirstTablePersistenceImpl() {
		setModelClass(FirstTable.class);

		setModelImplClass(FirstTableImpl.class);
		setModelPKClass(long.class);

		setTable(FirstTableTable.INSTANCE);
	}

	/**
	 * Caches the first table in the entity cache if it is enabled.
	 *
	 * @param firstTable the first table
	 */
	@Override
	public void cacheResult(FirstTable firstTable) {
		dummyEntityCache.putResult(
			FirstTableImpl.class, firstTable.getPrimaryKey(), firstTable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the first tables in the entity cache if it is enabled.
	 *
	 * @param firstTables the first tables
	 */
	@Override
	public void cacheResult(List<FirstTable> firstTables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (firstTables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FirstTable firstTable : firstTables) {
			if (dummyEntityCache.getResult(
					FirstTableImpl.class, firstTable.getPrimaryKey()) == null) {

				cacheResult(firstTable);
			}
		}
	}

	/**
	 * Clears the cache for all first tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(FirstTableImpl.class);

		dummyFinderCache.clearCache(FirstTableImpl.class);
	}

	/**
	 * Clears the cache for the first table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FirstTable firstTable) {
		dummyEntityCache.removeResult(FirstTableImpl.class, firstTable);
	}

	@Override
	public void clearCache(List<FirstTable> firstTables) {
		for (FirstTable firstTable : firstTables) {
			dummyEntityCache.removeResult(FirstTableImpl.class, firstTable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FirstTableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(FirstTableImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new first table with the primary key. Does not add the first table to the database.
	 *
	 * @param soId the primary key for the new first table
	 * @return the new first table
	 */
	@Override
	public FirstTable create(long soId) {
		FirstTable firstTable = new FirstTableImpl();

		firstTable.setNew(true);
		firstTable.setPrimaryKey(soId);

		firstTable.setCompanyId(CompanyThreadLocal.getCompanyId());

		return firstTable;
	}

	/**
	 * Removes the first table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table that was removed
	 * @throws NoSuchFirstTableException if a first table with the primary key could not be found
	 */
	@Override
	public FirstTable remove(long soId) throws NoSuchFirstTableException {
		return remove((Serializable)soId);
	}

	/**
	 * Removes the first table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the first table
	 * @return the first table that was removed
	 * @throws NoSuchFirstTableException if a first table with the primary key could not be found
	 */
	@Override
	public FirstTable remove(Serializable primaryKey)
		throws NoSuchFirstTableException {

		Session session = null;

		try {
			session = openSession();

			FirstTable firstTable = (FirstTable)session.get(
				FirstTableImpl.class, primaryKey);

			if (firstTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFirstTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(firstTable);
		}
		catch (NoSuchFirstTableException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected FirstTable removeImpl(FirstTable firstTable) {
		firstTableToSecondTableTableMapper.deleteLeftPrimaryKeyTableMappings(
			firstTable.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(firstTable)) {
				firstTable = (FirstTable)session.get(
					FirstTableImpl.class, firstTable.getPrimaryKeyObj());
			}

			if (firstTable != null) {
				session.delete(firstTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (firstTable != null) {
			clearCache(firstTable);
		}

		return firstTable;
	}

	@Override
	public FirstTable updateImpl(FirstTable firstTable) {
		boolean isNew = firstTable.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(firstTable);
			}
			else {
				firstTable = (FirstTable)session.merge(firstTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			FirstTableImpl.class, firstTable, false, true);

		if (isNew) {
			firstTable.setNew(false);
		}

		firstTable.resetOriginalValues();

		return firstTable;
	}

	/**
	 * Returns the first table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the first table
	 * @return the first table
	 * @throws NoSuchFirstTableException if a first table with the primary key could not be found
	 */
	@Override
	public FirstTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFirstTableException {

		FirstTable firstTable = fetchByPrimaryKey(primaryKey);

		if (firstTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFirstTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return firstTable;
	}

	/**
	 * Returns the first table with the primary key or throws a <code>NoSuchFirstTableException</code> if it could not be found.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table
	 * @throws NoSuchFirstTableException if a first table with the primary key could not be found
	 */
	@Override
	public FirstTable findByPrimaryKey(long soId)
		throws NoSuchFirstTableException {

		return findByPrimaryKey((Serializable)soId);
	}

	/**
	 * Returns the first table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table, or <code>null</code> if a first table with the primary key could not be found
	 */
	@Override
	public FirstTable fetchByPrimaryKey(long soId) {
		return fetchByPrimaryKey((Serializable)soId);
	}

	/**
	 * Returns all the first tables.
	 *
	 * @return the first tables
	 */
	@Override
	public List<FirstTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FirstTable> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<FirstTable> findAll(
		int start, int end, OrderByComparator<FirstTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<FirstTable> findAll(
		int start, int end, OrderByComparator<FirstTable> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<FirstTable> list = null;

		if (useFinderCache) {
			list = (List<FirstTable>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FIRSTTABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FIRSTTABLE;

				sql = sql.concat(FirstTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FirstTable>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the first tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FirstTable firstTable : findAll()) {
			remove(firstTable);
		}
	}

	/**
	 * Returns the number of first tables.
	 *
	 * @return the number of first tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FIRSTTABLE);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of second tables associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @return long[] of the primaryKeys of second tables associated with the first table
	 */
	@Override
	public long[] getSecondTablePrimaryKeys(long pk) {
		long[] pks = firstTableToSecondTableTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the first table associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @return the first tables associated with the second table
	 */
	@Override
	public List<FirstTable> getSecondTableFirstTables(long pk) {
		return getSecondTableFirstTables(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<FirstTable> getSecondTableFirstTables(
		long pk, int start, int end) {

		return getSecondTableFirstTables(pk, start, end, null);
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
	@Override
	public List<FirstTable> getSecondTableFirstTables(
		long pk, int start, int end,
		OrderByComparator<FirstTable> orderByComparator) {

		return firstTableToSecondTableTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of second tables associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @return the number of second tables associated with the first table
	 */
	@Override
	public int getSecondTablesSize(long pk) {
		long[] pks = firstTableToSecondTableTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the second table is associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePK the primary key of the second table
	 * @return <code>true</code> if the second table is associated with the first table; <code>false</code> otherwise
	 */
	@Override
	public boolean containsSecondTable(long pk, long secondTablePK) {
		return firstTableToSecondTableTableMapper.containsTableMapping(
			pk, secondTablePK);
	}

	/**
	 * Returns <code>true</code> if the first table has any second tables associated with it.
	 *
	 * @param pk the primary key of the first table to check for associations with second tables
	 * @return <code>true</code> if the first table has any second tables associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsSecondTables(long pk) {
		if (getSecondTablesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePK the primary key of the second table
	 */
	@Override
	public void addSecondTable(long pk, long secondTablePK) {
		FirstTable firstTable = fetchByPrimaryKey(pk);

		if (firstTable == null) {
			firstTableToSecondTableTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, secondTablePK);
		}
		else {
			firstTableToSecondTableTableMapper.addTableMapping(
				firstTable.getCompanyId(), pk, secondTablePK);
		}
	}

	/**
	 * Adds an association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTable the second table
	 */
	@Override
	public void addSecondTable(long pk, SecondTable secondTable) {
		FirstTable firstTable = fetchByPrimaryKey(pk);

		if (firstTable == null) {
			firstTableToSecondTableTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				secondTable.getPrimaryKey());
		}
		else {
			firstTableToSecondTableTableMapper.addTableMapping(
				firstTable.getCompanyId(), pk, secondTable.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePKs the primary keys of the second tables
	 */
	@Override
	public void addSecondTables(long pk, long[] secondTablePKs) {
		long companyId = 0;

		FirstTable firstTable = fetchByPrimaryKey(pk);

		if (firstTable == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = firstTable.getCompanyId();
		}

		firstTableToSecondTableTableMapper.addTableMappings(
			companyId, pk, secondTablePKs);
	}

	/**
	 * Adds an association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTables the second tables
	 */
	@Override
	public void addSecondTables(long pk, List<SecondTable> secondTables) {
		addSecondTables(
			pk, ListUtil.toLongArray(secondTables, SecondTable.CO_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the first table and its second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table to clear the associated second tables from
	 */
	@Override
	public void clearSecondTables(long pk) {
		firstTableToSecondTableTableMapper.deleteLeftPrimaryKeyTableMappings(
			pk);
	}

	/**
	 * Removes the association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePK the primary key of the second table
	 */
	@Override
	public void removeSecondTable(long pk, long secondTablePK) {
		firstTableToSecondTableTableMapper.deleteTableMapping(
			pk, secondTablePK);
	}

	/**
	 * Removes the association between the first table and the second table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTable the second table
	 */
	@Override
	public void removeSecondTable(long pk, SecondTable secondTable) {
		firstTableToSecondTableTableMapper.deleteTableMapping(
			pk, secondTable.getPrimaryKey());
	}

	/**
	 * Removes the association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePKs the primary keys of the second tables
	 */
	@Override
	public void removeSecondTables(long pk, long[] secondTablePKs) {
		firstTableToSecondTableTableMapper.deleteTableMappings(
			pk, secondTablePKs);
	}

	/**
	 * Removes the association between the first table and the second tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTables the second tables
	 */
	@Override
	public void removeSecondTables(long pk, List<SecondTable> secondTables) {
		removeSecondTables(
			pk, ListUtil.toLongArray(secondTables, SecondTable.CO_ID_ACCESSOR));
	}

	/**
	 * Sets the second tables associated with the first table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTablePKs the primary keys of the second tables to be associated with the first table
	 */
	@Override
	public void setSecondTables(long pk, long[] secondTablePKs) {
		Set<Long> newSecondTablePKsSet = SetUtil.fromArray(secondTablePKs);
		Set<Long> oldSecondTablePKsSet = SetUtil.fromArray(
			firstTableToSecondTableTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeSecondTablePKsSet = new HashSet<Long>(
			oldSecondTablePKsSet);

		removeSecondTablePKsSet.removeAll(newSecondTablePKsSet);

		firstTableToSecondTableTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeSecondTablePKsSet));

		newSecondTablePKsSet.removeAll(oldSecondTablePKsSet);

		long companyId = 0;

		FirstTable firstTable = fetchByPrimaryKey(pk);

		if (firstTable == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = firstTable.getCompanyId();
		}

		firstTableToSecondTableTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newSecondTablePKsSet));
	}

	/**
	 * Sets the second tables associated with the first table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the first table
	 * @param secondTables the second tables to be associated with the first table
	 */
	@Override
	public void setSecondTables(long pk, List<SecondTable> secondTables) {
		try {
			long[] secondTablePKs = new long[secondTables.size()];

			for (int i = 0; i < secondTables.size(); i++) {
				SecondTable secondTable = secondTables.get(i);

				secondTablePKs[i] = secondTable.getPrimaryKey();
			}

			setSecondTables(pk, secondTablePKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "soId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FIRSTTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FirstTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the first table persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		firstTableToSecondTableTableMapper = TableMapperFactory.getTableMapper(
			"FOO_FirstTables_SecondTables#soId", "FOO_FirstTables_SecondTables",
			"companyId", "soId", "coId", this, SecondTable.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setFirstTableUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFirstTableUtilPersistence(null);

		dummyEntityCache.removeCache(FirstTableImpl.class.getName());

		TableMapperFactory.removeTableMapper(
			"FOO_FirstTables_SecondTables#soId");
	}

	private void _setFirstTableUtilPersistence(
		FirstTablePersistence firstTablePersistence) {

		try {
			Field field = FirstTableUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, firstTablePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	protected TableMapper<FirstTable, SecondTable>
		firstTableToSecondTableTableMapper;

	private static final String _SQL_SELECT_FIRSTTABLE =
		"SELECT firstTable FROM FirstTable firstTable";

	private static final String _SQL_COUNT_FIRSTTABLE =
		"SELECT COUNT(firstTable) FROM FirstTable firstTable";

	private static final String _ORDER_BY_ENTITY_ALIAS = "firstTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FirstTable exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		FirstTablePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}