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

import com.intranet.exception.NoSuchExperienceDetailsException;
import com.intranet.model.ExperienceDetails;
import com.intranet.model.ExperienceDetailsTable;
import com.intranet.model.impl.ExperienceDetailsImpl;
import com.intranet.model.impl.ExperienceDetailsModelImpl;
import com.intranet.service.persistence.ExperienceDetailsPersistence;
import com.intranet.service.persistence.ExperienceDetailsUtil;
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
 * The persistence implementation for the experience details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {ExperienceDetailsPersistence.class, BasePersistence.class}
)
public class ExperienceDetailsPersistenceImpl
	extends BasePersistenceImpl<ExperienceDetails>
	implements ExperienceDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExperienceDetailsUtil</code> to access the experience details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExperienceDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ExperienceDetailsPersistenceImpl() {
		setModelClass(ExperienceDetails.class);

		setModelImplClass(ExperienceDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(ExperienceDetailsTable.INSTANCE);
	}

	/**
	 * Caches the experience details in the entity cache if it is enabled.
	 *
	 * @param experienceDetails the experience details
	 */
	@Override
	public void cacheResult(ExperienceDetails experienceDetails) {
		entityCache.putResult(
			ExperienceDetailsImpl.class, experienceDetails.getPrimaryKey(),
			experienceDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the experience detailses in the entity cache if it is enabled.
	 *
	 * @param experienceDetailses the experience detailses
	 */
	@Override
	public void cacheResult(List<ExperienceDetails> experienceDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (experienceDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ExperienceDetails experienceDetails : experienceDetailses) {
			if (entityCache.getResult(
					ExperienceDetailsImpl.class,
					experienceDetails.getPrimaryKey()) == null) {

				cacheResult(experienceDetails);
			}
		}
	}

	/**
	 * Clears the cache for all experience detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExperienceDetailsImpl.class);

		finderCache.clearCache(ExperienceDetailsImpl.class);
	}

	/**
	 * Clears the cache for the experience details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExperienceDetails experienceDetails) {
		entityCache.removeResult(
			ExperienceDetailsImpl.class, experienceDetails);
	}

	@Override
	public void clearCache(List<ExperienceDetails> experienceDetailses) {
		for (ExperienceDetails experienceDetails : experienceDetailses) {
			entityCache.removeResult(
				ExperienceDetailsImpl.class, experienceDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ExperienceDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ExperienceDetailsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new experience details with the primary key. Does not add the experience details to the database.
	 *
	 * @param experienceId the primary key for the new experience details
	 * @return the new experience details
	 */
	@Override
	public ExperienceDetails create(long experienceId) {
		ExperienceDetails experienceDetails = new ExperienceDetailsImpl();

		experienceDetails.setNew(true);
		experienceDetails.setPrimaryKey(experienceId);

		return experienceDetails;
	}

	/**
	 * Removes the experience details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details that was removed
	 * @throws NoSuchExperienceDetailsException if a experience details with the primary key could not be found
	 */
	@Override
	public ExperienceDetails remove(long experienceId)
		throws NoSuchExperienceDetailsException {

		return remove((Serializable)experienceId);
	}

	/**
	 * Removes the experience details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the experience details
	 * @return the experience details that was removed
	 * @throws NoSuchExperienceDetailsException if a experience details with the primary key could not be found
	 */
	@Override
	public ExperienceDetails remove(Serializable primaryKey)
		throws NoSuchExperienceDetailsException {

		Session session = null;

		try {
			session = openSession();

			ExperienceDetails experienceDetails =
				(ExperienceDetails)session.get(
					ExperienceDetailsImpl.class, primaryKey);

			if (experienceDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExperienceDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(experienceDetails);
		}
		catch (NoSuchExperienceDetailsException noSuchEntityException) {
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
	protected ExperienceDetails removeImpl(
		ExperienceDetails experienceDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(experienceDetails)) {
				experienceDetails = (ExperienceDetails)session.get(
					ExperienceDetailsImpl.class,
					experienceDetails.getPrimaryKeyObj());
			}

			if (experienceDetails != null) {
				session.delete(experienceDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (experienceDetails != null) {
			clearCache(experienceDetails);
		}

		return experienceDetails;
	}

	@Override
	public ExperienceDetails updateImpl(ExperienceDetails experienceDetails) {
		boolean isNew = experienceDetails.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(experienceDetails);
			}
			else {
				experienceDetails = (ExperienceDetails)session.merge(
					experienceDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ExperienceDetailsImpl.class, experienceDetails, false, true);

		if (isNew) {
			experienceDetails.setNew(false);
		}

		experienceDetails.resetOriginalValues();

		return experienceDetails;
	}

	/**
	 * Returns the experience details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the experience details
	 * @return the experience details
	 * @throws NoSuchExperienceDetailsException if a experience details with the primary key could not be found
	 */
	@Override
	public ExperienceDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExperienceDetailsException {

		ExperienceDetails experienceDetails = fetchByPrimaryKey(primaryKey);

		if (experienceDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExperienceDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return experienceDetails;
	}

	/**
	 * Returns the experience details with the primary key or throws a <code>NoSuchExperienceDetailsException</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details
	 * @throws NoSuchExperienceDetailsException if a experience details with the primary key could not be found
	 */
	@Override
	public ExperienceDetails findByPrimaryKey(long experienceId)
		throws NoSuchExperienceDetailsException {

		return findByPrimaryKey((Serializable)experienceId);
	}

	/**
	 * Returns the experience details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details, or <code>null</code> if a experience details with the primary key could not be found
	 */
	@Override
	public ExperienceDetails fetchByPrimaryKey(long experienceId) {
		return fetchByPrimaryKey((Serializable)experienceId);
	}

	/**
	 * Returns all the experience detailses.
	 *
	 * @return the experience detailses
	 */
	@Override
	public List<ExperienceDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @return the range of experience detailses
	 */
	@Override
	public List<ExperienceDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of experience detailses
	 */
	@Override
	public List<ExperienceDetails> findAll(
		int start, int end,
		OrderByComparator<ExperienceDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of experience detailses
	 */
	@Override
	public List<ExperienceDetails> findAll(
		int start, int end,
		OrderByComparator<ExperienceDetails> orderByComparator,
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

		List<ExperienceDetails> list = null;

		if (useFinderCache) {
			list = (List<ExperienceDetails>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EXPERIENCEDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EXPERIENCEDETAILS;

				sql = sql.concat(ExperienceDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ExperienceDetails>)QueryUtil.list(
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
	 * Removes all the experience detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExperienceDetails experienceDetails : findAll()) {
			remove(experienceDetails);
		}
	}

	/**
	 * Returns the number of experience detailses.
	 *
	 * @return the number of experience detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EXPERIENCEDETAILS);

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
		return "experienceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXPERIENCEDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExperienceDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the experience details persistence.
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

		_setExperienceDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setExperienceDetailsUtilPersistence(null);

		entityCache.removeCache(ExperienceDetailsImpl.class.getName());
	}

	private void _setExperienceDetailsUtilPersistence(
		ExperienceDetailsPersistence experienceDetailsPersistence) {

		try {
			Field field = ExperienceDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, experienceDetailsPersistence);
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

	private static final String _SQL_SELECT_EXPERIENCEDETAILS =
		"SELECT experienceDetails FROM ExperienceDetails experienceDetails";

	private static final String _SQL_COUNT_EXPERIENCEDETAILS =
		"SELECT COUNT(experienceDetails) FROM ExperienceDetails experienceDetails";

	private static final String _ORDER_BY_ENTITY_ALIAS = "experienceDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ExperienceDetails exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ExperienceDetailsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ExperienceDetailsModelArgumentsResolver
		_experienceDetailsModelArgumentsResolver;

}