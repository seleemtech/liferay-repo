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

import com.prime.data.service.model.CandidateStatus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the candidate status service. This utility wraps <code>com.prime.data.service.service.persistence.impl.CandidateStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateStatusPersistence
 * @generated
 */
public class CandidateStatusUtil {

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
	public static void clearCache(CandidateStatus candidateStatus) {
		getPersistence().clearCache(candidateStatus);
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
	public static Map<Serializable, CandidateStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CandidateStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CandidateStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CandidateStatus update(CandidateStatus candidateStatus) {
		return getPersistence().update(candidateStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CandidateStatus update(
		CandidateStatus candidateStatus, ServiceContext serviceContext) {

		return getPersistence().update(candidateStatus, serviceContext);
	}

	/**
	 * Returns all the candidate statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching candidate statuses
	 */
	public static List<CandidateStatus> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the candidate statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @return the range of matching candidate statuses
	 */
	public static List<CandidateStatus> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the candidate statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate statuses
	 */
	public static List<CandidateStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CandidateStatus> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the candidate statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate statuses
	 */
	public static List<CandidateStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CandidateStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate status
	 * @throws NoSuchCandidateStatusException if a matching candidate status could not be found
	 */
	public static CandidateStatus findByUuid_First(
			String uuid, OrderByComparator<CandidateStatus> orderByComparator)
		throws com.prime.data.service.exception.NoSuchCandidateStatusException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate status, or <code>null</code> if a matching candidate status could not be found
	 */
	public static CandidateStatus fetchByUuid_First(
		String uuid, OrderByComparator<CandidateStatus> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate status
	 * @throws NoSuchCandidateStatusException if a matching candidate status could not be found
	 */
	public static CandidateStatus findByUuid_Last(
			String uuid, OrderByComparator<CandidateStatus> orderByComparator)
		throws com.prime.data.service.exception.NoSuchCandidateStatusException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate status, or <code>null</code> if a matching candidate status could not be found
	 */
	public static CandidateStatus fetchByUuid_Last(
		String uuid, OrderByComparator<CandidateStatus> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the candidate statuses before and after the current candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param candidateStatusId the primary key of the current candidate status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate status
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	public static CandidateStatus[] findByUuid_PrevAndNext(
			long candidateStatusId, String uuid,
			OrderByComparator<CandidateStatus> orderByComparator)
		throws com.prime.data.service.exception.NoSuchCandidateStatusException {

		return getPersistence().findByUuid_PrevAndNext(
			candidateStatusId, uuid, orderByComparator);
	}

	/**
	 * Removes all the candidate statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of candidate statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching candidate statuses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the candidate status in the entity cache if it is enabled.
	 *
	 * @param candidateStatus the candidate status
	 */
	public static void cacheResult(CandidateStatus candidateStatus) {
		getPersistence().cacheResult(candidateStatus);
	}

	/**
	 * Caches the candidate statuses in the entity cache if it is enabled.
	 *
	 * @param candidateStatuses the candidate statuses
	 */
	public static void cacheResult(List<CandidateStatus> candidateStatuses) {
		getPersistence().cacheResult(candidateStatuses);
	}

	/**
	 * Creates a new candidate status with the primary key. Does not add the candidate status to the database.
	 *
	 * @param candidateStatusId the primary key for the new candidate status
	 * @return the new candidate status
	 */
	public static CandidateStatus create(long candidateStatusId) {
		return getPersistence().create(candidateStatusId);
	}

	/**
	 * Removes the candidate status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status that was removed
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	public static CandidateStatus remove(long candidateStatusId)
		throws com.prime.data.service.exception.NoSuchCandidateStatusException {

		return getPersistence().remove(candidateStatusId);
	}

	public static CandidateStatus updateImpl(CandidateStatus candidateStatus) {
		return getPersistence().updateImpl(candidateStatus);
	}

	/**
	 * Returns the candidate status with the primary key or throws a <code>NoSuchCandidateStatusException</code> if it could not be found.
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	public static CandidateStatus findByPrimaryKey(long candidateStatusId)
		throws com.prime.data.service.exception.NoSuchCandidateStatusException {

		return getPersistence().findByPrimaryKey(candidateStatusId);
	}

	/**
	 * Returns the candidate status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status, or <code>null</code> if a candidate status with the primary key could not be found
	 */
	public static CandidateStatus fetchByPrimaryKey(long candidateStatusId) {
		return getPersistence().fetchByPrimaryKey(candidateStatusId);
	}

	/**
	 * Returns all the candidate statuses.
	 *
	 * @return the candidate statuses
	 */
	public static List<CandidateStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the candidate statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @return the range of candidate statuses
	 */
	public static List<CandidateStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the candidate statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate statuses
	 */
	public static List<CandidateStatus> findAll(
		int start, int end,
		OrderByComparator<CandidateStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the candidate statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of candidate statuses
	 */
	public static List<CandidateStatus> findAll(
		int start, int end,
		OrderByComparator<CandidateStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the candidate statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of candidate statuses.
	 *
	 * @return the number of candidate statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CandidateStatusPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CandidateStatusPersistence _persistence;

}