package com.comments.headless.internal.resource.v1_0;

import com.comments.headless.dto.v1_0.AssignableUser;
import com.comments.headless.dto.v1_0.WorflowTansition;
import com.comments.headless.dto.v1_0.Workflow;
import com.comments.headless.resource.v1_0.WorkflowResource;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManager;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTransition;
import com.liferay.portal.workflow.security.permission.WorkflowTaskPermission;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author E2Software-011
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/workflow.properties", scope = ServiceScope.PROTOTYPE, service = WorkflowResource.class)
public class WorkflowResourceImpl extends BaseWorkflowResourceImpl {
	@Override
	public Workflow assignToMe(Workflow workflow) throws Exception {
		workflowTaskManager.assignWorkflowTaskToUser(workflow.getCompanyId(), workflow.getUserId(),
				workflow.getWorkflowTaskId(), workflow.getAssigneeUserId(), workflow.getComment(), null, null);

		return workflow;
	}

	@Override
	public Workflow completeAssignTask(Workflow workflow) throws Exception {

		Map<String, Serializable> workflowContext = _getWorkflowContext(workflow.getCompanyId(),
				workflow.getWorkflowTaskId());

		workflowContext.put(WorkflowConstants.CONTEXT_USER_ID, String.valueOf(workflow.getUserId()));
		workflowTaskManager.completeWorkflowTask(workflow.getCompanyId(), workflow.getUserId(),
				workflow.getWorkflowTaskId(), workflow.getTransitionName(), workflow.getComment(), workflowContext);

		return workflow;
	}

	private Map<String, Serializable> _getWorkflowContext(long companyId, long workflowTaskId) throws Exception {

		WorkflowTask workflowTask = workflowTaskManager.getWorkflowTask(workflowTaskId);

		WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId,
				workflowTask.getWorkflowInstanceId());

		return workflowInstance.getWorkflowContext();
	}

	@Override
	public Workflow getWorkflowTask(Long workflowTaskId) throws Exception {
		long companyId = CompanyThreadLocal.getCompanyId();
		WorkflowTask workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(CompanyThreadLocal.getCompanyId(),
				workflowTaskId);
		return _workflow(workflowTask);
	}
	
	private Workflow _workflow(WorkflowTask workflow) {
		return new Workflow() {
			{
				workflowTaskId = workflow.getWorkflowTaskId();
				assigneeUserId = workflow.getAssigneeUserId();
				isAssignedToSingleUser = workflow.isAssignedToSingleUser();
				workflowTaskAssigneeUserName = getWorkflowTaskAssigneeUserNames(workflow);
				TaskContent = HtmlUtil.escape(workflow.getLabel(LocaleThreadLocal.getDefaultLocale()));
				try{
					  List<WorkflowTransition> transitions = getWorkflowTaskWorkflowTransitions(workflow);
					  worflowTansition = transitions.stream()
				                .map(transition -> new WorflowTansition() {
				                    {
				                        label = transition.getName();
				                    }
				                })
				                .toArray(WorflowTansition[]::new);
					  List<User> users = getAssignableUsers(workflow);
					  
					  assignableUser = users.stream().map(user-> new AssignableUser() {
						  {
							name = user.getFullName();
							userId = user.getUserId();
						  }
					  })
					  .toArray(AssignableUser[]::new);
					  companyId = CompanyThreadLocal.getCompanyId();
					  isWorkflowCompleted = workflow.isCompleted();
				}catch (Exception e) {
					_log.error(e);
				}
				
			}
		};
	}
	
	private List<WorkflowTransition> getWorkflowTaskWorkflowTransitions(
			WorkflowTask workflowTask)
		throws PortalException {

		return WorkflowTaskManagerUtil.getWorkflowTaskWorkflowTransitions(
			workflowTask.getWorkflowTaskId());
	}
	
	private List<User> getAssignableUsers(WorkflowTask workflowTask)
			throws PortalException {

			return WorkflowTaskManagerUtil.getAssignableUsers(
				workflowTask.getWorkflowTaskId());
		}
	
	
	private String getWorkflowTaskAssigneeUserNames(WorkflowTask workflowTask) {
		return PortalUtil.getUserName(
			workflowTask.getAssigneeUserId(),
			String.valueOf(workflowTask.getAssigneeUserId()));
	}

	@Reference
	protected WorkflowTaskManager workflowTaskManager;

	@Reference
	private WorkflowTaskPermission _workflowTaskPermission;
	
	private static Log _log = LogFactoryUtil.getLog(WorkflowResourceImpl.class);
}