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

import java.util.Date;

/**
 * The table class for the &quot;INTRANET_Billclaim&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Billclaim
 * @generated
 */
public class BillclaimTable extends BaseTable<BillclaimTable> {

	public static final BillclaimTable INSTANCE = new BillclaimTable();

	public final Column<BillclaimTable, Long> fooId = createColumn(
		"fooId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BillclaimTable, String> employeeID = createColumn(
		"employeeID", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BillclaimTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BillclaimTable, String> claimType = createColumn(
		"claimType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BillclaimTable, Date> claimDate = createColumn(
		"claimDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BillclaimTable, Long> claimAmount = createColumn(
		"claimAmount", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BillclaimTable, Long> attachBill = createColumn(
		"attachBill", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BillclaimTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private BillclaimTable() {
		super("INTRANET_Billclaim", BillclaimTable::new);
	}

}