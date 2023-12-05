<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletMode"%>
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

<link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> <!-- Include jQuery library -->
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.js"></script>	

<p>
	<b><liferay-ui:message key="testing.caption" /></b>
</p>



<%
	List<UserNotificationEvent> UserNotificationEventList = UserNotificationEventLocalServiceUtil
			.getDeliveredUserNotificationEvents(themeDisplay.getUserId(),
					UserNotificationDeliveryConstants.TYPE_WEBSITE, true, false, -1, -1);
	String sessionJS = (String) request.getSession().getId();
	CustomWorkflowTaskDisplayContext customWorkflowTaskDisplayContext = (CustomWorkflowTaskDisplayContext) renderRequest
			.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>



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




