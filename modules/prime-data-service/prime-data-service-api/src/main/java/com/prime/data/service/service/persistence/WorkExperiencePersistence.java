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

import com.prime.data.service.exception.NoSuchWorkExperienceException;
import com.prime.data.service.model.WorkExperience;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkExperienceUtil
 * @generated
 */
@ProviderType
public interface WorkExperiencePersistence
	extends BasePersistence<WorkExperience> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkExperienceUtil} to access the work experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work experiences
	 */
	public java.util.List<WorkExperience> findByUuid(String uuid);

	/**
	 * Returns a range of all the work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @return the range of matching work experiences
	 */
	public java.util.List<WorkExperience> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work experiences
	 */
	public java.util.List<WorkExperience> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work experiences where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work experiences
	 */
	public java.util.List<WorkExperience> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work experience
	 * @throws NoSuchWorkExperienceException if a matching work experience could not be found
	 */
	public WorkExperience findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkExperience>
				orderByComparator)
		throws NoSuchWorkExperienceException;

	/**
	 * Returns the first work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work experience, or <code>null</code> if a matching work experience could not be found
	 */
	public WorkExperience fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkExperience>
			orderByComparator);

	/**
	 * Returns the last work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work experience
	 * @throws NoSuchWorkExperienceException if a matching work experience could not be found
	 */
	public WorkExperience findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkExperience>
				orderByComparator)
		throws NoSuchWorkExperienceException;

	/**
	 * Returns the last work experience in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work experience, or <code>null</code> if a matching work experience could not be found
	 */
	public WorkExperience fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkExperience>
			orderByComparator);

	/**
	 * Returns the work experiences before and after the current work experience in the ordered set where uuid = &#63;.
	 *
	 * @param workExpId the primary key of the current work experience
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work experience
	 * @throws NoSuchWorkExperienceException if a work experience with the primary key could not be found
	 */
	public WorkExperience[] findByUuid_PrevAndNext(
			long workExpId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkExperience>
				orderByComparator)
		throws NoSuchWorkExperienceException;

	/**
	 * Removes all the work experiences where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of work experiences where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work experiences
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the work experience in the entity cache if it is enabled.
	 *
	 * @param workExperience the work experience
	 */
	public void cacheResult(WorkExperience workExperience);

	/**
	 * Caches the work experiences in the entity cache if it is enabled.
	 *
	 * @param workExperiences the work experiences
	 */
	public void cacheResult(java.util.List<WorkExperience> workExperiences);

	/**
	 * Creates a new work experience with the primary key. Does not add the work experience to the database.
	 *
	 * @param workExpId the primary key for the new work experience
	 * @return the new work experience
	 */
	public WorkExperience create(long workExpId);

	/**
	 * Removes the work experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workExpId the primary key of the work experience
	 * @return the work experience that was removed
	 * @throws NoSuchWorkExperienceException if a work experience with the primary key could not be found
	 */
	public WorkExperience remove(long workExpId)
		throws NoSuchWorkExperienceException;

	public WorkExperience updateImpl(WorkExperience workExperience);

	/**
	 * Returns the work experience with the primary key or throws a <code>NoSuchWorkExperienceException</code> if it could not be found.
	 *
	 * @param workExpId the primary key of the work experience
	 * @return the work experience
	 * @throws NoSuchWorkExperienceException if a work experience with the primary key could not be found
	 */
	public WorkExperience findByPrimaryKey(long workExpId)
		throws NoSuchWorkExperienceException;

	/**
	 * Returns the work experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workExpId the primary key of the work experience
	 * @return the work experience, or <code>null</code> if a work experience with the primary key could not be found
	 */
	public WorkExperience fetchByPrimaryKey(long workExpId);

	/**
	 * Returns all the work experiences.
	 *
	 * @return the work experiences
	 */
	public java.util.List<WorkExperience> findAll();

	/**
	 * Returns a range of all the work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @return the range of work experiences
	 */
	public java.util.List<WorkExperience> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work experiences
	 */
	public java.util.List<WorkExperience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkExperience>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work experiences
	 */
	public java.util.List<WorkExperience> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkExperience>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work experiences from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work experiences.
	 *
	 * @return the number of work experiences
	 */
	public int countAll();

}