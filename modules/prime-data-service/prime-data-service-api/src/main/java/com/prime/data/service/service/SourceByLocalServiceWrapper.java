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
 * Provides a wrapper for {@link SourceByLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SourceByLocalService
 * @generated
 */
public class SourceByLocalServiceWrapper
	implements ServiceWrapper<SourceByLocalService>, SourceByLocalService {

	public SourceByLocalServiceWrapper(
		SourceByLocalService sourceByLocalService) {

		_sourceByLocalService = sourceByLocalService;
	}

	@Override
	public void addSource(String sourceBy) {
		_sourceByLocalService.addSource(sourceBy);
	}

	/**
	 * Adds the source by to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SourceByLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sourceBy the source by
	 * @return the source by that was added
	 */
	@Override
	public com.prime.data.service.model.SourceBy addSourceBy(
		com.prime.data.service.model.SourceBy sourceBy) {

		return _sourceByLocalService.addSourceBy(sourceBy);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sourceByLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new source by with the primary key. Does not add the source by to the database.
	 *
	 * @param sourceId the primary key for the new source by
	 * @return the new source by
	 */
	@Override
	public com.prime.data.service.model.SourceBy createSourceBy(long sourceId) {
		return _sourceByLocalService.createSourceBy(sourceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sourceByLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the source by with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SourceByLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sourceId the primary key of the source by
	 * @return the source by that was removed
	 * @throws PortalException if a source by with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.SourceBy deleteSourceBy(long sourceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sourceByLocalService.deleteSourceBy(sourceId);
	}

	/**
	 * Deletes the source by from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SourceByLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sourceBy the source by
	 * @return the source by that was removed
	 */
	@Override
	public com.prime.data.service.model.SourceBy deleteSourceBy(
		com.prime.data.service.model.SourceBy sourceBy) {

		return _sourceByLocalService.deleteSourceBy(sourceBy);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _sourceByLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _sourceByLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sourceByLocalService.dynamicQuery();
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

		return _sourceByLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.SourceByModelImpl</code>.
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

		return _sourceByLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.SourceByModelImpl</code>.
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

		return _sourceByLocalService.dynamicQuery(
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

		return _sourceByLocalService.dynamicQueryCount(dynamicQuery);
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

		return _sourceByLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.SourceBy fetchSourceBy(long sourceId) {
		return _sourceByLocalService.fetchSourceBy(sourceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sourceByLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sourceByLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sourceByLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sourceByLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the source bies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.SourceByModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of source bies
	 * @param end the upper bound of the range of source bies (not inclusive)
	 * @return the range of source bies
	 */
	@Override
	public java.util.List<com.prime.data.service.model.SourceBy> getSourceBies(
		int start, int end) {

		return _sourceByLocalService.getSourceBies(start, end);
	}

	/**
	 * Returns the number of source bies.
	 *
	 * @return the number of source bies
	 */
	@Override
	public int getSourceBiesCount() {
		return _sourceByLocalService.getSourceBiesCount();
	}

	/**
	 * Returns the source by with the primary key.
	 *
	 * @param sourceId the primary key of the source by
	 * @return the source by
	 * @throws PortalException if a source by with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.SourceBy getSourceBy(long sourceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sourceByLocalService.getSourceBy(sourceId);
	}

	/**
	 * Updates the source by in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SourceByLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sourceBy the source by
	 * @return the source by that was updated
	 */
	@Override
	public com.prime.data.service.model.SourceBy updateSourceBy(
		com.prime.data.service.model.SourceBy sourceBy) {

		return _sourceByLocalService.updateSourceBy(sourceBy);
	}

	@Override
	public SourceByLocalService getWrappedService() {
		return _sourceByLocalService;
	}

	@Override
	public void setWrappedService(SourceByLocalService sourceByLocalService) {
		_sourceByLocalService = sourceByLocalService;
	}

	private SourceByLocalService _sourceByLocalService;

}