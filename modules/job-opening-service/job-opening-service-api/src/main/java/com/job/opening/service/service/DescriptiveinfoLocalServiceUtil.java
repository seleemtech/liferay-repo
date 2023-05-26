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

import com.job.opening.service.model.Descriptiveinfo;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Descriptiveinfo. This utility wraps
 * <code>com.job.opening.service.service.impl.DescriptiveinfoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DescriptiveinfoLocalService
 * @generated
 */
public class DescriptiveinfoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.job.opening.service.service.impl.DescriptiveinfoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Descriptiveinfo addDescriptiveinfo(
		Descriptiveinfo descriptiveinfo) {

		return getService().addDescriptiveinfo(descriptiveinfo);
	}

	public static Descriptiveinfo createDescription(
			String jobDescription, String requirements, String benefits,
			long jobId)
		throws PortalException {

		return getService().createDescription(
			jobDescription, requirements, benefits, jobId);
	}

	/**
	 * Creates a new descriptiveinfo with the primary key. Does not add the descriptiveinfo to the database.
	 *
	 * @param descriptiveId the primary key for the new descriptiveinfo
	 * @return the new descriptiveinfo
	 */
	public static Descriptiveinfo createDescriptiveinfo(long descriptiveId) {
		return getService().createDescriptiveinfo(descriptiveId);
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
	 * Deletes the descriptiveinfo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DescriptiveinfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param descriptiveinfo the descriptiveinfo
	 * @return the descriptiveinfo that was removed
	 */
	public static Descriptiveinfo deleteDescriptiveinfo(
		Descriptiveinfo descriptiveinfo) {

		return getService().deleteDescriptiveinfo(descriptiveinfo);
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
	public static Descriptiveinfo deleteDescriptiveinfo(long descriptiveId)
		throws PortalException {

		return getService().deleteDescriptiveinfo(descriptiveId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.DescriptiveinfoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.job.opening.service.model.impl.DescriptiveinfoModelImpl</code>.
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

	public static Descriptiveinfo fetchDescriptiveinfo(long descriptiveId) {
		return getService().fetchDescriptiveinfo(descriptiveId);
	}

	public static Descriptiveinfo findByjobId(long jobId) {
		return getService().findByjobId(jobId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the descriptiveinfo with the primary key.
	 *
	 * @param descriptiveId the primary key of the descriptiveinfo
	 * @return the descriptiveinfo
	 * @throws PortalException if a descriptiveinfo with the primary key could not be found
	 */
	public static Descriptiveinfo getDescriptiveinfo(long descriptiveId)
		throws PortalException {

		return getService().getDescriptiveinfo(descriptiveId);
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
	public static List<Descriptiveinfo> getDescriptiveinfos(
		int start, int end) {

		return getService().getDescriptiveinfos(start, end);
	}

	/**
	 * Returns the number of descriptiveinfos.
	 *
	 * @return the number of descriptiveinfos
	 */
	public static int getDescriptiveinfosCount() {
		return getService().getDescriptiveinfosCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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

	public static Descriptiveinfo updateDescription(
			String jobDescription, String requirements, String benefits,
			long jobId)
		throws PortalException {

		return getService().updateDescription(
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
	public static Descriptiveinfo updateDescriptiveinfo(
		Descriptiveinfo descriptiveinfo) {

		return getService().updateDescriptiveinfo(descriptiveinfo);
	}

	public static DescriptiveinfoLocalService getService() {
		return _service;
	}

	private static volatile DescriptiveinfoLocalService _service;

}