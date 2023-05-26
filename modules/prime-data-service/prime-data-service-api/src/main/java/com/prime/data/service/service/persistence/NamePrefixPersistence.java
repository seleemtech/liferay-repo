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

import com.prime.data.service.exception.NoSuchNamePrefixException;
import com.prime.data.service.model.NamePrefix;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the name prefix service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NamePrefixUtil
 * @generated
 */
@ProviderType
public interface NamePrefixPersistence extends BasePersistence<NamePrefix> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NamePrefixUtil} to access the name prefix persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the name prefixes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching name prefixes
	 */
	public java.util.List<NamePrefix> findByUuid(String uuid);

	/**
	 * Returns a range of all the name prefixes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @return the range of matching name prefixes
	 */
	public java.util.List<NamePrefix> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the name prefixes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching name prefixes
	 */
	public java.util.List<NamePrefix> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NamePrefix>
			orderByComparator);

	/**
	 * Returns an ordered range of all the name prefixes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching name prefixes
	 */
	public java.util.List<NamePrefix> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NamePrefix>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching name prefix
	 * @throws NoSuchNamePrefixException if a matching name prefix could not be found
	 */
	public NamePrefix findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NamePrefix>
				orderByComparator)
		throws NoSuchNamePrefixException;

	/**
	 * Returns the first name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching name prefix, or <code>null</code> if a matching name prefix could not be found
	 */
	public NamePrefix fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NamePrefix>
			orderByComparator);

	/**
	 * Returns the last name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching name prefix
	 * @throws NoSuchNamePrefixException if a matching name prefix could not be found
	 */
	public NamePrefix findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NamePrefix>
				orderByComparator)
		throws NoSuchNamePrefixException;

	/**
	 * Returns the last name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching name prefix, or <code>null</code> if a matching name prefix could not be found
	 */
	public NamePrefix fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NamePrefix>
			orderByComparator);

	/**
	 * Returns the name prefixes before and after the current name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param namePrefixId the primary key of the current name prefix
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next name prefix
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	public NamePrefix[] findByUuid_PrevAndNext(
			long namePrefixId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NamePrefix>
				orderByComparator)
		throws NoSuchNamePrefixException;

	/**
	 * Removes all the name prefixes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of name prefixes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching name prefixes
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the name prefix in the entity cache if it is enabled.
	 *
	 * @param namePrefix the name prefix
	 */
	public void cacheResult(NamePrefix namePrefix);

	/**
	 * Caches the name prefixes in the entity cache if it is enabled.
	 *
	 * @param namePrefixes the name prefixes
	 */
	public void cacheResult(java.util.List<NamePrefix> namePrefixes);

	/**
	 * Creates a new name prefix with the primary key. Does not add the name prefix to the database.
	 *
	 * @param namePrefixId the primary key for the new name prefix
	 * @return the new name prefix
	 */
	public NamePrefix create(long namePrefixId);

	/**
	 * Removes the name prefix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix that was removed
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	public NamePrefix remove(long namePrefixId)
		throws NoSuchNamePrefixException;

	public NamePrefix updateImpl(NamePrefix namePrefix);

	/**
	 * Returns the name prefix with the primary key or throws a <code>NoSuchNamePrefixException</code> if it could not be found.
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	public NamePrefix findByPrimaryKey(long namePrefixId)
		throws NoSuchNamePrefixException;

	/**
	 * Returns the name prefix with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix, or <code>null</code> if a name prefix with the primary key could not be found
	 */
	public NamePrefix fetchByPrimaryKey(long namePrefixId);

	/**
	 * Returns all the name prefixes.
	 *
	 * @return the name prefixes
	 */
	public java.util.List<NamePrefix> findAll();

	/**
	 * Returns a range of all the name prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @return the range of name prefixes
	 */
	public java.util.List<NamePrefix> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the name prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of name prefixes
	 */
	public java.util.List<NamePrefix> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NamePrefix>
			orderByComparator);

	/**
	 * Returns an ordered range of all the name prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of name prefixes
	 */
	public java.util.List<NamePrefix> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NamePrefix>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the name prefixes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of name prefixes.
	 *
	 * @return the number of name prefixes
	 */
	public int countAll();

}