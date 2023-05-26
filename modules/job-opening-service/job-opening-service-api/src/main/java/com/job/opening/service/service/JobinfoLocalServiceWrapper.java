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
 * Provides a wrapper for {@link JobinfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see JobinfoLocalService
 * @generated
 */
public class JobinfoLocalServiceWrapper
	implements JobinfoLocalService, ServiceWrapper<JobinfoLocalService> {

	public JobinfoLocalServiceWrapper(JobinfoLocalService jobinfoLocalService) {
		_jobinfoLocalService = jobinfoLocalService;
	}

	/**
	 * Adds the jobinfo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobinfo the jobinfo
	 * @return the jobinfo that was added
	 */
	@Override
	public com.job.opening.service.model.Jobinfo addJobinfo(
		com.job.opening.service.model.Jobinfo jobinfo) {

		return _jobinfoLocalService.addJobinfo(jobinfo);
	}

	@Override
	public com.job.opening.service.model.Jobinfo createJob(
			long groupId, long companyId, long userId, String userName,
			String postingTitle, String title, String assignedRecruiter,
			String clientName, java.util.Date targetDate,
			String jobopeningStatus, String industry, String jobResource,
			String hiringManager, String positions, java.util.Date dateOpened,
			String jobType, String workExperience, String skillSet,
			String projectStatus, long summaryId, long otherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobinfoLocalService.createJob(
			groupId, companyId, userId, userName, postingTitle, title,
			assignedRecruiter, clientName, targetDate, jobopeningStatus,
			industry, jobResource, hiringManager, positions, dateOpened,
			jobType, workExperience, skillSet, projectStatus, summaryId,
			otherId);
	}

	/**
	 * Creates a new jobinfo with the primary key. Does not add the jobinfo to the database.
	 *
	 * @param jobId the primary key for the new jobinfo
	 * @return the new jobinfo
	 */
	@Override
	public com.job.opening.service.model.Jobinfo createJobinfo(long jobId) {
		return _jobinfoLocalService.createJobinfo(jobId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobinfoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the jobinfo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobinfo the jobinfo
	 * @return the jobinfo that was removed
	 */
	@Override
	public com.job.opening.service.model.Jobinfo deleteJobinfo(
		com.job.opening.service.model.Jobinfo jobinfo) {

		return _jobinfoLocalService.deleteJobinfo(jobinfo);
	}

	/**
	 * Deletes the jobinfo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobId the primary key of the jobinfo
	 * @return the jobinfo that was removed
	 * @throws PortalException if a jobinfo with the primary key could not be found
	 */
	@Override
	public com.job.opening.service.model.Jobinfo deleteJobinfo(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobinfoLocalService.deleteJobinfo(jobId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobinfoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _jobinfoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _jobinfoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _jobinfoLocalService.dynamicQuery();
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

		return _jobinfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.JobinfoModelImpl</code>.
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

		return _jobinfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.JobinfoModelImpl</code>.
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

		return _jobinfoLocalService.dynamicQuery(
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

		return _jobinfoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _jobinfoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.job.opening.service.model.Jobinfo fetchJobinfo(long jobId) {
		return _jobinfoLocalService.fetchJobinfo(jobId);
	}

	/**
	 * Returns the jobinfo matching the UUID and group.
	 *
	 * @param uuid the jobinfo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	@Override
	public com.job.opening.service.model.Jobinfo fetchJobinfoByUuidAndGroupId(
		String uuid, long groupId) {

		return _jobinfoLocalService.fetchJobinfoByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _jobinfoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _jobinfoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the jobinfo with the primary key.
	 *
	 * @param jobId the primary key of the jobinfo
	 * @return the jobinfo
	 * @throws PortalException if a jobinfo with the primary key could not be found
	 */
	@Override
	public com.job.opening.service.model.Jobinfo getJobinfo(long jobId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobinfoLocalService.getJobinfo(jobId);
	}

	/**
	 * Returns the jobinfo matching the UUID and group.
	 *
	 * @param uuid the jobinfo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching jobinfo
	 * @throws PortalException if a matching jobinfo could not be found
	 */
	@Override
	public com.job.opening.service.model.Jobinfo getJobinfoByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobinfoLocalService.getJobinfoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the jobinfos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.JobinfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @return the range of jobinfos
	 */
	@Override
	public java.util.List<com.job.opening.service.model.Jobinfo> getJobinfos(
		int start, int end) {

		return _jobinfoLocalService.getJobinfos(start, end);
	}

	/**
	 * Returns all the jobinfos matching the UUID and company.
	 *
	 * @param uuid the UUID of the jobinfos
	 * @param companyId the primary key of the company
	 * @return the matching jobinfos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.job.opening.service.model.Jobinfo>
		getJobinfosByUuidAndCompanyId(String uuid, long companyId) {

		return _jobinfoLocalService.getJobinfosByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of jobinfos matching the UUID and company.
	 *
	 * @param uuid the UUID of the jobinfos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of jobinfos
	 * @param end the upper bound of the range of jobinfos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching jobinfos, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.job.opening.service.model.Jobinfo>
		getJobinfosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.job.opening.service.model.Jobinfo> orderByComparator) {

		return _jobinfoLocalService.getJobinfosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of jobinfos.
	 *
	 * @return the number of jobinfos
	 */
	@Override
	public int getJobinfosCount() {
		return _jobinfoLocalService.getJobinfosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _jobinfoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobinfoLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.job.opening.service.model.Jobinfo updateJob(
			long groupId, long companyId, long userId, String userName,
			long jobId, String postingTitle, String title,
			String assignedRecruiter, String clientName,
			java.util.Date targetDate, String jobopeningStatus, String industry,
			String jobResource, String hiringManager, String positions,
			java.util.Date dateOpened, String jobType, String workExperience,
			String skillSet, String projectStatus, long summaryId, long otherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _jobinfoLocalService.updateJob(
			groupId, companyId, userId, userName, jobId, postingTitle, title,
			assignedRecruiter, clientName, targetDate, jobopeningStatus,
			industry, jobResource, hiringManager, positions, dateOpened,
			jobType, workExperience, skillSet, projectStatus, summaryId,
			otherId);
	}

	/**
	 * Updates the jobinfo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect JobinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param jobinfo the jobinfo
	 * @return the jobinfo that was updated
	 */
	@Override
	public com.job.opening.service.model.Jobinfo updateJobinfo(
		com.job.opening.service.model.Jobinfo jobinfo) {

		return _jobinfoLocalService.updateJobinfo(jobinfo);
	}

	@Override
	public JobinfoLocalService getWrappedService() {
		return _jobinfoLocalService;
	}

	@Override
	public void setWrappedService(JobinfoLocalService jobinfoLocalService) {
		_jobinfoLocalService = jobinfoLocalService;
	}

	private JobinfoLocalService _jobinfoLocalService;

}