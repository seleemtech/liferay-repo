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

package com.job.opening.service.service.base;

import com.job.opening.service.model.Addressinfo;
import com.job.opening.service.service.AddressinfoLocalService;
import com.job.opening.service.service.AddressinfoLocalServiceUtil;
import com.job.opening.service.service.persistence.AddressinfoPersistence;
import com.job.opening.service.service.persistence.DescriptiveinfoPersistence;
import com.job.opening.service.service.persistence.JobinfoPersistence;

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
 * Provides the base implementation for the addressinfo local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.job.opening.service.service.impl.AddressinfoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.job.opening.service.service.impl.AddressinfoLocalServiceImpl
 * @generated
 */
public abstract class AddressinfoLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AddressinfoLocalService, AopService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AddressinfoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AddressinfoLocalServiceUtil</code>.
	 */

	/**
	 * Adds the addressinfo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressinfo the addressinfo
	 * @return the addressinfo that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Addressinfo addAddressinfo(Addressinfo addressinfo) {
		addressinfo.setNew(true);

		return addressinfoPersistence.update(addressinfo);
	}

	/**
	 * Creates a new addressinfo with the primary key. Does not add the addressinfo to the database.
	 *
	 * @param addressId the primary key for the new addressinfo
	 * @return the new addressinfo
	 */
	@Override
	@Transactional(enabled = false)
	public Addressinfo createAddressinfo(long addressId) {
		return addressinfoPersistence.create(addressId);
	}

	/**
	 * Deletes the addressinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo that was removed
	 * @throws PortalException if a addressinfo with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Addressinfo deleteAddressinfo(long addressId)
		throws PortalException {

		return addressinfoPersistence.remove(addressId);
	}

	/**
	 * Deletes the addressinfo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressinfo the addressinfo
	 * @return the addressinfo that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Addressinfo deleteAddressinfo(Addressinfo addressinfo) {
		return addressinfoPersistence.remove(addressinfo);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return addressinfoPersistence.dslQuery(dslQuery);
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
			Addressinfo.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return addressinfoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.AddressinfoModelImpl</code>.
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

		return addressinfoPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.AddressinfoModelImpl</code>.
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

		return addressinfoPersistence.findWithDynamicQuery(
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
		return addressinfoPersistence.countWithDynamicQuery(dynamicQuery);
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

		return addressinfoPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Addressinfo fetchAddressinfo(long addressId) {
		return addressinfoPersistence.fetchByPrimaryKey(addressId);
	}

	/**
	 * Returns the addressinfo with the primary key.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo
	 * @throws PortalException if a addressinfo with the primary key could not be found
	 */
	@Override
	public Addressinfo getAddressinfo(long addressId) throws PortalException {
		return addressinfoPersistence.findByPrimaryKey(addressId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(addressinfoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Addressinfo.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("addressId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			addressinfoLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Addressinfo.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("addressId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(addressinfoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Addressinfo.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("addressId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return addressinfoPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return addressinfoLocalService.deleteAddressinfo(
			(Addressinfo)persistedModel);
	}

	@Override
	public BasePersistence<Addressinfo> getBasePersistence() {
		return addressinfoPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return addressinfoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the addressinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.AddressinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of addressinfos
	 * @param end the upper bound of the range of addressinfos (not inclusive)
	 * @return the range of addressinfos
	 */
	@Override
	public List<Addressinfo> getAddressinfos(int start, int end) {
		return addressinfoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of addressinfos.
	 *
	 * @return the number of addressinfos
	 */
	@Override
	public int getAddressinfosCount() {
		return addressinfoPersistence.countAll();
	}

	/**
	 * Updates the addressinfo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AddressinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addressinfo the addressinfo
	 * @return the addressinfo that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Addressinfo updateAddressinfo(Addressinfo addressinfo) {
		return addressinfoPersistence.update(addressinfo);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			AddressinfoLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		addressinfoLocalService = (AddressinfoLocalService)aopProxy;

		_setLocalServiceUtilService(addressinfoLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AddressinfoLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Addressinfo.class;
	}

	protected String getModelClassName() {
		return Addressinfo.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = addressinfoPersistence.getDataSource();

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
		AddressinfoLocalService addressinfoLocalService) {

		try {
			Field field = AddressinfoLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, addressinfoLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected AddressinfoLocalService addressinfoLocalService;

	@Reference
	protected AddressinfoPersistence addressinfoPersistence;

	@Reference
	protected DescriptiveinfoPersistence descriptiveinfoPersistence;

	@Reference
	protected JobinfoPersistence jobinfoPersistence;

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