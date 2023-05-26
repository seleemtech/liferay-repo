package com.rms.language.bundle;

import com.liferay.portal.kernel.language.UTF8Control;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class EnglishResourceBundle extends ResourceBundle {

	@Override
	protected Object handleGetObject(String key) {
		// TODO Auto-generated method stub
		return _resourceBundle.getObject(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return _resourceBundle.getKeys();
	}
	private final ResourceBundle _resourceBundle = ResourceBundle.getBundle("content.Language_en_US", UTF8Control.INSTANCE);
}
