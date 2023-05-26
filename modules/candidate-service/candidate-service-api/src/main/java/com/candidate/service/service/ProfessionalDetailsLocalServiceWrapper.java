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
 * Provides a wrapper for {@link ProfessionalDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalDetailsLocalService
 * @generated
 */
public class ProfessionalDetailsLocalServiceWrapper
	implements ProfessionalDetailsLocalService,
			   ServiceWrapper<ProfessionalDetailsLocalService> {

	public ProfessionalDetailsLocalServiceWrapper(
		ProfessionalDetailsLocalService professionalDetailsLocalService) {

		_professionalDetailsLocalService = professionalDetailsLocalService;
	}

	/**
	 * Adds the professional details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfessionalDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param professionalDetails the professional details
	 * @return the professional details that was added
	 */
	@Override
	public com.candidate.service.model.ProfessionalDetails
		addProfessionalDetails(
			com.candidate.service.model.ProfessionalDetails
				professionalDetails) {

		return _professionalDetailsLocalService.addProfessionalDetails(
			professionalDetails);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professionalDetailsLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new professional details with the primary key. Does not add the professional details to the database.
	 *
	 * @param professionalDetailsId the primary key for the new professional details
	 * @return the new professional details
	 */
	@Override
	public com.candidate.service.model.ProfessionalDetails
		createProfessionalDetails(long professionalDetailsId) {

		return _professionalDetailsLocalService.createProfessionalDetails(
			professionalDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professionalDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the professional details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfessionalDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param professionalDetailsId the primary key of the professional details
	 * @return the professional details that was removed
	 * @throws PortalException if a professional details with the primary key could not be found
	 */
	@Override
	public com.candidate.service.model.ProfessionalDetails
			deleteProfessionalDetails(long professionalDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professionalDetailsLocalService.deleteProfessionalDetails(
			professionalDetailsId);
	}

	/**
	 * Deletes the professional details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfessionalDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param professionalDetails the professional details
	 * @return the professional details that was removed
	 */
	@Override
	public com.candidate.service.model.ProfessionalDetails
		deleteProfessionalDetails(
			com.candidate.service.model.ProfessionalDetails
				professionalDetails) {

		return _professionalDetailsLocalService.deleteProfessionalDetails(
			professionalDetails);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _professionalDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _professionalDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _professionalDetailsLocalService.dynamicQuery();
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

		return _professionalDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.ProfessionalDetailsModelImpl</code>.
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

		return _professionalDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.ProfessionalDetailsModelImpl</code>.
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

		return _professionalDetailsLocalService.dynamicQuery(
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

		return _professionalDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _professionalDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.candidate.service.model.ProfessionalDetails
		fetchProfessionalDetails(long professionalDetailsId) {

		return _professionalDetailsLocalService.fetchProfessionalDetails(
			professionalDetailsId);
	}

	/**
	 * Returns the professional details with the matching UUID and company.
	 *
	 * @param uuid the professional details's UUID
	 * @param companyId the primary key of the company
	 * @return the matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	@Override
	public com.candidate.service.model.ProfessionalDetails
		fetchProfessionalDetailsByUuidAndCompanyId(
			String uuid, long companyId) {

		return _professionalDetailsLocalService.
			fetchProfessionalDetailsByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _professionalDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.candidate.service.model.ProfessionalDetails getByCandidateId(
			long candidateId)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return _professionalDetailsLocalService.getByCandidateId(candidateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _professionalDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _professionalDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professionalDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the professional details with the primary key.
	 *
	 * @param professionalDetailsId the primary key of the professional details
	 * @return the professional details
	 * @throws PortalException if a professional details with the primary key could not be found
	 */
	@Override
	public com.candidate.service.model.ProfessionalDetails
			getProfessionalDetails(long professionalDetailsId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professionalDetailsLocalService.getProfessionalDetails(
			professionalDetailsId);
	}

	/**
	 * Returns the professional details with the matching UUID and company.
	 *
	 * @param uuid the professional details's UUID
	 * @param companyId the primary key of the company
	 * @return the matching professional details
	 * @throws PortalException if a matching professional details could not be found
	 */
	@Override
	public com.candidate.service.model.ProfessionalDetails
			getProfessionalDetailsByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _professionalDetailsLocalService.
			getProfessionalDetailsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the professional detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.ProfessionalDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of professional detailses
	 * @param end the upper bound of the range of professional detailses (not inclusive)
	 * @return the range of professional detailses
	 */
	@Override
	public java.util.List<com.candidate.service.model.ProfessionalDetails>
		getProfessionalDetailses(int start, int end) {

		return _professionalDetailsLocalService.getProfessionalDetailses(
			start, end);
	}

	/**
	 * Returns the number of professional detailses.
	 *
	 * @return the number of professional detailses
	 */
	@Override
	public int getProfessionalDetailsesCount() {
		return _professionalDetailsLocalService.getProfessionalDetailsesCount();
	}

	@Override
	public com.candidate.service.model.ProfessionalDetails updateProfDetails(
		long professionalDetailsId, long candidateId, double expectedSalary,
		double currentSalary, String skillSet, String additionalInfo,
		String currentEmployer, String workType, String experience,
		String qualification, String jobTitle,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _professionalDetailsLocalService.updateProfDetails(
			professionalDetailsId, candidateId, expectedSalary, currentSalary,
			skillSet, additionalInfo, currentEmployer, workType, experience,
			qualification, jobTitle, serviceContext);
	}

	/**
	 * Updates the professional details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProfessionalDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param professionalDetails the professional details
	 * @return the professional details that was updated
	 */
	@Override
	public com.candidate.service.model.ProfessionalDetails
		updateProfessionalDetails(
			com.candidate.service.model.ProfessionalDetails
				professionalDetails) {

		return _professionalDetailsLocalService.updateProfessionalDetails(
			professionalDetails);
	}

	@Override
	public ProfessionalDetailsLocalService getWrappedService() {
		return _professionalDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		ProfessionalDetailsLocalService professionalDetailsLocalService) {

		_professionalDetailsLocalService = professionalDetailsLocalService;
	}

	private ProfessionalDetailsLocalService _professionalDetailsLocalService;

}