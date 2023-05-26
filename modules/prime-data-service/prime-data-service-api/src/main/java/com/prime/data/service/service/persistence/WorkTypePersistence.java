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

import com.prime.data.service.exception.NoSuchWorkTypeException;
import com.prime.data.service.model.WorkType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the work type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkTypeUtil
 * @generated
 */
@ProviderType
public interface WorkTypePersistence extends BasePersistence<WorkType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkTypeUtil} to access the work type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the work types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching work types
	 */
	public java.util.List<WorkType> findByUuid(String uuid);

	/**
	 * Returns a range of all the work types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @return the range of matching work types
	 */
	public java.util.List<WorkType> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the work types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching work types
	 */
	public java.util.List<WorkType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work types where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching work types
	 */
	public java.util.List<WorkType> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work type
	 * @throws NoSuchWorkTypeException if a matching work type could not be found
	 */
	public WorkType findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkType>
				orderByComparator)
		throws NoSuchWorkTypeException;

	/**
	 * Returns the first work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching work type, or <code>null</code> if a matching work type could not be found
	 */
	public WorkType fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkType>
			orderByComparator);

	/**
	 * Returns the last work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work type
	 * @throws NoSuchWorkTypeException if a matching work type could not be found
	 */
	public WorkType findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkType>
				orderByComparator)
		throws NoSuchWorkTypeException;

	/**
	 * Returns the last work type in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching work type, or <code>null</code> if a matching work type could not be found
	 */
	public WorkType fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<WorkType>
			orderByComparator);

	/**
	 * Returns the work types before and after the current work type in the ordered set where uuid = &#63;.
	 *
	 * @param workTypeId the primary key of the current work type
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next work type
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	public WorkType[] findByUuid_PrevAndNext(
			long workTypeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<WorkType>
				orderByComparator)
		throws NoSuchWorkTypeException;

	/**
	 * Removes all the work types where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of work types where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching work types
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the work type in the entity cache if it is enabled.
	 *
	 * @param workType the work type
	 */
	public void cacheResult(WorkType workType);

	/**
	 * Caches the work types in the entity cache if it is enabled.
	 *
	 * @param workTypes the work types
	 */
	public void cacheResult(java.util.List<WorkType> workTypes);

	/**
	 * Creates a new work type with the primary key. Does not add the work type to the database.
	 *
	 * @param workTypeId the primary key for the new work type
	 * @return the new work type
	 */
	public WorkType create(long workTypeId);

	/**
	 * Removes the work type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type that was removed
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	public WorkType remove(long workTypeId) throws NoSuchWorkTypeException;

	public WorkType updateImpl(WorkType workType);

	/**
	 * Returns the work type with the primary key or throws a <code>NoSuchWorkTypeException</code> if it could not be found.
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type
	 * @throws NoSuchWorkTypeException if a work type with the primary key could not be found
	 */
	public WorkType findByPrimaryKey(long workTypeId)
		throws NoSuchWorkTypeException;

	/**
	 * Returns the work type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type, or <code>null</code> if a work type with the primary key could not be found
	 */
	public WorkType fetchByPrimaryKey(long workTypeId);

	/**
	 * Returns all the work types.
	 *
	 * @return the work types
	 */
	public java.util.List<WorkType> findAll();

	/**
	 * Returns a range of all the work types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @return the range of work types
	 */
	public java.util.List<WorkType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the work types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of work types
	 */
	public java.util.List<WorkType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the work types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of work types
	 */
	public java.util.List<WorkType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<WorkType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the work types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of work types.
	 *
	 * @return the number of work types
	 */
	public int countAll();

}