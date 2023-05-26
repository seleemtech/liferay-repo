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

import com.candidate.service.model.ProfessionalDetails;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ProfessionalDetails. This utility wraps
 * <code>com.candidate.service.service.impl.ProfessionalDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProfessionalDetailsLocalService
 * @generated
 */
public class ProfessionalDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.candidate.service.service.impl.ProfessionalDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ProfessionalDetails addProfessionalDetails(
		ProfessionalDetails professionalDetails) {

		return getService().addProfessionalDetails(professionalDetails);
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
	 * Creates a new professional details with the primary key. Does not add the professional details to the database.
	 *
	 * @param professionalDetailsId the primary key for the new professional details
	 * @return the new professional details
	 */
	public static ProfessionalDetails createProfessionalDetails(
		long professionalDetailsId) {

		return getService().createProfessionalDetails(professionalDetailsId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static ProfessionalDetails deleteProfessionalDetails(
			long professionalDetailsId)
		throws PortalException {

		return getService().deleteProfessionalDetails(professionalDetailsId);
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
	public static ProfessionalDetails deleteProfessionalDetails(
		ProfessionalDetails professionalDetails) {

		return getService().deleteProfessionalDetails(professionalDetails);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.ProfessionalDetailsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.candidate.service.model.impl.ProfessionalDetailsModelImpl</code>.
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

	public static ProfessionalDetails fetchProfessionalDetails(
		long professionalDetailsId) {

		return getService().fetchProfessionalDetails(professionalDetailsId);
	}

	/**
	 * Returns the professional details with the matching UUID and company.
	 *
	 * @param uuid the professional details's UUID
	 * @param companyId the primary key of the company
	 * @return the matching professional details, or <code>null</code> if a matching professional details could not be found
	 */
	public static ProfessionalDetails
		fetchProfessionalDetailsByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().fetchProfessionalDetailsByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static ProfessionalDetails getByCandidateId(long candidateId)
		throws com.candidate.service.exception.
			NoSuchProfessionalDetailsException {

		return getService().getByCandidateId(candidateId);
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
	 * Returns the professional details with the primary key.
	 *
	 * @param professionalDetailsId the primary key of the professional details
	 * @return the professional details
	 * @throws PortalException if a professional details with the primary key could not be found
	 */
	public static ProfessionalDetails getProfessionalDetails(
			long professionalDetailsId)
		throws PortalException {

		return getService().getProfessionalDetails(professionalDetailsId);
	}

	/**
	 * Returns the professional details with the matching UUID and company.
	 *
	 * @param uuid the professional details's UUID
	 * @param companyId the primary key of the company
	 * @return the matching professional details
	 * @throws PortalException if a matching professional details could not be found
	 */
	public static ProfessionalDetails getProfessionalDetailsByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getProfessionalDetailsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<ProfessionalDetails> getProfessionalDetailses(
		int start, int end) {

		return getService().getProfessionalDetailses(start, end);
	}

	/**
	 * Returns the number of professional detailses.
	 *
	 * @return the number of professional detailses
	 */
	public static int getProfessionalDetailsesCount() {
		return getService().getProfessionalDetailsesCount();
	}

	public static ProfessionalDetails updateProfDetails(
		long professionalDetailsId, long candidateId, double expectedSalary,
		double currentSalary, String skillSet, String additionalInfo,
		String currentEmployer, String workType, String experience,
		String qualification, String jobTitle,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().updateProfDetails(
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
	public static ProfessionalDetails updateProfessionalDetails(
		ProfessionalDetails professionalDetails) {

		return getService().updateProfessionalDetails(professionalDetails);
	}

	public static ProfessionalDetailsLocalService getService() {
		return _service;
	}

	private static volatile ProfessionalDetailsLocalService _service;

}