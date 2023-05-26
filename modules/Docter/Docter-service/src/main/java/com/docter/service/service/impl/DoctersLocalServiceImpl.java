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

package com.docter.service.service.impl;

import com.docter.service.model.Docters;
import com.docter.service.service.base.DoctersLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.docter.service.model.Docters", service = AopService.class)
public class DoctersLocalServiceImpl extends DoctersLocalServiceBaseImpl {

	public Docters updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext)
			throws PortalException {
		System.out.println("coming to doc update status userId" + userId);
		System.out.println("coming to update status resourcePrimKey" + resourcePrimKey);
		System.out.println("coming to update status status" + status);
		User user = userLocalService.getUser(userId);
		Docters docter = doctersLocalService.getDocters(resourcePrimKey);
		docter.setStatusByUserId(userId);
		docter.setStatusByUserName(user.getFullName());
		docter.setStatus(status);
		docter.setStatusDate(serviceContext.getModifiedDate());
		doctersPersistence.update(docter);
		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(Docters.class.getName(), resourcePrimKey, true);
		} else {
			assetEntryLocalService.updateVisible(Docters.class.getName(), resourcePrimKey, false);
		}
		return docter;

	}

	public Docters updatedocter(long docterId, String docterName, ServiceContext serviceContext)
			throws PortalException {
		docterId = counterLocalService.increment();
		Docters docter = doctersPersistence.create(docterId);

		// TODO: handle exception
		try {
			docter.setDocterName(docterName);
			docter.setGroupId(serviceContext.getScopeGroupId());
			docter.setCompanyId(serviceContext.getCompanyId());
			docter.setUserId(serviceContext.getUserId());
			docter.setCreateDate(new Date());

			doctersPersistence.update(docter);
			assetEntryLocalService.updateEntry(serviceContext.getUserId(), docter.getGroupId(), Docters.class.getName(),
					docter.getDocterId(), serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());

			Indexer<Docters> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Docters.class);
			indexer.reindex(docter);
			assetEntryLocalService.updateVisible(Docters.class.getName(), docter.getDocterId(), true);

			WorkflowHandlerRegistryUtil.startWorkflowInstance(docter.getCompanyId(), docter.getGroupId(),
					docter.getUserId(), Docters.class.getName(), docter.getPrimaryKey(), docter, serviceContext);
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		return docter;
	}
}