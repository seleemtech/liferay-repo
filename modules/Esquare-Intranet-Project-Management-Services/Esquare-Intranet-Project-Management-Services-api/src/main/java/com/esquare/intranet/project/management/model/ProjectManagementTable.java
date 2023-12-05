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

/**
 * The table class for the &quot;Esquare_ProjectManagement&quot; database table.
 *
 * @author Mahammed Seleem
 * @see ProjectManagement
 * @generated
 */
public class ProjectManagementTable extends BaseTable<ProjectManagementTable> {

	public static final ProjectManagementTable INSTANCE =
		new ProjectManagementTable();

	public final Column<ProjectManagementTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectManagementTable, Long> projectMgmtId =
		createColumn(
			"projectMgmtId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProjectManagementTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectManagementTable, String> contactNumber =
		createColumn(
			"contactNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectManagementTable, String> contactEmail =
		createColumn(
			"contactEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectManagementTable, String> projectName =
		createColumn(
			"projectName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectManagementTable, String> description =
		createColumn(
			"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectManagementTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectManagementTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectManagementTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectManagementTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProjectManagementTable() {
		super("Esquare_ProjectManagement", ProjectManagementTable::new);
	}

}