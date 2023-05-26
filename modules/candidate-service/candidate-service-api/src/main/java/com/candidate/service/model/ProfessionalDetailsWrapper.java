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

package com.candidate.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProfessionalDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalDetails
 * @generated
 */
public class ProfessionalDetailsWrapper
	extends BaseModelWrapper<ProfessionalDetails>
	implements ModelWrapper<ProfessionalDetails>, ProfessionalDetails {

	public ProfessionalDetailsWrapper(ProfessionalDetails professionalDetails) {
		super(professionalDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("professionalDetailsId", getProfessionalDetailsId());
		attributes.put("candidateId", getCandidateId());
		attributes.put("expectedSalary", getExpectedSalary());
		attributes.put("currentSalary", getCurrentSalary());
		attributes.put("skillSet", getSkillSet());
		attributes.put("additionalInfo", getAdditionalInfo());
		attributes.put("currentEmployer", getCurrentEmployer());
		attributes.put("workType", getWorkType());
		attributes.put("experience ", getExperience());
		attributes.put("qualification", getQualification());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long professionalDetailsId = (Long)attributes.get(
			"professionalDetailsId");

		if (professionalDetailsId != null) {
			setProfessionalDetailsId(professionalDetailsId);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		Double expectedSalary = (Double)attributes.get("expectedSalary");

		if (expectedSalary != null) {
			setExpectedSalary(expectedSalary);
		}

		Double currentSalary = (Double)attributes.get("currentSalary");

		if (currentSalary != null) {
			setCurrentSalary(currentSalary);
		}

		String skillSet = (String)attributes.get("skillSet");

		if (skillSet != null) {
			setSkillSet(skillSet);
		}

		String additionalInfo = (String)attributes.get("additionalInfo");

		if (additionalInfo != null) {
			setAdditionalInfo(additionalInfo);
		}

		String currentEmployer = (String)attributes.get("currentEmployer");

		if (currentEmployer != null) {
			setCurrentEmployer(currentEmployer);
		}

		String workType = (String)attributes.get("workType");

		if (workType != null) {
			setWorkType(workType);
		}

		String experience = (String)attributes.get("experience ");

		if (experience != null) {
			setExperience(experience);
		}

		String qualification = (String)attributes.get("qualification");

		if (qualification != null) {
			setQualification(qualification);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public ProfessionalDetails cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the additional info of this professional details.
	 *
	 * @return the additional info of this professional details
	 */
	@Override
	public String getAdditionalInfo() {
		return model.getAdditionalInfo();
	}

	/**
	 * Returns the candidate ID of this professional details.
	 *
	 * @return the candidate ID of this professional details
	 */
	@Override
	public long getCandidateId() {
		return model.getCandidateId();
	}

	/**
	 * Returns the company ID of this professional details.
	 *
	 * @return the company ID of this professional details
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the current employer of this professional details.
	 *
	 * @return the current employer of this professional details
	 */
	@Override
	public String getCurrentEmployer() {
		return model.getCurrentEmployer();
	}

	/**
	 * Returns the current salary of this professional details.
	 *
	 * @return the current salary of this professional details
	 */
	@Override
	public double getCurrentSalary() {
		return model.getCurrentSalary();
	}

	/**
	 * Returns the expected salary of this professional details.
	 *
	 * @return the expected salary of this professional details
	 */
	@Override
	public double getExpectedSalary() {
		return model.getExpectedSalary();
	}

	/**
	 * Returns the experience of this professional details.
	 *
	 * @return the experience of this professional details
	 */
	@Override
	public String getExperience() {
		return model.getExperience();
	}

	/**
	 * Returns the job title of this professional details.
	 *
	 * @return the job title of this professional details
	 */
	@Override
	public String getJobTitle() {
		return model.getJobTitle();
	}

	/**
	 * Returns the primary key of this professional details.
	 *
	 * @return the primary key of this professional details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the professional details ID of this professional details.
	 *
	 * @return the professional details ID of this professional details
	 */
	@Override
	public long getProfessionalDetailsId() {
		return model.getProfessionalDetailsId();
	}

	/**
	 * Returns the qualification of this professional details.
	 *
	 * @return the qualification of this professional details
	 */
	@Override
	public String getQualification() {
		return model.getQualification();
	}

	/**
	 * Returns the skill set of this professional details.
	 *
	 * @return the skill set of this professional details
	 */
	@Override
	public String getSkillSet() {
		return model.getSkillSet();
	}

	/**
	 * Returns the user ID of this professional details.
	 *
	 * @return the user ID of this professional details
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this professional details.
	 *
	 * @return the user uuid of this professional details
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this professional details.
	 *
	 * @return the uuid of this professional details
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work type of this professional details.
	 *
	 * @return the work type of this professional details
	 */
	@Override
	public String getWorkType() {
		return model.getWorkType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the additional info of this professional details.
	 *
	 * @param additionalInfo the additional info of this professional details
	 */
	@Override
	public void setAdditionalInfo(String additionalInfo) {
		model.setAdditionalInfo(additionalInfo);
	}

	/**
	 * Sets the candidate ID of this professional details.
	 *
	 * @param candidateId the candidate ID of this professional details
	 */
	@Override
	public void setCandidateId(long candidateId) {
		model.setCandidateId(candidateId);
	}

	/**
	 * Sets the company ID of this professional details.
	 *
	 * @param companyId the company ID of this professional details
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the current employer of this professional details.
	 *
	 * @param currentEmployer the current employer of this professional details
	 */
	@Override
	public void setCurrentEmployer(String currentEmployer) {
		model.setCurrentEmployer(currentEmployer);
	}

	/**
	 * Sets the current salary of this professional details.
	 *
	 * @param currentSalary the current salary of this professional details
	 */
	@Override
	public void setCurrentSalary(double currentSalary) {
		model.setCurrentSalary(currentSalary);
	}

	/**
	 * Sets the expected salary of this professional details.
	 *
	 * @param expectedSalary the expected salary of this professional details
	 */
	@Override
	public void setExpectedSalary(double expectedSalary) {
		model.setExpectedSalary(expectedSalary);
	}

	/**
	 * Sets the experience of this professional details.
	 *
	 * @param experience  the experience of this professional details
	 */
	@Override
	public void setExperience(String experience) {
		model.setExperience(experience);
	}

	/**
	 * Sets the job title of this professional details.
	 *
	 * @param jobTitle the job title of this professional details
	 */
	@Override
	public void setJobTitle(String jobTitle) {
		model.setJobTitle(jobTitle);
	}

	/**
	 * Sets the primary key of this professional details.
	 *
	 * @param primaryKey the primary key of this professional details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the professional details ID of this professional details.
	 *
	 * @param professionalDetailsId the professional details ID of this professional details
	 */
	@Override
	public void setProfessionalDetailsId(long professionalDetailsId) {
		model.setProfessionalDetailsId(professionalDetailsId);
	}

	/**
	 * Sets the qualification of this professional details.
	 *
	 * @param qualification the qualification of this professional details
	 */
	@Override
	public void setQualification(String qualification) {
		model.setQualification(qualification);
	}

	/**
	 * Sets the skill set of this professional details.
	 *
	 * @param skillSet the skill set of this professional details
	 */
	@Override
	public void setSkillSet(String skillSet) {
		model.setSkillSet(skillSet);
	}

	/**
	 * Sets the user ID of this professional details.
	 *
	 * @param userId the user ID of this professional details
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this professional details.
	 *
	 * @param userUuid the user uuid of this professional details
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this professional details.
	 *
	 * @param uuid the uuid of this professional details
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work type of this professional details.
	 *
	 * @param workType the work type of this professional details
	 */
	@Override
	public void setWorkType(String workType) {
		model.setWorkType(workType);
	}

	@Override
	protected ProfessionalDetailsWrapper wrap(
		ProfessionalDetails professionalDetails) {

		return new ProfessionalDetailsWrapper(professionalDetails);
	}

}