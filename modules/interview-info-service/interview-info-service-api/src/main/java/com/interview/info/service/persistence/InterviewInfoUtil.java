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

import com.interview.info.model.InterviewInfo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the interview info service. This utility wraps <code>com.interview.info.service.persistence.impl.InterviewInfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InterviewInfoPersistence
 * @generated
 */
public class InterviewInfoUtil {

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
	public static void clearCache(InterviewInfo interviewInfo) {
		getPersistence().clearCache(interviewInfo);
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
	public static Map<Serializable, InterviewInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<InterviewInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InterviewInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InterviewInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InterviewInfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InterviewInfo update(InterviewInfo interviewInfo) {
		return getPersistence().update(interviewInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InterviewInfo update(
		InterviewInfo interviewInfo, ServiceContext serviceContext) {

		return getPersistence().update(interviewInfo, serviceContext);
	}

	/**
	 * Returns all the interview infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching interview infos
	 */
	public static List<InterviewInfo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<InterviewInfo> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<InterviewInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<InterviewInfo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<InterviewInfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<InterviewInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview info
	 * @throws NoSuchInterviewInfoException if a matching interview info could not be found
	 */
	public static InterviewInfo findByUuid_First(
			String uuid, OrderByComparator<InterviewInfo> orderByComparator)
		throws com.interview.info.exception.NoSuchInterviewInfoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	public static InterviewInfo fetchByUuid_First(
		String uuid, OrderByComparator<InterviewInfo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview info
	 * @throws NoSuchInterviewInfoException if a matching interview info could not be found
	 */
	public static InterviewInfo findByUuid_Last(
			String uuid, OrderByComparator<InterviewInfo> orderByComparator)
		throws com.interview.info.exception.NoSuchInterviewInfoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last interview info in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	public static InterviewInfo fetchByUuid_Last(
		String uuid, OrderByComparator<InterviewInfo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the interview infos before and after the current interview info in the ordered set where uuid = &#63;.
	 *
	 * @param interviewId the primary key of the current interview info
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview info
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	public static InterviewInfo[] findByUuid_PrevAndNext(
			long interviewId, String uuid,
			OrderByComparator<InterviewInfo> orderByComparator)
		throws com.interview.info.exception.NoSuchInterviewInfoException {

		return getPersistence().findByUuid_PrevAndNext(
			interviewId, uuid, orderByComparator);
	}

	/**
	 * Removes all the interview infos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of interview infos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching interview infos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the interview info where attachmentId = &#63; or throws a <code>NoSuchInterviewInfoException</code> if it could not be found.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching interview info
	 * @throws NoSuchInterviewInfoException if a matching interview info could not be found
	 */
	public static InterviewInfo findByDocument(long attachmentId)
		throws com.interview.info.exception.NoSuchInterviewInfoException {

		return getPersistence().findByDocument(attachmentId);
	}

	/**
	 * Returns the interview info where attachmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @return the matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	public static InterviewInfo fetchByDocument(long attachmentId) {
		return getPersistence().fetchByDocument(attachmentId);
	}

	/**
	 * Returns the interview info where attachmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param attachmentId the attachment ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching interview info, or <code>null</code> if a matching interview info could not be found
	 */
	public static InterviewInfo fetchByDocument(
		long attachmentId, boolean useFinderCache) {

		return getPersistence().fetchByDocument(attachmentId, useFinderCache);
	}

	/**
	 * Removes the interview info where attachmentId = &#63; from the database.
	 *
	 * @param attachmentId the attachment ID
	 * @return the interview info that was removed
	 */
	public static InterviewInfo removeByDocument(long attachmentId)
		throws com.interview.info.exception.NoSuchInterviewInfoException {

		return getPersistence().removeByDocument(attachmentId);
	}

	/**
	 * Returns the number of interview infos where attachmentId = &#63;.
	 *
	 * @param attachmentId the attachment ID
	 * @return the number of matching interview infos
	 */
	public static int countByDocument(long attachmentId) {
		return getPersistence().countByDocument(attachmentId);
	}

	/**
	 * Caches the interview info in the entity cache if it is enabled.
	 *
	 * @param interviewInfo the interview info
	 */
	public static void cacheResult(InterviewInfo interviewInfo) {
		getPersistence().cacheResult(interviewInfo);
	}

	/**
	 * Caches the interview infos in the entity cache if it is enabled.
	 *
	 * @param interviewInfos the interview infos
	 */
	public static void cacheResult(List<InterviewInfo> interviewInfos) {
		getPersistence().cacheResult(interviewInfos);
	}

	/**
	 * Creates a new interview info with the primary key. Does not add the interview info to the database.
	 *
	 * @param interviewId the primary key for the new interview info
	 * @return the new interview info
	 */
	public static InterviewInfo create(long interviewId) {
		return getPersistence().create(interviewId);
	}

	/**
	 * Removes the interview info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info that was removed
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	public static InterviewInfo remove(long interviewId)
		throws com.interview.info.exception.NoSuchInterviewInfoException {

		return getPersistence().remove(interviewId);
	}

	public static InterviewInfo updateImpl(InterviewInfo interviewInfo) {
		return getPersistence().updateImpl(interviewInfo);
	}

	/**
	 * Returns the interview info with the primary key or throws a <code>NoSuchInterviewInfoException</code> if it could not be found.
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info
	 * @throws NoSuchInterviewInfoException if a interview info with the primary key could not be found
	 */
	public static InterviewInfo findByPrimaryKey(long interviewId)
		throws com.interview.info.exception.NoSuchInterviewInfoException {

		return getPersistence().findByPrimaryKey(interviewId);
	}

	/**
	 * Returns the interview info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info, or <code>null</code> if a interview info with the primary key could not be found
	 */
	public static InterviewInfo fetchByPrimaryKey(long interviewId) {
		return getPersistence().fetchByPrimaryKey(interviewId);
	}

	/**
	 * Returns all the interview infos.
	 *
	 * @return the interview infos
	 */
	public static List<InterviewInfo> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<InterviewInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<InterviewInfo> findAll(
		int start, int end,
		OrderByComparator<InterviewInfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<InterviewInfo> findAll(
		int start, int end, OrderByComparator<InterviewInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the interview infos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of interview infos.
	 *
	 * @return the number of interview infos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InterviewInfoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile InterviewInfoPersistence _persistence;

}