/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;API_ApiMapKey&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ApiMapKey
 * @generated
 */
public class ApiMapKeyTable extends BaseTable<ApiMapKeyTable> {

	public static final ApiMapKeyTable INSTANCE = new ApiMapKeyTable();

	public final Column<ApiMapKeyTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ApiMapKeyTable, Long> apiMapKeyId = createColumn(
		"apiMapKeyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ApiMapKeyTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ApiMapKeyTable, String> key = createColumn(
		"key_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ApiMapKeyTable, String> typeSettings = createColumn(
		"typeSettings", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ApiMapKeyTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ApiMapKeyTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ApiMapKeyTable() {
		super("API_ApiMapKey", ApiMapKeyTable::new);
	}

}