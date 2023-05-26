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
 * This class is used by SOAP remote services, specifically {@link com.candidate.service.service.http.CandidateOtherInfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CandidateOtherInfoSoap implements Serializable {

	public static CandidateOtherInfoSoap toSoapModel(CandidateOtherInfo model) {
		CandidateOtherInfoSoap soapModel = new CandidateOtherInfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCandidateOtherInfoId(model.getCandidateOtherInfoId());
		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setCandidateStatus(model.getCandidateStatus());
		soapModel.setCandidateStage(model.getCandidateStage());
		soapModel.setSource(model.getSource());
		soapModel.setCandidateOwner(model.getCandidateOwner());
		soapModel.setInstitute(model.getInstitute());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setDegree(model.getDegree());
		soapModel.setFromDuration(model.getFromDuration());
		soapModel.setToDuration(model.getToDuration());
		soapModel.setOccupation(model.getOccupation());
		soapModel.setCompany(model.getCompany());
		soapModel.setSummary(model.getSummary());
		soapModel.setFromWorkDuration(model.getFromWorkDuration());
		soapModel.setToWorkDuration(model.getToWorkDuration());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setFolderId(model.getFolderId());

		return soapModel;
	}

	public static CandidateOtherInfoSoap[] toSoapModels(
		CandidateOtherInfo[] models) {

		CandidateOtherInfoSoap[] soapModels =
			new CandidateOtherInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateOtherInfoSoap[][] toSoapModels(
		CandidateOtherInfo[][] models) {

		CandidateOtherInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CandidateOtherInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateOtherInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateOtherInfoSoap[] toSoapModels(
		List<CandidateOtherInfo> models) {

		List<CandidateOtherInfoSoap> soapModels =
			new ArrayList<CandidateOtherInfoSoap>(models.size());

		for (CandidateOtherInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CandidateOtherInfoSoap[soapModels.size()]);
	}

	public CandidateOtherInfoSoap() {
	}

	public long getPrimaryKey() {
		return _candidateOtherInfoId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateOtherInfoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCandidateOtherInfoId() {
		return _candidateOtherInfoId;
	}

	public void setCandidateOtherInfoId(long candidateOtherInfoId) {
		_candidateOtherInfoId = candidateOtherInfoId;
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public String getCandidateStatus() {
		return _candidateStatus;
	}

	public void setCandidateStatus(String candidateStatus) {
		_candidateStatus = candidateStatus;
	}

	public String getCandidateStage() {
		return _candidateStage;
	}

	public void setCandidateStage(String candidateStage) {
		_candidateStage = candidateStage;
	}

	public String getSource() {
		return _source;
	}

	public void setSource(String source) {
		_source = source;
	}

	public String getCandidateOwner() {
		return _candidateOwner;
	}

	public void setCandidateOwner(String candidateOwner) {
		_candidateOwner = candidateOwner;
	}

	public String getInstitute() {
		return _institute;
	}

	public void setInstitute(String institute) {
		_institute = institute;
	}

	public String getDepartment() {
		return _department;
	}

	public void setDepartment(String department) {
		_department = department;
	}

	public String getDegree() {
		return _degree;
	}

	public void setDegree(String degree) {
		_degree = degree;
	}

	public String getFromDuration() {
		return _fromDuration;
	}

	public void setFromDuration(String fromDuration) {
		_fromDuration = fromDuration;
	}

	public String getToDuration() {
		return _toDuration;
	}

	public void setToDuration(String toDuration) {
		_toDuration = toDuration;
	}

	public String getOccupation() {
		return _occupation;
	}

	public void setOccupation(String occupation) {
		_occupation = occupation;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public String getFromWorkDuration() {
		return _fromWorkDuration;
	}

	public void setFromWorkDuration(String fromWorkDuration) {
		_fromWorkDuration = fromWorkDuration;
	}

	public String getToWorkDuration() {
		return _toWorkDuration;
	}

	public void setToWorkDuration(String toWorkDuration) {
		_toWorkDuration = toWorkDuration;
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

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	private String _uuid;
	private long _candidateOtherInfoId;
	private long _candidateId;
	private String _candidateStatus;
	private String _candidateStage;
	private String _source;
	private String _candidateOwner;
	private String _institute;
	private String _department;
	private String _degree;
	private String _fromDuration;
	private String _toDuration;
	private String _occupation;
	private String _company;
	private String _summary;
	private String _fromWorkDuration;
	private String _toWorkDuration;
	private long _companyId;
	private long _userId;
	private long _folderId;

}