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
 * The table class for the &quot;INTRANET_EmployeeDetails&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetails
 * @generated
 */
public class EmployeeDetailsTable extends BaseTable<EmployeeDetailsTable> {

	public static final EmployeeDetailsTable INSTANCE =
		new EmployeeDetailsTable();

	public final Column<EmployeeDetailsTable, Long> employeeID = createColumn(
		"employeeID", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmployeeDetailsTable, String> employeename =
		createColumn(
			"employeename", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> domain = createColumn(
		"domain", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> contact = createColumn(
		"contact", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> pannumber = createColumn(
		"pannumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> passportNumber =
		createColumn(
			"passportNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, String> aadhar = createColumn(
		"aadhar", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Date> joiningDate = createColumn(
		"joiningDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Date> dob = createColumn(
		"dob", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Boolean> maritalstatus =
		createColumn(
			"maritalstatus", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Date> anniversaryDate =
		createColumn(
			"anniversaryDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<EmployeeDetailsTable, Long> fileEntryId = createColumn(
		"fileEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EmployeeDetailsTable() {
		super("INTRANET_EmployeeDetails", EmployeeDetailsTable::new);
	}

}