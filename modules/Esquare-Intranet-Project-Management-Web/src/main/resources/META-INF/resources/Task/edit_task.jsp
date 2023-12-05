<%@ include file="/META-INF/resources/init.jsp" %>

<%
    TaskListDisplayContext taskListDisplayContext = (TaskListDisplayContext) request.getAttribute("taskDisplayContext");
    long taskId = ParamUtil.getLong(renderRequest, "taskId");
    Tasks task = TasksLocalServiceUtil.fetchTasks(taskId);
    Projects projects = ProjectsLocalServiceUtil.fetchProjects(task.getProjectId());
%>

<react:component
        module="js/components/EditTask.es"
        props='<%=
		HashMapBuilder.<String, Object>put(
			"apiUrl", taskListDisplayContext.updateAPIURL()
		).put("taskName" ,task.getName())
		 .put("taskDesc" , task.getDescription())
		 .put("projectCode", projects.getCode())
		 .put("projectDeveloperList",taskListDisplayContext.getUserListByRoleName(projects.getProjectId(), ProjectConstant.PROJECT_DEVELOPER_TEAM,taskId))
		 .put("projectTesterList",taskListDisplayContext.getUserListByRoleName(projects.getProjectId(), ProjectConstant.PROJECT_TESTER_TEAM,taskId))
		 .put("taskId",taskId)
		 .put("taskStartDate",Validator.isNotNull(task.getTaskStartDate()) ? task.getTaskStartDate() : projects.getDevelopmentStartDate())
		 .put("taskEndDate",Validator.isNotNull(task.getTaskEndDate()) ? task.getTaskEndDate() : projects.getEstimatedDate())
		 .build()
	%>'
/>
