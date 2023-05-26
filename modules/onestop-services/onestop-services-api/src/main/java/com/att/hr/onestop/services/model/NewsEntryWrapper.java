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

package com.att.hr.onestop.services.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NewsEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsEntry
 * @generated
 */
public class NewsEntryWrapper
	extends BaseModelWrapper<NewsEntry>
	implements ModelWrapper<NewsEntry>, NewsEntry {

	public NewsEntryWrapper(NewsEntry newsEntry) {
		super(newsEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("newsEntryId", getNewsEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("newsTitle", getNewsTitle());
		attributes.put("newsSummary", getNewsSummary());
		attributes.put("newsContent", getNewsContent());
		attributes.put("newsImageId", getNewsImageId());
		attributes.put("newsScopeId", getNewsScopeId());
		attributes.put("archive", isArchive());
		attributes.put("allowedInDashBoard", isAllowedInDashBoard());
		attributes.put("expireDate", getExpireDate());
		attributes.put("ToEmail", getToEmail());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long newsEntryId = (Long)attributes.get("newsEntryId");

		if (newsEntryId != null) {
			setNewsEntryId(newsEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String newsTitle = (String)attributes.get("newsTitle");

		if (newsTitle != null) {
			setNewsTitle(newsTitle);
		}

		String newsSummary = (String)attributes.get("newsSummary");

		if (newsSummary != null) {
			setNewsSummary(newsSummary);
		}

		String newsContent = (String)attributes.get("newsContent");

		if (newsContent != null) {
			setNewsContent(newsContent);
		}

		Long newsImageId = (Long)attributes.get("newsImageId");

		if (newsImageId != null) {
			setNewsImageId(newsImageId);
		}

		Long newsScopeId = (Long)attributes.get("newsScopeId");

		if (newsScopeId != null) {
			setNewsScopeId(newsScopeId);
		}

		Boolean archive = (Boolean)attributes.get("archive");

		if (archive != null) {
			setArchive(archive);
		}

		Boolean allowedInDashBoard = (Boolean)attributes.get(
			"allowedInDashBoard");

		if (allowedInDashBoard != null) {
			setAllowedInDashBoard(allowedInDashBoard);
		}

		Date expireDate = (Date)attributes.get("expireDate");

		if (expireDate != null) {
			setExpireDate(expireDate);
		}

		String ToEmail = (String)attributes.get("ToEmail");

		if (ToEmail != null) {
			setToEmail(ToEmail);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public NewsEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allowed in dash board of this news entry.
	 *
	 * @return the allowed in dash board of this news entry
	 */
	@Override
	public boolean getAllowedInDashBoard() {
		return model.getAllowedInDashBoard();
	}

	/**
	 * Returns the archive of this news entry.
	 *
	 * @return the archive of this news entry
	 */
	@Override
	public boolean getArchive() {
		return model.getArchive();
	}

	/**
	 * Returns the company ID of this news entry.
	 *
	 * @return the company ID of this news entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this news entry.
	 *
	 * @return the create date of this news entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the expire date of this news entry.
	 *
	 * @return the expire date of this news entry
	 */
	@Override
	public Date getExpireDate() {
		return model.getExpireDate();
	}

	/**
	 * Returns the group ID of this news entry.
	 *
	 * @return the group ID of this news entry
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this news entry.
	 *
	 * @return the modified date of this news entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the news content of this news entry.
	 *
	 * @return the news content of this news entry
	 */
	@Override
	public String getNewsContent() {
		return model.getNewsContent();
	}

	/**
	 * Returns the news entry ID of this news entry.
	 *
	 * @return the news entry ID of this news entry
	 */
	@Override
	public long getNewsEntryId() {
		return model.getNewsEntryId();
	}

	/**
	 * Returns the news image ID of this news entry.
	 *
	 * @return the news image ID of this news entry
	 */
	@Override
	public long getNewsImageId() {
		return model.getNewsImageId();
	}

	/**
	 * Returns the news scope ID of this news entry.
	 *
	 * @return the news scope ID of this news entry
	 */
	@Override
	public long getNewsScopeId() {
		return model.getNewsScopeId();
	}

	/**
	 * Returns the news summary of this news entry.
	 *
	 * @return the news summary of this news entry
	 */
	@Override
	public String getNewsSummary() {
		return model.getNewsSummary();
	}

	/**
	 * Returns the news title of this news entry.
	 *
	 * @return the news title of this news entry
	 */
	@Override
	public String getNewsTitle() {
		return model.getNewsTitle();
	}

	/**
	 * Returns the primary key of this news entry.
	 *
	 * @return the primary key of this news entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this news entry.
	 *
	 * @return the status of this news entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this news entry.
	 *
	 * @return the status by user ID of this news entry
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this news entry.
	 *
	 * @return the status by user name of this news entry
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this news entry.
	 *
	 * @return the status by user uuid of this news entry
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this news entry.
	 *
	 * @return the status date of this news entry
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the to email of this news entry.
	 *
	 * @return the to email of this news entry
	 */
	@Override
	public String getToEmail() {
		return model.getToEmail();
	}

	/**
	 * Returns the user ID of this news entry.
	 *
	 * @return the user ID of this news entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this news entry.
	 *
	 * @return the user uuid of this news entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this news entry is allowed in dash board.
	 *
	 * @return <code>true</code> if this news entry is allowed in dash board; <code>false</code> otherwise
	 */
	@Override
	public boolean isAllowedInDashBoard() {
		return model.isAllowedInDashBoard();
	}

	/**
	 * Returns <code>true</code> if this news entry is approved.
	 *
	 * @return <code>true</code> if this news entry is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this news entry is archive.
	 *
	 * @return <code>true</code> if this news entry is archive; <code>false</code> otherwise
	 */
	@Override
	public boolean isArchive() {
		return model.isArchive();
	}

	/**
	 * Returns <code>true</code> if this news entry is denied.
	 *
	 * @return <code>true</code> if this news entry is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this news entry is a draft.
	 *
	 * @return <code>true</code> if this news entry is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this news entry is expired.
	 *
	 * @return <code>true</code> if this news entry is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this news entry is inactive.
	 *
	 * @return <code>true</code> if this news entry is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this news entry is incomplete.
	 *
	 * @return <code>true</code> if this news entry is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this news entry is pending.
	 *
	 * @return <code>true</code> if this news entry is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this news entry is scheduled.
	 *
	 * @return <code>true</code> if this news entry is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this news entry is allowed in dash board.
	 *
	 * @param allowedInDashBoard the allowed in dash board of this news entry
	 */
	@Override
	public void setAllowedInDashBoard(boolean allowedInDashBoard) {
		model.setAllowedInDashBoard(allowedInDashBoard);
	}

	/**
	 * Sets whether this news entry is archive.
	 *
	 * @param archive the archive of this news entry
	 */
	@Override
	public void setArchive(boolean archive) {
		model.setArchive(archive);
	}

	/**
	 * Sets the company ID of this news entry.
	 *
	 * @param companyId the company ID of this news entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this news entry.
	 *
	 * @param createDate the create date of this news entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the expire date of this news entry.
	 *
	 * @param expireDate the expire date of this news entry
	 */
	@Override
	public void setExpireDate(Date expireDate) {
		model.setExpireDate(expireDate);
	}

	/**
	 * Sets the group ID of this news entry.
	 *
	 * @param groupId the group ID of this news entry
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this news entry.
	 *
	 * @param modifiedDate the modified date of this news entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the news content of this news entry.
	 *
	 * @param newsContent the news content of this news entry
	 */
	@Override
	public void setNewsContent(String newsContent) {
		model.setNewsContent(newsContent);
	}

	/**
	 * Sets the news entry ID of this news entry.
	 *
	 * @param newsEntryId the news entry ID of this news entry
	 */
	@Override
	public void setNewsEntryId(long newsEntryId) {
		model.setNewsEntryId(newsEntryId);
	}

	/**
	 * Sets the news image ID of this news entry.
	 *
	 * @param newsImageId the news image ID of this news entry
	 */
	@Override
	public void setNewsImageId(long newsImageId) {
		model.setNewsImageId(newsImageId);
	}

	/**
	 * Sets the news scope ID of this news entry.
	 *
	 * @param newsScopeId the news scope ID of this news entry
	 */
	@Override
	public void setNewsScopeId(long newsScopeId) {
		model.setNewsScopeId(newsScopeId);
	}

	/**
	 * Sets the news summary of this news entry.
	 *
	 * @param newsSummary the news summary of this news entry
	 */
	@Override
	public void setNewsSummary(String newsSummary) {
		model.setNewsSummary(newsSummary);
	}

	/**
	 * Sets the news title of this news entry.
	 *
	 * @param newsTitle the news title of this news entry
	 */
	@Override
	public void setNewsTitle(String newsTitle) {
		model.setNewsTitle(newsTitle);
	}

	/**
	 * Sets the primary key of this news entry.
	 *
	 * @param primaryKey the primary key of this news entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this news entry.
	 *
	 * @param status the status of this news entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this news entry.
	 *
	 * @param statusByUserId the status by user ID of this news entry
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this news entry.
	 *
	 * @param statusByUserName the status by user name of this news entry
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this news entry.
	 *
	 * @param statusByUserUuid the status by user uuid of this news entry
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this news entry.
	 *
	 * @param statusDate the status date of this news entry
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the to email of this news entry.
	 *
	 * @param ToEmail the to email of this news entry
	 */
	@Override
	public void setToEmail(String ToEmail) {
		model.setToEmail(ToEmail);
	}

	/**
	 * Sets the user ID of this news entry.
	 *
	 * @param userId the user ID of this news entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this news entry.
	 *
	 * @param userUuid the user uuid of this news entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected NewsEntryWrapper wrap(NewsEntry newsEntry) {
		return new NewsEntryWrapper(newsEntry);
	}

}