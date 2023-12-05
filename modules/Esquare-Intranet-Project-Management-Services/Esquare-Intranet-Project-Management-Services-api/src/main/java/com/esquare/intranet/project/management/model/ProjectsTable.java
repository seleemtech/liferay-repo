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
 * The table class for the &quot;Esquare_Projects&quot; database table.
 *
 * @author Mahammed Seleem
 * @see Projects
 * @generated
 */
public class ProjectsTable extends BaseTable<ProjectsTable> {

	public static final ProjectsTable INSTANCE = new ProjectsTable();

	public final Column<ProjectsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProjectsTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, String> projectName = createColumn(
		"projectName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, Date> proposedDate = createColumn(
		"proposedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, Date> confirmedDate = createColumn(
		"confirmedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, Date> developmentStartDate =
		createColumn(
			"developmentStartDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, Date> estimatedDate = createColumn(
		"estimatedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, String> durationDate = createColumn(
		"durationDate", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, Integer> code = createColumn(
		"code_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, Long> documentId = createColumn(
		"documentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, String> resourceIdSettings =
		createColumn(
			"resourceIdSettings", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, String> contactNumber = createColumn(
		"contactNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectsTable, String> contactEmail = createColumn(
		"contactEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProjectsTable() {
		super("Esquare_Projects", ProjectsTable::new);
	}

}