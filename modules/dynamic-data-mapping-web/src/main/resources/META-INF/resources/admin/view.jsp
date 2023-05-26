<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/admin/init.jsp" %>

<p>
	<b><liferay-ui:message key="dynamicdatamappingweb.caption"/></b>
</p>

<%
String currentTab = ParamUtil.getString(request, "currentTab", "forms");
currentTab="forms";
%>

<liferay-util:include page="/admin/navigation_bar.jsp" servletContext="<%= application %>" />
<liferay-util:include page="/admin/management_bar.jsp" servletContext="<%= application %>" />
<c:choose>
	<c:when test='<%= currentTab.equals("forms") %>'>
		<liferay-util:include page="/admin/view_form_instance.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test='<%= currentTab.equals("element-set") %>'>
		<liferay-util:include page="/admin/view_element_set.jsp" servletContext="<%= application %>" />
	</c:when>
</c:choose>