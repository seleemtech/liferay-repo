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

import com.prime.data.service.exception.NoSuchPriorityException;
import com.prime.data.service.model.Priority;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the priority service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PriorityUtil
 * @generated
 */
@ProviderType
public interface PriorityPersistence extends BasePersistence<Priority> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PriorityUtil} to access the priority persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the priorities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching priorities
	 */
	public java.util.List<Priority> findByUuid(String uuid);

	/**
	 * Returns a range of all the priorities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @return the range of matching priorities
	 */
	public java.util.List<Priority> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the priorities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching priorities
	 */
	public java.util.List<Priority> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Priority>
			orderByComparator);

	/**
	 * Returns an ordered range of all the priorities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching priorities
	 */
	public java.util.List<Priority> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Priority>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching priority
	 * @throws NoSuchPriorityException if a matching priority could not be found
	 */
	public Priority findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Priority>
				orderByComparator)
		throws NoSuchPriorityException;

	/**
	 * Returns the first priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching priority, or <code>null</code> if a matching priority could not be found
	 */
	public Priority fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Priority>
			orderByComparator);

	/**
	 * Returns the last priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching priority
	 * @throws NoSuchPriorityException if a matching priority could not be found
	 */
	public Priority findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Priority>
				orderByComparator)
		throws NoSuchPriorityException;

	/**
	 * Returns the last priority in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching priority, or <code>null</code> if a matching priority could not be found
	 */
	public Priority fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Priority>
			orderByComparator);

	/**
	 * Returns the priorities before and after the current priority in the ordered set where uuid = &#63;.
	 *
	 * @param priorityId the primary key of the current priority
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next priority
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	public Priority[] findByUuid_PrevAndNext(
			long priorityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Priority>
				orderByComparator)
		throws NoSuchPriorityException;

	/**
	 * Removes all the priorities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of priorities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching priorities
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the priority in the entity cache if it is enabled.
	 *
	 * @param priority the priority
	 */
	public void cacheResult(Priority priority);

	/**
	 * Caches the priorities in the entity cache if it is enabled.
	 *
	 * @param priorities the priorities
	 */
	public void cacheResult(java.util.List<Priority> priorities);

	/**
	 * Creates a new priority with the primary key. Does not add the priority to the database.
	 *
	 * @param priorityId the primary key for the new priority
	 * @return the new priority
	 */
	public Priority create(long priorityId);

	/**
	 * Removes the priority with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param priorityId the primary key of the priority
	 * @return the priority that was removed
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	public Priority remove(long priorityId) throws NoSuchPriorityException;

	public Priority updateImpl(Priority priority);

	/**
	 * Returns the priority with the primary key or throws a <code>NoSuchPriorityException</code> if it could not be found.
	 *
	 * @param priorityId the primary key of the priority
	 * @return the priority
	 * @throws NoSuchPriorityException if a priority with the primary key could not be found
	 */
	public Priority findByPrimaryKey(long priorityId)
		throws NoSuchPriorityException;

	/**
	 * Returns the priority with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param priorityId the primary key of the priority
	 * @return the priority, or <code>null</code> if a priority with the primary key could not be found
	 */
	public Priority fetchByPrimaryKey(long priorityId);

	/**
	 * Returns all the priorities.
	 *
	 * @return the priorities
	 */
	public java.util.List<Priority> findAll();

	/**
	 * Returns a range of all the priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @return the range of priorities
	 */
	public java.util.List<Priority> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of priorities
	 */
	public java.util.List<Priority> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Priority>
			orderByComparator);

	/**
	 * Returns an ordered range of all the priorities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PriorityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of priorities
	 * @param end the upper bound of the range of priorities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of priorities
	 */
	public java.util.List<Priority> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Priority>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the priorities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of priorities.
	 *
	 * @return the number of priorities
	 */
	public int countAll();

}