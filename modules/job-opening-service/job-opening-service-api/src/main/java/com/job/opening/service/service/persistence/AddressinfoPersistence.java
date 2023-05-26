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

import com.job.opening.service.exception.NoSuchAddressinfoException;
import com.job.opening.service.model.Addressinfo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the addressinfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AddressinfoUtil
 * @generated
 */
@ProviderType
public interface AddressinfoPersistence extends BasePersistence<Addressinfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressinfoUtil} to access the addressinfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the addressinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching addressinfos
	 */
	public java.util.List<Addressinfo> findByUuid(String uuid);

	/**
	 * Returns a range of all the addressinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @return the range of matching addressinfos
	 */
	public java.util.List<Addressinfo> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the addressinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching addressinfos
	 */
	public java.util.List<Addressinfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Addressinfo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the addressinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching addressinfos
	 */
	public java.util.List<Addressinfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Addressinfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addressinfo
	 * @throws NoSuchAddressinfoException if a matching addressinfo could not be found
	 */
	public Addressinfo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Addressinfo>
				orderByComparator)
		throws NoSuchAddressinfoException;

	/**
	 * Returns the first addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	public Addressinfo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Addressinfo>
			orderByComparator);

	/**
	 * Returns the last addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addressinfo
	 * @throws NoSuchAddressinfoException if a matching addressinfo could not be found
	 */
	public Addressinfo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Addressinfo>
				orderByComparator)
		throws NoSuchAddressinfoException;

	/**
	 * Returns the last addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	public Addressinfo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Addressinfo>
			orderByComparator);

	/**
	 * Returns the addressinfos before and after the current addressinfo in the ordered set where uuid = &#63;.
	 *
	 * @param addressId the primary key of the current addressinfo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next addressinfo
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	public Addressinfo[] findByUuid_PrevAndNext(
			long addressId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Addressinfo>
				orderByComparator)
		throws NoSuchAddressinfoException;

	/**
	 * Removes all the addressinfos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of addressinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching addressinfos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the addressinfo where jobId = &#63; or throws a <code>NoSuchAddressinfoException</code> if it could not be found.
	 *
	 * @param jobId the job ID
	 * @return the matching addressinfo
	 * @throws NoSuchAddressinfoException if a matching addressinfo could not be found
	 */
	public Addressinfo findByjobId(long jobId)
		throws NoSuchAddressinfoException;

	/**
	 * Returns the addressinfo where jobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param jobId the job ID
	 * @return the matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	public Addressinfo fetchByjobId(long jobId);

	/**
	 * Returns the addressinfo where jobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param jobId the job ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching addressinfo, or <code>null</code> if a matching addressinfo could not be found
	 */
	public Addressinfo fetchByjobId(long jobId, boolean useFinderCache);

	/**
	 * Removes the addressinfo where jobId = &#63; from the database.
	 *
	 * @param jobId the job ID
	 * @return the addressinfo that was removed
	 */
	public Addressinfo removeByjobId(long jobId)
		throws NoSuchAddressinfoException;

	/**
	 * Returns the number of addressinfos where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @return the number of matching addressinfos
	 */
	public int countByjobId(long jobId);

	/**
	 * Caches the addressinfo in the entity cache if it is enabled.
	 *
	 * @param addressinfo the addressinfo
	 */
	public void cacheResult(Addressinfo addressinfo);

	/**
	 * Caches the addressinfos in the entity cache if it is enabled.
	 *
	 * @param addressinfos the addressinfos
	 */
	public void cacheResult(java.util.List<Addressinfo> addressinfos);

	/**
	 * Creates a new addressinfo with the primary key. Does not add the addressinfo to the database.
	 *
	 * @param addressId the primary key for the new addressinfo
	 * @return the new addressinfo
	 */
	public Addressinfo create(long addressId);

	/**
	 * Removes the addressinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo that was removed
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	public Addressinfo remove(long addressId) throws NoSuchAddressinfoException;

	public Addressinfo updateImpl(Addressinfo addressinfo);

	/**
	 * Returns the addressinfo with the primary key or throws a <code>NoSuchAddressinfoException</code> if it could not be found.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo
	 * @throws NoSuchAddressinfoException if a addressinfo with the primary key could not be found
	 */
	public Addressinfo findByPrimaryKey(long addressId)
		throws NoSuchAddressinfoException;

	/**
	 * Returns the addressinfo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo, or <code>null</code> if a addressinfo with the primary key could not be found
	 */
	public Addressinfo fetchByPrimaryKey(long addressId);

	/**
	 * Returns all the addressinfos.
	 *
	 * @return the addressinfos
	 */
	public java.util.List<Addressinfo> findAll();

	/**
	 * Returns a range of all the addressinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @return the range of addressinfos
	 */
	public java.util.List<Addressinfo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the addressinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of addressinfos
	 */
	public java.util.List<Addressinfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Addressinfo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the addressinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of addressinfos
	 */
	public java.util.List<Addressinfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Addressinfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the addressinfos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of addressinfos.
	 *
	 * @return the number of addressinfos
	 */
	public int countAll();

}