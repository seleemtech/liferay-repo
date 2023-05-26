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
 * The table class for the &quot;INTRANET_ComplaintBox&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ComplaintBox
 * @generated
 */
public class ComplaintBoxTable extends BaseTable<ComplaintBoxTable> {

	public static final ComplaintBoxTable INSTANCE = new ComplaintBoxTable();

	public final Column<ComplaintBoxTable, Long> fooId = createColumn(
		"fooId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ComplaintBoxTable, String> employeeId = createColumn(
		"employeeId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, String> posistionType = createColumn(
		"posistionType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Date> submittedDate = createColumn(
		"submittedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question1 = createColumn(
		"question1", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question2 = createColumn(
		"question2", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question3 = createColumn(
		"question3", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question4 = createColumn(
		"question4", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question5 = createColumn(
		"question5", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question6 = createColumn(
		"question6", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question7 = createColumn(
		"question7", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question8 = createColumn(
		"question8", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question9 = createColumn(
		"question9", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question10 = createColumn(
		"question10", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question11 = createColumn(
		"question11", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question12 = createColumn(
		"question12", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question13 = createColumn(
		"question13", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question14 = createColumn(
		"question14", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, Integer> question15 = createColumn(
		"question15", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, String> description1 = createColumn(
		"description1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, String> description2 = createColumn(
		"description2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ComplaintBoxTable, String> description3 = createColumn(
		"description3", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ComplaintBoxTable() {
		super("INTRANET_ComplaintBox", ComplaintBoxTable::new);
	}

}