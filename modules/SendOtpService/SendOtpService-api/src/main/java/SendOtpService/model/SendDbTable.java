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

package SendOtpService.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;FOO_SendDb&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SendDb
 * @generated
 */
public class SendDbTable extends BaseTable<SendDbTable> {

	public static final SendDbTable INSTANCE = new SendDbTable();

	public final Column<SendDbTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SendDbTable, Long> sendId = createColumn(
		"sendId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SendDbTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SendDbTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SendDbTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SendDbTable, Long> mobileNumber = createColumn(
		"mobileNumber", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SendDbTable, String> Name = createColumn(
		"Name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private SendDbTable() {
		super("FOO_SendDb", SendDbTable::new);
	}

}