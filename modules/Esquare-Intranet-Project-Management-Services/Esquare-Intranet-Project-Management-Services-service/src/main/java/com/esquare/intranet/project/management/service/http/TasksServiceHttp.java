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

package com.esquare.intranet.project.management.service.http;

import com.esquare.intranet.project.management.service.TasksServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>TasksServiceUtil</code> service
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
 * @author Mahammed Seleem
 * @generated
 */
public class TasksServiceHttp {

	public static java.util.List
		<com.esquare.intranet.project.management.model.Tasks>
			getTasksByProjectId(HttpPrincipal httpPrincipal, long projectId) {

		try {
			MethodKey methodKey = new MethodKey(
				TasksServiceUtil.class, "getTasksByProjectId",
				_getTasksByProjectIdParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, projectId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.esquare.intranet.project.management.model.Tasks>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.esquare.intranet.project.management.model.Tasks
		updateTask(
			HttpPrincipal httpPrincipal, long taskId, String taskName,
			String taskDesc, String developmentTeamIds, String testerTeamIds,
			java.util.Date startDate, java.util.Date endDate) {

		try {
			MethodKey methodKey = new MethodKey(
				TasksServiceUtil.class, "updateTask",
				_updateTaskParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, taskId, taskName, taskDesc, developmentTeamIds,
				testerTeamIds, startDate, endDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.esquare.intranet.project.management.model.Tasks)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.esquare.intranet.project.management.model.Tasks addTasks(
		HttpPrincipal httpPrincipal, long projectId, String name,
		String description) {

		try {
			MethodKey methodKey = new MethodKey(
				TasksServiceUtil.class, "addTasks", _addTasksParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, projectId, name, description);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.esquare.intranet.project.management.model.Tasks)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TasksServiceHttp.class);

	private static final Class<?>[] _getTasksByProjectIdParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _updateTaskParameterTypes1 = new Class[] {
		long.class, String.class, String.class, String.class, String.class,
		java.util.Date.class, java.util.Date.class
	};
	private static final Class<?>[] _addTasksParameterTypes2 = new Class[] {
		long.class, String.class, String.class
	};

}