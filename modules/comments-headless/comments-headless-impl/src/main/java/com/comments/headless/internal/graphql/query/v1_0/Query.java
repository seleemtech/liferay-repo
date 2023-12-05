package com.comments.headless.internal.graphql.query.v1_0;

import com.comments.headless.dto.v1_0.Comments;
import com.comments.headless.dto.v1_0.CustomObjectDefinition;
import com.comments.headless.dto.v1_0.Notification;
import com.comments.headless.dto.v1_0.Workflow;
import com.comments.headless.resource.v1_0.CommentsResource;
import com.comments.headless.resource.v1_0.CustomObjectDefinitionResource;
import com.comments.headless.resource.v1_0.NotificationResource;
import com.comments.headless.resource.v1_0.WorkflowResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.aggregation.Aggregation;
import com.liferay.portal.vulcan.aggregation.Facet;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author E2Software-011
 * @generated
 */
@Generated("")
public class Query {

	public static void setCommentsResourceComponentServiceObjects(
		ComponentServiceObjects<CommentsResource>
			commentsResourceComponentServiceObjects) {

		_commentsResourceComponentServiceObjects =
			commentsResourceComponentServiceObjects;
	}

	public static void setCustomObjectDefinitionResourceComponentServiceObjects(
		ComponentServiceObjects<CustomObjectDefinitionResource>
			customObjectDefinitionResourceComponentServiceObjects) {

		_customObjectDefinitionResourceComponentServiceObjects =
			customObjectDefinitionResourceComponentServiceObjects;
	}

	public static void setNotificationResourceComponentServiceObjects(
		ComponentServiceObjects<NotificationResource>
			notificationResourceComponentServiceObjects) {

		_notificationResourceComponentServiceObjects =
			notificationResourceComponentServiceObjects;
	}

	public static void setWorkflowResourceComponentServiceObjects(
		ComponentServiceObjects<WorkflowResource>
			workflowResourceComponentServiceObjects) {

		_workflowResourceComponentServiceObjects =
			workflowResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {commentsEntry(companyId: ___, objectDefinitionName: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CommentsPage commentsEntry(
			@GraphQLName("companyId") Long companyId,
			@GraphQLName("objectDefinitionName") String objectDefinitionName)
		throws Exception {

		return _applyComponentServiceObjects(
			_commentsResourceComponentServiceObjects,
			this::_populateResourceContext,
			commentsResource -> new CommentsPage(
				commentsResource.getCommentsEntry(
					companyId, objectDefinitionName)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {objectDefinitions(aggregation: ___, filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CustomObjectDefinitionPage objectDefinitions(
			@GraphQLName("search") String search,
			@GraphQLName("aggregation") List<String> aggregations,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_customObjectDefinitionResourceComponentServiceObjects,
			this::_populateResourceContext,
			customObjectDefinitionResource -> new CustomObjectDefinitionPage(
				customObjectDefinitionResource.getObjectDefinitionsPage(
					search,
					_aggregationBiFunction.apply(
						customObjectDefinitionResource, aggregations),
					_filterBiFunction.apply(
						customObjectDefinitionResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(
						customObjectDefinitionResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {userNotification(userId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public NotificationPage userNotification(@GraphQLName("userId") Long userId)
		throws Exception {

		return _applyComponentServiceObjects(
			_notificationResourceComponentServiceObjects,
			this::_populateResourceContext,
			notificationResource -> new NotificationPage(
				notificationResource.getUserNotification(userId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {workflowTask(workflowTaskId: ___){transitionName, comment, workflowTaskId, assigneeUserId, userId, companyId, groupId, isAssignedToSingleUser, isWorkflowCompleted, workflowTaskAssigneeUserName, TaskContent, worflowTansition, assignableUser}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Workflow workflowTask(
			@GraphQLName("workflowTaskId") Long workflowTaskId)
		throws Exception {

		return _applyComponentServiceObjects(
			_workflowResourceComponentServiceObjects,
			this::_populateResourceContext,
			workflowResource -> workflowResource.getWorkflowTask(
				workflowTaskId));
	}

	@GraphQLName("CommentsPage")
	public class CommentsPage {

		public CommentsPage(Page commentsPage) {
			actions = commentsPage.getActions();

			facets = commentsPage.getFacets();

			items = commentsPage.getItems();
			lastPage = commentsPage.getLastPage();
			page = commentsPage.getPage();
			pageSize = commentsPage.getPageSize();
			totalCount = commentsPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected List<Facet> facets;

		@GraphQLField
		protected java.util.Collection<Comments> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("CustomObjectDefinitionPage")
	public class CustomObjectDefinitionPage {

		public CustomObjectDefinitionPage(Page customObjectDefinitionPage) {
			actions = customObjectDefinitionPage.getActions();

			facets = customObjectDefinitionPage.getFacets();

			items = customObjectDefinitionPage.getItems();
			lastPage = customObjectDefinitionPage.getLastPage();
			page = customObjectDefinitionPage.getPage();
			pageSize = customObjectDefinitionPage.getPageSize();
			totalCount = customObjectDefinitionPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected List<Facet> facets;

		@GraphQLField
		protected java.util.Collection<CustomObjectDefinition> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("NotificationPage")
	public class NotificationPage {

		public NotificationPage(Page notificationPage) {
			actions = notificationPage.getActions();

			facets = notificationPage.getFacets();

			items = notificationPage.getItems();
			lastPage = notificationPage.getLastPage();
			page = notificationPage.getPage();
			pageSize = notificationPage.getPageSize();
			totalCount = notificationPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected List<Facet> facets;

		@GraphQLField
		protected java.util.Collection<Notification> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("WorkflowPage")
	public class WorkflowPage {

		public WorkflowPage(Page workflowPage) {
			actions = workflowPage.getActions();

			facets = workflowPage.getFacets();

			items = workflowPage.getItems();
			lastPage = workflowPage.getLastPage();
			page = workflowPage.getPage();
			pageSize = workflowPage.getPageSize();
			totalCount = workflowPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected List<Facet> facets;

		@GraphQLField
		protected java.util.Collection<Workflow> items;

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

	private void _populateResourceContext(CommentsResource commentsResource)
		throws Exception {

		commentsResource.setContextAcceptLanguage(_acceptLanguage);
		commentsResource.setContextCompany(_company);
		commentsResource.setContextHttpServletRequest(_httpServletRequest);
		commentsResource.setContextHttpServletResponse(_httpServletResponse);
		commentsResource.setContextUriInfo(_uriInfo);
		commentsResource.setContextUser(_user);
		commentsResource.setGroupLocalService(_groupLocalService);
		commentsResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			CustomObjectDefinitionResource customObjectDefinitionResource)
		throws Exception {

		customObjectDefinitionResource.setContextAcceptLanguage(
			_acceptLanguage);
		customObjectDefinitionResource.setContextCompany(_company);
		customObjectDefinitionResource.setContextHttpServletRequest(
			_httpServletRequest);
		customObjectDefinitionResource.setContextHttpServletResponse(
			_httpServletResponse);
		customObjectDefinitionResource.setContextUriInfo(_uriInfo);
		customObjectDefinitionResource.setContextUser(_user);
		customObjectDefinitionResource.setGroupLocalService(_groupLocalService);
		customObjectDefinitionResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			NotificationResource notificationResource)
		throws Exception {

		notificationResource.setContextAcceptLanguage(_acceptLanguage);
		notificationResource.setContextCompany(_company);
		notificationResource.setContextHttpServletRequest(_httpServletRequest);
		notificationResource.setContextHttpServletResponse(
			_httpServletResponse);
		notificationResource.setContextUriInfo(_uriInfo);
		notificationResource.setContextUser(_user);
		notificationResource.setGroupLocalService(_groupLocalService);
		notificationResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(WorkflowResource workflowResource)
		throws Exception {

		workflowResource.setContextAcceptLanguage(_acceptLanguage);
		workflowResource.setContextCompany(_company);
		workflowResource.setContextHttpServletRequest(_httpServletRequest);
		workflowResource.setContextHttpServletResponse(_httpServletResponse);
		workflowResource.setContextUriInfo(_uriInfo);
		workflowResource.setContextUser(_user);
		workflowResource.setGroupLocalService(_groupLocalService);
		workflowResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<CommentsResource>
		_commentsResourceComponentServiceObjects;
	private static ComponentServiceObjects<CustomObjectDefinitionResource>
		_customObjectDefinitionResourceComponentServiceObjects;
	private static ComponentServiceObjects<NotificationResource>
		_notificationResourceComponentServiceObjects;
	private static ComponentServiceObjects<WorkflowResource>
		_workflowResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private BiFunction<Object, List<String>, Aggregation>
		_aggregationBiFunction;
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