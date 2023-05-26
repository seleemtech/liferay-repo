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

import com.intranet.exception.NoSuchComplaintBoxException;
import com.intranet.model.ComplaintBox;
import com.intranet.model.ComplaintBoxTable;
import com.intranet.model.impl.ComplaintBoxImpl;
import com.intranet.model.impl.ComplaintBoxModelImpl;
import com.intranet.service.persistence.ComplaintBoxPersistence;
import com.intranet.service.persistence.ComplaintBoxUtil;
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
 * The persistence implementation for the complaint box service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ComplaintBoxPersistence.class, BasePersistence.class})
public class ComplaintBoxPersistenceImpl
	extends BasePersistenceImpl<ComplaintBox>
	implements ComplaintBoxPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ComplaintBoxUtil</code> to access the complaint box persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ComplaintBoxImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ComplaintBoxPersistenceImpl() {
		setModelClass(ComplaintBox.class);

		setModelImplClass(ComplaintBoxImpl.class);
		setModelPKClass(long.class);

		setTable(ComplaintBoxTable.INSTANCE);
	}

	/**
	 * Caches the complaint box in the entity cache if it is enabled.
	 *
	 * @param complaintBox the complaint box
	 */
	@Override
	public void cacheResult(ComplaintBox complaintBox) {
		entityCache.putResult(
			ComplaintBoxImpl.class, complaintBox.getPrimaryKey(), complaintBox);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the complaint boxes in the entity cache if it is enabled.
	 *
	 * @param complaintBoxes the complaint boxes
	 */
	@Override
	public void cacheResult(List<ComplaintBox> complaintBoxes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (complaintBoxes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ComplaintBox complaintBox : complaintBoxes) {
			if (entityCache.getResult(
					ComplaintBoxImpl.class, complaintBox.getPrimaryKey()) ==
						null) {

				cacheResult(complaintBox);
			}
		}
	}

	/**
	 * Clears the cache for all complaint boxes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ComplaintBoxImpl.class);

		finderCache.clearCache(ComplaintBoxImpl.class);
	}

	/**
	 * Clears the cache for the complaint box.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ComplaintBox complaintBox) {
		entityCache.removeResult(ComplaintBoxImpl.class, complaintBox);
	}

	@Override
	public void clearCache(List<ComplaintBox> complaintBoxes) {
		for (ComplaintBox complaintBox : complaintBoxes) {
			entityCache.removeResult(ComplaintBoxImpl.class, complaintBox);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ComplaintBoxImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ComplaintBoxImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new complaint box with the primary key. Does not add the complaint box to the database.
	 *
	 * @param fooId the primary key for the new complaint box
	 * @return the new complaint box
	 */
	@Override
	public ComplaintBox create(long fooId) {
		ComplaintBox complaintBox = new ComplaintBoxImpl();

		complaintBox.setNew(true);
		complaintBox.setPrimaryKey(fooId);

		return complaintBox;
	}

	/**
	 * Removes the complaint box with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box that was removed
	 * @throws NoSuchComplaintBoxException if a complaint box with the primary key could not be found
	 */
	@Override
	public ComplaintBox remove(long fooId) throws NoSuchComplaintBoxException {
		return remove((Serializable)fooId);
	}

	/**
	 * Removes the complaint box with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the complaint box
	 * @return the complaint box that was removed
	 * @throws NoSuchComplaintBoxException if a complaint box with the primary key could not be found
	 */
	@Override
	public ComplaintBox remove(Serializable primaryKey)
		throws NoSuchComplaintBoxException {

		Session session = null;

		try {
			session = openSession();

			ComplaintBox complaintBox = (ComplaintBox)session.get(
				ComplaintBoxImpl.class, primaryKey);

			if (complaintBox == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComplaintBoxException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(complaintBox);
		}
		catch (NoSuchComplaintBoxException noSuchEntityException) {
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
	protected ComplaintBox removeImpl(ComplaintBox complaintBox) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(complaintBox)) {
				complaintBox = (ComplaintBox)session.get(
					ComplaintBoxImpl.class, complaintBox.getPrimaryKeyObj());
			}

			if (complaintBox != null) {
				session.delete(complaintBox);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (complaintBox != null) {
			clearCache(complaintBox);
		}

		return complaintBox;
	}

	@Override
	public ComplaintBox updateImpl(ComplaintBox complaintBox) {
		boolean isNew = complaintBox.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(complaintBox);
			}
			else {
				complaintBox = (ComplaintBox)session.merge(complaintBox);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ComplaintBoxImpl.class, complaintBox, false, true);

		if (isNew) {
			complaintBox.setNew(false);
		}

		complaintBox.resetOriginalValues();

		return complaintBox;
	}

	/**
	 * Returns the complaint box with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the complaint box
	 * @return the complaint box
	 * @throws NoSuchComplaintBoxException if a complaint box with the primary key could not be found
	 */
	@Override
	public ComplaintBox findByPrimaryKey(Serializable primaryKey)
		throws NoSuchComplaintBoxException {

		ComplaintBox complaintBox = fetchByPrimaryKey(primaryKey);

		if (complaintBox == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchComplaintBoxException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return complaintBox;
	}

	/**
	 * Returns the complaint box with the primary key or throws a <code>NoSuchComplaintBoxException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box
	 * @throws NoSuchComplaintBoxException if a complaint box with the primary key could not be found
	 */
	@Override
	public ComplaintBox findByPrimaryKey(long fooId)
		throws NoSuchComplaintBoxException {

		return findByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns the complaint box with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box, or <code>null</code> if a complaint box with the primary key could not be found
	 */
	@Override
	public ComplaintBox fetchByPrimaryKey(long fooId) {
		return fetchByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns all the complaint boxes.
	 *
	 * @return the complaint boxes
	 */
	@Override
	public List<ComplaintBox> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complaint boxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComplaintBoxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint boxes
	 * @param end the upper bound of the range of complaint boxes (not inclusive)
	 * @return the range of complaint boxes
	 */
	@Override
	public List<ComplaintBox> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the complaint boxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComplaintBoxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint boxes
	 * @param end the upper bound of the range of complaint boxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of complaint boxes
	 */
	@Override
	public List<ComplaintBox> findAll(
		int start, int end, OrderByComparator<ComplaintBox> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the complaint boxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComplaintBoxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint boxes
	 * @param end the upper bound of the range of complaint boxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of complaint boxes
	 */
	@Override
	public List<ComplaintBox> findAll(
		int start, int end, OrderByComparator<ComplaintBox> orderByComparator,
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

		List<ComplaintBox> list = null;

		if (useFinderCache) {
			list = (List<ComplaintBox>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMPLAINTBOX);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMPLAINTBOX;

				sql = sql.concat(ComplaintBoxModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ComplaintBox>)QueryUtil.list(
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
	 * Removes all the complaint boxes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ComplaintBox complaintBox : findAll()) {
			remove(complaintBox);
		}
	}

	/**
	 * Returns the number of complaint boxes.
	 *
	 * @return the number of complaint boxes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMPLAINTBOX);

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
		return "fooId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMPLAINTBOX;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ComplaintBoxModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the complaint box persistence.
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

		_setComplaintBoxUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setComplaintBoxUtilPersistence(null);

		entityCache.removeCache(ComplaintBoxImpl.class.getName());
	}

	private void _setComplaintBoxUtilPersistence(
		ComplaintBoxPersistence complaintBoxPersistence) {

		try {
			Field field = ComplaintBoxUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, complaintBoxPersistence);
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

	private static final String _SQL_SELECT_COMPLAINTBOX =
		"SELECT complaintBox FROM ComplaintBox complaintBox";

	private static final String _SQL_COUNT_COMPLAINTBOX =
		"SELECT COUNT(complaintBox) FROM ComplaintBox complaintBox";

	private static final String _ORDER_BY_ENTITY_ALIAS = "complaintBox.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ComplaintBox exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ComplaintBoxPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ComplaintBoxModelArgumentsResolver
		_complaintBoxModelArgumentsResolver;

}