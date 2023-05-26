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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.prime.data.service.exception.NoSuchCandidateStatusException;
import com.prime.data.service.model.CandidateStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the candidate status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateStatusUtil
 * @generated
 */
@ProviderType
public interface CandidateStatusPersistence
	extends BasePersistence<CandidateStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CandidateStatusUtil} to access the candidate status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the candidate statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching candidate statuses
	 */
	public java.util.List<CandidateStatus> findByUuid(String uuid);

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
	public java.util.List<CandidateStatus> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CandidateStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateStatus>
			orderByComparator);

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
	public java.util.List<CandidateStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate status
	 * @throws NoSuchCandidateStatusException if a matching candidate status could not be found
	 */
	public CandidateStatus findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateStatus>
				orderByComparator)
		throws NoSuchCandidateStatusException;

	/**
	 * Returns the first candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate status, or <code>null</code> if a matching candidate status could not be found
	 */
	public CandidateStatus fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateStatus>
			orderByComparator);

	/**
	 * Returns the last candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate status
	 * @throws NoSuchCandidateStatusException if a matching candidate status could not be found
	 */
	public CandidateStatus findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateStatus>
				orderByComparator)
		throws NoSuchCandidateStatusException;

	/**
	 * Returns the last candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate status, or <code>null</code> if a matching candidate status could not be found
	 */
	public CandidateStatus fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateStatus>
			orderByComparator);

	/**
	 * Returns the candidate statuses before and after the current candidate status in the ordered set where uuid = &#63;.
	 *
	 * @param candidateStatusId the primary key of the current candidate status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate status
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	public CandidateStatus[] findByUuid_PrevAndNext(
			long candidateStatusId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CandidateStatus>
				orderByComparator)
		throws NoSuchCandidateStatusException;

	/**
	 * Removes all the candidate statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of candidate statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching candidate statuses
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the candidate status in the entity cache if it is enabled.
	 *
	 * @param candidateStatus the candidate status
	 */
	public void cacheResult(CandidateStatus candidateStatus);

	/**
	 * Caches the candidate statuses in the entity cache if it is enabled.
	 *
	 * @param candidateStatuses the candidate statuses
	 */
	public void cacheResult(java.util.List<CandidateStatus> candidateStatuses);

	/**
	 * Creates a new candidate status with the primary key. Does not add the candidate status to the database.
	 *
	 * @param candidateStatusId the primary key for the new candidate status
	 * @return the new candidate status
	 */
	public CandidateStatus create(long candidateStatusId);

	/**
	 * Removes the candidate status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status that was removed
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	public CandidateStatus remove(long candidateStatusId)
		throws NoSuchCandidateStatusException;

	public CandidateStatus updateImpl(CandidateStatus candidateStatus);

	/**
	 * Returns the candidate status with the primary key or throws a <code>NoSuchCandidateStatusException</code> if it could not be found.
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status
	 * @throws NoSuchCandidateStatusException if a candidate status with the primary key could not be found
	 */
	public CandidateStatus findByPrimaryKey(long candidateStatusId)
		throws NoSuchCandidateStatusException;

	/**
	 * Returns the candidate status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status, or <code>null</code> if a candidate status with the primary key could not be found
	 */
	public CandidateStatus fetchByPrimaryKey(long candidateStatusId);

	/**
	 * Returns all the candidate statuses.
	 *
	 * @return the candidate statuses
	 */
	public java.util.List<CandidateStatus> findAll();

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
	public java.util.List<CandidateStatus> findAll(int start, int end);

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
	public java.util.List<CandidateStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateStatus>
			orderByComparator);

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
	public java.util.List<CandidateStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CandidateStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the candidate statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of candidate statuses.
	 *
	 * @return the number of candidate statuses
	 */
	public int countAll();

}