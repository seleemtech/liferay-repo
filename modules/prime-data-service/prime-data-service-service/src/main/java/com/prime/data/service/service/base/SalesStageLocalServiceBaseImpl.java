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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.prime.data.service.model.SalesStage;
import com.prime.data.service.service.SalesStageLocalService;
import com.prime.data.service.service.SalesStageLocalServiceUtil;
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

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the sales stage local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.prime.data.service.service.impl.SalesStageLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.prime.data.service.service.impl.SalesStageLocalServiceImpl
 * @generated
 */
public abstract class SalesStageLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, SalesStageLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>SalesStageLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>SalesStageLocalServiceUtil</code>.
	 */

	/**
	 * Adds the sales stage to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesStageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesStage the sales stage
	 * @return the sales stage that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SalesStage addSalesStage(SalesStage salesStage) {
		salesStage.setNew(true);

		return salesStagePersistence.update(salesStage);
	}

	/**
	 * Creates a new sales stage with the primary key. Does not add the sales stage to the database.
	 *
	 * @param salesStageId the primary key for the new sales stage
	 * @return the new sales stage
	 */
	@Override
	@Transactional(enabled = false)
	public SalesStage createSalesStage(long salesStageId) {
		return salesStagePersistence.create(salesStageId);
	}

	/**
	 * Deletes the sales stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesStageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage that was removed
	 * @throws PortalException if a sales stage with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SalesStage deleteSalesStage(long salesStageId)
		throws PortalException {

		return salesStagePersistence.remove(salesStageId);
	}

	/**
	 * Deletes the sales stage from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesStageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesStage the sales stage
	 * @return the sales stage that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SalesStage deleteSalesStage(SalesStage salesStage) {
		return salesStagePersistence.remove(salesStage);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return salesStagePersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			SalesStage.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return salesStagePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return salesStagePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return salesStagePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return salesStagePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return salesStagePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public SalesStage fetchSalesStage(long salesStageId) {
		return salesStagePersistence.fetchByPrimaryKey(salesStageId);
	}

	/**
	 * Returns the sales stage with the primary key.
	 *
	 * @param salesStageId the primary key of the sales stage
	 * @return the sales stage
	 * @throws PortalException if a sales stage with the primary key could not be found
	 */
	@Override
	public SalesStage getSalesStage(long salesStageId) throws PortalException {
		return salesStagePersistence.findByPrimaryKey(salesStageId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(salesStageLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SalesStage.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("salesStageId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			salesStageLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(SalesStage.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"salesStageId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(salesStageLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(SalesStage.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("salesStageId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return salesStagePersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return salesStageLocalService.deleteSalesStage(
			(SalesStage)persistedModel);
	}

	@Override
	public BasePersistence<SalesStage> getBasePersistence() {
		return salesStagePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return salesStagePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the sales stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.SalesStageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sales stages
	 * @param end the upper bound of the range of sales stages (not inclusive)
	 * @return the range of sales stages
	 */
	@Override
	public List<SalesStage> getSalesStages(int start, int end) {
		return salesStagePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of sales stages.
	 *
	 * @return the number of sales stages
	 */
	@Override
	public int getSalesStagesCount() {
		return salesStagePersistence.countAll();
	}

	/**
	 * Updates the sales stage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SalesStageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param salesStage the sales stage
	 * @return the sales stage that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SalesStage updateSalesStage(SalesStage salesStage) {
		return salesStagePersistence.update(salesStage);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			SalesStageLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		salesStageLocalService = (SalesStageLocalService)aopProxy;

		_setLocalServiceUtilService(salesStageLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SalesStageLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return SalesStage.class;
	}

	protected String getModelClassName() {
		return SalesStage.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = salesStagePersistence.getDataSource();

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

	private void _setLocalServiceUtilService(
		SalesStageLocalService salesStageLocalService) {

		try {
			Field field = SalesStageLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, salesStageLocalService);
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

	protected SalesStageLocalService salesStageLocalService;

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
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}