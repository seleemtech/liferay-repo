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

import com.prime.data.service.exception.NoSuchWorkTypeException;
import com.prime.data.service.model.WorkType;
import com.prime.data.service.model.WorkTypeTable;
import com.prime.data.service.model.impl.WorkTypeImpl;
import com.prime.data.service.model.impl.WorkTypeModelImpl;
import com.prime.data.service.service.persistence.WorkTypePersistence;
import com.prime.data.service.service.persistence.WorkTypeUtil;
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
 * The persistence implementation for the work type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {WorkTypePersistence.class, BasePersistence.class})
public class WorkTypePersistenceImpl
	extends BasePersistenceImpl<WorkType> implements WorkTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkTypeUtil</code> to access the work type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkTypeImpl.class.getName();

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
	 * Returns all the work types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work types
	 */
	@Override
	public List<WorkType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @return the range of matching work types
	 */
	@Override
	public List<WorkType> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work types
	 */
	@Override
	public List<WorkType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work types
	 */
	@Override
	public List<WorkType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkType> orderByComparator, boolean useFinderCache) {

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

		List<WorkType> list = null;

		if (useFinderCache) {
			list = (List<WorkType>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkType workType : list) {
					if (!uuid.equals(workType.getUuid())) {
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

			sb.append(_SQL_SELECT_WORKTYPE_WHERE);

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
				sb.append(WorkTypeModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkType>)QueryUtil.list(
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
	 * Returns the first work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work type
	 * @throws NoSuchWorkTypeException if a matching work type could not be found
	 */
	@Override
	public WorkType findByUuid_First(
			String uuid, OrderByComparator<WorkType> orderByComparator)
		throws NoSuchWorkTypeException {

		WorkType workType = fetchByUuid_First(uuid, orderByComparator);

		if (workType != null) {
			return workType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkTypeException(sb.toString());
	}

	/**
	 * Returns the first work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work type, or <code>null</code> if a matching work type could not be found
	 */
	@Override
	public WorkType fetchByUuid_First(
		String uuid, OrderByComparator<WorkType> orderByComparator) {

		List<WorkType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work type
	 * @throws NoSuchWorkTypeException if a matching work type could not be found
	 */
	@Override
	public WorkType findByUuid_Last(
			String uuid, OrderByComparator<WorkType> orderByComparator)
		throws NoSuchWorkTypeException {

		WorkType workType = fetchByUuid_Last(uuid, orderByComparator);

		if (workType != null) {
			return workType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkTypeException(sb.toString());
	}

	/**
	 * Returns the last work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work type, or <code>null</code> if a matching work type could not be found
	 */
	@Override
	public WorkType fetchByUuid_Last(
		String uuid, OrderByComparator<WorkType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<WorkType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work types before and after the current work type in the ordered set where uuid = &#63;.
	 *
	 * @param workTypeId the primary key of the current work type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work type
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	@Override
	public WorkType[] findByUuid_PrevAndNext(
			long workTypeId, String uuid,
			OrderByComparator<WorkType> orderByComparator)
		throws NoSuchWorkTypeException {

		uuid = Objects.toString(uuid, "");

		WorkType workType = findByPrimaryKey(workTypeId);

		Session session = null;

		try {
			session = openSession();

			WorkType[] array = new WorkTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, workType, uuid, orderByComparator, true);

			array[1] = workType;

			array[2] = getByUuid_PrevAndNext(
				session, workType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkType getByUuid_PrevAndNext(
		Session session, WorkType workType, String uuid,
		OrderByComparator<WorkType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKTYPE_WHERE);

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
			sb.append(WorkTypeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(workType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (WorkType workType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workType);
		}
	}

	/**
	 * Returns the number of work types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKTYPE_WHERE);

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
		"workType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(workType.uuid IS NULL OR workType.uuid = '')";

	public WorkTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkType.class);

		setModelImplClass(WorkTypeImpl.class);
		setModelPKClass(long.class);

		setTable(WorkTypeTable.INSTANCE);
	}

	/**
	 * Caches the work type in the entity cache if it is enabled.
	 *
	 * @param workType the work type
	 */
	@Override
	public void cacheResult(WorkType workType) {
		entityCache.putResult(
			WorkTypeImpl.class, workType.getPrimaryKey(), workType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the work types in the entity cache if it is enabled.
	 *
	 * @param workTypes the work types
	 */
	@Override
	public void cacheResult(List<WorkType> workTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (workTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (WorkType workType : workTypes) {
			if (entityCache.getResult(
					WorkTypeImpl.class, workType.getPrimaryKey()) == null) {

				cacheResult(workType);
			}
		}
	}

	/**
	 * Clears the cache for all work types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkTypeImpl.class);

		finderCache.clearCache(WorkTypeImpl.class);
	}

	/**
	 * Clears the cache for the work type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkType workType) {
		entityCache.removeResult(WorkTypeImpl.class, workType);
	}

	@Override
	public void clearCache(List<WorkType> workTypes) {
		for (WorkType workType : workTypes) {
			entityCache.removeResult(WorkTypeImpl.class, workType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(WorkTypeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WorkTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new work type with the primary key. Does not add the work type to the database.
	 *
	 * @param workTypeId the primary key for the new work type
	 * @return the new work type
	 */
	@Override
	public WorkType create(long workTypeId) {
		WorkType workType = new WorkTypeImpl();

		workType.setNew(true);
		workType.setPrimaryKey(workTypeId);

		String uuid = PortalUUIDUtil.generate();

		workType.setUuid(uuid);

		return workType;
	}

	/**
	 * Removes the work type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type that was removed
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	@Override
	public WorkType remove(long workTypeId) throws NoSuchWorkTypeException {
		return remove((Serializable)workTypeId);
	}

	/**
	 * Removes the work type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work type
	 * @return the work type that was removed
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	@Override
	public WorkType remove(Serializable primaryKey)
		throws NoSuchWorkTypeException {

		Session session = null;

		try {
			session = openSession();

			WorkType workType = (WorkType)session.get(
				WorkTypeImpl.class, primaryKey);

			if (workType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workType);
		}
		catch (NoSuchWorkTypeException noSuchEntityException) {
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
	protected WorkType removeImpl(WorkType workType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workType)) {
				workType = (WorkType)session.get(
					WorkTypeImpl.class, workType.getPrimaryKeyObj());
			}

			if (workType != null) {
				session.delete(workType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workType != null) {
			clearCache(workType);
		}

		return workType;
	}

	@Override
	public WorkType updateImpl(WorkType workType) {
		boolean isNew = workType.isNew();

		if (!(workType instanceof WorkTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(workType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkType implementation " +
					workType.getClass());
		}

		WorkTypeModelImpl workTypeModelImpl = (WorkTypeModelImpl)workType;

		if (Validator.isNull(workType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			workType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workType);
			}
			else {
				workType = (WorkType)session.merge(workType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WorkTypeImpl.class, workTypeModelImpl, false, true);

		if (isNew) {
			workType.setNew(false);
		}

		workType.resetOriginalValues();

		return workType;
	}

	/**
	 * Returns the work type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work type
	 * @return the work type
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	@Override
	public WorkType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkTypeException {

		WorkType workType = fetchByPrimaryKey(primaryKey);

		if (workType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workType;
	}

	/**
	 * Returns the work type with the primary key or throws a <code>NoSuchWorkTypeException</code> if it could not be found.
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	@Override
	public WorkType findByPrimaryKey(long workTypeId)
		throws NoSuchWorkTypeException {

		return findByPrimaryKey((Serializable)workTypeId);
	}

	/**
	 * Returns the work type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type, or <code>null</code> if a work type with the primary key could not be found
	 */
	@Override
	public WorkType fetchByPrimaryKey(long workTypeId) {
		return fetchByPrimaryKey((Serializable)workTypeId);
	}

	/**
	 * Returns all the work types.
	 *
	 * @return the work types
	 */
	@Override
	public List<WorkType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @return the range of work types
	 */
	@Override
	public List<WorkType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work types
	 */
	@Override
	public List<WorkType> findAll(
		int start, int end, OrderByComparator<WorkType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work types
	 */
	@Override
	public List<WorkType> findAll(
		int start, int end, OrderByComparator<WorkType> orderByComparator,
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

		List<WorkType> list = null;

		if (useFinderCache) {
			list = (List<WorkType>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKTYPE;

				sql = sql.concat(WorkTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkType>)QueryUtil.list(
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
	 * Removes all the work types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkType workType : findAll()) {
			remove(workType);
		}
	}

	/**
	 * Returns the number of work types.
	 *
	 * @return the number of work types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WORKTYPE);

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
		return "workTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WORKTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work type persistence.
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

		_setWorkTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setWorkTypeUtilPersistence(null);

		entityCache.removeCache(WorkTypeImpl.class.getName());
	}

	private void _setWorkTypeUtilPersistence(
		WorkTypePersistence workTypePersistence) {

		try {
			Field field = WorkTypeUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, workTypePersistence);
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

	private static final String _SQL_SELECT_WORKTYPE =
		"SELECT workType FROM WorkType workType";

	private static final String _SQL_SELECT_WORKTYPE_WHERE =
		"SELECT workType FROM WorkType workType WHERE ";

	private static final String _SQL_COUNT_WORKTYPE =
		"SELECT COUNT(workType) FROM WorkType workType";

	private static final String _SQL_COUNT_WORKTYPE_WHERE =
		"SELECT COUNT(workType) FROM WorkType workType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private WorkTypeModelArgumentsResolver _workTypeModelArgumentsResolver;

}