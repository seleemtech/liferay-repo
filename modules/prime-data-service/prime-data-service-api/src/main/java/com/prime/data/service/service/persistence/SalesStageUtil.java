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

import com.prime.data.service.model.SalesStage;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the sales stage service. This utility wraps <code>com.prime.data.service.service.persistence.impl.SalesStagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalesStagePersistence
 * @generated
 */
public class SalesStageUtil {

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
	public static void clearCache(SalesStage salesStage) {
		getPersistence().clearCache(salesStage);
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
	public static Map<Serializable, SalesStage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SalesStage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SalesStage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SalesStage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SalesStage> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SalesStage update(SalesStage salesStage) {
		return getPersistence().update(salesStage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SalesStage update(
		SalesStage salesStage, ServiceContext serviceContext) {

		return getPersistence().update(salesStage, serviceContext);
	}

	/**
	 * Returns all the sales stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sales stages
	 */
	public static List<SalesStage> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the sales stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @return the range of matching sales stages
	 */
	public static List<SalesStage> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the sales stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sales stages
	 */
	public static List<SalesStage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesStage> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sales stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching sales stages
	 */
	public static List<SalesStage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SalesStage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales stage
	 * @throws NoSuchSalesStageException if a matching sales stage could not be found
	 */
	public static SalesStage findByUuid_First(
			String uuid, OrderByComparator<SalesStage> orderByComparator)
		throws com.prime.data.service.exception.NoSuchSalesStageException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sales stage, or <code>null</code> if a matching sales stage could not be found
	 */
	public static SalesStage fetchByUuid_First(
		String uuid, OrderByComparator<SalesStage> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales stage
	 * @throws NoSuchSalesStageException if a matching sales stage could not be found
	 */
	public static SalesStage findByUuid_Last(
			String uuid, OrderByComparator<SalesStage> orderByComparator)
		throws com.prime.data.service.exception.NoSuchSalesStageException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sales stage, or <code>null</code> if a matching sales stage could not be found
	 */
	public static SalesStage fetchByUuid_Last(
		String uuid, OrderByComparator<SalesStage> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the sales stages before and after the current sales stage in the ordered set where uuid = &#63;.
	 *
	 * @param salesStageId the primary key of the current sales stage
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sales stage
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	public static SalesStage[] findByUuid_PrevAndNext(
			long salesStageId, String uuid,
			OrderByComparator<SalesStage> orderByComparator)
		throws com.prime.data.service.exception.NoSuchSalesStageException {

		return getPersistence().findByUuid_PrevAndNext(
			salesStageId, uuid, orderByComparator);
	}

	/**
	 * Removes all the sales stages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of sales stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sales stages
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the sales stage in the entity cache if it is enabled.
	 *
	 * @param salesStage the sales stage
	 */
	public static void cacheResult(SalesStage salesStage) {
		getPersistence().cacheResult(salesStage);
	}

	/**
	 * Caches the sales stages in the entity cache if it is enabled.
	 *
	 * @param salesStages the sales stages
	 */
	public static void cacheResult(List<SalesStage> salesStages) {
		getPersistence().cacheResult(salesStages);
	}

	/**
	 * Creates a new sales stage with the primary key. Does not add the sales stage to the database.
	 *
	 * @param salesStageId the primary key for the new sales stage
	 * @return the new sales stage
	 */
	public static SalesStage create(long salesStageId) {
		return getPersistence().create(salesStageId);
	}

	/**
	 * Removes the sales stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage that was removed
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	public static SalesStage remove(long salesStageId)
		throws com.prime.data.service.exception.NoSuchSalesStageException {

		return getPersistence().remove(salesStageId);
	}

	public static SalesStage updateImpl(SalesStage salesStage) {
		return getPersistence().updateImpl(salesStage);
	}

	/**
	 * Returns the sales stage with the primary key or throws a <code>NoSuchSalesStageException</code> if it could not be found.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage
	 * @throws NoSuchSalesStageException if a sales stage with the primary key could not be found
	 */
	public static SalesStage findByPrimaryKey(long salesStageId)
		throws com.prime.data.service.exception.NoSuchSalesStageException {

		return getPersistence().findByPrimaryKey(salesStageId);
	}

	/**
	 * Returns the sales stage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage, or <code>null</code> if a sales stage with the primary key could not be found
	 */
	public static SalesStage fetchByPrimaryKey(long salesStageId) {
		return getPersistence().fetchByPrimaryKey(salesStageId);
	}

	/**
	 * Returns all the sales stages.
	 *
	 * @return the sales stages
	 */
	public static List<SalesStage> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @return the range of sales stages
	 */
	public static List<SalesStage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sales stages
	 */
	public static List<SalesStage> findAll(
		int start, int end, OrderByComparator<SalesStage> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of sales stages
	 */
	public static List<SalesStage> findAll(
		int start, int end, OrderByComparator<SalesStage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the sales stages from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of sales stages.
	 *
	 * @return the number of sales stages
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SalesStagePersistence getPersistence() {
		return _persistence;
	}

	private static volatile SalesStagePersistence _persistence;

}