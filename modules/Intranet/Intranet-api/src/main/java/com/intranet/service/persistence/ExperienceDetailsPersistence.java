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

import com.intranet.exception.NoSuchExperienceDetailsException;
import com.intranet.model.ExperienceDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the experience details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExperienceDetailsUtil
 * @generated
 */
@ProviderType
public interface ExperienceDetailsPersistence
	extends BasePersistence<ExperienceDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExperienceDetailsUtil} to access the experience details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the experience details in the entity cache if it is enabled.
	 *
	 * @param experienceDetails the experience details
	 */
	public void cacheResult(ExperienceDetails experienceDetails);

	/**
	 * Caches the experience detailses in the entity cache if it is enabled.
	 *
	 * @param experienceDetailses the experience detailses
	 */
	public void cacheResult(
		java.util.List<ExperienceDetails> experienceDetailses);

	/**
	 * Creates a new experience details with the primary key. Does not add the experience details to the database.
	 *
	 * @param experienceId the primary key for the new experience details
	 * @return the new experience details
	 */
	public ExperienceDetails create(long experienceId);

	/**
	 * Removes the experience details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details that was removed
	 * @throws NoSuchExperienceDetailsException if a experience details with the primary key could not be found
	 */
	public ExperienceDetails remove(long experienceId)
		throws NoSuchExperienceDetailsException;

	public ExperienceDetails updateImpl(ExperienceDetails experienceDetails);

	/**
	 * Returns the experience details with the primary key or throws a <code>NoSuchExperienceDetailsException</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details
	 * @throws NoSuchExperienceDetailsException if a experience details with the primary key could not be found
	 */
	public ExperienceDetails findByPrimaryKey(long experienceId)
		throws NoSuchExperienceDetailsException;

	/**
	 * Returns the experience details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience details
	 * @return the experience details, or <code>null</code> if a experience details with the primary key could not be found
	 */
	public ExperienceDetails fetchByPrimaryKey(long experienceId);

	/**
	 * Returns all the experience detailses.
	 *
	 * @return the experience detailses
	 */
	public java.util.List<ExperienceDetails> findAll();

	/**
	 * Returns a range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @return the range of experience detailses
	 */
	public java.util.List<ExperienceDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of experience detailses
	 */
	public java.util.List<ExperienceDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperienceDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the experience detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExperienceDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of experience detailses
	 * @param end the upper bound of the range of experience detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of experience detailses
	 */
	public java.util.List<ExperienceDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExperienceDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the experience detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of experience detailses.
	 *
	 * @return the number of experience detailses
	 */
	public int countAll();

}