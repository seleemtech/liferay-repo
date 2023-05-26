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

package com.candidate.service.service.persistence.impl;

import com.candidate.service.exception.NoSuchCandidateOtherInfoException;
import com.candidate.service.model.CandidateOtherInfo;
import com.candidate.service.model.CandidateOtherInfoTable;
import com.candidate.service.model.impl.CandidateOtherInfoImpl;
import com.candidate.service.model.impl.CandidateOtherInfoModelImpl;
import com.candidate.service.service.persistence.CandidateOtherInfoPersistence;
import com.candidate.service.service.persistence.CandidateOtherInfoUtil;
import com.candidate.service.service.persistence.impl.constants.RMSPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
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
 * The persistence implementation for the candidate other info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {CandidateOtherInfoPersistence.class, BasePersistence.class}
)
public class CandidateOtherInfoPersistenceImpl
	extends BasePersistenceImpl<CandidateOtherInfo>
	implements CandidateOtherInfoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CandidateOtherInfoUtil</code> to access the candidate other info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CandidateOtherInfoImpl.class.getName();

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
	 * Returns all the candidate other infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate other infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
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

		List<CandidateOtherInfo> list = null;

		if (useFinderCache) {
			list = (List<CandidateOtherInfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateOtherInfo candidateOtherInfo : list) {
					if (!uuid.equals(candidateOtherInfo.getUuid())) {
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

			sb.append(_SQL_SELECT_CANDIDATEOTHERINFO_WHERE);

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
				sb.append(CandidateOtherInfoModelImpl.ORDER_BY_JPQL);
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

				list = (List<CandidateOtherInfo>)QueryUtil.list(
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
	 * Returns the first candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo findByUuid_First(
			String uuid,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByUuid_First(
			uuid, orderByComparator);

		if (candidateOtherInfo != null) {
			return candidateOtherInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCandidateOtherInfoException(sb.toString());
	}

	/**
	 * Returns the first candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByUuid_First(
		String uuid, OrderByComparator<CandidateOtherInfo> orderByComparator) {

		List<CandidateOtherInfo> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo findByUuid_Last(
			String uuid,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByUuid_Last(
			uuid, orderByComparator);

		if (candidateOtherInfo != null) {
			return candidateOtherInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCandidateOtherInfoException(sb.toString());
	}

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByUuid_Last(
		String uuid, OrderByComparator<CandidateOtherInfo> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CandidateOtherInfo> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	@Override
	public CandidateOtherInfo[] findByUuid_PrevAndNext(
			long candidateOtherInfoId, String uuid,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		uuid = Objects.toString(uuid, "");

		CandidateOtherInfo candidateOtherInfo = findByPrimaryKey(
			candidateOtherInfoId);

		Session session = null;

		try {
			session = openSession();

			CandidateOtherInfo[] array = new CandidateOtherInfoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, candidateOtherInfo, uuid, orderByComparator, true);

			array[1] = candidateOtherInfo;

			array[2] = getByUuid_PrevAndNext(
				session, candidateOtherInfo, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateOtherInfo getByUuid_PrevAndNext(
		Session session, CandidateOtherInfo candidateOtherInfo, String uuid,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
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

		sb.append(_SQL_SELECT_CANDIDATEOTHERINFO_WHERE);

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
			sb.append(CandidateOtherInfoModelImpl.ORDER_BY_JPQL);
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
						candidateOtherInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CandidateOtherInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate other infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CandidateOtherInfo candidateOtherInfo :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(candidateOtherInfo);
		}
	}

	/**
	 * Returns the number of candidate other infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching candidate other infos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CANDIDATEOTHERINFO_WHERE);

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
		"candidateOtherInfo.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(candidateOtherInfo.uuid IS NULL OR candidateOtherInfo.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CandidateOtherInfo> list = null;

		if (useFinderCache) {
			list = (List<CandidateOtherInfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateOtherInfo candidateOtherInfo : list) {
					if (!uuid.equals(candidateOtherInfo.getUuid()) ||
						(companyId != candidateOtherInfo.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CANDIDATEOTHERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CandidateOtherInfoModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<CandidateOtherInfo>)QueryUtil.list(
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
	 * Returns the first candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (candidateOtherInfo != null) {
			return candidateOtherInfo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCandidateOtherInfoException(sb.toString());
	}

	/**
	 * Returns the first candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		List<CandidateOtherInfo> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (candidateOtherInfo != null) {
			return candidateOtherInfo;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCandidateOtherInfoException(sb.toString());
	}

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CandidateOtherInfo> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	@Override
	public CandidateOtherInfo[] findByUuid_C_PrevAndNext(
			long candidateOtherInfoId, String uuid, long companyId,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		uuid = Objects.toString(uuid, "");

		CandidateOtherInfo candidateOtherInfo = findByPrimaryKey(
			candidateOtherInfoId);

		Session session = null;

		try {
			session = openSession();

			CandidateOtherInfo[] array = new CandidateOtherInfoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, candidateOtherInfo, uuid, companyId, orderByComparator,
				true);

			array[1] = candidateOtherInfo;

			array[2] = getByUuid_C_PrevAndNext(
				session, candidateOtherInfo, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateOtherInfo getByUuid_C_PrevAndNext(
		Session session, CandidateOtherInfo candidateOtherInfo, String uuid,
		long companyId, OrderByComparator<CandidateOtherInfo> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CANDIDATEOTHERINFO_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(CandidateOtherInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						candidateOtherInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CandidateOtherInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate other infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CandidateOtherInfo candidateOtherInfo :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(candidateOtherInfo);
		}
	}

	/**
	 * Returns the number of candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching candidate other infos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CANDIDATEOTHERINFO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"candidateOtherInfo.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(candidateOtherInfo.uuid IS NULL OR candidateOtherInfo.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"candidateOtherInfo.companyId = ?";

	private FinderPath _finderPathFetchByCandidateId;
	private FinderPath _finderPathCountByCandidateId;

	/**
	 * Returns the candidate other info where candidateId = &#63; or throws a <code>NoSuchCandidateOtherInfoException</code> if it could not be found.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo findByCandidateId(long candidateId)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByCandidateId(candidateId);

		if (candidateOtherInfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("candidateId=");
			sb.append(candidateId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCandidateOtherInfoException(sb.toString());
		}

		return candidateOtherInfo;
	}

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByCandidateId(long candidateId) {
		return fetchByCandidateId(candidateId, true);
	}

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByCandidateId(
		long candidateId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {candidateId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCandidateId, finderArgs);
		}

		if (result instanceof CandidateOtherInfo) {
			CandidateOtherInfo candidateOtherInfo = (CandidateOtherInfo)result;

			if (candidateId != candidateOtherInfo.getCandidateId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CANDIDATEOTHERINFO_WHERE);

			sb.append(_FINDER_COLUMN_CANDIDATEID_CANDIDATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(candidateId);

				List<CandidateOtherInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCandidateId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {candidateId};
							}

							_log.warn(
								"CandidateOtherInfoPersistenceImpl.fetchByCandidateId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CandidateOtherInfo candidateOtherInfo = list.get(0);

					result = candidateOtherInfo;

					cacheResult(candidateOtherInfo);
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
			return (CandidateOtherInfo)result;
		}
	}

	/**
	 * Removes the candidate other info where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @return the candidate other info that was removed
	 */
	@Override
	public CandidateOtherInfo removeByCandidateId(long candidateId)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = findByCandidateId(candidateId);

		return remove(candidateOtherInfo);
	}

	/**
	 * Returns the number of candidate other infos where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching candidate other infos
	 */
	@Override
	public int countByCandidateId(long candidateId) {
		FinderPath finderPath = _finderPathCountByCandidateId;

		Object[] finderArgs = new Object[] {candidateId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CANDIDATEOTHERINFO_WHERE);

			sb.append(_FINDER_COLUMN_CANDIDATEID_CANDIDATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(candidateId);

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

	private static final String _FINDER_COLUMN_CANDIDATEID_CANDIDATEID_2 =
		"candidateOtherInfo.candidateId = ?";

	private FinderPath _finderPathFetchByCandidatesId;
	private FinderPath _finderPathCountByCandidatesId;

	/**
	 * Returns the candidate other info where candidateId = &#63; or throws a <code>NoSuchCandidateOtherInfoException</code> if it could not be found.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo findByCandidatesId(long candidateId)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByCandidatesId(
			candidateId);

		if (candidateOtherInfo == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("candidateId=");
			sb.append(candidateId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCandidateOtherInfoException(sb.toString());
		}

		return candidateOtherInfo;
	}

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByCandidatesId(long candidateId) {
		return fetchByCandidatesId(candidateId, true);
	}

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByCandidatesId(
		long candidateId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {candidateId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCandidatesId, finderArgs);
		}

		if (result instanceof CandidateOtherInfo) {
			CandidateOtherInfo candidateOtherInfo = (CandidateOtherInfo)result;

			if (candidateId != candidateOtherInfo.getCandidateId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CANDIDATEOTHERINFO_WHERE);

			sb.append(_FINDER_COLUMN_CANDIDATESID_CANDIDATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(candidateId);

				List<CandidateOtherInfo> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCandidatesId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {candidateId};
							}

							_log.warn(
								"CandidateOtherInfoPersistenceImpl.fetchByCandidatesId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CandidateOtherInfo candidateOtherInfo = list.get(0);

					result = candidateOtherInfo;

					cacheResult(candidateOtherInfo);
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
			return (CandidateOtherInfo)result;
		}
	}

	/**
	 * Removes the candidate other info where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @return the candidate other info that was removed
	 */
	@Override
	public CandidateOtherInfo removeByCandidatesId(long candidateId)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = findByCandidatesId(candidateId);

		return remove(candidateOtherInfo);
	}

	/**
	 * Returns the number of candidate other infos where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching candidate other infos
	 */
	@Override
	public int countByCandidatesId(long candidateId) {
		FinderPath finderPath = _finderPathCountByCandidatesId;

		Object[] finderArgs = new Object[] {candidateId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CANDIDATEOTHERINFO_WHERE);

			sb.append(_FINDER_COLUMN_CANDIDATESID_CANDIDATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(candidateId);

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

	private static final String _FINDER_COLUMN_CANDIDATESID_CANDIDATEID_2 =
		"candidateOtherInfo.candidateId = ?";

	private FinderPath _finderPathWithPaginationFindByCandidateStatus;
	private FinderPath _finderPathWithoutPaginationFindByCandidateStatus;
	private FinderPath _finderPathCountByCandidateStatus;

	/**
	 * Returns all the candidate other infos where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @return the matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus) {

		return findByCandidateStatus(
			candidateStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate other infos where candidateStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStatus the candidate status
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus, int start, int end) {

		return findByCandidateStatus(candidateStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where candidateStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStatus the candidate status
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return findByCandidateStatus(
			candidateStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where candidateStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStatus the candidate status
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
		boolean useFinderCache) {

		candidateStatus = Objects.toString(candidateStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCandidateStatus;
				finderArgs = new Object[] {candidateStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCandidateStatus;
			finderArgs = new Object[] {
				candidateStatus, start, end, orderByComparator
			};
		}

		List<CandidateOtherInfo> list = null;

		if (useFinderCache) {
			list = (List<CandidateOtherInfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateOtherInfo candidateOtherInfo : list) {
					if (!candidateStatus.equals(
							candidateOtherInfo.getCandidateStatus())) {

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

			sb.append(_SQL_SELECT_CANDIDATEOTHERINFO_WHERE);

			boolean bindCandidateStatus = false;

			if (candidateStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_CANDIDATESTATUS_CANDIDATESTATUS_3);
			}
			else {
				bindCandidateStatus = true;

				sb.append(_FINDER_COLUMN_CANDIDATESTATUS_CANDIDATESTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CandidateOtherInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCandidateStatus) {
					queryPos.add(candidateStatus);
				}

				list = (List<CandidateOtherInfo>)QueryUtil.list(
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
	 * Returns the first candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo findByCandidateStatus_First(
			String candidateStatus,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByCandidateStatus_First(
			candidateStatus, orderByComparator);

		if (candidateOtherInfo != null) {
			return candidateOtherInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("candidateStatus=");
		sb.append(candidateStatus);

		sb.append("}");

		throw new NoSuchCandidateOtherInfoException(sb.toString());
	}

	/**
	 * Returns the first candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByCandidateStatus_First(
		String candidateStatus,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		List<CandidateOtherInfo> list = findByCandidateStatus(
			candidateStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo findByCandidateStatus_Last(
			String candidateStatus,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByCandidateStatus_Last(
			candidateStatus, orderByComparator);

		if (candidateOtherInfo != null) {
			return candidateOtherInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("candidateStatus=");
		sb.append(candidateStatus);

		sb.append("}");

		throw new NoSuchCandidateOtherInfoException(sb.toString());
	}

	/**
	 * Returns the last candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByCandidateStatus_Last(
		String candidateStatus,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		int count = countByCandidateStatus(candidateStatus);

		if (count == 0) {
			return null;
		}

		List<CandidateOtherInfo> list = findByCandidateStatus(
			candidateStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	@Override
	public CandidateOtherInfo[] findByCandidateStatus_PrevAndNext(
			long candidateOtherInfoId, String candidateStatus,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		candidateStatus = Objects.toString(candidateStatus, "");

		CandidateOtherInfo candidateOtherInfo = findByPrimaryKey(
			candidateOtherInfoId);

		Session session = null;

		try {
			session = openSession();

			CandidateOtherInfo[] array = new CandidateOtherInfoImpl[3];

			array[0] = getByCandidateStatus_PrevAndNext(
				session, candidateOtherInfo, candidateStatus, orderByComparator,
				true);

			array[1] = candidateOtherInfo;

			array[2] = getByCandidateStatus_PrevAndNext(
				session, candidateOtherInfo, candidateStatus, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateOtherInfo getByCandidateStatus_PrevAndNext(
		Session session, CandidateOtherInfo candidateOtherInfo,
		String candidateStatus,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
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

		sb.append(_SQL_SELECT_CANDIDATEOTHERINFO_WHERE);

		boolean bindCandidateStatus = false;

		if (candidateStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_CANDIDATESTATUS_CANDIDATESTATUS_3);
		}
		else {
			bindCandidateStatus = true;

			sb.append(_FINDER_COLUMN_CANDIDATESTATUS_CANDIDATESTATUS_2);
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
			sb.append(CandidateOtherInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCandidateStatus) {
			queryPos.add(candidateStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						candidateOtherInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CandidateOtherInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate other infos where candidateStatus = &#63; from the database.
	 *
	 * @param candidateStatus the candidate status
	 */
	@Override
	public void removeByCandidateStatus(String candidateStatus) {
		for (CandidateOtherInfo candidateOtherInfo :
				findByCandidateStatus(
					candidateStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(candidateOtherInfo);
		}
	}

	/**
	 * Returns the number of candidate other infos where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @return the number of matching candidate other infos
	 */
	@Override
	public int countByCandidateStatus(String candidateStatus) {
		candidateStatus = Objects.toString(candidateStatus, "");

		FinderPath finderPath = _finderPathCountByCandidateStatus;

		Object[] finderArgs = new Object[] {candidateStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CANDIDATEOTHERINFO_WHERE);

			boolean bindCandidateStatus = false;

			if (candidateStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_CANDIDATESTATUS_CANDIDATESTATUS_3);
			}
			else {
				bindCandidateStatus = true;

				sb.append(_FINDER_COLUMN_CANDIDATESTATUS_CANDIDATESTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCandidateStatus) {
					queryPos.add(candidateStatus);
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

	private static final String
		_FINDER_COLUMN_CANDIDATESTATUS_CANDIDATESTATUS_2 =
			"candidateOtherInfo.candidateStatus = ?";

	private static final String
		_FINDER_COLUMN_CANDIDATESTATUS_CANDIDATESTATUS_3 =
			"(candidateOtherInfo.candidateStatus IS NULL OR candidateOtherInfo.candidateStatus = '')";

	private FinderPath _finderPathWithPaginationFindByCandidateStage;
	private FinderPath _finderPathWithoutPaginationFindByCandidateStage;
	private FinderPath _finderPathCountByCandidateStage;

	/**
	 * Returns all the candidate other infos where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @return the matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage) {

		return findByCandidateStage(
			candidateStage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate other infos where candidateStage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStage the candidate stage
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage, int start, int end) {

		return findByCandidateStage(candidateStage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where candidateStage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStage the candidate stage
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return findByCandidateStage(
			candidateStage, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where candidateStage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStage the candidate stage
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
		boolean useFinderCache) {

		candidateStage = Objects.toString(candidateStage, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCandidateStage;
				finderArgs = new Object[] {candidateStage};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCandidateStage;
			finderArgs = new Object[] {
				candidateStage, start, end, orderByComparator
			};
		}

		List<CandidateOtherInfo> list = null;

		if (useFinderCache) {
			list = (List<CandidateOtherInfo>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CandidateOtherInfo candidateOtherInfo : list) {
					if (!candidateStage.equals(
							candidateOtherInfo.getCandidateStage())) {

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

			sb.append(_SQL_SELECT_CANDIDATEOTHERINFO_WHERE);

			boolean bindCandidateStage = false;

			if (candidateStage.isEmpty()) {
				sb.append(_FINDER_COLUMN_CANDIDATESTAGE_CANDIDATESTAGE_3);
			}
			else {
				bindCandidateStage = true;

				sb.append(_FINDER_COLUMN_CANDIDATESTAGE_CANDIDATESTAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CandidateOtherInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCandidateStage) {
					queryPos.add(candidateStage);
				}

				list = (List<CandidateOtherInfo>)QueryUtil.list(
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
	 * Returns the first candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo findByCandidateStage_First(
			String candidateStage,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByCandidateStage_First(
			candidateStage, orderByComparator);

		if (candidateOtherInfo != null) {
			return candidateOtherInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("candidateStage=");
		sb.append(candidateStage);

		sb.append("}");

		throw new NoSuchCandidateOtherInfoException(sb.toString());
	}

	/**
	 * Returns the first candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByCandidateStage_First(
		String candidateStage,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		List<CandidateOtherInfo> list = findByCandidateStage(
			candidateStage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo findByCandidateStage_Last(
			String candidateStage,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByCandidateStage_Last(
			candidateStage, orderByComparator);

		if (candidateOtherInfo != null) {
			return candidateOtherInfo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("candidateStage=");
		sb.append(candidateStage);

		sb.append("}");

		throw new NoSuchCandidateOtherInfoException(sb.toString());
	}

	/**
	 * Returns the last candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByCandidateStage_Last(
		String candidateStage,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		int count = countByCandidateStage(candidateStage);

		if (count == 0) {
			return null;
		}

		List<CandidateOtherInfo> list = findByCandidateStage(
			candidateStage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	@Override
	public CandidateOtherInfo[] findByCandidateStage_PrevAndNext(
			long candidateOtherInfoId, String candidateStage,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws NoSuchCandidateOtherInfoException {

		candidateStage = Objects.toString(candidateStage, "");

		CandidateOtherInfo candidateOtherInfo = findByPrimaryKey(
			candidateOtherInfoId);

		Session session = null;

		try {
			session = openSession();

			CandidateOtherInfo[] array = new CandidateOtherInfoImpl[3];

			array[0] = getByCandidateStage_PrevAndNext(
				session, candidateOtherInfo, candidateStage, orderByComparator,
				true);

			array[1] = candidateOtherInfo;

			array[2] = getByCandidateStage_PrevAndNext(
				session, candidateOtherInfo, candidateStage, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateOtherInfo getByCandidateStage_PrevAndNext(
		Session session, CandidateOtherInfo candidateOtherInfo,
		String candidateStage,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
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

		sb.append(_SQL_SELECT_CANDIDATEOTHERINFO_WHERE);

		boolean bindCandidateStage = false;

		if (candidateStage.isEmpty()) {
			sb.append(_FINDER_COLUMN_CANDIDATESTAGE_CANDIDATESTAGE_3);
		}
		else {
			bindCandidateStage = true;

			sb.append(_FINDER_COLUMN_CANDIDATESTAGE_CANDIDATESTAGE_2);
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
			sb.append(CandidateOtherInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCandidateStage) {
			queryPos.add(candidateStage);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						candidateOtherInfo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CandidateOtherInfo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate other infos where candidateStage = &#63; from the database.
	 *
	 * @param candidateStage the candidate stage
	 */
	@Override
	public void removeByCandidateStage(String candidateStage) {
		for (CandidateOtherInfo candidateOtherInfo :
				findByCandidateStage(
					candidateStage, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(candidateOtherInfo);
		}
	}

	/**
	 * Returns the number of candidate other infos where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @return the number of matching candidate other infos
	 */
	@Override
	public int countByCandidateStage(String candidateStage) {
		candidateStage = Objects.toString(candidateStage, "");

		FinderPath finderPath = _finderPathCountByCandidateStage;

		Object[] finderArgs = new Object[] {candidateStage};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CANDIDATEOTHERINFO_WHERE);

			boolean bindCandidateStage = false;

			if (candidateStage.isEmpty()) {
				sb.append(_FINDER_COLUMN_CANDIDATESTAGE_CANDIDATESTAGE_3);
			}
			else {
				bindCandidateStage = true;

				sb.append(_FINDER_COLUMN_CANDIDATESTAGE_CANDIDATESTAGE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCandidateStage) {
					queryPos.add(candidateStage);
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

	private static final String _FINDER_COLUMN_CANDIDATESTAGE_CANDIDATESTAGE_2 =
		"candidateOtherInfo.candidateStage = ?";

	private static final String _FINDER_COLUMN_CANDIDATESTAGE_CANDIDATESTAGE_3 =
		"(candidateOtherInfo.candidateStage IS NULL OR candidateOtherInfo.candidateStage = '')";

	public CandidateOtherInfoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CandidateOtherInfo.class);

		setModelImplClass(CandidateOtherInfoImpl.class);
		setModelPKClass(long.class);

		setTable(CandidateOtherInfoTable.INSTANCE);
	}

	/**
	 * Caches the candidate other info in the entity cache if it is enabled.
	 *
	 * @param candidateOtherInfo the candidate other info
	 */
	@Override
	public void cacheResult(CandidateOtherInfo candidateOtherInfo) {
		entityCache.putResult(
			CandidateOtherInfoImpl.class, candidateOtherInfo.getPrimaryKey(),
			candidateOtherInfo);

		finderCache.putResult(
			_finderPathFetchByCandidateId,
			new Object[] {candidateOtherInfo.getCandidateId()},
			candidateOtherInfo);

		finderCache.putResult(
			_finderPathFetchByCandidatesId,
			new Object[] {candidateOtherInfo.getCandidateId()},
			candidateOtherInfo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the candidate other infos in the entity cache if it is enabled.
	 *
	 * @param candidateOtherInfos the candidate other infos
	 */
	@Override
	public void cacheResult(List<CandidateOtherInfo> candidateOtherInfos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (candidateOtherInfos.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CandidateOtherInfo candidateOtherInfo : candidateOtherInfos) {
			if (entityCache.getResult(
					CandidateOtherInfoImpl.class,
					candidateOtherInfo.getPrimaryKey()) == null) {

				cacheResult(candidateOtherInfo);
			}
		}
	}

	/**
	 * Clears the cache for all candidate other infos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CandidateOtherInfoImpl.class);

		finderCache.clearCache(CandidateOtherInfoImpl.class);
	}

	/**
	 * Clears the cache for the candidate other info.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CandidateOtherInfo candidateOtherInfo) {
		entityCache.removeResult(
			CandidateOtherInfoImpl.class, candidateOtherInfo);
	}

	@Override
	public void clearCache(List<CandidateOtherInfo> candidateOtherInfos) {
		for (CandidateOtherInfo candidateOtherInfo : candidateOtherInfos) {
			entityCache.removeResult(
				CandidateOtherInfoImpl.class, candidateOtherInfo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CandidateOtherInfoImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CandidateOtherInfoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CandidateOtherInfoModelImpl candidateOtherInfoModelImpl) {

		Object[] args = new Object[] {
			candidateOtherInfoModelImpl.getCandidateId()
		};

		finderCache.putResult(
			_finderPathCountByCandidateId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCandidateId, args, candidateOtherInfoModelImpl);

		args = new Object[] {candidateOtherInfoModelImpl.getCandidateId()};

		finderCache.putResult(
			_finderPathCountByCandidatesId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByCandidatesId, args, candidateOtherInfoModelImpl);
	}

	/**
	 * Creates a new candidate other info with the primary key. Does not add the candidate other info to the database.
	 *
	 * @param candidateOtherInfoId the primary key for the new candidate other info
	 * @return the new candidate other info
	 */
	@Override
	public CandidateOtherInfo create(long candidateOtherInfoId) {
		CandidateOtherInfo candidateOtherInfo = new CandidateOtherInfoImpl();

		candidateOtherInfo.setNew(true);
		candidateOtherInfo.setPrimaryKey(candidateOtherInfoId);

		String uuid = PortalUUIDUtil.generate();

		candidateOtherInfo.setUuid(uuid);

		candidateOtherInfo.setCompanyId(CompanyThreadLocal.getCompanyId());

		return candidateOtherInfo;
	}

	/**
	 * Removes the candidate other info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info that was removed
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	@Override
	public CandidateOtherInfo remove(long candidateOtherInfoId)
		throws NoSuchCandidateOtherInfoException {

		return remove((Serializable)candidateOtherInfoId);
	}

	/**
	 * Removes the candidate other info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate other info
	 * @return the candidate other info that was removed
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	@Override
	public CandidateOtherInfo remove(Serializable primaryKey)
		throws NoSuchCandidateOtherInfoException {

		Session session = null;

		try {
			session = openSession();

			CandidateOtherInfo candidateOtherInfo =
				(CandidateOtherInfo)session.get(
					CandidateOtherInfoImpl.class, primaryKey);

			if (candidateOtherInfo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidateOtherInfoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(candidateOtherInfo);
		}
		catch (NoSuchCandidateOtherInfoException noSuchEntityException) {
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
	protected CandidateOtherInfo removeImpl(
		CandidateOtherInfo candidateOtherInfo) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidateOtherInfo)) {
				candidateOtherInfo = (CandidateOtherInfo)session.get(
					CandidateOtherInfoImpl.class,
					candidateOtherInfo.getPrimaryKeyObj());
			}

			if (candidateOtherInfo != null) {
				session.delete(candidateOtherInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (candidateOtherInfo != null) {
			clearCache(candidateOtherInfo);
		}

		return candidateOtherInfo;
	}

	@Override
	public CandidateOtherInfo updateImpl(
		CandidateOtherInfo candidateOtherInfo) {

		boolean isNew = candidateOtherInfo.isNew();

		if (!(candidateOtherInfo instanceof CandidateOtherInfoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(candidateOtherInfo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					candidateOtherInfo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in candidateOtherInfo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CandidateOtherInfo implementation " +
					candidateOtherInfo.getClass());
		}

		CandidateOtherInfoModelImpl candidateOtherInfoModelImpl =
			(CandidateOtherInfoModelImpl)candidateOtherInfo;

		if (Validator.isNull(candidateOtherInfo.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			candidateOtherInfo.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(candidateOtherInfo);
			}
			else {
				candidateOtherInfo = (CandidateOtherInfo)session.merge(
					candidateOtherInfo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CandidateOtherInfoImpl.class, candidateOtherInfoModelImpl, false,
			true);

		cacheUniqueFindersCache(candidateOtherInfoModelImpl);

		if (isNew) {
			candidateOtherInfo.setNew(false);
		}

		candidateOtherInfo.resetOriginalValues();

		return candidateOtherInfo;
	}

	/**
	 * Returns the candidate other info with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate other info
	 * @return the candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	@Override
	public CandidateOtherInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidateOtherInfoException {

		CandidateOtherInfo candidateOtherInfo = fetchByPrimaryKey(primaryKey);

		if (candidateOtherInfo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidateOtherInfoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return candidateOtherInfo;
	}

	/**
	 * Returns the candidate other info with the primary key or throws a <code>NoSuchCandidateOtherInfoException</code> if it could not be found.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	@Override
	public CandidateOtherInfo findByPrimaryKey(long candidateOtherInfoId)
		throws NoSuchCandidateOtherInfoException {

		return findByPrimaryKey((Serializable)candidateOtherInfoId);
	}

	/**
	 * Returns the candidate other info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info, or <code>null</code> if a candidate other info with the primary key could not be found
	 */
	@Override
	public CandidateOtherInfo fetchByPrimaryKey(long candidateOtherInfoId) {
		return fetchByPrimaryKey((Serializable)candidateOtherInfoId);
	}

	/**
	 * Returns all the candidate other infos.
	 *
	 * @return the candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findAll(
		int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the candidate other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of candidate other infos
	 */
	@Override
	public List<CandidateOtherInfo> findAll(
		int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
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

		List<CandidateOtherInfo> list = null;

		if (useFinderCache) {
			list = (List<CandidateOtherInfo>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CANDIDATEOTHERINFO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATEOTHERINFO;

				sql = sql.concat(CandidateOtherInfoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CandidateOtherInfo>)QueryUtil.list(
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
	 * Removes all the candidate other infos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CandidateOtherInfo candidateOtherInfo : findAll()) {
			remove(candidateOtherInfo);
		}
	}

	/**
	 * Returns the number of candidate other infos.
	 *
	 * @return the number of candidate other infos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_CANDIDATEOTHERINFO);

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
		return "candidateOtherInfoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CANDIDATEOTHERINFO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CandidateOtherInfoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the candidate other info persistence.
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

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathFetchByCandidateId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCandidateId",
			new String[] {Long.class.getName()}, new String[] {"candidateId"},
			true);

		_finderPathCountByCandidateId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCandidateId",
			new String[] {Long.class.getName()}, new String[] {"candidateId"},
			false);

		_finderPathFetchByCandidatesId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCandidatesId",
			new String[] {Long.class.getName()}, new String[] {"candidateId"},
			true);

		_finderPathCountByCandidatesId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCandidatesId",
			new String[] {Long.class.getName()}, new String[] {"candidateId"},
			false);

		_finderPathWithPaginationFindByCandidateStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCandidateStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"candidateStatus"}, true);

		_finderPathWithoutPaginationFindByCandidateStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCandidateStatus",
			new String[] {String.class.getName()},
			new String[] {"candidateStatus"}, true);

		_finderPathCountByCandidateStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCandidateStatus",
			new String[] {String.class.getName()},
			new String[] {"candidateStatus"}, false);

		_finderPathWithPaginationFindByCandidateStage = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCandidateStage",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"candidateStage"}, true);

		_finderPathWithoutPaginationFindByCandidateStage = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCandidateStage",
			new String[] {String.class.getName()},
			new String[] {"candidateStage"}, true);

		_finderPathCountByCandidateStage = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCandidateStage",
			new String[] {String.class.getName()},
			new String[] {"candidateStage"}, false);

		_setCandidateOtherInfoUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCandidateOtherInfoUtilPersistence(null);

		entityCache.removeCache(CandidateOtherInfoImpl.class.getName());
	}

	private void _setCandidateOtherInfoUtilPersistence(
		CandidateOtherInfoPersistence candidateOtherInfoPersistence) {

		try {
			Field field = CandidateOtherInfoUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, candidateOtherInfoPersistence);
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

	private static final String _SQL_SELECT_CANDIDATEOTHERINFO =
		"SELECT candidateOtherInfo FROM CandidateOtherInfo candidateOtherInfo";

	private static final String _SQL_SELECT_CANDIDATEOTHERINFO_WHERE =
		"SELECT candidateOtherInfo FROM CandidateOtherInfo candidateOtherInfo WHERE ";

	private static final String _SQL_COUNT_CANDIDATEOTHERINFO =
		"SELECT COUNT(candidateOtherInfo) FROM CandidateOtherInfo candidateOtherInfo";

	private static final String _SQL_COUNT_CANDIDATEOTHERINFO_WHERE =
		"SELECT COUNT(candidateOtherInfo) FROM CandidateOtherInfo candidateOtherInfo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "candidateOtherInfo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CandidateOtherInfo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CandidateOtherInfo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CandidateOtherInfoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CandidateOtherInfoModelArgumentsResolver
		_candidateOtherInfoModelArgumentsResolver;

}