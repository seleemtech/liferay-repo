/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence;

import api.master.slayer.model.MasterUrl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the master url service. This utility wraps <code>api.master.slayer.service.persistence.impl.MasterUrlPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterUrlPersistence
 * @generated
 */
public class MasterUrlUtil {

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
	public static void clearCache(MasterUrl masterUrl) {
		getPersistence().clearCache(masterUrl);
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
	public static Map<Serializable, MasterUrl> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MasterUrl> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MasterUrl> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MasterUrl> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MasterUrl update(MasterUrl masterUrl) {
		return getPersistence().update(masterUrl);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MasterUrl update(
		MasterUrl masterUrl, ServiceContext serviceContext) {

		return getPersistence().update(masterUrl, serviceContext);
	}

	/**
	 * Returns all the master urls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching master urls
	 */
	public static List<MasterUrl> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the master urls where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @return the range of matching master urls
	 */
	public static List<MasterUrl> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the master urls where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master urls
	 */
	public static List<MasterUrl> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master urls where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master urls
	 */
	public static List<MasterUrl> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public static MasterUrl findByUuid_First(
			String uuid, OrderByComparator<MasterUrl> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public static MasterUrl fetchByUuid_First(
		String uuid, OrderByComparator<MasterUrl> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public static MasterUrl findByUuid_Last(
			String uuid, OrderByComparator<MasterUrl> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public static MasterUrl fetchByUuid_Last(
		String uuid, OrderByComparator<MasterUrl> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the master urls before and after the current master url in the ordered set where uuid = &#63;.
	 *
	 * @param masterUrlId the primary key of the current master url
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master url
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	public static MasterUrl[] findByUuid_PrevAndNext(
			long masterUrlId, String uuid,
			OrderByComparator<MasterUrl> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().findByUuid_PrevAndNext(
			masterUrlId, uuid, orderByComparator);
	}

	/**
	 * Removes all the master urls where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of master urls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching master urls
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the master url where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMasterUrlException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public static MasterUrl findByUUID_G(String uuid, long groupId)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the master url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public static MasterUrl fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the master url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public static MasterUrl fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the master url where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the master url that was removed
	 */
	public static MasterUrl removeByUUID_G(String uuid, long groupId)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of master urls where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching master urls
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching master urls
	 */
	public static List<MasterUrl> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @return the range of matching master urls
	 */
	public static List<MasterUrl> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master urls
	 */
	public static List<MasterUrl> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master urls
	 */
	public static List<MasterUrl> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public static MasterUrl findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MasterUrl> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public static MasterUrl fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MasterUrl> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public static MasterUrl findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MasterUrl> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public static MasterUrl fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MasterUrl> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the master urls before and after the current master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param masterUrlId the primary key of the current master url
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master url
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	public static MasterUrl[] findByUuid_C_PrevAndNext(
			long masterUrlId, String uuid, long companyId,
			OrderByComparator<MasterUrl> orderByComparator)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().findByUuid_C_PrevAndNext(
			masterUrlId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the master urls where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching master urls
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the master url where appName = &#63; or throws a <code>NoSuchMasterUrlException</code> if it could not be found.
	 *
	 * @param appName the app name
	 * @return the matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public static MasterUrl findByAppName(String appName)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().findByAppName(appName);
	}

	/**
	 * Returns the master url where appName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appName the app name
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public static MasterUrl fetchByAppName(String appName) {
		return getPersistence().fetchByAppName(appName);
	}

	/**
	 * Returns the master url where appName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appName the app name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public static MasterUrl fetchByAppName(
		String appName, boolean useFinderCache) {

		return getPersistence().fetchByAppName(appName, useFinderCache);
	}

	/**
	 * Removes the master url where appName = &#63; from the database.
	 *
	 * @param appName the app name
	 * @return the master url that was removed
	 */
	public static MasterUrl removeByAppName(String appName)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().removeByAppName(appName);
	}

	/**
	 * Returns the number of master urls where appName = &#63;.
	 *
	 * @param appName the app name
	 * @return the number of matching master urls
	 */
	public static int countByAppName(String appName) {
		return getPersistence().countByAppName(appName);
	}

	/**
	 * Caches the master url in the entity cache if it is enabled.
	 *
	 * @param masterUrl the master url
	 */
	public static void cacheResult(MasterUrl masterUrl) {
		getPersistence().cacheResult(masterUrl);
	}

	/**
	 * Caches the master urls in the entity cache if it is enabled.
	 *
	 * @param masterUrls the master urls
	 */
	public static void cacheResult(List<MasterUrl> masterUrls) {
		getPersistence().cacheResult(masterUrls);
	}

	/**
	 * Creates a new master url with the primary key. Does not add the master url to the database.
	 *
	 * @param masterUrlId the primary key for the new master url
	 * @return the new master url
	 */
	public static MasterUrl create(long masterUrlId) {
		return getPersistence().create(masterUrlId);
	}

	/**
	 * Removes the master url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url that was removed
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	public static MasterUrl remove(long masterUrlId)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().remove(masterUrlId);
	}

	public static MasterUrl updateImpl(MasterUrl masterUrl) {
		return getPersistence().updateImpl(masterUrl);
	}

	/**
	 * Returns the master url with the primary key or throws a <code>NoSuchMasterUrlException</code> if it could not be found.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	public static MasterUrl findByPrimaryKey(long masterUrlId)
		throws api.master.slayer.exception.NoSuchMasterUrlException {

		return getPersistence().findByPrimaryKey(masterUrlId);
	}

	/**
	 * Returns the master url with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url, or <code>null</code> if a master url with the primary key could not be found
	 */
	public static MasterUrl fetchByPrimaryKey(long masterUrlId) {
		return getPersistence().fetchByPrimaryKey(masterUrlId);
	}

	/**
	 * Returns all the master urls.
	 *
	 * @return the master urls
	 */
	public static List<MasterUrl> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the master urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @return the range of master urls
	 */
	public static List<MasterUrl> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the master urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master urls
	 */
	public static List<MasterUrl> findAll(
		int start, int end, OrderByComparator<MasterUrl> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the master urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master urls
	 */
	public static List<MasterUrl> findAll(
		int start, int end, OrderByComparator<MasterUrl> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the master urls from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of master urls.
	 *
	 * @return the number of master urls
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MasterUrlPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(MasterUrlPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile MasterUrlPersistence _persistence;

}