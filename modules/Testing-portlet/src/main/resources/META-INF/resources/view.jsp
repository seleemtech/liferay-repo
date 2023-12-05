<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page
	import="Testing.portlet.display.context.CustomWorkflowTaskDisplayContext"%>
<%@page
	import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="java.text.Format"%>
<%@page import="com.liferay.portal.kernel.util.Time"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page
	import="com.liferay.portal.kernel.model.UserNotificationDeliveryConstants"%>
<%@page
	import="com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.petra.string.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HashMapBuilder"%>
<%@page import="com.liferay.portal.kernel.model.UserNotificationEvent"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextFactory"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page
	import="com.liferay.portal.kernel.notifications.UserNotificationManagerUtil"%>
<%@page
	import="com.liferay.portal.kernel.notifications.UserNotificationFeedEntry"%>
<%@ include file="/init.jsp"%>

<p>
	<b><liferay-ui:message key="testing.caption" /></b>
</p>

<liferay-ui:tabs
    names='<%= "Add Entry,Notification,Object Definition,Comments Entry" %>'
    param="tabs2"
    refresh="<%= false %>"
    type="tabs nav-tabs-default"
>
    <liferay-ui:section>
        <%@ include file="/form.jsp" %>
    </liferay-ui:section>

    <liferay-ui:section>
 
        <%@ include file="/notification_js.jsp" %>
    </liferay-ui:section>

    <liferay-ui:section>
        <%@ include file="/objectDefinition.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
        <%@ include file="/commentsEntry.jsp" %>
    </liferay-ui:section>
</liferay-ui:tabs>





<%-- <%
	List<UserNotificationEvent> UserNotificationEventList = UserNotificationEventLocalServiceUtil
			.getDeliveredUserNotificationEvents(themeDisplay.getUserId(),
					UserNotificationDeliveryConstants.TYPE_WEBSITE, true, false, -1, -1);
	String sessionJS = (String) request.getSession().getId();
	CustomWorkflowTaskDisplayContext customWorkflowTaskDisplayContext = (CustomWorkflowTaskDisplayContext) renderRequest
			.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>


<aui:form method="post" name="addObjectEntry"
	onSubmit='<%="event.preventDefault(); " + liferayPortletResponse.getNamespace() + "addObjectEntry();"%>'>
	<aui:input name="message" id="message" />
	<aui:input name="document" id="document" type="file" />
	<aui:button type="submit" value="add"></aui:button>
</aui:form>

<liferay-ui:search-container
	total='<%=UserNotificationEventList.size()%>'>
	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(UserNotificationEventList, searchContainer.getStart(),
						searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.model.UserNotificationEvent"
		keyProperty="userNotificationEventId" modelVar="userNotificationEvent">
		<liferay-ui:search-container-column-text
			property="userNotificationEventId" name="userNotificationEventId" />
		<%
			String workflowId = StringPool.BLANK;
					String notificationMessage = StringPool.BLANK;
					Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
					notificationMessage = jsonObject.getString("notificationMessage");
					workflowId = jsonObject.getString("workflowTaskId");
		%>

		<portlet:renderURL var="editWorkflowTask">
			<portlet:param name="mvcPath"
				value="/workflow/workflow_task_edit.jsp" />
			<portlet:param name="workflowId" value="<%=workflowId%>" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="Notification Message">
			<a href="<%=editWorkflowTask%>"><%=notificationMessage%></a>


			<span class="text-default"> <%=Time.getRelativeTimeDescription(userNotificationEvent.getTimestamp(),
								themeDisplay.getLocale(), themeDisplay.getTimeZone(), dateFormatDateTime)%></span>
		</liferay-ui:search-container-column-text>


	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>



<aui:script use="aui-base">
    Liferay.provide(
        window,
        '<portlet:namespace />addObjectEntry',
        () => {
        var sessionId = "<%=sessionJS%>";
        var fileInput = document.getElementById("<portlet:namespace />document");
        var f = fileInput.files[0]; // FileList object
        var reader = new FileReader();
        var fileName = fileInput.files[0].name;
        console.log("File Name:::::::: "+fileName);
          const username = 'test@liferay.com';
        const password = '1234';
        const base64Credentials = btoa(username + ':' + password);
         var message = A.one('#<portlet:namespace />message');
            var companyId ="<%=themeDisplay.getCompanyId()%>";
			var userId ="<%=themeDisplay.getUserId()%>";
			var groupId ="<%=themeDisplay.getScopeGroupId()%>";
        reader.onload = (function(theFile) {
        return function(e) {
          var binaryData = e.target.result;
          var bs = window.btoa(binaryData);
               Liferay.Util.fetch('/o/comments-headless/v1.0/post-comments-entrys', {
               body: JSON.stringify({
                message: message.val(),
                companyId: companyId,
                userId: userId,
                base64Doc: bs,
                fileName: fileName,
                groupId:groupId
            }),
                method: 'POST',
				 headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + base64Credentials,
            },
            }).then(function(response) {
                return response.json();
            }).then(function(response) {
                
             	Liferay.Util.openToast({
                    autoClose: true,
                    message: 'Comments Entry Created',
                    type: 'success'
            });
                
                
            }).catch((error) => {
            console.log(error);
                Liferay.Util.openToast({
                    autoClose: false,
                    message: Liferay.Language.get(
                        'an-unexpected-system-error-occurred'
                    ),
                    type: 'danger',
                });
            });
        };
      })(f);
      reader.readAsBinaryString(f);
        
        },
        ['aui-base','aui-io-request','io', 'liferay-notification','liferay-util-window']
    );
    
</aui:script> --%>
