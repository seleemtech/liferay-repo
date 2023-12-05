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
 * Provides a wrapper for {@link ProjectsLocalService}.
 *
 * @author Mahammed Seleem
 * @see ProjectsLocalService
 * @generated
 */
public class ProjectsLocalServiceWrapper
	implements ProjectsLocalService, ServiceWrapper<ProjectsLocalService> {

	public ProjectsLocalServiceWrapper() {
		this(null);
	}

	public ProjectsLocalServiceWrapper(
		ProjectsLocalService projectsLocalService) {

		_projectsLocalService = projectsLocalService;
	}

	@Override
	public com.esquare.intranet.project.management.model.Projects
		_addResourceIdSetting(
			com.esquare.intranet.project.management.model.Projects projects,
			String resourceIdSettings) {

		return _projectsLocalService._addResourceIdSetting(
			projects, resourceIdSettings);
	}

	@Override
	public com.esquare.intranet.project.management.model.Projects addProject(
			String projectName, String projectDesc,
			java.util.Date projectProposedDate,
			java.util.Date projectConfirmedDate,
			java.util.Date projectDevelopmentStartDate,
			java.util.Date deliveryEstimatedDate, String projectDurationDate,
			int projectStatus, int projectCode, long projectDocumentId,
			String name, String contactNumber, String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsLocalService.addProject(
			projectName, projectDesc, projectProposedDate, projectConfirmedDate,
			projectDevelopmentStartDate, deliveryEstimatedDate,
			projectDurationDate, projectStatus, projectCode, projectDocumentId,
			name, contactNumber, email, serviceContext);
	}

	/**
	 * Adds the projects to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projects the projects
	 * @return the projects that was added
	 */
	@Override
	public com.esquare.intranet.project.management.model.Projects addProjects(
		com.esquare.intranet.project.management.model.Projects projects) {

		return _projectsLocalService.addProjects(projects);
	}

	@Override
	public com.esquare.intranet.project.management.model.Projects
			addResourceIdSetting(
				long projectId, long pmId, long dlId, long opId, long qaId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return _projectsLocalService.addResourceIdSetting(
			projectId, pmId, dlId, opId, qaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new projects with the primary key. Does not add the projects to the database.
	 *
	 * @param projectId the primary key for the new projects
	 * @return the new projects
	 */
	@Override
	public com.esquare.intranet.project.management.model.Projects
		createProjects(long projectId) {

		return _projectsLocalService.createProjects(projectId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the projects with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectId the primary key of the projects
	 * @return the projects that was removed
	 * @throws PortalException if a projects with the primary key could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.Projects
			deleteProjects(long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsLocalService.deleteProjects(projectId);
	}

	/**
	 * Deletes the projects from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projects the projects
	 * @return the projects that was removed
	 */
	@Override
	public com.esquare.intranet.project.management.model.Projects
		deleteProjects(
			com.esquare.intranet.project.management.model.Projects projects) {

		return _projectsLocalService.deleteProjects(projects);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectsLocalService.dynamicQuery();
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

		return _projectsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.ProjectsModelImpl</code>.
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

		return _projectsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.ProjectsModelImpl</code>.
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

		return _projectsLocalService.dynamicQuery(
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

		return _projectsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projectsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.esquare.intranet.project.management.model.Projects editProject(
			long projectId, String projectName, String projectDesc,
			java.util.Date projectProposedDate,
			java.util.Date projectConfirmedDate,
			java.util.Date projectDevelopmentStartDate,
			java.util.Date deliveryEstimatedDate, String projectDurationDate,
			int projectStatus, int projectCode, long projectDocumentId,
			String clientName, String contactNumber, String email,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsLocalService.editProject(
			projectId, projectName, projectDesc, projectProposedDate,
			projectConfirmedDate, projectDevelopmentStartDate,
			deliveryEstimatedDate, projectDurationDate, projectStatus,
			projectCode, projectDocumentId, clientName, contactNumber, email,
			serviceContext);
	}

	@Override
	public com.esquare.intranet.project.management.model.Projects fetchProjects(
		long projectId) {

		return _projectsLocalService.fetchProjects(projectId);
	}

	/**
	 * Returns the projects matching the UUID and group.
	 *
	 * @param uuid the projects's UUID
	 * @param groupId the primary key of the group
	 * @return the matching projects, or <code>null</code> if a matching projects could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.Projects
		fetchProjectsByUuidAndGroupId(String uuid, long groupId) {

		return _projectsLocalService.fetchProjectsByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.esquare.intranet.project.management.model.Projects getProject(
			long projectId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return _projectsLocalService.getProject(projectId);
	}

	/**
	 * Returns the projects with the primary key.
	 *
	 * @param projectId the primary key of the projects
	 * @return the projects
	 * @throws PortalException if a projects with the primary key could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.Projects getProjects(
			long projectId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsLocalService.getProjects(projectId);
	}

	/**
	 * Returns the projects matching the UUID and group.
	 *
	 * @param uuid the projects's UUID
	 * @param groupId the primary key of the group
	 * @return the matching projects
	 * @throws PortalException if a matching projects could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.Projects
			getProjectsByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsLocalService.getProjectsByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the projectses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.ProjectsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @return the range of projectses
	 */
	@Override
	public java.util.List
		<com.esquare.intranet.project.management.model.Projects> getProjectses(
			int start, int end) {

		return _projectsLocalService.getProjectses(start, end);
	}

	/**
	 * Returns all the projectses matching the UUID and company.
	 *
	 * @param uuid the UUID of the projectses
	 * @param companyId the primary key of the company
	 * @return the matching projectses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.esquare.intranet.project.management.model.Projects>
			getProjectsesByUuidAndCompanyId(String uuid, long companyId) {

		return _projectsLocalService.getProjectsesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of projectses matching the UUID and company.
	 *
	 * @param uuid the UUID of the projectses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of projectses
	 * @param end the upper bound of the range of projectses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching projectses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.esquare.intranet.project.management.model.Projects>
			getProjectsesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.esquare.intranet.project.management.model.Projects>
						orderByComparator) {

		return _projectsLocalService.getProjectsesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of projectses.
	 *
	 * @return the number of projectses
	 */
	@Override
	public int getProjectsesCount() {
		return _projectsLocalService.getProjectsesCount();
	}

	/**
	 * Updates the projects in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projects the projects
	 * @return the projects that was updated
	 */
	@Override
	public com.esquare.intranet.project.management.model.Projects
		updateProjects(
			com.esquare.intranet.project.management.model.Projects projects) {

		return _projectsLocalService.updateProjects(projects);
	}

	@Override
	public com.esquare.intranet.project.management.model.Projects
			updateProjects(
				com.esquare.intranet.project.management.model.Projects projects,
				String projectName, String projectDesc,
				java.util.Date projectProposedDate,
				java.util.Date projectConfirmedDate,
				java.util.Date projectDevelopmentStartDate,
				java.util.Date deliveryEstimatedDate,
				String projectDurationDate, int projectStatus, int projectCode,
				long projectDocumentId, String name, String contactNumber,
				String email,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectsLocalService.updateProjects(
			projects, projectName, projectDesc, projectProposedDate,
			projectConfirmedDate, projectDevelopmentStartDate,
			deliveryEstimatedDate, projectDurationDate, projectStatus,
			projectCode, projectDocumentId, name, contactNumber, email,
			serviceContext);
	}

	@Override
	public com.esquare.intranet.project.management.model.Projects updateStatus(
			long projectId, int status)
		throws com.esquare.intranet.project.management.exception.
			NoSuchProjectsException {

		return _projectsLocalService.updateStatus(projectId, status);
	}

	@Override
	public ProjectsLocalService getWrappedService() {
		return _projectsLocalService;
	}

	@Override
	public void setWrappedService(ProjectsLocalService projectsLocalService) {
		_projectsLocalService = projectsLocalService;
	}

	private ProjectsLocalService _projectsLocalService;

}