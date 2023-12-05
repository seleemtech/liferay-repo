package com.esqure.intranet.project.management.web.action;

import com.esquare.intranet.project.management.constants.ProjectConstant;
import com.esquare.intranet.project.management.service.TeamMembersLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Mahammed Seleem
 * @Description This class is used for adding resources to TeamMember Entity.
 * @Creation_Date 29/8/2023
 * @Version : 2
 * @module :
 */
@Component(
        property = {
                "javax.portlet.name=" + ProjectConstant.PROJECT_MANAGEMENT_PORTLET,
                "mvc.command.name=project/addResources"
        },
        service = MVCActionCommand.class
)
public class AddResourceMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String userIds = ParamUtil.getString(actionRequest, "userIds");
        long projectId = ParamUtil.getLong(actionRequest, "projectId");
        String[] userIdsArray = userIds.split(StringPool.COMMA);
        for (String userId : userIdsArray) {
            try {
                long userIdValue = Long.parseLong(userId);
                User user = _userLocalService.getUser(userIdValue);
                List<Role> roleList = user.getRoles();
                String roleNames = roleList.stream()
                        .filter(role -> ArrayUtil.contains(ProjectConstant.ROLE_NAMES, role.getName()))
                        .map(Role::getName)
                        .collect(Collectors.joining(StringPool.COMMA));
                _teamMemberLocalService.addTeamMenber(roleNames, user.getUserId(), user.getFullName(), projectId);
            } catch (NumberFormatException e) {
                if (_log.isDebugEnabled()) {
                    _log.debug(e);
                }
            }
        }

    }

    private final Log _log = LogFactoryUtil.getLog(AddResourceMVCActionCommand.class);

    @Reference
    private UserLocalService _userLocalService;
    @Reference
    private TeamMembersLocalService _teamMemberLocalService;

}
