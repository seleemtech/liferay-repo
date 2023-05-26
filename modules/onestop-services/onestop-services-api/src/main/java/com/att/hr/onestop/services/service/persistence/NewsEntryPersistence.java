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

package com.att.hr.onestop.services.service.persistence;

import com.att.hr.onestop.services.exception.NoSuchNewsEntryException;
import com.att.hr.onestop.services.model.NewsEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the news entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsEntryUtil
 * @generated
 */
@ProviderType
public interface NewsEntryPersistence extends BasePersistence<NewsEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsEntryUtil} to access the news entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the news entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching news entries
	 */
	public java.util.List<NewsEntry> findByGroupId(long groupId);

	/**
	 * Returns a range of all the news entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of matching news entries
	 */
	public java.util.List<NewsEntry> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the news entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching news entries
	 */
	public java.util.List<NewsEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news entries where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching news entries
	 */
	public java.util.List<NewsEntry> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public NewsEntry findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Returns the first news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public NewsEntry fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public NewsEntry findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public NewsEntry fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where groupId = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public NewsEntry[] findByGroupId_PrevAndNext(
			long newsEntryId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Removes all the news entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of news entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching news entries
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the news entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching news entries
	 */
	public java.util.List<NewsEntry> findByCompanyId(long companyId);

	/**
	 * Returns a range of all the news entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of matching news entries
	 */
	public java.util.List<NewsEntry> findByCompanyId(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the news entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching news entries
	 */
	public java.util.List<NewsEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news entries where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching news entries
	 */
	public java.util.List<NewsEntry> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public NewsEntry findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Returns the first news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public NewsEntry fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns the last news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public NewsEntry findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Returns the last news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public NewsEntry fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where companyId = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public NewsEntry[] findByCompanyId_PrevAndNext(
			long newsEntryId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Removes all the news entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of news entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching news entries
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the news entries where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @return the matching news entries
	 */
	public java.util.List<NewsEntry> findByNewsScopeId(long newsScopeId);

	/**
	 * Returns a range of all the news entries where newsScopeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param newsScopeId the news scope ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of matching news entries
	 */
	public java.util.List<NewsEntry> findByNewsScopeId(
		long newsScopeId, int start, int end);

	/**
	 * Returns an ordered range of all the news entries where newsScopeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param newsScopeId the news scope ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching news entries
	 */
	public java.util.List<NewsEntry> findByNewsScopeId(
		long newsScopeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news entries where newsScopeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param newsScopeId the news scope ID
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching news entries
	 */
	public java.util.List<NewsEntry> findByNewsScopeId(
		long newsScopeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public NewsEntry findByNewsScopeId_First(
			long newsScopeId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Returns the first news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public NewsEntry fetchByNewsScopeId_First(
		long newsScopeId,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns the last news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public NewsEntry findByNewsScopeId_Last(
			long newsScopeId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Returns the last news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public NewsEntry fetchByNewsScopeId_Last(
		long newsScopeId,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public NewsEntry[] findByNewsScopeId_PrevAndNext(
			long newsEntryId, long newsScopeId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Removes all the news entries where newsScopeId = &#63; from the database.
	 *
	 * @param newsScopeId the news scope ID
	 */
	public void removeByNewsScopeId(long newsScopeId);

	/**
	 * Returns the number of news entries where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @return the number of matching news entries
	 */
	public int countByNewsScopeId(long newsScopeId);

	/**
	 * Returns all the news entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching news entries
	 */
	public java.util.List<NewsEntry> findByG_S(long groupId, int status);

	/**
	 * Returns a range of all the news entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of matching news entries
	 */
	public java.util.List<NewsEntry> findByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the news entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching news entries
	 */
	public java.util.List<NewsEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching news entries
	 */
	public java.util.List<NewsEntry> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public NewsEntry findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Returns the first news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public NewsEntry fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public NewsEntry findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public NewsEntry fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public NewsEntry[] findByG_S_PrevAndNext(
			long newsEntryId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
				orderByComparator)
		throws NoSuchNewsEntryException;

	/**
	 * Removes all the news entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of news entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching news entries
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Caches the news entry in the entity cache if it is enabled.
	 *
	 * @param newsEntry the news entry
	 */
	public void cacheResult(NewsEntry newsEntry);

	/**
	 * Caches the news entries in the entity cache if it is enabled.
	 *
	 * @param newsEntries the news entries
	 */
	public void cacheResult(java.util.List<NewsEntry> newsEntries);

	/**
	 * Creates a new news entry with the primary key. Does not add the news entry to the database.
	 *
	 * @param newsEntryId the primary key for the new news entry
	 * @return the new news entry
	 */
	public NewsEntry create(long newsEntryId);

	/**
	 * Removes the news entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry that was removed
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public NewsEntry remove(long newsEntryId) throws NoSuchNewsEntryException;

	public NewsEntry updateImpl(NewsEntry newsEntry);

	/**
	 * Returns the news entry with the primary key or throws a <code>NoSuchNewsEntryException</code> if it could not be found.
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public NewsEntry findByPrimaryKey(long newsEntryId)
		throws NoSuchNewsEntryException;

	/**
	 * Returns the news entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry, or <code>null</code> if a news entry with the primary key could not be found
	 */
	public NewsEntry fetchByPrimaryKey(long newsEntryId);

	/**
	 * Returns all the news entries.
	 *
	 * @return the news entries
	 */
	public java.util.List<NewsEntry> findAll();

	/**
	 * Returns a range of all the news entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @return the range of news entries
	 */
	public java.util.List<NewsEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the news entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news entries
	 */
	public java.util.List<NewsEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news entries
	 * @param end the upper bound of the range of news entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news entries
	 */
	public java.util.List<NewsEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news entries.
	 *
	 * @return the number of news entries
	 */
	public int countAll();

}