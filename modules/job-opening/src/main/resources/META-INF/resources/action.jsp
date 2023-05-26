<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.job.opening.service.service.JobinfoLocalServiceUtil"%>
<%@page import="com.job.opening.service.model.Jobinfo"%>
<%@ include file="init.jsp"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects />
<%
	ResultRow row = (ResultRow) renderRequest.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Jobinfo job = (Jobinfo) row.getObject();
%>

 <liferay-portlet:renderURL var="editURL">
				<portlet:param name="mvcPath" value="/update.jsp" />
				<portlet:param name="jobId" value="<%=String.valueOf(job.getJobId())%>" />
			</liferay-portlet:renderURL>

<liferay-portlet:actionURL name="deletejob" var="deleteurl">

	<portlet:param name="jobId"
		value="<%=String.valueOf(job.getJobId())%>"></portlet:param>
</liferay-portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon message="Edit" url="${editURL}" />
	<liferay-ui:icon message="Delete" url="${deleteurl}" />

</liferay-ui:icon-menu>









