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

import com.prime.data.service.exception.NoSuchHighQualHeldException;
import com.prime.data.service.model.HighQualHeld;
import com.prime.data.service.model.HighQualHeldTable;
import com.prime.data.service.model.impl.HighQualHeldImpl;
import com.prime.data.service.model.impl.HighQualHeldModelImpl;
import com.prime.data.service.service.persistence.HighQualHeldPersistence;
import com.prime.data.service.service.persistence.HighQualHeldUtil;
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
 * The persistence implementation for the high qual held service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {HighQualHeldPersistence.class, BasePersistence.class})
public class HighQualHeldPersistenceImpl
	extends BasePersistenceImpl<HighQualHeld>
	implements HighQualHeldPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HighQualHeldUtil</code> to access the high qual held persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HighQualHeldImpl.class.getName();

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
	 * Returns all the high qual helds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching high qual helds
	 */
	@Override
	public List<HighQualHeld> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the high qual helds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @return the range of matching high qual helds
	 */
	@Override
	public List<HighQualHeld> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the high qual helds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching high qual helds
	 */
	@Override
	public List<HighQualHeld> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<HighQualHeld> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the high qual helds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching high qual helds
	 */
	@Override
	public List<HighQualHeld> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<HighQualHeld> orderByComparator,
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

		List<HighQualHeld> list = null;

		if (useFinderCache) {
			list = (List<HighQualHeld>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (HighQualHeld highQualHeld : list) {
					if (!uuid.equals(highQualHeld.getUuid())) {
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

			sb.append(_SQL_SELECT_HIGHQUALHELD_WHERE);

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
				sb.append(HighQualHeldModelImpl.ORDER_BY_JPQL);
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

				list = (List<HighQualHeld>)QueryUtil.list(
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
	 * Returns the first high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching high qual held
	 * @throws NoSuchHighQualHeldException if a matching high qual held could not be found
	 */
	@Override
	public HighQualHeld findByUuid_First(
			String uuid, OrderByComparator<HighQualHeld> orderByComparator)
		throws NoSuchHighQualHeldException {

		HighQualHeld highQualHeld = fetchByUuid_First(uuid, orderByComparator);

		if (highQualHeld != null) {
			return highQualHeld;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchHighQualHeldException(sb.toString());
	}

	/**
	 * Returns the first high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching high qual held, or <code>null</code> if a matching high qual held could not be found
	 */
	@Override
	public HighQualHeld fetchByUuid_First(
		String uuid, OrderByComparator<HighQualHeld> orderByComparator) {

		List<HighQualHeld> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching high qual held
	 * @throws NoSuchHighQualHeldException if a matching high qual held could not be found
	 */
	@Override
	public HighQualHeld findByUuid_Last(
			String uuid, OrderByComparator<HighQualHeld> orderByComparator)
		throws NoSuchHighQualHeldException {

		HighQualHeld highQualHeld = fetchByUuid_Last(uuid, orderByComparator);

		if (highQualHeld != null) {
			return highQualHeld;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchHighQualHeldException(sb.toString());
	}

	/**
	 * Returns the last high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching high qual held, or <code>null</code> if a matching high qual held could not be found
	 */
	@Override
	public HighQualHeld fetchByUuid_Last(
		String uuid, OrderByComparator<HighQualHeld> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<HighQualHeld> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the high qual helds before and after the current high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param highQualHeldId the primary key of the current high qual held
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next high qual held
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	@Override
	public HighQualHeld[] findByUuid_PrevAndNext(
			long highQualHeldId, String uuid,
			OrderByComparator<HighQualHeld> orderByComparator)
		throws NoSuchHighQualHeldException {

		uuid = Objects.toString(uuid, "");

		HighQualHeld highQualHeld = findByPrimaryKey(highQualHeldId);

		Session session = null;

		try {
			session = openSession();

			HighQualHeld[] array = new HighQualHeldImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, highQualHeld, uuid, orderByComparator, true);

			array[1] = highQualHeld;

			array[2] = getByUuid_PrevAndNext(
				session, highQualHeld, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected HighQualHeld getByUuid_PrevAndNext(
		Session session, HighQualHeld highQualHeld, String uuid,
		OrderByComparator<HighQualHeld> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HIGHQUALHELD_WHERE);

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
			sb.append(HighQualHeldModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(highQualHeld)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<HighQualHeld> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the high qual helds where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (HighQualHeld highQualHeld :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(highQualHeld);
		}
	}

	/**
	 * Returns the number of high qual helds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching high qual helds
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HIGHQUALHELD_WHERE);

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
		"highQualHeld.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(highQualHeld.uuid IS NULL OR highQualHeld.uuid = '')";

	public HighQualHeldPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HighQualHeld.class);

		setModelImplClass(HighQualHeldImpl.class);
		setModelPKClass(long.class);

		setTable(HighQualHeldTable.INSTANCE);
	}

	/**
	 * Caches the high qual held in the entity cache if it is enabled.
	 *
	 * @param highQualHeld the high qual held
	 */
	@Override
	public void cacheResult(HighQualHeld highQualHeld) {
		entityCache.putResult(
			HighQualHeldImpl.class, highQualHeld.getPrimaryKey(), highQualHeld);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the high qual helds in the entity cache if it is enabled.
	 *
	 * @param highQualHelds the high qual helds
	 */
	@Override
	public void cacheResult(List<HighQualHeld> highQualHelds) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (highQualHelds.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HighQualHeld highQualHeld : highQualHelds) {
			if (entityCache.getResult(
					HighQualHeldImpl.class, highQualHeld.getPrimaryKey()) ==
						null) {

				cacheResult(highQualHeld);
			}
		}
	}

	/**
	 * Clears the cache for all high qual helds.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HighQualHeldImpl.class);

		finderCache.clearCache(HighQualHeldImpl.class);
	}

	/**
	 * Clears the cache for the high qual held.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HighQualHeld highQualHeld) {
		entityCache.removeResult(HighQualHeldImpl.class, highQualHeld);
	}

	@Override
	public void clearCache(List<HighQualHeld> highQualHelds) {
		for (HighQualHeld highQualHeld : highQualHelds) {
			entityCache.removeResult(HighQualHeldImpl.class, highQualHeld);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(HighQualHeldImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HighQualHeldImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new high qual held with the primary key. Does not add the high qual held to the database.
	 *
	 * @param highQualHeldId the primary key for the new high qual held
	 * @return the new high qual held
	 */
	@Override
	public HighQualHeld create(long highQualHeldId) {
		HighQualHeld highQualHeld = new HighQualHeldImpl();

		highQualHeld.setNew(true);
		highQualHeld.setPrimaryKey(highQualHeldId);

		String uuid = PortalUUIDUtil.generate();

		highQualHeld.setUuid(uuid);

		return highQualHeld;
	}

	/**
	 * Removes the high qual held with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held that was removed
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	@Override
	public HighQualHeld remove(long highQualHeldId)
		throws NoSuchHighQualHeldException {

		return remove((Serializable)highQualHeldId);
	}

	/**
	 * Removes the high qual held with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the high qual held
	 * @return the high qual held that was removed
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	@Override
	public HighQualHeld remove(Serializable primaryKey)
		throws NoSuchHighQualHeldException {

		Session session = null;

		try {
			session = openSession();

			HighQualHeld highQualHeld = (HighQualHeld)session.get(
				HighQualHeldImpl.class, primaryKey);

			if (highQualHeld == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHighQualHeldException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(highQualHeld);
		}
		catch (NoSuchHighQualHeldException noSuchEntityException) {
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
	protected HighQualHeld removeImpl(HighQualHeld highQualHeld) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(highQualHeld)) {
				highQualHeld = (HighQualHeld)session.get(
					HighQualHeldImpl.class, highQualHeld.getPrimaryKeyObj());
			}

			if (highQualHeld != null) {
				session.delete(highQualHeld);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (highQualHeld != null) {
			clearCache(highQualHeld);
		}

		return highQualHeld;
	}

	@Override
	public HighQualHeld updateImpl(HighQualHeld highQualHeld) {
		boolean isNew = highQualHeld.isNew();

		if (!(highQualHeld instanceof HighQualHeldModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(highQualHeld.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					highQualHeld);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in highQualHeld proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HighQualHeld implementation " +
					highQualHeld.getClass());
		}

		HighQualHeldModelImpl highQualHeldModelImpl =
			(HighQualHeldModelImpl)highQualHeld;

		if (Validator.isNull(highQualHeld.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			highQualHeld.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(highQualHeld);
			}
			else {
				highQualHeld = (HighQualHeld)session.merge(highQualHeld);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			HighQualHeldImpl.class, highQualHeldModelImpl, false, true);

		if (isNew) {
			highQualHeld.setNew(false);
		}

		highQualHeld.resetOriginalValues();

		return highQualHeld;
	}

	/**
	 * Returns the high qual held with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the high qual held
	 * @return the high qual held
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	@Override
	public HighQualHeld findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHighQualHeldException {

		HighQualHeld highQualHeld = fetchByPrimaryKey(primaryKey);

		if (highQualHeld == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHighQualHeldException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return highQualHeld;
	}

	/**
	 * Returns the high qual held with the primary key or throws a <code>NoSuchHighQualHeldException</code> if it could not be found.
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	@Override
	public HighQualHeld findByPrimaryKey(long highQualHeldId)
		throws NoSuchHighQualHeldException {

		return findByPrimaryKey((Serializable)highQualHeldId);
	}

	/**
	 * Returns the high qual held with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held, or <code>null</code> if a high qual held with the primary key could not be found
	 */
	@Override
	public HighQualHeld fetchByPrimaryKey(long highQualHeldId) {
		return fetchByPrimaryKey((Serializable)highQualHeldId);
	}

	/**
	 * Returns all the high qual helds.
	 *
	 * @return the high qual helds
	 */
	@Override
	public List<HighQualHeld> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the high qual helds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @return the range of high qual helds
	 */
	@Override
	public List<HighQualHeld> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the high qual helds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of high qual helds
	 */
	@Override
	public List<HighQualHeld> findAll(
		int start, int end, OrderByComparator<HighQualHeld> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the high qual helds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of high qual helds
	 */
	@Override
	public List<HighQualHeld> findAll(
		int start, int end, OrderByComparator<HighQualHeld> orderByComparator,
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

		List<HighQualHeld> list = null;

		if (useFinderCache) {
			list = (List<HighQualHeld>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HIGHQUALHELD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HIGHQUALHELD;

				sql = sql.concat(HighQualHeldModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HighQualHeld>)QueryUtil.list(
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
	 * Removes all the high qual helds from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HighQualHeld highQualHeld : findAll()) {
			remove(highQualHeld);
		}
	}

	/**
	 * Returns the number of high qual helds.
	 *
	 * @return the number of high qual helds
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HIGHQUALHELD);

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
		return "highQualHeldId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HIGHQUALHELD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HighQualHeldModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the high qual held persistence.
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

		_setHighQualHeldUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setHighQualHeldUtilPersistence(null);

		entityCache.removeCache(HighQualHeldImpl.class.getName());
	}

	private void _setHighQualHeldUtilPersistence(
		HighQualHeldPersistence highQualHeldPersistence) {

		try {
			Field field = HighQualHeldUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, highQualHeldPersistence);
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

	private static final String _SQL_SELECT_HIGHQUALHELD =
		"SELECT highQualHeld FROM HighQualHeld highQualHeld";

	private static final String _SQL_SELECT_HIGHQUALHELD_WHERE =
		"SELECT highQualHeld FROM HighQualHeld highQualHeld WHERE ";

	private static final String _SQL_COUNT_HIGHQUALHELD =
		"SELECT COUNT(highQualHeld) FROM HighQualHeld highQualHeld";

	private static final String _SQL_COUNT_HIGHQUALHELD_WHERE =
		"SELECT COUNT(highQualHeld) FROM HighQualHeld highQualHeld WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "highQualHeld.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HighQualHeld exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No HighQualHeld exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HighQualHeldPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private HighQualHeldModelArgumentsResolver
		_highQualHeldModelArgumentsResolver;

}