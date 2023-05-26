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

import com.intranet.model.ComplaintBox;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ComplaintBox in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ComplaintBoxCacheModel
	implements CacheModel<ComplaintBox>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ComplaintBoxCacheModel)) {
			return false;
		}

		ComplaintBoxCacheModel complaintBoxCacheModel =
			(ComplaintBoxCacheModel)object;

		if (fooId == complaintBoxCacheModel.fooId) {
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
		StringBundler sb = new StringBundler(47);

		sb.append("{fooId=");
		sb.append(fooId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", posistionType=");
		sb.append(posistionType);
		sb.append(", submittedDate=");
		sb.append(submittedDate);
		sb.append(", question1=");
		sb.append(question1);
		sb.append(", question2=");
		sb.append(question2);
		sb.append(", question3=");
		sb.append(question3);
		sb.append(", question4=");
		sb.append(question4);
		sb.append(", question5=");
		sb.append(question5);
		sb.append(", question6=");
		sb.append(question6);
		sb.append(", question7=");
		sb.append(question7);
		sb.append(", question8=");
		sb.append(question8);
		sb.append(", question9=");
		sb.append(question9);
		sb.append(", question10=");
		sb.append(question10);
		sb.append(", question11=");
		sb.append(question11);
		sb.append(", question12=");
		sb.append(question12);
		sb.append(", question13=");
		sb.append(question13);
		sb.append(", question14=");
		sb.append(question14);
		sb.append(", question15=");
		sb.append(question15);
		sb.append(", description1=");
		sb.append(description1);
		sb.append(", description2=");
		sb.append(description2);
		sb.append(", description3=");
		sb.append(description3);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ComplaintBox toEntityModel() {
		ComplaintBoxImpl complaintBoxImpl = new ComplaintBoxImpl();

		complaintBoxImpl.setFooId(fooId);

		if (employeeId == null) {
			complaintBoxImpl.setEmployeeId("");
		}
		else {
			complaintBoxImpl.setEmployeeId(employeeId);
		}

		if (userName == null) {
			complaintBoxImpl.setUserName("");
		}
		else {
			complaintBoxImpl.setUserName(userName);
		}

		if (posistionType == null) {
			complaintBoxImpl.setPosistionType("");
		}
		else {
			complaintBoxImpl.setPosistionType(posistionType);
		}

		if (submittedDate == Long.MIN_VALUE) {
			complaintBoxImpl.setSubmittedDate(null);
		}
		else {
			complaintBoxImpl.setSubmittedDate(new Date(submittedDate));
		}

		complaintBoxImpl.setQuestion1(question1);
		complaintBoxImpl.setQuestion2(question2);
		complaintBoxImpl.setQuestion3(question3);
		complaintBoxImpl.setQuestion4(question4);
		complaintBoxImpl.setQuestion5(question5);
		complaintBoxImpl.setQuestion6(question6);
		complaintBoxImpl.setQuestion7(question7);
		complaintBoxImpl.setQuestion8(question8);
		complaintBoxImpl.setQuestion9(question9);
		complaintBoxImpl.setQuestion10(question10);
		complaintBoxImpl.setQuestion11(question11);
		complaintBoxImpl.setQuestion12(question12);
		complaintBoxImpl.setQuestion13(question13);
		complaintBoxImpl.setQuestion14(question14);
		complaintBoxImpl.setQuestion15(question15);

		if (description1 == null) {
			complaintBoxImpl.setDescription1("");
		}
		else {
			complaintBoxImpl.setDescription1(description1);
		}

		if (description2 == null) {
			complaintBoxImpl.setDescription2("");
		}
		else {
			complaintBoxImpl.setDescription2(description2);
		}

		if (description3 == null) {
			complaintBoxImpl.setDescription3("");
		}
		else {
			complaintBoxImpl.setDescription3(description3);
		}

		complaintBoxImpl.resetOriginalValues();

		return complaintBoxImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fooId = objectInput.readLong();
		employeeId = objectInput.readUTF();
		userName = objectInput.readUTF();
		posistionType = objectInput.readUTF();
		submittedDate = objectInput.readLong();

		question1 = objectInput.readInt();

		question2 = objectInput.readInt();

		question3 = objectInput.readInt();

		question4 = objectInput.readInt();

		question5 = objectInput.readInt();

		question6 = objectInput.readInt();

		question7 = objectInput.readInt();

		question8 = objectInput.readInt();

		question9 = objectInput.readInt();

		question10 = objectInput.readInt();

		question11 = objectInput.readInt();

		question12 = objectInput.readInt();

		question13 = objectInput.readInt();

		question14 = objectInput.readInt();

		question15 = objectInput.readInt();
		description1 = objectInput.readUTF();
		description2 = objectInput.readUTF();
		description3 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fooId);

		if (employeeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeId);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (posistionType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(posistionType);
		}

		objectOutput.writeLong(submittedDate);

		objectOutput.writeInt(question1);

		objectOutput.writeInt(question2);

		objectOutput.writeInt(question3);

		objectOutput.writeInt(question4);

		objectOutput.writeInt(question5);

		objectOutput.writeInt(question6);

		objectOutput.writeInt(question7);

		objectOutput.writeInt(question8);

		objectOutput.writeInt(question9);

		objectOutput.writeInt(question10);

		objectOutput.writeInt(question11);

		objectOutput.writeInt(question12);

		objectOutput.writeInt(question13);

		objectOutput.writeInt(question14);

		objectOutput.writeInt(question15);

		if (description1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description1);
		}

		if (description2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description2);
		}

		if (description3 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description3);
		}
	}

	public long fooId;
	public String employeeId;
	public String userName;
	public String posistionType;
	public long submittedDate;
	public int question1;
	public int question2;
	public int question3;
	public int question4;
	public int question5;
	public int question6;
	public int question7;
	public int question8;
	public int question9;
	public int question10;
	public int question11;
	public int question12;
	public int question13;
	public int question14;
	public int question15;
	public String description1;
	public String description2;
	public String description3;

}