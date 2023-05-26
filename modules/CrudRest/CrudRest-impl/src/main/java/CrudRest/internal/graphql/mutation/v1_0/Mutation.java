package CrudRest.internal.graphql.mutation.v1_0;

import CrudRest.dto.v1_0.CrudRest;

import CrudRest.resource.v1_0.CrudRestResource;

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
 * @author DELL
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setCrudRestResourceComponentServiceObjects(
		ComponentServiceObjects<CrudRestResource>
			crudRestResourceComponentServiceObjects) {

		_crudRestResourceComponentServiceObjects =
			crudRestResourceComponentServiceObjects;
	}

	@GraphQLField
	@GraphQLName(description = "null", value = "updateCrudPageCrudIdCrudRest")
	public CrudRest updateCrudPage(
			@GraphQLName("crudId") Long crudId,
			@GraphQLName("crudRest") CrudRest crudRest)
		throws Exception {

		return _applyComponentServiceObjects(
			_crudRestResourceComponentServiceObjects,
			this::_populateResourceContext,
			crudRestResource -> crudRestResource.updateCrudPage(
				crudId, crudRest));
	}

	@GraphQLField
	@GraphQLName(description = "null", value = "postCrudAddCrudRest")
	public CrudRest createCrudAdd(@GraphQLName("crudRest") CrudRest crudRest)
		throws Exception {

		return _applyComponentServiceObjects(
			_crudRestResourceComponentServiceObjects,
			this::_populateResourceContext,
			crudRestResource -> crudRestResource.postCrudAdd(crudRest));
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

	private void _populateResourceContext(CrudRestResource crudRestResource)
		throws Exception {

		crudRestResource.setContextAcceptLanguage(_acceptLanguage);
		crudRestResource.setContextCompany(_company);
		crudRestResource.setContextHttpServletRequest(_httpServletRequest);
		crudRestResource.setContextHttpServletResponse(_httpServletResponse);
		crudRestResource.setContextUriInfo(_uriInfo);
		crudRestResource.setContextUser(_user);
		crudRestResource.setGroupLocalService(_groupLocalService);
		crudRestResource.setRoleLocalService(_roleLocalService);

		crudRestResource.setVulcanBatchEngineImportTaskResource(
			_vulcanBatchEngineImportTaskResource);
	}

	private static ComponentServiceObjects<CrudRestResource>
		_crudRestResourceComponentServiceObjects;

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