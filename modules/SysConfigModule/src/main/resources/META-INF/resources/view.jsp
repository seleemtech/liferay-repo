<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="sysconfigmodule.caption"/></b>
</p>
<portlet:actionURL name="addEntry" var="addEntryURL" />
<aui:form action="<%= addEntryURL %>" name="<portlet:namespace />fm">
<aui:button type="submit"></aui:button>
</aui:form>