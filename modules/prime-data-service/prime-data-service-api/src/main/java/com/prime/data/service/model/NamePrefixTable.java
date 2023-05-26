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
 * The table class for the &quot;PRIME_NamePrefix&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see NamePrefix
 * @generated
 */
public class NamePrefixTable extends BaseTable<NamePrefixTable> {

	public static final NamePrefixTable INSTANCE = new NamePrefixTable();

	public final Column<NamePrefixTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NamePrefixTable, Long> namePrefixId = createColumn(
		"namePrefixId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NamePrefixTable, String> namePrefix = createColumn(
		"namePrefix", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private NamePrefixTable() {
		super("PRIME_NamePrefix", NamePrefixTable::new);
	}

}