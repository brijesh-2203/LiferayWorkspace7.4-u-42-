package ckeditordemo.portlet;

import ckeditordemo.constants.CKEditordemoPortletKeys;

import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

/**
 * @author root322
 */
@Component(
		immediate = true,
		property = {
				"editor.name=ckeditor",
				"service.ranking:Integer=101"
		},
		service = EditorConfigContributor.class
)
public class CKEditordemoPortlet extends BaseEditorConfigContributor {
	@Override
	public void populateConfigJSONObject(JSONObject jsonObject, Map<String, Object> map, ThemeDisplay themeDisplay, RequestBackedPortletURLFactory requestBackedPortletURLFactory) {
		System.out.println("jSON Object: "+jsonObject);
		String extraPlugins = jsonObject.getString("extraPlugins");
		System.out.println("extraplugin: "+extraPlugins);

		if (!extraPlugins.contains("colorbutton")) {
			extraPlugins = extraPlugins + ",templates,smiley,uicolor,button,panel,panelbutton,floatpanel,colorbutton";
		}
		jsonObject.put("extraPlugins",extraPlugins);
		System.out.println("added extra : "+extraPlugins);
		JSONArray toolbarsLiferay = JSONFactoryUtil.createJSONArray();

		JSONArray extraTools = JSONFactoryUtil.createJSONArray();
		if (jsonObject.has("toolbar_liferay")) {
			toolbarsLiferay = jsonObject.getJSONArray("toolbar_liferay");
			extraTools = toolbarsLiferay.getJSONArray(4);
		}

		extraTools.put("-");
		extraTools.put("Cut");
		extraTools.put("Copy");
		extraTools.put("Paste");
		extraTools.put("UIColor");
		extraTools.put("-");
//		extraTools.put("Button");
//		extraTools.put("Panel");
//		extraTools.put("PanelButton");
//		extraTools.put("FloatPanel");
		extraTools.put("BGColor");
		extraTools.put("TextColor");
		extraTools.put("Smiley");
		extraTools.put("Templates");
		jsonObject.put("toolbar_liferay",toolbarsLiferay);
		System.out.println("akjdksjdk: "+jsonObject);
	}
}