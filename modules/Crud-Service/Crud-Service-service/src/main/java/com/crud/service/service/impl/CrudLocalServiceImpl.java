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

import com.crud.service.exception.NoSuchCrudException;
import com.crud.service.model.Crud;
import com.crud.service.service.base.CrudLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.crud.service.model.Crud",
	service = AopService.class
)
public class CrudLocalServiceImpl extends CrudLocalServiceBaseImpl {
	public Crud addData(String crudName,long crudNo) {
		long crudId=counterLocalService.increment();
		Crud crd=crudPersistence.create(crudId);
		crd.setCrudName(crudName);
		crd.setCrudNo(crudNo);
		crudPersistence.update(crd);
		return crd;
		
	}
	public Crud updateData(long crudId,String crudName,long crudNo) {
	
		Crud crd=crudPersistence.fetchByPrimaryKey(crudId);
		crd.setCrudName(crudName);
		crd.setCrudNo(crudNo);
		crudPersistence.update(crd);
		return crd;
	}
	
	public Crud deleteData(long crudId) throws NoSuchCrudException {
		return crudPersistence.remove(crudId);
		
	}
	
	public List<Crud> findByName(String crudName){
		return crudPersistence.findByCrudName(crudName);
	}
	public List<Crud> getByCrudNameAndCrudNo(String crudName,long crudNo){
		return crudFinder.getByCrudNameAndCrudNo(crudName, crudNo);
	}
	
	public List<Crud> getByCrudId(long crudId){
		return crudPersistence.findByCrudId(crudId);
	}
}