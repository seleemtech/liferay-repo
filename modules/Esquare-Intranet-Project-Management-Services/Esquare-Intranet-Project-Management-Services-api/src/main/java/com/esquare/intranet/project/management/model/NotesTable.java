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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Esquare_Notes&quot; database table.
 *
 * @author Mahammed Seleem
 * @see Notes
 * @generated
 */
public class NotesTable extends BaseTable<NotesTable> {

	public static final NotesTable INSTANCE = new NotesTable();

	public final Column<NotesTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotesTable, Long> noteId = createColumn(
		"noteId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NotesTable, String> noteTitle = createColumn(
		"noteTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotesTable, String> noteDescription = createColumn(
		"noteDescription", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotesTable, String> noteType = createColumn(
		"noteType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotesTable, String> noteAuthor = createColumn(
		"noteAuthor", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotesTable, Date> noteDate = createColumn(
		"noteDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NotesTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private NotesTable() {
		super("Esquare_Notes", NotesTable::new);
	}

}