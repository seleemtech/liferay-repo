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

import com.prime.data.service.exception.NoSuchCurrJobTitleException;
import com.prime.data.service.model.CurrJobTitle;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the curr job title service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CurrJobTitleUtil
 * @generated
 */
@ProviderType
public interface CurrJobTitlePersistence extends BasePersistence<CurrJobTitle> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CurrJobTitleUtil} to access the curr job title persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the curr job titles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching curr job titles
	 */
	public java.util.List<CurrJobTitle> findByUuid(String uuid);

	/**
	 * Returns a range of all the curr job titles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @return the range of matching curr job titles
	 */
	public java.util.List<CurrJobTitle> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the curr job titles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching curr job titles
	 */
	public java.util.List<CurrJobTitle> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CurrJobTitle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the curr job titles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching curr job titles
	 */
	public java.util.List<CurrJobTitle> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CurrJobTitle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curr job title
	 * @throws NoSuchCurrJobTitleException if a matching curr job title could not be found
	 */
	public CurrJobTitle findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CurrJobTitle>
				orderByComparator)
		throws NoSuchCurrJobTitleException;

	/**
	 * Returns the first curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curr job title, or <code>null</code> if a matching curr job title could not be found
	 */
	public CurrJobTitle fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CurrJobTitle>
			orderByComparator);

	/**
	 * Returns the last curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curr job title
	 * @throws NoSuchCurrJobTitleException if a matching curr job title could not be found
	 */
	public CurrJobTitle findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CurrJobTitle>
				orderByComparator)
		throws NoSuchCurrJobTitleException;

	/**
	 * Returns the last curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curr job title, or <code>null</code> if a matching curr job title could not be found
	 */
	public CurrJobTitle fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CurrJobTitle>
			orderByComparator);

	/**
	 * Returns the curr job titles before and after the current curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param currJobTitleId the primary key of the current curr job title
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next curr job title
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	public CurrJobTitle[] findByUuid_PrevAndNext(
			long currJobTitleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CurrJobTitle>
				orderByComparator)
		throws NoSuchCurrJobTitleException;

	/**
	 * Removes all the curr job titles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of curr job titles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching curr job titles
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the curr job title in the entity cache if it is enabled.
	 *
	 * @param currJobTitle the curr job title
	 */
	public void cacheResult(CurrJobTitle currJobTitle);

	/**
	 * Caches the curr job titles in the entity cache if it is enabled.
	 *
	 * @param currJobTitles the curr job titles
	 */
	public void cacheResult(java.util.List<CurrJobTitle> currJobTitles);

	/**
	 * Creates a new curr job title with the primary key. Does not add the curr job title to the database.
	 *
	 * @param currJobTitleId the primary key for the new curr job title
	 * @return the new curr job title
	 */
	public CurrJobTitle create(long currJobTitleId);

	/**
	 * Removes the curr job title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title that was removed
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	public CurrJobTitle remove(long currJobTitleId)
		throws NoSuchCurrJobTitleException;

	public CurrJobTitle updateImpl(CurrJobTitle currJobTitle);

	/**
	 * Returns the curr job title with the primary key or throws a <code>NoSuchCurrJobTitleException</code> if it could not be found.
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	public CurrJobTitle findByPrimaryKey(long currJobTitleId)
		throws NoSuchCurrJobTitleException;

	/**
	 * Returns the curr job title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title, or <code>null</code> if a curr job title with the primary key could not be found
	 */
	public CurrJobTitle fetchByPrimaryKey(long currJobTitleId);

	/**
	 * Returns all the curr job titles.
	 *
	 * @return the curr job titles
	 */
	public java.util.List<CurrJobTitle> findAll();

	/**
	 * Returns a range of all the curr job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @return the range of curr job titles
	 */
	public java.util.List<CurrJobTitle> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the curr job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of curr job titles
	 */
	public java.util.List<CurrJobTitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CurrJobTitle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the curr job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of curr job titles
	 */
	public java.util.List<CurrJobTitle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CurrJobTitle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the curr job titles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of curr job titles.
	 *
	 * @return the number of curr job titles
	 */
	public int countAll();

}