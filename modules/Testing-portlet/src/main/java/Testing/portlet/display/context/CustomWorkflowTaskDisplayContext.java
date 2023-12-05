package Testing.portlet.display.context;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowTransition;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class CustomWorkflowTaskDisplayContext {

	public CustomWorkflowTaskDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_httpServletRequest = PortalUtil.getHttpServletRequest(liferayPortletRequest);
		_workflowTaskRequestHelper = new CustomWorkflowTaskRequestHelper(
				_httpServletRequest);
	}
	public long getWorkflowContextEntryClassPK(WorkflowTask workflowTask)
			throws PortalException {

			Map<String, Serializable> workflowContext = _getWorkflowContext(
				workflowTask);

			return GetterUtil.getLong(
				(String)workflowContext.get(
					WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
		}
	
	public boolean hasRolePermission(List<Role> roles) {
	    String[] roleNames = {"Workflow Approver", "Workflow Manager"};

	    return roles.stream()
	            .map(Role::getName) 
	            .anyMatch(roleName -> ArrayUtil.contains(roleNames, roleName));
	}
	public String getCurrentURL() {
		PortletURL portletURL = PortletURLUtil.getCurrent(
			_liferayPortletRequest, _liferayPortletResponse);

		return portletURL.toString();
	}

	public Map<String, Object> getWorkflowTaskActionLinkData() {
		return new HashMap<>();
	}
	
	public List<WorkflowTransition> getWorkflowTaskWorkflowTransitions(
			WorkflowTask workflowTask)
		throws PortalException {

		return WorkflowTaskManagerUtil.getWorkflowTaskWorkflowTransitions(
			workflowTask.getWorkflowTaskId());
	}
	public boolean isAssignedToUser(WorkflowTask workflowTask) {
		if (workflowTask.getAssigneeUserId() ==
				_workflowTaskRequestHelper.getUserId()) {

			return true;
		}

		return false;
	}
	public boolean hasAssignableUsers(WorkflowTask workflowTask)
			throws PortalException {

			return WorkflowTaskManagerUtil.hasAssignableUsers(
				_workflowTaskRequestHelper.getCompanyId(),
				workflowTask.getWorkflowTaskId());
		}

	
	public List<String> getTransitionNames(WorkflowTask workflowTask)
			throws PortalException {

			return WorkflowTaskManagerUtil.getNextTransitionNames(
				_workflowTaskRequestHelper.getCompanyId(),
				_workflowTaskRequestHelper.getUserId(),
				workflowTask.getWorkflowTaskId());
		}

	private Map<String, Serializable> _getWorkflowContext(
			WorkflowTask workflowTask)
		throws PortalException {

		WorkflowInstance workflowInstance = _getWorkflowInstance(workflowTask);

		return workflowInstance.getWorkflowContext();
	}
	

	public List<User> getAssignableUsers(WorkflowTask workflowTask)
		throws PortalException {

		return WorkflowTaskManagerUtil.getAssignableUsers(
			workflowTask.getWorkflowTaskId());
	}

	
	private WorkflowInstance _getWorkflowInstance(WorkflowTask workflowTask)
			throws PortalException {

			return  WorkflowInstanceManagerUtil.getWorkflowInstance(
				_workflowTaskRequestHelper.getCompanyId(),
				_getWorkflowInstanceId(workflowTask));
		}
	
	private long _getWorkflowInstanceId(WorkflowTask workflowTask) {
		return workflowTask.getWorkflowInstanceId();
	}
	
	public String getWorkflowTaskAssigneeUserName(WorkflowTask workflowTask) {
		return PortalUtil.getUserName(
			workflowTask.getAssigneeUserId(),
			String.valueOf(workflowTask.getAssigneeUserId()));
	}
	
	
	public String getWorkflowTaskUnassignedUserName() {
		return LanguageUtil.get(
			_workflowTaskRequestHelper.getRequest(), "nobody");
	}
	
	public WorkflowHandler<?> getWorkflowHandler(WorkflowTask workflowTask)
			throws PortalException {

			return WorkflowHandlerRegistryUtil
					.getWorkflowHandler(
				_getWorkflowContextEntryClassName(workflowTask));
		}
	public String getAssetTitle(WorkflowTask workflowTask)
			throws PortalException {

			WorkflowHandler<?> workflowHandler = getWorkflowHandler(workflowTask);

			String title = workflowHandler.getTitle(
				getWorkflowContextEntryClassPK(workflowTask),
				getTaskContentLocale());

			if (title != null) {
				return title;
			}

			return getAssetType(workflowTask);
		}
	public String getAssetType(WorkflowTask workflowTask)
			throws PortalException {

			WorkflowHandler<?> workflowHandler = getWorkflowHandler(workflowTask);

			return workflowHandler.getType(getTaskContentLocale());
		}
	public String getPreviewOfTitle(WorkflowTask workflowTask)
			throws PortalException {

			HttpServletRequest httpServletRequest =
				_workflowTaskRequestHelper.getRequest();

			ThemeDisplay themeDisplay =
				(ThemeDisplay)httpServletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			return LanguageUtil.format(
				themeDisplay.getLocale(), "preview-of-x",
				ResourceActionsUtil.getModelResource(
					themeDisplay.getLocale(),
					_getWorkflowContextEntryClassName(workflowTask)),
				false);
		}
	private String _getWorkflowContextEntryClassName(WorkflowTask workflowTask)
			throws PortalException {

			Map<String, Serializable> workflowContext = _getWorkflowContext(
				workflowTask);

			return (String)workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME);
		}
	
	public Locale getTaskContentLocale() {
		String languageId = LanguageUtil.getLanguageId(_httpServletRequest);

		if (Validator.isNotNull(languageId)) {
			return LocaleUtil
					.fromLanguageId(languageId);
		}

		return _workflowTaskRequestHelper.getLocale();
	}

	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final CustomWorkflowTaskRequestHelper _workflowTaskRequestHelper;

}
