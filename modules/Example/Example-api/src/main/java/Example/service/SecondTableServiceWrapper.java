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

package Example.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SecondTableService}.
 *
 * @author Brian Wing Shun Chan
 * @see SecondTableService
 * @generated
 */
public class SecondTableServiceWrapper
	implements SecondTableService, ServiceWrapper<SecondTableService> {

	public SecondTableServiceWrapper() {
		this(null);
	}

	public SecondTableServiceWrapper(SecondTableService secondTableService) {
		_secondTableService = secondTableService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _secondTableService.getOSGiServiceIdentifier();
	}

	@Override
	public SecondTableService getWrappedService() {
		return _secondTableService;
	}

	@Override
	public void setWrappedService(SecondTableService secondTableService) {
		_secondTableService = secondTableService;
	}

	private SecondTableService _secondTableService;

}