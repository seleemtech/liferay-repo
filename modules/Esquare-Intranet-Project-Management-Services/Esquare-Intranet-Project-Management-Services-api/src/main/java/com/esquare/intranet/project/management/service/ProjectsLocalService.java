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

import com.esquare.intranet.project.management.exception.NoSuchProjectsException;
import com.esquare.intranet.project.management.model.Projects;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Projects. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Mahammed Seleem
 * @see ProjectsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ProjectsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.esquare.intranet.project.management.service.impl.ProjectsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the projects local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ProjectsLocalServiceUtil} if injection and service tracking are not available.
	 */
	public Projects _addResourceIdSetting(
		Projects projects, String resourceIdSettings);

	public Projects addProject(
			String projectName, String projectDesc, Date projectProposedDate,
			Date projectConfirmedDate, Date projectDevelopmentStartDate,
			Date deliveryEstimatedDate, String projectDurationDate,
			int projectStatus, int projectCode, long projectDocumentId,
			String name, String contactNumber, String email,
			ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public Projects addProjects(Projects projects);

	public Projects addResourceIdSetting(
			long projectId, long pmId, long dlId, long opId, long qaId)
		throws NoSuchProjectsException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new projects with the primary key. Does not add the projects to the database.
	 *
	 * @param projectId the primary key for the new projects
	 * @return the new projects
	 */
	@Transactional(enabled = false)
	public Projects createProjects(long projectId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Projects deleteProjects(long projectId) throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public Projects deleteProjects(Projects projects);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Projects editProject(
			long projectId, String projectName, String projectDesc,
			Date projectProposedDate, Date projectConfirmedDate,
			Date projectDevelopmentStartDate, Date deliveryEstimatedDate,
			String projectDurationDate, int projectStatus, int projectCode,
			long projectDocumentId, String clientName, String contactNumber,
			String email, ServiceContext serviceContext)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Projects fetchProjects(long projectId);

	/**
	 * Returns the projects matching the UUID and group.
	 *
	 * @param uuid the projects's UUID
	 * @param groupId the primary key of the group
	 * @return the matching projects, or <code>null</code> if a matching projects could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Projects fetchProjectsByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Projects getProject(long projectId) throws NoSuchProjectsException;

	/**
	 * Returns the projects with the primary key.
	 *
	 * @param projectId the primary key of the projects
	 * @return the projects
	 * @throws PortalException if a projects with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Projects getProjects(long projectId) throws PortalException;

	/**
	 * Returns the projects matching the UUID and group.
	 *
	 * @param uuid the projects's UUID
	 * @param groupId the primary key of the group
	 * @return the matching projects
	 * @throws PortalException if a matching projects could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Projects getProjectsByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Projects> getProjectses(int start, int end);

	/**
	 * Returns all the projectses matching the UUID and company.
	 *
	 * @param uuid the UUID of the projectses
	 * @param companyId the primary key of the company
	 * @return the matching projectses, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Projects> getProjectsesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Projects> getProjectsesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Projects> orderByComparator);

	/**
	 * Returns the number of projectses.
	 *
	 * @return the number of projectses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getProjectsesCount();

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
	@Indexable(type = IndexableType.REINDEX)
	public Projects updateProjects(Projects projects);

	public Projects updateProjects(
			Projects projects, String projectName, String projectDesc,
			Date projectProposedDate, Date projectConfirmedDate,
			Date projectDevelopmentStartDate, Date deliveryEstimatedDate,
			String projectDurationDate, int projectStatus, int projectCode,
			long projectDocumentId, String name, String contactNumber,
			String email, ServiceContext serviceContext)
		throws PortalException;

	public Projects updateStatus(long projectId, int status)
		throws NoSuchProjectsException;

}