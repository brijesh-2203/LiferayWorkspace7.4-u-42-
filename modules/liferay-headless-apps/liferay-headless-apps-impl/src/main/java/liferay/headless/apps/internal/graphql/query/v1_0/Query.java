package liferay.headless.apps.internal.graphql.query.v1_0;

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

import javax.ws.rs.core.UriInfo;

import liferay.headless.apps.dto.v1_0.App;
import liferay.headless.apps.resource.v1_0.AppResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author root322
 * @generated
 */
@Generated("")
public class Query {

	public static void setAppResourceComponentServiceObjects(
		ComponentServiceObjects<AppResource>
			appResourceComponentServiceObjects) {

		_appResourceComponentServiceObjects =
			appResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {apps{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get all apps")
	public AppPage apps() throws Exception {
		return _applyComponentServiceObjects(
			_appResourceComponentServiceObjects, this::_populateResourceContext,
			appResource -> new AppPage(appResource.getApps()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {app(appId: ___){appId, name, description, logoUrl, link}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the app")
	public App app(@GraphQLName("appId") String appId) throws Exception {
		return _applyComponentServiceObjects(
			_appResourceComponentServiceObjects, this::_populateResourceContext,
			appResource -> appResource.getApp(appId));
	}

	@GraphQLName("AppPage")
	public class AppPage {

		public AppPage(Page appPage) {
			actions = appPage.getActions();

			items = appPage.getItems();
			lastPage = appPage.getLastPage();
			page = appPage.getPage();
			pageSize = appPage.getPageSize();
			totalCount = appPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<App> items;

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

	private void _populateResourceContext(AppResource appResource)
		throws Exception {

		appResource.setContextAcceptLanguage(_acceptLanguage);
		appResource.setContextCompany(_company);
		appResource.setContextHttpServletRequest(_httpServletRequest);
		appResource.setContextHttpServletResponse(_httpServletResponse);
		appResource.setContextUriInfo(_uriInfo);
		appResource.setContextUser(_user);
		appResource.setGroupLocalService(_groupLocalService);
		appResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<AppResource>
		_appResourceComponentServiceObjects;

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