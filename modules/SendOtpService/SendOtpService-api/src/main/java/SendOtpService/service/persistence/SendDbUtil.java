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

package SendOtpService.service.persistence;

import SendOtpService.model.SendDb;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the send db service. This utility wraps <code>SendOtpService.service.persistence.impl.SendDbPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SendDbPersistence
 * @generated
 */
public class SendDbUtil {

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
	public static void clearCache(SendDb sendDb) {
		getPersistence().clearCache(sendDb);
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
	public static Map<Serializable, SendDb> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SendDb> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SendDb> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SendDb> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SendDb> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SendDb update(SendDb sendDb) {
		return getPersistence().update(sendDb);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SendDb update(SendDb sendDb, ServiceContext serviceContext) {
		return getPersistence().update(sendDb, serviceContext);
	}

	/**
	 * Returns all the send dbs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching send dbs
	 */
	public static List<SendDb> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the send dbs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @return the range of matching send dbs
	 */
	public static List<SendDb> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the send dbs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching send dbs
	 */
	public static List<SendDb> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SendDb> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the send dbs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching send dbs
	 */
	public static List<SendDb> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SendDb> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first send db in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching send db
	 * @throws NoSuchSendDbException if a matching send db could not be found
	 */
	public static SendDb findByUuid_First(
			String uuid, OrderByComparator<SendDb> orderByComparator)
		throws SendOtpService.exception.NoSuchSendDbException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first send db in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching send db, or <code>null</code> if a matching send db could not be found
	 */
	public static SendDb fetchByUuid_First(
		String uuid, OrderByComparator<SendDb> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last send db in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching send db
	 * @throws NoSuchSendDbException if a matching send db could not be found
	 */
	public static SendDb findByUuid_Last(
			String uuid, OrderByComparator<SendDb> orderByComparator)
		throws SendOtpService.exception.NoSuchSendDbException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last send db in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching send db, or <code>null</code> if a matching send db could not be found
	 */
	public static SendDb fetchByUuid_Last(
		String uuid, OrderByComparator<SendDb> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the send dbs before and after the current send db in the ordered set where uuid = &#63;.
	 *
	 * @param sendId the primary key of the current send db
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next send db
	 * @throws NoSuchSendDbException if a send db with the primary key could not be found
	 */
	public static SendDb[] findByUuid_PrevAndNext(
			long sendId, String uuid,
			OrderByComparator<SendDb> orderByComparator)
		throws SendOtpService.exception.NoSuchSendDbException {

		return getPersistence().findByUuid_PrevAndNext(
			sendId, uuid, orderByComparator);
	}

	/**
	 * Removes all the send dbs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of send dbs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching send dbs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the send dbs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching send dbs
	 */
	public static List<SendDb> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the send dbs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @return the range of matching send dbs
	 */
	public static List<SendDb> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the send dbs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching send dbs
	 */
	public static List<SendDb> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SendDb> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the send dbs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching send dbs
	 */
	public static List<SendDb> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SendDb> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first send db in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching send db
	 * @throws NoSuchSendDbException if a matching send db could not be found
	 */
	public static SendDb findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SendDb> orderByComparator)
		throws SendOtpService.exception.NoSuchSendDbException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first send db in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching send db, or <code>null</code> if a matching send db could not be found
	 */
	public static SendDb fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SendDb> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last send db in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching send db
	 * @throws NoSuchSendDbException if a matching send db could not be found
	 */
	public static SendDb findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SendDb> orderByComparator)
		throws SendOtpService.exception.NoSuchSendDbException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last send db in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching send db, or <code>null</code> if a matching send db could not be found
	 */
	public static SendDb fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SendDb> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the send dbs before and after the current send db in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sendId the primary key of the current send db
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next send db
	 * @throws NoSuchSendDbException if a send db with the primary key could not be found
	 */
	public static SendDb[] findByUuid_C_PrevAndNext(
			long sendId, String uuid, long companyId,
			OrderByComparator<SendDb> orderByComparator)
		throws SendOtpService.exception.NoSuchSendDbException {

		return getPersistence().findByUuid_C_PrevAndNext(
			sendId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the send dbs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of send dbs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching send dbs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the send db in the entity cache if it is enabled.
	 *
	 * @param sendDb the send db
	 */
	public static void cacheResult(SendDb sendDb) {
		getPersistence().cacheResult(sendDb);
	}

	/**
	 * Caches the send dbs in the entity cache if it is enabled.
	 *
	 * @param sendDbs the send dbs
	 */
	public static void cacheResult(List<SendDb> sendDbs) {
		getPersistence().cacheResult(sendDbs);
	}

	/**
	 * Creates a new send db with the primary key. Does not add the send db to the database.
	 *
	 * @param sendId the primary key for the new send db
	 * @return the new send db
	 */
	public static SendDb create(long sendId) {
		return getPersistence().create(sendId);
	}

	/**
	 * Removes the send db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sendId the primary key of the send db
	 * @return the send db that was removed
	 * @throws NoSuchSendDbException if a send db with the primary key could not be found
	 */
	public static SendDb remove(long sendId)
		throws SendOtpService.exception.NoSuchSendDbException {

		return getPersistence().remove(sendId);
	}

	public static SendDb updateImpl(SendDb sendDb) {
		return getPersistence().updateImpl(sendDb);
	}

	/**
	 * Returns the send db with the primary key or throws a <code>NoSuchSendDbException</code> if it could not be found.
	 *
	 * @param sendId the primary key of the send db
	 * @return the send db
	 * @throws NoSuchSendDbException if a send db with the primary key could not be found
	 */
	public static SendDb findByPrimaryKey(long sendId)
		throws SendOtpService.exception.NoSuchSendDbException {

		return getPersistence().findByPrimaryKey(sendId);
	}

	/**
	 * Returns the send db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sendId the primary key of the send db
	 * @return the send db, or <code>null</code> if a send db with the primary key could not be found
	 */
	public static SendDb fetchByPrimaryKey(long sendId) {
		return getPersistence().fetchByPrimaryKey(sendId);
	}

	/**
	 * Returns all the send dbs.
	 *
	 * @return the send dbs
	 */
	public static List<SendDb> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the send dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @return the range of send dbs
	 */
	public static List<SendDb> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the send dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of send dbs
	 */
	public static List<SendDb> findAll(
		int start, int end, OrderByComparator<SendDb> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the send dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SendDbModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of send dbs
	 * @param end the upper bound of the range of send dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of send dbs
	 */
	public static List<SendDb> findAll(
		int start, int end, OrderByComparator<SendDb> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the send dbs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of send dbs.
	 *
	 * @return the number of send dbs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SendDbPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SendDbPersistence _persistence;

}