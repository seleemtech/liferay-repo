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

package com.prime.data.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;PRIME_SalaryRange&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SalaryRange
 * @generated
 */
public class SalaryRangeTable extends BaseTable<SalaryRangeTable> {

	public static final SalaryRangeTable INSTANCE = new SalaryRangeTable();

	public final Column<SalaryRangeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SalaryRangeTable, Long> salaryRangeId = createColumn(
		"salaryRangeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SalaryRangeTable, String> salaryRange = createColumn(
		"salaryRange", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private SalaryRangeTable() {
		super("PRIME_SalaryRange", SalaryRangeTable::new);
	}

}