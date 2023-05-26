<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.intranet.service.EmployeeDetailsLocalServiceUtil"%>
<%@page import="com.intranet.model.EmployeeDetails"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="/init.jsp"%>

<%
SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
PortletURL updateURL = renderResponse.createActionURL();
updateURL.setParameter(ActionRequest.ACTION_NAME, "updateEmployee");


EmployeeDetails emp = null;

long employeeID = ParamUtil.getLong(request, "employeeID");
if (employeeID > 0) {
	emp = EmployeeDetailsLocalServiceUtil.fetchEmployeeDetails(employeeID);
	updateURL.setParameter("employeeID", String.valueOf(emp.getEmployeeID()));
}
%>


<div class="card">
	<div class="card-block">

		<h3 class="employeetitle">Personal Details</h3>

		<aui:form name="create" method="POST" enctype="multipart/form-data"
			action="<%=updateURL.toString()%>">

			<div class="row ques">

				<div class="col-md-6">
					<aui:input name="employeename" label="Employee Name" value="">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
				<div class="col-md-6">
					<aui:input name="screenName" label="Screen Name" value="">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>

			</div>
			<div class="row ques">
				<div class="col-md-6">
					<aui:select name="domain" label="Domain" value="">
						<aui:option value="alfresco">Alfresco</aui:option>
						<aui:option value="dotnet">Dotnet</aui:option>
						<aui:option value="android">Android</aui:option>
						<aui:option value="java">Java</aui:option>
						<aui:option value="liferay">Liferay</aui:option>
						<aui:option value="php">Php</aui:option>

					</aui:select>


				</div>
				<div class="col-md-6">
					<aui:select name="gender" label="Gender" value="">
						<aui:option>Gender type</aui:option>
						<aui:option value="Male">Male</aui:option>
						<aui:option value="Female">Female</aui:option>

					</aui:select>
				</div>

			</div>
			<div class="row ques">
				<div class="col-md-6">
					<br>
					<aui:input name="contact" label="Contact"
						placeholder="Phone Number" value="">
						<aui:validator name="digit"></aui:validator>
					</aui:input>
				</div>

				<div class="col-md-6">
					<aui:input type="textarea" name="address" label="address"
						placeholder="Please enter your permanant address" value="">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
			</div>
			<div class="row ques">
				<div class="col-md-6">
					<aui:input name="dob" label="Date of Birth"
						placeholder="Date of Birth" value="">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>
				<div class="col-md-6">
					<aui:input name="pannumber" label="Pan Number"
						placeholder="Pan Number" cssClass="panNumber"
						value="">
						<aui:validator name="required"></aui:validator>
						<aui:validator name="custom"
							errorMessage="Please Enter valid PAN Number (Ex:HAKPS2741D)">
				function(val,fieldNode,ruleValue){
				var result=true;
				var pattern=/^([a-zA-Z]){5}([0-9]){4}([a-zA-Z]){1}?$/;
				var check=pattern.test(val);
				if(check==false){
				result=false;
				}
				val=$.trim(val);
				$("#<portlet:namespace />pannumber").val(val);
				return(result);
				}
				</aui:validator>
					</aui:input>
					<p id="pan"></p>
				</div>


			</div>
			<div class="row ques">

				<div class="col-md-6">
					<aui:input name="passportNumber" label="Passport Number"
						cssClass="passNumber"
						value="">
						<aui:validator name="required"></aui:validator>
						<aui:validator name="custom"
							errorMessage="Please Enter valid Passport Number (Ex:S1234567)">
				function(val, fieldNode, ruleValue){
                        var result = true;
                        var pattern = /^([a-zA-Z]){1}([0-9]){7}?$/;
                        var check = pattern.test(val);
                        if(check == false){
                            result = false;
                        }
                        val = $.trim(val);
                        $("#<portlet:namespace />passportNumber").val(val);
                        return result;
                    }
				
				</aui:validator>


					</aui:input>
					<p id="pass"></p>

				</div>
				<div class="col-md-6">
					<aui:input name="Aadhar" label="Aadhar number"
						placeholder="Enter your Aathar Id" cssClass="aadhar"
						value="">
						<aui:validator name="required"></aui:validator>
						<aui:validator name="custom"
							errorMessage="Please Enter valid aadharId (Ex:121134321901)">
				function(val, fieldNode, ruleValue){
                        var result = true;
                        var pattern = /^([0-9]){12}?$/;
                        var check = pattern.test(val);
                        if(check == false){
                            result = false;
                        }
                        val = $.trim(val);
                        $("#<portlet:namespace />Aadhar").val(val);
                        return result;
                    }
				
				</aui:validator>
					</aui:input>
					<p id="aadhar"></p>
				</div>

			</div>

			<div class="row ques">
				<div class="col-md-6">
					<aui:input name="joiningDate" label="Joining Date"
						placeholder="Joining Date"
						value="">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</div>

				<div class="col-md-6">
					<aui:input name="email" label="Email" placeholder="Email Id"
						value="">
						<aui:validator name="required"></aui:validator>
						<aui:validator name="email"></aui:validator>
					</aui:input>
				</div>
			</div>

			<div class="row ques">

				<div class="col-md-6">
					<label>Marital Status</label>
					<div class="row">

						<div class="col-md-3">
							<aui:input inlineLabel="right" name="maritalstatus" type="radio"
								value="true" label="Married" />
						</div>
						<div class="col-md-9">
							<aui:input inlineLabel="right" name="maritalstatus" type="radio"
								value="false" label="Unmarried" />
						</div>
					</div>
				</div>

				<div class="col-md-6" id="anniversarydate" style="display: none;"
					value="">
					<aui:input name="anniversaryDate" label="Anniversary Date"
						placeholder="Anniversary Date">

					</aui:input>
				</div>
			</div>
			<div class="row ques">
				<div class="col-md-4">
					<h3>Upload Document</h3>
				</div>


				<div class="col-md-4">
					<aui:input type="file" name="uploadedFile" label="File Upload">

					</aui:input>
				</div>
			</div>


			<div class="button-holder">
				<aui:button value="Save" type="submit" />
			</div>
		</aui:form>
	</div>
</div>
