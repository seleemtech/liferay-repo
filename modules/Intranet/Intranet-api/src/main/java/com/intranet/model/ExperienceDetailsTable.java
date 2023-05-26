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
 * The table class for the &quot;INTRANET_ExperienceDetails&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ExperienceDetails
 * @generated
 */
public class ExperienceDetailsTable extends BaseTable<ExperienceDetailsTable> {

	public static final ExperienceDetailsTable INSTANCE =
		new ExperienceDetailsTable();

	public final Column<ExperienceDetailsTable, Long> experienceId =
		createColumn(
			"experienceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ExperienceDetailsTable, Long> employeeID = createColumn(
		"employeeID", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ExperienceDetailsTable, String> organization =
		createColumn(
			"organization", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExperienceDetailsTable, String> designation =
		createColumn(
			"designation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ExperienceDetailsTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ExperienceDetailsTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ExperienceDetailsTable() {
		super("INTRANET_ExperienceDetails", ExperienceDetailsTable::new);
	}

}