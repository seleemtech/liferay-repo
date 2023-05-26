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

package com.prime.data.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.prime.data.service.model.NamePrefix;
import com.prime.data.service.service.NamePrefixLocalServiceUtil;
import com.prime.data.service.service.base.NamePrefixLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.prime.data.service.model.NamePrefix",
	service = AopService.class
)
public class NamePrefixLocalServiceImpl extends NamePrefixLocalServiceBaseImpl {
	public void addNamePrefix(String namePrefix) {
		NamePrefix prefix = NamePrefixLocalServiceUtil.createNamePrefix(0);
		prefix.setNamePrefix(namePrefix);
		NamePrefixLocalServiceUtil.addNamePrefix(prefix);
	}
}