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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Notes service. Represents a row in the &quot;Esquare_Notes&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.esquare.intranet.project.management.model.impl.NotesModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.esquare.intranet.project.management.model.impl.NotesImpl</code>.
 * </p>
 *
 * @author Mahammed Seleem
 * @see Notes
 * @generated
 */
@ProviderType
public interface NotesModel extends BaseModel<Notes> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a notes model instance should use the {@link Notes} interface instead.
	 */

	/**
	 * Returns the primary key of this notes.
	 *
	 * @return the primary key of this notes
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this notes.
	 *
	 * @param primaryKey the primary key of this notes
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this notes.
	 *
	 * @return the uuid of this notes
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this notes.
	 *
	 * @param uuid the uuid of this notes
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the note ID of this notes.
	 *
	 * @return the note ID of this notes
	 */
	public long getNoteId();

	/**
	 * Sets the note ID of this notes.
	 *
	 * @param noteId the note ID of this notes
	 */
	public void setNoteId(long noteId);

	/**
	 * Returns the note title of this notes.
	 *
	 * @return the note title of this notes
	 */
	@AutoEscape
	public String getNoteTitle();

	/**
	 * Sets the note title of this notes.
	 *
	 * @param noteTitle the note title of this notes
	 */
	public void setNoteTitle(String noteTitle);

	/**
	 * Returns the note description of this notes.
	 *
	 * @return the note description of this notes
	 */
	@AutoEscape
	public String getNoteDescription();

	/**
	 * Sets the note description of this notes.
	 *
	 * @param noteDescription the note description of this notes
	 */
	public void setNoteDescription(String noteDescription);

	/**
	 * Returns the note type of this notes.
	 *
	 * @return the note type of this notes
	 */
	@AutoEscape
	public String getNoteType();

	/**
	 * Sets the note type of this notes.
	 *
	 * @param noteType the note type of this notes
	 */
	public void setNoteType(String noteType);

	/**
	 * Returns the note author of this notes.
	 *
	 * @return the note author of this notes
	 */
	@AutoEscape
	public String getNoteAuthor();

	/**
	 * Sets the note author of this notes.
	 *
	 * @param noteAuthor the note author of this notes
	 */
	public void setNoteAuthor(String noteAuthor);

	/**
	 * Returns the note date of this notes.
	 *
	 * @return the note date of this notes
	 */
	public Date getNoteDate();

	/**
	 * Sets the note date of this notes.
	 *
	 * @param noteDate the note date of this notes
	 */
	public void setNoteDate(Date noteDate);

	/**
	 * Returns the project ID of this notes.
	 *
	 * @return the project ID of this notes
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this notes.
	 *
	 * @param projectId the project ID of this notes
	 */
	public void setProjectId(long projectId);

	@Override
	public Notes cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}