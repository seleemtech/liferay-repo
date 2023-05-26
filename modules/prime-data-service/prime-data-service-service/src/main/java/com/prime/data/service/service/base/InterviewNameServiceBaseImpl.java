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

package com.prime.data.service.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.prime.data.service.model.InterviewName;
import com.prime.data.service.service.InterviewNameService;
import com.prime.data.service.service.InterviewNameServiceUtil;
import com.prime.data.service.service.persistence.CandidateStatusPersistence;
import com.prime.data.service.service.persistence.CurrJobTitlePersistence;
import com.prime.data.service.service.persistence.DocumentMapperPersistence;
import com.prime.data.service.service.persistence.HighQualHeldPersistence;
import com.prime.data.service.service.persistence.IndustryPersistence;
import com.prime.data.service.service.persistence.InterviewNamePersistence;
import com.prime.data.service.service.persistence.JobOpeningStatusPersistence;
import com.prime.data.service.service.persistence.JobTypePersistence;
import com.prime.data.service.service.persistence.MainTablePersistence;
import com.prime.data.service.service.persistence.NamePrefixPersistence;
import com.prime.data.service.service.persistence.PriorityPersistence;
import com.prime.data.service.service.persistence.ProjectStatusPersistence;
import com.prime.data.service.service.persistence.SalaryRangePersistence;
import com.prime.data.service.service.persistence.SalesStagePersistence;
import com.prime.data.service.service.persistence.SkillSetPersistence;
import com.prime.data.service.service.persistence.SourceByPersistence;
import com.prime.data.service.service.persistence.WorkExperiencePersistence;
import com.prime.data.service.service.persistence.WorkTypePersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the interview name remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.prime.data.service.service.impl.InterviewNameServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.prime.data.service.service.impl.InterviewNameServiceImpl
 * @generated
 */
public abstract class InterviewNameServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, InterviewNameService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>InterviewNameService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>InterviewNameServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			InterviewNameService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		interviewNameService = (InterviewNameService)aopProxy;

		_setServiceUtilService(interviewNameService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return InterviewNameService.class.getName();
	}

	protected Class<?> getModelClass() {
		return InterviewName.class;
	}

	protected String getModelClassName() {
		return InterviewName.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = interviewNamePersistence.getDataSource();

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

	private void _setServiceUtilService(
		InterviewNameService interviewNameService) {

		try {
			Field field = InterviewNameServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, interviewNameService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected CandidateStatusPersistence candidateStatusPersistence;

	@Reference
	protected CurrJobTitlePersistence currJobTitlePersistence;

	@Reference
	protected DocumentMapperPersistence documentMapperPersistence;

	@Reference
	protected HighQualHeldPersistence highQualHeldPersistence;

	@Reference
	protected IndustryPersistence industryPersistence;

	@Reference
	protected com.prime.data.service.service.InterviewNameLocalService
		interviewNameLocalService;

	protected InterviewNameService interviewNameService;

	@Reference
	protected InterviewNamePersistence interviewNamePersistence;

	@Reference
	protected JobOpeningStatusPersistence jobOpeningStatusPersistence;

	@Reference
	protected JobTypePersistence jobTypePersistence;

	@Reference
	protected MainTablePersistence mainTablePersistence;

	@Reference
	protected NamePrefixPersistence namePrefixPersistence;

	@Reference
	protected PriorityPersistence priorityPersistence;

	@Reference
	protected ProjectStatusPersistence projectStatusPersistence;

	@Reference
	protected SalaryRangePersistence salaryRangePersistence;

	@Reference
	protected SalesStagePersistence salesStagePersistence;

	@Reference
	protected SkillSetPersistence skillSetPersistence;

	@Reference
	protected SourceByPersistence sourceByPersistence;

	@Reference
	protected WorkExperiencePersistence workExperiencePersistence;

	@Reference
	protected WorkTypePersistence workTypePersistence;

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

}