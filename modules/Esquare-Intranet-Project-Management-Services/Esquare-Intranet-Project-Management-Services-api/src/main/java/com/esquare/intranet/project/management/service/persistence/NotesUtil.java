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

package com.esquare.intranet.project.management.service.persistence;

import com.esquare.intranet.project.management.model.Notes;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the notes service. This utility wraps <code>com.esquare.intranet.project.management.service.persistence.impl.NotesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @see NotesPersistence
 * @generated
 */
public class NotesUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Notes notes) {
		getPersistence().clearCache(notes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Notes> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Notes> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Notes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Notes> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Notes> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Notes update(Notes notes) {
		return getPersistence().update(notes);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Notes update(Notes notes, ServiceContext serviceContext) {
		return getPersistence().update(notes, serviceContext);
	}

	/**
	 * Returns all the noteses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching noteses
	 */
	public static List<Notes> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the noteses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @return the range of matching noteses
	 */
	public static List<Notes> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the noteses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching noteses
	 */
	public static List<Notes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Notes> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the noteses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching noteses
	 */
	public static List<Notes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Notes> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notes
	 * @throws NoSuchNotesException if a matching notes could not be found
	 */
	public static Notes findByUuid_First(
			String uuid, OrderByComparator<Notes> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchNotesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notes, or <code>null</code> if a matching notes could not be found
	 */
	public static Notes fetchByUuid_First(
		String uuid, OrderByComparator<Notes> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notes
	 * @throws NoSuchNotesException if a matching notes could not be found
	 */
	public static Notes findByUuid_Last(
			String uuid, OrderByComparator<Notes> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchNotesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notes, or <code>null</code> if a matching notes could not be found
	 */
	public static Notes fetchByUuid_Last(
		String uuid, OrderByComparator<Notes> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the noteses before and after the current notes in the ordered set where uuid = &#63;.
	 *
	 * @param noteId the primary key of the current notes
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notes
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	public static Notes[] findByUuid_PrevAndNext(
			long noteId, String uuid,
			OrderByComparator<Notes> orderByComparator)
		throws com.esquare.intranet.project.management.exception.
			NoSuchNotesException {

		return getPersistence().findByUuid_PrevAndNext(
			noteId, uuid, orderByComparator);
	}

	/**
	 * Removes all the noteses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of noteses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching noteses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the notes in the entity cache if it is enabled.
	 *
	 * @param notes the notes
	 */
	public static void cacheResult(Notes notes) {
		getPersistence().cacheResult(notes);
	}

	/**
	 * Caches the noteses in the entity cache if it is enabled.
	 *
	 * @param noteses the noteses
	 */
	public static void cacheResult(List<Notes> noteses) {
		getPersistence().cacheResult(noteses);
	}

	/**
	 * Creates a new notes with the primary key. Does not add the notes to the database.
	 *
	 * @param noteId the primary key for the new notes
	 * @return the new notes
	 */
	public static Notes create(long noteId) {
		return getPersistence().create(noteId);
	}

	/**
	 * Removes the notes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes that was removed
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	public static Notes remove(long noteId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchNotesException {

		return getPersistence().remove(noteId);
	}

	public static Notes updateImpl(Notes notes) {
		return getPersistence().updateImpl(notes);
	}

	/**
	 * Returns the notes with the primary key or throws a <code>NoSuchNotesException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	public static Notes findByPrimaryKey(long noteId)
		throws com.esquare.intranet.project.management.exception.
			NoSuchNotesException {

		return getPersistence().findByPrimaryKey(noteId);
	}

	/**
	 * Returns the notes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes, or <code>null</code> if a notes with the primary key could not be found
	 */
	public static Notes fetchByPrimaryKey(long noteId) {
		return getPersistence().fetchByPrimaryKey(noteId);
	}

	/**
	 * Returns all the noteses.
	 *
	 * @return the noteses
	 */
	public static List<Notes> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the noteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @return the range of noteses
	 */
	public static List<Notes> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the noteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of noteses
	 */
	public static List<Notes> findAll(
		int start, int end, OrderByComparator<Notes> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the noteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of noteses
	 */
	public static List<Notes> findAll(
		int start, int end, OrderByComparator<Notes> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the noteses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of noteses.
	 *
	 * @return the number of noteses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NotesPersistence getPersistence() {
		return _persistence;
	}

	private static volatile NotesPersistence _persistence;

}