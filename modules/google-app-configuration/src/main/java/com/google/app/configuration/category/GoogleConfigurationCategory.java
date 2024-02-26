package com.google.app.configuration.category;

import org.osgi.service.component.annotations.Component;

import com.liferay.configuration.admin.category.ConfigurationCategory;
@Component(
		service = ConfigurationCategory.class
		)
public class GoogleConfigurationCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {
		return "google-authentication-url";
	}

	@Override
	public String getCategorySection() {
		return "google-authentication-section";
	}

}