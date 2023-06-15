<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%
long azid=ParamUtil.getLong(renderRequest, "azId");
System.out.println("azidazidazid"+azid);

List<Map<String, Object>> dataList = (List<Map<String, Object>>) request.getAttribute("dataList");


List<Map<String, Object>> matchingDataList = dataList.stream()
.filter(data -> ((Number) data.get("azId")).longValue() == azid)
.collect(Collectors.toList());
System.out.println("sortedDataList"+matchingDataList);

%>

<portlet:actionURL name="updateListAPi" var="updateApiURL" />
<%
for(Map<String,Object> data :matchingDataList ){
	
	
%>
 <aui:form name="fn" action="<%= updateApiURL%>">

<aui:input name="azId" type="hidden" value="<%=data.get("azId") %>" > </aui:input>
<aui:input name="name" value="<%=data.get("name") %>" > </aui:input>
<aui:input name="age" value="<%=data.get("age") %>"> </aui:input>
<aui:input name="mobileNumber" value="<%=data.get("mobileNumber") %>"> </aui:input>
<aui:input name="email" value="<%=data.get("email") %>"> </aui:input>
<aui:button value="Save" type="submit" />

</aui:form> 
<%}%>