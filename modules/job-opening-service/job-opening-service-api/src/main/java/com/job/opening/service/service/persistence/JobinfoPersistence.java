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

import com.job.opening.service.exception.NoSuchJobinfoException;
import com.job.opening.service.model.Jobinfo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the jobinfo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JobinfoUtil
 * @generated
 */
@ProviderType
public interface JobinfoPersistence extends BasePersistence<Jobinfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JobinfoUtil} to access the jobinfo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the jobinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching jobinfos
	 */
	public java.util.List<Jobinfo> findByUuid(String uuid);

	/**
	 * Returns a range of all the jobinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @return the range of matching jobinfos
	 */
	public java.util.List<Jobinfo> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the jobinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobinfos
	 */
	public java.util.List<Jobinfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the jobinfos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching jobinfos
	 */
	public java.util.List<Jobinfo> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first jobinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jobinfo
	 * @throws NoSuchJobinfoException if a matching jobinfo could not be found
	 */
	public Jobinfo findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
				orderByComparator)
		throws NoSuchJobinfoException;

	/**
	 * Returns the first jobinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public Jobinfo fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
			orderByComparator);

	/**
	 * Returns the last jobinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jobinfo
	 * @throws NoSuchJobinfoException if a matching jobinfo could not be found
	 */
	public Jobinfo findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
				orderByComparator)
		throws NoSuchJobinfoException;

	/**
	 * Returns the last jobinfo in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public Jobinfo fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
			orderByComparator);

	/**
	 * Returns the jobinfos before and after the current jobinfo in the ordered set where uuid = &#63;.
	 *
	 * @param jobId the primary key of the current jobinfo
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next jobinfo
	 * @throws NoSuchJobinfoException if a jobinfo with the primary key could not be found
	 */
	public Jobinfo[] findByUuid_PrevAndNext(
			long jobId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
				orderByComparator)
		throws NoSuchJobinfoException;

	/**
	 * Removes all the jobinfos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of jobinfos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching jobinfos
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the jobinfo where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchJobinfoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching jobinfo
	 * @throws NoSuchJobinfoException if a matching jobinfo could not be found
	 */
	public Jobinfo findByUUID_G(String uuid, long groupId)
		throws NoSuchJobinfoException;

	/**
	 * Returns the jobinfo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public Jobinfo fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the jobinfo where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public Jobinfo fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the jobinfo where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the jobinfo that was removed
	 */
	public Jobinfo removeByUUID_G(String uuid, long groupId)
		throws NoSuchJobinfoException;

	/**
	 * Returns the number of jobinfos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching jobinfos
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the jobinfos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching jobinfos
	 */
	public java.util.List<Jobinfo> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the jobinfos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @return the range of matching jobinfos
	 */
	public java.util.List<Jobinfo> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the jobinfos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching jobinfos
	 */
	public java.util.List<Jobinfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the jobinfos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching jobinfos
	 */
	public java.util.List<Jobinfo> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first jobinfo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jobinfo
	 * @throws NoSuchJobinfoException if a matching jobinfo could not be found
	 */
	public Jobinfo findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
				orderByComparator)
		throws NoSuchJobinfoException;

	/**
	 * Returns the first jobinfo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public Jobinfo fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
			orderByComparator);

	/**
	 * Returns the last jobinfo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jobinfo
	 * @throws NoSuchJobinfoException if a matching jobinfo could not be found
	 */
	public Jobinfo findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
				orderByComparator)
		throws NoSuchJobinfoException;

	/**
	 * Returns the last jobinfo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public Jobinfo fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
			orderByComparator);

	/**
	 * Returns the jobinfos before and after the current jobinfo in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param jobId the primary key of the current jobinfo
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next jobinfo
	 * @throws NoSuchJobinfoException if a jobinfo with the primary key could not be found
	 */
	public Jobinfo[] findByUuid_C_PrevAndNext(
			long jobId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
				orderByComparator)
		throws NoSuchJobinfoException;

	/**
	 * Removes all the jobinfos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of jobinfos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching jobinfos
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the jobinfo in the entity cache if it is enabled.
	 *
	 * @param jobinfo the jobinfo
	 */
	public void cacheResult(Jobinfo jobinfo);

	/**
	 * Caches the jobinfos in the entity cache if it is enabled.
	 *
	 * @param jobinfos the jobinfos
	 */
	public void cacheResult(java.util.List<Jobinfo> jobinfos);

	/**
	 * Creates a new jobinfo with the primary key. Does not add the jobinfo to the database.
	 *
	 * @param jobId the primary key for the new jobinfo
	 * @return the new jobinfo
	 */
	public Jobinfo create(long jobId);

	/**
	 * Removes the jobinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the jobinfo
	 * @return the jobinfo that was removed
	 * @throws NoSuchJobinfoException if a jobinfo with the primary key could not be found
	 */
	public Jobinfo remove(long jobId) throws NoSuchJobinfoException;

	public Jobinfo updateImpl(Jobinfo jobinfo);

	/**
	 * Returns the jobinfo with the primary key or throws a <code>NoSuchJobinfoException</code> if it could not be found.
	 *
	 * @param jobId the primary key of the jobinfo
	 * @return the jobinfo
	 * @throws NoSuchJobinfoException if a jobinfo with the primary key could not be found
	 */
	public Jobinfo findByPrimaryKey(long jobId) throws NoSuchJobinfoException;

	/**
	 * Returns the jobinfo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobId the primary key of the jobinfo
	 * @return the jobinfo, or <code>null</code> if a jobinfo with the primary key could not be found
	 */
	public Jobinfo fetchByPrimaryKey(long jobId);

	/**
	 * Returns all the jobinfos.
	 *
	 * @return the jobinfos
	 */
	public java.util.List<Jobinfo> findAll();

	/**
	 * Returns a range of all the jobinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @return the range of jobinfos
	 */
	public java.util.List<Jobinfo> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the jobinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jobinfos
	 */
	public java.util.List<Jobinfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
			orderByComparator);

	/**
	 * Returns an ordered range of all the jobinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of jobinfos
	 */
	public java.util.List<Jobinfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Jobinfo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the jobinfos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of jobinfos.
	 *
	 * @return the number of jobinfos
	 */
	public int countAll();

}