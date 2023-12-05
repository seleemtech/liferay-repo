package com.esquare.intranet.project.headless.internal.resource.v1_0;

import com.esquare.intranet.helpdesk.web.portlet.workflow.CustomWorkflowConstants;
import com.esquare.intranet.project.headless.dto.v1_0.Project;
import com.esquare.intranet.project.headless.dto.v1_0.Status;
import com.esquare.intranet.project.headless.dto.v1_0.Task;
import com.esquare.intranet.project.headless.resource.v1_0.TaskResource;

import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.model.Tasks;
import com.esquare.intranet.project.management.service.ProjectsService;
import com.esquare.intranet.project.management.service.TasksLocalService;
import com.esquare.intranet.project.management.service.TasksService;
import com.esquare.intranet.project.management.service.TeamMembersService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mahammed Seleem
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/task.properties",
        scope = ServiceScope.PROTOTYPE, service = TaskResource.class
)
public class TaskResourceImpl extends BaseTaskResourceImpl {
    @Override
    public Task postUpdateTask(Task task) throws Exception {

        return _toTask(tasksService.updateTask(task.getId(), task.getName(), task.getDescription(), task.getDevelopmentTeamIds(), task.getTesterTeamIds(), task.getTaskStartDate(), task.getTaskEndDate()));
    }

    @Override
    public Page<Task> getGetTasksProjectPage(Long projectId) throws Exception {

        List<Task> tasksPage = new ArrayList<>();
        List<Tasks> tasksList = tasksService.getTasksByProjectId(projectId);
        tasksList.stream().forEach(tasks -> tasksPage.add(_toTask(tasks)));

        for(Tasks tasj:tasksList){
            tasksPage.add(_toTask(tasj));
        }
        return Page.of(tasksPage);
    }

    @Override
    public Task postPostTask(Task task) throws Exception {
        return _toTask(tasksService.addTasks(task.getProjectId(), task.getName(), task.getDescription()));
    }

    private Task _toTask(
            Tasks
                    serviceBuilderTask) {
        return new Task() {
            {
				/*actions = HashMapBuilder
						.put(
								"post",
								addAction(
										null, "getProjectsManagementProject",
										Projects.class.getName(),
										serviceBuilderProjectManagement.getProjectId()
								)
						).build();*/
                name = serviceBuilderTask.getName();
                description =
                        serviceBuilderTask.getDescription();
                taskEndDate = serviceBuilderTask.getTaskEndDate();
                taskStartDate = serviceBuilderTask.getTaskStartDate();
                try {
                    Projects projects = projectsService.getProject(serviceBuilderTask.getProjectId());
                    projectCode = (long) projects.getCode();
                } catch (PortalException e) {
                    if (_log.isDebugEnabled()) {
                        _log.debug(e);
                    }
                }
                projectId = serviceBuilderTask.getProjectId();
                id = serviceBuilderTask.getTaskId();
                /* assigned = teamMembersService.getAssignedMemberName(serviceBuilderTask.getAssigned());*/
                status = new Status() {
                    {
                        code = serviceBuilderTask.getStatus();
                        label = CustomWorkflowConstants.getStatusStyle(serviceBuilderTask.getStatus());
                        label_i18n =
                                CustomWorkflowConstants.getStatusLabel(
                                        serviceBuilderTask.getStatus());
                    }
                };
                developmentTeam = getResourceName(serviceBuilderTask.getDeveloperTeam().split(StringPool.COMMA));
                testerTeam = getResourceName(serviceBuilderTask.getTesterTeam().split(StringPool.COMMA));

            }
        };
    }

    private String getResourceName(String[] resourceIds) {
        return Arrays.stream(resourceIds)
                .filter(s -> !s.isEmpty())
                .mapToLong(Long::parseLong)
                .mapToObj(this::getResourceNameById)
                .collect(Collectors.joining(StringPool.COMMA_AND_SPACE));
    }

    private String getResourceNameById(long resourceId) {
        String userName = StringPool.BLANK;
        try {
            if (resourceId > 0) {
                User user = UserLocalServiceUtil.getUser(resourceId);
                userName = user.getFullName();
            }
        } catch (PortalException e) {
            if (_log.isDebugEnabled()) {
                _log.debug(e);
            }
            e.printStackTrace();
        }
        return userName;
    }

    @Reference
    private Language _language;
    @Reference
    private TeamMembersService teamMembersService;
    @Reference
    private ProjectsService projectsService;
    @Reference
    private TasksService tasksService;

    private Log _log = LogFactoryUtil.getLog(TaskResourceImpl.class);
}