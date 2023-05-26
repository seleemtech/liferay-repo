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

package Example.service;

import Example.model.SecondTable;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for SecondTable. This utility wraps
 * <code>Example.service.impl.SecondTableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SecondTableLocalService
 * @generated
 */
public class SecondTableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>Example.service.impl.SecondTableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addFirstTableSecondTable(long soId, long coId) {
		getService().addFirstTableSecondTable(soId, coId);
	}

	public static void addFirstTableSecondTable(
		long soId, SecondTable secondTable) {

		getService().addFirstTableSecondTable(soId, secondTable);
	}

	public static void addFirstTableSecondTables(
		long soId, List<SecondTable> secondTables) {

		getService().addFirstTableSecondTables(soId, secondTables);
	}

	public static void addFirstTableSecondTables(long soId, long[] coIds) {
		getService().addFirstTableSecondTables(soId, coIds);
	}

	/**
	 * Adds the second table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SecondTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param secondTable the second table
	 * @return the second table that was added
	 */
	public static SecondTable addSecondTable(SecondTable secondTable) {
		return getService().addSecondTable(secondTable);
	}

	public static void clearFirstTableSecondTables(long soId) {
		getService().clearFirstTableSecondTables(soId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new second table with the primary key. Does not add the second table to the database.
	 *
	 * @param coId the primary key for the new second table
	 * @return the new second table
	 */
	public static SecondTable createSecondTable(long coId) {
		return getService().createSecondTable(coId);
	}

	public static void deleteFirstTableSecondTable(long soId, long coId) {
		getService().deleteFirstTableSecondTable(soId, coId);
	}

	public static void deleteFirstTableSecondTable(
		long soId, SecondTable secondTable) {

		getService().deleteFirstTableSecondTable(soId, secondTable);
	}

	public static void deleteFirstTableSecondTables(
		long soId, List<SecondTable> secondTables) {

		getService().deleteFirstTableSecondTables(soId, secondTables);
	}

	public static void deleteFirstTableSecondTables(long soId, long[] coIds) {
		getService().deleteFirstTableSecondTables(soId, coIds);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the second table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SecondTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param coId the primary key of the second table
	 * @return the second table that was removed
	 * @throws PortalException if a second table with the primary key could not be found
	 */
	public static SecondTable deleteSecondTable(long coId)
		throws PortalException {

		return getService().deleteSecondTable(coId);
	}

	/**
	 * Deletes the second table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SecondTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param secondTable the second table
	 * @return the second table that was removed
	 */
	public static SecondTable deleteSecondTable(SecondTable secondTable) {
		return getService().deleteSecondTable(secondTable);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Example.model.impl.SecondTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Example.model.impl.SecondTableModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static SecondTable fetchSecondTable(long coId) {
		return getService().fetchSecondTable(coId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the soIds of the first tables associated with the second table.
	 *
	 * @param coId the coId of the second table
	 * @return long[] the soIds of first tables associated with the second table
	 */
	public static long[] getFirstTablePrimaryKeys(long coId) {
		return getService().getFirstTablePrimaryKeys(coId);
	}

	public static List<SecondTable> getFirstTableSecondTables(long soId) {
		return getService().getFirstTableSecondTables(soId);
	}

	public static List<SecondTable> getFirstTableSecondTables(
		long soId, int start, int end) {

		return getService().getFirstTableSecondTables(soId, start, end);
	}

	public static List<SecondTable> getFirstTableSecondTables(
		long soId, int start, int end,
		OrderByComparator<SecondTable> orderByComparator) {

		return getService().getFirstTableSecondTables(
			soId, start, end, orderByComparator);
	}

	public static int getFirstTableSecondTablesCount(long soId) {
		return getService().getFirstTableSecondTablesCount(soId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the second table with the primary key.
	 *
	 * @param coId the primary key of the second table
	 * @return the second table
	 * @throws PortalException if a second table with the primary key could not be found
	 */
	public static SecondTable getSecondTable(long coId) throws PortalException {
		return getService().getSecondTable(coId);
	}

	/**
	 * Returns a range of all the second tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Example.model.impl.SecondTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of second tables
	 * @param end the upper bound of the range of second tables (not inclusive)
	 * @return the range of second tables
	 */
	public static List<SecondTable> getSecondTables(int start, int end) {
		return getService().getSecondTables(start, end);
	}

	/**
	 * Returns the number of second tables.
	 *
	 * @return the number of second tables
	 */
	public static int getSecondTablesCount() {
		return getService().getSecondTablesCount();
	}

	public static boolean hasFirstTableSecondTable(long soId, long coId) {
		return getService().hasFirstTableSecondTable(soId, coId);
	}

	public static boolean hasFirstTableSecondTables(long soId) {
		return getService().hasFirstTableSecondTables(soId);
	}

	public static void setFirstTableSecondTables(long soId, long[] coIds) {
		getService().setFirstTableSecondTables(soId, coIds);
	}

	/**
	 * Updates the second table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SecondTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param secondTable the second table
	 * @return the second table that was updated
	 */
	public static SecondTable updateSecondTable(SecondTable secondTable) {
		return getService().updateSecondTable(secondTable);
	}

	public static SecondTableLocalService getService() {
		return _service;
	}

	private static volatile SecondTableLocalService _service;

}