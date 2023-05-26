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

package com.interview.info.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InterviewInfoService}.
 *
 * @author Brian Wing Shun Chan
 * @see InterviewInfoService
 * @generated
 */
public class InterviewInfoServiceWrapper
	implements InterviewInfoService, ServiceWrapper<InterviewInfoService> {

	public InterviewInfoServiceWrapper(
		InterviewInfoService interviewInfoService) {

		_interviewInfoService = interviewInfoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _interviewInfoService.getOSGiServiceIdentifier();
	}

	@Override
	public InterviewInfoService getWrappedService() {
		return _interviewInfoService;
	}

	@Override
	public void setWrappedService(InterviewInfoService interviewInfoService) {
		_interviewInfoService = interviewInfoService;
	}

	private InterviewInfoService _interviewInfoService;

}