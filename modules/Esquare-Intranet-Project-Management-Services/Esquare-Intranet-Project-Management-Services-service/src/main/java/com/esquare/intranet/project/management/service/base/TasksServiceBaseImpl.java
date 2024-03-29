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

package com.esquare.intranet.project.management.service.base;

import com.esquare.intranet.project.management.model.Tasks;
import com.esquare.intranet.project.management.service.TasksService;
import com.esquare.intranet.project.management.service.TasksServiceUtil;
import com.esquare.intranet.project.management.service.persistence.NotesPersistence;
import com.esquare.intranet.project.management.service.persistence.ProjectsPersistence;
import com.esquare.intranet.project.management.service.persistence.TasksPersistence;
import com.esquare.intranet.project.management.service.persistence.TeamMembersPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the tasks remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.esquare.intranet.project.management.service.impl.TasksServiceImpl}.
 * </p>
 *
 * @author Mahammed Seleem
 * @see com.esquare.intranet.project.management.service.impl.TasksServiceImpl
 * @generated
 */
public abstract class TasksServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, TasksService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TasksService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>TasksServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			TasksService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		tasksService = (TasksService)aopProxy;

		_setServiceUtilService(tasksService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TasksService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Tasks.class;
	}

	protected String getModelClassName() {
		return Tasks.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = tasksPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(TasksService tasksService) {
		try {
			Field field = TasksServiceUtil.class.getDeclaredField("_service");

			field.setAccessible(true);

			field.set(null, tasksService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected NotesPersistence notesPersistence;

	@Reference
	protected ProjectsPersistence projectsPersistence;

	@Reference
	protected com.esquare.intranet.project.management.service.TasksLocalService
		tasksLocalService;

	protected TasksService tasksService;

	@Reference
	protected TasksPersistence tasksPersistence;

	@Reference
	protected TeamMembersPersistence teamMembersPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	private static final Log _log = LogFactoryUtil.getLog(
		TasksServiceBaseImpl.class);

}