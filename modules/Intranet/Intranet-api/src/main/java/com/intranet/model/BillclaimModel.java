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
 * The base model interface for the Billclaim service. Represents a row in the &quot;INTRANET_Billclaim&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.intranet.model.impl.BillclaimModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.intranet.model.impl.BillclaimImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billclaim
 * @generated
 */
@ProviderType
public interface BillclaimModel extends BaseModel<Billclaim> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a billclaim model instance should use the {@link Billclaim} interface instead.
	 */

	/**
	 * Returns the primary key of this billclaim.
	 *
	 * @return the primary key of this billclaim
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this billclaim.
	 *
	 * @param primaryKey the primary key of this billclaim
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the foo ID of this billclaim.
	 *
	 * @return the foo ID of this billclaim
	 */
	public long getFooId();

	/**
	 * Sets the foo ID of this billclaim.
	 *
	 * @param fooId the foo ID of this billclaim
	 */
	public void setFooId(long fooId);

	/**
	 * Returns the employee ID of this billclaim.
	 *
	 * @return the employee ID of this billclaim
	 */
	@AutoEscape
	public String getEmployeeID();

	/**
	 * Sets the employee ID of this billclaim.
	 *
	 * @param employeeID the employee ID of this billclaim
	 */
	public void setEmployeeID(String employeeID);

	/**
	 * Returns the user name of this billclaim.
	 *
	 * @return the user name of this billclaim
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this billclaim.
	 *
	 * @param userName the user name of this billclaim
	 */
	public void setUserName(String userName);

	/**
	 * Returns the claim type of this billclaim.
	 *
	 * @return the claim type of this billclaim
	 */
	@AutoEscape
	public String getClaimType();

	/**
	 * Sets the claim type of this billclaim.
	 *
	 * @param claimType the claim type of this billclaim
	 */
	public void setClaimType(String claimType);

	/**
	 * Returns the claim date of this billclaim.
	 *
	 * @return the claim date of this billclaim
	 */
	public Date getClaimDate();

	/**
	 * Sets the claim date of this billclaim.
	 *
	 * @param claimDate the claim date of this billclaim
	 */
	public void setClaimDate(Date claimDate);

	/**
	 * Returns the claim amount of this billclaim.
	 *
	 * @return the claim amount of this billclaim
	 */
	public long getClaimAmount();

	/**
	 * Sets the claim amount of this billclaim.
	 *
	 * @param claimAmount the claim amount of this billclaim
	 */
	public void setClaimAmount(long claimAmount);

	/**
	 * Returns the attach bill of this billclaim.
	 *
	 * @return the attach bill of this billclaim
	 */
	public long getAttachBill();

	/**
	 * Sets the attach bill of this billclaim.
	 *
	 * @param attachBill the attach bill of this billclaim
	 */
	public void setAttachBill(long attachBill);

	/**
	 * Returns the status of this billclaim.
	 *
	 * @return the status of this billclaim
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this billclaim.
	 *
	 * @param status the status of this billclaim
	 */
	public void setStatus(String status);

	@Override
	public Billclaim cloneWithOriginalValues();

}