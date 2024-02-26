/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MasterUrlService}.
 *
 * @author Brian Wing Shun Chan
 * @see MasterUrlService
 * @generated
 */
public class MasterUrlServiceWrapper
	implements MasterUrlService, ServiceWrapper<MasterUrlService> {

	public MasterUrlServiceWrapper() {
		this(null);
	}

	public MasterUrlServiceWrapper(MasterUrlService masterUrlService) {
		_masterUrlService = masterUrlService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterUrlService.getOSGiServiceIdentifier();
	}

	@Override
	public MasterUrlService getWrappedService() {
		return _masterUrlService;
	}

	@Override
	public void setWrappedService(MasterUrlService masterUrlService) {
		_masterUrlService = masterUrlService;
	}

	private MasterUrlService _masterUrlService;

}