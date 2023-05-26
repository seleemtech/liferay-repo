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

package com.candidate.service.service.persistence;

import com.candidate.service.model.CandidateInfo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the candidate info service. This utility wraps <code>com.candidate.service.service.persistence.impl.CandidateInfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateInfoPersistence
 * @generated
 */
public class CandidateInfoUtil {

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
	public static void clearCache(CandidateInfo candidateInfo) {
		getPersistence().clearCache(candidateInfo);
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
	public static Map<Serializable, CandidateInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CandidateInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CandidateInfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CandidateInfo update(CandidateInfo candidateInfo) {
		return getPersistence().update(candidateInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CandidateInfo update(
		CandidateInfo candidateInfo, ServiceContext serviceContext) {

		return getPersistence().update(candidateInfo, serviceContext);
	}

	/**
	 * Returns all the candidate infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching candidate infos
	 */
	public static List<CandidateInfo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the candidate infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate infos
	 * @param end the upper bound of the range of candidate infos (not inclusive)
	 * @return the range of matching candidate infos
	 */
	public static List<CandidateInfo> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the candidate infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate infos
	 * @param end the upper bound of the range of candidate infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate infos
	 */
	public static List<CandidateInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CandidateInfo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the candidate infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate infos
	 * @param end the upper bound of the range of candidate infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate infos
	 */
	public static List<CandidateInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CandidateInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first candidate info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate info
	 * @throws NoSuchCandidateInfoException if a matching candidate info could not be found
	 */
	public static CandidateInfo findByUuid_First(
			String uuid, OrderByComparator<CandidateInfo> orderByComparator)
		throws com.candidate.service.exception.NoSuchCandidateInfoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first candidate info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate info, or <code>null</code> if a matching candidate info could not be found
	 */
	public static CandidateInfo fetchByUuid_First(
		String uuid, OrderByComparator<CandidateInfo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last candidate info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate info
	 * @throws NoSuchCandidateInfoException if a matching candidate info could not be found
	 */
	public static CandidateInfo findByUuid_Last(
			String uuid, OrderByComparator<CandidateInfo> orderByComparator)
		throws com.candidate.service.exception.NoSuchCandidateInfoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last candidate info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate info, or <code>null</code> if a matching candidate info could not be found
	 */
	public static CandidateInfo fetchByUuid_Last(
		String uuid, OrderByComparator<CandidateInfo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the candidate infos before and after the current candidate info in the ordered set where uuid = &#63;.
	 *
	 * @param candidateId the primary key of the current candidate info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate info
	 * @throws NoSuchCandidateInfoException if a candidate info with the primary key could not be found
	 */
	public static CandidateInfo[] findByUuid_PrevAndNext(
			long candidateId, String uuid,
			OrderByComparator<CandidateInfo> orderByComparator)
		throws com.candidate.service.exception.NoSuchCandidateInfoException {

		return getPersistence().findByUuid_PrevAndNext(
			candidateId, uuid, orderByComparator);
	}

	/**
	 * Removes all the candidate infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of candidate infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching candidate infos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the candidate infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching candidate infos
	 */
	public static List<CandidateInfo> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the candidate infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of candidate infos
	 * @param end the upper bound of the range of candidate infos (not inclusive)
	 * @return the range of matching candidate infos
	 */
	public static List<CandidateInfo> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the candidate infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of candidate infos
	 * @param end the upper bound of the range of candidate infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate infos
	 */
	public static List<CandidateInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CandidateInfo> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the candidate infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of candidate infos
	 * @param end the upper bound of the range of candidate infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate infos
	 */
	public static List<CandidateInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CandidateInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first candidate info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate info
	 * @throws NoSuchCandidateInfoException if a matching candidate info could not be found
	 */
	public static CandidateInfo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CandidateInfo> orderByComparator)
		throws com.candidate.service.exception.NoSuchCandidateInfoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first candidate info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate info, or <code>null</code> if a matching candidate info could not be found
	 */
	public static CandidateInfo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CandidateInfo> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last candidate info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate info
	 * @throws NoSuchCandidateInfoException if a matching candidate info could not be found
	 */
	public static CandidateInfo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CandidateInfo> orderByComparator)
		throws com.candidate.service.exception.NoSuchCandidateInfoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last candidate info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate info, or <code>null</code> if a matching candidate info could not be found
	 */
	public static CandidateInfo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CandidateInfo> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the candidate infos before and after the current candidate info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param candidateId the primary key of the current candidate info
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate info
	 * @throws NoSuchCandidateInfoException if a candidate info with the primary key could not be found
	 */
	public static CandidateInfo[] findByUuid_C_PrevAndNext(
			long candidateId, String uuid, long companyId,
			OrderByComparator<CandidateInfo> orderByComparator)
		throws com.candidate.service.exception.NoSuchCandidateInfoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			candidateId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the candidate infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of candidate infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching candidate infos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the candidate info in the entity cache if it is enabled.
	 *
	 * @param candidateInfo the candidate info
	 */
	public static void cacheResult(CandidateInfo candidateInfo) {
		getPersistence().cacheResult(candidateInfo);
	}

	/**
	 * Caches the candidate infos in the entity cache if it is enabled.
	 *
	 * @param candidateInfos the candidate infos
	 */
	public static void cacheResult(List<CandidateInfo> candidateInfos) {
		getPersistence().cacheResult(candidateInfos);
	}

	/**
	 * Creates a new candidate info with the primary key. Does not add the candidate info to the database.
	 *
	 * @param candidateId the primary key for the new candidate info
	 * @return the new candidate info
	 */
	public static CandidateInfo create(long candidateId) {
		return getPersistence().create(candidateId);
	}

	/**
	 * Removes the candidate info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateId the primary key of the candidate info
	 * @return the candidate info that was removed
	 * @throws NoSuchCandidateInfoException if a candidate info with the primary key could not be found
	 */
	public static CandidateInfo remove(long candidateId)
		throws com.candidate.service.exception.NoSuchCandidateInfoException {

		return getPersistence().remove(candidateId);
	}

	public static CandidateInfo updateImpl(CandidateInfo candidateInfo) {
		return getPersistence().updateImpl(candidateInfo);
	}

	/**
	 * Returns the candidate info with the primary key or throws a <code>NoSuchCandidateInfoException</code> if it could not be found.
	 *
	 * @param candidateId the primary key of the candidate info
	 * @return the candidate info
	 * @throws NoSuchCandidateInfoException if a candidate info with the primary key could not be found
	 */
	public static CandidateInfo findByPrimaryKey(long candidateId)
		throws com.candidate.service.exception.NoSuchCandidateInfoException {

		return getPersistence().findByPrimaryKey(candidateId);
	}

	/**
	 * Returns the candidate info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateId the primary key of the candidate info
	 * @return the candidate info, or <code>null</code> if a candidate info with the primary key could not be found
	 */
	public static CandidateInfo fetchByPrimaryKey(long candidateId) {
		return getPersistence().fetchByPrimaryKey(candidateId);
	}

	/**
	 * Returns all the candidate infos.
	 *
	 * @return the candidate infos
	 */
	public static List<CandidateInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the candidate infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate infos
	 * @param end the upper bound of the range of candidate infos (not inclusive)
	 * @return the range of candidate infos
	 */
	public static List<CandidateInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the candidate infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate infos
	 * @param end the upper bound of the range of candidate infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate infos
	 */
	public static List<CandidateInfo> findAll(
		int start, int end,
		OrderByComparator<CandidateInfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the candidate infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate infos
	 * @param end the upper bound of the range of candidate infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of candidate infos
	 */
	public static List<CandidateInfo> findAll(
		int start, int end, OrderByComparator<CandidateInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the candidate infos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of candidate infos.
	 *
	 * @return the number of candidate infos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CandidateInfoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CandidateInfoPersistence _persistence;

}