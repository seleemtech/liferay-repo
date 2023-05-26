<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLAppLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page
	import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.job.opening.service.model.Jobinfo"%>
<%@page import="com.job.opening.service.service.JobinfoLocalServiceUtil"%>
<%@page
	import="com.job.opening.service.service.DescriptiveinfoLocalServiceUtil"%>
<%@page import="com.job.opening.service.model.Descriptiveinfo"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="com.job.opening.service.service.AddressinfoLocalServiceUtil"%>
<%@page import="com.job.opening.service.model.Addressinfo"%>
<%@page import="com.job.opening.service.service.AddressinfoLocalService"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	Object myAttribute = request.getAttribute("job");
	Jobinfo job = JobinfoLocalServiceUtil.getJobinfo(ParamUtil.getLong(request, "jobId"));

	Addressinfo addinfo = AddressinfoLocalServiceUtil.findByjobId(ParamUtil.getLong(request, "jobId"));
	Descriptiveinfo desinfo = DescriptiveinfoLocalServiceUtil.findByjobId(ParamUtil.getLong(request, "jobId"));
%>

<liferay-portlet:actionURL name="createorupdateJob"
	var="createorupdatejobUrl">
	<portlet:param name="mvcActionCommand" value="createorupdateJob" />
</liferay-portlet:actionURL>
<aui:form action="${createorupdatejobUrl}" name="createorupdateJob"
	method="POST" enctype="multipart/form-data">
	<aui:fieldset label="Job Opening Information"
		style="font-weight: bold;" markupView="lexicon">
		<div class="row ques">

			<clay:col md="6">
				<aui:input name="jobId" type="hidden" value="<%=job.getJobId()%>" />
				<aui:input name="postingTitle" label="Posting Title"
					value="${job.getPostingTitle()}">
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</clay:col>
			<clay:col md="6">

				<aui:input name="title" label="Title" value="${job.getTitle()}">

				</aui:input>
			</clay:col>

		</div>


		<div class="row ques">
			<clay:col md="6">
				<label>Job Resource</label>
				<clay:row>

					<clay:col md="3">
						<%
							if (job.getJobResource().equalsIgnoreCase("InternalResource")) {
						%>
						<aui:input inlineLabel="right" name="jobResource" type="radio"
							value="InternalResource" label="Internal" checked="true" />
						<%
							}

												else {
						%>
						<aui:input inlineLabel="right" name="jobResource" type="radio"
							value="ExternalResource" label="External" checked="true" />
						<%
							}
						%>
					</clay:col>


				</clay:row>

			</clay:col>

			<clay:col md="6">

				<%
					if (job.getJobResource().equalsIgnoreCase("InternalResource")) {
				%>
				<aui:input name="hiringManager" label="Hiring Manager"
					value="<%=job.getHiringManager()%>" selected="true" type="text" />
				<%
					}

								else {
				%>
				<aui:input name="clientName" label="Client Name" type="text"
					value="<%=job.getClientName()%>" />
				<%
					}
				%>
			</clay:col>
		</div>



		<div class="row ques">
			<clay:col md="6">
				<aui:input name="assignedRecruiter" label="Assigned Recruiter"
					value="${job.getAssignedRecruiter()}">
				</aui:input>
			</clay:col>

			<clay:col md="6">
				<aui:input name="positions" label="No Of Positions"
					value="${job.getPositions()}">
					<aui:validator name="required"></aui:validator>
				</aui:input>

			</clay:col>
		</div>

		<div class="row ques">
			<clay:col md="6">


				<aui:input name="dateOpened" label="Date Opened" id="from_date"
					value="${job.getDateOpened()}">
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</clay:col>
			<clay:col md="6">
				<aui:input name="targetDate" label="Target Date" id="to_date"
					value="${job.getTargetDate()}">
					<aui:validator name="required" />


				</aui:input>
			</clay:col>



		</div>
		<div class="row ques">

			<clay:col md="6">
				<aui:input name="jobopeningStatus" label="Job Opening Status"
					value="${job.getJobopeningStatus()}">

				</aui:input>

			</clay:col>
			<clay:col md="6">
				<aui:input name="jobType" label="Job Type"
					value="${job.getJobType()}">

				</aui:input>
			</clay:col>

		</div>

		<div class="row ques">
			<clay:col md="6">
				<aui:input name="workExperience" label="Work Experience"
					value="${job.getWorkExperience()}">

				</aui:input>
			</clay:col>
			<clay:col md="6">
				<aui:input name="skillSet" label="Skill Set"
					value="${job.getSkillSet()}">

				</aui:input>


			</clay:col>
		</div>
		<div class="row ques">

			<clay:col md="6">
				<aui:input name="industry" label="Industry"
					value="${job.getIndustry()}">


				</aui:input>
			</clay:col>
			<clay:col md="6">
				<aui:input name="projectStatus" label="Project Status"
					value="${job.getProjectStatus()}">

				</aui:input>


			</clay:col>


		</div>
	</aui:fieldset>
	<aui:fieldset label="Address Information" style="font-weight: bold"
		markupView="lexicon">
		<%-- <aui:input name="remote" type="radio" value="0" label="Remote">

</aui:input> --%>

		<div class="row ques">
			<clay:col md="6">

				<aui:input name="city" label="City" value="<%=addinfo.getCity()%>">
					<aui:validator name="required"></aui:validator>

				</aui:input>
			</clay:col>
			<clay:col md="6">
				<aui:input name="state" label="State"
					value="<%=addinfo.getState()%>">
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</clay:col>
		</div>
		<div class="row ques">
			<clay:col md="6">
				<aui:select id="" name="country" onChange="" label="Country"
					value="<%=addinfo.getCountry()%>">
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
				<aui:input name="postalCode" label="Postal Code"
					value="<%=addinfo.getPostalCode()%>">
					<aui:validator name="required"></aui:validator>
				</aui:input>
			</clay:col>
		</div>
	</aui:fieldset>
	<aui:fieldset label="Description Information" style="font-weight: bold"
		markupView="lexicon">
		<h5>Job Description</h5>
		<aui:input name="" value="<%=desinfo.getJobDescription()%>"
			type="textarea"></aui:input>
		<h5>Requirements</h5>
		<aui:input name="" value="<%=desinfo.getRequirements()%>"
			type="textarea"></aui:input>
		<h5>Benefits</h5>
		<aui:input name="" value="<%=desinfo.getBenefits()%>" type="textarea"></aui:input>

	</aui:fieldset>
	<aui:fieldset label="Attachment Information" style="font-weight: bold"
		markupView="lexicon">
		<div class="row ques">
			<clay:col>
				<%
					StringBuilder documentURLs = new StringBuilder();

								DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(job.getSummaryId());
								documentURLs
										.append(PortalUtil.getPortalURL(request) + "/documents/" + dlFileEntry.getFileEntryId()
												+ "/" + dlFileEntry.getFolderId() + "/" + dlFileEntry.getTitle());
				%>

				<aui:input label="<%=dlFileEntry.getFileName()%>" name="jobSummary"
					value="<%=dlFileEntry.getFileName()%>" type="file" />
				<a href="#" onclick="return popitup('<%=documentURLs.toString()%>')">
					<%=dlFileEntry.getTitle()%></a>


			</clay:col>


			<clay:col>
				<%
					DLFileEntry fileEntry1 = DLFileEntryLocalServiceUtil.getFileEntry(job.getOtherId());
								String urll = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
										+ themeDisplay.getScopeGroupId() + StringPool.SLASH + fileEntry1.getUuid();
				%>
				<aui:input label="<%=fileEntry1.getFileName()%>" name="others"
					value="<%=fileEntry1.getFileName()%>" selected="<%=fileEntry1.getFileName()%>"  type="file" />
				<a href="#" onclick="return popitup1('<%=urll%>')"> <%=fileEntry1.getTitle()%></a>
			</clay:col>
		</div>
	</aui:fieldset>

	<div class="button-holder">
		<aui:button value="Save" type="submit" />
	</div>

</aui:form>
<script type="text/javascript">
	function popitup(documentURLs) {
		newwindow = window.open(documentURLs, 'name', 'height=500,width=900');
		if (window.focus) {
			newwindow.focus()
		}
		return false;

	}

	function popitup1(urll) {
		newwindow = window.open(urll, 'name', 'height=500,width=900');
		if (window.focus) {
			newwindow.focus()
		}
		return false;
	}
</script>