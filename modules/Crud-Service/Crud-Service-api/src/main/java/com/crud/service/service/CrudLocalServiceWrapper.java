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

package com.crud.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CrudLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CrudLocalService
 * @generated
 */
public class CrudLocalServiceWrapper
	implements CrudLocalService, ServiceWrapper<CrudLocalService> {

	public CrudLocalServiceWrapper() {
		this(null);
	}

	public CrudLocalServiceWrapper(CrudLocalService crudLocalService) {
		_crudLocalService = crudLocalService;
	}

	/**
	 * Adds the crud to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrudLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crud the crud
	 * @return the crud that was added
	 */
	@Override
	public com.crud.service.model.Crud addCrud(
		com.crud.service.model.Crud crud) {

		return _crudLocalService.addCrud(crud);
	}

	@Override
	public com.crud.service.model.Crud addData(String crudName, long crudNo) {
		return _crudLocalService.addData(crudName, crudNo);
	}

	/**
	 * Creates a new crud with the primary key. Does not add the crud to the database.
	 *
	 * @param crudId the primary key for the new crud
	 * @return the new crud
	 */
	@Override
	public com.crud.service.model.Crud createCrud(long crudId) {
		return _crudLocalService.createCrud(crudId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crudLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the crud from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrudLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crud the crud
	 * @return the crud that was removed
	 */
	@Override
	public com.crud.service.model.Crud deleteCrud(
		com.crud.service.model.Crud crud) {

		return _crudLocalService.deleteCrud(crud);
	}

	/**
	 * Deletes the crud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrudLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud that was removed
	 * @throws PortalException if a crud with the primary key could not be found
	 */
	@Override
	public com.crud.service.model.Crud deleteCrud(long crudId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crudLocalService.deleteCrud(crudId);
	}

	@Override
	public com.crud.service.model.Crud deleteData(long crudId)
		throws com.crud.service.exception.NoSuchCrudException {

		return _crudLocalService.deleteData(crudId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crudLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _crudLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _crudLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _crudLocalService.dynamicQuery();
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

		return _crudLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.crud.service.model.impl.CrudModelImpl</code>.
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

		return _crudLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.crud.service.model.impl.CrudModelImpl</code>.
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

		return _crudLocalService.dynamicQuery(
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

		return _crudLocalService.dynamicQueryCount(dynamicQuery);
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

		return _crudLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.crud.service.model.Crud fetchCrud(long crudId) {
		return _crudLocalService.fetchCrud(crudId);
	}

	@Override
	public java.util.List<com.crud.service.model.Crud> findByName(
		String crudName) {

		return _crudLocalService.findByName(crudName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _crudLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.crud.service.model.Crud> getByCrudId(
		long crudId) {

		return _crudLocalService.getByCrudId(crudId);
	}

	@Override
	public java.util.List<com.crud.service.model.Crud> getByCrudNameAndCrudNo(
		String crudName, long crudNo) {

		return _crudLocalService.getByCrudNameAndCrudNo(crudName, crudNo);
	}

	/**
	 * Returns the crud with the primary key.
	 *
	 * @param crudId the primary key of the crud
	 * @return the crud
	 * @throws PortalException if a crud with the primary key could not be found
	 */
	@Override
	public com.crud.service.model.Crud getCrud(long crudId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crudLocalService.getCrud(crudId);
	}

	/**
	 * Returns a range of all the cruds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.crud.service.model.impl.CrudModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cruds
	 * @param end the upper bound of the range of cruds (not inclusive)
	 * @return the range of cruds
	 */
	@Override
	public java.util.List<com.crud.service.model.Crud> getCruds(
		int start, int end) {

		return _crudLocalService.getCruds(start, end);
	}

	/**
	 * Returns the number of cruds.
	 *
	 * @return the number of cruds
	 */
	@Override
	public int getCrudsCount() {
		return _crudLocalService.getCrudsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _crudLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _crudLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _crudLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the crud in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CrudLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param crud the crud
	 * @return the crud that was updated
	 */
	@Override
	public com.crud.service.model.Crud updateCrud(
		com.crud.service.model.Crud crud) {

		return _crudLocalService.updateCrud(crud);
	}

	@Override
	public com.crud.service.model.Crud updateData(
		long crudId, String crudName, long crudNo) {

		return _crudLocalService.updateData(crudId, crudName, crudNo);
	}

	@Override
	public CrudLocalService getWrappedService() {
		return _crudLocalService;
	}

	@Override
	public void setWrappedService(CrudLocalService crudLocalService) {
		_crudLocalService = crudLocalService;
	}

	private CrudLocalService _crudLocalService;

}