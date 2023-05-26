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
 * This class is a wrapper for {@link InterviewName}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InterviewName
 * @generated
 */
public class InterviewNameWrapper
	extends BaseModelWrapper<InterviewName>
	implements InterviewName, ModelWrapper<InterviewName> {

	public InterviewNameWrapper(InterviewName interviewName) {
		super(interviewName);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("interviewNameId", getInterviewNameId());
		attributes.put("interviewName", getInterviewName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long interviewNameId = (Long)attributes.get("interviewNameId");

		if (interviewNameId != null) {
			setInterviewNameId(interviewNameId);
		}

		String interviewName = (String)attributes.get("interviewName");

		if (interviewName != null) {
			setInterviewName(interviewName);
		}
	}

	@Override
	public InterviewName cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the interview name of this interview name.
	 *
	 * @return the interview name of this interview name
	 */
	@Override
	public String getInterviewName() {
		return model.getInterviewName();
	}

	/**
	 * Returns the interview name ID of this interview name.
	 *
	 * @return the interview name ID of this interview name
	 */
	@Override
	public long getInterviewNameId() {
		return model.getInterviewNameId();
	}

	/**
	 * Returns the primary key of this interview name.
	 *
	 * @return the primary key of this interview name
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this interview name.
	 *
	 * @return the uuid of this interview name
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
	 * Sets the interview name of this interview name.
	 *
	 * @param interviewName the interview name of this interview name
	 */
	@Override
	public void setInterviewName(String interviewName) {
		model.setInterviewName(interviewName);
	}

	/**
	 * Sets the interview name ID of this interview name.
	 *
	 * @param interviewNameId the interview name ID of this interview name
	 */
	@Override
	public void setInterviewNameId(long interviewNameId) {
		model.setInterviewNameId(interviewNameId);
	}

	/**
	 * Sets the primary key of this interview name.
	 *
	 * @param primaryKey the primary key of this interview name
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this interview name.
	 *
	 * @param uuid the uuid of this interview name
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected InterviewNameWrapper wrap(InterviewName interviewName) {
		return new InterviewNameWrapper(interviewName);
	}

}