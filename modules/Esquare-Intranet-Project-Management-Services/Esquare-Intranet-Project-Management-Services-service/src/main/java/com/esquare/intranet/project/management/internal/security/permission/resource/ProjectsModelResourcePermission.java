/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 *//*


package com.esquare.intranet.project.management.internal.security.permission.resource;

import com.esquare.intranet.project.management.constant.ProjectConstant;
import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.service.ProjectsLocalService;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

*/
/**
 * @author Mahammed Seleem
 *//*

@Component(
        property = "model.class.name=com.esquare.intranet.project.management.model.Projects",
        service = ModelResourcePermission.class
)
public class ProjectsModelResourcePermission
        implements ModelResourcePermission<Projects> {

    @Override
    public void check(
            PermissionChecker permissionChecker,
            Projects project, String actionId)
            throws PortalException {

        if (!contains(permissionChecker, project, actionId)) {
            throw new PrincipalException.MustHavePermission(
                    permissionChecker, Projects.class.getName(),
                    project.getPrimaryKey(), actionId);
        }
    }

    @Override
    public void check(
            PermissionChecker permissionChecker, long projectId,
            String actionId)
            throws PortalException {

        if (!contains(permissionChecker, projectId, actionId)) {
            throw new PrincipalException.MustHavePermission(
                    permissionChecker, Projects.class.getName(),
                    projectId, actionId);
        }
    }

    @Override
    public boolean contains(
            PermissionChecker permissionChecker,
            Projects project, String actionId)
            throws PortalException {

        if (permissionChecker.hasOwnerPermission(
                permissionChecker.getCompanyId(),
                ListTypeDefinition.class.getName(),
                project.getProjectId(),
                project.getUserId(), actionId) ||
                permissionChecker.hasPermission(
                        null, Projects.class.getName(),
                        project.getPrimaryKey(), actionId)) {

            return true;
        }

        return false;
    }

    @Override
    public boolean contains(
            PermissionChecker permissionChecker, long projectId,
            String actionId)
            throws PortalException {

        return contains(
                permissionChecker,
                _projectsLocalService.getProjects(
                        projectId),
                actionId);
    }

    @Override
    public String getModelName() {
        return Projects.class.getName();
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {
        return _portletResourcePermission;
    }

    @Reference
    private ProjectsLocalService _projectsLocalService;

    @Reference(
            target = "(resource.name=" + ProjectConstant.RESOURCE_NAME + ")"
    )
    private PortletResourcePermission _portletResourcePermission;

}*/
