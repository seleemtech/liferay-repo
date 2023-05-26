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

package com.crud.service.service.persistence;

import com.crud.service.model.Crud;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the crud service. This utility wraps <code>com.crud.service.service.persistence.impl.CrudPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CrudPersistence
 * @generated
 */
public class CrudUtil {

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
	public static void clearCache(Crud crud) {
		getPersistence().clearCache(crud);
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
	public static Map<Serializable, Crud> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Crud> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Crud> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Crud> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Crud> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Crud update(Crud crud) {
		return getPersistence().update(crud);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Crud update(Crud crud, ServiceContext serviceContext) {
		return getPersistence().update(crud, serviceContext);
	}

	/**
	 * Returns all the cruds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cruds
	 */
	public static List<Crud> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cruds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of matching cruds
	 */
	public static List<Crud> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cruds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cruds
	 */
	public static List<Crud> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Crud> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cruds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cruds
	 */
	public static List<Crud> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Crud> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public static Crud findByUuid_First(
			String uuid, OrderByComparator<Crud> orderByComparator)
		throws com.crud.service.exception.NoSuchCrudException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public static Crud fetchByUuid_First(
		String uuid, OrderByComparator<Crud> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public static Crud findByUuid_Last(
			String uuid, OrderByComparator<Crud> orderByComparator)
		throws com.crud.service.exception.NoSuchCrudException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last crud in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public static Crud fetchByUuid_Last(
		String uuid, OrderByComparator<Crud> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cruds before and after the current crud in the ordered set where uuid = &#63;.
	 *
	 * @param crudId the primary key of the current crud
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crud
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	public static Crud[] findByUuid_PrevAndNext(
			long crudId, String uuid, OrderByComparator<Crud> orderByComparator)
		throws com.crud.service.exception.NoSuchCrudException {

		return getPersistence().findByUuid_PrevAndNext(
			crudId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cruds where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cruds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cruds
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the cruds where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @return the matching cruds
	 */
	public static List<Crud> findByCrudName(String crudName) {
		return getPersistence().findByCrudName(crudName);
	}

	/**
	 * Returns a range of all the cruds where crudName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudName the crud name
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of matching cruds
	 */
	public static List<Crud> findByCrudName(
		String crudName, int start, int end) {

		return getPersistence().findByCrudName(crudName, start, end);
	}

	/**
	 * Returns an ordered range of all the cruds where crudName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudName the crud name
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cruds
	 */
	public static List<Crud> findByCrudName(
		String crudName, int start, int end,
		OrderByComparator<Crud> orderByComparator) {

		return getPersistence().findByCrudName(
			crudName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cruds where crudName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudName the crud name
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cruds
	 */
	public static List<Crud> findByCrudName(
		String crudName, int start, int end,
		OrderByComparator<Crud> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCrudName(
			crudName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public static Crud findByCrudName_First(
			String crudName, OrderByComparator<Crud> orderByComparator)
		throws com.crud.service.exception.NoSuchCrudException {

		return getPersistence().findByCrudName_First(
			crudName, orderByComparator);
	}

	/**
	 * Returns the first crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public static Crud fetchByCrudName_First(
		String crudName, OrderByComparator<Crud> orderByComparator) {

		return getPersistence().fetchByCrudName_First(
			crudName, orderByComparator);
	}

	/**
	 * Returns the last crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public static Crud findByCrudName_Last(
			String crudName, OrderByComparator<Crud> orderByComparator)
		throws com.crud.service.exception.NoSuchCrudException {

		return getPersistence().findByCrudName_Last(
			crudName, orderByComparator);
	}

	/**
	 * Returns the last crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public static Crud fetchByCrudName_Last(
		String crudName, OrderByComparator<Crud> orderByComparator) {

		return getPersistence().fetchByCrudName_Last(
			crudName, orderByComparator);
	}

	/**
	 * Returns the cruds before and after the current crud in the ordered set where crudName = &#63;.
	 *
	 * @param crudId the primary key of the current crud
	 * @param crudName the crud name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next crud
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	public static Crud[] findByCrudName_PrevAndNext(
			long crudId, String crudName,
			OrderByComparator<Crud> orderByComparator)
		throws com.crud.service.exception.NoSuchCrudException {

		return getPersistence().findByCrudName_PrevAndNext(
			crudId, crudName, orderByComparator);
	}

	/**
	 * Removes all the cruds where crudName = &#63; from the database.
	 *
	 * @param crudName the crud name
	 */
	public static void removeByCrudName(String crudName) {
		getPersistence().removeByCrudName(crudName);
	}

	/**
	 * Returns the number of cruds where crudName = &#63;.
	 *
	 * @param crudName the crud name
	 * @return the number of matching cruds
	 */
	public static int countByCrudName(String crudName) {
		return getPersistence().countByCrudName(crudName);
	}

	/**
	 * Returns all the cruds where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @return the matching cruds
	 */
	public static List<Crud> findByCrudId(long crudId) {
		return getPersistence().findByCrudId(crudId);
	}

	/**
	 * Returns a range of all the cruds where crudId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudId the crud ID
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of matching cruds
	 */
	public static List<Crud> findByCrudId(long crudId, int start, int end) {
		return getPersistence().findByCrudId(crudId, start, end);
	}

	/**
	 * Returns an ordered range of all the cruds where crudId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudId the crud ID
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cruds
	 */
	public static List<Crud> findByCrudId(
		long crudId, int start, int end,
		OrderByComparator<Crud> orderByComparator) {

		return getPersistence().findByCrudId(
			crudId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cruds where crudId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param crudId the crud ID
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cruds
	 */
	public static List<Crud> findByCrudId(
		long crudId, int start, int end,
		OrderByComparator<Crud> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCrudId(
			crudId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public static Crud findByCrudId_First(
			long crudId, OrderByComparator<Crud> orderByComparator)
		throws com.crud.service.exception.NoSuchCrudException {

		return getPersistence().findByCrudId_First(crudId, orderByComparator);
	}

	/**
	 * Returns the first crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public static Crud fetchByCrudId_First(
		long crudId, OrderByComparator<Crud> orderByComparator) {

		return getPersistence().fetchByCrudId_First(crudId, orderByComparator);
	}

	/**
	 * Returns the last crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud
	 * @throws NoSuchCrudException if a matching crud could not be found
	 */
	public static Crud findByCrudId_Last(
			long crudId, OrderByComparator<Crud> orderByComparator)
		throws com.crud.service.exception.NoSuchCrudException {

		return getPersistence().findByCrudId_Last(crudId, orderByComparator);
	}

	/**
	 * Returns the last crud in the ordered set where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching crud, or <code>null</code> if a matching crud could not be found
	 */
	public static Crud fetchByCrudId_Last(
		long crudId, OrderByComparator<Crud> orderByComparator) {

		return getPersistence().fetchByCrudId_Last(crudId, orderByComparator);
	}

	/**
	 * Removes all the cruds where crudId = &#63; from the database.
	 *
	 * @param crudId the crud ID
	 */
	public static void removeByCrudId(long crudId) {
		getPersistence().removeByCrudId(crudId);
	}

	/**
	 * Returns the number of cruds where crudId = &#63;.
	 *
	 * @param crudId the crud ID
	 * @return the number of matching cruds
	 */
	public static int countByCrudId(long crudId) {
		return getPersistence().countByCrudId(crudId);
	}

	/**
	 * Caches the crud in the entity cache if it is enabled.
	 *
	 * @param crud the crud
	 */
	public static void cacheResult(Crud crud) {
		getPersistence().cacheResult(crud);
	}

	/**
	 * Caches the cruds in the entity cache if it is enabled.
	 *
	 * @param cruds the cruds
	 */
	public static void cacheResult(List<Crud> cruds) {
		getPersistence().cacheResult(cruds);
	}

	/**
	 * Creates a new crud with the primary key. Does not add the crud to the database.
	 *
	 * @param crudId the primary key for the new crud
	 * @return the new crud
	 */
	public static Crud create(long crudId) {
		return getPersistence().create(crudId);
	}

	/**
	 * Removes the crud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud that was removed
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	public static Crud remove(long crudId)
		throws com.crud.service.exception.NoSuchCrudException {

		return getPersistence().remove(crudId);
	}

	public static Crud updateImpl(Crud crud) {
		return getPersistence().updateImpl(crud);
	}

	/**
	 * Returns the crud with the primary key or throws a <code>NoSuchCrudException</code> if it could not be found.
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud
	 * @throws NoSuchCrudException if a crud with the primary key could not be found
	 */
	public static Crud findByPrimaryKey(long crudId)
		throws com.crud.service.exception.NoSuchCrudException {

		return getPersistence().findByPrimaryKey(crudId);
	}

	/**
	 * Returns the crud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud, or <code>null</code> if a crud with the primary key could not be found
	 */
	public static Crud fetchByPrimaryKey(long crudId) {
		return getPersistence().fetchByPrimaryKey(crudId);
	}

	/**
	 * Returns all the cruds.
	 *
	 * @return the cruds
	 */
	public static List<Crud> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cruds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of cruds
	 */
	public static List<Crud> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cruds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cruds
	 */
	public static List<Crud> findAll(
		int start, int end, OrderByComparator<Crud> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cruds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CrudModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cruds
	 */
	public static List<Crud> findAll(
		int start, int end, OrderByComparator<Crud> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cruds from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cruds.
	 *
	 * @return the number of cruds
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CrudPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CrudPersistence _persistence;

}