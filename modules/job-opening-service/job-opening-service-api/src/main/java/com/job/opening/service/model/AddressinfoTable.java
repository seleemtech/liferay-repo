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

package com.job.opening.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rms_Addressinfo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Addressinfo
 * @generated
 */
public class AddressinfoTable extends BaseTable<AddressinfoTable> {

	public static final AddressinfoTable INSTANCE = new AddressinfoTable();

	public final Column<AddressinfoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressinfoTable, Long> addressId = createColumn(
		"addressId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AddressinfoTable, Long> jobId = createColumn(
		"jobId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AddressinfoTable, Boolean> remote = createColumn(
		"remote", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AddressinfoTable, String> city = createColumn(
		"city", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressinfoTable, String> country = createColumn(
		"country", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressinfoTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AddressinfoTable, Long> postalCode = createColumn(
		"postalCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AddressinfoTable() {
		super("rms_Addressinfo", AddressinfoTable::new);
	}

}