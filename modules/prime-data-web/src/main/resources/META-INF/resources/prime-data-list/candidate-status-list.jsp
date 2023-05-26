<%@page import="com.prime.data.service.model.MainTable"%>
<%@page import="com.prime.data.service.service.MainTableLocalServiceUtil"%>
<%@page import="com.prime.data.service.service.CandidateStatusLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.CandidateStatus"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%
List<MainTable> mainTables = MainTableLocalServiceUtil.getByCategory("Candidate status");
%>
<liferay-ui:search-container total="<%=mainTables.size()%>" var="searchContainer" delta="10" deltaConfigurable="true" 
  emptyResultsMessage="No candidate status To Display">
 <liferay-ui:search-container-results results="<%=ListUtil.subList(mainTables, searchContainer.getStart(),searchContainer.getEnd())%>" />
  <liferay-ui:search-container-row className="com.prime.data.service.model.MainTable" modelVar="jobType" keyProperty="categoryId" >
   <liferay-ui:search-container-column-text name="candidate status ID" property="categoryId"/>
   <liferay-ui:search-container-column-text name="Category" property="category"/>
   <liferay-ui:search-container-column-text name="Name" property="name"/>
  </liferay-ui:search-container-row>
 <liferay-ui:search-iterator />
</liferay-ui:search-container>