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
 * Provides a wrapper for {@link CandidateInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateInfoLocalService
 * @generated
 */
public class CandidateInfoLocalServiceWrapper
	implements CandidateInfoLocalService,
			   ServiceWrapper<CandidateInfoLocalService> {

	public CandidateInfoLocalServiceWrapper(
		CandidateInfoLocalService candidateInfoLocalService) {

		_candidateInfoLocalService = candidateInfoLocalService;
	}

	/**
	 * Adds the candidate info to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateInfo the candidate info
	 * @return the candidate info that was added
	 */
	@Override
	public com.candidate.service.model.CandidateInfo addCandidateInfo(
		com.candidate.service.model.CandidateInfo candidateInfo) {

		return _candidateInfoLocalService.addCandidateInfo(candidateInfo);
	}

	@Override
	public com.candidate.service.model.CandidateInfo addOrUpdateCandidate(
		long candidateId, String firstName, String lastName, String email,
		String secondaryEmail, String mobileNumber, String country,
		String street, String city, String state, String zipCode,
		String houseNumber, String website,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _candidateInfoLocalService.addOrUpdateCandidate(
			candidateId, firstName, lastName, email, secondaryEmail,
			mobileNumber, country, street, city, state, zipCode, houseNumber,
			website, serviceContext);
	}

	/**
	 * Creates a new candidate info with the primary key. Does not add the candidate info to the database.
	 *
	 * @param candidateId the primary key for the new candidate info
	 * @return the new candidate info
	 */
	@Override
	public com.candidate.service.model.CandidateInfo createCandidateInfo(
		long candidateId) {

		return _candidateInfoLocalService.createCandidateInfo(candidateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateInfoLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public com.candidate.service.model.CandidateInfo deleteCandidate(
			long candidateId)
		throws com.candidate.service.exception.NoSuchCandidateInfoException {

		return _candidateInfoLocalService.deleteCandidate(candidateId);
	}

	/**
	 * Deletes the candidate info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateInfo the candidate info
	 * @return the candidate info that was removed
	 */
	@Override
	public com.candidate.service.model.CandidateInfo deleteCandidateInfo(
		com.candidate.service.model.CandidateInfo candidateInfo) {

		return _candidateInfoLocalService.deleteCandidateInfo(candidateInfo);
	}

	/**
	 * Deletes the candidate info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateId the primary key of the candidate info
	 * @return the candidate info that was removed
	 * @throws PortalException if a candidate info with the primary key could not be found
	 */
	@Override
	public com.candidate.service.model.CandidateInfo deleteCandidateInfo(
			long candidateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateInfoLocalService.deleteCandidateInfo(candidateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateInfoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _candidateInfoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _candidateInfoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateInfoLocalService.dynamicQuery();
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

		return _candidateInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.CandidateInfoModelImpl</code>.
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

		return _candidateInfoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.CandidateInfoModelImpl</code>.
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

		return _candidateInfoLocalService.dynamicQuery(
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

		return _candidateInfoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _candidateInfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.candidate.service.model.CandidateInfo fetchCandidateInfo(
		long candidateId) {

		return _candidateInfoLocalService.fetchCandidateInfo(candidateId);
	}

	/**
	 * Returns the candidate info with the matching UUID and company.
	 *
	 * @param uuid the candidate info's UUID
	 * @param companyId the primary key of the company
	 * @return the matching candidate info, or <code>null</code> if a matching candidate info could not be found
	 */
	@Override
	public com.candidate.service.model.CandidateInfo
		fetchCandidateInfoByUuidAndCompanyId(String uuid, long companyId) {

		return _candidateInfoLocalService.fetchCandidateInfoByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _candidateInfoLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the candidate info with the primary key.
	 *
	 * @param candidateId the primary key of the candidate info
	 * @return the candidate info
	 * @throws PortalException if a candidate info with the primary key could not be found
	 */
	@Override
	public com.candidate.service.model.CandidateInfo getCandidateInfo(
			long candidateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateInfoLocalService.getCandidateInfo(candidateId);
	}

	/**
	 * Returns the candidate info with the matching UUID and company.
	 *
	 * @param uuid the candidate info's UUID
	 * @param companyId the primary key of the company
	 * @return the matching candidate info
	 * @throws PortalException if a matching candidate info could not be found
	 */
	@Override
	public com.candidate.service.model.CandidateInfo
			getCandidateInfoByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateInfoLocalService.getCandidateInfoByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the candidate infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.CandidateInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate infos
	 * @param end the upper bound of the range of candidate infos (not inclusive)
	 * @return the range of candidate infos
	 */
	@Override
	public java.util.List<com.candidate.service.model.CandidateInfo>
		getCandidateInfos(int start, int end) {

		return _candidateInfoLocalService.getCandidateInfos(start, end);
	}

	/**
	 * Returns the number of candidate infos.
	 *
	 * @return the number of candidate infos
	 */
	@Override
	public int getCandidateInfosCount() {
		return _candidateInfoLocalService.getCandidateInfosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _candidateInfoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _candidateInfoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the candidate info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateInfo the candidate info
	 * @return the candidate info that was updated
	 */
	@Override
	public com.candidate.service.model.CandidateInfo updateCandidateInfo(
		com.candidate.service.model.CandidateInfo candidateInfo) {

		return _candidateInfoLocalService.updateCandidateInfo(candidateInfo);
	}

	@Override
	public CandidateInfoLocalService getWrappedService() {
		return _candidateInfoLocalService;
	}

	@Override
	public void setWrappedService(
		CandidateInfoLocalService candidateInfoLocalService) {

		_candidateInfoLocalService = candidateInfoLocalService;
	}

	private CandidateInfoLocalService _candidateInfoLocalService;

}