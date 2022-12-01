package assetentry.portlet;

import assetentry.constants.AssetEntryPortletKeys;

import com.liferay.journal.constants.JournalPortletKeys;
import com.liferay.portal.kernel.portlet.AddPortletProvider;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.search.web.internal.result.display.context.SearchResultSummaryDisplayContext;
/**
 * @author root322
 */
@Component(
	immediate = true,
	property = {
		"model.class.name=com.liferay.asset.kernel.model.AssetEntry",
		"service.ranking:Integer=" + Integer.MAX_VALUE
	},
	service = AddPortletProvider.class
)
public class AssetEntryAddPortletProvider
	extends BasePortletProvider implements AddPortletProvider {

	@Override
	public String getPortletName() {
		System.out.println("Portlat nAMe: ");
		return AssetEntryPortletKeys.ASSETENTRY;
	}

	@Override
	public void updatePortletPreferences(
			PortletPreferences portletPreferences, String portletId,
			String className, long classPK, ThemeDisplay themeDisplay)
		throws Exception {
		System.out.println("CLass nAMe: "+className);
		System.out.println("ClassPk :  "+classPK);
		SearchResultSummaryDisplayContext resultSummaryDisplayContext = new SearchResultSummaryDisplayContext();
		portletPreferences.setValue("className", className);
		portletPreferences.setValue("classPK", String.valueOf(classPK));

	}
}