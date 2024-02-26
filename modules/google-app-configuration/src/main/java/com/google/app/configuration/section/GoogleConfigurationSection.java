package com.google.app.configuration.section;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "google-authentication-url", scope = ExtendedObjectClassDefinition.Scope.GROUP)
@Meta.OCD(id = "com.google.app.configuration.section.GoogleConfigurationSection", localization = "content/Language", name = "Google URL's Configuration")
public interface GoogleConfigurationSection {
	@Meta.AD(deflt = "[CLIENT-ID]", name = "Enter your Client ID", required = false)
	public String clientId();

	@Meta.AD(deflt = "[CLIENT-KEY]", name = "Enter your Client Key", required = false)
	public String clientKey();

	@Meta.AD(deflt = "http://localhost:8080", name = "Enter Authorized Redirect URL's", required = false)
	public String getRedirectUrl();

	@Meta.AD(deflt = "http://localhost:8080", name = "Enter Authorized Redirect URL's", required = false)
	public String getSecondRedirectUrl();
	@Meta.AD(deflt = "http://localhost:8080", name = "Enter Authorized Redirect URL's", required = false)
	public String getThirdRedirectUrl();
}