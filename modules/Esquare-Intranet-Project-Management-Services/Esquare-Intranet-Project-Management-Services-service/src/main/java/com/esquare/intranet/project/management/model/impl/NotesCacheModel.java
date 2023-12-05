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

package com.esquare.intranet.project.management.model.impl;

import com.esquare.intranet.project.management.model.Notes;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Notes in entity cache.
 *
 * @author Mahammed Seleem
 * @generated
 */
public class NotesCacheModel implements CacheModel<Notes>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NotesCacheModel)) {
			return false;
		}

		NotesCacheModel notesCacheModel = (NotesCacheModel)object;

		if (noteId == notesCacheModel.noteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, noteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", noteId=");
		sb.append(noteId);
		sb.append(", noteTitle=");
		sb.append(noteTitle);
		sb.append(", noteDescription=");
		sb.append(noteDescription);
		sb.append(", noteType=");
		sb.append(noteType);
		sb.append(", noteAuthor=");
		sb.append(noteAuthor);
		sb.append(", noteDate=");
		sb.append(noteDate);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Notes toEntityModel() {
		NotesImpl notesImpl = new NotesImpl();

		if (uuid == null) {
			notesImpl.setUuid("");
		}
		else {
			notesImpl.setUuid(uuid);
		}

		notesImpl.setNoteId(noteId);

		if (noteTitle == null) {
			notesImpl.setNoteTitle("");
		}
		else {
			notesImpl.setNoteTitle(noteTitle);
		}

		if (noteDescription == null) {
			notesImpl.setNoteDescription("");
		}
		else {
			notesImpl.setNoteDescription(noteDescription);
		}

		if (noteType == null) {
			notesImpl.setNoteType("");
		}
		else {
			notesImpl.setNoteType(noteType);
		}

		if (noteAuthor == null) {
			notesImpl.setNoteAuthor("");
		}
		else {
			notesImpl.setNoteAuthor(noteAuthor);
		}

		if (noteDate == Long.MIN_VALUE) {
			notesImpl.setNoteDate(null);
		}
		else {
			notesImpl.setNoteDate(new Date(noteDate));
		}

		notesImpl.setProjectId(projectId);

		notesImpl.resetOriginalValues();

		return notesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		noteId = objectInput.readLong();
		noteTitle = objectInput.readUTF();
		noteDescription = objectInput.readUTF();
		noteType = objectInput.readUTF();
		noteAuthor = objectInput.readUTF();
		noteDate = objectInput.readLong();

		projectId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(noteId);

		if (noteTitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noteTitle);
		}

		if (noteDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noteDescription);
		}

		if (noteType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noteType);
		}

		if (noteAuthor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noteAuthor);
		}

		objectOutput.writeLong(noteDate);

		objectOutput.writeLong(projectId);
	}

	public String uuid;
	public long noteId;
	public String noteTitle;
	public String noteDescription;
	public String noteType;
	public String noteAuthor;
	public long noteDate;
	public long projectId;

}