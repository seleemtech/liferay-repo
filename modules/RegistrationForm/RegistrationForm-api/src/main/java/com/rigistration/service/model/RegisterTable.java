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

package com.rigistration.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;RG_Register&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Register
 * @generated
 */
public class RegisterTable extends BaseTable<RegisterTable> {

	public static final RegisterTable INSTANCE = new RegisterTable();

	public final Column<RegisterTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegisterTable, Long> registerId = createColumn(
		"registerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RegisterTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegisterTable, Long> phone = createColumn(
		"phone", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegisterTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegisterTable, String> password = createColumn(
		"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RegisterTable() {
		super("RG_Register", RegisterTable::new);
	}

}