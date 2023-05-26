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

import com.job.opening.service.exception.NoSuchDescriptiveinfoException;
import com.job.opening.service.model.Descriptiveinfo;
import com.job.opening.service.model.DescriptiveinfoTable;
import com.job.opening.service.model.impl.DescriptiveinfoImpl;
import com.job.opening.service.model.impl.DescriptiveinfoModelImpl;
import com.job.opening.service.service.persistence.DescriptiveinfoPersistence;
import com.job.opening.service.service.persistence.DescriptiveinfoUtil;
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
 * The persistence implementation for the descriptiveinfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DescriptiveinfoPersistence.class, BasePersistence.class})
public class DescriptiveinfoPersistenceImpl
	extends BasePersistenceImpl<Descriptiveinfo>
	implements DescriptiveinfoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DescriptiveinfoUtil</code> to access the descriptiveinfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DescriptiveinfoImpl.class.getName();

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
	 * Returns all the descriptiveinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching descriptiveinfos
	 */
	@Override
	public List<Descriptiveinfo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the descriptiveinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @return the range of matching descriptiveinfos
	 */
	@Override
	public List<Descriptiveinfo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the descriptiveinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching descriptiveinfos
	 */
	@Override
	public List<Descriptiveinfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Descriptiveinfo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the descriptiveinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching descriptiveinfos
	 */
	@Override
	public List<Descriptiveinfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Descriptiveinfo> orderByComparator,
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

		List<Descriptiveinfo> list = null;

		if (useFinderCache) {
			list = (List<Descriptiveinfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Descriptiveinfo descriptiveinfo : list) {
					if (!uuid.equals(descriptiveinfo.getUuid())) {
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

			sb.append(_SQL_SELECT_DESCRIPTIVEINFO_WHERE);

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
				sb.append(DescriptiveinfoModelImpl.ORDER_BY_JPQL);
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

				list = (List<Descriptiveinfo>)QueryUtil.list(
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
	 * Returns the first descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a matching descriptiveinfo could not be found
	 */
	@Override
	public Descriptiveinfo findByUuid_First(
			String uuid, OrderByComparator<Descriptiveinfo> orderByComparator)
		throws NoSuchDescriptiveinfoException {

		Descriptiveinfo descriptiveinfo = fetchByUuid_First(
			uuid, orderByComparator);

		if (descriptiveinfo != null) {
			return descriptiveinfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDescriptiveinfoException(sb.toString());
	}

	/**
	 * Returns the first descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	@Override
	public Descriptiveinfo fetchByUuid_First(
		String uuid, OrderByComparator<Descriptiveinfo> orderByComparator) {

		List<Descriptiveinfo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a matching descriptiveinfo could not be found
	 */
	@Override
	public Descriptiveinfo findByUuid_Last(
			String uuid, OrderByComparator<Descriptiveinfo> orderByComparator)
		throws NoSuchDescriptiveinfoException {

		Descriptiveinfo descriptiveinfo = fetchByUuid_Last(
			uuid, orderByComparator);

		if (descriptiveinfo != null) {
			return descriptiveinfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDescriptiveinfoException(sb.toString());
	}

	/**
	 * Returns the last descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	@Override
	public Descriptiveinfo fetchByUuid_Last(
		String uuid, OrderByComparator<Descriptiveinfo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Descriptiveinfo> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the descriptiveinfos before and after the current descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param descriptiveId the primary key of the current descriptiveinfo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	@Override
	public Descriptiveinfo[] findByUuid_PrevAndNext(
			long descriptiveId, String uuid,
			OrderByComparator<Descriptiveinfo> orderByComparator)
		throws NoSuchDescriptiveinfoException {

		uuid = Objects.toString(uuid, "");

		Descriptiveinfo descriptiveinfo = findByPrimaryKey(descriptiveId);

		Session session = null;

		try {
			session = openSession();

			Descriptiveinfo[] array = new DescriptiveinfoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, descriptiveinfo, uuid, orderByComparator, true);

			array[1] = descriptiveinfo;

			array[2] = getByUuid_PrevAndNext(
				session, descriptiveinfo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Descriptiveinfo getByUuid_PrevAndNext(
		Session session, Descriptiveinfo descriptiveinfo, String uuid,
		OrderByComparator<Descriptiveinfo> orderByComparator,
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

		sb.append(_SQL_SELECT_DESCRIPTIVEINFO_WHERE);

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
			sb.append(DescriptiveinfoModelImpl.ORDER_BY_JPQL);
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
						descriptiveinfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Descriptiveinfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the descriptiveinfos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Descriptiveinfo descriptiveinfo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(descriptiveinfo);
		}
	}

	/**
	 * Returns the number of descriptiveinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching descriptiveinfos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESCRIPTIVEINFO_WHERE);

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
		"descriptiveinfo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(descriptiveinfo.uuid IS NULL OR descriptiveinfo.uuid = '')";

	private FinderPath _finderPathFetchByjobId;
	private FinderPath _finderPathCountByjobId;

	/**
	 * Returns the descriptiveinfo where jobId = &#63; or throws a <code>NoSuchDescriptiveinfoException</code> if it could not be found.
	 *
	 * @param jobId the job ID
	 * @return the matching descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a matching descriptiveinfo could not be found
	 */
	@Override
	public Descriptiveinfo findByjobId(long jobId)
		throws NoSuchDescriptiveinfoException {

		Descriptiveinfo descriptiveinfo = fetchByjobId(jobId);

		if (descriptiveinfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("jobId=");
			sb.append(jobId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDescriptiveinfoException(sb.toString());
		}

		return descriptiveinfo;
	}

	/**
	 * Returns the descriptiveinfo where jobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param jobId the job ID
	 * @return the matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	@Override
	public Descriptiveinfo fetchByjobId(long jobId) {
		return fetchByjobId(jobId, true);
	}

	/**
	 * Returns the descriptiveinfo where jobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param jobId the job ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	@Override
	public Descriptiveinfo fetchByjobId(long jobId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {jobId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByjobId, finderArgs);
		}

		if (result instanceof Descriptiveinfo) {
			Descriptiveinfo descriptiveinfo = (Descriptiveinfo)result;

			if (jobId != descriptiveinfo.getJobId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DESCRIPTIVEINFO_WHERE);

			sb.append(_FINDER_COLUMN_JOBID_JOBID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(jobId);

				List<Descriptiveinfo> list = query.list();

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
								"DescriptiveinfoPersistenceImpl.fetchByjobId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Descriptiveinfo descriptiveinfo = list.get(0);

					result = descriptiveinfo;

					cacheResult(descriptiveinfo);
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
			return (Descriptiveinfo)result;
		}
	}

	/**
	 * Removes the descriptiveinfo where jobId = &#63; from the database.
	 *
	 * @param jobId the job ID
	 * @return the descriptiveinfo that was removed
	 */
	@Override
	public Descriptiveinfo removeByjobId(long jobId)
		throws NoSuchDescriptiveinfoException {

		Descriptiveinfo descriptiveinfo = findByjobId(jobId);

		return remove(descriptiveinfo);
	}

	/**
	 * Returns the number of descriptiveinfos where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @return the number of matching descriptiveinfos
	 */
	@Override
	public int countByjobId(long jobId) {
		FinderPath finderPath = _finderPathCountByjobId;

		Object[] finderArgs = new Object[] {jobId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESCRIPTIVEINFO_WHERE);

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
		"descriptiveinfo.jobId = ?";

	public DescriptiveinfoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Descriptiveinfo.class);

		setModelImplClass(DescriptiveinfoImpl.class);
		setModelPKClass(long.class);

		setTable(DescriptiveinfoTable.INSTANCE);
	}

	/**
	 * Caches the descriptiveinfo in the entity cache if it is enabled.
	 *
	 * @param descriptiveinfo the descriptiveinfo
	 */
	@Override
	public void cacheResult(Descriptiveinfo descriptiveinfo) {
		entityCache.putResult(
			DescriptiveinfoImpl.class, descriptiveinfo.getPrimaryKey(),
			descriptiveinfo);

		finderCache.putResult(
			_finderPathFetchByjobId, new Object[] {descriptiveinfo.getJobId()},
			descriptiveinfo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the descriptiveinfos in the entity cache if it is enabled.
	 *
	 * @param descriptiveinfos the descriptiveinfos
	 */
	@Override
	public void cacheResult(List<Descriptiveinfo> descriptiveinfos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (descriptiveinfos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Descriptiveinfo descriptiveinfo : descriptiveinfos) {
			if (entityCache.getResult(
					DescriptiveinfoImpl.class,
					descriptiveinfo.getPrimaryKey()) == null) {

				cacheResult(descriptiveinfo);
			}
		}
	}

	/**
	 * Clears the cache for all descriptiveinfos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DescriptiveinfoImpl.class);

		finderCache.clearCache(DescriptiveinfoImpl.class);
	}

	/**
	 * Clears the cache for the descriptiveinfo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Descriptiveinfo descriptiveinfo) {
		entityCache.removeResult(DescriptiveinfoImpl.class, descriptiveinfo);
	}

	@Override
	public void clearCache(List<Descriptiveinfo> descriptiveinfos) {
		for (Descriptiveinfo descriptiveinfo : descriptiveinfos) {
			entityCache.removeResult(
				DescriptiveinfoImpl.class, descriptiveinfo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DescriptiveinfoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DescriptiveinfoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DescriptiveinfoModelImpl descriptiveinfoModelImpl) {

		Object[] args = new Object[] {descriptiveinfoModelImpl.getJobId()};

		finderCache.putResult(_finderPathCountByjobId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByjobId, args, descriptiveinfoModelImpl);
	}

	/**
	 * Creates a new descriptiveinfo with the primary key. Does not add the descriptiveinfo to the database.
	 *
	 * @param descriptiveId the primary key for the new descriptiveinfo
	 * @return the new descriptiveinfo
	 */
	@Override
	public Descriptiveinfo create(long descriptiveId) {
		Descriptiveinfo descriptiveinfo = new DescriptiveinfoImpl();

		descriptiveinfo.setNew(true);
		descriptiveinfo.setPrimaryKey(descriptiveId);

		String uuid = PortalUUIDUtil.generate();

		descriptiveinfo.setUuid(uuid);

		return descriptiveinfo;
	}

	/**
	 * Removes the descriptiveinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo that was removed
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	@Override
	public Descriptiveinfo remove(long descriptiveId)
		throws NoSuchDescriptiveinfoException {

		return remove((Serializable)descriptiveId);
	}

	/**
	 * Removes the descriptiveinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the descriptiveinfo
	 * @return the descriptiveinfo that was removed
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	@Override
	public Descriptiveinfo remove(Serializable primaryKey)
		throws NoSuchDescriptiveinfoException {

		Session session = null;

		try {
			session = openSession();

			Descriptiveinfo descriptiveinfo = (Descriptiveinfo)session.get(
				DescriptiveinfoImpl.class, primaryKey);

			if (descriptiveinfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDescriptiveinfoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(descriptiveinfo);
		}
		catch (NoSuchDescriptiveinfoException noSuchEntityException) {
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
	protected Descriptiveinfo removeImpl(Descriptiveinfo descriptiveinfo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(descriptiveinfo)) {
				descriptiveinfo = (Descriptiveinfo)session.get(
					DescriptiveinfoImpl.class,
					descriptiveinfo.getPrimaryKeyObj());
			}

			if (descriptiveinfo != null) {
				session.delete(descriptiveinfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (descriptiveinfo != null) {
			clearCache(descriptiveinfo);
		}

		return descriptiveinfo;
	}

	@Override
	public Descriptiveinfo updateImpl(Descriptiveinfo descriptiveinfo) {
		boolean isNew = descriptiveinfo.isNew();

		if (!(descriptiveinfo instanceof DescriptiveinfoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(descriptiveinfo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					descriptiveinfo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in descriptiveinfo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Descriptiveinfo implementation " +
					descriptiveinfo.getClass());
		}

		DescriptiveinfoModelImpl descriptiveinfoModelImpl =
			(DescriptiveinfoModelImpl)descriptiveinfo;

		if (Validator.isNull(descriptiveinfo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			descriptiveinfo.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(descriptiveinfo);
			}
			else {
				descriptiveinfo = (Descriptiveinfo)session.merge(
					descriptiveinfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DescriptiveinfoImpl.class, descriptiveinfoModelImpl, false, true);

		cacheUniqueFindersCache(descriptiveinfoModelImpl);

		if (isNew) {
			descriptiveinfo.setNew(false);
		}

		descriptiveinfo.resetOriginalValues();

		return descriptiveinfo;
	}

	/**
	 * Returns the descriptiveinfo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the descriptiveinfo
	 * @return the descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	@Override
	public Descriptiveinfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDescriptiveinfoException {

		Descriptiveinfo descriptiveinfo = fetchByPrimaryKey(primaryKey);

		if (descriptiveinfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDescriptiveinfoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return descriptiveinfo;
	}

	/**
	 * Returns the descriptiveinfo with the primary key or throws a <code>NoSuchDescriptiveinfoException</code> if it could not be found.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	@Override
	public Descriptiveinfo findByPrimaryKey(long descriptiveId)
		throws NoSuchDescriptiveinfoException {

		return findByPrimaryKey((Serializable)descriptiveId);
	}

	/**
	 * Returns the descriptiveinfo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo, or <code>null</code> if a descriptiveinfo with the primary key could not be found
	 */
	@Override
	public Descriptiveinfo fetchByPrimaryKey(long descriptiveId) {
		return fetchByPrimaryKey((Serializable)descriptiveId);
	}

	/**
	 * Returns all the descriptiveinfos.
	 *
	 * @return the descriptiveinfos
	 */
	@Override
	public List<Descriptiveinfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the descriptiveinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @return the range of descriptiveinfos
	 */
	@Override
	public List<Descriptiveinfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the descriptiveinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of descriptiveinfos
	 */
	@Override
	public List<Descriptiveinfo> findAll(
		int start, int end,
		OrderByComparator<Descriptiveinfo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the descriptiveinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of descriptiveinfos
	 */
	@Override
	public List<Descriptiveinfo> findAll(
		int start, int end,
		OrderByComparator<Descriptiveinfo> orderByComparator,
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

		List<Descriptiveinfo> list = null;

		if (useFinderCache) {
			list = (List<Descriptiveinfo>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESCRIPTIVEINFO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESCRIPTIVEINFO;

				sql = sql.concat(DescriptiveinfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Descriptiveinfo>)QueryUtil.list(
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
	 * Removes all the descriptiveinfos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Descriptiveinfo descriptiveinfo : findAll()) {
			remove(descriptiveinfo);
		}
	}

	/**
	 * Returns the number of descriptiveinfos.
	 *
	 * @return the number of descriptiveinfos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESCRIPTIVEINFO);

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
		return "descriptiveId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESCRIPTIVEINFO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DescriptiveinfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the descriptiveinfo persistence.
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

		_setDescriptiveinfoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDescriptiveinfoUtilPersistence(null);

		entityCache.removeCache(DescriptiveinfoImpl.class.getName());
	}

	private void _setDescriptiveinfoUtilPersistence(
		DescriptiveinfoPersistence descriptiveinfoPersistence) {

		try {
			Field field = DescriptiveinfoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, descriptiveinfoPersistence);
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

	private static final String _SQL_SELECT_DESCRIPTIVEINFO =
		"SELECT descriptiveinfo FROM Descriptiveinfo descriptiveinfo";

	private static final String _SQL_SELECT_DESCRIPTIVEINFO_WHERE =
		"SELECT descriptiveinfo FROM Descriptiveinfo descriptiveinfo WHERE ";

	private static final String _SQL_COUNT_DESCRIPTIVEINFO =
		"SELECT COUNT(descriptiveinfo) FROM Descriptiveinfo descriptiveinfo";

	private static final String _SQL_COUNT_DESCRIPTIVEINFO_WHERE =
		"SELECT COUNT(descriptiveinfo) FROM Descriptiveinfo descriptiveinfo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "descriptiveinfo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Descriptiveinfo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Descriptiveinfo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DescriptiveinfoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DescriptiveinfoModelArgumentsResolver
		_descriptiveinfoModelArgumentsResolver;

}