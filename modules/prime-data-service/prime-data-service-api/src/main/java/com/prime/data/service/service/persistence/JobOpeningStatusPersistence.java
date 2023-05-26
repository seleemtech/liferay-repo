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

import com.prime.data.service.exception.NoSuchJobOpeningStatusException;
import com.prime.data.service.model.JobOpeningStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the job opening status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobOpeningStatusUtil
 * @generated
 */
@ProviderType
public interface JobOpeningStatusPersistence
	extends BasePersistence<JobOpeningStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobOpeningStatusUtil} to access the job opening status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the job opening statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching job opening statuses
	 */
	public java.util.List<JobOpeningStatus> findByUuid(String uuid);

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
	public java.util.List<JobOpeningStatus> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<JobOpeningStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobOpeningStatus>
			orderByComparator);

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
	public java.util.List<JobOpeningStatus> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobOpeningStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job opening status
	 * @throws NoSuchJobOpeningStatusException if a matching job opening status could not be found
	 */
	public JobOpeningStatus findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JobOpeningStatus>
				orderByComparator)
		throws NoSuchJobOpeningStatusException;

	/**
	 * Returns the first job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job opening status, or <code>null</code> if a matching job opening status could not be found
	 */
	public JobOpeningStatus fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<JobOpeningStatus>
			orderByComparator);

	/**
	 * Returns the last job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job opening status
	 * @throws NoSuchJobOpeningStatusException if a matching job opening status could not be found
	 */
	public JobOpeningStatus findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JobOpeningStatus>
				orderByComparator)
		throws NoSuchJobOpeningStatusException;

	/**
	 * Returns the last job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job opening status, or <code>null</code> if a matching job opening status could not be found
	 */
	public JobOpeningStatus fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<JobOpeningStatus>
			orderByComparator);

	/**
	 * Returns the job opening statuses before and after the current job opening status in the ordered set where uuid = &#63;.
	 *
	 * @param jobStatusId the primary key of the current job opening status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job opening status
	 * @throws NoSuchJobOpeningStatusException if a job opening status with the primary key could not be found
	 */
	public JobOpeningStatus[] findByUuid_PrevAndNext(
			long jobStatusId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JobOpeningStatus>
				orderByComparator)
		throws NoSuchJobOpeningStatusException;

	/**
	 * Removes all the job opening statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of job opening statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching job opening statuses
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the job opening status in the entity cache if it is enabled.
	 *
	 * @param jobOpeningStatus the job opening status
	 */
	public void cacheResult(JobOpeningStatus jobOpeningStatus);

	/**
	 * Caches the job opening statuses in the entity cache if it is enabled.
	 *
	 * @param jobOpeningStatuses the job opening statuses
	 */
	public void cacheResult(
		java.util.List<JobOpeningStatus> jobOpeningStatuses);

	/**
	 * Creates a new job opening status with the primary key. Does not add the job opening status to the database.
	 *
	 * @param jobStatusId the primary key for the new job opening status
	 * @return the new job opening status
	 */
	public JobOpeningStatus create(long jobStatusId);

	/**
	 * Removes the job opening status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status that was removed
	 * @throws NoSuchJobOpeningStatusException if a job opening status with the primary key could not be found
	 */
	public JobOpeningStatus remove(long jobStatusId)
		throws NoSuchJobOpeningStatusException;

	public JobOpeningStatus updateImpl(JobOpeningStatus jobOpeningStatus);

	/**
	 * Returns the job opening status with the primary key or throws a <code>NoSuchJobOpeningStatusException</code> if it could not be found.
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status
	 * @throws NoSuchJobOpeningStatusException if a job opening status with the primary key could not be found
	 */
	public JobOpeningStatus findByPrimaryKey(long jobStatusId)
		throws NoSuchJobOpeningStatusException;

	/**
	 * Returns the job opening status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status, or <code>null</code> if a job opening status with the primary key could not be found
	 */
	public JobOpeningStatus fetchByPrimaryKey(long jobStatusId);

	/**
	 * Returns all the job opening statuses.
	 *
	 * @return the job opening statuses
	 */
	public java.util.List<JobOpeningStatus> findAll();

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
	public java.util.List<JobOpeningStatus> findAll(int start, int end);

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
	public java.util.List<JobOpeningStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobOpeningStatus>
			orderByComparator);

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
	public java.util.List<JobOpeningStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobOpeningStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the job opening statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of job opening statuses.
	 *
	 * @return the number of job opening statuses
	 */
	public int countAll();

}