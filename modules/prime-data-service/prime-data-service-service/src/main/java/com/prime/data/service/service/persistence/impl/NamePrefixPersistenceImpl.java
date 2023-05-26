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

import com.prime.data.service.exception.NoSuchNamePrefixException;
import com.prime.data.service.model.NamePrefix;
import com.prime.data.service.model.NamePrefixTable;
import com.prime.data.service.model.impl.NamePrefixImpl;
import com.prime.data.service.model.impl.NamePrefixModelImpl;
import com.prime.data.service.service.persistence.NamePrefixPersistence;
import com.prime.data.service.service.persistence.NamePrefixUtil;
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
 * The persistence implementation for the name prefix service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {NamePrefixPersistence.class, BasePersistence.class})
public class NamePrefixPersistenceImpl
	extends BasePersistenceImpl<NamePrefix> implements NamePrefixPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NamePrefixUtil</code> to access the name prefix persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NamePrefixImpl.class.getName();

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
	 * Returns all the name prefixes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching name prefixes
	 */
	@Override
	public List<NamePrefix> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the name prefixes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @return the range of matching name prefixes
	 */
	@Override
	public List<NamePrefix> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the name prefixes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching name prefixes
	 */
	@Override
	public List<NamePrefix> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NamePrefix> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the name prefixes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching name prefixes
	 */
	@Override
	public List<NamePrefix> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NamePrefix> orderByComparator,
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

		List<NamePrefix> list = null;

		if (useFinderCache) {
			list = (List<NamePrefix>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (NamePrefix namePrefix : list) {
					if (!uuid.equals(namePrefix.getUuid())) {
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

			sb.append(_SQL_SELECT_NAMEPREFIX_WHERE);

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
				sb.append(NamePrefixModelImpl.ORDER_BY_JPQL);
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

				list = (List<NamePrefix>)QueryUtil.list(
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
	 * Returns the first name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching name prefix
	 * @throws NoSuchNamePrefixException if a matching name prefix could not be found
	 */
	@Override
	public NamePrefix findByUuid_First(
			String uuid, OrderByComparator<NamePrefix> orderByComparator)
		throws NoSuchNamePrefixException {

		NamePrefix namePrefix = fetchByUuid_First(uuid, orderByComparator);

		if (namePrefix != null) {
			return namePrefix;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNamePrefixException(sb.toString());
	}

	/**
	 * Returns the first name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching name prefix, or <code>null</code> if a matching name prefix could not be found
	 */
	@Override
	public NamePrefix fetchByUuid_First(
		String uuid, OrderByComparator<NamePrefix> orderByComparator) {

		List<NamePrefix> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching name prefix
	 * @throws NoSuchNamePrefixException if a matching name prefix could not be found
	 */
	@Override
	public NamePrefix findByUuid_Last(
			String uuid, OrderByComparator<NamePrefix> orderByComparator)
		throws NoSuchNamePrefixException {

		NamePrefix namePrefix = fetchByUuid_Last(uuid, orderByComparator);

		if (namePrefix != null) {
			return namePrefix;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNamePrefixException(sb.toString());
	}

	/**
	 * Returns the last name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching name prefix, or <code>null</code> if a matching name prefix could not be found
	 */
	@Override
	public NamePrefix fetchByUuid_Last(
		String uuid, OrderByComparator<NamePrefix> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<NamePrefix> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the name prefixes before and after the current name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param namePrefixId the primary key of the current name prefix
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next name prefix
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	@Override
	public NamePrefix[] findByUuid_PrevAndNext(
			long namePrefixId, String uuid,
			OrderByComparator<NamePrefix> orderByComparator)
		throws NoSuchNamePrefixException {

		uuid = Objects.toString(uuid, "");

		NamePrefix namePrefix = findByPrimaryKey(namePrefixId);

		Session session = null;

		try {
			session = openSession();

			NamePrefix[] array = new NamePrefixImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, namePrefix, uuid, orderByComparator, true);

			array[1] = namePrefix;

			array[2] = getByUuid_PrevAndNext(
				session, namePrefix, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected NamePrefix getByUuid_PrevAndNext(
		Session session, NamePrefix namePrefix, String uuid,
		OrderByComparator<NamePrefix> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_NAMEPREFIX_WHERE);

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
			sb.append(NamePrefixModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(namePrefix)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NamePrefix> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the name prefixes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (NamePrefix namePrefix :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(namePrefix);
		}
	}

	/**
	 * Returns the number of name prefixes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching name prefixes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NAMEPREFIX_WHERE);

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
		"namePrefix.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(namePrefix.uuid IS NULL OR namePrefix.uuid = '')";

	public NamePrefixPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(NamePrefix.class);

		setModelImplClass(NamePrefixImpl.class);
		setModelPKClass(long.class);

		setTable(NamePrefixTable.INSTANCE);
	}

	/**
	 * Caches the name prefix in the entity cache if it is enabled.
	 *
	 * @param namePrefix the name prefix
	 */
	@Override
	public void cacheResult(NamePrefix namePrefix) {
		entityCache.putResult(
			NamePrefixImpl.class, namePrefix.getPrimaryKey(), namePrefix);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the name prefixes in the entity cache if it is enabled.
	 *
	 * @param namePrefixes the name prefixes
	 */
	@Override
	public void cacheResult(List<NamePrefix> namePrefixes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (namePrefixes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (NamePrefix namePrefix : namePrefixes) {
			if (entityCache.getResult(
					NamePrefixImpl.class, namePrefix.getPrimaryKey()) == null) {

				cacheResult(namePrefix);
			}
		}
	}

	/**
	 * Clears the cache for all name prefixes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NamePrefixImpl.class);

		finderCache.clearCache(NamePrefixImpl.class);
	}

	/**
	 * Clears the cache for the name prefix.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NamePrefix namePrefix) {
		entityCache.removeResult(NamePrefixImpl.class, namePrefix);
	}

	@Override
	public void clearCache(List<NamePrefix> namePrefixes) {
		for (NamePrefix namePrefix : namePrefixes) {
			entityCache.removeResult(NamePrefixImpl.class, namePrefix);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(NamePrefixImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NamePrefixImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new name prefix with the primary key. Does not add the name prefix to the database.
	 *
	 * @param namePrefixId the primary key for the new name prefix
	 * @return the new name prefix
	 */
	@Override
	public NamePrefix create(long namePrefixId) {
		NamePrefix namePrefix = new NamePrefixImpl();

		namePrefix.setNew(true);
		namePrefix.setPrimaryKey(namePrefixId);

		String uuid = PortalUUIDUtil.generate();

		namePrefix.setUuid(uuid);

		return namePrefix;
	}

	/**
	 * Removes the name prefix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix that was removed
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	@Override
	public NamePrefix remove(long namePrefixId)
		throws NoSuchNamePrefixException {

		return remove((Serializable)namePrefixId);
	}

	/**
	 * Removes the name prefix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the name prefix
	 * @return the name prefix that was removed
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	@Override
	public NamePrefix remove(Serializable primaryKey)
		throws NoSuchNamePrefixException {

		Session session = null;

		try {
			session = openSession();

			NamePrefix namePrefix = (NamePrefix)session.get(
				NamePrefixImpl.class, primaryKey);

			if (namePrefix == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNamePrefixException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(namePrefix);
		}
		catch (NoSuchNamePrefixException noSuchEntityException) {
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
	protected NamePrefix removeImpl(NamePrefix namePrefix) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(namePrefix)) {
				namePrefix = (NamePrefix)session.get(
					NamePrefixImpl.class, namePrefix.getPrimaryKeyObj());
			}

			if (namePrefix != null) {
				session.delete(namePrefix);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (namePrefix != null) {
			clearCache(namePrefix);
		}

		return namePrefix;
	}

	@Override
	public NamePrefix updateImpl(NamePrefix namePrefix) {
		boolean isNew = namePrefix.isNew();

		if (!(namePrefix instanceof NamePrefixModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(namePrefix.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(namePrefix);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in namePrefix proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom NamePrefix implementation " +
					namePrefix.getClass());
		}

		NamePrefixModelImpl namePrefixModelImpl =
			(NamePrefixModelImpl)namePrefix;

		if (Validator.isNull(namePrefix.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			namePrefix.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(namePrefix);
			}
			else {
				namePrefix = (NamePrefix)session.merge(namePrefix);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			NamePrefixImpl.class, namePrefixModelImpl, false, true);

		if (isNew) {
			namePrefix.setNew(false);
		}

		namePrefix.resetOriginalValues();

		return namePrefix;
	}

	/**
	 * Returns the name prefix with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the name prefix
	 * @return the name prefix
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	@Override
	public NamePrefix findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNamePrefixException {

		NamePrefix namePrefix = fetchByPrimaryKey(primaryKey);

		if (namePrefix == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNamePrefixException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return namePrefix;
	}

	/**
	 * Returns the name prefix with the primary key or throws a <code>NoSuchNamePrefixException</code> if it could not be found.
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	@Override
	public NamePrefix findByPrimaryKey(long namePrefixId)
		throws NoSuchNamePrefixException {

		return findByPrimaryKey((Serializable)namePrefixId);
	}

	/**
	 * Returns the name prefix with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix, or <code>null</code> if a name prefix with the primary key could not be found
	 */
	@Override
	public NamePrefix fetchByPrimaryKey(long namePrefixId) {
		return fetchByPrimaryKey((Serializable)namePrefixId);
	}

	/**
	 * Returns all the name prefixes.
	 *
	 * @return the name prefixes
	 */
	@Override
	public List<NamePrefix> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the name prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @return the range of name prefixes
	 */
	@Override
	public List<NamePrefix> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the name prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of name prefixes
	 */
	@Override
	public List<NamePrefix> findAll(
		int start, int end, OrderByComparator<NamePrefix> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the name prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of name prefixes
	 */
	@Override
	public List<NamePrefix> findAll(
		int start, int end, OrderByComparator<NamePrefix> orderByComparator,
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

		List<NamePrefix> list = null;

		if (useFinderCache) {
			list = (List<NamePrefix>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NAMEPREFIX);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NAMEPREFIX;

				sql = sql.concat(NamePrefixModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<NamePrefix>)QueryUtil.list(
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
	 * Removes all the name prefixes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NamePrefix namePrefix : findAll()) {
			remove(namePrefix);
		}
	}

	/**
	 * Returns the number of name prefixes.
	 *
	 * @return the number of name prefixes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NAMEPREFIX);

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
		return "namePrefixId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NAMEPREFIX;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NamePrefixModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the name prefix persistence.
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

		_setNamePrefixUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNamePrefixUtilPersistence(null);

		entityCache.removeCache(NamePrefixImpl.class.getName());
	}

	private void _setNamePrefixUtilPersistence(
		NamePrefixPersistence namePrefixPersistence) {

		try {
			Field field = NamePrefixUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, namePrefixPersistence);
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

	private static final String _SQL_SELECT_NAMEPREFIX =
		"SELECT namePrefix FROM NamePrefix namePrefix";

	private static final String _SQL_SELECT_NAMEPREFIX_WHERE =
		"SELECT namePrefix FROM NamePrefix namePrefix WHERE ";

	private static final String _SQL_COUNT_NAMEPREFIX =
		"SELECT COUNT(namePrefix) FROM NamePrefix namePrefix";

	private static final String _SQL_COUNT_NAMEPREFIX_WHERE =
		"SELECT COUNT(namePrefix) FROM NamePrefix namePrefix WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "namePrefix.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No NamePrefix exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No NamePrefix exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NamePrefixPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private NamePrefixModelArgumentsResolver _namePrefixModelArgumentsResolver;

}