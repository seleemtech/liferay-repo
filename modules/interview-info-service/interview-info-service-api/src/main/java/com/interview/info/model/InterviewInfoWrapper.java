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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link InterviewInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InterviewInfo
 * @generated
 */
public class InterviewInfoWrapper
	extends BaseModelWrapper<InterviewInfo>
	implements InterviewInfo, ModelWrapper<InterviewInfo> {

	public InterviewInfoWrapper(InterviewInfo interviewInfo) {
		super(interviewInfo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("interviewId", getInterviewId());
		attributes.put("interviewName", getInterviewName());
		attributes.put("postingTitleId", getPostingTitleId());
		attributes.put("candidateId", getCandidateId());
		attributes.put("clientId", getClientId());
		attributes.put("interviewFrom", getInterviewFrom());
		attributes.put("interviewTo", getInterviewTo());
		attributes.put("interviewers", getInterviewers());
		attributes.put("interviewOwner", getInterviewOwner());
		attributes.put("scheduleComments", getScheduleComments());
		attributes.put("location", getLocation());
		attributes.put("attachmentId", getAttachmentId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long interviewId = (Long)attributes.get("interviewId");

		if (interviewId != null) {
			setInterviewId(interviewId);
		}

		String interviewName = (String)attributes.get("interviewName");

		if (interviewName != null) {
			setInterviewName(interviewName);
		}

		Long postingTitleId = (Long)attributes.get("postingTitleId");

		if (postingTitleId != null) {
			setPostingTitleId(postingTitleId);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		Long clientId = (Long)attributes.get("clientId");

		if (clientId != null) {
			setClientId(clientId);
		}

		Long interviewFrom = (Long)attributes.get("interviewFrom");

		if (interviewFrom != null) {
			setInterviewFrom(interviewFrom);
		}

		Long interviewTo = (Long)attributes.get("interviewTo");

		if (interviewTo != null) {
			setInterviewTo(interviewTo);
		}

		String interviewers = (String)attributes.get("interviewers");

		if (interviewers != null) {
			setInterviewers(interviewers);
		}

		Long interviewOwner = (Long)attributes.get("interviewOwner");

		if (interviewOwner != null) {
			setInterviewOwner(interviewOwner);
		}

		String scheduleComments = (String)attributes.get("scheduleComments");

		if (scheduleComments != null) {
			setScheduleComments(scheduleComments);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long createdDate = (Long)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Long modifiedDate = (Long)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public InterviewInfo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attachment ID of this interview info.
	 *
	 * @return the attachment ID of this interview info
	 */
	@Override
	public long getAttachmentId() {
		return model.getAttachmentId();
	}

	/**
	 * Returns the candidate ID of this interview info.
	 *
	 * @return the candidate ID of this interview info
	 */
	@Override
	public long getCandidateId() {
		return model.getCandidateId();
	}

	/**
	 * Returns the client ID of this interview info.
	 *
	 * @return the client ID of this interview info
	 */
	@Override
	public long getClientId() {
		return model.getClientId();
	}

	/**
	 * Returns the created by of this interview info.
	 *
	 * @return the created by of this interview info
	 */
	@Override
	public long getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the created date of this interview info.
	 *
	 * @return the created date of this interview info
	 */
	@Override
	public long getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the interviewers of this interview info.
	 *
	 * @return the interviewers of this interview info
	 */
	@Override
	public String getInterviewers() {
		return model.getInterviewers();
	}

	/**
	 * Returns the interview from of this interview info.
	 *
	 * @return the interview from of this interview info
	 */
	@Override
	public long getInterviewFrom() {
		return model.getInterviewFrom();
	}

	/**
	 * Returns the interview ID of this interview info.
	 *
	 * @return the interview ID of this interview info
	 */
	@Override
	public long getInterviewId() {
		return model.getInterviewId();
	}

	/**
	 * Returns the interview name of this interview info.
	 *
	 * @return the interview name of this interview info
	 */
	@Override
	public String getInterviewName() {
		return model.getInterviewName();
	}

	/**
	 * Returns the interview owner of this interview info.
	 *
	 * @return the interview owner of this interview info
	 */
	@Override
	public long getInterviewOwner() {
		return model.getInterviewOwner();
	}

	/**
	 * Returns the interview to of this interview info.
	 *
	 * @return the interview to of this interview info
	 */
	@Override
	public long getInterviewTo() {
		return model.getInterviewTo();
	}

	/**
	 * Returns the location of this interview info.
	 *
	 * @return the location of this interview info
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified by of this interview info.
	 *
	 * @return the modified by of this interview info
	 */
	@Override
	public long getModifiedBy() {
		return model.getModifiedBy();
	}

	/**
	 * Returns the modified date of this interview info.
	 *
	 * @return the modified date of this interview info
	 */
	@Override
	public long getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the posting title ID of this interview info.
	 *
	 * @return the posting title ID of this interview info
	 */
	@Override
	public long getPostingTitleId() {
		return model.getPostingTitleId();
	}

	/**
	 * Returns the primary key of this interview info.
	 *
	 * @return the primary key of this interview info
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the schedule comments of this interview info.
	 *
	 * @return the schedule comments of this interview info
	 */
	@Override
	public String getScheduleComments() {
		return model.getScheduleComments();
	}

	/**
	 * Returns the uuid of this interview info.
	 *
	 * @return the uuid of this interview info
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
	 * Sets the attachment ID of this interview info.
	 *
	 * @param attachmentId the attachment ID of this interview info
	 */
	@Override
	public void setAttachmentId(long attachmentId) {
		model.setAttachmentId(attachmentId);
	}

	/**
	 * Sets the candidate ID of this interview info.
	 *
	 * @param candidateId the candidate ID of this interview info
	 */
	@Override
	public void setCandidateId(long candidateId) {
		model.setCandidateId(candidateId);
	}

	/**
	 * Sets the client ID of this interview info.
	 *
	 * @param clientId the client ID of this interview info
	 */
	@Override
	public void setClientId(long clientId) {
		model.setClientId(clientId);
	}

	/**
	 * Sets the created by of this interview info.
	 *
	 * @param createdBy the created by of this interview info
	 */
	@Override
	public void setCreatedBy(long createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets the created date of this interview info.
	 *
	 * @param createdDate the created date of this interview info
	 */
	@Override
	public void setCreatedDate(long createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the interviewers of this interview info.
	 *
	 * @param interviewers the interviewers of this interview info
	 */
	@Override
	public void setInterviewers(String interviewers) {
		model.setInterviewers(interviewers);
	}

	/**
	 * Sets the interview from of this interview info.
	 *
	 * @param interviewFrom the interview from of this interview info
	 */
	@Override
	public void setInterviewFrom(long interviewFrom) {
		model.setInterviewFrom(interviewFrom);
	}

	/**
	 * Sets the interview ID of this interview info.
	 *
	 * @param interviewId the interview ID of this interview info
	 */
	@Override
	public void setInterviewId(long interviewId) {
		model.setInterviewId(interviewId);
	}

	/**
	 * Sets the interview name of this interview info.
	 *
	 * @param interviewName the interview name of this interview info
	 */
	@Override
	public void setInterviewName(String interviewName) {
		model.setInterviewName(interviewName);
	}

	/**
	 * Sets the interview owner of this interview info.
	 *
	 * @param interviewOwner the interview owner of this interview info
	 */
	@Override
	public void setInterviewOwner(long interviewOwner) {
		model.setInterviewOwner(interviewOwner);
	}

	/**
	 * Sets the interview to of this interview info.
	 *
	 * @param interviewTo the interview to of this interview info
	 */
	@Override
	public void setInterviewTo(long interviewTo) {
		model.setInterviewTo(interviewTo);
	}

	/**
	 * Sets the location of this interview info.
	 *
	 * @param location the location of this interview info
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified by of this interview info.
	 *
	 * @param modifiedBy the modified by of this interview info
	 */
	@Override
	public void setModifiedBy(long modifiedBy) {
		model.setModifiedBy(modifiedBy);
	}

	/**
	 * Sets the modified date of this interview info.
	 *
	 * @param modifiedDate the modified date of this interview info
	 */
	@Override
	public void setModifiedDate(long modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the posting title ID of this interview info.
	 *
	 * @param postingTitleId the posting title ID of this interview info
	 */
	@Override
	public void setPostingTitleId(long postingTitleId) {
		model.setPostingTitleId(postingTitleId);
	}

	/**
	 * Sets the primary key of this interview info.
	 *
	 * @param primaryKey the primary key of this interview info
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the schedule comments of this interview info.
	 *
	 * @param scheduleComments the schedule comments of this interview info
	 */
	@Override
	public void setScheduleComments(String scheduleComments) {
		model.setScheduleComments(scheduleComments);
	}

	/**
	 * Sets the uuid of this interview info.
	 *
	 * @param uuid the uuid of this interview info
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected InterviewInfoWrapper wrap(InterviewInfo interviewInfo) {
		return new InterviewInfoWrapper(interviewInfo);
	}

}