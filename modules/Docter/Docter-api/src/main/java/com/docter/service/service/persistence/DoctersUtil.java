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

package com.docter.service.service.persistence;

import com.docter.service.model.Docters;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the docters service. This utility wraps <code>com.docter.service.service.persistence.impl.DoctersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DoctersPersistence
 * @generated
 */
public class DoctersUtil {

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
	public static void clearCache(Docters docters) {
		getPersistence().clearCache(docters);
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
	public static Map<Serializable, Docters> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Docters> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Docters> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Docters> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Docters> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Docters update(Docters docters) {
		return getPersistence().update(docters);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Docters update(
		Docters docters, ServiceContext serviceContext) {

		return getPersistence().update(docters, serviceContext);
	}

	/**
	 * Returns all the docterses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching docterses
	 */
	public static List<Docters> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the docterses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @return the range of matching docterses
	 */
	public static List<Docters> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the docterses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching docterses
	 */
	public static List<Docters> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Docters> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the docterses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching docterses
	 */
	public static List<Docters> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Docters> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first docters in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docters
	 * @throws NoSuchDoctersException if a matching docters could not be found
	 */
	public static Docters findByUuid_First(
			String uuid, OrderByComparator<Docters> orderByComparator)
		throws com.docter.service.exception.NoSuchDoctersException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first docters in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public static Docters fetchByUuid_First(
		String uuid, OrderByComparator<Docters> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last docters in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docters
	 * @throws NoSuchDoctersException if a matching docters could not be found
	 */
	public static Docters findByUuid_Last(
			String uuid, OrderByComparator<Docters> orderByComparator)
		throws com.docter.service.exception.NoSuchDoctersException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last docters in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public static Docters fetchByUuid_Last(
		String uuid, OrderByComparator<Docters> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the docterses before and after the current docters in the ordered set where uuid = &#63;.
	 *
	 * @param docterId the primary key of the current docters
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next docters
	 * @throws NoSuchDoctersException if a docters with the primary key could not be found
	 */
	public static Docters[] findByUuid_PrevAndNext(
			long docterId, String uuid,
			OrderByComparator<Docters> orderByComparator)
		throws com.docter.service.exception.NoSuchDoctersException {

		return getPersistence().findByUuid_PrevAndNext(
			docterId, uuid, orderByComparator);
	}

	/**
	 * Removes all the docterses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of docterses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching docterses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the docters where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDoctersException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching docters
	 * @throws NoSuchDoctersException if a matching docters could not be found
	 */
	public static Docters findByUUID_G(String uuid, long groupId)
		throws com.docter.service.exception.NoSuchDoctersException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the docters where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public static Docters fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the docters where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public static Docters fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the docters where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the docters that was removed
	 */
	public static Docters removeByUUID_G(String uuid, long groupId)
		throws com.docter.service.exception.NoSuchDoctersException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of docterses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching docterses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the docterses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching docterses
	 */
	public static List<Docters> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the docterses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @return the range of matching docterses
	 */
	public static List<Docters> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the docterses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching docterses
	 */
	public static List<Docters> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Docters> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the docterses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching docterses
	 */
	public static List<Docters> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Docters> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first docters in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docters
	 * @throws NoSuchDoctersException if a matching docters could not be found
	 */
	public static Docters findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Docters> orderByComparator)
		throws com.docter.service.exception.NoSuchDoctersException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first docters in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public static Docters fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Docters> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last docters in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docters
	 * @throws NoSuchDoctersException if a matching docters could not be found
	 */
	public static Docters findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Docters> orderByComparator)
		throws com.docter.service.exception.NoSuchDoctersException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last docters in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public static Docters fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Docters> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the docterses before and after the current docters in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param docterId the primary key of the current docters
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next docters
	 * @throws NoSuchDoctersException if a docters with the primary key could not be found
	 */
	public static Docters[] findByUuid_C_PrevAndNext(
			long docterId, String uuid, long companyId,
			OrderByComparator<Docters> orderByComparator)
		throws com.docter.service.exception.NoSuchDoctersException {

		return getPersistence().findByUuid_C_PrevAndNext(
			docterId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the docterses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of docterses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching docterses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the docters in the entity cache if it is enabled.
	 *
	 * @param docters the docters
	 */
	public static void cacheResult(Docters docters) {
		getPersistence().cacheResult(docters);
	}

	/**
	 * Caches the docterses in the entity cache if it is enabled.
	 *
	 * @param docterses the docterses
	 */
	public static void cacheResult(List<Docters> docterses) {
		getPersistence().cacheResult(docterses);
	}

	/**
	 * Creates a new docters with the primary key. Does not add the docters to the database.
	 *
	 * @param docterId the primary key for the new docters
	 * @return the new docters
	 */
	public static Docters create(long docterId) {
		return getPersistence().create(docterId);
	}

	/**
	 * Removes the docters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docterId the primary key of the docters
	 * @return the docters that was removed
	 * @throws NoSuchDoctersException if a docters with the primary key could not be found
	 */
	public static Docters remove(long docterId)
		throws com.docter.service.exception.NoSuchDoctersException {

		return getPersistence().remove(docterId);
	}

	public static Docters updateImpl(Docters docters) {
		return getPersistence().updateImpl(docters);
	}

	/**
	 * Returns the docters with the primary key or throws a <code>NoSuchDoctersException</code> if it could not be found.
	 *
	 * @param docterId the primary key of the docters
	 * @return the docters
	 * @throws NoSuchDoctersException if a docters with the primary key could not be found
	 */
	public static Docters findByPrimaryKey(long docterId)
		throws com.docter.service.exception.NoSuchDoctersException {

		return getPersistence().findByPrimaryKey(docterId);
	}

	/**
	 * Returns the docters with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param docterId the primary key of the docters
	 * @return the docters, or <code>null</code> if a docters with the primary key could not be found
	 */
	public static Docters fetchByPrimaryKey(long docterId) {
		return getPersistence().fetchByPrimaryKey(docterId);
	}

	/**
	 * Returns all the docterses.
	 *
	 * @return the docterses
	 */
	public static List<Docters> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the docterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @return the range of docterses
	 */
	public static List<Docters> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the docterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of docterses
	 */
	public static List<Docters> findAll(
		int start, int end, OrderByComparator<Docters> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the docterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of docterses
	 */
	public static List<Docters> findAll(
		int start, int end, OrderByComparator<Docters> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the docterses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of docterses.
	 *
	 * @return the number of docterses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DoctersPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DoctersPersistence _persistence;

}