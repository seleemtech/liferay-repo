<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addCurrJobTitleURL"/>

<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addCurrJobTitleURL}">
	<aui:input name="category" value="Current job title"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>

<%@ include file="/prime-data-list/current-job-title-list.jsp" %>
<% } } %>