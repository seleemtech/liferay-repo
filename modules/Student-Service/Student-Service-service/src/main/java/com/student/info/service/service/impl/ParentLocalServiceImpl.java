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

package com.student.info.service.service.impl;

import com.liferay.portal.aop.AopService;
import com.student.info.service.model.Parent;
import com.student.info.service.service.base.ParentLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.student.info.service.model.Parent",
	service = AopService.class
)
public class ParentLocalServiceImpl extends ParentLocalServiceBaseImpl {
	public Parent addParent(long parentId,String parentName,long parentContact,long companyId) {
		Parent parent=parentPersistence.create(parentId);
		parent.setParentName(parentName);
		parent.setParentContact(parentContact);
		parent.setCompanyId(companyId);
		parentPersistence.update(parent);
		
		return parent;
		
	}
	public Parent updateParent(long parentId,String parentName,long parentContact) {
		Parent parent=parentPersistence.fetchByPrimaryKey(parentId);
		parent.setParentName(parentName);
		parent.setParentContact(parentContact);
		parentPersistence.update(parent);
		
		return parent;
		
	}
}