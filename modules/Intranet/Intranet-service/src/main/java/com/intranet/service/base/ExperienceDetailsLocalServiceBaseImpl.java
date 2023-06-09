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

package com.intranet.service.base;

import com.intranet.model.ExperienceDetails;
import com.intranet.service.ExperienceDetailsLocalService;
import com.intranet.service.ExperienceDetailsLocalServiceUtil;
import com.intranet.service.persistence.BillclaimPersistence;
import com.intranet.service.persistence.ComplaintBoxPersistence;
import com.intranet.service.persistence.EducationDetailsPersistence;
import com.intranet.service.persistence.EmployeeDetailsPersistence;
import com.intranet.service.persistence.ExperienceDetailsPersistence;
import com.intranet.service.persistence.GraduationPersistence;
import com.intranet.service.persistence.SpecializationPersistence;
import com.intranet.service.persistence.skillsPersistence;

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

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the experience details local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.intranet.service.impl.ExperienceDetailsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.intranet.service.impl.ExperienceDetailsLocalServiceImpl
 * @generated
 */
public abstract class ExperienceDetailsLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, ExperienceDetailsLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ExperienceDetailsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ExperienceDetailsLocalServiceUtil</code>.
	 */

	/**
	 * Adds the experience details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperienceDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experienceDetails the experience details
	 * @return the experience details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ExperienceDetails addExperienceDetails(
		ExperienceDetails experienceDetails) {

		experienceDetails.setNew(true);

		return experienceDetailsPersistence.update(experienceDetails);
	}

	/**
	 * Creates a new experience details with the primary key. Does not add the experience details to the database.
	 *
	 * @param experienceId the primary key for the new experience details
	 * @return the new experience details
	 */
	@Override
	@Transactional(enabled = false)
	public ExperienceDetails createExperienceDetails(long experienceId) {
		return experienceDetailsPersistence.create(experienceId);
	}

	/**
	 * Deletes the experience details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperienceDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details that was removed
	 * @throws PortalException if a experience details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ExperienceDetails deleteExperienceDetails(long experienceId)
		throws PortalException {

		return experienceDetailsPersistence.remove(experienceId);
	}

	/**
	 * Deletes the experience details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperienceDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experienceDetails the experience details
	 * @return the experience details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ExperienceDetails deleteExperienceDetails(
		ExperienceDetails experienceDetails) {

		return experienceDetailsPersistence.remove(experienceDetails);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return experienceDetailsPersistence.dslQuery(dslQuery);
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
			ExperienceDetails.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return experienceDetailsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.ExperienceDetailsModelImpl</code>.
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

		return experienceDetailsPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.ExperienceDetailsModelImpl</code>.
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

		return experienceDetailsPersistence.findWithDynamicQuery(
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
		return experienceDetailsPersistence.countWithDynamicQuery(dynamicQuery);
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

		return experienceDetailsPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ExperienceDetails fetchExperienceDetails(long experienceId) {
		return experienceDetailsPersistence.fetchByPrimaryKey(experienceId);
	}

	/**
	 * Returns the experience details with the primary key.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details
	 * @throws PortalException if a experience details with the primary key could not be found
	 */
	@Override
	public ExperienceDetails getExperienceDetails(long experienceId)
		throws PortalException {

		return experienceDetailsPersistence.findByPrimaryKey(experienceId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			experienceDetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ExperienceDetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("experienceId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			experienceDetailsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ExperienceDetails.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"experienceId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			experienceDetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ExperienceDetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("experienceId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return experienceDetailsPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return experienceDetailsLocalService.deleteExperienceDetails(
			(ExperienceDetails)persistedModel);
	}

	@Override
	public BasePersistence<ExperienceDetails> getBasePersistence() {
		return experienceDetailsPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return experienceDetailsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @return the range of experience detailses
	 */
	@Override
	public List<ExperienceDetails> getExperienceDetailses(int start, int end) {
		return experienceDetailsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of experience detailses.
	 *
	 * @return the number of experience detailses
	 */
	@Override
	public int getExperienceDetailsesCount() {
		return experienceDetailsPersistence.countAll();
	}

	/**
	 * Updates the experience details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExperienceDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param experienceDetails the experience details
	 * @return the experience details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ExperienceDetails updateExperienceDetails(
		ExperienceDetails experienceDetails) {

		return experienceDetailsPersistence.update(experienceDetails);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ExperienceDetailsLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		experienceDetailsLocalService = (ExperienceDetailsLocalService)aopProxy;

		_setLocalServiceUtilService(experienceDetailsLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ExperienceDetailsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ExperienceDetails.class;
	}

	protected String getModelClassName() {
		return ExperienceDetails.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				experienceDetailsPersistence.getDataSource();

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
		ExperienceDetailsLocalService experienceDetailsLocalService) {

		try {
			Field field =
				ExperienceDetailsLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, experienceDetailsLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected BillclaimPersistence billclaimPersistence;

	@Reference
	protected ComplaintBoxPersistence complaintBoxPersistence;

	@Reference
	protected EducationDetailsPersistence educationDetailsPersistence;

	@Reference
	protected EmployeeDetailsPersistence employeeDetailsPersistence;

	protected ExperienceDetailsLocalService experienceDetailsLocalService;

	@Reference
	protected ExperienceDetailsPersistence experienceDetailsPersistence;

	@Reference
	protected GraduationPersistence graduationPersistence;

	@Reference
	protected skillsPersistence skillsPersistence;

	@Reference
	protected SpecializationPersistence specializationPersistence;

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