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

package com.interview.info.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;RMS_InterviewInfo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see InterviewInfo
 * @generated
 */
public class InterviewInfoTable extends BaseTable<InterviewInfoTable> {

	public static final InterviewInfoTable INSTANCE = new InterviewInfoTable();

	public final Column<InterviewInfoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> interviewId = createColumn(
		"interviewId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<InterviewInfoTable, String> interviewName =
		createColumn(
			"interviewName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> postingTitleId = createColumn(
		"postingTitleId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> candidateId = createColumn(
		"candidateId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> clientId = createColumn(
		"clientId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> interviewFrom = createColumn(
		"interviewFrom", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> interviewTo = createColumn(
		"interviewTo", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, String> interviewers = createColumn(
		"interviewers", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> interviewOwner = createColumn(
		"interviewOwner", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, String> scheduleComments =
		createColumn(
			"scheduleComments", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> attachmentId = createColumn(
		"attachmentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> createdBy = createColumn(
		"createdBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> createdDate = createColumn(
		"createdDate", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> modifiedBy = createColumn(
		"modifiedBy", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterviewInfoTable, Long> modifiedDate = createColumn(
		"modifiedDate", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private InterviewInfoTable() {
		super("RMS_InterviewInfo", InterviewInfoTable::new);
	}

}