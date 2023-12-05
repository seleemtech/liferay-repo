<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
<%@ include file="/init.jsp"%>

<link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> <!-- Include jQuery library -->
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.js"></script>	

<p>
	<b><liferay-ui:message key="testing.caption" /></b>
</p>



<%
	String sessionJS = (String) request.getSession().getId();
%>





<table id="notifiationTable" class="display">
    <thead>
        <tr>
            <th>Id</th>
            <th>Message</th>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>


 <script>
 AUI().use(
			'aui-base',
			'liferay-portlet-url',
			'liferay-util-window',
			function (A) {
				 A.on('domready', function() {
			        	var userId ="<%=themeDisplay.getUserId()%>";
			        	var sessionId = "<%=sessionJS %>";
			        	var portletURL =new Liferay.PortletURL.createURL(Liferay.currentURL);
						portletURL.setParameter('mvcPath', '/workflow/workflow_task_edit_js.jsp');
						portletURL.setParameter('p_auth', Liferay.authToken);
						portletURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId() %>");
						portletURL.setPortletMode('<%=LiferayPortletMode.VIEW %>');
						portletURL.setWindowState('<%=LiferayWindowState.NORMAL.toString() %>');
						
						console.log("portletURL::: "+portletURL);
						
			    		Liferay.Util.fetch('/o/comments-headless/v1.0/get-user-notifications/'+userId, {
							method: 'GET',
							 headers: {
							  'Cookie': 'JSESSIONID=' + sessionId,
			                  'Content-Type': 'application/json',
			            },
						})
							.then((response) => response.json())
							.then((json) => {
								
								  for (var i = 0; i < json.items.length; i++) {
									  portletURL.setParameter('workflowId', json.items[i].workflowTaskId);
						             $('#notifiationTable tbody').append('<tr><td>' + json.items[i].notificationEventId + '</td><td><a href="' + portletURL + '">' + json.items[i].notificationMessage + '</a><span class="additional-value"> '+json.items[i].notificationTimeDiff +'</span></td></tr>');
						            }

						       
						       new DataTable('#notifiationTable', {
						    	    order: [[0, 'desc']]
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
		);

 
 
 
 
 
       
    </script>

