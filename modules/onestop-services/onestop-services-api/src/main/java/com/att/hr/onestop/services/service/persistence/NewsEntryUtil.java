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

import com.att.hr.onestop.services.model.NewsEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the news entry service. This utility wraps <code>com.att.hr.onestop.services.service.persistence.impl.NewsEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsEntryPersistence
 * @generated
 */
public class NewsEntryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(NewsEntry newsEntry) {
		getPersistence().clearCache(newsEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, NewsEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NewsEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NewsEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NewsEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static NewsEntry update(NewsEntry newsEntry) {
		return getPersistence().update(newsEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static NewsEntry update(
		NewsEntry newsEntry, ServiceContext serviceContext) {

		return getPersistence().update(newsEntry, serviceContext);
	}

	/**
	 * Returns all the news entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching news entries
	 */
	public static List<NewsEntry> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<NewsEntry> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<NewsEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<NewsEntry> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public static NewsEntry findByGroupId_First(
			long groupId, OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public static NewsEntry fetchByGroupId_First(
		long groupId, OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public static NewsEntry findByGroupId_Last(
			long groupId, OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public static NewsEntry fetchByGroupId_Last(
		long groupId, OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where groupId = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public static NewsEntry[] findByGroupId_PrevAndNext(
			long newsEntryId, long groupId,
			OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByGroupId_PrevAndNext(
			newsEntryId, groupId, orderByComparator);
	}

	/**
	 * Removes all the news entries where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of news entries where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching news entries
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the news entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching news entries
	 */
	public static List<NewsEntry> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static List<NewsEntry> findByCompanyId(
		long companyId, int start, int end) {

		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static List<NewsEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator);
	}

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
	public static List<NewsEntry> findByCompanyId(
		long companyId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCompanyId(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public static NewsEntry findByCompanyId_First(
			long companyId, OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the first news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public static NewsEntry fetchByCompanyId_First(
		long companyId, OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().fetchByCompanyId_First(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public static NewsEntry findByCompanyId_Last(
			long companyId, OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the last news entry in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public static NewsEntry fetchByCompanyId_Last(
		long companyId, OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().fetchByCompanyId_Last(
			companyId, orderByComparator);
	}

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where companyId = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public static NewsEntry[] findByCompanyId_PrevAndNext(
			long newsEntryId, long companyId,
			OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByCompanyId_PrevAndNext(
			newsEntryId, companyId, orderByComparator);
	}

	/**
	 * Removes all the news entries where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	 * Returns the number of news entries where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching news entries
	 */
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	 * Returns all the news entries where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @return the matching news entries
	 */
	public static List<NewsEntry> findByNewsScopeId(long newsScopeId) {
		return getPersistence().findByNewsScopeId(newsScopeId);
	}

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
	public static List<NewsEntry> findByNewsScopeId(
		long newsScopeId, int start, int end) {

		return getPersistence().findByNewsScopeId(newsScopeId, start, end);
	}

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
	public static List<NewsEntry> findByNewsScopeId(
		long newsScopeId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().findByNewsScopeId(
			newsScopeId, start, end, orderByComparator);
	}

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
	public static List<NewsEntry> findByNewsScopeId(
		long newsScopeId, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByNewsScopeId(
			newsScopeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public static NewsEntry findByNewsScopeId_First(
			long newsScopeId, OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByNewsScopeId_First(
			newsScopeId, orderByComparator);
	}

	/**
	 * Returns the first news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public static NewsEntry fetchByNewsScopeId_First(
		long newsScopeId, OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().fetchByNewsScopeId_First(
			newsScopeId, orderByComparator);
	}

	/**
	 * Returns the last news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public static NewsEntry findByNewsScopeId_Last(
			long newsScopeId, OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByNewsScopeId_Last(
			newsScopeId, orderByComparator);
	}

	/**
	 * Returns the last news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public static NewsEntry fetchByNewsScopeId_Last(
		long newsScopeId, OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().fetchByNewsScopeId_Last(
			newsScopeId, orderByComparator);
	}

	/**
	 * Returns the news entries before and after the current news entry in the ordered set where newsScopeId = &#63;.
	 *
	 * @param newsEntryId the primary key of the current news entry
	 * @param newsScopeId the news scope ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public static NewsEntry[] findByNewsScopeId_PrevAndNext(
			long newsEntryId, long newsScopeId,
			OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByNewsScopeId_PrevAndNext(
			newsEntryId, newsScopeId, orderByComparator);
	}

	/**
	 * Removes all the news entries where newsScopeId = &#63; from the database.
	 *
	 * @param newsScopeId the news scope ID
	 */
	public static void removeByNewsScopeId(long newsScopeId) {
		getPersistence().removeByNewsScopeId(newsScopeId);
	}

	/**
	 * Returns the number of news entries where newsScopeId = &#63;.
	 *
	 * @param newsScopeId the news scope ID
	 * @return the number of matching news entries
	 */
	public static int countByNewsScopeId(long newsScopeId) {
		return getPersistence().countByNewsScopeId(newsScopeId);
	}

	/**
	 * Returns all the news entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching news entries
	 */
	public static List<NewsEntry> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

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
	public static List<NewsEntry> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

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
	public static List<NewsEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

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
	public static List<NewsEntry> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<NewsEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public static NewsEntry findByG_S_First(
			long groupId, int status,
			OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public static NewsEntry fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry
	 * @throws NoSuchNewsEntryException if a matching news entry could not be found
	 */
	public static NewsEntry findByG_S_Last(
			long groupId, int status,
			OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last news entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching news entry, or <code>null</code> if a matching news entry could not be found
	 */
	public static NewsEntry fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

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
	public static NewsEntry[] findByG_S_PrevAndNext(
			long newsEntryId, long groupId, int status,
			OrderByComparator<NewsEntry> orderByComparator)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByG_S_PrevAndNext(
			newsEntryId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the news entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of news entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching news entries
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Caches the news entry in the entity cache if it is enabled.
	 *
	 * @param newsEntry the news entry
	 */
	public static void cacheResult(NewsEntry newsEntry) {
		getPersistence().cacheResult(newsEntry);
	}

	/**
	 * Caches the news entries in the entity cache if it is enabled.
	 *
	 * @param newsEntries the news entries
	 */
	public static void cacheResult(List<NewsEntry> newsEntries) {
		getPersistence().cacheResult(newsEntries);
	}

	/**
	 * Creates a new news entry with the primary key. Does not add the news entry to the database.
	 *
	 * @param newsEntryId the primary key for the new news entry
	 * @return the new news entry
	 */
	public static NewsEntry create(long newsEntryId) {
		return getPersistence().create(newsEntryId);
	}

	/**
	 * Removes the news entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry that was removed
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public static NewsEntry remove(long newsEntryId)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().remove(newsEntryId);
	}

	public static NewsEntry updateImpl(NewsEntry newsEntry) {
		return getPersistence().updateImpl(newsEntry);
	}

	/**
	 * Returns the news entry with the primary key or throws a <code>NoSuchNewsEntryException</code> if it could not be found.
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry
	 * @throws NoSuchNewsEntryException if a news entry with the primary key could not be found
	 */
	public static NewsEntry findByPrimaryKey(long newsEntryId)
		throws com.att.hr.onestop.services.exception.NoSuchNewsEntryException {

		return getPersistence().findByPrimaryKey(newsEntryId);
	}

	/**
	 * Returns the news entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsEntryId the primary key of the news entry
	 * @return the news entry, or <code>null</code> if a news entry with the primary key could not be found
	 */
	public static NewsEntry fetchByPrimaryKey(long newsEntryId) {
		return getPersistence().fetchByPrimaryKey(newsEntryId);
	}

	/**
	 * Returns all the news entries.
	 *
	 * @return the news entries
	 */
	public static List<NewsEntry> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<NewsEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<NewsEntry> findAll(
		int start, int end, OrderByComparator<NewsEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<NewsEntry> findAll(
		int start, int end, OrderByComparator<NewsEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the news entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of news entries.
	 *
	 * @return the number of news entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NewsEntryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile NewsEntryPersistence _persistence;

}