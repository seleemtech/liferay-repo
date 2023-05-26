package CrudRest.internal.graphql.servlet.v1_0;

import CrudRest.internal.graphql.mutation.v1_0.Mutation;
import CrudRest.internal.graphql.query.v1_0.Query;

import CrudRest.resource.v1_0.CrudRestResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author DELL
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setCrudRestResourceComponentServiceObjects(
			_crudRestResourceComponentServiceObjects);

		Query.setCrudRestResourceComponentServiceObjects(
			_crudRestResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/CrudRest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CrudRestResource>
		_crudRestResourceComponentServiceObjects;

}