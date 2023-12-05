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
	long assigneeUserId = ParamUtil.getLong(renderRequest, "assigneeUserId");
	long workflowId = ParamUtil.getLong(renderRequest, "workflowTaskId");
	String assignToMe = ParamUtil.getString(renderRequest, "assignToMe");
	String sessionJS = (String) request.getSession().getId();
%>

<div class="task-action" >
	<aui:form action="" method="post" name="assignFm">
		<div class="modal-body task-action-content" id="inputDiv">
		
		<aui:input name="workflowTaskId" type="hidden" id="workflowTaskId"
				 />

			<aui:input cols="55" cssClass="task-action-comment" id="comment"
				
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
console.log("before destroy message");
					
					console.log("after destroy message");
					  Liferay.Util.openToast({
	                    autoClose: true,
	                    message: 'Workflow Assigned SuccessFully',
	                    type: 'success'
	                });
	             
console.log("after success message");
	                setTimeout(() => {
	                    window.location.reload();
	                }, 3000);
	                Liferay.Util.getWindow(
						'<portlet:namespace />assignToDialog'
					).destroy();
	                console.log("after time out message");
				})
				.catch((error) => {
				console.log("error in assign to"+error);
                Liferay.Util.openToast({
                    autoClose: true,
                    message: Liferay.Language.get(
                        'an-unexpected-system-error-occurred'
                    ),
                    type: 'danger',
                });
            }); 
		});
	}
	
	
	    A.on('domready', function() {
	            var workflowTaskId = '<%=workflowId%>';
	            A.one('#<portlet:namespace />workflowTaskId').val(workflowTaskId);
	            var assigneeUserId = '<%=assigneeUserId%>';
	            var assignToMe = '<%=assignToMe%>';
	            
	            var inputField=A.Node.create('<input/>');
                    inputField.set("id","<portlet:namespace />assigneeUserId");
                    inputField.set("name","<portlet:namespace />assigneeUserId");
                    inputField.set("type","hidden");
                
                var selectField = A.Node.create('<select></select>');
                    selectField.set("id", "<portlet:namespace />assigneeUserId");
                    selectField.set("name", "<portlet:namespace />assigneeUserId");

                  
	            var sessionId = "<%=sessionJS%>";
	            Liferay.Util.fetch('/o/comments-headless/v1.0/get-workflow-task/' + workflowTaskId, {
	                    method: 'GET',
	                    headers: {
	                        'Cookie': 'JSESSIONID=' + sessionId,
	                        'Content-Type': 'application/json',
	                    },
	                })
	                .then((response) => response.json())
	                .then((json) => {

                      if('assignToMe'===assignToMe){
                       A.one('#inputDiv').append(inputField);
                        inputField.val(assigneeUserId);  
                      }else{
                         for (var i = 0; i < json.assignableUser.length; i++) {
                            var option = A.Node.create('<option></option>');
                                option.set("value", json.assignableUser[i].userId);
                                option.text(json.assignableUser[i].name); 
                           if (json.assignableUser[i].userId === json.assigneeUserId) {
                                option.set("selected", "selected");
                              }
                                selectField.append(option);
                          A.one('#inputDiv').append(selectField);
                         }
                     }
	                    
	                })
	                .catch((error) => {
	                	console.log("error");
	                    Liferay.Util.openToast({
	                        autoClose: false,
	                        message: Liferay.Language.get('an-unexpected-system-error-occurred'),
	                        type: 'danger',
	                    });
	                });
	        });
	
	

</aui:script>