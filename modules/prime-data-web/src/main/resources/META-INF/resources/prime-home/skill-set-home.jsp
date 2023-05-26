<%@ include file="/init.jsp" %>

<portlet:actionURL  name="addCategory" var="addSkillSetURL"/>
<%
List<Role> roles = themeDisplay.getUser().getRoles();
for (Role role: roles) {
if (role.getName().contains("Admin")) { 
%>
<aui:form  action="${addSkillSetURL}">
	<aui:input name="category" value="Skill set"/>
	<aui:input name="name"/>
	<aui:button  name="submit" type="submit" value="Save"></aui:button>
</aui:form>
<aui:script>
AUI().use('liferay-auto-fields', function(A) {
	new Liferay.AutoFields({
		contentBox : '#skillTools',
		fieldIndexes : '<portlet:namespace />rowIndexesSkillTools'
	}).render();
});
</aui:script>

<%@ include file="/prime-data-list/skill-set-list.jsp" %>
<% } } %>