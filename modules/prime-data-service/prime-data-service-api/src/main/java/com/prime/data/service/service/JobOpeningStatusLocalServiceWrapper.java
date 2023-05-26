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

package com.prime.data.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JobOpeningStatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobOpeningStatusLocalService
 * @generated
 */
public class JobOpeningStatusLocalServiceWrapper
	implements JobOpeningStatusLocalService,
			   ServiceWrapper<JobOpeningStatusLocalService> {

	public JobOpeningStatusLocalServiceWrapper(
		JobOpeningStatusLocalService jobOpeningStatusLocalService) {

		_jobOpeningStatusLocalService = jobOpeningStatusLocalService;
	}

	/**
	 * Adds the job opening status to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobOpeningStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobOpeningStatus the job opening status
	 * @return the job opening status that was added
	 */
	@Override
	public com.prime.data.service.model.JobOpeningStatus addJobOpeningStatus(
		com.prime.data.service.model.JobOpeningStatus jobOpeningStatus) {

		return _jobOpeningStatusLocalService.addJobOpeningStatus(
			jobOpeningStatus);
	}

	@Override
	public void addJobOpeningStatus(String jobOpeningStatus) {
		_jobOpeningStatusLocalService.addJobOpeningStatus(jobOpeningStatus);
	}

	/**
	 * Creates a new job opening status with the primary key. Does not add the job opening status to the database.
	 *
	 * @param jobStatusId the primary key for the new job opening status
	 * @return the new job opening status
	 */
	@Override
	public com.prime.data.service.model.JobOpeningStatus createJobOpeningStatus(
		long jobStatusId) {

		return _jobOpeningStatusLocalService.createJobOpeningStatus(
			jobStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobOpeningStatusLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the job opening status from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobOpeningStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobOpeningStatus the job opening status
	 * @return the job opening status that was removed
	 */
	@Override
	public com.prime.data.service.model.JobOpeningStatus deleteJobOpeningStatus(
		com.prime.data.service.model.JobOpeningStatus jobOpeningStatus) {

		return _jobOpeningStatusLocalService.deleteJobOpeningStatus(
			jobOpeningStatus);
	}

	/**
	 * Deletes the job opening status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobOpeningStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status that was removed
	 * @throws PortalException if a job opening status with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.JobOpeningStatus deleteJobOpeningStatus(
			long jobStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobOpeningStatusLocalService.deleteJobOpeningStatus(
			jobStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobOpeningStatusLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _jobOpeningStatusLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _jobOpeningStatusLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobOpeningStatusLocalService.dynamicQuery();
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

		return _jobOpeningStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.JobOpeningStatusModelImpl</code>.
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

		return _jobOpeningStatusLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.JobOpeningStatusModelImpl</code>.
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

		return _jobOpeningStatusLocalService.dynamicQuery(
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

		return _jobOpeningStatusLocalService.dynamicQueryCount(dynamicQuery);
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

		return _jobOpeningStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.JobOpeningStatus fetchJobOpeningStatus(
		long jobStatusId) {

		return _jobOpeningStatusLocalService.fetchJobOpeningStatus(jobStatusId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _jobOpeningStatusLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _jobOpeningStatusLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the job opening status with the primary key.
	 *
	 * @param jobStatusId the primary key of the job opening status
	 * @return the job opening status
	 * @throws PortalException if a job opening status with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.JobOpeningStatus getJobOpeningStatus(
			long jobStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobOpeningStatusLocalService.getJobOpeningStatus(jobStatusId);
	}

	/**
	 * Returns a range of all the job opening statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.JobOpeningStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job opening statuses
	 * @param end the upper bound of the range of job opening statuses (not inclusive)
	 * @return the range of job opening statuses
	 */
	@Override
	public java.util.List<com.prime.data.service.model.JobOpeningStatus>
		getJobOpeningStatuses(int start, int end) {

		return _jobOpeningStatusLocalService.getJobOpeningStatuses(start, end);
	}

	/**
	 * Returns the number of job opening statuses.
	 *
	 * @return the number of job opening statuses
	 */
	@Override
	public int getJobOpeningStatusesCount() {
		return _jobOpeningStatusLocalService.getJobOpeningStatusesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobOpeningStatusLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobOpeningStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the job opening status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobOpeningStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobOpeningStatus the job opening status
	 * @return the job opening status that was updated
	 */
	@Override
	public com.prime.data.service.model.JobOpeningStatus updateJobOpeningStatus(
		com.prime.data.service.model.JobOpeningStatus jobOpeningStatus) {

		return _jobOpeningStatusLocalService.updateJobOpeningStatus(
			jobOpeningStatus);
	}

	@Override
	public JobOpeningStatusLocalService getWrappedService() {
		return _jobOpeningStatusLocalService;
	}

	@Override
	public void setWrappedService(
		JobOpeningStatusLocalService jobOpeningStatusLocalService) {

		_jobOpeningStatusLocalService = jobOpeningStatusLocalService;
	}

	private JobOpeningStatusLocalService _jobOpeningStatusLocalService;

}