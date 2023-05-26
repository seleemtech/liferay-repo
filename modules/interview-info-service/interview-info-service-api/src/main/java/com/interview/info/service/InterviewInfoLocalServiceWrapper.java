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

package com.interview.info.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InterviewInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InterviewInfoLocalService
 * @generated
 */
public class InterviewInfoLocalServiceWrapper
	implements InterviewInfoLocalService,
			   ServiceWrapper<InterviewInfoLocalService> {

	public InterviewInfoLocalServiceWrapper(
		InterviewInfoLocalService interviewInfoLocalService) {

		_interviewInfoLocalService = interviewInfoLocalService;
	}

	/**
	 * Adds the interview info to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterviewInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interviewInfo the interview info
	 * @return the interview info that was added
	 */
	@Override
	public com.interview.info.model.InterviewInfo addInterviewInfo(
		com.interview.info.model.InterviewInfo interviewInfo) {

		return _interviewInfoLocalService.addInterviewInfo(interviewInfo);
	}

	/**
	 * Creates a new interview info with the primary key. Does not add the interview info to the database.
	 *
	 * @param interviewId the primary key for the new interview info
	 * @return the new interview info
	 */
	@Override
	public com.interview.info.model.InterviewInfo createInterviewInfo(
		long interviewId) {

		return _interviewInfoLocalService.createInterviewInfo(interviewId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interviewInfoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the interview info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterviewInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interviewInfo the interview info
	 * @return the interview info that was removed
	 */
	@Override
	public com.interview.info.model.InterviewInfo deleteInterviewInfo(
		com.interview.info.model.InterviewInfo interviewInfo) {

		return _interviewInfoLocalService.deleteInterviewInfo(interviewInfo);
	}

	/**
	 * Deletes the interview info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterviewInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info that was removed
	 * @throws PortalException if a interview info with the primary key could not be found
	 */
	@Override
	public com.interview.info.model.InterviewInfo deleteInterviewInfo(
			long interviewId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interviewInfoLocalService.deleteInterviewInfo(interviewId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interviewInfoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _interviewInfoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _interviewInfoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _interviewInfoLocalService.dynamicQuery();
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

		return _interviewInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.interview.info.model.impl.InterviewInfoModelImpl</code>.
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

		return _interviewInfoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.interview.info.model.impl.InterviewInfoModelImpl</code>.
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

		return _interviewInfoLocalService.dynamicQuery(
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

		return _interviewInfoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _interviewInfoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.interview.info.model.InterviewInfo fetchInterviewInfo(
		long interviewId) {

		return _interviewInfoLocalService.fetchInterviewInfo(interviewId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _interviewInfoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _interviewInfoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the interview info with the primary key.
	 *
	 * @param interviewId the primary key of the interview info
	 * @return the interview info
	 * @throws PortalException if a interview info with the primary key could not be found
	 */
	@Override
	public com.interview.info.model.InterviewInfo getInterviewInfo(
			long interviewId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interviewInfoLocalService.getInterviewInfo(interviewId);
	}

	/**
	 * Returns a range of all the interview infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.interview.info.model.impl.InterviewInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview infos
	 * @param end the upper bound of the range of interview infos (not inclusive)
	 * @return the range of interview infos
	 */
	@Override
	public java.util.List<com.interview.info.model.InterviewInfo>
		getInterviewInfos(int start, int end) {

		return _interviewInfoLocalService.getInterviewInfos(start, end);
	}

	/**
	 * Returns the number of interview infos.
	 *
	 * @return the number of interview infos
	 */
	@Override
	public int getInterviewInfosCount() {
		return _interviewInfoLocalService.getInterviewInfosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _interviewInfoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interviewInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the interview info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterviewInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interviewInfo the interview info
	 * @return the interview info that was updated
	 */
	@Override
	public com.interview.info.model.InterviewInfo updateInterviewInfo(
		com.interview.info.model.InterviewInfo interviewInfo) {

		return _interviewInfoLocalService.updateInterviewInfo(interviewInfo);
	}

	@Override
	public InterviewInfoLocalService getWrappedService() {
		return _interviewInfoLocalService;
	}

	@Override
	public void setWrappedService(
		InterviewInfoLocalService interviewInfoLocalService) {

		_interviewInfoLocalService = interviewInfoLocalService;
	}

	private InterviewInfoLocalService _interviewInfoLocalService;

}