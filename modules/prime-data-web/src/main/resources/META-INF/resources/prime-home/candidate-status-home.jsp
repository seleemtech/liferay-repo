<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addCandidateStatusURL"/>

<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>

<aui:form  action="${addCandidateStatusURL}">
	<aui:input name="category" value="Candidate status"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>


<%@ include file="/prime-data-list/candidate-status-list.jsp" %>
<% } } %>