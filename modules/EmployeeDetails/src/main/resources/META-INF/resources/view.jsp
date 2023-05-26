
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.employeeDetails.constants.EmployeeDetailsPortletKeys"%>
<%@ include file="/init.jsp" %>
<%
String selectedTab =EmployeeDetailsPortletKeys.ADD_EMPLOYEE;
String empDetailsTabs=(String) request.getAttribute("employeeTabs");

if(Validator.isNull(empDetailsTabs)){
	empDetailsTabs=ParamUtil.getString(request, "employeeTabs");
	
}
if(Validator.isNotNull(empDetailsTabs)){
	selectedTab=empDetailsTabs;
}


%>

<div class="container-fluid">
<liferay-ui:tabs names="Add Employee,View Employee Details" refresh="false" value="<%= selectedTab %>">

<liferay-ui:section>
        <%@ include file="/createemployee.jsp" %>
    </liferay-ui:section>
    <liferay-ui:section>
        <%@ include file="/display.jsp" %>
    </liferay-ui:section>

</liferay-ui:tabs>



</div>