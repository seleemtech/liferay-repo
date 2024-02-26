<%@ include file="/init.jsp" %>
<portlet:actionURL name="/add/masterapplication" var="addMasterData" />
<aui:form method="post" action="${addMasterData}">
<aui:input name="appName" placeholder="Enter the application name" label="Application Name"><aui:validator name="required" /></aui:input>
<aui:input name="baseUrl" placeholder="Enter the application base URL" label="Base Application URL"><aui:validator name="required" /></aui:input>
<aui:select name="httpMethod" label="HTTP Method">
	<aui:option value="">Select a Method</aui:option>
	<aui:option value="GET">GET</aui:option>
	<aui:option value="POST">POST</aui:option>
	<aui:option value="UPDATE">UPDATE</aui:option>
	<aui:option value="DELETE">DELETE</aui:option>
	<aui:option value="PUT">PUT</aui:option>
	<aui:option value="PATCH">PATCH</aui:option>
	<aui:validator name="required" />
</aui:select>
<aui:input name="iconUrl" placeholder="Enter the application icon URL" label="Application Icon URL"><aui:validator name="required" /></aui:input>
<aui:button type="submit" value="Submit"></aui:button>
</aui:form>