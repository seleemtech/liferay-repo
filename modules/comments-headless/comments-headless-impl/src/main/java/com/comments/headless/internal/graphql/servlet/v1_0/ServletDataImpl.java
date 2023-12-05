package com.comments.headless.internal.graphql.servlet.v1_0;

import com.comments.headless.internal.graphql.mutation.v1_0.Mutation;
import com.comments.headless.internal.graphql.query.v1_0.Query;
import com.comments.headless.internal.resource.v1_0.CommentsResourceImpl;
import com.comments.headless.internal.resource.v1_0.CustomObjectDefinitionResourceImpl;
import com.comments.headless.internal.resource.v1_0.NotificationResourceImpl;
import com.comments.headless.internal.resource.v1_0.WorkflowResourceImpl;
import com.comments.headless.resource.v1_0.CommentsResource;
import com.comments.headless.resource.v1_0.CustomObjectDefinitionResource;
import com.comments.headless.resource.v1_0.NotificationResource;
import com.comments.headless.resource.v1_0.WorkflowResource;

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
 * @author E2Software-011
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setCommentsResourceComponentServiceObjects(
			_commentsResourceComponentServiceObjects);
		Mutation.setWorkflowResourceComponentServiceObjects(
			_workflowResourceComponentServiceObjects);

		Query.setCommentsResourceComponentServiceObjects(
			_commentsResourceComponentServiceObjects);
		Query.setCustomObjectDefinitionResourceComponentServiceObjects(
			_customObjectDefinitionResourceComponentServiceObjects);
		Query.setNotificationResourceComponentServiceObjects(
			_notificationResourceComponentServiceObjects);
		Query.setWorkflowResourceComponentServiceObjects(
			_workflowResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "CommentsHeadless";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/comments-headless-graphql/v1_0";
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
						"mutation#createCommentsEntry",
						new ObjectValuePair<>(
							CommentsResourceImpl.class, "postCommentsEntry"));
					put(
						"mutation#assignToMe",
						new ObjectValuePair<>(
							WorkflowResourceImpl.class, "assignToMe"));
					put(
						"mutation#completeAssignTask",
						new ObjectValuePair<>(
							WorkflowResourceImpl.class, "completeAssignTask"));

					put(
						"query#commentsEntry",
						new ObjectValuePair<>(
							CommentsResourceImpl.class, "getCommentsEntry"));
					put(
						"query#objectDefinitions",
						new ObjectValuePair<>(
							CustomObjectDefinitionResourceImpl.class,
							"getObjectDefinitionsPage"));
					put(
						"query#userNotification",
						new ObjectValuePair<>(
							NotificationResourceImpl.class,
							"getUserNotification"));
					put(
						"query#workflowTask",
						new ObjectValuePair<>(
							WorkflowResourceImpl.class, "getWorkflowTask"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CommentsResource>
		_commentsResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<WorkflowResource>
		_workflowResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CustomObjectDefinitionResource>
		_customObjectDefinitionResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<NotificationResource>
		_notificationResourceComponentServiceObjects;

}