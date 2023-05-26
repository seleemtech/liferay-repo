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

package com.intranet.service.persistence;

import com.intranet.exception.NoSuchComplaintBoxException;
import com.intranet.model.ComplaintBox;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the complaint box service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComplaintBoxUtil
 * @generated
 */
@ProviderType
public interface ComplaintBoxPersistence extends BasePersistence<ComplaintBox> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ComplaintBoxUtil} to access the complaint box persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the complaint box in the entity cache if it is enabled.
	 *
	 * @param complaintBox the complaint box
	 */
	public void cacheResult(ComplaintBox complaintBox);

	/**
	 * Caches the complaint boxes in the entity cache if it is enabled.
	 *
	 * @param complaintBoxes the complaint boxes
	 */
	public void cacheResult(java.util.List<ComplaintBox> complaintBoxes);

	/**
	 * Creates a new complaint box with the primary key. Does not add the complaint box to the database.
	 *
	 * @param fooId the primary key for the new complaint box
	 * @return the new complaint box
	 */
	public ComplaintBox create(long fooId);

	/**
	 * Removes the complaint box with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box that was removed
	 * @throws NoSuchComplaintBoxException if a complaint box with the primary key could not be found
	 */
	public ComplaintBox remove(long fooId) throws NoSuchComplaintBoxException;

	public ComplaintBox updateImpl(ComplaintBox complaintBox);

	/**
	 * Returns the complaint box with the primary key or throws a <code>NoSuchComplaintBoxException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box
	 * @throws NoSuchComplaintBoxException if a complaint box with the primary key could not be found
	 */
	public ComplaintBox findByPrimaryKey(long fooId)
		throws NoSuchComplaintBoxException;

	/**
	 * Returns the complaint box with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the complaint box
	 * @return the complaint box, or <code>null</code> if a complaint box with the primary key could not be found
	 */
	public ComplaintBox fetchByPrimaryKey(long fooId);

	/**
	 * Returns all the complaint boxes.
	 *
	 * @return the complaint boxes
	 */
	public java.util.List<ComplaintBox> findAll();

	/**
	 * Returns a range of all the complaint boxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComplaintBoxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint boxes
	 * @param end the upper bound of the range of complaint boxes (not inclusive)
	 * @return the range of complaint boxes
	 */
	public java.util.List<ComplaintBox> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the complaint boxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComplaintBoxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint boxes
	 * @param end the upper bound of the range of complaint boxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of complaint boxes
	 */
	public java.util.List<ComplaintBox> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComplaintBox>
			orderByComparator);

	/**
	 * Returns an ordered range of all the complaint boxes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComplaintBoxModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of complaint boxes
	 * @param end the upper bound of the range of complaint boxes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of complaint boxes
	 */
	public java.util.List<ComplaintBox> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComplaintBox>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the complaint boxes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of complaint boxes.
	 *
	 * @return the number of complaint boxes
	 */
	public int countAll();

}