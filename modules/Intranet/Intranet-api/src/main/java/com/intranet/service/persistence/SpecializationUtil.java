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

import com.intranet.model.Specialization;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the specialization service. This utility wraps <code>com.intranet.service.persistence.impl.SpecializationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpecializationPersistence
 * @generated
 */
public class SpecializationUtil {

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
	public static void clearCache(Specialization specialization) {
		getPersistence().clearCache(specialization);
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
	public static Map<Serializable, Specialization> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Specialization> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Specialization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Specialization> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Specialization> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Specialization update(Specialization specialization) {
		return getPersistence().update(specialization);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Specialization update(
		Specialization specialization, ServiceContext serviceContext) {

		return getPersistence().update(specialization, serviceContext);
	}

	/**
	 * Returns all the specializations where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @return the matching specializations
	 */
	public static List<Specialization> findBygraduationCode(
		String graduationCode) {

		return getPersistence().findBygraduationCode(graduationCode);
	}

	/**
	 * Returns a range of all the specializations where graduationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param graduationCode the graduation code
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @return the range of matching specializations
	 */
	public static List<Specialization> findBygraduationCode(
		String graduationCode, int start, int end) {

		return getPersistence().findBygraduationCode(
			graduationCode, start, end);
	}

	/**
	 * Returns an ordered range of all the specializations where graduationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param graduationCode the graduation code
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specializations
	 */
	public static List<Specialization> findBygraduationCode(
		String graduationCode, int start, int end,
		OrderByComparator<Specialization> orderByComparator) {

		return getPersistence().findBygraduationCode(
			graduationCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the specializations where graduationCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param graduationCode the graduation code
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching specializations
	 */
	public static List<Specialization> findBygraduationCode(
		String graduationCode, int start, int end,
		OrderByComparator<Specialization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBygraduationCode(
			graduationCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specialization
	 * @throws NoSuchSpecializationException if a matching specialization could not be found
	 */
	public static Specialization findBygraduationCode_First(
			String graduationCode,
			OrderByComparator<Specialization> orderByComparator)
		throws com.intranet.exception.NoSuchSpecializationException {

		return getPersistence().findBygraduationCode_First(
			graduationCode, orderByComparator);
	}

	/**
	 * Returns the first specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specialization, or <code>null</code> if a matching specialization could not be found
	 */
	public static Specialization fetchBygraduationCode_First(
		String graduationCode,
		OrderByComparator<Specialization> orderByComparator) {

		return getPersistence().fetchBygraduationCode_First(
			graduationCode, orderByComparator);
	}

	/**
	 * Returns the last specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specialization
	 * @throws NoSuchSpecializationException if a matching specialization could not be found
	 */
	public static Specialization findBygraduationCode_Last(
			String graduationCode,
			OrderByComparator<Specialization> orderByComparator)
		throws com.intranet.exception.NoSuchSpecializationException {

		return getPersistence().findBygraduationCode_Last(
			graduationCode, orderByComparator);
	}

	/**
	 * Returns the last specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specialization, or <code>null</code> if a matching specialization could not be found
	 */
	public static Specialization fetchBygraduationCode_Last(
		String graduationCode,
		OrderByComparator<Specialization> orderByComparator) {

		return getPersistence().fetchBygraduationCode_Last(
			graduationCode, orderByComparator);
	}

	/**
	 * Returns the specializations before and after the current specialization in the ordered set where graduationCode = &#63;.
	 *
	 * @param spCode the primary key of the current specialization
	 * @param graduationCode the graduation code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specialization
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	public static Specialization[] findBygraduationCode_PrevAndNext(
			long spCode, String graduationCode,
			OrderByComparator<Specialization> orderByComparator)
		throws com.intranet.exception.NoSuchSpecializationException {

		return getPersistence().findBygraduationCode_PrevAndNext(
			spCode, graduationCode, orderByComparator);
	}

	/**
	 * Removes all the specializations where graduationCode = &#63; from the database.
	 *
	 * @param graduationCode the graduation code
	 */
	public static void removeBygraduationCode(String graduationCode) {
		getPersistence().removeBygraduationCode(graduationCode);
	}

	/**
	 * Returns the number of specializations where graduationCode = &#63;.
	 *
	 * @param graduationCode the graduation code
	 * @return the number of matching specializations
	 */
	public static int countBygraduationCode(String graduationCode) {
		return getPersistence().countBygraduationCode(graduationCode);
	}

	/**
	 * Caches the specialization in the entity cache if it is enabled.
	 *
	 * @param specialization the specialization
	 */
	public static void cacheResult(Specialization specialization) {
		getPersistence().cacheResult(specialization);
	}

	/**
	 * Caches the specializations in the entity cache if it is enabled.
	 *
	 * @param specializations the specializations
	 */
	public static void cacheResult(List<Specialization> specializations) {
		getPersistence().cacheResult(specializations);
	}

	/**
	 * Creates a new specialization with the primary key. Does not add the specialization to the database.
	 *
	 * @param spCode the primary key for the new specialization
	 * @return the new specialization
	 */
	public static Specialization create(long spCode) {
		return getPersistence().create(spCode);
	}

	/**
	 * Removes the specialization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param spCode the primary key of the specialization
	 * @return the specialization that was removed
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	public static Specialization remove(long spCode)
		throws com.intranet.exception.NoSuchSpecializationException {

		return getPersistence().remove(spCode);
	}

	public static Specialization updateImpl(Specialization specialization) {
		return getPersistence().updateImpl(specialization);
	}

	/**
	 * Returns the specialization with the primary key or throws a <code>NoSuchSpecializationException</code> if it could not be found.
	 *
	 * @param spCode the primary key of the specialization
	 * @return the specialization
	 * @throws NoSuchSpecializationException if a specialization with the primary key could not be found
	 */
	public static Specialization findByPrimaryKey(long spCode)
		throws com.intranet.exception.NoSuchSpecializationException {

		return getPersistence().findByPrimaryKey(spCode);
	}

	/**
	 * Returns the specialization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param spCode the primary key of the specialization
	 * @return the specialization, or <code>null</code> if a specialization with the primary key could not be found
	 */
	public static Specialization fetchByPrimaryKey(long spCode) {
		return getPersistence().fetchByPrimaryKey(spCode);
	}

	/**
	 * Returns all the specializations.
	 *
	 * @return the specializations
	 */
	public static List<Specialization> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the specializations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @return the range of specializations
	 */
	public static List<Specialization> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the specializations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of specializations
	 */
	public static List<Specialization> findAll(
		int start, int end,
		OrderByComparator<Specialization> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the specializations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SpecializationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of specializations
	 * @param end the upper bound of the range of specializations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of specializations
	 */
	public static List<Specialization> findAll(
		int start, int end, OrderByComparator<Specialization> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the specializations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of specializations.
	 *
	 * @return the number of specializations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SpecializationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SpecializationPersistence _persistence;

}