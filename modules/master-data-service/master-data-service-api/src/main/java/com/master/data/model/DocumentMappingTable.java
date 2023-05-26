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

package com.master.data.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Master_DocumentMapping&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMapping
 * @generated
 */
public class DocumentMappingTable extends BaseTable<DocumentMappingTable> {

	public static final DocumentMappingTable INSTANCE =
		new DocumentMappingTable();

	public final Column<DocumentMappingTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentMappingTable, Long> recordId = createColumn(
		"recordId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DocumentMappingTable, String> moduleName = createColumn(
		"moduleName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentMappingTable, Long> classPk = createColumn(
		"classPk", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentMappingTable, String> documentName =
		createColumn(
			"documentName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DocumentMappingTable, Long> documentId = createColumn(
		"documentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DocumentMappingTable, Date> createdDate = createColumn(
		"createdDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DocumentMappingTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DocumentMappingTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DocumentMappingTable() {
		super("Master_DocumentMapping", DocumentMappingTable::new);
	}

}