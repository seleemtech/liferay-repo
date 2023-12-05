<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page
	import="com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil"%>
<%@page
	import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page
	import="Testing.portlet.display.context.CustomWorkflowTaskDisplayContext"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	long assigneeUserId = ParamUtil.getLong(renderRequest, "assigneeUserId");
	long workflowId = ParamUtil.getLong(renderRequest, "workflowTaskId");
	String assignToMe = ParamUtil.getString(renderRequest, "assignToMe");
	String workflowTaskURL = ParamUtil.getString(request, "workflowTaskURL");
	CustomWorkflowTaskDisplayContext customWorkflowTaskDisplayContext = (CustomWorkflowTaskDisplayContext) renderRequest
			.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
	WorkflowTask workflowTask = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(),
			workflowId);
	String sessionJS = (String) request.getSession().getId();
	boolean hasAssignableUsers = customWorkflowTaskDisplayContext.hasAssignableUsers(workflowTask);
%>

<liferay-portlet:resourceURL copyCurrentRenderParameters="<%=false%>"
	id="/custom/portal_workflow_task/assign_task" var="assignURL" />

<div class="task-action">
	<aui:form action="<%=assignURL%>" method="post" name="assignFm">
		<div class="modal-body task-action-content">
			<aui:input name="workflowTaskId" type="hidden" id="workflowTaskId"
				value="<%=String.valueOf(workflowTask.getWorkflowTaskId())%>" />

			<c:choose>
				<c:when test="<%=("assignToMe").equals(assignToMe)%>">
					<aui:input name="assigneeUserId" type="hidden"
						value="<%=String.valueOf(assigneeUserId)%>" id="assigneeUserId" />
				</c:when>
				<c:otherwise>
					<aui:select label="assign-to" name="assigneeUserId">

						<%
							for (User assignableUser : customWorkflowTaskDisplayContext
													.getAssignableUsers(workflowTask)) {
						%>

						<aui:option
							label="<%=HtmlUtil.escape(assignableUser.getScreenName()) + StringPool.SPACE
										+ StringPool.OPEN_PARENTHESIS + HtmlUtil.escape(assignableUser.getFullName())
										+ StringPool.CLOSE_PARENTHESIS%>"
							selected="<%=workflowTask.getAssigneeUserId() == assignableUser.getUserId()%>"
							value="<%=String.valueOf(assignableUser.getUserId())%>" />

						<%
							}
						%>

					</aui:select>
				</c:otherwise>
			</c:choose>

			<aui:input cols="55" cssClass="task-action-comment" id="comment"
				disabled="<%=!hasAssignableUsers && (assigneeUserId <= 0)%>"
				name="comment" placeholder="comment" rows="1" type="textarea" />
		</div>

		<div class="modal-footer">
			<div class="modal-item-last">
				<div class="btn-group">
					<div class="btn-group-item">
						<aui:button name="close" type="cancel" />
					</div>

					<div class="btn-group-item">
						<aui:button
							disabled="<%=!hasAssignableUsers && (assigneeUserId <= 0)%>"
							name="done" primary="<%=true%>" value="done" />
					</div>
				</div>
			</div>
		</div>
	</aui:form>
</div>

<aui:script use="aui-base">
	var done = A.one('#<portlet:namespace />done');

	if (done) {
		done.on('click', (event) => {
		
		var sessionId = "<%=sessionJS %>";
			var companyId ="<%=themeDisplay.getCompanyId() %>";
			var userId ="<%=themeDisplay.getUserId() %>";
			var workflowTaskId = A.one('#<portlet:namespace />workflowTaskId');
            var assigneeUserId = A.one('#<portlet:namespace />assigneeUserId');
            var comment = A.one('#<portlet:namespace />comment');
			Liferay.Util.fetch('/o/comments-headless/v1.0/workflow/assign-to-me', {
				body: JSON.stringify({
                workflowTaskId: workflowTaskId.val(),
                assigneeUserId: assigneeUserId.val(),
                comment: comment.val(),
                companyId: companyId,
                userId: userId
            }),
				method: 'POST',
				 headers: {
				  'Cookie': 'JSESSIONID=' + sessionId,
                  'Content-Type': 'application/json',
            },
			})
				.then((response) => response.json())
				.then((json) => {
					const assignMode =
						'<%=ParamUtil.getString(request, "assignMode")%>';

					if (assignMode === 'assignToMe') {
						Liferay.Util.getOpener().<portlet:namespace />refreshPortlet(
							'<%=PortalUtil.escapeRedirect(redirect)%>'
						);
					}
					else {
						Liferay.Util.getOpener().<portlet:namespace />refreshPortlet(
							json.hasPermission
								? '<%=PortalUtil.escapeRedirect(workflowTaskURL)%>'
								: '<%=PortalUtil.escapeRedirect(redirect)%>'
						);
					}

					Liferay.Util.getWindow(
						'<portlet:namespace />assignToDialog'
					).destroy();
					
					Liferay.Util.openToast({
                    autoClose: true,
                    message: 'Workflow Assigned SuccessFully',
                    type: 'success'
            });
				})
				.catch((error) => {
                Liferay.Util.openToast({
                    autoClose: false,
                    message: Liferay.Language.get(
                        'an-unexpected-system-error-occurred'
                    ),
                    type: 'danger',
                });
            });
		});
	}
	
	

</aui:script>