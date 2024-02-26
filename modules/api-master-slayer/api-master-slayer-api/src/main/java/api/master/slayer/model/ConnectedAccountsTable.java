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
 * The table class for the &quot;API_ConnectedAccounts&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ConnectedAccounts
 * @generated
 */
public class ConnectedAccountsTable extends BaseTable<ConnectedAccountsTable> {

	public static final ConnectedAccountsTable INSTANCE =
		new ConnectedAccountsTable();

	public final Column<ConnectedAccountsTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectedAccountsTable, Long> c_accountId =
		createColumn(
			"c_accountId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ConnectedAccountsTable, String> emailAddress =
		createColumn(
			"emailAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectedAccountsTable, String> appName = createColumn(
		"appName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectedAccountsTable, String> refreshToken =
		createColumn(
			"refreshToken", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectedAccountsTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ConnectedAccountsTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ConnectedAccountsTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ConnectedAccountsTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ConnectedAccountsTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ConnectedAccountsTable() {
		super("API_ConnectedAccounts", ConnectedAccountsTable::new);
	}

}