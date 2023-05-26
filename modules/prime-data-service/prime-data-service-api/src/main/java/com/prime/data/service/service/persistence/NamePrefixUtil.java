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

import com.prime.data.service.model.NamePrefix;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the name prefix service. This utility wraps <code>com.prime.data.service.service.persistence.impl.NamePrefixPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NamePrefixPersistence
 * @generated
 */
public class NamePrefixUtil {

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
	public static void clearCache(NamePrefix namePrefix) {
		getPersistence().clearCache(namePrefix);
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
	public static Map<Serializable, NamePrefix> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NamePrefix> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NamePrefix> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NamePrefix> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<NamePrefix> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static NamePrefix update(NamePrefix namePrefix) {
		return getPersistence().update(namePrefix);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static NamePrefix update(
		NamePrefix namePrefix, ServiceContext serviceContext) {

		return getPersistence().update(namePrefix, serviceContext);
	}

	/**
	 * Returns all the name prefixes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching name prefixes
	 */
	public static List<NamePrefix> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<NamePrefix> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<NamePrefix> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NamePrefix> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<NamePrefix> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NamePrefix> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching name prefix
	 * @throws NoSuchNamePrefixException if a matching name prefix could not be found
	 */
	public static NamePrefix findByUuid_First(
			String uuid, OrderByComparator<NamePrefix> orderByComparator)
		throws com.prime.data.service.exception.NoSuchNamePrefixException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching name prefix, or <code>null</code> if a matching name prefix could not be found
	 */
	public static NamePrefix fetchByUuid_First(
		String uuid, OrderByComparator<NamePrefix> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching name prefix
	 * @throws NoSuchNamePrefixException if a matching name prefix could not be found
	 */
	public static NamePrefix findByUuid_Last(
			String uuid, OrderByComparator<NamePrefix> orderByComparator)
		throws com.prime.data.service.exception.NoSuchNamePrefixException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching name prefix, or <code>null</code> if a matching name prefix could not be found
	 */
	public static NamePrefix fetchByUuid_Last(
		String uuid, OrderByComparator<NamePrefix> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the name prefixes before and after the current name prefix in the ordered set where uuid = &#63;.
	 *
	 * @param namePrefixId the primary key of the current name prefix
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next name prefix
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	public static NamePrefix[] findByUuid_PrevAndNext(
			long namePrefixId, String uuid,
			OrderByComparator<NamePrefix> orderByComparator)
		throws com.prime.data.service.exception.NoSuchNamePrefixException {

		return getPersistence().findByUuid_PrevAndNext(
			namePrefixId, uuid, orderByComparator);
	}

	/**
	 * Removes all the name prefixes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of name prefixes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching name prefixes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the name prefix in the entity cache if it is enabled.
	 *
	 * @param namePrefix the name prefix
	 */
	public static void cacheResult(NamePrefix namePrefix) {
		getPersistence().cacheResult(namePrefix);
	}

	/**
	 * Caches the name prefixes in the entity cache if it is enabled.
	 *
	 * @param namePrefixes the name prefixes
	 */
	public static void cacheResult(List<NamePrefix> namePrefixes) {
		getPersistence().cacheResult(namePrefixes);
	}

	/**
	 * Creates a new name prefix with the primary key. Does not add the name prefix to the database.
	 *
	 * @param namePrefixId the primary key for the new name prefix
	 * @return the new name prefix
	 */
	public static NamePrefix create(long namePrefixId) {
		return getPersistence().create(namePrefixId);
	}

	/**
	 * Removes the name prefix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix that was removed
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	public static NamePrefix remove(long namePrefixId)
		throws com.prime.data.service.exception.NoSuchNamePrefixException {

		return getPersistence().remove(namePrefixId);
	}

	public static NamePrefix updateImpl(NamePrefix namePrefix) {
		return getPersistence().updateImpl(namePrefix);
	}

	/**
	 * Returns the name prefix with the primary key or throws a <code>NoSuchNamePrefixException</code> if it could not be found.
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix
	 * @throws NoSuchNamePrefixException if a name prefix with the primary key could not be found
	 */
	public static NamePrefix findByPrimaryKey(long namePrefixId)
		throws com.prime.data.service.exception.NoSuchNamePrefixException {

		return getPersistence().findByPrimaryKey(namePrefixId);
	}

	/**
	 * Returns the name prefix with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix, or <code>null</code> if a name prefix with the primary key could not be found
	 */
	public static NamePrefix fetchByPrimaryKey(long namePrefixId) {
		return getPersistence().fetchByPrimaryKey(namePrefixId);
	}

	/**
	 * Returns all the name prefixes.
	 *
	 * @return the name prefixes
	 */
	public static List<NamePrefix> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<NamePrefix> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<NamePrefix> findAll(
		int start, int end, OrderByComparator<NamePrefix> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<NamePrefix> findAll(
		int start, int end, OrderByComparator<NamePrefix> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the name prefixes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of name prefixes.
	 *
	 * @return the number of name prefixes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NamePrefixPersistence getPersistence() {
		return _persistence;
	}

	private static volatile NamePrefixPersistence _persistence;

}