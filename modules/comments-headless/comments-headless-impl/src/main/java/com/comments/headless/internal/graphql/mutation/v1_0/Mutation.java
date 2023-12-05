package com.comments.headless.internal.graphql.mutation.v1_0;

import com.comments.headless.dto.v1_0.Comments;
import com.comments.headless.dto.v1_0.Workflow;
import com.comments.headless.resource.v1_0.CommentsResource;
import com.comments.headless.resource.v1_0.WorkflowResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineImportTaskResource;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

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
public class Mutation {

	public static void setCommentsResourceComponentServiceObjects(
		ComponentServiceObjects<CommentsResource>
			commentsResourceComponentServiceObjects) {

		_commentsResourceComponentServiceObjects =
			commentsResourceComponentServiceObjects;
	}

	public static void setWorkflowResourceComponentServiceObjects(
		ComponentServiceObjects<WorkflowResource>
			workflowResourceComponentServiceObjects) {

		_workflowResourceComponentServiceObjects =
			workflowResourceComponentServiceObjects;
	}

	@GraphQLField
	public Comments createCommentsEntry(
			@GraphQLName("comments") Comments comments)
		throws Exception {

		return _applyComponentServiceObjects(
			_commentsResourceComponentServiceObjects,
			this::_populateResourceContext,
			commentsResource -> commentsResource.postCommentsEntry(comments));
	}

	@GraphQLField
	public Workflow assignToMe(@GraphQLName("workflow") Workflow workflow)
		throws Exception {

		return _applyComponentServiceObjects(
			_workflowResourceComponentServiceObjects,
			this::_populateResourceContext,
			workflowResource -> workflowResource.assignToMe(workflow));
	}

	@GraphQLField
	public Workflow completeAssignTask(
			@GraphQLName("workflow") Workflow workflow)
		throws Exception {

		return _applyComponentServiceObjects(
			_workflowResourceComponentServiceObjects,
			this::_populateResourceContext,
			workflowResource -> workflowResource.completeAssignTask(workflow));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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

		commentsResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
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
	private static ComponentServiceObjects<WorkflowResource>
		_workflowResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;
	private VulcanBatchEngineImportTaskResource
		_vulcanBatchEngineImportTaskResource;

}