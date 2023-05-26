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

package com.docter.service.service.persistence;

import com.docter.service.exception.NoSuchDoctersException;
import com.docter.service.model.Docters;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the docters service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DoctersUtil
 * @generated
 */
@ProviderType
public interface DoctersPersistence extends BasePersistence<Docters> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DoctersUtil} to access the docters persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the docterses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching docterses
	 */
	public java.util.List<Docters> findByUuid(String uuid);

	/**
	 * Returns a range of all the docterses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @return the range of matching docterses
	 */
	public java.util.List<Docters> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the docterses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching docterses
	 */
	public java.util.List<Docters> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Docters>
			orderByComparator);

	/**
	 * Returns an ordered range of all the docterses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching docterses
	 */
	public java.util.List<Docters> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Docters>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first docters in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docters
	 * @throws NoSuchDoctersException if a matching docters could not be found
	 */
	public Docters findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Docters>
				orderByComparator)
		throws NoSuchDoctersException;

	/**
	 * Returns the first docters in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public Docters fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Docters>
			orderByComparator);

	/**
	 * Returns the last docters in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docters
	 * @throws NoSuchDoctersException if a matching docters could not be found
	 */
	public Docters findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Docters>
				orderByComparator)
		throws NoSuchDoctersException;

	/**
	 * Returns the last docters in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public Docters fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Docters>
			orderByComparator);

	/**
	 * Returns the docterses before and after the current docters in the ordered set where uuid = &#63;.
	 *
	 * @param docterId the primary key of the current docters
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next docters
	 * @throws NoSuchDoctersException if a docters with the primary key could not be found
	 */
	public Docters[] findByUuid_PrevAndNext(
			long docterId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Docters>
				orderByComparator)
		throws NoSuchDoctersException;

	/**
	 * Removes all the docterses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of docterses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching docterses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the docters where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDoctersException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching docters
	 * @throws NoSuchDoctersException if a matching docters could not be found
	 */
	public Docters findByUUID_G(String uuid, long groupId)
		throws NoSuchDoctersException;

	/**
	 * Returns the docters where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public Docters fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the docters where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public Docters fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the docters where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the docters that was removed
	 */
	public Docters removeByUUID_G(String uuid, long groupId)
		throws NoSuchDoctersException;

	/**
	 * Returns the number of docterses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching docterses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the docterses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching docterses
	 */
	public java.util.List<Docters> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the docterses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @return the range of matching docterses
	 */
	public java.util.List<Docters> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the docterses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching docterses
	 */
	public java.util.List<Docters> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Docters>
			orderByComparator);

	/**
	 * Returns an ordered range of all the docterses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching docterses
	 */
	public java.util.List<Docters> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Docters>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first docters in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docters
	 * @throws NoSuchDoctersException if a matching docters could not be found
	 */
	public Docters findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Docters>
				orderByComparator)
		throws NoSuchDoctersException;

	/**
	 * Returns the first docters in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public Docters fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Docters>
			orderByComparator);

	/**
	 * Returns the last docters in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docters
	 * @throws NoSuchDoctersException if a matching docters could not be found
	 */
	public Docters findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Docters>
				orderByComparator)
		throws NoSuchDoctersException;

	/**
	 * Returns the last docters in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docters, or <code>null</code> if a matching docters could not be found
	 */
	public Docters fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Docters>
			orderByComparator);

	/**
	 * Returns the docterses before and after the current docters in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param docterId the primary key of the current docters
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next docters
	 * @throws NoSuchDoctersException if a docters with the primary key could not be found
	 */
	public Docters[] findByUuid_C_PrevAndNext(
			long docterId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Docters>
				orderByComparator)
		throws NoSuchDoctersException;

	/**
	 * Removes all the docterses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of docterses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching docterses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the docters in the entity cache if it is enabled.
	 *
	 * @param docters the docters
	 */
	public void cacheResult(Docters docters);

	/**
	 * Caches the docterses in the entity cache if it is enabled.
	 *
	 * @param docterses the docterses
	 */
	public void cacheResult(java.util.List<Docters> docterses);

	/**
	 * Creates a new docters with the primary key. Does not add the docters to the database.
	 *
	 * @param docterId the primary key for the new docters
	 * @return the new docters
	 */
	public Docters create(long docterId);

	/**
	 * Removes the docters with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param docterId the primary key of the docters
	 * @return the docters that was removed
	 * @throws NoSuchDoctersException if a docters with the primary key could not be found
	 */
	public Docters remove(long docterId) throws NoSuchDoctersException;

	public Docters updateImpl(Docters docters);

	/**
	 * Returns the docters with the primary key or throws a <code>NoSuchDoctersException</code> if it could not be found.
	 *
	 * @param docterId the primary key of the docters
	 * @return the docters
	 * @throws NoSuchDoctersException if a docters with the primary key could not be found
	 */
	public Docters findByPrimaryKey(long docterId)
		throws NoSuchDoctersException;

	/**
	 * Returns the docters with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param docterId the primary key of the docters
	 * @return the docters, or <code>null</code> if a docters with the primary key could not be found
	 */
	public Docters fetchByPrimaryKey(long docterId);

	/**
	 * Returns all the docterses.
	 *
	 * @return the docterses
	 */
	public java.util.List<Docters> findAll();

	/**
	 * Returns a range of all the docterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @return the range of docterses
	 */
	public java.util.List<Docters> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the docterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of docterses
	 */
	public java.util.List<Docters> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Docters>
			orderByComparator);

	/**
	 * Returns an ordered range of all the docterses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DoctersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of docterses
	 * @param end the upper bound of the range of docterses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of docterses
	 */
	public java.util.List<Docters> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Docters>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the docterses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of docterses.
	 *
	 * @return the number of docterses
	 */
	public int countAll();

}