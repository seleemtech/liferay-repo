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

package com.intranet.service.persistence.impl;

import com.intranet.exception.NoSuchGraduationException;
import com.intranet.model.Graduation;
import com.intranet.model.GraduationTable;
import com.intranet.model.impl.GraduationImpl;
import com.intranet.model.impl.GraduationModelImpl;
import com.intranet.service.persistence.GraduationPersistence;
import com.intranet.service.persistence.GraduationUtil;
import com.intranet.service.persistence.impl.constants.INTRANETPersistenceConstants;

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
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the graduation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {GraduationPersistence.class, BasePersistence.class})
public class GraduationPersistenceImpl
	extends BasePersistenceImpl<Graduation> implements GraduationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GraduationUtil</code> to access the graduation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GraduationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public GraduationPersistenceImpl() {
		setModelClass(Graduation.class);

		setModelImplClass(GraduationImpl.class);
		setModelPKClass(String.class);

		setTable(GraduationTable.INSTANCE);
	}

	/**
	 * Caches the graduation in the entity cache if it is enabled.
	 *
	 * @param graduation the graduation
	 */
	@Override
	public void cacheResult(Graduation graduation) {
		entityCache.putResult(
			GraduationImpl.class, graduation.getPrimaryKey(), graduation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the graduations in the entity cache if it is enabled.
	 *
	 * @param graduations the graduations
	 */
	@Override
	public void cacheResult(List<Graduation> graduations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (graduations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Graduation graduation : graduations) {
			if (entityCache.getResult(
					GraduationImpl.class, graduation.getPrimaryKey()) == null) {

				cacheResult(graduation);
			}
		}
	}

	/**
	 * Clears the cache for all graduations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GraduationImpl.class);

		finderCache.clearCache(GraduationImpl.class);
	}

	/**
	 * Clears the cache for the graduation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Graduation graduation) {
		entityCache.removeResult(GraduationImpl.class, graduation);
	}

	@Override
	public void clearCache(List<Graduation> graduations) {
		for (Graduation graduation : graduations) {
			entityCache.removeResult(GraduationImpl.class, graduation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(GraduationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(GraduationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new graduation with the primary key. Does not add the graduation to the database.
	 *
	 * @param graduationCode the primary key for the new graduation
	 * @return the new graduation
	 */
	@Override
	public Graduation create(String graduationCode) {
		Graduation graduation = new GraduationImpl();

		graduation.setNew(true);
		graduation.setPrimaryKey(graduationCode);

		return graduation;
	}

	/**
	 * Removes the graduation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation that was removed
	 * @throws NoSuchGraduationException if a graduation with the primary key could not be found
	 */
	@Override
	public Graduation remove(String graduationCode)
		throws NoSuchGraduationException {

		return remove((Serializable)graduationCode);
	}

	/**
	 * Removes the graduation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the graduation
	 * @return the graduation that was removed
	 * @throws NoSuchGraduationException if a graduation with the primary key could not be found
	 */
	@Override
	public Graduation remove(Serializable primaryKey)
		throws NoSuchGraduationException {

		Session session = null;

		try {
			session = openSession();

			Graduation graduation = (Graduation)session.get(
				GraduationImpl.class, primaryKey);

			if (graduation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGraduationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(graduation);
		}
		catch (NoSuchGraduationException noSuchEntityException) {
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
	protected Graduation removeImpl(Graduation graduation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(graduation)) {
				graduation = (Graduation)session.get(
					GraduationImpl.class, graduation.getPrimaryKeyObj());
			}

			if (graduation != null) {
				session.delete(graduation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (graduation != null) {
			clearCache(graduation);
		}

		return graduation;
	}

	@Override
	public Graduation updateImpl(Graduation graduation) {
		boolean isNew = graduation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(graduation);
			}
			else {
				graduation = (Graduation)session.merge(graduation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(GraduationImpl.class, graduation, false, true);

		if (isNew) {
			graduation.setNew(false);
		}

		graduation.resetOriginalValues();

		return graduation;
	}

	/**
	 * Returns the graduation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the graduation
	 * @return the graduation
	 * @throws NoSuchGraduationException if a graduation with the primary key could not be found
	 */
	@Override
	public Graduation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGraduationException {

		Graduation graduation = fetchByPrimaryKey(primaryKey);

		if (graduation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGraduationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return graduation;
	}

	/**
	 * Returns the graduation with the primary key or throws a <code>NoSuchGraduationException</code> if it could not be found.
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation
	 * @throws NoSuchGraduationException if a graduation with the primary key could not be found
	 */
	@Override
	public Graduation findByPrimaryKey(String graduationCode)
		throws NoSuchGraduationException {

		return findByPrimaryKey((Serializable)graduationCode);
	}

	/**
	 * Returns the graduation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation, or <code>null</code> if a graduation with the primary key could not be found
	 */
	@Override
	public Graduation fetchByPrimaryKey(String graduationCode) {
		return fetchByPrimaryKey((Serializable)graduationCode);
	}

	/**
	 * Returns all the graduations.
	 *
	 * @return the graduations
	 */
	@Override
	public List<Graduation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the graduations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GraduationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of graduations
	 * @param end the upper bound of the range of graduations (not inclusive)
	 * @return the range of graduations
	 */
	@Override
	public List<Graduation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the graduations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GraduationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of graduations
	 * @param end the upper bound of the range of graduations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of graduations
	 */
	@Override
	public List<Graduation> findAll(
		int start, int end, OrderByComparator<Graduation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the graduations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GraduationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of graduations
	 * @param end the upper bound of the range of graduations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of graduations
	 */
	@Override
	public List<Graduation> findAll(
		int start, int end, OrderByComparator<Graduation> orderByComparator,
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

		List<Graduation> list = null;

		if (useFinderCache) {
			list = (List<Graduation>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GRADUATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GRADUATION;

				sql = sql.concat(GraduationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Graduation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Removes all the graduations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Graduation graduation : findAll()) {
			remove(graduation);
		}
	}

	/**
	 * Returns the number of graduations.
	 *
	 * @return the number of graduations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GRADUATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
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

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "graduationCode";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GRADUATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GraduationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the graduation persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_setGraduationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setGraduationUtilPersistence(null);

		entityCache.removeCache(GraduationImpl.class.getName());
	}

	private void _setGraduationUtilPersistence(
		GraduationPersistence graduationPersistence) {

		try {
			Field field = GraduationUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, graduationPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_GRADUATION =
		"SELECT graduation FROM Graduation graduation";

	private static final String _SQL_COUNT_GRADUATION =
		"SELECT COUNT(graduation) FROM Graduation graduation";

	private static final String _ORDER_BY_ENTITY_ALIAS = "graduation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Graduation exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		GraduationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private GraduationModelArgumentsResolver _graduationModelArgumentsResolver;

}