package com.sys.config.portlet;

import com.sys.config.constants.SysConfigModulePortletKeys;
import com.sys.config.file.UserEmailConfig;
import com.sys.config.file.UsersKeyContactEmailConfiguration;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author E2Software-011
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SysConfigModule", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SysConfigModulePortletKeys.SYSCONFIGMODULE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class SysConfigModulePortlet extends MVCPortlet {

	public void addEntry(ActionRequest actionRequest, ActionResponse actionResponse) {
		// TODO Auto-generated method stub

		Map<String, List<String>> keyContactCountryMap = getKeyContactRolesMap();

		for (Map.Entry<String, List<String>> entry : keyContactCountryMap.entrySet()) {
			String key = entry.getKey();
			List<String> value = entry.getValue();

			System.out.println("Key: " + key);
			System.out.println("Value: " + value);

		}

	}

	private Map<String, List<String>> getKeyContactRolesMap() {

		Map<String, List<String>> keyContactCountryMap = new LinkedHashMap<>();
		keyContactCountryMap.put("upp-emea", _configuration.getUppEmeaKeyContactEmails());
		keyContactCountryMap.put("upp-apj", _configuration.getUppApjKeyContactEmails());
		keyContactCountryMap.put("upp-na", _configuration.getUppNaKeyContactEmails());
		keyContactCountryMap.put("upp-lar", _configuration.getUppLarKeyContactEmails());

		return keyContactCountryMap;
	}
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(UsersKeyContactEmailConfiguration.class, properties);
	}

	private volatile UsersKeyContactEmailConfiguration _configuration;
}