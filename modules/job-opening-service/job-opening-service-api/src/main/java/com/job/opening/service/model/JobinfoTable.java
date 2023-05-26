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

import java.util.Date;

/**
 * The table class for the &quot;rms_Jobinfo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Jobinfo
 * @generated
 */
public class JobinfoTable extends BaseTable<JobinfoTable> {

	public static final JobinfoTable INSTANCE = new JobinfoTable();

	public final Column<JobinfoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, Long> jobId = createColumn(
		"jobId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<JobinfoTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> postingTitle = createColumn(
		"postingTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> assignedRecruiter = createColumn(
		"assignedRecruiter", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, Date> targetDate = createColumn(
		"targetDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> jobopeningStatus = createColumn(
		"jobopeningStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> industry = createColumn(
		"industry", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> jobResource = createColumn(
		"jobResource", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> hiringManager = createColumn(
		"hiringManager", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> clientName = createColumn(
		"clientName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> positions = createColumn(
		"positions", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, Date> dateOpened = createColumn(
		"dateOpened", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> jobType = createColumn(
		"jobType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> workExperience = createColumn(
		"workExperience", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> skillSet = createColumn(
		"skillSet", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, String> projectStatus = createColumn(
		"projectStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, Long> summaryId = createColumn(
		"summaryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<JobinfoTable, Long> otherId = createColumn(
		"otherId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private JobinfoTable() {
		super("rms_Jobinfo", JobinfoTable::new);
	}

}