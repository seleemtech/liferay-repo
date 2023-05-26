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

package com.interview.info.service.persistence;

import com.interview.info.exception.NoSuchInterviewInfoException;
import com.interview.info.model.InterviewInfo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the interview info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InterviewInfoUtil
 * @generated
 */
@ProviderType
public interface InterviewInfoPersistence
	extends BasePersistence<InterviewInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InterviewInfoUtil} to access the interview info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the interview infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching interview infos
	 */
	public java.util.List<InterviewInfo> findByUuid(String uuid);

	/**
	 * Returns a range of all the interview infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @return the range of matching interview infos
	 */
	public java.util.List<InterviewInfo> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the interview infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interview infos
	 */
	public java.util.List<InterviewInfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewInfo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the interview infos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching interview infos
	 */
	public java.util.List<InterviewInfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview info
	 * @throws NoSuchInterviewInfoException if a matching interview info could not be found
	 */
	public InterviewInfo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<InterviewInfo>
				orderByComparator)
		throws NoSuchInterviewInfoException;

	/**
	 * Returns the first interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	public InterviewInfo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewInfo>
			orderByComparator);

	/**
	 * Returns the last interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview info
	 * @throws NoSuchInterviewInfoException if a matching interview info could not be found
	 */
	public InterviewInfo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<InterviewInfo>
				orderByComparator)
		throws NoSuchInterviewInfoException;

	/**
	 * Returns the last interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	public InterviewInfo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewInfo>
			orderByComparator);

	/**
	 * Returns the interview infos before and after the current interview info in the ordered set where uuid = &#63;.
	 *
	 * @param interviewId the primary key of the current interview info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview info
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	public InterviewInfo[] findByUuid_PrevAndNext(
			long interviewId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<InterviewInfo>
				orderByComparator)
		throws NoSuchInterviewInfoException;

	/**
	 * Removes all the interview infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of interview infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching interview infos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the interview info where attachmentId = &#63; or throws a <code>NoSuchInterviewInfoException</code> if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching interview info
	 * @throws NoSuchInterviewInfoException if a matching interview info could not be found
	 */
	public InterviewInfo findByDocument(long attachmentId)
		throws NoSuchInterviewInfoException;

	/**
	 * Returns the interview info where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	public InterviewInfo fetchByDocument(long attachmentId);

	/**
	 * Returns the interview info where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	public InterviewInfo fetchByDocument(
		long attachmentId, boolean useFinderCache);

	/**
	 * Removes the interview info where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @return the interview info that was removed
	 */
	public InterviewInfo removeByDocument(long attachmentId)
		throws NoSuchInterviewInfoException;

	/**
	 * Returns the number of interview infos where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching interview infos
	 */
	public int countByDocument(long attachmentId);

	/**
	 * Caches the interview info in the entity cache if it is enabled.
	 *
	 * @param interviewInfo the interview info
	 */
	public void cacheResult(InterviewInfo interviewInfo);

	/**
	 * Caches the interview infos in the entity cache if it is enabled.
	 *
	 * @param interviewInfos the interview infos
	 */
	public void cacheResult(java.util.List<InterviewInfo> interviewInfos);

	/**
	 * Creates a new interview info with the primary key. Does not add the interview info to the database.
	 *
	 * @param interviewId the primary key for the new interview info
	 * @return the new interview info
	 */
	public InterviewInfo create(long interviewId);

	/**
	 * Removes the interview info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info that was removed
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	public InterviewInfo remove(long interviewId)
		throws NoSuchInterviewInfoException;

	public InterviewInfo updateImpl(InterviewInfo interviewInfo);

	/**
	 * Returns the interview info with the primary key or throws a <code>NoSuchInterviewInfoException</code> if it could not be found.
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	public InterviewInfo findByPrimaryKey(long interviewId)
		throws NoSuchInterviewInfoException;

	/**
	 * Returns the interview info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info, or <code>null</code> if a interview info with the primary key could not be found
	 */
	public InterviewInfo fetchByPrimaryKey(long interviewId);

	/**
	 * Returns all the interview infos.
	 *
	 * @return the interview infos
	 */
	public java.util.List<InterviewInfo> findAll();

	/**
	 * Returns a range of all the interview infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @return the range of interview infos
	 */
	public java.util.List<InterviewInfo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the interview infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interview infos
	 */
	public java.util.List<InterviewInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewInfo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the interview infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of interview infos
	 */
	public java.util.List<InterviewInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<InterviewInfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the interview infos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of interview infos.
	 *
	 * @return the number of interview infos
	 */
	public int countAll();

}