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

import com.prime.data.service.exception.NoSuchJobTypeException;
import com.prime.data.service.model.JobType;
import com.prime.data.service.model.JobTypeTable;
import com.prime.data.service.model.impl.JobTypeImpl;
import com.prime.data.service.model.impl.JobTypeModelImpl;
import com.prime.data.service.service.persistence.JobTypePersistence;
import com.prime.data.service.service.persistence.JobTypeUtil;
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
 * The persistence implementation for the job type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {JobTypePersistence.class, BasePersistence.class})
public class JobTypePersistenceImpl
	extends BasePersistenceImpl<JobType> implements JobTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>JobTypeUtil</code> to access the job type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		JobTypeImpl.class.getName();

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
	 * Returns all the job types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching job types
	 */
	@Override
	public List<JobType> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job types
	 * @param end the upper bound of the range of job types (not inclusive)
	 * @return the range of matching job types
	 */
	@Override
	public List<JobType> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job types
	 * @param end the upper bound of the range of job types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job types
	 */
	@Override
	public List<JobType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobType> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of job types
	 * @param end the upper bound of the range of job types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching job types
	 */
	@Override
	public List<JobType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobType> orderByComparator, boolean useFinderCache) {

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

		List<JobType> list = null;

		if (useFinderCache) {
			list = (List<JobType>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (JobType jobType : list) {
					if (!uuid.equals(jobType.getUuid())) {
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

			sb.append(_SQL_SELECT_JOBTYPE_WHERE);

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
				sb.append(JobTypeModelImpl.ORDER_BY_JPQL);
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

				list = (List<JobType>)QueryUtil.list(
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
	 * Returns the first job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job type
	 * @throws NoSuchJobTypeException if a matching job type could not be found
	 */
	@Override
	public JobType findByUuid_First(
			String uuid, OrderByComparator<JobType> orderByComparator)
		throws NoSuchJobTypeException {

		JobType jobType = fetchByUuid_First(uuid, orderByComparator);

		if (jobType != null) {
			return jobType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchJobTypeException(sb.toString());
	}

	/**
	 * Returns the first job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job type, or <code>null</code> if a matching job type could not be found
	 */
	@Override
	public JobType fetchByUuid_First(
		String uuid, OrderByComparator<JobType> orderByComparator) {

		List<JobType> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job type
	 * @throws NoSuchJobTypeException if a matching job type could not be found
	 */
	@Override
	public JobType findByUuid_Last(
			String uuid, OrderByComparator<JobType> orderByComparator)
		throws NoSuchJobTypeException {

		JobType jobType = fetchByUuid_Last(uuid, orderByComparator);

		if (jobType != null) {
			return jobType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchJobTypeException(sb.toString());
	}

	/**
	 * Returns the last job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job type, or <code>null</code> if a matching job type could not be found
	 */
	@Override
	public JobType fetchByUuid_Last(
		String uuid, OrderByComparator<JobType> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<JobType> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job types before and after the current job type in the ordered set where uuid = &#63;.
	 *
	 * @param jobTypeId the primary key of the current job type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job type
	 * @throws NoSuchJobTypeException if a job type with the primary key could not be found
	 */
	@Override
	public JobType[] findByUuid_PrevAndNext(
			long jobTypeId, String uuid,
			OrderByComparator<JobType> orderByComparator)
		throws NoSuchJobTypeException {

		uuid = Objects.toString(uuid, "");

		JobType jobType = findByPrimaryKey(jobTypeId);

		Session session = null;

		try {
			session = openSession();

			JobType[] array = new JobTypeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, jobType, uuid, orderByComparator, true);

			array[1] = jobType;

			array[2] = getByUuid_PrevAndNext(
				session, jobType, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobType getByUuid_PrevAndNext(
		Session session, JobType jobType, String uuid,
		OrderByComparator<JobType> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_JOBTYPE_WHERE);

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
			sb.append(JobTypeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(jobType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<JobType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (JobType jobType :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(jobType);
		}
	}

	/**
	 * Returns the number of job types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching job types
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_JOBTYPE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "jobType.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(jobType.uuid IS NULL OR jobType.uuid = '')";

	public JobTypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(JobType.class);

		setModelImplClass(JobTypeImpl.class);
		setModelPKClass(long.class);

		setTable(JobTypeTable.INSTANCE);
	}

	/**
	 * Caches the job type in the entity cache if it is enabled.
	 *
	 * @param jobType the job type
	 */
	@Override
	public void cacheResult(JobType jobType) {
		entityCache.putResult(
			JobTypeImpl.class, jobType.getPrimaryKey(), jobType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the job types in the entity cache if it is enabled.
	 *
	 * @param jobTypes the job types
	 */
	@Override
	public void cacheResult(List<JobType> jobTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (jobTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (JobType jobType : jobTypes) {
			if (entityCache.getResult(
					JobTypeImpl.class, jobType.getPrimaryKey()) == null) {

				cacheResult(jobType);
			}
		}
	}

	/**
	 * Clears the cache for all job types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(JobTypeImpl.class);

		finderCache.clearCache(JobTypeImpl.class);
	}

	/**
	 * Clears the cache for the job type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobType jobType) {
		entityCache.removeResult(JobTypeImpl.class, jobType);
	}

	@Override
	public void clearCache(List<JobType> jobTypes) {
		for (JobType jobType : jobTypes) {
			entityCache.removeResult(JobTypeImpl.class, jobType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(JobTypeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(JobTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new job type with the primary key. Does not add the job type to the database.
	 *
	 * @param jobTypeId the primary key for the new job type
	 * @return the new job type
	 */
	@Override
	public JobType create(long jobTypeId) {
		JobType jobType = new JobTypeImpl();

		jobType.setNew(true);
		jobType.setPrimaryKey(jobTypeId);

		String uuid = PortalUUIDUtil.generate();

		jobType.setUuid(uuid);

		return jobType;
	}

	/**
	 * Removes the job type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type that was removed
	 * @throws NoSuchJobTypeException if a job type with the primary key could not be found
	 */
	@Override
	public JobType remove(long jobTypeId) throws NoSuchJobTypeException {
		return remove((Serializable)jobTypeId);
	}

	/**
	 * Removes the job type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job type
	 * @return the job type that was removed
	 * @throws NoSuchJobTypeException if a job type with the primary key could not be found
	 */
	@Override
	public JobType remove(Serializable primaryKey)
		throws NoSuchJobTypeException {

		Session session = null;

		try {
			session = openSession();

			JobType jobType = (JobType)session.get(
				JobTypeImpl.class, primaryKey);

			if (jobType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(jobType);
		}
		catch (NoSuchJobTypeException noSuchEntityException) {
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
	protected JobType removeImpl(JobType jobType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobType)) {
				jobType = (JobType)session.get(
					JobTypeImpl.class, jobType.getPrimaryKeyObj());
			}

			if (jobType != null) {
				session.delete(jobType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (jobType != null) {
			clearCache(jobType);
		}

		return jobType;
	}

	@Override
	public JobType updateImpl(JobType jobType) {
		boolean isNew = jobType.isNew();

		if (!(jobType instanceof JobTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(jobType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(jobType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in jobType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom JobType implementation " +
					jobType.getClass());
		}

		JobTypeModelImpl jobTypeModelImpl = (JobTypeModelImpl)jobType;

		if (Validator.isNull(jobType.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			jobType.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(jobType);
			}
			else {
				jobType = (JobType)session.merge(jobType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(JobTypeImpl.class, jobTypeModelImpl, false, true);

		if (isNew) {
			jobType.setNew(false);
		}

		jobType.resetOriginalValues();

		return jobType;
	}

	/**
	 * Returns the job type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job type
	 * @return the job type
	 * @throws NoSuchJobTypeException if a job type with the primary key could not be found
	 */
	@Override
	public JobType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobTypeException {

		JobType jobType = fetchByPrimaryKey(primaryKey);

		if (jobType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return jobType;
	}

	/**
	 * Returns the job type with the primary key or throws a <code>NoSuchJobTypeException</code> if it could not be found.
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type
	 * @throws NoSuchJobTypeException if a job type with the primary key could not be found
	 */
	@Override
	public JobType findByPrimaryKey(long jobTypeId)
		throws NoSuchJobTypeException {

		return findByPrimaryKey((Serializable)jobTypeId);
	}

	/**
	 * Returns the job type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type, or <code>null</code> if a job type with the primary key could not be found
	 */
	@Override
	public JobType fetchByPrimaryKey(long jobTypeId) {
		return fetchByPrimaryKey((Serializable)jobTypeId);
	}

	/**
	 * Returns all the job types.
	 *
	 * @return the job types
	 */
	@Override
	public List<JobType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job types
	 * @param end the upper bound of the range of job types (not inclusive)
	 * @return the range of job types
	 */
	@Override
	public List<JobType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job types
	 * @param end the upper bound of the range of job types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job types
	 */
	@Override
	public List<JobType> findAll(
		int start, int end, OrderByComparator<JobType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the job types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job types
	 * @param end the upper bound of the range of job types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of job types
	 */
	@Override
	public List<JobType> findAll(
		int start, int end, OrderByComparator<JobType> orderByComparator,
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

		List<JobType> list = null;

		if (useFinderCache) {
			list = (List<JobType>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_JOBTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_JOBTYPE;

				sql = sql.concat(JobTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<JobType>)QueryUtil.list(
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
	 * Removes all the job types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (JobType jobType : findAll()) {
			remove(jobType);
		}
	}

	/**
	 * Returns the number of job types.
	 *
	 * @return the number of job types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_JOBTYPE);

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
		return "jobTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_JOBTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return JobTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the job type persistence.
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

		_setJobTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setJobTypeUtilPersistence(null);

		entityCache.removeCache(JobTypeImpl.class.getName());
	}

	private void _setJobTypeUtilPersistence(
		JobTypePersistence jobTypePersistence) {

		try {
			Field field = JobTypeUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, jobTypePersistence);
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

	private static final String _SQL_SELECT_JOBTYPE =
		"SELECT jobType FROM JobType jobType";

	private static final String _SQL_SELECT_JOBTYPE_WHERE =
		"SELECT jobType FROM JobType jobType WHERE ";

	private static final String _SQL_COUNT_JOBTYPE =
		"SELECT COUNT(jobType) FROM JobType jobType";

	private static final String _SQL_COUNT_JOBTYPE_WHERE =
		"SELECT COUNT(jobType) FROM JobType jobType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "jobType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No JobType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No JobType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		JobTypePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private JobTypeModelArgumentsResolver _jobTypeModelArgumentsResolver;

}