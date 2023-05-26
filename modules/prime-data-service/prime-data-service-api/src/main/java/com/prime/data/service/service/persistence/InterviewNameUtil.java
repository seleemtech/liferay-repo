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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.prime.data.service.model.InterviewName;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the interview name service. This utility wraps <code>com.prime.data.service.service.persistence.impl.InterviewNamePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InterviewNamePersistence
 * @generated
 */
public class InterviewNameUtil {

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
	public static void clearCache(InterviewName interviewName) {
		getPersistence().clearCache(interviewName);
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
	public static Map<Serializable, InterviewName> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<InterviewName> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InterviewName> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InterviewName> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InterviewName> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InterviewName update(InterviewName interviewName) {
		return getPersistence().update(interviewName);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InterviewName update(
		InterviewName interviewName, ServiceContext serviceContext) {

		return getPersistence().update(interviewName, serviceContext);
	}

	/**
	 * Returns all the interview names where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching interview names
	 */
	public static List<InterviewName> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<InterviewName> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<InterviewName> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<InterviewName> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<InterviewName> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<InterviewName> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first interview name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview name
	 * @throws NoSuchInterviewNameException if a matching interview name could not be found
	 */
	public static InterviewName findByUuid_First(
			String uuid, OrderByComparator<InterviewName> orderByComparator)
		throws com.prime.data.service.exception.NoSuchInterviewNameException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first interview name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview name, or <code>null</code> if a matching interview name could not be found
	 */
	public static InterviewName fetchByUuid_First(
		String uuid, OrderByComparator<InterviewName> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last interview name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview name
	 * @throws NoSuchInterviewNameException if a matching interview name could not be found
	 */
	public static InterviewName findByUuid_Last(
			String uuid, OrderByComparator<InterviewName> orderByComparator)
		throws com.prime.data.service.exception.NoSuchInterviewNameException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last interview name in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview name, or <code>null</code> if a matching interview name could not be found
	 */
	public static InterviewName fetchByUuid_Last(
		String uuid, OrderByComparator<InterviewName> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the interview names before and after the current interview name in the ordered set where uuid = &#63;.
	 *
	 * @param interviewNameId the primary key of the current interview name
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview name
	 * @throws NoSuchInterviewNameException if a interview name with the primary key could not be found
	 */
	public static InterviewName[] findByUuid_PrevAndNext(
			long interviewNameId, String uuid,
			OrderByComparator<InterviewName> orderByComparator)
		throws com.prime.data.service.exception.NoSuchInterviewNameException {

		return getPersistence().findByUuid_PrevAndNext(
			interviewNameId, uuid, orderByComparator);
	}

	/**
	 * Removes all the interview names where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of interview names where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching interview names
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the interview name in the entity cache if it is enabled.
	 *
	 * @param interviewName the interview name
	 */
	public static void cacheResult(InterviewName interviewName) {
		getPersistence().cacheResult(interviewName);
	}

	/**
	 * Caches the interview names in the entity cache if it is enabled.
	 *
	 * @param interviewNames the interview names
	 */
	public static void cacheResult(List<InterviewName> interviewNames) {
		getPersistence().cacheResult(interviewNames);
	}

	/**
	 * Creates a new interview name with the primary key. Does not add the interview name to the database.
	 *
	 * @param interviewNameId the primary key for the new interview name
	 * @return the new interview name
	 */
	public static InterviewName create(long interviewNameId) {
		return getPersistence().create(interviewNameId);
	}

	/**
	 * Removes the interview name with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interviewNameId the primary key of the interview name
	 * @return the interview name that was removed
	 * @throws NoSuchInterviewNameException if a interview name with the primary key could not be found
	 */
	public static InterviewName remove(long interviewNameId)
		throws com.prime.data.service.exception.NoSuchInterviewNameException {

		return getPersistence().remove(interviewNameId);
	}

	public static InterviewName updateImpl(InterviewName interviewName) {
		return getPersistence().updateImpl(interviewName);
	}

	/**
	 * Returns the interview name with the primary key or throws a <code>NoSuchInterviewNameException</code> if it could not be found.
	 *
	 * @param interviewNameId the primary key of the interview name
	 * @return the interview name
	 * @throws NoSuchInterviewNameException if a interview name with the primary key could not be found
	 */
	public static InterviewName findByPrimaryKey(long interviewNameId)
		throws com.prime.data.service.exception.NoSuchInterviewNameException {

		return getPersistence().findByPrimaryKey(interviewNameId);
	}

	/**
	 * Returns the interview name with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interviewNameId the primary key of the interview name
	 * @return the interview name, or <code>null</code> if a interview name with the primary key could not be found
	 */
	public static InterviewName fetchByPrimaryKey(long interviewNameId) {
		return getPersistence().fetchByPrimaryKey(interviewNameId);
	}

	/**
	 * Returns all the interview names.
	 *
	 * @return the interview names
	 */
	public static List<InterviewName> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<InterviewName> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<InterviewName> findAll(
		int start, int end,
		OrderByComparator<InterviewName> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<InterviewName> findAll(
		int start, int end, OrderByComparator<InterviewName> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the interview names from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of interview names.
	 *
	 * @return the number of interview names
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InterviewNamePersistence getPersistence() {
		return _persistence;
	}

	private static volatile InterviewNamePersistence _persistence;

}