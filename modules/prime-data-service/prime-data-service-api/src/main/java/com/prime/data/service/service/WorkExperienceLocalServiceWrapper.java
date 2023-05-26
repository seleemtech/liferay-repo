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
 * Provides a wrapper for {@link WorkExperienceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see WorkExperienceLocalService
 * @generated
 */
public class WorkExperienceLocalServiceWrapper
	implements ServiceWrapper<WorkExperienceLocalService>,
			   WorkExperienceLocalService {

	public WorkExperienceLocalServiceWrapper(
		WorkExperienceLocalService workExperienceLocalService) {

		_workExperienceLocalService = workExperienceLocalService;
	}

	@Override
	public void addWorkExperience(String workExpRange) {
		_workExperienceLocalService.addWorkExperience(workExpRange);
	}

	/**
	 * Adds the work experience to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workExperience the work experience
	 * @return the work experience that was added
	 */
	@Override
	public com.prime.data.service.model.WorkExperience addWorkExperience(
		com.prime.data.service.model.WorkExperience workExperience) {

		return _workExperienceLocalService.addWorkExperience(workExperience);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workExperienceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new work experience with the primary key. Does not add the work experience to the database.
	 *
	 * @param workExpId the primary key for the new work experience
	 * @return the new work experience
	 */
	@Override
	public com.prime.data.service.model.WorkExperience createWorkExperience(
		long workExpId) {

		return _workExperienceLocalService.createWorkExperience(workExpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workExperienceLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the work experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workExpId the primary key of the work experience
	 * @return the work experience that was removed
	 * @throws PortalException if a work experience with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.WorkExperience deleteWorkExperience(
			long workExpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workExperienceLocalService.deleteWorkExperience(workExpId);
	}

	/**
	 * Deletes the work experience from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workExperience the work experience
	 * @return the work experience that was removed
	 */
	@Override
	public com.prime.data.service.model.WorkExperience deleteWorkExperience(
		com.prime.data.service.model.WorkExperience workExperience) {

		return _workExperienceLocalService.deleteWorkExperience(workExperience);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _workExperienceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _workExperienceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workExperienceLocalService.dynamicQuery();
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

		return _workExperienceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.WorkExperienceModelImpl</code>.
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

		return _workExperienceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.WorkExperienceModelImpl</code>.
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

		return _workExperienceLocalService.dynamicQuery(
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

		return _workExperienceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _workExperienceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.WorkExperience fetchWorkExperience(
		long workExpId) {

		return _workExperienceLocalService.fetchWorkExperience(workExpId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _workExperienceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _workExperienceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _workExperienceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workExperienceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the work experience with the primary key.
	 *
	 * @param workExpId the primary key of the work experience
	 * @return the work experience
	 * @throws PortalException if a work experience with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.WorkExperience getWorkExperience(
			long workExpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _workExperienceLocalService.getWorkExperience(workExpId);
	}

	/**
	 * Returns a range of all the work experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.WorkExperienceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of work experiences
	 * @param end the upper bound of the range of work experiences (not inclusive)
	 * @return the range of work experiences
	 */
	@Override
	public java.util.List<com.prime.data.service.model.WorkExperience>
		getWorkExperiences(int start, int end) {

		return _workExperienceLocalService.getWorkExperiences(start, end);
	}

	/**
	 * Returns the number of work experiences.
	 *
	 * @return the number of work experiences
	 */
	@Override
	public int getWorkExperiencesCount() {
		return _workExperienceLocalService.getWorkExperiencesCount();
	}

	/**
	 * Updates the work experience in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect WorkExperienceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param workExperience the work experience
	 * @return the work experience that was updated
	 */
	@Override
	public com.prime.data.service.model.WorkExperience updateWorkExperience(
		com.prime.data.service.model.WorkExperience workExperience) {

		return _workExperienceLocalService.updateWorkExperience(workExperience);
	}

	@Override
	public WorkExperienceLocalService getWrappedService() {
		return _workExperienceLocalService;
	}

	@Override
	public void setWrappedService(
		WorkExperienceLocalService workExperienceLocalService) {

		_workExperienceLocalService = workExperienceLocalService;
	}

	private WorkExperienceLocalService _workExperienceLocalService;

}