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

package com.interview.info.service.persistence.impl;

import com.interview.info.exception.NoSuchInterviewInfoException;
import com.interview.info.model.InterviewInfo;
import com.interview.info.model.InterviewInfoTable;
import com.interview.info.model.impl.InterviewInfoImpl;
import com.interview.info.model.impl.InterviewInfoModelImpl;
import com.interview.info.service.persistence.InterviewInfoPersistence;
import com.interview.info.service.persistence.InterviewInfoUtil;
import com.interview.info.service.persistence.impl.constants.RMSPersistenceConstants;

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
 * The persistence implementation for the interview info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {InterviewInfoPersistence.class, BasePersistence.class})
public class InterviewInfoPersistenceImpl
	extends BasePersistenceImpl<InterviewInfo>
	implements InterviewInfoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>InterviewInfoUtil</code> to access the interview info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		InterviewInfoImpl.class.getName();

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
	 * Returns all the interview infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching interview infos
	 */
	@Override
	public List<InterviewInfo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interview infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @return the range of matching interview infos
	 */
	@Override
	public List<InterviewInfo> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the interview infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interview infos
	 */
	@Override
	public List<InterviewInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<InterviewInfo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the interview infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching interview infos
	 */
	@Override
	public List<InterviewInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<InterviewInfo> orderByComparator,
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

		List<InterviewInfo> list = null;

		if (useFinderCache) {
			list = (List<InterviewInfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (InterviewInfo interviewInfo : list) {
					if (!uuid.equals(interviewInfo.getUuid())) {
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

			sb.append(_SQL_SELECT_INTERVIEWINFO_WHERE);

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
				sb.append(InterviewInfoModelImpl.ORDER_BY_JPQL);
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

				list = (List<InterviewInfo>)QueryUtil.list(
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
	 * Returns the first interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview info
	 * @throws NoSuchInterviewInfoException if a matching interview info could not be found
	 */
	@Override
	public InterviewInfo findByUuid_First(
			String uuid, OrderByComparator<InterviewInfo> orderByComparator)
		throws NoSuchInterviewInfoException {

		InterviewInfo interviewInfo = fetchByUuid_First(
			uuid, orderByComparator);

		if (interviewInfo != null) {
			return interviewInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchInterviewInfoException(sb.toString());
	}

	/**
	 * Returns the first interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	@Override
	public InterviewInfo fetchByUuid_First(
		String uuid, OrderByComparator<InterviewInfo> orderByComparator) {

		List<InterviewInfo> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview info
	 * @throws NoSuchInterviewInfoException if a matching interview info could not be found
	 */
	@Override
	public InterviewInfo findByUuid_Last(
			String uuid, OrderByComparator<InterviewInfo> orderByComparator)
		throws NoSuchInterviewInfoException {

		InterviewInfo interviewInfo = fetchByUuid_Last(uuid, orderByComparator);

		if (interviewInfo != null) {
			return interviewInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchInterviewInfoException(sb.toString());
	}

	/**
	 * Returns the last interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	@Override
	public InterviewInfo fetchByUuid_Last(
		String uuid, OrderByComparator<InterviewInfo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<InterviewInfo> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the interview infos before and after the current interview info in the ordered set where uuid = &#63;.
	 *
	 * @param interviewId the primary key of the current interview info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview info
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	@Override
	public InterviewInfo[] findByUuid_PrevAndNext(
			long interviewId, String uuid,
			OrderByComparator<InterviewInfo> orderByComparator)
		throws NoSuchInterviewInfoException {

		uuid = Objects.toString(uuid, "");

		InterviewInfo interviewInfo = findByPrimaryKey(interviewId);

		Session session = null;

		try {
			session = openSession();

			InterviewInfo[] array = new InterviewInfoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, interviewInfo, uuid, orderByComparator, true);

			array[1] = interviewInfo;

			array[2] = getByUuid_PrevAndNext(
				session, interviewInfo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected InterviewInfo getByUuid_PrevAndNext(
		Session session, InterviewInfo interviewInfo, String uuid,
		OrderByComparator<InterviewInfo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INTERVIEWINFO_WHERE);

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
			sb.append(InterviewInfoModelImpl.ORDER_BY_JPQL);
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
						interviewInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<InterviewInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the interview infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (InterviewInfo interviewInfo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(interviewInfo);
		}
	}

	/**
	 * Returns the number of interview infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching interview infos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INTERVIEWINFO_WHERE);

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
		"interviewInfo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(interviewInfo.uuid IS NULL OR interviewInfo.uuid = '')";

	private FinderPath _finderPathFetchByDocument;
	private FinderPath _finderPathCountByDocument;

	/**
	 * Returns the interview info where attachmentId = &#63; or throws a <code>NoSuchInterviewInfoException</code> if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching interview info
	 * @throws NoSuchInterviewInfoException if a matching interview info could not be found
	 */
	@Override
	public InterviewInfo findByDocument(long attachmentId)
		throws NoSuchInterviewInfoException {

		InterviewInfo interviewInfo = fetchByDocument(attachmentId);

		if (interviewInfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("attachmentId=");
			sb.append(attachmentId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchInterviewInfoException(sb.toString());
		}

		return interviewInfo;
	}

	/**
	 * Returns the interview info where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	@Override
	public InterviewInfo fetchByDocument(long attachmentId) {
		return fetchByDocument(attachmentId, true);
	}

	/**
	 * Returns the interview info where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	@Override
	public InterviewInfo fetchByDocument(
		long attachmentId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {attachmentId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDocument, finderArgs);
		}

		if (result instanceof InterviewInfo) {
			InterviewInfo interviewInfo = (InterviewInfo)result;

			if (attachmentId != interviewInfo.getAttachmentId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_INTERVIEWINFO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENT_ATTACHMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attachmentId);

				List<InterviewInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDocument, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {attachmentId};
							}

							_log.warn(
								"InterviewInfoPersistenceImpl.fetchByDocument(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					InterviewInfo interviewInfo = list.get(0);

					result = interviewInfo;

					cacheResult(interviewInfo);
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
			return (InterviewInfo)result;
		}
	}

	/**
	 * Removes the interview info where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @return the interview info that was removed
	 */
	@Override
	public InterviewInfo removeByDocument(long attachmentId)
		throws NoSuchInterviewInfoException {

		InterviewInfo interviewInfo = findByDocument(attachmentId);

		return remove(interviewInfo);
	}

	/**
	 * Returns the number of interview infos where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching interview infos
	 */
	@Override
	public int countByDocument(long attachmentId) {
		FinderPath finderPath = _finderPathCountByDocument;

		Object[] finderArgs = new Object[] {attachmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INTERVIEWINFO_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENT_ATTACHMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(attachmentId);

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

	private static final String _FINDER_COLUMN_DOCUMENT_ATTACHMENTID_2 =
		"interviewInfo.attachmentId = ?";

	public InterviewInfoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(InterviewInfo.class);

		setModelImplClass(InterviewInfoImpl.class);
		setModelPKClass(long.class);

		setTable(InterviewInfoTable.INSTANCE);
	}

	/**
	 * Caches the interview info in the entity cache if it is enabled.
	 *
	 * @param interviewInfo the interview info
	 */
	@Override
	public void cacheResult(InterviewInfo interviewInfo) {
		entityCache.putResult(
			InterviewInfoImpl.class, interviewInfo.getPrimaryKey(),
			interviewInfo);

		finderCache.putResult(
			_finderPathFetchByDocument,
			new Object[] {interviewInfo.getAttachmentId()}, interviewInfo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the interview infos in the entity cache if it is enabled.
	 *
	 * @param interviewInfos the interview infos
	 */
	@Override
	public void cacheResult(List<InterviewInfo> interviewInfos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (interviewInfos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (InterviewInfo interviewInfo : interviewInfos) {
			if (entityCache.getResult(
					InterviewInfoImpl.class, interviewInfo.getPrimaryKey()) ==
						null) {

				cacheResult(interviewInfo);
			}
		}
	}

	/**
	 * Clears the cache for all interview infos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InterviewInfoImpl.class);

		finderCache.clearCache(InterviewInfoImpl.class);
	}

	/**
	 * Clears the cache for the interview info.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InterviewInfo interviewInfo) {
		entityCache.removeResult(InterviewInfoImpl.class, interviewInfo);
	}

	@Override
	public void clearCache(List<InterviewInfo> interviewInfos) {
		for (InterviewInfo interviewInfo : interviewInfos) {
			entityCache.removeResult(InterviewInfoImpl.class, interviewInfo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(InterviewInfoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(InterviewInfoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		InterviewInfoModelImpl interviewInfoModelImpl) {

		Object[] args = new Object[] {interviewInfoModelImpl.getAttachmentId()};

		finderCache.putResult(
			_finderPathCountByDocument, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDocument, args, interviewInfoModelImpl);
	}

	/**
	 * Creates a new interview info with the primary key. Does not add the interview info to the database.
	 *
	 * @param interviewId the primary key for the new interview info
	 * @return the new interview info
	 */
	@Override
	public InterviewInfo create(long interviewId) {
		InterviewInfo interviewInfo = new InterviewInfoImpl();

		interviewInfo.setNew(true);
		interviewInfo.setPrimaryKey(interviewId);

		String uuid = PortalUUIDUtil.generate();

		interviewInfo.setUuid(uuid);

		return interviewInfo;
	}

	/**
	 * Removes the interview info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info that was removed
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	@Override
	public InterviewInfo remove(long interviewId)
		throws NoSuchInterviewInfoException {

		return remove((Serializable)interviewId);
	}

	/**
	 * Removes the interview info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the interview info
	 * @return the interview info that was removed
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	@Override
	public InterviewInfo remove(Serializable primaryKey)
		throws NoSuchInterviewInfoException {

		Session session = null;

		try {
			session = openSession();

			InterviewInfo interviewInfo = (InterviewInfo)session.get(
				InterviewInfoImpl.class, primaryKey);

			if (interviewInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInterviewInfoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(interviewInfo);
		}
		catch (NoSuchInterviewInfoException noSuchEntityException) {
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
	protected InterviewInfo removeImpl(InterviewInfo interviewInfo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(interviewInfo)) {
				interviewInfo = (InterviewInfo)session.get(
					InterviewInfoImpl.class, interviewInfo.getPrimaryKeyObj());
			}

			if (interviewInfo != null) {
				session.delete(interviewInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (interviewInfo != null) {
			clearCache(interviewInfo);
		}

		return interviewInfo;
	}

	@Override
	public InterviewInfo updateImpl(InterviewInfo interviewInfo) {
		boolean isNew = interviewInfo.isNew();

		if (!(interviewInfo instanceof InterviewInfoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(interviewInfo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					interviewInfo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in interviewInfo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom InterviewInfo implementation " +
					interviewInfo.getClass());
		}

		InterviewInfoModelImpl interviewInfoModelImpl =
			(InterviewInfoModelImpl)interviewInfo;

		if (Validator.isNull(interviewInfo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			interviewInfo.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(interviewInfo);
			}
			else {
				interviewInfo = (InterviewInfo)session.merge(interviewInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			InterviewInfoImpl.class, interviewInfoModelImpl, false, true);

		cacheUniqueFindersCache(interviewInfoModelImpl);

		if (isNew) {
			interviewInfo.setNew(false);
		}

		interviewInfo.resetOriginalValues();

		return interviewInfo;
	}

	/**
	 * Returns the interview info with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview info
	 * @return the interview info
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	@Override
	public InterviewInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInterviewInfoException {

		InterviewInfo interviewInfo = fetchByPrimaryKey(primaryKey);

		if (interviewInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInterviewInfoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return interviewInfo;
	}

	/**
	 * Returns the interview info with the primary key or throws a <code>NoSuchInterviewInfoException</code> if it could not be found.
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	@Override
	public InterviewInfo findByPrimaryKey(long interviewId)
		throws NoSuchInterviewInfoException {

		return findByPrimaryKey((Serializable)interviewId);
	}

	/**
	 * Returns the interview info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info, or <code>null</code> if a interview info with the primary key could not be found
	 */
	@Override
	public InterviewInfo fetchByPrimaryKey(long interviewId) {
		return fetchByPrimaryKey((Serializable)interviewId);
	}

	/**
	 * Returns all the interview infos.
	 *
	 * @return the interview infos
	 */
	@Override
	public List<InterviewInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interview infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @return the range of interview infos
	 */
	@Override
	public List<InterviewInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the interview infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interview infos
	 */
	@Override
	public List<InterviewInfo> findAll(
		int start, int end,
		OrderByComparator<InterviewInfo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the interview infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of interview infos
	 */
	@Override
	public List<InterviewInfo> findAll(
		int start, int end, OrderByComparator<InterviewInfo> orderByComparator,
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

		List<InterviewInfo> list = null;

		if (useFinderCache) {
			list = (List<InterviewInfo>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INTERVIEWINFO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INTERVIEWINFO;

				sql = sql.concat(InterviewInfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<InterviewInfo>)QueryUtil.list(
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
	 * Removes all the interview infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (InterviewInfo interviewInfo : findAll()) {
			remove(interviewInfo);
		}
	}

	/**
	 * Returns the number of interview infos.
	 *
	 * @return the number of interview infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INTERVIEWINFO);

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
		return "interviewId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INTERVIEWINFO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InterviewInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the interview info persistence.
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

		_finderPathFetchByDocument = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDocument",
			new String[] {Long.class.getName()}, new String[] {"attachmentId"},
			true);

		_finderPathCountByDocument = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocument",
			new String[] {Long.class.getName()}, new String[] {"attachmentId"},
			false);

		_setInterviewInfoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setInterviewInfoUtilPersistence(null);

		entityCache.removeCache(InterviewInfoImpl.class.getName());
	}

	private void _setInterviewInfoUtilPersistence(
		InterviewInfoPersistence interviewInfoPersistence) {

		try {
			Field field = InterviewInfoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, interviewInfoPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = RMSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = RMSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = RMSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_INTERVIEWINFO =
		"SELECT interviewInfo FROM InterviewInfo interviewInfo";

	private static final String _SQL_SELECT_INTERVIEWINFO_WHERE =
		"SELECT interviewInfo FROM InterviewInfo interviewInfo WHERE ";

	private static final String _SQL_COUNT_INTERVIEWINFO =
		"SELECT COUNT(interviewInfo) FROM InterviewInfo interviewInfo";

	private static final String _SQL_COUNT_INTERVIEWINFO_WHERE =
		"SELECT COUNT(interviewInfo) FROM InterviewInfo interviewInfo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "interviewInfo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No InterviewInfo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No InterviewInfo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		InterviewInfoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private InterviewInfoModelArgumentsResolver
		_interviewInfoModelArgumentsResolver;

}