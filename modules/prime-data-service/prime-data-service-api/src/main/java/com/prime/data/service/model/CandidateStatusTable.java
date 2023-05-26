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

/**
 * The table class for the &quot;PRIME_CandidateStatus&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateStatus
 * @generated
 */
public class CandidateStatusTable extends BaseTable<CandidateStatusTable> {

	public static final CandidateStatusTable INSTANCE =
		new CandidateStatusTable();

	public final Column<CandidateStatusTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CandidateStatusTable, Long> candidateStatusId =
		createColumn(
			"candidateStatusId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CandidateStatusTable, String> candidateStatus =
		createColumn(
			"candidateStatus", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private CandidateStatusTable() {
		super("PRIME_CandidateStatus", CandidateStatusTable::new);
	}

}