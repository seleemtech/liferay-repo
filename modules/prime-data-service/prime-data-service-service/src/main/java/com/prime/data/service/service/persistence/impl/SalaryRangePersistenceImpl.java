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

import com.prime.data.service.exception.NoSuchSalaryRangeException;
import com.prime.data.service.model.SalaryRange;
import com.prime.data.service.model.SalaryRangeTable;
import com.prime.data.service.model.impl.SalaryRangeImpl;
import com.prime.data.service.model.impl.SalaryRangeModelImpl;
import com.prime.data.service.service.persistence.SalaryRangePersistence;
import com.prime.data.service.service.persistence.SalaryRangeUtil;
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
 * The persistence implementation for the salary range service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {SalaryRangePersistence.class, BasePersistence.class})
public class SalaryRangePersistenceImpl
	extends BasePersistenceImpl<SalaryRange> implements SalaryRangePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SalaryRangeUtil</code> to access the salary range persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SalaryRangeImpl.class.getName();

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
	 * Returns all the salary ranges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching salary ranges
	 */
	@Override
	public List<SalaryRange> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the salary ranges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @return the range of matching salary ranges
	 */
	@Override
	public List<SalaryRange> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the salary ranges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching salary ranges
	 */
	@Override
	public List<SalaryRange> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalaryRange> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the salary ranges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching salary ranges
	 */
	@Override
	public List<SalaryRange> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalaryRange> orderByComparator,
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

		List<SalaryRange> list = null;

		if (useFinderCache) {
			list = (List<SalaryRange>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SalaryRange salaryRange : list) {
					if (!uuid.equals(salaryRange.getUuid())) {
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

			sb.append(_SQL_SELECT_SALARYRANGE_WHERE);

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
				sb.append(SalaryRangeModelImpl.ORDER_BY_JPQL);
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

				list = (List<SalaryRange>)QueryUtil.list(
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
	 * Returns the first salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching salary range
	 * @throws NoSuchSalaryRangeException if a matching salary range could not be found
	 */
	@Override
	public SalaryRange findByUuid_First(
			String uuid, OrderByComparator<SalaryRange> orderByComparator)
		throws NoSuchSalaryRangeException {

		SalaryRange salaryRange = fetchByUuid_First(uuid, orderByComparator);

		if (salaryRange != null) {
			return salaryRange;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSalaryRangeException(sb.toString());
	}

	/**
	 * Returns the first salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching salary range, or <code>null</code> if a matching salary range could not be found
	 */
	@Override
	public SalaryRange fetchByUuid_First(
		String uuid, OrderByComparator<SalaryRange> orderByComparator) {

		List<SalaryRange> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching salary range
	 * @throws NoSuchSalaryRangeException if a matching salary range could not be found
	 */
	@Override
	public SalaryRange findByUuid_Last(
			String uuid, OrderByComparator<SalaryRange> orderByComparator)
		throws NoSuchSalaryRangeException {

		SalaryRange salaryRange = fetchByUuid_Last(uuid, orderByComparator);

		if (salaryRange != null) {
			return salaryRange;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSalaryRangeException(sb.toString());
	}

	/**
	 * Returns the last salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching salary range, or <code>null</code> if a matching salary range could not be found
	 */
	@Override
	public SalaryRange fetchByUuid_Last(
		String uuid, OrderByComparator<SalaryRange> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SalaryRange> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the salary ranges before and after the current salary range in the ordered set where uuid = &#63;.
	 *
	 * @param salaryRangeId the primary key of the current salary range
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next salary range
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	@Override
	public SalaryRange[] findByUuid_PrevAndNext(
			long salaryRangeId, String uuid,
			OrderByComparator<SalaryRange> orderByComparator)
		throws NoSuchSalaryRangeException {

		uuid = Objects.toString(uuid, "");

		SalaryRange salaryRange = findByPrimaryKey(salaryRangeId);

		Session session = null;

		try {
			session = openSession();

			SalaryRange[] array = new SalaryRangeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, salaryRange, uuid, orderByComparator, true);

			array[1] = salaryRange;

			array[2] = getByUuid_PrevAndNext(
				session, salaryRange, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SalaryRange getByUuid_PrevAndNext(
		Session session, SalaryRange salaryRange, String uuid,
		OrderByComparator<SalaryRange> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SALARYRANGE_WHERE);

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
			sb.append(SalaryRangeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(salaryRange)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SalaryRange> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the salary ranges where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SalaryRange salaryRange :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(salaryRange);
		}
	}

	/**
	 * Returns the number of salary ranges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching salary ranges
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SALARYRANGE_WHERE);

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
		"salaryRange.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(salaryRange.uuid IS NULL OR salaryRange.uuid = '')";

	public SalaryRangePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SalaryRange.class);

		setModelImplClass(SalaryRangeImpl.class);
		setModelPKClass(long.class);

		setTable(SalaryRangeTable.INSTANCE);
	}

	/**
	 * Caches the salary range in the entity cache if it is enabled.
	 *
	 * @param salaryRange the salary range
	 */
	@Override
	public void cacheResult(SalaryRange salaryRange) {
		entityCache.putResult(
			SalaryRangeImpl.class, salaryRange.getPrimaryKey(), salaryRange);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the salary ranges in the entity cache if it is enabled.
	 *
	 * @param salaryRanges the salary ranges
	 */
	@Override
	public void cacheResult(List<SalaryRange> salaryRanges) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (salaryRanges.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SalaryRange salaryRange : salaryRanges) {
			if (entityCache.getResult(
					SalaryRangeImpl.class, salaryRange.getPrimaryKey()) ==
						null) {

				cacheResult(salaryRange);
			}
		}
	}

	/**
	 * Clears the cache for all salary ranges.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SalaryRangeImpl.class);

		finderCache.clearCache(SalaryRangeImpl.class);
	}

	/**
	 * Clears the cache for the salary range.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SalaryRange salaryRange) {
		entityCache.removeResult(SalaryRangeImpl.class, salaryRange);
	}

	@Override
	public void clearCache(List<SalaryRange> salaryRanges) {
		for (SalaryRange salaryRange : salaryRanges) {
			entityCache.removeResult(SalaryRangeImpl.class, salaryRange);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SalaryRangeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SalaryRangeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new salary range with the primary key. Does not add the salary range to the database.
	 *
	 * @param salaryRangeId the primary key for the new salary range
	 * @return the new salary range
	 */
	@Override
	public SalaryRange create(long salaryRangeId) {
		SalaryRange salaryRange = new SalaryRangeImpl();

		salaryRange.setNew(true);
		salaryRange.setPrimaryKey(salaryRangeId);

		String uuid = PortalUUIDUtil.generate();

		salaryRange.setUuid(uuid);

		return salaryRange;
	}

	/**
	 * Removes the salary range with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salaryRangeId the primary key of the salary range
	 * @return the salary range that was removed
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	@Override
	public SalaryRange remove(long salaryRangeId)
		throws NoSuchSalaryRangeException {

		return remove((Serializable)salaryRangeId);
	}

	/**
	 * Removes the salary range with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the salary range
	 * @return the salary range that was removed
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	@Override
	public SalaryRange remove(Serializable primaryKey)
		throws NoSuchSalaryRangeException {

		Session session = null;

		try {
			session = openSession();

			SalaryRange salaryRange = (SalaryRange)session.get(
				SalaryRangeImpl.class, primaryKey);

			if (salaryRange == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSalaryRangeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(salaryRange);
		}
		catch (NoSuchSalaryRangeException noSuchEntityException) {
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
	protected SalaryRange removeImpl(SalaryRange salaryRange) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(salaryRange)) {
				salaryRange = (SalaryRange)session.get(
					SalaryRangeImpl.class, salaryRange.getPrimaryKeyObj());
			}

			if (salaryRange != null) {
				session.delete(salaryRange);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (salaryRange != null) {
			clearCache(salaryRange);
		}

		return salaryRange;
	}

	@Override
	public SalaryRange updateImpl(SalaryRange salaryRange) {
		boolean isNew = salaryRange.isNew();

		if (!(salaryRange instanceof SalaryRangeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(salaryRange.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(salaryRange);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in salaryRange proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SalaryRange implementation " +
					salaryRange.getClass());
		}

		SalaryRangeModelImpl salaryRangeModelImpl =
			(SalaryRangeModelImpl)salaryRange;

		if (Validator.isNull(salaryRange.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			salaryRange.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(salaryRange);
			}
			else {
				salaryRange = (SalaryRange)session.merge(salaryRange);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SalaryRangeImpl.class, salaryRangeModelImpl, false, true);

		if (isNew) {
			salaryRange.setNew(false);
		}

		salaryRange.resetOriginalValues();

		return salaryRange;
	}

	/**
	 * Returns the salary range with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the salary range
	 * @return the salary range
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	@Override
	public SalaryRange findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSalaryRangeException {

		SalaryRange salaryRange = fetchByPrimaryKey(primaryKey);

		if (salaryRange == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSalaryRangeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return salaryRange;
	}

	/**
	 * Returns the salary range with the primary key or throws a <code>NoSuchSalaryRangeException</code> if it could not be found.
	 *
	 * @param salaryRangeId the primary key of the salary range
	 * @return the salary range
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	@Override
	public SalaryRange findByPrimaryKey(long salaryRangeId)
		throws NoSuchSalaryRangeException {

		return findByPrimaryKey((Serializable)salaryRangeId);
	}

	/**
	 * Returns the salary range with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salaryRangeId the primary key of the salary range
	 * @return the salary range, or <code>null</code> if a salary range with the primary key could not be found
	 */
	@Override
	public SalaryRange fetchByPrimaryKey(long salaryRangeId) {
		return fetchByPrimaryKey((Serializable)salaryRangeId);
	}

	/**
	 * Returns all the salary ranges.
	 *
	 * @return the salary ranges
	 */
	@Override
	public List<SalaryRange> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the salary ranges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @return the range of salary ranges
	 */
	@Override
	public List<SalaryRange> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the salary ranges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of salary ranges
	 */
	@Override
	public List<SalaryRange> findAll(
		int start, int end, OrderByComparator<SalaryRange> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the salary ranges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of salary ranges
	 */
	@Override
	public List<SalaryRange> findAll(
		int start, int end, OrderByComparator<SalaryRange> orderByComparator,
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

		List<SalaryRange> list = null;

		if (useFinderCache) {
			list = (List<SalaryRange>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SALARYRANGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SALARYRANGE;

				sql = sql.concat(SalaryRangeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SalaryRange>)QueryUtil.list(
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
	 * Removes all the salary ranges from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SalaryRange salaryRange : findAll()) {
			remove(salaryRange);
		}
	}

	/**
	 * Returns the number of salary ranges.
	 *
	 * @return the number of salary ranges
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SALARYRANGE);

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
		return "salaryRangeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SALARYRANGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SalaryRangeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the salary range persistence.
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

		_setSalaryRangeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSalaryRangeUtilPersistence(null);

		entityCache.removeCache(SalaryRangeImpl.class.getName());
	}

	private void _setSalaryRangeUtilPersistence(
		SalaryRangePersistence salaryRangePersistence) {

		try {
			Field field = SalaryRangeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, salaryRangePersistence);
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

	private static final String _SQL_SELECT_SALARYRANGE =
		"SELECT salaryRange FROM SalaryRange salaryRange";

	private static final String _SQL_SELECT_SALARYRANGE_WHERE =
		"SELECT salaryRange FROM SalaryRange salaryRange WHERE ";

	private static final String _SQL_COUNT_SALARYRANGE =
		"SELECT COUNT(salaryRange) FROM SalaryRange salaryRange";

	private static final String _SQL_COUNT_SALARYRANGE_WHERE =
		"SELECT COUNT(salaryRange) FROM SalaryRange salaryRange WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "salaryRange.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SalaryRange exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SalaryRange exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SalaryRangePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private SalaryRangeModelArgumentsResolver
		_salaryRangeModelArgumentsResolver;

}