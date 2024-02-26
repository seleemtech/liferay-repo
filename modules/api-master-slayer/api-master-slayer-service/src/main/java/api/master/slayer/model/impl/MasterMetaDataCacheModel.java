/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model.impl;

import api.master.slayer.model.MasterMetaData;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterMetaData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MasterMetaDataCacheModel
	implements CacheModel<MasterMetaData>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterMetaDataCacheModel)) {
			return false;
		}

		MasterMetaDataCacheModel masterMetaDataCacheModel =
			(MasterMetaDataCacheModel)object;

		if (mmdId == masterMetaDataCacheModel.mmdId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, mmdId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", mmdId=");
		sb.append(mmdId);
		sb.append(", masterUrlId=");
		sb.append(masterUrlId);
		sb.append(", appSubUrl=");
		sb.append(appSubUrl);
		sb.append(", httpMethod=");
		sb.append(httpMethod);
		sb.append(", httpMethodName=");
		sb.append(httpMethodName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MasterMetaData toEntityModel() {
		MasterMetaDataImpl masterMetaDataImpl = new MasterMetaDataImpl();

		if (uuid == null) {
			masterMetaDataImpl.setUuid("");
		}
		else {
			masterMetaDataImpl.setUuid(uuid);
		}

		masterMetaDataImpl.setMmdId(mmdId);
		masterMetaDataImpl.setMasterUrlId(masterUrlId);

		if (appSubUrl == null) {
			masterMetaDataImpl.setAppSubUrl("");
		}
		else {
			masterMetaDataImpl.setAppSubUrl(appSubUrl);
		}

		if (httpMethod == null) {
			masterMetaDataImpl.setHttpMethod("");
		}
		else {
			masterMetaDataImpl.setHttpMethod(httpMethod);
		}

		if (httpMethodName == null) {
			masterMetaDataImpl.setHttpMethodName("");
		}
		else {
			masterMetaDataImpl.setHttpMethodName(httpMethodName);
		}

		masterMetaDataImpl.setUserId(userId);
		masterMetaDataImpl.setGroupId(groupId);
		masterMetaDataImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			masterMetaDataImpl.setCreateDate(null);
		}
		else {
			masterMetaDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterMetaDataImpl.setModifiedDate(null);
		}
		else {
			masterMetaDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		masterMetaDataImpl.resetOriginalValues();

		return masterMetaDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		mmdId = objectInput.readLong();

		masterUrlId = objectInput.readLong();
		appSubUrl = objectInput.readUTF();
		httpMethod = objectInput.readUTF();
		httpMethodName = objectInput.readUTF();

		userId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(mmdId);

		objectOutput.writeLong(masterUrlId);

		if (appSubUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appSubUrl);
		}

		if (httpMethod == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(httpMethod);
		}

		if (httpMethodName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(httpMethodName);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long mmdId;
	public long masterUrlId;
	public String appSubUrl;
	public String httpMethod;
	public String httpMethodName;
	public long userId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;

}