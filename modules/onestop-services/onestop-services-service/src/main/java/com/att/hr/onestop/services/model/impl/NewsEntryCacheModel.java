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

package com.att.hr.onestop.services.model.impl;

import com.att.hr.onestop.services.model.NewsEntry;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NewsEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NewsEntryCacheModel
	implements CacheModel<NewsEntry>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NewsEntryCacheModel)) {
			return false;
		}

		NewsEntryCacheModel newsEntryCacheModel = (NewsEntryCacheModel)object;

		if (newsEntryId == newsEntryCacheModel.newsEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, newsEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{newsEntryId=");
		sb.append(newsEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", newsTitle=");
		sb.append(newsTitle);
		sb.append(", newsSummary=");
		sb.append(newsSummary);
		sb.append(", newsContent=");
		sb.append(newsContent);
		sb.append(", newsImageId=");
		sb.append(newsImageId);
		sb.append(", newsScopeId=");
		sb.append(newsScopeId);
		sb.append(", archive=");
		sb.append(archive);
		sb.append(", allowedInDashBoard=");
		sb.append(allowedInDashBoard);
		sb.append(", expireDate=");
		sb.append(expireDate);
		sb.append(", ToEmail=");
		sb.append(ToEmail);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NewsEntry toEntityModel() {
		NewsEntryImpl newsEntryImpl = new NewsEntryImpl();

		newsEntryImpl.setNewsEntryId(newsEntryId);
		newsEntryImpl.setGroupId(groupId);
		newsEntryImpl.setCompanyId(companyId);
		newsEntryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			newsEntryImpl.setCreateDate(null);
		}
		else {
			newsEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			newsEntryImpl.setModifiedDate(null);
		}
		else {
			newsEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (newsTitle == null) {
			newsEntryImpl.setNewsTitle("");
		}
		else {
			newsEntryImpl.setNewsTitle(newsTitle);
		}

		if (newsSummary == null) {
			newsEntryImpl.setNewsSummary("");
		}
		else {
			newsEntryImpl.setNewsSummary(newsSummary);
		}

		if (newsContent == null) {
			newsEntryImpl.setNewsContent("");
		}
		else {
			newsEntryImpl.setNewsContent(newsContent);
		}

		newsEntryImpl.setNewsImageId(newsImageId);
		newsEntryImpl.setNewsScopeId(newsScopeId);
		newsEntryImpl.setArchive(archive);
		newsEntryImpl.setAllowedInDashBoard(allowedInDashBoard);

		if (expireDate == Long.MIN_VALUE) {
			newsEntryImpl.setExpireDate(null);
		}
		else {
			newsEntryImpl.setExpireDate(new Date(expireDate));
		}

		if (ToEmail == null) {
			newsEntryImpl.setToEmail("");
		}
		else {
			newsEntryImpl.setToEmail(ToEmail);
		}

		newsEntryImpl.setStatus(status);
		newsEntryImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			newsEntryImpl.setStatusByUserName("");
		}
		else {
			newsEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			newsEntryImpl.setStatusDate(null);
		}
		else {
			newsEntryImpl.setStatusDate(new Date(statusDate));
		}

		newsEntryImpl.resetOriginalValues();

		return newsEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		newsEntryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		newsTitle = objectInput.readUTF();
		newsSummary = objectInput.readUTF();
		newsContent = objectInput.readUTF();

		newsImageId = objectInput.readLong();

		newsScopeId = objectInput.readLong();

		archive = objectInput.readBoolean();

		allowedInDashBoard = objectInput.readBoolean();
		expireDate = objectInput.readLong();
		ToEmail = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(newsEntryId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (newsTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(newsTitle);
		}

		if (newsSummary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(newsSummary);
		}

		if (newsContent == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(newsContent);
		}

		objectOutput.writeLong(newsImageId);

		objectOutput.writeLong(newsScopeId);

		objectOutput.writeBoolean(archive);

		objectOutput.writeBoolean(allowedInDashBoard);
		objectOutput.writeLong(expireDate);

		if (ToEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ToEmail);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long newsEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String newsTitle;
	public String newsSummary;
	public String newsContent;
	public long newsImageId;
	public long newsScopeId;
	public boolean archive;
	public boolean allowedInDashBoard;
	public long expireDate;
	public String ToEmail;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;

}