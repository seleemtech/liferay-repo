package com.esqure.intranet.project.management.web.headless.display.context;


import com.esquare.intranet.helpdesk.web.portlet.workflow.CustomWorkflowConstants;
import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.model.TeamMembers;
import com.esquare.intranet.project.management.service.TeamMembersLocalServiceUtil;
import com.esqure.intranet.project.management.web.headless.helper.APIClient;
import com.esqure.intranet.project.management.web.headless.helper.ProjectRequestHelper;
import com.liferay.frontend.data.set.model.FDSActionDropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Mahammed Seleem
 */
public class ProjectListDisplayContext {
    public ProjectListDisplayContext(
            HttpServletRequest httpServletRequest, RenderRequest renderRequest,
            RenderResponse renderResponse, List<Projects> projectsList
    ) {
        _renderRequest = renderRequest;
        _renderResponse = renderResponse;
        _projectList = projectsList;
        _projectRequestHelper = new ProjectRequestHelper(httpServletRequest);
        _themeDisplay = _projectRequestHelper.getThemeDisplay();

    }


    public String getAPIURL() {
        return "/o/esquare/intranet/project/headless/v1.0/projects-management";
    }

    public String getProjectUpdateStatusAPIURL() {
        return "/o/esquare/intranet/project/headless/v1.0/post-project-status";
    }

    public String getAssignResourceAPIURL() {
        return "/o/esquare/intranet/project/headless/v1.0/post-resources";
    }

    public CreationMenu getCreationMenu() {
        CreationMenu creationMenu = new CreationMenu();
        creationMenu.addDropdownItem(
                dropdownItem -> {
                    dropdownItem.setHref(
                            _renderResponse.createRenderURL(),
                            "mvcRenderCommandName",
                            "/project_admin/edit_project"
                    );
                    dropdownItem.setLabel(
                            LanguageUtil.get(
                                    _projectRequestHelper.getRequest(), "add-project"));
                });

        return creationMenu;
    }

    public CreationMenu getTaskCreationMenu() {
        CreationMenu creationMenu = new CreationMenu();
        creationMenu.addDropdownItem(
                dropdownItem -> {
                    dropdownItem.setHref("addTask");
                    dropdownItem.setLabel(
                            LanguageUtil.get(
                                    _projectRequestHelper.getRequest(), "add-picklist"));
                    dropdownItem.setTarget("event");
                });


        return creationMenu;
    }

    /**
     * @Descriptions: Returning TeamMemberList Based on projectId
     * @Params: projectId
     */
    public List<TeamMembers> memberList(long projectId) {
        List<TeamMembers> teamMembersList = TeamMembersLocalServiceUtil.getTeamMembersByProjectId(projectId);

        return teamMembersList;
    }


    /**
     * @Descriptions: Returning UserList Based on RoleNames
     * @Params: projectId
     */
    public List<User> getResourcesList(long projectId) {
        List<Role> roleList = RoleLocalServiceUtil.getTypeRoles(RoleConstants.TYPE_REGULAR, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        long[] roleIds = roleList.stream()
                .filter(role -> ArrayUtil.contains(ProjectConstant.ROLE_NAMES, role.getName()))
                .mapToLong(Role::getRoleId)
                .toArray();
        List<User> userList = Arrays.stream(roleIds)
                .boxed() // Convert long to Long
                .flatMap(roleId -> UserLocalServiceUtil.getRoleUsers(roleId).stream())
                .distinct()
                .collect(Collectors.toList());

        return getExcludeResourcesListFromTeamMembersTable(projectId, userList);
    }


    /**
     * @Descriptions: Filter the userList to exclude users if matching with TeamMembers Table
     * @params : projectId
     * : UserList
     */
    private List<User> getExcludeResourcesListFromTeamMembersTable(long projectId, List<User> userList) {
        List<TeamMembers> teamMemberList = TeamMembersLocalServiceUtil.getTeamMembersByProjectId(projectId);
        Set<Long> teamMembersUserIds = teamMemberList.stream()
                .map(TeamMembers::getUserId)
                .collect(Collectors.toSet());
        userList = userList.stream()
                .filter(user -> !teamMembersUserIds.contains(user.getUserId()))
                .collect(Collectors.toList());

        return userList;
    }

    /**
     * @Descriptions: Returning roleName Based on userId
     * @Params: UserList
     * : userId
     */
    public String getRoleName(List<User> userList, long userId) {
        Optional<String> roleName = Optional.of(userList.stream()
                .filter(user -> user.getUserId() == userId)
                .flatMap(user -> user.getRoles().stream()).filter(role -> ArrayUtil.contains(ProjectConstant.ROLE_NAMES, role.getName()))
                .map(Role::getName)
                .collect(Collectors.joining(StringPool.COMMA_AND_SPACE)));
        return roleName.orElse(StringPool.BLANK);
    }

    /**
     * @Descriptions: Returning roleName Based on memberId
     * @Params: UserList
     * : userId
     */
    public String getRoleNameByMemberId(long memberId) throws PortalException {
        TeamMembers teamMembers = TeamMembersLocalServiceUtil.fetchTeamMembers(memberId);
        User user = UserLocalServiceUtil.getUser(teamMembers.getUserId());
        String roleName = user.getRoles().stream().filter(role -> ArrayUtil.contains(ProjectConstant.ROLE_NAMES, role.getName()))
                .map(Role::getName).collect(Collectors.joining(StringPool.COMMA));
        return roleName;
    }

    /**
     * @Descriptions: Returning memberName/resourceName Based on userId
     * @Params: userId
     */
    public String getMemberNameByUserId(String stringUserId) {
        String memberName = StringPool.BLANK;
        try {
            long userId = Long.parseLong(stringUserId);
            if (userId > 0) {
                TeamMembers teamMembers = TeamMembersLocalServiceUtil.getTeamMemberByUserId(userId);
                memberName = teamMembers.getName();
            }
        } catch (Exception e) {

        }
        return memberName;
    }

    /**
     * @Descriptions: Returning UserList Based on the roleName
     * @Params: projectId
     * : roleName
     */
    public Map<Long, String> getResourceListByRoleName(long projectId, String roleName) {
        List<TeamMembers> teamMembers = TeamMembersLocalServiceUtil.getTeamMembersByProjectId(projectId);
        Map<Long, String> userFilteredList = new HashMap<>();
        teamMembers.stream().forEach(teamMember -> {
            try {
                User user = UserLocalServiceUtil.getUser(teamMember.getUserId());
                // Filter roles by matching the specified role
                boolean hasRole = user.getRoles().stream().anyMatch(role -> roleName.equals(role.getName()));
                if (hasRole) {
                    userFilteredList.put(user.getUserId(), user.getFullName());
                }
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
        });
        return userFilteredList;
    }

    public Map<Integer, String> getProjectStatus() {
        Map<Integer, String> projectStatusList = new HashMap<>();
        projectStatusList.put(CustomWorkflowConstants.STATUS_NEW, CustomWorkflowConstants.LABEL_NEW);
        projectStatusList.put(CustomWorkflowConstants.STATUS_IN_PROCESS, CustomWorkflowConstants.LABEL_IN_PROCESS);
        projectStatusList.put(CustomWorkflowConstants.STATUS_NOT_STARTED, CustomWorkflowConstants.LABEL_NOT_STARTED);
        projectStatusList.put(CustomWorkflowConstants.STATUS_CANCELLED, CustomWorkflowConstants.LABEL_CANCELLED);
        projectStatusList.put(CustomWorkflowConstants.STATUS_ON_HOLD, CustomWorkflowConstants.LABEL_ON_HOLD);
        return projectStatusList;
    }

   /* public List<FDSActionDropdownItem> getFDSActionDropdownItems(List<Projects> projectsList) throws Exception {
        List<FDSActionDropdownItem> actionDropdownItems = new ArrayList<>();
        Map<Long, Integer> projectStatusList = APIClient.apiGet(getAPIURL(), _themeDisplay);

        // Use a set to keep track of processed project IDs
        Set<Long> processedProjectIds = new HashSet<>();

        for (Map.Entry<Long, Integer> projectStatus : projectStatusList.entrySet()) {
            for (Projects project : projectsList) {
                // Check if the project ID has already been processed
                if (!processedProjectIds.contains(project.getProjectId())) {
                    if (projectStatus.getKey() == project.getProjectId()) {
                        actionDropdownItems.addAll(createDropdownItemsForProject(project));
                        // Mark the project ID as processed
                        processedProjectIds.add(project.getProjectId());
                    }
                }
            }
        }

        return actionDropdownItems;
    }*/

    private List<FDSActionDropdownItem> createDropdownItemsForProject(Projects project) throws PortletException {
        List<FDSActionDropdownItem> dropdownItems = new ArrayList<>();

        dropdownItems.add(
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                getPortletURL()
                        ).setMVCRenderCommandName(
                                "/project_admin/edit_project"
                        ).setParameter(
                                "projectId", "{id}"
                        ).setWindowState(
                                LiferayWindowState.NORMAL
                        ).buildString(),
                        "pencil", "edit",
                        LanguageUtil.get(_projectRequestHelper.getRequest(), "edit"),
                        "", null, ""));
        dropdownItems.add(
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                        getPortletURL()
                                ).setMVCRenderCommandName(
                                        "/project_admin/view_single_project"
                                ).setParameter(
                                        "projectId", "{id}")
                                .setParameter(
                                        "view", "view"
                                ).setWindowState(
                                        LiferayWindowState.NORMAL
                                ).buildString(),
                        "view", "view",
                        LanguageUtil.get(_projectRequestHelper.getRequest(), "view"),
                        "", null, ""));
        dropdownItems.add(
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                getPortletURL()
                        ).setMVCRenderCommandName(
                                "/project_admin/update_Status"
                        ).setParameter(
                                "projectId", "{id}"
                        ).setWindowState(
                                LiferayWindowState.POP_UP
                        ).buildString(),
                        "",
                        "view",
                        LanguageUtil.get(_projectRequestHelper.getRequest(), "Update Status"),
                        "", // Call your JavaScript function here
                        null,
                        "sidePanel"
                )
        );
        // Conditionally add the "Assign Resources" dropdown item based on the project status
        if (CustomWorkflowConstants.STATUS_IN_PROCESS == project.getStatus()) {
            dropdownItems.add(
                    new FDSActionDropdownItem(
                            PortletURLBuilder.create(
                                    getPortletURL()
                            ).setMVCRenderCommandName(
                                    "/project_admin/add_resources"
                            ).setParameter(
                                    "projectId", "{id}"
                            ).setWindowState(
                                    LiferayWindowState.NORMAL
                            ).buildString(),
                            "users", "view",
                            LanguageUtil.get(_projectRequestHelper.getRequest(), "Add Resources"),
                            "", null, "")
            );
            dropdownItems.add(
                    new FDSActionDropdownItem(
                            PortletURLBuilder.create(
                                    getPortletURL()
                            ).setMVCRenderCommandName(
                                    "/project_admin/view_resources"
                            ).setParameter(
                                    "projectId", "{id}"
                            ).setWindowState(
                                    LiferayWindowState.NORMAL
                            ).buildString(),
                            "view", "view",
                            LanguageUtil.get(_projectRequestHelper.getRequest(), "View Resources"),
                            "", null, "")
            );
            dropdownItems.add(
                    new FDSActionDropdownItem(
                            PortletURLBuilder.create(
                                    getPortletURL()
                            ).setMVCRenderCommandName(
                                    "/project_admin/assign_project_to_resources"
                            ).setParameter(
                                    "projectId", "{id}"
                            ).setWindowState(
                                    LiferayWindowState.NORMAL
                            ).buildString(),
                            "add-role", "edit",
                            LanguageUtil.get(_projectRequestHelper.getRequest(), "Assign Resources"),
                            "", null, "sidePanel")
            );
            dropdownItems.add(
                    new FDSActionDropdownItem(
                            PortletURLBuilder.create(
                                    getPortletURL()
                            ).setMVCRenderCommandName(
                                    "/task_admin/add_task"
                            ).setParameter(
                                    "projectId", "{id}"
                            ).setWindowState(
                                    LiferayWindowState.NORMAL
                            ).buildString(),
                            "plus-squares", "view",
                            LanguageUtil.get(_projectRequestHelper.getRequest(), "view Task"),
                            "", null, "")
            );
        }


        return dropdownItems;
    }


    public List<FDSActionDropdownItem> getFDSActionDropdownItems()
            throws Exception {
        return Arrays.asList(
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                getPortletURL()
                        ).setMVCRenderCommandName(
                                "/project_admin/edit_project"
                        ).setParameter(
                                "projectId", "{id}"
                        ).setWindowState(
                                LiferayWindowState.NORMAL
                        ).buildString(),
                        "pencil", "edit",
                        LanguageUtil.get(_projectRequestHelper.getRequest(), "edit"),
                        "", null, ""),
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                        getPortletURL()
                                ).setMVCRenderCommandName(
                                        "/project_admin/view_single_project"
                                ).setParameter(
                                        "projectId", "{id}")
                                .setParameter(
                                        "view", "view"
                                ).setWindowState(
                                        LiferayWindowState.NORMAL
                                ).buildString(),
                        "view", "view",
                        LanguageUtil.get(_projectRequestHelper.getRequest(), "view"),
                        "", null, ""),
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                getPortletURL()
                        ).setMVCRenderCommandName(
                                "/project_admin/add_resources"
                        ).setParameter(
                                "projectId", "{id}"
                        ).setWindowState(
                                LiferayWindowState.NORMAL
                        ).buildString(),
                        "users", "view",
                        LanguageUtil.get(_projectRequestHelper.getRequest(), "Add Resources"),
                        "", null, ""),
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                getPortletURL()
                        ).setMVCRenderCommandName(
                                "/project_admin/view_resources"
                        ).setParameter(
                                "projectId", "{id}"
                        ).setWindowState(
                                LiferayWindowState.NORMAL
                        ).buildString(),
                        "view", "view",
                        LanguageUtil.get(_projectRequestHelper.getRequest(), "View Resources"),
                        "", null, ""),
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                getPortletURL()
                        ).setMVCRenderCommandName(
                                "/project_admin/assign_project_to_resources"
                        ).setParameter(
                                "projectId", "{id}"
                        ).setWindowState(
                                LiferayWindowState.NORMAL
                        ).buildString(),
                        "add-role", "edit",
                        LanguageUtil.get(_projectRequestHelper.getRequest(), "Assign Resources"),
                        "", null, "sidePanel"),
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                getPortletURL()
                        ).setMVCRenderCommandName(
                                "/task_admin/add_task"
                        ).setParameter(
                                "projectId", "{id}"
                        ).setWindowState(
                                LiferayWindowState.NORMAL
                        ).buildString(),
                        "plus-squares", "view",
                        LanguageUtil.get(_projectRequestHelper.getRequest(), "view Task"),
                        "", null, ""),
                new FDSActionDropdownItem(
                        PortletURLBuilder.create(
                                getPortletURL()
                        ).setMVCRenderCommandName(
                                "/project_admin/update_Status"
                        ).setParameter(
                                "projectId", "{id}"
                        ).setWindowState(
                                LiferayWindowState.POP_UP
                        ).buildString(),
                        "",
                        "view",
                        LanguageUtil.get(_projectRequestHelper.getRequest(), "Update Status"),
                        "", // Call your JavaScript function here
                        null,
                        "sidePanel"
                )
        );


    }

    public PortletURL getPortletURL() throws PortletException {
        return PortletURLUtil.clone(
                PortletURLUtil.getCurrent(
                        _projectRequestHelper.getLiferayPortletRequest(),
                        _projectRequestHelper.getLiferayPortletResponse()),
                _projectRequestHelper.getLiferayPortletResponse());
    }


    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
    private final ThemeDisplay _themeDisplay;
    private final List<Projects> _projectList;
    private final ProjectRequestHelper _projectRequestHelper;

}





