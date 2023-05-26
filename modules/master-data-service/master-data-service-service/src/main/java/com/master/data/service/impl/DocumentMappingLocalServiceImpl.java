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

package com.master.data.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.master.data.exception.NoSuchDocumentMappingException;
import com.master.data.model.DocumentMapping;
import com.master.data.service.base.DocumentMappingLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.master.data.model.DocumentMapping",
	service = AopService.class
)
public class DocumentMappingLocalServiceImpl
	extends DocumentMappingLocalServiceBaseImpl {
	public DocumentMapping AddorUpdateDocument(long recordId, String moduleName, long classPk, String documentName, long documentId, ServiceContext serviceContext) {
		DocumentMapping documentMapping=null;
		System.out.println("update method in service impl");
		try {
			documentMapping=documentMappingPersistence.findByPrimaryKey(recordId);
		
		documentMapping.setModuleName(moduleName);
		documentMapping.setClassPk(classPk);
		documentMapping.setDocumentName(documentName);
		documentMapping.setDocumentId(documentId);
		documentMapping.setUserId(serviceContext.getUserId());
		documentMapping.setCreatedDate(serviceContext.getCreateDate());
		documentMappingPersistence.update(documentMapping);
		} catch (NoSuchDocumentMappingException e) {
			System.out.println("add method in service");
			recordId=counterLocalService.increment();
			documentMapping=documentMappingPersistence.create(recordId);
			documentMapping.setModuleName(moduleName);
			documentMapping.setClassPk(classPk);
			documentMapping.setDocumentName(documentName);
			documentMapping.setDocumentId(documentId);
			documentMapping.setUserId(serviceContext.getUserId());
			documentMapping.setModifiedDate(serviceContext.getModifiedDate());
			documentMappingPersistence.update(documentMapping);
		}
		return documentMapping;
		
	}
}