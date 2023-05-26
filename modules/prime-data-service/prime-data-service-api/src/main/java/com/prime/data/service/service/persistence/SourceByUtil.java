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

import com.prime.data.service.model.SourceBy;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the source by service. This utility wraps <code>com.prime.data.service.service.persistence.impl.SourceByPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SourceByPersistence
 * @generated
 */
public class SourceByUtil {

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
	public static void clearCache(SourceBy sourceBy) {
		getPersistence().clearCache(sourceBy);
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
	public static Map<Serializable, SourceBy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SourceBy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SourceBy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SourceBy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SourceBy> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SourceBy update(SourceBy sourceBy) {
		return getPersistence().update(sourceBy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SourceBy update(
		SourceBy sourceBy, ServiceContext serviceContext) {

		return getPersistence().update(sourceBy, serviceContext);
	}

	/**
	 * Returns all the source bies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching source bies
	 */
	public static List<SourceBy> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the source bies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @return the range of matching source bies
	 */
	public static List<SourceBy> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the source bies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching source bies
	 */
	public static List<SourceBy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SourceBy> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the source bies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching source bies
	 */
	public static List<SourceBy> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SourceBy> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first source by in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching source by
	 * @throws NoSuchSourceByException if a matching source by could not be found
	 */
	public static SourceBy findByUuid_First(
			String uuid, OrderByComparator<SourceBy> orderByComparator)
		throws com.prime.data.service.exception.NoSuchSourceByException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first source by in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching source by, or <code>null</code> if a matching source by could not be found
	 */
	public static SourceBy fetchByUuid_First(
		String uuid, OrderByComparator<SourceBy> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last source by in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching source by
	 * @throws NoSuchSourceByException if a matching source by could not be found
	 */
	public static SourceBy findByUuid_Last(
			String uuid, OrderByComparator<SourceBy> orderByComparator)
		throws com.prime.data.service.exception.NoSuchSourceByException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last source by in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching source by, or <code>null</code> if a matching source by could not be found
	 */
	public static SourceBy fetchByUuid_Last(
		String uuid, OrderByComparator<SourceBy> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the source bies before and after the current source by in the ordered set where uuid = &#63;.
	 *
	 * @param sourceId the primary key of the current source by
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next source by
	 * @throws NoSuchSourceByException if a source by with the primary key could not be found
	 */
	public static SourceBy[] findByUuid_PrevAndNext(
			long sourceId, String uuid,
			OrderByComparator<SourceBy> orderByComparator)
		throws com.prime.data.service.exception.NoSuchSourceByException {

		return getPersistence().findByUuid_PrevAndNext(
			sourceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the source bies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of source bies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching source bies
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the source by in the entity cache if it is enabled.
	 *
	 * @param sourceBy the source by
	 */
	public static void cacheResult(SourceBy sourceBy) {
		getPersistence().cacheResult(sourceBy);
	}

	/**
	 * Caches the source bies in the entity cache if it is enabled.
	 *
	 * @param sourceBies the source bies
	 */
	public static void cacheResult(List<SourceBy> sourceBies) {
		getPersistence().cacheResult(sourceBies);
	}

	/**
	 * Creates a new source by with the primary key. Does not add the source by to the database.
	 *
	 * @param sourceId the primary key for the new source by
	 * @return the new source by
	 */
	public static SourceBy create(long sourceId) {
		return getPersistence().create(sourceId);
	}

	/**
	 * Removes the source by with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sourceId the primary key of the source by
	 * @return the source by that was removed
	 * @throws NoSuchSourceByException if a source by with the primary key could not be found
	 */
	public static SourceBy remove(long sourceId)
		throws com.prime.data.service.exception.NoSuchSourceByException {

		return getPersistence().remove(sourceId);
	}

	public static SourceBy updateImpl(SourceBy sourceBy) {
		return getPersistence().updateImpl(sourceBy);
	}

	/**
	 * Returns the source by with the primary key or throws a <code>NoSuchSourceByException</code> if it could not be found.
	 *
	 * @param sourceId the primary key of the source by
	 * @return the source by
	 * @throws NoSuchSourceByException if a source by with the primary key could not be found
	 */
	public static SourceBy findByPrimaryKey(long sourceId)
		throws com.prime.data.service.exception.NoSuchSourceByException {

		return getPersistence().findByPrimaryKey(sourceId);
	}

	/**
	 * Returns the source by with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sourceId the primary key of the source by
	 * @return the source by, or <code>null</code> if a source by with the primary key could not be found
	 */
	public static SourceBy fetchByPrimaryKey(long sourceId) {
		return getPersistence().fetchByPrimaryKey(sourceId);
	}

	/**
	 * Returns all the source bies.
	 *
	 * @return the source bies
	 */
	public static List<SourceBy> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the source bies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @return the range of source bies
	 */
	public static List<SourceBy> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the source bies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of source bies
	 */
	public static List<SourceBy> findAll(
		int start, int end, OrderByComparator<SourceBy> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the source bies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of source bies
	 */
	public static List<SourceBy> findAll(
		int start, int end, OrderByComparator<SourceBy> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the source bies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of source bies.
	 *
	 * @return the number of source bies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SourceByPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SourceByPersistence _persistence;

}