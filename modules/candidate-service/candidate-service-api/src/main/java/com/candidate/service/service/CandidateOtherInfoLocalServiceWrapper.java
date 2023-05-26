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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CandidateOtherInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateOtherInfoLocalService
 * @generated
 */
public class CandidateOtherInfoLocalServiceWrapper
	implements CandidateOtherInfoLocalService,
			   ServiceWrapper<CandidateOtherInfoLocalService> {

	public CandidateOtherInfoLocalServiceWrapper(
		CandidateOtherInfoLocalService candidateOtherInfoLocalService) {

		_candidateOtherInfoLocalService = candidateOtherInfoLocalService;
	}

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
	@Override
	public com.candidate.service.model.CandidateOtherInfo addCandidateOtherInfo(
		com.candidate.service.model.CandidateOtherInfo candidateOtherInfo) {

		return _candidateOtherInfoLocalService.addCandidateOtherInfo(
			candidateOtherInfo);
	}

	@Override
	public com.candidate.service.model.CandidateOtherInfo
		addOrUpdateCandidateOtherInfo(
			long candidateOtherInfoId, long candidateId, String candidateStatus,
			String candidateStage, String source, String candidateOwner,
			String institute, String department, String degree,
			String FromDuration, String Toduration, String occupation,
			String company, String summary, String FromWorkDuration,
			String ToWorkDuration, long folderId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _candidateOtherInfoLocalService.addOrUpdateCandidateOtherInfo(
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
	@Override
	public com.candidate.service.model.CandidateOtherInfo
		createCandidateOtherInfo(long candidateOtherInfoId) {

		return _candidateOtherInfoLocalService.createCandidateOtherInfo(
			candidateOtherInfoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateOtherInfoLocalService.createPersistedModel(
			primaryKeyObj);
	}

	@Override
	public com.candidate.service.model.CandidateOtherInfo
			deleCandidateOtherInfo(long candidateOtherInfoId)
		throws com.candidate.service.exception.
			NoSuchCandidateOtherInfoException {

		return _candidateOtherInfoLocalService.deleCandidateOtherInfo(
			candidateOtherInfoId);
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
	@Override
	public com.candidate.service.model.CandidateOtherInfo
		deleteCandidateOtherInfo(
			com.candidate.service.model.CandidateOtherInfo candidateOtherInfo) {

		return _candidateOtherInfoLocalService.deleteCandidateOtherInfo(
			candidateOtherInfo);
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
	@Override
	public com.candidate.service.model.CandidateOtherInfo
			deleteCandidateOtherInfo(long candidateOtherInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateOtherInfoLocalService.deleteCandidateOtherInfo(
			candidateOtherInfoId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateOtherInfoLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _candidateOtherInfoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _candidateOtherInfoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateOtherInfoLocalService.dynamicQuery();
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

		return _candidateOtherInfoLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _candidateOtherInfoLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _candidateOtherInfoLocalService.dynamicQuery(
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

		return _candidateOtherInfoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _candidateOtherInfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.candidate.service.model.CandidateOtherInfo
		fetchCandidateOtherInfo(long candidateOtherInfoId) {

		return _candidateOtherInfoLocalService.fetchCandidateOtherInfo(
			candidateOtherInfoId);
	}

	/**
	 * Returns the candidate other info with the matching UUID and company.
	 *
	 * @param uuid the candidate other info's UUID
	 * @param companyId the primary key of the company
	 * @return the matching candidate other info, or <code>null</code> if a matching candidate other info could not be found
	 */
	@Override
	public com.candidate.service.model.CandidateOtherInfo
		fetchCandidateOtherInfoByUuidAndCompanyId(String uuid, long companyId) {

		return _candidateOtherInfoLocalService.
			fetchCandidateOtherInfoByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _candidateOtherInfoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.candidate.service.model.CandidateOtherInfo getByCandidtatesId(
		long candidateId) {

		return _candidateOtherInfoLocalService.getByCandidtatesId(candidateId);
	}

	/**
	 * Returns the candidate other info with the primary key.
	 *
	 * @param candidateOtherInfoId the primary key of the candidate other info
	 * @return the candidate other info
	 * @throws PortalException if a candidate other info with the primary key could not be found
	 */
	@Override
	public com.candidate.service.model.CandidateOtherInfo getCandidateOtherInfo(
			long candidateOtherInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateOtherInfoLocalService.getCandidateOtherInfo(
			candidateOtherInfoId);
	}

	/**
	 * Returns the candidate other info with the matching UUID and company.
	 *
	 * @param uuid the candidate other info's UUID
	 * @param companyId the primary key of the company
	 * @return the matching candidate other info
	 * @throws PortalException if a matching candidate other info could not be found
	 */
	@Override
	public com.candidate.service.model.CandidateOtherInfo
			getCandidateOtherInfoByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateOtherInfoLocalService.
			getCandidateOtherInfoByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.candidate.service.model.CandidateOtherInfo>
		getCandidateOtherInfos(int start, int end) {

		return _candidateOtherInfoLocalService.getCandidateOtherInfos(
			start, end);
	}

	/**
	 * Returns the number of candidate other infos.
	 *
	 * @return the number of candidate other infos
	 */
	@Override
	public int getCandidateOtherInfosCount() {
		return _candidateOtherInfoLocalService.getCandidateOtherInfosCount();
	}

	@Override
	public int getCandidateStatusCount(String candidateStatus) {
		return _candidateOtherInfoLocalService.getCandidateStatusCount(
			candidateStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _candidateOtherInfoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _candidateOtherInfoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateOtherInfoLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.candidate.service.model.CandidateOtherInfo
		updateCandidateOtherInfo(
			com.candidate.service.model.CandidateOtherInfo candidateOtherInfo) {

		return _candidateOtherInfoLocalService.updateCandidateOtherInfo(
			candidateOtherInfo);
	}

	@Override
	public com.candidate.service.model.CandidateOtherInfo updateCandidateStage(
		long candidateId, String candidateStage) {

		return _candidateOtherInfoLocalService.updateCandidateStage(
			candidateId, candidateStage);
	}

	@Override
	public com.candidate.service.model.CandidateOtherInfo updateCandidateStatus(
		long candidateId, String candidateStatus) {

		return _candidateOtherInfoLocalService.updateCandidateStatus(
			candidateId, candidateStatus);
	}

	@Override
	public CandidateOtherInfoLocalService getWrappedService() {
		return _candidateOtherInfoLocalService;
	}

	@Override
	public void setWrappedService(
		CandidateOtherInfoLocalService candidateOtherInfoLocalService) {

		_candidateOtherInfoLocalService = candidateOtherInfoLocalService;
	}

	private CandidateOtherInfoLocalService _candidateOtherInfoLocalService;

}