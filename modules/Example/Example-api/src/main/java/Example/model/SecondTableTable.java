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
 * The table class for the &quot;FOO_SecondTable&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SecondTable
 * @generated
 */
public class SecondTableTable extends BaseTable<SecondTableTable> {

	public static final SecondTableTable INSTANCE = new SecondTableTable();

	public final Column<SecondTableTable, Long> coId = createColumn(
		"coId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SecondTableTable, String> coName = createColumn(
		"coName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SecondTableTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SecondTableTable() {
		super("FOO_SecondTable", SecondTableTable::new);
	}

}