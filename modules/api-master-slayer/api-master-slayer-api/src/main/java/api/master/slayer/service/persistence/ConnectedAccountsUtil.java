/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence;

import api.master.slayer.model.ConnectedAccounts;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the connected accounts service. This utility wraps <code>api.master.slayer.service.persistence.impl.ConnectedAccountsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConnectedAccountsPersistence
 * @generated
 */
public class ConnectedAccountsUtil {

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
	public static void clearCache(ConnectedAccounts connectedAccounts) {
		getPersistence().clearCache(connectedAccounts);
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
	public static Map<Serializable, ConnectedAccounts> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ConnectedAccounts> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConnectedAccounts> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConnectedAccounts> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ConnectedAccounts update(
		ConnectedAccounts connectedAccounts) {

		return getPersistence().update(connectedAccounts);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ConnectedAccounts update(
		ConnectedAccounts connectedAccounts, ServiceContext serviceContext) {

		return getPersistence().update(connectedAccounts, serviceContext);
	}

	/**
	 * Returns all the connected accountses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the connected accountses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @return the range of matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the connected accountses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the connected accountses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts findByUuid_First(
			String uuid, OrderByComparator<ConnectedAccounts> orderByComparator)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByUuid_First(
		String uuid, OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts findByUuid_Last(
			String uuid, OrderByComparator<ConnectedAccounts> orderByComparator)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByUuid_Last(
		String uuid, OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the connected accountses before and after the current connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param c_accountId the primary key of the current connected accounts
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	public static ConnectedAccounts[] findByUuid_PrevAndNext(
			long c_accountId, String uuid,
			OrderByComparator<ConnectedAccounts> orderByComparator)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByUuid_PrevAndNext(
			c_accountId, uuid, orderByComparator);
	}

	/**
	 * Removes all the connected accountses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of connected accountses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching connected accountses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the connected accounts where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts findByUUID_G(String uuid, long groupId)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the connected accounts where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the connected accounts where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the connected accounts where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the connected accounts that was removed
	 */
	public static ConnectedAccounts removeByUUID_G(String uuid, long groupId)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of connected accountses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching connected accountses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @return the range of matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ConnectedAccounts> orderByComparator)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ConnectedAccounts> orderByComparator)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the connected accountses before and after the current connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param c_accountId the primary key of the current connected accounts
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	public static ConnectedAccounts[] findByUuid_C_PrevAndNext(
			long c_accountId, String uuid, long companyId,
			OrderByComparator<ConnectedAccounts> orderByComparator)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByUuid_C_PrevAndNext(
			c_accountId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the connected accountses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching connected accountses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the connected accounts where appName = &#63; or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param appName the app name
	 * @return the matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts findByAppName(String appName)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByAppName(appName);
	}

	/**
	 * Returns the connected accounts where appName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appName the app name
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByAppName(String appName) {
		return getPersistence().fetchByAppName(appName);
	}

	/**
	 * Returns the connected accounts where appName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appName the app name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByAppName(
		String appName, boolean useFinderCache) {

		return getPersistence().fetchByAppName(appName, useFinderCache);
	}

	/**
	 * Removes the connected accounts where appName = &#63; from the database.
	 *
	 * @param appName the app name
	 * @return the connected accounts that was removed
	 */
	public static ConnectedAccounts removeByAppName(String appName)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().removeByAppName(appName);
	}

	/**
	 * Returns the number of connected accountses where appName = &#63;.
	 *
	 * @param appName the app name
	 * @return the number of matching connected accountses
	 */
	public static int countByAppName(String appName) {
		return getPersistence().countByAppName(appName);
	}

	/**
	 * Returns the connected accounts where appName = &#63; and emailAddress = &#63; or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts findByGetAccount(
			String appName, String emailAddress)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByGetAccount(appName, emailAddress);
	}

	/**
	 * Returns the connected accounts where appName = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByGetAccount(
		String appName, String emailAddress) {

		return getPersistence().fetchByGetAccount(appName, emailAddress);
	}

	/**
	 * Returns the connected accounts where appName = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByGetAccount(
		String appName, String emailAddress, boolean useFinderCache) {

		return getPersistence().fetchByGetAccount(
			appName, emailAddress, useFinderCache);
	}

	/**
	 * Removes the connected accounts where appName = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the connected accounts that was removed
	 */
	public static ConnectedAccounts removeByGetAccount(
			String appName, String emailAddress)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().removeByGetAccount(appName, emailAddress);
	}

	/**
	 * Returns the number of connected accountses where appName = &#63; and emailAddress = &#63;.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the number of matching connected accountses
	 */
	public static int countByGetAccount(String appName, String emailAddress) {
		return getPersistence().countByGetAccount(appName, emailAddress);
	}

	/**
	 * Returns all the connected accountses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the connected accountses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @return the range of matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the connected accountses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the connected accountses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching connected accountses
	 */
	public static List<ConnectedAccounts> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts findByUserId_First(
			long userId, OrderByComparator<ConnectedAccounts> orderByComparator)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByUserId_First(
		long userId, OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts findByUserId_Last(
			long userId, OrderByComparator<ConnectedAccounts> orderByComparator)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public static ConnectedAccounts fetchByUserId_Last(
		long userId, OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the connected accountses before and after the current connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param c_accountId the primary key of the current connected accounts
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	public static ConnectedAccounts[] findByUserId_PrevAndNext(
			long c_accountId, long userId,
			OrderByComparator<ConnectedAccounts> orderByComparator)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByUserId_PrevAndNext(
			c_accountId, userId, orderByComparator);
	}

	/**
	 * Removes all the connected accountses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of connected accountses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching connected accountses
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the connected accounts in the entity cache if it is enabled.
	 *
	 * @param connectedAccounts the connected accounts
	 */
	public static void cacheResult(ConnectedAccounts connectedAccounts) {
		getPersistence().cacheResult(connectedAccounts);
	}

	/**
	 * Caches the connected accountses in the entity cache if it is enabled.
	 *
	 * @param connectedAccountses the connected accountses
	 */
	public static void cacheResult(
		List<ConnectedAccounts> connectedAccountses) {

		getPersistence().cacheResult(connectedAccountses);
	}

	/**
	 * Creates a new connected accounts with the primary key. Does not add the connected accounts to the database.
	 *
	 * @param c_accountId the primary key for the new connected accounts
	 * @return the new connected accounts
	 */
	public static ConnectedAccounts create(long c_accountId) {
		return getPersistence().create(c_accountId);
	}

	/**
	 * Removes the connected accounts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts that was removed
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	public static ConnectedAccounts remove(long c_accountId)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().remove(c_accountId);
	}

	public static ConnectedAccounts updateImpl(
		ConnectedAccounts connectedAccounts) {

		return getPersistence().updateImpl(connectedAccounts);
	}

	/**
	 * Returns the connected accounts with the primary key or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	public static ConnectedAccounts findByPrimaryKey(long c_accountId)
		throws api.master.slayer.exception.NoSuchConnectedAccountsException {

		return getPersistence().findByPrimaryKey(c_accountId);
	}

	/**
	 * Returns the connected accounts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts, or <code>null</code> if a connected accounts with the primary key could not be found
	 */
	public static ConnectedAccounts fetchByPrimaryKey(long c_accountId) {
		return getPersistence().fetchByPrimaryKey(c_accountId);
	}

	/**
	 * Returns all the connected accountses.
	 *
	 * @return the connected accountses
	 */
	public static List<ConnectedAccounts> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the connected accountses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @return the range of connected accountses
	 */
	public static List<ConnectedAccounts> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the connected accountses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of connected accountses
	 */
	public static List<ConnectedAccounts> findAll(
		int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the connected accountses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of connected accountses
	 */
	public static List<ConnectedAccounts> findAll(
		int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the connected accountses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of connected accountses.
	 *
	 * @return the number of connected accountses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConnectedAccountsPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		ConnectedAccountsPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile ConnectedAccountsPersistence _persistence;

}