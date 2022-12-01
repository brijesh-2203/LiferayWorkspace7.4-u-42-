package product_search.portlet;

import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPDefinitionLocalization;
import com.liferay.commerce.product.model.CProduct;
import com.liferay.commerce.product.service.CPDefinitionLocalServiceUtil;
import com.liferay.commerce.product.service.CProductLocalServiceUtil;
import com.liferay.commerce.product.service.persistence.CPDefinitionLocalizationUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import product_search.constants.Product_SearchPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + Product_SearchPortletKeys.PRODUCT_SEARCH,
                "mvc.command.name=/view"
        },
        service = MVCRenderCommand.class
)
public class Product_SearchMVCRender implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

        String keywords = ParamUtil.getString(renderRequest, "keywords");
        System.out.println("Keywords : "+keywords);
        long[] a = {20121,68897,62808};

            List<CPDefinition> searchResult = CPDefinitionLocalServiceUtil.getCPDefinitions(0,CPDefinitionLocalServiceUtil.getCPDefinitionsCount());
        //    BaseModelSearchResult<CPDefinition> searchResult = CPDefinitionLocalServiceUtil.searchCPDefinitions(20097,a,keywords,"productTypeName","simple",0,CPDefinitionLocalServiceUtil.getCPDefinitionsCount(),(Sort) null);
            List<CPDefinitionLocalization> listOfproducts =new ArrayList<CPDefinitionLocalization>();
            System.out.println("sasa: "+searchResult);
            for (CPDefinition cpd : searchResult)
            {
                System.out.println("ids: "+cpd.getCPDefinitionId());
              //  System.out.println("Name: "+CPDefinitionLocalizationUtil.fetchByCPDefinitionId_LanguageId(70043,"en_US"));
                List<CPDefinitionLocalization> cp = CPDefinitionLocalizationUtil.findByCPDefinitionId(cpd.getCPDefinitionId());
                for(CPDefinitionLocalization c : cp)
                {
                    System.out.println("cp. : "+c.getName());
                }
                //  listOfproducts.add(CPDefinitionLocalizationUtil.fetchByCPDefinitionId_LanguageId(cpd.getCPDefinitionId(), cpd.getDefaultLanguageId()));
            }


//
//
//        List<CProduct> products = CProductLocalServiceUtil.getCProducts(0,CProductLocalServiceUtil.getCProductsCount());
//        List<CPDefinitionLocalization> listOfproducts =new ArrayList<>();
//        for(CProduct p : products) {
//            System.out.println(p.getPublishedCPDefinitionId());
//            System.out.println("productid: "+p.getCProductId());
//            List<CPDefinitionLocalization> cps = CPDefinitionLocalizationUtil.findByCPDefinitionId(p.getPublishedCPDefinitionId());
//            for(CPDefinitionLocalization cpl : cps) {
//                //listOfproducts.add(cpl);
//                System.out.println("Name: "+cpl.getName());
//            }
//        }
        return "/view.jsp";
    }
}
