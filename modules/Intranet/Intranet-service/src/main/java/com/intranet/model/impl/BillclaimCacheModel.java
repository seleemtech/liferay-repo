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

package com.intranet.model.impl;

import com.intranet.model.Billclaim;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Billclaim in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BillclaimCacheModel
	implements CacheModel<Billclaim>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BillclaimCacheModel)) {
			return false;
		}

		BillclaimCacheModel billclaimCacheModel = (BillclaimCacheModel)object;

		if (fooId == billclaimCacheModel.fooId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fooId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{fooId=");
		sb.append(fooId);
		sb.append(", employeeID=");
		sb.append(employeeID);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", claimType=");
		sb.append(claimType);
		sb.append(", claimDate=");
		sb.append(claimDate);
		sb.append(", claimAmount=");
		sb.append(claimAmount);
		sb.append(", attachBill=");
		sb.append(attachBill);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Billclaim toEntityModel() {
		BillclaimImpl billclaimImpl = new BillclaimImpl();

		billclaimImpl.setFooId(fooId);

		if (employeeID == null) {
			billclaimImpl.setEmployeeID("");
		}
		else {
			billclaimImpl.setEmployeeID(employeeID);
		}

		if (userName == null) {
			billclaimImpl.setUserName("");
		}
		else {
			billclaimImpl.setUserName(userName);
		}

		if (claimType == null) {
			billclaimImpl.setClaimType("");
		}
		else {
			billclaimImpl.setClaimType(claimType);
		}

		if (claimDate == Long.MIN_VALUE) {
			billclaimImpl.setClaimDate(null);
		}
		else {
			billclaimImpl.setClaimDate(new Date(claimDate));
		}

		billclaimImpl.setClaimAmount(claimAmount);
		billclaimImpl.setAttachBill(attachBill);

		if (status == null) {
			billclaimImpl.setStatus("");
		}
		else {
			billclaimImpl.setStatus(status);
		}

		billclaimImpl.resetOriginalValues();

		return billclaimImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fooId = objectInput.readLong();
		employeeID = objectInput.readUTF();
		userName = objectInput.readUTF();
		claimType = objectInput.readUTF();
		claimDate = objectInput.readLong();

		claimAmount = objectInput.readLong();

		attachBill = objectInput.readLong();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fooId);

		if (employeeID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeID);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (claimType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimType);
		}

		objectOutput.writeLong(claimDate);

		objectOutput.writeLong(claimAmount);

		objectOutput.writeLong(attachBill);

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long fooId;
	public String employeeID;
	public String userName;
	public String claimType;
	public long claimDate;
	public long claimAmount;
	public long attachBill;
	public String status;

}