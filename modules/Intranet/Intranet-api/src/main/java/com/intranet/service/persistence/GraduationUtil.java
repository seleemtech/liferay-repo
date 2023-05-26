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

package com.intranet.service.persistence;

import com.intranet.model.Graduation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the graduation service. This utility wraps <code>com.intranet.service.persistence.impl.GraduationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GraduationPersistence
 * @generated
 */
public class GraduationUtil {

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
	public static void clearCache(Graduation graduation) {
		getPersistence().clearCache(graduation);
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
	public static Map<Serializable, Graduation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Graduation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Graduation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Graduation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Graduation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Graduation update(Graduation graduation) {
		return getPersistence().update(graduation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Graduation update(
		Graduation graduation, ServiceContext serviceContext) {

		return getPersistence().update(graduation, serviceContext);
	}

	/**
	 * Caches the graduation in the entity cache if it is enabled.
	 *
	 * @param graduation the graduation
	 */
	public static void cacheResult(Graduation graduation) {
		getPersistence().cacheResult(graduation);
	}

	/**
	 * Caches the graduations in the entity cache if it is enabled.
	 *
	 * @param graduations the graduations
	 */
	public static void cacheResult(List<Graduation> graduations) {
		getPersistence().cacheResult(graduations);
	}

	/**
	 * Creates a new graduation with the primary key. Does not add the graduation to the database.
	 *
	 * @param graduationCode the primary key for the new graduation
	 * @return the new graduation
	 */
	public static Graduation create(String graduationCode) {
		return getPersistence().create(graduationCode);
	}

	/**
	 * Removes the graduation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation that was removed
	 * @throws NoSuchGraduationException if a graduation with the primary key could not be found
	 */
	public static Graduation remove(String graduationCode)
		throws com.intranet.exception.NoSuchGraduationException {

		return getPersistence().remove(graduationCode);
	}

	public static Graduation updateImpl(Graduation graduation) {
		return getPersistence().updateImpl(graduation);
	}

	/**
	 * Returns the graduation with the primary key or throws a <code>NoSuchGraduationException</code> if it could not be found.
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation
	 * @throws NoSuchGraduationException if a graduation with the primary key could not be found
	 */
	public static Graduation findByPrimaryKey(String graduationCode)
		throws com.intranet.exception.NoSuchGraduationException {

		return getPersistence().findByPrimaryKey(graduationCode);
	}

	/**
	 * Returns the graduation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation, or <code>null</code> if a graduation with the primary key could not be found
	 */
	public static Graduation fetchByPrimaryKey(String graduationCode) {
		return getPersistence().fetchByPrimaryKey(graduationCode);
	}

	/**
	 * Returns all the graduations.
	 *
	 * @return the graduations
	 */
	public static List<Graduation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the graduations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GraduationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of graduations
	 * @param end the upper bound of the range of graduations (not inclusive)
	 * @return the range of graduations
	 */
	public static List<Graduation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the graduations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GraduationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of graduations
	 * @param end the upper bound of the range of graduations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of graduations
	 */
	public static List<Graduation> findAll(
		int start, int end, OrderByComparator<Graduation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the graduations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GraduationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of graduations
	 * @param end the upper bound of the range of graduations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of graduations
	 */
	public static List<Graduation> findAll(
		int start, int end, OrderByComparator<Graduation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the graduations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of graduations.
	 *
	 * @return the number of graduations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GraduationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile GraduationPersistence _persistence;

}