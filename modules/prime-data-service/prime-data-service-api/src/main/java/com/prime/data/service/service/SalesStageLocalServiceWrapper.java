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
 * Provides a wrapper for {@link SalesStageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SalesStageLocalService
 * @generated
 */
public class SalesStageLocalServiceWrapper
	implements SalesStageLocalService, ServiceWrapper<SalesStageLocalService> {

	public SalesStageLocalServiceWrapper(
		SalesStageLocalService salesStageLocalService) {

		_salesStageLocalService = salesStageLocalService;
	}

	/**
	 * Adds the sales stage to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesStageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesStage the sales stage
	 * @return the sales stage that was added
	 */
	@Override
	public com.prime.data.service.model.SalesStage addSalesStage(
		com.prime.data.service.model.SalesStage salesStage) {

		return _salesStageLocalService.addSalesStage(salesStage);
	}

	@Override
	public void addSalesStage(String saleStage) {
		_salesStageLocalService.addSalesStage(saleStage);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesStageLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new sales stage with the primary key. Does not add the sales stage to the database.
	 *
	 * @param salesStageId the primary key for the new sales stage
	 * @return the new sales stage
	 */
	@Override
	public com.prime.data.service.model.SalesStage createSalesStage(
		long salesStageId) {

		return _salesStageLocalService.createSalesStage(salesStageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesStageLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sales stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesStageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage that was removed
	 * @throws PortalException if a sales stage with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.SalesStage deleteSalesStage(
			long salesStageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesStageLocalService.deleteSalesStage(salesStageId);
	}

	/**
	 * Deletes the sales stage from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesStageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesStage the sales stage
	 * @return the sales stage that was removed
	 */
	@Override
	public com.prime.data.service.model.SalesStage deleteSalesStage(
		com.prime.data.service.model.SalesStage salesStage) {

		return _salesStageLocalService.deleteSalesStage(salesStage);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _salesStageLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _salesStageLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _salesStageLocalService.dynamicQuery();
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

		return _salesStageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.SalesStageModelImpl</code>.
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

		return _salesStageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.SalesStageModelImpl</code>.
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

		return _salesStageLocalService.dynamicQuery(
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

		return _salesStageLocalService.dynamicQueryCount(dynamicQuery);
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

		return _salesStageLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.SalesStage fetchSalesStage(
		long salesStageId) {

		return _salesStageLocalService.fetchSalesStage(salesStageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _salesStageLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _salesStageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _salesStageLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesStageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sales stage with the primary key.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage
	 * @throws PortalException if a sales stage with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.SalesStage getSalesStage(
			long salesStageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _salesStageLocalService.getSalesStage(salesStageId);
	}

	/**
	 * Returns a range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @return the range of sales stages
	 */
	@Override
	public java.util.List<com.prime.data.service.model.SalesStage>
		getSalesStages(int start, int end) {

		return _salesStageLocalService.getSalesStages(start, end);
	}

	/**
	 * Returns the number of sales stages.
	 *
	 * @return the number of sales stages
	 */
	@Override
	public int getSalesStagesCount() {
		return _salesStageLocalService.getSalesStagesCount();
	}

	/**
	 * Updates the sales stage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesStageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesStage the sales stage
	 * @return the sales stage that was updated
	 */
	@Override
	public com.prime.data.service.model.SalesStage updateSalesStage(
		com.prime.data.service.model.SalesStage salesStage) {

		return _salesStageLocalService.updateSalesStage(salesStage);
	}

	@Override
	public SalesStageLocalService getWrappedService() {
		return _salesStageLocalService;
	}

	@Override
	public void setWrappedService(
		SalesStageLocalService salesStageLocalService) {

		_salesStageLocalService = salesStageLocalService;
	}

	private SalesStageLocalService _salesStageLocalService;

}