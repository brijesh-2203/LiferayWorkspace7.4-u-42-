package com.liferay.searchProducts.portlet;

import com.liferay.chat.model.Entry;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPDefinitionLocalization;
import com.liferay.commerce.product.model.CProduct;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.product.service.CPDefinitionLocalServiceUtil;
import com.liferay.commerce.product.service.CProductLocalServiceUtil;
import com.liferay.document.library.repository.cmis.Session;
import com.liferay.headless.commerce.admin.catalog.dto.v1_0.Product;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.searchProducts.constants.SearchProductsPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author root321
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=SearchProducts",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + SearchProductsPortletKeys.SEARCHPRODUCTS,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class SearchProductsPortlet extends MVCPortlet {


    //	@Override
//	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//		long productId = ParamUtil.getLong(renderRequest, "productId");
//		CProduct product = null;
//		product = CProductLocalServiceUtil.fetchCProduct(productId);
//		renderRequest.setAttribute("product", product);
//		super.render(renderRequest,renderResponse);
//	}
    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        String keywords = ParamUtil.getString(renderRequest, "keywords");
        System.out.println("keywords:  " + keywords);

       // List<CPDefinition> cpDefinitions = CPDefinitionLocalServiceUtil.
        BaseModelSearchResult<CPDefinition> cpDefinitionBaseModelSearchResult = null;

        try {
            cpDefinitionBaseModelSearchResult = CPDefinitionLocalServiceUtil.searchCPDefinitions(20097, new long[]{20121}, keywords,
                     null, null,0,5,new Sort());
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }
        System.out.println("object"+cpDefinitionBaseModelSearchResult);

        super.render(renderRequest, renderResponse);
//
//        FacetClass facetClass = null;
//       String field_name =  facetClass.getFieldName();
//        System.out.println("=================="+field_name);

    }
}