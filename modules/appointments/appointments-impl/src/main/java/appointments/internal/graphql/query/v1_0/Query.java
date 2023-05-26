package appointments.internal.graphql.query.v1_0;

import appointments.dto.v1_0.Appoinment;

import appointments.resource.v1_0.AppoinmentResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotEmpty;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author DELL
 * @generated
 */
@Generated("")
public class Query {

	public static void setAppoinmentResourceComponentServiceObjects(
		ComponentServiceObjects<AppoinmentResource>
			appoinmentResourceComponentServiceObjects) {

		_appoinmentResourceComponentServiceObjects =
			appoinmentResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {appointments(siteKey: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public AppoinmentPage appointments(
			@GraphQLName("siteKey") @NotEmpty String siteKey)
		throws Exception {

		return _applyComponentServiceObjects(
			_appoinmentResourceComponentServiceObjects,
			this::_populateResourceContext,
			appoinmentResource -> new AppoinmentPage(
				appoinmentResource.getSiteAppointmentsPage(
					Long.valueOf(siteKey))));
	}

	@GraphQLName("AppoinmentPage")
	public class AppoinmentPage {

		public AppoinmentPage(Page appoinmentPage) {
			actions = appoinmentPage.getActions();

			items = appoinmentPage.getItems();
			lastPage = appoinmentPage.getLastPage();
			page = appoinmentPage.getPage();
			pageSize = appoinmentPage.getPageSize();
			totalCount = appoinmentPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Appoinment> items;

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

	private void _populateResourceContext(AppoinmentResource appoinmentResource)
		throws Exception {

		appoinmentResource.setContextAcceptLanguage(_acceptLanguage);
		appoinmentResource.setContextCompany(_company);
		appoinmentResource.setContextHttpServletRequest(_httpServletRequest);
		appoinmentResource.setContextHttpServletResponse(_httpServletResponse);
		appoinmentResource.setContextUriInfo(_uriInfo);
		appoinmentResource.setContextUser(_user);
		appoinmentResource.setGroupLocalService(_groupLocalService);
		appoinmentResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<AppoinmentResource>
		_appoinmentResourceComponentServiceObjects;

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