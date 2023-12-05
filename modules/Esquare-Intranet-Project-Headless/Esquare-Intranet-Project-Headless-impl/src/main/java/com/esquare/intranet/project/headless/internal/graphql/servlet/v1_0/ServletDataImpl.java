package com.esquare.intranet.project.headless.internal.graphql.servlet.v1_0;

import com.esquare.intranet.project.headless.internal.graphql.mutation.v1_0.Mutation;
import com.esquare.intranet.project.headless.internal.graphql.query.v1_0.Query;
import com.esquare.intranet.project.headless.internal.resource.v1_0.ProjectResourceImpl;
import com.esquare.intranet.project.headless.internal.resource.v1_0.TaskResourceImpl;
import com.esquare.intranet.project.headless.resource.v1_0.ProjectResource;
import com.esquare.intranet.project.headless.resource.v1_0.TaskResource;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Mahammed Seleem
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setProjectResourceComponentServiceObjects(
			_projectResourceComponentServiceObjects);
		Mutation.setTaskResourceComponentServiceObjects(
			_taskResourceComponentServiceObjects);

		Query.setProjectResourceComponentServiceObjects(
			_projectResourceComponentServiceObjects);
		Query.setTaskResourceComponentServiceObjects(
			_taskResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "EsquareIntranetProjectHeadless";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/esquare/intranet/project/headless-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	public ObjectValuePair<Class<?>, String> getResourceMethodObjectValuePair(
		String methodName, boolean mutation) {

		if (mutation) {
			return _resourceMethodObjectValuePairs.get(
				"mutation#" + methodName);
		}

		return _resourceMethodObjectValuePairs.get("query#" + methodName);
	}

	private static final Map<String, ObjectValuePair<Class<?>, String>>
		_resourceMethodObjectValuePairs =
			new HashMap<String, ObjectValuePair<Class<?>, String>>() {
				{
					put(
						"mutation#deleteProjectsManagementProject",
						new ObjectValuePair<>(
							ProjectResourceImpl.class,
							"deleteProjectsManagementProject"));
					put(
						"mutation#patchPostResource",
						new ObjectValuePair<>(
							ProjectResourceImpl.class, "patchPostResource"));
					put(
						"mutation#patchPostProjectStatu",
						new ObjectValuePair<>(
							ProjectResourceImpl.class,
							"patchPostProjectStatu"));
					put(
						"mutation#createPostTask",
						new ObjectValuePair<>(
							TaskResourceImpl.class, "postPostTask"));
					put(
						"mutation#createUpdateTask",
						new ObjectValuePair<>(
							TaskResourceImpl.class, "postUpdateTask"));

					put(
						"query#projectsManagement",
						new ObjectValuePair<>(
							ProjectResourceImpl.class,
							"getProjectsManagementPage"));
					put(
						"query#projectsManagementProject",
						new ObjectValuePair<>(
							ProjectResourceImpl.class,
							"getProjectsManagementProject"));
					put(
						"query#getTasksProject",
						new ObjectValuePair<>(
							TaskResourceImpl.class, "getGetTasksProjectPage"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ProjectResource>
		_projectResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<TaskResource>
		_taskResourceComponentServiceObjects;

}