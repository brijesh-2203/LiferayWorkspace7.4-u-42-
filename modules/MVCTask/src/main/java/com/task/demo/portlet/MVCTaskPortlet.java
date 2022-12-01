package com.task.demo.portlet;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalArticleServiceUtil;
import com.liferay.journal.service.persistence.JournalArticleUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReader;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.task.demo.constants.MVCTaskPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author root322
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MVCTask",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MVCTaskPortletKeys.MVCTASK,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MVCTaskPortlet extends MVCPortlet {



	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		ThemeDisplay themeDisplay= (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long portletGroupId= themeDisplay.getSiteGroupId();

		List<JournalArticle> articles = JournalArticleLocalServiceUtil.getArticles(portletGroupId);
		List<String> content = new ArrayList<>();
		for(JournalArticle article : articles)
		{
			System.out.println(article.getSmallImageURL());
			System.out.println("aricleid "+article.getArticleId());
			System.out.println("title: "+article.getTitle());
			System.out.println("title: "+article.getDDMStructure().getStructureKey());

			try {
				content.add(getDataFromXML(article.getContent()));
			} catch (DocumentException e) {
				throw new RuntimeException(e);
			}
		}

		renderRequest.setAttribute("content",content);
		renderRequest.setAttribute("webList",articles);
		super.render(renderRequest, renderResponse);
//        return null;
    }


	public static String getDataFromXML(String xml) throws DocumentException {
		System.out.println("xhshjshjdhsjdhj");
		Document doc = SAXReaderUtil.read(xml);
		System.out.println(doc.getStringValue().replaceAll("\\<.*?>", ""));
		return doc.getStringValue().replaceAll("\\<.*?>", "");
	}

	//@ProcessAction(name = "deleteWebContent")
	public void deleteWebContent(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException {
		long article = Long.parseLong(ParamUtil.getString(actionRequest,"articleId"));
		System.out.println("delete method" + article);

		JournalArticleLocalServiceUtil.deleteJournalArticle(article);
		System.out.println("deleted!!");
	}

	public void editEntry(ActionRequest actionRequest,ActionResponse actionResponse) throws PortalException {
		long webId = Long.parseLong(ParamUtil.getString(actionRequest,"articleId"));
		String title = ParamUtil.getString(actionRequest, "title");
		String content = ParamUtil.getString(actionRequest, "content");

		JournalArticle article = JournalArticleLocalServiceUtil.getArticle(webId);
		article.setUrlTitle(title);
		//article.setC
	}


}