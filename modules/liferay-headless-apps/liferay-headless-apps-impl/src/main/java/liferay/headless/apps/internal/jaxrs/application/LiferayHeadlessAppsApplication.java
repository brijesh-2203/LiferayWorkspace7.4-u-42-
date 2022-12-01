package liferay.headless.apps.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author root322
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/liferay-headless-apps",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=LiferayHeadlessApps"
	},
	service = Application.class
)
@Generated("")
public class LiferayHeadlessAppsApplication extends Application {
}