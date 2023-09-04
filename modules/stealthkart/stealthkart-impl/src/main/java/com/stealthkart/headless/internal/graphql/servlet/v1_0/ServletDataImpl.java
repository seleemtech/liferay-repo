package com.stealthkart.headless.internal.graphql.servlet.v1_0;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import com.stealthkart.headless.internal.graphql.mutation.v1_0.Mutation;
import com.stealthkart.headless.internal.graphql.query.v1_0.Query;
import com.stealthkart.headless.internal.resource.v1_0.InstanceResourceImpl;
import com.stealthkart.headless.resource.v1_0.InstanceResource;

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
		Mutation.setInstanceResourceComponentServiceObjects(
			_instanceResourceComponentServiceObjects);

		Query.setInstanceResourceComponentServiceObjects(
			_instanceResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "Stealthkart";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/stealthkart-graphql/v1_0";
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
						"mutation#updateInstancePage",
						new ObjectValuePair<>(
							InstanceResourceImpl.class, "updateInstancePage"));
					put(
						"mutation#createInstaceAdd",
						new ObjectValuePair<>(
							InstanceResourceImpl.class, "postInstaceAdd"));

					put(
						"query#instance",
						new ObjectValuePair<>(
							InstanceResourceImpl.class, "getInstancePage"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<InstanceResource>
		_instanceResourceComponentServiceObjects;

}