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
 * This class is a wrapper for {@link Billclaim}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Billclaim
 * @generated
 */
public class BillclaimWrapper
	extends BaseModelWrapper<Billclaim>
	implements Billclaim, ModelWrapper<Billclaim> {

	public BillclaimWrapper(Billclaim billclaim) {
		super(billclaim);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fooId", getFooId());
		attributes.put("employeeID", getEmployeeID());
		attributes.put("userName", getUserName());
		attributes.put("claimType", getClaimType());
		attributes.put("claimDate", getClaimDate());
		attributes.put("claimAmount", getClaimAmount());
		attributes.put("attachBill", getAttachBill());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fooId = (Long)attributes.get("fooId");

		if (fooId != null) {
			setFooId(fooId);
		}

		String employeeID = (String)attributes.get("employeeID");

		if (employeeID != null) {
			setEmployeeID(employeeID);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String claimType = (String)attributes.get("claimType");

		if (claimType != null) {
			setClaimType(claimType);
		}

		Date claimDate = (Date)attributes.get("claimDate");

		if (claimDate != null) {
			setClaimDate(claimDate);
		}

		Long claimAmount = (Long)attributes.get("claimAmount");

		if (claimAmount != null) {
			setClaimAmount(claimAmount);
		}

		Long attachBill = (Long)attributes.get("attachBill");

		if (attachBill != null) {
			setAttachBill(attachBill);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Billclaim cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attach bill of this billclaim.
	 *
	 * @return the attach bill of this billclaim
	 */
	@Override
	public long getAttachBill() {
		return model.getAttachBill();
	}

	/**
	 * Returns the claim amount of this billclaim.
	 *
	 * @return the claim amount of this billclaim
	 */
	@Override
	public long getClaimAmount() {
		return model.getClaimAmount();
	}

	/**
	 * Returns the claim date of this billclaim.
	 *
	 * @return the claim date of this billclaim
	 */
	@Override
	public Date getClaimDate() {
		return model.getClaimDate();
	}

	/**
	 * Returns the claim type of this billclaim.
	 *
	 * @return the claim type of this billclaim
	 */
	@Override
	public String getClaimType() {
		return model.getClaimType();
	}

	/**
	 * Returns the employee ID of this billclaim.
	 *
	 * @return the employee ID of this billclaim
	 */
	@Override
	public String getEmployeeID() {
		return model.getEmployeeID();
	}

	/**
	 * Returns the foo ID of this billclaim.
	 *
	 * @return the foo ID of this billclaim
	 */
	@Override
	public long getFooId() {
		return model.getFooId();
	}

	/**
	 * Returns the primary key of this billclaim.
	 *
	 * @return the primary key of this billclaim
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this billclaim.
	 *
	 * @return the status of this billclaim
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user name of this billclaim.
	 *
	 * @return the user name of this billclaim
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the attach bill of this billclaim.
	 *
	 * @param attachBill the attach bill of this billclaim
	 */
	@Override
	public void setAttachBill(long attachBill) {
		model.setAttachBill(attachBill);
	}

	/**
	 * Sets the claim amount of this billclaim.
	 *
	 * @param claimAmount the claim amount of this billclaim
	 */
	@Override
	public void setClaimAmount(long claimAmount) {
		model.setClaimAmount(claimAmount);
	}

	/**
	 * Sets the claim date of this billclaim.
	 *
	 * @param claimDate the claim date of this billclaim
	 */
	@Override
	public void setClaimDate(Date claimDate) {
		model.setClaimDate(claimDate);
	}

	/**
	 * Sets the claim type of this billclaim.
	 *
	 * @param claimType the claim type of this billclaim
	 */
	@Override
	public void setClaimType(String claimType) {
		model.setClaimType(claimType);
	}

	/**
	 * Sets the employee ID of this billclaim.
	 *
	 * @param employeeID the employee ID of this billclaim
	 */
	@Override
	public void setEmployeeID(String employeeID) {
		model.setEmployeeID(employeeID);
	}

	/**
	 * Sets the foo ID of this billclaim.
	 *
	 * @param fooId the foo ID of this billclaim
	 */
	@Override
	public void setFooId(long fooId) {
		model.setFooId(fooId);
	}

	/**
	 * Sets the primary key of this billclaim.
	 *
	 * @param primaryKey the primary key of this billclaim
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this billclaim.
	 *
	 * @param status the status of this billclaim
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user name of this billclaim.
	 *
	 * @param userName the user name of this billclaim
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	@Override
	protected BillclaimWrapper wrap(Billclaim billclaim) {
		return new BillclaimWrapper(billclaim);
	}

}