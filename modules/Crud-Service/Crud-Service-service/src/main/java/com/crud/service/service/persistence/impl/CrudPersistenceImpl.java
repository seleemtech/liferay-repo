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

package com.crud.service.service.persistence.impl;

import com.crud.service.exception.NoSuchCrudException;
import com.crud.service.model.Crud;
import com.crud.service.model.CrudTable;
import com.crud.service.model.impl.CrudImpl;
import com.crud.service.model.impl.CrudModelImpl;
import com.crud.service.service.persistence.CrudPersistence;
import com.crud.service.service.persistence.CrudUtil;
import com.crud.service.service.persistence.impl.constants.FOOPersistenceConstants;

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
import com.liferay.portal.kernel.uuid.PortalUUID;

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
 * The persistence implementation for the crud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {CrudPersistence.class, BasePersistence.class})
public class CrudPersistenceImpl
	extends BasePersistenceImpl<Crud> implements CrudPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CrudUtil</code> to access the crud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CrudImpl.class.getName();

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
	 * Returns all the cruds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cruds
	 */
	@Override
	public List<Crud> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cruds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of matching cruds
	 */
	@Override
	public List<Crud> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cruds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cruds
	 */
	@Override
	public List<Crud> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Crud> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cruds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cruds
	 */
	@Override
	public List<Crud> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Crud> orderByComparator, boolean useFinderCache) {

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

		List<Crud> list = null;

		if (useFinderCache) {
			list = (List<Crud>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Crud crud : list) {
					if (!uuid.equals(crud.getUuid())) {
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

			sb.append(_SQL_SELECT_CRUD_WHERE);

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
				sb.append(CrudModelImpl.ORDER_BY_JPQL);
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

				list = (List<Crud>)QueryUtil.list(
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
	 * Returns the first crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	@Override
	public Crud findByUuid_First(
			String uuid, OrderByComparator<Crud> orderByComparator)
		throws NoSuchCrudException {

		Crud crud = fetchByUuid_First(uuid, orderByComparator);

		if (crud != null) {
			return crud;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCrudException(sb.toString());
	}

	/**
	 * Returns the first crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud, or <code>null</code> if a matching crud could not be found
	 */
	@Override
	public Crud fetchByUuid_First(
		String uuid, OrderByComparator<Crud> orderByComparator) {

		List<Crud> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	@Override
	public Crud findByUuid_Last(
			String uuid, OrderByComparator<Crud> orderByComparator)
		throws NoSuchCrudException {

		Crud crud = fetchByUuid_Last(uuid, orderByComparator);

		if (crud != null) {
			return crud;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCrudException(sb.toString());
	}

	/**
	 * Returns the last crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud, or <code>null</code> if a matching crud could not be found
	 */
	@Override
	public Crud fetchByUuid_Last(
		String uuid, OrderByComparator<Crud> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Crud> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cruds before and after the current crud in the ordered set where uuid = &#63;.
	 *
	 * @param crudId the primary key of the current crud
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crud
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	@Override
	public Crud[] findByUuid_PrevAndNext(
			long crudId, String uuid, OrderByComparator<Crud> orderByComparator)
		throws NoSuchCrudException {

		uuid = Objects.toString(uuid, "");

		Crud crud = findByPrimaryKey(crudId);

		Session session = null;

		try {
			session = openSession();

			Crud[] array = new CrudImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, crud, uuid, orderByComparator, true);

			array[1] = crud;

			array[2] = getByUuid_PrevAndNext(
				session, crud, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Crud getByUuid_PrevAndNext(
		Session session, Crud crud, String uuid,
		OrderByComparator<Crud> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRUD_WHERE);

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
			sb.append(CrudModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(crud)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Crud> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cruds where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Crud crud :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crud);
		}
	}

	/**
	 * Returns the number of cruds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cruds
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRUD_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "crud.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(crud.uuid IS NULL OR crud.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByCrudName;
	private FinderPath _finderPathWithoutPaginationFindByCrudName;
	private FinderPath _finderPathCountByCrudName;

	/**
	 * Returns all the cruds where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @return the matching cruds
	 */
	@Override
	public List<Crud> findByCrudName(String crudName) {
		return findByCrudName(
			crudName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cruds where crudName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudName the crud name
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of matching cruds
	 */
	@Override
	public List<Crud> findByCrudName(String crudName, int start, int end) {
		return findByCrudName(crudName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cruds where crudName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudName the crud name
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cruds
	 */
	@Override
	public List<Crud> findByCrudName(
		String crudName, int start, int end,
		OrderByComparator<Crud> orderByComparator) {

		return findByCrudName(crudName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cruds where crudName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudName the crud name
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cruds
	 */
	@Override
	public List<Crud> findByCrudName(
		String crudName, int start, int end,
		OrderByComparator<Crud> orderByComparator, boolean useFinderCache) {

		crudName = Objects.toString(crudName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCrudName;
				finderArgs = new Object[] {crudName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCrudName;
			finderArgs = new Object[] {crudName, start, end, orderByComparator};
		}

		List<Crud> list = null;

		if (useFinderCache) {
			list = (List<Crud>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Crud crud : list) {
					if (!crudName.equals(crud.getCrudName())) {
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

			sb.append(_SQL_SELECT_CRUD_WHERE);

			boolean bindCrudName = false;

			if (crudName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CRUDNAME_CRUDNAME_3);
			}
			else {
				bindCrudName = true;

				sb.append(_FINDER_COLUMN_CRUDNAME_CRUDNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CrudModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCrudName) {
					queryPos.add(crudName);
				}

				list = (List<Crud>)QueryUtil.list(
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
	 * Returns the first crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	@Override
	public Crud findByCrudName_First(
			String crudName, OrderByComparator<Crud> orderByComparator)
		throws NoSuchCrudException {

		Crud crud = fetchByCrudName_First(crudName, orderByComparator);

		if (crud != null) {
			return crud;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crudName=");
		sb.append(crudName);

		sb.append("}");

		throw new NoSuchCrudException(sb.toString());
	}

	/**
	 * Returns the first crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud, or <code>null</code> if a matching crud could not be found
	 */
	@Override
	public Crud fetchByCrudName_First(
		String crudName, OrderByComparator<Crud> orderByComparator) {

		List<Crud> list = findByCrudName(crudName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	@Override
	public Crud findByCrudName_Last(
			String crudName, OrderByComparator<Crud> orderByComparator)
		throws NoSuchCrudException {

		Crud crud = fetchByCrudName_Last(crudName, orderByComparator);

		if (crud != null) {
			return crud;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crudName=");
		sb.append(crudName);

		sb.append("}");

		throw new NoSuchCrudException(sb.toString());
	}

	/**
	 * Returns the last crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud, or <code>null</code> if a matching crud could not be found
	 */
	@Override
	public Crud fetchByCrudName_Last(
		String crudName, OrderByComparator<Crud> orderByComparator) {

		int count = countByCrudName(crudName);

		if (count == 0) {
			return null;
		}

		List<Crud> list = findByCrudName(
			crudName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cruds before and after the current crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudId the primary key of the current crud
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crud
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	@Override
	public Crud[] findByCrudName_PrevAndNext(
			long crudId, String crudName,
			OrderByComparator<Crud> orderByComparator)
		throws NoSuchCrudException {

		crudName = Objects.toString(crudName, "");

		Crud crud = findByPrimaryKey(crudId);

		Session session = null;

		try {
			session = openSession();

			Crud[] array = new CrudImpl[3];

			array[0] = getByCrudName_PrevAndNext(
				session, crud, crudName, orderByComparator, true);

			array[1] = crud;

			array[2] = getByCrudName_PrevAndNext(
				session, crud, crudName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Crud getByCrudName_PrevAndNext(
		Session session, Crud crud, String crudName,
		OrderByComparator<Crud> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CRUD_WHERE);

		boolean bindCrudName = false;

		if (crudName.isEmpty()) {
			sb.append(_FINDER_COLUMN_CRUDNAME_CRUDNAME_3);
		}
		else {
			bindCrudName = true;

			sb.append(_FINDER_COLUMN_CRUDNAME_CRUDNAME_2);
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
			sb.append(CrudModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCrudName) {
			queryPos.add(crudName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(crud)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Crud> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cruds where crudName = &#63; from the database.
	 *
	 * @param crudName the crud name
	 */
	@Override
	public void removeByCrudName(String crudName) {
		for (Crud crud :
				findByCrudName(
					crudName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crud);
		}
	}

	/**
	 * Returns the number of cruds where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @return the number of matching cruds
	 */
	@Override
	public int countByCrudName(String crudName) {
		crudName = Objects.toString(crudName, "");

		FinderPath finderPath = _finderPathCountByCrudName;

		Object[] finderArgs = new Object[] {crudName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRUD_WHERE);

			boolean bindCrudName = false;

			if (crudName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CRUDNAME_CRUDNAME_3);
			}
			else {
				bindCrudName = true;

				sb.append(_FINDER_COLUMN_CRUDNAME_CRUDNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCrudName) {
					queryPos.add(crudName);
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

	private static final String _FINDER_COLUMN_CRUDNAME_CRUDNAME_2 =
		"crud.crudName = ?";

	private static final String _FINDER_COLUMN_CRUDNAME_CRUDNAME_3 =
		"(crud.crudName IS NULL OR crud.crudName = '')";

	private FinderPath _finderPathWithPaginationFindByCrudId;
	private FinderPath _finderPathWithoutPaginationFindByCrudId;
	private FinderPath _finderPathCountByCrudId;

	/**
	 * Returns all the cruds where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @return the matching cruds
	 */
	@Override
	public List<Crud> findByCrudId(long crudId) {
		return findByCrudId(crudId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cruds where crudId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudId the crud ID
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of matching cruds
	 */
	@Override
	public List<Crud> findByCrudId(long crudId, int start, int end) {
		return findByCrudId(crudId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cruds where crudId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudId the crud ID
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cruds
	 */
	@Override
	public List<Crud> findByCrudId(
		long crudId, int start, int end,
		OrderByComparator<Crud> orderByComparator) {

		return findByCrudId(crudId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cruds where crudId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudId the crud ID
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cruds
	 */
	@Override
	public List<Crud> findByCrudId(
		long crudId, int start, int end,
		OrderByComparator<Crud> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCrudId;
				finderArgs = new Object[] {crudId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCrudId;
			finderArgs = new Object[] {crudId, start, end, orderByComparator};
		}

		List<Crud> list = null;

		if (useFinderCache) {
			list = (List<Crud>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Crud crud : list) {
					if (crudId != crud.getCrudId()) {
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

			sb.append(_SQL_SELECT_CRUD_WHERE);

			sb.append(_FINDER_COLUMN_CRUDID_CRUDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CrudModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crudId);

				list = (List<Crud>)QueryUtil.list(
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
	 * Returns the first crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	@Override
	public Crud findByCrudId_First(
			long crudId, OrderByComparator<Crud> orderByComparator)
		throws NoSuchCrudException {

		Crud crud = fetchByCrudId_First(crudId, orderByComparator);

		if (crud != null) {
			return crud;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crudId=");
		sb.append(crudId);

		sb.append("}");

		throw new NoSuchCrudException(sb.toString());
	}

	/**
	 * Returns the first crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud, or <code>null</code> if a matching crud could not be found
	 */
	@Override
	public Crud fetchByCrudId_First(
		long crudId, OrderByComparator<Crud> orderByComparator) {

		List<Crud> list = findByCrudId(crudId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	@Override
	public Crud findByCrudId_Last(
			long crudId, OrderByComparator<Crud> orderByComparator)
		throws NoSuchCrudException {

		Crud crud = fetchByCrudId_Last(crudId, orderByComparator);

		if (crud != null) {
			return crud;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("crudId=");
		sb.append(crudId);

		sb.append("}");

		throw new NoSuchCrudException(sb.toString());
	}

	/**
	 * Returns the last crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud, or <code>null</code> if a matching crud could not be found
	 */
	@Override
	public Crud fetchByCrudId_Last(
		long crudId, OrderByComparator<Crud> orderByComparator) {

		int count = countByCrudId(crudId);

		if (count == 0) {
			return null;
		}

		List<Crud> list = findByCrudId(
			crudId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the cruds where crudId = &#63; from the database.
	 *
	 * @param crudId the crud ID
	 */
	@Override
	public void removeByCrudId(long crudId) {
		for (Crud crud :
				findByCrudId(
					crudId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(crud);
		}
	}

	/**
	 * Returns the number of cruds where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @return the number of matching cruds
	 */
	@Override
	public int countByCrudId(long crudId) {
		FinderPath finderPath = _finderPathCountByCrudId;

		Object[] finderArgs = new Object[] {crudId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CRUD_WHERE);

			sb.append(_FINDER_COLUMN_CRUDID_CRUDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(crudId);

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

	private static final String _FINDER_COLUMN_CRUDID_CRUDID_2 =
		"crud.crudId = ?";

	public CrudPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Crud.class);

		setModelImplClass(CrudImpl.class);
		setModelPKClass(long.class);

		setTable(CrudTable.INSTANCE);
	}

	/**
	 * Caches the crud in the entity cache if it is enabled.
	 *
	 * @param crud the crud
	 */
	@Override
	public void cacheResult(Crud crud) {
		entityCache.putResult(CrudImpl.class, crud.getPrimaryKey(), crud);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cruds in the entity cache if it is enabled.
	 *
	 * @param cruds the cruds
	 */
	@Override
	public void cacheResult(List<Crud> cruds) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cruds.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Crud crud : cruds) {
			if (entityCache.getResult(CrudImpl.class, crud.getPrimaryKey()) ==
					null) {

				cacheResult(crud);
			}
		}
	}

	/**
	 * Clears the cache for all cruds.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CrudImpl.class);

		finderCache.clearCache(CrudImpl.class);
	}

	/**
	 * Clears the cache for the crud.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Crud crud) {
		entityCache.removeResult(CrudImpl.class, crud);
	}

	@Override
	public void clearCache(List<Crud> cruds) {
		for (Crud crud : cruds) {
			entityCache.removeResult(CrudImpl.class, crud);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CrudImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CrudImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new crud with the primary key. Does not add the crud to the database.
	 *
	 * @param crudId the primary key for the new crud
	 * @return the new crud
	 */
	@Override
	public Crud create(long crudId) {
		Crud crud = new CrudImpl();

		crud.setNew(true);
		crud.setPrimaryKey(crudId);

		String uuid = _portalUUID.generate();

		crud.setUuid(uuid);

		return crud;
	}

	/**
	 * Removes the crud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud that was removed
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	@Override
	public Crud remove(long crudId) throws NoSuchCrudException {
		return remove((Serializable)crudId);
	}

	/**
	 * Removes the crud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the crud
	 * @return the crud that was removed
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	@Override
	public Crud remove(Serializable primaryKey) throws NoSuchCrudException {
		Session session = null;

		try {
			session = openSession();

			Crud crud = (Crud)session.get(CrudImpl.class, primaryKey);

			if (crud == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCrudException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(crud);
		}
		catch (NoSuchCrudException noSuchEntityException) {
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
	protected Crud removeImpl(Crud crud) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(crud)) {
				crud = (Crud)session.get(
					CrudImpl.class, crud.getPrimaryKeyObj());
			}

			if (crud != null) {
				session.delete(crud);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (crud != null) {
			clearCache(crud);
		}

		return crud;
	}

	@Override
	public Crud updateImpl(Crud crud) {
		boolean isNew = crud.isNew();

		if (!(crud instanceof CrudModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(crud.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(crud);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in crud proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Crud implementation " +
					crud.getClass());
		}

		CrudModelImpl crudModelImpl = (CrudModelImpl)crud;

		if (Validator.isNull(crud.getUuid())) {
			String uuid = _portalUUID.generate();

			crud.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(crud);
			}
			else {
				crud = (Crud)session.merge(crud);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(CrudImpl.class, crudModelImpl, false, true);

		if (isNew) {
			crud.setNew(false);
		}

		crud.resetOriginalValues();

		return crud;
	}

	/**
	 * Returns the crud with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the crud
	 * @return the crud
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	@Override
	public Crud findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCrudException {

		Crud crud = fetchByPrimaryKey(primaryKey);

		if (crud == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCrudException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return crud;
	}

	/**
	 * Returns the crud with the primary key or throws a <code>NoSuchCrudException</code> if it could not be found.
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	@Override
	public Crud findByPrimaryKey(long crudId) throws NoSuchCrudException {
		return findByPrimaryKey((Serializable)crudId);
	}

	/**
	 * Returns the crud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud, or <code>null</code> if a crud with the primary key could not be found
	 */
	@Override
	public Crud fetchByPrimaryKey(long crudId) {
		return fetchByPrimaryKey((Serializable)crudId);
	}

	/**
	 * Returns all the cruds.
	 *
	 * @return the cruds
	 */
	@Override
	public List<Crud> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cruds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of cruds
	 */
	@Override
	public List<Crud> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cruds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cruds
	 */
	@Override
	public List<Crud> findAll(
		int start, int end, OrderByComparator<Crud> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cruds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cruds
	 */
	@Override
	public List<Crud> findAll(
		int start, int end, OrderByComparator<Crud> orderByComparator,
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

		List<Crud> list = null;

		if (useFinderCache) {
			list = (List<Crud>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CRUD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CRUD;

				sql = sql.concat(CrudModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Crud>)QueryUtil.list(
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
	 * Removes all the cruds from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Crud crud : findAll()) {
			remove(crud);
		}
	}

	/**
	 * Returns the number of cruds.
	 *
	 * @return the number of cruds
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CRUD);

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
		return "crudId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CRUD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CrudModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the crud persistence.
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

		_finderPathWithPaginationFindByCrudName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCrudName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"crudName"}, true);

		_finderPathWithoutPaginationFindByCrudName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCrudName",
			new String[] {String.class.getName()}, new String[] {"crudName"},
			true);

		_finderPathCountByCrudName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCrudName",
			new String[] {String.class.getName()}, new String[] {"crudName"},
			false);

		_finderPathWithPaginationFindByCrudId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCrudId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"crudId"}, true);

		_finderPathWithoutPaginationFindByCrudId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCrudId",
			new String[] {Long.class.getName()}, new String[] {"crudId"}, true);

		_finderPathCountByCrudId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCrudId",
			new String[] {Long.class.getName()}, new String[] {"crudId"},
			false);

		_setCrudUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCrudUtilPersistence(null);

		entityCache.removeCache(CrudImpl.class.getName());
	}

	private void _setCrudUtilPersistence(CrudPersistence crudPersistence) {
		try {
			Field field = CrudUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, crudPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CRUD = "SELECT crud FROM Crud crud";

	private static final String _SQL_SELECT_CRUD_WHERE =
		"SELECT crud FROM Crud crud WHERE ";

	private static final String _SQL_COUNT_CRUD =
		"SELECT COUNT(crud) FROM Crud crud";

	private static final String _SQL_COUNT_CRUD_WHERE =
		"SELECT COUNT(crud) FROM Crud crud WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "crud.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Crud exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Crud exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CrudPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private CrudModelArgumentsResolver _crudModelArgumentsResolver;

}