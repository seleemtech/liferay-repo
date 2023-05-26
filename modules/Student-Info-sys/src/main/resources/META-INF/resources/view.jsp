
<%@page import="com.liferay.expando.kernel.model.ExpandoBridge"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.liferay.portal.kernel.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.UserGroup"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>

<%@ include file="/init.jsp"%>
<portlet:actionURL name="createUser" var="actionURL" />
<portlet:resourceURL id="/checkUSer" var="resourceURL" />
<portlet:renderURL var="viewUserListURL">
	<portlet:param name="mvcPath" value="/view-user-list.jsp" />
</portlet:renderURL>
<portlet:actionURL var="addStudentURL">
    <portlet:param name="mvcPath" value="/addStudentParent.jsp" />
</portlet:actionURL>
<portlet:actionURL var="addCourseURL">
    <portlet:param name="mvcPath" value="/addCourse.jsp" />
</portlet:actionURL>
<portlet:actionURL var="addTeacherURL">
    <portlet:param name="mvcPath" value="/addTeacher.jsp" />
</portlet:actionURL>
<portlet:actionURL var="ViewAllTheTable">
    <portlet:param name="mvcPath" value="/view-list.jsp" />
</portlet:actionURL>
<aui:button type="submit" value="View User"
	onClick="<%=viewUserListURL%>" />

<aui:button type="submit" value="add Course"
	onClick="<%=addCourseURL%>" />
	<aui:button type="submit" value="add Teacher"
	onClick="<%=addTeacherURL%>" />
	<aui:button type="submit" value="add Student"
	onClick="<%=addStudentURL%>" />
	<aui:button type="submit" value="All The List"
	onClick="<%=ViewAllTheTable%>" />
<%
	long userID = ParamUtil.getLong(renderRequest, "userId");
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
							<aui:select label="UserType" required="true" class="form-control"
								id="usertype" name="usertype" onClick="disableUserGroup();">
								<%
									String[] selectedRoleNames = {"Student", "Parent", "Instructor"};
											List<Role> roles = RoleLocalServiceUtil.getRoles(0, RoleLocalServiceUtil.getRolesCount());

											for (Role role : roles) {
												for (String roleName : selectedRoleNames) {
													if (role.getName().equals(roleName)) {
								%>
								<aui:option value="<%=role.getRoleId()%>"><%=role.getName()%></aui:option>
								<%
									break;
													}
												}
											}
								%>
								<aui:validator name="required" />
							</aui:select>
						</div>
						<div class="form-group" id="userNameContainer">
							<aui:input type="text" required="true" class="form-control"
								label="User Name" name="screenName" id="username"
								placeholder="Enter User name" onblur="checkUser();">
								<aui:validator name="required"
									errorMessage="Please enter user name." />
							</aui:input>
							<p id="userName-error"
								style="display: none; color: red; font-size: 18px;">User
								already exists!</p>
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
						<div class="form-group" id="EmailContainer">
							<aui:input type="email" label="Email address"
								class="form-control" name="emailAddress" id="email"
								onblur="checkUser();" placeholder="Enter email">
								<aui:validator name="required" />
							</aui:input>
							<p id="emailAddress-error"
								style="display: none; color: red; font-size: 18px;">Email
								Address already exists!</p>
						</div>
						<div class="form-group" id="usergroups">
							<aui:select label="UserGroup" class="form-control" id="usergroup"
								name="usergroup">
								<aui:option value="">Select User Group</aui:option>
								<%
									String[] selectedUserGroupNames = {"Department", "Standard"};
											List<UserGroup> userGroups = UserGroupLocalServiceUtil.getUserGroups(0,
													UserGroupLocalServiceUtil.getUserGroupsCount());
											for (UserGroup userGroup : userGroups) {
												for (String userGroupName : selectedUserGroupNames) {
													if (userGroup.getName().equals(userGroupName)) {
								%>
								<aui:option value="<%=userGroup.getUserGroupId()%>"><%=userGroup.getName()%></aui:option>
								<%
									break;
													}
												}
											}
								%>

							</aui:select>
						</div>
						<div class="form-group">
							<aui:input type="date" label="Date Of Birth" required="true"
								name="birthday">
								<aui:validator name="date" />
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

						<div class="form-group">
							<liferay-captcha:captcha url="${captchaURL}" />
						</div>

						<aui:button type="submit" value="Submit" />
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>

<script>

function checkUser() {
    $.ajax({
        url: '<%=resourceURL%>',
			data : $("#<portlet:namespace/>fm").serialize(),
			type : "POST",
			dataType : 'json',
			success : function(data) {
				console.log(data);
				console.log(data.exists);
				if (data.exists) {
					$("#userName-error").show();
				} else {

					$("#userName-error").hide();
				}
				if (data.emailExists) {
					$("#emailAddress-error").show();
				} else {
					$("#emailAddress-error").hide();
				}

			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("Error: " + textStatus + " - " + errorThrown);
			}
		});
	}
	function disableUserGroup(){
		console.log("Disable user");
		var userTypeValue=$("#<portlet:namespace/>usertype option:selected").html();
		 if (userTypeValue.trim() === "Parent") {
				$("#usergroups").hide();
			}else {
				$("#usergroups").show();
				
				
			}
	
	}

</script>










