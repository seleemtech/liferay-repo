<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addJobOpeningStatusURL"/>

<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addJobOpeningStatusURL}">
	<aui:input name="category" value="Job opening status"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>



<%@ include file="/prime-data-list/job-opening-status-list.jsp" %>
<% } } %>