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

import com.esquare.intranet.project.management.exception.NoSuchNotesException;
import com.esquare.intranet.project.management.model.Notes;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the notes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @see NotesUtil
 * @generated
 */
@ProviderType
public interface NotesPersistence extends BasePersistence<Notes> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotesUtil} to access the notes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the noteses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching noteses
	 */
	public java.util.List<Notes> findByUuid(String uuid);

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
	public java.util.List<Notes> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Notes> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notes>
			orderByComparator);

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
	public java.util.List<Notes> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notes
	 * @throws NoSuchNotesException if a matching notes could not be found
	 */
	public Notes findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Notes>
				orderByComparator)
		throws NoSuchNotesException;

	/**
	 * Returns the first notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notes, or <code>null</code> if a matching notes could not be found
	 */
	public Notes fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Notes>
			orderByComparator);

	/**
	 * Returns the last notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notes
	 * @throws NoSuchNotesException if a matching notes could not be found
	 */
	public Notes findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Notes>
				orderByComparator)
		throws NoSuchNotesException;

	/**
	 * Returns the last notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notes, or <code>null</code> if a matching notes could not be found
	 */
	public Notes fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Notes>
			orderByComparator);

	/**
	 * Returns the noteses before and after the current notes in the ordered set where uuid = &#63;.
	 *
	 * @param noteId the primary key of the current notes
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notes
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	public Notes[] findByUuid_PrevAndNext(
			long noteId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Notes>
				orderByComparator)
		throws NoSuchNotesException;

	/**
	 * Removes all the noteses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of noteses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching noteses
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the notes in the entity cache if it is enabled.
	 *
	 * @param notes the notes
	 */
	public void cacheResult(Notes notes);

	/**
	 * Caches the noteses in the entity cache if it is enabled.
	 *
	 * @param noteses the noteses
	 */
	public void cacheResult(java.util.List<Notes> noteses);

	/**
	 * Creates a new notes with the primary key. Does not add the notes to the database.
	 *
	 * @param noteId the primary key for the new notes
	 * @return the new notes
	 */
	public Notes create(long noteId);

	/**
	 * Removes the notes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes that was removed
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	public Notes remove(long noteId) throws NoSuchNotesException;

	public Notes updateImpl(Notes notes);

	/**
	 * Returns the notes with the primary key or throws a <code>NoSuchNotesException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	public Notes findByPrimaryKey(long noteId) throws NoSuchNotesException;

	/**
	 * Returns the notes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes, or <code>null</code> if a notes with the primary key could not be found
	 */
	public Notes fetchByPrimaryKey(long noteId);

	/**
	 * Returns all the noteses.
	 *
	 * @return the noteses
	 */
	public java.util.List<Notes> findAll();

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
	public java.util.List<Notes> findAll(int start, int end);

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
	public java.util.List<Notes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notes>
			orderByComparator);

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
	public java.util.List<Notes> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Notes>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the noteses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of noteses.
	 *
	 * @return the number of noteses
	 */
	public int countAll();

}