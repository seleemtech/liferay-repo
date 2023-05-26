<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.interview.info.service.InterviewInfoLocalServiceUtil"%>
<%@page import="com.interview.info.model.InterviewInfo"%>
<%@ include file="/init.jsp" %>
<portlet:renderURL var="renderURL">
	<portlet:param name="mvcPath" value="/create-interview.jsp" />
</portlet:renderURL>
<aui:button type="submit" onClick="${renderURL}" value="Create Interview"></aui:button>

<%
	List<InterviewInfo> interviewInfo = InterviewInfoLocalServiceUtil.getInterviewInfos(-1, -1);
%>

<liferay-ui:search-container total="<%=interviewInfo.size()%>"
	var="searchContainer" delta="10" deltaConfigurable="true"
	emptyResultsMessage="No Interviews To Display">
	<liferay-ui:search-container-results
		results="<%=ListUtil.subList(interviewInfo, searchContainer.getStart(), searchContainer.getEnd())%>" />
	<liferay-ui:search-container-row
		className="com.interview.info.model.InterviewInfo" modelVar="ii"
		keyProperty="interviewId">
		<liferay-ui:search-container-column-text name="Interview ID"
			property="interviewId" />
		<liferay-ui:search-container-column-text name="Interview Name" property="interviewName" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>