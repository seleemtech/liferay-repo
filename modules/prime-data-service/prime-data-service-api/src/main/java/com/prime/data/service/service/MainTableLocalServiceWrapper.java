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

package com.prime.data.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MainTableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MainTableLocalService
 * @generated
 */
public class MainTableLocalServiceWrapper
	implements MainTableLocalService, ServiceWrapper<MainTableLocalService> {

	public MainTableLocalServiceWrapper(
		MainTableLocalService mainTableLocalService) {

		_mainTableLocalService = mainTableLocalService;
	}

	/**
	 * Adds the main table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MainTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mainTable the main table
	 * @return the main table that was added
	 */
	@Override
	public com.prime.data.service.model.MainTable addMainTable(
		com.prime.data.service.model.MainTable mainTable) {

		return _mainTableLocalService.addMainTable(mainTable);
	}

	/**
	 * Creates a new main table with the primary key. Does not add the main table to the database.
	 *
	 * @param categoryId the primary key for the new main table
	 * @return the new main table
	 */
	@Override
	public com.prime.data.service.model.MainTable createMainTable(
		long categoryId) {

		return _mainTableLocalService.createMainTable(categoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mainTableLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the main table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MainTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table that was removed
	 * @throws PortalException if a main table with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.MainTable deleteMainTable(
			long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mainTableLocalService.deleteMainTable(categoryId);
	}

	/**
	 * Deletes the main table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MainTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mainTable the main table
	 * @return the main table that was removed
	 */
	@Override
	public com.prime.data.service.model.MainTable deleteMainTable(
		com.prime.data.service.model.MainTable mainTable) {

		return _mainTableLocalService.deleteMainTable(mainTable);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mainTableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _mainTableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _mainTableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mainTableLocalService.dynamicQuery();
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

		return _mainTableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.MainTableModelImpl</code>.
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

		return _mainTableLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.MainTableModelImpl</code>.
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

		return _mainTableLocalService.dynamicQuery(
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

		return _mainTableLocalService.dynamicQueryCount(dynamicQuery);
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

		return _mainTableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.MainTable fetchMainTable(
		long categoryId) {

		return _mainTableLocalService.fetchMainTable(categoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mainTableLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.prime.data.service.model.MainTable> getByCategory(
		String category) {

		return _mainTableLocalService.getByCategory(category);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mainTableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the main table with the primary key.
	 *
	 * @param categoryId the primary key of the main table
	 * @return the main table
	 * @throws PortalException if a main table with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.MainTable getMainTable(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mainTableLocalService.getMainTable(categoryId);
	}

	/**
	 * Returns a range of all the main tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.MainTableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of main tables
	 * @param end the upper bound of the range of main tables (not inclusive)
	 * @return the range of main tables
	 */
	@Override
	public java.util.List<com.prime.data.service.model.MainTable> getMainTables(
		int start, int end) {

		return _mainTableLocalService.getMainTables(start, end);
	}

	/**
	 * Returns the number of main tables.
	 *
	 * @return the number of main tables
	 */
	@Override
	public int getMainTablesCount() {
		return _mainTableLocalService.getMainTablesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mainTableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mainTableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the main table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MainTableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mainTable the main table
	 * @return the main table that was updated
	 */
	@Override
	public com.prime.data.service.model.MainTable updateMainTable(
		com.prime.data.service.model.MainTable mainTable) {

		return _mainTableLocalService.updateMainTable(mainTable);
	}

	@Override
	public MainTableLocalService getWrappedService() {
		return _mainTableLocalService;
	}

	@Override
	public void setWrappedService(MainTableLocalService mainTableLocalService) {
		_mainTableLocalService = mainTableLocalService;
	}

	private MainTableLocalService _mainTableLocalService;

}