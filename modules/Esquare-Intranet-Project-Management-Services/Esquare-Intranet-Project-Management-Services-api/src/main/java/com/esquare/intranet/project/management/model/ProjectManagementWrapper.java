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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProjectManagement}.
 * </p>
 *
 * @author Mahammed Seleem
 * @see ProjectManagement
 * @generated
 */
public class ProjectManagementWrapper
	extends BaseModelWrapper<ProjectManagement>
	implements ModelWrapper<ProjectManagement>, ProjectManagement {

	public ProjectManagementWrapper(ProjectManagement projectManagement) {
		super(projectManagement);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectMgmtId", getProjectMgmtId());
		attributes.put("name", getName());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("contactEmail", getContactEmail());
		attributes.put("projectName", getProjectName());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectMgmtId = (Long)attributes.get("projectMgmtId");

		if (projectMgmtId != null) {
			setProjectMgmtId(projectMgmtId);
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

		String projectName = (String)attributes.get("projectName");

		if (projectName != null) {
			setProjectName(projectName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	}

	@Override
	public ProjectManagement cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this project management.
	 *
	 * @return the company ID of this project management
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact email of this project management.
	 *
	 * @return the contact email of this project management
	 */
	@Override
	public String getContactEmail() {
		return model.getContactEmail();
	}

	/**
	 * Returns the contact number of this project management.
	 *
	 * @return the contact number of this project management
	 */
	@Override
	public String getContactNumber() {
		return model.getContactNumber();
	}

	/**
	 * Returns the description of this project management.
	 *
	 * @return the description of this project management
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this project management.
	 *
	 * @return the group ID of this project management
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the name of this project management.
	 *
	 * @return the name of this project management
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this project management.
	 *
	 * @return the primary key of this project management
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project mgmt ID of this project management.
	 *
	 * @return the project mgmt ID of this project management
	 */
	@Override
	public long getProjectMgmtId() {
		return model.getProjectMgmtId();
	}

	/**
	 * Returns the project name of this project management.
	 *
	 * @return the project name of this project management
	 */
	@Override
	public String getProjectName() {
		return model.getProjectName();
	}

	/**
	 * Returns the user ID of this project management.
	 *
	 * @return the user ID of this project management
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this project management.
	 *
	 * @return the user name of this project management
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this project management.
	 *
	 * @return the user uuid of this project management
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this project management.
	 *
	 * @return the uuid of this project management
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
	 * Sets the company ID of this project management.
	 *
	 * @param companyId the company ID of this project management
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact email of this project management.
	 *
	 * @param contactEmail the contact email of this project management
	 */
	@Override
	public void setContactEmail(String contactEmail) {
		model.setContactEmail(contactEmail);
	}

	/**
	 * Sets the contact number of this project management.
	 *
	 * @param contactNumber the contact number of this project management
	 */
	@Override
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}

	/**
	 * Sets the description of this project management.
	 *
	 * @param description the description of this project management
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this project management.
	 *
	 * @param groupId the group ID of this project management
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the name of this project management.
	 *
	 * @param name the name of this project management
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this project management.
	 *
	 * @param primaryKey the primary key of this project management
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project mgmt ID of this project management.
	 *
	 * @param projectMgmtId the project mgmt ID of this project management
	 */
	@Override
	public void setProjectMgmtId(long projectMgmtId) {
		model.setProjectMgmtId(projectMgmtId);
	}

	/**
	 * Sets the project name of this project management.
	 *
	 * @param projectName the project name of this project management
	 */
	@Override
	public void setProjectName(String projectName) {
		model.setProjectName(projectName);
	}

	/**
	 * Sets the user ID of this project management.
	 *
	 * @param userId the user ID of this project management
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this project management.
	 *
	 * @param userName the user name of this project management
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this project management.
	 *
	 * @param userUuid the user uuid of this project management
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this project management.
	 *
	 * @param uuid the uuid of this project management
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
	protected ProjectManagementWrapper wrap(
		ProjectManagement projectManagement) {

		return new ProjectManagementWrapper(projectManagement);
	}

}