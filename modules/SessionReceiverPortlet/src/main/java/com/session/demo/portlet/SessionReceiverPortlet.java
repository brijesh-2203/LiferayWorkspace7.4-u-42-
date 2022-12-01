package com.session.demo.portlet;

import com.session.demo.constants.SessionReceiverPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author root322
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
			"com.liferay.portlet.private-session-attributes=false",
			"javax.portlet.display-name=SessionReceiver",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SessionReceiverPortletKeys.SESSIONRECEIVER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SessionReceiverPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		PortletSession session = renderRequest.getPortletSession();

		String message = (String) session.getAttribute("data",PortletSession.APPLICATION_SCOPE);
		renderRequest.setAttribute("message",message);
		super.doView(renderRequest,renderResponse);
	}
}