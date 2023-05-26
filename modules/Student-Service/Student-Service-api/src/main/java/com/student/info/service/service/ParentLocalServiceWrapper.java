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

package com.student.info.service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ParentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ParentLocalService
 * @generated
 */
public class ParentLocalServiceWrapper
	implements ParentLocalService, ServiceWrapper<ParentLocalService> {

	public ParentLocalServiceWrapper() {
		this(null);
	}

	public ParentLocalServiceWrapper(ParentLocalService parentLocalService) {
		_parentLocalService = parentLocalService;
	}

	@Override
	public com.student.info.service.model.Parent addParent(
		long parentId, String parentName, long parentContact, long companyId) {

		return _parentLocalService.addParent(
			parentId, parentName, parentContact, companyId);
	}

	/**
	 * Adds the parent to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param parent the parent
	 * @return the parent that was added
	 */
	@Override
	public com.student.info.service.model.Parent addParent(
		com.student.info.service.model.Parent parent) {

		return _parentLocalService.addParent(parent);
	}

	@Override
	public void addStudentParent(long studentId, long parentId) {
		_parentLocalService.addStudentParent(studentId, parentId);
	}

	@Override
	public void addStudentParent(
		long studentId, com.student.info.service.model.Parent parent) {

		_parentLocalService.addStudentParent(studentId, parent);
	}

	@Override
	public void addStudentParents(
		long studentId,
		java.util.List<com.student.info.service.model.Parent> parents) {

		_parentLocalService.addStudentParents(studentId, parents);
	}

	@Override
	public void addStudentParents(long studentId, long[] parentIds) {
		_parentLocalService.addStudentParents(studentId, parentIds);
	}

	@Override
	public void clearStudentParents(long studentId) {
		_parentLocalService.clearStudentParents(studentId);
	}

	/**
	 * Creates a new parent with the primary key. Does not add the parent to the database.
	 *
	 * @param parentId the primary key for the new parent
	 * @return the new parent
	 */
	@Override
	public com.student.info.service.model.Parent createParent(long parentId) {
		return _parentLocalService.createParent(parentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the parent with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent that was removed
	 * @throws PortalException if a parent with the primary key could not be found
	 */
	@Override
	public com.student.info.service.model.Parent deleteParent(long parentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parentLocalService.deleteParent(parentId);
	}

	/**
	 * Deletes the parent from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param parent the parent
	 * @return the parent that was removed
	 */
	@Override
	public com.student.info.service.model.Parent deleteParent(
		com.student.info.service.model.Parent parent) {

		return _parentLocalService.deleteParent(parent);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deleteStudentParent(long studentId, long parentId) {
		_parentLocalService.deleteStudentParent(studentId, parentId);
	}

	@Override
	public void deleteStudentParent(
		long studentId, com.student.info.service.model.Parent parent) {

		_parentLocalService.deleteStudentParent(studentId, parent);
	}

	@Override
	public void deleteStudentParents(
		long studentId,
		java.util.List<com.student.info.service.model.Parent> parents) {

		_parentLocalService.deleteStudentParents(studentId, parents);
	}

	@Override
	public void deleteStudentParents(long studentId, long[] parentIds) {
		_parentLocalService.deleteStudentParents(studentId, parentIds);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _parentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _parentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _parentLocalService.dynamicQuery();
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

		return _parentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.ParentModelImpl</code>.
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

		return _parentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.ParentModelImpl</code>.
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

		return _parentLocalService.dynamicQuery(
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

		return _parentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _parentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.student.info.service.model.Parent fetchParent(long parentId) {
		return _parentLocalService.fetchParent(parentId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _parentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _parentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _parentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the parent with the primary key.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent
	 * @throws PortalException if a parent with the primary key could not be found
	 */
	@Override
	public com.student.info.service.model.Parent getParent(long parentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parentLocalService.getParent(parentId);
	}

	/**
	 * Returns a range of all the parents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.ParentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of parents
	 * @param end the upper bound of the range of parents (not inclusive)
	 * @return the range of parents
	 */
	@Override
	public java.util.List<com.student.info.service.model.Parent> getParents(
		int start, int end) {

		return _parentLocalService.getParents(start, end);
	}

	/**
	 * Returns the number of parents.
	 *
	 * @return the number of parents
	 */
	@Override
	public int getParentsCount() {
		return _parentLocalService.getParentsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _parentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.student.info.service.model.Parent>
		getStudentParents(long studentId) {

		return _parentLocalService.getStudentParents(studentId);
	}

	@Override
	public java.util.List<com.student.info.service.model.Parent>
		getStudentParents(long studentId, int start, int end) {

		return _parentLocalService.getStudentParents(studentId, start, end);
	}

	@Override
	public java.util.List<com.student.info.service.model.Parent>
		getStudentParents(
			long studentId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.student.info.service.model.Parent> orderByComparator) {

		return _parentLocalService.getStudentParents(
			studentId, start, end, orderByComparator);
	}

	@Override
	public int getStudentParentsCount(long studentId) {
		return _parentLocalService.getStudentParentsCount(studentId);
	}

	/**
	 * Returns the studentIds of the students associated with the parent.
	 *
	 * @param parentId the parentId of the parent
	 * @return long[] the studentIds of students associated with the parent
	 */
	@Override
	public long[] getStudentPrimaryKeys(long parentId) {
		return _parentLocalService.getStudentPrimaryKeys(parentId);
	}

	@Override
	public boolean hasStudentParent(long studentId, long parentId) {
		return _parentLocalService.hasStudentParent(studentId, parentId);
	}

	@Override
	public boolean hasStudentParents(long studentId) {
		return _parentLocalService.hasStudentParents(studentId);
	}

	@Override
	public void setStudentParents(long studentId, long[] parentIds) {
		_parentLocalService.setStudentParents(studentId, parentIds);
	}

	@Override
	public com.student.info.service.model.Parent updateParent(
		long parentId, String parentName, long parentContact) {

		return _parentLocalService.updateParent(
			parentId, parentName, parentContact);
	}

	/**
	 * Updates the parent in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param parent the parent
	 * @return the parent that was updated
	 */
	@Override
	public com.student.info.service.model.Parent updateParent(
		com.student.info.service.model.Parent parent) {

		return _parentLocalService.updateParent(parent);
	}

	@Override
	public ParentLocalService getWrappedService() {
		return _parentLocalService;
	}

	@Override
	public void setWrappedService(ParentLocalService parentLocalService) {
		_parentLocalService = parentLocalService;
	}

	private ParentLocalService _parentLocalService;

}