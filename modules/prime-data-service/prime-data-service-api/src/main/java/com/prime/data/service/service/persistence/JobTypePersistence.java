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

import com.prime.data.service.exception.NoSuchJobTypeException;
import com.prime.data.service.model.JobType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the job type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobTypeUtil
 * @generated
 */
@ProviderType
public interface JobTypePersistence extends BasePersistence<JobType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobTypeUtil} to access the job type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the job types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching job types
	 */
	public java.util.List<JobType> findByUuid(String uuid);

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
	public java.util.List<JobType> findByUuid(String uuid, int start, int end);

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
	public java.util.List<JobType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobType>
			orderByComparator);

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
	public java.util.List<JobType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job type
	 * @throws NoSuchJobTypeException if a matching job type could not be found
	 */
	public JobType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JobType>
				orderByComparator)
		throws NoSuchJobTypeException;

	/**
	 * Returns the first job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job type, or <code>null</code> if a matching job type could not be found
	 */
	public JobType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<JobType>
			orderByComparator);

	/**
	 * Returns the last job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job type
	 * @throws NoSuchJobTypeException if a matching job type could not be found
	 */
	public JobType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JobType>
				orderByComparator)
		throws NoSuchJobTypeException;

	/**
	 * Returns the last job type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job type, or <code>null</code> if a matching job type could not be found
	 */
	public JobType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<JobType>
			orderByComparator);

	/**
	 * Returns the job types before and after the current job type in the ordered set where uuid = &#63;.
	 *
	 * @param jobTypeId the primary key of the current job type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job type
	 * @throws NoSuchJobTypeException if a job type with the primary key could not be found
	 */
	public JobType[] findByUuid_PrevAndNext(
			long jobTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<JobType>
				orderByComparator)
		throws NoSuchJobTypeException;

	/**
	 * Removes all the job types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of job types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching job types
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the job type in the entity cache if it is enabled.
	 *
	 * @param jobType the job type
	 */
	public void cacheResult(JobType jobType);

	/**
	 * Caches the job types in the entity cache if it is enabled.
	 *
	 * @param jobTypes the job types
	 */
	public void cacheResult(java.util.List<JobType> jobTypes);

	/**
	 * Creates a new job type with the primary key. Does not add the job type to the database.
	 *
	 * @param jobTypeId the primary key for the new job type
	 * @return the new job type
	 */
	public JobType create(long jobTypeId);

	/**
	 * Removes the job type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type that was removed
	 * @throws NoSuchJobTypeException if a job type with the primary key could not be found
	 */
	public JobType remove(long jobTypeId) throws NoSuchJobTypeException;

	public JobType updateImpl(JobType jobType);

	/**
	 * Returns the job type with the primary key or throws a <code>NoSuchJobTypeException</code> if it could not be found.
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type
	 * @throws NoSuchJobTypeException if a job type with the primary key could not be found
	 */
	public JobType findByPrimaryKey(long jobTypeId)
		throws NoSuchJobTypeException;

	/**
	 * Returns the job type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type, or <code>null</code> if a job type with the primary key could not be found
	 */
	public JobType fetchByPrimaryKey(long jobTypeId);

	/**
	 * Returns all the job types.
	 *
	 * @return the job types
	 */
	public java.util.List<JobType> findAll();

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
	public java.util.List<JobType> findAll(int start, int end);

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
	public java.util.List<JobType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobType>
			orderByComparator);

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
	public java.util.List<JobType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<JobType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the job types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of job types.
	 *
	 * @return the number of job types
	 */
	public int countAll();

}