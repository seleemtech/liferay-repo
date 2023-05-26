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

package com.crud.service.service.impl;

import com.crud.service.model.Crud;
import com.crud.service.service.CrudLocalService;
import com.crud.service.service.CrudLocalServiceUtil;
import com.crud.service.service.base.CrudServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=foo",
		"json.web.service.context.path=Crud"
	},
	service = AopService.class
)
public class CrudServiceImpl extends CrudServiceBaseImpl {
	public List<Crud> getByCrudList(long crudId) {
		return crudPersistence.findAll(-1, -1);
		
	}
	@Reference
	private CrudLocalService _crudLocalService;
}

