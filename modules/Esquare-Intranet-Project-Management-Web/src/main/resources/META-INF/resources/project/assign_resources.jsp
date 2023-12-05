<%@ include file="/META-INF/resources/init.jsp" %>
<%
    ProjectListDisplayContext projectListDisplayContextdd = (ProjectListDisplayContext) request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
    long projectId = ParamUtil.getLong(renderRequest, "projectId");
    Projects projects = ProjectsLocalServiceUtil.fetchProjects(projectId);
    UnicodeProperties resourceIdSettings = new UnicodeProperties();
    resourceIdSettings.fastLoad(projects.getResourceIdSettings());
%>
<react:component
        module="js/components/AssignResources.es"
        props='<%=
		HashMapBuilder.<String, Object>put(
			"apiUrl", projectListDisplayContextdd.getAssignResourceAPIURL()
		).put("projectManagerUser",projectListDisplayContextdd.getResourceListByRoleName(projectId, ProjectConstant.PROJECT_MANAGER)
		).put("deliveryLeadUser",projectListDisplayContextdd.getResourceListByRoleName(projectId, ProjectConstant.DELIVERY_LEAD)
		).put("operationLeadUser",projectListDisplayContextdd.getResourceListByRoleName(projectId, ProjectConstant.OPERATION_LEAD)
		).put("projectQALeadUser",projectListDisplayContextdd.getResourceListByRoleName(projectId, ProjectConstant.PROJECT_QA_LEAD)
		).put("projectId",projectId)
		.put("selectedPM",projectListDisplayContextdd.getMemberNameByUserId(resourceIdSettings.get(ProjectConstant.PROJECT_MANAGER_ID)))
		.put("selectedDL",projectListDisplayContextdd.getMemberNameByUserId(resourceIdSettings.get(ProjectConstant.DELIVERY_LEAD_ID)))
		.put("selectedPQL",projectListDisplayContextdd.getMemberNameByUserId(resourceIdSettings.get(ProjectConstant.PROJECT_QA_LEAD_ID)))
		.put("selectedOL",projectListDisplayContextdd.getMemberNameByUserId(resourceIdSettings.get(ProjectConstant.OPERATION_LEAD_ID))
		).build()
	%>'
/>
