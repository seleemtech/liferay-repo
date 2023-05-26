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

import com.candidate.service.model.ProfessionalDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the professional details service. This utility wraps <code>com.candidate.service.service.persistence.impl.ProfessionalDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalDetailsPersistence
 * @generated
 */
public class ProfessionalDetailsUtil {

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
	public static void clearCache(ProfessionalDetails professionalDetails) {
		getPersistence().clearCache(professionalDetails);
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
	public static Map<Serializable, ProfessionalDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProfessionalDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProfessionalDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProfessionalDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProfessionalDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProfessionalDetails update(
		ProfessionalDetails professionalDetails) {

		return getPersistence().update(professionalDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProfessionalDetails update(
		ProfessionalDetails professionalDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(professionalDetails, serviceContext);
	}

	/**
	 * Returns all the professional detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching professional detailses
	 */
	public static List<ProfessionalDetails> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the professional detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @return the range of matching professional detailses
	 */
	public static List<ProfessionalDetails> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the professional detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching professional detailses
	 */
	public static List<ProfessionalDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfessionalDetails> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the professional detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching professional detailses
	 */
	public static List<ProfessionalDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProfessionalDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first professional details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional details
	 * @throws NoSuchProfessionalDetailsException if a matching professional details could not be found
	 */
	public static ProfessionalDetails findByUuid_First(
			String uuid,
			OrderByComparator<ProfessionalDetails> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first professional details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public static ProfessionalDetails fetchByUuid_First(
		String uuid, OrderByComparator<ProfessionalDetails> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last professional details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional details
	 * @throws NoSuchProfessionalDetailsException if a matching professional details could not be found
	 */
	public static ProfessionalDetails findByUuid_Last(
			String uuid,
			OrderByComparator<ProfessionalDetails> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last professional details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public static ProfessionalDetails fetchByUuid_Last(
		String uuid, OrderByComparator<ProfessionalDetails> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the professional detailses before and after the current professional details in the ordered set where uuid = &#63;.
	 *
	 * @param professionalDetailsId the primary key of the current professional details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professional details
	 * @throws NoSuchProfessionalDetailsException if a professional details with the primary key could not be found
	 */
	public static ProfessionalDetails[] findByUuid_PrevAndNext(
			long professionalDetailsId, String uuid,
			OrderByComparator<ProfessionalDetails> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getPersistence().findByUuid_PrevAndNext(
			professionalDetailsId, uuid, orderByComparator);
	}

	/**
	 * Removes all the professional detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of professional detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching professional detailses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the professional detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching professional detailses
	 */
	public static List<ProfessionalDetails> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the professional detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @return the range of matching professional detailses
	 */
	public static List<ProfessionalDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the professional detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching professional detailses
	 */
	public static List<ProfessionalDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfessionalDetails> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the professional detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching professional detailses
	 */
	public static List<ProfessionalDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProfessionalDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first professional details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional details
	 * @throws NoSuchProfessionalDetailsException if a matching professional details could not be found
	 */
	public static ProfessionalDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProfessionalDetails> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first professional details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public static ProfessionalDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProfessionalDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last professional details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional details
	 * @throws NoSuchProfessionalDetailsException if a matching professional details could not be found
	 */
	public static ProfessionalDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProfessionalDetails> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last professional details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public static ProfessionalDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProfessionalDetails> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the professional detailses before and after the current professional details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param professionalDetailsId the primary key of the current professional details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next professional details
	 * @throws NoSuchProfessionalDetailsException if a professional details with the primary key could not be found
	 */
	public static ProfessionalDetails[] findByUuid_C_PrevAndNext(
			long professionalDetailsId, String uuid, long companyId,
			OrderByComparator<ProfessionalDetails> orderByComparator)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			professionalDetailsId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the professional detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of professional detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching professional detailses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the professional details where candidateId = &#63; or throws a <code>NoSuchProfessionalDetailsException</code> if it could not be found.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching professional details
	 * @throws NoSuchProfessionalDetailsException if a matching professional details could not be found
	 */
	public static ProfessionalDetails findByCandidateId(long candidateId)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getPersistence().findByCandidateId(candidateId);
	}

	/**
	 * Returns the professional details where candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public static ProfessionalDetails fetchByCandidateId(long candidateId) {
		return getPersistence().fetchByCandidateId(candidateId);
	}

	/**
	 * Returns the professional details where candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public static ProfessionalDetails fetchByCandidateId(
		long candidateId, boolean useFinderCache) {

		return getPersistence().fetchByCandidateId(candidateId, useFinderCache);
	}

	/**
	 * Removes the professional details where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @return the professional details that was removed
	 */
	public static ProfessionalDetails removeByCandidateId(long candidateId)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getPersistence().removeByCandidateId(candidateId);
	}

	/**
	 * Returns the number of professional detailses where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching professional detailses
	 */
	public static int countByCandidateId(long candidateId) {
		return getPersistence().countByCandidateId(candidateId);
	}

	/**
	 * Caches the professional details in the entity cache if it is enabled.
	 *
	 * @param professionalDetails the professional details
	 */
	public static void cacheResult(ProfessionalDetails professionalDetails) {
		getPersistence().cacheResult(professionalDetails);
	}

	/**
	 * Caches the professional detailses in the entity cache if it is enabled.
	 *
	 * @param professionalDetailses the professional detailses
	 */
	public static void cacheResult(
		List<ProfessionalDetails> professionalDetailses) {

		getPersistence().cacheResult(professionalDetailses);
	}

	/**
	 * Creates a new professional details with the primary key. Does not add the professional details to the database.
	 *
	 * @param professionalDetailsId the primary key for the new professional details
	 * @return the new professional details
	 */
	public static ProfessionalDetails create(long professionalDetailsId) {
		return getPersistence().create(professionalDetailsId);
	}

	/**
	 * Removes the professional details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param professionalDetailsId the primary key of the professional details
	 * @return the professional details that was removed
	 * @throws NoSuchProfessionalDetailsException if a professional details with the primary key could not be found
	 */
	public static ProfessionalDetails remove(long professionalDetailsId)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getPersistence().remove(professionalDetailsId);
	}

	public static ProfessionalDetails updateImpl(
		ProfessionalDetails professionalDetails) {

		return getPersistence().updateImpl(professionalDetails);
	}

	/**
	 * Returns the professional details with the primary key or throws a <code>NoSuchProfessionalDetailsException</code> if it could not be found.
	 *
	 * @param professionalDetailsId the primary key of the professional details
	 * @return the professional details
	 * @throws NoSuchProfessionalDetailsException if a professional details with the primary key could not be found
	 */
	public static ProfessionalDetails findByPrimaryKey(
			long professionalDetailsId)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getPersistence().findByPrimaryKey(professionalDetailsId);
	}

	/**
	 * Returns the professional details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param professionalDetailsId the primary key of the professional details
	 * @return the professional details, or <code>null</code> if a professional details with the primary key could not be found
	 */
	public static ProfessionalDetails fetchByPrimaryKey(
		long professionalDetailsId) {

		return getPersistence().fetchByPrimaryKey(professionalDetailsId);
	}

	/**
	 * Returns all the professional detailses.
	 *
	 * @return the professional detailses
	 */
	public static List<ProfessionalDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the professional detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @return the range of professional detailses
	 */
	public static List<ProfessionalDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the professional detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of professional detailses
	 */
	public static List<ProfessionalDetails> findAll(
		int start, int end,
		OrderByComparator<ProfessionalDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the professional detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of professional detailses
	 */
	public static List<ProfessionalDetails> findAll(
		int start, int end,
		OrderByComparator<ProfessionalDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the professional detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of professional detailses.
	 *
	 * @return the number of professional detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProfessionalDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProfessionalDetailsPersistence _persistence;

}