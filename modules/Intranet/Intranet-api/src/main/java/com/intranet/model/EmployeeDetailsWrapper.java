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

package com.intranet.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmployeeDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetails
 * @generated
 */
public class EmployeeDetailsWrapper
	extends BaseModelWrapper<EmployeeDetails>
	implements EmployeeDetails, ModelWrapper<EmployeeDetails> {

	public EmployeeDetailsWrapper(EmployeeDetails employeeDetails) {
		super(employeeDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeID", getEmployeeID());
		attributes.put("employeename", getEmployeename());
		attributes.put("gender", getGender());
		attributes.put("domain", getDomain());
		attributes.put("contact", getContact());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());
		attributes.put("pannumber", getPannumber());
		attributes.put("passportNumber", getPassportNumber());
		attributes.put("aadhar", getAadhar());
		attributes.put("joiningDate", getJoiningDate());
		attributes.put("dob", getDob());
		attributes.put("maritalstatus", isMaritalstatus());
		attributes.put("anniversaryDate", getAnniversaryDate());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeID = (Long)attributes.get("employeeID");

		if (employeeID != null) {
			setEmployeeID(employeeID);
		}

		String employeename = (String)attributes.get("employeename");

		if (employeename != null) {
			setEmployeename(employeename);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String domain = (String)attributes.get("domain");

		if (domain != null) {
			setDomain(domain);
		}

		Long contact = (Long)attributes.get("contact");

		if (contact != null) {
			setContact(contact);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String pannumber = (String)attributes.get("pannumber");

		if (pannumber != null) {
			setPannumber(pannumber);
		}

		String passportNumber = (String)attributes.get("passportNumber");

		if (passportNumber != null) {
			setPassportNumber(passportNumber);
		}

		String aadhar = (String)attributes.get("aadhar");

		if (aadhar != null) {
			setAadhar(aadhar);
		}

		Date joiningDate = (Date)attributes.get("joiningDate");

		if (joiningDate != null) {
			setJoiningDate(joiningDate);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		Boolean maritalstatus = (Boolean)attributes.get("maritalstatus");

		if (maritalstatus != null) {
			setMaritalstatus(maritalstatus);
		}

		Date anniversaryDate = (Date)attributes.get("anniversaryDate");

		if (anniversaryDate != null) {
			setAnniversaryDate(anniversaryDate);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	@Override
	public EmployeeDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the aadhar of this employee details.
	 *
	 * @return the aadhar of this employee details
	 */
	@Override
	public String getAadhar() {
		return model.getAadhar();
	}

	/**
	 * Returns the address of this employee details.
	 *
	 * @return the address of this employee details
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the anniversary date of this employee details.
	 *
	 * @return the anniversary date of this employee details
	 */
	@Override
	public Date getAnniversaryDate() {
		return model.getAnniversaryDate();
	}

	/**
	 * Returns the contact of this employee details.
	 *
	 * @return the contact of this employee details
	 */
	@Override
	public long getContact() {
		return model.getContact();
	}

	/**
	 * Returns the dob of this employee details.
	 *
	 * @return the dob of this employee details
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the domain of this employee details.
	 *
	 * @return the domain of this employee details
	 */
	@Override
	public String getDomain() {
		return model.getDomain();
	}

	/**
	 * Returns the email of this employee details.
	 *
	 * @return the email of this employee details
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the employee ID of this employee details.
	 *
	 * @return the employee ID of this employee details
	 */
	@Override
	public long getEmployeeID() {
		return model.getEmployeeID();
	}

	/**
	 * Returns the employeename of this employee details.
	 *
	 * @return the employeename of this employee details
	 */
	@Override
	public String getEmployeename() {
		return model.getEmployeename();
	}

	/**
	 * Returns the file entry ID of this employee details.
	 *
	 * @return the file entry ID of this employee details
	 */
	@Override
	public long getFileEntryId() {
		return model.getFileEntryId();
	}

	/**
	 * Returns the gender of this employee details.
	 *
	 * @return the gender of this employee details
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the joining date of this employee details.
	 *
	 * @return the joining date of this employee details
	 */
	@Override
	public Date getJoiningDate() {
		return model.getJoiningDate();
	}

	/**
	 * Returns the maritalstatus of this employee details.
	 *
	 * @return the maritalstatus of this employee details
	 */
	@Override
	public boolean getMaritalstatus() {
		return model.getMaritalstatus();
	}

	/**
	 * Returns the pannumber of this employee details.
	 *
	 * @return the pannumber of this employee details
	 */
	@Override
	public String getPannumber() {
		return model.getPannumber();
	}

	/**
	 * Returns the passport number of this employee details.
	 *
	 * @return the passport number of this employee details
	 */
	@Override
	public String getPassportNumber() {
		return model.getPassportNumber();
	}

	/**
	 * Returns the primary key of this employee details.
	 *
	 * @return the primary key of this employee details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this employee details is maritalstatus.
	 *
	 * @return <code>true</code> if this employee details is maritalstatus; <code>false</code> otherwise
	 */
	@Override
	public boolean isMaritalstatus() {
		return model.isMaritalstatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the aadhar of this employee details.
	 *
	 * @param aadhar the aadhar of this employee details
	 */
	@Override
	public void setAadhar(String aadhar) {
		model.setAadhar(aadhar);
	}

	/**
	 * Sets the address of this employee details.
	 *
	 * @param address the address of this employee details
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the anniversary date of this employee details.
	 *
	 * @param anniversaryDate the anniversary date of this employee details
	 */
	@Override
	public void setAnniversaryDate(Date anniversaryDate) {
		model.setAnniversaryDate(anniversaryDate);
	}

	/**
	 * Sets the contact of this employee details.
	 *
	 * @param contact the contact of this employee details
	 */
	@Override
	public void setContact(long contact) {
		model.setContact(contact);
	}

	/**
	 * Sets the dob of this employee details.
	 *
	 * @param dob the dob of this employee details
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the domain of this employee details.
	 *
	 * @param domain the domain of this employee details
	 */
	@Override
	public void setDomain(String domain) {
		model.setDomain(domain);
	}

	/**
	 * Sets the email of this employee details.
	 *
	 * @param email the email of this employee details
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the employee ID of this employee details.
	 *
	 * @param employeeID the employee ID of this employee details
	 */
	@Override
	public void setEmployeeID(long employeeID) {
		model.setEmployeeID(employeeID);
	}

	/**
	 * Sets the employeename of this employee details.
	 *
	 * @param employeename the employeename of this employee details
	 */
	@Override
	public void setEmployeename(String employeename) {
		model.setEmployeename(employeename);
	}

	/**
	 * Sets the file entry ID of this employee details.
	 *
	 * @param fileEntryId the file entry ID of this employee details
	 */
	@Override
	public void setFileEntryId(long fileEntryId) {
		model.setFileEntryId(fileEntryId);
	}

	/**
	 * Sets the gender of this employee details.
	 *
	 * @param gender the gender of this employee details
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the joining date of this employee details.
	 *
	 * @param joiningDate the joining date of this employee details
	 */
	@Override
	public void setJoiningDate(Date joiningDate) {
		model.setJoiningDate(joiningDate);
	}

	/**
	 * Sets whether this employee details is maritalstatus.
	 *
	 * @param maritalstatus the maritalstatus of this employee details
	 */
	@Override
	public void setMaritalstatus(boolean maritalstatus) {
		model.setMaritalstatus(maritalstatus);
	}

	/**
	 * Sets the pannumber of this employee details.
	 *
	 * @param pannumber the pannumber of this employee details
	 */
	@Override
	public void setPannumber(String pannumber) {
		model.setPannumber(pannumber);
	}

	/**
	 * Sets the passport number of this employee details.
	 *
	 * @param passportNumber the passport number of this employee details
	 */
	@Override
	public void setPassportNumber(String passportNumber) {
		model.setPassportNumber(passportNumber);
	}

	/**
	 * Sets the primary key of this employee details.
	 *
	 * @param primaryKey the primary key of this employee details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected EmployeeDetailsWrapper wrap(EmployeeDetails employeeDetails) {
		return new EmployeeDetailsWrapper(employeeDetails);
	}

}