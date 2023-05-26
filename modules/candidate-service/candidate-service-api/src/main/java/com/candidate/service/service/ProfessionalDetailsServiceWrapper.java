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

package com.candidate.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProfessionalDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalDetailsService
 * @generated
 */
public class ProfessionalDetailsServiceWrapper
	implements ProfessionalDetailsService,
			   ServiceWrapper<ProfessionalDetailsService> {

	public ProfessionalDetailsServiceWrapper(
		ProfessionalDetailsService professionalDetailsService) {

		_professionalDetailsService = professionalDetailsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _professionalDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public ProfessionalDetailsService getWrappedService() {
		return _professionalDetailsService;
	}

	@Override
	public void setWrappedService(
		ProfessionalDetailsService professionalDetailsService) {

		_professionalDetailsService = professionalDetailsService;
	}

	private ProfessionalDetailsService _professionalDetailsService;

}