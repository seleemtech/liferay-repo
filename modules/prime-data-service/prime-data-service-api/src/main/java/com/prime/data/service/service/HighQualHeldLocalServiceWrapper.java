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
 * Provides a wrapper for {@link HighQualHeldLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HighQualHeldLocalService
 * @generated
 */
public class HighQualHeldLocalServiceWrapper
	implements HighQualHeldLocalService,
			   ServiceWrapper<HighQualHeldLocalService> {

	public HighQualHeldLocalServiceWrapper(
		HighQualHeldLocalService highQualHeldLocalService) {

		_highQualHeldLocalService = highQualHeldLocalService;
	}

	/**
	 * Adds the high qual held to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HighQualHeldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param highQualHeld the high qual held
	 * @return the high qual held that was added
	 */
	@Override
	public com.prime.data.service.model.HighQualHeld addHighQualHeld(
		com.prime.data.service.model.HighQualHeld highQualHeld) {

		return _highQualHeldLocalService.addHighQualHeld(highQualHeld);
	}

	@Override
	public void addHighQualHeld(String highQualHeld) {
		_highQualHeldLocalService.addHighQualHeld(highQualHeld);
	}

	/**
	 * Creates a new high qual held with the primary key. Does not add the high qual held to the database.
	 *
	 * @param highQualHeldId the primary key for the new high qual held
	 * @return the new high qual held
	 */
	@Override
	public com.prime.data.service.model.HighQualHeld createHighQualHeld(
		long highQualHeldId) {

		return _highQualHeldLocalService.createHighQualHeld(highQualHeldId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _highQualHeldLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the high qual held from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HighQualHeldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param highQualHeld the high qual held
	 * @return the high qual held that was removed
	 */
	@Override
	public com.prime.data.service.model.HighQualHeld deleteHighQualHeld(
		com.prime.data.service.model.HighQualHeld highQualHeld) {

		return _highQualHeldLocalService.deleteHighQualHeld(highQualHeld);
	}

	/**
	 * Deletes the high qual held with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HighQualHeldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held that was removed
	 * @throws PortalException if a high qual held with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.HighQualHeld deleteHighQualHeld(
			long highQualHeldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _highQualHeldLocalService.deleteHighQualHeld(highQualHeldId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _highQualHeldLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _highQualHeldLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _highQualHeldLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _highQualHeldLocalService.dynamicQuery();
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

		return _highQualHeldLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.HighQualHeldModelImpl</code>.
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

		return _highQualHeldLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.HighQualHeldModelImpl</code>.
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

		return _highQualHeldLocalService.dynamicQuery(
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

		return _highQualHeldLocalService.dynamicQueryCount(dynamicQuery);
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

		return _highQualHeldLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.HighQualHeld fetchHighQualHeld(
		long highQualHeldId) {

		return _highQualHeldLocalService.fetchHighQualHeld(highQualHeldId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _highQualHeldLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the high qual held with the primary key.
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held
	 * @throws PortalException if a high qual held with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.HighQualHeld getHighQualHeld(
			long highQualHeldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _highQualHeldLocalService.getHighQualHeld(highQualHeldId);
	}

	/**
	 * Returns a range of all the high qual helds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @return the range of high qual helds
	 */
	@Override
	public java.util.List<com.prime.data.service.model.HighQualHeld>
		getHighQualHelds(int start, int end) {

		return _highQualHeldLocalService.getHighQualHelds(start, end);
	}

	/**
	 * Returns the number of high qual helds.
	 *
	 * @return the number of high qual helds
	 */
	@Override
	public int getHighQualHeldsCount() {
		return _highQualHeldLocalService.getHighQualHeldsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _highQualHeldLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _highQualHeldLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _highQualHeldLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the high qual held in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HighQualHeldLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param highQualHeld the high qual held
	 * @return the high qual held that was updated
	 */
	@Override
	public com.prime.data.service.model.HighQualHeld updateHighQualHeld(
		com.prime.data.service.model.HighQualHeld highQualHeld) {

		return _highQualHeldLocalService.updateHighQualHeld(highQualHeld);
	}

	@Override
	public HighQualHeldLocalService getWrappedService() {
		return _highQualHeldLocalService;
	}

	@Override
	public void setWrappedService(
		HighQualHeldLocalService highQualHeldLocalService) {

		_highQualHeldLocalService = highQualHeldLocalService;
	}

	private HighQualHeldLocalService _highQualHeldLocalService;

}