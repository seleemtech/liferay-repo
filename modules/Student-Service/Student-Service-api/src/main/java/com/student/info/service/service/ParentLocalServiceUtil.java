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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.student.info.service.model.Parent;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Parent. This utility wraps
 * <code>com.student.info.service.service.impl.ParentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ParentLocalService
 * @generated
 */
public class ParentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.student.info.service.service.impl.ParentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Parent addParent(
		long parentId, String parentName, long parentContact, long companyId) {

		return getService().addParent(
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
	public static Parent addParent(Parent parent) {
		return getService().addParent(parent);
	}

	public static void addStudentParent(long studentId, long parentId) {
		getService().addStudentParent(studentId, parentId);
	}

	public static void addStudentParent(long studentId, Parent parent) {
		getService().addStudentParent(studentId, parent);
	}

	public static void addStudentParents(long studentId, List<Parent> parents) {
		getService().addStudentParents(studentId, parents);
	}

	public static void addStudentParents(long studentId, long[] parentIds) {
		getService().addStudentParents(studentId, parentIds);
	}

	public static void clearStudentParents(long studentId) {
		getService().clearStudentParents(studentId);
	}

	/**
	 * Creates a new parent with the primary key. Does not add the parent to the database.
	 *
	 * @param parentId the primary key for the new parent
	 * @return the new parent
	 */
	public static Parent createParent(long parentId) {
		return getService().createParent(parentId);
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
	public static Parent deleteParent(long parentId) throws PortalException {
		return getService().deleteParent(parentId);
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
	public static Parent deleteParent(Parent parent) {
		return getService().deleteParent(parent);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static void deleteStudentParent(long studentId, long parentId) {
		getService().deleteStudentParent(studentId, parentId);
	}

	public static void deleteStudentParent(long studentId, Parent parent) {
		getService().deleteStudentParent(studentId, parent);
	}

	public static void deleteStudentParents(
		long studentId, List<Parent> parents) {

		getService().deleteStudentParents(studentId, parents);
	}

	public static void deleteStudentParents(long studentId, long[] parentIds) {
		getService().deleteStudentParents(studentId, parentIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.ParentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.student.info.service.model.impl.ParentModelImpl</code>.
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

	public static Parent fetchParent(long parentId) {
		return getService().fetchParent(parentId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the parent with the primary key.
	 *
	 * @param parentId the primary key of the parent
	 * @return the parent
	 * @throws PortalException if a parent with the primary key could not be found
	 */
	public static Parent getParent(long parentId) throws PortalException {
		return getService().getParent(parentId);
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
	public static List<Parent> getParents(int start, int end) {
		return getService().getParents(start, end);
	}

	/**
	 * Returns the number of parents.
	 *
	 * @return the number of parents
	 */
	public static int getParentsCount() {
		return getService().getParentsCount();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static List<Parent> getStudentParents(long studentId) {
		return getService().getStudentParents(studentId);
	}

	public static List<Parent> getStudentParents(
		long studentId, int start, int end) {

		return getService().getStudentParents(studentId, start, end);
	}

	public static List<Parent> getStudentParents(
		long studentId, int start, int end,
		OrderByComparator<Parent> orderByComparator) {

		return getService().getStudentParents(
			studentId, start, end, orderByComparator);
	}

	public static int getStudentParentsCount(long studentId) {
		return getService().getStudentParentsCount(studentId);
	}

	/**
	 * Returns the studentIds of the students associated with the parent.
	 *
	 * @param parentId the parentId of the parent
	 * @return long[] the studentIds of students associated with the parent
	 */
	public static long[] getStudentPrimaryKeys(long parentId) {
		return getService().getStudentPrimaryKeys(parentId);
	}

	public static boolean hasStudentParent(long studentId, long parentId) {
		return getService().hasStudentParent(studentId, parentId);
	}

	public static boolean hasStudentParents(long studentId) {
		return getService().hasStudentParents(studentId);
	}

	public static void setStudentParents(long studentId, long[] parentIds) {
		getService().setStudentParents(studentId, parentIds);
	}

	public static Parent updateParent(
		long parentId, String parentName, long parentContact) {

		return getService().updateParent(parentId, parentName, parentContact);
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
	public static Parent updateParent(Parent parent) {
		return getService().updateParent(parent);
	}

	public static ParentLocalService getService() {
		return _service;
	}

	private static volatile ParentLocalService _service;

}