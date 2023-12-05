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

package com.esquare.intranet.project.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NotesLocalService}.
 *
 * @author Mahammed Seleem
 * @see NotesLocalService
 * @generated
 */
public class NotesLocalServiceWrapper
	implements NotesLocalService, ServiceWrapper<NotesLocalService> {

	public NotesLocalServiceWrapper() {
		this(null);
	}

	public NotesLocalServiceWrapper(NotesLocalService notesLocalService) {
		_notesLocalService = notesLocalService;
	}

	/**
	 * Adds the notes to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notes the notes
	 * @return the notes that was added
	 */
	@Override
	public com.esquare.intranet.project.management.model.Notes addNotes(
		com.esquare.intranet.project.management.model.Notes notes) {

		return _notesLocalService.addNotes(notes);
	}

	/**
	 * Creates a new notes with the primary key. Does not add the notes to the database.
	 *
	 * @param noteId the primary key for the new notes
	 * @return the new notes
	 */
	@Override
	public com.esquare.intranet.project.management.model.Notes createNotes(
		long noteId) {

		return _notesLocalService.createNotes(noteId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the notes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes that was removed
	 * @throws PortalException if a notes with the primary key could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.Notes deleteNotes(
			long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notesLocalService.deleteNotes(noteId);
	}

	/**
	 * Deletes the notes from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notes the notes
	 * @return the notes that was removed
	 */
	@Override
	public com.esquare.intranet.project.management.model.Notes deleteNotes(
		com.esquare.intranet.project.management.model.Notes notes) {

		return _notesLocalService.deleteNotes(notes);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _notesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _notesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _notesLocalService.dynamicQuery();
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

		return _notesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.NotesModelImpl</code>.
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

		return _notesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.NotesModelImpl</code>.
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

		return _notesLocalService.dynamicQuery(
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

		return _notesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _notesLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.esquare.intranet.project.management.model.Notes fetchNotes(
		long noteId) {

		return _notesLocalService.fetchNotes(noteId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _notesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _notesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the notes with the primary key.
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes
	 * @throws PortalException if a notes with the primary key could not be found
	 */
	@Override
	public com.esquare.intranet.project.management.model.Notes getNotes(
			long noteId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notesLocalService.getNotes(noteId);
	}

	/**
	 * Returns a range of all the noteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.esquare.intranet.project.management.model.impl.NotesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @return the range of noteses
	 */
	@Override
	public java.util.List<com.esquare.intranet.project.management.model.Notes>
		getNoteses(int start, int end) {

		return _notesLocalService.getNoteses(start, end);
	}

	/**
	 * Returns the number of noteses.
	 *
	 * @return the number of noteses
	 */
	@Override
	public int getNotesesCount() {
		return _notesLocalService.getNotesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _notesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _notesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the notes in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notes the notes
	 * @return the notes that was updated
	 */
	@Override
	public com.esquare.intranet.project.management.model.Notes updateNotes(
		com.esquare.intranet.project.management.model.Notes notes) {

		return _notesLocalService.updateNotes(notes);
	}

	@Override
	public NotesLocalService getWrappedService() {
		return _notesLocalService;
	}

	@Override
	public void setWrappedService(NotesLocalService notesLocalService) {
		_notesLocalService = notesLocalService;
	}

	private NotesLocalService _notesLocalService;

}