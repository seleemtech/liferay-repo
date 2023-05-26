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

package com.many.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;MTM_Students_Courses&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Course
 * @see Student
 * @generated
 */
public class MTM_Students_CoursesTable
	extends BaseTable<MTM_Students_CoursesTable> {

	public static final MTM_Students_CoursesTable INSTANCE =
		new MTM_Students_CoursesTable();

	public final Column<MTM_Students_CoursesTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MTM_Students_CoursesTable, Long> courseId =
		createColumn("courseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MTM_Students_CoursesTable, Long> studentId =
		createColumn(
			"studentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private MTM_Students_CoursesTable() {
		super("MTM_Students_Courses", MTM_Students_CoursesTable::new);
	}

}