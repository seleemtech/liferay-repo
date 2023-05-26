<%@ include file="/init.jsp" %>

<liferay-ui:success key="entryAdded" message="job-added" />
<liferay-ui:success key="entryUpdated" message="job-updated" />
<liferay-ui:success key="entryDeleted" message="job-deleted" />

<portlet:renderURL var="createjobUrl" >
<portlet:param name="mvcPath" value="/createjob.jsp"/>
</portlet:renderURL>

 <aui:button value="Create Job" onClick="${createjobUrl}"></aui:button>
 
<%@page import="com.job.opening.service.model.Jobinfo"%>
<%@page import="java.util.List"%>
<%@page import="com.job.opening.service.service.JobinfoLocalServiceUtil"%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/list.jsp" />
</liferay-portlet:renderURL>

<portlet:renderURL var="updatejobURL" >
<portlet:param name="mvcPath" value="/update.jsp"/>
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/list.jsp" />
</liferay-portlet:renderURL>
<%
	List<Jobinfo> jobs = JobinfoLocalServiceUtil.getJobinfos(-1, -1);
	
%>

<liferay-ui:search-container total="<%=jobs.size()%>"
	var="searchContainer" delta="10" deltaConfigurable="true"
	emptyResultsMessage="No Users To Display">
 <liferay-ui:search-container-results results="<%= JobinfoLocalServiceUtil.getJobinfos(searchContainer.getStart(), searchContainer.getEnd()) %>" >
 </liferay-ui:search-container-results>
 
 <liferay-ui:search-container-row className="com.job.opening.service.model.JobinfoModel" modelVar="job" keyProperty="jobId" > 
 
 
 <liferay-ui:search-container-column-text name="Posting Title" >
 <liferay-portlet:renderURL var="editURL">
				<portlet:param name="mvcPath" value="/update.jsp" />
				<portlet:param name="jobId" value="${job.jobId }" />
			</liferay-portlet:renderURL>
			<a href="${editURL}"><%=job.getPostingTitle() %></a>
			
		</liferay-ui:search-container-column-text>
 <liferay-ui:search-container-column-date property="targetDate" name="Target Date"></liferay-ui:search-container-column-date>
 <liferay-ui:search-container-column-text property="positions" name="No Of Positions"></liferay-ui:search-container-column-text>
  <liferay-ui:search-container-column-text property="jobType" name="Job Type"></liferay-ui:search-container-column-text>
  <liferay-ui:search-container-column-text property="workExperience" name="Required Experience"></liferay-ui:search-container-column-text>
  <liferay-ui:search-container-column-text property="jobopeningStatus" name="Jobopening Status" href="${rowURL}"/> 
 <liferay-ui:search-container-column-jsp name="Actions" path="/action.jsp"  />
 </liferay-ui:search-container-row>
 <liferay-ui:search-iterator />
</liferay-ui:search-container>