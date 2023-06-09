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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CandidateStatus service. Represents a row in the &quot;PRIME_CandidateStatus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.prime.data.service.model.impl.CandidateStatusModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.prime.data.service.model.impl.CandidateStatusImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateStatus
 * @generated
 */
@ProviderType
public interface CandidateStatusModel extends BaseModel<CandidateStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a candidate status model instance should use the {@link CandidateStatus} interface instead.
	 */

	/**
	 * Returns the primary key of this candidate status.
	 *
	 * @return the primary key of this candidate status
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this candidate status.
	 *
	 * @param primaryKey the primary key of this candidate status
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this candidate status.
	 *
	 * @return the uuid of this candidate status
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this candidate status.
	 *
	 * @param uuid the uuid of this candidate status
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the candidate status ID of this candidate status.
	 *
	 * @return the candidate status ID of this candidate status
	 */
	public long getCandidateStatusId();

	/**
	 * Sets the candidate status ID of this candidate status.
	 *
	 * @param candidateStatusId the candidate status ID of this candidate status
	 */
	public void setCandidateStatusId(long candidateStatusId);

	/**
	 * Returns the candidate status of this candidate status.
	 *
	 * @return the candidate status of this candidate status
	 */
	@AutoEscape
	public String getCandidateStatus();

	/**
	 * Sets the candidate status of this candidate status.
	 *
	 * @param candidateStatus the candidate status of this candidate status
	 */
	public void setCandidateStatus(String candidateStatus);

	@Override
	public CandidateStatus cloneWithOriginalValues();

}