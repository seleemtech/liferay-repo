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
import com.prime.data.service.model.WorkType;
import com.prime.data.service.service.WorkTypeLocalServiceUtil;
import com.prime.data.service.service.base.WorkTypeLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.prime.data.service.model.WorkType",
	service = AopService.class
)
public class WorkTypeLocalServiceImpl extends WorkTypeLocalServiceBaseImpl {
	public void addWorkType(String workTypeName) {
		WorkType workType = WorkTypeLocalServiceUtil.createWorkType(0);
		workType.setWorkTypeName(workTypeName);
		WorkTypeLocalServiceUtil.addWorkType(workType);
	}
}