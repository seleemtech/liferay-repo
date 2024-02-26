/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model.impl;

import api.master.slayer.model.MasterUrl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MasterUrl in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MasterUrlCacheModel
	implements CacheModel<MasterUrl>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MasterUrlCacheModel)) {
			return false;
		}

		MasterUrlCacheModel masterUrlCacheModel = (MasterUrlCacheModel)object;

		if (masterUrlId == masterUrlCacheModel.masterUrlId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, masterUrlId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", masterUrlId=");
		sb.append(masterUrlId);
		sb.append(", appName=");
		sb.append(appName);
		sb.append(", baseUrl=");
		sb.append(baseUrl);
		sb.append(", svgIcon=");
		sb.append(svgIcon);
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
	public MasterUrl toEntityModel() {
		MasterUrlImpl masterUrlImpl = new MasterUrlImpl();

		if (uuid == null) {
			masterUrlImpl.setUuid("");
		}
		else {
			masterUrlImpl.setUuid(uuid);
		}

		masterUrlImpl.setMasterUrlId(masterUrlId);

		if (appName == null) {
			masterUrlImpl.setAppName("");
		}
		else {
			masterUrlImpl.setAppName(appName);
		}

		if (baseUrl == null) {
			masterUrlImpl.setBaseUrl("");
		}
		else {
			masterUrlImpl.setBaseUrl(baseUrl);
		}

		if (svgIcon == null) {
			masterUrlImpl.setSvgIcon("");
		}
		else {
			masterUrlImpl.setSvgIcon(svgIcon);
		}

		masterUrlImpl.setUserId(userId);
		masterUrlImpl.setGroupId(groupId);
		masterUrlImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			masterUrlImpl.setCreateDate(null);
		}
		else {
			masterUrlImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			masterUrlImpl.setModifiedDate(null);
		}
		else {
			masterUrlImpl.setModifiedDate(new Date(modifiedDate));
		}

		masterUrlImpl.resetOriginalValues();

		return masterUrlImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		masterUrlId = objectInput.readLong();
		appName = objectInput.readUTF();
		baseUrl = objectInput.readUTF();
		svgIcon = objectInput.readUTF();

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

		objectOutput.writeLong(masterUrlId);

		if (appName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appName);
		}

		if (baseUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(baseUrl);
		}

		if (svgIcon == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(svgIcon);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long masterUrlId;
	public String appName;
	public String baseUrl;
	public String svgIcon;
	public long userId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;

}