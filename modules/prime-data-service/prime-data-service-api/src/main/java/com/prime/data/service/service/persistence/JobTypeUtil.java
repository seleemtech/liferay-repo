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

package com.prime.data.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.prime.data.service.model.JobType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the job type service. This utility wraps <code>com.prime.data.service.service.persistence.impl.JobTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobTypePersistence
 * @generated
 */
public class JobTypeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(JobType jobType) {
		getPersistence().clearCache(jobType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, JobType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JobType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JobType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JobType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<JobType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static JobType update(JobType jobType) {
		return getPersistence().update(jobType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static JobType update(
		JobType jobType, ServiceContext serviceContext) {

		return getPersistence().update(jobType, serviceContext);
	}

	/**
	 * Returns all the job types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching job types
	 */
	public static List<JobType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<JobType> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<JobType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<JobType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobType> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job type
	 * @throws NoSuchJobTypeException if a matching job type could not be found
	 */
	public static JobType findByUuid_First(
			String uuid, OrderByComparator<JobType> orderByComparator)
		throws com.prime.data.service.exception.NoSuchJobTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job type, or <code>null</code> if a matching job type could not be found
	 */
	public static JobType fetchByUuid_First(
		String uuid, OrderByComparator<JobType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job type
	 * @throws NoSuchJobTypeException if a matching job type could not be found
	 */
	public static JobType findByUuid_Last(
			String uuid, OrderByComparator<JobType> orderByComparator)
		throws com.prime.data.service.exception.NoSuchJobTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job type, or <code>null</code> if a matching job type could not be found
	 */
	public static JobType fetchByUuid_Last(
		String uuid, OrderByComparator<JobType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static JobType[] findByUuid_PrevAndNext(
			long jobTypeId, String uuid,
			OrderByComparator<JobType> orderByComparator)
		throws com.prime.data.service.exception.NoSuchJobTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			jobTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the job types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of job types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching job types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the job type in the entity cache if it is enabled.
	 *
	 * @param jobType the job type
	 */
	public static void cacheResult(JobType jobType) {
		getPersistence().cacheResult(jobType);
	}

	/**
	 * Caches the job types in the entity cache if it is enabled.
	 *
	 * @param jobTypes the job types
	 */
	public static void cacheResult(List<JobType> jobTypes) {
		getPersistence().cacheResult(jobTypes);
	}

	/**
	 * Creates a new job type with the primary key. Does not add the job type to the database.
	 *
	 * @param jobTypeId the primary key for the new job type
	 * @return the new job type
	 */
	public static JobType create(long jobTypeId) {
		return getPersistence().create(jobTypeId);
	}

	/**
	 * Removes the job type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type that was removed
	 * @throws NoSuchJobTypeException if a job type with the primary key could not be found
	 */
	public static JobType remove(long jobTypeId)
		throws com.prime.data.service.exception.NoSuchJobTypeException {

		return getPersistence().remove(jobTypeId);
	}

	public static JobType updateImpl(JobType jobType) {
		return getPersistence().updateImpl(jobType);
	}

	/**
	 * Returns the job type with the primary key or throws a <code>NoSuchJobTypeException</code> if it could not be found.
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type
	 * @throws NoSuchJobTypeException if a job type with the primary key could not be found
	 */
	public static JobType findByPrimaryKey(long jobTypeId)
		throws com.prime.data.service.exception.NoSuchJobTypeException {

		return getPersistence().findByPrimaryKey(jobTypeId);
	}

	/**
	 * Returns the job type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type, or <code>null</code> if a job type with the primary key could not be found
	 */
	public static JobType fetchByPrimaryKey(long jobTypeId) {
		return getPersistence().fetchByPrimaryKey(jobTypeId);
	}

	/**
	 * Returns all the job types.
	 *
	 * @return the job types
	 */
	public static List<JobType> findAll() {
		return getPersistence().findAll();
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
	public static List<JobType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<JobType> findAll(
		int start, int end, OrderByComparator<JobType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<JobType> findAll(
		int start, int end, OrderByComparator<JobType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the job types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of job types.
	 *
	 * @return the number of job types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JobTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile JobTypePersistence _persistence;

}