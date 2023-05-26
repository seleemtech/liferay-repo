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

package com.docter.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DOC_Docters&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Docters
 * @generated
 */
public class DoctersTable extends BaseTable<DoctersTable> {

	public static final DoctersTable INSTANCE = new DoctersTable();

	public final Column<DoctersTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctersTable, Long> docterId = createColumn(
		"docterId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DoctersTable, String> docterName = createColumn(
		"docterName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DoctersTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DoctersTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DoctersTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DoctersTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DoctersTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DoctersTable, Integer> status = createColumn(
		"STATUS", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DoctersTable, Long> statusByUserId = createColumn(
		"STATUS_BY_USER_ID", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DoctersTable, String> statusByUserName = createColumn(
		"STATUS_BY_USER_NAME", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<DoctersTable, Date> statusDate = createColumn(
		"STATUS_DATE", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DoctersTable() {
		super("DOC_Docters", DoctersTable::new);
	}

}