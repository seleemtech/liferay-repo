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

import com.job.opening.service.exception.NoSuchDescriptiveinfoException;
import com.job.opening.service.model.Descriptiveinfo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the descriptiveinfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DescriptiveinfoUtil
 * @generated
 */
@ProviderType
public interface DescriptiveinfoPersistence
	extends BasePersistence<Descriptiveinfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DescriptiveinfoUtil} to access the descriptiveinfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the descriptiveinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching descriptiveinfos
	 */
	public java.util.List<Descriptiveinfo> findByUuid(String uuid);

	/**
	 * Returns a range of all the descriptiveinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @return the range of matching descriptiveinfos
	 */
	public java.util.List<Descriptiveinfo> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the descriptiveinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching descriptiveinfos
	 */
	public java.util.List<Descriptiveinfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Descriptiveinfo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the descriptiveinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching descriptiveinfos
	 */
	public java.util.List<Descriptiveinfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Descriptiveinfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a matching descriptiveinfo could not be found
	 */
	public Descriptiveinfo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Descriptiveinfo>
				orderByComparator)
		throws NoSuchDescriptiveinfoException;

	/**
	 * Returns the first descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	public Descriptiveinfo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Descriptiveinfo>
			orderByComparator);

	/**
	 * Returns the last descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a matching descriptiveinfo could not be found
	 */
	public Descriptiveinfo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Descriptiveinfo>
				orderByComparator)
		throws NoSuchDescriptiveinfoException;

	/**
	 * Returns the last descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	public Descriptiveinfo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Descriptiveinfo>
			orderByComparator);

	/**
	 * Returns the descriptiveinfos before and after the current descriptiveinfo in the ordered set where uuid = &#63;.
	 *
	 * @param descriptiveId the primary key of the current descriptiveinfo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	public Descriptiveinfo[] findByUuid_PrevAndNext(
			long descriptiveId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Descriptiveinfo>
				orderByComparator)
		throws NoSuchDescriptiveinfoException;

	/**
	 * Removes all the descriptiveinfos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of descriptiveinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching descriptiveinfos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the descriptiveinfo where jobId = &#63; or throws a <code>NoSuchDescriptiveinfoException</code> if it could not be found.
	 *
	 * @param jobId the job ID
	 * @return the matching descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a matching descriptiveinfo could not be found
	 */
	public Descriptiveinfo findByjobId(long jobId)
		throws NoSuchDescriptiveinfoException;

	/**
	 * Returns the descriptiveinfo where jobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param jobId the job ID
	 * @return the matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	public Descriptiveinfo fetchByjobId(long jobId);

	/**
	 * Returns the descriptiveinfo where jobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param jobId the job ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching descriptiveinfo, or <code>null</code> if a matching descriptiveinfo could not be found
	 */
	public Descriptiveinfo fetchByjobId(long jobId, boolean useFinderCache);

	/**
	 * Removes the descriptiveinfo where jobId = &#63; from the database.
	 *
	 * @param jobId the job ID
	 * @return the descriptiveinfo that was removed
	 */
	public Descriptiveinfo removeByjobId(long jobId)
		throws NoSuchDescriptiveinfoException;

	/**
	 * Returns the number of descriptiveinfos where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @return the number of matching descriptiveinfos
	 */
	public int countByjobId(long jobId);

	/**
	 * Caches the descriptiveinfo in the entity cache if it is enabled.
	 *
	 * @param descriptiveinfo the descriptiveinfo
	 */
	public void cacheResult(Descriptiveinfo descriptiveinfo);

	/**
	 * Caches the descriptiveinfos in the entity cache if it is enabled.
	 *
	 * @param descriptiveinfos the descriptiveinfos
	 */
	public void cacheResult(java.util.List<Descriptiveinfo> descriptiveinfos);

	/**
	 * Creates a new descriptiveinfo with the primary key. Does not add the descriptiveinfo to the database.
	 *
	 * @param descriptiveId the primary key for the new descriptiveinfo
	 * @return the new descriptiveinfo
	 */
	public Descriptiveinfo create(long descriptiveId);

	/**
	 * Removes the descriptiveinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo that was removed
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	public Descriptiveinfo remove(long descriptiveId)
		throws NoSuchDescriptiveinfoException;

	public Descriptiveinfo updateImpl(Descriptiveinfo descriptiveinfo);

	/**
	 * Returns the descriptiveinfo with the primary key or throws a <code>NoSuchDescriptiveinfoException</code> if it could not be found.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo
	 * @throws NoSuchDescriptiveinfoException if a descriptiveinfo with the primary key could not be found
	 */
	public Descriptiveinfo findByPrimaryKey(long descriptiveId)
		throws NoSuchDescriptiveinfoException;

	/**
	 * Returns the descriptiveinfo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo, or <code>null</code> if a descriptiveinfo with the primary key could not be found
	 */
	public Descriptiveinfo fetchByPrimaryKey(long descriptiveId);

	/**
	 * Returns all the descriptiveinfos.
	 *
	 * @return the descriptiveinfos
	 */
	public java.util.List<Descriptiveinfo> findAll();

	/**
	 * Returns a range of all the descriptiveinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @return the range of descriptiveinfos
	 */
	public java.util.List<Descriptiveinfo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the descriptiveinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of descriptiveinfos
	 */
	public java.util.List<Descriptiveinfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Descriptiveinfo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the descriptiveinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of descriptiveinfos
	 */
	public java.util.List<Descriptiveinfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Descriptiveinfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the descriptiveinfos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of descriptiveinfos.
	 *
	 * @return the number of descriptiveinfos
	 */
	public int countAll();

}