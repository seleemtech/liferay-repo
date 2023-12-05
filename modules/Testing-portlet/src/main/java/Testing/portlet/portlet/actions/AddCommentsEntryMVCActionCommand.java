package Testing.portlet.portlet.actions;

import com.liferay.object.constants.ObjectDefinitionConstants;
import com.liferay.object.constants.ObjectFieldConstants;
import com.liferay.object.field.setting.builder.ObjectFieldSettingBuilder;
import com.liferay.object.field.util.ObjectFieldUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.scope.ObjectScopeProvider;
import com.liferay.object.scope.ObjectScopeProviderRegistry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.ThreadUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManager;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.vulcan.util.LocalizedMapUtil;
import com.liferay.taglib.util.ThreadLocalUtil;

import java.util.Arrays;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import Testing.portlet.constants.TestingPortletKeys;
import Testing.portlet.portlet.util.APIUtil;
import Testing.portlet.portlet.util.FileUtil;

@Component(property = { "javax.portlet.name=" + TestingPortletKeys.TESTING,
		"mvc.command.name=/comments/add_comments" }, service = MVCActionCommand.class)
public class AddCommentsEntryMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String message = ParamUtil.getString(actionRequest, "message");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		FileEntry fileEntry = FileUtil.uploadFile(uploadPortletRequest);

		ObjectDefinition objectDefinition = null;
		WorkflowDefinition workflowDefinition = null;
		try {
			objectDefinition = _objectDefinitionLocalService.fetchObjectDefinition(themeDisplay.getCompanyId(),
					"C_Comments");

		} catch (Exception e) {
		}
		if (null == objectDefinition) {
			objectDefinition = addCustomObject(themeDisplay);
		}

		try {
			workflowDefinition = _workflowDefinitionManager.getLatestWorkflowDefinition(themeDisplay.getCompanyId(),
					"Comments multliLevel Workflow");
		} catch (Exception e) {
			if (null == workflowDefinition && null != objectDefinition) {
				workflowDefinition = createWorkflowDefinition(themeDisplay, objectDefinition.getClassName());
			}
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("message", message);
		jsonObject.put("file", fileEntry.getFileEntryId());
		jsonObject.put("userId", themeDisplay.getUserId());
		jsonObject.put("groupId", _getGroupId(actionRequest, objectDefinition));
		jsonObject.put("objectDefinitionId", objectDefinition.getObjectDefinitionId());
		String sessionId = actionRequest.getRequestedSessionId();
		String token = AuthTokenUtil.getToken(uploadPortletRequest);
//		String url = themeDisplay.getPortalURL() + "/o" + objectDefinition.getRESTContextPath();
		/*
		 * String url = "http://localhost:8080/o/comments-headless/v1.0/post-comments" +
		 * "?p_auth=" + token;
		 */
		String url = "http://localhost:8080/o/comments-headless/v1.0/post-comments";
		APIUtil.apiPost(jsonObject.toString(), url, sessionId);
	}

	public WorkflowDefinition createWorkflowDefinition(ThemeDisplay themeDisplay, String className)
			throws WorkflowException {
		String content = StringUtil.read(AddCommentsEntryMVCActionCommand.class, "dependencies/custom-workflow.xml");
		WorkflowDefinition workflowDefinition = null;
		try {
			workflowDefinition = _workflowDefinitionManager.deployWorkflowDefinition(themeDisplay.getCompanyId(),
					themeDisplay.getUserId(), "Comments multliLevel Workflow", "Comments multliLevel Workflow",
					content.getBytes());
			String value = getWorkflowDefinitionValue(workflowDefinition);

			_workflowDefinitionLinkLocalService.updateWorkflowDefinitionLink(themeDisplay.getUserId(),
					themeDisplay.getCompanyId(), 0, className, 0, 0, value);
		} catch (PortalException e) {
		}

		return workflowDefinition;
	}

	public String getWorkflowDefinitionValue(WorkflowDefinition workflowDefinition) {

		return HtmlUtil.escapeAttribute(workflowDefinition.getName()) + StringPool.AT + workflowDefinition.getVersion();
	}

	private long _getGroupId(ActionRequest actionRequest, ObjectDefinition objectDefinition) throws Exception {

		ObjectScopeProvider objectScopeProvider = _objectScopeProviderRegistry
				.getObjectScopeProvider(objectDefinition.getScope());

		return objectScopeProvider.getGroupId(_portal.getHttpServletRequest(actionRequest));
	}

	private ObjectDefinition addCustomObject(ThemeDisplay themeDisplay) throws PortalException {
		ObjectDefinition objectDefinition = _objectDefinitionLocalService.addCustomObjectDefinition(
				themeDisplay.getUserId(), false, false, LocalizedMapUtil.getLocalizedMap("Comments Object"), "Comments",
				"100", "control_panel.object", LocalizedMapUtil.getLocalizedMap("Comments Object"),
				ObjectDefinitionConstants.SCOPE_COMPANY, ObjectDefinitionConstants.STORAGE_TYPE_DEFAULT,
				Arrays.asList(
						ObjectFieldUtil.createObjectField(ObjectFieldConstants.BUSINESS_TYPE_TEXT,
								ObjectFieldConstants.DB_TYPE_STRING, true, false, null, "Message", "message", false),
						ObjectFieldUtil.createObjectField(ObjectFieldConstants.BUSINESS_TYPE_ATTACHMENT,
								ObjectFieldConstants.DB_TYPE_LONG, true, false, null, "File", "file",
								Arrays.asList(
										new ObjectFieldSettingBuilder().name("acceptedFileExtensions").value("pdf")
												.build(),
										new ObjectFieldSettingBuilder().name("fileSource").value("userComputer")
												.build(),
										new ObjectFieldSettingBuilder().name("maximumFileSize").value("100").build()),
								false)));

		objectDefinition = _objectDefinitionLocalService.publishCustomObjectDefinition(themeDisplay.getUserId(),
				objectDefinition.getObjectDefinitionId());
		return objectDefinition;
	}

	@Reference
	private WorkflowDefinitionLinkLocalService _workflowDefinitionLinkLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private WorkflowDefinitionManager _workflowDefinitionManager;

	@Reference
	private ObjectScopeProviderRegistry _objectScopeProviderRegistry;

	@Reference
	private ObjectDefinitionLocalService _objectDefinitionLocalService;

}
