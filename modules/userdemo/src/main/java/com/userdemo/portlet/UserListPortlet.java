package com.userdemo.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.userdemo.constants.UserListPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.*;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author root328
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UserList",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UserListPortletKeys.USERLIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UserListPortlet extends MVCPortlet {

	@Reference
	CounterLocalService counterLocalService;


	@ProcessAction(name = "addStudent")
	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
		long userId = counterLocalService.increment();

		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
		String password = ParamUtil.getString(actionRequest, "password");
		String greeting = ParamUtil.getString(actionRequest, "greeting");
		String languageId = ParamUtil.getString(actionRequest, "languageId");
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
//		String contactId = ParamUtil.getString(actionRequest, "contactId");
//		String ctCollectionId = ParamUtil.getString(actionRequest, "ctCollectionId");



		User user = UserLocalServiceUtil.createUser(userId);
		user.setUserId(userId);
		user.setScreenName(screenName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(emailAddress);
//		user.setPassword(password);
//		user.setCreateDate(new Date());
//		user.setGreeting("Hi " + greeting);
//		user.setJobTitle(jobTitle);
		user.setLanguageId(languageId);
		user.setContactId(userId+1);
		user.setCtCollectionId(0);
//		System.out.println("User is :"+ user);
		UserLocalServiceUtil.addUser(user);
		long userid[] = {user.getUserId()};
		System.out.println("Class PK is :"+ userid[0]);

		//Get ClassName ID
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(String.valueOf(user.getModelClassName()));
		System.out.println("ClassName id "+ classNameId);

		//Get Company ID
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = themeDisplay.getCompanyId();


		long gpId = CounterLocalServiceUtil.increment(Group.class.getName());
		Group userGrp = GroupLocalServiceUtil.createGroup(gpId);
		userGrp.setClassNameId(classNameId);
		userGrp.setClassPK(userid[0]);
		userGrp.setCompanyId(companyId);
		userGrp.setName("group"+String.valueOf(userid[0]));
		userGrp.setFriendlyURL("/group"+gpId);
		userGrp.setCreatorUserId(PortalUtil.getUserId(actionRequest));
		userGrp.setActive(true);
		GroupLocalServiceUtil.addGroup(userGrp);

		//Assign LayoutSet in Liferay for Public page
		long layoutSetIdPub = CounterLocalServiceUtil.increment(LayoutSet.class.getName());
		LayoutSet layoutSetPub=LayoutSetLocalServiceUtil.createLayoutSet(layoutSetIdPub);
		layoutSetPub.setCompanyId(companyId);
		layoutSetPub.setPrivateLayout(false);
		layoutSetPub.setGroupId(userGrp.getGroupId());
		layoutSetPub.setThemeId("classic");
		try{
			LayoutSetLocalServiceUtil.addLayoutSet(layoutSetPub);
		}catch(SystemException se){
		}

		//Assign LayoutSet in Liferay For Private Page
		long layoutSetIdPriv= CounterLocalServiceUtil.increment(LayoutSet.class.getName());
		LayoutSet layoutSetPriv=LayoutSetLocalServiceUtil.createLayoutSet(layoutSetIdPriv);
		layoutSetPriv.setCompanyId(companyId);
		layoutSetPriv.setPrivateLayout(true);
		layoutSetPriv.setThemeId("classic");
		layoutSetPriv.setGroupId(userGrp.getGroupId());
		try{
			LayoutSetLocalServiceUtil.addLayoutSet(layoutSetPriv);
		}catch(SystemException se){
		}

		//Insert Contact for this user
		int prefixId=123;
		int suffixId=234;
		long idContact = CounterLocalServiceUtil.increment(Contact.class.getName());
		Contact contact = ContactLocalServiceUtil.createContact(idContact);
		contact.setCompanyId(companyId);
		contact.setCreateDate(new Date());
		contact.setUserName(screenName);
		contact.setUserId(user.getUserId());
		contact.setModifiedDate(new Date());
		contact.setFirstName("contact-"+contact.getContactId());
		contact.setLastName("contact-"+contact.getContactId());
		contact.setMiddleName("contact-"+contact.getContactId());
		contact.setPrefixId(prefixId);
		contact.setSuffixId(suffixId);
		contact.setJobTitle(jobTitle+contact.getContactId());
		contact.setBirthday(new Date());
		contact.setClassNameId(classNameId);
		contact.setClassPK(userid[0]);
		contact.setContactId(userid[0]+1);
		contact.setEmailAddress(emailAddress);
		ContactLocalServiceUtil.addContact(contact);

		//Assign Role to User
//		String roleName = "Administrator";
//		Role role = RoleLocalServiceUtil.getRole(20097, roleName);
//		User user2 = UserLocalServiceUtil.getUserById(userId);
//		UserLocalServiceUtil.addRoleUser(role.getRoleId(), user.getUserId());
//		UserLocalServiceUtil.updateUser(user2);

		//Create Org
//		long organizationId = counterLocalService.increment();
//		Organization organization = OrganizationLocalServiceUtil.createOrganization(organizationId);
//		organization.setCompanyId(companyId);
//		organization.setParentOrganizationId(0);
//		String treePath = organization.buildTreePath();
//		organization.setTreePath(treePath);
//		organization.setName("org3");
//		organization.setType("organization");
//		organization.setRecursable(true);
//		organization.setRegionId(0);
//		organization.setCountryId(0);
//		organization.setUserId(user.getUserId());
//		organization.setStatusId(ListTypeConstants.ORGANIZATION_STATUS_DEFAULT);
//		organization.setComments("des");
//		organization.setUserName("Test Test");
//		System.out.println("org is :"+ organization);
//		OrganizationLocalServiceUtil.addOrganization(organization);
	}

	@ProcessAction(name = "deleteStudent")
	public void deleteStudent(ActionRequest actionRequest, ActionResponse actionResponse){
		long userId = ParamUtil.getLong(actionRequest, "userId", GetterUtil.DEFAULT_LONG);
		try {
			UserLocalServiceUtil.deleteUser(userId);
		} catch (Exception e) {
//			log.error(e.getMessage(), e);
		}
	}

	@ProcessAction(name = "updateStudent")
	public void updateStudent(ActionRequest actionRequest,  ActionResponse actionResponse) {
		long userId = ParamUtil.getLong(actionRequest,"userId", GetterUtil.DEFAULT_LONG);
		String firstName = ParamUtil.getString(actionRequest, "firstName", GetterUtil.DEFAULT_STRING);
		String lastName = ParamUtil.getString(actionRequest, "lastName", GetterUtil.DEFAULT_STRING);
		String screenName = ParamUtil.getString(actionRequest, "screenName", GetterUtil.DEFAULT_STRING);
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress", GetterUtil.DEFAULT_STRING);
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (Exception e) {
//			log.error(e.getCause(), e);
		}

		if(Validator.isNotNull(user)) {
			user.setScreenName(screenName);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmailAddress(emailAddress);
			UserLocalServiceUtil.updateUser(user);
		}
	}
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		CacheRegistryUtil.clear();
		int count = UserLocalServiceUtil.getUsersCount();
		List<User> users =  UserLocalServiceUtil.getUsers(0,count);
		renderRequest.setAttribute("allUsers", users );

		super.render(renderRequest, renderResponse);

        return null;
    }

	public void addOrganization(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {


		String orgname = ParamUtil.getString(actionRequest, "orgname");
		String type = ParamUtil.getString(actionRequest, "type");
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(scopeGroupId);


		long companyId = themeDisplay.getCompanyId();
		System.out.println("Name of org : "+orgname);
		System.out.println("type: "+type);
		System.out.println("company id : "+companyId);
		long usrid = themeDisplay.getUserId();
		System.out.println("user id current: "+usrid);
		User usr = themeDisplay.getUser();
		long orgId = counterLocalService.increment();
		Organization organization = OrganizationLocalServiceUtil.createOrganization(orgId);
		organization.setCompanyId(companyId);
		organization.setParentOrganizationId(0);
		String treePath = organization.buildTreePath();
		organization.setTreePath(treePath);
		organization.setName(orgname);
		organization.setType(type);
		organization.setRecursable(true);
		organization.setRegionId(0);
		organization.setCountryId(0);
		organization.setUserId(usrid);
		organization.setStatusId(ListTypeConstants.ORGANIZATION_STATUS_DEFAULT);
		organization.setUserName(usr.getFullName());
		System.out.println("name :"+usr.getFullName());
		System.out.println("org is :"+ organization);
		OrganizationLocalServiceUtil.addOrganization(organization);

		long res = counterLocalService.increment();

		ResourcePermission rs = ResourcePermissionLocalServiceUtil.createResourcePermission(res);
		rs.setCompanyId(companyId);
		rs.setName("com.liferay.portal.kernel.model.Organization");
		rs.setPrimKey(String.valueOf(orgId));
		rs.setPrimKeyId(orgId);
		rs.setScope(4);
		rs.setRoleId(20103l);
		ResourcePermissionLocalServiceUtil.addResourcePermission(rs);
	}
}