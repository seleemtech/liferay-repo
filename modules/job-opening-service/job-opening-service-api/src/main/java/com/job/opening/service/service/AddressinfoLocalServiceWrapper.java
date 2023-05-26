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

package com.job.opening.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AddressinfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AddressinfoLocalService
 * @generated
 */
public class AddressinfoLocalServiceWrapper
	implements AddressinfoLocalService,
			   ServiceWrapper<AddressinfoLocalService> {

	public AddressinfoLocalServiceWrapper(
		AddressinfoLocalService addressinfoLocalService) {

		_addressinfoLocalService = addressinfoLocalService;
	}

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
	@Override
	public com.job.opening.service.model.Addressinfo addAddressinfo(
		com.job.opening.service.model.Addressinfo addressinfo) {

		return _addressinfoLocalService.addAddressinfo(addressinfo);
	}

	@Override
	public com.job.opening.service.model.Addressinfo createAddress(
			String city, String country, String state, long postalCode,
			long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressinfoLocalService.createAddress(
			city, country, state, postalCode, jobId);
	}

	/**
	 * Creates a new addressinfo with the primary key. Does not add the addressinfo to the database.
	 *
	 * @param addressId the primary key for the new addressinfo
	 * @return the new addressinfo
	 */
	@Override
	public com.job.opening.service.model.Addressinfo createAddressinfo(
		long addressId) {

		return _addressinfoLocalService.createAddressinfo(addressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressinfoLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.job.opening.service.model.Addressinfo deleteAddressinfo(
		com.job.opening.service.model.Addressinfo addressinfo) {

		return _addressinfoLocalService.deleteAddressinfo(addressinfo);
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
	@Override
	public com.job.opening.service.model.Addressinfo deleteAddressinfo(
			long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressinfoLocalService.deleteAddressinfo(addressId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressinfoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _addressinfoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _addressinfoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _addressinfoLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _addressinfoLocalService.dynamicQuery(dynamicQuery);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _addressinfoLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _addressinfoLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _addressinfoLocalService.dynamicQueryCount(dynamicQuery);
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _addressinfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.job.opening.service.model.Addressinfo fetchAddressinfo(
		long addressId) {

		return _addressinfoLocalService.fetchAddressinfo(addressId);
	}

	@Override
	public com.job.opening.service.model.Addressinfo findByjobId(long jobId) {
		return _addressinfoLocalService.findByjobId(jobId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _addressinfoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the addressinfo with the primary key.
	 *
	 * @param addressId the primary key of the addressinfo
	 * @return the addressinfo
	 * @throws PortalException if a addressinfo with the primary key could not be found
	 */
	@Override
	public com.job.opening.service.model.Addressinfo getAddressinfo(
			long addressId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressinfoLocalService.getAddressinfo(addressId);
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
	public java.util.List<com.job.opening.service.model.Addressinfo>
		getAddressinfos(int start, int end) {

		return _addressinfoLocalService.getAddressinfos(start, end);
	}

	/**
	 * Returns the number of addressinfos.
	 *
	 * @return the number of addressinfos
	 */
	@Override
	public int getAddressinfosCount() {
		return _addressinfoLocalService.getAddressinfosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _addressinfoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _addressinfoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressinfoLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.job.opening.service.model.Addressinfo updateAddress(
			String city, String country, String state, long postalCode,
			long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _addressinfoLocalService.updateAddress(
			city, country, state, postalCode, jobId);
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
	@Override
	public com.job.opening.service.model.Addressinfo updateAddressinfo(
		com.job.opening.service.model.Addressinfo addressinfo) {

		return _addressinfoLocalService.updateAddressinfo(addressinfo);
	}

	@Override
	public AddressinfoLocalService getWrappedService() {
		return _addressinfoLocalService;
	}

	@Override
	public void setWrappedService(
		AddressinfoLocalService addressinfoLocalService) {

		_addressinfoLocalService = addressinfoLocalService;
	}

	private AddressinfoLocalService _addressinfoLocalService;

}