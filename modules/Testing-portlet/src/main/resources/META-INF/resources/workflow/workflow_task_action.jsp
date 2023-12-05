<%@page
	import="com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="Testing.portlet.constants.TestingPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTransition"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@ include file="/./init.jsp"%>

<%
 String sessionJS = (String) request.getSession().getId();
	PortletURL redirectURL = PortletURLBuilder.createRenderURL(renderResponse).setMVCPath("/view.jsp")
			.buildPortletURL();
%>

<liferay-ui:icon-menu cssClass="lfr-asset-actions" direction="left-side"
	icon="<%=StringPool.BLANK%>" markupView="lexicon"
	message="<%=StringPool.BLANK%>" showExpanded="">
	<c:if test="<%=!workflowTask.isCompleted()%>">
		<c:choose>
			<c:when
				test="<%=customWorkflowTaskDisplayContext.isAssignedToUser(workflowTask)%>">

				<%
					for (WorkflowTransition workflowTransition : customWorkflowTaskDisplayContext
											.getWorkflowTaskWorkflowTransitions(workflowTask)) {
				%>

				<liferay-portlet:actionURL copyCurrentRenderParameters="<%=false%>"
					name="/custom/portal_workflow_task/complete_task" var="editURL">
					<portlet:param name="mvcPath"
						value="/workflow/workflow_task_edit.jsp" />
					<portlet:param name="redirect" value="" />
					<portlet:param name="closeRedirect" value="" />
					<portlet:param name="workflowTaskId"
						value="<%=String.valueOf(workflowTask.getWorkflowTaskId())%>" />
					<portlet:param name="assigneeUserId"
						value="<%=String.valueOf(workflowTask.getAssigneeUserId())%>" />

					<c:if test="<%=Validator.isNotNull(workflowTransition.getName())%>">
						<portlet:param name="transitionName"
							value="<%=workflowTransition.getName()%>" />
					</c:if>
				</liferay-portlet:actionURL>

				<liferay-ui:icon
					cssClass='<%="workflow-task-" + randomId + " task-change-status-link"%>'
					data="<%=customWorkflowTaskDisplayContext.getWorkflowTaskActionLinkData()%>"
					id='<%=randomId + HtmlUtil.escapeAttribute(workflowTransition.getName())
										+ "taskChangeStatusLink"%>'
					message="<%=workflowTransition
										.getLabel(customWorkflowTaskDisplayContext.getTaskContentLocale())%>"
					method="get"
					url='<%="javascript:" + randomId + liferayPortletResponse.getNamespace()
										+ "completeTask(\'" + workflowTransition.getName() + "\',\'"
										+ workflowTask.getAssigneeUserId() + "\',\'" + workflowTask.getWorkflowTaskId()
										+ "\',\'" + themeDisplay.getCompanyId() + "\',\'" + themeDisplay.getUserId()
										+ "\');"%>' />
				<%
					}
				%>

			</c:when>
			<c:otherwise>

				<liferay-portlet:renderURL copyCurrentRenderParameters="<%=false%>"
					var="assignToMeURL"
					windowState="<%=LiferayWindowState.POP_UP.toString()%>">
					<portlet:param name="mvcPath"
						value="/workflow/workflow_task_assign.jsp" />
					<portlet:param name="redirect"
						value='<%=Validator.isNull(request.getParameter("workflowId")) ? redirectURL.toString()
										: currentURL%>' />

					<portlet:param name="workflowTaskId"
						value="<%=String.valueOf(workflowTask.getWorkflowTaskId())%>" />
					<portlet:param name="assigneeUserId"
						value="<%=String.valueOf(user.getUserId())%>" />
					<portlet:param name="assignMode" value="assignToMe" />
				</liferay-portlet:renderURL>

				<liferay-ui:icon message="assign-to-me"
					onClick='<%="javascript:" + liferayPortletResponse.getNamespace() + "taskAssignToMe('"
									+ assignToMeURL + "');"%>'
					url="javascript:void(0);" />
			</c:otherwise>
		</c:choose>

		<liferay-portlet:renderURL copyCurrentRenderParameters="<%=false%>"
			var="assignURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="mvcPath"
				value="/workflow/workflow_task_assign.jsp" />
			<portlet:param name="redirect" value="" />
			<portlet:param name="workflowTaskId"
				value="<%=String.valueOf(workflowTask.getWorkflowTaskId())%>" />
			<portlet:param name="workflowTaskURL" value="" />
		</liferay-portlet:renderURL>

		<liferay-ui:icon message="assign-to-..."
			onClick='<%="javascript:" + liferayPortletResponse.getNamespace() + "taskAssign('" + assignURL + "');"%>'
			url="javascript:void(0);" />

		<liferay-portlet:renderURL copyCurrentRenderParameters="<%=false%>"
			var="updateDueDateURL"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="mvcPath" value="/workflow_task_due_date.jsp" />
			<portlet:param name="redirect" value="" />
			<portlet:param name="workflowTaskId"
				value="<%=String.valueOf(workflowTask.getWorkflowTaskId())%>" />
		</liferay-portlet:renderURL>

		<liferay-ui:icon message="update-due-date"
			onClick='<%="javascript:" + liferayPortletResponse.getNamespace() + "taskUpdate('" + updateDueDateURL
							+ "');"%>'
			url="javascript:void(0);" />
	</c:if>
</liferay-ui:icon-menu>

<aui:form name='<%=randomId + "form"%>'>
	<div class="hide" id="<%=randomId%>updateComments">
		<aui:input cols="55" cssClass="task-content-comment" name="comment"
			placeholder="comment" rows="1" type="textarea" />
	</div>
</aui:form>
<aui:script use="liferay-workflow-tasks">
var onTaskClickFn = function(transitionName, assigneeUserId, workflowTaskId, companyId, userId) {

    var sessionId = "<%=sessionJS%>";

    Liferay.Util.fetch('/o/comments-headless/v1.0/workflow/complete-task-assign', {
        body: JSON.stringify({
            transitionName: transitionName,
            workflowTaskId: workflowTaskId,
            assigneeUserId: assigneeUserId,
            comment: "",
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
        var toastMessage = '';

        switch (json.transitionName) {
            case "Assignee Reject":
            case "Manager Reject":
                toastMessage = 'Workflow Task Rejected successfully';
                break;
            case "Resubmit":
                toastMessage = 'Workflow Task Resubmitted successfully';
                break;
            default:
                toastMessage = 'Workflow Task Approved successfully';
        }
        Liferay.Util.openToast({
            autoClose: true,
            message: toastMessage,
            type: 'success'
        });
     

        setTimeout(() => {
            window.location.reload();
        }, 3000);
    })
    .catch((error) => {
        Liferay.Util.openToast({
            autoClose: false,
            message: Liferay.Language.get('an-unexpected-system-error-occurred'),
            type: 'danger',
        });
    });
};

	<c:if
		test="<%=!workflowTask.isCompleted()
							&& customWorkflowTaskDisplayContext.isAssignedToUser(workflowTask)%>">
		<%
			for (String transitionName : customWorkflowTaskDisplayContext.getTransitionNames(workflowTask)) {
		%>
			Liferay.delegateClick(
				'<portlet:namespace /><%=randomId + HtmlUtil.escapeJS(transitionName)%>taskChangeStatusLink',
				function() {
					onTaskClickFn('<%=transitionName%>', '<%=workflowTask.getAssigneeUserId()%>','<%=workflowTask.getWorkflowTaskId()%>','<%=themeDisplay.getCompanyId()%>','<%=themeDisplay.getUserId()%>');
				}
			);
		<%
			}
		%>
	</c:if>
</aui:script>


<aui:script>
	function <portlet:namespace />taskAssign(uri) {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				height: 430,
				resizable: false,
				width: 896,
			},
			dialogIframe: {
				bodyCssClass: 'task-dialog',
			},
			id: '<portlet:namespace />assignToDialog',
			title: '<liferay-ui:message key="assign-to-..." />',
			uri: uri,
		});
	}

	function <portlet:namespace />taskAssignToMe(uri) {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				height: 340,
				resizable: false,
				width: 896,
			},
			dialogIframe: {
				bodyCssClass: 'task-dialog',
			},
			id: '<portlet:namespace />assignToDialog',
			title: '<liferay-ui:message key="assign-to-me" />',
			uri: uri,
		});
	}

	function <portlet:namespace />taskUpdate(uri) {
		Liferay.Util.openWindow({
			dialog: {
				destroyOnHide: true,
				height: 430,
				resizable: false,
				width: 896,
			},
			dialogIframe: {
				bodyCssClass: 'task-dialog',
			},
			id: '<portlet:namespace />updateDialog',
			title: '<liferay-ui:message key="update-due-date" />',
			uri: uri,
		});
	}

	function <portlet:namespace />refreshPortlet(uri) {
		location.href = uri;
	}
</aui:script>