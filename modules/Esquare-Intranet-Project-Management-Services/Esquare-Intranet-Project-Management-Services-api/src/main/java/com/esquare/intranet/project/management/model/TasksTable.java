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
 * The table class for the &quot;Esquare_Tasks&quot; database table.
 *
 * @author Mahammed Seleem
 * @see Tasks
 * @generated
 */
public class TasksTable extends BaseTable<TasksTable> {

	public static final TasksTable INSTANCE = new TasksTable();

	public final Column<TasksTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TasksTable, Long> taskId = createColumn(
		"taskId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TasksTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TasksTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TasksTable, String> developerTeam = createColumn(
		"developerTeam", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TasksTable, String> testerTeam = createColumn(
		"testerTeam", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TasksTable, Date> taskStartDate = createColumn(
		"taskStartDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TasksTable, Date> taskEndDate = createColumn(
		"taskEndDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TasksTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TasksTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TasksTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TasksTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TasksTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private TasksTable() {
		super("Esquare_Tasks", TasksTable::new);
	}

}