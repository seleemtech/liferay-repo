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

import com.job.opening.service.model.Descriptiveinfo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the descriptiveinfo service. This utility wraps <code>com.job.opening.service.service.persistence.impl.DescriptiveinfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescriptiveinfoPersistence
 * @generated
 */
public class DescriptiveinfoUtil {

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
	public static void clearCache(Descriptiveinfo descriptiveinfo) {
		getPersistence().clearCache(descriptiveinfo);
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
	public static Map<Serializable, Descriptiveinfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Descriptiveinfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Descriptiveinfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Descriptiveinfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Descriptiveinfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Descriptiveinfo update(Descriptiveinfo descriptiveinfo) {
		return getPersistence().update(descriptiveinfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Descriptiveinfo update(
		Descriptiveinfo descriptiveinfo, ServiceContext serviceContext) {

		return getPersistence().update(descriptiveinfo, serviceContext);
	}

	/**
	 * Returns all the descriptiveinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching descriptiveinfos
	 */
	public static List<Descriptiveinfo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the descriptiveinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @return the range of matching descriptiveinfos
	 */
	public static List<Descriptiveinfo> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the descriptiveinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching descriptiveinfos
	 */
	public static List<Descriptiveinfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Descriptiveinfo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the descriptiveinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching descriptiveinfos
	 */
	public static List<Descriptiveinfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Descriptiveinfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a matching descriptiveinfo could not be found
	 */
	public static Descriptiveinfo findByUuid_First(
			String uuid, OrderByComparator<Descriptiveinfo> orderByComparator)
		throws com.job.opening.service.exception.
			NoSuchDescriptiveinfoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	public static Descriptiveinfo fetchByUuid_First(
		String uuid, OrderByComparator<Descriptiveinfo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a matching descriptiveinfo could not be found
	 */
	public static Descriptiveinfo findByUuid_Last(
			String uuid, OrderByComparator<Descriptiveinfo> orderByComparator)
		throws com.job.opening.service.exception.
			NoSuchDescriptiveinfoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	public static Descriptiveinfo fetchByUuid_Last(
		String uuid, OrderByComparator<Descriptiveinfo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the descriptiveinfos before and after the current descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param descriptiveId the primary key of the current descriptiveinfo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	public static Descriptiveinfo[] findByUuid_PrevAndNext(
			long descriptiveId, String uuid,
			OrderByComparator<Descriptiveinfo> orderByComparator)
		throws com.job.opening.service.exception.
			NoSuchDescriptiveinfoException {

		return getPersistence().findByUuid_PrevAndNext(
			descriptiveId, uuid, orderByComparator);
	}

	/**
	 * Removes all the descriptiveinfos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of descriptiveinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching descriptiveinfos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the descriptiveinfo where jobId = &#63; or throws a <code>NoSuchDescriptiveinfoException</code> if it could not be found.
	 *
	 * @param jobId the job ID
	 * @return the matching descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a matching descriptiveinfo could not be found
	 */
	public static Descriptiveinfo findByjobId(long jobId)
		throws com.job.opening.service.exception.
			NoSuchDescriptiveinfoException {

		return getPersistence().findByjobId(jobId);
	}

	/**
	 * Returns the descriptiveinfo where jobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param jobId the job ID
	 * @return the matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	public static Descriptiveinfo fetchByjobId(long jobId) {
		return getPersistence().fetchByjobId(jobId);
	}

	/**
	 * Returns the descriptiveinfo where jobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param jobId the job ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	public static Descriptiveinfo fetchByjobId(
		long jobId, boolean useFinderCache) {

		return getPersistence().fetchByjobId(jobId, useFinderCache);
	}

	/**
	 * Removes the descriptiveinfo where jobId = &#63; from the database.
	 *
	 * @param jobId the job ID
	 * @return the descriptiveinfo that was removed
	 */
	public static Descriptiveinfo removeByjobId(long jobId)
		throws com.job.opening.service.exception.
			NoSuchDescriptiveinfoException {

		return getPersistence().removeByjobId(jobId);
	}

	/**
	 * Returns the number of descriptiveinfos where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @return the number of matching descriptiveinfos
	 */
	public static int countByjobId(long jobId) {
		return getPersistence().countByjobId(jobId);
	}

	/**
	 * Caches the descriptiveinfo in the entity cache if it is enabled.
	 *
	 * @param descriptiveinfo the descriptiveinfo
	 */
	public static void cacheResult(Descriptiveinfo descriptiveinfo) {
		getPersistence().cacheResult(descriptiveinfo);
	}

	/**
	 * Caches the descriptiveinfos in the entity cache if it is enabled.
	 *
	 * @param descriptiveinfos the descriptiveinfos
	 */
	public static void cacheResult(List<Descriptiveinfo> descriptiveinfos) {
		getPersistence().cacheResult(descriptiveinfos);
	}

	/**
	 * Creates a new descriptiveinfo with the primary key. Does not add the descriptiveinfo to the database.
	 *
	 * @param descriptiveId the primary key for the new descriptiveinfo
	 * @return the new descriptiveinfo
	 */
	public static Descriptiveinfo create(long descriptiveId) {
		return getPersistence().create(descriptiveId);
	}

	/**
	 * Removes the descriptiveinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo that was removed
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	public static Descriptiveinfo remove(long descriptiveId)
		throws com.job.opening.service.exception.
			NoSuchDescriptiveinfoException {

		return getPersistence().remove(descriptiveId);
	}

	public static Descriptiveinfo updateImpl(Descriptiveinfo descriptiveinfo) {
		return getPersistence().updateImpl(descriptiveinfo);
	}

	/**
	 * Returns the descriptiveinfo with the primary key or throws a <code>NoSuchDescriptiveinfoException</code> if it could not be found.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	public static Descriptiveinfo findByPrimaryKey(long descriptiveId)
		throws com.job.opening.service.exception.
			NoSuchDescriptiveinfoException {

		return getPersistence().findByPrimaryKey(descriptiveId);
	}

	/**
	 * Returns the descriptiveinfo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo, or <code>null</code> if a descriptiveinfo with the primary key could not be found
	 */
	public static Descriptiveinfo fetchByPrimaryKey(long descriptiveId) {
		return getPersistence().fetchByPrimaryKey(descriptiveId);
	}

	/**
	 * Returns all the descriptiveinfos.
	 *
	 * @return the descriptiveinfos
	 */
	public static List<Descriptiveinfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the descriptiveinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @return the range of descriptiveinfos
	 */
	public static List<Descriptiveinfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the descriptiveinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of descriptiveinfos
	 */
	public static List<Descriptiveinfo> findAll(
		int start, int end,
		OrderByComparator<Descriptiveinfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the descriptiveinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of descriptiveinfos
	 */
	public static List<Descriptiveinfo> findAll(
		int start, int end,
		OrderByComparator<Descriptiveinfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the descriptiveinfos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of descriptiveinfos.
	 *
	 * @return the number of descriptiveinfos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DescriptiveinfoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DescriptiveinfoPersistence _persistence;

}