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
 * Provides a wrapper for {@link CurrJobTitleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CurrJobTitleLocalService
 * @generated
 */
public class CurrJobTitleLocalServiceWrapper
	implements CurrJobTitleLocalService,
			   ServiceWrapper<CurrJobTitleLocalService> {

	public CurrJobTitleLocalServiceWrapper(
		CurrJobTitleLocalService currJobTitleLocalService) {

		_currJobTitleLocalService = currJobTitleLocalService;
	}

	/**
	 * Adds the curr job title to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CurrJobTitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param currJobTitle the curr job title
	 * @return the curr job title that was added
	 */
	@Override
	public com.prime.data.service.model.CurrJobTitle addCurrJobTitle(
		com.prime.data.service.model.CurrJobTitle currJobTitle) {

		return _currJobTitleLocalService.addCurrJobTitle(currJobTitle);
	}

	@Override
	public void addCurrJobTitle(String currentJobTitle) {
		_currJobTitleLocalService.addCurrJobTitle(currentJobTitle);
	}

	/**
	 * Creates a new curr job title with the primary key. Does not add the curr job title to the database.
	 *
	 * @param currJobTitleId the primary key for the new curr job title
	 * @return the new curr job title
	 */
	@Override
	public com.prime.data.service.model.CurrJobTitle createCurrJobTitle(
		long currJobTitleId) {

		return _currJobTitleLocalService.createCurrJobTitle(currJobTitleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currJobTitleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the curr job title from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CurrJobTitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param currJobTitle the curr job title
	 * @return the curr job title that was removed
	 */
	@Override
	public com.prime.data.service.model.CurrJobTitle deleteCurrJobTitle(
		com.prime.data.service.model.CurrJobTitle currJobTitle) {

		return _currJobTitleLocalService.deleteCurrJobTitle(currJobTitle);
	}

	/**
	 * Deletes the curr job title with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CurrJobTitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title that was removed
	 * @throws PortalException if a curr job title with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.CurrJobTitle deleteCurrJobTitle(
			long currJobTitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currJobTitleLocalService.deleteCurrJobTitle(currJobTitleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currJobTitleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _currJobTitleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _currJobTitleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _currJobTitleLocalService.dynamicQuery();
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

		return _currJobTitleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.CurrJobTitleModelImpl</code>.
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

		return _currJobTitleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.CurrJobTitleModelImpl</code>.
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

		return _currJobTitleLocalService.dynamicQuery(
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

		return _currJobTitleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _currJobTitleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.CurrJobTitle fetchCurrJobTitle(
		long currJobTitleId) {

		return _currJobTitleLocalService.fetchCurrJobTitle(currJobTitleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _currJobTitleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the curr job title with the primary key.
	 *
	 * @param currJobTitleId the primary key of the curr job title
	 * @return the curr job title
	 * @throws PortalException if a curr job title with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.CurrJobTitle getCurrJobTitle(
			long currJobTitleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currJobTitleLocalService.getCurrJobTitle(currJobTitleId);
	}

	/**
	 * Returns a range of all the curr job titles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.CurrJobTitleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of curr job titles
	 * @param end the upper bound of the range of curr job titles (not inclusive)
	 * @return the range of curr job titles
	 */
	@Override
	public java.util.List<com.prime.data.service.model.CurrJobTitle>
		getCurrJobTitles(int start, int end) {

		return _currJobTitleLocalService.getCurrJobTitles(start, end);
	}

	/**
	 * Returns the number of curr job titles.
	 *
	 * @return the number of curr job titles
	 */
	@Override
	public int getCurrJobTitlesCount() {
		return _currJobTitleLocalService.getCurrJobTitlesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _currJobTitleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _currJobTitleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _currJobTitleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the curr job title in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CurrJobTitleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param currJobTitle the curr job title
	 * @return the curr job title that was updated
	 */
	@Override
	public com.prime.data.service.model.CurrJobTitle updateCurrJobTitle(
		com.prime.data.service.model.CurrJobTitle currJobTitle) {

		return _currJobTitleLocalService.updateCurrJobTitle(currJobTitle);
	}

	@Override
	public CurrJobTitleLocalService getWrappedService() {
		return _currJobTitleLocalService;
	}

	@Override
	public void setWrappedService(
		CurrJobTitleLocalService currJobTitleLocalService) {

		_currJobTitleLocalService = currJobTitleLocalService;
	}

	private CurrJobTitleLocalService _currJobTitleLocalService;

}