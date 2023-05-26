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

import java.util.Date;

/**
 * The table class for the &quot;PRIME_DocumentMapper&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMapper
 * @generated
 */
public class DocumentMapperTable extends BaseTable<DocumentMapperTable> {

	public static final DocumentMapperTable INSTANCE =
		new DocumentMapperTable();

	public final Column<DocumentMapperTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentMapperTable, Long> recordId = createColumn(
		"recordId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DocumentMapperTable, String> moduleName = createColumn(
		"moduleName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentMapperTable, Long> classPk = createColumn(
		"classPk", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentMapperTable, String> documentName =
		createColumn(
			"documentName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentMapperTable, Long> documentId = createColumn(
		"documentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentMapperTable, Date> createdDate = createColumn(
		"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DocumentMapperTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DocumentMapperTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DocumentMapperTable() {
		super("PRIME_DocumentMapper", DocumentMapperTable::new);
	}

}