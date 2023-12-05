<%@ include file="/META-INF/resources/init.jsp" %>
<%
    ProjectListDisplayContext projectListDisplayContextdd = (ProjectListDisplayContext) request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
    long projectIds = ParamUtil.getLong(renderRequest, "projectId");
    Projects projects =ProjectsLocalServiceUtil.getProject(projectIds);
%>
<h2><%=projects.getProjectName()%> Resources</h2>

<aui:form action="" method="post"
          name="fm">
    <aui:input name="memberIds" type="hidden"/>
    <aui:input name="projectId" type="hidden" value="<%=projectIds%>"/>
    <liferay-ui:search-container emptyResultsMessage="there-are-no-resources"
            total="<%=projectListDisplayContextdd.memberList(projectIds).size() %>"
           >
        <liferay-ui:search-container-results
                results="<%=ListUtil.subList( projectListDisplayContextdd.memberList(projectIds), searchContainer.getStart(), searchContainer.getEnd())%>"/>

        <liferay-ui:search-container-row
                className="com.esquare.intranet.project.management.model.TeamMembers"
                keyProperty="memberId"
                modelVar="member"
                rowIdProperty="memberId"
        >
            <%@ include file="/project/member_search_columns.jspf" %>
            <liferay-ui:search-container-column-jsp
                    cssClass="last-action-td"
                    path="/project/resource_actions.jsp"
            />
        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator/>
    </liferay-ui:search-container>
</aui:form>

<style>
    .last-action-td {
        width: 1%;
    }
</style>