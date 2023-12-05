package com.esquare.intranet.project.headless.internal.graphql.query.v1_0;

import com.esquare.intranet.project.headless.dto.v1_0.Project;
import com.esquare.intranet.project.headless.dto.v1_0.Task;
import com.esquare.intranet.project.headless.resource.v1_0.ProjectResource;
import com.esquare.intranet.project.headless.resource.v1_0.TaskResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Mahammed Seleem
 * @generated
 */
@Generated("")
public class Query {

	public static void setProjectResourceComponentServiceObjects(
		ComponentServiceObjects<ProjectResource>
			projectResourceComponentServiceObjects) {

		_projectResourceComponentServiceObjects =
			projectResourceComponentServiceObjects;
	}

	public static void setTaskResourceComponentServiceObjects(
		ComponentServiceObjects<TaskResource>
			taskResourceComponentServiceObjects) {

		_taskResourceComponentServiceObjects =
			taskResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {projectsManagement(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProjectPage projectsManagement(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> new ProjectPage(
				projectResource.getProjectsManagementPage(
					search,
					_filterBiFunction.apply(projectResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(projectResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {projectsManagementProject(projectId: ___){actions, name, description, proposedDate, confirmedDate, developmentStartDate, durationDate, code, id, projectName, status, statusCode, projectManager, deliveryLead, operationLead, projectQaLead, contactNumber, contactEmail, pmId, dlId, olId, qlId}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Project projectsManagementProject(
			@GraphQLName("projectId") Long projectId)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.getProjectsManagementProject(
				projectId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {getTasksProject(projectId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public TaskPage getTasksProject(@GraphQLName("projectId") Long projectId)
		throws Exception {

		return _applyComponentServiceObjects(
			_taskResourceComponentServiceObjects,
			this::_populateResourceContext,
			taskResource -> new TaskPage(
				taskResource.getGetTasksProjectPage(projectId)));
	}

	@GraphQLTypeExtension(Project.class)
	public class GetGetTasksProjectPageTypeExtension {

		public GetGetTasksProjectPageTypeExtension(Project project) {
			_project = project;
		}

		@GraphQLField
		public TaskPage getTasksProject() throws Exception {
			return _applyComponentServiceObjects(
				_taskResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				taskResource -> new TaskPage(
					taskResource.getGetTasksProjectPage(_project.getId())));
		}

		private Project _project;

	}

	@GraphQLTypeExtension(Task.class)
	public class GetProjectsManagementProjectTypeExtension {

		public GetProjectsManagementProjectTypeExtension(Task task) {
			_task = task;
		}

		@GraphQLField
		public Project projectsManagementProject() throws Exception {
			return _applyComponentServiceObjects(
				_projectResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				projectResource -> projectResource.getProjectsManagementProject(
					_task.getProjectId()));
		}

		private Task _task;

	}

	@GraphQLName("ProjectPage")
	public class ProjectPage {

		public ProjectPage(Page projectPage) {
			actions = projectPage.getActions();

			items = projectPage.getItems();
			lastPage = projectPage.getLastPage();
			page = projectPage.getPage();
			pageSize = projectPage.getPageSize();
			totalCount = projectPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<Project> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("TaskPage")
	public class TaskPage {

		public TaskPage(Page taskPage) {
			actions = taskPage.getActions();

			items = taskPage.getItems();
			lastPage = taskPage.getLastPage();
			page = taskPage.getPage();
			pageSize = taskPage.getPageSize();
			totalCount = taskPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<Task> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(ProjectResource projectResource)
		throws Exception {

		projectResource.setContextAcceptLanguage(_acceptLanguage);
		projectResource.setContextCompany(_company);
		projectResource.setContextHttpServletRequest(_httpServletRequest);
		projectResource.setContextHttpServletResponse(_httpServletResponse);
		projectResource.setContextUriInfo(_uriInfo);
		projectResource.setContextUser(_user);
		projectResource.setGroupLocalService(_groupLocalService);
		projectResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(TaskResource taskResource)
		throws Exception {

		taskResource.setContextAcceptLanguage(_acceptLanguage);
		taskResource.setContextCompany(_company);
		taskResource.setContextHttpServletRequest(_httpServletRequest);
		taskResource.setContextHttpServletResponse(_httpServletResponse);
		taskResource.setContextUriInfo(_uriInfo);
		taskResource.setContextUser(_user);
		taskResource.setGroupLocalService(_groupLocalService);
		taskResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<ProjectResource>
		_projectResourceComponentServiceObjects;
	private static ComponentServiceObjects<TaskResource>
		_taskResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}