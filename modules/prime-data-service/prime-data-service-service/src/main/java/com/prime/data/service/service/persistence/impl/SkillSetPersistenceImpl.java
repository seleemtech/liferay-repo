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

import com.prime.data.service.exception.NoSuchSkillSetException;
import com.prime.data.service.model.SkillSet;
import com.prime.data.service.model.SkillSetTable;
import com.prime.data.service.model.impl.SkillSetImpl;
import com.prime.data.service.model.impl.SkillSetModelImpl;
import com.prime.data.service.service.persistence.SkillSetPersistence;
import com.prime.data.service.service.persistence.SkillSetUtil;
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
 * The persistence implementation for the skill set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {SkillSetPersistence.class, BasePersistence.class})
public class SkillSetPersistenceImpl
	extends BasePersistenceImpl<SkillSet> implements SkillSetPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SkillSetUtil</code> to access the skill set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SkillSetImpl.class.getName();

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
	 * Returns all the skill sets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching skill sets
	 */
	@Override
	public List<SkillSet> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the skill sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkillSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of skill sets
	 * @param end the upper bound of the range of skill sets (not inclusive)
	 * @return the range of matching skill sets
	 */
	@Override
	public List<SkillSet> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the skill sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkillSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of skill sets
	 * @param end the upper bound of the range of skill sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching skill sets
	 */
	@Override
	public List<SkillSet> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SkillSet> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the skill sets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkillSetModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of skill sets
	 * @param end the upper bound of the range of skill sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching skill sets
	 */
	@Override
	public List<SkillSet> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SkillSet> orderByComparator, boolean useFinderCache) {

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

		List<SkillSet> list = null;

		if (useFinderCache) {
			list = (List<SkillSet>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (SkillSet skillSet : list) {
					if (!uuid.equals(skillSet.getUuid())) {
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

			sb.append(_SQL_SELECT_SKILLSET_WHERE);

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
				sb.append(SkillSetModelImpl.ORDER_BY_JPQL);
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

				list = (List<SkillSet>)QueryUtil.list(
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
	 * Returns the first skill set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skill set
	 * @throws NoSuchSkillSetException if a matching skill set could not be found
	 */
	@Override
	public SkillSet findByUuid_First(
			String uuid, OrderByComparator<SkillSet> orderByComparator)
		throws NoSuchSkillSetException {

		SkillSet skillSet = fetchByUuid_First(uuid, orderByComparator);

		if (skillSet != null) {
			return skillSet;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSkillSetException(sb.toString());
	}

	/**
	 * Returns the first skill set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skill set, or <code>null</code> if a matching skill set could not be found
	 */
	@Override
	public SkillSet fetchByUuid_First(
		String uuid, OrderByComparator<SkillSet> orderByComparator) {

		List<SkillSet> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last skill set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skill set
	 * @throws NoSuchSkillSetException if a matching skill set could not be found
	 */
	@Override
	public SkillSet findByUuid_Last(
			String uuid, OrderByComparator<SkillSet> orderByComparator)
		throws NoSuchSkillSetException {

		SkillSet skillSet = fetchByUuid_Last(uuid, orderByComparator);

		if (skillSet != null) {
			return skillSet;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSkillSetException(sb.toString());
	}

	/**
	 * Returns the last skill set in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skill set, or <code>null</code> if a matching skill set could not be found
	 */
	@Override
	public SkillSet fetchByUuid_Last(
		String uuid, OrderByComparator<SkillSet> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SkillSet> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the skill sets before and after the current skill set in the ordered set where uuid = &#63;.
	 *
	 * @param skillSetId the primary key of the current skill set
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next skill set
	 * @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet[] findByUuid_PrevAndNext(
			long skillSetId, String uuid,
			OrderByComparator<SkillSet> orderByComparator)
		throws NoSuchSkillSetException {

		uuid = Objects.toString(uuid, "");

		SkillSet skillSet = findByPrimaryKey(skillSetId);

		Session session = null;

		try {
			session = openSession();

			SkillSet[] array = new SkillSetImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, skillSet, uuid, orderByComparator, true);

			array[1] = skillSet;

			array[2] = getByUuid_PrevAndNext(
				session, skillSet, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SkillSet getByUuid_PrevAndNext(
		Session session, SkillSet skillSet, String uuid,
		OrderByComparator<SkillSet> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SKILLSET_WHERE);

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
			sb.append(SkillSetModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(skillSet)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SkillSet> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the skill sets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SkillSet skillSet :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(skillSet);
		}
	}

	/**
	 * Returns the number of skill sets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching skill sets
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SKILLSET_WHERE);

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
		"skillSet.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(skillSet.uuid IS NULL OR skillSet.uuid = '')";

	public SkillSetPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(SkillSet.class);

		setModelImplClass(SkillSetImpl.class);
		setModelPKClass(long.class);

		setTable(SkillSetTable.INSTANCE);
	}

	/**
	 * Caches the skill set in the entity cache if it is enabled.
	 *
	 * @param skillSet the skill set
	 */
	@Override
	public void cacheResult(SkillSet skillSet) {
		entityCache.putResult(
			SkillSetImpl.class, skillSet.getPrimaryKey(), skillSet);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the skill sets in the entity cache if it is enabled.
	 *
	 * @param skillSets the skill sets
	 */
	@Override
	public void cacheResult(List<SkillSet> skillSets) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (skillSets.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SkillSet skillSet : skillSets) {
			if (entityCache.getResult(
					SkillSetImpl.class, skillSet.getPrimaryKey()) == null) {

				cacheResult(skillSet);
			}
		}
	}

	/**
	 * Clears the cache for all skill sets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SkillSetImpl.class);

		finderCache.clearCache(SkillSetImpl.class);
	}

	/**
	 * Clears the cache for the skill set.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SkillSet skillSet) {
		entityCache.removeResult(SkillSetImpl.class, skillSet);
	}

	@Override
	public void clearCache(List<SkillSet> skillSets) {
		for (SkillSet skillSet : skillSets) {
			entityCache.removeResult(SkillSetImpl.class, skillSet);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SkillSetImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SkillSetImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new skill set with the primary key. Does not add the skill set to the database.
	 *
	 * @param skillSetId the primary key for the new skill set
	 * @return the new skill set
	 */
	@Override
	public SkillSet create(long skillSetId) {
		SkillSet skillSet = new SkillSetImpl();

		skillSet.setNew(true);
		skillSet.setPrimaryKey(skillSetId);

		String uuid = PortalUUIDUtil.generate();

		skillSet.setUuid(uuid);

		return skillSet;
	}

	/**
	 * Removes the skill set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param skillSetId the primary key of the skill set
	 * @return the skill set that was removed
	 * @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet remove(long skillSetId) throws NoSuchSkillSetException {
		return remove((Serializable)skillSetId);
	}

	/**
	 * Removes the skill set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the skill set
	 * @return the skill set that was removed
	 * @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet remove(Serializable primaryKey)
		throws NoSuchSkillSetException {

		Session session = null;

		try {
			session = openSession();

			SkillSet skillSet = (SkillSet)session.get(
				SkillSetImpl.class, primaryKey);

			if (skillSet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSkillSetException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(skillSet);
		}
		catch (NoSuchSkillSetException noSuchEntityException) {
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
	protected SkillSet removeImpl(SkillSet skillSet) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skillSet)) {
				skillSet = (SkillSet)session.get(
					SkillSetImpl.class, skillSet.getPrimaryKeyObj());
			}

			if (skillSet != null) {
				session.delete(skillSet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (skillSet != null) {
			clearCache(skillSet);
		}

		return skillSet;
	}

	@Override
	public SkillSet updateImpl(SkillSet skillSet) {
		boolean isNew = skillSet.isNew();

		if (!(skillSet instanceof SkillSetModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(skillSet.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(skillSet);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in skillSet proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SkillSet implementation " +
					skillSet.getClass());
		}

		SkillSetModelImpl skillSetModelImpl = (SkillSetModelImpl)skillSet;

		if (Validator.isNull(skillSet.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			skillSet.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(skillSet);
			}
			else {
				skillSet = (SkillSet)session.merge(skillSet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SkillSetImpl.class, skillSetModelImpl, false, true);

		if (isNew) {
			skillSet.setNew(false);
		}

		skillSet.resetOriginalValues();

		return skillSet;
	}

	/**
	 * Returns the skill set with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the skill set
	 * @return the skill set
	 * @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSkillSetException {

		SkillSet skillSet = fetchByPrimaryKey(primaryKey);

		if (skillSet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSkillSetException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return skillSet;
	}

	/**
	 * Returns the skill set with the primary key or throws a <code>NoSuchSkillSetException</code> if it could not be found.
	 *
	 * @param skillSetId the primary key of the skill set
	 * @return the skill set
	 * @throws NoSuchSkillSetException if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet findByPrimaryKey(long skillSetId)
		throws NoSuchSkillSetException {

		return findByPrimaryKey((Serializable)skillSetId);
	}

	/**
	 * Returns the skill set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param skillSetId the primary key of the skill set
	 * @return the skill set, or <code>null</code> if a skill set with the primary key could not be found
	 */
	@Override
	public SkillSet fetchByPrimaryKey(long skillSetId) {
		return fetchByPrimaryKey((Serializable)skillSetId);
	}

	/**
	 * Returns all the skill sets.
	 *
	 * @return the skill sets
	 */
	@Override
	public List<SkillSet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the skill sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkillSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of skill sets
	 * @param end the upper bound of the range of skill sets (not inclusive)
	 * @return the range of skill sets
	 */
	@Override
	public List<SkillSet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the skill sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkillSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of skill sets
	 * @param end the upper bound of the range of skill sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of skill sets
	 */
	@Override
	public List<SkillSet> findAll(
		int start, int end, OrderByComparator<SkillSet> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the skill sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SkillSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of skill sets
	 * @param end the upper bound of the range of skill sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of skill sets
	 */
	@Override
	public List<SkillSet> findAll(
		int start, int end, OrderByComparator<SkillSet> orderByComparator,
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

		List<SkillSet> list = null;

		if (useFinderCache) {
			list = (List<SkillSet>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SKILLSET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SKILLSET;

				sql = sql.concat(SkillSetModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SkillSet>)QueryUtil.list(
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
	 * Removes all the skill sets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SkillSet skillSet : findAll()) {
			remove(skillSet);
		}
	}

	/**
	 * Returns the number of skill sets.
	 *
	 * @return the number of skill sets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SKILLSET);

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
		return "skillSetId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SKILLSET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SkillSetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the skill set persistence.
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

		_setSkillSetUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSkillSetUtilPersistence(null);

		entityCache.removeCache(SkillSetImpl.class.getName());
	}

	private void _setSkillSetUtilPersistence(
		SkillSetPersistence skillSetPersistence) {

		try {
			Field field = SkillSetUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, skillSetPersistence);
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

	private static final String _SQL_SELECT_SKILLSET =
		"SELECT skillSet FROM SkillSet skillSet";

	private static final String _SQL_SELECT_SKILLSET_WHERE =
		"SELECT skillSet FROM SkillSet skillSet WHERE ";

	private static final String _SQL_COUNT_SKILLSET =
		"SELECT COUNT(skillSet) FROM SkillSet skillSet";

	private static final String _SQL_COUNT_SKILLSET_WHERE =
		"SELECT COUNT(skillSet) FROM SkillSet skillSet WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "skillSet.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SkillSet exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SkillSet exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SkillSetPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private SkillSetModelArgumentsResolver _skillSetModelArgumentsResolver;

}