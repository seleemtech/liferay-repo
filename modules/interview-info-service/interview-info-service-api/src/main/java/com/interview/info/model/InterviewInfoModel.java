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

package com.interview.info.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the InterviewInfo service. Represents a row in the &quot;RMS_InterviewInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.interview.info.model.impl.InterviewInfoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.interview.info.model.impl.InterviewInfoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InterviewInfo
 * @generated
 */
@ProviderType
public interface InterviewInfoModel extends BaseModel<InterviewInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a interview info model instance should use the {@link InterviewInfo} interface instead.
	 */

	/**
	 * Returns the primary key of this interview info.
	 *
	 * @return the primary key of this interview info
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this interview info.
	 *
	 * @param primaryKey the primary key of this interview info
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this interview info.
	 *
	 * @return the uuid of this interview info
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this interview info.
	 *
	 * @param uuid the uuid of this interview info
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the interview ID of this interview info.
	 *
	 * @return the interview ID of this interview info
	 */
	public long getInterviewId();

	/**
	 * Sets the interview ID of this interview info.
	 *
	 * @param interviewId the interview ID of this interview info
	 */
	public void setInterviewId(long interviewId);

	/**
	 * Returns the interview name of this interview info.
	 *
	 * @return the interview name of this interview info
	 */
	@AutoEscape
	public String getInterviewName();

	/**
	 * Sets the interview name of this interview info.
	 *
	 * @param interviewName the interview name of this interview info
	 */
	public void setInterviewName(String interviewName);

	/**
	 * Returns the posting title ID of this interview info.
	 *
	 * @return the posting title ID of this interview info
	 */
	public long getPostingTitleId();

	/**
	 * Sets the posting title ID of this interview info.
	 *
	 * @param postingTitleId the posting title ID of this interview info
	 */
	public void setPostingTitleId(long postingTitleId);

	/**
	 * Returns the candidate ID of this interview info.
	 *
	 * @return the candidate ID of this interview info
	 */
	public long getCandidateId();

	/**
	 * Sets the candidate ID of this interview info.
	 *
	 * @param candidateId the candidate ID of this interview info
	 */
	public void setCandidateId(long candidateId);

	/**
	 * Returns the client ID of this interview info.
	 *
	 * @return the client ID of this interview info
	 */
	public long getClientId();

	/**
	 * Sets the client ID of this interview info.
	 *
	 * @param clientId the client ID of this interview info
	 */
	public void setClientId(long clientId);

	/**
	 * Returns the interview from of this interview info.
	 *
	 * @return the interview from of this interview info
	 */
	public long getInterviewFrom();

	/**
	 * Sets the interview from of this interview info.
	 *
	 * @param interviewFrom the interview from of this interview info
	 */
	public void setInterviewFrom(long interviewFrom);

	/**
	 * Returns the interview to of this interview info.
	 *
	 * @return the interview to of this interview info
	 */
	public long getInterviewTo();

	/**
	 * Sets the interview to of this interview info.
	 *
	 * @param interviewTo the interview to of this interview info
	 */
	public void setInterviewTo(long interviewTo);

	/**
	 * Returns the interviewers of this interview info.
	 *
	 * @return the interviewers of this interview info
	 */
	@AutoEscape
	public String getInterviewers();

	/**
	 * Sets the interviewers of this interview info.
	 *
	 * @param interviewers the interviewers of this interview info
	 */
	public void setInterviewers(String interviewers);

	/**
	 * Returns the interview owner of this interview info.
	 *
	 * @return the interview owner of this interview info
	 */
	public long getInterviewOwner();

	/**
	 * Sets the interview owner of this interview info.
	 *
	 * @param interviewOwner the interview owner of this interview info
	 */
	public void setInterviewOwner(long interviewOwner);

	/**
	 * Returns the schedule comments of this interview info.
	 *
	 * @return the schedule comments of this interview info
	 */
	@AutoEscape
	public String getScheduleComments();

	/**
	 * Sets the schedule comments of this interview info.
	 *
	 * @param scheduleComments the schedule comments of this interview info
	 */
	public void setScheduleComments(String scheduleComments);

	/**
	 * Returns the location of this interview info.
	 *
	 * @return the location of this interview info
	 */
	@AutoEscape
	public String getLocation();

	/**
	 * Sets the location of this interview info.
	 *
	 * @param location the location of this interview info
	 */
	public void setLocation(String location);

	/**
	 * Returns the attachment ID of this interview info.
	 *
	 * @return the attachment ID of this interview info
	 */
	public long getAttachmentId();

	/**
	 * Sets the attachment ID of this interview info.
	 *
	 * @param attachmentId the attachment ID of this interview info
	 */
	public void setAttachmentId(long attachmentId);

	/**
	 * Returns the created by of this interview info.
	 *
	 * @return the created by of this interview info
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this interview info.
	 *
	 * @param createdBy the created by of this interview info
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the created date of this interview info.
	 *
	 * @return the created date of this interview info
	 */
	public long getCreatedDate();

	/**
	 * Sets the created date of this interview info.
	 *
	 * @param createdDate the created date of this interview info
	 */
	public void setCreatedDate(long createdDate);

	/**
	 * Returns the modified by of this interview info.
	 *
	 * @return the modified by of this interview info
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this interview info.
	 *
	 * @param modifiedBy the modified by of this interview info
	 */
	public void setModifiedBy(long modifiedBy);

	/**
	 * Returns the modified date of this interview info.
	 *
	 * @return the modified date of this interview info
	 */
	public long getModifiedDate();

	/**
	 * Sets the modified date of this interview info.
	 *
	 * @param modifiedDate the modified date of this interview info
	 */
	public void setModifiedDate(long modifiedDate);

	@Override
	public InterviewInfo cloneWithOriginalValues();

}