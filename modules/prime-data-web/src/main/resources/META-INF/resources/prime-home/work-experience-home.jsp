	<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addWorkExperienceURL"/>
<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addWorkExperienceURL}">
	<aui:input name="category" value="Work experience"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>

<%@ include file="/prime-data-list/work-experience-list.jsp" %>
<% } } %>