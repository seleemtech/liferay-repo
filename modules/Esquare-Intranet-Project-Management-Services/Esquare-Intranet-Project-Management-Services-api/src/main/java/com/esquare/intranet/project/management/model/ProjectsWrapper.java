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
 * This class is a wrapper for {@link Projects}.
 * </p>
 *
 * @author Mahammed Seleem
 * @see Projects
 * @generated
 */
public class ProjectsWrapper
	extends BaseModelWrapper<Projects>
	implements ModelWrapper<Projects>, Projects {

	public ProjectsWrapper(Projects projects) {
		super(projects);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectId", getProjectId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("projectName", getProjectName());
		attributes.put("description", getDescription());
		attributes.put("proposedDate", getProposedDate());
		attributes.put("confirmedDate", getConfirmedDate());
		attributes.put("developmentStartDate", getDevelopmentStartDate());
		attributes.put("estimatedDate", getEstimatedDate());
		attributes.put("durationDate", getDurationDate());
		attributes.put("status", getStatus());
		attributes.put("code", getCode());
		attributes.put("documentId", getDocumentId());
		attributes.put("resourceIdSettings", getResourceIdSettings());
		attributes.put("name", getName());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("contactEmail", getContactEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
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

		String projectName = (String)attributes.get("projectName");

		if (projectName != null) {
			setProjectName(projectName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date proposedDate = (Date)attributes.get("proposedDate");

		if (proposedDate != null) {
			setProposedDate(proposedDate);
		}

		Date confirmedDate = (Date)attributes.get("confirmedDate");

		if (confirmedDate != null) {
			setConfirmedDate(confirmedDate);
		}

		Date developmentStartDate = (Date)attributes.get(
			"developmentStartDate");

		if (developmentStartDate != null) {
			setDevelopmentStartDate(developmentStartDate);
		}

		Date estimatedDate = (Date)attributes.get("estimatedDate");

		if (estimatedDate != null) {
			setEstimatedDate(estimatedDate);
		}

		String durationDate = (String)attributes.get("durationDate");

		if (durationDate != null) {
			setDurationDate(durationDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer code = (Integer)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		String resourceIdSettings = (String)attributes.get(
			"resourceIdSettings");

		if (resourceIdSettings != null) {
			setResourceIdSettings(resourceIdSettings);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String contactEmail = (String)attributes.get("contactEmail");

		if (contactEmail != null) {
			setContactEmail(contactEmail);
		}
	}

	@Override
	public Projects cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the code of this projects.
	 *
	 * @return the code of this projects
	 */
	@Override
	public int getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this projects.
	 *
	 * @return the company ID of this projects
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the confirmed date of this projects.
	 *
	 * @return the confirmed date of this projects
	 */
	@Override
	public Date getConfirmedDate() {
		return model.getConfirmedDate();
	}

	/**
	 * Returns the contact email of this projects.
	 *
	 * @return the contact email of this projects
	 */
	@Override
	public String getContactEmail() {
		return model.getContactEmail();
	}

	/**
	 * Returns the contact number of this projects.
	 *
	 * @return the contact number of this projects
	 */
	@Override
	public String getContactNumber() {
		return model.getContactNumber();
	}

	/**
	 * Returns the description of this projects.
	 *
	 * @return the description of this projects
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the development start date of this projects.
	 *
	 * @return the development start date of this projects
	 */
	@Override
	public Date getDevelopmentStartDate() {
		return model.getDevelopmentStartDate();
	}

	/**
	 * Returns the document ID of this projects.
	 *
	 * @return the document ID of this projects
	 */
	@Override
	public long getDocumentId() {
		return model.getDocumentId();
	}

	/**
	 * Returns the duration date of this projects.
	 *
	 * @return the duration date of this projects
	 */
	@Override
	public String getDurationDate() {
		return model.getDurationDate();
	}

	/**
	 * Returns the estimated date of this projects.
	 *
	 * @return the estimated date of this projects
	 */
	@Override
	public Date getEstimatedDate() {
		return model.getEstimatedDate();
	}

	/**
	 * Returns the group ID of this projects.
	 *
	 * @return the group ID of this projects
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the name of this projects.
	 *
	 * @return the name of this projects
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this projects.
	 *
	 * @return the primary key of this projects
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this projects.
	 *
	 * @return the project ID of this projects
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the project name of this projects.
	 *
	 * @return the project name of this projects
	 */
	@Override
	public String getProjectName() {
		return model.getProjectName();
	}

	/**
	 * Returns the proposed date of this projects.
	 *
	 * @return the proposed date of this projects
	 */
	@Override
	public Date getProposedDate() {
		return model.getProposedDate();
	}

	/**
	 * Returns the resource ID settings of this projects.
	 *
	 * @return the resource ID settings of this projects
	 */
	@Override
	public String getResourceIdSettings() {
		return model.getResourceIdSettings();
	}

	/**
	 * Returns the status of this projects.
	 *
	 * @return the status of this projects
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user ID of this projects.
	 *
	 * @return the user ID of this projects
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this projects.
	 *
	 * @return the user name of this projects
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this projects.
	 *
	 * @return the user uuid of this projects
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this projects.
	 *
	 * @return the uuid of this projects
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
	 * Sets the code of this projects.
	 *
	 * @param code the code of this projects
	 */
	@Override
	public void setCode(int code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this projects.
	 *
	 * @param companyId the company ID of this projects
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the confirmed date of this projects.
	 *
	 * @param confirmedDate the confirmed date of this projects
	 */
	@Override
	public void setConfirmedDate(Date confirmedDate) {
		model.setConfirmedDate(confirmedDate);
	}

	/**
	 * Sets the contact email of this projects.
	 *
	 * @param contactEmail the contact email of this projects
	 */
	@Override
	public void setContactEmail(String contactEmail) {
		model.setContactEmail(contactEmail);
	}

	/**
	 * Sets the contact number of this projects.
	 *
	 * @param contactNumber the contact number of this projects
	 */
	@Override
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}

	/**
	 * Sets the description of this projects.
	 *
	 * @param description the description of this projects
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the development start date of this projects.
	 *
	 * @param developmentStartDate the development start date of this projects
	 */
	@Override
	public void setDevelopmentStartDate(Date developmentStartDate) {
		model.setDevelopmentStartDate(developmentStartDate);
	}

	/**
	 * Sets the document ID of this projects.
	 *
	 * @param documentId the document ID of this projects
	 */
	@Override
	public void setDocumentId(long documentId) {
		model.setDocumentId(documentId);
	}

	/**
	 * Sets the duration date of this projects.
	 *
	 * @param durationDate the duration date of this projects
	 */
	@Override
	public void setDurationDate(String durationDate) {
		model.setDurationDate(durationDate);
	}

	/**
	 * Sets the estimated date of this projects.
	 *
	 * @param estimatedDate the estimated date of this projects
	 */
	@Override
	public void setEstimatedDate(Date estimatedDate) {
		model.setEstimatedDate(estimatedDate);
	}

	/**
	 * Sets the group ID of this projects.
	 *
	 * @param groupId the group ID of this projects
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the name of this projects.
	 *
	 * @param name the name of this projects
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this projects.
	 *
	 * @param primaryKey the primary key of this projects
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this projects.
	 *
	 * @param projectId the project ID of this projects
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the project name of this projects.
	 *
	 * @param projectName the project name of this projects
	 */
	@Override
	public void setProjectName(String projectName) {
		model.setProjectName(projectName);
	}

	/**
	 * Sets the proposed date of this projects.
	 *
	 * @param proposedDate the proposed date of this projects
	 */
	@Override
	public void setProposedDate(Date proposedDate) {
		model.setProposedDate(proposedDate);
	}

	/**
	 * Sets the resource ID settings of this projects.
	 *
	 * @param resourceIdSettings the resource ID settings of this projects
	 */
	@Override
	public void setResourceIdSettings(String resourceIdSettings) {
		model.setResourceIdSettings(resourceIdSettings);
	}

	/**
	 * Sets the status of this projects.
	 *
	 * @param status the status of this projects
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user ID of this projects.
	 *
	 * @param userId the user ID of this projects
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this projects.
	 *
	 * @param userName the user name of this projects
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this projects.
	 *
	 * @param userUuid the user uuid of this projects
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this projects.
	 *
	 * @param uuid the uuid of this projects
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
	protected ProjectsWrapper wrap(Projects projects) {
		return new ProjectsWrapper(projects);
	}

}