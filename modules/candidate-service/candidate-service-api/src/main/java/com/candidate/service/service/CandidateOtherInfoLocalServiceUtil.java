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

package com.candidate.service.service;

import com.candidate.service.model.CandidateOtherInfo;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CandidateOtherInfo. This utility wraps
 * <code>com.candidate.service.service.impl.CandidateOtherInfoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateOtherInfoLocalService
 * @generated
 */
public class CandidateOtherInfoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.candidate.service.service.impl.CandidateOtherInfoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the candidate other info to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateOtherInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateOtherInfo the candidate other info
	 * @return the candidate other info that was added
	 */
	public static CandidateOtherInfo addCandidateOtherInfo(
		CandidateOtherInfo candidateOtherInfo) {

		return getService().addCandidateOtherInfo(candidateOtherInfo);
	}

	public static CandidateOtherInfo addOrUpdateCandidateOtherInfo(
		long candidateOtherInfoId, long candidateId, String candidateStatus,
		String candidateStage, String source, String candidateOwner,
		String institute, String department, String degree, String FromDuration,
		String Toduration, String occupation, String company, String summary,
		String FromWorkDuration, String ToWorkDuration, long folderId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addOrUpdateCandidateOtherInfo(
			candidateOtherInfoId, candidateId, candidateStatus, candidateStage,
			source, candidateOwner, institute, department, degree, FromDuration,
			Toduration, occupation, company, summary, FromWorkDuration,
			ToWorkDuration, folderId, serviceContext);
	}

	/**
	 * Creates a new candidate other info with the primary key. Does not add the candidate other info to the database.
	 *
	 * @param candidateOtherInfoId the primary key for the new candidate other info
	 * @return the new candidate other info
	 */
	public static CandidateOtherInfo createCandidateOtherInfo(
		long candidateOtherInfoId) {

		return getService().createCandidateOtherInfo(candidateOtherInfoId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static CandidateOtherInfo deleCandidateOtherInfo(
			long candidateOtherInfoId)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return getService().deleCandidateOtherInfo(candidateOtherInfoId);
	}

	/**
	 * Deletes the candidate other info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateOtherInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateOtherInfo the candidate other info
	 * @return the candidate other info that was removed
	 */
	public static CandidateOtherInfo deleteCandidateOtherInfo(
		CandidateOtherInfo candidateOtherInfo) {

		return getService().deleteCandidateOtherInfo(candidateOtherInfo);
	}

	/**
	 * Deletes the candidate other info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateOtherInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info that was removed
	 * @throws PortalException if a candidate other info with the primary key could not be found
	 */
	public static CandidateOtherInfo deleteCandidateOtherInfo(
			long candidateOtherInfoId)
		throws PortalException {

		return getService().deleteCandidateOtherInfo(candidateOtherInfoId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.CandidateOtherInfoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.CandidateOtherInfoModelImpl</code>.
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

	public static CandidateOtherInfo fetchCandidateOtherInfo(
		long candidateOtherInfoId) {

		return getService().fetchCandidateOtherInfo(candidateOtherInfoId);
	}

	/**
	 * Returns the candidate other info with the matching UUID and company.
	 *
	 * @param uuid the candidate other info's UUID
	 * @param companyId the primary key of the company
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo fetchCandidateOtherInfoByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchCandidateOtherInfoByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static CandidateOtherInfo getByCandidtatesId(long candidateId) {
		return getService().getByCandidtatesId(candidateId);
	}

	/**
	 * Returns the candidate other info with the primary key.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info
	 * @throws PortalException if a candidate other info with the primary key could not be found
	 */
	public static CandidateOtherInfo getCandidateOtherInfo(
			long candidateOtherInfoId)
		throws PortalException {

		return getService().getCandidateOtherInfo(candidateOtherInfoId);
	}

	/**
	 * Returns the candidate other info with the matching UUID and company.
	 *
	 * @param uuid the candidate other info's UUID
	 * @param companyId the primary key of the company
	 * @return the matching candidate other info
	 * @throws PortalException if a matching candidate other info could not be found
	 */
	public static CandidateOtherInfo getCandidateOtherInfoByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getCandidateOtherInfoByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the candidate other infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.CandidateOtherInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate other infos
	 * @param end the upper bound of the range of candidate other infos (not inclusive)
	 * @return the range of candidate other infos
	 */
	public static List<CandidateOtherInfo> getCandidateOtherInfos(
		int start, int end) {

		return getService().getCandidateOtherInfos(start, end);
	}

	/**
	 * Returns the number of candidate other infos.
	 *
	 * @return the number of candidate other infos
	 */
	public static int getCandidateOtherInfosCount() {
		return getService().getCandidateOtherInfosCount();
	}

	public static int getCandidateStatusCount(String candidateStatus) {
		return getService().getCandidateStatusCount(candidateStatus);
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

	/**
	 * Updates the candidate other info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateOtherInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateOtherInfo the candidate other info
	 * @return the candidate other info that was updated
	 */
	public static CandidateOtherInfo updateCandidateOtherInfo(
		CandidateOtherInfo candidateOtherInfo) {

		return getService().updateCandidateOtherInfo(candidateOtherInfo);
	}

	public static CandidateOtherInfo updateCandidateStage(
		long candidateId, String candidateStage) {

		return getService().updateCandidateStage(candidateId, candidateStage);
	}

	public static CandidateOtherInfo updateCandidateStatus(
		long candidateId, String candidateStatus) {

		return getService().updateCandidateStatus(candidateId, candidateStatus);
	}

	public static CandidateOtherInfoLocalService getService() {
		return _service;
	}

	private static volatile CandidateOtherInfoLocalService _service;

}