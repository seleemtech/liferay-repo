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

import com.prime.data.service.exception.NoSuchCandidateStatusException;
import com.prime.data.service.model.CandidateStatus;
import com.prime.data.service.model.CandidateStatusTable;
import com.prime.data.service.model.impl.CandidateStatusImpl;
import com.prime.data.service.model.impl.CandidateStatusModelImpl;
import com.prime.data.service.service.persistence.CandidateStatusPersistence;
import com.prime.data.service.service.persistence.CandidateStatusUtil;
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
 * The persistence implementation for the candidate status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {CandidateStatusPersistence.class, BasePersistence.class})
public class CandidateStatusPersistenceImpl
	extends BasePersistenceImpl<CandidateStatus>
	implements CandidateStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CandidateStatusUtil</code> to access the candidate status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CandidateStatusImpl.class.getName();

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
	 * Returns all the candidate statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching candidate statuses
	 */
	@Override
	public List<CandidateStatus> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @return the range of matching candidate statuses
	 */
	@Override
	public List<CandidateStatus> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate statuses
	 */
	@Override
	public List<CandidateStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CandidateStatus> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate statuses
	 */
	@Override
	public List<CandidateStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CandidateStatus> orderByComparator,
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

		List<CandidateStatus> list = null;

		if (useFinderCache) {
			list = (List<CandidateStatus>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateStatus candidateStatus : list) {
					if (!uuid.equals(candidateStatus.getUuid())) {
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

			sb.append(_SQL_SELECT_CANDIDATESTATUS_WHERE);

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
				sb.append(CandidateStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<CandidateStatus>)QueryUtil.list(
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
	 * Returns the first candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate status
	 * @throws NoSuchCandidateStatusException if a matching candidate status could not be found
	 */
	@Override
	public CandidateStatus findByUuid_First(
			String uuid, OrderByComparator<CandidateStatus> orderByComparator)
		throws NoSuchCandidateStatusException {

		CandidateStatus candidateStatus = fetchByUuid_First(
			uuid, orderByComparator);

		if (candidateStatus != null) {
			return candidateStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCandidateStatusException(sb.toString());
	}

	/**
	 * Returns the first candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate status, or <code>null</code> if a matching candidate status could not be found
	 */
	@Override
	public CandidateStatus fetchByUuid_First(
		String uuid, OrderByComparator<CandidateStatus> orderByComparator) {

		List<CandidateStatus> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate status
	 * @throws NoSuchCandidateStatusException if a matching candidate status could not be found
	 */
	@Override
	public CandidateStatus findByUuid_Last(
			String uuid, OrderByComparator<CandidateStatus> orderByComparator)
		throws NoSuchCandidateStatusException {

		CandidateStatus candidateStatus = fetchByUuid_Last(
			uuid, orderByComparator);

		if (candidateStatus != null) {
			return candidateStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCandidateStatusException(sb.toString());
	}

	/**
	 * Returns the last candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate status, or <code>null</code> if a matching candidate status could not be found
	 */
	@Override
	public CandidateStatus fetchByUuid_Last(
		String uuid, OrderByComparator<CandidateStatus> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CandidateStatus> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate statuses before and after the current candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param candidateStatusId the primary key of the current candidate status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate status
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	@Override
	public CandidateStatus[] findByUuid_PrevAndNext(
			long candidateStatusId, String uuid,
			OrderByComparator<CandidateStatus> orderByComparator)
		throws NoSuchCandidateStatusException {

		uuid = Objects.toString(uuid, "");

		CandidateStatus candidateStatus = findByPrimaryKey(candidateStatusId);

		Session session = null;

		try {
			session = openSession();

			CandidateStatus[] array = new CandidateStatusImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, candidateStatus, uuid, orderByComparator, true);

			array[1] = candidateStatus;

			array[2] = getByUuid_PrevAndNext(
				session, candidateStatus, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateStatus getByUuid_PrevAndNext(
		Session session, CandidateStatus candidateStatus, String uuid,
		OrderByComparator<CandidateStatus> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CANDIDATESTATUS_WHERE);

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
			sb.append(CandidateStatusModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						candidateStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CandidateStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CandidateStatus candidateStatus :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(candidateStatus);
		}
	}

	/**
	 * Returns the number of candidate statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching candidate statuses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CANDIDATESTATUS_WHERE);

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
		"candidateStatus.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(candidateStatus.uuid IS NULL OR candidateStatus.uuid = '')";

	public CandidateStatusPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CandidateStatus.class);

		setModelImplClass(CandidateStatusImpl.class);
		setModelPKClass(long.class);

		setTable(CandidateStatusTable.INSTANCE);
	}

	/**
	 * Caches the candidate status in the entity cache if it is enabled.
	 *
	 * @param candidateStatus the candidate status
	 */
	@Override
	public void cacheResult(CandidateStatus candidateStatus) {
		entityCache.putResult(
			CandidateStatusImpl.class, candidateStatus.getPrimaryKey(),
			candidateStatus);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the candidate statuses in the entity cache if it is enabled.
	 *
	 * @param candidateStatuses the candidate statuses
	 */
	@Override
	public void cacheResult(List<CandidateStatus> candidateStatuses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (candidateStatuses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CandidateStatus candidateStatus : candidateStatuses) {
			if (entityCache.getResult(
					CandidateStatusImpl.class,
					candidateStatus.getPrimaryKey()) == null) {

				cacheResult(candidateStatus);
			}
		}
	}

	/**
	 * Clears the cache for all candidate statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CandidateStatusImpl.class);

		finderCache.clearCache(CandidateStatusImpl.class);
	}

	/**
	 * Clears the cache for the candidate status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CandidateStatus candidateStatus) {
		entityCache.removeResult(CandidateStatusImpl.class, candidateStatus);
	}

	@Override
	public void clearCache(List<CandidateStatus> candidateStatuses) {
		for (CandidateStatus candidateStatus : candidateStatuses) {
			entityCache.removeResult(
				CandidateStatusImpl.class, candidateStatus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CandidateStatusImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CandidateStatusImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new candidate status with the primary key. Does not add the candidate status to the database.
	 *
	 * @param candidateStatusId the primary key for the new candidate status
	 * @return the new candidate status
	 */
	@Override
	public CandidateStatus create(long candidateStatusId) {
		CandidateStatus candidateStatus = new CandidateStatusImpl();

		candidateStatus.setNew(true);
		candidateStatus.setPrimaryKey(candidateStatusId);

		String uuid = PortalUUIDUtil.generate();

		candidateStatus.setUuid(uuid);

		return candidateStatus;
	}

	/**
	 * Removes the candidate status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status that was removed
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	@Override
	public CandidateStatus remove(long candidateStatusId)
		throws NoSuchCandidateStatusException {

		return remove((Serializable)candidateStatusId);
	}

	/**
	 * Removes the candidate status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate status
	 * @return the candidate status that was removed
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	@Override
	public CandidateStatus remove(Serializable primaryKey)
		throws NoSuchCandidateStatusException {

		Session session = null;

		try {
			session = openSession();

			CandidateStatus candidateStatus = (CandidateStatus)session.get(
				CandidateStatusImpl.class, primaryKey);

			if (candidateStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidateStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(candidateStatus);
		}
		catch (NoSuchCandidateStatusException noSuchEntityException) {
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
	protected CandidateStatus removeImpl(CandidateStatus candidateStatus) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidateStatus)) {
				candidateStatus = (CandidateStatus)session.get(
					CandidateStatusImpl.class,
					candidateStatus.getPrimaryKeyObj());
			}

			if (candidateStatus != null) {
				session.delete(candidateStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (candidateStatus != null) {
			clearCache(candidateStatus);
		}

		return candidateStatus;
	}

	@Override
	public CandidateStatus updateImpl(CandidateStatus candidateStatus) {
		boolean isNew = candidateStatus.isNew();

		if (!(candidateStatus instanceof CandidateStatusModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(candidateStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					candidateStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in candidateStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CandidateStatus implementation " +
					candidateStatus.getClass());
		}

		CandidateStatusModelImpl candidateStatusModelImpl =
			(CandidateStatusModelImpl)candidateStatus;

		if (Validator.isNull(candidateStatus.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			candidateStatus.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(candidateStatus);
			}
			else {
				candidateStatus = (CandidateStatus)session.merge(
					candidateStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CandidateStatusImpl.class, candidateStatusModelImpl, false, true);

		if (isNew) {
			candidateStatus.setNew(false);
		}

		candidateStatus.resetOriginalValues();

		return candidateStatus;
	}

	/**
	 * Returns the candidate status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate status
	 * @return the candidate status
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	@Override
	public CandidateStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidateStatusException {

		CandidateStatus candidateStatus = fetchByPrimaryKey(primaryKey);

		if (candidateStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidateStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return candidateStatus;
	}

	/**
	 * Returns the candidate status with the primary key or throws a <code>NoSuchCandidateStatusException</code> if it could not be found.
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	@Override
	public CandidateStatus findByPrimaryKey(long candidateStatusId)
		throws NoSuchCandidateStatusException {

		return findByPrimaryKey((Serializable)candidateStatusId);
	}

	/**
	 * Returns the candidate status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status, or <code>null</code> if a candidate status with the primary key could not be found
	 */
	@Override
	public CandidateStatus fetchByPrimaryKey(long candidateStatusId) {
		return fetchByPrimaryKey((Serializable)candidateStatusId);
	}

	/**
	 * Returns all the candidate statuses.
	 *
	 * @return the candidate statuses
	 */
	@Override
	public List<CandidateStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @return the range of candidate statuses
	 */
	@Override
	public List<CandidateStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate statuses
	 */
	@Override
	public List<CandidateStatus> findAll(
		int start, int end,
		OrderByComparator<CandidateStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of candidate statuses
	 */
	@Override
	public List<CandidateStatus> findAll(
		int start, int end,
		OrderByComparator<CandidateStatus> orderByComparator,
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

		List<CandidateStatus> list = null;

		if (useFinderCache) {
			list = (List<CandidateStatus>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CANDIDATESTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATESTATUS;

				sql = sql.concat(CandidateStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CandidateStatus>)QueryUtil.list(
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
	 * Removes all the candidate statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CandidateStatus candidateStatus : findAll()) {
			remove(candidateStatus);
		}
	}

	/**
	 * Returns the number of candidate statuses.
	 *
	 * @return the number of candidate statuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CANDIDATESTATUS);

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
		return "candidateStatusId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CANDIDATESTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CandidateStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the candidate status persistence.
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

		_setCandidateStatusUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCandidateStatusUtilPersistence(null);

		entityCache.removeCache(CandidateStatusImpl.class.getName());
	}

	private void _setCandidateStatusUtilPersistence(
		CandidateStatusPersistence candidateStatusPersistence) {

		try {
			Field field = CandidateStatusUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, candidateStatusPersistence);
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

	private static final String _SQL_SELECT_CANDIDATESTATUS =
		"SELECT candidateStatus FROM CandidateStatus candidateStatus";

	private static final String _SQL_SELECT_CANDIDATESTATUS_WHERE =
		"SELECT candidateStatus FROM CandidateStatus candidateStatus WHERE ";

	private static final String _SQL_COUNT_CANDIDATESTATUS =
		"SELECT COUNT(candidateStatus) FROM CandidateStatus candidateStatus";

	private static final String _SQL_COUNT_CANDIDATESTATUS_WHERE =
		"SELECT COUNT(candidateStatus) FROM CandidateStatus candidateStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "candidateStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CandidateStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CandidateStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CandidateStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CandidateStatusModelArgumentsResolver
		_candidateStatusModelArgumentsResolver;

}