<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addProjectStatusURL"/>
<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addProjectStatusURL}">
	<aui:input name="category" value="Project status"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>

<%@ include file="/prime-data-list/project-status-list.jsp" %>
<% } } %>