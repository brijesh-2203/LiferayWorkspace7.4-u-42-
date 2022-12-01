package userservicewrapper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceWrapper;

import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Map;

/**
 * @author root322
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class UserServiceWrapper extends UserLocalServiceWrapper {

	public UserServiceWrapper() {
		super(null);
	}

	@Override
	public int authenticateByEmailAddress(long companyId, String emailAddress,
										  String password, Map<String, String[]> headerMap,
										  Map<String, String[]> parameterMap, Map<String, Object> resultsMap)
			throws PortalException {

		System.out.println(
				"Authenticating user by email address " + emailAddress);
		return super.authenticateByEmailAddress(companyId, emailAddress, password,
				headerMap, parameterMap, resultsMap);
	}

	@Override
	public User getUser(long userId) throws PortalException {
		System.out.println("Getting user by id " + userId);
		return super.getUser(userId);
	}

	@Reference(unbind = "-")
	private void serviceSetter(UserLocalService userLocalService) {
		setWrappedService(userLocalService);
	}

}