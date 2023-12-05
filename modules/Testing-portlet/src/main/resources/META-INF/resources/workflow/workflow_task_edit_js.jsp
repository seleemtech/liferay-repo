<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@page import="Testing.portlet.constants.TestingPortletKeys"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTransition"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetRendererFactory"%>
<%@page import="com.liferay.asset.kernel.model.AssetRenderer"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowHandler"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page
	import="Testing.portlet.display.context.CustomWorkflowTaskDisplayContext"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ include file="/./init.jsp"%>

<%

String randomId = StringUtil.randomId();

	long workflowId = ParamUtil.getLong(renderRequest, "workflowId");
	String sessionJS = (String) request.getSession().getId();
	
	
%>


<clay:container-fluid>
	<clay:col cssClass="lfr-asset-column lfr-asset-column-details">
		<div class="sheet">
			<div class="panel-group panel-group-flush">
				
					<%@ include file="/workflow/workflow_task_action_js.jsp"%>
					
					<!-- <div id="myIconMenu"></div> -->
				
				<clay:col md="6">
					<aui:field-wrapper label="assigned-to">
						<aui:fieldset>
							<div class="align-items-center card-row" id="userNameDiv">
							</div>
						</aui:fieldset>
					</aui:field-wrapper>

					<aui:field-wrapper label="task-name" >
						<aui:fieldset>
							 <div class="my-content" id="taskNameField"></div>
						</aui:fieldset>
					</aui:field-wrapper>
				</clay:col>



			</div>
		</div>
	</clay:col>
</clay:container-fluid>


<script>
AUI().use(
	    'aui-base',
	    'liferay-portlet-url',
	    'liferay-util-window',
	    function(A) {
	    	 var sessionId = "<%=sessionJS%>";
	    	 var userId = '<%=themeDisplay.getUserId()%>';
	    	 var companyId = '<%=themeDisplay.getCompanyId()%>';
	        A.on('domready', function() {
	            var workflowTaskId = '<%=workflowId%>';
	            
	            var userNameDiv = A.one('#userNameDiv');
	            
	            var isAssignedToSingleUserFirstDiv = A.Node.create('<div class="card-col-field mr-2">' +
	                    '<div class="list-group-card-icon">' +
	                    '<liferay-ui:user-portrait />' +
	                    '</div>' +
	                    '</div>');
	                var isAssignedToSingleUserSecondDiv = A.Node.create('<div class="card-col-content card-col-gutters">' +
	                    '<div class="lfr-asset-assigned">' +
	                    '</div>' +
	                    '</div>');
	                var UnassignedUserNameDiv = A.Node.create('<div class="card-col-content card-col-gutters lfr-asset-assigned">' +
		                    '<div class="lfr-asset-assigned">' +
		                    '</div>' +
		                    '</div>');
	                var taskNameField = A.one('#taskNameField');
	                
	                var iconMenuContainer = A.one('#myIconMenu');
	           
	            Liferay.Util.fetch('/o/comments-headless/v1.0/get-workflow-task/' + workflowTaskId, {
	                    method: 'GET',
	                    headers: {
	                        'Cookie': 'JSESSIONID=' + sessionId,
	                        'Content-Type': 'application/json',
	                    },
	                })
	                .then((response) => response.json())
	                .then((json) => {
	                    console.log("json:::::", json);
	                    
	                    if(json.isAssignedToSingleUser){
	    	                userNameDiv.append(isAssignedToSingleUserFirstDiv);
	    	                isAssignedToSingleUserSecondDiv.one('.lfr-asset-assigned').html(json.workflowTaskAssigneeUserName);
	    	                userNameDiv.append(isAssignedToSingleUserSecondDiv);
	                    }else{
	                    	UnassignedUserNameDiv.one('.lfr-asset-assigned').html('Nobody');
		    	            userNameDiv.append(UnassignedUserNameDiv);
	                    }
	                    taskNameField.html(json.TaskContent);
	                    if(!json.isWorkflowCompleted){
	                    	if(userId == json.assigneeUserId){
		                    	 for (var i = 0; i < json.worflowTansition.length; i++) {
									  addIconToMenu(iconMenuContainer,  json.worflowTansition[i].label,json.workflowTaskId, userId, json.assigneeUserId);
						            }
		                    }else{
		                    	addIconToMenu(iconMenuContainer,  'Assign To Me', json.workflowTaskId, userId);
		                    	addIconToMenu(iconMenuContainer,  'Assign To ...', json.workflowTaskId, userId);
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
	        
	        function addIconToMenu(container, transitionName, workflowTaskId, userId, assigneeUserId) {
                var iconMenu = A.Node.create('<div class="lfr-icon-menu-open"></div>');

                var icon = A.Node.create('<span class="dropdown-item lfr-icon-item taglib-icon">' + transitionName + '</span>');
                icon.on('click', function() {
                	var portletURL =new Liferay.PortletURL.createURL(Liferay.currentURL);
					portletURL.setParameter('mvcPath', '/workflow/workflow_task_assign_js.jsp');
					portletURL.setParameter('p_auth', Liferay.authToken);
					portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
					portletURL.setPortletMode('<%=LiferayPortletMode.VIEW %>');
					portletURL.setWindowState('<%=LiferayWindowState.NORMAL.toString() %>');
					portletURL.setParameter('workflowTaskId', workflowTaskId);
					portletURL.setParameter('assigneeUserId', userId);
                	if(transitionName=='Assign To Me' || transitionName=='Assign To ...' ){
                		if(transitionName=='Assign To Me'){
                			portletURL.setParameter('assignToMe', 'assignToMe');
                		}
                		
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
                			title: transitionName,
                			uri: portletURL,
                		});
                	}else{
                		completeTask(transitionName, workflowTaskId, assigneeUserId);
                	}
                   
                }); 

                iconMenu.append(icon);

                container.append(iconMenu);
            }
	        function completeTask(transitionName, workflowTaskId, assigneeUserId) {
	        	

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
	        	console.log("transitionName"+transitionName);
            }
	    }
	);

    </script>

