/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 *//*


package com.esquare.intranet.project.management.internal.workflow;

import com.esquare.intranet.project.management.model.Projects;
import com.esquare.intranet.project.management.service.ProjectsLocalService;
import com.liferay.account.model.AccountEntry;
import com.liferay.account.service.AccountEntryLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

*/
/**
 * @author Mahammed Seleem
 *//*

@Component(
	property = "model.class.name=com.esquare.intranet.project.management.model.Projects",
	service = WorkflowHandler.class
)
public class ProjectsWorkflowHandler
	extends BaseWorkflowHandler<Projects> {

	@Override
	public String getClassName() {
		return Projects.class.getName();
	}

	@Override
	public String getType(Locale locale) {
		return _language.get(locale, "Projects");
	}

	@Override
	public boolean isScopeable() {
		return false;
	}

	@Override
	public Projects updateStatus(
			int status, Map<String, Serializable> workflowContext)
		throws PortalException {

		long userId = GetterUtil.getLong(
			(String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long classPK = GetterUtil.getLong(
			(String)workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext)workflowContext.get(
			"serviceContext");

		return _projectsLocalService.updateStatus(
			userId, classPK, status, serviceContext, workflowContext);
	}

	@Reference
	private ProjectsLocalService _projectsLocalService;

	@Reference
	private Language _language;

}*/
