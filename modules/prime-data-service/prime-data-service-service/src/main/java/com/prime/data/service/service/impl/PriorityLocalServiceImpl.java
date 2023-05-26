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

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.prime.data.service.model.Priority;
import com.prime.data.service.service.PriorityLocalServiceUtil;
import com.prime.data.service.service.base.PriorityLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.prime.data.service.model.Priority",
	service = AopService.class
)
public class PriorityLocalServiceImpl extends PriorityLocalServiceBaseImpl {
	public void addPriority(String priorityName) {
		Priority priority = PriorityLocalServiceUtil.createPriority(0);
		priority.setPriorityName(priorityName);
		PriorityLocalServiceUtil.addPriority(priority);
	}
}