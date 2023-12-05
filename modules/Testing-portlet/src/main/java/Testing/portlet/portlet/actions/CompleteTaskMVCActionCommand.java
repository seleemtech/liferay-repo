/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package Testing.portlet.portlet.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;

import java.io.Serializable;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Testing.portlet.constants.TestingPortletKeys;

/**
 * @author Leonardo Barros
 */
@Component(
	property = {
		"javax.portlet.name=" + TestingPortletKeys.TESTING,
		"mvc.command.name=/custom/portal_workflow_task/complete_task"
	},
	service = MVCActionCommand.class
)
public class CompleteTaskMVCActionCommand
	extends BaseWorkflowTaskMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		System.out.println("CompleteTaskMVCActionCommand");
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long workflowTaskId = ParamUtil.getLong(
			actionRequest, "workflowTaskId");

		String transitionName = ParamUtil.getString(
			actionRequest, "transitionName");
		String comment = ParamUtil.getString(actionRequest, "comment");

		Map<String, Serializable> workflowContext = _getWorkflowContext(
			themeDisplay.getCompanyId(), workflowTaskId);

		ServiceContext serviceContext = (ServiceContext)workflowContext.get(
			"serviceContext");

		serviceContext.setRequest(
			_getHttpServletRequest(actionRequest, actionResponse));

		workflowContext.put(
			WorkflowConstants.CONTEXT_USER_ID,
			String.valueOf(themeDisplay.getUserId()));

		workflowTaskManager.completeWorkflowTask(
			themeDisplay.getCompanyId(), themeDisplay.getUserId(),
			workflowTaskId, transitionName, comment, workflowContext);
	}

	@Reference
	protected WorkflowTaskManager workflowTaskManager;

	private HttpServletRequest _getHttpServletRequest(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		HttpServletRequest httpServletRequest = _portal.getHttpServletRequest(
			actionRequest);

		PortletResponse portletResponse =
			(PortletResponse)httpServletRequest.getAttribute(
				JavaConstants.JAVAX_PORTLET_RESPONSE);

		if (portletResponse == null) {
			httpServletRequest.setAttribute(
				JavaConstants.JAVAX_PORTLET_RESPONSE,
				_portal.getLiferayPortletResponse(actionResponse));
		}

		return httpServletRequest;
	}

	private Map<String, Serializable> _getWorkflowContext(
			long companyId, long workflowTaskId)
		throws Exception {

		WorkflowTask workflowTask = workflowTaskManager.getWorkflowTask(
			workflowTaskId);

		WorkflowInstance workflowInstance =
			WorkflowInstanceManagerUtil.getWorkflowInstance(
				companyId, workflowTask.getWorkflowInstanceId());

		return workflowInstance.getWorkflowContext();
	}

	@Reference
	private Portal _portal;

}