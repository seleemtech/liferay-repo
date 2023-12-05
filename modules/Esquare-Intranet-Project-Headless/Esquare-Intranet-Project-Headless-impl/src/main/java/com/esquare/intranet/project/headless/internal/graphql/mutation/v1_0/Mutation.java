package com.esquare.intranet.project.headless.internal.graphql.mutation.v1_0;

import com.esquare.intranet.project.headless.dto.v1_0.Project;
import com.esquare.intranet.project.headless.dto.v1_0.Task;
import com.esquare.intranet.project.headless.resource.v1_0.ProjectResource;
import com.esquare.intranet.project.headless.resource.v1_0.TaskResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.batch.engine.resource.VulcanBatchEngineExportTaskResource;
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
 * @author Mahammed Seleem
 * @generated
 */
@Generated("")
public class Mutation {

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

	@GraphQLField
	public boolean deleteProjectsManagementProject(
			@GraphQLName("projectId") Long projectId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.deleteProjectsManagementProject(
				projectId));

		return true;
	}

	@GraphQLField
	public Project patchPostResource(@GraphQLName("project") Project project)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.patchPostResource(project));
	}

	@GraphQLField
	public Project patchPostProjectStatu(
			@GraphQLName("project") Project project)
		throws Exception {

		return _applyComponentServiceObjects(
			_projectResourceComponentServiceObjects,
			this::_populateResourceContext,
			projectResource -> projectResource.patchPostProjectStatu(project));
	}

	@GraphQLField
	public Task createPostTask(@GraphQLName("task") Task task)
		throws Exception {

		return _applyComponentServiceObjects(
			_taskResourceComponentServiceObjects,
			this::_populateResourceContext,
			taskResource -> taskResource.postPostTask(task));
	}

	@GraphQLField
	public Task createUpdateTask(@GraphQLName("task") Task task)
		throws Exception {

		return _applyComponentServiceObjects(
			_taskResourceComponentServiceObjects,
			this::_populateResourceContext,
			taskResource -> taskResource.postUpdateTask(task));
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

		projectResource.setVulcanBatchEngineExportTaskResource(
			_vulcanBatchEngineExportTaskResource);

		projectResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
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

		taskResource.setVulcanBatchEngineExportTaskResource(
			_vulcanBatchEngineExportTaskResource);

		taskResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
	}

	private static ComponentServiceObjects<ProjectResource>
		_projectResourceComponentServiceObjects;
	private static ComponentServiceObjects<TaskResource>
		_taskResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;
	private VulcanBatchEngineExportTaskResource
		_vulcanBatchEngineExportTaskResource;
	private VulcanBatchEngineImportTaskResource
		_vulcanBatchEngineImportTaskResource;

}