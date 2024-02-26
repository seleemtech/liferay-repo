/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model.impl;

import api.master.slayer.model.ConnectedAccounts;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ConnectedAccounts in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConnectedAccountsCacheModel
	implements CacheModel<ConnectedAccounts>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConnectedAccountsCacheModel)) {
			return false;
		}

		ConnectedAccountsCacheModel connectedAccountsCacheModel =
			(ConnectedAccountsCacheModel)object;

		if (c_accountId == connectedAccountsCacheModel.c_accountId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, c_accountId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", c_accountId=");
		sb.append(c_accountId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", appName=");
		sb.append(appName);
		sb.append(", refreshToken=");
		sb.append(refreshToken);
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
	public ConnectedAccounts toEntityModel() {
		ConnectedAccountsImpl connectedAccountsImpl =
			new ConnectedAccountsImpl();

		if (uuid == null) {
			connectedAccountsImpl.setUuid("");
		}
		else {
			connectedAccountsImpl.setUuid(uuid);
		}

		connectedAccountsImpl.setC_accountId(c_accountId);

		if (emailAddress == null) {
			connectedAccountsImpl.setEmailAddress("");
		}
		else {
			connectedAccountsImpl.setEmailAddress(emailAddress);
		}

		if (appName == null) {
			connectedAccountsImpl.setAppName("");
		}
		else {
			connectedAccountsImpl.setAppName(appName);
		}

		if (refreshToken == null) {
			connectedAccountsImpl.setRefreshToken("");
		}
		else {
			connectedAccountsImpl.setRefreshToken(refreshToken);
		}

		connectedAccountsImpl.setUserId(userId);
		connectedAccountsImpl.setGroupId(groupId);
		connectedAccountsImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			connectedAccountsImpl.setCreateDate(null);
		}
		else {
			connectedAccountsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			connectedAccountsImpl.setModifiedDate(null);
		}
		else {
			connectedAccountsImpl.setModifiedDate(new Date(modifiedDate));
		}

		connectedAccountsImpl.resetOriginalValues();

		return connectedAccountsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		c_accountId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		appName = objectInput.readUTF();
		refreshToken = objectInput.readUTF();

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

		objectOutput.writeLong(c_accountId);

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (appName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appName);
		}

		if (refreshToken == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(refreshToken);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long c_accountId;
	public String emailAddress;
	public String appName;
	public String refreshToken;
	public long userId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;

}