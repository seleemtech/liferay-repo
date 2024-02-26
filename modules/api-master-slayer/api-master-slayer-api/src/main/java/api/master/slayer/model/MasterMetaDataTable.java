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
 * The table class for the &quot;API_MasterMetaData&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see MasterMetaData
 * @generated
 */
public class MasterMetaDataTable extends BaseTable<MasterMetaDataTable> {

	public static final MasterMetaDataTable INSTANCE =
		new MasterMetaDataTable();

	public final Column<MasterMetaDataTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MasterMetaDataTable, Long> mmdId = createColumn(
		"mmdId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MasterMetaDataTable, Long> masterUrlId = createColumn(
		"masterUrlId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MasterMetaDataTable, String> appSubUrl = createColumn(
		"appSubUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MasterMetaDataTable, String> httpMethod = createColumn(
		"httpMethod", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MasterMetaDataTable, String> httpMethodName =
		createColumn(
			"httpMethodName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MasterMetaDataTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MasterMetaDataTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MasterMetaDataTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MasterMetaDataTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MasterMetaDataTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private MasterMetaDataTable() {
		super("API_MasterMetaData", MasterMetaDataTable::new);
	}

}