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

import com.intranet.model.EducationDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the education details service. This utility wraps <code>com.intranet.service.persistence.impl.EducationDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EducationDetailsPersistence
 * @generated
 */
public class EducationDetailsUtil {

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
	public static void clearCache(EducationDetails educationDetails) {
		getPersistence().clearCache(educationDetails);
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
	public static Map<Serializable, EducationDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EducationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EducationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EducationDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EducationDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EducationDetails update(EducationDetails educationDetails) {
		return getPersistence().update(educationDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EducationDetails update(
		EducationDetails educationDetails, ServiceContext serviceContext) {

		return getPersistence().update(educationDetails, serviceContext);
	}

	/**
	 * Caches the education details in the entity cache if it is enabled.
	 *
	 * @param educationDetails the education details
	 */
	public static void cacheResult(EducationDetails educationDetails) {
		getPersistence().cacheResult(educationDetails);
	}

	/**
	 * Caches the education detailses in the entity cache if it is enabled.
	 *
	 * @param educationDetailses the education detailses
	 */
	public static void cacheResult(List<EducationDetails> educationDetailses) {
		getPersistence().cacheResult(educationDetailses);
	}

	/**
	 * Creates a new education details with the primary key. Does not add the education details to the database.
	 *
	 * @param educationId the primary key for the new education details
	 * @return the new education details
	 */
	public static EducationDetails create(long educationId) {
		return getPersistence().create(educationId);
	}

	/**
	 * Removes the education details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details that was removed
	 * @throws NoSuchEducationDetailsException if a education details with the primary key could not be found
	 */
	public static EducationDetails remove(long educationId)
		throws com.intranet.exception.NoSuchEducationDetailsException {

		return getPersistence().remove(educationId);
	}

	public static EducationDetails updateImpl(
		EducationDetails educationDetails) {

		return getPersistence().updateImpl(educationDetails);
	}

	/**
	 * Returns the education details with the primary key or throws a <code>NoSuchEducationDetailsException</code> if it could not be found.
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details
	 * @throws NoSuchEducationDetailsException if a education details with the primary key could not be found
	 */
	public static EducationDetails findByPrimaryKey(long educationId)
		throws com.intranet.exception.NoSuchEducationDetailsException {

		return getPersistence().findByPrimaryKey(educationId);
	}

	/**
	 * Returns the education details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details, or <code>null</code> if a education details with the primary key could not be found
	 */
	public static EducationDetails fetchByPrimaryKey(long educationId) {
		return getPersistence().fetchByPrimaryKey(educationId);
	}

	/**
	 * Returns all the education detailses.
	 *
	 * @return the education detailses
	 */
	public static List<EducationDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the education detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education detailses
	 * @param end the upper bound of the range of education detailses (not inclusive)
	 * @return the range of education detailses
	 */
	public static List<EducationDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the education detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education detailses
	 * @param end the upper bound of the range of education detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of education detailses
	 */
	public static List<EducationDetails> findAll(
		int start, int end,
		OrderByComparator<EducationDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the education detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education detailses
	 * @param end the upper bound of the range of education detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of education detailses
	 */
	public static List<EducationDetails> findAll(
		int start, int end,
		OrderByComparator<EducationDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the education detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of education detailses.
	 *
	 * @return the number of education detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EducationDetailsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile EducationDetailsPersistence _persistence;

}