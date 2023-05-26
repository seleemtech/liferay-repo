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

import com.prime.data.service.exception.NoSuchPriorityException;
import com.prime.data.service.model.Priority;
import com.prime.data.service.model.PriorityTable;
import com.prime.data.service.model.impl.PriorityImpl;
import com.prime.data.service.model.impl.PriorityModelImpl;
import com.prime.data.service.service.persistence.PriorityPersistence;
import com.prime.data.service.service.persistence.PriorityUtil;
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
 * The persistence implementation for the priority service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {PriorityPersistence.class, BasePersistence.class})
public class PriorityPersistenceImpl
	extends BasePersistenceImpl<Priority> implements PriorityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PriorityUtil</code> to access the priority persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PriorityImpl.class.getName();

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
	 * Returns all the priorities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching priorities
	 */
	@Override
	public List<Priority> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the priorities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @return the range of matching priorities
	 */
	@Override
	public List<Priority> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the priorities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching priorities
	 */
	@Override
	public List<Priority> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Priority> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the priorities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching priorities
	 */
	@Override
	public List<Priority> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Priority> orderByComparator, boolean useFinderCache) {

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

		List<Priority> list = null;

		if (useFinderCache) {
			list = (List<Priority>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Priority priority : list) {
					if (!uuid.equals(priority.getUuid())) {
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

			sb.append(_SQL_SELECT_PRIORITY_WHERE);

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
				sb.append(PriorityModelImpl.ORDER_BY_JPQL);
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

				list = (List<Priority>)QueryUtil.list(
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
	 * Returns the first priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching priority
	 * @throws NoSuchPriorityException if a matching priority could not be found
	 */
	@Override
	public Priority findByUuid_First(
			String uuid, OrderByComparator<Priority> orderByComparator)
		throws NoSuchPriorityException {

		Priority priority = fetchByUuid_First(uuid, orderByComparator);

		if (priority != null) {
			return priority;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPriorityException(sb.toString());
	}

	/**
	 * Returns the first priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching priority, or <code>null</code> if a matching priority could not be found
	 */
	@Override
	public Priority fetchByUuid_First(
		String uuid, OrderByComparator<Priority> orderByComparator) {

		List<Priority> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching priority
	 * @throws NoSuchPriorityException if a matching priority could not be found
	 */
	@Override
	public Priority findByUuid_Last(
			String uuid, OrderByComparator<Priority> orderByComparator)
		throws NoSuchPriorityException {

		Priority priority = fetchByUuid_Last(uuid, orderByComparator);

		if (priority != null) {
			return priority;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPriorityException(sb.toString());
	}

	/**
	 * Returns the last priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching priority, or <code>null</code> if a matching priority could not be found
	 */
	@Override
	public Priority fetchByUuid_Last(
		String uuid, OrderByComparator<Priority> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Priority> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the priorities before and after the current priority in the ordered set where uuid = &#63;.
	 *
	 * @param priorityId the primary key of the current priority
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next priority
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	@Override
	public Priority[] findByUuid_PrevAndNext(
			long priorityId, String uuid,
			OrderByComparator<Priority> orderByComparator)
		throws NoSuchPriorityException {

		uuid = Objects.toString(uuid, "");

		Priority priority = findByPrimaryKey(priorityId);

		Session session = null;

		try {
			session = openSession();

			Priority[] array = new PriorityImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, priority, uuid, orderByComparator, true);

			array[1] = priority;

			array[2] = getByUuid_PrevAndNext(
				session, priority, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Priority getByUuid_PrevAndNext(
		Session session, Priority priority, String uuid,
		OrderByComparator<Priority> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRIORITY_WHERE);

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
			sb.append(PriorityModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(priority)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Priority> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the priorities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Priority priority :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(priority);
		}
	}

	/**
	 * Returns the number of priorities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching priorities
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRIORITY_WHERE);

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
		"priority.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(priority.uuid IS NULL OR priority.uuid = '')";

	public PriorityPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Priority.class);

		setModelImplClass(PriorityImpl.class);
		setModelPKClass(long.class);

		setTable(PriorityTable.INSTANCE);
	}

	/**
	 * Caches the priority in the entity cache if it is enabled.
	 *
	 * @param priority the priority
	 */
	@Override
	public void cacheResult(Priority priority) {
		entityCache.putResult(
			PriorityImpl.class, priority.getPrimaryKey(), priority);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the priorities in the entity cache if it is enabled.
	 *
	 * @param priorities the priorities
	 */
	@Override
	public void cacheResult(List<Priority> priorities) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (priorities.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Priority priority : priorities) {
			if (entityCache.getResult(
					PriorityImpl.class, priority.getPrimaryKey()) == null) {

				cacheResult(priority);
			}
		}
	}

	/**
	 * Clears the cache for all priorities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PriorityImpl.class);

		finderCache.clearCache(PriorityImpl.class);
	}

	/**
	 * Clears the cache for the priority.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Priority priority) {
		entityCache.removeResult(PriorityImpl.class, priority);
	}

	@Override
	public void clearCache(List<Priority> priorities) {
		for (Priority priority : priorities) {
			entityCache.removeResult(PriorityImpl.class, priority);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PriorityImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PriorityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new priority with the primary key. Does not add the priority to the database.
	 *
	 * @param priorityId the primary key for the new priority
	 * @return the new priority
	 */
	@Override
	public Priority create(long priorityId) {
		Priority priority = new PriorityImpl();

		priority.setNew(true);
		priority.setPrimaryKey(priorityId);

		String uuid = PortalUUIDUtil.generate();

		priority.setUuid(uuid);

		return priority;
	}

	/**
	 * Removes the priority with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param priorityId the primary key of the priority
	 * @return the priority that was removed
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	@Override
	public Priority remove(long priorityId) throws NoSuchPriorityException {
		return remove((Serializable)priorityId);
	}

	/**
	 * Removes the priority with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the priority
	 * @return the priority that was removed
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	@Override
	public Priority remove(Serializable primaryKey)
		throws NoSuchPriorityException {

		Session session = null;

		try {
			session = openSession();

			Priority priority = (Priority)session.get(
				PriorityImpl.class, primaryKey);

			if (priority == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPriorityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(priority);
		}
		catch (NoSuchPriorityException noSuchEntityException) {
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
	protected Priority removeImpl(Priority priority) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(priority)) {
				priority = (Priority)session.get(
					PriorityImpl.class, priority.getPrimaryKeyObj());
			}

			if (priority != null) {
				session.delete(priority);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (priority != null) {
			clearCache(priority);
		}

		return priority;
	}

	@Override
	public Priority updateImpl(Priority priority) {
		boolean isNew = priority.isNew();

		if (!(priority instanceof PriorityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(priority.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(priority);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in priority proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Priority implementation " +
					priority.getClass());
		}

		PriorityModelImpl priorityModelImpl = (PriorityModelImpl)priority;

		if (Validator.isNull(priority.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			priority.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(priority);
			}
			else {
				priority = (Priority)session.merge(priority);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PriorityImpl.class, priorityModelImpl, false, true);

		if (isNew) {
			priority.setNew(false);
		}

		priority.resetOriginalValues();

		return priority;
	}

	/**
	 * Returns the priority with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the priority
	 * @return the priority
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	@Override
	public Priority findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPriorityException {

		Priority priority = fetchByPrimaryKey(primaryKey);

		if (priority == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPriorityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return priority;
	}

	/**
	 * Returns the priority with the primary key or throws a <code>NoSuchPriorityException</code> if it could not be found.
	 *
	 * @param priorityId the primary key of the priority
	 * @return the priority
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	@Override
	public Priority findByPrimaryKey(long priorityId)
		throws NoSuchPriorityException {

		return findByPrimaryKey((Serializable)priorityId);
	}

	/**
	 * Returns the priority with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param priorityId the primary key of the priority
	 * @return the priority, or <code>null</code> if a priority with the primary key could not be found
	 */
	@Override
	public Priority fetchByPrimaryKey(long priorityId) {
		return fetchByPrimaryKey((Serializable)priorityId);
	}

	/**
	 * Returns all the priorities.
	 *
	 * @return the priorities
	 */
	@Override
	public List<Priority> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @return the range of priorities
	 */
	@Override
	public List<Priority> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of priorities
	 */
	@Override
	public List<Priority> findAll(
		int start, int end, OrderByComparator<Priority> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of priorities
	 */
	@Override
	public List<Priority> findAll(
		int start, int end, OrderByComparator<Priority> orderByComparator,
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

		List<Priority> list = null;

		if (useFinderCache) {
			list = (List<Priority>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRIORITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRIORITY;

				sql = sql.concat(PriorityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Priority>)QueryUtil.list(
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
	 * Removes all the priorities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Priority priority : findAll()) {
			remove(priority);
		}
	}

	/**
	 * Returns the number of priorities.
	 *
	 * @return the number of priorities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRIORITY);

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
		return "priorityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRIORITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PriorityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the priority persistence.
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

		_setPriorityUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPriorityUtilPersistence(null);

		entityCache.removeCache(PriorityImpl.class.getName());
	}

	private void _setPriorityUtilPersistence(
		PriorityPersistence priorityPersistence) {

		try {
			Field field = PriorityUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, priorityPersistence);
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

	private static final String _SQL_SELECT_PRIORITY =
		"SELECT priority FROM Priority priority";

	private static final String _SQL_SELECT_PRIORITY_WHERE =
		"SELECT priority FROM Priority priority WHERE ";

	private static final String _SQL_COUNT_PRIORITY =
		"SELECT COUNT(priority) FROM Priority priority";

	private static final String _SQL_COUNT_PRIORITY_WHERE =
		"SELECT COUNT(priority) FROM Priority priority WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "priority.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Priority exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Priority exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PriorityPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PriorityModelArgumentsResolver _priorityModelArgumentsResolver;

}