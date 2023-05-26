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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Jobinfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Jobinfo
 * @generated
 */
public class JobinfoWrapper
	extends BaseModelWrapper<Jobinfo>
	implements Jobinfo, ModelWrapper<Jobinfo> {

	public JobinfoWrapper(Jobinfo jobinfo) {
		super(jobinfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("jobId", getJobId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("postingTitle", getPostingTitle());
		attributes.put("title", getTitle());
		attributes.put("assignedRecruiter", getAssignedRecruiter());
		attributes.put("targetDate", getTargetDate());
		attributes.put("jobopeningStatus", getJobopeningStatus());
		attributes.put("industry", getIndustry());
		attributes.put("jobResource", getJobResource());
		attributes.put("hiringManager", getHiringManager());
		attributes.put("clientName", getClientName());
		attributes.put("positions", getPositions());
		attributes.put("dateOpened", getDateOpened());
		attributes.put("jobType", getJobType());
		attributes.put("workExperience", getWorkExperience());
		attributes.put("skillSet", getSkillSet());
		attributes.put("projectStatus", getProjectStatus());
		attributes.put("summaryId", getSummaryId());
		attributes.put("otherId", getOtherId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String postingTitle = (String)attributes.get("postingTitle");

		if (postingTitle != null) {
			setPostingTitle(postingTitle);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String assignedRecruiter = (String)attributes.get("assignedRecruiter");

		if (assignedRecruiter != null) {
			setAssignedRecruiter(assignedRecruiter);
		}

		Date targetDate = (Date)attributes.get("targetDate");

		if (targetDate != null) {
			setTargetDate(targetDate);
		}

		String jobopeningStatus = (String)attributes.get("jobopeningStatus");

		if (jobopeningStatus != null) {
			setJobopeningStatus(jobopeningStatus);
		}

		String industry = (String)attributes.get("industry");

		if (industry != null) {
			setIndustry(industry);
		}

		String jobResource = (String)attributes.get("jobResource");

		if (jobResource != null) {
			setJobResource(jobResource);
		}

		String hiringManager = (String)attributes.get("hiringManager");

		if (hiringManager != null) {
			setHiringManager(hiringManager);
		}

		String clientName = (String)attributes.get("clientName");

		if (clientName != null) {
			setClientName(clientName);
		}

		String positions = (String)attributes.get("positions");

		if (positions != null) {
			setPositions(positions);
		}

		Date dateOpened = (Date)attributes.get("dateOpened");

		if (dateOpened != null) {
			setDateOpened(dateOpened);
		}

		String jobType = (String)attributes.get("jobType");

		if (jobType != null) {
			setJobType(jobType);
		}

		String workExperience = (String)attributes.get("workExperience");

		if (workExperience != null) {
			setWorkExperience(workExperience);
		}

		String skillSet = (String)attributes.get("skillSet");

		if (skillSet != null) {
			setSkillSet(skillSet);
		}

		String projectStatus = (String)attributes.get("projectStatus");

		if (projectStatus != null) {
			setProjectStatus(projectStatus);
		}

		Long summaryId = (Long)attributes.get("summaryId");

		if (summaryId != null) {
			setSummaryId(summaryId);
		}

		Long otherId = (Long)attributes.get("otherId");

		if (otherId != null) {
			setOtherId(otherId);
		}
	}

	@Override
	public Jobinfo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the assigned recruiter of this jobinfo.
	 *
	 * @return the assigned recruiter of this jobinfo
	 */
	@Override
	public String getAssignedRecruiter() {
		return model.getAssignedRecruiter();
	}

	/**
	 * Returns the client name of this jobinfo.
	 *
	 * @return the client name of this jobinfo
	 */
	@Override
	public String getClientName() {
		return model.getClientName();
	}

	/**
	 * Returns the company ID of this jobinfo.
	 *
	 * @return the company ID of this jobinfo
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the date opened of this jobinfo.
	 *
	 * @return the date opened of this jobinfo
	 */
	@Override
	public Date getDateOpened() {
		return model.getDateOpened();
	}

	/**
	 * Returns the group ID of this jobinfo.
	 *
	 * @return the group ID of this jobinfo
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hiring manager of this jobinfo.
	 *
	 * @return the hiring manager of this jobinfo
	 */
	@Override
	public String getHiringManager() {
		return model.getHiringManager();
	}

	/**
	 * Returns the industry of this jobinfo.
	 *
	 * @return the industry of this jobinfo
	 */
	@Override
	public String getIndustry() {
		return model.getIndustry();
	}

	/**
	 * Returns the job ID of this jobinfo.
	 *
	 * @return the job ID of this jobinfo
	 */
	@Override
	public long getJobId() {
		return model.getJobId();
	}

	/**
	 * Returns the jobopening status of this jobinfo.
	 *
	 * @return the jobopening status of this jobinfo
	 */
	@Override
	public String getJobopeningStatus() {
		return model.getJobopeningStatus();
	}

	/**
	 * Returns the job resource of this jobinfo.
	 *
	 * @return the job resource of this jobinfo
	 */
	@Override
	public String getJobResource() {
		return model.getJobResource();
	}

	/**
	 * Returns the job type of this jobinfo.
	 *
	 * @return the job type of this jobinfo
	 */
	@Override
	public String getJobType() {
		return model.getJobType();
	}

	/**
	 * Returns the modified date of this jobinfo.
	 *
	 * @return the modified date of this jobinfo
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the other ID of this jobinfo.
	 *
	 * @return the other ID of this jobinfo
	 */
	@Override
	public long getOtherId() {
		return model.getOtherId();
	}

	/**
	 * Returns the positions of this jobinfo.
	 *
	 * @return the positions of this jobinfo
	 */
	@Override
	public String getPositions() {
		return model.getPositions();
	}

	/**
	 * Returns the posting title of this jobinfo.
	 *
	 * @return the posting title of this jobinfo
	 */
	@Override
	public String getPostingTitle() {
		return model.getPostingTitle();
	}

	/**
	 * Returns the primary key of this jobinfo.
	 *
	 * @return the primary key of this jobinfo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project status of this jobinfo.
	 *
	 * @return the project status of this jobinfo
	 */
	@Override
	public String getProjectStatus() {
		return model.getProjectStatus();
	}

	/**
	 * Returns the skill set of this jobinfo.
	 *
	 * @return the skill set of this jobinfo
	 */
	@Override
	public String getSkillSet() {
		return model.getSkillSet();
	}

	/**
	 * Returns the summary ID of this jobinfo.
	 *
	 * @return the summary ID of this jobinfo
	 */
	@Override
	public long getSummaryId() {
		return model.getSummaryId();
	}

	/**
	 * Returns the target date of this jobinfo.
	 *
	 * @return the target date of this jobinfo
	 */
	@Override
	public Date getTargetDate() {
		return model.getTargetDate();
	}

	/**
	 * Returns the title of this jobinfo.
	 *
	 * @return the title of this jobinfo
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this jobinfo.
	 *
	 * @return the user ID of this jobinfo
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this jobinfo.
	 *
	 * @return the user name of this jobinfo
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this jobinfo.
	 *
	 * @return the user uuid of this jobinfo
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this jobinfo.
	 *
	 * @return the uuid of this jobinfo
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the work experience of this jobinfo.
	 *
	 * @return the work experience of this jobinfo
	 */
	@Override
	public String getWorkExperience() {
		return model.getWorkExperience();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the assigned recruiter of this jobinfo.
	 *
	 * @param assignedRecruiter the assigned recruiter of this jobinfo
	 */
	@Override
	public void setAssignedRecruiter(String assignedRecruiter) {
		model.setAssignedRecruiter(assignedRecruiter);
	}

	/**
	 * Sets the client name of this jobinfo.
	 *
	 * @param clientName the client name of this jobinfo
	 */
	@Override
	public void setClientName(String clientName) {
		model.setClientName(clientName);
	}

	/**
	 * Sets the company ID of this jobinfo.
	 *
	 * @param companyId the company ID of this jobinfo
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the date opened of this jobinfo.
	 *
	 * @param dateOpened the date opened of this jobinfo
	 */
	@Override
	public void setDateOpened(Date dateOpened) {
		model.setDateOpened(dateOpened);
	}

	/**
	 * Sets the group ID of this jobinfo.
	 *
	 * @param groupId the group ID of this jobinfo
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hiring manager of this jobinfo.
	 *
	 * @param hiringManager the hiring manager of this jobinfo
	 */
	@Override
	public void setHiringManager(String hiringManager) {
		model.setHiringManager(hiringManager);
	}

	/**
	 * Sets the industry of this jobinfo.
	 *
	 * @param industry the industry of this jobinfo
	 */
	@Override
	public void setIndustry(String industry) {
		model.setIndustry(industry);
	}

	/**
	 * Sets the job ID of this jobinfo.
	 *
	 * @param jobId the job ID of this jobinfo
	 */
	@Override
	public void setJobId(long jobId) {
		model.setJobId(jobId);
	}

	/**
	 * Sets the jobopening status of this jobinfo.
	 *
	 * @param jobopeningStatus the jobopening status of this jobinfo
	 */
	@Override
	public void setJobopeningStatus(String jobopeningStatus) {
		model.setJobopeningStatus(jobopeningStatus);
	}

	/**
	 * Sets the job resource of this jobinfo.
	 *
	 * @param jobResource the job resource of this jobinfo
	 */
	@Override
	public void setJobResource(String jobResource) {
		model.setJobResource(jobResource);
	}

	/**
	 * Sets the job type of this jobinfo.
	 *
	 * @param jobType the job type of this jobinfo
	 */
	@Override
	public void setJobType(String jobType) {
		model.setJobType(jobType);
	}

	/**
	 * Sets the modified date of this jobinfo.
	 *
	 * @param modifiedDate the modified date of this jobinfo
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the other ID of this jobinfo.
	 *
	 * @param otherId the other ID of this jobinfo
	 */
	@Override
	public void setOtherId(long otherId) {
		model.setOtherId(otherId);
	}

	/**
	 * Sets the positions of this jobinfo.
	 *
	 * @param positions the positions of this jobinfo
	 */
	@Override
	public void setPositions(String positions) {
		model.setPositions(positions);
	}

	/**
	 * Sets the posting title of this jobinfo.
	 *
	 * @param postingTitle the posting title of this jobinfo
	 */
	@Override
	public void setPostingTitle(String postingTitle) {
		model.setPostingTitle(postingTitle);
	}

	/**
	 * Sets the primary key of this jobinfo.
	 *
	 * @param primaryKey the primary key of this jobinfo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project status of this jobinfo.
	 *
	 * @param projectStatus the project status of this jobinfo
	 */
	@Override
	public void setProjectStatus(String projectStatus) {
		model.setProjectStatus(projectStatus);
	}

	/**
	 * Sets the skill set of this jobinfo.
	 *
	 * @param skillSet the skill set of this jobinfo
	 */
	@Override
	public void setSkillSet(String skillSet) {
		model.setSkillSet(skillSet);
	}

	/**
	 * Sets the summary ID of this jobinfo.
	 *
	 * @param summaryId the summary ID of this jobinfo
	 */
	@Override
	public void setSummaryId(long summaryId) {
		model.setSummaryId(summaryId);
	}

	/**
	 * Sets the target date of this jobinfo.
	 *
	 * @param targetDate the target date of this jobinfo
	 */
	@Override
	public void setTargetDate(Date targetDate) {
		model.setTargetDate(targetDate);
	}

	/**
	 * Sets the title of this jobinfo.
	 *
	 * @param title the title of this jobinfo
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this jobinfo.
	 *
	 * @param userId the user ID of this jobinfo
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this jobinfo.
	 *
	 * @param userName the user name of this jobinfo
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this jobinfo.
	 *
	 * @param userUuid the user uuid of this jobinfo
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this jobinfo.
	 *
	 * @param uuid the uuid of this jobinfo
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the work experience of this jobinfo.
	 *
	 * @param workExperience the work experience of this jobinfo
	 */
	@Override
	public void setWorkExperience(String workExperience) {
		model.setWorkExperience(workExperience);
	}

	@Override
	protected JobinfoWrapper wrap(Jobinfo jobinfo) {
		return new JobinfoWrapper(jobinfo);
	}

}