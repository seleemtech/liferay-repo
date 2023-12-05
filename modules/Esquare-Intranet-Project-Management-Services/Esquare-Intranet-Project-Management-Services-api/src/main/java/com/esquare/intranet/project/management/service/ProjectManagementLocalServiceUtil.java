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

import com.esquare.intranet.project.management.model.ProjectManagement;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProjectManagement. This utility wraps
 * <code>com.esquare.intranet.project.management.service.impl.ProjectManagementLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mahammed Seleem
 * @see ProjectManagementLocalService
 * @generated
 */
public class ProjectManagementLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.esquare.intranet.project.management.service.impl.ProjectManagementLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ProjectManagement addProjectManagement(
		ProjectManagement projectManagement) {

		return getService().addProjectManagement(projectManagement);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new project management with the primary key. Does not add the project management to the database.
	 *
	 * @param projectMgmtId the primary key for the new project management
	 * @return the new project management
	 */
	public static ProjectManagement createProjectManagement(
		long projectMgmtId) {

		return getService().createProjectManagement(projectMgmtId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static ProjectManagement deleteProjectManagement(long projectMgmtId)
		throws PortalException {

		return getService().deleteProjectManagement(projectMgmtId);
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
	public static ProjectManagement deleteProjectManagement(
		ProjectManagement projectManagement) {

		return getService().deleteProjectManagement(projectManagement);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ProjectManagement fetchProjectManagement(long projectMgmtId) {
		return getService().fetchProjectManagement(projectMgmtId);
	}

	/**
	 * Returns the project management matching the UUID and group.
	 *
	 * @param uuid the project management's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project management, or <code>null</code> if a matching project management could not be found
	 */
	public static ProjectManagement fetchProjectManagementByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProjectManagementByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the project management with the primary key.
	 *
	 * @param projectMgmtId the primary key of the project management
	 * @return the project management
	 * @throws PortalException if a project management with the primary key could not be found
	 */
	public static ProjectManagement getProjectManagement(long projectMgmtId)
		throws PortalException {

		return getService().getProjectManagement(projectMgmtId);
	}

	/**
	 * Returns the project management matching the UUID and group.
	 *
	 * @param uuid the project management's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project management
	 * @throws PortalException if a matching project management could not be found
	 */
	public static ProjectManagement getProjectManagementByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getProjectManagementByUuidAndGroupId(uuid, groupId);
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
	public static List<ProjectManagement> getProjectManagements(
		int start, int end) {

		return getService().getProjectManagements(start, end);
	}

	/**
	 * Returns all the project managements matching the UUID and company.
	 *
	 * @param uuid the UUID of the project managements
	 * @param companyId the primary key of the company
	 * @return the matching project managements, or an empty list if no matches were found
	 */
	public static List<ProjectManagement>
		getProjectManagementsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getProjectManagementsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<ProjectManagement>
		getProjectManagementsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ProjectManagement> orderByComparator) {

		return getService().getProjectManagementsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of project managements.
	 *
	 * @return the number of project managements
	 */
	public static int getProjectManagementsCount() {
		return getService().getProjectManagementsCount();
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
	public static ProjectManagement updateProjectManagement(
		ProjectManagement projectManagement) {

		return getService().updateProjectManagement(projectManagement);
	}

	public static ProjectManagementLocalService getService() {
		return _service;
	}

	private static volatile ProjectManagementLocalService _service;

}