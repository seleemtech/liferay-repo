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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the EmployeeDetails service. Represents a row in the &quot;INTRANET_EmployeeDetails&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.intranet.model.impl.EmployeeDetailsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.intranet.model.impl.EmployeeDetailsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetails
 * @generated
 */
@ProviderType
public interface EmployeeDetailsModel extends BaseModel<EmployeeDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee details model instance should use the {@link EmployeeDetails} interface instead.
	 */

	/**
	 * Returns the primary key of this employee details.
	 *
	 * @return the primary key of this employee details
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee details.
	 *
	 * @param primaryKey the primary key of this employee details
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee ID of this employee details.
	 *
	 * @return the employee ID of this employee details
	 */
	public long getEmployeeID();

	/**
	 * Sets the employee ID of this employee details.
	 *
	 * @param employeeID the employee ID of this employee details
	 */
	public void setEmployeeID(long employeeID);

	/**
	 * Returns the employeename of this employee details.
	 *
	 * @return the employeename of this employee details
	 */
	@AutoEscape
	public String getEmployeename();

	/**
	 * Sets the employeename of this employee details.
	 *
	 * @param employeename the employeename of this employee details
	 */
	public void setEmployeename(String employeename);

	/**
	 * Returns the gender of this employee details.
	 *
	 * @return the gender of this employee details
	 */
	@AutoEscape
	public String getGender();

	/**
	 * Sets the gender of this employee details.
	 *
	 * @param gender the gender of this employee details
	 */
	public void setGender(String gender);

	/**
	 * Returns the domain of this employee details.
	 *
	 * @return the domain of this employee details
	 */
	@AutoEscape
	public String getDomain();

	/**
	 * Sets the domain of this employee details.
	 *
	 * @param domain the domain of this employee details
	 */
	public void setDomain(String domain);

	/**
	 * Returns the contact of this employee details.
	 *
	 * @return the contact of this employee details
	 */
	public long getContact();

	/**
	 * Sets the contact of this employee details.
	 *
	 * @param contact the contact of this employee details
	 */
	public void setContact(long contact);

	/**
	 * Returns the email of this employee details.
	 *
	 * @return the email of this employee details
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this employee details.
	 *
	 * @param email the email of this employee details
	 */
	public void setEmail(String email);

	/**
	 * Returns the address of this employee details.
	 *
	 * @return the address of this employee details
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this employee details.
	 *
	 * @param address the address of this employee details
	 */
	public void setAddress(String address);

	/**
	 * Returns the pannumber of this employee details.
	 *
	 * @return the pannumber of this employee details
	 */
	@AutoEscape
	public String getPannumber();

	/**
	 * Sets the pannumber of this employee details.
	 *
	 * @param pannumber the pannumber of this employee details
	 */
	public void setPannumber(String pannumber);

	/**
	 * Returns the passport number of this employee details.
	 *
	 * @return the passport number of this employee details
	 */
	@AutoEscape
	public String getPassportNumber();

	/**
	 * Sets the passport number of this employee details.
	 *
	 * @param passportNumber the passport number of this employee details
	 */
	public void setPassportNumber(String passportNumber);

	/**
	 * Returns the aadhar of this employee details.
	 *
	 * @return the aadhar of this employee details
	 */
	@AutoEscape
	public String getAadhar();

	/**
	 * Sets the aadhar of this employee details.
	 *
	 * @param aadhar the aadhar of this employee details
	 */
	public void setAadhar(String aadhar);

	/**
	 * Returns the joining date of this employee details.
	 *
	 * @return the joining date of this employee details
	 */
	public Date getJoiningDate();

	/**
	 * Sets the joining date of this employee details.
	 *
	 * @param joiningDate the joining date of this employee details
	 */
	public void setJoiningDate(Date joiningDate);

	/**
	 * Returns the dob of this employee details.
	 *
	 * @return the dob of this employee details
	 */
	public Date getDob();

	/**
	 * Sets the dob of this employee details.
	 *
	 * @param dob the dob of this employee details
	 */
	public void setDob(Date dob);

	/**
	 * Returns the maritalstatus of this employee details.
	 *
	 * @return the maritalstatus of this employee details
	 */
	public boolean getMaritalstatus();

	/**
	 * Returns <code>true</code> if this employee details is maritalstatus.
	 *
	 * @return <code>true</code> if this employee details is maritalstatus; <code>false</code> otherwise
	 */
	public boolean isMaritalstatus();

	/**
	 * Sets whether this employee details is maritalstatus.
	 *
	 * @param maritalstatus the maritalstatus of this employee details
	 */
	public void setMaritalstatus(boolean maritalstatus);

	/**
	 * Returns the anniversary date of this employee details.
	 *
	 * @return the anniversary date of this employee details
	 */
	public Date getAnniversaryDate();

	/**
	 * Sets the anniversary date of this employee details.
	 *
	 * @param anniversaryDate the anniversary date of this employee details
	 */
	public void setAnniversaryDate(Date anniversaryDate);

	/**
	 * Returns the file entry ID of this employee details.
	 *
	 * @return the file entry ID of this employee details
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this employee details.
	 *
	 * @param fileEntryId the file entry ID of this employee details
	 */
	public void setFileEntryId(long fileEntryId);

	@Override
	public EmployeeDetails cloneWithOriginalValues();

}