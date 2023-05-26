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

import Example.model.FirstTable;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FirstTable. This utility wraps
 * <code>Example.service.impl.FirstTableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FirstTableLocalService
 * @generated
 */
public class FirstTableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>Example.service.impl.FirstTableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the first table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FirstTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param firstTable the first table
	 * @return the first table that was added
	 */
	public static FirstTable addFirstTable(FirstTable firstTable) {
		return getService().addFirstTable(firstTable);
	}

	public static void addSecondTableFirstTable(
		long coId, FirstTable firstTable) {

		getService().addSecondTableFirstTable(coId, firstTable);
	}

	public static void addSecondTableFirstTable(long coId, long soId) {
		getService().addSecondTableFirstTable(coId, soId);
	}

	public static void addSecondTableFirstTables(
		long coId, List<FirstTable> firstTables) {

		getService().addSecondTableFirstTables(coId, firstTables);
	}

	public static void addSecondTableFirstTables(long coId, long[] soIds) {
		getService().addSecondTableFirstTables(coId, soIds);
	}

	public static void clearSecondTableFirstTables(long coId) {
		getService().clearSecondTableFirstTables(coId);
	}

	/**
	 * Creates a new first table with the primary key. Does not add the first table to the database.
	 *
	 * @param soId the primary key for the new first table
	 * @return the new first table
	 */
	public static FirstTable createFirstTable(long soId) {
		return getService().createFirstTable(soId);
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
	 * Deletes the first table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FirstTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param firstTable the first table
	 * @return the first table that was removed
	 */
	public static FirstTable deleteFirstTable(FirstTable firstTable) {
		return getService().deleteFirstTable(firstTable);
	}

	/**
	 * Deletes the first table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FirstTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param soId the primary key of the first table
	 * @return the first table that was removed
	 * @throws PortalException if a first table with the primary key could not be found
	 */
	public static FirstTable deleteFirstTable(long soId)
		throws PortalException {

		return getService().deleteFirstTable(soId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteSecondTableFirstTable(
		long coId, FirstTable firstTable) {

		getService().deleteSecondTableFirstTable(coId, firstTable);
	}

	public static void deleteSecondTableFirstTable(long coId, long soId) {
		getService().deleteSecondTableFirstTable(coId, soId);
	}

	public static void deleteSecondTableFirstTables(
		long coId, List<FirstTable> firstTables) {

		getService().deleteSecondTableFirstTables(coId, firstTables);
	}

	public static void deleteSecondTableFirstTables(long coId, long[] soIds) {
		getService().deleteSecondTableFirstTables(coId, soIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Example.model.impl.FirstTableModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Example.model.impl.FirstTableModelImpl</code>.
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

	public static FirstTable fetchFirstTable(long soId) {
		return getService().fetchFirstTable(soId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the first table with the primary key.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table
	 * @throws PortalException if a first table with the primary key could not be found
	 */
	public static FirstTable getFirstTable(long soId) throws PortalException {
		return getService().getFirstTable(soId);
	}

	/**
	 * Returns a range of all the first tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Example.model.impl.FirstTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of first tables
	 * @param end the upper bound of the range of first tables (not inclusive)
	 * @return the range of first tables
	 */
	public static List<FirstTable> getFirstTables(int start, int end) {
		return getService().getFirstTables(start, end);
	}

	/**
	 * Returns the number of first tables.
	 *
	 * @return the number of first tables
	 */
	public static int getFirstTablesCount() {
		return getService().getFirstTablesCount();
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

	public static List<FirstTable> getSecondTableFirstTables(long coId) {
		return getService().getSecondTableFirstTables(coId);
	}

	public static List<FirstTable> getSecondTableFirstTables(
		long coId, int start, int end) {

		return getService().getSecondTableFirstTables(coId, start, end);
	}

	public static List<FirstTable> getSecondTableFirstTables(
		long coId, int start, int end,
		OrderByComparator<FirstTable> orderByComparator) {

		return getService().getSecondTableFirstTables(
			coId, start, end, orderByComparator);
	}

	public static int getSecondTableFirstTablesCount(long coId) {
		return getService().getSecondTableFirstTablesCount(coId);
	}

	/**
	 * Returns the coIds of the second tables associated with the first table.
	 *
	 * @param soId the soId of the first table
	 * @return long[] the coIds of second tables associated with the first table
	 */
	public static long[] getSecondTablePrimaryKeys(long soId) {
		return getService().getSecondTablePrimaryKeys(soId);
	}

	public static boolean hasSecondTableFirstTable(long coId, long soId) {
		return getService().hasSecondTableFirstTable(coId, soId);
	}

	public static boolean hasSecondTableFirstTables(long coId) {
		return getService().hasSecondTableFirstTables(coId);
	}

	public static void setSecondTableFirstTables(long coId, long[] soIds) {
		getService().setSecondTableFirstTables(coId, soIds);
	}

	/**
	 * Updates the first table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FirstTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param firstTable the first table
	 * @return the first table that was updated
	 */
	public static FirstTable updateFirstTable(FirstTable firstTable) {
		return getService().updateFirstTable(firstTable);
	}

	public static FirstTableLocalService getService() {
		return _service;
	}

	private static volatile FirstTableLocalService _service;

}