/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;API_MasterUrl&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see MasterUrl
 * @generated
 */
public class MasterUrlTable extends BaseTable<MasterUrlTable> {

	public static final MasterUrlTable INSTANCE = new MasterUrlTable();

	public final Column<MasterUrlTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MasterUrlTable, Long> masterUrlId = createColumn(
		"masterUrlId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MasterUrlTable, String> appName = createColumn(
		"appName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MasterUrlTable, String> baseUrl = createColumn(
		"baseUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MasterUrlTable, String> svgIcon = createColumn(
		"svgIcon", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MasterUrlTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MasterUrlTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MasterUrlTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MasterUrlTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MasterUrlTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private MasterUrlTable() {
		super("API_MasterUrl", MasterUrlTable::new);
	}

}