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

package com.esquare.intranet.project.management.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Tasks}.
 * </p>
 *
 * @author Mahammed Seleem
 * @see Tasks
 * @generated
 */
public class TasksWrapper
	extends BaseModelWrapper<Tasks> implements ModelWrapper<Tasks>, Tasks {

	public TasksWrapper(Tasks tasks) {
		super(tasks);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("taskId", getTaskId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("developerTeam", getDeveloperTeam());
		attributes.put("testerTeam", getTesterTeam());
		attributes.put("taskStartDate", getTaskStartDate());
		attributes.put("taskEndDate", getTaskEndDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("projectId", getProjectId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String developerTeam = (String)attributes.get("developerTeam");

		if (developerTeam != null) {
			setDeveloperTeam(developerTeam);
		}

		String testerTeam = (String)attributes.get("testerTeam");

		if (testerTeam != null) {
			setTesterTeam(testerTeam);
		}

		Date taskStartDate = (Date)attributes.get("taskStartDate");

		if (taskStartDate != null) {
			setTaskStartDate(taskStartDate);
		}

		Date taskEndDate = (Date)attributes.get("taskEndDate");

		if (taskEndDate != null) {
			setTaskEndDate(taskEndDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}
	}

	@Override
	public Tasks cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the description of this tasks.
	 *
	 * @return the description of this tasks
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the developer team of this tasks.
	 *
	 * @return the developer team of this tasks
	 */
	@Override
	public String getDeveloperTeam() {
		return model.getDeveloperTeam();
	}

	/**
	 * Returns the name of this tasks.
	 *
	 * @return the name of this tasks
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this tasks.
	 *
	 * @return the primary key of this tasks
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this tasks.
	 *
	 * @return the project ID of this tasks
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the status of this tasks.
	 *
	 * @return the status of this tasks
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this tasks.
	 *
	 * @return the status by user ID of this tasks
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this tasks.
	 *
	 * @return the status by user name of this tasks
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this tasks.
	 *
	 * @return the status by user uuid of this tasks
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this tasks.
	 *
	 * @return the status date of this tasks
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the task end date of this tasks.
	 *
	 * @return the task end date of this tasks
	 */
	@Override
	public Date getTaskEndDate() {
		return model.getTaskEndDate();
	}

	/**
	 * Returns the task ID of this tasks.
	 *
	 * @return the task ID of this tasks
	 */
	@Override
	public long getTaskId() {
		return model.getTaskId();
	}

	/**
	 * Returns the task start date of this tasks.
	 *
	 * @return the task start date of this tasks
	 */
	@Override
	public Date getTaskStartDate() {
		return model.getTaskStartDate();
	}

	/**
	 * Returns the tester team of this tasks.
	 *
	 * @return the tester team of this tasks
	 */
	@Override
	public String getTesterTeam() {
		return model.getTesterTeam();
	}

	/**
	 * Returns the uuid of this tasks.
	 *
	 * @return the uuid of this tasks
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this tasks is approved.
	 *
	 * @return <code>true</code> if this tasks is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this tasks is denied.
	 *
	 * @return <code>true</code> if this tasks is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this tasks is a draft.
	 *
	 * @return <code>true</code> if this tasks is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this tasks is expired.
	 *
	 * @return <code>true</code> if this tasks is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this tasks is inactive.
	 *
	 * @return <code>true</code> if this tasks is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this tasks is incomplete.
	 *
	 * @return <code>true</code> if this tasks is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this tasks is pending.
	 *
	 * @return <code>true</code> if this tasks is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this tasks is scheduled.
	 *
	 * @return <code>true</code> if this tasks is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the description of this tasks.
	 *
	 * @param description the description of this tasks
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the developer team of this tasks.
	 *
	 * @param developerTeam the developer team of this tasks
	 */
	@Override
	public void setDeveloperTeam(String developerTeam) {
		model.setDeveloperTeam(developerTeam);
	}

	/**
	 * Sets the name of this tasks.
	 *
	 * @param name the name of this tasks
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this tasks.
	 *
	 * @param primaryKey the primary key of this tasks
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this tasks.
	 *
	 * @param projectId the project ID of this tasks
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the status of this tasks.
	 *
	 * @param status the status of this tasks
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this tasks.
	 *
	 * @param statusByUserId the status by user ID of this tasks
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this tasks.
	 *
	 * @param statusByUserName the status by user name of this tasks
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this tasks.
	 *
	 * @param statusByUserUuid the status by user uuid of this tasks
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this tasks.
	 *
	 * @param statusDate the status date of this tasks
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the task end date of this tasks.
	 *
	 * @param taskEndDate the task end date of this tasks
	 */
	@Override
	public void setTaskEndDate(Date taskEndDate) {
		model.setTaskEndDate(taskEndDate);
	}

	/**
	 * Sets the task ID of this tasks.
	 *
	 * @param taskId the task ID of this tasks
	 */
	@Override
	public void setTaskId(long taskId) {
		model.setTaskId(taskId);
	}

	/**
	 * Sets the task start date of this tasks.
	 *
	 * @param taskStartDate the task start date of this tasks
	 */
	@Override
	public void setTaskStartDate(Date taskStartDate) {
		model.setTaskStartDate(taskStartDate);
	}

	/**
	 * Sets the tester team of this tasks.
	 *
	 * @param testerTeam the tester team of this tasks
	 */
	@Override
	public void setTesterTeam(String testerTeam) {
		model.setTesterTeam(testerTeam);
	}

	/**
	 * Sets the uuid of this tasks.
	 *
	 * @param uuid the uuid of this tasks
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TasksWrapper wrap(Tasks tasks) {
		return new TasksWrapper(tasks);
	}

}