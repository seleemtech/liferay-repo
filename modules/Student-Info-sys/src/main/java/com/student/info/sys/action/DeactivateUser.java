package com.student.info.sys.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.student.info.sys.constants.StudentInfoSysPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + StudentInfoSysPortletKeys.STUDENTINFOSYS,
		"mvc.command.name=/deactivate_user" }, service = MVCActionCommand.class)
public class DeactivateUser extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
	long userId = ParamUtil.getLong(actionRequest, "userId");
	try {
		ServiceContext serviceContext = new ServiceContext();
		_userService.updateStatus(userId, WorkflowConstants.STATUS_INACTIVE, serviceContext);
	} catch (PortalException | SystemException e) {
		SessionErrors.add(actionRequest, "error-deactivating-user");
	}
	
	String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");
	sendRedirect(actionRequest, actionResponse, redirectURL);
	}
	@Reference
	private UserService _userService;
	private final Log logger = LogFactoryUtil.getLog(DeactivateUser.class);
}
