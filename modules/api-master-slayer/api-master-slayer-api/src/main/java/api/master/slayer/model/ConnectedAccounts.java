/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ConnectedAccounts service. Represents a row in the &quot;API_ConnectedAccounts&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ConnectedAccountsModel
 * @generated
 */
@ImplementationClassName("api.master.slayer.model.impl.ConnectedAccountsImpl")
@ProviderType
public interface ConnectedAccounts
	extends ConnectedAccountsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>api.master.slayer.model.impl.ConnectedAccountsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ConnectedAccounts, Long>
		C_ACCOUNT_ID_ACCESSOR = new Accessor<ConnectedAccounts, Long>() {

			@Override
			public Long get(ConnectedAccounts connectedAccounts) {
				return connectedAccounts.getC_accountId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ConnectedAccounts> getTypeClass() {
				return ConnectedAccounts.class;
			}

		};

}