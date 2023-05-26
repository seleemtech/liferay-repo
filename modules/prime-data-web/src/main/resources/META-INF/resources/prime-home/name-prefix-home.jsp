<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addNamePrefixURL"/>
<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addNamePrefixURL}">
	<aui:input name="category" value="Name prefix"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>

<%@ include file="/prime-data-list/name-prefix-list.jsp" %>
<% } } %>