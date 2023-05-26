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

import com.intranet.model.ExperienceDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the experience details service. This utility wraps <code>com.intranet.service.persistence.impl.ExperienceDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExperienceDetailsPersistence
 * @generated
 */
public class ExperienceDetailsUtil {

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
	public static void clearCache(ExperienceDetails experienceDetails) {
		getPersistence().clearCache(experienceDetails);
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
	public static Map<Serializable, ExperienceDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ExperienceDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExperienceDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExperienceDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExperienceDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExperienceDetails update(
		ExperienceDetails experienceDetails) {

		return getPersistence().update(experienceDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExperienceDetails update(
		ExperienceDetails experienceDetails, ServiceContext serviceContext) {

		return getPersistence().update(experienceDetails, serviceContext);
	}

	/**
	 * Caches the experience details in the entity cache if it is enabled.
	 *
	 * @param experienceDetails the experience details
	 */
	public static void cacheResult(ExperienceDetails experienceDetails) {
		getPersistence().cacheResult(experienceDetails);
	}

	/**
	 * Caches the experience detailses in the entity cache if it is enabled.
	 *
	 * @param experienceDetailses the experience detailses
	 */
	public static void cacheResult(
		List<ExperienceDetails> experienceDetailses) {

		getPersistence().cacheResult(experienceDetailses);
	}

	/**
	 * Creates a new experience details with the primary key. Does not add the experience details to the database.
	 *
	 * @param experienceId the primary key for the new experience details
	 * @return the new experience details
	 */
	public static ExperienceDetails create(long experienceId) {
		return getPersistence().create(experienceId);
	}

	/**
	 * Removes the experience details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details that was removed
	 * @throws NoSuchExperienceDetailsException if a experience details with the primary key could not be found
	 */
	public static ExperienceDetails remove(long experienceId)
		throws com.intranet.exception.NoSuchExperienceDetailsException {

		return getPersistence().remove(experienceId);
	}

	public static ExperienceDetails updateImpl(
		ExperienceDetails experienceDetails) {

		return getPersistence().updateImpl(experienceDetails);
	}

	/**
	 * Returns the experience details with the primary key or throws a <code>NoSuchExperienceDetailsException</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details
	 * @throws NoSuchExperienceDetailsException if a experience details with the primary key could not be found
	 */
	public static ExperienceDetails findByPrimaryKey(long experienceId)
		throws com.intranet.exception.NoSuchExperienceDetailsException {

		return getPersistence().findByPrimaryKey(experienceId);
	}

	/**
	 * Returns the experience details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details, or <code>null</code> if a experience details with the primary key could not be found
	 */
	public static ExperienceDetails fetchByPrimaryKey(long experienceId) {
		return getPersistence().fetchByPrimaryKey(experienceId);
	}

	/**
	 * Returns all the experience detailses.
	 *
	 * @return the experience detailses
	 */
	public static List<ExperienceDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @return the range of experience detailses
	 */
	public static List<ExperienceDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of experience detailses
	 */
	public static List<ExperienceDetails> findAll(
		int start, int end,
		OrderByComparator<ExperienceDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of experience detailses
	 */
	public static List<ExperienceDetails> findAll(
		int start, int end,
		OrderByComparator<ExperienceDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the experience detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of experience detailses.
	 *
	 * @return the number of experience detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExperienceDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ExperienceDetailsPersistence _persistence;

}