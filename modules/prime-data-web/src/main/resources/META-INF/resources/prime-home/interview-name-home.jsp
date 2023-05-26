<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addInterviewNameURL"/>

<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addInterviewNameURL}">
	<aui:input name="category" value="Interview name"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>

<%@ include file="/prime-data-list/interview-name-list.jsp" %>
<% } } %>