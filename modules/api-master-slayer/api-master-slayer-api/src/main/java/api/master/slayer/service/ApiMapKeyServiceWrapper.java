/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApiMapKeyService}.
 *
 * @author Brian Wing Shun Chan
 * @see ApiMapKeyService
 * @generated
 */
public class ApiMapKeyServiceWrapper
	implements ApiMapKeyService, ServiceWrapper<ApiMapKeyService> {

	public ApiMapKeyServiceWrapper() {
		this(null);
	}

	public ApiMapKeyServiceWrapper(ApiMapKeyService apiMapKeyService) {
		_apiMapKeyService = apiMapKeyService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _apiMapKeyService.getOSGiServiceIdentifier();
	}

	@Override
	public ApiMapKeyService getWrappedService() {
		return _apiMapKeyService;
	}

	@Override
	public void setWrappedService(ApiMapKeyService apiMapKeyService) {
		_apiMapKeyService = apiMapKeyService;
	}

	private ApiMapKeyService _apiMapKeyService;

}