<%@ include file="./init.jsp" %>
<portlet:renderURL var="createCandidateUrl" >
<portlet:param name="mvcPath" value="/createCandidate.jsp"/>
</portlet:renderURL>
<aui:button-row>
<aui:button value="Create Candidate" onClick="${createCandidateUrl}"></aui:button>
</aui:button-row>
<%@ include file="/candidate-list.jsp"%>




