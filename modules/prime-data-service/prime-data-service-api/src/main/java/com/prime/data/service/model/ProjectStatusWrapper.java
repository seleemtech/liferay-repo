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

package com.prime.data.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProjectStatus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectStatus
 * @generated
 */
public class ProjectStatusWrapper
	extends BaseModelWrapper<ProjectStatus>
	implements ModelWrapper<ProjectStatus>, ProjectStatus {

	public ProjectStatusWrapper(ProjectStatus projectStatus) {
		super(projectStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("projectStatusId", getProjectStatusId());
		attributes.put("projectStatus", getProjectStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long projectStatusId = (Long)attributes.get("projectStatusId");

		if (projectStatusId != null) {
			setProjectStatusId(projectStatusId);
		}

		String projectStatus = (String)attributes.get("projectStatus");

		if (projectStatus != null) {
			setProjectStatus(projectStatus);
		}
	}

	@Override
	public ProjectStatus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this project status.
	 *
	 * @return the primary key of this project status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project status of this project status.
	 *
	 * @return the project status of this project status
	 */
	@Override
	public String getProjectStatus() {
		return model.getProjectStatus();
	}

	/**
	 * Returns the project status ID of this project status.
	 *
	 * @return the project status ID of this project status
	 */
	@Override
	public long getProjectStatusId() {
		return model.getProjectStatusId();
	}

	/**
	 * Returns the uuid of this project status.
	 *
	 * @return the uuid of this project status
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
	 * Sets the primary key of this project status.
	 *
	 * @param primaryKey the primary key of this project status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project status of this project status.
	 *
	 * @param projectStatus the project status of this project status
	 */
	@Override
	public void setProjectStatus(String projectStatus) {
		model.setProjectStatus(projectStatus);
	}

	/**
	 * Sets the project status ID of this project status.
	 *
	 * @param projectStatusId the project status ID of this project status
	 */
	@Override
	public void setProjectStatusId(long projectStatusId) {
		model.setProjectStatusId(projectStatusId);
	}

	/**
	 * Sets the uuid of this project status.
	 *
	 * @param uuid the uuid of this project status
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ProjectStatusWrapper wrap(ProjectStatus projectStatus) {
		return new ProjectStatusWrapper(projectStatus);
	}

}