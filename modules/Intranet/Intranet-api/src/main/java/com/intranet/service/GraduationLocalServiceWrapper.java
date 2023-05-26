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

package com.intranet.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GraduationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GraduationLocalService
 * @generated
 */
public class GraduationLocalServiceWrapper
	implements GraduationLocalService, ServiceWrapper<GraduationLocalService> {

	public GraduationLocalServiceWrapper() {
		this(null);
	}

	public GraduationLocalServiceWrapper(
		GraduationLocalService graduationLocalService) {

		_graduationLocalService = graduationLocalService;
	}

	/**
	 * Adds the graduation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GraduationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param graduation the graduation
	 * @return the graduation that was added
	 */
	@Override
	public com.intranet.model.Graduation addGraduation(
		com.intranet.model.Graduation graduation) {

		return _graduationLocalService.addGraduation(graduation);
	}

	/**
	 * Creates a new graduation with the primary key. Does not add the graduation to the database.
	 *
	 * @param graduationCode the primary key for the new graduation
	 * @return the new graduation
	 */
	@Override
	public com.intranet.model.Graduation createGraduation(
		String graduationCode) {

		return _graduationLocalService.createGraduation(graduationCode);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _graduationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the graduation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GraduationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param graduation the graduation
	 * @return the graduation that was removed
	 */
	@Override
	public com.intranet.model.Graduation deleteGraduation(
		com.intranet.model.Graduation graduation) {

		return _graduationLocalService.deleteGraduation(graduation);
	}

	/**
	 * Deletes the graduation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GraduationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation that was removed
	 * @throws PortalException if a graduation with the primary key could not be found
	 */
	@Override
	public com.intranet.model.Graduation deleteGraduation(String graduationCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _graduationLocalService.deleteGraduation(graduationCode);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _graduationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _graduationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _graduationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _graduationLocalService.dynamicQuery();
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

		return _graduationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.GraduationModelImpl</code>.
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

		return _graduationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.GraduationModelImpl</code>.
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

		return _graduationLocalService.dynamicQuery(
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

		return _graduationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _graduationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.intranet.model.Graduation fetchGraduation(
		String graduationCode) {

		return _graduationLocalService.fetchGraduation(graduationCode);
	}

	/**
	 * Returns the graduation with the primary key.
	 *
	 * @param graduationCode the primary key of the graduation
	 * @return the graduation
	 * @throws PortalException if a graduation with the primary key could not be found
	 */
	@Override
	public com.intranet.model.Graduation getGraduation(String graduationCode)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _graduationLocalService.getGraduation(graduationCode);
	}

	/**
	 * Returns a range of all the graduations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.GraduationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of graduations
	 * @param end the upper bound of the range of graduations (not inclusive)
	 * @return the range of graduations
	 */
	@Override
	public java.util.List<com.intranet.model.Graduation> getGraduations(
		int start, int end) {

		return _graduationLocalService.getGraduations(start, end);
	}

	/**
	 * Returns the number of graduations.
	 *
	 * @return the number of graduations
	 */
	@Override
	public int getGraduationsCount() {
		return _graduationLocalService.getGraduationsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _graduationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _graduationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the graduation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GraduationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param graduation the graduation
	 * @return the graduation that was updated
	 */
	@Override
	public com.intranet.model.Graduation updateGraduation(
		com.intranet.model.Graduation graduation) {

		return _graduationLocalService.updateGraduation(graduation);
	}

	@Override
	public GraduationLocalService getWrappedService() {
		return _graduationLocalService;
	}

	@Override
	public void setWrappedService(
		GraduationLocalService graduationLocalService) {

		_graduationLocalService = graduationLocalService;
	}

	private GraduationLocalService _graduationLocalService;

}