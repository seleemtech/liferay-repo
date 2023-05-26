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

import com.prime.data.service.exception.NoSuchWorkExperienceException;
import com.prime.data.service.model.WorkExperience;
import com.prime.data.service.model.WorkExperienceTable;
import com.prime.data.service.model.impl.WorkExperienceImpl;
import com.prime.data.service.model.impl.WorkExperienceModelImpl;
import com.prime.data.service.service.persistence.WorkExperiencePersistence;
import com.prime.data.service.service.persistence.WorkExperienceUtil;
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
 * The persistence implementation for the work experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {WorkExperiencePersistence.class, BasePersistence.class})
public class WorkExperiencePersistenceImpl
	extends BasePersistenceImpl<WorkExperience>
	implements WorkExperiencePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>WorkExperienceUtil</code> to access the work experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		WorkExperienceImpl.class.getName();

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
	 * Returns all the work experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work experiences
	 */
	@Override
	public List<WorkExperience> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @return the range of matching work experiences
	 */
	@Override
	public List<WorkExperience> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work experiences
	 */
	@Override
	public List<WorkExperience> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkExperience> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work experiences
	 */
	@Override
	public List<WorkExperience> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkExperience> orderByComparator,
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

		List<WorkExperience> list = null;

		if (useFinderCache) {
			list = (List<WorkExperience>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (WorkExperience workExperience : list) {
					if (!uuid.equals(workExperience.getUuid())) {
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

			sb.append(_SQL_SELECT_WORKEXPERIENCE_WHERE);

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
				sb.append(WorkExperienceModelImpl.ORDER_BY_JPQL);
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

				list = (List<WorkExperience>)QueryUtil.list(
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
	 * Returns the first work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work experience
	 * @throws NoSuchWorkExperienceException if a matching work experience could not be found
	 */
	@Override
	public WorkExperience findByUuid_First(
			String uuid, OrderByComparator<WorkExperience> orderByComparator)
		throws NoSuchWorkExperienceException {

		WorkExperience workExperience = fetchByUuid_First(
			uuid, orderByComparator);

		if (workExperience != null) {
			return workExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkExperienceException(sb.toString());
	}

	/**
	 * Returns the first work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work experience, or <code>null</code> if a matching work experience could not be found
	 */
	@Override
	public WorkExperience fetchByUuid_First(
		String uuid, OrderByComparator<WorkExperience> orderByComparator) {

		List<WorkExperience> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work experience
	 * @throws NoSuchWorkExperienceException if a matching work experience could not be found
	 */
	@Override
	public WorkExperience findByUuid_Last(
			String uuid, OrderByComparator<WorkExperience> orderByComparator)
		throws NoSuchWorkExperienceException {

		WorkExperience workExperience = fetchByUuid_Last(
			uuid, orderByComparator);

		if (workExperience != null) {
			return workExperience;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchWorkExperienceException(sb.toString());
	}

	/**
	 * Returns the last work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work experience, or <code>null</code> if a matching work experience could not be found
	 */
	@Override
	public WorkExperience fetchByUuid_Last(
		String uuid, OrderByComparator<WorkExperience> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<WorkExperience> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the work experiences before and after the current work experience in the ordered set where uuid = &#63;.
	 *
	 * @param workExpId the primary key of the current work experience
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work experience
	 * @throws NoSuchWorkExperienceException if a work experience with the primary key could not be found
	 */
	@Override
	public WorkExperience[] findByUuid_PrevAndNext(
			long workExpId, String uuid,
			OrderByComparator<WorkExperience> orderByComparator)
		throws NoSuchWorkExperienceException {

		uuid = Objects.toString(uuid, "");

		WorkExperience workExperience = findByPrimaryKey(workExpId);

		Session session = null;

		try {
			session = openSession();

			WorkExperience[] array = new WorkExperienceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, workExperience, uuid, orderByComparator, true);

			array[1] = workExperience;

			array[2] = getByUuid_PrevAndNext(
				session, workExperience, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkExperience getByUuid_PrevAndNext(
		Session session, WorkExperience workExperience, String uuid,
		OrderByComparator<WorkExperience> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_WORKEXPERIENCE_WHERE);

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
			sb.append(WorkExperienceModelImpl.ORDER_BY_JPQL);
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
						workExperience)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<WorkExperience> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the work experiences where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (WorkExperience workExperience :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(workExperience);
		}
	}

	/**
	 * Returns the number of work experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work experiences
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_WORKEXPERIENCE_WHERE);

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
		"workExperience.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(workExperience.uuid IS NULL OR workExperience.uuid = '')";

	public WorkExperiencePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(WorkExperience.class);

		setModelImplClass(WorkExperienceImpl.class);
		setModelPKClass(long.class);

		setTable(WorkExperienceTable.INSTANCE);
	}

	/**
	 * Caches the work experience in the entity cache if it is enabled.
	 *
	 * @param workExperience the work experience
	 */
	@Override
	public void cacheResult(WorkExperience workExperience) {
		entityCache.putResult(
			WorkExperienceImpl.class, workExperience.getPrimaryKey(),
			workExperience);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the work experiences in the entity cache if it is enabled.
	 *
	 * @param workExperiences the work experiences
	 */
	@Override
	public void cacheResult(List<WorkExperience> workExperiences) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (workExperiences.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (WorkExperience workExperience : workExperiences) {
			if (entityCache.getResult(
					WorkExperienceImpl.class, workExperience.getPrimaryKey()) ==
						null) {

				cacheResult(workExperience);
			}
		}
	}

	/**
	 * Clears the cache for all work experiences.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(WorkExperienceImpl.class);

		finderCache.clearCache(WorkExperienceImpl.class);
	}

	/**
	 * Clears the cache for the work experience.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkExperience workExperience) {
		entityCache.removeResult(WorkExperienceImpl.class, workExperience);
	}

	@Override
	public void clearCache(List<WorkExperience> workExperiences) {
		for (WorkExperience workExperience : workExperiences) {
			entityCache.removeResult(WorkExperienceImpl.class, workExperience);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(WorkExperienceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(WorkExperienceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new work experience with the primary key. Does not add the work experience to the database.
	 *
	 * @param workExpId the primary key for the new work experience
	 * @return the new work experience
	 */
	@Override
	public WorkExperience create(long workExpId) {
		WorkExperience workExperience = new WorkExperienceImpl();

		workExperience.setNew(true);
		workExperience.setPrimaryKey(workExpId);

		String uuid = PortalUUIDUtil.generate();

		workExperience.setUuid(uuid);

		return workExperience;
	}

	/**
	 * Removes the work experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workExpId the primary key of the work experience
	 * @return the work experience that was removed
	 * @throws NoSuchWorkExperienceException if a work experience with the primary key could not be found
	 */
	@Override
	public WorkExperience remove(long workExpId)
		throws NoSuchWorkExperienceException {

		return remove((Serializable)workExpId);
	}

	/**
	 * Removes the work experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work experience
	 * @return the work experience that was removed
	 * @throws NoSuchWorkExperienceException if a work experience with the primary key could not be found
	 */
	@Override
	public WorkExperience remove(Serializable primaryKey)
		throws NoSuchWorkExperienceException {

		Session session = null;

		try {
			session = openSession();

			WorkExperience workExperience = (WorkExperience)session.get(
				WorkExperienceImpl.class, primaryKey);

			if (workExperience == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkExperienceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(workExperience);
		}
		catch (NoSuchWorkExperienceException noSuchEntityException) {
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
	protected WorkExperience removeImpl(WorkExperience workExperience) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workExperience)) {
				workExperience = (WorkExperience)session.get(
					WorkExperienceImpl.class,
					workExperience.getPrimaryKeyObj());
			}

			if (workExperience != null) {
				session.delete(workExperience);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (workExperience != null) {
			clearCache(workExperience);
		}

		return workExperience;
	}

	@Override
	public WorkExperience updateImpl(WorkExperience workExperience) {
		boolean isNew = workExperience.isNew();

		if (!(workExperience instanceof WorkExperienceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(workExperience.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					workExperience);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in workExperience proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom WorkExperience implementation " +
					workExperience.getClass());
		}

		WorkExperienceModelImpl workExperienceModelImpl =
			(WorkExperienceModelImpl)workExperience;

		if (Validator.isNull(workExperience.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			workExperience.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(workExperience);
			}
			else {
				workExperience = (WorkExperience)session.merge(workExperience);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			WorkExperienceImpl.class, workExperienceModelImpl, false, true);

		if (isNew) {
			workExperience.setNew(false);
		}

		workExperience.resetOriginalValues();

		return workExperience;
	}

	/**
	 * Returns the work experience with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work experience
	 * @return the work experience
	 * @throws NoSuchWorkExperienceException if a work experience with the primary key could not be found
	 */
	@Override
	public WorkExperience findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkExperienceException {

		WorkExperience workExperience = fetchByPrimaryKey(primaryKey);

		if (workExperience == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkExperienceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return workExperience;
	}

	/**
	 * Returns the work experience with the primary key or throws a <code>NoSuchWorkExperienceException</code> if it could not be found.
	 *
	 * @param workExpId the primary key of the work experience
	 * @return the work experience
	 * @throws NoSuchWorkExperienceException if a work experience with the primary key could not be found
	 */
	@Override
	public WorkExperience findByPrimaryKey(long workExpId)
		throws NoSuchWorkExperienceException {

		return findByPrimaryKey((Serializable)workExpId);
	}

	/**
	 * Returns the work experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workExpId the primary key of the work experience
	 * @return the work experience, or <code>null</code> if a work experience with the primary key could not be found
	 */
	@Override
	public WorkExperience fetchByPrimaryKey(long workExpId) {
		return fetchByPrimaryKey((Serializable)workExpId);
	}

	/**
	 * Returns all the work experiences.
	 *
	 * @return the work experiences
	 */
	@Override
	public List<WorkExperience> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @return the range of work experiences
	 */
	@Override
	public List<WorkExperience> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work experiences
	 */
	@Override
	public List<WorkExperience> findAll(
		int start, int end,
		OrderByComparator<WorkExperience> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work experiences
	 */
	@Override
	public List<WorkExperience> findAll(
		int start, int end, OrderByComparator<WorkExperience> orderByComparator,
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

		List<WorkExperience> list = null;

		if (useFinderCache) {
			list = (List<WorkExperience>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_WORKEXPERIENCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_WORKEXPERIENCE;

				sql = sql.concat(WorkExperienceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<WorkExperience>)QueryUtil.list(
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
	 * Removes all the work experiences from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (WorkExperience workExperience : findAll()) {
			remove(workExperience);
		}
	}

	/**
	 * Returns the number of work experiences.
	 *
	 * @return the number of work experiences
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_WORKEXPERIENCE);

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
		return "workExpId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_WORKEXPERIENCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return WorkExperienceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the work experience persistence.
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

		_setWorkExperienceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setWorkExperienceUtilPersistence(null);

		entityCache.removeCache(WorkExperienceImpl.class.getName());
	}

	private void _setWorkExperienceUtilPersistence(
		WorkExperiencePersistence workExperiencePersistence) {

		try {
			Field field = WorkExperienceUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, workExperiencePersistence);
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

	private static final String _SQL_SELECT_WORKEXPERIENCE =
		"SELECT workExperience FROM WorkExperience workExperience";

	private static final String _SQL_SELECT_WORKEXPERIENCE_WHERE =
		"SELECT workExperience FROM WorkExperience workExperience WHERE ";

	private static final String _SQL_COUNT_WORKEXPERIENCE =
		"SELECT COUNT(workExperience) FROM WorkExperience workExperience";

	private static final String _SQL_COUNT_WORKEXPERIENCE_WHERE =
		"SELECT COUNT(workExperience) FROM WorkExperience workExperience WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "workExperience.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No WorkExperience exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No WorkExperience exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		WorkExperiencePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private WorkExperienceModelArgumentsResolver
		_workExperienceModelArgumentsResolver;

}