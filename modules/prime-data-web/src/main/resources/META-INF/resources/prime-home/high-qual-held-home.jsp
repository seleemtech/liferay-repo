<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addHighQualHeldURL"/>
<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addHighQualHeldURL}">
	<aui:input name="category" value="Highest qualification held"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>


<%@ include file="/prime-data-list/high-qual-held-list.jsp" %>
<% } } %>