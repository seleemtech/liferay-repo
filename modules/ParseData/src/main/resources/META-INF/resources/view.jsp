<%@ include file="/init.jsp"%>
<portlet:actionURL name="nextPage" var="nextPageURL" />
<aui:form action="<%=nextPageURL %>" method="post" name="fm" id="fm">
    <div class="form-group">
        <label for="file">Import file</label>
        <input type="file" class="form-control" id="file" name="file" />
    </div>
    <aui:button type="submit" value="Upload"class="btn btn-primary"></aui:button>
 
</aui:form>