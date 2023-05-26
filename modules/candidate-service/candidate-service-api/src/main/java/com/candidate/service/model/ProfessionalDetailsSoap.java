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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.candidate.service.service.http.ProfessionalDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ProfessionalDetailsSoap implements Serializable {

	public static ProfessionalDetailsSoap toSoapModel(
		ProfessionalDetails model) {

		ProfessionalDetailsSoap soapModel = new ProfessionalDetailsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProfessionalDetailsId(model.getProfessionalDetailsId());
		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setExpectedSalary(model.getExpectedSalary());
		soapModel.setCurrentSalary(model.getCurrentSalary());
		soapModel.setSkillSet(model.getSkillSet());
		soapModel.setAdditionalInfo(model.getAdditionalInfo());
		soapModel.setCurrentEmployer(model.getCurrentEmployer());
		soapModel.setWorkType(model.getWorkType());
		soapModel.setExperience(model.getExperience());
		soapModel.setQualification(model.getQualification());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static ProfessionalDetailsSoap[] toSoapModels(
		ProfessionalDetails[] models) {

		ProfessionalDetailsSoap[] soapModels =
			new ProfessionalDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProfessionalDetailsSoap[][] toSoapModels(
		ProfessionalDetails[][] models) {

		ProfessionalDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProfessionalDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProfessionalDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProfessionalDetailsSoap[] toSoapModels(
		List<ProfessionalDetails> models) {

		List<ProfessionalDetailsSoap> soapModels =
			new ArrayList<ProfessionalDetailsSoap>(models.size());

		for (ProfessionalDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ProfessionalDetailsSoap[soapModels.size()]);
	}

	public ProfessionalDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _professionalDetailsId;
	}

	public void setPrimaryKey(long pk) {
		setProfessionalDetailsId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProfessionalDetailsId() {
		return _professionalDetailsId;
	}

	public void setProfessionalDetailsId(long professionalDetailsId) {
		_professionalDetailsId = professionalDetailsId;
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public double getExpectedSalary() {
		return _expectedSalary;
	}

	public void setExpectedSalary(double expectedSalary) {
		_expectedSalary = expectedSalary;
	}

	public double getCurrentSalary() {
		return _currentSalary;
	}

	public void setCurrentSalary(double currentSalary) {
		_currentSalary = currentSalary;
	}

	public String getSkillSet() {
		return _skillSet;
	}

	public void setSkillSet(String skillSet) {
		_skillSet = skillSet;
	}

	public String getAdditionalInfo() {
		return _additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		_additionalInfo = additionalInfo;
	}

	public String getCurrentEmployer() {
		return _currentEmployer;
	}

	public void setCurrentEmployer(String currentEmployer) {
		_currentEmployer = currentEmployer;
	}

	public String getWorkType() {
		return _workType;
	}

	public void setWorkType(String workType) {
		_workType = workType;
	}

	public String getExperience() {
		return _experience;
	}

	public void setExperience(String experience) {
		_experience = experience;
	}

	public String getQualification() {
		return _qualification;
	}

	public void setQualification(String qualification) {
		_qualification = qualification;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private String _uuid;
	private long _professionalDetailsId;
	private long _candidateId;
	private double _expectedSalary;
	private double _currentSalary;
	private String _skillSet;
	private String _additionalInfo;
	private String _currentEmployer;
	private String _workType;
	private String _experience;
	private String _qualification;
	private String _jobTitle;
	private long _companyId;
	private long _userId;

}