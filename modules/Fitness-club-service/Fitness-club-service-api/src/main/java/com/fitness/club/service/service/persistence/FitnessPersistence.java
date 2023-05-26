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

import com.fitness.club.service.exception.NoSuchFitnessException;
import com.fitness.club.service.model.Fitness;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the fitness service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FitnessUtil
 * @generated
 */
@ProviderType
public interface FitnessPersistence extends BasePersistence<Fitness> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FitnessUtil} to access the fitness persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the fitnesses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching fitnesses
	 */
	public java.util.List<Fitness> findByUuid(String uuid);

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
	public java.util.List<Fitness> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Fitness> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Fitness>
			orderByComparator);

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
	public java.util.List<Fitness> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Fitness>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness
	 * @throws NoSuchFitnessException if a matching fitness could not be found
	 */
	public Fitness findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Fitness>
				orderByComparator)
		throws NoSuchFitnessException;

	/**
	 * Returns the first fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching fitness, or <code>null</code> if a matching fitness could not be found
	 */
	public Fitness fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Fitness>
			orderByComparator);

	/**
	 * Returns the last fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness
	 * @throws NoSuchFitnessException if a matching fitness could not be found
	 */
	public Fitness findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Fitness>
				orderByComparator)
		throws NoSuchFitnessException;

	/**
	 * Returns the last fitness in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching fitness, or <code>null</code> if a matching fitness could not be found
	 */
	public Fitness fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Fitness>
			orderByComparator);

	/**
	 * Returns the fitnesses before and after the current fitness in the ordered set where uuid = &#63;.
	 *
	 * @param trainerId the primary key of the current fitness
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next fitness
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	public Fitness[] findByUuid_PrevAndNext(
			long trainerId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Fitness>
				orderByComparator)
		throws NoSuchFitnessException;

	/**
	 * Removes all the fitnesses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of fitnesses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching fitnesses
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the fitness in the entity cache if it is enabled.
	 *
	 * @param fitness the fitness
	 */
	public void cacheResult(Fitness fitness);

	/**
	 * Caches the fitnesses in the entity cache if it is enabled.
	 *
	 * @param fitnesses the fitnesses
	 */
	public void cacheResult(java.util.List<Fitness> fitnesses);

	/**
	 * Creates a new fitness with the primary key. Does not add the fitness to the database.
	 *
	 * @param trainerId the primary key for the new fitness
	 * @return the new fitness
	 */
	public Fitness create(long trainerId);

	/**
	 * Removes the fitness with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness that was removed
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	public Fitness remove(long trainerId) throws NoSuchFitnessException;

	public Fitness updateImpl(Fitness fitness);

	/**
	 * Returns the fitness with the primary key or throws a <code>NoSuchFitnessException</code> if it could not be found.
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness
	 * @throws NoSuchFitnessException if a fitness with the primary key could not be found
	 */
	public Fitness findByPrimaryKey(long trainerId)
		throws NoSuchFitnessException;

	/**
	 * Returns the fitness with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainerId the primary key of the fitness
	 * @return the fitness, or <code>null</code> if a fitness with the primary key could not be found
	 */
	public Fitness fetchByPrimaryKey(long trainerId);

	/**
	 * Returns all the fitnesses.
	 *
	 * @return the fitnesses
	 */
	public java.util.List<Fitness> findAll();

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
	public java.util.List<Fitness> findAll(int start, int end);

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
	public java.util.List<Fitness> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Fitness>
			orderByComparator);

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
	public java.util.List<Fitness> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Fitness>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the fitnesses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of fitnesses.
	 *
	 * @return the number of fitnesses
	 */
	public int countAll();

}