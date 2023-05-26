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

import com.job.opening.service.model.Jobinfo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the jobinfo service. This utility wraps <code>com.job.opening.service.service.persistence.impl.JobinfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobinfoPersistence
 * @generated
 */
public class JobinfoUtil {

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
	public static void clearCache(Jobinfo jobinfo) {
		getPersistence().clearCache(jobinfo);
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
	public static Map<Serializable, Jobinfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Jobinfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Jobinfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Jobinfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Jobinfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Jobinfo update(Jobinfo jobinfo) {
		return getPersistence().update(jobinfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Jobinfo update(
		Jobinfo jobinfo, ServiceContext serviceContext) {

		return getPersistence().update(jobinfo, serviceContext);
	}

	/**
	 * Returns all the jobinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching jobinfos
	 */
	public static List<Jobinfo> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the jobinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @return the range of matching jobinfos
	 */
	public static List<Jobinfo> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the jobinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobinfos
	 */
	public static List<Jobinfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Jobinfo> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching jobinfos
	 */
	public static List<Jobinfo> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Jobinfo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first jobinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jobinfo
	 * @throws NoSuchJobinfoException if a matching jobinfo could not be found
	 */
	public static Jobinfo findByUuid_First(
			String uuid, OrderByComparator<Jobinfo> orderByComparator)
		throws com.job.opening.service.exception.NoSuchJobinfoException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first jobinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public static Jobinfo fetchByUuid_First(
		String uuid, OrderByComparator<Jobinfo> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last jobinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jobinfo
	 * @throws NoSuchJobinfoException if a matching jobinfo could not be found
	 */
	public static Jobinfo findByUuid_Last(
			String uuid, OrderByComparator<Jobinfo> orderByComparator)
		throws com.job.opening.service.exception.NoSuchJobinfoException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last jobinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public static Jobinfo fetchByUuid_Last(
		String uuid, OrderByComparator<Jobinfo> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the jobinfos before and after the current jobinfo in the ordered set where uuid = &#63;.
	 *
	 * @param jobId the primary key of the current jobinfo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next jobinfo
	 * @throws NoSuchJobinfoException if a jobinfo with the primary key could not be found
	 */
	public static Jobinfo[] findByUuid_PrevAndNext(
			long jobId, String uuid,
			OrderByComparator<Jobinfo> orderByComparator)
		throws com.job.opening.service.exception.NoSuchJobinfoException {

		return getPersistence().findByUuid_PrevAndNext(
			jobId, uuid, orderByComparator);
	}

	/**
	 * Removes all the jobinfos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of jobinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching jobinfos
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the jobinfo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJobinfoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching jobinfo
	 * @throws NoSuchJobinfoException if a matching jobinfo could not be found
	 */
	public static Jobinfo findByUUID_G(String uuid, long groupId)
		throws com.job.opening.service.exception.NoSuchJobinfoException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the jobinfo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public static Jobinfo fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the jobinfo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public static Jobinfo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the jobinfo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the jobinfo that was removed
	 */
	public static Jobinfo removeByUUID_G(String uuid, long groupId)
		throws com.job.opening.service.exception.NoSuchJobinfoException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of jobinfos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching jobinfos
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the jobinfos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching jobinfos
	 */
	public static List<Jobinfo> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the jobinfos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @return the range of matching jobinfos
	 */
	public static List<Jobinfo> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the jobinfos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobinfos
	 */
	public static List<Jobinfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Jobinfo> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobinfos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching jobinfos
	 */
	public static List<Jobinfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Jobinfo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first jobinfo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jobinfo
	 * @throws NoSuchJobinfoException if a matching jobinfo could not be found
	 */
	public static Jobinfo findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Jobinfo> orderByComparator)
		throws com.job.opening.service.exception.NoSuchJobinfoException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first jobinfo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public static Jobinfo fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Jobinfo> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last jobinfo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jobinfo
	 * @throws NoSuchJobinfoException if a matching jobinfo could not be found
	 */
	public static Jobinfo findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Jobinfo> orderByComparator)
		throws com.job.opening.service.exception.NoSuchJobinfoException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last jobinfo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public static Jobinfo fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Jobinfo> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the jobinfos before and after the current jobinfo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param jobId the primary key of the current jobinfo
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next jobinfo
	 * @throws NoSuchJobinfoException if a jobinfo with the primary key could not be found
	 */
	public static Jobinfo[] findByUuid_C_PrevAndNext(
			long jobId, String uuid, long companyId,
			OrderByComparator<Jobinfo> orderByComparator)
		throws com.job.opening.service.exception.NoSuchJobinfoException {

		return getPersistence().findByUuid_C_PrevAndNext(
			jobId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the jobinfos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of jobinfos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching jobinfos
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the jobinfo in the entity cache if it is enabled.
	 *
	 * @param jobinfo the jobinfo
	 */
	public static void cacheResult(Jobinfo jobinfo) {
		getPersistence().cacheResult(jobinfo);
	}

	/**
	 * Caches the jobinfos in the entity cache if it is enabled.
	 *
	 * @param jobinfos the jobinfos
	 */
	public static void cacheResult(List<Jobinfo> jobinfos) {
		getPersistence().cacheResult(jobinfos);
	}

	/**
	 * Creates a new jobinfo with the primary key. Does not add the jobinfo to the database.
	 *
	 * @param jobId the primary key for the new jobinfo
	 * @return the new jobinfo
	 */
	public static Jobinfo create(long jobId) {
		return getPersistence().create(jobId);
	}

	/**
	 * Removes the jobinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the jobinfo
	 * @return the jobinfo that was removed
	 * @throws NoSuchJobinfoException if a jobinfo with the primary key could not be found
	 */
	public static Jobinfo remove(long jobId)
		throws com.job.opening.service.exception.NoSuchJobinfoException {

		return getPersistence().remove(jobId);
	}

	public static Jobinfo updateImpl(Jobinfo jobinfo) {
		return getPersistence().updateImpl(jobinfo);
	}

	/**
	 * Returns the jobinfo with the primary key or throws a <code>NoSuchJobinfoException</code> if it could not be found.
	 *
	 * @param jobId the primary key of the jobinfo
	 * @return the jobinfo
	 * @throws NoSuchJobinfoException if a jobinfo with the primary key could not be found
	 */
	public static Jobinfo findByPrimaryKey(long jobId)
		throws com.job.opening.service.exception.NoSuchJobinfoException {

		return getPersistence().findByPrimaryKey(jobId);
	}

	/**
	 * Returns the jobinfo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobId the primary key of the jobinfo
	 * @return the jobinfo, or <code>null</code> if a jobinfo with the primary key could not be found
	 */
	public static Jobinfo fetchByPrimaryKey(long jobId) {
		return getPersistence().fetchByPrimaryKey(jobId);
	}

	/**
	 * Returns all the jobinfos.
	 *
	 * @return the jobinfos
	 */
	public static List<Jobinfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the jobinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @return the range of jobinfos
	 */
	public static List<Jobinfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the jobinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jobinfos
	 */
	public static List<Jobinfo> findAll(
		int start, int end, OrderByComparator<Jobinfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the jobinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of jobinfos
	 */
	public static List<Jobinfo> findAll(
		int start, int end, OrderByComparator<Jobinfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the jobinfos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of jobinfos.
	 *
	 * @return the number of jobinfos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static JobinfoPersistence getPersistence() {
		return _persistence;
	}

	private static volatile JobinfoPersistence _persistence;

}