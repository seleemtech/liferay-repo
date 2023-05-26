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

import com.prime.data.service.exception.NoSuchInterviewNameException;
import com.prime.data.service.model.InterviewName;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the interview name service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InterviewNameUtil
 * @generated
 */
@ProviderType
public interface InterviewNamePersistence
	extends BasePersistence<InterviewName> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InterviewNameUtil} to access the interview name persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the interview names where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching interview names
	 */
	public java.util.List<InterviewName> findByUuid(String uuid);

	/**
	 * Returns a range of all the interview names where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewNameModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interview names
	 * @param end the upper bound of the range of interview names (not inclusive)
	 * @return the range of matching interview names
	 */
	public java.util.List<InterviewName> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the interview names where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewNameModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interview names
	 * @param end the upper bound of the range of interview names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interview names
	 */
	public java.util.List<InterviewName> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewName>
			orderByComparator);

	/**
	 * Returns an ordered range of all the interview names where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewNameModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interview names
	 * @param end the upper bound of the range of interview names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching interview names
	 */
	public java.util.List<InterviewName> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewName>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first interview name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview name
	 * @throws NoSuchInterviewNameException if a matching interview name could not be found
	 */
	public InterviewName findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<InterviewName>
				orderByComparator)
		throws NoSuchInterviewNameException;

	/**
	 * Returns the first interview name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview name, or <code>null</code> if a matching interview name could not be found
	 */
	public InterviewName fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewName>
			orderByComparator);

	/**
	 * Returns the last interview name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview name
	 * @throws NoSuchInterviewNameException if a matching interview name could not be found
	 */
	public InterviewName findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<InterviewName>
				orderByComparator)
		throws NoSuchInterviewNameException;

	/**
	 * Returns the last interview name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview name, or <code>null</code> if a matching interview name could not be found
	 */
	public InterviewName fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewName>
			orderByComparator);

	/**
	 * Returns the interview names before and after the current interview name in the ordered set where uuid = &#63;.
	 *
	 * @param interviewNameId the primary key of the current interview name
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview name
	 * @throws NoSuchInterviewNameException if a interview name with the primary key could not be found
	 */
	public InterviewName[] findByUuid_PrevAndNext(
			long interviewNameId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<InterviewName>
				orderByComparator)
		throws NoSuchInterviewNameException;

	/**
	 * Removes all the interview names where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of interview names where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching interview names
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the interview name in the entity cache if it is enabled.
	 *
	 * @param interviewName the interview name
	 */
	public void cacheResult(InterviewName interviewName);

	/**
	 * Caches the interview names in the entity cache if it is enabled.
	 *
	 * @param interviewNames the interview names
	 */
	public void cacheResult(java.util.List<InterviewName> interviewNames);

	/**
	 * Creates a new interview name with the primary key. Does not add the interview name to the database.
	 *
	 * @param interviewNameId the primary key for the new interview name
	 * @return the new interview name
	 */
	public InterviewName create(long interviewNameId);

	/**
	 * Removes the interview name with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interviewNameId the primary key of the interview name
	 * @return the interview name that was removed
	 * @throws NoSuchInterviewNameException if a interview name with the primary key could not be found
	 */
	public InterviewName remove(long interviewNameId)
		throws NoSuchInterviewNameException;

	public InterviewName updateImpl(InterviewName interviewName);

	/**
	 * Returns the interview name with the primary key or throws a <code>NoSuchInterviewNameException</code> if it could not be found.
	 *
	 * @param interviewNameId the primary key of the interview name
	 * @return the interview name
	 * @throws NoSuchInterviewNameException if a interview name with the primary key could not be found
	 */
	public InterviewName findByPrimaryKey(long interviewNameId)
		throws NoSuchInterviewNameException;

	/**
	 * Returns the interview name with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interviewNameId the primary key of the interview name
	 * @return the interview name, or <code>null</code> if a interview name with the primary key could not be found
	 */
	public InterviewName fetchByPrimaryKey(long interviewNameId);

	/**
	 * Returns all the interview names.
	 *
	 * @return the interview names
	 */
	public java.util.List<InterviewName> findAll();

	/**
	 * Returns a range of all the interview names.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewNameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview names
	 * @param end the upper bound of the range of interview names (not inclusive)
	 * @return the range of interview names
	 */
	public java.util.List<InterviewName> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the interview names.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewNameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview names
	 * @param end the upper bound of the range of interview names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interview names
	 */
	public java.util.List<InterviewName> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewName>
			orderByComparator);

	/**
	 * Returns an ordered range of all the interview names.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewNameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview names
	 * @param end the upper bound of the range of interview names (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of interview names
	 */
	public java.util.List<InterviewName> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewName>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the interview names from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of interview names.
	 *
	 * @return the number of interview names
	 */
	public int countAll();

}