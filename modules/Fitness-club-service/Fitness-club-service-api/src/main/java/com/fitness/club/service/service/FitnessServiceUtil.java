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

import com.fitness.club.service.model.Fitness;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Fitness. This utility wraps
 * <code>com.fitness.club.service.service.impl.FitnessServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FitnessService
 * @generated
 */
public class FitnessServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.fitness.club.service.service.impl.FitnessServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Fitness add(
		String trainerName, String gender, long age, long experiance,
		String Type, long conNumber, long image) {

		return getService().add(
			trainerName, gender, age, experiance, Type, conNumber, image);
	}

	public static Fitness addFitness(String params) {
		return getService().addFitness(params);
	}

	public static void delteFitness(long trainerId) throws PortalException {
		getService().delteFitness(trainerId);
	}

	public static List<Fitness> getFitnesses() {
		return getService().getFitnesses();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Fitness updateFitness(long trainerId, String params)
		throws PortalException {

		return getService().updateFitness(trainerId, params);
	}

	public static FitnessService getService() {
		return _service;
	}

	private static volatile FitnessService _service;

}