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

package Example.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;FOO_FirstTables_SecondTables&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FirstTable
 * @see SecondTable
 * @generated
 */
public class FOO_FirstTables_SecondTablesTable
	extends BaseTable<FOO_FirstTables_SecondTablesTable> {

	public static final FOO_FirstTables_SecondTablesTable INSTANCE =
		new FOO_FirstTables_SecondTablesTable();

	public final Column<FOO_FirstTables_SecondTablesTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FOO_FirstTables_SecondTablesTable, Long> soId =
		createColumn("soId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FOO_FirstTables_SecondTablesTable, Long> coId =
		createColumn("coId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private FOO_FirstTables_SecondTablesTable() {
		super(
			"FOO_FirstTables_SecondTables",
			FOO_FirstTables_SecondTablesTable::new);
	}

}