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

import com.candidate.service.model.CandidateOtherInfo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the candidate other info service. This utility wraps <code>com.candidate.service.service.persistence.impl.CandidateOtherInfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateOtherInfoPersistence
 * @generated
 */
public class CandidateOtherInfoUtil {

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
	public static void clearCache(CandidateOtherInfo candidateOtherInfo) {
		getPersistence().clearCache(candidateOtherInfo);
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
	public static Map<Serializable, CandidateOtherInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CandidateOtherInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CandidateOtherInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CandidateOtherInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CandidateOtherInfo update(
		CandidateOtherInfo candidateOtherInfo) {

		return getPersistence().update(candidateOtherInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CandidateOtherInfo update(
		CandidateOtherInfo candidateOtherInfo, ServiceContext serviceContext) {

		return getPersistence().update(candidateOtherInfo, serviceContext);
	}

	/**
	 * Returns all the candidate other infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the candidate other infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo findByUuid_First(
			String uuid,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByUuid_First(
		String uuid, OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo findByUuid_Last(
			String uuid,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByUuid_Last(
		String uuid, OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public static CandidateOtherInfo[] findByUuid_PrevAndNext(
			long candidateOtherInfoId, String uuid,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByUuid_PrevAndNext(
			candidateOtherInfoId, uuid, orderByComparator);
	}

	/**
	 * Removes all the candidate other infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of candidate other infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching candidate other infos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public static CandidateOtherInfo[] findByUuid_C_PrevAndNext(
			long candidateOtherInfoId, String uuid, long companyId,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			candidateOtherInfoId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the candidate other infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching candidate other infos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the candidate other info where candidateId = &#63; or throws a <code>NoSuchCandidateOtherInfoException</code> if it could not be found.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo findByCandidateId(long candidateId)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByCandidateId(candidateId);
	}

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByCandidateId(long candidateId) {
		return getPersistence().fetchByCandidateId(candidateId);
	}

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByCandidateId(
		long candidateId, boolean useFinderCache) {

		return getPersistence().fetchByCandidateId(candidateId, useFinderCache);
	}

	/**
	 * Removes the candidate other info where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @return the candidate other info that was removed
	 */
	public static CandidateOtherInfo removeByCandidateId(long candidateId)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().removeByCandidateId(candidateId);
	}

	/**
	 * Returns the number of candidate other infos where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching candidate other infos
	 */
	public static int countByCandidateId(long candidateId) {
		return getPersistence().countByCandidateId(candidateId);
	}

	/**
	 * Returns the candidate other info where candidateId = &#63; or throws a <code>NoSuchCandidateOtherInfoException</code> if it could not be found.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo findByCandidatesId(long candidateId)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByCandidatesId(candidateId);
	}

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByCandidatesId(long candidateId) {
		return getPersistence().fetchByCandidatesId(candidateId);
	}

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByCandidatesId(
		long candidateId, boolean useFinderCache) {

		return getPersistence().fetchByCandidatesId(
			candidateId, useFinderCache);
	}

	/**
	 * Removes the candidate other info where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @return the candidate other info that was removed
	 */
	public static CandidateOtherInfo removeByCandidatesId(long candidateId)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().removeByCandidatesId(candidateId);
	}

	/**
	 * Returns the number of candidate other infos where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching candidate other infos
	 */
	public static int countByCandidatesId(long candidateId) {
		return getPersistence().countByCandidatesId(candidateId);
	}

	/**
	 * Returns all the candidate other infos where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @return the matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus) {

		return getPersistence().findByCandidateStatus(candidateStatus);
	}

	/**
	 * Returns a range of all the candidate other infos where candidateStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStatus the candidate status
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus, int start, int end) {

		return getPersistence().findByCandidateStatus(
			candidateStatus, start, end);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where candidateStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStatus the candidate status
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().findByCandidateStatus(
			candidateStatus, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where candidateStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStatus the candidate status
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCandidateStatus(
			candidateStatus, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo findByCandidateStatus_First(
			String candidateStatus,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByCandidateStatus_First(
			candidateStatus, orderByComparator);
	}

	/**
	 * Returns the first candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByCandidateStatus_First(
		String candidateStatus,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().fetchByCandidateStatus_First(
			candidateStatus, orderByComparator);
	}

	/**
	 * Returns the last candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo findByCandidateStatus_Last(
			String candidateStatus,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByCandidateStatus_Last(
			candidateStatus, orderByComparator);
	}

	/**
	 * Returns the last candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByCandidateStatus_Last(
		String candidateStatus,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().fetchByCandidateStatus_Last(
			candidateStatus, orderByComparator);
	}

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public static CandidateOtherInfo[] findByCandidateStatus_PrevAndNext(
			long candidateOtherInfoId, String candidateStatus,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByCandidateStatus_PrevAndNext(
			candidateOtherInfoId, candidateStatus, orderByComparator);
	}

	/**
	 * Removes all the candidate other infos where candidateStatus = &#63; from the database.
	 *
	 * @param candidateStatus the candidate status
	 */
	public static void removeByCandidateStatus(String candidateStatus) {
		getPersistence().removeByCandidateStatus(candidateStatus);
	}

	/**
	 * Returns the number of candidate other infos where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @return the number of matching candidate other infos
	 */
	public static int countByCandidateStatus(String candidateStatus) {
		return getPersistence().countByCandidateStatus(candidateStatus);
	}

	/**
	 * Returns all the candidate other infos where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @return the matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage) {

		return getPersistence().findByCandidateStage(candidateStage);
	}

	/**
	 * Returns a range of all the candidate other infos where candidateStage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStage the candidate stage
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage, int start, int end) {

		return getPersistence().findByCandidateStage(
			candidateStage, start, end);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where candidateStage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStage the candidate stage
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().findByCandidateStage(
			candidateStage, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the candidate other infos where candidateStage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param candidateStage the candidate stage
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching candidate other infos
	 */
	public static List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage, int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCandidateStage(
			candidateStage, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo findByCandidateStage_First(
			String candidateStage,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByCandidateStage_First(
			candidateStage, orderByComparator);
	}

	/**
	 * Returns the first candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByCandidateStage_First(
		String candidateStage,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().fetchByCandidateStage_First(
			candidateStage, orderByComparator);
	}

	/**
	 * Returns the last candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo findByCandidateStage_Last(
			String candidateStage,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByCandidateStage_Last(
			candidateStage, orderByComparator);
	}

	/**
	 * Returns the last candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchByCandidateStage_Last(
		String candidateStage,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().fetchByCandidateStage_Last(
			candidateStage, orderByComparator);
	}

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public static CandidateOtherInfo[] findByCandidateStage_PrevAndNext(
			long candidateOtherInfoId, String candidateStage,
			OrderByComparator<CandidateOtherInfo> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByCandidateStage_PrevAndNext(
			candidateOtherInfoId, candidateStage, orderByComparator);
	}

	/**
	 * Removes all the candidate other infos where candidateStage = &#63; from the database.
	 *
	 * @param candidateStage the candidate stage
	 */
	public static void removeByCandidateStage(String candidateStage) {
		getPersistence().removeByCandidateStage(candidateStage);
	}

	/**
	 * Returns the number of candidate other infos where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @return the number of matching candidate other infos
	 */
	public static int countByCandidateStage(String candidateStage) {
		return getPersistence().countByCandidateStage(candidateStage);
	}

	/**
	 * Caches the candidate other info in the entity cache if it is enabled.
	 *
	 * @param candidateOtherInfo the candidate other info
	 */
	public static void cacheResult(CandidateOtherInfo candidateOtherInfo) {
		getPersistence().cacheResult(candidateOtherInfo);
	}

	/**
	 * Caches the candidate other infos in the entity cache if it is enabled.
	 *
	 * @param candidateOtherInfos the candidate other infos
	 */
	public static void cacheResult(
		List<CandidateOtherInfo> candidateOtherInfos) {

		getPersistence().cacheResult(candidateOtherInfos);
	}

	/**
	 * Creates a new candidate other info with the primary key. Does not add the candidate other info to the database.
	 *
	 * @param candidateOtherInfoId the primary key for the new candidate other info
	 * @return the new candidate other info
	 */
	public static CandidateOtherInfo create(long candidateOtherInfoId) {
		return getPersistence().create(candidateOtherInfoId);
	}

	/**
	 * Removes the candidate other info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info that was removed
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public static CandidateOtherInfo remove(long candidateOtherInfoId)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().remove(candidateOtherInfoId);
	}

	public static CandidateOtherInfo updateImpl(
		CandidateOtherInfo candidateOtherInfo) {

		return getPersistence().updateImpl(candidateOtherInfo);
	}

	/**
	 * Returns the candidate other info with the primary key or throws a <code>NoSuchCandidateOtherInfoException</code> if it could not be found.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public static CandidateOtherInfo findByPrimaryKey(long candidateOtherInfoId)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getPersistence().findByPrimaryKey(candidateOtherInfoId);
	}

	/**
	 * Returns the candidate other info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info, or <code>null</code> if a candidate other info with the primary key could not be found
	 */
	public static CandidateOtherInfo fetchByPrimaryKey(
		long candidateOtherInfoId) {

		return getPersistence().fetchByPrimaryKey(candidateOtherInfoId);
	}

	/**
	 * Returns all the candidate other infos.
	 *
	 * @return the candidate other infos
	 */
	public static List<CandidateOtherInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the candidate other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of candidate other infos
	 */
	public static List<CandidateOtherInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the candidate other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate other infos
	 */
	public static List<CandidateOtherInfo> findAll(
		int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the candidate other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of candidate other infos
	 */
	public static List<CandidateOtherInfo> findAll(
		int start, int end,
		OrderByComparator<CandidateOtherInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the candidate other infos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of candidate other infos.
	 *
	 * @return the number of candidate other infos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CandidateOtherInfoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CandidateOtherInfoPersistence _persistence;

}