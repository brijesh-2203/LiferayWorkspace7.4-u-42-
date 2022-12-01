package friendlyurl.portlet;


import com.liferay.blogs.constants.BlogsPortletKeys;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import org.osgi.service.component.annotations.Component;

@Component(
        property = {
                "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
                "javax.portlet.name=" + BlogsPortletKeys.BLOGS
        },
        service = FriendlyURLMapper.class
)
public class BlogFriendlyUrl extends DefaultFriendlyURLMapper{
    @Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "blogs";
}
