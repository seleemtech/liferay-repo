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

package com.job.opening.service.service.persistence;

import com.job.opening.service.model.Addressinfo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the addressinfo service. This utility wraps <code>com.job.opening.service.service.persistence.impl.AddressinfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressinfoPersistence
 * @generated
 */
public class AddressinfoUtil {

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
	public static void clearCache(Addressinfo addressinfo) {
		getPersistence().clearCache(addressinfo);
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
	public static Map<Serializable, Addressinfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Addressinfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Addressinfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Addressinfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Addressinfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Addressinfo update(Addressinfo addressinfo) {
		return getPersistence().update(addressinfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Addressinfo update(
		Addressinfo addressinfo, ServiceContext serviceContext) {

		return getPersistence().update(addressinfo, serviceContext);
	}

	/**
	 * Returns all the addressinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching addressinfos
	 */
	public static List<Addressinfo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the addressinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @return the range of matching addressinfos
	 */
	public static List<Addressinfo> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the addressinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addressinfos
	 */
	public static List<Addressinfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Addressinfo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addressinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addressinfos
	 */
	public static List<Addressinfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Addressinfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addressinfo
	 * @throws NoSuchAddressinfoException if a matching addressinfo could not be found
	 */
	public static Addressinfo findByUuid_First(
			String uuid, OrderByComparator<Addressinfo> orderByComparator)
		throws com.job.opening.service.exception.NoSuchAddressinfoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	public static Addressinfo fetchByUuid_First(
		String uuid, OrderByComparator<Addressinfo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addressinfo
	 * @throws NoSuchAddressinfoException if a matching addressinfo could not be found
	 */
	public static Addressinfo findByUuid_Last(
			String uuid, OrderByComparator<Addressinfo> orderByComparator)
		throws com.job.opening.service.exception.NoSuchAddressinfoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	public static Addressinfo fetchByUuid_Last(
		String uuid, OrderByComparator<Addressinfo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the addressinfos before and after the current addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param addressId the primary key of the current addressinfo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next addressinfo
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	public static Addressinfo[] findByUuid_PrevAndNext(
			long addressId, String uuid,
			OrderByComparator<Addressinfo> orderByComparator)
		throws com.job.opening.service.exception.NoSuchAddressinfoException {

		return getPersistence().findByUuid_PrevAndNext(
			addressId, uuid, orderByComparator);
	}

	/**
	 * Removes all the addressinfos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of addressinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching addressinfos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the addressinfo where jobId = &#63; or throws a <code>NoSuchAddressinfoException</code> if it could not be found.
	 *
	 * @param jobId the job ID
	 * @return the matching addressinfo
	 * @throws NoSuchAddressinfoException if a matching addressinfo could not be found
	 */
	public static Addressinfo findByjobId(long jobId)
		throws com.job.opening.service.exception.NoSuchAddressinfoException {

		return getPersistence().findByjobId(jobId);
	}

	/**
	 * Returns the addressinfo where jobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param jobId the job ID
	 * @return the matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	public static Addressinfo fetchByjobId(long jobId) {
		return getPersistence().fetchByjobId(jobId);
	}

	/**
	 * Returns the addressinfo where jobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param jobId the job ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	public static Addressinfo fetchByjobId(long jobId, boolean useFinderCache) {
		return getPersistence().fetchByjobId(jobId, useFinderCache);
	}

	/**
	 * Removes the addressinfo where jobId = &#63; from the database.
	 *
	 * @param jobId the job ID
	 * @return the addressinfo that was removed
	 */
	public static Addressinfo removeByjobId(long jobId)
		throws com.job.opening.service.exception.NoSuchAddressinfoException {

		return getPersistence().removeByjobId(jobId);
	}

	/**
	 * Returns the number of addressinfos where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @return the number of matching addressinfos
	 */
	public static int countByjobId(long jobId) {
		return getPersistence().countByjobId(jobId);
	}

	/**
	 * Caches the addressinfo in the entity cache if it is enabled.
	 *
	 * @param addressinfo the addressinfo
	 */
	public static void cacheResult(Addressinfo addressinfo) {
		getPersistence().cacheResult(addressinfo);
	}

	/**
	 * Caches the addressinfos in the entity cache if it is enabled.
	 *
	 * @param addressinfos the addressinfos
	 */
	public static void cacheResult(List<Addressinfo> addressinfos) {
		getPersistence().cacheResult(addressinfos);
	}

	/**
	 * Creates a new addressinfo with the primary key. Does not add the addressinfo to the database.
	 *
	 * @param addressId the primary key for the new addressinfo
	 * @return the new addressinfo
	 */
	public static Addressinfo create(long addressId) {
		return getPersistence().create(addressId);
	}

	/**
	 * Removes the addressinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo that was removed
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	public static Addressinfo remove(long addressId)
		throws com.job.opening.service.exception.NoSuchAddressinfoException {

		return getPersistence().remove(addressId);
	}

	public static Addressinfo updateImpl(Addressinfo addressinfo) {
		return getPersistence().updateImpl(addressinfo);
	}

	/**
	 * Returns the addressinfo with the primary key or throws a <code>NoSuchAddressinfoException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	public static Addressinfo findByPrimaryKey(long addressId)
		throws com.job.opening.service.exception.NoSuchAddressinfoException {

		return getPersistence().findByPrimaryKey(addressId);
	}

	/**
	 * Returns the addressinfo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo, or <code>null</code> if a addressinfo with the primary key could not be found
	 */
	public static Addressinfo fetchByPrimaryKey(long addressId) {
		return getPersistence().fetchByPrimaryKey(addressId);
	}

	/**
	 * Returns all the addressinfos.
	 *
	 * @return the addressinfos
	 */
	public static List<Addressinfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the addressinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @return the range of addressinfos
	 */
	public static List<Addressinfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the addressinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addressinfos
	 */
	public static List<Addressinfo> findAll(
		int start, int end, OrderByComparator<Addressinfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the addressinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of addressinfos
	 */
	public static List<Addressinfo> findAll(
		int start, int end, OrderByComparator<Addressinfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the addressinfos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of addressinfos.
	 *
	 * @return the number of addressinfos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AddressinfoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AddressinfoPersistence _persistence;

}