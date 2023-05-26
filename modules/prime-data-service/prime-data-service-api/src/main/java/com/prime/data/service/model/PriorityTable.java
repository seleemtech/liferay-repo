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
 * The table class for the &quot;PRIME_Priority&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Priority
 * @generated
 */
public class PriorityTable extends BaseTable<PriorityTable> {

	public static final PriorityTable INSTANCE = new PriorityTable();

	public final Column<PriorityTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PriorityTable, Long> priorityId = createColumn(
		"priorityId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PriorityTable, String> priorityName = createColumn(
		"priorityName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PriorityTable() {
		super("PRIME_Priority", PriorityTable::new);
	}

}