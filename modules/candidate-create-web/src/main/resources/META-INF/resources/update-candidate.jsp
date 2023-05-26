
<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page import="com.candidate.web.constants.FileTitleConstant"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<portlet:actionURL name="/addORUpdateCandidate" var="updateCandidateURL" />

<%
	long candidateId = ParamUtil.getLong(renderRequest, "candidateId");
	CandidateInfo candidateInfo = null;
	CandidateOtherInfo candiOtherInfo = null;
	ProfessionalDetails professionalDetails = null;
	  SimpleDateFormat inputDateFormat = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
	   SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM");
	String stateName = "";
	/* ThemeDisplay themeDisplays = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY); */

/* 	long groupId = themeDisplays.getScopeGroupId(); */
/* 	System.out.println("groupID"+groupId); */
	if (Validator.isNotNull(candidateId)) {
		System.out.println("iddd" + candidateId);
		candidateInfo = CandidateInfoLocalServiceUtil.fetchCandidateInfo(candidateId);
		candiOtherInfo = CandidateOtherInfoLocalServiceUtil.getByCandidtatesId(candidateId);
		professionalDetails = ProfessionalDetailsLocalServiceUtil.getByCandidateId(candidateId);
		List<Region> regionList = RegionLocalServiceUtil.getRegions(Long.parseLong(candidateInfo.getCountry()),
				true);
		for (Region region : regionList) {
			if (candidateInfo.getState().equalsIgnoreCase(region.getName())) {
				stateName = region.getName();
			}

		}
		
		
	}
%>


<div class="login-container">
	<aui:form action="${updateCandidateURL}" name="createCandidate"
		method="POST" enctype="multipart/form-data">
		<aui:fieldset label="Basic Info" style="font-weight: bold;"
			markupView="lexicon">
			<div class="row ques">
				<clay:col md="6">
					<aui:input name="candidateId"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getCandidateId() : ""%>"
						type="hidden">
					</aui:input>
					<aui:input name="firstName"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getFirstName() : ""%>"
						label="First Name">
						<aui:validator name="required" />
						<aui:validator name="alpha" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="lastName"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getLastName() : ""%>"
						label="Last Name">
						<aui:validator name="required" />
						<aui:validator name="alpha" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="email"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getEmail() : ""%>"
						label="Email">
						<aui:validator name="email" />
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="secondaryEmail"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getSecondaryEmail() : ""%>"
						label="Secondary Email">
						<aui:validator name="email" />
					</aui:input>
				</clay:col>


				<clay:col md="6">
					<aui:input name="mobileNumber"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getMobileNumber() : ""%>"
						label="Mobile">
						<aui:validator name="digits" />
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="website"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getWebsite() : ""%>"
						label="Website">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>

			</div>
		</aui:fieldset>

		<aui:fieldset label="Address Information" style="font-weight: bold;"
			markupView="lexicon">
			<div class="row ques">
				<clay:col md="6">
					<aui:select name="country"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getCountry() : ""%>"
						id="country" label="Country">
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
					<aui:input name="city"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getCity() : ""%>"
						label="city">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="street"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getStreet() : ""%>"
						label="Street">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>



				<clay:col md="6">
					<aui:input name="postalCode"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getZipCode() : ""%>"
						label="Postal Code">
						<aui:validator name="number" />
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="houseNumber"
						value="<%=Validator.isNotNull(candidateInfo) ? candidateInfo.getHouseNumber() : ""%>"
						label="House Number">
						<aui:validator name="number" />
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
		</aui:fieldset>

		<aui:fieldset label="Professional Details" style="font-weight: bold;"
			markupView="lexicon">
			<div class="row ques">

				<clay:col md="6">

					<aui:input name="professionalDetailsId"
						value="<%=Validator.isNotNull(professionalDetails)
									? professionalDetails.getProfessionalDetailsId()
									: ""%>"
						type="hidden">
					</aui:input>
					<aui:input name="experienceinYears" label="Experience in Years" value="<%=Validator.isNotNull(professionalDetails)
									? professionalDetails.getExperience()
									: ""%>" >

						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:select name="qualification"
						value="<%=Validator.isNotNull(professionalDetails) ? professionalDetails.getQualification(): ""%>"
						label="Highest Qualification Held">
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
					<aui:select name="jobTitle"
						value="<%=Validator.isNotNull(professionalDetails) ? professionalDetails.getJobTitle() : ""%>"
						label="Current Job Title">
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
					<aui:input name="expectedSalary"
						value="<%=Validator.isNotNull(professionalDetails) ? professionalDetails.getExpectedSalary()
									: ""%>"
						label="Expected Salary">
						<aui:validator name="number" />
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="currentSalary"
						value="<%=Validator.isNotNull(professionalDetails) ? professionalDetails.getCurrentSalary()
									: ""%>"
						label="Current Salary">
						<aui:validator name="number" />
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="skillSet"
						value="<%=Validator.isNotNull(professionalDetails) ? professionalDetails.getSkillSet() : ""%>"
						label="Skill Set">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:select name="workType"
						value="<%=Validator.isNotNull(professionalDetails) ? professionalDetails.getWorkType() : ""%>"
						label="work Type">
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

					<aui:input name="additionalInfo"
						value="<%=Validator.isNotNull(professionalDetails) ? professionalDetails.getAdditionalInfo()
									: ""%>"
						label="Additional Infomartion">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
				<clay:col md="6">

					<aui:input name="currentEmployer"
						value="<%=Validator.isNotNull(professionalDetails) ? professionalDetails.getCurrentEmployer()
											: ""%>"
						label="Current Employer">
						<aui:validator name="required" />
					</aui:input>
				</clay:col>
		</aui:fieldset>
		<aui:fieldset label="Other Info" style="font-weight: bold;"
			markupView="lexicon">
			<div class="row ques">

				<clay:col md="6">
					<aui:input name="candidateOtherInfoId"
						value="<%=Validator.isNotNull(candiOtherInfo) ? candiOtherInfo.getCandidateOtherInfoId()
									: ""%>"
						type="hidden"></aui:input>
					<aui:input name="folderId"
						value="<%=Validator.isNotNull(candiOtherInfo) ? candiOtherInfo.getFolderId() : ""%>"
						type="hidden">
					</aui:input>
					<aui:select name="candidateStatus"
						value="<%=Validator.isNotNull(candiOtherInfo) ? candiOtherInfo.getCandidateStatus() : ""%>"
						label="Candidate Status">
						<aui:option>Select Title</aui:option>
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
					<aui:select name="source"
						value="<%=Validator.isNotNull(candiOtherInfo) ? candiOtherInfo.getSource() : ""%>"
						label="Source">
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
					<aui:select name="candidateOwner"
						value="<%=Validator.isNotNull(candiOtherInfo) ? candiOtherInfo.getCandidateOwner() : ""%>"
						label="Candidate Owner">
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
					<%
						String[] candidateInstitue = candiOtherInfo.getInstitute().split(",");
					   String[] candidateDepartMent=candiOtherInfo.getDepartment().split(",");
					   String[] candidateDegree=candiOtherInfo.getDegree().split(",");
					   String[] candidateFromDate=candiOtherInfo.getFromDuration().split(",");
					   String[] candidateToDate=candiOtherInfo.getToDuration().split(",");
					 
									
					%>

					<div id="auto-fields-container">
					<%for(int i=0; i < candidateInstitue.length;i++){ 
						String formattedFromDate = outputDateFormat.format(inputDateFormat.parse(candidateFromDate[i]));
						String formattedToDate = outputDateFormat.format(inputDateFormat.parse(candidateToDate[i]));
					%>
						<div class="lfr-form-row lfr-form-row-inline">
							<aui:input label="Institute" value="<%=candidateInstitue[i] %>" name="<%="institute"+i %>">
								<aui:validator name="required" />
							</aui:input>
							<aui:input label="Department" value="<%=candidateDepartMent[i] %>" name="<%="department"+i %>">
								<aui:validator name="required" />
							</aui:input>
							<aui:input label="Degree" value="<%=candidateDegree[i] %>" name="<%="degree"+i %>">
								<aui:validator name="required" />
							</aui:input>
							<h5>
								<b>Duration</b>
							</h5>
							<aui:input label="From" value="<%=formattedFromDate %>" name="<%="FromDuration"+i %>" type="month">
								<aui:validator name="required" />
							</aui:input>
							<aui:input label="To" name="<%="ToDuration"+i %>" value="<%=formattedToDate %>" placeholder="select Date" type="month">
								<aui:validator name="required" />
							</aui:input>
						</div>
						<%System.out.println("Updated Date"+candidateFromDate.toString());} %>
					</div>


				</aui:fieldset>
			</clay:col>
			<clay:col md="6">
				<aui:fieldset label="Experience Details" style="font-weight: bold;"
					markupView="lexicon">
					<%
						String[] candidateOccupation = candiOtherInfo.getOccupation().split(",");
									String[] candidateCompany = candiOtherInfo.getCompany().split(",");
									String[] candidateSummary = candiOtherInfo.getSummary().split(",");
									String[] candidateFromWorkDate = candiOtherInfo.getFromWorkDuration().split(",");
									String[] candidateToWorkDate = candiOtherInfo.getToWorkDuration().split(",");
					%>
					<div id="auto-fields-container1">
					<%for(int i=0;i<candidateOccupation.length;i++){ 
					String formattedFromWorkDate = outputDateFormat.format(inputDateFormat.parse(candidateFromWorkDate[i]));
						String formattedToWorkDate = outputDateFormat.format(inputDateFormat.parse(candidateToWorkDate[i]));%>
						<div class="lfr-form-row lfr-form-row-inline">
							<aui:input label="Occupation" value="<%=candidateOccupation[i] %>" name="<%="occupation"+i %>">
								<aui:validator name="required" />
							</aui:input>
							<aui:input label="Company" value="<%=candidateCompany[i] %>" name="<%="company"+i %>">
								<aui:validator name="required" />
							</aui:input>
							<aui:input label="Summary" value="<%=candidateSummary[i] %>" name="<%="summary"+i %>">
								<aui:validator name="required" />
							</aui:input>
							<h5>
								<b>Work Duration</b>
							</h5>
							<aui:input label="From" value="<%=formattedFromWorkDate %>" name="<%="FromworkDuration"+i%>" type="month">
								<aui:validator name="required" />
							</aui:input>
							<aui:input label="To" value="<%=formattedToWorkDate %>" name="<%="ToworkDuration"+i %>" type="month">
								<aui:validator name="required" />
							</aui:input>
						</div>
						<%} %>
					</div>


				</aui:fieldset>
			</clay:col>
		</div>
		<aui:fieldset label="Attachment Information"
			style="font-weight: bold;" markupView="lexicon">
			<%
			DLFileEntry resumefileEntry=DLFileEntryLocalServiceUtil.fetchFileEntry(20121, candiOtherInfo.getFolderId(),FileTitleConstant.RESUME); 
			System.out.println("getFileEntryId:::::::::::::"+resumefileEntry.getFileEntryId()+"getFileName::::::::::::"+resumefileEntry.getContentStream());
			%>
			<div class="row ques">
				<clay:col md="6">
					<div class="form-group-autofit">
						<div class="form-group-item">
							<div class="form-group">
								<h5>
									<b>Resume</b>
								</h5>
								<label class="sr-only" for="resume"></label> <aui:input name="resumeFile"
									type="file" value="<%=Validator.isNotNull(resumefileEntry)?resumefileEntry.getFileName():"" %>" />
							</div>
							<div class="form-group">
								<h5>
									<b>Cover Letter</b>
								</h5>
								<label class="sr-only" for="coverletter"></label> <input
									name="coverLetterFile" type="file" value="<%=Validator.isNotNull(resumefileEntry)?resumefileEntry.getFileName():"" %>"  />
							</div>
							<div class="form-group">
								<h5>
									<b>Others</b>
								</h5>
								<label class="sr-only" for="others"></label> <input name="otherFiles"
									type="file"  />
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
	
	var state = '<%=Validator.isNotNull(stateName)? stateName:"" %>'; 
      console.log(state);
var updateStateSelect = $("#<portlet:namespace />state"); 
	
	  updateStateSelect.append($('<option>', {
    value: state,
    text: state
}));
updateStateSelect.val(state);

		 });
	
		
</aui:script>