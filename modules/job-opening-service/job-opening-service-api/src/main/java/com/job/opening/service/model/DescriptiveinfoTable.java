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

package com.job.opening.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rms_Descriptiveinfo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Descriptiveinfo
 * @generated
 */
public class DescriptiveinfoTable extends BaseTable<DescriptiveinfoTable> {

	public static final DescriptiveinfoTable INSTANCE =
		new DescriptiveinfoTable();

	public final Column<DescriptiveinfoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DescriptiveinfoTable, Long> descriptiveId =
		createColumn(
			"descriptiveId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DescriptiveinfoTable, Long> jobId = createColumn(
		"jobId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DescriptiveinfoTable, String> jobDescription =
		createColumn(
			"jobDescription", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DescriptiveinfoTable, String> requirements =
		createColumn(
			"requirements", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DescriptiveinfoTable, String> benefits = createColumn(
		"benefits", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DescriptiveinfoTable() {
		super("rms_Descriptiveinfo", DescriptiveinfoTable::new);
	}

}