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
 * Provides a wrapper for {@link DescriptiveinfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DescriptiveinfoLocalService
 * @generated
 */
public class DescriptiveinfoLocalServiceWrapper
	implements DescriptiveinfoLocalService,
			   ServiceWrapper<DescriptiveinfoLocalService> {

	public DescriptiveinfoLocalServiceWrapper(
		DescriptiveinfoLocalService descriptiveinfoLocalService) {

		_descriptiveinfoLocalService = descriptiveinfoLocalService;
	}

	/**
	 * Adds the descriptiveinfo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DescriptiveinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param descriptiveinfo the descriptiveinfo
	 * @return the descriptiveinfo that was added
	 */
	@Override
	public com.job.opening.service.model.Descriptiveinfo addDescriptiveinfo(
		com.job.opening.service.model.Descriptiveinfo descriptiveinfo) {

		return _descriptiveinfoLocalService.addDescriptiveinfo(descriptiveinfo);
	}

	@Override
	public com.job.opening.service.model.Descriptiveinfo createDescription(
			String jobDescription, String requirements, String benefits,
			long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descriptiveinfoLocalService.createDescription(
			jobDescription, requirements, benefits, jobId);
	}

	/**
	 * Creates a new descriptiveinfo with the primary key. Does not add the descriptiveinfo to the database.
	 *
	 * @param descriptiveId the primary key for the new descriptiveinfo
	 * @return the new descriptiveinfo
	 */
	@Override
	public com.job.opening.service.model.Descriptiveinfo createDescriptiveinfo(
		long descriptiveId) {

		return _descriptiveinfoLocalService.createDescriptiveinfo(
			descriptiveId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descriptiveinfoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the descriptiveinfo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DescriptiveinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param descriptiveinfo the descriptiveinfo
	 * @return the descriptiveinfo that was removed
	 */
	@Override
	public com.job.opening.service.model.Descriptiveinfo deleteDescriptiveinfo(
		com.job.opening.service.model.Descriptiveinfo descriptiveinfo) {

		return _descriptiveinfoLocalService.deleteDescriptiveinfo(
			descriptiveinfo);
	}

	/**
	 * Deletes the descriptiveinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DescriptiveinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo that was removed
	 * @throws PortalException if a descriptiveinfo with the primary key could not be found
	 */
	@Override
	public com.job.opening.service.model.Descriptiveinfo deleteDescriptiveinfo(
			long descriptiveId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descriptiveinfoLocalService.deleteDescriptiveinfo(
			descriptiveId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descriptiveinfoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _descriptiveinfoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _descriptiveinfoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _descriptiveinfoLocalService.dynamicQuery();
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

		return _descriptiveinfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.DescriptiveinfoModelImpl</code>.
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

		return _descriptiveinfoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.DescriptiveinfoModelImpl</code>.
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

		return _descriptiveinfoLocalService.dynamicQuery(
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

		return _descriptiveinfoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _descriptiveinfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.job.opening.service.model.Descriptiveinfo fetchDescriptiveinfo(
		long descriptiveId) {

		return _descriptiveinfoLocalService.fetchDescriptiveinfo(descriptiveId);
	}

	@Override
	public com.job.opening.service.model.Descriptiveinfo findByjobId(
		long jobId) {

		return _descriptiveinfoLocalService.findByjobId(jobId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _descriptiveinfoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the descriptiveinfo with the primary key.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo
	 * @throws PortalException if a descriptiveinfo with the primary key could not be found
	 */
	@Override
	public com.job.opening.service.model.Descriptiveinfo getDescriptiveinfo(
			long descriptiveId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descriptiveinfoLocalService.getDescriptiveinfo(descriptiveId);
	}

	/**
	 * Returns a range of all the descriptiveinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.DescriptiveinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of descriptiveinfos
	 * @param end the upper bound of the range of descriptiveinfos (not inclusive)
	 * @return the range of descriptiveinfos
	 */
	@Override
	public java.util.List<com.job.opening.service.model.Descriptiveinfo>
		getDescriptiveinfos(int start, int end) {

		return _descriptiveinfoLocalService.getDescriptiveinfos(start, end);
	}

	/**
	 * Returns the number of descriptiveinfos.
	 *
	 * @return the number of descriptiveinfos
	 */
	@Override
	public int getDescriptiveinfosCount() {
		return _descriptiveinfoLocalService.getDescriptiveinfosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _descriptiveinfoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _descriptiveinfoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descriptiveinfoLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.job.opening.service.model.Descriptiveinfo updateDescription(
			String jobDescription, String requirements, String benefits,
			long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _descriptiveinfoLocalService.updateDescription(
			jobDescription, requirements, benefits, jobId);
	}

	/**
	 * Updates the descriptiveinfo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DescriptiveinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param descriptiveinfo the descriptiveinfo
	 * @return the descriptiveinfo that was updated
	 */
	@Override
	public com.job.opening.service.model.Descriptiveinfo updateDescriptiveinfo(
		com.job.opening.service.model.Descriptiveinfo descriptiveinfo) {

		return _descriptiveinfoLocalService.updateDescriptiveinfo(
			descriptiveinfo);
	}

	@Override
	public DescriptiveinfoLocalService getWrappedService() {
		return _descriptiveinfoLocalService;
	}

	@Override
	public void setWrappedService(
		DescriptiveinfoLocalService descriptiveinfoLocalService) {

		_descriptiveinfoLocalService = descriptiveinfoLocalService;
	}

	private DescriptiveinfoLocalService _descriptiveinfoLocalService;

}