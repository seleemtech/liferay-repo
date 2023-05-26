<%@page import="com.crud.service.service.CrudLocalServiceUtil"%>
<%@page import="com.crud.service.model.Crud"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>


 <%
	long crudId = ParamUtil.getLong(renderRequest, "crudId");

	Crud crd = null;
	if (crudId > 0) {
		crd = CrudLocalServiceUtil.fetchCrud(crudId);
	}
%> 
<portlet:actionURL name="updateData" var="actionURL" />


<aui:form action="<%=actionURL%>" method="post" name="fm">
	 <aui:model-context bean="<%=crd%>" model="<%=Crud.class%>" />
	<aui:fieldset>
	<aui:input name="crudId" type="hidden"/>
	<aui:input name="crudName" />
	<aui:input name="crudNo" />
	
	</aui:fieldset>
<aui:button-row>
		<aui:button type="submit" name="save" />
	</aui:button-row>
</aui:form>
