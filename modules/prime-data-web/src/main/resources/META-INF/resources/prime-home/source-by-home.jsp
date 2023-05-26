<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addSourceURL"/>
<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addSourceURL}">
	<aui:input name="category" value="Source by"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>

<%@ include file="/prime-data-list/source-by-list.jsp" %>
<% } } %>