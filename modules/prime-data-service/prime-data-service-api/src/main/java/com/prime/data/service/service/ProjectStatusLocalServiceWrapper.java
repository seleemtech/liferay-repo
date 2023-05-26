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
 * Provides a wrapper for {@link ProjectStatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectStatusLocalService
 * @generated
 */
public class ProjectStatusLocalServiceWrapper
	implements ProjectStatusLocalService,
			   ServiceWrapper<ProjectStatusLocalService> {

	public ProjectStatusLocalServiceWrapper(
		ProjectStatusLocalService projectStatusLocalService) {

		_projectStatusLocalService = projectStatusLocalService;
	}

	/**
	 * Adds the project status to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectStatus the project status
	 * @return the project status that was added
	 */
	@Override
	public com.prime.data.service.model.ProjectStatus addProjectStatus(
		com.prime.data.service.model.ProjectStatus projectStatus) {

		return _projectStatusLocalService.addProjectStatus(projectStatus);
	}

	@Override
	public void addProjectStatus(String projectStatusName) {
		_projectStatusLocalService.addProjectStatus(projectStatusName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectStatusLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new project status with the primary key. Does not add the project status to the database.
	 *
	 * @param projectStatusId the primary key for the new project status
	 * @return the new project status
	 */
	@Override
	public com.prime.data.service.model.ProjectStatus createProjectStatus(
		long projectStatusId) {

		return _projectStatusLocalService.createProjectStatus(projectStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectStatusLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the project status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status that was removed
	 * @throws PortalException if a project status with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.ProjectStatus deleteProjectStatus(
			long projectStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectStatusLocalService.deleteProjectStatus(projectStatusId);
	}

	/**
	 * Deletes the project status from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectStatus the project status
	 * @return the project status that was removed
	 */
	@Override
	public com.prime.data.service.model.ProjectStatus deleteProjectStatus(
		com.prime.data.service.model.ProjectStatus projectStatus) {

		return _projectStatusLocalService.deleteProjectStatus(projectStatus);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectStatusLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectStatusLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectStatusLocalService.dynamicQuery();
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

		return _projectStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.ProjectStatusModelImpl</code>.
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

		return _projectStatusLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.ProjectStatusModelImpl</code>.
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

		return _projectStatusLocalService.dynamicQuery(
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

		return _projectStatusLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projectStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.ProjectStatus fetchProjectStatus(
		long projectStatusId) {

		return _projectStatusLocalService.fetchProjectStatus(projectStatusId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectStatusLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectStatusLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectStatusLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the project status with the primary key.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status
	 * @throws PortalException if a project status with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.ProjectStatus getProjectStatus(
			long projectStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectStatusLocalService.getProjectStatus(projectStatusId);
	}

	/**
	 * Returns a range of all the project statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @return the range of project statuses
	 */
	@Override
	public java.util.List<com.prime.data.service.model.ProjectStatus>
		getProjectStatuses(int start, int end) {

		return _projectStatusLocalService.getProjectStatuses(start, end);
	}

	/**
	 * Returns the number of project statuses.
	 *
	 * @return the number of project statuses
	 */
	@Override
	public int getProjectStatusesCount() {
		return _projectStatusLocalService.getProjectStatusesCount();
	}

	/**
	 * Updates the project status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectStatus the project status
	 * @return the project status that was updated
	 */
	@Override
	public com.prime.data.service.model.ProjectStatus updateProjectStatus(
		com.prime.data.service.model.ProjectStatus projectStatus) {

		return _projectStatusLocalService.updateProjectStatus(projectStatus);
	}

	@Override
	public ProjectStatusLocalService getWrappedService() {
		return _projectStatusLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectStatusLocalService projectStatusLocalService) {

		_projectStatusLocalService = projectStatusLocalService;
	}

	private ProjectStatusLocalService _projectStatusLocalService;

}