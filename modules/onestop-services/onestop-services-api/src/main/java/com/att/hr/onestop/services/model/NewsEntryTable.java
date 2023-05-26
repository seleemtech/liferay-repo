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

package com.att.hr.onestop.services.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;HROS_NewsEntry&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see NewsEntry
 * @generated
 */
public class NewsEntryTable extends BaseTable<NewsEntryTable> {

	public static final NewsEntryTable INSTANCE = new NewsEntryTable();

	public final Column<NewsEntryTable, Long> newsEntryId = createColumn(
		"NEWS_ENTRY_ID", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NewsEntryTable, Long> groupId = createColumn(
		"GROUP_ID", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Long> companyId = createColumn(
		"COMPANY_ID", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Long> userId = createColumn(
		"USER_ID", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Date> createDate = createColumn(
		"CREATE_DATE", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Date> modifiedDate = createColumn(
		"MODIFIED_DATE", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, String> newsTitle = createColumn(
		"NEWS_TITLE", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, String> newsSummary = createColumn(
		"NEWS_SUMMARY", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, String> newsContent = createColumn(
		"NEWS_CONTENT", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Long> newsImageId = createColumn(
		"NEWS_IMAGE_ID", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Long> newsScopeId = createColumn(
		"NEWS_SCOPE_ID", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Boolean> archive = createColumn(
		"ARCHIVE", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Boolean> allowedInDashBoard =
		createColumn(
			"ALLOWED_IN_DASHBOARD", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Date> expireDate = createColumn(
		"EXPIRE_DATE", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, String> ToEmail = createColumn(
		"TO_NEWS_EMAIL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Integer> status = createColumn(
		"STATUS", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Long> statusByUserId = createColumn(
		"STATUS_BY_USER_ID", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, String> statusByUserName = createColumn(
		"STATUS_BY_USER_NAME", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<NewsEntryTable, Date> statusDate = createColumn(
		"STATUS_DATE", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private NewsEntryTable() {
		super("HROS_NewsEntry", NewsEntryTable::new);
	}

}