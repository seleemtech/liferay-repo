<%@ include file="/init.jsp" %>
<portlet:actionURL  name="addInterview" var="addinterviewURL"/>
<aui:form action="<%= addinterviewURL %>" method="post" name="fm" >
<h2>Interview Information</h2>
<div class="row">
<div class="col-md-6">
<aui:select name="interviewName" label="Interview Name">
						<aui:option value="Internal Interview">Internal Interview</aui:option>
						<aui:option value="General Interview">General Interview</aui:option>
						<aui:option value="Online Interview">Online Interview</aui:option>
						<aui:option value="Phone Interview">Phone Interview</aui:option>
						<aui:option value="Level 1 interview">Level 1 interview</aui:option>
						<aui:option value="Level 2 interview">Level 2 interview</aui:option>
</aui:select>
<aui:select name="clientName" label="Client Name">
						<aui:option value="TCS">TCS</aui:option>
						<aui:option value="CTS">CTS</aui:option>
</aui:select>
<aui:input name="fromTime" type="Datetime-local" label=""  prefix="From" />
<aui:input name="interviewers" label="" prefix="Interviewers" />
<aui:select name="location" label="Preferred Location">
	<aui:option value="Bangalore">Bangalore</aui:option>
	<aui:option value="Chennai">Chennai</aui:option>
</aui:select>
</div>
<div class="col-md-6">
<aui:select name="candidateName" label="Candidate Name">
	<aui:option value="Habeeb">Habeeb</aui:option>
	<aui:option value="Habeeb">Vinoth</aui:option>
</aui:select>
<aui:select name="postingTitle" label="Posting Title">
						<aui:option value="React">React dev</aui:option>
						<aui:option value="Liferay">Liferay dev</aui:option>
</aui:select>
<aui:input name="toTime" type="Datetime-local" label=""  prefix="To"/>
<aui:input name="interviewOwner" label="" prefix="Interview Owner" value="<%=user.getDisplayEmailAddress()%>"/>
<aui:input name="scheduleComments" label="Comments" type="textarea" ></aui:input>
</div>
</div>
<h3>Additional Information</h3>
<aui:input type="file" name="documentId" label="" prefix="File Upload"></aui:input>
<aui:button type="reset" value="Cancel"></aui:button>
<aui:button type="submit" value="Create Interview"></aui:button>
</aui:form>