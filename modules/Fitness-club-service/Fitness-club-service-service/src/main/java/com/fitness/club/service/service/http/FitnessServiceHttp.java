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

package com.fitness.club.service.service.http;

import com.fitness.club.service.service.FitnessServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>FitnessServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FitnessServiceHttp {

	public static com.fitness.club.service.model.Fitness add(
		HttpPrincipal httpPrincipal, String trainerName, String gender,
		long age, long experiance, String Type, long conNumber, long image) {

		try {
			MethodKey methodKey = new MethodKey(
				FitnessServiceUtil.class, "add", _addParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, trainerName, gender, age, experiance, Type,
				conNumber, image);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.fitness.club.service.model.Fitness)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.fitness.club.service.model.Fitness addFitness(
		HttpPrincipal httpPrincipal, String params) {

		try {
			MethodKey methodKey = new MethodKey(
				FitnessServiceUtil.class, "addFitness",
				_addFitnessParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, params);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.fitness.club.service.model.Fitness)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.fitness.club.service.model.Fitness updateFitness(
			HttpPrincipal httpPrincipal, long trainerId, String params)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FitnessServiceUtil.class, "updateFitness",
				_updateFitnessParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, trainerId, params);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.fitness.club.service.model.Fitness)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void delteFitness(HttpPrincipal httpPrincipal, long trainerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				FitnessServiceUtil.class, "delteFitness",
				_delteFitnessParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, trainerId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.fitness.club.service.model.Fitness>
		getFitnesses(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				FitnessServiceUtil.class, "getFitnesses",
				_getFitnessesParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.fitness.club.service.model.Fitness>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FitnessServiceHttp.class);

	private static final Class<?>[] _addParameterTypes0 = new Class[] {
		String.class, String.class, long.class, long.class, String.class,
		long.class, long.class
	};
	private static final Class<?>[] _addFitnessParameterTypes1 = new Class[] {
		String.class
	};
	private static final Class<?>[] _updateFitnessParameterTypes2 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _delteFitnessParameterTypes3 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getFitnessesParameterTypes4 =
		new Class[] {};

}