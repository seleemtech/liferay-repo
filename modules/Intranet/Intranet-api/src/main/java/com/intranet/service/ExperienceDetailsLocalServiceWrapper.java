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
 * Provides a wrapper for {@link ExperienceDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExperienceDetailsLocalService
 * @generated
 */
public class ExperienceDetailsLocalServiceWrapper
	implements ExperienceDetailsLocalService,
			   ServiceWrapper<ExperienceDetailsLocalService> {

	public ExperienceDetailsLocalServiceWrapper() {
		this(null);
	}

	public ExperienceDetailsLocalServiceWrapper(
		ExperienceDetailsLocalService experienceDetailsLocalService) {

		_experienceDetailsLocalService = experienceDetailsLocalService;
	}

	/**
	 * Adds the experience details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperienceDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experienceDetails the experience details
	 * @return the experience details that was added
	 */
	@Override
	public com.intranet.model.ExperienceDetails addExperienceDetails(
		com.intranet.model.ExperienceDetails experienceDetails) {

		return _experienceDetailsLocalService.addExperienceDetails(
			experienceDetails);
	}

	/**
	 * Creates a new experience details with the primary key. Does not add the experience details to the database.
	 *
	 * @param experienceId the primary key for the new experience details
	 * @return the new experience details
	 */
	@Override
	public com.intranet.model.ExperienceDetails createExperienceDetails(
		long experienceId) {

		return _experienceDetailsLocalService.createExperienceDetails(
			experienceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the experience details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperienceDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experienceDetails the experience details
	 * @return the experience details that was removed
	 */
	@Override
	public com.intranet.model.ExperienceDetails deleteExperienceDetails(
		com.intranet.model.ExperienceDetails experienceDetails) {

		return _experienceDetailsLocalService.deleteExperienceDetails(
			experienceDetails);
	}

	/**
	 * Deletes the experience details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperienceDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details that was removed
	 * @throws PortalException if a experience details with the primary key could not be found
	 */
	@Override
	public com.intranet.model.ExperienceDetails deleteExperienceDetails(
			long experienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceDetailsLocalService.deleteExperienceDetails(
			experienceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _experienceDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _experienceDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _experienceDetailsLocalService.dynamicQuery();
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

		return _experienceDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.ExperienceDetailsModelImpl</code>.
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

		return _experienceDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.ExperienceDetailsModelImpl</code>.
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

		return _experienceDetailsLocalService.dynamicQuery(
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

		return _experienceDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _experienceDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.intranet.model.ExperienceDetails fetchExperienceDetails(
		long experienceId) {

		return _experienceDetailsLocalService.fetchExperienceDetails(
			experienceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _experienceDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the experience details with the primary key.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details
	 * @throws PortalException if a experience details with the primary key could not be found
	 */
	@Override
	public com.intranet.model.ExperienceDetails getExperienceDetails(
			long experienceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceDetailsLocalService.getExperienceDetails(
			experienceId);
	}

	/**
	 * Returns a range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @return the range of experience detailses
	 */
	@Override
	public java.util.List<com.intranet.model.ExperienceDetails>
		getExperienceDetailses(int start, int end) {

		return _experienceDetailsLocalService.getExperienceDetailses(
			start, end);
	}

	/**
	 * Returns the number of experience detailses.
	 *
	 * @return the number of experience detailses
	 */
	@Override
	public int getExperienceDetailsesCount() {
		return _experienceDetailsLocalService.getExperienceDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _experienceDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _experienceDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _experienceDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the experience details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperienceDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experienceDetails the experience details
	 * @return the experience details that was updated
	 */
	@Override
	public com.intranet.model.ExperienceDetails updateExperienceDetails(
		com.intranet.model.ExperienceDetails experienceDetails) {

		return _experienceDetailsLocalService.updateExperienceDetails(
			experienceDetails);
	}

	@Override
	public ExperienceDetailsLocalService getWrappedService() {
		return _experienceDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		ExperienceDetailsLocalService experienceDetailsLocalService) {

		_experienceDetailsLocalService = experienceDetailsLocalService;
	}

	private ExperienceDetailsLocalService _experienceDetailsLocalService;

}