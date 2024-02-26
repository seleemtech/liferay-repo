/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence;

import api.master.slayer.exception.NoSuchApiMapKeyException;
import api.master.slayer.model.ApiMapKey;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the api map key service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ApiMapKeyUtil
 * @generated
 */
@ProviderType
public interface ApiMapKeyPersistence extends BasePersistence<ApiMapKey> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApiMapKeyUtil} to access the api map key persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the api map keys where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching api map keys
	 */
	public java.util.List<ApiMapKey> findByUuid(String uuid);

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
	public java.util.List<ApiMapKey> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ApiMapKey> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
			orderByComparator);

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
	public java.util.List<ApiMapKey> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public ApiMapKey findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
				orderByComparator)
		throws NoSuchApiMapKeyException;

	/**
	 * Returns the first api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public ApiMapKey fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
			orderByComparator);

	/**
	 * Returns the last api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public ApiMapKey findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
				orderByComparator)
		throws NoSuchApiMapKeyException;

	/**
	 * Returns the last api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public ApiMapKey fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
			orderByComparator);

	/**
	 * Returns the api map keys before and after the current api map key in the ordered set where uuid = &#63;.
	 *
	 * @param apiMapKeyId the primary key of the current api map key
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next api map key
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	public ApiMapKey[] findByUuid_PrevAndNext(
			long apiMapKeyId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
				orderByComparator)
		throws NoSuchApiMapKeyException;

	/**
	 * Removes all the api map keys where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of api map keys where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching api map keys
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the api map key where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchApiMapKeyException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public ApiMapKey findByUUID_G(String uuid, long groupId)
		throws NoSuchApiMapKeyException;

	/**
	 * Returns the api map key where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public ApiMapKey fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the api map key where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public ApiMapKey fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the api map key where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the api map key that was removed
	 */
	public ApiMapKey removeByUUID_G(String uuid, long groupId)
		throws NoSuchApiMapKeyException;

	/**
	 * Returns the number of api map keys where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching api map keys
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns the api map key where name = &#63; or throws a <code>NoSuchApiMapKeyException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public ApiMapKey findByName(String name) throws NoSuchApiMapKeyException;

	/**
	 * Returns the api map key where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public ApiMapKey fetchByName(String name);

	/**
	 * Returns the api map key where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public ApiMapKey fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the api map key where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the api map key that was removed
	 */
	public ApiMapKey removeByName(String name) throws NoSuchApiMapKeyException;

	/**
	 * Returns the number of api map keys where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching api map keys
	 */
	public int countByName(String name);

	/**
	 * Returns all the api map keys where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching api map keys
	 */
	public java.util.List<ApiMapKey> findByUserId(long userId);

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
	public java.util.List<ApiMapKey> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<ApiMapKey> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
			orderByComparator);

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
	public java.util.List<ApiMapKey> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public ApiMapKey findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
				orderByComparator)
		throws NoSuchApiMapKeyException;

	/**
	 * Returns the first api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public ApiMapKey fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
			orderByComparator);

	/**
	 * Returns the last api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	public ApiMapKey findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
				orderByComparator)
		throws NoSuchApiMapKeyException;

	/**
	 * Returns the last api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	public ApiMapKey fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
			orderByComparator);

	/**
	 * Returns the api map keys before and after the current api map key in the ordered set where userId = &#63;.
	 *
	 * @param apiMapKeyId the primary key of the current api map key
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next api map key
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	public ApiMapKey[] findByUserId_PrevAndNext(
			long apiMapKeyId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
				orderByComparator)
		throws NoSuchApiMapKeyException;

	/**
	 * Removes all the api map keys where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of api map keys where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching api map keys
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the api map key in the entity cache if it is enabled.
	 *
	 * @param apiMapKey the api map key
	 */
	public void cacheResult(ApiMapKey apiMapKey);

	/**
	 * Caches the api map keys in the entity cache if it is enabled.
	 *
	 * @param apiMapKeys the api map keys
	 */
	public void cacheResult(java.util.List<ApiMapKey> apiMapKeys);

	/**
	 * Creates a new api map key with the primary key. Does not add the api map key to the database.
	 *
	 * @param apiMapKeyId the primary key for the new api map key
	 * @return the new api map key
	 */
	public ApiMapKey create(long apiMapKeyId);

	/**
	 * Removes the api map key with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key that was removed
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	public ApiMapKey remove(long apiMapKeyId) throws NoSuchApiMapKeyException;

	public ApiMapKey updateImpl(ApiMapKey apiMapKey);

	/**
	 * Returns the api map key with the primary key or throws a <code>NoSuchApiMapKeyException</code> if it could not be found.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	public ApiMapKey findByPrimaryKey(long apiMapKeyId)
		throws NoSuchApiMapKeyException;

	/**
	 * Returns the api map key with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key, or <code>null</code> if a api map key with the primary key could not be found
	 */
	public ApiMapKey fetchByPrimaryKey(long apiMapKeyId);

	/**
	 * Returns all the api map keys.
	 *
	 * @return the api map keys
	 */
	public java.util.List<ApiMapKey> findAll();

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
	public java.util.List<ApiMapKey> findAll(int start, int end);

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
	public java.util.List<ApiMapKey> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
			orderByComparator);

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
	public java.util.List<ApiMapKey> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApiMapKey>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the api map keys from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of api map keys.
	 *
	 * @return the number of api map keys
	 */
	public int countAll();

}