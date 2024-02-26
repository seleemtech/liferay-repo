/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence;

import api.master.slayer.exception.NoSuchMasterUrlException;
import api.master.slayer.model.MasterUrl;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the master url service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MasterUrlUtil
 * @generated
 */
@ProviderType
public interface MasterUrlPersistence extends BasePersistence<MasterUrl> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MasterUrlUtil} to access the master url persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the master urls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching master urls
	 */
	public java.util.List<MasterUrl> findByUuid(String uuid);

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
	public java.util.List<MasterUrl> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<MasterUrl> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
			orderByComparator);

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
	public java.util.List<MasterUrl> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public MasterUrl findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
				orderByComparator)
		throws NoSuchMasterUrlException;

	/**
	 * Returns the first master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public MasterUrl fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
			orderByComparator);

	/**
	 * Returns the last master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public MasterUrl findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
				orderByComparator)
		throws NoSuchMasterUrlException;

	/**
	 * Returns the last master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public MasterUrl fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
			orderByComparator);

	/**
	 * Returns the master urls before and after the current master url in the ordered set where uuid = &#63;.
	 *
	 * @param masterUrlId the primary key of the current master url
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master url
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	public MasterUrl[] findByUuid_PrevAndNext(
			long masterUrlId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
				orderByComparator)
		throws NoSuchMasterUrlException;

	/**
	 * Removes all the master urls where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of master urls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching master urls
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the master url where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMasterUrlException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public MasterUrl findByUUID_G(String uuid, long groupId)
		throws NoSuchMasterUrlException;

	/**
	 * Returns the master url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public MasterUrl fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the master url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public MasterUrl fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the master url where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the master url that was removed
	 */
	public MasterUrl removeByUUID_G(String uuid, long groupId)
		throws NoSuchMasterUrlException;

	/**
	 * Returns the number of master urls where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching master urls
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching master urls
	 */
	public java.util.List<MasterUrl> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<MasterUrl> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<MasterUrl> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
			orderByComparator);

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
	public java.util.List<MasterUrl> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public MasterUrl findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
				orderByComparator)
		throws NoSuchMasterUrlException;

	/**
	 * Returns the first master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public MasterUrl fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
			orderByComparator);

	/**
	 * Returns the last master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public MasterUrl findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
				orderByComparator)
		throws NoSuchMasterUrlException;

	/**
	 * Returns the last master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public MasterUrl fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
			orderByComparator);

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
	public MasterUrl[] findByUuid_C_PrevAndNext(
			long masterUrlId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
				orderByComparator)
		throws NoSuchMasterUrlException;

	/**
	 * Removes all the master urls where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching master urls
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the master url where appName = &#63; or throws a <code>NoSuchMasterUrlException</code> if it could not be found.
	 *
	 * @param appName the app name
	 * @return the matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	public MasterUrl findByAppName(String appName)
		throws NoSuchMasterUrlException;

	/**
	 * Returns the master url where appName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appName the app name
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public MasterUrl fetchByAppName(String appName);

	/**
	 * Returns the master url where appName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appName the app name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	public MasterUrl fetchByAppName(String appName, boolean useFinderCache);

	/**
	 * Removes the master url where appName = &#63; from the database.
	 *
	 * @param appName the app name
	 * @return the master url that was removed
	 */
	public MasterUrl removeByAppName(String appName)
		throws NoSuchMasterUrlException;

	/**
	 * Returns the number of master urls where appName = &#63;.
	 *
	 * @param appName the app name
	 * @return the number of matching master urls
	 */
	public int countByAppName(String appName);

	/**
	 * Caches the master url in the entity cache if it is enabled.
	 *
	 * @param masterUrl the master url
	 */
	public void cacheResult(MasterUrl masterUrl);

	/**
	 * Caches the master urls in the entity cache if it is enabled.
	 *
	 * @param masterUrls the master urls
	 */
	public void cacheResult(java.util.List<MasterUrl> masterUrls);

	/**
	 * Creates a new master url with the primary key. Does not add the master url to the database.
	 *
	 * @param masterUrlId the primary key for the new master url
	 * @return the new master url
	 */
	public MasterUrl create(long masterUrlId);

	/**
	 * Removes the master url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url that was removed
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	public MasterUrl remove(long masterUrlId) throws NoSuchMasterUrlException;

	public MasterUrl updateImpl(MasterUrl masterUrl);

	/**
	 * Returns the master url with the primary key or throws a <code>NoSuchMasterUrlException</code> if it could not be found.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	public MasterUrl findByPrimaryKey(long masterUrlId)
		throws NoSuchMasterUrlException;

	/**
	 * Returns the master url with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url, or <code>null</code> if a master url with the primary key could not be found
	 */
	public MasterUrl fetchByPrimaryKey(long masterUrlId);

	/**
	 * Returns all the master urls.
	 *
	 * @return the master urls
	 */
	public java.util.List<MasterUrl> findAll();

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
	public java.util.List<MasterUrl> findAll(int start, int end);

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
	public java.util.List<MasterUrl> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
			orderByComparator);

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
	public java.util.List<MasterUrl> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MasterUrl>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the master urls from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of master urls.
	 *
	 * @return the number of master urls
	 */
	public int countAll();

}