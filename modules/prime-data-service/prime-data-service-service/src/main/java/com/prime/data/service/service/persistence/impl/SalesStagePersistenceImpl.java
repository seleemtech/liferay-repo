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

package com.prime.data.service.service.persistence.impl;

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
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.prime.data.service.exception.NoSuchSalesStageException;
import com.prime.data.service.model.SalesStage;
import com.prime.data.service.model.SalesStageTable;
import com.prime.data.service.model.impl.SalesStageImpl;
import com.prime.data.service.model.impl.SalesStageModelImpl;
import com.prime.data.service.service.persistence.SalesStagePersistence;
import com.prime.data.service.service.persistence.SalesStageUtil;
import com.prime.data.service.service.persistence.impl.constants.PRIMEPersistenceConstants;

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
 * The persistence implementation for the sales stage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {SalesStagePersistence.class, BasePersistence.class})
public class SalesStagePersistenceImpl
	extends BasePersistenceImpl<SalesStage> implements SalesStagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SalesStageUtil</code> to access the sales stage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SalesStageImpl.class.getName();

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
	 * Returns all the sales stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales stages
	 */
	@Override
	public List<SalesStage> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @return the range of matching sales stages
	 */
	@Override
	public List<SalesStage> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales stages
	 */
	@Override
	public List<SalesStage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesStage> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales stages
	 */
	@Override
	public List<SalesStage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesStage> orderByComparator,
		boolean useFinderCache) {

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

		List<SalesStage> list = null;

		if (useFinderCache) {
			list = (List<SalesStage>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SalesStage salesStage : list) {
					if (!uuid.equals(salesStage.getUuid())) {
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

			sb.append(_SQL_SELECT_SALESSTAGE_WHERE);

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
				sb.append(SalesStageModelImpl.ORDER_BY_JPQL);
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

				list = (List<SalesStage>)QueryUtil.list(
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
	 * Returns the first sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales stage
	 * @throws NoSuchSalesStageException if a matching sales stage could not be found
	 */
	@Override
	public SalesStage findByUuid_First(
			String uuid, OrderByComparator<SalesStage> orderByComparator)
		throws NoSuchSalesStageException {

		SalesStage salesStage = fetchByUuid_First(uuid, orderByComparator);

		if (salesStage != null) {
			return salesStage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSalesStageException(sb.toString());
	}

	/**
	 * Returns the first sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales stage, or <code>null</code> if a matching sales stage could not be found
	 */
	@Override
	public SalesStage fetchByUuid_First(
		String uuid, OrderByComparator<SalesStage> orderByComparator) {

		List<SalesStage> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales stage
	 * @throws NoSuchSalesStageException if a matching sales stage could not be found
	 */
	@Override
	public SalesStage findByUuid_Last(
			String uuid, OrderByComparator<SalesStage> orderByComparator)
		throws NoSuchSalesStageException {

		SalesStage salesStage = fetchByUuid_Last(uuid, orderByComparator);

		if (salesStage != null) {
			return salesStage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSalesStageException(sb.toString());
	}

	/**
	 * Returns the last sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales stage, or <code>null</code> if a matching sales stage could not be found
	 */
	@Override
	public SalesStage fetchByUuid_Last(
		String uuid, OrderByComparator<SalesStage> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SalesStage> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sales stages before and after the current sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param salesStageId the primary key of the current sales stage
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales stage
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	@Override
	public SalesStage[] findByUuid_PrevAndNext(
			long salesStageId, String uuid,
			OrderByComparator<SalesStage> orderByComparator)
		throws NoSuchSalesStageException {

		uuid = Objects.toString(uuid, "");

		SalesStage salesStage = findByPrimaryKey(salesStageId);

		Session session = null;

		try {
			session = openSession();

			SalesStage[] array = new SalesStageImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, salesStage, uuid, orderByComparator, true);

			array[1] = salesStage;

			array[2] = getByUuid_PrevAndNext(
				session, salesStage, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalesStage getByUuid_PrevAndNext(
		Session session, SalesStage salesStage, String uuid,
		OrderByComparator<SalesStage> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SALESSTAGE_WHERE);

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
			sb.append(SalesStageModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(salesStage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SalesStage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sales stages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SalesStage salesStage :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(salesStage);
		}
	}

	/**
	 * Returns the number of sales stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales stages
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALESSTAGE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"salesStage.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(salesStage.uuid IS NULL OR salesStage.uuid = '')";

	public SalesStagePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SalesStage.class);

		setModelImplClass(SalesStageImpl.class);
		setModelPKClass(long.class);

		setTable(SalesStageTable.INSTANCE);
	}

	/**
	 * Caches the sales stage in the entity cache if it is enabled.
	 *
	 * @param salesStage the sales stage
	 */
	@Override
	public void cacheResult(SalesStage salesStage) {
		entityCache.putResult(
			SalesStageImpl.class, salesStage.getPrimaryKey(), salesStage);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the sales stages in the entity cache if it is enabled.
	 *
	 * @param salesStages the sales stages
	 */
	@Override
	public void cacheResult(List<SalesStage> salesStages) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (salesStages.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SalesStage salesStage : salesStages) {
			if (entityCache.getResult(
					SalesStageImpl.class, salesStage.getPrimaryKey()) == null) {

				cacheResult(salesStage);
			}
		}
	}

	/**
	 * Clears the cache for all sales stages.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SalesStageImpl.class);

		finderCache.clearCache(SalesStageImpl.class);
	}

	/**
	 * Clears the cache for the sales stage.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SalesStage salesStage) {
		entityCache.removeResult(SalesStageImpl.class, salesStage);
	}

	@Override
	public void clearCache(List<SalesStage> salesStages) {
		for (SalesStage salesStage : salesStages) {
			entityCache.removeResult(SalesStageImpl.class, salesStage);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SalesStageImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SalesStageImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new sales stage with the primary key. Does not add the sales stage to the database.
	 *
	 * @param salesStageId the primary key for the new sales stage
	 * @return the new sales stage
	 */
	@Override
	public SalesStage create(long salesStageId) {
		SalesStage salesStage = new SalesStageImpl();

		salesStage.setNew(true);
		salesStage.setPrimaryKey(salesStageId);

		String uuid = PortalUUIDUtil.generate();

		salesStage.setUuid(uuid);

		return salesStage;
	}

	/**
	 * Removes the sales stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage that was removed
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	@Override
	public SalesStage remove(long salesStageId)
		throws NoSuchSalesStageException {

		return remove((Serializable)salesStageId);
	}

	/**
	 * Removes the sales stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sales stage
	 * @return the sales stage that was removed
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	@Override
	public SalesStage remove(Serializable primaryKey)
		throws NoSuchSalesStageException {

		Session session = null;

		try {
			session = openSession();

			SalesStage salesStage = (SalesStage)session.get(
				SalesStageImpl.class, primaryKey);

			if (salesStage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSalesStageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(salesStage);
		}
		catch (NoSuchSalesStageException noSuchEntityException) {
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
	protected SalesStage removeImpl(SalesStage salesStage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(salesStage)) {
				salesStage = (SalesStage)session.get(
					SalesStageImpl.class, salesStage.getPrimaryKeyObj());
			}

			if (salesStage != null) {
				session.delete(salesStage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (salesStage != null) {
			clearCache(salesStage);
		}

		return salesStage;
	}

	@Override
	public SalesStage updateImpl(SalesStage salesStage) {
		boolean isNew = salesStage.isNew();

		if (!(salesStage instanceof SalesStageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(salesStage.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(salesStage);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in salesStage proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SalesStage implementation " +
					salesStage.getClass());
		}

		SalesStageModelImpl salesStageModelImpl =
			(SalesStageModelImpl)salesStage;

		if (Validator.isNull(salesStage.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			salesStage.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(salesStage);
			}
			else {
				salesStage = (SalesStage)session.merge(salesStage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SalesStageImpl.class, salesStageModelImpl, false, true);

		if (isNew) {
			salesStage.setNew(false);
		}

		salesStage.resetOriginalValues();

		return salesStage;
	}

	/**
	 * Returns the sales stage with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sales stage
	 * @return the sales stage
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	@Override
	public SalesStage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSalesStageException {

		SalesStage salesStage = fetchByPrimaryKey(primaryKey);

		if (salesStage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSalesStageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return salesStage;
	}

	/**
	 * Returns the sales stage with the primary key or throws a <code>NoSuchSalesStageException</code> if it could not be found.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	@Override
	public SalesStage findByPrimaryKey(long salesStageId)
		throws NoSuchSalesStageException {

		return findByPrimaryKey((Serializable)salesStageId);
	}

	/**
	 * Returns the sales stage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage, or <code>null</code> if a sales stage with the primary key could not be found
	 */
	@Override
	public SalesStage fetchByPrimaryKey(long salesStageId) {
		return fetchByPrimaryKey((Serializable)salesStageId);
	}

	/**
	 * Returns all the sales stages.
	 *
	 * @return the sales stages
	 */
	@Override
	public List<SalesStage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @return the range of sales stages
	 */
	@Override
	public List<SalesStage> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sales stages
	 */
	@Override
	public List<SalesStage> findAll(
		int start, int end, OrderByComparator<SalesStage> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sales stages
	 */
	@Override
	public List<SalesStage> findAll(
		int start, int end, OrderByComparator<SalesStage> orderByComparator,
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

		List<SalesStage> list = null;

		if (useFinderCache) {
			list = (List<SalesStage>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SALESSTAGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SALESSTAGE;

				sql = sql.concat(SalesStageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SalesStage>)QueryUtil.list(
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
	 * Removes all the sales stages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SalesStage salesStage : findAll()) {
			remove(salesStage);
		}
	}

	/**
	 * Returns the number of sales stages.
	 *
	 * @return the number of sales stages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SALESSTAGE);

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
		return "salesStageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SALESSTAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SalesStageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sales stage persistence.
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

		_setSalesStageUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSalesStageUtilPersistence(null);

		entityCache.removeCache(SalesStageImpl.class.getName());
	}

	private void _setSalesStageUtilPersistence(
		SalesStagePersistence salesStagePersistence) {

		try {
			Field field = SalesStageUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, salesStagePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = PRIMEPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PRIMEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PRIMEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SALESSTAGE =
		"SELECT salesStage FROM SalesStage salesStage";

	private static final String _SQL_SELECT_SALESSTAGE_WHERE =
		"SELECT salesStage FROM SalesStage salesStage WHERE ";

	private static final String _SQL_COUNT_SALESSTAGE =
		"SELECT COUNT(salesStage) FROM SalesStage salesStage";

	private static final String _SQL_COUNT_SALESSTAGE_WHERE =
		"SELECT COUNT(salesStage) FROM SalesStage salesStage WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "salesStage.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SalesStage exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SalesStage exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SalesStagePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private SalesStageModelArgumentsResolver _salesStageModelArgumentsResolver;

}