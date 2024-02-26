package com.google.app.configuration.activator;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.google.app.configuration.section.GoogleConfigurationSection;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.configuration.module.configuration.ConfigurationProvider;
import com.liferay.portal.spring.extender.service.ServiceReference;

@Component(immediate = true, service = GoogleConfigurationActivator.class)
public class GoogleConfigurationActivator {
	@Reference
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		_configurationProvider = configurationProvider;
	}

	@ServiceReference(type = ConfigurationProvider.class)
	protected ConfigurationProvider _configurationProvider;
	private volatile GoogleConfigurationSection _googleConfigurationSection;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_googleConfigurationSection = ConfigurableUtil.createConfigurable(GoogleConfigurationSection.class, properties);
	}
}