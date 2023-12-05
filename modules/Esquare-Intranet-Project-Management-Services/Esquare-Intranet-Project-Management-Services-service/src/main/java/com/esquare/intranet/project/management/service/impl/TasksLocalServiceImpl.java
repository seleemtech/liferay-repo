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
import com.esquare.intranet.project.management.service.base.TasksLocalServiceBaseImpl;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Mahammed Seleem
 */
@Component(
        property = "model.class.name=com.esquare.intranet.project.management.model.Tasks",
        service = AopService.class
)
public class TasksLocalServiceImpl extends TasksLocalServiceBaseImpl {
    public List<Tasks> getTasksByProjectId(long projectId) {
        return tasksPersistence.findByProjectId(projectId);
    }

    public Tasks updateTasks(long taskId, String taskName, String taskDesc, String developmentTeamIds, String testerTeamIds, Date startDate, Date endDate) {
        Tasks tasks = tasksPersistence.fetchByPrimaryKey(taskId);
        tasks = _updateTask(tasks, startDate, endDate, developmentTeamIds, testerTeamIds, taskName, taskDesc);
        return tasks;
    }

    private Tasks _updateTask(Tasks updateTask, Date startDate, Date endDate, String developmentTeamId, String testerTeamId, String taskName, String taskDesc) {
        updateTask.setName(taskName);
        updateTask.setDescription(taskDesc);
        updateTask.setDeveloperTeam(developmentTeamId);
        updateTask.setTesterTeam(testerTeamId);
        updateTask.setTaskStartDate(startDate);
        updateTask.setTaskEndDate(endDate);
        updateTask = tasksPersistence.update(updateTask);
        return updateTask;
    }

    public Tasks addTasks(
            long projectId,
            String name, String description) {
        Tasks tasks =
                tasksPersistence.create(
                        counterLocalService.increment());
        tasks = _addTasks(
                tasks, projectId, name, description);
        return tasks;
    }

    private Tasks _addTasks(
            Tasks addTasks,
            long projectId, String name, String description) {
        addTasks.setName(name);
        addTasks.setDescription(description);
        addTasks.setProjectId(projectId);
        addTasks.setStatus(WorkflowConstants.STATUS_PENDING);
        addTasks = tasksPersistence.update(
                addTasks);

        return addTasks;
    }
}