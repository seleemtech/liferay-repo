/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence;

import api.master.slayer.exception.NoSuchConnectedAccountsException;
import api.master.slayer.model.ConnectedAccounts;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the connected accounts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConnectedAccountsUtil
 * @generated
 */
@ProviderType
public interface ConnectedAccountsPersistence
	extends BasePersistence<ConnectedAccounts> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConnectedAccountsUtil} to access the connected accounts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the connected accountses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching connected accountses
	 */
	public java.util.List<ConnectedAccounts> findByUuid(String uuid);

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
	public java.util.List<ConnectedAccounts> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ConnectedAccounts> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator);

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
	public java.util.List<ConnectedAccounts> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public ConnectedAccounts findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
				orderByComparator)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the first connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator);

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public ConnectedAccounts findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
				orderByComparator)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator);

	/**
	 * Returns the connected accountses before and after the current connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param c_accountId the primary key of the current connected accounts
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	public ConnectedAccounts[] findByUuid_PrevAndNext(
			long c_accountId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
				orderByComparator)
		throws NoSuchConnectedAccountsException;

	/**
	 * Removes all the connected accountses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of connected accountses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching connected accountses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the connected accounts where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public ConnectedAccounts findByUUID_G(String uuid, long groupId)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the connected accounts where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the connected accounts where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the connected accounts where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the connected accounts that was removed
	 */
	public ConnectedAccounts removeByUUID_G(String uuid, long groupId)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the number of connected accountses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching connected accountses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching connected accountses
	 */
	public java.util.List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator);

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
	public java.util.List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public ConnectedAccounts findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
				orderByComparator)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the first connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator);

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public ConnectedAccounts findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
				orderByComparator)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator);

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
	public ConnectedAccounts[] findByUuid_C_PrevAndNext(
			long c_accountId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
				orderByComparator)
		throws NoSuchConnectedAccountsException;

	/**
	 * Removes all the connected accountses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching connected accountses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the connected accounts where appName = &#63; or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param appName the app name
	 * @return the matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public ConnectedAccounts findByAppName(String appName)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the connected accounts where appName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appName the app name
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByAppName(String appName);

	/**
	 * Returns the connected accounts where appName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appName the app name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByAppName(
		String appName, boolean useFinderCache);

	/**
	 * Removes the connected accounts where appName = &#63; from the database.
	 *
	 * @param appName the app name
	 * @return the connected accounts that was removed
	 */
	public ConnectedAccounts removeByAppName(String appName)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the number of connected accountses where appName = &#63;.
	 *
	 * @param appName the app name
	 * @return the number of matching connected accountses
	 */
	public int countByAppName(String appName);

	/**
	 * Returns the connected accounts where appName = &#63; and emailAddress = &#63; or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public ConnectedAccounts findByGetAccount(
			String appName, String emailAddress)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the connected accounts where appName = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByGetAccount(
		String appName, String emailAddress);

	/**
	 * Returns the connected accounts where appName = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByGetAccount(
		String appName, String emailAddress, boolean useFinderCache);

	/**
	 * Removes the connected accounts where appName = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the connected accounts that was removed
	 */
	public ConnectedAccounts removeByGetAccount(
			String appName, String emailAddress)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the number of connected accountses where appName = &#63; and emailAddress = &#63;.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the number of matching connected accountses
	 */
	public int countByGetAccount(String appName, String emailAddress);

	/**
	 * Returns all the connected accountses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching connected accountses
	 */
	public java.util.List<ConnectedAccounts> findByUserId(long userId);

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
	public java.util.List<ConnectedAccounts> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<ConnectedAccounts> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator);

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
	public java.util.List<ConnectedAccounts> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public ConnectedAccounts findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
				orderByComparator)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the first connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator);

	/**
	 * Returns the last connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	public ConnectedAccounts findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
				orderByComparator)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the last connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	public ConnectedAccounts fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator);

	/**
	 * Returns the connected accountses before and after the current connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param c_accountId the primary key of the current connected accounts
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	public ConnectedAccounts[] findByUserId_PrevAndNext(
			long c_accountId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
				orderByComparator)
		throws NoSuchConnectedAccountsException;

	/**
	 * Removes all the connected accountses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of connected accountses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching connected accountses
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the connected accounts in the entity cache if it is enabled.
	 *
	 * @param connectedAccounts the connected accounts
	 */
	public void cacheResult(ConnectedAccounts connectedAccounts);

	/**
	 * Caches the connected accountses in the entity cache if it is enabled.
	 *
	 * @param connectedAccountses the connected accountses
	 */
	public void cacheResult(
		java.util.List<ConnectedAccounts> connectedAccountses);

	/**
	 * Creates a new connected accounts with the primary key. Does not add the connected accounts to the database.
	 *
	 * @param c_accountId the primary key for the new connected accounts
	 * @return the new connected accounts
	 */
	public ConnectedAccounts create(long c_accountId);

	/**
	 * Removes the connected accounts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts that was removed
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	public ConnectedAccounts remove(long c_accountId)
		throws NoSuchConnectedAccountsException;

	public ConnectedAccounts updateImpl(ConnectedAccounts connectedAccounts);

	/**
	 * Returns the connected accounts with the primary key or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	public ConnectedAccounts findByPrimaryKey(long c_accountId)
		throws NoSuchConnectedAccountsException;

	/**
	 * Returns the connected accounts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts, or <code>null</code> if a connected accounts with the primary key could not be found
	 */
	public ConnectedAccounts fetchByPrimaryKey(long c_accountId);

	/**
	 * Returns all the connected accountses.
	 *
	 * @return the connected accountses
	 */
	public java.util.List<ConnectedAccounts> findAll();

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
	public java.util.List<ConnectedAccounts> findAll(int start, int end);

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
	public java.util.List<ConnectedAccounts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator);

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
	public java.util.List<ConnectedAccounts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConnectedAccounts>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the connected accountses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of connected accountses.
	 *
	 * @return the number of connected accountses
	 */
	public int countAll();

}