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

import com.prime.data.service.model.HighQualHeld;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the high qual held service. This utility wraps <code>com.prime.data.service.service.persistence.impl.HighQualHeldPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HighQualHeldPersistence
 * @generated
 */
public class HighQualHeldUtil {

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
	public static void clearCache(HighQualHeld highQualHeld) {
		getPersistence().clearCache(highQualHeld);
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
	public static Map<Serializable, HighQualHeld> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HighQualHeld> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HighQualHeld> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HighQualHeld> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HighQualHeld> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HighQualHeld update(HighQualHeld highQualHeld) {
		return getPersistence().update(highQualHeld);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HighQualHeld update(
		HighQualHeld highQualHeld, ServiceContext serviceContext) {

		return getPersistence().update(highQualHeld, serviceContext);
	}

	/**
	 * Returns all the high qual helds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching high qual helds
	 */
	public static List<HighQualHeld> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the high qual helds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @return the range of matching high qual helds
	 */
	public static List<HighQualHeld> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the high qual helds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching high qual helds
	 */
	public static List<HighQualHeld> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<HighQualHeld> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the high qual helds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching high qual helds
	 */
	public static List<HighQualHeld> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<HighQualHeld> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching high qual held
	 * @throws NoSuchHighQualHeldException if a matching high qual held could not be found
	 */
	public static HighQualHeld findByUuid_First(
			String uuid, OrderByComparator<HighQualHeld> orderByComparator)
		throws com.prime.data.service.exception.NoSuchHighQualHeldException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching high qual held, or <code>null</code> if a matching high qual held could not be found
	 */
	public static HighQualHeld fetchByUuid_First(
		String uuid, OrderByComparator<HighQualHeld> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching high qual held
	 * @throws NoSuchHighQualHeldException if a matching high qual held could not be found
	 */
	public static HighQualHeld findByUuid_Last(
			String uuid, OrderByComparator<HighQualHeld> orderByComparator)
		throws com.prime.data.service.exception.NoSuchHighQualHeldException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching high qual held, or <code>null</code> if a matching high qual held could not be found
	 */
	public static HighQualHeld fetchByUuid_Last(
		String uuid, OrderByComparator<HighQualHeld> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the high qual helds before and after the current high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param highQualHeldId the primary key of the current high qual held
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next high qual held
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	public static HighQualHeld[] findByUuid_PrevAndNext(
			long highQualHeldId, String uuid,
			OrderByComparator<HighQualHeld> orderByComparator)
		throws com.prime.data.service.exception.NoSuchHighQualHeldException {

		return getPersistence().findByUuid_PrevAndNext(
			highQualHeldId, uuid, orderByComparator);
	}

	/**
	 * Removes all the high qual helds where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of high qual helds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching high qual helds
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the high qual held in the entity cache if it is enabled.
	 *
	 * @param highQualHeld the high qual held
	 */
	public static void cacheResult(HighQualHeld highQualHeld) {
		getPersistence().cacheResult(highQualHeld);
	}

	/**
	 * Caches the high qual helds in the entity cache if it is enabled.
	 *
	 * @param highQualHelds the high qual helds
	 */
	public static void cacheResult(List<HighQualHeld> highQualHelds) {
		getPersistence().cacheResult(highQualHelds);
	}

	/**
	 * Creates a new high qual held with the primary key. Does not add the high qual held to the database.
	 *
	 * @param highQualHeldId the primary key for the new high qual held
	 * @return the new high qual held
	 */
	public static HighQualHeld create(long highQualHeldId) {
		return getPersistence().create(highQualHeldId);
	}

	/**
	 * Removes the high qual held with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held that was removed
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	public static HighQualHeld remove(long highQualHeldId)
		throws com.prime.data.service.exception.NoSuchHighQualHeldException {

		return getPersistence().remove(highQualHeldId);
	}

	public static HighQualHeld updateImpl(HighQualHeld highQualHeld) {
		return getPersistence().updateImpl(highQualHeld);
	}

	/**
	 * Returns the high qual held with the primary key or throws a <code>NoSuchHighQualHeldException</code> if it could not be found.
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	public static HighQualHeld findByPrimaryKey(long highQualHeldId)
		throws com.prime.data.service.exception.NoSuchHighQualHeldException {

		return getPersistence().findByPrimaryKey(highQualHeldId);
	}

	/**
	 * Returns the high qual held with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held, or <code>null</code> if a high qual held with the primary key could not be found
	 */
	public static HighQualHeld fetchByPrimaryKey(long highQualHeldId) {
		return getPersistence().fetchByPrimaryKey(highQualHeldId);
	}

	/**
	 * Returns all the high qual helds.
	 *
	 * @return the high qual helds
	 */
	public static List<HighQualHeld> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the high qual helds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @return the range of high qual helds
	 */
	public static List<HighQualHeld> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the high qual helds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of high qual helds
	 */
	public static List<HighQualHeld> findAll(
		int start, int end, OrderByComparator<HighQualHeld> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the high qual helds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of high qual helds
	 */
	public static List<HighQualHeld> findAll(
		int start, int end, OrderByComparator<HighQualHeld> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the high qual helds from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of high qual helds.
	 *
	 * @return the number of high qual helds
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HighQualHeldPersistence getPersistence() {
		return _persistence;
	}

	private static volatile HighQualHeldPersistence _persistence;

}