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
 * This class is a wrapper for {@link Notes}.
 * </p>
 *
 * @author Mahammed Seleem
 * @see Notes
 * @generated
 */
public class NotesWrapper
	extends BaseModelWrapper<Notes> implements ModelWrapper<Notes>, Notes {

	public NotesWrapper(Notes notes) {
		super(notes);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("noteId", getNoteId());
		attributes.put("noteTitle", getNoteTitle());
		attributes.put("noteDescription", getNoteDescription());
		attributes.put("noteType", getNoteType());
		attributes.put("noteAuthor", getNoteAuthor());
		attributes.put("noteDate", getNoteDate());
		attributes.put("projectId", getProjectId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long noteId = (Long)attributes.get("noteId");

		if (noteId != null) {
			setNoteId(noteId);
		}

		String noteTitle = (String)attributes.get("noteTitle");

		if (noteTitle != null) {
			setNoteTitle(noteTitle);
		}

		String noteDescription = (String)attributes.get("noteDescription");

		if (noteDescription != null) {
			setNoteDescription(noteDescription);
		}

		String noteType = (String)attributes.get("noteType");

		if (noteType != null) {
			setNoteType(noteType);
		}

		String noteAuthor = (String)attributes.get("noteAuthor");

		if (noteAuthor != null) {
			setNoteAuthor(noteAuthor);
		}

		Date noteDate = (Date)attributes.get("noteDate");

		if (noteDate != null) {
			setNoteDate(noteDate);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}
	}

	@Override
	public Notes cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the note author of this notes.
	 *
	 * @return the note author of this notes
	 */
	@Override
	public String getNoteAuthor() {
		return model.getNoteAuthor();
	}

	/**
	 * Returns the note date of this notes.
	 *
	 * @return the note date of this notes
	 */
	@Override
	public Date getNoteDate() {
		return model.getNoteDate();
	}

	/**
	 * Returns the note description of this notes.
	 *
	 * @return the note description of this notes
	 */
	@Override
	public String getNoteDescription() {
		return model.getNoteDescription();
	}

	/**
	 * Returns the note ID of this notes.
	 *
	 * @return the note ID of this notes
	 */
	@Override
	public long getNoteId() {
		return model.getNoteId();
	}

	/**
	 * Returns the note title of this notes.
	 *
	 * @return the note title of this notes
	 */
	@Override
	public String getNoteTitle() {
		return model.getNoteTitle();
	}

	/**
	 * Returns the note type of this notes.
	 *
	 * @return the note type of this notes
	 */
	@Override
	public String getNoteType() {
		return model.getNoteType();
	}

	/**
	 * Returns the primary key of this notes.
	 *
	 * @return the primary key of this notes
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this notes.
	 *
	 * @return the project ID of this notes
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the uuid of this notes.
	 *
	 * @return the uuid of this notes
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
	 * Sets the note author of this notes.
	 *
	 * @param noteAuthor the note author of this notes
	 */
	@Override
	public void setNoteAuthor(String noteAuthor) {
		model.setNoteAuthor(noteAuthor);
	}

	/**
	 * Sets the note date of this notes.
	 *
	 * @param noteDate the note date of this notes
	 */
	@Override
	public void setNoteDate(Date noteDate) {
		model.setNoteDate(noteDate);
	}

	/**
	 * Sets the note description of this notes.
	 *
	 * @param noteDescription the note description of this notes
	 */
	@Override
	public void setNoteDescription(String noteDescription) {
		model.setNoteDescription(noteDescription);
	}

	/**
	 * Sets the note ID of this notes.
	 *
	 * @param noteId the note ID of this notes
	 */
	@Override
	public void setNoteId(long noteId) {
		model.setNoteId(noteId);
	}

	/**
	 * Sets the note title of this notes.
	 *
	 * @param noteTitle the note title of this notes
	 */
	@Override
	public void setNoteTitle(String noteTitle) {
		model.setNoteTitle(noteTitle);
	}

	/**
	 * Sets the note type of this notes.
	 *
	 * @param noteType the note type of this notes
	 */
	@Override
	public void setNoteType(String noteType) {
		model.setNoteType(noteType);
	}

	/**
	 * Sets the primary key of this notes.
	 *
	 * @param primaryKey the primary key of this notes
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this notes.
	 *
	 * @param projectId the project ID of this notes
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the uuid of this notes.
	 *
	 * @param uuid the uuid of this notes
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
	protected NotesWrapper wrap(Notes notes) {
		return new NotesWrapper(notes);
	}

}