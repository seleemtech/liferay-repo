<%@ include file="/META-INF/resources/init.jsp" %>

<%
    TaskListDisplayContext taskListDisplayContext = (TaskListDisplayContext) request.getAttribute("taskDisplayContext");
    long projectId = ParamUtil.getLong(renderRequest, "projectId");
%>


<h2>Task</h2>

<frontend-data-set:headless-display
        apiURL="<%= taskListDisplayContext.getAPIURL(projectId) %>"
        creationMenu="<%= taskListDisplayContext.getCreationMenu() %>"
        fdsActionDropdownItems="<%= taskListDisplayContext.getFDSActionDropdownItems() %>"
        formName="fm"
        id="<%= ProjectConstant.TASK_TABLE %>"
        style="fluid"
/>

<div id="<portlet:namespace />addTask">
    <react:component
            module="js/components/ModalAddTask.es"
            props='<%=
		HashMapBuilder.<String, Object>put(
			"apiUrl", taskListDisplayContext.postAPIURL()
		).put(
				"projectId", projectId
		).build()
	%>'
    />
</div>
