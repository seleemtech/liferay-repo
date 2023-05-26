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
 * The table class for the &quot;INTRANET_EducationDetails&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EducationDetails
 * @generated
 */
public class EducationDetailsTable extends BaseTable<EducationDetailsTable> {

	public static final EducationDetailsTable INSTANCE =
		new EducationDetailsTable();

	public final Column<EducationDetailsTable, Long> educationId = createColumn(
		"educationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EducationDetailsTable, Long> employeeID = createColumn(
		"employeeID", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> pgGraduation =
		createColumn(
			"pgGraduation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> pgSpecialization =
		createColumn(
			"pgSpecialization", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> pgUniversity =
		createColumn(
			"pgUniversity", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> pgPassout = createColumn(
		"pgPassout", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> pgPercentage =
		createColumn(
			"pgPercentage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> graduation =
		createColumn(
			"graduation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> specialization =
		createColumn(
			"specialization", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> university =
		createColumn(
			"university", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> passout = createColumn(
		"passout", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> percentage =
		createColumn(
			"percentage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> hscSchool = createColumn(
		"hscSchool", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> hscPassout =
		createColumn(
			"hscPassout", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> hscPercentage =
		createColumn(
			"hscPercentage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> sslcSchool =
		createColumn(
			"sslcSchool", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> sslcPassout =
		createColumn(
			"sslcPassout", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EducationDetailsTable, String> sslcPercentage =
		createColumn(
			"sslcPercentage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EducationDetailsTable() {
		super("INTRANET_EducationDetails", EducationDetailsTable::new);
	}

}