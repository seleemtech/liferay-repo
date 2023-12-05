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

package com.esquare.intranet.project.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectManagementLocalService}.
 *
 * @author Mahammed Seleem
 * @see ProjectManagementLocalService
 * @generated
 */
public class ProjectManagementLocalServiceWrapper
	implements ProjectManagementLocalService,
			   ServiceWrapper<ProjectManagementLocalService> {

	public ProjectManagementLocalServiceWrapper() {
		this(null);
	}

	public ProjectManagementLocalServiceWrapper(
		ProjectManagementLocalService projectManagementLocalService) {

		_projectManagementLocalService = projectManagementLocalService;
	}

	/**
	 * Adds the project management to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectManagementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectManagement the project management
	 * @return the project management that was added
	 */
	@Override
	public com.esquare.intranet.project.management.model.ProjectManagement
		addProjectManagement(
			com.esquare.intranet.project.management.model.ProjectManagement
				projectManagement) {

		return _projectManagementLocalService.addProjectManagement(
			projectManagement);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectManagementLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new project management with the primary key. Does not add the project management to the database.
	 *
	 * @param projectMgmtId the primary key for the new project management
	 * @return the new project management
	 */
	@Override
	public com.esquare.intranet.project.management.model.ProjectManagement
		createProjectManagement(long projectMgmtId) {

		return _projectManagementLocalService.createProjectManagement(
			projectMgmtId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectManagementLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the project management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectManagementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectMgmtId the primary key of the project management
	 * @return the project management that was removed
	 * @throws PortalException if a project management with the primary key could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.ProjectManagement
			deleteProjectManagement(long projectMgmtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectManagementLocalService.deleteProjectManagement(
			projectMgmtId);
	}

	/**
	 * Deletes the project management from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectManagementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectManagement the project management
	 * @return the project management that was removed
	 */
	@Override
	public com.esquare.intranet.project.management.model.ProjectManagement
		deleteProjectManagement(
			com.esquare.intranet.project.management.model.ProjectManagement
				projectManagement) {

		return _projectManagementLocalService.deleteProjectManagement(
			projectManagement);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectManagementLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectManagementLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectManagementLocalService.dynamicQuery();
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

		return _projectManagementLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.ProjectManagementModelImpl</code>.
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

		return _projectManagementLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.ProjectManagementModelImpl</code>.
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

		return _projectManagementLocalService.dynamicQuery(
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

		return _projectManagementLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projectManagementLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esquare.intranet.project.management.model.ProjectManagement
		fetchProjectManagement(long projectMgmtId) {

		return _projectManagementLocalService.fetchProjectManagement(
			projectMgmtId);
	}

	/**
	 * Returns the project management matching the UUID and group.
	 *
	 * @param uuid the project management's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project management, or <code>null</code> if a matching project management could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.ProjectManagement
		fetchProjectManagementByUuidAndGroupId(String uuid, long groupId) {

		return _projectManagementLocalService.
			fetchProjectManagementByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectManagementLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectManagementLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectManagementLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectManagementLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the project management with the primary key.
	 *
	 * @param projectMgmtId the primary key of the project management
	 * @return the project management
	 * @throws PortalException if a project management with the primary key could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.ProjectManagement
			getProjectManagement(long projectMgmtId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectManagementLocalService.getProjectManagement(
			projectMgmtId);
	}

	/**
	 * Returns the project management matching the UUID and group.
	 *
	 * @param uuid the project management's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project management
	 * @throws PortalException if a matching project management could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.ProjectManagement
			getProjectManagementByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectManagementLocalService.
			getProjectManagementByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the project managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @return the range of project managements
	 */
	@Override
	public java.util.List
		<com.esquare.intranet.project.management.model.ProjectManagement>
			getProjectManagements(int start, int end) {

		return _projectManagementLocalService.getProjectManagements(start, end);
	}

	/**
	 * Returns all the project managements matching the UUID and company.
	 *
	 * @param uuid the UUID of the project managements
	 * @param companyId the primary key of the company
	 * @return the matching project managements, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.esquare.intranet.project.management.model.ProjectManagement>
			getProjectManagementsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _projectManagementLocalService.
			getProjectManagementsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of project managements matching the UUID and company.
	 *
	 * @param uuid the UUID of the project managements
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching project managements, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.esquare.intranet.project.management.model.ProjectManagement>
			getProjectManagementsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.esquare.intranet.project.management.model.
						ProjectManagement> orderByComparator) {

		return _projectManagementLocalService.
			getProjectManagementsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of project managements.
	 *
	 * @return the number of project managements
	 */
	@Override
	public int getProjectManagementsCount() {
		return _projectManagementLocalService.getProjectManagementsCount();
	}

	/**
	 * Updates the project management in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectManagementLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectManagement the project management
	 * @return the project management that was updated
	 */
	@Override
	public com.esquare.intranet.project.management.model.ProjectManagement
		updateProjectManagement(
			com.esquare.intranet.project.management.model.ProjectManagement
				projectManagement) {

		return _projectManagementLocalService.updateProjectManagement(
			projectManagement);
	}

	@Override
	public ProjectManagementLocalService getWrappedService() {
		return _projectManagementLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectManagementLocalService projectManagementLocalService) {

		_projectManagementLocalService = projectManagementLocalService;
	}

	private ProjectManagementLocalService _projectManagementLocalService;

}