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

import com.prime.data.service.model.WorkType;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the work type service. This utility wraps <code>com.prime.data.service.service.persistence.impl.WorkTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkTypePersistence
 * @generated
 */
public class WorkTypeUtil {

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
	public static void clearCache(WorkType workType) {
		getPersistence().clearCache(workType);
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
	public static Map<Serializable, WorkType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<WorkType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static WorkType update(WorkType workType) {
		return getPersistence().update(workType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static WorkType update(
		WorkType workType, ServiceContext serviceContext) {

		return getPersistence().update(workType, serviceContext);
	}

	/**
	 * Returns all the work types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work types
	 */
	public static List<WorkType> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the work types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @return the range of matching work types
	 */
	public static List<WorkType> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the work types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work types
	 */
	public static List<WorkType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkType> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work types
	 */
	public static List<WorkType> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<WorkType> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work type
	 * @throws NoSuchWorkTypeException if a matching work type could not be found
	 */
	public static WorkType findByUuid_First(
			String uuid, OrderByComparator<WorkType> orderByComparator)
		throws com.prime.data.service.exception.NoSuchWorkTypeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work type, or <code>null</code> if a matching work type could not be found
	 */
	public static WorkType fetchByUuid_First(
		String uuid, OrderByComparator<WorkType> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work type
	 * @throws NoSuchWorkTypeException if a matching work type could not be found
	 */
	public static WorkType findByUuid_Last(
			String uuid, OrderByComparator<WorkType> orderByComparator)
		throws com.prime.data.service.exception.NoSuchWorkTypeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work type, or <code>null</code> if a matching work type could not be found
	 */
	public static WorkType fetchByUuid_Last(
		String uuid, OrderByComparator<WorkType> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the work types before and after the current work type in the ordered set where uuid = &#63;.
	 *
	 * @param workTypeId the primary key of the current work type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work type
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	public static WorkType[] findByUuid_PrevAndNext(
			long workTypeId, String uuid,
			OrderByComparator<WorkType> orderByComparator)
		throws com.prime.data.service.exception.NoSuchWorkTypeException {

		return getPersistence().findByUuid_PrevAndNext(
			workTypeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the work types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of work types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work types
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the work type in the entity cache if it is enabled.
	 *
	 * @param workType the work type
	 */
	public static void cacheResult(WorkType workType) {
		getPersistence().cacheResult(workType);
	}

	/**
	 * Caches the work types in the entity cache if it is enabled.
	 *
	 * @param workTypes the work types
	 */
	public static void cacheResult(List<WorkType> workTypes) {
		getPersistence().cacheResult(workTypes);
	}

	/**
	 * Creates a new work type with the primary key. Does not add the work type to the database.
	 *
	 * @param workTypeId the primary key for the new work type
	 * @return the new work type
	 */
	public static WorkType create(long workTypeId) {
		return getPersistence().create(workTypeId);
	}

	/**
	 * Removes the work type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type that was removed
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	public static WorkType remove(long workTypeId)
		throws com.prime.data.service.exception.NoSuchWorkTypeException {

		return getPersistence().remove(workTypeId);
	}

	public static WorkType updateImpl(WorkType workType) {
		return getPersistence().updateImpl(workType);
	}

	/**
	 * Returns the work type with the primary key or throws a <code>NoSuchWorkTypeException</code> if it could not be found.
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	public static WorkType findByPrimaryKey(long workTypeId)
		throws com.prime.data.service.exception.NoSuchWorkTypeException {

		return getPersistence().findByPrimaryKey(workTypeId);
	}

	/**
	 * Returns the work type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type, or <code>null</code> if a work type with the primary key could not be found
	 */
	public static WorkType fetchByPrimaryKey(long workTypeId) {
		return getPersistence().fetchByPrimaryKey(workTypeId);
	}

	/**
	 * Returns all the work types.
	 *
	 * @return the work types
	 */
	public static List<WorkType> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the work types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @return the range of work types
	 */
	public static List<WorkType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the work types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work types
	 */
	public static List<WorkType> findAll(
		int start, int end, OrderByComparator<WorkType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the work types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work types
	 */
	public static List<WorkType> findAll(
		int start, int end, OrderByComparator<WorkType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the work types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of work types.
	 *
	 * @return the number of work types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static WorkTypePersistence getPersistence() {
		return _persistence;
	}

	private static volatile WorkTypePersistence _persistence;

}