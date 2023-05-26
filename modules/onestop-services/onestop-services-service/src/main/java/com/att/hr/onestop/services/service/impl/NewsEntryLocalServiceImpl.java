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

package com.att.hr.onestop.services.service.impl;

import com.att.hr.onestop.services.exception.NoSuchNewsEntryException;
import com.att.hr.onestop.services.model.NewsEntry;
import com.att.hr.onestop.services.service.base.NewsEntryLocalServiceBaseImpl;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowInstanceLink;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalService;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.*;
import org.osgi.service.component.annotations.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=com.att.hr.onestop.services.model.NewsEntry", service = AopService.class)
public class NewsEntryLocalServiceImpl extends NewsEntryLocalServiceBaseImpl {
	public NewsEntry updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext)
			throws PortalException, SystemException {
		System.out.println("coming to update status userId" + userId);
		System.out.println("coming to update status resourcePrimKey" + resourcePrimKey);
		System.out.println("coming to update status status" + status);
		// Group scopeGroup = serviceContext.getScopeGroup();
		// boolean isStagged = scopeGroup.isStaged();

		User user = userLocalService.getUser(userId);
		NewsEntry newsEntry = getNewsEntry(resourcePrimKey);
		newsEntry.setStatus(status);
		newsEntry.setStatusByUserId(userId);
		newsEntry.setStatusByUserName(user.getFullName());
		newsEntry.setStatusDate(serviceContext.getModifiedDate());

		/*
		 * if (status == WorkflowConstants.STATUS_APPROVED && isStagged) {
		 * newsEntry.setGroupId(scopeGroup.getLiveGroupId()); }
		 */
		if(status==WorkflowConstants.STATUS_APPROVED) {
			InternetAddress to=new InternetAddress();
			InternetAddress from=new InternetAddress();
			to.setAddress(newsEntry.getToEmail());
			from.setAddress(user.getEmailAddress());
			System.out.println("from mail"+from);
			System.out.println("to mail"+to);
			MailMessage mail=new MailMessage();
			mail.setFrom(from);
			mail.setBody("News Email sent Successfully");
			mail.setTo(to);
			MailServiceUtil.sendEmail(mail);
		}
		newsEntryPersistence.update(newsEntry);

		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(NewsEntry.class.getName(), resourcePrimKey, true);
		} else {
			assetEntryLocalService.updateVisible(NewsEntry.class.getName(), resourcePrimKey, false);
		}

		return newsEntry;
	}

	public NewsEntry updateNewsEntry(long newsEntryId, String newsTitle, String newsSummary, String newsContent,
			long newsImageId, long newsScopeId, Date expireDate, boolean archive, boolean isApproved,
			boolean isAllowedInDashBoard, String ToEmail, ServiceContext serviceContext)
			throws SystemException, PortalException {

		NewsEntry newsEntry = null;
		Group scopeGroup = serviceContext.getScopeGroup();
		boolean isStagged = scopeGroup.isStaged() && scopeGroup.isStagingGroup();
		try {
			newsEntry = newsEntryPersistence.findByPrimaryKey(newsEntryId);
			newsEntry.setModifiedDate(new Date());
		} catch (NoSuchNewsEntryException e) {
			newsEntryId = counterLocalService.increment();
			newsEntry = newsEntryPersistence.create(newsEntryId);
			newsEntry.setCreateDate(new Date());
			newsEntry.setCompanyId(serviceContext.getCompanyId());
			newsEntry.setGroupId(serviceContext.getScopeGroupId());
		}
		if (isStagged) {
			if ((newsEntry.getGroupId() != serviceContext.getScopeGroupId()) && newsEntry.getNewsScopeId() != 0) {
				// stagging group and layout is belong to live site
				Layout liveLayout = LayoutLocalServiceUtil.getLayout(newsScopeId);
				Layout stagingLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(serviceContext.getScopeGroupId(),
						liveLayout.isPrivateLayout(), liveLayout.getFriendlyURL());
				newsEntry.setNewsScopeId(stagingLayout.getPlid());
			} else {
				newsEntry.setNewsScopeId(newsScopeId);
			}
			newsEntry.setGroupId(serviceContext.getScopeGroupId());

		} else {
			newsEntry.setNewsScopeId(newsScopeId);
		}

		newsEntry.setUserId(serviceContext.getUserId());
		newsEntry.setNewsTitle(newsTitle);
		newsEntry.setNewsSummary(newsSummary);
		newsEntry.setNewsContent(newsContent);
		newsEntry.setNewsImageId(newsImageId);
		newsEntry.setToEmail(ToEmail);
		newsEntry.setArchive(archive);
		newsEntry.setAllowedInDashBoard(isAllowedInDashBoard);
		if (Validator.isNotNull(expireDate)) {
			newsEntry.setExpireDate(expireDate);
		}
		if (isApproved) {
			newsEntry.setStatus(WorkflowConstants.STATUS_APPROVED);
		} else {
			newsEntry.setStatus(WorkflowConstants.STATUS_PENDING);
		}
		newsEntryPersistence.update(newsEntry);
		assetEntryLocalService.updateEntry(serviceContext.getUserId(), newsEntry.getGroupId(),
				NewsEntry.class.getName(), newsEntry.getNewsEntryId(), serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());

		Indexer<NewsEntry> indexer = IndexerRegistryUtil.nullSafeGetIndexer(NewsEntry.class);
		indexer.reindex(newsEntry);

		if (isApproved) {
			assetEntryLocalService.updateVisible(NewsEntry.class.getName(), newsEntry.getNewsEntryId(), true);

		} else {
			assetEntryLocalService.updateVisible(NewsEntry.class.getName(), newsEntry.getNewsEntryId(), false);
			serviceContext.setAttribute("newsScopeId", String.valueOf(newsEntry.getNewsScopeId()));
			if (newsEntry.isPending()) {
				WorkflowInstanceLink workflowInstanceLink = WorkflowInstanceLinkLocalServiceUtil
						.fetchWorkflowInstanceLink(newsEntry.getCompanyId(), newsEntry.getGroupId(),
								NewsEntry.class.getName(), newsEntry.getNewsEntryId());
				if (workflowInstanceLink != null) {
					long workflowInstanceId = workflowInstanceLink.getWorkflowInstanceId();
					WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil
							.getWorkflowInstance(serviceContext.getCompanyId(), workflowInstanceId);

					if (!workflowInstance.isComplete()) {
						Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();
						ServiceContext serviceContext1 = (ServiceContext) workflowContext
								.get(WorkflowConstants.CONTEXT_SERVICE_CONTEXT);
						serviceContext1.setAttribute("newsScopeId", String.valueOf(newsEntry.getNewsScopeId()));
						workflowContext.put(WorkflowConstants.CONTEXT_SERVICE_CONTEXT, serviceContext1);
						WorkflowInstanceManagerUtil.updateWorkflowContext(newsEntry.getCompanyId(), workflowInstanceId,
								workflowContext);
					}
				}
			}

			WorkflowHandler a = null;

			WorkflowHandlerRegistryUtil.startWorkflowInstance(newsEntry.getCompanyId(), newsEntry.getGroupId(),
					newsEntry.getUserId(), NewsEntry.class.getName(), newsEntry.getPrimaryKey(), newsEntry,
					serviceContext);
		}

		return newsEntry;
	}

	public List<NewsEntry> getNewsEntryByStatus(long groupId, int status) {
		return newsEntryPersistence.findByG_S(groupId, status);

	}

	public List<NewsEntry> getNewsEntryByGroupId(long groupId) {
		System.out.println("newsEntryPersistence-->" + Validator.isNull(newsEntryPersistence) + "groupId-->" + groupId);
		return newsEntryPersistence.findByGroupId(groupId);
	}

	public NewsEntry publishToLive(long newsEntryId, ServiceContext serviceContext) throws PortalException {
		NewsEntry newsEntry = getNewsEntry(newsEntryId);
		Group scopeGroup = serviceContext.getScopeGroup();
		boolean isStagged = scopeGroup.isStaged() && scopeGroup.isStagingGroup();
		if (newsEntry.getStatus() == WorkflowConstants.STATUS_APPROVED && isStagged) {
			if (newsEntry.getNewsScopeId() > 0) {
				Layout stagingLayout = LayoutLocalServiceUtil.getLayout(newsEntry.getNewsScopeId());
				Layout liveLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(scopeGroup.getLiveGroupId(),
						stagingLayout.isPrivateLayout(), stagingLayout.getFriendlyURL());
				newsEntry.setNewsScopeId(liveLayout.getPlid());
			}

			newsEntry.setGroupId(scopeGroup.getLiveGroupId());
			newsEntryPersistence.update(newsEntry);
		}
		return newsEntry;

	}

	public NewsEntry deleteNewsEntryById(long newsEntryId) throws SystemException, PortalException {

		NewsEntry newsEntry = newsEntryPersistence.findByPrimaryKey(newsEntryId);

		newsEntry = deleteEntry(newsEntry);

		return newsEntry;
	}

	public void deleteNewsEntryByPillarLayout(long plId) {
		List<NewsEntry> newsEntries = newsEntryPersistence.findByNewsScopeId(plId);
		for (NewsEntry newEntry : newsEntries) {
			try {
				deleteEntry(newEntry);
			} catch (PortalException portalException) {

			}
		}
	}

	public NewsEntry deleteEntry(NewsEntry newsEntry) throws PortalException {
		assetEntryLocalService.deleteEntry(NewsEntry.class.getName(), newsEntry.getNewsEntryId());

		Indexer<NewsEntry> indexer = IndexerRegistryUtil.nullSafeGetIndexer(NewsEntry.class);
		indexer.delete(newsEntry);

		workflowInstanceLinkLocalService.deleteWorkflowInstanceLink(newsEntry.getCompanyId(), newsEntry.getGroupId(),
				NewsEntry.class.getName(), newsEntry.getNewsEntryId());

		newsEntryPersistence.remove(newsEntry);
		return newsEntry;
	}

	public void deleteEntries(long groupId) throws PortalException {
		for (NewsEntry entry : newsEntryPersistence.findByGroupId(groupId)) {
			newsEntryLocalService.deleteEntry(entry);
		}
	}

	public NewsEntry toggleArchiveNewsEntry(long newsEntryId, boolean archive) throws SystemException, PortalException {

		NewsEntry newsEntry = newsEntryPersistence.findByPrimaryKey(newsEntryId);
		newsEntry.setArchive(archive);
		newsEntryPersistence.update(newsEntry);

		if (archive) {
			assetEntryLocalService.updateVisible(NewsEntry.class.getName(), newsEntry.getNewsEntryId(), false);

		} else {
			assetEntryLocalService.updateVisible(NewsEntry.class.getName(), newsEntry.getNewsEntryId(), true);
		}
		return newsEntry;
	}

	/*
	 * public List<NewsEntry> findByExpirationDate(long companyId, long groupId,
	 * long newsScopeId, int status, boolean archive, Date expirationDateLT) throws
	 * SystemException { return newsEntryFinder.findByExpirationDate(companyId,
	 * groupId, newsScopeId, status, archive, expirationDateLT); }
	 * 
	 * public List<NewsEntry> findDashBoardNewsByExpirationDate(long companyId, long
	 * groupId, long newsScopeId, int status, boolean archive, boolean
	 * allowedInDashboard, Date expirationDateLT) throws SystemException { return
	 * newsEntryFinder.findDashBoardNewsByExpirationDate(companyId, groupId,
	 * newsScopeId, status, archive, allowedInDashboard, expirationDateLT); }
	 * 
	 * public List<NewsEntry> findHomePageNewsByExpirationDate(long companyId, long
	 * groupId, int status, boolean archive, boolean allowedInDashboard, Date
	 * expirationDateLT) throws SystemException { return
	 * newsEntryFinder.findHomePageNewsByExpirationDate(companyId, groupId, status,
	 * archive, allowedInDashboard, expirationDateLT); }
	 */

}