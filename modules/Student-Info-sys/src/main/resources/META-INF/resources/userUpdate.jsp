
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.student.info.sys.constants.StudentInfoSysPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%@page
	import="com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoColumn"%>
<%@page
	import="com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoTable"%>
<%@page
	import="com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoValue"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page
	import="com.liferay.portal.kernel.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.UserGroup"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL name="updateUser" var="actionURL" />
<%
	long userID = ParamUtil.getLong(renderRequest, "userId");
	System.out.println("user id is came" + userID);
	long companyId = PortalUtil.getDefaultCompanyId(); // Get the default company ID
	ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(companyId, User.class.getName(),
			StudentInfoSysPortletKeys.CUSTOM_USER_TABLE, StudentInfoSysPortletKeys.CUSTOM_USER_COLUMN, userID);
	String genderData = expandoValue.getData();
	System.out.println("Gender is coming:::::"+genderData);
	User users = null;

	if (userID > 0) {
		users = UserLocalServiceUtil.fetchUserById(userID);
		
			}

%>

<div class="container mt-5" id="cont">
	<div class="row">
		<div class="col-md-6 mx-auto">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title text-center">Registration</h4>
					<aui:form action="<%=actionURL%>" method="POST" name="fm" id="fm">
						<aui:model-context bean="<%=users%>" model="<%=User.class%>" />
					<div class="form-group">
							<aui:input  class="form-control" name="userId" type="hidden"	>
				
							</aui:input>
						</div>
						<div class="form-group">
							<aui:input type="text" class="form-control" name="firstName"
								placeholder="Enter First name">
								<aui:validator name="required" />
							</aui:input>
						</div>
						<div class="form-group">
							<aui:input type="text" class="form-control" name="lastName"
								placeholder="Enter last name">
								<aui:validator name="required" />
							</aui:input>
						</div>
						
						<div class="form-group">
							<aui:input type="date" label="Date Of Birth" 
								name="birthday" ide="birthday" >
							<aui:validator name="required" />
							</aui:input>
						</div>
						<div class="form-group">
							<label for="gender">Gender</label>



							<div class="form-check">
								<aui:input class="form-check-input" type="radio" name="gender" 
									id="male" label="male" value="male"></aui:input>
								<aui:input class="form-check-input" type="radio" name="gender" 
									label="Female" id="female" value="female" />
								<aui:input class="form-check-input" label="Other" type="radio" 
									name="gender" id="other" value="other" />
							</div>
						</div>

				
						<aui:button type="submit" value="Update" />
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
  var gender = '<%= genderData %>'; // get the gender value from JSP

  $('input[name=<portlet:namespace/>gender][value=' + gender + ']').prop('checked', true);
  var dateString = '<%=users.getBirthday().toString()%>';
  console.log("date"+dateString);
  if (dateString != null) {

	  var selectedDate = new Date(dateString);
	    // Use the date object as needed
	    var formattedDate = selectedDate.toISOString().substring(0, 10);;
	  $('input[name=<portlet:namespace/>birthday]').val(formattedDate);
	}


 

});
</script>