package com.esqure.intranet.project.management.web.headless.display.context;


import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.esquare.intranet.project.management.model.Tasks;
import com.esquare.intranet.project.management.model.TeamMembers;
import com.esquare.intranet.project.management.service.TasksLocalServiceUtil;
import com.esquare.intranet.project.management.service.TeamMembersLocalServiceUtil;
import com.esqure.intranet.project.management.web.headless.helper.TaskRequestHelper;
import com.liferay.frontend.data.set.model.FDSActionDropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * @author Mahammed Seleem
 */
public class TaskListDisplayContext {
    public TaskListDisplayContext(
            HttpServletRequest httpServletRequest, RenderRequest renderRequest,
            RenderResponse renderResponse
    ) {
        _renderRequest = renderRequest;
        _renderResponse = renderResponse;

        _taskRequestHelper = new TaskRequestHelper(httpServletRequest);
    }


    public String getAPIURL(long projectId) {
        return "/o/esquare/intranet/project/headless/v1.0/get-task/" + projectId;
    }

    public String postAPIURL() {

        return "/o/esquare/intranet/project/headless/v1.0/post-task";
    }

    public String updateAPIURL() {

        return "/o/esquare/intranet/project/headless/v1.0/update-task";
    }

    public CreationMenu getCreationMenu() {
        CreationMenu creationMenu = new CreationMenu();
        creationMenu.addDropdownItem(
                dropdownItem -> {
                    dropdownItem.setHref("addTask");
                    dropdownItem.setLabel(
                            LanguageUtil.get(
                                    _taskRequestHelper.getRequest(), "Add Task"));
                    dropdownItem.setTarget("event");
                });

        return creationMenu;
    }

    /**
     * @Descriptions: Returning UserList Based on the roleName
     * @Params: projectId
     * : roleName
     */
    public Map<String, List<Map<String, String>>> getUserListByRoleName(long projectId, String roleName, long taskId) {
        Map<String, List<Map<String, String>>> resultMap = new HashMap<>();
        List<Map<String, String>> leftSideList = new ArrayList<>();
        List<Map<String, String>> rightSideList = new ArrayList<>();
        List<TeamMembers> teamMembers = TeamMembersLocalServiceUtil.getTeamMembersByProjectId(projectId);
        Tasks task = TasksLocalServiceUtil.fetchTasks(taskId);
        String[] userIds;
        if (null != task) {
            userIds = roleName.equals(ProjectConstant.PROJECT_DEVELOPER_TEAM)
                    ? task.getDeveloperTeam().split(StringPool.COMMA)
                    : task.getTesterTeam().split(StringPool.COMMA);
        } else {
            userIds = StringPool.EMPTY_ARRAY;
        }

        teamMembers.stream().forEach(teamMember -> {
            try {
                User user = UserLocalServiceUtil.getUser(teamMember.getUserId());
                if (!Arrays.asList(userIds).contains(String.valueOf(user.getUserId()))) {
                    boolean hasRole = user.getRoles().stream().anyMatch(role -> roleName.equals(role.getName()));

                    if (hasRole) {
                        Map<String, String> leftSideItem = new HashMap<>();
                        leftSideItem.put("value", String.valueOf(user.getUserId()));
                        leftSideItem.put("label", user.getFullName());
                        leftSideList.add(leftSideItem);
                    }
                }
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
        });
        Arrays.stream(userIds).forEach(userId -> {
            try {
                if (!userId.isEmpty()){
                    User user = UserLocalServiceUtil.getUser(Long.parseLong(userId));
                    Map<String, String> rightSideItem = new HashMap<>();
                    rightSideItem.put("value", String.valueOf(user.getUserId()));
                    rightSideItem.put("label", user.getFullName());
                    rightSideList.add(rightSideItem);
                }
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
        });

        resultMap.put("leftSide", leftSideList);
        resultMap.put("rightSide", rightSideList);

        return resultMap;
    }

    public List<FDSActionDropdownItem> getFDSActionDropdownItems()
            throws Exception {
        return Arrays.asList(
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                getPortletURL()
                        ).setMVCRenderCommandName(
                                "/task_admin/assign_task_to_resources"
                        ).setParameter(
                                "taskId", "{id}"
                        ).setWindowState(
                                LiferayWindowState.NORMAL
                        ).buildString(),
                        "pencil", "edit",
                        LanguageUtil.get(_taskRequestHelper.getRequest(), "edit"),
                        "", null, "sidePanel")

        );


    }


    public PortletURL getPortletURL() throws PortletException {
        return PortletURLUtil.clone(
                PortletURLUtil.getCurrent(
                        _taskRequestHelper.getLiferayPortletRequest(),
                        _taskRequestHelper.getLiferayPortletResponse()),
                _taskRequestHelper.getLiferayPortletResponse());
    }


    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
    private final TaskRequestHelper _taskRequestHelper;


}





