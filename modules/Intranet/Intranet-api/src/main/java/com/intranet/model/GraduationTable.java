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

package com.intranet.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;INTRANET_Graduation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Graduation
 * @generated
 */
public class GraduationTable extends BaseTable<GraduationTable> {

	public static final GraduationTable INSTANCE = new GraduationTable();

	public final Column<GraduationTable, String> graduationCode = createColumn(
		"graduationCode", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<GraduationTable, String> graduationName = createColumn(
		"graduationName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private GraduationTable() {
		super("INTRANET_Graduation", GraduationTable::new);
	}

}