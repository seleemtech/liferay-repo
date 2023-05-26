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

import com.candidate.service.exception.NoSuchCandidateOtherInfoException;
import com.candidate.service.model.CandidateOtherInfo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the candidate other info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateOtherInfoUtil
 * @generated
 */
@ProviderType
public interface CandidateOtherInfoPersistence
	extends BasePersistence<CandidateOtherInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateOtherInfoUtil} to access the candidate other info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the candidate other infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching candidate other infos
	 */
	public java.util.List<CandidateOtherInfo> findByUuid(String uuid);

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
	public java.util.List<CandidateOtherInfo> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CandidateOtherInfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

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
	public java.util.List<CandidateOtherInfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the first candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where uuid = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public CandidateOtherInfo[] findByUuid_PrevAndNext(
			long candidateOtherInfoId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Removes all the candidate other infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of candidate other infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching candidate other infos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching candidate other infos
	 */
	public java.util.List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

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
	public java.util.List<CandidateOtherInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the first candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the last candidate other info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

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
	public CandidateOtherInfo[] findByUuid_C_PrevAndNext(
			long candidateOtherInfoId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Removes all the candidate other infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of candidate other infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching candidate other infos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the candidate other info where candidateId = &#63; or throws a <code>NoSuchCandidateOtherInfoException</code> if it could not be found.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo findByCandidateId(long candidateId)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByCandidateId(long candidateId);

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByCandidateId(
		long candidateId, boolean useFinderCache);

	/**
	 * Removes the candidate other info where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @return the candidate other info that was removed
	 */
	public CandidateOtherInfo removeByCandidateId(long candidateId)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the number of candidate other infos where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching candidate other infos
	 */
	public int countByCandidateId(long candidateId);

	/**
	 * Returns the candidate other info where candidateId = &#63; or throws a <code>NoSuchCandidateOtherInfoException</code> if it could not be found.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo findByCandidatesId(long candidateId)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByCandidatesId(long candidateId);

	/**
	 * Returns the candidate other info where candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByCandidatesId(
		long candidateId, boolean useFinderCache);

	/**
	 * Removes the candidate other info where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @return the candidate other info that was removed
	 */
	public CandidateOtherInfo removeByCandidatesId(long candidateId)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the number of candidate other infos where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching candidate other infos
	 */
	public int countByCandidatesId(long candidateId);

	/**
	 * Returns all the candidate other infos where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @return the matching candidate other infos
	 */
	public java.util.List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus);

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
	public java.util.List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus, int start, int end);

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
	public java.util.List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

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
	public java.util.List<CandidateOtherInfo> findByCandidateStatus(
		String candidateStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo findByCandidateStatus_First(
			String candidateStatus,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the first candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByCandidateStatus_First(
		String candidateStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

	/**
	 * Returns the last candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo findByCandidateStatus_Last(
			String candidateStatus,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the last candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByCandidateStatus_Last(
		String candidateStatus,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where candidateStatus = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param candidateStatus the candidate status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public CandidateOtherInfo[] findByCandidateStatus_PrevAndNext(
			long candidateOtherInfoId, String candidateStatus,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Removes all the candidate other infos where candidateStatus = &#63; from the database.
	 *
	 * @param candidateStatus the candidate status
	 */
	public void removeByCandidateStatus(String candidateStatus);

	/**
	 * Returns the number of candidate other infos where candidateStatus = &#63;.
	 *
	 * @param candidateStatus the candidate status
	 * @return the number of matching candidate other infos
	 */
	public int countByCandidateStatus(String candidateStatus);

	/**
	 * Returns all the candidate other infos where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @return the matching candidate other infos
	 */
	public java.util.List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage);

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
	public java.util.List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage, int start, int end);

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
	public java.util.List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

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
	public java.util.List<CandidateOtherInfo> findByCandidateStage(
		String candidateStage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo findByCandidateStage_First(
			String candidateStage,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the first candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByCandidateStage_First(
		String candidateStage,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

	/**
	 * Returns the last candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo findByCandidateStage_Last(
			String candidateStage,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the last candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public CandidateOtherInfo fetchByCandidateStage_Last(
		String candidateStage,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

	/**
	 * Returns the candidate other infos before and after the current candidate other info in the ordered set where candidateStage = &#63;.
	 *
	 * @param candidateOtherInfoId the primary key of the current candidate other info
	 * @param candidateStage the candidate stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public CandidateOtherInfo[] findByCandidateStage_PrevAndNext(
			long candidateOtherInfoId, String candidateStage,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
				orderByComparator)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Removes all the candidate other infos where candidateStage = &#63; from the database.
	 *
	 * @param candidateStage the candidate stage
	 */
	public void removeByCandidateStage(String candidateStage);

	/**
	 * Returns the number of candidate other infos where candidateStage = &#63;.
	 *
	 * @param candidateStage the candidate stage
	 * @return the number of matching candidate other infos
	 */
	public int countByCandidateStage(String candidateStage);

	/**
	 * Caches the candidate other info in the entity cache if it is enabled.
	 *
	 * @param candidateOtherInfo the candidate other info
	 */
	public void cacheResult(CandidateOtherInfo candidateOtherInfo);

	/**
	 * Caches the candidate other infos in the entity cache if it is enabled.
	 *
	 * @param candidateOtherInfos the candidate other infos
	 */
	public void cacheResult(
		java.util.List<CandidateOtherInfo> candidateOtherInfos);

	/**
	 * Creates a new candidate other info with the primary key. Does not add the candidate other info to the database.
	 *
	 * @param candidateOtherInfoId the primary key for the new candidate other info
	 * @return the new candidate other info
	 */
	public CandidateOtherInfo create(long candidateOtherInfoId);

	/**
	 * Removes the candidate other info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info that was removed
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public CandidateOtherInfo remove(long candidateOtherInfoId)
		throws NoSuchCandidateOtherInfoException;

	public CandidateOtherInfo updateImpl(CandidateOtherInfo candidateOtherInfo);

	/**
	 * Returns the candidate other info with the primary key or throws a <code>NoSuchCandidateOtherInfoException</code> if it could not be found.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info
	 * @throws NoSuchCandidateOtherInfoException if a candidate other info with the primary key could not be found
	 */
	public CandidateOtherInfo findByPrimaryKey(long candidateOtherInfoId)
		throws NoSuchCandidateOtherInfoException;

	/**
	 * Returns the candidate other info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info, or <code>null</code> if a candidate other info with the primary key could not be found
	 */
	public CandidateOtherInfo fetchByPrimaryKey(long candidateOtherInfoId);

	/**
	 * Returns all the candidate other infos.
	 *
	 * @return the candidate other infos
	 */
	public java.util.List<CandidateOtherInfo> findAll();

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
	public java.util.List<CandidateOtherInfo> findAll(int start, int end);

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
	public java.util.List<CandidateOtherInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator);

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
	public java.util.List<CandidateOtherInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateOtherInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the candidate other infos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of candidate other infos.
	 *
	 * @return the number of candidate other infos
	 */
	public int countAll();

}