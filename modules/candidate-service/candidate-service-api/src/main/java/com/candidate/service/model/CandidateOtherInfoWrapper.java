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
 * This class is a wrapper for {@link CandidateOtherInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateOtherInfo
 * @generated
 */
public class CandidateOtherInfoWrapper
	extends BaseModelWrapper<CandidateOtherInfo>
	implements CandidateOtherInfo, ModelWrapper<CandidateOtherInfo> {

	public CandidateOtherInfoWrapper(CandidateOtherInfo candidateOtherInfo) {
		super(candidateOtherInfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("candidateOtherInfoId", getCandidateOtherInfoId());
		attributes.put("candidateId", getCandidateId());
		attributes.put("candidateStatus", getCandidateStatus());
		attributes.put("candidateStage", getCandidateStage());
		attributes.put("source", getSource());
		attributes.put("candidateOwner", getCandidateOwner());
		attributes.put("institute", getInstitute());
		attributes.put("department", getDepartment());
		attributes.put("degree", getDegree());
		attributes.put("fromDuration", getFromDuration());
		attributes.put("toDuration", getToDuration());
		attributes.put("occupation", getOccupation());
		attributes.put("company", getCompany());
		attributes.put("summary", getSummary());
		attributes.put("fromWorkDuration", getFromWorkDuration());
		attributes.put("toWorkDuration", getToWorkDuration());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("folderId", getFolderId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long candidateOtherInfoId = (Long)attributes.get(
			"candidateOtherInfoId");

		if (candidateOtherInfoId != null) {
			setCandidateOtherInfoId(candidateOtherInfoId);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		String candidateStatus = (String)attributes.get("candidateStatus");

		if (candidateStatus != null) {
			setCandidateStatus(candidateStatus);
		}

		String candidateStage = (String)attributes.get("candidateStage");

		if (candidateStage != null) {
			setCandidateStage(candidateStage);
		}

		String source = (String)attributes.get("source");

		if (source != null) {
			setSource(source);
		}

		String candidateOwner = (String)attributes.get("candidateOwner");

		if (candidateOwner != null) {
			setCandidateOwner(candidateOwner);
		}

		String institute = (String)attributes.get("institute");

		if (institute != null) {
			setInstitute(institute);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String degree = (String)attributes.get("degree");

		if (degree != null) {
			setDegree(degree);
		}

		String fromDuration = (String)attributes.get("fromDuration");

		if (fromDuration != null) {
			setFromDuration(fromDuration);
		}

		String toDuration = (String)attributes.get("toDuration");

		if (toDuration != null) {
			setToDuration(toDuration);
		}

		String occupation = (String)attributes.get("occupation");

		if (occupation != null) {
			setOccupation(occupation);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String fromWorkDuration = (String)attributes.get("fromWorkDuration");

		if (fromWorkDuration != null) {
			setFromWorkDuration(fromWorkDuration);
		}

		String toWorkDuration = (String)attributes.get("toWorkDuration");

		if (toWorkDuration != null) {
			setToWorkDuration(toWorkDuration);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}
	}

	@Override
	public CandidateOtherInfo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the candidate ID of this candidate other info.
	 *
	 * @return the candidate ID of this candidate other info
	 */
	@Override
	public long getCandidateId() {
		return model.getCandidateId();
	}

	/**
	 * Returns the candidate other info ID of this candidate other info.
	 *
	 * @return the candidate other info ID of this candidate other info
	 */
	@Override
	public long getCandidateOtherInfoId() {
		return model.getCandidateOtherInfoId();
	}

	/**
	 * Returns the candidate owner of this candidate other info.
	 *
	 * @return the candidate owner of this candidate other info
	 */
	@Override
	public String getCandidateOwner() {
		return model.getCandidateOwner();
	}

	/**
	 * Returns the candidate stage of this candidate other info.
	 *
	 * @return the candidate stage of this candidate other info
	 */
	@Override
	public String getCandidateStage() {
		return model.getCandidateStage();
	}

	/**
	 * Returns the candidate status of this candidate other info.
	 *
	 * @return the candidate status of this candidate other info
	 */
	@Override
	public String getCandidateStatus() {
		return model.getCandidateStatus();
	}

	/**
	 * Returns the company of this candidate other info.
	 *
	 * @return the company of this candidate other info
	 */
	@Override
	public String getCompany() {
		return model.getCompany();
	}

	/**
	 * Returns the company ID of this candidate other info.
	 *
	 * @return the company ID of this candidate other info
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the degree of this candidate other info.
	 *
	 * @return the degree of this candidate other info
	 */
	@Override
	public String getDegree() {
		return model.getDegree();
	}

	/**
	 * Returns the department of this candidate other info.
	 *
	 * @return the department of this candidate other info
	 */
	@Override
	public String getDepartment() {
		return model.getDepartment();
	}

	/**
	 * Returns the folder ID of this candidate other info.
	 *
	 * @return the folder ID of this candidate other info
	 */
	@Override
	public long getFolderId() {
		return model.getFolderId();
	}

	/**
	 * Returns the from duration of this candidate other info.
	 *
	 * @return the from duration of this candidate other info
	 */
	@Override
	public String getFromDuration() {
		return model.getFromDuration();
	}

	/**
	 * Returns the from work duration of this candidate other info.
	 *
	 * @return the from work duration of this candidate other info
	 */
	@Override
	public String getFromWorkDuration() {
		return model.getFromWorkDuration();
	}

	/**
	 * Returns the institute of this candidate other info.
	 *
	 * @return the institute of this candidate other info
	 */
	@Override
	public String getInstitute() {
		return model.getInstitute();
	}

	/**
	 * Returns the occupation of this candidate other info.
	 *
	 * @return the occupation of this candidate other info
	 */
	@Override
	public String getOccupation() {
		return model.getOccupation();
	}

	/**
	 * Returns the primary key of this candidate other info.
	 *
	 * @return the primary key of this candidate other info
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the source of this candidate other info.
	 *
	 * @return the source of this candidate other info
	 */
	@Override
	public String getSource() {
		return model.getSource();
	}

	/**
	 * Returns the summary of this candidate other info.
	 *
	 * @return the summary of this candidate other info
	 */
	@Override
	public String getSummary() {
		return model.getSummary();
	}

	/**
	 * Returns the to duration of this candidate other info.
	 *
	 * @return the to duration of this candidate other info
	 */
	@Override
	public String getToDuration() {
		return model.getToDuration();
	}

	/**
	 * Returns the to work duration of this candidate other info.
	 *
	 * @return the to work duration of this candidate other info
	 */
	@Override
	public String getToWorkDuration() {
		return model.getToWorkDuration();
	}

	/**
	 * Returns the user ID of this candidate other info.
	 *
	 * @return the user ID of this candidate other info
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this candidate other info.
	 *
	 * @return the user uuid of this candidate other info
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this candidate other info.
	 *
	 * @return the uuid of this candidate other info
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the candidate ID of this candidate other info.
	 *
	 * @param candidateId the candidate ID of this candidate other info
	 */
	@Override
	public void setCandidateId(long candidateId) {
		model.setCandidateId(candidateId);
	}

	/**
	 * Sets the candidate other info ID of this candidate other info.
	 *
	 * @param candidateOtherInfoId the candidate other info ID of this candidate other info
	 */
	@Override
	public void setCandidateOtherInfoId(long candidateOtherInfoId) {
		model.setCandidateOtherInfoId(candidateOtherInfoId);
	}

	/**
	 * Sets the candidate owner of this candidate other info.
	 *
	 * @param candidateOwner the candidate owner of this candidate other info
	 */
	@Override
	public void setCandidateOwner(String candidateOwner) {
		model.setCandidateOwner(candidateOwner);
	}

	/**
	 * Sets the candidate stage of this candidate other info.
	 *
	 * @param candidateStage the candidate stage of this candidate other info
	 */
	@Override
	public void setCandidateStage(String candidateStage) {
		model.setCandidateStage(candidateStage);
	}

	/**
	 * Sets the candidate status of this candidate other info.
	 *
	 * @param candidateStatus the candidate status of this candidate other info
	 */
	@Override
	public void setCandidateStatus(String candidateStatus) {
		model.setCandidateStatus(candidateStatus);
	}

	/**
	 * Sets the company of this candidate other info.
	 *
	 * @param company the company of this candidate other info
	 */
	@Override
	public void setCompany(String company) {
		model.setCompany(company);
	}

	/**
	 * Sets the company ID of this candidate other info.
	 *
	 * @param companyId the company ID of this candidate other info
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the degree of this candidate other info.
	 *
	 * @param degree the degree of this candidate other info
	 */
	@Override
	public void setDegree(String degree) {
		model.setDegree(degree);
	}

	/**
	 * Sets the department of this candidate other info.
	 *
	 * @param department the department of this candidate other info
	 */
	@Override
	public void setDepartment(String department) {
		model.setDepartment(department);
	}

	/**
	 * Sets the folder ID of this candidate other info.
	 *
	 * @param folderId the folder ID of this candidate other info
	 */
	@Override
	public void setFolderId(long folderId) {
		model.setFolderId(folderId);
	}

	/**
	 * Sets the from duration of this candidate other info.
	 *
	 * @param fromDuration the from duration of this candidate other info
	 */
	@Override
	public void setFromDuration(String fromDuration) {
		model.setFromDuration(fromDuration);
	}

	/**
	 * Sets the from work duration of this candidate other info.
	 *
	 * @param fromWorkDuration the from work duration of this candidate other info
	 */
	@Override
	public void setFromWorkDuration(String fromWorkDuration) {
		model.setFromWorkDuration(fromWorkDuration);
	}

	/**
	 * Sets the institute of this candidate other info.
	 *
	 * @param institute the institute of this candidate other info
	 */
	@Override
	public void setInstitute(String institute) {
		model.setInstitute(institute);
	}

	/**
	 * Sets the occupation of this candidate other info.
	 *
	 * @param occupation the occupation of this candidate other info
	 */
	@Override
	public void setOccupation(String occupation) {
		model.setOccupation(occupation);
	}

	/**
	 * Sets the primary key of this candidate other info.
	 *
	 * @param primaryKey the primary key of this candidate other info
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the source of this candidate other info.
	 *
	 * @param source the source of this candidate other info
	 */
	@Override
	public void setSource(String source) {
		model.setSource(source);
	}

	/**
	 * Sets the summary of this candidate other info.
	 *
	 * @param summary the summary of this candidate other info
	 */
	@Override
	public void setSummary(String summary) {
		model.setSummary(summary);
	}

	/**
	 * Sets the to duration of this candidate other info.
	 *
	 * @param toDuration the to duration of this candidate other info
	 */
	@Override
	public void setToDuration(String toDuration) {
		model.setToDuration(toDuration);
	}

	/**
	 * Sets the to work duration of this candidate other info.
	 *
	 * @param toWorkDuration the to work duration of this candidate other info
	 */
	@Override
	public void setToWorkDuration(String toWorkDuration) {
		model.setToWorkDuration(toWorkDuration);
	}

	/**
	 * Sets the user ID of this candidate other info.
	 *
	 * @param userId the user ID of this candidate other info
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this candidate other info.
	 *
	 * @param userUuid the user uuid of this candidate other info
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this candidate other info.
	 *
	 * @param uuid the uuid of this candidate other info
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CandidateOtherInfoWrapper wrap(
		CandidateOtherInfo candidateOtherInfo) {

		return new CandidateOtherInfoWrapper(candidateOtherInfo);
	}

}