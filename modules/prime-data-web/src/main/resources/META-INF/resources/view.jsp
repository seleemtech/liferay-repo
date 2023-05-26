<%@ include file="/init.jsp" %>
<!-- In create job opening -->

<portlet:renderURL var="jobTypeHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/job-type-home.jsp" />
</portlet:renderURL>
<portlet:renderURL var="jobOpeningStatusURL">
			<portlet:param name="mvcPath" value="/prime-home/job-opening-status-home.jsp" />
</portlet:renderURL>
<portlet:renderURL var="industryHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/industry-home.jsp" />
</portlet:renderURL>
<portlet:renderURL var="salaryRangeHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/salary-range-home.jsp" />
</portlet:renderURL>
<portlet:renderURL var="workExperienceHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/work-experience-home.jsp" />
</portlet:renderURL>
<portlet:renderURL var="salesStageHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/sales-stage-home.jsp" />
</portlet:renderURL>
<portlet:renderURL var="projectStatusHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/project-status-home.jsp" />
</portlet:renderURL>
<div class="card-container">
<a href="${jobTypeHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add job type</div>
      <div class="card-body">
        <p class="card-text">For ex, Full time, Part time, Permanent, Contract, Freelance</p>
      </div>
    </div>
</a>
<a href="${jobOpeningStatusURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add job opening status</div>
      <div class="card-body">
        <p class="card-text">For ex, In-Progress, Waiting for approval, On-Hold, Cancelled</p>
      </div>
    </div>
</a>
<a href="${industryHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add industry</div>
      <div class="card-body">
        <p class="card-text">For ex, Administration, Advertising, Agriculture, Arts & Graphics</p>
      </div>
    </div>
</a>
<a href="${salaryRangeHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add salary</div>
      <div class="card-body">
        <p class="card-text">For ex, 0-3k, 3-5k, 5-7k, 10k+</p>
      </div>
    </div>
</a>
<a href="${workExperienceHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add work experience</div>
      <div class="card-body">
        <p class="card-text">For ex, Fresher, 0-1 years, 1-3 years, 3+ years</p>
      </div>
    </div>
</a>
<a href="${salesStageHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add sales stage</div>
      <div class="card-body">
        <p class="card-text">For ex, None, Requirements received, Shared profile, Documentation Process</p>
      </div>
    </div>
</a>
<a href="${projectStatusHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add project status</div>
      <div class="card-body">
        <p class="card-text">For ex, New, Existing, Maintenance</p>
      </div>
    </div>
</a>

	<!-- In create candidate -->

<portlet:renderURL var="namePrefixHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/name-prefix-home.jsp" />
		</portlet:renderURL>
<portlet:renderURL var="highQualHeldHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/high-qual-held-home.jsp" />
		</portlet:renderURL>
<portlet:renderURL var="currentJobTitleHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/current-job-title-home.jsp" />
		</portlet:renderURL>				
<portlet:renderURL var="skillSetHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/skill-set-home.jsp" />
		</portlet:renderURL>
<portlet:renderURL var="candidateStatusHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/candidate-status-home.jsp" />
		</portlet:renderURL>
<portlet:renderURL var="sourceByHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/source-by-home.jsp" />
		</portlet:renderURL>
<portlet:renderURL var="priorityHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/priority-home.jsp" />
		</portlet:renderURL>
<portlet:renderURL var="workTypeHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/work-type-home.jsp" />
		</portlet:renderURL>
<a href="${namePrefixHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add name prefix</div>
      <div class="card-body">
        <p class="card-text">For ex, Mr, Ms, Mrs</p>
      </div>
    </div>
</a>
<a href="${highQualHeldHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add highest qualification</div>
      <div class="card-body">
        <p class="card-text">For ex, MCA, BE, MBA, ME, BTECH, BCA</p>
      </div>
    </div>
</a>
<a href="${currentJobTitleHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add current job title</div>
      <div class="card-body">
        <p class="card-text">For ex, Fresher, Project-Lead, Project-Manager</p>
      </div>
    </div>
</a>
<a href="${skillSetHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add skill set</div>
      <div class="card-body">
        <p class="card-text">For ex, For web dev(Java, Python), For Mobile development(iOS, Android)</p>
      </div>
    </div>
</a>
<a href="${candidateStatusHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add candidate status</div>
      <div class="card-body">
        <p class="card-text">For ex, New, Qualified, Unqualified, Junk Candidate, Contacted, Not contacted</p>
      </div>
    </div>
</a>
<a href="${sourceByHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add source</div>
      <div class="card-body">
        <p class="card-text">For ex, Added by user, Advertisement, API, Career Site, Cold Call</p>
      </div>
    </div>
</a>
<a href="${priorityHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add priority</div>
      <div class="card-body">
        <p class="card-text">For ex, None, High, Medium, Low</p>
      </div>
    </div>
</a>
<a href="${workTypeHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add work type</div>
      <div class="card-body">
        <p class="card-text">For ex, WFH, WFO, Hybrid</p>
      </div>
    </div>
</a>

	<!-- In create interview -->
	
<portlet:renderURL var="interviewNameHomeURL">
			<portlet:param name="mvcPath" value="/prime-home/interview-name-home.jsp" />
		</portlet:renderURL>
<a href="${interviewNameHomeURL}" class="my-link">
    <div class="card">
      <div class="card-header">Add interview Name</div>
      <div class="card-body">
        <p class="card-text">For ex, Internal interview, General interview, Online Interview, Phone interview</p>
      </div>
    </div>
</a>

</div>