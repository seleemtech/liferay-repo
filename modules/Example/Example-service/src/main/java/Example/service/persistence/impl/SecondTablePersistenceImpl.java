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

import Example.exception.NoSuchSecondTableException;

import Example.model.FirstTable;
import Example.model.SecondTable;
import Example.model.SecondTableTable;
import Example.model.impl.SecondTableImpl;
import Example.model.impl.SecondTableModelImpl;

import Example.service.persistence.SecondTablePersistence;
import Example.service.persistence.SecondTableUtil;
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
 * The persistence implementation for the second table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SecondTablePersistence.class)
public class SecondTablePersistenceImpl
	extends BasePersistenceImpl<SecondTable> implements SecondTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SecondTableUtil</code> to access the second table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SecondTableImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SecondTablePersistenceImpl() {
		setModelClass(SecondTable.class);

		setModelImplClass(SecondTableImpl.class);
		setModelPKClass(long.class);

		setTable(SecondTableTable.INSTANCE);
	}

	/**
	 * Caches the second table in the entity cache if it is enabled.
	 *
	 * @param secondTable the second table
	 */
	@Override
	public void cacheResult(SecondTable secondTable) {
		dummyEntityCache.putResult(
			SecondTableImpl.class, secondTable.getPrimaryKey(), secondTable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the second tables in the entity cache if it is enabled.
	 *
	 * @param secondTables the second tables
	 */
	@Override
	public void cacheResult(List<SecondTable> secondTables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (secondTables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SecondTable secondTable : secondTables) {
			if (dummyEntityCache.getResult(
					SecondTableImpl.class, secondTable.getPrimaryKey()) ==
						null) {

				cacheResult(secondTable);
			}
		}
	}

	/**
	 * Clears the cache for all second tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(SecondTableImpl.class);

		dummyFinderCache.clearCache(SecondTableImpl.class);
	}

	/**
	 * Clears the cache for the second table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SecondTable secondTable) {
		dummyEntityCache.removeResult(SecondTableImpl.class, secondTable);
	}

	@Override
	public void clearCache(List<SecondTable> secondTables) {
		for (SecondTable secondTable : secondTables) {
			dummyEntityCache.removeResult(SecondTableImpl.class, secondTable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(SecondTableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(SecondTableImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new second table with the primary key. Does not add the second table to the database.
	 *
	 * @param coId the primary key for the new second table
	 * @return the new second table
	 */
	@Override
	public SecondTable create(long coId) {
		SecondTable secondTable = new SecondTableImpl();

		secondTable.setNew(true);
		secondTable.setPrimaryKey(coId);

		secondTable.setCompanyId(CompanyThreadLocal.getCompanyId());

		return secondTable;
	}

	/**
	 * Removes the second table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table that was removed
	 * @throws NoSuchSecondTableException if a second table with the primary key could not be found
	 */
	@Override
	public SecondTable remove(long coId) throws NoSuchSecondTableException {
		return remove((Serializable)coId);
	}

	/**
	 * Removes the second table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the second table
	 * @return the second table that was removed
	 * @throws NoSuchSecondTableException if a second table with the primary key could not be found
	 */
	@Override
	public SecondTable remove(Serializable primaryKey)
		throws NoSuchSecondTableException {

		Session session = null;

		try {
			session = openSession();

			SecondTable secondTable = (SecondTable)session.get(
				SecondTableImpl.class, primaryKey);

			if (secondTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSecondTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(secondTable);
		}
		catch (NoSuchSecondTableException noSuchEntityException) {
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
	protected SecondTable removeImpl(SecondTable secondTable) {
		secondTableToFirstTableTableMapper.deleteLeftPrimaryKeyTableMappings(
			secondTable.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(secondTable)) {
				secondTable = (SecondTable)session.get(
					SecondTableImpl.class, secondTable.getPrimaryKeyObj());
			}

			if (secondTable != null) {
				session.delete(secondTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (secondTable != null) {
			clearCache(secondTable);
		}

		return secondTable;
	}

	@Override
	public SecondTable updateImpl(SecondTable secondTable) {
		boolean isNew = secondTable.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(secondTable);
			}
			else {
				secondTable = (SecondTable)session.merge(secondTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			SecondTableImpl.class, secondTable, false, true);

		if (isNew) {
			secondTable.setNew(false);
		}

		secondTable.resetOriginalValues();

		return secondTable;
	}

	/**
	 * Returns the second table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the second table
	 * @return the second table
	 * @throws NoSuchSecondTableException if a second table with the primary key could not be found
	 */
	@Override
	public SecondTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSecondTableException {

		SecondTable secondTable = fetchByPrimaryKey(primaryKey);

		if (secondTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSecondTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return secondTable;
	}

	/**
	 * Returns the second table with the primary key or throws a <code>NoSuchSecondTableException</code> if it could not be found.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table
	 * @throws NoSuchSecondTableException if a second table with the primary key could not be found
	 */
	@Override
	public SecondTable findByPrimaryKey(long coId)
		throws NoSuchSecondTableException {

		return findByPrimaryKey((Serializable)coId);
	}

	/**
	 * Returns the second table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table, or <code>null</code> if a second table with the primary key could not be found
	 */
	@Override
	public SecondTable fetchByPrimaryKey(long coId) {
		return fetchByPrimaryKey((Serializable)coId);
	}

	/**
	 * Returns all the second tables.
	 *
	 * @return the second tables
	 */
	@Override
	public List<SecondTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SecondTable> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<SecondTable> findAll(
		int start, int end, OrderByComparator<SecondTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<SecondTable> findAll(
		int start, int end, OrderByComparator<SecondTable> orderByComparator,
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

		List<SecondTable> list = null;

		if (useFinderCache) {
			list = (List<SecondTable>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SECONDTABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SECONDTABLE;

				sql = sql.concat(SecondTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SecondTable>)QueryUtil.list(
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
	 * Removes all the second tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SecondTable secondTable : findAll()) {
			remove(secondTable);
		}
	}

	/**
	 * Returns the number of second tables.
	 *
	 * @return the number of second tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SECONDTABLE);

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
	 * Returns the primaryKeys of first tables associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @return long[] of the primaryKeys of first tables associated with the second table
	 */
	@Override
	public long[] getFirstTablePrimaryKeys(long pk) {
		long[] pks = secondTableToFirstTableTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the second table associated with the first table.
	 *
	 * @param pk the primary key of the first table
	 * @return the second tables associated with the first table
	 */
	@Override
	public List<SecondTable> getFirstTableSecondTables(long pk) {
		return getFirstTableSecondTables(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<SecondTable> getFirstTableSecondTables(
		long pk, int start, int end) {

		return getFirstTableSecondTables(pk, start, end, null);
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
	@Override
	public List<SecondTable> getFirstTableSecondTables(
		long pk, int start, int end,
		OrderByComparator<SecondTable> orderByComparator) {

		return secondTableToFirstTableTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of first tables associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @return the number of first tables associated with the second table
	 */
	@Override
	public int getFirstTablesSize(long pk) {
		long[] pks = secondTableToFirstTableTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the first table is associated with the second table.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePK the primary key of the first table
	 * @return <code>true</code> if the first table is associated with the second table; <code>false</code> otherwise
	 */
	@Override
	public boolean containsFirstTable(long pk, long firstTablePK) {
		return secondTableToFirstTableTableMapper.containsTableMapping(
			pk, firstTablePK);
	}

	/**
	 * Returns <code>true</code> if the second table has any first tables associated with it.
	 *
	 * @param pk the primary key of the second table to check for associations with first tables
	 * @return <code>true</code> if the second table has any first tables associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsFirstTables(long pk) {
		if (getFirstTablesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePK the primary key of the first table
	 */
	@Override
	public void addFirstTable(long pk, long firstTablePK) {
		SecondTable secondTable = fetchByPrimaryKey(pk);

		if (secondTable == null) {
			secondTableToFirstTableTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, firstTablePK);
		}
		else {
			secondTableToFirstTableTableMapper.addTableMapping(
				secondTable.getCompanyId(), pk, firstTablePK);
		}
	}

	/**
	 * Adds an association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTable the first table
	 */
	@Override
	public void addFirstTable(long pk, FirstTable firstTable) {
		SecondTable secondTable = fetchByPrimaryKey(pk);

		if (secondTable == null) {
			secondTableToFirstTableTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				firstTable.getPrimaryKey());
		}
		else {
			secondTableToFirstTableTableMapper.addTableMapping(
				secondTable.getCompanyId(), pk, firstTable.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePKs the primary keys of the first tables
	 */
	@Override
	public void addFirstTables(long pk, long[] firstTablePKs) {
		long companyId = 0;

		SecondTable secondTable = fetchByPrimaryKey(pk);

		if (secondTable == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = secondTable.getCompanyId();
		}

		secondTableToFirstTableTableMapper.addTableMappings(
			companyId, pk, firstTablePKs);
	}

	/**
	 * Adds an association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTables the first tables
	 */
	@Override
	public void addFirstTables(long pk, List<FirstTable> firstTables) {
		addFirstTables(
			pk, ListUtil.toLongArray(firstTables, FirstTable.SO_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the second table and its first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table to clear the associated first tables from
	 */
	@Override
	public void clearFirstTables(long pk) {
		secondTableToFirstTableTableMapper.deleteLeftPrimaryKeyTableMappings(
			pk);
	}

	/**
	 * Removes the association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePK the primary key of the first table
	 */
	@Override
	public void removeFirstTable(long pk, long firstTablePK) {
		secondTableToFirstTableTableMapper.deleteTableMapping(pk, firstTablePK);
	}

	/**
	 * Removes the association between the second table and the first table. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTable the first table
	 */
	@Override
	public void removeFirstTable(long pk, FirstTable firstTable) {
		secondTableToFirstTableTableMapper.deleteTableMapping(
			pk, firstTable.getPrimaryKey());
	}

	/**
	 * Removes the association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePKs the primary keys of the first tables
	 */
	@Override
	public void removeFirstTables(long pk, long[] firstTablePKs) {
		secondTableToFirstTableTableMapper.deleteTableMappings(
			pk, firstTablePKs);
	}

	/**
	 * Removes the association between the second table and the first tables. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTables the first tables
	 */
	@Override
	public void removeFirstTables(long pk, List<FirstTable> firstTables) {
		removeFirstTables(
			pk, ListUtil.toLongArray(firstTables, FirstTable.SO_ID_ACCESSOR));
	}

	/**
	 * Sets the first tables associated with the second table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTablePKs the primary keys of the first tables to be associated with the second table
	 */
	@Override
	public void setFirstTables(long pk, long[] firstTablePKs) {
		Set<Long> newFirstTablePKsSet = SetUtil.fromArray(firstTablePKs);
		Set<Long> oldFirstTablePKsSet = SetUtil.fromArray(
			secondTableToFirstTableTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeFirstTablePKsSet = new HashSet<Long>(
			oldFirstTablePKsSet);

		removeFirstTablePKsSet.removeAll(newFirstTablePKsSet);

		secondTableToFirstTableTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeFirstTablePKsSet));

		newFirstTablePKsSet.removeAll(oldFirstTablePKsSet);

		long companyId = 0;

		SecondTable secondTable = fetchByPrimaryKey(pk);

		if (secondTable == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = secondTable.getCompanyId();
		}

		secondTableToFirstTableTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newFirstTablePKsSet));
	}

	/**
	 * Sets the first tables associated with the second table, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the second table
	 * @param firstTables the first tables to be associated with the second table
	 */
	@Override
	public void setFirstTables(long pk, List<FirstTable> firstTables) {
		try {
			long[] firstTablePKs = new long[firstTables.size()];

			for (int i = 0; i < firstTables.size(); i++) {
				FirstTable firstTable = firstTables.get(i);

				firstTablePKs[i] = firstTable.getPrimaryKey();
			}

			setFirstTables(pk, firstTablePKs);
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
		return "coId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SECONDTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SecondTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the second table persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		secondTableToFirstTableTableMapper = TableMapperFactory.getTableMapper(
			"FOO_FirstTables_SecondTables#coId", "FOO_FirstTables_SecondTables",
			"companyId", "coId", "soId", this, FirstTable.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setSecondTableUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSecondTableUtilPersistence(null);

		dummyEntityCache.removeCache(SecondTableImpl.class.getName());

		TableMapperFactory.removeTableMapper(
			"FOO_FirstTables_SecondTables#coId");
	}

	private void _setSecondTableUtilPersistence(
		SecondTablePersistence secondTablePersistence) {

		try {
			Field field = SecondTableUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, secondTablePersistence);
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

	protected TableMapper<SecondTable, FirstTable>
		secondTableToFirstTableTableMapper;

	private static final String _SQL_SELECT_SECONDTABLE =
		"SELECT secondTable FROM SecondTable secondTable";

	private static final String _SQL_COUNT_SECONDTABLE =
		"SELECT COUNT(secondTable) FROM SecondTable secondTable";

	private static final String _ORDER_BY_ENTITY_ALIAS = "secondTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SecondTable exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SecondTablePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}