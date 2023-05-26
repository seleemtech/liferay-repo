package com.docter.web.workflow;


import com.docter.service.model.Docters;
import com.docter.service.service.DoctersLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActionsUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(property = {
"model.class.name=com.docter.service.model.Docters" }, service = WorkflowHandler.class)
public class DoctersWorkflowHandler extends BaseWorkflowHandler<Docters> {

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return Docters.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		// TODO Auto-generated method stub
		return ResourceActionsUtil.getModelResource(locale, getClassName());
	}

	@Override
	public Docters updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		// TODO Auto-generated method stub
		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPK = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");

		return _doctersLocalService.updateStatus(userId, classPK, status, serviceContext);
		
	}
	@Reference(unbind = "-")
	protected void setDoctersLocalService(DoctersLocalService DoctersLocalService) {

		_doctersLocalService = DoctersLocalService;
	}
	private DoctersLocalService _doctersLocalService;

}
