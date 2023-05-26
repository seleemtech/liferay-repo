<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addPriorityURL"/>
<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addPriorityURL}">
	<aui:input name="category" value="Priority"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>

<%@ include file="/prime-data-list/priority-list.jsp" %>
<% } } %>