<%@page import="com.candidate.service.service.CandidateOtherInfoLocalServiceUtil"%>
<%@page import="com.candidate.service.model.CandidateOtherInfo"%>
<%@page import="com.candidate.service.service.CandidateInfoLocalServiceUtil"%>
<%@page import="com.candidate.service.model.CandidateInfo"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%
String candidateId = request.getParameter("candidateID");
CandidateInfo candidateInfos = CandidateInfoLocalServiceUtil.getCandidateInfo(Long.valueOf(candidateId));
out.println(candidateId);
CandidateOtherInfo candidateOtherInfo = CandidateOtherInfoLocalServiceUtil.getByCandidtatesId(Long.valueOf(candidateId));
%>
<h3>Candidate information</h3>
<div class="row">
<div class="col-md-6">
<aui:input name="firstName" value="<%= candidateInfos.getFirstName()%>" label="First Name"/>
<aui:input name="lastName" value="<%= candidateInfos.getLastName()%>" label="Last Name"/>
<aui:input name="email" value="<%= candidateInfos.getEmail()%>" label="Email"/>
<aui:input name="secondaryEmail" value="<%= candidateInfos.getSecondaryEmail()%>" label="Secondary email"/>
<aui:input name="mobileNumber" value="<%= candidateInfos.getMobileNumber()%>" label="Mobile Number"/>
</div>
<div class="col-md-6">
<aui:input name="city" value="<%= candidateInfos.getCity()%>" label="City"/>
<aui:input name="state" value="<%= candidateInfos.getState()%>" label="State"/>
<aui:input name="zipCode" value="<%= candidateInfos.getZipCode()%>" label="Zip Code"/>
<aui:input name="houseNumber" value="<%= candidateInfos.getHouseNumber()%>" label="House number"/>
<aui:input name="webSite" value="<%= candidateInfos.getWebsite()%>" label="Website"/>
</div>
</div>
<h3>Additional information</h3>
<div class="row">
<div class="col-md-6">
<aui:input name="status" value="<%= candidateOtherInfo.getCandidateStatus()%>" label="Status"/>
<aui:input name="lastName" value="<%= candidateOtherInfo.getSource()%>" label="Source"/>
<aui:input name="candidateOwner" value="<%= candidateOtherInfo.getCandidateOwner()%>" label="Candidate Owner"/>
<aui:input name="institute" value="<%= candidateOtherInfo.getInstitute()%>" label="Institute"/>
<aui:input name="department" value="<%= candidateOtherInfo.getDepartment()%>" label="Department"/>
</div>
<div class="col-md-6">
<aui:input name="degree" value="<%= candidateOtherInfo.getDegree()%>" label="Degree"/>
<aui:input name="FromDuration" value="<%= candidateOtherInfo.getFromDuration()%>" label="From Duration"/>
<aui:input name="ToDuration" value="<%= candidateOtherInfo.getToDuration()%>" label="To Duration"/>
<aui:input name="occupation" value="<%= candidateOtherInfo.getOccupation()%>" label="Occupation"/>
<aui:input name="company" value="<%= candidateOtherInfo.getCompany()%>" label="Company"/>
<aui:input name="summary" value="<%= candidateOtherInfo.getSummary()%>" label="Summary"/>
<aui:input name="FromworkDuration" value="<%= candidateOtherInfo.getFromWorkDuration()%>" label="From Work duration"/>
<aui:input name="ToworkDuration" value="<%= candidateOtherInfo.getToWorkDuration()%>" label="To Work duration"/>
</div>
</div>