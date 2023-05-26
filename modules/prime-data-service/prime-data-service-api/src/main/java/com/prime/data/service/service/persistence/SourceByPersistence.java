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

import com.prime.data.service.exception.NoSuchSourceByException;
import com.prime.data.service.model.SourceBy;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the source by service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SourceByUtil
 * @generated
 */
@ProviderType
public interface SourceByPersistence extends BasePersistence<SourceBy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SourceByUtil} to access the source by persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the source bies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching source bies
	 */
	public java.util.List<SourceBy> findByUuid(String uuid);

	/**
	 * Returns a range of all the source bies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @return the range of matching source bies
	 */
	public java.util.List<SourceBy> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the source bies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching source bies
	 */
	public java.util.List<SourceBy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SourceBy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the source bies where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching source bies
	 */
	public java.util.List<SourceBy> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SourceBy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first source by in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching source by
	 * @throws NoSuchSourceByException if a matching source by could not be found
	 */
	public SourceBy findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SourceBy>
				orderByComparator)
		throws NoSuchSourceByException;

	/**
	 * Returns the first source by in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching source by, or <code>null</code> if a matching source by could not be found
	 */
	public SourceBy fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SourceBy>
			orderByComparator);

	/**
	 * Returns the last source by in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching source by
	 * @throws NoSuchSourceByException if a matching source by could not be found
	 */
	public SourceBy findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SourceBy>
				orderByComparator)
		throws NoSuchSourceByException;

	/**
	 * Returns the last source by in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching source by, or <code>null</code> if a matching source by could not be found
	 */
	public SourceBy fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<SourceBy>
			orderByComparator);

	/**
	 * Returns the source bies before and after the current source by in the ordered set where uuid = &#63;.
	 *
	 * @param sourceId the primary key of the current source by
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next source by
	 * @throws NoSuchSourceByException if a source by with the primary key could not be found
	 */
	public SourceBy[] findByUuid_PrevAndNext(
			long sourceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<SourceBy>
				orderByComparator)
		throws NoSuchSourceByException;

	/**
	 * Removes all the source bies where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of source bies where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching source bies
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the source by in the entity cache if it is enabled.
	 *
	 * @param sourceBy the source by
	 */
	public void cacheResult(SourceBy sourceBy);

	/**
	 * Caches the source bies in the entity cache if it is enabled.
	 *
	 * @param sourceBies the source bies
	 */
	public void cacheResult(java.util.List<SourceBy> sourceBies);

	/**
	 * Creates a new source by with the primary key. Does not add the source by to the database.
	 *
	 * @param sourceId the primary key for the new source by
	 * @return the new source by
	 */
	public SourceBy create(long sourceId);

	/**
	 * Removes the source by with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sourceId the primary key of the source by
	 * @return the source by that was removed
	 * @throws NoSuchSourceByException if a source by with the primary key could not be found
	 */
	public SourceBy remove(long sourceId) throws NoSuchSourceByException;

	public SourceBy updateImpl(SourceBy sourceBy);

	/**
	 * Returns the source by with the primary key or throws a <code>NoSuchSourceByException</code> if it could not be found.
	 *
	 * @param sourceId the primary key of the source by
	 * @return the source by
	 * @throws NoSuchSourceByException if a source by with the primary key could not be found
	 */
	public SourceBy findByPrimaryKey(long sourceId)
		throws NoSuchSourceByException;

	/**
	 * Returns the source by with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sourceId the primary key of the source by
	 * @return the source by, or <code>null</code> if a source by with the primary key could not be found
	 */
	public SourceBy fetchByPrimaryKey(long sourceId);

	/**
	 * Returns all the source bies.
	 *
	 * @return the source bies
	 */
	public java.util.List<SourceBy> findAll();

	/**
	 * Returns a range of all the source bies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @return the range of source bies
	 */
	public java.util.List<SourceBy> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the source bies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of source bies
	 */
	public java.util.List<SourceBy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SourceBy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the source bies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of source bies
	 */
	public java.util.List<SourceBy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SourceBy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the source bies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of source bies.
	 *
	 * @return the number of source bies
	 */
	public int countAll();

}