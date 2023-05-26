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

import com.prime.data.service.exception.NoSuchCurrJobTitleException;
import com.prime.data.service.model.CurrJobTitle;
import com.prime.data.service.model.CurrJobTitleTable;
import com.prime.data.service.model.impl.CurrJobTitleImpl;
import com.prime.data.service.model.impl.CurrJobTitleModelImpl;
import com.prime.data.service.service.persistence.CurrJobTitlePersistence;
import com.prime.data.service.service.persistence.CurrJobTitleUtil;
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
 * The persistence implementation for the curr job title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {CurrJobTitlePersistence.class, BasePersistence.class})
public class CurrJobTitlePersistenceImpl
	extends BasePersistenceImpl<CurrJobTitle>
	implements CurrJobTitlePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CurrJobTitleUtil</code> to access the curr job title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CurrJobTitleImpl.class.getName();

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
	 * Returns all the curr job titles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching curr job titles
	 */
	@Override
	public List<CurrJobTitle> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the curr job titles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @return the range of matching curr job titles
	 */
	@Override
	public List<CurrJobTitle> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the curr job titles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching curr job titles
	 */
	@Override
	public List<CurrJobTitle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CurrJobTitle> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the curr job titles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching curr job titles
	 */
	@Override
	public List<CurrJobTitle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CurrJobTitle> orderByComparator,
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

		List<CurrJobTitle> list = null;

		if (useFinderCache) {
			list = (List<CurrJobTitle>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CurrJobTitle currJobTitle : list) {
					if (!uuid.equals(currJobTitle.getUuid())) {
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

			sb.append(_SQL_SELECT_CURRJOBTITLE_WHERE);

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
				sb.append(CurrJobTitleModelImpl.ORDER_BY_JPQL);
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

				list = (List<CurrJobTitle>)QueryUtil.list(
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
	 * Returns the first curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curr job title
	 * @throws NoSuchCurrJobTitleException if a matching curr job title could not be found
	 */
	@Override
	public CurrJobTitle findByUuid_First(
			String uuid, OrderByComparator<CurrJobTitle> orderByComparator)
		throws NoSuchCurrJobTitleException {

		CurrJobTitle currJobTitle = fetchByUuid_First(uuid, orderByComparator);

		if (currJobTitle != null) {
			return currJobTitle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCurrJobTitleException(sb.toString());
	}

	/**
	 * Returns the first curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curr job title, or <code>null</code> if a matching curr job title could not be found
	 */
	@Override
	public CurrJobTitle fetchByUuid_First(
		String uuid, OrderByComparator<CurrJobTitle> orderByComparator) {

		List<CurrJobTitle> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curr job title
	 * @throws NoSuchCurrJobTitleException if a matching curr job title could not be found
	 */
	@Override
	public CurrJobTitle findByUuid_Last(
			String uuid, OrderByComparator<CurrJobTitle> orderByComparator)
		throws NoSuchCurrJobTitleException {

		CurrJobTitle currJobTitle = fetchByUuid_Last(uuid, orderByComparator);

		if (currJobTitle != null) {
			return currJobTitle;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCurrJobTitleException(sb.toString());
	}

	/**
	 * Returns the last curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curr job title, or <code>null</code> if a matching curr job title could not be found
	 */
	@Override
	public CurrJobTitle fetchByUuid_Last(
		String uuid, OrderByComparator<CurrJobTitle> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CurrJobTitle> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the curr job titles before and after the current curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param currJobTitleId the primary key of the current curr job title
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next curr job title
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	@Override
	public CurrJobTitle[] findByUuid_PrevAndNext(
			long currJobTitleId, String uuid,
			OrderByComparator<CurrJobTitle> orderByComparator)
		throws NoSuchCurrJobTitleException {

		uuid = Objects.toString(uuid, "");

		CurrJobTitle currJobTitle = findByPrimaryKey(currJobTitleId);

		Session session = null;

		try {
			session = openSession();

			CurrJobTitle[] array = new CurrJobTitleImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, currJobTitle, uuid, orderByComparator, true);

			array[1] = currJobTitle;

			array[2] = getByUuid_PrevAndNext(
				session, currJobTitle, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CurrJobTitle getByUuid_PrevAndNext(
		Session session, CurrJobTitle currJobTitle, String uuid,
		OrderByComparator<CurrJobTitle> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CURRJOBTITLE_WHERE);

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
			sb.append(CurrJobTitleModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(currJobTitle)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CurrJobTitle> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the curr job titles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CurrJobTitle currJobTitle :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(currJobTitle);
		}
	}

	/**
	 * Returns the number of curr job titles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching curr job titles
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CURRJOBTITLE_WHERE);

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
		"currJobTitle.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(currJobTitle.uuid IS NULL OR currJobTitle.uuid = '')";

	public CurrJobTitlePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CurrJobTitle.class);

		setModelImplClass(CurrJobTitleImpl.class);
		setModelPKClass(long.class);

		setTable(CurrJobTitleTable.INSTANCE);
	}

	/**
	 * Caches the curr job title in the entity cache if it is enabled.
	 *
	 * @param currJobTitle the curr job title
	 */
	@Override
	public void cacheResult(CurrJobTitle currJobTitle) {
		entityCache.putResult(
			CurrJobTitleImpl.class, currJobTitle.getPrimaryKey(), currJobTitle);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the curr job titles in the entity cache if it is enabled.
	 *
	 * @param currJobTitles the curr job titles
	 */
	@Override
	public void cacheResult(List<CurrJobTitle> currJobTitles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (currJobTitles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CurrJobTitle currJobTitle : currJobTitles) {
			if (entityCache.getResult(
					CurrJobTitleImpl.class, currJobTitle.getPrimaryKey()) ==
						null) {

				cacheResult(currJobTitle);
			}
		}
	}

	/**
	 * Clears the cache for all curr job titles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CurrJobTitleImpl.class);

		finderCache.clearCache(CurrJobTitleImpl.class);
	}

	/**
	 * Clears the cache for the curr job title.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CurrJobTitle currJobTitle) {
		entityCache.removeResult(CurrJobTitleImpl.class, currJobTitle);
	}

	@Override
	public void clearCache(List<CurrJobTitle> currJobTitles) {
		for (CurrJobTitle currJobTitle : currJobTitles) {
			entityCache.removeResult(CurrJobTitleImpl.class, currJobTitle);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CurrJobTitleImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CurrJobTitleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new curr job title with the primary key. Does not add the curr job title to the database.
	 *
	 * @param currJobTitleId the primary key for the new curr job title
	 * @return the new curr job title
	 */
	@Override
	public CurrJobTitle create(long currJobTitleId) {
		CurrJobTitle currJobTitle = new CurrJobTitleImpl();

		currJobTitle.setNew(true);
		currJobTitle.setPrimaryKey(currJobTitleId);

		String uuid = PortalUUIDUtil.generate();

		currJobTitle.setUuid(uuid);

		return currJobTitle;
	}

	/**
	 * Removes the curr job title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title that was removed
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	@Override
	public CurrJobTitle remove(long currJobTitleId)
		throws NoSuchCurrJobTitleException {

		return remove((Serializable)currJobTitleId);
	}

	/**
	 * Removes the curr job title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the curr job title
	 * @return the curr job title that was removed
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	@Override
	public CurrJobTitle remove(Serializable primaryKey)
		throws NoSuchCurrJobTitleException {

		Session session = null;

		try {
			session = openSession();

			CurrJobTitle currJobTitle = (CurrJobTitle)session.get(
				CurrJobTitleImpl.class, primaryKey);

			if (currJobTitle == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCurrJobTitleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(currJobTitle);
		}
		catch (NoSuchCurrJobTitleException noSuchEntityException) {
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
	protected CurrJobTitle removeImpl(CurrJobTitle currJobTitle) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(currJobTitle)) {
				currJobTitle = (CurrJobTitle)session.get(
					CurrJobTitleImpl.class, currJobTitle.getPrimaryKeyObj());
			}

			if (currJobTitle != null) {
				session.delete(currJobTitle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (currJobTitle != null) {
			clearCache(currJobTitle);
		}

		return currJobTitle;
	}

	@Override
	public CurrJobTitle updateImpl(CurrJobTitle currJobTitle) {
		boolean isNew = currJobTitle.isNew();

		if (!(currJobTitle instanceof CurrJobTitleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(currJobTitle.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					currJobTitle);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in currJobTitle proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CurrJobTitle implementation " +
					currJobTitle.getClass());
		}

		CurrJobTitleModelImpl currJobTitleModelImpl =
			(CurrJobTitleModelImpl)currJobTitle;

		if (Validator.isNull(currJobTitle.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			currJobTitle.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(currJobTitle);
			}
			else {
				currJobTitle = (CurrJobTitle)session.merge(currJobTitle);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CurrJobTitleImpl.class, currJobTitleModelImpl, false, true);

		if (isNew) {
			currJobTitle.setNew(false);
		}

		currJobTitle.resetOriginalValues();

		return currJobTitle;
	}

	/**
	 * Returns the curr job title with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the curr job title
	 * @return the curr job title
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	@Override
	public CurrJobTitle findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCurrJobTitleException {

		CurrJobTitle currJobTitle = fetchByPrimaryKey(primaryKey);

		if (currJobTitle == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCurrJobTitleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return currJobTitle;
	}

	/**
	 * Returns the curr job title with the primary key or throws a <code>NoSuchCurrJobTitleException</code> if it could not be found.
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	@Override
	public CurrJobTitle findByPrimaryKey(long currJobTitleId)
		throws NoSuchCurrJobTitleException {

		return findByPrimaryKey((Serializable)currJobTitleId);
	}

	/**
	 * Returns the curr job title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title, or <code>null</code> if a curr job title with the primary key could not be found
	 */
	@Override
	public CurrJobTitle fetchByPrimaryKey(long currJobTitleId) {
		return fetchByPrimaryKey((Serializable)currJobTitleId);
	}

	/**
	 * Returns all the curr job titles.
	 *
	 * @return the curr job titles
	 */
	@Override
	public List<CurrJobTitle> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the curr job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @return the range of curr job titles
	 */
	@Override
	public List<CurrJobTitle> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the curr job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of curr job titles
	 */
	@Override
	public List<CurrJobTitle> findAll(
		int start, int end, OrderByComparator<CurrJobTitle> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the curr job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of curr job titles
	 */
	@Override
	public List<CurrJobTitle> findAll(
		int start, int end, OrderByComparator<CurrJobTitle> orderByComparator,
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

		List<CurrJobTitle> list = null;

		if (useFinderCache) {
			list = (List<CurrJobTitle>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CURRJOBTITLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CURRJOBTITLE;

				sql = sql.concat(CurrJobTitleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CurrJobTitle>)QueryUtil.list(
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
	 * Removes all the curr job titles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CurrJobTitle currJobTitle : findAll()) {
			remove(currJobTitle);
		}
	}

	/**
	 * Returns the number of curr job titles.
	 *
	 * @return the number of curr job titles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CURRJOBTITLE);

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
		return "currJobTitleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CURRJOBTITLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CurrJobTitleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the curr job title persistence.
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

		_setCurrJobTitleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCurrJobTitleUtilPersistence(null);

		entityCache.removeCache(CurrJobTitleImpl.class.getName());
	}

	private void _setCurrJobTitleUtilPersistence(
		CurrJobTitlePersistence currJobTitlePersistence) {

		try {
			Field field = CurrJobTitleUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, currJobTitlePersistence);
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

	private static final String _SQL_SELECT_CURRJOBTITLE =
		"SELECT currJobTitle FROM CurrJobTitle currJobTitle";

	private static final String _SQL_SELECT_CURRJOBTITLE_WHERE =
		"SELECT currJobTitle FROM CurrJobTitle currJobTitle WHERE ";

	private static final String _SQL_COUNT_CURRJOBTITLE =
		"SELECT COUNT(currJobTitle) FROM CurrJobTitle currJobTitle";

	private static final String _SQL_COUNT_CURRJOBTITLE_WHERE =
		"SELECT COUNT(currJobTitle) FROM CurrJobTitle currJobTitle WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "currJobTitle.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CurrJobTitle exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CurrJobTitle exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CurrJobTitlePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CurrJobTitleModelArgumentsResolver
		_currJobTitleModelArgumentsResolver;

}