package com.esqure.intranet.project.management.web.action;

import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.model.Tasks;
import com.esquare.intranet.project.management.model.TeamMembers;
import com.esquare.intranet.project.management.service.ProjectsLocalService;
import com.esquare.intranet.project.management.service.TasksLocalService;
import com.esquare.intranet.project.management.service.TasksLocalServiceUtil;
import com.esquare.intranet.project.management.service.TeamMembersLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mahammed Seleem
 * @Description This class is used for removing resources from the projects.
 * @Creation_Date 29/8/2023
 * @Version : 2
 * @module :
 */
@Component(
        property = {
                "javax.portlet.name=" + ProjectConstant.PROJECT_MANAGEMENT_PORTLET,
                "mvc.command.name=project/removeResources"
        },
        service = MVCActionCommand.class
)
public class RemoveResourceMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String memberId = ParamUtil.getString(actionRequest, "memberId");
        try {
            long memberIdValue = Long.parseLong(memberId);
            TeamMembers teamMembers = _teamMemberLocalService.getTeamMembers(memberIdValue);
            if (null != teamMembers) {
                _teamMemberLocalService.deleteTeamMembers(memberIdValue);
                removeResourcesFromResourceIdSettings(teamMembers.getProjectId(), teamMembers.getUserId());
                removeAssignedResourcesFromTasks(teamMembers.getProjectId(), teamMembers.getUserId());
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) {
                _log.debug(e);
            }
        }

    }

    private void removeResourcesFromResourceIdSettings(long projectId, long userId) {

        Projects projects = _projectsLocalService.fetchProjects(projectId);
        if (null != projects) {
            UnicodeProperties resourceSettingsIds = new UnicodeProperties();
            resourceSettingsIds.fastLoad(projects.getResourceIdSettings());

            Arrays.stream(ProjectConstant.PROJECT_RESOURCE_SETTING_KEYS)
                    .filter(resourceSettingsIds::containsKey)
                    .filter(value -> String.valueOf(userId).equals(resourceSettingsIds.getProperty(value)))
                    .forEach(key -> resourceSettingsIds.setProperty(key, "0"));

            projects.setResourceIdSettings(resourceSettingsIds.toString());
            _projectsLocalService.updateProjects(projects);
        }

    }

    private void removeAssignedResourcesFromTasks(long projectId, long userId) {
        List<Tasks> tasks = _tasksLocalService.getTasksByProjectId(projectId);
        tasks.stream().forEach(task -> {
            String developerTeamId = removeUserId(task.getDeveloperTeam(), userId);
            String testerTeamIds = removeUserId(task.getTesterTeam(), userId);

            task.setDeveloperTeam(developerTeamId);
            task.setTesterTeam(testerTeamIds);
            _tasksLocalService.updateTasks(task);
        });

    }

    private String removeUserId(String resourceIdsString, long userId) {
        String[] resourceIds = resourceIdsString.split(StringPool.COMMA);
        List<String> updatedResourceIds = Arrays.stream(resourceIds)
                .filter(id -> !id.isEmpty())
                .filter(id -> !String.valueOf(userId).equals(id)).collect(Collectors.toList());
        return String.join(StringPool.COMMA, updatedResourceIds);
    }

    private final Log _log = LogFactoryUtil.getLog(RemoveResourceMVCActionCommand.class);

    @Reference
    private TeamMembersLocalService _teamMemberLocalService;
    @Reference
    private TasksLocalService _tasksLocalService;
    @Reference
    private ProjectsLocalService _projectsLocalService;

}
