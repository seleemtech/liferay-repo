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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Descriptiveinfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Descriptiveinfo
 * @generated
 */
public class DescriptiveinfoWrapper
	extends BaseModelWrapper<Descriptiveinfo>
	implements Descriptiveinfo, ModelWrapper<Descriptiveinfo> {

	public DescriptiveinfoWrapper(Descriptiveinfo descriptiveinfo) {
		super(descriptiveinfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("descriptiveId", getDescriptiveId());
		attributes.put("jobId", getJobId());
		attributes.put("jobDescription", getJobDescription());
		attributes.put("requirements", getRequirements());
		attributes.put("benefits", getBenefits());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long descriptiveId = (Long)attributes.get("descriptiveId");

		if (descriptiveId != null) {
			setDescriptiveId(descriptiveId);
		}

		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		String jobDescription = (String)attributes.get("jobDescription");

		if (jobDescription != null) {
			setJobDescription(jobDescription);
		}

		String requirements = (String)attributes.get("requirements");

		if (requirements != null) {
			setRequirements(requirements);
		}

		String benefits = (String)attributes.get("benefits");

		if (benefits != null) {
			setBenefits(benefits);
		}
	}

	@Override
	public Descriptiveinfo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the benefits of this descriptiveinfo.
	 *
	 * @return the benefits of this descriptiveinfo
	 */
	@Override
	public String getBenefits() {
		return model.getBenefits();
	}

	/**
	 * Returns the descriptive ID of this descriptiveinfo.
	 *
	 * @return the descriptive ID of this descriptiveinfo
	 */
	@Override
	public long getDescriptiveId() {
		return model.getDescriptiveId();
	}

	/**
	 * Returns the job description of this descriptiveinfo.
	 *
	 * @return the job description of this descriptiveinfo
	 */
	@Override
	public String getJobDescription() {
		return model.getJobDescription();
	}

	/**
	 * Returns the job ID of this descriptiveinfo.
	 *
	 * @return the job ID of this descriptiveinfo
	 */
	@Override
	public long getJobId() {
		return model.getJobId();
	}

	/**
	 * Returns the primary key of this descriptiveinfo.
	 *
	 * @return the primary key of this descriptiveinfo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the requirements of this descriptiveinfo.
	 *
	 * @return the requirements of this descriptiveinfo
	 */
	@Override
	public String getRequirements() {
		return model.getRequirements();
	}

	/**
	 * Returns the uuid of this descriptiveinfo.
	 *
	 * @return the uuid of this descriptiveinfo
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
	 * Sets the benefits of this descriptiveinfo.
	 *
	 * @param benefits the benefits of this descriptiveinfo
	 */
	@Override
	public void setBenefits(String benefits) {
		model.setBenefits(benefits);
	}

	/**
	 * Sets the descriptive ID of this descriptiveinfo.
	 *
	 * @param descriptiveId the descriptive ID of this descriptiveinfo
	 */
	@Override
	public void setDescriptiveId(long descriptiveId) {
		model.setDescriptiveId(descriptiveId);
	}

	/**
	 * Sets the job description of this descriptiveinfo.
	 *
	 * @param jobDescription the job description of this descriptiveinfo
	 */
	@Override
	public void setJobDescription(String jobDescription) {
		model.setJobDescription(jobDescription);
	}

	/**
	 * Sets the job ID of this descriptiveinfo.
	 *
	 * @param jobId the job ID of this descriptiveinfo
	 */
	@Override
	public void setJobId(long jobId) {
		model.setJobId(jobId);
	}

	/**
	 * Sets the primary key of this descriptiveinfo.
	 *
	 * @param primaryKey the primary key of this descriptiveinfo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the requirements of this descriptiveinfo.
	 *
	 * @param requirements the requirements of this descriptiveinfo
	 */
	@Override
	public void setRequirements(String requirements) {
		model.setRequirements(requirements);
	}

	/**
	 * Sets the uuid of this descriptiveinfo.
	 *
	 * @param uuid the uuid of this descriptiveinfo
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected DescriptiveinfoWrapper wrap(Descriptiveinfo descriptiveinfo) {
		return new DescriptiveinfoWrapper(descriptiveinfo);
	}

}