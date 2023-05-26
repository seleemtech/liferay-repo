<%@page
	import="com.liferay.portal.kernel.service.RegionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Region"%>
<%@page
	import="com.candidate.service.service.CandidateOtherInfoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.candidate.service.model.CandidateOtherInfo"%>
<%@page
	import="com.candidate.service.service.ProfessionalDetailsLocalServiceUtil"%>
<%@page import="com.candidate.service.model.ProfessionalDetails"%>
<%@page
	import="com.candidate.service.service.CandidateInfoLocalServiceUtil"%>
<%@page import="com.candidate.service.model.CandidateInfo"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.prime.data.service.service.WorkTypeLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.WorkType"%>
<%@page import="com.prime.data.service.service.SourceByLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.SourceBy"%>
<%@page
	import="com.prime.data.service.service.CandidateStatusLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.CandidateStatus"%>
<%@page
	import="com.liferay.portal.kernel.repository.event.WorkflowRepositoryEventType"%>
<%@page
	import="com.prime.data.service.service.CurrJobTitleLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.CurrJobTitle"%>
<%@page
	import="com.prime.data.service.service.HighQualHeldLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.HighQualHeld"%>
<%@page import="java.util.List"%>
<%@page
	import="com.liferay.portal.kernel.service.CountryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@ include file="./init.jsp"%>
<portlet:resourceURL var="resourceURL" />
<portlet:actionURL name="/addORUpdateCandidate" var="createCandidateURL" />



<div class="login-container">
	<aui:form action="${createCandidateURL}" name="createCandidate"
		method="POST" enctype="multipart/form-data">
		<aui:fieldset label="Basic Info" style="font-weight: bold;"
			markupView="lexicon">
			<div class="row ques">
				<clay:col md="6">
					<aui:input name="candidateId"
						value=""
						type="hidden">
					</aui:input>
					<aui:input name="firstName" label="First Name">
						<aui:validator name="required" />
						<aui:validator name="alpha" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="lastName" label="Last Name">
						<aui:validator name="required" />
						<aui:validator name="alpha" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="email" label="Email">
						<aui:validator name="email" />
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="secondaryEmail" label="Secondary Email">
						<aui:validator name="email" />
					</aui:input>
				</clay:col>


				<clay:col md="6">
					<aui:input name="mobileNumber" label="Mobile">
						<aui:validator name="number"/>
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="website" label="Website">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>

			</div>
		</aui:fieldset>

		<aui:fieldset label="Address Information" style="font-weight: bold;"
			markupView="lexicon">
			<div class="row ques">
				<clay:col md="6">
					<aui:select name="country" id="country" label="Country">
						<aui:option>Select country</aui:option>
						<%
							List<Country> countryList = CountryLocalServiceUtil.getCountries(-1, -1);
											for (Country country : countryList) {
						%>
						<aui:option value="<%=country.getCountryId()%>"><%=country.getName()%></aui:option>

						<%
							}
						%>
						<aui:validator name="required" />
					</aui:select>
				</clay:col>
				<clay:col md="6">
					<aui:select name="state" id="state" label="State">
						<aui:option>Select State</aui:option>
						<aui:validator name="required" />
					</aui:select>
				</clay:col>
				<clay:col md="6">
					<aui:input name="city" label="city">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="street" label="Street">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>



				<clay:col md="6">
					<aui:input name="postalCode" label="Postal Code">
						<aui:validator name="number"/>
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="houseNumber" label="House Number">
						<aui:validator name="number"/>
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
		</aui:fieldset>

		<aui:fieldset label="Professional Details" style="font-weight: bold;"
			markupView="lexicon">
			<div class="row ques">

				<clay:col md="6">
					<aui:input name="professionalDetailsId"
						value="" type="hidden">
					</aui:input>
					<aui:input name="experienceinYears" label="Experience in Years">
						
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:select name="qualification" label="Highest Qualification Held">
						<aui:option>Select Qualification</aui:option>
						<%
							List<HighQualHeld> highQualHelds = HighQualHeldLocalServiceUtil.getHighQualHelds(-1, -1);
											for (HighQualHeld highQualHeldsItem : highQualHelds) {
						%>
						<aui:option value="<%=highQualHeldsItem.getHighQualHeld()%>"><%=highQualHeldsItem.getHighQualHeld()%></aui:option>

						<%
							}
						%>
						<aui:validator name="required" />
					</aui:select>
				</clay:col>
				<clay:col md="6">
					<aui:select name="jobTitle" label="Current Job Title">
						<aui:option>Select Title</aui:option>
						<%
							List<CurrJobTitle> currJobTitles = CurrJobTitleLocalServiceUtil.getCurrJobTitles(-1, -1);
											for (CurrJobTitle currJobTitlesItem : currJobTitles) {
						%>
						<aui:option value="<%=currJobTitlesItem.getCurrJobTitleId()%>"><%=currJobTitlesItem.getCurrentJobTitle()%></aui:option>

						<%
							}
						%>
						<aui:validator name="required" />
					</aui:select>
				</clay:col>

				<clay:col md="6">
					<aui:input name="expectedSalary" label="Expected Salary">
						<aui:validator name="number"/>
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="currentSalary" label="Current Salary">
						<aui:validator name="number"/>
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="skillSet" label="Skill Set">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:select name="workType" label="work Type">
						<aui:option>Select Type</aui:option>
						<%
							List<WorkType> workTypes = WorkTypeLocalServiceUtil.getWorkTypes(-1, -1);
											for (WorkType workTypesItem : workTypes) {
						%>
						<aui:option value="<%=workTypesItem.getWorkTypeName()%>"><%=workTypesItem.getWorkTypeName()%></aui:option>

						<%
							}
						%>
						<aui:validator name="required" />
					</aui:select>
				</clay:col>
				<clay:col md="6">

					<aui:input name="additionalInfo" label="Additional Infomartion">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">

					<aui:input name="currentEmployer" label="Current Employer">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
		</aui:fieldset>
		<aui:fieldset label="Other Info" style="font-weight: bold;"
			markupView="lexicon">
			<div class="row ques">

				<clay:col md="6">
					<aui:input name="candidateOtherInfoId"
						value=""
						type="hidden"></aui:input>
					<aui:input name="folderId"
						value=""
						type="hidden">
					</aui:input>
					<aui:select name="candidateStatus" label="Candidate Status">
						<aui:option>Select Status</aui:option>
						<%
							List<CandidateStatus> candidateStatus = CandidateStatusLocalServiceUtil
													.getCandidateStatuses(-1, -1);
											for (CandidateStatus candidateStatusItem : candidateStatus) {
						%>
						<aui:option value="<%=candidateStatusItem.getCandidateStatus()%>"><%=candidateStatusItem.getCandidateStatus()%></aui:option>

						<%
							}
						%>
						<aui:validator name="required" />
					</aui:select>
				</clay:col>
				<clay:col md="6">
					<aui:select name="source" label="Source">
						<aui:option>Select Title</aui:option>
						<%
							List<SourceBy> sourceBies = SourceByLocalServiceUtil.getSourceBies(-1, -1);
											for (SourceBy sourceBiesItem : sourceBies) {
						%>
						<aui:option value="<%=sourceBiesItem.getSourceBy()%>"><%=sourceBiesItem.getSourceBy()%></aui:option>

						<%
							}
						%>
						<aui:validator name="required" />
					</aui:select>
				</clay:col>
				<clay:col md="6">
					<aui:select name="candidateOwner" label="Candidate Owner">
						<aui:option>Select Title</aui:option>
						<aui:option value="none">None</aui:option>
						<aui:option value="option-1">Option-1</aui:option>
						<aui:option value="option-2">Option-2</aui:option>
						<aui:validator name="required" />
					</aui:select>
				</clay:col>
		</aui:fieldset>
		<div class="row">
			<clay:col md="6">
				<aui:fieldset label="Educational Details" style="font-weight: bold;"
					markupView="lexicon">


					<div id="auto-fields-container">
						<div class="lfr-form-row lfr-form-row-inline">
							<aui:input label="Institute" name="institute0" ><aui:validator name="required" /></aui:input>
							<aui:input label="Department" name="department0" ><aui:validator name="required" /></aui:input>
							<aui:input label="Degree" name="degree0" ><aui:validator name="required" /></aui:input>
							<h5>
								<b>Duration</b>
							</h5>
							<aui:input label="From" name="FromDuration0" type="month" ><aui:validator name="required" /></aui:input>
							<aui:input label="To" name="ToDuration0" type="month" ><aui:validator name="required" /></aui:input>
						</div>
					</div>


				</aui:fieldset>
			</clay:col>
			<clay:col md="6">
				<aui:fieldset label="Experience Details" style="font-weight: bold;"
					markupView="lexicon">

					<div id="auto-fields-container1">
						<div class="lfr-form-row lfr-form-row-inline">
							<aui:input label="Occupation" name="occupation0"><aui:validator name="required" /></aui:input>
							<aui:input label="Company" name="company0" ><aui:validator name="required" /></aui:input>
							<aui:input label="Summary" name="summary0" ><aui:validator name="required" /></aui:input>
							<h5>
								<b>Work Duration</b>
							</h5>
							<aui:input label="From" name="FromworkDuration0" type="month" placeholder="YYYY-MM"><aui:validator name="required" /></aui:input>
							<aui:input label="To" name="ToworkDuration0" type="month" ><aui:validator name="required" /></aui:input>
						</div>
					</div>
		

		</aui:fieldset>
		</clay:col>
</div>
<aui:fieldset label="Attachment Information" style="font-weight: bold;"
	markupView="lexicon">
	<div class="row ques">
		<clay:col md="6">
			<div class="form-group-autofit">
				<div class="form-group-item">
					<div class="form-group">
						<h5>
							<b>Resume</b>
						</h5>
						<label class="sr-only" for="resume"></label> <input name="resumeFile"
							type="file" />
					</div>
					<div class="form-group">
						<h5>
							<b>Cover Letter</b>
						</h5>
						<label class="sr-only" for="coverletter"></label> <input
							name="coverLetterFile" type="file" />
					</div>
					<div class="form-group">
						<h5>
							<b>Others</b>
						</h5>
						<label class="sr-only" for="others"></label> <input name="otherFiles"
							type="file" />
					</div>
				</div>
			</div>

		</clay:col>

		<clay:col md="6">
			<div class="form-group-autofit">
				<div class="form-group-item">
					<div class="form-group">
						<h5>
							<b>Offer</b>
						</h5>
						<label class="sr-only" for="offer"></label> <input name="offerFile"
							type="file" />
					</div>
					<div class="form-group">
						<h5>
							<b>Contracts</b>
						</h5>
						<label class="sr-only" for="contracts"></label> <input
							name="contractFiles" type="file" />
					</div>
				</div>
			</div>
		</clay:col>
	</div>
</aui:fieldset>


<div class="button-holder">
	<aui:button value="Save" type="submit" />
</div>

</aui:form>

</div>
<aui:script >
 $(document).ready(function() {

AUI().use('liferay-auto-fields',function(A) {
 new Liferay.AutoFields(
       {
           contentBox: '#auto-fields-container',
           fieldIndexes: '<portlet:namespace />autofieldscontainer',
        on: {
       		'clone': function(event) {
       		},
       		'delete': function(event) {
       		}
       	},
       	sortable: true,
 }
   ).render();
   });
   
   AUI().use('liferay-auto-fields',function(A) {
 new Liferay.AutoFields(
       {
           contentBox: '#auto-fields-container1',
           fieldIndexes: '<portlet:namespace />autofieldscontainer1',
        on: {
       		'clone': function(event) {
       		},
       		'delete': function(event) {
       		}
       	},
       	sortable: true,
 }
   ).render();
   });
    
     $("#<portlet:namespace />country").change(function() {
      var inputVal = $(this).val();
      console.log(inputVal);
          $.ajax({
        url: '<%=resourceURL%>',
     	data : {
		'<portlet:namespace />countryId' : inputVal
		},
		type : "POST",
		dataType : 'json',
		success : function(data) {
					var stateSelect = $("#<portlet:namespace />state"); 
                   stateSelect.empty(); 
       stateSelect.append($('<option>').attr('value','').text('Select State')); $.each(data.StateValue, function(index,state) { 
       var option = $('<option>').attr('value', state.name).text(state.name);
		stateSelect.append(option); });
		 }, 
		error : function(jqXHR,textStatus,errorThrown) { 
		alert("Error: "+ textStatus +	" - "+ errorThrown); }
		 }); }); 
	
	

		 });
		 
		
</aui:script>