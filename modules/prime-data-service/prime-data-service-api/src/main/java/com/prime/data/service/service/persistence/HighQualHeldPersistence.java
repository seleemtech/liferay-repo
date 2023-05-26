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

package com.prime.data.service.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.prime.data.service.exception.NoSuchHighQualHeldException;
import com.prime.data.service.model.HighQualHeld;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the high qual held service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HighQualHeldUtil
 * @generated
 */
@ProviderType
public interface HighQualHeldPersistence extends BasePersistence<HighQualHeld> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HighQualHeldUtil} to access the high qual held persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the high qual helds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching high qual helds
	 */
	public java.util.List<HighQualHeld> findByUuid(String uuid);

	/**
	 * Returns a range of all the high qual helds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @return the range of matching high qual helds
	 */
	public java.util.List<HighQualHeld> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the high qual helds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching high qual helds
	 */
	public java.util.List<HighQualHeld> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HighQualHeld>
			orderByComparator);

	/**
	 * Returns an ordered range of all the high qual helds where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching high qual helds
	 */
	public java.util.List<HighQualHeld> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HighQualHeld>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching high qual held
	 * @throws NoSuchHighQualHeldException if a matching high qual held could not be found
	 */
	public HighQualHeld findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<HighQualHeld>
				orderByComparator)
		throws NoSuchHighQualHeldException;

	/**
	 * Returns the first high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching high qual held, or <code>null</code> if a matching high qual held could not be found
	 */
	public HighQualHeld fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<HighQualHeld>
			orderByComparator);

	/**
	 * Returns the last high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching high qual held
	 * @throws NoSuchHighQualHeldException if a matching high qual held could not be found
	 */
	public HighQualHeld findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<HighQualHeld>
				orderByComparator)
		throws NoSuchHighQualHeldException;

	/**
	 * Returns the last high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching high qual held, or <code>null</code> if a matching high qual held could not be found
	 */
	public HighQualHeld fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<HighQualHeld>
			orderByComparator);

	/**
	 * Returns the high qual helds before and after the current high qual held in the ordered set where uuid = &#63;.
	 *
	 * @param highQualHeldId the primary key of the current high qual held
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next high qual held
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	public HighQualHeld[] findByUuid_PrevAndNext(
			long highQualHeldId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<HighQualHeld>
				orderByComparator)
		throws NoSuchHighQualHeldException;

	/**
	 * Removes all the high qual helds where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of high qual helds where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching high qual helds
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the high qual held in the entity cache if it is enabled.
	 *
	 * @param highQualHeld the high qual held
	 */
	public void cacheResult(HighQualHeld highQualHeld);

	/**
	 * Caches the high qual helds in the entity cache if it is enabled.
	 *
	 * @param highQualHelds the high qual helds
	 */
	public void cacheResult(java.util.List<HighQualHeld> highQualHelds);

	/**
	 * Creates a new high qual held with the primary key. Does not add the high qual held to the database.
	 *
	 * @param highQualHeldId the primary key for the new high qual held
	 * @return the new high qual held
	 */
	public HighQualHeld create(long highQualHeldId);

	/**
	 * Removes the high qual held with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held that was removed
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	public HighQualHeld remove(long highQualHeldId)
		throws NoSuchHighQualHeldException;

	public HighQualHeld updateImpl(HighQualHeld highQualHeld);

	/**
	 * Returns the high qual held with the primary key or throws a <code>NoSuchHighQualHeldException</code> if it could not be found.
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held
	 * @throws NoSuchHighQualHeldException if a high qual held with the primary key could not be found
	 */
	public HighQualHeld findByPrimaryKey(long highQualHeldId)
		throws NoSuchHighQualHeldException;

	/**
	 * Returns the high qual held with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param highQualHeldId the primary key of the high qual held
	 * @return the high qual held, or <code>null</code> if a high qual held with the primary key could not be found
	 */
	public HighQualHeld fetchByPrimaryKey(long highQualHeldId);

	/**
	 * Returns all the high qual helds.
	 *
	 * @return the high qual helds
	 */
	public java.util.List<HighQualHeld> findAll();

	/**
	 * Returns a range of all the high qual helds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @return the range of high qual helds
	 */
	public java.util.List<HighQualHeld> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the high qual helds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of high qual helds
	 */
	public java.util.List<HighQualHeld> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HighQualHeld>
			orderByComparator);

	/**
	 * Returns an ordered range of all the high qual helds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HighQualHeldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of high qual helds
	 * @param end the upper bound of the range of high qual helds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of high qual helds
	 */
	public java.util.List<HighQualHeld> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HighQualHeld>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the high qual helds from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of high qual helds.
	 *
	 * @return the number of high qual helds
	 */
	public int countAll();

}