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
 * Provides a wrapper for {@link EducationDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EducationDetailsLocalService
 * @generated
 */
public class EducationDetailsLocalServiceWrapper
	implements EducationDetailsLocalService,
			   ServiceWrapper<EducationDetailsLocalService> {

	public EducationDetailsLocalServiceWrapper() {
		this(null);
	}

	public EducationDetailsLocalServiceWrapper(
		EducationDetailsLocalService educationDetailsLocalService) {

		_educationDetailsLocalService = educationDetailsLocalService;
	}

	/**
	 * Adds the education details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EducationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param educationDetails the education details
	 * @return the education details that was added
	 */
	@Override
	public com.intranet.model.EducationDetails addEducationDetails(
		com.intranet.model.EducationDetails educationDetails) {

		return _educationDetailsLocalService.addEducationDetails(
			educationDetails);
	}

	/**
	 * Creates a new education details with the primary key. Does not add the education details to the database.
	 *
	 * @param educationId the primary key for the new education details
	 * @return the new education details
	 */
	@Override
	public com.intranet.model.EducationDetails createEducationDetails(
		long educationId) {

		return _educationDetailsLocalService.createEducationDetails(
			educationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _educationDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the education details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EducationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param educationDetails the education details
	 * @return the education details that was removed
	 */
	@Override
	public com.intranet.model.EducationDetails deleteEducationDetails(
		com.intranet.model.EducationDetails educationDetails) {

		return _educationDetailsLocalService.deleteEducationDetails(
			educationDetails);
	}

	/**
	 * Deletes the education details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EducationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details that was removed
	 * @throws PortalException if a education details with the primary key could not be found
	 */
	@Override
	public com.intranet.model.EducationDetails deleteEducationDetails(
			long educationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _educationDetailsLocalService.deleteEducationDetails(
			educationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _educationDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _educationDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _educationDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _educationDetailsLocalService.dynamicQuery();
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

		return _educationDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.EducationDetailsModelImpl</code>.
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

		return _educationDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.EducationDetailsModelImpl</code>.
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

		return _educationDetailsLocalService.dynamicQuery(
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

		return _educationDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _educationDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.intranet.model.EducationDetails fetchEducationDetails(
		long educationId) {

		return _educationDetailsLocalService.fetchEducationDetails(educationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _educationDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the education details with the primary key.
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details
	 * @throws PortalException if a education details with the primary key could not be found
	 */
	@Override
	public com.intranet.model.EducationDetails getEducationDetails(
			long educationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _educationDetailsLocalService.getEducationDetails(educationId);
	}

	/**
	 * Returns a range of all the education detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.EducationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education detailses
	 * @param end the upper bound of the range of education detailses (not inclusive)
	 * @return the range of education detailses
	 */
	@Override
	public java.util.List<com.intranet.model.EducationDetails>
		getEducationDetailses(int start, int end) {

		return _educationDetailsLocalService.getEducationDetailses(start, end);
	}

	/**
	 * Returns the number of education detailses.
	 *
	 * @return the number of education detailses
	 */
	@Override
	public int getEducationDetailsesCount() {
		return _educationDetailsLocalService.getEducationDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _educationDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _educationDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _educationDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the education details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EducationDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param educationDetails the education details
	 * @return the education details that was updated
	 */
	@Override
	public com.intranet.model.EducationDetails updateEducationDetails(
		com.intranet.model.EducationDetails educationDetails) {

		return _educationDetailsLocalService.updateEducationDetails(
			educationDetails);
	}

	@Override
	public EducationDetailsLocalService getWrappedService() {
		return _educationDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		EducationDetailsLocalService educationDetailsLocalService) {

		_educationDetailsLocalService = educationDetailsLocalService;
	}

	private EducationDetailsLocalService _educationDetailsLocalService;

}