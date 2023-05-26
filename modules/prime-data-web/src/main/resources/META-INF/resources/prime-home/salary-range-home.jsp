<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addSalaryRangeURL"/>
<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addSalaryRangeURL}">
	<aui:input name="category" value="Salary range"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>

<%@ include file="/prime-data-list/salary-range-list.jsp" %>
<% } } %>