package com.comments.headless.internal.resource.v1_0;

import com.comments.headless.dto.v1_0.Comments;
import com.comments.headless.dto.v1_0.Status;
import com.comments.headless.internal.resource.v1_0.util.FileUtil;
import com.comments.headless.resource.v1_0.CommentsResource;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.persistence.DLFileEntryFinderUtil;
import com.liferay.object.constants.ObjectDefinitionConstants;
import com.liferay.object.constants.ObjectFieldConstants;
import com.liferay.object.field.setting.builder.ObjectFieldSettingBuilder;
import com.liferay.object.field.util.ObjectFieldUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.scope.ObjectScopeProvider;
import com.liferay.object.scope.ObjectScopeProviderRegistry;
import com.liferay.object.service.ObjectActionService;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.object.service.ObjectEntryService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManager;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.util.LocalizedMapUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author E2Software-011
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/comments.properties", scope = ServiceScope.PROTOTYPE, service = CommentsResource.class)
public class CommentsResourceImpl extends BaseCommentsResourceImpl {

	@Override
	public Comments postCommentsEntry(Comments comments) throws Exception {
		try {
			/** fetching/creating object definition */
			ObjectDefinition objectDefinition = _getCommentsObjectDefinition(comments.getUserId(),
					comments.getCompanyId());

			ServiceContext serviceContext = new ServiceContext();

			FileEntry fileEntry = FileUtil.uploadFile(comments.getFileName(), comments.getBase64Doc(),
					comments.getUserId(), comments.getGroupId());
			long fileEntryId = 0L;
			if (null != fileEntry) {
				fileEntryId = fileEntry.getFileEntryId();
			}
			_objectEntryService.addObjectEntry(0L, objectDefinition.getObjectDefinitionId(),
					_getValues(comments.getMessage(), fileEntryId), serviceContext);

		} catch (Exception e) {

			if (_log.isDebugEnabled()) {
				_log.debug("Error creating object entry", e);
			}

		}

		return comments;

	}

	@Override
	public Page<Comments> getCommentsEntry(Long companyId,String objectDefinitionName) throws Exception {

		List<Comments> commentsPage = new ArrayList<>();
		try {
		ObjectDefinition objectDefinition = _objectDefinitionLocalService.fetchObjectDefinition(companyId, "C_Comment");

			if (null != objectDefinition) {
				List<ObjectEntry> obejctEntry = _objectEntryLocalService.getObjectEntries(0,
						objectDefinition.getObjectDefinitionId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);

				obejctEntry.stream().forEach(entry -> commentsPage.add(_toCommentsEntry(entry)));
			}

		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Error fetching Object Definition Entrys", e);
			}
		}

		return Page.of(commentsPage);
	}

	public String _getWorkflowDefinitionValue(WorkflowDefinition workflowDefinition) {

		return HtmlUtil.escapeAttribute(workflowDefinition.getName()) + StringPool.AT + workflowDefinition.getVersion();
	}

	private ObjectDefinition _getCommentsObjectDefinition(long userId, long companyId) throws PortalException {
		ObjectDefinition objectDefinition = null;
		try {
			objectDefinition = _objectDefinitionLocalService.fetchObjectDefinition(companyId, "C_Comment");

			if (null == objectDefinition) {
				objectDefinition = _objectDefinitionLocalService.addCustomObjectDefinition(userId, false, false,
						LocalizedMapUtil.getLocalizedMap(OBJECT_DEFINITON_NAME), OBJECT_DEFINITON_NAME, "100",
						"control_panel.object", LocalizedMapUtil.getLocalizedMap(OBJECT_PLURAL_NAME),
						ObjectDefinitionConstants.SCOPE_COMPANY, ObjectDefinitionConstants.STORAGE_TYPE_DEFAULT,
						Arrays.asList(ObjectFieldUtil.createObjectField(ObjectFieldConstants.BUSINESS_TYPE_TEXT,
								ObjectFieldConstants.DB_TYPE_STRING, true, false, null, "Message", "message", false),
								ObjectFieldUtil.createObjectField(ObjectFieldConstants.BUSINESS_TYPE_ATTACHMENT,
										ObjectFieldConstants.DB_TYPE_LONG, true, false, null, "File", "file",
										Arrays.asList(
												new ObjectFieldSettingBuilder().name("acceptedFileExtensions")
														.value("pdf").build(),
												new ObjectFieldSettingBuilder().name("fileSource").value("userComputer")
														.build(),
												new ObjectFieldSettingBuilder().name("maximumFileSize").value("100")
														.build()),
										false)));
				objectDefinition = _objectDefinitionLocalService.publishCustomObjectDefinition(userId,
						objectDefinition.getObjectDefinitionId());

				/** setting permission for view objectEntry */
				_setObjectEntrViewPermission(objectDefinition);

				/** creating workflow definition */
				String content = StringUtil.read(CommentsResourceImpl.class, "dependencies/comments-workflow.xml");
				WorkflowDefinition workflowDefinition = _workflowDefinitionManager.deployWorkflowDefinition(companyId,
						userId, WORKFLOW_DEFINITON_NAME, WORKFLOW_DEFINITON_NAME, content.getBytes());
				String value = _getWorkflowDefinitionValue(workflowDefinition);
				_workflowDefinitionLinkLocalService.updateWorkflowDefinitionLink(userId, companyId, 0,
						objectDefinition.getClassName(), 0, 0, value);
			}

		} catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Error fetching/creating object definition", e);
			}
		}

		return objectDefinition;
	}

	private void _setObjectEntrViewPermission(ObjectDefinition objectDefinition) {
		try {

			List<Role> roleList = _roleLocalService.getTypeRoles(RoleConstants.TYPE_REGULAR, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
			long[] roleIds = roleList.stream().filter(role -> ArrayUtil.contains(ROLES_NAMES, role.getName()))
					.mapToLong(Role::getRoleId).toArray();
			List<Role> roles = _roleLocalService.getRoles(roleIds);
			for (Role role : roles) {
				boolean hasPermission = ResourcePermissionLocalServiceUtil.hasResourcePermission(role.getCompanyId(),
						objectDefinition.getClassName(), ResourceConstants.SCOPE_COMPANY,
						String.valueOf(objectDefinition.getObjectDefinitionId()), role.getRoleId(), ActionKeys.VIEW);
				if (!hasPermission) {
					ResourcePermissionLocalServiceUtil.setResourcePermissions(role.getCompanyId(),
							objectDefinition.getClassName(), ResourceConstants.SCOPE_COMPANY,
							String.valueOf(objectDefinition.getObjectDefinitionId()), role.getRoleId(),
							new String[] { ActionKeys.VIEW, ActionKeys.PERMISSIONS });
				}
			}
		} catch (PortalException e) {
			if (_log.isDebugEnabled()) {
				_log.debug("Error for assinging permission", e);
			}
		}
	}

	private long _getGroupId(ObjectDefinition objectDefinition) throws Exception {

		ObjectScopeProvider objectScopeProvider = _objectScopeProviderRegistry
				.getObjectScopeProvider(objectDefinition.getScope());

		return objectScopeProvider.getGroupId(_portal.getOriginalServletRequest(contextHttpServletRequest));
	}

	private Map<String, Serializable> _getValues(String message, long fileId) {
		Map<String, Serializable> ddmFormValuesMap = new HashMap<>();

		ddmFormValuesMap.put("message", message);
		ddmFormValuesMap.put("file", fileId);
		return ddmFormValuesMap;
	}

	private Comments _toCommentsEntry(ObjectEntry serviceBulderObjectEntry) {
		return new Comments() {
			{
				Map<String, Serializable> ddmFormValuesMap = serviceBulderObjectEntry.getValues();
				message = ddmFormValuesMap.get("message").toString();
				try {
					Long fileId = (Long) ddmFormValuesMap.get("file");
		            fileName = getFileEntryName(fileId != null ? fileId.longValue() : 0L);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				status = new Status() {
					{
						code = serviceBulderObjectEntry.getStatus();
						label = WorkflowConstants.getStatusLabel(serviceBulderObjectEntry.getStatus());
						label_i18n = WorkflowConstants.getStatusLabel(serviceBulderObjectEntry.getStatus());
					}
				};
			}
		};
	}
	private String getFileEntryName(long fileEntryId) throws PortalException {
	    FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
	    return null != fileEntry ? fileEntry.getFileName() : StringPool.BLANK;
	}

	
	public static final String OBJECT_DEFINITON_NAME = "Comment";
	public static final String OBJECT_PLURAL_NAME = "Comments";
	public static final String WORKFLOW_DEFINITON_NAME = "Comments Workflow";
	public static final String[] ROLES_NAMES = { "Workflow Approver", "Workflow Managaer" };
	private Log _log = LogFactoryUtil.getLog(CommentsResourceImpl.class);
	private HttpServletRequest contextHttpServletRequest;
	@Reference
	private WorkflowDefinitionLinkLocalService _workflowDefinitionLinkLocalService;
	@Reference
	private WorkflowDefinitionManager _workflowDefinitionManager;
	@Reference
	private Portal _portal;
	@Reference
	private ObjectScopeProviderRegistry _objectScopeProviderRegistry;
	@Reference
	private RoleLocalService _roleLocalService;
	@Reference
	private ObjectEntryService _objectEntryService;
	@Reference
	private ObjectEntryLocalService _objectEntryLocalService;
	@Reference
	private ObjectDefinitionLocalService _objectDefinitionLocalService;
	@Reference
	private ObjectActionService _objectActionService;

}