/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rigistration.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.rigistration.service.model.Register;
import com.rigistration.service.service.base.RegisterLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.rigistration.service.model.Register",
	service = AopService.class
)
public class RegisterLocalServiceImpl extends RegisterLocalServiceBaseImpl {
	public Register addData(long phone,String firstName,String userName,String password) {
		long registerId=counterLocalService.increment();
		Register _register=registerPersistence.create(registerId);
		_register.setPhone(phone);
		_register.setFirstName(firstName);
		_register.setUserName(userName);
		_register.setPassword(password);
		registerPersistence.update(_register);
		return _register;
		
	}
}