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
 * The table class for the &quot;INTRANET_Specialization&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Specialization
 * @generated
 */
public class SpecializationTable extends BaseTable<SpecializationTable> {

	public static final SpecializationTable INSTANCE =
		new SpecializationTable();

	public final Column<SpecializationTable, String> graduationCode =
		createColumn(
			"graduationCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SpecializationTable, String> specializationName =
		createColumn(
			"specializationName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SpecializationTable, Long> spCode = createColumn(
		"spCode", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private SpecializationTable() {
		super("INTRANET_Specialization", SpecializationTable::new);
	}

}