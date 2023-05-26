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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.prime.data.service.model.CurrJobTitle;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the curr job title service. This utility wraps <code>com.prime.data.service.service.persistence.impl.CurrJobTitlePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CurrJobTitlePersistence
 * @generated
 */
public class CurrJobTitleUtil {

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
	public static void clearCache(CurrJobTitle currJobTitle) {
		getPersistence().clearCache(currJobTitle);
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
	public static Map<Serializable, CurrJobTitle> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CurrJobTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CurrJobTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CurrJobTitle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CurrJobTitle> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CurrJobTitle update(CurrJobTitle currJobTitle) {
		return getPersistence().update(currJobTitle);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CurrJobTitle update(
		CurrJobTitle currJobTitle, ServiceContext serviceContext) {

		return getPersistence().update(currJobTitle, serviceContext);
	}

	/**
	 * Returns all the curr job titles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching curr job titles
	 */
	public static List<CurrJobTitle> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<CurrJobTitle> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<CurrJobTitle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CurrJobTitle> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<CurrJobTitle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CurrJobTitle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curr job title
	 * @throws NoSuchCurrJobTitleException if a matching curr job title could not be found
	 */
	public static CurrJobTitle findByUuid_First(
			String uuid, OrderByComparator<CurrJobTitle> orderByComparator)
		throws com.prime.data.service.exception.NoSuchCurrJobTitleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching curr job title, or <code>null</code> if a matching curr job title could not be found
	 */
	public static CurrJobTitle fetchByUuid_First(
		String uuid, OrderByComparator<CurrJobTitle> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curr job title
	 * @throws NoSuchCurrJobTitleException if a matching curr job title could not be found
	 */
	public static CurrJobTitle findByUuid_Last(
			String uuid, OrderByComparator<CurrJobTitle> orderByComparator)
		throws com.prime.data.service.exception.NoSuchCurrJobTitleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching curr job title, or <code>null</code> if a matching curr job title could not be found
	 */
	public static CurrJobTitle fetchByUuid_Last(
		String uuid, OrderByComparator<CurrJobTitle> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the curr job titles before and after the current curr job title in the ordered set where uuid = &#63;.
	 *
	 * @param currJobTitleId the primary key of the current curr job title
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next curr job title
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	public static CurrJobTitle[] findByUuid_PrevAndNext(
			long currJobTitleId, String uuid,
			OrderByComparator<CurrJobTitle> orderByComparator)
		throws com.prime.data.service.exception.NoSuchCurrJobTitleException {

		return getPersistence().findByUuid_PrevAndNext(
			currJobTitleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the curr job titles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of curr job titles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching curr job titles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the curr job title in the entity cache if it is enabled.
	 *
	 * @param currJobTitle the curr job title
	 */
	public static void cacheResult(CurrJobTitle currJobTitle) {
		getPersistence().cacheResult(currJobTitle);
	}

	/**
	 * Caches the curr job titles in the entity cache if it is enabled.
	 *
	 * @param currJobTitles the curr job titles
	 */
	public static void cacheResult(List<CurrJobTitle> currJobTitles) {
		getPersistence().cacheResult(currJobTitles);
	}

	/**
	 * Creates a new curr job title with the primary key. Does not add the curr job title to the database.
	 *
	 * @param currJobTitleId the primary key for the new curr job title
	 * @return the new curr job title
	 */
	public static CurrJobTitle create(long currJobTitleId) {
		return getPersistence().create(currJobTitleId);
	}

	/**
	 * Removes the curr job title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title that was removed
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	public static CurrJobTitle remove(long currJobTitleId)
		throws com.prime.data.service.exception.NoSuchCurrJobTitleException {

		return getPersistence().remove(currJobTitleId);
	}

	public static CurrJobTitle updateImpl(CurrJobTitle currJobTitle) {
		return getPersistence().updateImpl(currJobTitle);
	}

	/**
	 * Returns the curr job title with the primary key or throws a <code>NoSuchCurrJobTitleException</code> if it could not be found.
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title
	 * @throws NoSuchCurrJobTitleException if a curr job title with the primary key could not be found
	 */
	public static CurrJobTitle findByPrimaryKey(long currJobTitleId)
		throws com.prime.data.service.exception.NoSuchCurrJobTitleException {

		return getPersistence().findByPrimaryKey(currJobTitleId);
	}

	/**
	 * Returns the curr job title with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title, or <code>null</code> if a curr job title with the primary key could not be found
	 */
	public static CurrJobTitle fetchByPrimaryKey(long currJobTitleId) {
		return getPersistence().fetchByPrimaryKey(currJobTitleId);
	}

	/**
	 * Returns all the curr job titles.
	 *
	 * @return the curr job titles
	 */
	public static List<CurrJobTitle> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CurrJobTitle> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CurrJobTitle> findAll(
		int start, int end, OrderByComparator<CurrJobTitle> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<CurrJobTitle> findAll(
		int start, int end, OrderByComparator<CurrJobTitle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the curr job titles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of curr job titles.
	 *
	 * @return the number of curr job titles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CurrJobTitlePersistence getPersistence() {
		return _persistence;
	}

	private static volatile CurrJobTitlePersistence _persistence;

}