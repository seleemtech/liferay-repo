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
 * Provides a wrapper for {@link NamePrefixLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NamePrefixLocalService
 * @generated
 */
public class NamePrefixLocalServiceWrapper
	implements NamePrefixLocalService, ServiceWrapper<NamePrefixLocalService> {

	public NamePrefixLocalServiceWrapper(
		NamePrefixLocalService namePrefixLocalService) {

		_namePrefixLocalService = namePrefixLocalService;
	}

	/**
	 * Adds the name prefix to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NamePrefixLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param namePrefix the name prefix
	 * @return the name prefix that was added
	 */
	@Override
	public com.prime.data.service.model.NamePrefix addNamePrefix(
		com.prime.data.service.model.NamePrefix namePrefix) {

		return _namePrefixLocalService.addNamePrefix(namePrefix);
	}

	@Override
	public void addNamePrefix(String namePrefix) {
		_namePrefixLocalService.addNamePrefix(namePrefix);
	}

	/**
	 * Creates a new name prefix with the primary key. Does not add the name prefix to the database.
	 *
	 * @param namePrefixId the primary key for the new name prefix
	 * @return the new name prefix
	 */
	@Override
	public com.prime.data.service.model.NamePrefix createNamePrefix(
		long namePrefixId) {

		return _namePrefixLocalService.createNamePrefix(namePrefixId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _namePrefixLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the name prefix with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NamePrefixLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix that was removed
	 * @throws PortalException if a name prefix with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.NamePrefix deleteNamePrefix(
			long namePrefixId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _namePrefixLocalService.deleteNamePrefix(namePrefixId);
	}

	/**
	 * Deletes the name prefix from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NamePrefixLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param namePrefix the name prefix
	 * @return the name prefix that was removed
	 */
	@Override
	public com.prime.data.service.model.NamePrefix deleteNamePrefix(
		com.prime.data.service.model.NamePrefix namePrefix) {

		return _namePrefixLocalService.deleteNamePrefix(namePrefix);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _namePrefixLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _namePrefixLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _namePrefixLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _namePrefixLocalService.dynamicQuery();
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

		return _namePrefixLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.NamePrefixModelImpl</code>.
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

		return _namePrefixLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.NamePrefixModelImpl</code>.
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

		return _namePrefixLocalService.dynamicQuery(
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

		return _namePrefixLocalService.dynamicQueryCount(dynamicQuery);
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

		return _namePrefixLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.NamePrefix fetchNamePrefix(
		long namePrefixId) {

		return _namePrefixLocalService.fetchNamePrefix(namePrefixId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _namePrefixLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _namePrefixLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the name prefix with the primary key.
	 *
	 * @param namePrefixId the primary key of the name prefix
	 * @return the name prefix
	 * @throws PortalException if a name prefix with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.NamePrefix getNamePrefix(
			long namePrefixId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _namePrefixLocalService.getNamePrefix(namePrefixId);
	}

	/**
	 * Returns a range of all the name prefixes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.NamePrefixModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of name prefixes
	 * @param end the upper bound of the range of name prefixes (not inclusive)
	 * @return the range of name prefixes
	 */
	@Override
	public java.util.List<com.prime.data.service.model.NamePrefix>
		getNamePrefixes(int start, int end) {

		return _namePrefixLocalService.getNamePrefixes(start, end);
	}

	/**
	 * Returns the number of name prefixes.
	 *
	 * @return the number of name prefixes
	 */
	@Override
	public int getNamePrefixesCount() {
		return _namePrefixLocalService.getNamePrefixesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _namePrefixLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _namePrefixLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the name prefix in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NamePrefixLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param namePrefix the name prefix
	 * @return the name prefix that was updated
	 */
	@Override
	public com.prime.data.service.model.NamePrefix updateNamePrefix(
		com.prime.data.service.model.NamePrefix namePrefix) {

		return _namePrefixLocalService.updateNamePrefix(namePrefix);
	}

	@Override
	public NamePrefixLocalService getWrappedService() {
		return _namePrefixLocalService;
	}

	@Override
	public void setWrappedService(
		NamePrefixLocalService namePrefixLocalService) {

		_namePrefixLocalService = namePrefixLocalService;
	}

	private NamePrefixLocalService _namePrefixLocalService;

}