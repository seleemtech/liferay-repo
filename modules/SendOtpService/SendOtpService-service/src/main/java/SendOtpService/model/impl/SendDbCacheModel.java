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

package SendOtpService.model.impl;

import SendOtpService.model.SendDb;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SendDb in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SendDbCacheModel implements CacheModel<SendDb>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SendDbCacheModel)) {
			return false;
		}

		SendDbCacheModel sendDbCacheModel = (SendDbCacheModel)object;

		if (sendId == sendDbCacheModel.sendId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sendId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", sendId=");
		sb.append(sendId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", Name=");
		sb.append(Name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SendDb toEntityModel() {
		SendDbImpl sendDbImpl = new SendDbImpl();

		if (uuid == null) {
			sendDbImpl.setUuid("");
		}
		else {
			sendDbImpl.setUuid(uuid);
		}

		sendDbImpl.setSendId(sendId);
		sendDbImpl.setCompanyId(companyId);
		sendDbImpl.setUserId(userId);

		if (userName == null) {
			sendDbImpl.setUserName("");
		}
		else {
			sendDbImpl.setUserName(userName);
		}

		sendDbImpl.setMobileNumber(mobileNumber);

		if (Name == null) {
			sendDbImpl.setName("");
		}
		else {
			sendDbImpl.setName(Name);
		}

		sendDbImpl.resetOriginalValues();

		return sendDbImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		sendId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		mobileNumber = objectInput.readLong();
		Name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(sendId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(mobileNumber);

		if (Name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Name);
		}
	}

	public String uuid;
	public long sendId;
	public long companyId;
	public long userId;
	public String userName;
	public long mobileNumber;
	public String Name;

}