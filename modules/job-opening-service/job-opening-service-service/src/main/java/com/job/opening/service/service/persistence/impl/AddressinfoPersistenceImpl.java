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

package com.job.opening.service.service.persistence.impl;

import com.job.opening.service.exception.NoSuchAddressinfoException;
import com.job.opening.service.model.Addressinfo;
import com.job.opening.service.model.AddressinfoTable;
import com.job.opening.service.model.impl.AddressinfoImpl;
import com.job.opening.service.model.impl.AddressinfoModelImpl;
import com.job.opening.service.service.persistence.AddressinfoPersistence;
import com.job.opening.service.service.persistence.AddressinfoUtil;
import com.job.opening.service.service.persistence.impl.constants.rmsPersistenceConstants;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the addressinfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {AddressinfoPersistence.class, BasePersistence.class})
public class AddressinfoPersistenceImpl
	extends BasePersistenceImpl<Addressinfo> implements AddressinfoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AddressinfoUtil</code> to access the addressinfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AddressinfoImpl.class.getName();

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
	 * Returns all the addressinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching addressinfos
	 */
	@Override
	public List<Addressinfo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addressinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @return the range of matching addressinfos
	 */
	@Override
	public List<Addressinfo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the addressinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addressinfos
	 */
	@Override
	public List<Addressinfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Addressinfo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addressinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addressinfos
	 */
	@Override
	public List<Addressinfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Addressinfo> orderByComparator,
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

		List<Addressinfo> list = null;

		if (useFinderCache) {
			list = (List<Addressinfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Addressinfo addressinfo : list) {
					if (!uuid.equals(addressinfo.getUuid())) {
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

			sb.append(_SQL_SELECT_ADDRESSINFO_WHERE);

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
				sb.append(AddressinfoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Addressinfo>)QueryUtil.list(
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
	 * Returns the first addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addressinfo
	 * @throws NoSuchAddressinfoException if a matching addressinfo could not be found
	 */
	@Override
	public Addressinfo findByUuid_First(
			String uuid, OrderByComparator<Addressinfo> orderByComparator)
		throws NoSuchAddressinfoException {

		Addressinfo addressinfo = fetchByUuid_First(uuid, orderByComparator);

		if (addressinfo != null) {
			return addressinfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAddressinfoException(sb.toString());
	}

	/**
	 * Returns the first addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	@Override
	public Addressinfo fetchByUuid_First(
		String uuid, OrderByComparator<Addressinfo> orderByComparator) {

		List<Addressinfo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addressinfo
	 * @throws NoSuchAddressinfoException if a matching addressinfo could not be found
	 */
	@Override
	public Addressinfo findByUuid_Last(
			String uuid, OrderByComparator<Addressinfo> orderByComparator)
		throws NoSuchAddressinfoException {

		Addressinfo addressinfo = fetchByUuid_Last(uuid, orderByComparator);

		if (addressinfo != null) {
			return addressinfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAddressinfoException(sb.toString());
	}

	/**
	 * Returns the last addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	@Override
	public Addressinfo fetchByUuid_Last(
		String uuid, OrderByComparator<Addressinfo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Addressinfo> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the addressinfos before and after the current addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param addressId the primary key of the current addressinfo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next addressinfo
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	@Override
	public Addressinfo[] findByUuid_PrevAndNext(
			long addressId, String uuid,
			OrderByComparator<Addressinfo> orderByComparator)
		throws NoSuchAddressinfoException {

		uuid = Objects.toString(uuid, "");

		Addressinfo addressinfo = findByPrimaryKey(addressId);

		Session session = null;

		try {
			session = openSession();

			Addressinfo[] array = new AddressinfoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, addressinfo, uuid, orderByComparator, true);

			array[1] = addressinfo;

			array[2] = getByUuid_PrevAndNext(
				session, addressinfo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Addressinfo getByUuid_PrevAndNext(
		Session session, Addressinfo addressinfo, String uuid,
		OrderByComparator<Addressinfo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ADDRESSINFO_WHERE);

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
			sb.append(AddressinfoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(addressinfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Addressinfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the addressinfos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Addressinfo addressinfo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(addressinfo);
		}
	}

	/**
	 * Returns the number of addressinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching addressinfos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ADDRESSINFO_WHERE);

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
		"addressinfo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(addressinfo.uuid IS NULL OR addressinfo.uuid = '')";

	private FinderPath _finderPathFetchByjobId;
	private FinderPath _finderPathCountByjobId;

	/**
	 * Returns the addressinfo where jobId = &#63; or throws a <code>NoSuchAddressinfoException</code> if it could not be found.
	 *
	 * @param jobId the job ID
	 * @return the matching addressinfo
	 * @throws NoSuchAddressinfoException if a matching addressinfo could not be found
	 */
	@Override
	public Addressinfo findByjobId(long jobId)
		throws NoSuchAddressinfoException {

		Addressinfo addressinfo = fetchByjobId(jobId);

		if (addressinfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("jobId=");
			sb.append(jobId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAddressinfoException(sb.toString());
		}

		return addressinfo;
	}

	/**
	 * Returns the addressinfo where jobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param jobId the job ID
	 * @return the matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	@Override
	public Addressinfo fetchByjobId(long jobId) {
		return fetchByjobId(jobId, true);
	}

	/**
	 * Returns the addressinfo where jobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param jobId the job ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	@Override
	public Addressinfo fetchByjobId(long jobId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {jobId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByjobId, finderArgs);
		}

		if (result instanceof Addressinfo) {
			Addressinfo addressinfo = (Addressinfo)result;

			if (jobId != addressinfo.getJobId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ADDRESSINFO_WHERE);

			sb.append(_FINDER_COLUMN_JOBID_JOBID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(jobId);

				List<Addressinfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByjobId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {jobId};
							}

							_log.warn(
								"AddressinfoPersistenceImpl.fetchByjobId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Addressinfo addressinfo = list.get(0);

					result = addressinfo;

					cacheResult(addressinfo);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Addressinfo)result;
		}
	}

	/**
	 * Removes the addressinfo where jobId = &#63; from the database.
	 *
	 * @param jobId the job ID
	 * @return the addressinfo that was removed
	 */
	@Override
	public Addressinfo removeByjobId(long jobId)
		throws NoSuchAddressinfoException {

		Addressinfo addressinfo = findByjobId(jobId);

		return remove(addressinfo);
	}

	/**
	 * Returns the number of addressinfos where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @return the number of matching addressinfos
	 */
	@Override
	public int countByjobId(long jobId) {
		FinderPath finderPath = _finderPathCountByjobId;

		Object[] finderArgs = new Object[] {jobId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ADDRESSINFO_WHERE);

			sb.append(_FINDER_COLUMN_JOBID_JOBID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(jobId);

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

	private static final String _FINDER_COLUMN_JOBID_JOBID_2 =
		"addressinfo.jobId = ?";

	public AddressinfoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("state", "state_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Addressinfo.class);

		setModelImplClass(AddressinfoImpl.class);
		setModelPKClass(long.class);

		setTable(AddressinfoTable.INSTANCE);
	}

	/**
	 * Caches the addressinfo in the entity cache if it is enabled.
	 *
	 * @param addressinfo the addressinfo
	 */
	@Override
	public void cacheResult(Addressinfo addressinfo) {
		entityCache.putResult(
			AddressinfoImpl.class, addressinfo.getPrimaryKey(), addressinfo);

		finderCache.putResult(
			_finderPathFetchByjobId, new Object[] {addressinfo.getJobId()},
			addressinfo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the addressinfos in the entity cache if it is enabled.
	 *
	 * @param addressinfos the addressinfos
	 */
	@Override
	public void cacheResult(List<Addressinfo> addressinfos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (addressinfos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Addressinfo addressinfo : addressinfos) {
			if (entityCache.getResult(
					AddressinfoImpl.class, addressinfo.getPrimaryKey()) ==
						null) {

				cacheResult(addressinfo);
			}
		}
	}

	/**
	 * Clears the cache for all addressinfos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AddressinfoImpl.class);

		finderCache.clearCache(AddressinfoImpl.class);
	}

	/**
	 * Clears the cache for the addressinfo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Addressinfo addressinfo) {
		entityCache.removeResult(AddressinfoImpl.class, addressinfo);
	}

	@Override
	public void clearCache(List<Addressinfo> addressinfos) {
		for (Addressinfo addressinfo : addressinfos) {
			entityCache.removeResult(AddressinfoImpl.class, addressinfo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AddressinfoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AddressinfoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AddressinfoModelImpl addressinfoModelImpl) {

		Object[] args = new Object[] {addressinfoModelImpl.getJobId()};

		finderCache.putResult(_finderPathCountByjobId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByjobId, args, addressinfoModelImpl);
	}

	/**
	 * Creates a new addressinfo with the primary key. Does not add the addressinfo to the database.
	 *
	 * @param addressId the primary key for the new addressinfo
	 * @return the new addressinfo
	 */
	@Override
	public Addressinfo create(long addressId) {
		Addressinfo addressinfo = new AddressinfoImpl();

		addressinfo.setNew(true);
		addressinfo.setPrimaryKey(addressId);

		String uuid = PortalUUIDUtil.generate();

		addressinfo.setUuid(uuid);

		return addressinfo;
	}

	/**
	 * Removes the addressinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo that was removed
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	@Override
	public Addressinfo remove(long addressId)
		throws NoSuchAddressinfoException {

		return remove((Serializable)addressId);
	}

	/**
	 * Removes the addressinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the addressinfo
	 * @return the addressinfo that was removed
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	@Override
	public Addressinfo remove(Serializable primaryKey)
		throws NoSuchAddressinfoException {

		Session session = null;

		try {
			session = openSession();

			Addressinfo addressinfo = (Addressinfo)session.get(
				AddressinfoImpl.class, primaryKey);

			if (addressinfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAddressinfoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(addressinfo);
		}
		catch (NoSuchAddressinfoException noSuchEntityException) {
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
	protected Addressinfo removeImpl(Addressinfo addressinfo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(addressinfo)) {
				addressinfo = (Addressinfo)session.get(
					AddressinfoImpl.class, addressinfo.getPrimaryKeyObj());
			}

			if (addressinfo != null) {
				session.delete(addressinfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (addressinfo != null) {
			clearCache(addressinfo);
		}

		return addressinfo;
	}

	@Override
	public Addressinfo updateImpl(Addressinfo addressinfo) {
		boolean isNew = addressinfo.isNew();

		if (!(addressinfo instanceof AddressinfoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(addressinfo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(addressinfo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in addressinfo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Addressinfo implementation " +
					addressinfo.getClass());
		}

		AddressinfoModelImpl addressinfoModelImpl =
			(AddressinfoModelImpl)addressinfo;

		if (Validator.isNull(addressinfo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			addressinfo.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(addressinfo);
			}
			else {
				addressinfo = (Addressinfo)session.merge(addressinfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AddressinfoImpl.class, addressinfoModelImpl, false, true);

		cacheUniqueFindersCache(addressinfoModelImpl);

		if (isNew) {
			addressinfo.setNew(false);
		}

		addressinfo.resetOriginalValues();

		return addressinfo;
	}

	/**
	 * Returns the addressinfo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the addressinfo
	 * @return the addressinfo
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	@Override
	public Addressinfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAddressinfoException {

		Addressinfo addressinfo = fetchByPrimaryKey(primaryKey);

		if (addressinfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAddressinfoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return addressinfo;
	}

	/**
	 * Returns the addressinfo with the primary key or throws a <code>NoSuchAddressinfoException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	@Override
	public Addressinfo findByPrimaryKey(long addressId)
		throws NoSuchAddressinfoException {

		return findByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns the addressinfo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo, or <code>null</code> if a addressinfo with the primary key could not be found
	 */
	@Override
	public Addressinfo fetchByPrimaryKey(long addressId) {
		return fetchByPrimaryKey((Serializable)addressId);
	}

	/**
	 * Returns all the addressinfos.
	 *
	 * @return the addressinfos
	 */
	@Override
	public List<Addressinfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the addressinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @return the range of addressinfos
	 */
	@Override
	public List<Addressinfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the addressinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addressinfos
	 */
	@Override
	public List<Addressinfo> findAll(
		int start, int end, OrderByComparator<Addressinfo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the addressinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of addressinfos
	 */
	@Override
	public List<Addressinfo> findAll(
		int start, int end, OrderByComparator<Addressinfo> orderByComparator,
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

		List<Addressinfo> list = null;

		if (useFinderCache) {
			list = (List<Addressinfo>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ADDRESSINFO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ADDRESSINFO;

				sql = sql.concat(AddressinfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Addressinfo>)QueryUtil.list(
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
	 * Removes all the addressinfos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Addressinfo addressinfo : findAll()) {
			remove(addressinfo);
		}
	}

	/**
	 * Returns the number of addressinfos.
	 *
	 * @return the number of addressinfos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ADDRESSINFO);

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
		return "addressId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ADDRESSINFO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AddressinfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the addressinfo persistence.
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

		_finderPathFetchByjobId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByjobId",
			new String[] {Long.class.getName()}, new String[] {"jobId"}, true);

		_finderPathCountByjobId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByjobId",
			new String[] {Long.class.getName()}, new String[] {"jobId"}, false);

		_setAddressinfoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAddressinfoUtilPersistence(null);

		entityCache.removeCache(AddressinfoImpl.class.getName());
	}

	private void _setAddressinfoUtilPersistence(
		AddressinfoPersistence addressinfoPersistence) {

		try {
			Field field = AddressinfoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, addressinfoPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = rmsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = rmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = rmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ADDRESSINFO =
		"SELECT addressinfo FROM Addressinfo addressinfo";

	private static final String _SQL_SELECT_ADDRESSINFO_WHERE =
		"SELECT addressinfo FROM Addressinfo addressinfo WHERE ";

	private static final String _SQL_COUNT_ADDRESSINFO =
		"SELECT COUNT(addressinfo) FROM Addressinfo addressinfo";

	private static final String _SQL_COUNT_ADDRESSINFO_WHERE =
		"SELECT COUNT(addressinfo) FROM Addressinfo addressinfo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "addressinfo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Addressinfo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Addressinfo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AddressinfoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "state"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AddressinfoModelArgumentsResolver
		_addressinfoModelArgumentsResolver;

}