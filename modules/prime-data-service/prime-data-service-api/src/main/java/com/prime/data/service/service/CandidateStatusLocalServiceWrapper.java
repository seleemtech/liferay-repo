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
 * Provides a wrapper for {@link CandidateStatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateStatusLocalService
 * @generated
 */
public class CandidateStatusLocalServiceWrapper
	implements CandidateStatusLocalService,
			   ServiceWrapper<CandidateStatusLocalService> {

	public CandidateStatusLocalServiceWrapper(
		CandidateStatusLocalService candidateStatusLocalService) {

		_candidateStatusLocalService = candidateStatusLocalService;
	}

	/**
	 * Adds the candidate status to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateStatus the candidate status
	 * @return the candidate status that was added
	 */
	@Override
	public com.prime.data.service.model.CandidateStatus addCandidateStatus(
		com.prime.data.service.model.CandidateStatus candidateStatus) {

		return _candidateStatusLocalService.addCandidateStatus(candidateStatus);
	}

	@Override
	public void addCandidateStatus(String candidateStatus) {
		_candidateStatusLocalService.addCandidateStatus(candidateStatus);
	}

	/**
	 * Creates a new candidate status with the primary key. Does not add the candidate status to the database.
	 *
	 * @param candidateStatusId the primary key for the new candidate status
	 * @return the new candidate status
	 */
	@Override
	public com.prime.data.service.model.CandidateStatus createCandidateStatus(
		long candidateStatusId) {

		return _candidateStatusLocalService.createCandidateStatus(
			candidateStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateStatusLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the candidate status from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateStatus the candidate status
	 * @return the candidate status that was removed
	 */
	@Override
	public com.prime.data.service.model.CandidateStatus deleteCandidateStatus(
		com.prime.data.service.model.CandidateStatus candidateStatus) {

		return _candidateStatusLocalService.deleteCandidateStatus(
			candidateStatus);
	}

	/**
	 * Deletes the candidate status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status that was removed
	 * @throws PortalException if a candidate status with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.CandidateStatus deleteCandidateStatus(
			long candidateStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateStatusLocalService.deleteCandidateStatus(
			candidateStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateStatusLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _candidateStatusLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _candidateStatusLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateStatusLocalService.dynamicQuery();
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

		return _candidateStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.CandidateStatusModelImpl</code>.
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

		return _candidateStatusLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.CandidateStatusModelImpl</code>.
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

		return _candidateStatusLocalService.dynamicQuery(
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

		return _candidateStatusLocalService.dynamicQueryCount(dynamicQuery);
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

		return _candidateStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.CandidateStatus fetchCandidateStatus(
		long candidateStatusId) {

		return _candidateStatusLocalService.fetchCandidateStatus(
			candidateStatusId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _candidateStatusLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the candidate status with the primary key.
	 *
	 * @param candidateStatusId the primary key of the candidate status
	 * @return the candidate status
	 * @throws PortalException if a candidate status with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.CandidateStatus getCandidateStatus(
			long candidateStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateStatusLocalService.getCandidateStatus(
			candidateStatusId);
	}

	/**
	 * Returns a range of all the candidate statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.CandidateStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate statuses
	 * @param end the upper bound of the range of candidate statuses (not inclusive)
	 * @return the range of candidate statuses
	 */
	@Override
	public java.util.List<com.prime.data.service.model.CandidateStatus>
		getCandidateStatuses(int start, int end) {

		return _candidateStatusLocalService.getCandidateStatuses(start, end);
	}

	/**
	 * Returns the number of candidate statuses.
	 *
	 * @return the number of candidate statuses
	 */
	@Override
	public int getCandidateStatusesCount() {
		return _candidateStatusLocalService.getCandidateStatusesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _candidateStatusLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _candidateStatusLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the candidate status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CandidateStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param candidateStatus the candidate status
	 * @return the candidate status that was updated
	 */
	@Override
	public com.prime.data.service.model.CandidateStatus updateCandidateStatus(
		com.prime.data.service.model.CandidateStatus candidateStatus) {

		return _candidateStatusLocalService.updateCandidateStatus(
			candidateStatus);
	}

	@Override
	public CandidateStatusLocalService getWrappedService() {
		return _candidateStatusLocalService;
	}

	@Override
	public void setWrappedService(
		CandidateStatusLocalService candidateStatusLocalService) {

		_candidateStatusLocalService = candidateStatusLocalService;
	}

	private CandidateStatusLocalService _candidateStatusLocalService;

}