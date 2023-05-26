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

package com.candidate.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;RMS_CandidateOtherInfo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateOtherInfo
 * @generated
 */
public class CandidateOtherInfoTable
	extends BaseTable<CandidateOtherInfoTable> {

	public static final CandidateOtherInfoTable INSTANCE =
		new CandidateOtherInfoTable();

	public final Column<CandidateOtherInfoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, Long> candidateOtherInfoId =
		createColumn(
			"candidateOtherInfoId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<CandidateOtherInfoTable, Long> candidateId =
		createColumn(
			"candidateId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> candidateStatus =
		createColumn(
			"candidateStatus", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> candidateStage =
		createColumn(
			"candidateStage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> source = createColumn(
		"source", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> candidateOwner =
		createColumn(
			"candidateOwner", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> institute =
		createColumn(
			"institute", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> department =
		createColumn(
			"department", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> degree = createColumn(
		"degree", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> fromDuration =
		createColumn(
			"fromDuration", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> toDuration =
		createColumn(
			"toDuration", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> occupation =
		createColumn(
			"occupation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> company = createColumn(
		"company", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> summary = createColumn(
		"summary", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> fromWorkDuration =
		createColumn(
			"fromWorkDuration", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, String> toWorkDuration =
		createColumn(
			"toWorkDuration", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CandidateOtherInfoTable, Long> folderId = createColumn(
		"folderId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private CandidateOtherInfoTable() {
		super("RMS_CandidateOtherInfo", CandidateOtherInfoTable::new);
	}

}