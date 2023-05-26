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
 * The table class for the &quot;RMS_ProfessionalDetails&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalDetails
 * @generated
 */
public class ProfessionalDetailsTable
	extends BaseTable<ProfessionalDetailsTable> {

	public static final ProfessionalDetailsTable INSTANCE =
		new ProfessionalDetailsTable();

	public final Column<ProfessionalDetailsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, Long> professionalDetailsId =
		createColumn(
			"professionalDetailsId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ProfessionalDetailsTable, Long> candidateId =
		createColumn(
			"candidateId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, Double> expectedSalary =
		createColumn(
			"expectedSalary", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, Double> currentSalary =
		createColumn(
			"currentSalary", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, String> skillSet =
		createColumn(
			"skillSet", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, String> additionalInfo =
		createColumn(
			"additionalInfo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, String> currentEmployer =
		createColumn(
			"currentEmployer", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, String> workType =
		createColumn(
			"workType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, String> experience =
		createColumn(
			"experience ", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, String> qualification =
		createColumn(
			"qualification", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, String> jobTitle =
		createColumn(
			"jobTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProfessionalDetailsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ProfessionalDetailsTable() {
		super("RMS_ProfessionalDetails", ProfessionalDetailsTable::new);
	}

}