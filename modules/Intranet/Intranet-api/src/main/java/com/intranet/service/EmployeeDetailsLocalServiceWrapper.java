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
 * Provides a wrapper for {@link EmployeeDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeDetailsLocalService
 * @generated
 */
public class EmployeeDetailsLocalServiceWrapper
	implements EmployeeDetailsLocalService,
			   ServiceWrapper<EmployeeDetailsLocalService> {

	public EmployeeDetailsLocalServiceWrapper() {
		this(null);
	}

	public EmployeeDetailsLocalServiceWrapper(
		EmployeeDetailsLocalService employeeDetailsLocalService) {

		_employeeDetailsLocalService = employeeDetailsLocalService;
	}

	@Override
	public com.intranet.model.EmployeeDetails addEmployee(
			String employeename, String gender, String domain, long contact,
			String email, String address, String pannumber,
			String passportNumber, String aadhar, java.util.Date joiningDate,
			java.util.Date dob, boolean maritalstatus,
			java.util.Date anniversaryDate, long fileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.addEmployee(
			employeename, gender, domain, contact, email, address, pannumber,
			passportNumber, aadhar, joiningDate, dob, maritalstatus,
			anniversaryDate, fileEntryId);
	}

	/**
	 * Adds the employee details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDetails the employee details
	 * @return the employee details that was added
	 */
	@Override
	public com.intranet.model.EmployeeDetails addEmployeeDetails(
		com.intranet.model.EmployeeDetails employeeDetails) {

		return _employeeDetailsLocalService.addEmployeeDetails(employeeDetails);
	}

	/**
	 * Creates a new employee details with the primary key. Does not add the employee details to the database.
	 *
	 * @param employeeID the primary key for the new employee details
	 * @return the new employee details
	 */
	@Override
	public com.intranet.model.EmployeeDetails createEmployeeDetails(
		long employeeID) {

		return _employeeDetailsLocalService.createEmployeeDetails(employeeID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public com.intranet.model.EmployeeDetails deleteEmployee(long employeeID)
		throws com.intranet.exception.NoSuchEmployeeDetailsException {

		return _employeeDetailsLocalService.deleteEmployee(employeeID);
	}

	/**
	 * Deletes the employee details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDetails the employee details
	 * @return the employee details that was removed
	 */
	@Override
	public com.intranet.model.EmployeeDetails deleteEmployeeDetails(
		com.intranet.model.EmployeeDetails employeeDetails) {

		return _employeeDetailsLocalService.deleteEmployeeDetails(
			employeeDetails);
	}

	/**
	 * Deletes the employee details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details that was removed
	 * @throws PortalException if a employee details with the primary key could not be found
	 */
	@Override
	public com.intranet.model.EmployeeDetails deleteEmployeeDetails(
			long employeeID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.deleteEmployeeDetails(employeeID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _employeeDetailsLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _employeeDetailsLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeDetailsLocalService.dynamicQuery();
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

		return _employeeDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.EmployeeDetailsModelImpl</code>.
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

		return _employeeDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.EmployeeDetailsModelImpl</code>.
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

		return _employeeDetailsLocalService.dynamicQuery(
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

		return _employeeDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.intranet.model.EmployeeDetails fetchEmployeeDetails(
		long employeeID) {

		return _employeeDetailsLocalService.fetchEmployeeDetails(employeeID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the employee details with the primary key.
	 *
	 * @param employeeID the primary key of the employee details
	 * @return the employee details
	 * @throws PortalException if a employee details with the primary key could not be found
	 */
	@Override
	public com.intranet.model.EmployeeDetails getEmployeeDetails(
			long employeeID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.getEmployeeDetails(employeeID);
	}

	/**
	 * Returns a range of all the employee detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.intranet.model.impl.EmployeeDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee detailses
	 * @param end the upper bound of the range of employee detailses (not inclusive)
	 * @return the range of employee detailses
	 */
	@Override
	public java.util.List<com.intranet.model.EmployeeDetails>
		getEmployeeDetailses(int start, int end) {

		return _employeeDetailsLocalService.getEmployeeDetailses(start, end);
	}

	/**
	 * Returns the number of employee detailses.
	 *
	 * @return the number of employee detailses
	 */
	@Override
	public int getEmployeeDetailsesCount() {
		return _employeeDetailsLocalService.getEmployeeDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.intranet.model.EmployeeDetails updateEmployee(
		long employeeID, String employeename, String gender, String domain,
		long contact, String email, String address, String pannumber,
		String passportNumber, String aadhar, java.util.Date joiningDate,
		java.util.Date dob, boolean maritalstatus,
		java.util.Date anniversaryDate, long fileEntryId) {

		return _employeeDetailsLocalService.updateEmployee(
			employeeID, employeename, gender, domain, contact, email, address,
			pannumber, passportNumber, aadhar, joiningDate, dob, maritalstatus,
			anniversaryDate, fileEntryId);
	}

	/**
	 * Updates the employee details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeDetails the employee details
	 * @return the employee details that was updated
	 */
	@Override
	public com.intranet.model.EmployeeDetails updateEmployeeDetails(
		com.intranet.model.EmployeeDetails employeeDetails) {

		return _employeeDetailsLocalService.updateEmployeeDetails(
			employeeDetails);
	}

	@Override
	public EmployeeDetailsLocalService getWrappedService() {
		return _employeeDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		EmployeeDetailsLocalService employeeDetailsLocalService) {

		_employeeDetailsLocalService = employeeDetailsLocalService;
	}

	private EmployeeDetailsLocalService _employeeDetailsLocalService;

}