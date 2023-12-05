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

import com.esquare.intranet.project.management.model.Tasks;
import com.esquare.intranet.project.management.service.base.TasksServiceBaseImpl;

import com.liferay.list.type.constants.ListTypeActionKeys;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Mahammed Seleem
 */
@Component(
        property = {
                "json.web.service.context.name=esquare",
                "json.web.service.context.path=Tasks"
        },
        service = AopService.class
)
public class TasksServiceImpl extends TasksServiceBaseImpl {

    public List<Tasks> getTasksByProjectId(long projectId) {
        return tasksPersistence.findByProjectId(projectId);
    }

    public Tasks updateTask(long taskId, String taskName, String taskDesc, String developmentTeamIds, String testerTeamIds, Date startDate, Date endDate) {
        return tasksLocalService.updateTasks(taskId, taskName, taskDesc, developmentTeamIds, testerTeamIds, startDate, endDate);
    }

    public Tasks addTasks(
            long projectId, String name,
            String description) {

        return tasksLocalService.addTasks(
                projectId, name, description);
    }

}