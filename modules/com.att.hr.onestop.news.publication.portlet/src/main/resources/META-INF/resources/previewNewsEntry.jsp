<%@ include file="init.jsp" %>
<%
long newsEntryId = ParamUtil.getLong(renderRequest, "newsEntryId");
NewsEntry newsEntry = NewsEntryLocalServiceUtil.getNewsEntry(newsEntryId);
%>

<div class="row">
<div class="col-md-6">
<strong>News Title:</strong>
</div>
<div class="col-md-6">
<%=newsEntry.getNewsTitle() %>
</div>
</div>
<div class="row">
<div class="col-md-6">
<strong>News Sumamry:</strong>
</div>
<div class="col-md-6">
<%=newsEntry.getNewsSummary() %>
</div>
</div>
<div class="row">
<div class="col-md-6">
<strong> News Content:</strong>
</div>
<div class="col-md-6">
<%=newsEntry.getNewsContent() %>
</div>
</div>