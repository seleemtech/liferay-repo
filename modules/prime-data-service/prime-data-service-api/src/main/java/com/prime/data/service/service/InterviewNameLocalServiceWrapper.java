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
 * Provides a wrapper for {@link InterviewNameLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InterviewNameLocalService
 * @generated
 */
public class InterviewNameLocalServiceWrapper
	implements InterviewNameLocalService,
			   ServiceWrapper<InterviewNameLocalService> {

	public InterviewNameLocalServiceWrapper(
		InterviewNameLocalService interviewNameLocalService) {

		_interviewNameLocalService = interviewNameLocalService;
	}

	/**
	 * Adds the interview name to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterviewNameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interviewName the interview name
	 * @return the interview name that was added
	 */
	@Override
	public com.prime.data.service.model.InterviewName addInterviewName(
		com.prime.data.service.model.InterviewName interviewName) {

		return _interviewNameLocalService.addInterviewName(interviewName);
	}

	@Override
	public void addInterviewName(String interviewName) {
		_interviewNameLocalService.addInterviewName(interviewName);
	}

	/**
	 * Creates a new interview name with the primary key. Does not add the interview name to the database.
	 *
	 * @param interviewNameId the primary key for the new interview name
	 * @return the new interview name
	 */
	@Override
	public com.prime.data.service.model.InterviewName createInterviewName(
		long interviewNameId) {

		return _interviewNameLocalService.createInterviewName(interviewNameId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interviewNameLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the interview name from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterviewNameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interviewName the interview name
	 * @return the interview name that was removed
	 */
	@Override
	public com.prime.data.service.model.InterviewName deleteInterviewName(
		com.prime.data.service.model.InterviewName interviewName) {

		return _interviewNameLocalService.deleteInterviewName(interviewName);
	}

	/**
	 * Deletes the interview name with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterviewNameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interviewNameId the primary key of the interview name
	 * @return the interview name that was removed
	 * @throws PortalException if a interview name with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.InterviewName deleteInterviewName(
			long interviewNameId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interviewNameLocalService.deleteInterviewName(interviewNameId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interviewNameLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _interviewNameLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _interviewNameLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _interviewNameLocalService.dynamicQuery();
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

		return _interviewNameLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.InterviewNameModelImpl</code>.
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

		return _interviewNameLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.InterviewNameModelImpl</code>.
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

		return _interviewNameLocalService.dynamicQuery(
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

		return _interviewNameLocalService.dynamicQueryCount(dynamicQuery);
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

		return _interviewNameLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.prime.data.service.model.InterviewName fetchInterviewName(
		long interviewNameId) {

		return _interviewNameLocalService.fetchInterviewName(interviewNameId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _interviewNameLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _interviewNameLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the interview name with the primary key.
	 *
	 * @param interviewNameId the primary key of the interview name
	 * @return the interview name
	 * @throws PortalException if a interview name with the primary key could not be found
	 */
	@Override
	public com.prime.data.service.model.InterviewName getInterviewName(
			long interviewNameId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interviewNameLocalService.getInterviewName(interviewNameId);
	}

	/**
	 * Returns a range of all the interview names.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.prime.data.service.model.impl.InterviewNameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview names
	 * @param end the upper bound of the range of interview names (not inclusive)
	 * @return the range of interview names
	 */
	@Override
	public java.util.List<com.prime.data.service.model.InterviewName>
		getInterviewNames(int start, int end) {

		return _interviewNameLocalService.getInterviewNames(start, end);
	}

	/**
	 * Returns the number of interview names.
	 *
	 * @return the number of interview names
	 */
	@Override
	public int getInterviewNamesCount() {
		return _interviewNameLocalService.getInterviewNamesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _interviewNameLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interviewNameLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the interview name in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterviewNameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interviewName the interview name
	 * @return the interview name that was updated
	 */
	@Override
	public com.prime.data.service.model.InterviewName updateInterviewName(
		com.prime.data.service.model.InterviewName interviewName) {

		return _interviewNameLocalService.updateInterviewName(interviewName);
	}

	@Override
	public InterviewNameLocalService getWrappedService() {
		return _interviewNameLocalService;
	}

	@Override
	public void setWrappedService(
		InterviewNameLocalService interviewNameLocalService) {

		_interviewNameLocalService = interviewNameLocalService;
	}

	private InterviewNameLocalService _interviewNameLocalService;

}