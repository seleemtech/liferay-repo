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
 * This class is a wrapper for {@link ExperienceDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExperienceDetails
 * @generated
 */
public class ExperienceDetailsWrapper
	extends BaseModelWrapper<ExperienceDetails>
	implements ExperienceDetails, ModelWrapper<ExperienceDetails> {

	public ExperienceDetailsWrapper(ExperienceDetails experienceDetails) {
		super(experienceDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("experienceId", getExperienceId());
		attributes.put("employeeID", getEmployeeID());
		attributes.put("organization", getOrganization());
		attributes.put("designation", getDesignation());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long experienceId = (Long)attributes.get("experienceId");

		if (experienceId != null) {
			setExperienceId(experienceId);
		}

		Long employeeID = (Long)attributes.get("employeeID");

		if (employeeID != null) {
			setEmployeeID(employeeID);
		}

		String organization = (String)attributes.get("organization");

		if (organization != null) {
			setOrganization(organization);
		}

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public ExperienceDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the designation of this experience details.
	 *
	 * @return the designation of this experience details
	 */
	@Override
	public String getDesignation() {
		return model.getDesignation();
	}

	/**
	 * Returns the employee ID of this experience details.
	 *
	 * @return the employee ID of this experience details
	 */
	@Override
	public long getEmployeeID() {
		return model.getEmployeeID();
	}

	/**
	 * Returns the end date of this experience details.
	 *
	 * @return the end date of this experience details
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the experience ID of this experience details.
	 *
	 * @return the experience ID of this experience details
	 */
	@Override
	public long getExperienceId() {
		return model.getExperienceId();
	}

	/**
	 * Returns the organization of this experience details.
	 *
	 * @return the organization of this experience details
	 */
	@Override
	public String getOrganization() {
		return model.getOrganization();
	}

	/**
	 * Returns the primary key of this experience details.
	 *
	 * @return the primary key of this experience details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this experience details.
	 *
	 * @return the start date of this experience details
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the designation of this experience details.
	 *
	 * @param designation the designation of this experience details
	 */
	@Override
	public void setDesignation(String designation) {
		model.setDesignation(designation);
	}

	/**
	 * Sets the employee ID of this experience details.
	 *
	 * @param employeeID the employee ID of this experience details
	 */
	@Override
	public void setEmployeeID(long employeeID) {
		model.setEmployeeID(employeeID);
	}

	/**
	 * Sets the end date of this experience details.
	 *
	 * @param endDate the end date of this experience details
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the experience ID of this experience details.
	 *
	 * @param experienceId the experience ID of this experience details
	 */
	@Override
	public void setExperienceId(long experienceId) {
		model.setExperienceId(experienceId);
	}

	/**
	 * Sets the organization of this experience details.
	 *
	 * @param organization the organization of this experience details
	 */
	@Override
	public void setOrganization(String organization) {
		model.setOrganization(organization);
	}

	/**
	 * Sets the primary key of this experience details.
	 *
	 * @param primaryKey the primary key of this experience details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this experience details.
	 *
	 * @param startDate the start date of this experience details
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	@Override
	protected ExperienceDetailsWrapper wrap(
		ExperienceDetails experienceDetails) {

		return new ExperienceDetailsWrapper(experienceDetails);
	}

}