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

import com.intranet.model.EmployeeDetails;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeDetailsCacheModel
	implements CacheModel<EmployeeDetails>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeDetailsCacheModel)) {
			return false;
		}

		EmployeeDetailsCacheModel employeeDetailsCacheModel =
			(EmployeeDetailsCacheModel)object;

		if (employeeID == employeeDetailsCacheModel.employeeID) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeID);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{employeeID=");
		sb.append(employeeID);
		sb.append(", employeename=");
		sb.append(employeename);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", domain=");
		sb.append(domain);
		sb.append(", contact=");
		sb.append(contact);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", pannumber=");
		sb.append(pannumber);
		sb.append(", passportNumber=");
		sb.append(passportNumber);
		sb.append(", aadhar=");
		sb.append(aadhar);
		sb.append(", joiningDate=");
		sb.append(joiningDate);
		sb.append(", dob=");
		sb.append(dob);
		sb.append(", maritalstatus=");
		sb.append(maritalstatus);
		sb.append(", anniversaryDate=");
		sb.append(anniversaryDate);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeDetails toEntityModel() {
		EmployeeDetailsImpl employeeDetailsImpl = new EmployeeDetailsImpl();

		employeeDetailsImpl.setEmployeeID(employeeID);

		if (employeename == null) {
			employeeDetailsImpl.setEmployeename("");
		}
		else {
			employeeDetailsImpl.setEmployeename(employeename);
		}

		if (gender == null) {
			employeeDetailsImpl.setGender("");
		}
		else {
			employeeDetailsImpl.setGender(gender);
		}

		if (domain == null) {
			employeeDetailsImpl.setDomain("");
		}
		else {
			employeeDetailsImpl.setDomain(domain);
		}

		employeeDetailsImpl.setContact(contact);

		if (email == null) {
			employeeDetailsImpl.setEmail("");
		}
		else {
			employeeDetailsImpl.setEmail(email);
		}

		if (address == null) {
			employeeDetailsImpl.setAddress("");
		}
		else {
			employeeDetailsImpl.setAddress(address);
		}

		if (pannumber == null) {
			employeeDetailsImpl.setPannumber("");
		}
		else {
			employeeDetailsImpl.setPannumber(pannumber);
		}

		if (passportNumber == null) {
			employeeDetailsImpl.setPassportNumber("");
		}
		else {
			employeeDetailsImpl.setPassportNumber(passportNumber);
		}

		if (aadhar == null) {
			employeeDetailsImpl.setAadhar("");
		}
		else {
			employeeDetailsImpl.setAadhar(aadhar);
		}

		if (joiningDate == Long.MIN_VALUE) {
			employeeDetailsImpl.setJoiningDate(null);
		}
		else {
			employeeDetailsImpl.setJoiningDate(new Date(joiningDate));
		}

		if (dob == Long.MIN_VALUE) {
			employeeDetailsImpl.setDob(null);
		}
		else {
			employeeDetailsImpl.setDob(new Date(dob));
		}

		employeeDetailsImpl.setMaritalstatus(maritalstatus);

		if (anniversaryDate == Long.MIN_VALUE) {
			employeeDetailsImpl.setAnniversaryDate(null);
		}
		else {
			employeeDetailsImpl.setAnniversaryDate(new Date(anniversaryDate));
		}

		employeeDetailsImpl.setFileEntryId(fileEntryId);

		employeeDetailsImpl.resetOriginalValues();

		return employeeDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeID = objectInput.readLong();
		employeename = objectInput.readUTF();
		gender = objectInput.readUTF();
		domain = objectInput.readUTF();

		contact = objectInput.readLong();
		email = objectInput.readUTF();
		address = objectInput.readUTF();
		pannumber = objectInput.readUTF();
		passportNumber = objectInput.readUTF();
		aadhar = objectInput.readUTF();
		joiningDate = objectInput.readLong();
		dob = objectInput.readLong();

		maritalstatus = objectInput.readBoolean();
		anniversaryDate = objectInput.readLong();

		fileEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeID);

		if (employeename == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeename);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (domain == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(domain);
		}

		objectOutput.writeLong(contact);

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (pannumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pannumber);
		}

		if (passportNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(passportNumber);
		}

		if (aadhar == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aadhar);
		}

		objectOutput.writeLong(joiningDate);
		objectOutput.writeLong(dob);

		objectOutput.writeBoolean(maritalstatus);
		objectOutput.writeLong(anniversaryDate);

		objectOutput.writeLong(fileEntryId);
	}

	public long employeeID;
	public String employeename;
	public String gender;
	public String domain;
	public long contact;
	public String email;
	public String address;
	public String pannumber;
	public String passportNumber;
	public String aadhar;
	public long joiningDate;
	public long dob;
	public boolean maritalstatus;
	public long anniversaryDate;
	public long fileEntryId;

}