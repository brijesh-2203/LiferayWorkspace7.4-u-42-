package LanguageHookDemo.portlet;

import LanguageHookDemo.constants.LanguageHookDemoPortletKeys;

import com.liferay.portal.kernel.language.UTF8Control;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author root322
 */
@Component(
		 property = { "language.id=en_US" }, 
		 service = ResourceBundle.class
		)
public class LanguageHookDemoPortlet extends ResourceBundle {
	
	ResourceBundle bundle = ResourceBundle.getBundle("content.Language", UTF8Control.INSTANCE);

	 @Override
	 protected Object handleGetObject(String key) {
	 System.out.println("getting key"+key.toString());
	 return bundle.getObject(key);
	 }

	 @Override
	 public Enumeration<String> getKeys() {
	 return bundle.getKeys();
	 }
}