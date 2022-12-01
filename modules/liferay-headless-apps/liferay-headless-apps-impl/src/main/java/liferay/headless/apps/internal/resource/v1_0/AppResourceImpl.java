package liferay.headless.apps.internal.resource.v1_0;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.vulcan.pagination.Page;
import liferay.headless.apps.dto.v1_0.App;
import liferay.headless.apps.resource.v1_0.AppResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import userapp.model.UserApp;
import userapp.service.UserAppLocalService;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @author root322
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/app.properties",
	scope = ServiceScope.PROTOTYPE, service = AppResource.class
)
public class AppResourceImpl extends BaseAppResourceImpl {

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	UserAppLocalService userAppLocalService;

	@Override
	public void deleteApp(@NotNull String appId)
			throws Exception {
		System.out.println("Inside delete App");
		userAppLocalService.deleteUserApp(appId);
	}

	@Override
	public App getApp(String appId) throws Exception {
		System.out.println("Inside Get Apps");
		UserApp userApp=userAppLocalService.getUserApp(appId);
		return _toApp(userApp);
	}


	protected App _toApp(UserApp userApp) throws Exception {
		return new App() {{
			appId = userApp.getAppId();
			description =userApp.getDescription();
			link=userApp.getLink();
			logoUrl=userApp.getLogoUrl();
			name =userApp.getName();
			System.out.println("Inside _App method "+ appId + "--" + description + "--" + name);
		}};
	}

	@Override
	public App postApp(App app) throws Exception {
		System.out.println("Inside add App1 ");
		UserApp a= userAppLocalService.createUserApp(app.getAppId());
		a.setName(app.getName());
		a.setLink(app.getLink());
		a.setDescription(app.getDescription());
		a.setLogoUrl(app.getLogoUrl());
		UserApp userApp= userAppLocalService.addUserApp(a);

		System.out.println("Inside add App11" + userApp);
		return _toApp(userApp);
	}



	@Override
	public Page<App> getApps() throws Exception {
		List<UserApp> userAppList = userAppLocalService.getUserApps(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (UserApp ulist: userAppList){
			System.out.println("User List is :"+ ulist);
		}
		return super.getApps();
	}



}