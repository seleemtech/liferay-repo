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

import com.intranet.model.ComplaintBox;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the complaint box service. This utility wraps <code>com.intranet.service.persistence.impl.ComplaintBoxPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComplaintBoxPersistence
 * @generated
 */
public class ComplaintBoxUtil {

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
	public static void clearCache(ComplaintBox complaintBox) {
		getPersistence().clearCache(complaintBox);
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
	public static Map<Serializable, ComplaintBox> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ComplaintBox> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ComplaintBox> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ComplaintBox> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ComplaintBox> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ComplaintBox update(ComplaintBox complaintBox) {
		return getPersistence().update(complaintBox);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ComplaintBox update(
		ComplaintBox complaintBox, ServiceContext serviceContext) {

		return getPersistence().update(complaintBox, serviceContext);
	}

	/**
	 * Caches the complaint box in the entity cache if it is enabled.
	 *
	 * @param complaintBox the complaint box
	 */
	public static void cacheResult(ComplaintBox complaintBox) {
		getPersistence().cacheResult(complaintBox);
	}

	/**
	 * Caches the complaint boxes in the entity cache if it is enabled.
	 *
	 * @param complaintBoxes the complaint boxes
	 */
	public static void cacheResult(List<ComplaintBox> complaintBoxes) {
		getPersistence().cacheResult(complaintBoxes);
	}

	/**
	 * Creates a new complaint box with the primary key. Does not add the complaint box to the database.
	 *
	 * @param fooId the primary key for the new complaint box
	 * @return the new complaint box
	 */
	public static ComplaintBox create(long fooId) {
		return getPersistence().create(fooId);
	}

	/**
	 * Removes the complaint box with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box that was removed
	 * @throws NoSuchComplaintBoxException if a complaint box with the primary key could not be found
	 */
	public static ComplaintBox remove(long fooId)
		throws com.intranet.exception.NoSuchComplaintBoxException {

		return getPersistence().remove(fooId);
	}

	public static ComplaintBox updateImpl(ComplaintBox complaintBox) {
		return getPersistence().updateImpl(complaintBox);
	}

	/**
	 * Returns the complaint box with the primary key or throws a <code>NoSuchComplaintBoxException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box
	 * @throws NoSuchComplaintBoxException if a complaint box with the primary key could not be found
	 */
	public static ComplaintBox findByPrimaryKey(long fooId)
		throws com.intranet.exception.NoSuchComplaintBoxException {

		return getPersistence().findByPrimaryKey(fooId);
	}

	/**
	 * Returns the complaint box with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box, or <code>null</code> if a complaint box with the primary key could not be found
	 */
	public static ComplaintBox fetchByPrimaryKey(long fooId) {
		return getPersistence().fetchByPrimaryKey(fooId);
	}

	/**
	 * Returns all the complaint boxes.
	 *
	 * @return the complaint boxes
	 */
	public static List<ComplaintBox> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the complaint boxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComplaintBoxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint boxes
	 * @param end the upper bound of the range of complaint boxes (not inclusive)
	 * @return the range of complaint boxes
	 */
	public static List<ComplaintBox> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the complaint boxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComplaintBoxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint boxes
	 * @param end the upper bound of the range of complaint boxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of complaint boxes
	 */
	public static List<ComplaintBox> findAll(
		int start, int end, OrderByComparator<ComplaintBox> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the complaint boxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComplaintBoxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint boxes
	 * @param end the upper bound of the range of complaint boxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of complaint boxes
	 */
	public static List<ComplaintBox> findAll(
		int start, int end, OrderByComparator<ComplaintBox> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the complaint boxes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of complaint boxes.
	 *
	 * @return the number of complaint boxes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ComplaintBoxPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ComplaintBoxPersistence _persistence;

}