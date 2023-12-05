<%@ include file="/META-INF/resources/init.jsp" %>
<%
    ProjectListDisplayContext projectListDisplayContextddd = (ProjectListDisplayContext) request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
    long projectId = ParamUtil.getLong(renderRequest, "projectId");
    Projects project = ProjectsLocalServiceUtil.getProject(projectId);
%>

<liferay-portlet:actionURL var="addResourcesURL" name="project/addResources">
</liferay-portlet:actionURL>
<h2>Add Resources to <%=project.getProjectName()%></h2>
<aui:form action="<%=addResourcesURL.toString()%>" method="post"
          name="fm">
    <aui:input name="userIds" type="hidden"/>
    <aui:input name="projectId" type="hidden" value="<%=projectId%>"/>
    <liferay-ui:search-container total='<%=projectListDisplayContextddd.getResourcesList(projectId).size()%>'
                                 rowChecker='<%= new EmptyOnClickRowChecker(renderResponse)%>' var="searchContainer" delta="100" deltaConfigurable="true">
        <liferay-ui:search-container-results
                results="<%=ListUtil.subList(projectListDisplayContextddd.getResourcesList(projectId), searchContainer.getStart(), searchContainer.getEnd())%>"/>
        <liferay-ui:search-container-row
                className="com.liferay.portal.kernel.model.User"
                keyProperty="userId"
                modelVar="user9"
                rowIdProperty="userId"
        >
            <%@ include file="/project/user_search_columns.jspf" %>
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator/>
    </liferay-ui:search-container>
</aui:form>
<aui:a cssClass="btn btn-primary"
       href='<%="javascript:" + renderResponse.getNamespace() + "addResources();"%>'
       label="Save" title="Save"></aui:a>
<aui:script use="aui-base,liferay-util-window,liferay-portlet-url">
    Liferay
        .provide(
            window,
            '<portlet:namespace />addResources',
            function () {
                var userIds = Liferay.Util.listCheckedExcept(
                    <portlet:namespace />fm,
                    '<portlet:namespace />allRowIds');
                if (userIds == "" || userIds == null) {
                    alert("Please select atleast one record.");
                    return;
                }
                A.one('#<portlet:namespace />userIds').val(
    userIds);
                    if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-add-the-selected-entries") %>')) {

                        submitForm(document.<portlet:namespace />fm);
                    }
            });
</aui:script>