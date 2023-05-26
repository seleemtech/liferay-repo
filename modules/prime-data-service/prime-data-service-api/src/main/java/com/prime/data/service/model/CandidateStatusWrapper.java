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
 * This class is a wrapper for {@link CandidateStatus}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateStatus
 * @generated
 */
public class CandidateStatusWrapper
	extends BaseModelWrapper<CandidateStatus>
	implements CandidateStatus, ModelWrapper<CandidateStatus> {

	public CandidateStatusWrapper(CandidateStatus candidateStatus) {
		super(candidateStatus);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("candidateStatusId", getCandidateStatusId());
		attributes.put("candidateStatus", getCandidateStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long candidateStatusId = (Long)attributes.get("candidateStatusId");

		if (candidateStatusId != null) {
			setCandidateStatusId(candidateStatusId);
		}

		String candidateStatus = (String)attributes.get("candidateStatus");

		if (candidateStatus != null) {
			setCandidateStatus(candidateStatus);
		}
	}

	@Override
	public CandidateStatus cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the candidate status of this candidate status.
	 *
	 * @return the candidate status of this candidate status
	 */
	@Override
	public String getCandidateStatus() {
		return model.getCandidateStatus();
	}

	/**
	 * Returns the candidate status ID of this candidate status.
	 *
	 * @return the candidate status ID of this candidate status
	 */
	@Override
	public long getCandidateStatusId() {
		return model.getCandidateStatusId();
	}

	/**
	 * Returns the primary key of this candidate status.
	 *
	 * @return the primary key of this candidate status
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this candidate status.
	 *
	 * @return the uuid of this candidate status
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
	 * Sets the candidate status of this candidate status.
	 *
	 * @param candidateStatus the candidate status of this candidate status
	 */
	@Override
	public void setCandidateStatus(String candidateStatus) {
		model.setCandidateStatus(candidateStatus);
	}

	/**
	 * Sets the candidate status ID of this candidate status.
	 *
	 * @param candidateStatusId the candidate status ID of this candidate status
	 */
	@Override
	public void setCandidateStatusId(long candidateStatusId) {
		model.setCandidateStatusId(candidateStatusId);
	}

	/**
	 * Sets the primary key of this candidate status.
	 *
	 * @param primaryKey the primary key of this candidate status
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this candidate status.
	 *
	 * @param uuid the uuid of this candidate status
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CandidateStatusWrapper wrap(CandidateStatus candidateStatus) {
		return new CandidateStatusWrapper(candidateStatus);
	}

}