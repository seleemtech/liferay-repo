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

package com.student.info.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;ST_Courses_Teachers&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Course
 * @see Teacher
 * @generated
 */
public class ST_Courses_TeachersTable
	extends BaseTable<ST_Courses_TeachersTable> {

	public static final ST_Courses_TeachersTable INSTANCE =
		new ST_Courses_TeachersTable();

	public final Column<ST_Courses_TeachersTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ST_Courses_TeachersTable, Long> courseId = createColumn(
		"courseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ST_Courses_TeachersTable, Long> teacherId =
		createColumn(
			"teacherId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private ST_Courses_TeachersTable() {
		super("ST_Courses_Teachers", ST_Courses_TeachersTable::new);
	}

}