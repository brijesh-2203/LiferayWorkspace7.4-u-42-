package panelappdemo.application.list;

import panelappdemo.constants.PanelAppDemoPanelCategoryKeys;
import panelappdemo.constants.PanelAppDemoPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author root322
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + PanelAppDemoPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class PanelAppDemoPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return PanelAppDemoPortletKeys.PANELAPPDEMO;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + PanelAppDemoPortletKeys.PANELAPPDEMO + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}