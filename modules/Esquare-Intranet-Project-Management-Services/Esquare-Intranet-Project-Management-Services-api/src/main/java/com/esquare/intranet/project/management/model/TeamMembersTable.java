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
 * The table class for the &quot;Esquare_TeamMembers&quot; database table.
 *
 * @author Mahammed Seleem
 * @see TeamMembers
 * @generated
 */
public class TeamMembersTable extends BaseTable<TeamMembersTable> {

	public static final TeamMembersTable INSTANCE = new TeamMembersTable();

	public final Column<TeamMembersTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TeamMembersTable, Long> memberId = createColumn(
		"memberId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TeamMembersTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TeamMembersTable, String> memberRole = createColumn(
		"memberRole", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TeamMembersTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TeamMembersTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private TeamMembersTable() {
		super("Esquare_TeamMembers", TeamMembersTable::new);
	}

}