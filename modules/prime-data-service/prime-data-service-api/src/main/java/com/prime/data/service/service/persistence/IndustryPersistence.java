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

import com.prime.data.service.exception.NoSuchIndustryException;
import com.prime.data.service.model.Industry;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the industry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IndustryUtil
 * @generated
 */
@ProviderType
public interface IndustryPersistence extends BasePersistence<Industry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IndustryUtil} to access the industry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the industries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching industries
	 */
	public java.util.List<Industry> findByUuid(String uuid);

	/**
	 * Returns a range of all the industries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @return the range of matching industries
	 */
	public java.util.List<Industry> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the industries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching industries
	 */
	public java.util.List<Industry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Industry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the industries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching industries
	 */
	public java.util.List<Industry> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Industry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first industry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching industry
	 * @throws NoSuchIndustryException if a matching industry could not be found
	 */
	public Industry findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Industry>
				orderByComparator)
		throws NoSuchIndustryException;

	/**
	 * Returns the first industry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching industry, or <code>null</code> if a matching industry could not be found
	 */
	public Industry fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Industry>
			orderByComparator);

	/**
	 * Returns the last industry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching industry
	 * @throws NoSuchIndustryException if a matching industry could not be found
	 */
	public Industry findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Industry>
				orderByComparator)
		throws NoSuchIndustryException;

	/**
	 * Returns the last industry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching industry, or <code>null</code> if a matching industry could not be found
	 */
	public Industry fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Industry>
			orderByComparator);

	/**
	 * Returns the industries before and after the current industry in the ordered set where uuid = &#63;.
	 *
	 * @param industryId the primary key of the current industry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next industry
	 * @throws NoSuchIndustryException if a industry with the primary key could not be found
	 */
	public Industry[] findByUuid_PrevAndNext(
			long industryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Industry>
				orderByComparator)
		throws NoSuchIndustryException;

	/**
	 * Removes all the industries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of industries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching industries
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the industry in the entity cache if it is enabled.
	 *
	 * @param industry the industry
	 */
	public void cacheResult(Industry industry);

	/**
	 * Caches the industries in the entity cache if it is enabled.
	 *
	 * @param industries the industries
	 */
	public void cacheResult(java.util.List<Industry> industries);

	/**
	 * Creates a new industry with the primary key. Does not add the industry to the database.
	 *
	 * @param industryId the primary key for the new industry
	 * @return the new industry
	 */
	public Industry create(long industryId);

	/**
	 * Removes the industry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry that was removed
	 * @throws NoSuchIndustryException if a industry with the primary key could not be found
	 */
	public Industry remove(long industryId) throws NoSuchIndustryException;

	public Industry updateImpl(Industry industry);

	/**
	 * Returns the industry with the primary key or throws a <code>NoSuchIndustryException</code> if it could not be found.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry
	 * @throws NoSuchIndustryException if a industry with the primary key could not be found
	 */
	public Industry findByPrimaryKey(long industryId)
		throws NoSuchIndustryException;

	/**
	 * Returns the industry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param industryId the primary key of the industry
	 * @return the industry, or <code>null</code> if a industry with the primary key could not be found
	 */
	public Industry fetchByPrimaryKey(long industryId);

	/**
	 * Returns all the industries.
	 *
	 * @return the industries
	 */
	public java.util.List<Industry> findAll();

	/**
	 * Returns a range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @return the range of industries
	 */
	public java.util.List<Industry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of industries
	 */
	public java.util.List<Industry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Industry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the industries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IndustryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of industries
	 * @param end the upper bound of the range of industries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of industries
	 */
	public java.util.List<Industry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Industry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the industries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of industries.
	 *
	 * @return the number of industries
	 */
	public int countAll();

}