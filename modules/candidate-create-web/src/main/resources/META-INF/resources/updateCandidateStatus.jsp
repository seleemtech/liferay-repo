<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.prime.data.service.service.CandidateStatusLocalServiceUtil"%>
<%@page import="com.prime.data.service.model.CandidateStatus"%>
<%@page import="java.util.List"%>
<%@page import="com.candidate.service.service.CandidateOtherInfoLocalServiceUtil"%>
<%@page import="com.candidate.service.model.CandidateOtherInfo"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp"%>

<portlet:actionURL name="/UpdateStatus" var="updateCandidateStatusURL" />
<%
	long candidateId = ParamUtil.getLong(renderRequest, "candidateId");
	CandidateOtherInfo candiOtherInfo=CandidateOtherInfoLocalServiceUtil.getByCandidtatesId(candidateId);
	String Status=Validator.isNotNull(candiOtherInfo)?candiOtherInfo.getCandidateStatus():"";
%>
<div class="login-container">
	<aui:form action="${updateCandidateStatusURL}" name="createCandidate"
		method="POST" enctype="multipart/form-data">
		<aui:fieldset label="Update Candidate Status"
			style="font-weight: bold;" markupView="lexicon">
			<div class="row ques">
				<clay:col md="6">
					<aui:input name="candidateId" value="<%=candidateId%>" type="hidden">
					</aui:input>
					<aui:select name="candidateStatus"  label="Candidate Status" id="status">
					<aui:option>Select Status</aui:option>
					<% List<CandidateStatus> candidateStatus = CandidateStatusLocalServiceUtil.getCandidateStatuses(-1, -1);
											for (CandidateStatus candidateStatusItem : candidateStatus) {
						%>
						<aui:option value="<%=candidateStatusItem.getCandidateStatus()%>"><%=candidateStatusItem.getCandidateStatus()%></aui:option>

						<%
							}
						%>
						
					</aui:select>
				</clay:col>
			</div>
		</aui:fieldset>
		<div class="button-holder">
			<aui:button value="Update" type="submit" />
		</div>
	</aui:form>

</div>

<script type="text/javascript">
$(document).ready(function() {
	var SelectedSataus='<%=Status%>';
	$("#<portlet:namespace />status").val(SelectedSataus);
});
</script>
