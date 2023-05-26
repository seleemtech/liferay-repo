<%@ include file="/init.jsp"%>

<portlet:actionURL name="editNewsEntry" var="actionURL" />


<aui:form action="<%=actionURL%>" method="post" name="fm">


		<aui:input name="docterId" type="hidden" />
		<aui:input name="docterName"  />

	<aui:button-row>
		<aui:button type="submit" name="save" />
	</aui:button-row>
</aui:form>