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

package com.prime.data.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.prime.data.service.model.SalesStage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SalesStage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SalesStageCacheModel
	implements CacheModel<SalesStage>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SalesStageCacheModel)) {
			return false;
		}

		SalesStageCacheModel salesStageCacheModel =
			(SalesStageCacheModel)object;

		if (salesStageId == salesStageCacheModel.salesStageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, salesStageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", salesStageId=");
		sb.append(salesStageId);
		sb.append(", salesStage=");
		sb.append(salesStage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SalesStage toEntityModel() {
		SalesStageImpl salesStageImpl = new SalesStageImpl();

		if (uuid == null) {
			salesStageImpl.setUuid("");
		}
		else {
			salesStageImpl.setUuid(uuid);
		}

		salesStageImpl.setSalesStageId(salesStageId);

		if (salesStage == null) {
			salesStageImpl.setSalesStage("");
		}
		else {
			salesStageImpl.setSalesStage(salesStage);
		}

		salesStageImpl.resetOriginalValues();

		return salesStageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		salesStageId = objectInput.readLong();
		salesStage = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(salesStageId);

		if (salesStage == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salesStage);
		}
	}

	public String uuid;
	public long salesStageId;
	public String salesStage;

}