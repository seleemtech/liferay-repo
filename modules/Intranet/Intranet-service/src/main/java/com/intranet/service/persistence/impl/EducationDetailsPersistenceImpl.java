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

import com.intranet.exception.NoSuchEducationDetailsException;
import com.intranet.model.EducationDetails;
import com.intranet.model.EducationDetailsTable;
import com.intranet.model.impl.EducationDetailsImpl;
import com.intranet.model.impl.EducationDetailsModelImpl;
import com.intranet.service.persistence.EducationDetailsPersistence;
import com.intranet.service.persistence.EducationDetailsUtil;
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
 * The persistence implementation for the education details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {EducationDetailsPersistence.class, BasePersistence.class})
public class EducationDetailsPersistenceImpl
	extends BasePersistenceImpl<EducationDetails>
	implements EducationDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EducationDetailsUtil</code> to access the education details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EducationDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EducationDetailsPersistenceImpl() {
		setModelClass(EducationDetails.class);

		setModelImplClass(EducationDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(EducationDetailsTable.INSTANCE);
	}

	/**
	 * Caches the education details in the entity cache if it is enabled.
	 *
	 * @param educationDetails the education details
	 */
	@Override
	public void cacheResult(EducationDetails educationDetails) {
		entityCache.putResult(
			EducationDetailsImpl.class, educationDetails.getPrimaryKey(),
			educationDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the education detailses in the entity cache if it is enabled.
	 *
	 * @param educationDetailses the education detailses
	 */
	@Override
	public void cacheResult(List<EducationDetails> educationDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (educationDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EducationDetails educationDetails : educationDetailses) {
			if (entityCache.getResult(
					EducationDetailsImpl.class,
					educationDetails.getPrimaryKey()) == null) {

				cacheResult(educationDetails);
			}
		}
	}

	/**
	 * Clears the cache for all education detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EducationDetailsImpl.class);

		finderCache.clearCache(EducationDetailsImpl.class);
	}

	/**
	 * Clears the cache for the education details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EducationDetails educationDetails) {
		entityCache.removeResult(EducationDetailsImpl.class, educationDetails);
	}

	@Override
	public void clearCache(List<EducationDetails> educationDetailses) {
		for (EducationDetails educationDetails : educationDetailses) {
			entityCache.removeResult(
				EducationDetailsImpl.class, educationDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EducationDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EducationDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new education details with the primary key. Does not add the education details to the database.
	 *
	 * @param educationId the primary key for the new education details
	 * @return the new education details
	 */
	@Override
	public EducationDetails create(long educationId) {
		EducationDetails educationDetails = new EducationDetailsImpl();

		educationDetails.setNew(true);
		educationDetails.setPrimaryKey(educationId);

		return educationDetails;
	}

	/**
	 * Removes the education details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details that was removed
	 * @throws NoSuchEducationDetailsException if a education details with the primary key could not be found
	 */
	@Override
	public EducationDetails remove(long educationId)
		throws NoSuchEducationDetailsException {

		return remove((Serializable)educationId);
	}

	/**
	 * Removes the education details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the education details
	 * @return the education details that was removed
	 * @throws NoSuchEducationDetailsException if a education details with the primary key could not be found
	 */
	@Override
	public EducationDetails remove(Serializable primaryKey)
		throws NoSuchEducationDetailsException {

		Session session = null;

		try {
			session = openSession();

			EducationDetails educationDetails = (EducationDetails)session.get(
				EducationDetailsImpl.class, primaryKey);

			if (educationDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEducationDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(educationDetails);
		}
		catch (NoSuchEducationDetailsException noSuchEntityException) {
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
	protected EducationDetails removeImpl(EducationDetails educationDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(educationDetails)) {
				educationDetails = (EducationDetails)session.get(
					EducationDetailsImpl.class,
					educationDetails.getPrimaryKeyObj());
			}

			if (educationDetails != null) {
				session.delete(educationDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (educationDetails != null) {
			clearCache(educationDetails);
		}

		return educationDetails;
	}

	@Override
	public EducationDetails updateImpl(EducationDetails educationDetails) {
		boolean isNew = educationDetails.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(educationDetails);
			}
			else {
				educationDetails = (EducationDetails)session.merge(
					educationDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EducationDetailsImpl.class, educationDetails, false, true);

		if (isNew) {
			educationDetails.setNew(false);
		}

		educationDetails.resetOriginalValues();

		return educationDetails;
	}

	/**
	 * Returns the education details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the education details
	 * @return the education details
	 * @throws NoSuchEducationDetailsException if a education details with the primary key could not be found
	 */
	@Override
	public EducationDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEducationDetailsException {

		EducationDetails educationDetails = fetchByPrimaryKey(primaryKey);

		if (educationDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEducationDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return educationDetails;
	}

	/**
	 * Returns the education details with the primary key or throws a <code>NoSuchEducationDetailsException</code> if it could not be found.
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details
	 * @throws NoSuchEducationDetailsException if a education details with the primary key could not be found
	 */
	@Override
	public EducationDetails findByPrimaryKey(long educationId)
		throws NoSuchEducationDetailsException {

		return findByPrimaryKey((Serializable)educationId);
	}

	/**
	 * Returns the education details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details, or <code>null</code> if a education details with the primary key could not be found
	 */
	@Override
	public EducationDetails fetchByPrimaryKey(long educationId) {
		return fetchByPrimaryKey((Serializable)educationId);
	}

	/**
	 * Returns all the education detailses.
	 *
	 * @return the education detailses
	 */
	@Override
	public List<EducationDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the education detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education detailses
	 * @param end the upper bound of the range of education detailses (not inclusive)
	 * @return the range of education detailses
	 */
	@Override
	public List<EducationDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the education detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education detailses
	 * @param end the upper bound of the range of education detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of education detailses
	 */
	@Override
	public List<EducationDetails> findAll(
		int start, int end,
		OrderByComparator<EducationDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the education detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education detailses
	 * @param end the upper bound of the range of education detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of education detailses
	 */
	@Override
	public List<EducationDetails> findAll(
		int start, int end,
		OrderByComparator<EducationDetails> orderByComparator,
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

		List<EducationDetails> list = null;

		if (useFinderCache) {
			list = (List<EducationDetails>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EDUCATIONDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EDUCATIONDETAILS;

				sql = sql.concat(EducationDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EducationDetails>)QueryUtil.list(
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
	 * Removes all the education detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EducationDetails educationDetails : findAll()) {
			remove(educationDetails);
		}
	}

	/**
	 * Returns the number of education detailses.
	 *
	 * @return the number of education detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EDUCATIONDETAILS);

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
		return "educationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EDUCATIONDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EducationDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the education details persistence.
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

		_setEducationDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEducationDetailsUtilPersistence(null);

		entityCache.removeCache(EducationDetailsImpl.class.getName());
	}

	private void _setEducationDetailsUtilPersistence(
		EducationDetailsPersistence educationDetailsPersistence) {

		try {
			Field field = EducationDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, educationDetailsPersistence);
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

	private static final String _SQL_SELECT_EDUCATIONDETAILS =
		"SELECT educationDetails FROM EducationDetails educationDetails";

	private static final String _SQL_COUNT_EDUCATIONDETAILS =
		"SELECT COUNT(educationDetails) FROM EducationDetails educationDetails";

	private static final String _ORDER_BY_ENTITY_ALIAS = "educationDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EducationDetails exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EducationDetailsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private EducationDetailsModelArgumentsResolver
		_educationDetailsModelArgumentsResolver;

}