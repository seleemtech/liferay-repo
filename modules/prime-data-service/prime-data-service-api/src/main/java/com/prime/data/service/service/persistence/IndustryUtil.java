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

import com.prime.data.service.model.Industry;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the industry service. This utility wraps <code>com.prime.data.service.service.persistence.impl.IndustryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IndustryPersistence
 * @generated
 */
public class IndustryUtil {

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
	public static void clearCache(Industry industry) {
		getPersistence().clearCache(industry);
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
	public static Map<Serializable, Industry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Industry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Industry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Industry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Industry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Industry update(Industry industry) {
		return getPersistence().update(industry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Industry update(
		Industry industry, ServiceContext serviceContext) {

		return getPersistence().update(industry, serviceContext);
	}

	/**
	 * Returns all the industries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching industries
	 */
	public static List<Industry> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the industries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @return the range of matching industries
	 */
	public static List<Industry> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the industries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching industries
	 */
	public static List<Industry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Industry> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the industries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching industries
	 */
	public static List<Industry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Industry> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first industry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching industry
	 * @throws NoSuchIndustryException if a matching industry could not be found
	 */
	public static Industry findByUuid_First(
			String uuid, OrderByComparator<Industry> orderByComparator)
		throws com.prime.data.service.exception.NoSuchIndustryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first industry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching industry, or <code>null</code> if a matching industry could not be found
	 */
	public static Industry fetchByUuid_First(
		String uuid, OrderByComparator<Industry> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last industry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching industry
	 * @throws NoSuchIndustryException if a matching industry could not be found
	 */
	public static Industry findByUuid_Last(
			String uuid, OrderByComparator<Industry> orderByComparator)
		throws com.prime.data.service.exception.NoSuchIndustryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last industry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching industry, or <code>null</code> if a matching industry could not be found
	 */
	public static Industry fetchByUuid_Last(
		String uuid, OrderByComparator<Industry> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the industries before and after the current industry in the ordered set where uuid = &#63;.
	 *
	 * @param industryId the primary key of the current industry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next industry
	 * @throws NoSuchIndustryException if a industry with the primary key could not be found
	 */
	public static Industry[] findByUuid_PrevAndNext(
			long industryId, String uuid,
			OrderByComparator<Industry> orderByComparator)
		throws com.prime.data.service.exception.NoSuchIndustryException {

		return getPersistence().findByUuid_PrevAndNext(
			industryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the industries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of industries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching industries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the industry in the entity cache if it is enabled.
	 *
	 * @param industry the industry
	 */
	public static void cacheResult(Industry industry) {
		getPersistence().cacheResult(industry);
	}

	/**
	 * Caches the industries in the entity cache if it is enabled.
	 *
	 * @param industries the industries
	 */
	public static void cacheResult(List<Industry> industries) {
		getPersistence().cacheResult(industries);
	}

	/**
	 * Creates a new industry with the primary key. Does not add the industry to the database.
	 *
	 * @param industryId the primary key for the new industry
	 * @return the new industry
	 */
	public static Industry create(long industryId) {
		return getPersistence().create(industryId);
	}

	/**
	 * Removes the industry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry that was removed
	 * @throws NoSuchIndustryException if a industry with the primary key could not be found
	 */
	public static Industry remove(long industryId)
		throws com.prime.data.service.exception.NoSuchIndustryException {

		return getPersistence().remove(industryId);
	}

	public static Industry updateImpl(Industry industry) {
		return getPersistence().updateImpl(industry);
	}

	/**
	 * Returns the industry with the primary key or throws a <code>NoSuchIndustryException</code> if it could not be found.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry
	 * @throws NoSuchIndustryException if a industry with the primary key could not be found
	 */
	public static Industry findByPrimaryKey(long industryId)
		throws com.prime.data.service.exception.NoSuchIndustryException {

		return getPersistence().findByPrimaryKey(industryId);
	}

	/**
	 * Returns the industry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry, or <code>null</code> if a industry with the primary key could not be found
	 */
	public static Industry fetchByPrimaryKey(long industryId) {
		return getPersistence().fetchByPrimaryKey(industryId);
	}

	/**
	 * Returns all the industries.
	 *
	 * @return the industries
	 */
	public static List<Industry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @return the range of industries
	 */
	public static List<Industry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of industries
	 */
	public static List<Industry> findAll(
		int start, int end, OrderByComparator<Industry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of industries
	 */
	public static List<Industry> findAll(
		int start, int end, OrderByComparator<Industry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the industries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of industries.
	 *
	 * @return the number of industries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IndustryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile IndustryPersistence _persistence;

}