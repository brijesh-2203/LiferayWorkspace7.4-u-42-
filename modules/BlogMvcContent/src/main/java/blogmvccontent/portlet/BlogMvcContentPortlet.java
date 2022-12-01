//package blogmvccontent.portlet;
//
//import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
//import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
//import com.liferay.portal.kernel.json.JSONArray;
//import com.liferay.portal.kernel.json.JSONException;
//import com.liferay.portal.kernel.json.JSONFactoryUtil;
//import com.liferay.portal.kernel.json.JSONObject;
//import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.Validator;
//import org.osgi.service.component.annotations.Component;
//
//import java.util.Map;
//
//
//@Component(
//		immediate = true,
//		property = {
//				"editor.name=ckeditor",
//				"javax.portlet.name=com_liferay_journal_web_portlet_JournalPortlet",
//				"javax.portlet.name=com_liferay_blogs_web_portlet_BlogsAdminPortlet",
//				"service.ranking:Integer=100"
//		},
//		service = EditorConfigContributor.class
//)
//public class BlogMvcContentPortlet extends BaseEditorConfigContributor {
//
//	@Override
//	public void populateConfigJSONObject(JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
//										 ThemeDisplay themeDisplay, RequestBackedPortletURLFactory requestBackedPortletURLFactory) {
//		JSONArray toolbarsLiferay = JSONFactoryUtil.createJSONArray();
//
//		JSONArray extraTools = JSONFactoryUtil.createJSONArray();
//		System.out.println("!!!!!!!!!!!!!!!!json objedt "+jsonObject);
//
//
//		String extraPlugins = jsonObject.getString("extraPlugins");
//		System.out.println("before extra :"+extraPlugins);
//		if (Validator.isNotNull(extraPlugins)) {
//			extraPlugins = extraPlugins + ",colorbutton";
//		}
//		else {
//			extraPlugins = ",colorbutton";
//		}
//
//		jsonObject.put("extraPlugins", extraPlugins);
//
//		System.out.println("json extra: "+jsonObject);
//		if (jsonObject.has("toolbar_liferay")) {
//			System.out.println("json objedt in if: "+jsonObject);
//			toolbarsLiferay = jsonObject.getJSONArray("toolbar_liferay");
//			System.out.println("liferay "+toolbarsLiferay);
//			extraTools = toolbarsLiferay.getJSONArray(4);
//		}
////
////
////		extraTools.put("-");
////        extraTools.put("JustifyLeft");
////        extraTools.put("JustifyRight");
////        extraTools.put("JustifyCenter");
////        extraTools.put("JustifyBlock");
////        extraTools.put("RemoveFormat");
////		extraTools.put("BGColor");
////		extraTools.put("TextColor");
//		extraTools.put("-");
//		extraTools.put("Cut");
//		extraTools.put("Copy");
//		extraTools.put("Paste");
//		extraTools.put("BGColor");
//		extraTools.put("TextColor");
////		extraTools.put("Styles");
////		toolbarsLiferay.put(extraTools);
////		jsonObject.put("toolbar_liferay", toolbarsLiferay);
//		System.out.println("@@@@@@@@@@@@@@@@@@tool bars extra sret:  "+toolbarsLiferay);
////		System.out.println("tools extra : "+extraTools);
//		System.out.println("tools akkslskasa:"+jsonObject);
//	}
//}
