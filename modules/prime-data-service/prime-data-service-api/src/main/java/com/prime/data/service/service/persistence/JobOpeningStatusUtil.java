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

import com.prime.data.service.model.JobOpeningStatus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the job opening status service. This utility wraps <code>com.prime.data.service.service.persistence.impl.JobOpeningStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobOpeningStatusPersistence
 * @generated
 */
public class JobOpeningStatusUtil {

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
	public static void clearCache(JobOpeningStatus jobOpeningStatus) {
		getPersistence().clearCache(jobOpeningStatus);
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
	public static Map<Serializable, JobOpeningStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<JobOpeningStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<JobOpeningStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<JobOpeningStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<JobOpeningStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static JobOpeningStatus update(JobOpeningStatus jobOpeningStatus) {
		return getPersistence().update(jobOpeningStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static JobOpeningStatus update(
		JobOpeningStatus jobOpeningStatus, ServiceContext serviceContext) {

		return getPersistence().update(jobOpeningStatus, serviceContext);
	}

	/**
	 * Returns all the job opening statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching job opening statuses
	 */
	public static List<JobOpeningStatus> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<JobOpeningStatus> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<JobOpeningStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobOpeningStatus> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<JobOpeningStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<JobOpeningStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job opening status
	 * @throws NoSuchJobOpeningStatusException if a matching job opening status could not be found
	 */
	public static JobOpeningStatus findByUuid_First(
			String uuid, OrderByComparator<JobOpeningStatus> orderByComparator)
		throws com.prime.data.service.exception.
			NoSuchJobOpeningStatusException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job opening status, or <code>null</code> if a matching job opening status could not be found
	 */
	public static JobOpeningStatus fetchByUuid_First(
		String uuid, OrderByComparator<JobOpeningStatus> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job opening status
	 * @throws NoSuchJobOpeningStatusException if a matching job opening status could not be found
	 */
	public static JobOpeningStatus findByUuid_Last(
			String uuid, OrderByComparator<JobOpeningStatus> orderByComparator)
		throws com.prime.data.service.exception.
			NoSuchJobOpeningStatusException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job opening status, or <code>null</code> if a matching job opening status could not be found
	 */
	public static JobOpeningStatus fetchByUuid_Last(
		String uuid, OrderByComparator<JobOpeningStatus> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static JobOpeningStatus[] findByUuid_PrevAndNext(
			long jobStatusId, String uuid,
			OrderByComparator<JobOpeningStatus> orderByComparator)
		throws com.prime.data.service.exception.
			NoSuchJobOpeningStatusException {

		return getPersistence().findByUuid_PrevAndNext(
			jobStatusId, uuid, orderByComparator);
	}

	/**
	 * Removes all the job opening statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of job opening statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching job opening statuses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the job opening status in the entity cache if it is enabled.
	 *
	 * @param jobOpeningStatus the job opening status
	 */
	public static void cacheResult(JobOpeningStatus jobOpeningStatus) {
		getPersistence().cacheResult(jobOpeningStatus);
	}

	/**
	 * Caches the job opening statuses in the entity cache if it is enabled.
	 *
	 * @param jobOpeningStatuses the job opening statuses
	 */
	public static void cacheResult(List<JobOpeningStatus> jobOpeningStatuses) {
		getPersistence().cacheResult(jobOpeningStatuses);
	}

	/**
	 * Creates a new job opening status with the primary key. Does not add the job opening status to the database.
	 *
	 * @param jobStatusId the primary key for the new job opening status
	 * @return the new job opening status
	 */
	public static JobOpeningStatus create(long jobStatusId) {
		return getPersistence().create(jobStatusId);
	}

	/**
	 * Removes the job opening status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status that was removed
	 * @throws NoSuchJobOpeningStatusException if a job opening status with the primary key could not be found
	 */
	public static JobOpeningStatus remove(long jobStatusId)
		throws com.prime.data.service.exception.
			NoSuchJobOpeningStatusException {

		return getPersistence().remove(jobStatusId);
	}

	public static JobOpeningStatus updateImpl(
		JobOpeningStatus jobOpeningStatus) {

		return getPersistence().updateImpl(jobOpeningStatus);
	}

	/**
	 * Returns the job opening status with the primary key or throws a <code>NoSuchJobOpeningStatusException</code> if it could not be found.
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status
	 * @throws NoSuchJobOpeningStatusException if a job opening status with the primary key could not be found
	 */
	public static JobOpeningStatus findByPrimaryKey(long jobStatusId)
		throws com.prime.data.service.exception.
			NoSuchJobOpeningStatusException {

		return getPersistence().findByPrimaryKey(jobStatusId);
	}

	/**
	 * Returns the job opening status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status, or <code>null</code> if a job opening status with the primary key could not be found
	 */
	public static JobOpeningStatus fetchByPrimaryKey(long jobStatusId) {
		return getPersistence().fetchByPrimaryKey(jobStatusId);
	}

	/**
	 * Returns all the job opening statuses.
	 *
	 * @return the job opening statuses
	 */
	public static List<JobOpeningStatus> findAll() {
		return getPersistence().findAll();
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
	public static List<JobOpeningStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<JobOpeningStatus> findAll(
		int start, int end,
		OrderByComparator<JobOpeningStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<JobOpeningStatus> findAll(
		int start, int end,
		OrderByComparator<JobOpeningStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the job opening statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of job opening statuses.
	 *
	 * @return the number of job opening statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JobOpeningStatusPersistence getPersistence() {
		return _persistence;
	}

	private static volatile JobOpeningStatusPersistence _persistence;

}