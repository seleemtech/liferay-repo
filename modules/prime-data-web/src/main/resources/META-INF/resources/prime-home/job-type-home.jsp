<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addJobTypeURL"/>

<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addJobTypeURL}">
	<aui:input name="category" value="Job type"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>

<%@ include file="/prime-data-list/job-type-list.jsp" %>
<% } } %>