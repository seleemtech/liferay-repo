/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model.impl;

import api.master.slayer.model.ApiMapKey;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ApiMapKey in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ApiMapKeyCacheModel
	implements CacheModel<ApiMapKey>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ApiMapKeyCacheModel)) {
			return false;
		}

		ApiMapKeyCacheModel apiMapKeyCacheModel = (ApiMapKeyCacheModel)object;

		if (apiMapKeyId == apiMapKeyCacheModel.apiMapKeyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, apiMapKeyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", apiMapKeyId=");
		sb.append(apiMapKeyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", key=");
		sb.append(key);
		sb.append(", typeSettings=");
		sb.append(typeSettings);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApiMapKey toEntityModel() {
		ApiMapKeyImpl apiMapKeyImpl = new ApiMapKeyImpl();

		if (uuid == null) {
			apiMapKeyImpl.setUuid("");
		}
		else {
			apiMapKeyImpl.setUuid(uuid);
		}

		apiMapKeyImpl.setApiMapKeyId(apiMapKeyId);

		if (name == null) {
			apiMapKeyImpl.setName("");
		}
		else {
			apiMapKeyImpl.setName(name);
		}

		if (key == null) {
			apiMapKeyImpl.setKey("");
		}
		else {
			apiMapKeyImpl.setKey(key);
		}

		if (typeSettings == null) {
			apiMapKeyImpl.setTypeSettings("");
		}
		else {
			apiMapKeyImpl.setTypeSettings(typeSettings);
		}

		apiMapKeyImpl.setUserId(userId);
		apiMapKeyImpl.setGroupId(groupId);

		apiMapKeyImpl.resetOriginalValues();

		return apiMapKeyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		apiMapKeyId = objectInput.readLong();
		name = objectInput.readUTF();
		key = objectInput.readUTF();
		typeSettings = objectInput.readUTF();

		userId = objectInput.readLong();

		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(apiMapKeyId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (typeSettings == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeSettings);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(groupId);
	}

	public String uuid;
	public long apiMapKeyId;
	public String name;
	public String key;
	public String typeSettings;
	public long userId;
	public long groupId;

}