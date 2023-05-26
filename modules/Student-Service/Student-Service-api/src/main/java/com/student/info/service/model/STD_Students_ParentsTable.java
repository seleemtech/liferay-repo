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
 * The table class for the &quot;STD_Students_Parents&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Parent
 * @see Student
 * @generated
 */
public class STD_Students_ParentsTable
	extends BaseTable<STD_Students_ParentsTable> {

	public static final STD_Students_ParentsTable INSTANCE =
		new STD_Students_ParentsTable();

	public final Column<STD_Students_ParentsTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<STD_Students_ParentsTable, Long> parentId =
		createColumn("parentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<STD_Students_ParentsTable, Long> studentId =
		createColumn(
			"studentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private STD_Students_ParentsTable() {
		super("STD_Students_Parents", STD_Students_ParentsTable::new);
	}

}