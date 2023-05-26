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

import com.prime.data.service.exception.NoSuchJobOpeningStatusException;
import com.prime.data.service.model.JobOpeningStatus;
import com.prime.data.service.model.JobOpeningStatusTable;
import com.prime.data.service.model.impl.JobOpeningStatusImpl;
import com.prime.data.service.model.impl.JobOpeningStatusModelImpl;
import com.prime.data.service.service.persistence.JobOpeningStatusPersistence;
import com.prime.data.service.service.persistence.JobOpeningStatusUtil;
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
 * The persistence implementation for the job opening status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {JobOpeningStatusPersistence.class, BasePersistence.class})
public class JobOpeningStatusPersistenceImpl
	extends BasePersistenceImpl<JobOpeningStatus>
	implements JobOpeningStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JobOpeningStatusUtil</code> to access the job opening status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JobOpeningStatusImpl.class.getName();

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
	 * Returns all the job opening statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching job opening statuses
	 */
	@Override
	public List<JobOpeningStatus> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job opening statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobOpeningStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job opening statuses
	 * @param end the upper bound of the range of job opening statuses (not inclusive)
	 * @return the range of matching job opening statuses
	 */
	@Override
	public List<JobOpeningStatus> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job opening statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobOpeningStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job opening statuses
	 * @param end the upper bound of the range of job opening statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job opening statuses
	 */
	@Override
	public List<JobOpeningStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobOpeningStatus> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job opening statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobOpeningStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job opening statuses
	 * @param end the upper bound of the range of job opening statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching job opening statuses
	 */
	@Override
	public List<JobOpeningStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobOpeningStatus> orderByComparator,
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

		List<JobOpeningStatus> list = null;

		if (useFinderCache) {
			list = (List<JobOpeningStatus>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (JobOpeningStatus jobOpeningStatus : list) {
					if (!uuid.equals(jobOpeningStatus.getUuid())) {
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

			sb.append(_SQL_SELECT_JOBOPENINGSTATUS_WHERE);

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
				sb.append(JobOpeningStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<JobOpeningStatus>)QueryUtil.list(
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
	 * Returns the first job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job opening status
	 * @throws NoSuchJobOpeningStatusException if a matching job opening status could not be found
	 */
	@Override
	public JobOpeningStatus findByUuid_First(
			String uuid, OrderByComparator<JobOpeningStatus> orderByComparator)
		throws NoSuchJobOpeningStatusException {

		JobOpeningStatus jobOpeningStatus = fetchByUuid_First(
			uuid, orderByComparator);

		if (jobOpeningStatus != null) {
			return jobOpeningStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchJobOpeningStatusException(sb.toString());
	}

	/**
	 * Returns the first job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job opening status, or <code>null</code> if a matching job opening status could not be found
	 */
	@Override
	public JobOpeningStatus fetchByUuid_First(
		String uuid, OrderByComparator<JobOpeningStatus> orderByComparator) {

		List<JobOpeningStatus> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job opening status
	 * @throws NoSuchJobOpeningStatusException if a matching job opening status could not be found
	 */
	@Override
	public JobOpeningStatus findByUuid_Last(
			String uuid, OrderByComparator<JobOpeningStatus> orderByComparator)
		throws NoSuchJobOpeningStatusException {

		JobOpeningStatus jobOpeningStatus = fetchByUuid_Last(
			uuid, orderByComparator);

		if (jobOpeningStatus != null) {
			return jobOpeningStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchJobOpeningStatusException(sb.toString());
	}

	/**
	 * Returns the last job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job opening status, or <code>null</code> if a matching job opening status could not be found
	 */
	@Override
	public JobOpeningStatus fetchByUuid_Last(
		String uuid, OrderByComparator<JobOpeningStatus> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<JobOpeningStatus> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job opening statuses before and after the current job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param jobStatusId the primary key of the current job opening status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job opening status
	 * @throws NoSuchJobOpeningStatusException if a job opening status with the primary key could not be found
	 */
	@Override
	public JobOpeningStatus[] findByUuid_PrevAndNext(
			long jobStatusId, String uuid,
			OrderByComparator<JobOpeningStatus> orderByComparator)
		throws NoSuchJobOpeningStatusException {

		uuid = Objects.toString(uuid, "");

		JobOpeningStatus jobOpeningStatus = findByPrimaryKey(jobStatusId);

		Session session = null;

		try {
			session = openSession();

			JobOpeningStatus[] array = new JobOpeningStatusImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, jobOpeningStatus, uuid, orderByComparator, true);

			array[1] = jobOpeningStatus;

			array[2] = getByUuid_PrevAndNext(
				session, jobOpeningStatus, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobOpeningStatus getByUuid_PrevAndNext(
		Session session, JobOpeningStatus jobOpeningStatus, String uuid,
		OrderByComparator<JobOpeningStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_JOBOPENINGSTATUS_WHERE);

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
			sb.append(JobOpeningStatusModelImpl.ORDER_BY_JPQL);
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
						jobOpeningStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JobOpeningStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job opening statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (JobOpeningStatus jobOpeningStatus :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(jobOpeningStatus);
		}
	}

	/**
	 * Returns the number of job opening statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching job opening statuses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_JOBOPENINGSTATUS_WHERE);

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
		"jobOpeningStatus.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(jobOpeningStatus.uuid IS NULL OR jobOpeningStatus.uuid = '')";

	public JobOpeningStatusPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(JobOpeningStatus.class);

		setModelImplClass(JobOpeningStatusImpl.class);
		setModelPKClass(long.class);

		setTable(JobOpeningStatusTable.INSTANCE);
	}

	/**
	 * Caches the job opening status in the entity cache if it is enabled.
	 *
	 * @param jobOpeningStatus the job opening status
	 */
	@Override
	public void cacheResult(JobOpeningStatus jobOpeningStatus) {
		entityCache.putResult(
			JobOpeningStatusImpl.class, jobOpeningStatus.getPrimaryKey(),
			jobOpeningStatus);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the job opening statuses in the entity cache if it is enabled.
	 *
	 * @param jobOpeningStatuses the job opening statuses
	 */
	@Override
	public void cacheResult(List<JobOpeningStatus> jobOpeningStatuses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (jobOpeningStatuses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (JobOpeningStatus jobOpeningStatus : jobOpeningStatuses) {
			if (entityCache.getResult(
					JobOpeningStatusImpl.class,
					jobOpeningStatus.getPrimaryKey()) == null) {

				cacheResult(jobOpeningStatus);
			}
		}
	}

	/**
	 * Clears the cache for all job opening statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JobOpeningStatusImpl.class);

		finderCache.clearCache(JobOpeningStatusImpl.class);
	}

	/**
	 * Clears the cache for the job opening status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobOpeningStatus jobOpeningStatus) {
		entityCache.removeResult(JobOpeningStatusImpl.class, jobOpeningStatus);
	}

	@Override
	public void clearCache(List<JobOpeningStatus> jobOpeningStatuses) {
		for (JobOpeningStatus jobOpeningStatus : jobOpeningStatuses) {
			entityCache.removeResult(
				JobOpeningStatusImpl.class, jobOpeningStatus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(JobOpeningStatusImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(JobOpeningStatusImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new job opening status with the primary key. Does not add the job opening status to the database.
	 *
	 * @param jobStatusId the primary key for the new job opening status
	 * @return the new job opening status
	 */
	@Override
	public JobOpeningStatus create(long jobStatusId) {
		JobOpeningStatus jobOpeningStatus = new JobOpeningStatusImpl();

		jobOpeningStatus.setNew(true);
		jobOpeningStatus.setPrimaryKey(jobStatusId);

		String uuid = PortalUUIDUtil.generate();

		jobOpeningStatus.setUuid(uuid);

		return jobOpeningStatus;
	}

	/**
	 * Removes the job opening status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status that was removed
	 * @throws NoSuchJobOpeningStatusException if a job opening status with the primary key could not be found
	 */
	@Override
	public JobOpeningStatus remove(long jobStatusId)
		throws NoSuchJobOpeningStatusException {

		return remove((Serializable)jobStatusId);
	}

	/**
	 * Removes the job opening status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job opening status
	 * @return the job opening status that was removed
	 * @throws NoSuchJobOpeningStatusException if a job opening status with the primary key could not be found
	 */
	@Override
	public JobOpeningStatus remove(Serializable primaryKey)
		throws NoSuchJobOpeningStatusException {

		Session session = null;

		try {
			session = openSession();

			JobOpeningStatus jobOpeningStatus = (JobOpeningStatus)session.get(
				JobOpeningStatusImpl.class, primaryKey);

			if (jobOpeningStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobOpeningStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(jobOpeningStatus);
		}
		catch (NoSuchJobOpeningStatusException noSuchEntityException) {
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
	protected JobOpeningStatus removeImpl(JobOpeningStatus jobOpeningStatus) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobOpeningStatus)) {
				jobOpeningStatus = (JobOpeningStatus)session.get(
					JobOpeningStatusImpl.class,
					jobOpeningStatus.getPrimaryKeyObj());
			}

			if (jobOpeningStatus != null) {
				session.delete(jobOpeningStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (jobOpeningStatus != null) {
			clearCache(jobOpeningStatus);
		}

		return jobOpeningStatus;
	}

	@Override
	public JobOpeningStatus updateImpl(JobOpeningStatus jobOpeningStatus) {
		boolean isNew = jobOpeningStatus.isNew();

		if (!(jobOpeningStatus instanceof JobOpeningStatusModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(jobOpeningStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					jobOpeningStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in jobOpeningStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom JobOpeningStatus implementation " +
					jobOpeningStatus.getClass());
		}

		JobOpeningStatusModelImpl jobOpeningStatusModelImpl =
			(JobOpeningStatusModelImpl)jobOpeningStatus;

		if (Validator.isNull(jobOpeningStatus.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			jobOpeningStatus.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(jobOpeningStatus);
			}
			else {
				jobOpeningStatus = (JobOpeningStatus)session.merge(
					jobOpeningStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			JobOpeningStatusImpl.class, jobOpeningStatusModelImpl, false, true);

		if (isNew) {
			jobOpeningStatus.setNew(false);
		}

		jobOpeningStatus.resetOriginalValues();

		return jobOpeningStatus;
	}

	/**
	 * Returns the job opening status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job opening status
	 * @return the job opening status
	 * @throws NoSuchJobOpeningStatusException if a job opening status with the primary key could not be found
	 */
	@Override
	public JobOpeningStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobOpeningStatusException {

		JobOpeningStatus jobOpeningStatus = fetchByPrimaryKey(primaryKey);

		if (jobOpeningStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobOpeningStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return jobOpeningStatus;
	}

	/**
	 * Returns the job opening status with the primary key or throws a <code>NoSuchJobOpeningStatusException</code> if it could not be found.
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status
	 * @throws NoSuchJobOpeningStatusException if a job opening status with the primary key could not be found
	 */
	@Override
	public JobOpeningStatus findByPrimaryKey(long jobStatusId)
		throws NoSuchJobOpeningStatusException {

		return findByPrimaryKey((Serializable)jobStatusId);
	}

	/**
	 * Returns the job opening status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status, or <code>null</code> if a job opening status with the primary key could not be found
	 */
	@Override
	public JobOpeningStatus fetchByPrimaryKey(long jobStatusId) {
		return fetchByPrimaryKey((Serializable)jobStatusId);
	}

	/**
	 * Returns all the job opening statuses.
	 *
	 * @return the job opening statuses
	 */
	@Override
	public List<JobOpeningStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job opening statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobOpeningStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job opening statuses
	 * @param end the upper bound of the range of job opening statuses (not inclusive)
	 * @return the range of job opening statuses
	 */
	@Override
	public List<JobOpeningStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job opening statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobOpeningStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job opening statuses
	 * @param end the upper bound of the range of job opening statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job opening statuses
	 */
	@Override
	public List<JobOpeningStatus> findAll(
		int start, int end,
		OrderByComparator<JobOpeningStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job opening statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobOpeningStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job opening statuses
	 * @param end the upper bound of the range of job opening statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of job opening statuses
	 */
	@Override
	public List<JobOpeningStatus> findAll(
		int start, int end,
		OrderByComparator<JobOpeningStatus> orderByComparator,
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

		List<JobOpeningStatus> list = null;

		if (useFinderCache) {
			list = (List<JobOpeningStatus>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_JOBOPENINGSTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_JOBOPENINGSTATUS;

				sql = sql.concat(JobOpeningStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<JobOpeningStatus>)QueryUtil.list(
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
	 * Removes all the job opening statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JobOpeningStatus jobOpeningStatus : findAll()) {
			remove(jobOpeningStatus);
		}
	}

	/**
	 * Returns the number of job opening statuses.
	 *
	 * @return the number of job opening statuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_JOBOPENINGSTATUS);

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
		return "jobStatusId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOBOPENINGSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JobOpeningStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the job opening status persistence.
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

		_setJobOpeningStatusUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setJobOpeningStatusUtilPersistence(null);

		entityCache.removeCache(JobOpeningStatusImpl.class.getName());
	}

	private void _setJobOpeningStatusUtilPersistence(
		JobOpeningStatusPersistence jobOpeningStatusPersistence) {

		try {
			Field field = JobOpeningStatusUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, jobOpeningStatusPersistence);
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

	private static final String _SQL_SELECT_JOBOPENINGSTATUS =
		"SELECT jobOpeningStatus FROM JobOpeningStatus jobOpeningStatus";

	private static final String _SQL_SELECT_JOBOPENINGSTATUS_WHERE =
		"SELECT jobOpeningStatus FROM JobOpeningStatus jobOpeningStatus WHERE ";

	private static final String _SQL_COUNT_JOBOPENINGSTATUS =
		"SELECT COUNT(jobOpeningStatus) FROM JobOpeningStatus jobOpeningStatus";

	private static final String _SQL_COUNT_JOBOPENINGSTATUS_WHERE =
		"SELECT COUNT(jobOpeningStatus) FROM JobOpeningStatus jobOpeningStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "jobOpeningStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No JobOpeningStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No JobOpeningStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		JobOpeningStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private JobOpeningStatusModelArgumentsResolver
		_jobOpeningStatusModelArgumentsResolver;

}