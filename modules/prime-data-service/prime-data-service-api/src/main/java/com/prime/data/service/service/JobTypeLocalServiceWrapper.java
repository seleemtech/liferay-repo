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
 * Provides a wrapper for {@link JobTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobTypeLocalService
 * @generated
 */
public class JobTypeLocalServiceWrapper
	implements JobTypeLocalService, ServiceWrapper<JobTypeLocalService> {

	public JobTypeLocalServiceWrapper(JobTypeLocalService jobTypeLocalService) {
		_jobTypeLocalService = jobTypeLocalService;
	}

	/**
	 * Adds the job type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobType the job type
	 * @return the job type that was added
	 */
	@Override
	public com.prime.data.service.model.JobType addJobType(
		com.prime.data.service.model.JobType jobType) {

		return _jobTypeLocalService.addJobType(jobType);
	}

	@Override
	public void addJobType(String jobType) {
		_jobTypeLocalService.addJobType(jobType);
	}

	/**
	 * Creates a new job type with the primary key. Does not add the job type to the database.
	 *
	 * @param jobTypeId the primary key for the new job type
	 * @return the new job type
	 */
	@Override
	public com.prime.data.service.model.JobType createJobType(long jobTypeId) {
		return _jobTypeLocalService.createJobType(jobTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the job type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobType the job type
	 * @return the job type that was removed
	 */
	@Override
	public com.prime.data.service.model.JobType deleteJobType(
		com.prime.data.service.model.JobType jobType) {

		return _jobTypeLocalService.deleteJobType(jobType);
	}

	/**
	 * Deletes the job type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type that was removed
	 * @throws PortalException if a job type with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.JobType deleteJobType(long jobTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobTypeLocalService.deleteJobType(jobTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _jobTypeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _jobTypeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobTypeLocalService.dynamicQuery();
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

		return _jobTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.JobTypeModelImpl</code>.
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

		return _jobTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.JobTypeModelImpl</code>.
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

		return _jobTypeLocalService.dynamicQuery(
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

		return _jobTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _jobTypeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.JobType fetchJobType(long jobTypeId) {
		return _jobTypeLocalService.fetchJobType(jobTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _jobTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _jobTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the job type with the primary key.
	 *
	 * @param jobTypeId the primary key of the job type
	 * @return the job type
	 * @throws PortalException if a job type with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.JobType getJobType(long jobTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobTypeLocalService.getJobType(jobTypeId);
	}

	/**
	 * Returns a range of all the job types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.JobTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of job types
	 * @param end the upper bound of the range of job types (not inclusive)
	 * @return the range of job types
	 */
	@Override
	public java.util.List<com.prime.data.service.model.JobType> getJobTypes(
		int start, int end) {

		return _jobTypeLocalService.getJobTypes(start, end);
	}

	/**
	 * Returns the number of job types.
	 *
	 * @return the number of job types
	 */
	@Override
	public int getJobTypesCount() {
		return _jobTypeLocalService.getJobTypesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the job type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobType the job type
	 * @return the job type that was updated
	 */
	@Override
	public com.prime.data.service.model.JobType updateJobType(
		com.prime.data.service.model.JobType jobType) {

		return _jobTypeLocalService.updateJobType(jobType);
	}

	@Override
	public JobTypeLocalService getWrappedService() {
		return _jobTypeLocalService;
	}

	@Override
	public void setWrappedService(JobTypeLocalService jobTypeLocalService) {
		_jobTypeLocalService = jobTypeLocalService;
	}

	private JobTypeLocalService _jobTypeLocalService;

}