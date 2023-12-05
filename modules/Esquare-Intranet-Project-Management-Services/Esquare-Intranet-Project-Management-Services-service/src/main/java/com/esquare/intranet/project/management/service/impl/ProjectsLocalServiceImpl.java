/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.esquare.intranet.project.management.service.impl;

import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.esquare.intranet.project.management.exception.NoSuchProjectsException;
import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.service.base.ProjectsLocalServiceBaseImpl;
import com.liferay.account.model.AccountEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.workflow.WorkflowEngineManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowThreadLocal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author Mahammed Seleem
 */
@Component(
        property = "model.class.name=com.esquare.intranet.project.management.model.Projects",
        service = AopService.class
)
public class ProjectsLocalServiceImpl extends ProjectsLocalServiceBaseImpl {


    public Projects getProject(long projectId) throws NoSuchProjectsException {
        return projectsPersistence.findByPrimaryKey(projectId);
    }

    public Projects addResourceIdSetting(long projectId, long pmId, long dlId, long opId, long qaId) throws NoSuchProjectsException {
        Projects projects = projectsPersistence.findByPrimaryKey(projectId);
        UnicodeProperties resourceIdSettings = new UnicodeProperties();
        resourceIdSettings.setProperty(ProjectConstant.PROJECT_MANAGER_ID, String.valueOf(pmId));
        resourceIdSettings.setProperty(ProjectConstant.DELIVERY_LEAD_ID, String.valueOf(dlId));
        resourceIdSettings.setProperty(ProjectConstant.OPERATION_LEAD_ID, String.valueOf(opId));
        resourceIdSettings.setProperty(ProjectConstant.PROJECT_QA_LEAD_ID, String.valueOf(qaId));
        projects = _addResourceIdSetting(projects, resourceIdSettings.toString());
        return projects;
    }

    public Projects _addResourceIdSetting(Projects projects, String resourceIdSettings) {
        projects.setResourceIdSettings(resourceIdSettings);
        projects = projectsPersistence.update(projects);
        return projects;
    }

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    public Projects editProject(long projectId, String projectName, String projectDesc, Date projectProposedDate, Date projectConfirmedDate, Date projectDevelopmentStartDate, Date deliveryEstimatedDate, String projectDurationDate, int projectStatus, int projectCode, long projectDocumentId, String clientName, String contactNumber, String email, ServiceContext serviceContext) throws PortalException {
        Projects projects = null;

        try {
            /** Fetch the project */
            projects = projectsPersistence.findByPrimaryKey(projectId);
            if (null != projects) {
                return updateProjects(projects, projectName, projectDesc, projectProposedDate, projectConfirmedDate, projectDevelopmentStartDate, deliveryEstimatedDate, projectDurationDate, projectStatus, projectCode, projectDocumentId, clientName, contactNumber, email, serviceContext);
            }
        } catch (NoSuchProjectsException e) {
            projects = addProject(
                    projectName, projectDesc, projectProposedDate, projectConfirmedDate,
                    projectDevelopmentStartDate, deliveryEstimatedDate, projectDurationDate, projectStatus, projectCode, projectDocumentId, clientName, contactNumber, email, serviceContext);
            if (_log.isDebugEnabled()) {
                _log.debug(e);
            }
        }

        return projects;
    }

    public Projects updateProjects(Projects projects,
                                   String projectName, String projectDesc, Date projectProposedDate,
                                   Date projectConfirmedDate, Date projectDevelopmentStartDate, Date deliveryEstimatedDate, String projectDurationDate,
                                   int projectStatus, int projectCode, long projectDocumentId, String name,
                                   String contactNumber, String email, ServiceContext serviceContext)
            throws PortalException {

        User user = userLocalService.getUser(serviceContext.getUserId());

        projects.setProjectName(projectName);
        projects.setDescription(projectDesc);
        projects.setProposedDate(projectProposedDate);
        projects.setConfirmedDate(projectConfirmedDate);
        projects.setDevelopmentStartDate(projectDevelopmentStartDate);
        projects.setEstimatedDate(deliveryEstimatedDate);
        projects.setDurationDate(projectDurationDate);
        projects.setStatus(projectStatus);
        projects.setCode(projectCode);
        projects.setDocumentId(projectDocumentId);

        projects.setName(name);
        projects.setContactNumber(contactNumber);
        projects.setContactEmail(email);

        projects.setGroupId(serviceContext.getScopeGroupId());
        projects.setCompanyId(serviceContext.getCompanyId());
        projects.setUserId(serviceContext.getUserId());
        projects.setUserName(user.getScreenName());

        projects = projectsPersistence.update(projects);

       /* ServiceContext workflowServiceContext = new ServiceContext();
        long workflowUserId = projects.getUserId();

        if (serviceContext != null) {

            // Asset

            _updateAsset(projects, serviceContext);

            // Expando

            workflowServiceContext = (ServiceContext) serviceContext.clone();
            workflowUserId = serviceContext.getUserId();
        }

        if (_isWorkflowEnabled(projects.getCompanyId())) {
            _checkStatus(projects.getStatus(), projectStatus);

            projects = _startWorkflowInstance(
                    workflowUserId, projects, workflowServiceContext);
        } else {
            updateStatus(
                    workflowUserId, projects.getProjectId(), projectStatus, workflowServiceContext,
                    Collections.emptyMap());
        }*/

        return projects;
    }


    public Projects addProject(
            String projectName, String projectDesc, Date projectProposedDate,
            Date projectConfirmedDate, Date projectDevelopmentStartDate, Date deliveryEstimatedDate, String projectDurationDate,
            int projectStatus, int projectCode, long projectDocumentId, String name,
            String contactNumber, String email, ServiceContext serviceContext)
            throws PortalException {

        long projectId = counterLocalService.increment();

        Projects projects = projectsPersistence.create(
                projectId);

        User user = _userLocalService.getUser(serviceContext.getUserId());
        projects.setProjectName(projectName);
        projects.setDescription(projectDesc);
        projects.setProposedDate(projectProposedDate);
        projects.setConfirmedDate(projectConfirmedDate);
        projects.setDevelopmentStartDate(projectDevelopmentStartDate);
        projects.setEstimatedDate(deliveryEstimatedDate);
        projects.setDurationDate(projectDurationDate);
        projects.setStatus(projectStatus);
        projects.setCode(projectCode);
        projects.setDocumentId(projectDocumentId);

        /** Client Details */
        projects.setName(name);
        projects.setContactNumber(contactNumber);
        projects.setContactEmail(email);

        /** Audit Details */
        projects.setGroupId(serviceContext.getScopeGroupId());
        projects.setCompanyId(serviceContext.getCompanyId());
        projects.setUserId(serviceContext.getUserId());
        projects.setUserName(user.getScreenName());

        projects = projectsPersistence.update(projects);

      /*  ServiceContext workflowServiceContext = new ServiceContext();

        if (serviceContext != null) {

            // Asset

            _updateAsset(projects, serviceContext);

            // Expando

            workflowServiceContext = (ServiceContext) serviceContext.clone();
        }

        // Workflow

        if (_isWorkflowEnabled(projects.getCompanyId())) {
            _checkStatus(projects.getStatus(), projectStatus);

            projects = _startWorkflowInstance(
                    user.getUserId(), projects, workflowServiceContext);
        } else {
            projects = updateStatus(
                    user.getUserId(), projectId, projectStatus, workflowServiceContext,
                    Collections.emptyMap());
        }*/

        return projects;
    }

    public Projects updateStatus(
            long projectId, int status
    ) throws NoSuchProjectsException {
        Projects projects = getProject(projectId);

        if (projects.getStatus() == status) {
            return projects;
        }
        projects.setStatus(status);
        return updateProjects(projects);
    }

    private void _checkStatus(int oldStatus, int newStatus) {
        if (oldStatus != newStatus) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                        "Workflow is enabled for project. The status will " +
                                "be ignored.");
            }
        }
    }

    private void _updateAsset(
            Projects projects, ServiceContext serviceContext)
            throws PortalException {

        Company company = _companyLocalService.getCompany(
                serviceContext.getCompanyId());

        _assetEntryLocalService.updateEntry(
                serviceContext.getUserId(), company.getGroupId(),
                null, null,
                AccountEntry.class.getName(), projects.getProjectId(),
                null, 0, serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), true, true, null, null, null,
                null, null, projects.getProjectName(), projects.getDescription(),
                null, null, null, 0, 0, null);
    }

    private boolean _isWorkflowEnabled(long companyId) {
        Supplier<WorkflowDefinitionLink> workflowDefinitionLinkSupplier =
                () ->
                        _workflowDefinitionLinkLocalService.fetchWorkflowDefinitionLink(
                                companyId, GroupConstants.DEFAULT_LIVE_GROUP_ID,
                                AccountEntry.class.getName(), 0, 0);

        if (WorkflowThreadLocal.isEnabled() &&
                WorkflowEngineManagerUtil.isDeployed() &&
                (workflowDefinitionLinkSupplier.get() != null)) {

            return true;
        }

        return false;
    }

    private Projects _startWorkflowInstance(
            long workflowUserId, Projects projects,
            ServiceContext workflowServiceContext)
            throws PortalException {

        Map<String, Serializable> workflowContext =
                (Map<String, Serializable>) workflowServiceContext.removeAttribute(
                        "workflowContext");

        if (workflowContext == null) {
            workflowContext = Collections.emptyMap();
        }

        return WorkflowHandlerRegistryUtil.startWorkflowInstance(
                projects.getCompanyId(), GroupConstants.DEFAULT_LIVE_GROUP_ID,
                workflowUserId, AccountEntry.class.getName(),
                projects.getProjectId(), projects,
                workflowServiceContext, workflowContext);
    }

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private CompanyLocalService _companyLocalService;
    @Reference
    private AssetEntryLocalService _assetEntryLocalService;
    private Log _log = LogFactoryUtil.getLog(ProjectsLocalServiceImpl.class);
    @Reference
    private WorkflowDefinitionLinkLocalService
            _workflowDefinitionLinkLocalService;
/* @Reference
    private ResourceLocalService _resourceLocalService;*/
}