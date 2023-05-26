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

import com.candidate.service.exception.NoSuchCandidateInfoException;
import com.candidate.service.model.CandidateInfo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the candidate info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateInfoUtil
 * @generated
 */
@ProviderType
public interface CandidateInfoPersistence
	extends BasePersistence<CandidateInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateInfoUtil} to access the candidate info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the candidate infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching candidate infos
	 */
	public java.util.List<CandidateInfo> findByUuid(String uuid);

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
	public java.util.List<CandidateInfo> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CandidateInfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
			orderByComparator);

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
	public java.util.List<CandidateInfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first candidate info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate info
	 * @throws NoSuchCandidateInfoException if a matching candidate info could not be found
	 */
	public CandidateInfo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
				orderByComparator)
		throws NoSuchCandidateInfoException;

	/**
	 * Returns the first candidate info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate info, or <code>null</code> if a matching candidate info could not be found
	 */
	public CandidateInfo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
			orderByComparator);

	/**
	 * Returns the last candidate info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate info
	 * @throws NoSuchCandidateInfoException if a matching candidate info could not be found
	 */
	public CandidateInfo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
				orderByComparator)
		throws NoSuchCandidateInfoException;

	/**
	 * Returns the last candidate info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate info, or <code>null</code> if a matching candidate info could not be found
	 */
	public CandidateInfo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
			orderByComparator);

	/**
	 * Returns the candidate infos before and after the current candidate info in the ordered set where uuid = &#63;.
	 *
	 * @param candidateId the primary key of the current candidate info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate info
	 * @throws NoSuchCandidateInfoException if a candidate info with the primary key could not be found
	 */
	public CandidateInfo[] findByUuid_PrevAndNext(
			long candidateId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
				orderByComparator)
		throws NoSuchCandidateInfoException;

	/**
	 * Removes all the candidate infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of candidate infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching candidate infos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the candidate infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching candidate infos
	 */
	public java.util.List<CandidateInfo> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CandidateInfo> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CandidateInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
			orderByComparator);

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
	public java.util.List<CandidateInfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first candidate info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate info
	 * @throws NoSuchCandidateInfoException if a matching candidate info could not be found
	 */
	public CandidateInfo findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
				orderByComparator)
		throws NoSuchCandidateInfoException;

	/**
	 * Returns the first candidate info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate info, or <code>null</code> if a matching candidate info could not be found
	 */
	public CandidateInfo fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
			orderByComparator);

	/**
	 * Returns the last candidate info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate info
	 * @throws NoSuchCandidateInfoException if a matching candidate info could not be found
	 */
	public CandidateInfo findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
				orderByComparator)
		throws NoSuchCandidateInfoException;

	/**
	 * Returns the last candidate info in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate info, or <code>null</code> if a matching candidate info could not be found
	 */
	public CandidateInfo fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
			orderByComparator);

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
	public CandidateInfo[] findByUuid_C_PrevAndNext(
			long candidateId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
				orderByComparator)
		throws NoSuchCandidateInfoException;

	/**
	 * Removes all the candidate infos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of candidate infos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching candidate infos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the candidate info in the entity cache if it is enabled.
	 *
	 * @param candidateInfo the candidate info
	 */
	public void cacheResult(CandidateInfo candidateInfo);

	/**
	 * Caches the candidate infos in the entity cache if it is enabled.
	 *
	 * @param candidateInfos the candidate infos
	 */
	public void cacheResult(java.util.List<CandidateInfo> candidateInfos);

	/**
	 * Creates a new candidate info with the primary key. Does not add the candidate info to the database.
	 *
	 * @param candidateId the primary key for the new candidate info
	 * @return the new candidate info
	 */
	public CandidateInfo create(long candidateId);

	/**
	 * Removes the candidate info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateId the primary key of the candidate info
	 * @return the candidate info that was removed
	 * @throws NoSuchCandidateInfoException if a candidate info with the primary key could not be found
	 */
	public CandidateInfo remove(long candidateId)
		throws NoSuchCandidateInfoException;

	public CandidateInfo updateImpl(CandidateInfo candidateInfo);

	/**
	 * Returns the candidate info with the primary key or throws a <code>NoSuchCandidateInfoException</code> if it could not be found.
	 *
	 * @param candidateId the primary key of the candidate info
	 * @return the candidate info
	 * @throws NoSuchCandidateInfoException if a candidate info with the primary key could not be found
	 */
	public CandidateInfo findByPrimaryKey(long candidateId)
		throws NoSuchCandidateInfoException;

	/**
	 * Returns the candidate info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateId the primary key of the candidate info
	 * @return the candidate info, or <code>null</code> if a candidate info with the primary key could not be found
	 */
	public CandidateInfo fetchByPrimaryKey(long candidateId);

	/**
	 * Returns all the candidate infos.
	 *
	 * @return the candidate infos
	 */
	public java.util.List<CandidateInfo> findAll();

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
	public java.util.List<CandidateInfo> findAll(int start, int end);

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
	public java.util.List<CandidateInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
			orderByComparator);

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
	public java.util.List<CandidateInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the candidate infos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of candidate infos.
	 *
	 * @return the number of candidate infos
	 */
	public int countAll();

}