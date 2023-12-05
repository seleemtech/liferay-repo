<%@ page import="com.esquare.intranet.helpdesk.web.portlet.workflow.CustomWorkflowConstants" %>
<%@ include file="/META-INF/resources/init.jsp" %>
<%
    ProjectListDisplayContext projectListDisplayContexts = (ProjectListDisplayContext) request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
    long projectId = ParamUtil.getLong(renderRequest, "projectId");
    Projects projects = ProjectsLocalServiceUtil.fetchProjects(projectId);
%>
<react:component
        module="js/components/UpdateProjectStatus.es"
        props='<%=
		HashMapBuilder.<String, Object>put(
			"apiUrl", projectListDisplayContexts.getProjectUpdateStatusAPIURL()
	    ).put("projectId",projectId)
	    .put("statusList",projectListDisplayContexts.getProjectStatus())
	    .put("selectedStatus",CustomWorkflowConstants.getStatusLabel(projects.getStatus()))
	     .build()
	%>'
/>
