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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FirstTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FirstTableLocalService
 * @generated
 */
public class FirstTableLocalServiceWrapper
	implements FirstTableLocalService, ServiceWrapper<FirstTableLocalService> {

	public FirstTableLocalServiceWrapper() {
		this(null);
	}

	public FirstTableLocalServiceWrapper(
		FirstTableLocalService firstTableLocalService) {

		_firstTableLocalService = firstTableLocalService;
	}

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
	@Override
	public Example.model.FirstTable addFirstTable(
		Example.model.FirstTable firstTable) {

		return _firstTableLocalService.addFirstTable(firstTable);
	}

	@Override
	public void addSecondTableFirstTable(
		long coId, Example.model.FirstTable firstTable) {

		_firstTableLocalService.addSecondTableFirstTable(coId, firstTable);
	}

	@Override
	public void addSecondTableFirstTable(long coId, long soId) {
		_firstTableLocalService.addSecondTableFirstTable(coId, soId);
	}

	@Override
	public void addSecondTableFirstTables(
		long coId, java.util.List<Example.model.FirstTable> firstTables) {

		_firstTableLocalService.addSecondTableFirstTables(coId, firstTables);
	}

	@Override
	public void addSecondTableFirstTables(long coId, long[] soIds) {
		_firstTableLocalService.addSecondTableFirstTables(coId, soIds);
	}

	@Override
	public void clearSecondTableFirstTables(long coId) {
		_firstTableLocalService.clearSecondTableFirstTables(coId);
	}

	/**
	 * Creates a new first table with the primary key. Does not add the first table to the database.
	 *
	 * @param soId the primary key for the new first table
	 * @return the new first table
	 */
	@Override
	public Example.model.FirstTable createFirstTable(long soId) {
		return _firstTableLocalService.createFirstTable(soId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firstTableLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public Example.model.FirstTable deleteFirstTable(
		Example.model.FirstTable firstTable) {

		return _firstTableLocalService.deleteFirstTable(firstTable);
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
	@Override
	public Example.model.FirstTable deleteFirstTable(long soId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firstTableLocalService.deleteFirstTable(soId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firstTableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteSecondTableFirstTable(
		long coId, Example.model.FirstTable firstTable) {

		_firstTableLocalService.deleteSecondTableFirstTable(coId, firstTable);
	}

	@Override
	public void deleteSecondTableFirstTable(long coId, long soId) {
		_firstTableLocalService.deleteSecondTableFirstTable(coId, soId);
	}

	@Override
	public void deleteSecondTableFirstTables(
		long coId, java.util.List<Example.model.FirstTable> firstTables) {

		_firstTableLocalService.deleteSecondTableFirstTables(coId, firstTables);
	}

	@Override
	public void deleteSecondTableFirstTables(long coId, long[] soIds) {
		_firstTableLocalService.deleteSecondTableFirstTables(coId, soIds);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _firstTableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _firstTableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _firstTableLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _firstTableLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _firstTableLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _firstTableLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _firstTableLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _firstTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public Example.model.FirstTable fetchFirstTable(long soId) {
		return _firstTableLocalService.fetchFirstTable(soId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _firstTableLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the first table with the primary key.
	 *
	 * @param soId the primary key of the first table
	 * @return the first table
	 * @throws PortalException if a first table with the primary key could not be found
	 */
	@Override
	public Example.model.FirstTable getFirstTable(long soId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firstTableLocalService.getFirstTable(soId);
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
	@Override
	public java.util.List<Example.model.FirstTable> getFirstTables(
		int start, int end) {

		return _firstTableLocalService.getFirstTables(start, end);
	}

	/**
	 * Returns the number of first tables.
	 *
	 * @return the number of first tables
	 */
	@Override
	public int getFirstTablesCount() {
		return _firstTableLocalService.getFirstTablesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _firstTableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _firstTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _firstTableLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<Example.model.FirstTable> getSecondTableFirstTables(
		long coId) {

		return _firstTableLocalService.getSecondTableFirstTables(coId);
	}

	@Override
	public java.util.List<Example.model.FirstTable> getSecondTableFirstTables(
		long coId, int start, int end) {

		return _firstTableLocalService.getSecondTableFirstTables(
			coId, start, end);
	}

	@Override
	public java.util.List<Example.model.FirstTable> getSecondTableFirstTables(
		long coId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<Example.model.FirstTable> orderByComparator) {

		return _firstTableLocalService.getSecondTableFirstTables(
			coId, start, end, orderByComparator);
	}

	@Override
	public int getSecondTableFirstTablesCount(long coId) {
		return _firstTableLocalService.getSecondTableFirstTablesCount(coId);
	}

	/**
	 * Returns the coIds of the second tables associated with the first table.
	 *
	 * @param soId the soId of the first table
	 * @return long[] the coIds of second tables associated with the first table
	 */
	@Override
	public long[] getSecondTablePrimaryKeys(long soId) {
		return _firstTableLocalService.getSecondTablePrimaryKeys(soId);
	}

	@Override
	public boolean hasSecondTableFirstTable(long coId, long soId) {
		return _firstTableLocalService.hasSecondTableFirstTable(coId, soId);
	}

	@Override
	public boolean hasSecondTableFirstTables(long coId) {
		return _firstTableLocalService.hasSecondTableFirstTables(coId);
	}

	@Override
	public void setSecondTableFirstTables(long coId, long[] soIds) {
		_firstTableLocalService.setSecondTableFirstTables(coId, soIds);
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
	@Override
	public Example.model.FirstTable updateFirstTable(
		Example.model.FirstTable firstTable) {

		return _firstTableLocalService.updateFirstTable(firstTable);
	}

	@Override
	public FirstTableLocalService getWrappedService() {
		return _firstTableLocalService;
	}

	@Override
	public void setWrappedService(
		FirstTableLocalService firstTableLocalService) {

		_firstTableLocalService = firstTableLocalService;
	}

	private FirstTableLocalService _firstTableLocalService;

}