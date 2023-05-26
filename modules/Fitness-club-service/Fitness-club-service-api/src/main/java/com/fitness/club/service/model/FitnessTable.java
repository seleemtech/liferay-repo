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

package com.fitness.club.service.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;FOO_Fitness&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Fitness
 * @generated
 */
public class FitnessTable extends BaseTable<FitnessTable> {

	public static final FitnessTable INSTANCE = new FitnessTable();

	public final Column<FitnessTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FitnessTable, Long> trainerId = createColumn(
		"trainerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FitnessTable, String> trainerName = createColumn(
		"trainerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FitnessTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FitnessTable, Long> age = createColumn(
		"age", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FitnessTable, Long> experiance = createColumn(
		"experiance", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FitnessTable, String> Type = createColumn(
		"Type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FitnessTable, Long> conNumber = createColumn(
		"conNumber", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FitnessTable, Long> image = createColumn(
		"image", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private FitnessTable() {
		super("FOO_Fitness", FitnessTable::new);
	}

}