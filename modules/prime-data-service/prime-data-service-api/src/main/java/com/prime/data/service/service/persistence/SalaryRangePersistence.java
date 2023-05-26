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

package com.prime.data.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.prime.data.service.exception.NoSuchSalaryRangeException;
import com.prime.data.service.model.SalaryRange;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the salary range service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SalaryRangeUtil
 * @generated
 */
@ProviderType
public interface SalaryRangePersistence extends BasePersistence<SalaryRange> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SalaryRangeUtil} to access the salary range persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the salary ranges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching salary ranges
	 */
	public java.util.List<SalaryRange> findByUuid(String uuid);

	/**
	 * Returns a range of all the salary ranges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @return the range of matching salary ranges
	 */
	public java.util.List<SalaryRange> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the salary ranges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching salary ranges
	 */
	public java.util.List<SalaryRange> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalaryRange>
			orderByComparator);

	/**
	 * Returns an ordered range of all the salary ranges where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching salary ranges
	 */
	public java.util.List<SalaryRange> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalaryRange>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching salary range
	 * @throws NoSuchSalaryRangeException if a matching salary range could not be found
	 */
	public SalaryRange findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SalaryRange>
				orderByComparator)
		throws NoSuchSalaryRangeException;

	/**
	 * Returns the first salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching salary range, or <code>null</code> if a matching salary range could not be found
	 */
	public SalaryRange fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SalaryRange>
			orderByComparator);

	/**
	 * Returns the last salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching salary range
	 * @throws NoSuchSalaryRangeException if a matching salary range could not be found
	 */
	public SalaryRange findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SalaryRange>
				orderByComparator)
		throws NoSuchSalaryRangeException;

	/**
	 * Returns the last salary range in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching salary range, or <code>null</code> if a matching salary range could not be found
	 */
	public SalaryRange fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SalaryRange>
			orderByComparator);

	/**
	 * Returns the salary ranges before and after the current salary range in the ordered set where uuid = &#63;.
	 *
	 * @param salaryRangeId the primary key of the current salary range
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next salary range
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	public SalaryRange[] findByUuid_PrevAndNext(
			long salaryRangeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SalaryRange>
				orderByComparator)
		throws NoSuchSalaryRangeException;

	/**
	 * Removes all the salary ranges where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of salary ranges where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching salary ranges
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the salary range in the entity cache if it is enabled.
	 *
	 * @param salaryRange the salary range
	 */
	public void cacheResult(SalaryRange salaryRange);

	/**
	 * Caches the salary ranges in the entity cache if it is enabled.
	 *
	 * @param salaryRanges the salary ranges
	 */
	public void cacheResult(java.util.List<SalaryRange> salaryRanges);

	/**
	 * Creates a new salary range with the primary key. Does not add the salary range to the database.
	 *
	 * @param salaryRangeId the primary key for the new salary range
	 * @return the new salary range
	 */
	public SalaryRange create(long salaryRangeId);

	/**
	 * Removes the salary range with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param salaryRangeId the primary key of the salary range
	 * @return the salary range that was removed
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	public SalaryRange remove(long salaryRangeId)
		throws NoSuchSalaryRangeException;

	public SalaryRange updateImpl(SalaryRange salaryRange);

	/**
	 * Returns the salary range with the primary key or throws a <code>NoSuchSalaryRangeException</code> if it could not be found.
	 *
	 * @param salaryRangeId the primary key of the salary range
	 * @return the salary range
	 * @throws NoSuchSalaryRangeException if a salary range with the primary key could not be found
	 */
	public SalaryRange findByPrimaryKey(long salaryRangeId)
		throws NoSuchSalaryRangeException;

	/**
	 * Returns the salary range with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param salaryRangeId the primary key of the salary range
	 * @return the salary range, or <code>null</code> if a salary range with the primary key could not be found
	 */
	public SalaryRange fetchByPrimaryKey(long salaryRangeId);

	/**
	 * Returns all the salary ranges.
	 *
	 * @return the salary ranges
	 */
	public java.util.List<SalaryRange> findAll();

	/**
	 * Returns a range of all the salary ranges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @return the range of salary ranges
	 */
	public java.util.List<SalaryRange> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the salary ranges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of salary ranges
	 */
	public java.util.List<SalaryRange> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalaryRange>
			orderByComparator);

	/**
	 * Returns an ordered range of all the salary ranges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SalaryRangeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of salary ranges
	 * @param end the upper bound of the range of salary ranges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of salary ranges
	 */
	public java.util.List<SalaryRange> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SalaryRange>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the salary ranges from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of salary ranges.
	 *
	 * @return the number of salary ranges
	 */
	public int countAll();

}