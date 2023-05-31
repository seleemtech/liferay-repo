<%@page import="com.prime.data.service.service.SourceByLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.SourceBy"%>
<%@page import="com.prime.data.service.service.HighQualHeldLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.HighQualHeld"%>
<%@page import="com.prime.data.service.service.CurrJobTitleLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.CurrJobTitle"%>
<%@page import="com.candidate.service.service.ProfessionalDetailsLocalServiceUtil"%>
<%@page import="com.candidate.service.model.ProfessionalDetails"%>
<%@page import="com.candidate.web.constants.CandidateStageConstant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.prime.data.service.service.CandidateStatusLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.CandidateStatus"%>
<%@page
	import="com.prime.data.service.service.CandidateStatusLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.CandidateStatus"%>
<%@page
	import="com.candidate.service.service.CandidateOtherInfoLocalServiceUtil"%>
<%@page import="com.candidate.service.model.CandidateOtherInfo"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page
	import="com.candidate.service.service.CandidateInfoLocalServiceUtil"%>
<%@page import="com.candidate.service.model.CandidateInfo"%>
<%@page import="java.util.List"%>
<%@ include file="./init.jsp"%>

<%
	List<CandidateInfo> candidateInfoList = CandidateInfoLocalServiceUtil.getCandidateInfos(-1, -1);
%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/candidate-list.jsp" />
</liferay-portlet:renderURL>


<div class="row">
	<div style="float: left;">
	
	<div>
  <input type="text" id="labelSearchBar" placeholder="Search Labels">
</div>

 <div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkCandidateStage" />
    Candidate Stage
  </label>
</div>
<div class="flex-row">
 <select id="dropCandidateStage" style="display:none" class="filter-dropdown" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <select name="candidateStage" class="filter-input" id="filterCandidateStage"
					label="Candidate Status" style="display: none;">
					<option value="">Select Stage</option>
					<%
					List<String> candidateStage=new ArrayList<>();
					candidateStage.add(CandidateStageConstant.AVAILABLESTAGE);
					candidateStage.add(CandidateStageConstant.NEWSTAGE);
					candidateStage.add(CandidateStageConstant.ENGAGEDSTAGE);
					candidateStage.add(CandidateStageConstant.HIREDSTAGE);
					candidateStage.add(CandidateStageConstant.INREVIEWSTAGE);
					candidateStage.add(CandidateStageConstant.OFFEREDSTAGE);
					candidateStage.add(CandidateStageConstant.REJECTEDSTAGE);
						
						for (String candidateStageItem : candidateStage) {
					%>
					<option value="<%=candidateStageItem%>"><%=candidateStageItem%></option>
					<%
						}
					%>
				</select>
  
</div>







<div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkLastName" />
    Last Name
  </label>
</div>
<div class="flex-row">
 <select id="dropLastName" style="display:none" class="filter-dropdown" data-columnClass="firstName">
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterLastName" class="filter-input" placeholder="Enter Last Name" style="display: none;">
</div>

<div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkCandidateStatus" />
    Candidate Status
  </label>
</div>
<div class="flex-row">
 <select id="dropCandidateStatus" style="display:none" class="filter-dropdown" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <select name="candidateStatus" class="filter-input" id="filterCandidateStatus"
					label="Candidate Status" style="display: none;">
					<option value="">Select Status</option>
					<%
						List<CandidateStatus> candidateStatus = CandidateStatusLocalServiceUtil.getCandidateStatuses(-1, -1);
						for (CandidateStatus candidateStatusItem : candidateStatus) {
					%>
					<option value="<%=candidateStatusItem.getCandidateStatus()%>"><%=candidateStatusItem.getCandidateStatus()%></option>
					<%
						}
					%>
				</select>
  
</div>




<div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkEmail" />
    Email
  </label>
</div>
<div class="flex-row">
 <select id="dropEmail" style="display:none" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterEmail" class="filter-input" placeholder="Enter Email" style="display: none;">
</div>


<div> 
  <label class="checkbox-label">
    <input type="checkbox"  id="checkCandidateId" />
    Candidate ID
  </label> 
</div>
<div class="flex-row">
  <select id="dropCandidateId" style="display:none" class="filter-dropdown" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option> 
  </select>
  <input type="text" id="filterCandidateId" class="filter-input" placeholder="Enter First Name" style="display: none;">
</div>
	  
	  
	  <div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkSkill" />
    Skill Set
  </label>
</div>
<div class="flex-row">
 <select id="dropSkill" style="display:none" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterSkill" class="filter-input" placeholder="Enter Skill" style="display: none;">
</div>
	  
	<div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkSecEmail" />
    Secondary Email
  </label>
</div>
<div class="flex-row">
 <select id="dropSecEmail" style="display:none" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterSecEmail" class="filter-input" placeholder="Enter Email" style="display: none;">
</div>
	  
	  	<div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkAdditionalInfo" />
    Additional Info
  </label>
</div>
<div class="flex-row">
 <select id="dropAdditionalInfo" style="display:none" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterAdditionalInfo" class="filter-input" placeholder="Enter Info" style="display: none;">
</div>

  	<div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkCandidateOwner" />
    Candidate Owner
  </label>
</div>
<div class="flex-row">
 <select id="dropCandidateOwner" style="display:none" >
    <option value=""></option>
    <option value="is">is</option>
    <option value="is not">is not</option>
  </select>
  <input type="text" id="filterCandidateOwner" class="filter-input" placeholder="Enter Owner" style="display: none;">
</div>
	  
	   	<div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkCity" />
    City
  </label>
</div>
<div class="flex-row">
 <select id="dropCity" style="display:none" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterCity" class="filter-input" placeholder="Enter City" style="display: none;">
</div>


  	<div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkCountry" />
    Country
  </label>
</div>
<div class="flex-row">
 <select id="dropCountry" style="display:none" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterCountry" class="filter-input" placeholder="Enter Country" style="display: none;">
</div> 


  	<div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkCurrentEmployer" />
    Current Employer
  </label>
</div>
<div class="flex-row">
 <select id="dropCurrentEmployer" style="display:none" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterCurrentEmployer" class="filter-input" placeholder="Enter Country" style="display: none;">
</div> 
	  
	  
	  <div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkCandidateJobTitle" />
    Current Job Title
  </label>
</div>
<div class="flex-row">
 <select id="dropCandidateJobTitle" style="display:none" class="filter-dropdown" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <select  class="filter-input" id="filterCandidateJobTitle"
					label="Current Job Title" style="display: none;">
					<option value="">Select Status</option>
					<%
							List<CurrJobTitle> currJobTitles = CurrJobTitleLocalServiceUtil.getCurrJobTitles(-1, -1);
											for (CurrJobTitle currJobTitlesItem : currJobTitles) {
						%>
						<aui:option value="<%=currJobTitlesItem.getCurrJobTitleId()%>"><%=currJobTitlesItem.getCurrentJobTitle()%></aui:option>

						<%
							}
						%>
				</select>
  
</div>
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	<div> 
  <label class="checkbox-label">
    <input type="checkbox" name="filterName" id="checkFirstName" />
    First Name
  </label> 
</div>
<div class="flex-row">
  <select id="dropFirstName" style="display:none" class="filter-dropdown" data-columnClass="firstName">
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterFirstName" class="filter-input" placeholder="Enter First Name" style="display: none;">
</div>
	
	
		  <div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkQualification" />
    Highest Qualification Held
  </label>
</div>
<div class="flex-row">
 <select id="dropQualification" style="display:none" class="filter-dropdown" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <select  class="filter-input" id="filterQualification"
					label="Current Job Title" style="display: none;">
					<option value="">Select Status</option>
					<%
							List<HighQualHeld> highQualHelds = HighQualHeldLocalServiceUtil.getHighQualHelds(-1, -1);
											for (HighQualHeld highQualHeldsItem : highQualHelds) {
						%>
						<aui:option value="<%=highQualHeldsItem.getHighQualHeld()%>"><%=highQualHeldsItem.getHighQualHeld()%></aui:option>

						<%
							}
						%>
				</select>
  
</div>
	  
		  
	<div> 
  <label class="checkbox-label">
    <input type="checkbox"  id="checkMobile" />
    Mobile
  </label> 
</div>
<div class="flex-row">
  <select id="dropMobile" style="display:none" class="filter-dropdown" data-columnClass="firstName">
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterMobile" class="filter-input" placeholder="Enter mobile Number" style="display: none;">
</div>
	
			  <div>
  <label class="checkbox-label">
    <input type="checkbox" id="checkSource" />
    Source
  </label>
</div>
<div class="flex-row">
 <select id="dropSource" style="display:none" class="filter-dropdown" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <select  class="filter-input" id="filterSource"
					label="Current Job Title" style="display: none;">
					<option value="">Select Status</option>
						<%
							List<SourceBy> sourceBies = SourceByLocalServiceUtil.getSourceBies(-1, -1);
											for (SourceBy sourceBiesItem : sourceBies) {
						%>
						<aui:option value="<%=sourceBiesItem.getSourceBy()%>"><%=sourceBiesItem.getSourceBy()%></aui:option>

						<%
							}
						%>
				</select>
  
</div>

	<div> 
  <label class="checkbox-label">
    <input type="checkbox"  id="checkState" />
    State/Province
  </label> 
</div>
<div class="flex-row">
  <select id="dropState" style="display:none" class="filter-dropdown" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterState" class="filter-input" placeholder="Enter State" style="display: none;">
</div>
	
		<div> 
  <label class="checkbox-label">
    <input type="checkbox"  id="checkStreet" />
     Street
  </label> 
</div>
<div class="flex-row">
  <select id="dropStreet" style="display:none" class="filter-dropdown" data-columnClass="firstName">
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterStreet" class="filter-input" placeholder="Enter street" style="display: none;">
</div>
	
	
		<div> 
  <label class="checkbox-label">
    <input type="checkbox"  id="checkWebsite" />
     Website
  </label> 
</div>
<div class="flex-row">
  <select id="dropWebSite" style="display:none" class="filter-dropdown" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterWebsite" class="filter-input" placeholder="Enter Website" style="display: none;">
</div>
	
	
		<div> 
  <label class="checkbox-label">
    <input type="checkbox"  id="checkZipCode" />
    Zip/Postal Code
  </label> 
</div>
<div class="flex-row">
  <select id="dropZipCode" style="display:none" class="filter-dropdown" >
    <option value=""></option>
    <option value="contains">contains</option>
    <option value="doesn't contains">doesn't contain</option>
    <option value="is">is</option>
    <option value="is not">is not</option>
    <option value="starts with">starts with</option> 
    <option value="ends with">ends with</option> 
    <option value="is empty">is empty</option>
    <option value="is not empty">is not empty</option>
  </select>
  <input type="text" id="filterZipCode" class="filter-input" placeholder="Enter ZipCode" style="display: none;">
</div>
	
	  
	
	
	
	
	
		
		<div style="gap: 1rem; display:none;" id="FilterButtonID">
  <button type="submit" id="applyFilterBtn">Apply Filter</button>
  <button type="button" id="clearFilterBtn">Clear Filter</button>
</div>


	</div>
	<div class="ui-content" style="width: 84%">

		<%
			Map<String, String> candidateStatusMap = new HashMap<>();
			List<CandidateStatus> candidateStatusList = CandidateStatusLocalServiceUtil.getCandidateStatuses(-1, -1);

			for (CandidateStatus candidateStatusItem : candidateStatusList) {
				String status = candidateStatusItem.getCandidateStatus().toLowerCase();
				candidateStatusMap.put(status, candidateStatusItem.getCandidateStatus());
			}

			String inReview = candidateStatusMap.get("in-review");
			String newStatus = candidateStatusMap.get("new");
			String available = candidateStatusMap.get("available");
			String engaged = candidateStatusMap.get("engaged");
			String hired = candidateStatusMap.get("hired");
			String offered = candidateStatusMap.get("offered");
			String rejected = candidateStatusMap.get("rejected");
		%>
		<div class="stage-main">
			<p class="stage-info">Candidate Stages</p>
			<div class="stage-parent">
				<div class="stage-column cand-stage-new"
					style="border-left: 1px solid #e5e5e5 !important;">
					<a class="stage-status"
						data-value="<%=Validator.isNotNull(newStatus) ? newStatus : ""%>"><p><%=CandidateOtherInfoLocalServiceUtil.getCandidateStatusCount("new")%></p>
						<span>New</span></a>
				</div>
				<div class="stage-column cand-stage-inreview">
					<a class="stage-status"
						data-value="<%=Validator.isNotNull(inReview) ? inReview : ""%>"><p><%=CandidateOtherInfoLocalServiceUtil.getCandidateStatusCount("in-review")%>
						</p> <span>In Review</span></a>
				</div>
				<div class="stage-column cand-stage-available">
					<a class="stage-status"
						data-value="<%=Validator.isNotNull(available) ? available : ""%>"><p><%=CandidateOtherInfoLocalServiceUtil.getCandidateStatusCount("available")%>
						</p> <span>Available</span></a>
				</div>
				<div class="stage-column cand-stage-engaged">
					<a class="stage-status"
						data-value="<%=Validator.isNotNull(engaged) ? engaged : ""%>"><p>
							<%=CandidateOtherInfoLocalServiceUtil.getCandidateStatusCount("engaged")%></p>
						<span>Engaged</span></a>
				</div>
				<div class="stage-column cand-stage-hired">
					<a class="stage-status"
						data-value="<%=Validator.isNotNull(hired) ? hired : ""%>"><p>
							<%=CandidateOtherInfoLocalServiceUtil.getCandidateStatusCount("hired")%>
						</p> <span>Hired</span></a>
				</div>
				<div class="stage-column cand-stage-offered">
					<a class="stage-status"
						data-value="<%=Validator.isNotNull(offered) ? offered : ""%>"><p>
							<%=CandidateOtherInfoLocalServiceUtil.getCandidateStatusCount("offered")%>
						</p> <span>Offered</span></a>
				</div>
				<div class="stage-column cand-stage-rejected"
					style="border-right: 1px solid #e5e5e5 !important;">
					<a class="stage-status"
						data-value="<%=Validator.isNotNull(rejected) ? rejected : ""%>"><p>
							<%=CandidateOtherInfoLocalServiceUtil.getCandidateStatusCount("rejected")%>
						</p> <span>Rejected</span></a>
				</div>
			</div>
		</div>


		<div class="tableContainer">

			<table class="table myTable table-bordered table-hover"
				id="candidateTable">
				<thead>
					<tr class="dnd-moved table-row">
					<th style="width:41px"><span class="add-column showHeaderBtn" data-hover="Add Column">
  <img src="<%=request.getContextPath() %>/img/table-plus.png" alt="Add Column" />
</span>  	<div class="columnEdit">
<div class="search-div" ><input type="text" id="setupsearch" placeholder="Search "></div>
<div class="columnEdit-content">
				<label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Candidate ID" checked disabled> Candidate ID
				</label> <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Candidate Name" checked disabled> Candidate
					Name
				</label> <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Last Name" checked disabled> Last Name
				</label> <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Candidate Stage" checked disabled> Candidate
					Stage
				</label> <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Status"> Status
				</label>
				</label>
				 <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox" data-column="Email"> Email</label>				
				<label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox" data-column="Skill Set"> Skill Set</label>	
				<label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox" data-column="Secondary Email"> Secondary Email</label>
				<label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox" data-column="Additional Info"> Additional Info</label>
				<label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Candidate owner"> Candidate owner
				</label>
				
				 <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="City"> City
				</label> 
				 <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Country"> Country
				</label> 
				 <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Current Employer"> Current Employer
				</label> 
				 <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Current Job Title"> Current Job Title
				</label> 
				 <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Highest Qualification Held"> Highest Qualification Held
				</label> 
				 <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Mobile"> Mobile
				</label> 
				
				
				<label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox"
					data-column="Source"> Source
				</label>  <label> <input type="checkbox" class="header-checkbox"
					data-column="Actions"> Actions
				</label>
				 <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox" data-column="State"> State/Province</label>
				  <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox" data-column="Street"> Street</label>
				   <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox" data-column="Website"> Website</label>
				    <label class="toggle-checkbox"> <input type="checkbox" class="header-checkbox" data-column="ZipCode"> Zip/Postal Code</label>
				
				</div>
				<div class="columnListBtn" ><button class="cancelBtn closeColumnsBtn">Cancel</button><button class="saveBtn toggleColumnsBtn" >Save</button></div>
			</div></th>
						<th class="headerColumn">Candidate ID</th>
						<th class="headerColumn">Candidate Name</th>
						<th class="headerColumn">Last Name</th>
						<th class="headerColumn"> Candidate Stage</th>
						<th class="table-column-none headerColumn">Status</th>
						<th class="table-column-none headerColumn">Email</th>
						
						<th class="table-column-none headerColumn" >Skill Set</th>
						<th class="table-column-none headerColumn">Secondary Email</th>
						<th class="table-column-none headerColumn">Additional Info</th>
						<th class="table-column-none">Candidate owner</th>
						<th class="table-column-none">City</th>
						<th class="table-column-none">Country</th>
						<th class="table-column-none">Current Employer</th>
						<th class="table-column-none">Current Job Title</th>
						<th class="table-column-none">Highest Qualification Held</th>
						<th class="table-column-none">Mobile</th>
						
						<th class="table-column-none">Source</th>
						<th class="table-column-none">State</th>
						<th class="table-column-none">Street</th>
						<th class="table-column-none">Website</th>
						<th class="table-column-none">ZipCode</th>
						<th class="table-column-none">Actions</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (CandidateInfo candid : candidateInfoList) {

							CandidateOtherInfo candidateOtherInfos = CandidateOtherInfoLocalServiceUtil
									.getByCandidtatesId(candid.getCandidateId());
							ProfessionalDetails professionalDetails=ProfessionalDetailsLocalServiceUtil.getByCandidateId(candid.getCandidateId());
					%>
					<tr class="dnd-moved table-row">
					
						<portlet:renderURL var="updateCandidateURL">
								<portlet:param name="mvcPath" value="/update-candidate.jsp" />
								<portlet:param name="candidateId"
									value="<%=String.valueOf(candid.getCandidateId())%>" />
							</portlet:renderURL> 
				 <td> <a href="${updateCandidateURL}" class="icon-link"><i  class="fa">&#xf040;</i></a></td>
						<liferay-portlet:renderURL varImpl="viewCandidateURL">
							<portlet:param name="mvcPath" value="/candidate-det-view.jsp" />
							<portlet:param name="candidateID"
								value="<%=String.valueOf(candid.getCandidateId())%>"></portlet:param>
						</liferay-portlet:renderURL>
						
					
						<td class="candidateId"><a href="${viewCandidateURL}"><%=candid.getCandidateId()%></a></td>
						<td class="firstName"><%=candid.getFirstName()%></td>
						<td class="lastName"><%=candid.getLastName()%></td>
						<td class="candidateStage"><%=candidateOtherInfos.getCandidateStage()%></td>
						<td class="candidateStatus table-column-none"><span
							class="badge badge-success badge-pill"> <span
								class="badge-item badge-item-expand"> <%=candidateOtherInfos.getCandidateStatus()%></span>
						</span></td>
						<td class="candidateEmail table-column-none"><%=candid.getEmail()%></td>
						<td class="candidateSkill table-column-none"><%=professionalDetails.getSkillSet()%></td>
						<td class="candidateSecEmail table-column-none"><%=candid.getSecondaryEmail()%></td>
						<td class="candidateAdditionalInfo table-column-none"><%=professionalDetails.getAdditionalInfo()%></td>
						<td class="candidateOwner table-column-none"><%=candidateOtherInfos.getCandidateOwner()%></td>
						<td class="city table-column-none"><%=candid.getCity()%></td>
						<td class="country table-column-none"><%=candid.getCountry()%></td>
						<td class="currentEmployer table-column-none"><%=professionalDetails.getCurrentEmployer()%></td>
						<td class="currentJobTitle table-column-none"><%=professionalDetails.getJobTitle()%></td>
						<td class="highQualification table-column-none"><%=professionalDetails.getQualification()%></td>
						<td class="mobile table-column-none"><%=candid.getMobileNumber()%></td>
						
						<td class="source table-column-none"><%=candidateOtherInfos.getSource()%></td>
						<td class="State table-column-none"><%=candid.getState()%></td>
						<td class="Street table-column-none"><%=candid.getStreet()%></td>
						<td class="website table-column-none"><%=candid.getWebsite()%></td>
						<td class="zipCode table-column-none"><%=candid.getZipCode()%></td>
						<td class="table-column-none"><portlet:actionURL
								name="/DeleteCandidate" var="deleteCandidateURL">
								<portlet:param name="candidateId"
									value="<%=String.valueOf(candid.getCandidateId())%>" />
							</portlet:actionURL> <portlet:renderURL var="updateStatusURL">
								<portlet:param name="mvcPath" value="/updateCandidateStatus.jsp" />
								<portlet:param name="candidateId" value="<%=String.valueOf(candid.getCandidateId())%>" />
								</portlet:renderURL>
							 <liferay-ui:icon-menu>
								<liferay-ui:icon message="Delete" url="<%=deleteCandidateURL%>" />
								<liferay-ui:icon message="UpdateStatus"
									url="<%=updateStatusURL%>" />
							</liferay-ui:icon-menu></td>

					</tr>

					<%
						}
					%>
				</tbody>
			</table>
		</div>


	</div>
</div>
 <style>

</style>
<script>
	$('.table').dragableColumns({
		drag : true,
		dragClass : 'drag',
		overClass : 'over',
		movedContainerSelector : '.dnd-moved'
	});
</script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/table-column-toggle/table.column.toggle.js?v=126"></script> 
<script type="text/javascript" src="<%= request.getContextPath() %>/js/filters/8.dropdown.filters.js?v=28">
</script> 
 
