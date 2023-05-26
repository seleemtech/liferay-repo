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
 * Provides a wrapper for {@link WorkTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkTypeLocalService
 * @generated
 */
public class WorkTypeLocalServiceWrapper
	implements ServiceWrapper<WorkTypeLocalService>, WorkTypeLocalService {

	public WorkTypeLocalServiceWrapper(
		WorkTypeLocalService workTypeLocalService) {

		_workTypeLocalService = workTypeLocalService;
	}

	@Override
	public void addWorkType(String workTypeName) {
		_workTypeLocalService.addWorkType(workTypeName);
	}

	/**
	 * Adds the work type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workType the work type
	 * @return the work type that was added
	 */
	@Override
	public com.prime.data.service.model.WorkType addWorkType(
		com.prime.data.service.model.WorkType workType) {

		return _workTypeLocalService.addWorkType(workType);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new work type with the primary key. Does not add the work type to the database.
	 *
	 * @param workTypeId the primary key for the new work type
	 * @return the new work type
	 */
	@Override
	public com.prime.data.service.model.WorkType createWorkType(
		long workTypeId) {

		return _workTypeLocalService.createWorkType(workTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workTypeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the work type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type that was removed
	 * @throws PortalException if a work type with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.WorkType deleteWorkType(long workTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workTypeLocalService.deleteWorkType(workTypeId);
	}

	/**
	 * Deletes the work type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workType the work type
	 * @return the work type that was removed
	 */
	@Override
	public com.prime.data.service.model.WorkType deleteWorkType(
		com.prime.data.service.model.WorkType workType) {

		return _workTypeLocalService.deleteWorkType(workType);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _workTypeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _workTypeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workTypeLocalService.dynamicQuery();
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

		return _workTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.WorkTypeModelImpl</code>.
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

		return _workTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.WorkTypeModelImpl</code>.
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

		return _workTypeLocalService.dynamicQuery(
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

		return _workTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.WorkType fetchWorkType(
		long workTypeId) {

		return _workTypeLocalService.fetchWorkType(workTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the work type with the primary key.
	 *
	 * @param workTypeId the primary key of the work type
	 * @return the work type
	 * @throws PortalException if a work type with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.WorkType getWorkType(long workTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workTypeLocalService.getWorkType(workTypeId);
	}

	/**
	 * Returns a range of all the work types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.WorkTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work types
	 * @param end the upper bound of the range of work types (not inclusive)
	 * @return the range of work types
	 */
	@Override
	public java.util.List<com.prime.data.service.model.WorkType> getWorkTypes(
		int start, int end) {

		return _workTypeLocalService.getWorkTypes(start, end);
	}

	/**
	 * Returns the number of work types.
	 *
	 * @return the number of work types
	 */
	@Override
	public int getWorkTypesCount() {
		return _workTypeLocalService.getWorkTypesCount();
	}

	/**
	 * Updates the work type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workType the work type
	 * @return the work type that was updated
	 */
	@Override
	public com.prime.data.service.model.WorkType updateWorkType(
		com.prime.data.service.model.WorkType workType) {

		return _workTypeLocalService.updateWorkType(workType);
	}

	@Override
	public WorkTypeLocalService getWrappedService() {
		return _workTypeLocalService;
	}

	@Override
	public void setWrappedService(WorkTypeLocalService workTypeLocalService) {
		_workTypeLocalService = workTypeLocalService;
	}

	private WorkTypeLocalService _workTypeLocalService;

}