/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MasterMetaDataService}.
 *
 * @author Brian Wing Shun Chan
 * @see MasterMetaDataService
 * @generated
 */
public class MasterMetaDataServiceWrapper
	implements MasterMetaDataService, ServiceWrapper<MasterMetaDataService> {

	public MasterMetaDataServiceWrapper() {
		this(null);
	}

	public MasterMetaDataServiceWrapper(
		MasterMetaDataService masterMetaDataService) {

		_masterMetaDataService = masterMetaDataService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _masterMetaDataService.getOSGiServiceIdentifier();
	}

	@Override
	public MasterMetaDataService getWrappedService() {
		return _masterMetaDataService;
	}

	@Override
	public void setWrappedService(MasterMetaDataService masterMetaDataService) {
		_masterMetaDataService = masterMetaDataService;
	}

	private MasterMetaDataService _masterMetaDataService;

}