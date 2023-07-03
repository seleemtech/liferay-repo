package com.sys.config.file;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.HashMapDictionaryBuilder;

import java.util.Dictionary;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;



@Component(configurationPid = "com.sys.config.file.UsersKeyContactEmailConfiguration",
service = UserEmailConfig.class)
public class UserEmailConfig {

	private volatile UsersKeyContactEmailConfiguration _configuration;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_configuration = ConfigurableUtil.createConfigurable(UsersKeyContactEmailConfiguration.class,
				properties);
		
		
	}

	public Map<String, List<String>> getKeyContactRolesMap() {
		Map<String, List<String>> keyContactCountryMap = new LinkedHashMap<>();
		keyContactCountryMap.put("upp-emea", _configuration.getUppEmeaKeyContactEmails());
		keyContactCountryMap.put("upp-apj", _configuration.getUppApjKeyContactEmails());
		keyContactCountryMap.put("upp-na", _configuration.getUppNaKeyContactEmails());
		keyContactCountryMap.put("upp-lar", _configuration.getUppLarKeyContactEmails());

		return keyContactCountryMap;
	}

			
}

