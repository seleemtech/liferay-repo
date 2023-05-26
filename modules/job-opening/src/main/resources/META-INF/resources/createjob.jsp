
<%@page
	import="com.prime.data.service.service.ProjectStatusLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.ProjectStatus"%>
<%@page import="com.prime.data.service.service.IndustryLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.Industry"%>
<%@page import="com.prime.data.service.service.SkillSetLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.SkillSet"%>
<%@page
	import="com.prime.data.service.service.WorkExperienceLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.WorkExperience"%>
<%@page import="com.prime.data.service.service.JobTypeLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.JobType"%>
<%@page
	import="com.prime.data.service.service.JobOpeningStatusLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.JobOpeningStatus"%>
<%@page
	import="com.prime.data.service.service.CurrJobTitleLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.CurrJobTitle"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page
	import="com.liferay.admin.kernel.util.PortalUserPersonalBarApplicationType"%>
<%@page
	import="com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.UserGroupRole"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>

<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>


<liferay-portlet:actionURL name="createorupdateJob" var="createorupdatejobUrl">
	<portlet:param name="mvcActionCommand" value="createorupdateJob" />
</liferay-portlet:actionURL>

<div class="login-container">
	<aui:form action="${createorupdatejobUrl}" name="createorupdateJob" method="POST"
		enctype="multipart/form-data">
		<aui:fieldset label="Job Opening Information"
			style="font-weight: bold;" markupView="lexicon">
			<div class="row ques">

				<clay:col md="6">
					<aui:input name="postingTitle" label="Posting Title">
						<aui:validator name="alpha" />
					</aui:input>
				</clay:col>
				<clay:col md="6">

					<aui:select name="title" label="Title">
						<aui:option>Select Title</aui:option>
						<%
							List<CurrJobTitle> currJobTitles = CurrJobTitleLocalServiceUtil.getCurrJobTitles(-1, -1);
											for (CurrJobTitle currJobTitlesItem : currJobTitles) {
						%>
						<aui:option value="<%=currJobTitlesItem.getCurrentJobTitle()%>"><%=currJobTitlesItem.getCurrentJobTitle()%></aui:option>

						<%
							}
						%>
						<aui:validator name="required"></aui:validator>
					</aui:select>
				</clay:col>

			</div>


			<div class="row ques">
				<clay:col md="6">
					<label>Job Resource</label>
					<clay:row>

						<clay:col md="3">
							<aui:input inlineLabel="right" name="jobResource" type="radio"
								value="InternalResource" label="Internal" />
						</clay:col>
						<clay:col md="3">
							<aui:input inlineLabel="right" name="jobResource" type="radio"
								value="ExternalResource" label="External" />
						</clay:col>


					</clay:row>

				</clay:col>

				<clay:col md="6" id="in" style="display: block;">
					<aui:select name="hiringManager" label="Hiring Manager">
						<aui:option>None</aui:option>
						<aui:option value="Paramesh">Paramesh</aui:option>
						<aui:option value="Vinoth">Vinoth</aui:option>

					</aui:select>
				</clay:col>
				<clay:col md="6" id="out" style="display: none;">
					<aui:select name="clientName" onChange="" label="Client Name">
						<aui:option value="" label="Select Client"></aui:option>
						<aui:option value="TCS" label="TCS"></aui:option>
						<aui:option value="Infosys" label="Infosys"></aui:option>

					</aui:select>
				</clay:col>
			</div>



			<div class="row ques">
				<clay:col md="6">
					<aui:select name="assignedRecruiter" label="Assigned Recruiter">
						<aui:option value="" label="Select Recruiter"></aui:option>
						<aui:option value="Nazer" label="Nazer"></aui:option>
						<aui:option value="Ali" label="Ali"></aui:option>

					</aui:select>
				</clay:col>

				<clay:col md="6">
					<aui:input name="positions" label="No Of Positions">
						<aui:validator name="digits"></aui:validator>
					</aui:input>

				</clay:col>
			</div>

			<div class="row ques">
				<clay:col md="6">
					<aui:input name="dateOpened" label="Date Opened" id="from_date"
						placeholder="Enter Opened Date" type="date">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="targetDate" label="Target Date" id="to_date"
						placeholder="Enter Target Date" type="date">
						<aui:validator name="required" />
						<aui:validator name="custom"
							errorMessage="Target date must be greater than start date">

function () {

var result = false;

let from_date = document.getElementById("<portlet:namespace />from_date").value;

let selected_date = document.getElementById("<portlet:namespace />to_date").value;

console.log(selected_date);

let date1 = new Date(from_date);

let date2 = new Date(selected_date);

if (date1 < date2) {

result = true;

}

console.log(result);

return result;

}

</aui:validator>

					</aui:input>
				</clay:col>



			</div>
			<div class="row ques">

				<clay:col md="6">
					<aui:select name="jobopeningStatus" label="Job Opening Status">
						<aui:option>Select status</aui:option>
						<%
							List<JobOpeningStatus> jobOpeningStatus = JobOpeningStatusLocalServiceUtil
													.getJobOpeningStatuses(-1, -1);
											for (JobOpeningStatus jobOpeningStatusItem : jobOpeningStatus) {
						%>
						<aui:option
							value="<%=jobOpeningStatusItem.getJobOpeningStatus()%>"><%=jobOpeningStatusItem.getJobOpeningStatus()%></aui:option>

						<%
							}
						%>

					</aui:select>

				</clay:col>
				<clay:col md="6">
					<aui:select name="jobType" label="Job Type">
						<aui:option>None</aui:option>
						<%
							List<JobType> jobTypes = JobTypeLocalServiceUtil.getJobTypes(-1, -1);
											for (JobType jobTypesItem : jobTypes) {
						%>
						<aui:option value="<%=jobTypesItem.getJobType()%>"><%=jobTypesItem.getJobType()%></aui:option>

						<%
							}
						%>
						<aui:validator name="required"></aui:validator>
					</aui:select>
				</clay:col>

			</div>

			<div class="row ques">
				<clay:col md="6">
					<aui:select name="workExperience" label="Work Experience">
						<aui:option>None</aui:option>
						<%
							List<WorkExperience> workExperiences = WorkExperienceLocalServiceUtil.getWorkExperiences(-1,
													-1);
											for (WorkExperience workExperiencesItem : workExperiences) {
						%>
						<aui:option value="<%=workExperiencesItem.getWorkExpRange()%>"><%=workExperiencesItem.getWorkExpRange()%></aui:option>

						<%
							}
						%>
						<aui:validator name="required"></aui:validator>
					</aui:select>
				</clay:col>
				<clay:col md="6">
					<aui:select name="skillSet" label="Skill Set">
						<aui:option>None</aui:option>
						<%
							List<SkillSet> skillSets = SkillSetLocalServiceUtil.getSkillSets(-1, -1);
											for (SkillSet skillSetsItem : skillSets) {
						%>
						<aui:option value="<%=skillSetsItem.getSkillCategoryTools()%>"><%=skillSetsItem.getSkillCategoryTools()%></aui:option>

						<%
							}
						%>
					</aui:select>


				</clay:col>
			</div>
			<div class="row ques">

				<clay:col md="6">
					<aui:select name="industry" label="Industry">
						<aui:option>None</aui:option>
						<%
							List<Industry> industries = IndustryLocalServiceUtil.getIndustries(-1, -1);
											for (Industry industriesItem : industries) {
						%>
						<aui:option value="<%=industriesItem.getIndustryName()%>"><%=industriesItem.getIndustryName()%></aui:option>

						<%
							}
						%>

					</aui:select>
				</clay:col>
				<clay:col md="6">
					<aui:select name="projectStatus" label="Project Status">
						<aui:option>None</aui:option>
						<%
							List<ProjectStatus> projectStatus = ProjectStatusLocalServiceUtil.getProjectStatuses(-1,
													-1);
											for (ProjectStatus projectStatusItem : projectStatus) {
						%>
						<aui:option value="<%=projectStatusItem.getProjectStatus()%>"><%=projectStatusItem.getProjectStatus()%></aui:option>

						<%
							}
						%>
					</aui:select>


				</clay:col>


			</div>
		</aui:fieldset>
		<aui:fieldset label="Address Information" style="font-weight: bold"
			markupView="lexicon">
			<%-- <aui:input name="remote" type="radio" value="0" label="Remote">

</aui:input> --%>

			<div class="row ques">
				<clay:col md="6">
					<aui:input name="city" label="City">
						<aui:validator name="alpha" />
					</aui:input>
				</clay:col>
				<clay:col md="6">
					<aui:input name="state" label="State">
						<aui:validator name="required"></aui:validator>
					</aui:input>
				</clay:col>
			</div>
			<div class="row ques">
				<clay:col md="6">
					<aui:select id="" name="country" onChange="" label="Country">
						<aui:option value="" label="Select Country"></aui:option>
						<%
							List<Country> countryList = CountryServiceUtil.getCountries();

											for (Country p : countryList) {
						%>

						<aui:option value="<%=p.getName()%>"><%=p.getName()%>
						</aui:option>
						<%
							}
						%>


					</aui:select>

				</clay:col>
				<clay:col md="6">
					<aui:input name="postalCode" label="Postal Code">
						<aui:validator name="digits"></aui:validator>
					</aui:input>
				</clay:col>
			</div>
		</aui:fieldset>
		<aui:fieldset label="Description Information"
			style="font-weight: bold" markupView="lexicon">
			<h5>Job Description</h5>
			<liferay-ui:input-editor width="100%" name="jobDescription" />
			<h5>Requirements</h5>
			<liferay-ui:input-editor width="100%" name="requirements" />
			<h5>Benefits</h5>
			<liferay-ui:input-editor width="100%" name="benefits" />

		</aui:fieldset>
		<aui:fieldset label="Attachment Information" style="font-weight: bold"
			markupView="lexicon">
			<div class="row ques">
				<clay:col>
					<aui:input type="file" name="jobsummary" label="Job Summary">
						<aui:validator name="acceptFiles">
                                  'pdf'
                          </aui:validator>
					</aui:input>
				</clay:col>


				<clay:col>
					<aui:input type="file" name="others" label="Others">
						<aui:validator name="acceptFiles">
                                  'pdf'
                          </aui:validator>
					</aui:input>
				</clay:col>



			</div>
		</aui:fieldset>

		<div class="button-holder">
			<aui:button value="Save" type="submit" />
		</div>

	</aui:form>

</div>
<aui:script>


AUI().ready('node','event',function(A) {
A.all("input[name=<portlet:namespace />jobResource]").on('change',function() {
var jobResource = A.one("input[name=<portlet:namespace />jobResource]:checked").get("value");
if (jobResource =="InternalResource") {
A.all('#in').show();
A.all('#out').hide();

} else if (jobResource =="ExternalResource")  {
A.all('#out').show();
A.all('#in').hide();
}



});

});

AUI().use('aui-datepicker', function(A) {
        new A.DatePicker({
            trigger : '#<portlet:namespace />#to_date',
            popover : {
                zIndex : 1
            }
        });
    });
   
   
    AUI().use('aui-datepicker', function(A) {
        new A.DatePicker({
            trigger : '#<portlet:namespace />#from_date',
            popover : {
                zIndex : 1
            }
        });
    });
    
  
</aui:script>