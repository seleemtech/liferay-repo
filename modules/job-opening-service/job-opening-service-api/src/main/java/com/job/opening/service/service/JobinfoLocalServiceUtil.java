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

import com.job.opening.service.model.Jobinfo;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Jobinfo. This utility wraps
 * <code>com.job.opening.service.service.impl.JobinfoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see JobinfoLocalService
 * @generated
 */
public class JobinfoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.job.opening.service.service.impl.JobinfoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Jobinfo addJobinfo(Jobinfo jobinfo) {
		return getService().addJobinfo(jobinfo);
	}

	public static Jobinfo createJob(
			long groupId, long companyId, long userId, String userName,
			String postingTitle, String title, String assignedRecruiter,
			String clientName, java.util.Date targetDate,
			String jobopeningStatus, String industry, String jobResource,
			String hiringManager, String positions, java.util.Date dateOpened,
			String jobType, String workExperience, String skillSet,
			String projectStatus, long summaryId, long otherId)
		throws PortalException {

		return getService().createJob(
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
	public static Jobinfo createJobinfo(long jobId) {
		return getService().createJobinfo(jobId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static Jobinfo deleteJobinfo(Jobinfo jobinfo) {
		return getService().deleteJobinfo(jobinfo);
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
	public static Jobinfo deleteJobinfo(long jobId) throws PortalException {
		return getService().deleteJobinfo(jobId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Jobinfo fetchJobinfo(long jobId) {
		return getService().fetchJobinfo(jobId);
	}

	/**
	 * Returns the jobinfo matching the UUID and group.
	 *
	 * @param uuid the jobinfo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching jobinfo, or <code>null</code> if a matching jobinfo could not be found
	 */
	public static Jobinfo fetchJobinfoByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchJobinfoByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the jobinfo with the primary key.
	 *
	 * @param jobId the primary key of the jobinfo
	 * @return the jobinfo
	 * @throws PortalException if a jobinfo with the primary key could not be found
	 */
	public static Jobinfo getJobinfo(long jobId) throws PortalException {
		return getService().getJobinfo(jobId);
	}

	/**
	 * Returns the jobinfo matching the UUID and group.
	 *
	 * @param uuid the jobinfo's UUID
	 * @param groupId the primary key of the group
	 * @return the matching jobinfo
	 * @throws PortalException if a matching jobinfo could not be found
	 */
	public static Jobinfo getJobinfoByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getJobinfoByUuidAndGroupId(uuid, groupId);
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
	public static List<Jobinfo> getJobinfos(int start, int end) {
		return getService().getJobinfos(start, end);
	}

	/**
	 * Returns all the jobinfos matching the UUID and company.
	 *
	 * @param uuid the UUID of the jobinfos
	 * @param companyId the primary key of the company
	 * @return the matching jobinfos, or an empty list if no matches were found
	 */
	public static List<Jobinfo> getJobinfosByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getJobinfosByUuidAndCompanyId(uuid, companyId);
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
	public static List<Jobinfo> getJobinfosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Jobinfo> orderByComparator) {

		return getService().getJobinfosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of jobinfos.
	 *
	 * @return the number of jobinfos
	 */
	public static int getJobinfosCount() {
		return getService().getJobinfosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static Jobinfo updateJob(
			long groupId, long companyId, long userId, String userName,
			long jobId, String postingTitle, String title,
			String assignedRecruiter, String clientName,
			java.util.Date targetDate, String jobopeningStatus, String industry,
			String jobResource, String hiringManager, String positions,
			java.util.Date dateOpened, String jobType, String workExperience,
			String skillSet, String projectStatus, long summaryId, long otherId)
		throws PortalException {

		return getService().updateJob(
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
	public static Jobinfo updateJobinfo(Jobinfo jobinfo) {
		return getService().updateJobinfo(jobinfo);
	}

	public static JobinfoLocalService getService() {
		return _service;
	}

	private static volatile JobinfoLocalService _service;

}