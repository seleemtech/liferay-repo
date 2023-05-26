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

import com.intranet.exception.NoSuchEducationDetailsException;
import com.intranet.model.EducationDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the education details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EducationDetailsUtil
 * @generated
 */
@ProviderType
public interface EducationDetailsPersistence
	extends BasePersistence<EducationDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EducationDetailsUtil} to access the education details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the education details in the entity cache if it is enabled.
	 *
	 * @param educationDetails the education details
	 */
	public void cacheResult(EducationDetails educationDetails);

	/**
	 * Caches the education detailses in the entity cache if it is enabled.
	 *
	 * @param educationDetailses the education detailses
	 */
	public void cacheResult(
		java.util.List<EducationDetails> educationDetailses);

	/**
	 * Creates a new education details with the primary key. Does not add the education details to the database.
	 *
	 * @param educationId the primary key for the new education details
	 * @return the new education details
	 */
	public EducationDetails create(long educationId);

	/**
	 * Removes the education details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details that was removed
	 * @throws NoSuchEducationDetailsException if a education details with the primary key could not be found
	 */
	public EducationDetails remove(long educationId)
		throws NoSuchEducationDetailsException;

	public EducationDetails updateImpl(EducationDetails educationDetails);

	/**
	 * Returns the education details with the primary key or throws a <code>NoSuchEducationDetailsException</code> if it could not be found.
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details
	 * @throws NoSuchEducationDetailsException if a education details with the primary key could not be found
	 */
	public EducationDetails findByPrimaryKey(long educationId)
		throws NoSuchEducationDetailsException;

	/**
	 * Returns the education details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param educationId the primary key of the education details
	 * @return the education details, or <code>null</code> if a education details with the primary key could not be found
	 */
	public EducationDetails fetchByPrimaryKey(long educationId);

	/**
	 * Returns all the education detailses.
	 *
	 * @return the education detailses
	 */
	public java.util.List<EducationDetails> findAll();

	/**
	 * Returns a range of all the education detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education detailses
	 * @param end the upper bound of the range of education detailses (not inclusive)
	 * @return the range of education detailses
	 */
	public java.util.List<EducationDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the education detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education detailses
	 * @param end the upper bound of the range of education detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of education detailses
	 */
	public java.util.List<EducationDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EducationDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the education detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EducationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of education detailses
	 * @param end the upper bound of the range of education detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of education detailses
	 */
	public java.util.List<EducationDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EducationDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the education detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of education detailses.
	 *
	 * @return the number of education detailses
	 */
	public int countAll();

}