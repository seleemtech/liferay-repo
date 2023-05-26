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

package com.fitness.club.service.service.persistence;

import com.fitness.club.service.model.Fitness;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the fitness service. This utility wraps <code>com.fitness.club.service.service.persistence.impl.FitnessPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FitnessPersistence
 * @generated
 */
public class FitnessUtil {

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
	public static void clearCache(Fitness fitness) {
		getPersistence().clearCache(fitness);
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
	public static Map<Serializable, Fitness> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Fitness> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Fitness> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Fitness> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Fitness> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Fitness update(Fitness fitness) {
		return getPersistence().update(fitness);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Fitness update(
		Fitness fitness, ServiceContext serviceContext) {

		return getPersistence().update(fitness, serviceContext);
	}

	/**
	 * Returns all the fitnesses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fitnesses
	 */
	public static List<Fitness> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the fitnesses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @return the range of matching fitnesses
	 */
	public static List<Fitness> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the fitnesses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching fitnesses
	 */
	public static List<Fitness> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Fitness> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fitnesses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching fitnesses
	 */
	public static List<Fitness> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Fitness> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness
	 * @throws NoSuchFitnessException if a matching fitness could not be found
	 */
	public static Fitness findByUuid_First(
			String uuid, OrderByComparator<Fitness> orderByComparator)
		throws com.fitness.club.service.exception.NoSuchFitnessException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness, or <code>null</code> if a matching fitness could not be found
	 */
	public static Fitness fetchByUuid_First(
		String uuid, OrderByComparator<Fitness> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness
	 * @throws NoSuchFitnessException if a matching fitness could not be found
	 */
	public static Fitness findByUuid_Last(
			String uuid, OrderByComparator<Fitness> orderByComparator)
		throws com.fitness.club.service.exception.NoSuchFitnessException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness, or <code>null</code> if a matching fitness could not be found
	 */
	public static Fitness fetchByUuid_Last(
		String uuid, OrderByComparator<Fitness> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the fitnesses before and after the current fitness in the ordered set where uuid = &#63;.
	 *
	 * @param trainerId the primary key of the current fitness
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fitness
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	public static Fitness[] findByUuid_PrevAndNext(
			long trainerId, String uuid,
			OrderByComparator<Fitness> orderByComparator)
		throws com.fitness.club.service.exception.NoSuchFitnessException {

		return getPersistence().findByUuid_PrevAndNext(
			trainerId, uuid, orderByComparator);
	}

	/**
	 * Removes all the fitnesses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of fitnesses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fitnesses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the fitness in the entity cache if it is enabled.
	 *
	 * @param fitness the fitness
	 */
	public static void cacheResult(Fitness fitness) {
		getPersistence().cacheResult(fitness);
	}

	/**
	 * Caches the fitnesses in the entity cache if it is enabled.
	 *
	 * @param fitnesses the fitnesses
	 */
	public static void cacheResult(List<Fitness> fitnesses) {
		getPersistence().cacheResult(fitnesses);
	}

	/**
	 * Creates a new fitness with the primary key. Does not add the fitness to the database.
	 *
	 * @param trainerId the primary key for the new fitness
	 * @return the new fitness
	 */
	public static Fitness create(long trainerId) {
		return getPersistence().create(trainerId);
	}

	/**
	 * Removes the fitness with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness that was removed
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	public static Fitness remove(long trainerId)
		throws com.fitness.club.service.exception.NoSuchFitnessException {

		return getPersistence().remove(trainerId);
	}

	public static Fitness updateImpl(Fitness fitness) {
		return getPersistence().updateImpl(fitness);
	}

	/**
	 * Returns the fitness with the primary key or throws a <code>NoSuchFitnessException</code> if it could not be found.
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	public static Fitness findByPrimaryKey(long trainerId)
		throws com.fitness.club.service.exception.NoSuchFitnessException {

		return getPersistence().findByPrimaryKey(trainerId);
	}

	/**
	 * Returns the fitness with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness, or <code>null</code> if a fitness with the primary key could not be found
	 */
	public static Fitness fetchByPrimaryKey(long trainerId) {
		return getPersistence().fetchByPrimaryKey(trainerId);
	}

	/**
	 * Returns all the fitnesses.
	 *
	 * @return the fitnesses
	 */
	public static List<Fitness> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the fitnesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @return the range of fitnesses
	 */
	public static List<Fitness> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the fitnesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fitnesses
	 */
	public static List<Fitness> findAll(
		int start, int end, OrderByComparator<Fitness> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the fitnesses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FitnessModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fitnesses
	 * @param end the upper bound of the range of fitnesses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of fitnesses
	 */
	public static List<Fitness> findAll(
		int start, int end, OrderByComparator<Fitness> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the fitnesses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of fitnesses.
	 *
	 * @return the number of fitnesses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FitnessPersistence getPersistence() {
		return _persistence;
	}

	private static volatile FitnessPersistence _persistence;

}