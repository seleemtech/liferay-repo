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

import com.prime.data.service.exception.NoSuchMainTableException;
import com.prime.data.service.model.MainTable;
import com.prime.data.service.model.MainTableTable;
import com.prime.data.service.model.impl.MainTableImpl;
import com.prime.data.service.model.impl.MainTableModelImpl;
import com.prime.data.service.service.persistence.MainTablePersistence;
import com.prime.data.service.service.persistence.MainTableUtil;
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
 * The persistence implementation for the main table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {MainTablePersistence.class, BasePersistence.class})
public class MainTablePersistenceImpl
	extends BasePersistenceImpl<MainTable> implements MainTablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MainTableUtil</code> to access the main table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MainTableImpl.class.getName();

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
	 * Returns all the main tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching main tables
	 */
	@Override
	public List<MainTable> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the main tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @return the range of matching main tables
	 */
	@Override
	public List<MainTable> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the main tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching main tables
	 */
	@Override
	public List<MainTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MainTable> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the main tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching main tables
	 */
	@Override
	public List<MainTable> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MainTable> orderByComparator,
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

		List<MainTable> list = null;

		if (useFinderCache) {
			list = (List<MainTable>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (MainTable mainTable : list) {
					if (!uuid.equals(mainTable.getUuid())) {
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

			sb.append(_SQL_SELECT_MAINTABLE_WHERE);

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
				sb.append(MainTableModelImpl.ORDER_BY_JPQL);
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

				list = (List<MainTable>)QueryUtil.list(
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
	 * Returns the first main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	@Override
	public MainTable findByUuid_First(
			String uuid, OrderByComparator<MainTable> orderByComparator)
		throws NoSuchMainTableException {

		MainTable mainTable = fetchByUuid_First(uuid, orderByComparator);

		if (mainTable != null) {
			return mainTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMainTableException(sb.toString());
	}

	/**
	 * Returns the first main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table, or <code>null</code> if a matching main table could not be found
	 */
	@Override
	public MainTable fetchByUuid_First(
		String uuid, OrderByComparator<MainTable> orderByComparator) {

		List<MainTable> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	@Override
	public MainTable findByUuid_Last(
			String uuid, OrderByComparator<MainTable> orderByComparator)
		throws NoSuchMainTableException {

		MainTable mainTable = fetchByUuid_Last(uuid, orderByComparator);

		if (mainTable != null) {
			return mainTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMainTableException(sb.toString());
	}

	/**
	 * Returns the last main table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table, or <code>null</code> if a matching main table could not be found
	 */
	@Override
	public MainTable fetchByUuid_Last(
		String uuid, OrderByComparator<MainTable> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MainTable> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the main tables before and after the current main table in the ordered set where uuid = &#63;.
	 *
	 * @param categoryId the primary key of the current main table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next main table
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	@Override
	public MainTable[] findByUuid_PrevAndNext(
			long categoryId, String uuid,
			OrderByComparator<MainTable> orderByComparator)
		throws NoSuchMainTableException {

		uuid = Objects.toString(uuid, "");

		MainTable mainTable = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			MainTable[] array = new MainTableImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, mainTable, uuid, orderByComparator, true);

			array[1] = mainTable;

			array[2] = getByUuid_PrevAndNext(
				session, mainTable, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MainTable getByUuid_PrevAndNext(
		Session session, MainTable mainTable, String uuid,
		OrderByComparator<MainTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MAINTABLE_WHERE);

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
			sb.append(MainTableModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(mainTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MainTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the main tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MainTable mainTable :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(mainTable);
		}
	}

	/**
	 * Returns the number of main tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching main tables
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MAINTABLE_WHERE);

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
		"mainTable.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(mainTable.uuid IS NULL OR mainTable.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByCategory;
	private FinderPath _finderPathWithoutPaginationFindByCategory;
	private FinderPath _finderPathCountByCategory;

	/**
	 * Returns all the main tables where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching main tables
	 */
	@Override
	public List<MainTable> findByCategory(String category) {
		return findByCategory(
			category, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the main tables where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @return the range of matching main tables
	 */
	@Override
	public List<MainTable> findByCategory(String category, int start, int end) {
		return findByCategory(category, start, end, null);
	}

	/**
	 * Returns an ordered range of all the main tables where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching main tables
	 */
	@Override
	public List<MainTable> findByCategory(
		String category, int start, int end,
		OrderByComparator<MainTable> orderByComparator) {

		return findByCategory(category, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the main tables where category = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param category the category
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching main tables
	 */
	@Override
	public List<MainTable> findByCategory(
		String category, int start, int end,
		OrderByComparator<MainTable> orderByComparator,
		boolean useFinderCache) {

		category = Objects.toString(category, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCategory;
				finderArgs = new Object[] {category};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCategory;
			finderArgs = new Object[] {category, start, end, orderByComparator};
		}

		List<MainTable> list = null;

		if (useFinderCache) {
			list = (List<MainTable>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (MainTable mainTable : list) {
					if (!category.equals(mainTable.getCategory())) {
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

			sb.append(_SQL_SELECT_MAINTABLE_WHERE);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MainTableModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategory) {
					queryPos.add(category);
				}

				list = (List<MainTable>)QueryUtil.list(
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
	 * Returns the first main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	@Override
	public MainTable findByCategory_First(
			String category, OrderByComparator<MainTable> orderByComparator)
		throws NoSuchMainTableException {

		MainTable mainTable = fetchByCategory_First(
			category, orderByComparator);

		if (mainTable != null) {
			return mainTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("category=");
		sb.append(category);

		sb.append("}");

		throw new NoSuchMainTableException(sb.toString());
	}

	/**
	 * Returns the first main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching main table, or <code>null</code> if a matching main table could not be found
	 */
	@Override
	public MainTable fetchByCategory_First(
		String category, OrderByComparator<MainTable> orderByComparator) {

		List<MainTable> list = findByCategory(
			category, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table
	 * @throws NoSuchMainTableException if a matching main table could not be found
	 */
	@Override
	public MainTable findByCategory_Last(
			String category, OrderByComparator<MainTable> orderByComparator)
		throws NoSuchMainTableException {

		MainTable mainTable = fetchByCategory_Last(category, orderByComparator);

		if (mainTable != null) {
			return mainTable;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("category=");
		sb.append(category);

		sb.append("}");

		throw new NoSuchMainTableException(sb.toString());
	}

	/**
	 * Returns the last main table in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching main table, or <code>null</code> if a matching main table could not be found
	 */
	@Override
	public MainTable fetchByCategory_Last(
		String category, OrderByComparator<MainTable> orderByComparator) {

		int count = countByCategory(category);

		if (count == 0) {
			return null;
		}

		List<MainTable> list = findByCategory(
			category, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the main tables before and after the current main table in the ordered set where category = &#63;.
	 *
	 * @param categoryId the primary key of the current main table
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next main table
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	@Override
	public MainTable[] findByCategory_PrevAndNext(
			long categoryId, String category,
			OrderByComparator<MainTable> orderByComparator)
		throws NoSuchMainTableException {

		category = Objects.toString(category, "");

		MainTable mainTable = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			MainTable[] array = new MainTableImpl[3];

			array[0] = getByCategory_PrevAndNext(
				session, mainTable, category, orderByComparator, true);

			array[1] = mainTable;

			array[2] = getByCategory_PrevAndNext(
				session, mainTable, category, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MainTable getByCategory_PrevAndNext(
		Session session, MainTable mainTable, String category,
		OrderByComparator<MainTable> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MAINTABLE_WHERE);

		boolean bindCategory = false;

		if (category.isEmpty()) {
			sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
		}
		else {
			bindCategory = true;

			sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
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
			sb.append(MainTableModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCategory) {
			queryPos.add(category);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(mainTable)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MainTable> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the main tables where category = &#63; from the database.
	 *
	 * @param category the category
	 */
	@Override
	public void removeByCategory(String category) {
		for (MainTable mainTable :
				findByCategory(
					category, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(mainTable);
		}
	}

	/**
	 * Returns the number of main tables where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching main tables
	 */
	@Override
	public int countByCategory(String category) {
		category = Objects.toString(category, "");

		FinderPath finderPath = _finderPathCountByCategory;

		Object[] finderArgs = new Object[] {category};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MAINTABLE_WHERE);

			boolean bindCategory = false;

			if (category.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_3);
			}
			else {
				bindCategory = true;

				sb.append(_FINDER_COLUMN_CATEGORY_CATEGORY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategory) {
					queryPos.add(category);
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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_2 =
		"mainTable.category = ?";

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORY_3 =
		"(mainTable.category IS NULL OR mainTable.category = '')";

	public MainTablePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MainTable.class);

		setModelImplClass(MainTableImpl.class);
		setModelPKClass(long.class);

		setTable(MainTableTable.INSTANCE);
	}

	/**
	 * Caches the main table in the entity cache if it is enabled.
	 *
	 * @param mainTable the main table
	 */
	@Override
	public void cacheResult(MainTable mainTable) {
		entityCache.putResult(
			MainTableImpl.class, mainTable.getPrimaryKey(), mainTable);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the main tables in the entity cache if it is enabled.
	 *
	 * @param mainTables the main tables
	 */
	@Override
	public void cacheResult(List<MainTable> mainTables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (mainTables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MainTable mainTable : mainTables) {
			if (entityCache.getResult(
					MainTableImpl.class, mainTable.getPrimaryKey()) == null) {

				cacheResult(mainTable);
			}
		}
	}

	/**
	 * Clears the cache for all main tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MainTableImpl.class);

		finderCache.clearCache(MainTableImpl.class);
	}

	/**
	 * Clears the cache for the main table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MainTable mainTable) {
		entityCache.removeResult(MainTableImpl.class, mainTable);
	}

	@Override
	public void clearCache(List<MainTable> mainTables) {
		for (MainTable mainTable : mainTables) {
			entityCache.removeResult(MainTableImpl.class, mainTable);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MainTableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MainTableImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new main table with the primary key. Does not add the main table to the database.
	 *
	 * @param categoryId the primary key for the new main table
	 * @return the new main table
	 */
	@Override
	public MainTable create(long categoryId) {
		MainTable mainTable = new MainTableImpl();

		mainTable.setNew(true);
		mainTable.setPrimaryKey(categoryId);

		String uuid = PortalUUIDUtil.generate();

		mainTable.setUuid(uuid);

		return mainTable;
	}

	/**
	 * Removes the main table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table that was removed
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	@Override
	public MainTable remove(long categoryId) throws NoSuchMainTableException {
		return remove((Serializable)categoryId);
	}

	/**
	 * Removes the main table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the main table
	 * @return the main table that was removed
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	@Override
	public MainTable remove(Serializable primaryKey)
		throws NoSuchMainTableException {

		Session session = null;

		try {
			session = openSession();

			MainTable mainTable = (MainTable)session.get(
				MainTableImpl.class, primaryKey);

			if (mainTable == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMainTableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mainTable);
		}
		catch (NoSuchMainTableException noSuchEntityException) {
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
	protected MainTable removeImpl(MainTable mainTable) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mainTable)) {
				mainTable = (MainTable)session.get(
					MainTableImpl.class, mainTable.getPrimaryKeyObj());
			}

			if (mainTable != null) {
				session.delete(mainTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mainTable != null) {
			clearCache(mainTable);
		}

		return mainTable;
	}

	@Override
	public MainTable updateImpl(MainTable mainTable) {
		boolean isNew = mainTable.isNew();

		if (!(mainTable instanceof MainTableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mainTable.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(mainTable);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mainTable proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MainTable implementation " +
					mainTable.getClass());
		}

		MainTableModelImpl mainTableModelImpl = (MainTableModelImpl)mainTable;

		if (Validator.isNull(mainTable.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			mainTable.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(mainTable);
			}
			else {
				mainTable = (MainTable)session.merge(mainTable);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MainTableImpl.class, mainTableModelImpl, false, true);

		if (isNew) {
			mainTable.setNew(false);
		}

		mainTable.resetOriginalValues();

		return mainTable;
	}

	/**
	 * Returns the main table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the main table
	 * @return the main table
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	@Override
	public MainTable findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMainTableException {

		MainTable mainTable = fetchByPrimaryKey(primaryKey);

		if (mainTable == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMainTableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mainTable;
	}

	/**
	 * Returns the main table with the primary key or throws a <code>NoSuchMainTableException</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table
	 * @throws NoSuchMainTableException if a main table with the primary key could not be found
	 */
	@Override
	public MainTable findByPrimaryKey(long categoryId)
		throws NoSuchMainTableException {

		return findByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns the main table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table, or <code>null</code> if a main table with the primary key could not be found
	 */
	@Override
	public MainTable fetchByPrimaryKey(long categoryId) {
		return fetchByPrimaryKey((Serializable)categoryId);
	}

	/**
	 * Returns all the main tables.
	 *
	 * @return the main tables
	 */
	@Override
	public List<MainTable> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the main tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @return the range of main tables
	 */
	@Override
	public List<MainTable> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the main tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of main tables
	 */
	@Override
	public List<MainTable> findAll(
		int start, int end, OrderByComparator<MainTable> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the main tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of main tables
	 */
	@Override
	public List<MainTable> findAll(
		int start, int end, OrderByComparator<MainTable> orderByComparator,
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

		List<MainTable> list = null;

		if (useFinderCache) {
			list = (List<MainTable>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MAINTABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MAINTABLE;

				sql = sql.concat(MainTableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MainTable>)QueryUtil.list(
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
	 * Removes all the main tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MainTable mainTable : findAll()) {
			remove(mainTable);
		}
	}

	/**
	 * Returns the number of main tables.
	 *
	 * @return the number of main tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MAINTABLE);

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
		return "categoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MAINTABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MainTableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the main table persistence.
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

		_finderPathWithPaginationFindByCategory = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"category"}, true);

		_finderPathWithoutPaginationFindByCategory = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] {String.class.getName()}, new String[] {"category"},
			true);

		_finderPathCountByCategory = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] {String.class.getName()}, new String[] {"category"},
			false);

		_setMainTableUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setMainTableUtilPersistence(null);

		entityCache.removeCache(MainTableImpl.class.getName());
	}

	private void _setMainTableUtilPersistence(
		MainTablePersistence mainTablePersistence) {

		try {
			Field field = MainTableUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, mainTablePersistence);
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

	private static final String _SQL_SELECT_MAINTABLE =
		"SELECT mainTable FROM MainTable mainTable";

	private static final String _SQL_SELECT_MAINTABLE_WHERE =
		"SELECT mainTable FROM MainTable mainTable WHERE ";

	private static final String _SQL_COUNT_MAINTABLE =
		"SELECT COUNT(mainTable) FROM MainTable mainTable";

	private static final String _SQL_COUNT_MAINTABLE_WHERE =
		"SELECT COUNT(mainTable) FROM MainTable mainTable WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mainTable.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MainTable exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MainTable exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MainTablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private MainTableModelArgumentsResolver _mainTableModelArgumentsResolver;

}