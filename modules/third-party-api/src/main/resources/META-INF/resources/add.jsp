<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="updateListAPi" var="updateApiURL" />

 <aui:form name="fn" action="<%= updateApiURL%>">


<aui:input name="name"  > </aui:input>
<aui:input name="age" > </aui:input>
<aui:input name="mobileNumber" > </aui:input>
<aui:input name="email" > </aui:input>
<aui:button value="Save" type="submit" />

</aui:form> 
