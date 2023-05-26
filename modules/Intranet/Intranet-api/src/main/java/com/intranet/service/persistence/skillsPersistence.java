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

import com.intranet.exception.NoSuchskillsException;
import com.intranet.model.skills;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the skills service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see skillsUtil
 * @generated
 */
@ProviderType
public interface skillsPersistence extends BasePersistence<skills> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link skillsUtil} to access the skills persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the skillses where skill = &#63;.
	 *
	 * @param skill the skill
	 * @return the matching skillses
	 */
	public java.util.List<skills> findByskill(String skill);

	/**
	 * Returns a range of all the skillses where skill = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>skillsModelImpl</code>.
	 * </p>
	 *
	 * @param skill the skill
	 * @param start the lower bound of the range of skillses
	 * @param end the upper bound of the range of skillses (not inclusive)
	 * @return the range of matching skillses
	 */
	public java.util.List<skills> findByskill(String skill, int start, int end);

	/**
	 * Returns an ordered range of all the skillses where skill = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>skillsModelImpl</code>.
	 * </p>
	 *
	 * @param skill the skill
	 * @param start the lower bound of the range of skillses
	 * @param end the upper bound of the range of skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching skillses
	 */
	public java.util.List<skills> findByskill(
		String skill, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<skills>
			orderByComparator);

	/**
	 * Returns an ordered range of all the skillses where skill = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>skillsModelImpl</code>.
	 * </p>
	 *
	 * @param skill the skill
	 * @param start the lower bound of the range of skillses
	 * @param end the upper bound of the range of skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching skillses
	 */
	public java.util.List<skills> findByskill(
		String skill, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<skills>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skills
	 * @throws NoSuchskillsException if a matching skills could not be found
	 */
	public skills findByskill_First(
			String skill,
			com.liferay.portal.kernel.util.OrderByComparator<skills>
				orderByComparator)
		throws NoSuchskillsException;

	/**
	 * Returns the first skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skills, or <code>null</code> if a matching skills could not be found
	 */
	public skills fetchByskill_First(
		String skill,
		com.liferay.portal.kernel.util.OrderByComparator<skills>
			orderByComparator);

	/**
	 * Returns the last skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skills
	 * @throws NoSuchskillsException if a matching skills could not be found
	 */
	public skills findByskill_Last(
			String skill,
			com.liferay.portal.kernel.util.OrderByComparator<skills>
				orderByComparator)
		throws NoSuchskillsException;

	/**
	 * Returns the last skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skills, or <code>null</code> if a matching skills could not be found
	 */
	public skills fetchByskill_Last(
		String skill,
		com.liferay.portal.kernel.util.OrderByComparator<skills>
			orderByComparator);

	/**
	 * Returns the skillses before and after the current skills in the ordered set where skill = &#63;.
	 *
	 * @param skillId the primary key of the current skills
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next skills
	 * @throws NoSuchskillsException if a skills with the primary key could not be found
	 */
	public skills[] findByskill_PrevAndNext(
			long skillId, String skill,
			com.liferay.portal.kernel.util.OrderByComparator<skills>
				orderByComparator)
		throws NoSuchskillsException;

	/**
	 * Removes all the skillses where skill = &#63; from the database.
	 *
	 * @param skill the skill
	 */
	public void removeByskill(String skill);

	/**
	 * Returns the number of skillses where skill = &#63;.
	 *
	 * @param skill the skill
	 * @return the number of matching skillses
	 */
	public int countByskill(String skill);

	/**
	 * Caches the skills in the entity cache if it is enabled.
	 *
	 * @param skills the skills
	 */
	public void cacheResult(skills skills);

	/**
	 * Caches the skillses in the entity cache if it is enabled.
	 *
	 * @param skillses the skillses
	 */
	public void cacheResult(java.util.List<skills> skillses);

	/**
	 * Creates a new skills with the primary key. Does not add the skills to the database.
	 *
	 * @param skillId the primary key for the new skills
	 * @return the new skills
	 */
	public skills create(long skillId);

	/**
	 * Removes the skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills that was removed
	 * @throws NoSuchskillsException if a skills with the primary key could not be found
	 */
	public skills remove(long skillId) throws NoSuchskillsException;

	public skills updateImpl(skills skills);

	/**
	 * Returns the skills with the primary key or throws a <code>NoSuchskillsException</code> if it could not be found.
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills
	 * @throws NoSuchskillsException if a skills with the primary key could not be found
	 */
	public skills findByPrimaryKey(long skillId) throws NoSuchskillsException;

	/**
	 * Returns the skills with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills, or <code>null</code> if a skills with the primary key could not be found
	 */
	public skills fetchByPrimaryKey(long skillId);

	/**
	 * Returns all the skillses.
	 *
	 * @return the skillses
	 */
	public java.util.List<skills> findAll();

	/**
	 * Returns a range of all the skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>skillsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of skillses
	 * @param end the upper bound of the range of skillses (not inclusive)
	 * @return the range of skillses
	 */
	public java.util.List<skills> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>skillsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of skillses
	 * @param end the upper bound of the range of skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of skillses
	 */
	public java.util.List<skills> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<skills>
			orderByComparator);

	/**
	 * Returns an ordered range of all the skillses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>skillsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of skillses
	 * @param end the upper bound of the range of skillses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of skillses
	 */
	public java.util.List<skills> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<skills>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the skillses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of skillses.
	 *
	 * @return the number of skillses
	 */
	public int countAll();

}