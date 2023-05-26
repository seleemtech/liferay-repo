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

package com.att.hr.onestop.services.service.persistence.impl;

import com.att.hr.onestop.services.exception.NoSuchNewsEntryException;
import com.att.hr.onestop.services.model.NewsEntry;
import com.att.hr.onestop.services.model.NewsEntryTable;
import com.att.hr.onestop.services.model.impl.NewsEntryImpl;
import com.att.hr.onestop.services.model.impl.NewsEntryModelImpl;
import com.att.hr.onestop.services.service.persistence.NewsEntryPersistence;
import com.att.hr.onestop.services.service.persistence.NewsEntryUtil;
import com.att.hr.onestop.services.service.persistence.impl.constants.HROSPersistenceConstants;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the news entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {NewsEntryPersistence.class, BasePersistence.class})
public class NewsEntryPersistenceImpl
	extends BasePersistenceImpl<NewsEntry> implements NewsEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NewsEntryUtil</code> to access the news entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NewsEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the news entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching news entries
	 */
	@Override
	public List<NewsEntry> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the news entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<NewsEntry> list = null;

		if (useFinderCache) {
			list = (List<NewsEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NewsEntry newsEntry : list) {
					if (groupId != newsEntry.getGroupId()) {
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

			sb.append(_SQL_SELECT_NEWSENTRY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NewsEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<NewsEntry>)QueryUtil.list(
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
	 * Returns the first news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	@Override
	public NewsEntry findByGroupId_First(
			long groupId, OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = fetchByGroupId_First(groupId, orderByComparator);

		if (newsEntry != null) {
			return newsEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchNewsEntryException(sb.toString());
	}

	/**
	 * Returns the first news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	@Override
	public NewsEntry fetchByGroupId_First(
		long groupId, OrderByComparator<NewsEntry> orderByComparator) {

		List<NewsEntry> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	@Override
	public NewsEntry findByGroupId_Last(
			long groupId, OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = fetchByGroupId_Last(groupId, orderByComparator);

		if (newsEntry != null) {
			return newsEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchNewsEntryException(sb.toString());
	}

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	@Override
	public NewsEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<NewsEntry> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<NewsEntry> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where groupId = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	@Override
	public NewsEntry[] findByGroupId_PrevAndNext(
			long newsEntryId, long groupId,
			OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = findByPrimaryKey(newsEntryId);

		Session session = null;

		try {
			session = openSession();

			NewsEntry[] array = new NewsEntryImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, newsEntry, groupId, orderByComparator, true);

			array[1] = newsEntry;

			array[2] = getByGroupId_PrevAndNext(
				session, newsEntry, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected NewsEntry getByGroupId_PrevAndNext(
		Session session, NewsEntry newsEntry, long groupId,
		OrderByComparator<NewsEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_NEWSENTRY_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			sb.append(NewsEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(newsEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NewsEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the news entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (NewsEntry newsEntry :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(newsEntry);
		}
	}

	/**
	 * Returns the number of news entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching news entries
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NEWSENTRY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"newsEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByCompanyId;
	private FinderPath _finderPathCountByCompanyId;

	/**
	 * Returns all the news entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching news entries
	 */
	@Override
	public List<NewsEntry> findByCompanyId(long companyId) {
		return findByCompanyId(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByCompanyId(long companyId, int start, int end) {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the news entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator) {

		return findByCompanyId(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompanyId;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompanyId;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<NewsEntry> list = null;

		if (useFinderCache) {
			list = (List<NewsEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NewsEntry newsEntry : list) {
					if (companyId != newsEntry.getCompanyId()) {
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

			sb.append(_SQL_SELECT_NEWSENTRY_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NewsEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<NewsEntry>)QueryUtil.list(
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
	 * Returns the first news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	@Override
	public NewsEntry findByCompanyId_First(
			long companyId, OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = fetchByCompanyId_First(
			companyId, orderByComparator);

		if (newsEntry != null) {
			return newsEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchNewsEntryException(sb.toString());
	}

	/**
	 * Returns the first news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	@Override
	public NewsEntry fetchByCompanyId_First(
		long companyId, OrderByComparator<NewsEntry> orderByComparator) {

		List<NewsEntry> list = findByCompanyId(
			companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	@Override
	public NewsEntry findByCompanyId_Last(
			long companyId, OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = fetchByCompanyId_Last(
			companyId, orderByComparator);

		if (newsEntry != null) {
			return newsEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchNewsEntryException(sb.toString());
	}

	/**
	 * Returns the last news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	@Override
	public NewsEntry fetchByCompanyId_Last(
		long companyId, OrderByComparator<NewsEntry> orderByComparator) {

		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<NewsEntry> list = findByCompanyId(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where companyId = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	@Override
	public NewsEntry[] findByCompanyId_PrevAndNext(
			long newsEntryId, long companyId,
			OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = findByPrimaryKey(newsEntryId);

		Session session = null;

		try {
			session = openSession();

			NewsEntry[] array = new NewsEntryImpl[3];

			array[0] = getByCompanyId_PrevAndNext(
				session, newsEntry, companyId, orderByComparator, true);

			array[1] = newsEntry;

			array[2] = getByCompanyId_PrevAndNext(
				session, newsEntry, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected NewsEntry getByCompanyId_PrevAndNext(
		Session session, NewsEntry newsEntry, long companyId,
		OrderByComparator<NewsEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_NEWSENTRY_WHERE);

		sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			sb.append(NewsEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(newsEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NewsEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the news entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (NewsEntry newsEntry :
				findByCompanyId(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(newsEntry);
		}
	}

	/**
	 * Returns the number of news entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching news entries
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = _finderPathCountByCompanyId;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NEWSENTRY_WHERE);

			sb.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 =
		"newsEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByNewsScopeId;
	private FinderPath _finderPathWithoutPaginationFindByNewsScopeId;
	private FinderPath _finderPathCountByNewsScopeId;

	/**
	 * Returns all the news entries where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @return the matching news entries
	 */
	@Override
	public List<NewsEntry> findByNewsScopeId(long newsScopeId) {
		return findByNewsScopeId(
			newsScopeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news entries where newsScopeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param newsScopeId the news scope ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByNewsScopeId(
		long newsScopeId, int start, int end) {

		return findByNewsScopeId(newsScopeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the news entries where newsScopeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param newsScopeId the news scope ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByNewsScopeId(
		long newsScopeId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator) {

		return findByNewsScopeId(
			newsScopeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news entries where newsScopeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param newsScopeId the news scope ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByNewsScopeId(
		long newsScopeId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNewsScopeId;
				finderArgs = new Object[] {newsScopeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNewsScopeId;
			finderArgs = new Object[] {
				newsScopeId, start, end, orderByComparator
			};
		}

		List<NewsEntry> list = null;

		if (useFinderCache) {
			list = (List<NewsEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NewsEntry newsEntry : list) {
					if (newsScopeId != newsEntry.getNewsScopeId()) {
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

			sb.append(_SQL_SELECT_NEWSENTRY_WHERE);

			sb.append(_FINDER_COLUMN_NEWSSCOPEID_NEWSSCOPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NewsEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(newsScopeId);

				list = (List<NewsEntry>)QueryUtil.list(
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
	 * Returns the first news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	@Override
	public NewsEntry findByNewsScopeId_First(
			long newsScopeId, OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = fetchByNewsScopeId_First(
			newsScopeId, orderByComparator);

		if (newsEntry != null) {
			return newsEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("newsScopeId=");
		sb.append(newsScopeId);

		sb.append("}");

		throw new NoSuchNewsEntryException(sb.toString());
	}

	/**
	 * Returns the first news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	@Override
	public NewsEntry fetchByNewsScopeId_First(
		long newsScopeId, OrderByComparator<NewsEntry> orderByComparator) {

		List<NewsEntry> list = findByNewsScopeId(
			newsScopeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	@Override
	public NewsEntry findByNewsScopeId_Last(
			long newsScopeId, OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = fetchByNewsScopeId_Last(
			newsScopeId, orderByComparator);

		if (newsEntry != null) {
			return newsEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("newsScopeId=");
		sb.append(newsScopeId);

		sb.append("}");

		throw new NoSuchNewsEntryException(sb.toString());
	}

	/**
	 * Returns the last news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	@Override
	public NewsEntry fetchByNewsScopeId_Last(
		long newsScopeId, OrderByComparator<NewsEntry> orderByComparator) {

		int count = countByNewsScopeId(newsScopeId);

		if (count == 0) {
			return null;
		}

		List<NewsEntry> list = findByNewsScopeId(
			newsScopeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	@Override
	public NewsEntry[] findByNewsScopeId_PrevAndNext(
			long newsEntryId, long newsScopeId,
			OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = findByPrimaryKey(newsEntryId);

		Session session = null;

		try {
			session = openSession();

			NewsEntry[] array = new NewsEntryImpl[3];

			array[0] = getByNewsScopeId_PrevAndNext(
				session, newsEntry, newsScopeId, orderByComparator, true);

			array[1] = newsEntry;

			array[2] = getByNewsScopeId_PrevAndNext(
				session, newsEntry, newsScopeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected NewsEntry getByNewsScopeId_PrevAndNext(
		Session session, NewsEntry newsEntry, long newsScopeId,
		OrderByComparator<NewsEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_NEWSENTRY_WHERE);

		sb.append(_FINDER_COLUMN_NEWSSCOPEID_NEWSSCOPEID_2);

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
			sb.append(NewsEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(newsScopeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(newsEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NewsEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the news entries where newsScopeId = &#63; from the database.
	 *
	 * @param newsScopeId the news scope ID
	 */
	@Override
	public void removeByNewsScopeId(long newsScopeId) {
		for (NewsEntry newsEntry :
				findByNewsScopeId(
					newsScopeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(newsEntry);
		}
	}

	/**
	 * Returns the number of news entries where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @return the number of matching news entries
	 */
	@Override
	public int countByNewsScopeId(long newsScopeId) {
		FinderPath finderPath = _finderPathCountByNewsScopeId;

		Object[] finderArgs = new Object[] {newsScopeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NEWSENTRY_WHERE);

			sb.append(_FINDER_COLUMN_NEWSSCOPEID_NEWSSCOPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(newsScopeId);

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

	private static final String _FINDER_COLUMN_NEWSSCOPEID_NEWSSCOPEID_2 =
		"newsEntry.newsScopeId = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the news entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching news entries
	 */
	@Override
	public List<NewsEntry> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the news entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching news entries
	 */
	@Override
	public List<NewsEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<NewsEntry> list = null;

		if (useFinderCache) {
			list = (List<NewsEntry>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NewsEntry newsEntry : list) {
					if ((groupId != newsEntry.getGroupId()) ||
						(status != newsEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_NEWSENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NewsEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<NewsEntry>)QueryUtil.list(
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
	 * Returns the first news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	@Override
	public NewsEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (newsEntry != null) {
			return newsEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchNewsEntryException(sb.toString());
	}

	/**
	 * Returns the first news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	@Override
	public NewsEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<NewsEntry> orderByComparator) {

		List<NewsEntry> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	@Override
	public NewsEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (newsEntry != null) {
			return newsEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchNewsEntryException(sb.toString());
	}

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	@Override
	public NewsEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<NewsEntry> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<NewsEntry> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	@Override
	public NewsEntry[] findByG_S_PrevAndNext(
			long newsEntryId, long groupId, int status,
			OrderByComparator<NewsEntry> orderByComparator)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = findByPrimaryKey(newsEntryId);

		Session session = null;

		try {
			session = openSession();

			NewsEntry[] array = new NewsEntryImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, newsEntry, groupId, status, orderByComparator, true);

			array[1] = newsEntry;

			array[2] = getByG_S_PrevAndNext(
				session, newsEntry, groupId, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected NewsEntry getByG_S_PrevAndNext(
		Session session, NewsEntry newsEntry, long groupId, int status,
		OrderByComparator<NewsEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_NEWSENTRY_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

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
			sb.append(NewsEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(newsEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NewsEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the news entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (NewsEntry newsEntry :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(newsEntry);
		}
	}

	/**
	 * Returns the number of news entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching news entries
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NEWSENTRY_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"newsEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"newsEntry.status = ?";

	public NewsEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("newsEntryId", "NEWS_ENTRY_ID");
		dbColumnNames.put("groupId", "GROUP_ID");
		dbColumnNames.put("companyId", "COMPANY_ID");
		dbColumnNames.put("userId", "USER_ID");
		dbColumnNames.put("createDate", "CREATE_DATE");
		dbColumnNames.put("modifiedDate", "MODIFIED_DATE");
		dbColumnNames.put("newsTitle", "NEWS_TITLE");
		dbColumnNames.put("newsSummary", "NEWS_SUMMARY");
		dbColumnNames.put("newsContent", "NEWS_CONTENT");
		dbColumnNames.put("newsImageId", "NEWS_IMAGE_ID");
		dbColumnNames.put("newsScopeId", "NEWS_SCOPE_ID");
		dbColumnNames.put("archive", "ARCHIVE");
		dbColumnNames.put("allowedInDashBoard", "ALLOWED_IN_DASHBOARD");
		dbColumnNames.put("expireDate", "EXPIRE_DATE");
		dbColumnNames.put("ToEmail", "TO_NEWS_EMAIL");
		dbColumnNames.put("status", "STATUS");
		dbColumnNames.put("statusByUserId", "STATUS_BY_USER_ID");
		dbColumnNames.put("statusByUserName", "STATUS_BY_USER_NAME");
		dbColumnNames.put("statusDate", "STATUS_DATE");

		setDBColumnNames(dbColumnNames);

		setModelClass(NewsEntry.class);

		setModelImplClass(NewsEntryImpl.class);
		setModelPKClass(long.class);

		setTable(NewsEntryTable.INSTANCE);
	}

	/**
	 * Caches the news entry in the entity cache if it is enabled.
	 *
	 * @param newsEntry the news entry
	 */
	@Override
	public void cacheResult(NewsEntry newsEntry) {
		entityCache.putResult(
			NewsEntryImpl.class, newsEntry.getPrimaryKey(), newsEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the news entries in the entity cache if it is enabled.
	 *
	 * @param newsEntries the news entries
	 */
	@Override
	public void cacheResult(List<NewsEntry> newsEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (newsEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (NewsEntry newsEntry : newsEntries) {
			if (entityCache.getResult(
					NewsEntryImpl.class, newsEntry.getPrimaryKey()) == null) {

				cacheResult(newsEntry);
			}
		}
	}

	/**
	 * Clears the cache for all news entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NewsEntryImpl.class);

		finderCache.clearCache(NewsEntryImpl.class);
	}

	/**
	 * Clears the cache for the news entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NewsEntry newsEntry) {
		entityCache.removeResult(NewsEntryImpl.class, newsEntry);
	}

	@Override
	public void clearCache(List<NewsEntry> newsEntries) {
		for (NewsEntry newsEntry : newsEntries) {
			entityCache.removeResult(NewsEntryImpl.class, newsEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(NewsEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NewsEntryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new news entry with the primary key. Does not add the news entry to the database.
	 *
	 * @param newsEntryId the primary key for the new news entry
	 * @return the new news entry
	 */
	@Override
	public NewsEntry create(long newsEntryId) {
		NewsEntry newsEntry = new NewsEntryImpl();

		newsEntry.setNew(true);
		newsEntry.setPrimaryKey(newsEntryId);

		newsEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return newsEntry;
	}

	/**
	 * Removes the news entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry that was removed
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	@Override
	public NewsEntry remove(long newsEntryId) throws NoSuchNewsEntryException {
		return remove((Serializable)newsEntryId);
	}

	/**
	 * Removes the news entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news entry
	 * @return the news entry that was removed
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	@Override
	public NewsEntry remove(Serializable primaryKey)
		throws NoSuchNewsEntryException {

		Session session = null;

		try {
			session = openSession();

			NewsEntry newsEntry = (NewsEntry)session.get(
				NewsEntryImpl.class, primaryKey);

			if (newsEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNewsEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(newsEntry);
		}
		catch (NoSuchNewsEntryException noSuchEntityException) {
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
	protected NewsEntry removeImpl(NewsEntry newsEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(newsEntry)) {
				newsEntry = (NewsEntry)session.get(
					NewsEntryImpl.class, newsEntry.getPrimaryKeyObj());
			}

			if (newsEntry != null) {
				session.delete(newsEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (newsEntry != null) {
			clearCache(newsEntry);
		}

		return newsEntry;
	}

	@Override
	public NewsEntry updateImpl(NewsEntry newsEntry) {
		boolean isNew = newsEntry.isNew();

		if (!(newsEntry instanceof NewsEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(newsEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(newsEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in newsEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom NewsEntry implementation " +
					newsEntry.getClass());
		}

		NewsEntryModelImpl newsEntryModelImpl = (NewsEntryModelImpl)newsEntry;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (newsEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				newsEntry.setCreateDate(date);
			}
			else {
				newsEntry.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!newsEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				newsEntry.setModifiedDate(date);
			}
			else {
				newsEntry.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(newsEntry);
			}
			else {
				newsEntry = (NewsEntry)session.merge(newsEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			NewsEntryImpl.class, newsEntryModelImpl, false, true);

		if (isNew) {
			newsEntry.setNew(false);
		}

		newsEntry.resetOriginalValues();

		return newsEntry;
	}

	/**
	 * Returns the news entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news entry
	 * @return the news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	@Override
	public NewsEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNewsEntryException {

		NewsEntry newsEntry = fetchByPrimaryKey(primaryKey);

		if (newsEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNewsEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return newsEntry;
	}

	/**
	 * Returns the news entry with the primary key or throws a <code>NoSuchNewsEntryException</code> if it could not be found.
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	@Override
	public NewsEntry findByPrimaryKey(long newsEntryId)
		throws NoSuchNewsEntryException {

		return findByPrimaryKey((Serializable)newsEntryId);
	}

	/**
	 * Returns the news entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry, or <code>null</code> if a news entry with the primary key could not be found
	 */
	@Override
	public NewsEntry fetchByPrimaryKey(long newsEntryId) {
		return fetchByPrimaryKey((Serializable)newsEntryId);
	}

	/**
	 * Returns all the news entries.
	 *
	 * @return the news entries
	 */
	@Override
	public List<NewsEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of news entries
	 */
	@Override
	public List<NewsEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news entries
	 */
	@Override
	public List<NewsEntry> findAll(
		int start, int end, OrderByComparator<NewsEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news entries
	 */
	@Override
	public List<NewsEntry> findAll(
		int start, int end, OrderByComparator<NewsEntry> orderByComparator,
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

		List<NewsEntry> list = null;

		if (useFinderCache) {
			list = (List<NewsEntry>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NEWSENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NEWSENTRY;

				sql = sql.concat(NewsEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<NewsEntry>)QueryUtil.list(
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
	 * Removes all the news entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NewsEntry newsEntry : findAll()) {
			remove(newsEntry);
		}
	}

	/**
	 * Returns the number of news entries.
	 *
	 * @return the number of news entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NEWSENTRY);

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
		return "NEWS_ENTRY_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NEWSENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NewsEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the news entry persistence.
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

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"GROUP_ID"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"GROUP_ID"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"GROUP_ID"},
			false);

		_finderPathWithPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"COMPANY_ID"}, true);

		_finderPathWithoutPaginationFindByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"COMPANY_ID"},
			true);

		_finderPathCountByCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] {Long.class.getName()}, new String[] {"COMPANY_ID"},
			false);

		_finderPathWithPaginationFindByNewsScopeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNewsScopeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"NEWS_SCOPE_ID"}, true);

		_finderPathWithoutPaginationFindByNewsScopeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNewsScopeId",
			new String[] {Long.class.getName()}, new String[] {"NEWS_SCOPE_ID"},
			true);

		_finderPathCountByNewsScopeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNewsScopeId",
			new String[] {Long.class.getName()}, new String[] {"NEWS_SCOPE_ID"},
			false);

		_finderPathWithPaginationFindByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"GROUP_ID", "STATUS"}, true);

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"GROUP_ID", "STATUS"}, true);

		_finderPathCountByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"GROUP_ID", "STATUS"}, false);

		_setNewsEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNewsEntryUtilPersistence(null);

		entityCache.removeCache(NewsEntryImpl.class.getName());
	}

	private void _setNewsEntryUtilPersistence(
		NewsEntryPersistence newsEntryPersistence) {

		try {
			Field field = NewsEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, newsEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = HROSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = HROSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = HROSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_NEWSENTRY =
		"SELECT newsEntry FROM NewsEntry newsEntry";

	private static final String _SQL_SELECT_NEWSENTRY_WHERE =
		"SELECT newsEntry FROM NewsEntry newsEntry WHERE ";

	private static final String _SQL_COUNT_NEWSENTRY =
		"SELECT COUNT(newsEntry) FROM NewsEntry newsEntry";

	private static final String _SQL_COUNT_NEWSENTRY_WHERE =
		"SELECT COUNT(newsEntry) FROM NewsEntry newsEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "newsEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No NewsEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No NewsEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NewsEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"newsEntryId", "groupId", "companyId", "userId", "createDate",
			"modifiedDate", "newsTitle", "newsSummary", "newsContent",
			"newsImageId", "newsScopeId", "archive", "allowedInDashBoard",
			"expireDate", "ToEmail", "status", "statusByUserId",
			"statusByUserName", "statusDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private NewsEntryModelArgumentsResolver _newsEntryModelArgumentsResolver;

}