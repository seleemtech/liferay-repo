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

package com.fitness.club.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FitnessService}.
 *
 * @author Brian Wing Shun Chan
 * @see FitnessService
 * @generated
 */
public class FitnessServiceWrapper
	implements FitnessService, ServiceWrapper<FitnessService> {

	public FitnessServiceWrapper() {
		this(null);
	}

	public FitnessServiceWrapper(FitnessService fitnessService) {
		_fitnessService = fitnessService;
	}

	@Override
	public com.fitness.club.service.model.Fitness add(
		String trainerName, String gender, long age, long experiance,
		String Type, long conNumber, long image) {

		return _fitnessService.add(
			trainerName, gender, age, experiance, Type, conNumber, image);
	}

	@Override
	public com.fitness.club.service.model.Fitness addFitness(String params) {
		return _fitnessService.addFitness(params);
	}

	@Override
	public void delteFitness(long trainerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_fitnessService.delteFitness(trainerId);
	}

	@Override
	public java.util.List<com.fitness.club.service.model.Fitness>
		getFitnesses() {

		return _fitnessService.getFitnesses();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fitnessService.getOSGiServiceIdentifier();
	}

	@Override
	public com.fitness.club.service.model.Fitness updateFitness(
			long trainerId, String params)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fitnessService.updateFitness(trainerId, params);
	}

	@Override
	public FitnessService getWrappedService() {
		return _fitnessService;
	}

	@Override
	public void setWrappedService(FitnessService fitnessService) {
		_fitnessService = fitnessService;
	}

	private FitnessService _fitnessService;

}