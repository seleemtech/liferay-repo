<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addSalesStageURL"/>
<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addSalesStageURL}">
	<aui:input name="category" value="Sales stage"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>
<%@ include file="/prime-data-list/sales-stage-list.jsp" %>
<% } } %>