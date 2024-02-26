/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ConnectedAccountsService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConnectedAccountsService
 * @generated
 */
public class ConnectedAccountsServiceWrapper
	implements ConnectedAccountsService,
			   ServiceWrapper<ConnectedAccountsService> {

	public ConnectedAccountsServiceWrapper() {
		this(null);
	}

	public ConnectedAccountsServiceWrapper(
		ConnectedAccountsService connectedAccountsService) {

		_connectedAccountsService = connectedAccountsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _connectedAccountsService.getOSGiServiceIdentifier();
	}

	@Override
	public ConnectedAccountsService getWrappedService() {
		return _connectedAccountsService;
	}

	@Override
	public void setWrappedService(
		ConnectedAccountsService connectedAccountsService) {

		_connectedAccountsService = connectedAccountsService;
	}

	private ConnectedAccountsService _connectedAccountsService;

}