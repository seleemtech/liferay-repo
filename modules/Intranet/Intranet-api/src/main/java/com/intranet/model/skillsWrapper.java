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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link skills}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see skills
 * @generated
 */
public class skillsWrapper
	extends BaseModelWrapper<skills> implements ModelWrapper<skills>, skills {

	public skillsWrapper(skills skills) {
		super(skills);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("skillId", getSkillId());
		attributes.put("employeeID", getEmployeeID());
		attributes.put("skill", getSkill());
		attributes.put("version", getVersion());
		attributes.put("certification", isCertification());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long skillId = (Long)attributes.get("skillId");

		if (skillId != null) {
			setSkillId(skillId);
		}

		Long employeeID = (Long)attributes.get("employeeID");

		if (employeeID != null) {
			setEmployeeID(employeeID);
		}

		String skill = (String)attributes.get("skill");

		if (skill != null) {
			setSkill(skill);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Boolean certification = (Boolean)attributes.get("certification");

		if (certification != null) {
			setCertification(certification);
		}
	}

	@Override
	public skills cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the certification of this skills.
	 *
	 * @return the certification of this skills
	 */
	@Override
	public boolean getCertification() {
		return model.getCertification();
	}

	/**
	 * Returns the employee ID of this skills.
	 *
	 * @return the employee ID of this skills
	 */
	@Override
	public long getEmployeeID() {
		return model.getEmployeeID();
	}

	/**
	 * Returns the primary key of this skills.
	 *
	 * @return the primary key of this skills
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the skill of this skills.
	 *
	 * @return the skill of this skills
	 */
	@Override
	public String getSkill() {
		return model.getSkill();
	}

	/**
	 * Returns the skill ID of this skills.
	 *
	 * @return the skill ID of this skills
	 */
	@Override
	public long getSkillId() {
		return model.getSkillId();
	}

	/**
	 * Returns the version of this skills.
	 *
	 * @return the version of this skills
	 */
	@Override
	public String getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns <code>true</code> if this skills is certification.
	 *
	 * @return <code>true</code> if this skills is certification; <code>false</code> otherwise
	 */
	@Override
	public boolean isCertification() {
		return model.isCertification();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this skills is certification.
	 *
	 * @param certification the certification of this skills
	 */
	@Override
	public void setCertification(boolean certification) {
		model.setCertification(certification);
	}

	/**
	 * Sets the employee ID of this skills.
	 *
	 * @param employeeID the employee ID of this skills
	 */
	@Override
	public void setEmployeeID(long employeeID) {
		model.setEmployeeID(employeeID);
	}

	/**
	 * Sets the primary key of this skills.
	 *
	 * @param primaryKey the primary key of this skills
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the skill of this skills.
	 *
	 * @param skill the skill of this skills
	 */
	@Override
	public void setSkill(String skill) {
		model.setSkill(skill);
	}

	/**
	 * Sets the skill ID of this skills.
	 *
	 * @param skillId the skill ID of this skills
	 */
	@Override
	public void setSkillId(long skillId) {
		model.setSkillId(skillId);
	}

	/**
	 * Sets the version of this skills.
	 *
	 * @param version the version of this skills
	 */
	@Override
	public void setVersion(String version) {
		model.setVersion(version);
	}

	@Override
	protected skillsWrapper wrap(skills skills) {
		return new skillsWrapper(skills);
	}

}