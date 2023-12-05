//package Testing.portlet.workflow;
//
//import com.liferay.object.model.ObjectDefinition;
//import com.liferay.object.model.ObjectEntry;
//import com.liferay.object.service.ObjectDefinitionLocalService;
//import com.liferay.object.service.ObjectEntryLocalService;
//import com.liferay.petra.string.StringPool;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.util.GetterUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
//import com.liferay.portal.kernel.workflow.WorkflowConstants;
//import com.liferay.portal.kernel.workflow.WorkflowHandler;
//
//import java.io.Serializable;
//import java.util.Locale;
//import java.util.Map;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//@Component(immediate = true, service = WorkflowHandler.class)
//public class CommentsWorkflowHandler extends BaseWorkflowHandler<ObjectEntry> {
//	@Override
//	public String getClassName() {
//		// TODO Auto-generated method stub
//		return getObjectDefinition().getClassName();
//	}
//
//	@Override
//	public String getType(Locale locale) {
//		return getObjectDefinition().getLabel(locale);
//	}
//
//	@Override
//	public String getTitle(long classPK, Locale locale) {
//		try {
//			ObjectEntry objectEntry = _objectEntryLocalService.getObjectEntry(classPK);
//			System.out.println("objectEntry.getTitleValue()::::" + objectEntry.getTitleValue());
//			return objectEntry.getTitleValue();
//		} catch (PortalException portalException) {
//			if (_log.isWarnEnabled()) {
//				_log.warn(portalException);
//			}
//		}
//
//		return StringPool.BLANK;
//	}
//
//	public ObjectDefinition getObjectDefinition() {
//		ObjectDefinition objectDefinition = _objectDefinitionLocalService
//				.fetchObjectDefinition(PortalUtil.getDefaultCompanyId(), "C_Department");
//		return objectDefinition;
//	}
//
//	@Override
//	public ObjectEntry updateStatus(
//			int status, Map<String, Serializable> workflowContext)
//		throws PortalException {
//
//		long userId = GetterUtil.getLong(
//			(String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
//		long classPK = GetterUtil.getLong(
//			(String)workflowContext.get(
//				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
//
//		ServiceContext serviceContext = (ServiceContext)workflowContext.get(
//			"serviceContext");
//
//		return _objectEntryLocalService.updateStatus(
//			userId, classPK, status, serviceContext);
//	}
//
//	private static final Log _log = LogFactoryUtil.getLog(CommentsWorkflowHandler.class);
//
//	@Reference
//	private ObjectEntryLocalService _objectEntryLocalService;
//
//	@Reference
//	private ObjectDefinitionLocalService _objectDefinitionLocalService;
//
//}
