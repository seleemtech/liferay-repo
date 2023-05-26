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

package com.fitness.club.service.service.persistence.impl;

import com.fitness.club.service.exception.NoSuchFitnessException;
import com.fitness.club.service.model.Fitness;
import com.fitness.club.service.model.FitnessTable;
import com.fitness.club.service.model.impl.FitnessImpl;
import com.fitness.club.service.model.impl.FitnessModelImpl;
import com.fitness.club.service.service.persistence.FitnessPersistence;
import com.fitness.club.service.service.persistence.FitnessUtil;
import com.fitness.club.service.service.persistence.impl.constants.FOOPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the fitness service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {FitnessPersistence.class, BasePersistence.class})
public class FitnessPersistenceImpl
	extends BasePersistenceImpl<Fitness> implements FitnessPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FitnessUtil</code> to access the fitness persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FitnessImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the fitnesses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fitnesses
	 */
	@Override
	public List<Fitness> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fitnesses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @return the range of matching fitnesses
	 */
	@Override
	public List<Fitness> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the fitnesses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fitnesses
	 */
	@Override
	public List<Fitness> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Fitness> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fitnesses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fitnesses
	 */
	@Override
	public List<Fitness> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Fitness> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Fitness> list = null;

		if (useFinderCache) {
			list = (List<Fitness>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Fitness fitness : list) {
					if (!uuid.equals(fitness.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_FITNESS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FitnessModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Fitness>)QueryUtil.list(
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
	 * Returns the first fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness
	 * @throws NoSuchFitnessException if a matching fitness could not be found
	 */
	@Override
	public Fitness findByUuid_First(
			String uuid, OrderByComparator<Fitness> orderByComparator)
		throws NoSuchFitnessException {

		Fitness fitness = fetchByUuid_First(uuid, orderByComparator);

		if (fitness != null) {
			return fitness;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFitnessException(sb.toString());
	}

	/**
	 * Returns the first fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness, or <code>null</code> if a matching fitness could not be found
	 */
	@Override
	public Fitness fetchByUuid_First(
		String uuid, OrderByComparator<Fitness> orderByComparator) {

		List<Fitness> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness
	 * @throws NoSuchFitnessException if a matching fitness could not be found
	 */
	@Override
	public Fitness findByUuid_Last(
			String uuid, OrderByComparator<Fitness> orderByComparator)
		throws NoSuchFitnessException {

		Fitness fitness = fetchByUuid_Last(uuid, orderByComparator);

		if (fitness != null) {
			return fitness;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFitnessException(sb.toString());
	}

	/**
	 * Returns the last fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness, or <code>null</code> if a matching fitness could not be found
	 */
	@Override
	public Fitness fetchByUuid_Last(
		String uuid, OrderByComparator<Fitness> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Fitness> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the fitnesses before and after the current fitness in the ordered set where uuid = &#63;.
	 *
	 * @param trainerId the primary key of the current fitness
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fitness
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	@Override
	public Fitness[] findByUuid_PrevAndNext(
			long trainerId, String uuid,
			OrderByComparator<Fitness> orderByComparator)
		throws NoSuchFitnessException {

		uuid = Objects.toString(uuid, "");

		Fitness fitness = findByPrimaryKey(trainerId);

		Session session = null;

		try {
			session = openSession();

			Fitness[] array = new FitnessImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, fitness, uuid, orderByComparator, true);

			array[1] = fitness;

			array[2] = getByUuid_PrevAndNext(
				session, fitness, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Fitness getByUuid_PrevAndNext(
		Session session, Fitness fitness, String uuid,
		OrderByComparator<Fitness> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FITNESS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(FitnessModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(fitness)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Fitness> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the fitnesses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Fitness fitness :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(fitness);
		}
	}

	/**
	 * Returns the number of fitnesses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fitnesses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FITNESS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "fitness.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(fitness.uuid IS NULL OR fitness.uuid = '')";

	public FitnessPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Fitness.class);

		setModelImplClass(FitnessImpl.class);
		setModelPKClass(long.class);

		setTable(FitnessTable.INSTANCE);
	}

	/**
	 * Caches the fitness in the entity cache if it is enabled.
	 *
	 * @param fitness the fitness
	 */
	@Override
	public void cacheResult(Fitness fitness) {
		entityCache.putResult(
			FitnessImpl.class, fitness.getPrimaryKey(), fitness);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the fitnesses in the entity cache if it is enabled.
	 *
	 * @param fitnesses the fitnesses
	 */
	@Override
	public void cacheResult(List<Fitness> fitnesses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (fitnesses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Fitness fitness : fitnesses) {
			if (entityCache.getResult(
					FitnessImpl.class, fitness.getPrimaryKey()) == null) {

				cacheResult(fitness);
			}
		}
	}

	/**
	 * Clears the cache for all fitnesses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FitnessImpl.class);

		finderCache.clearCache(FitnessImpl.class);
	}

	/**
	 * Clears the cache for the fitness.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Fitness fitness) {
		entityCache.removeResult(FitnessImpl.class, fitness);
	}

	@Override
	public void clearCache(List<Fitness> fitnesses) {
		for (Fitness fitness : fitnesses) {
			entityCache.removeResult(FitnessImpl.class, fitness);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FitnessImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FitnessImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new fitness with the primary key. Does not add the fitness to the database.
	 *
	 * @param trainerId the primary key for the new fitness
	 * @return the new fitness
	 */
	@Override
	public Fitness create(long trainerId) {
		Fitness fitness = new FitnessImpl();

		fitness.setNew(true);
		fitness.setPrimaryKey(trainerId);

		String uuid = _portalUUID.generate();

		fitness.setUuid(uuid);

		return fitness;
	}

	/**
	 * Removes the fitness with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness that was removed
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	@Override
	public Fitness remove(long trainerId) throws NoSuchFitnessException {
		return remove((Serializable)trainerId);
	}

	/**
	 * Removes the fitness with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fitness
	 * @return the fitness that was removed
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	@Override
	public Fitness remove(Serializable primaryKey)
		throws NoSuchFitnessException {

		Session session = null;

		try {
			session = openSession();

			Fitness fitness = (Fitness)session.get(
				FitnessImpl.class, primaryKey);

			if (fitness == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFitnessException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(fitness);
		}
		catch (NoSuchFitnessException noSuchEntityException) {
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
	protected Fitness removeImpl(Fitness fitness) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(fitness)) {
				fitness = (Fitness)session.get(
					FitnessImpl.class, fitness.getPrimaryKeyObj());
			}

			if (fitness != null) {
				session.delete(fitness);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (fitness != null) {
			clearCache(fitness);
		}

		return fitness;
	}

	@Override
	public Fitness updateImpl(Fitness fitness) {
		boolean isNew = fitness.isNew();

		if (!(fitness instanceof FitnessModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(fitness.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(fitness);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in fitness proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Fitness implementation " +
					fitness.getClass());
		}

		FitnessModelImpl fitnessModelImpl = (FitnessModelImpl)fitness;

		if (Validator.isNull(fitness.getUuid())) {
			String uuid = _portalUUID.generate();

			fitness.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(fitness);
			}
			else {
				fitness = (Fitness)session.merge(fitness);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(FitnessImpl.class, fitnessModelImpl, false, true);

		if (isNew) {
			fitness.setNew(false);
		}

		fitness.resetOriginalValues();

		return fitness;
	}

	/**
	 * Returns the fitness with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fitness
	 * @return the fitness
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	@Override
	public Fitness findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFitnessException {

		Fitness fitness = fetchByPrimaryKey(primaryKey);

		if (fitness == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFitnessException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return fitness;
	}

	/**
	 * Returns the fitness with the primary key or throws a <code>NoSuchFitnessException</code> if it could not be found.
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	@Override
	public Fitness findByPrimaryKey(long trainerId)
		throws NoSuchFitnessException {

		return findByPrimaryKey((Serializable)trainerId);
	}

	/**
	 * Returns the fitness with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness, or <code>null</code> if a fitness with the primary key could not be found
	 */
	@Override
	public Fitness fetchByPrimaryKey(long trainerId) {
		return fetchByPrimaryKey((Serializable)trainerId);
	}

	/**
	 * Returns all the fitnesses.
	 *
	 * @return the fitnesses
	 */
	@Override
	public List<Fitness> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fitnesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @return the range of fitnesses
	 */
	@Override
	public List<Fitness> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fitnesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fitnesses
	 */
	@Override
	public List<Fitness> findAll(
		int start, int end, OrderByComparator<Fitness> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the fitnesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fitnesses
	 */
	@Override
	public List<Fitness> findAll(
		int start, int end, OrderByComparator<Fitness> orderByComparator,
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

		List<Fitness> list = null;

		if (useFinderCache) {
			list = (List<Fitness>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FITNESS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FITNESS;

				sql = sql.concat(FitnessModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Fitness>)QueryUtil.list(
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
	 * Removes all the fitnesses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Fitness fitness : findAll()) {
			remove(fitness);
		}
	}

	/**
	 * Returns the number of fitnesses.
	 *
	 * @return the number of fitnesses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FITNESS);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "trainerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FITNESS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FitnessModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the fitness persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_setFitnessUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFitnessUtilPersistence(null);

		entityCache.removeCache(FitnessImpl.class.getName());
	}

	private void _setFitnessUtilPersistence(
		FitnessPersistence fitnessPersistence) {

		try {
			Field field = FitnessUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, fitnessPersistence);
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

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FITNESS =
		"SELECT fitness FROM Fitness fitness";

	private static final String _SQL_SELECT_FITNESS_WHERE =
		"SELECT fitness FROM Fitness fitness WHERE ";

	private static final String _SQL_COUNT_FITNESS =
		"SELECT COUNT(fitness) FROM Fitness fitness";

	private static final String _SQL_COUNT_FITNESS_WHERE =
		"SELECT COUNT(fitness) FROM Fitness fitness WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "fitness.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Fitness exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Fitness exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FitnessPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private FitnessModelArgumentsResolver _fitnessModelArgumentsResolver;

}