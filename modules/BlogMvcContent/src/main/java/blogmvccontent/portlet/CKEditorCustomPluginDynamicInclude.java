package blogmvccontent.portlet;

import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.util.StreamUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;


@Component(immediate = true, service = DynamicInclude.class)

public class CKEditorCustomPluginDynamicInclude implements DynamicInclude {
    @Override
    public void include(HttpServletRequest request, HttpServletResponse response, String key) throws IOException {

        Bundle bundle = _bundleContext.getBundle();

        URL entryURL = bundle.getEntry(
                "/META-INF/resources/ckeditor/plugins/colorbutton/plugin.js");
        URL entryURL2 = bundle.getEntry(
                "/META-INF/resources/ckeditor/plugins/colorbutton/icons/bgcolor.png");
        URL entryURL3 = bundle.getEntry(
                "/META-INF/resources/ckeditor/plugins/colorbutton/icons/textcolor.png");
        StreamUtil.transfer(
                entryURL.openStream(), response.getOutputStream());
//        StreamUtil.transfer(
//                entryURL2.openStream(), response.getOutputStream());
//        StreamUtil.transfer(
//                entryURL3.openStream(), response.getOutputStream());
    }

    @Override
    public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
        dynamicIncludeRegistry.register("com.liferay.frontend.editor.ckeditor.web");
    }

    @Activate
    protected void activate(BundleContext bundleContext) {
        _bundleContext = bundleContext;
    }

    private BundleContext _bundleContext;
}
