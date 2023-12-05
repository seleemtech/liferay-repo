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

import com.esquare.intranet.project.management.exception.NoSuchProjectsException;
import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.service.base.ProjectsServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;

/**
 * @author Mahammed Seleem
 */
@Component(
        property = {
                "json.web.service.context.name=esquare",
                "json.web.service.context.path=Projects"
        },
        service = AopService.class
)
public class ProjectsServiceImpl extends ProjectsServiceBaseImpl {


    /**
     * Getting project details based on the projectId
     */
    public Projects getProject(long projectId)
            throws PortalException {

        /** Before getting project details checking the permission  */
		/*_projectsModelResourcePermission.check(
				getPermissionChecker(), projectId, ActionKeys.VIEW);
*/
        return projectsLocalService.fetchProjects(
                projectId);
    }

    public Projects addResourceIdSetting(long projectId, long pmId, long dlId, long opId, long qaId) throws PortalException {

        return projectsLocalService.addResourceIdSetting(projectId, pmId, dlId, opId, qaId);
    }

    public Projects updateStatus(long projectId,int status) throws NoSuchProjectsException {
        return projectsLocalService.updateStatus(projectId,status);
    }

	/*@Reference(
			target = "(model.class.name=com.esquare.intranet.project.management.model.Projects)"
	)
	private ModelResourcePermission<Projects>
			_projectsModelResourcePermission;*/
}