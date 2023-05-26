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

import com.intranet.exception.NoSuchGraduationException;
import com.intranet.model.Graduation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the graduation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GraduationUtil
 * @generated
 */
@ProviderType
public interface GraduationPersistence extends BasePersistence<Graduation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GraduationUtil} to access the graduation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the graduation in the entity cache if it is enabled.
	 *
	 * @param graduation the graduation
	 */
	public void cacheResult(Graduation graduation);

	/**
	 * Caches the graduations in the entity cache if it is enabled.
	 *
	 * @param graduations the graduations
	 */
	public void cacheResult(java.util.List<Graduation> graduations);

	/**
	 * Creates a new graduation with the primary key. Does not add the graduation to the database.
	 *
	 * @param graduationCode the primary key for the new graduation
	 * @return the new graduation
	 */
	public Graduation create(String graduationCode);

	/**
	 * Removes the graduation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation that was removed
	 * @throws NoSuchGraduationException if a graduation with the primary key could not be found
	 */
	public Graduation remove(String graduationCode)
		throws NoSuchGraduationException;

	public Graduation updateImpl(Graduation graduation);

	/**
	 * Returns the graduation with the primary key or throws a <code>NoSuchGraduationException</code> if it could not be found.
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation
	 * @throws NoSuchGraduationException if a graduation with the primary key could not be found
	 */
	public Graduation findByPrimaryKey(String graduationCode)
		throws NoSuchGraduationException;

	/**
	 * Returns the graduation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation, or <code>null</code> if a graduation with the primary key could not be found
	 */
	public Graduation fetchByPrimaryKey(String graduationCode);

	/**
	 * Returns all the graduations.
	 *
	 * @return the graduations
	 */
	public java.util.List<Graduation> findAll();

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
	public java.util.List<Graduation> findAll(int start, int end);

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
	public java.util.List<Graduation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Graduation>
			orderByComparator);

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
	public java.util.List<Graduation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Graduation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the graduations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of graduations.
	 *
	 * @return the number of graduations
	 */
	public int countAll();

}