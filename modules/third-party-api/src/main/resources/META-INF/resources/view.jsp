<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="thirdpartyapi.caption"/></b>
</p>

<%
List<Map<String, Object>> dataList = (List<Map<String, Object>>) request.getAttribute("dataList");

%>
<portlet:renderURL var="createCandidateUrl" >
<portlet:param name="mvcPath" value="/add.jsp"/>
</portlet:renderURL>
<aui:button-row>
<aui:button value="Create Candidate" onClick="${createCandidateUrl}"></aui:button>
</aui:button-row>
<table class="table table-bordered">
  <tr>
    <th>Name</th>
    <th>Age</th>
    <th>MobileNumber</th>
    <th>Email Address</th>
    <th>Action</th>
  </tr>
  <tbody>
  
  <%
  
  for (Map<String, Object> data : dataList) {
		
	    String property1 = (String) data.get("name");
	    System.out.println("name:::::::::::::"+property1);
	    // ...
	
  %>
  
  <tr>
  <liferay-portlet:renderURL varImpl="viewCandidateURL">
							<portlet:param name="mvcPath" value="/update.jsp" />
							<portlet:param name="azId"
								value="<%=String.valueOf(data.get("azId"))%>"></portlet:param>
								
						</liferay-portlet:renderURL>
    <td><%=data.get("name")%></td>
    <td><%=data.get("age")%></td>
     <td><%=data.get("mobileNumber")%></td>
      <td><%=data.get("email")%></td>
      <portlet:actionURL name="deleteData" var="deleteCrudURL">
				<portlet:param name="azId"
					value="<%=String.valueOf(data.get("azId"))%>" />
			</portlet:actionURL>


			<portlet:renderURL var="updateCrud">
				<portlet:param name="mvcPath" value="/add.jsp" />
				<portlet:param name="crudId"
					value="<%=String.valueOf(data.get("azId"))%>"></portlet:param>
			</portlet:renderURL>
      <td><liferay-ui:icon-menu>
				<liferay-ui:icon message="Delete" url="<%=deleteCrudURL%>" />
				<liferay-ui:icon message="Update" url="<%=updateCrud%>" />
			</liferay-ui:icon-menu></td>
  </tr>
  <%} %>
  </tbody>
</table>