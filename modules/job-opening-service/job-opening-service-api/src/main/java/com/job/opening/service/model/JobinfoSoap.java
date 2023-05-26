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

package com.job.opening.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.job.opening.service.service.http.JobinfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class JobinfoSoap implements Serializable {

	public static JobinfoSoap toSoapModel(Jobinfo model) {
		JobinfoSoap soapModel = new JobinfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setJobId(model.getJobId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPostingTitle(model.getPostingTitle());
		soapModel.setTitle(model.getTitle());
		soapModel.setAssignedRecruiter(model.getAssignedRecruiter());
		soapModel.setTargetDate(model.getTargetDate());
		soapModel.setJobopeningStatus(model.getJobopeningStatus());
		soapModel.setIndustry(model.getIndustry());
		soapModel.setJobResource(model.getJobResource());
		soapModel.setHiringManager(model.getHiringManager());
		soapModel.setClientName(model.getClientName());
		soapModel.setPositions(model.getPositions());
		soapModel.setDateOpened(model.getDateOpened());
		soapModel.setJobType(model.getJobType());
		soapModel.setWorkExperience(model.getWorkExperience());
		soapModel.setSkillSet(model.getSkillSet());
		soapModel.setProjectStatus(model.getProjectStatus());
		soapModel.setSummaryId(model.getSummaryId());
		soapModel.setOtherId(model.getOtherId());

		return soapModel;
	}

	public static JobinfoSoap[] toSoapModels(Jobinfo[] models) {
		JobinfoSoap[] soapModels = new JobinfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobinfoSoap[][] toSoapModels(Jobinfo[][] models) {
		JobinfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobinfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobinfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobinfoSoap[] toSoapModels(List<Jobinfo> models) {
		List<JobinfoSoap> soapModels = new ArrayList<JobinfoSoap>(
			models.size());

		for (Jobinfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobinfoSoap[soapModels.size()]);
	}

	public JobinfoSoap() {
	}

	public long getPrimaryKey() {
		return _jobId;
	}

	public void setPrimaryKey(long pk) {
		setJobId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getJobId() {
		return _jobId;
	}

	public void setJobId(long jobId) {
		_jobId = jobId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getPostingTitle() {
		return _postingTitle;
	}

	public void setPostingTitle(String postingTitle) {
		_postingTitle = postingTitle;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getAssignedRecruiter() {
		return _assignedRecruiter;
	}

	public void setAssignedRecruiter(String assignedRecruiter) {
		_assignedRecruiter = assignedRecruiter;
	}

	public Date getTargetDate() {
		return _targetDate;
	}

	public void setTargetDate(Date targetDate) {
		_targetDate = targetDate;
	}

	public String getJobopeningStatus() {
		return _jobopeningStatus;
	}

	public void setJobopeningStatus(String jobopeningStatus) {
		_jobopeningStatus = jobopeningStatus;
	}

	public String getIndustry() {
		return _industry;
	}

	public void setIndustry(String industry) {
		_industry = industry;
	}

	public String getJobResource() {
		return _jobResource;
	}

	public void setJobResource(String jobResource) {
		_jobResource = jobResource;
	}

	public String getHiringManager() {
		return _hiringManager;
	}

	public void setHiringManager(String hiringManager) {
		_hiringManager = hiringManager;
	}

	public String getClientName() {
		return _clientName;
	}

	public void setClientName(String clientName) {
		_clientName = clientName;
	}

	public String getPositions() {
		return _positions;
	}

	public void setPositions(String positions) {
		_positions = positions;
	}

	public Date getDateOpened() {
		return _dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		_dateOpened = dateOpened;
	}

	public String getJobType() {
		return _jobType;
	}

	public void setJobType(String jobType) {
		_jobType = jobType;
	}

	public String getWorkExperience() {
		return _workExperience;
	}

	public void setWorkExperience(String workExperience) {
		_workExperience = workExperience;
	}

	public String getSkillSet() {
		return _skillSet;
	}

	public void setSkillSet(String skillSet) {
		_skillSet = skillSet;
	}

	public String getProjectStatus() {
		return _projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		_projectStatus = projectStatus;
	}

	public long getSummaryId() {
		return _summaryId;
	}

	public void setSummaryId(long summaryId) {
		_summaryId = summaryId;
	}

	public long getOtherId() {
		return _otherId;
	}

	public void setOtherId(long otherId) {
		_otherId = otherId;
	}

	private String _uuid;
	private long _jobId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _modifiedDate;
	private String _postingTitle;
	private String _title;
	private String _assignedRecruiter;
	private Date _targetDate;
	private String _jobopeningStatus;
	private String _industry;
	private String _jobResource;
	private String _hiringManager;
	private String _clientName;
	private String _positions;
	private Date _dateOpened;
	private String _jobType;
	private String _workExperience;
	private String _skillSet;
	private String _projectStatus;
	private long _summaryId;
	private long _otherId;

}