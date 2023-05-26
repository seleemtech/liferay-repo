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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.interview.info.service.http.InterviewInfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class InterviewInfoSoap implements Serializable {

	public static InterviewInfoSoap toSoapModel(InterviewInfo model) {
		InterviewInfoSoap soapModel = new InterviewInfoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setInterviewId(model.getInterviewId());
		soapModel.setInterviewName(model.getInterviewName());
		soapModel.setPostingTitleId(model.getPostingTitleId());
		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setClientId(model.getClientId());
		soapModel.setInterviewFrom(model.getInterviewFrom());
		soapModel.setInterviewTo(model.getInterviewTo());
		soapModel.setInterviewers(model.getInterviewers());
		soapModel.setInterviewOwner(model.getInterviewOwner());
		soapModel.setScheduleComments(model.getScheduleComments());
		soapModel.setLocation(model.getLocation());
		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static InterviewInfoSoap[] toSoapModels(InterviewInfo[] models) {
		InterviewInfoSoap[] soapModels = new InterviewInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InterviewInfoSoap[][] toSoapModels(InterviewInfo[][] models) {
		InterviewInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InterviewInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InterviewInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InterviewInfoSoap[] toSoapModels(List<InterviewInfo> models) {
		List<InterviewInfoSoap> soapModels = new ArrayList<InterviewInfoSoap>(
			models.size());

		for (InterviewInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InterviewInfoSoap[soapModels.size()]);
	}

	public InterviewInfoSoap() {
	}

	public long getPrimaryKey() {
		return _interviewId;
	}

	public void setPrimaryKey(long pk) {
		setInterviewId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getInterviewId() {
		return _interviewId;
	}

	public void setInterviewId(long interviewId) {
		_interviewId = interviewId;
	}

	public String getInterviewName() {
		return _interviewName;
	}

	public void setInterviewName(String interviewName) {
		_interviewName = interviewName;
	}

	public long getPostingTitleId() {
		return _postingTitleId;
	}

	public void setPostingTitleId(long postingTitleId) {
		_postingTitleId = postingTitleId;
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public long getClientId() {
		return _clientId;
	}

	public void setClientId(long clientId) {
		_clientId = clientId;
	}

	public long getInterviewFrom() {
		return _interviewFrom;
	}

	public void setInterviewFrom(long interviewFrom) {
		_interviewFrom = interviewFrom;
	}

	public long getInterviewTo() {
		return _interviewTo;
	}

	public void setInterviewTo(long interviewTo) {
		_interviewTo = interviewTo;
	}

	public String getInterviewers() {
		return _interviewers;
	}

	public void setInterviewers(String interviewers) {
		_interviewers = interviewers;
	}

	public long getInterviewOwner() {
		return _interviewOwner;
	}

	public void setInterviewOwner(long interviewOwner) {
		_interviewOwner = interviewOwner;
	}

	public String getScheduleComments() {
		return _scheduleComments;
	}

	public void setScheduleComments(String scheduleComments) {
		_scheduleComments = scheduleComments;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public long getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(long createdDate) {
		_createdDate = createdDate;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public long getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _interviewId;
	private String _interviewName;
	private long _postingTitleId;
	private long _candidateId;
	private long _clientId;
	private long _interviewFrom;
	private long _interviewTo;
	private String _interviewers;
	private long _interviewOwner;
	private String _scheduleComments;
	private String _location;
	private long _attachmentId;
	private long _createdBy;
	private long _createdDate;
	private long _modifiedBy;
	private long _modifiedDate;

}