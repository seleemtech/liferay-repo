/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence;

import api.master.slayer.model.ApiMapKey;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the api map key service. This utility wraps <code>api.master.slayer.service.persistence.impl.ApiMapKeyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApiMapKeyPersistence
 * @generated
 */
public class ApiMapKeyUtil {

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
	public static void clearCache(ApiMapKey apiMapKey) {
		getPersistence().clearCache(apiMapKey);
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
	public static Map<Serializable, ApiMapKey> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ApiMapKey> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApiMapKey> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApiMapKey> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ApiMapKey> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ApiMapKey update(ApiMapKey apiMapKey) {
		return getPersistence().update(apiMapKey);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ApiMapKey update(
		ApiMapKey apiMapKey, ServiceContext serviceContext) {

		return getPersistence().update(apiMapKey, serviceContext);
	}

	/**
	 * Returns all the api map keys where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching api map keys
	 */
	public static List<ApiMapKey> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the api map keys where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @return the range of matching api map keys
	 */
	public static List<ApiMapKey> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the api map keys where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching api map keys
	 */
	public static List<ApiMapKey> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ApiMapKey> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the api map keys where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching api map keys
	 */
	public static List<ApiMapKey> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ApiMapKey> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public static ApiMapKey findByUuid_First(
			String uuid, OrderByComparator<ApiMapKey> orderByComparator)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public static ApiMapKey fetchByUuid_First(
		String uuid, OrderByComparator<ApiMapKey> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public static ApiMapKey findByUuid_Last(
			String uuid, OrderByComparator<ApiMapKey> orderByComparator)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public static ApiMapKey fetchByUuid_Last(
		String uuid, OrderByComparator<ApiMapKey> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the api map keys before and after the current api map key in the ordered set where uuid = &#63;.
	 *
	 * @param apiMapKeyId the primary key of the current api map key
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next api map key
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	public static ApiMapKey[] findByUuid_PrevAndNext(
			long apiMapKeyId, String uuid,
			OrderByComparator<ApiMapKey> orderByComparator)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().findByUuid_PrevAndNext(
			apiMapKeyId, uuid, orderByComparator);
	}

	/**
	 * Removes all the api map keys where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of api map keys where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching api map keys
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the api map key where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchApiMapKeyException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public static ApiMapKey findByUUID_G(String uuid, long groupId)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the api map key where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public static ApiMapKey fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the api map key where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public static ApiMapKey fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the api map key where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the api map key that was removed
	 */
	public static ApiMapKey removeByUUID_G(String uuid, long groupId)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of api map keys where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching api map keys
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the api map key where name = &#63; or throws a <code>NoSuchApiMapKeyException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public static ApiMapKey findByName(String name)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the api map key where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public static ApiMapKey fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the api map key where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public static ApiMapKey fetchByName(String name, boolean useFinderCache) {
		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the api map key where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the api map key that was removed
	 */
	public static ApiMapKey removeByName(String name)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of api map keys where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching api map keys
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Returns all the api map keys where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching api map keys
	 */
	public static List<ApiMapKey> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the api map keys where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @return the range of matching api map keys
	 */
	public static List<ApiMapKey> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the api map keys where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching api map keys
	 */
	public static List<ApiMapKey> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ApiMapKey> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the api map keys where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching api map keys
	 */
	public static List<ApiMapKey> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ApiMapKey> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public static ApiMapKey findByUserId_First(
			long userId, OrderByComparator<ApiMapKey> orderByComparator)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public static ApiMapKey fetchByUserId_First(
		long userId, OrderByComparator<ApiMapKey> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public static ApiMapKey findByUserId_Last(
			long userId, OrderByComparator<ApiMapKey> orderByComparator)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public static ApiMapKey fetchByUserId_Last(
		long userId, OrderByComparator<ApiMapKey> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the api map keys before and after the current api map key in the ordered set where userId = &#63;.
	 *
	 * @param apiMapKeyId the primary key of the current api map key
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next api map key
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	public static ApiMapKey[] findByUserId_PrevAndNext(
			long apiMapKeyId, long userId,
			OrderByComparator<ApiMapKey> orderByComparator)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().findByUserId_PrevAndNext(
			apiMapKeyId, userId, orderByComparator);
	}

	/**
	 * Removes all the api map keys where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of api map keys where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching api map keys
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the api map key in the entity cache if it is enabled.
	 *
	 * @param apiMapKey the api map key
	 */
	public static void cacheResult(ApiMapKey apiMapKey) {
		getPersistence().cacheResult(apiMapKey);
	}

	/**
	 * Caches the api map keys in the entity cache if it is enabled.
	 *
	 * @param apiMapKeys the api map keys
	 */
	public static void cacheResult(List<ApiMapKey> apiMapKeys) {
		getPersistence().cacheResult(apiMapKeys);
	}

	/**
	 * Creates a new api map key with the primary key. Does not add the api map key to the database.
	 *
	 * @param apiMapKeyId the primary key for the new api map key
	 * @return the new api map key
	 */
	public static ApiMapKey create(long apiMapKeyId) {
		return getPersistence().create(apiMapKeyId);
	}

	/**
	 * Removes the api map key with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key that was removed
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	public static ApiMapKey remove(long apiMapKeyId)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().remove(apiMapKeyId);
	}

	public static ApiMapKey updateImpl(ApiMapKey apiMapKey) {
		return getPersistence().updateImpl(apiMapKey);
	}

	/**
	 * Returns the api map key with the primary key or throws a <code>NoSuchApiMapKeyException</code> if it could not be found.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	public static ApiMapKey findByPrimaryKey(long apiMapKeyId)
		throws api.master.slayer.exception.NoSuchApiMapKeyException {

		return getPersistence().findByPrimaryKey(apiMapKeyId);
	}

	/**
	 * Returns the api map key with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key, or <code>null</code> if a api map key with the primary key could not be found
	 */
	public static ApiMapKey fetchByPrimaryKey(long apiMapKeyId) {
		return getPersistence().fetchByPrimaryKey(apiMapKeyId);
	}

	/**
	 * Returns all the api map keys.
	 *
	 * @return the api map keys
	 */
	public static List<ApiMapKey> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the api map keys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @return the range of api map keys
	 */
	public static List<ApiMapKey> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the api map keys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of api map keys
	 */
	public static List<ApiMapKey> findAll(
		int start, int end, OrderByComparator<ApiMapKey> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the api map keys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of api map keys
	 */
	public static List<ApiMapKey> findAll(
		int start, int end, OrderByComparator<ApiMapKey> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the api map keys from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of api map keys.
	 *
	 * @return the number of api map keys
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ApiMapKeyPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ApiMapKeyPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ApiMapKeyPersistence _persistence;

}