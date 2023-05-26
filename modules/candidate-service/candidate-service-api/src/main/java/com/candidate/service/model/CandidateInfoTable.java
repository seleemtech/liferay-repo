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
 * The table class for the &quot;RMS_CandidateInfo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateInfo
 * @generated
 */
public class CandidateInfoTable extends BaseTable<CandidateInfoTable> {

	public static final CandidateInfoTable INSTANCE = new CandidateInfoTable();

	public final Column<CandidateInfoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, Long> candidateId = createColumn(
		"candidateId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CandidateInfoTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> secondaryEmail =
		createColumn(
			"secondaryEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> mobileNumber = createColumn(
		"mobileNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> street = createColumn(
		"street", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> country = createColumn(
		"country", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> city = createColumn(
		"city", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> zipCode = createColumn(
		"zipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> houseNumber = createColumn(
		"houseNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, String> website = createColumn(
		"website", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CandidateInfoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private CandidateInfoTable() {
		super("RMS_CandidateInfo", CandidateInfoTable::new);
	}

}