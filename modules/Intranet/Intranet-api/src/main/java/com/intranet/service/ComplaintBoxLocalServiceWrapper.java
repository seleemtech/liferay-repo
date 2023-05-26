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

package com.intranet.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ComplaintBoxLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ComplaintBoxLocalService
 * @generated
 */
public class ComplaintBoxLocalServiceWrapper
	implements ComplaintBoxLocalService,
			   ServiceWrapper<ComplaintBoxLocalService> {

	public ComplaintBoxLocalServiceWrapper() {
		this(null);
	}

	public ComplaintBoxLocalServiceWrapper(
		ComplaintBoxLocalService complaintBoxLocalService) {

		_complaintBoxLocalService = complaintBoxLocalService;
	}

	/**
	 * Adds the complaint box to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComplaintBoxLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param complaintBox the complaint box
	 * @return the complaint box that was added
	 */
	@Override
	public com.intranet.model.ComplaintBox addComplaintBox(
		com.intranet.model.ComplaintBox complaintBox) {

		return _complaintBoxLocalService.addComplaintBox(complaintBox);
	}

	/**
	 * Creates a new complaint box with the primary key. Does not add the complaint box to the database.
	 *
	 * @param fooId the primary key for the new complaint box
	 * @return the new complaint box
	 */
	@Override
	public com.intranet.model.ComplaintBox createComplaintBox(long fooId) {
		return _complaintBoxLocalService.createComplaintBox(fooId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _complaintBoxLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the complaint box from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComplaintBoxLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param complaintBox the complaint box
	 * @return the complaint box that was removed
	 */
	@Override
	public com.intranet.model.ComplaintBox deleteComplaintBox(
		com.intranet.model.ComplaintBox complaintBox) {

		return _complaintBoxLocalService.deleteComplaintBox(complaintBox);
	}

	/**
	 * Deletes the complaint box with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComplaintBoxLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box that was removed
	 * @throws PortalException if a complaint box with the primary key could not be found
	 */
	@Override
	public com.intranet.model.ComplaintBox deleteComplaintBox(long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _complaintBoxLocalService.deleteComplaintBox(fooId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _complaintBoxLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _complaintBoxLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _complaintBoxLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _complaintBoxLocalService.dynamicQuery();
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

		return _complaintBoxLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.ComplaintBoxModelImpl</code>.
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

		return _complaintBoxLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.ComplaintBoxModelImpl</code>.
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

		return _complaintBoxLocalService.dynamicQuery(
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

		return _complaintBoxLocalService.dynamicQueryCount(dynamicQuery);
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

		return _complaintBoxLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.intranet.model.ComplaintBox fetchComplaintBox(long fooId) {
		return _complaintBoxLocalService.fetchComplaintBox(fooId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _complaintBoxLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the complaint box with the primary key.
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box
	 * @throws PortalException if a complaint box with the primary key could not be found
	 */
	@Override
	public com.intranet.model.ComplaintBox getComplaintBox(long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _complaintBoxLocalService.getComplaintBox(fooId);
	}

	/**
	 * Returns a range of all the complaint boxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.ComplaintBoxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint boxes
	 * @param end the upper bound of the range of complaint boxes (not inclusive)
	 * @return the range of complaint boxes
	 */
	@Override
	public java.util.List<com.intranet.model.ComplaintBox> getComplaintBoxes(
		int start, int end) {

		return _complaintBoxLocalService.getComplaintBoxes(start, end);
	}

	/**
	 * Returns the number of complaint boxes.
	 *
	 * @return the number of complaint boxes
	 */
	@Override
	public int getComplaintBoxesCount() {
		return _complaintBoxLocalService.getComplaintBoxesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _complaintBoxLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _complaintBoxLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _complaintBoxLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the complaint box in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComplaintBoxLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param complaintBox the complaint box
	 * @return the complaint box that was updated
	 */
	@Override
	public com.intranet.model.ComplaintBox updateComplaintBox(
		com.intranet.model.ComplaintBox complaintBox) {

		return _complaintBoxLocalService.updateComplaintBox(complaintBox);
	}

	@Override
	public ComplaintBoxLocalService getWrappedService() {
		return _complaintBoxLocalService;
	}

	@Override
	public void setWrappedService(
		ComplaintBoxLocalService complaintBoxLocalService) {

		_complaintBoxLocalService = complaintBoxLocalService;
	}

	private ComplaintBoxLocalService _complaintBoxLocalService;

}