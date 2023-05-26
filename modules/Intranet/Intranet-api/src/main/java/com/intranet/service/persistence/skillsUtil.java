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

import com.intranet.model.skills;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the skills service. This utility wraps <code>com.intranet.service.persistence.impl.skillsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see skillsPersistence
 * @generated
 */
public class skillsUtil {

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
	public static void clearCache(skills skills) {
		getPersistence().clearCache(skills);
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
	public static Map<Serializable, skills> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<skills> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<skills> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<skills> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<skills> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static skills update(skills skills) {
		return getPersistence().update(skills);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static skills update(skills skills, ServiceContext serviceContext) {
		return getPersistence().update(skills, serviceContext);
	}

	/**
	 * Returns all the skillses where skill = &#63;.
	 *
	 * @param skill the skill
	 * @return the matching skillses
	 */
	public static List<skills> findByskill(String skill) {
		return getPersistence().findByskill(skill);
	}

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
	public static List<skills> findByskill(String skill, int start, int end) {
		return getPersistence().findByskill(skill, start, end);
	}

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
	public static List<skills> findByskill(
		String skill, int start, int end,
		OrderByComparator<skills> orderByComparator) {

		return getPersistence().findByskill(
			skill, start, end, orderByComparator);
	}

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
	public static List<skills> findByskill(
		String skill, int start, int end,
		OrderByComparator<skills> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByskill(
			skill, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skills
	 * @throws NoSuchskillsException if a matching skills could not be found
	 */
	public static skills findByskill_First(
			String skill, OrderByComparator<skills> orderByComparator)
		throws com.intranet.exception.NoSuchskillsException {

		return getPersistence().findByskill_First(skill, orderByComparator);
	}

	/**
	 * Returns the first skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skills, or <code>null</code> if a matching skills could not be found
	 */
	public static skills fetchByskill_First(
		String skill, OrderByComparator<skills> orderByComparator) {

		return getPersistence().fetchByskill_First(skill, orderByComparator);
	}

	/**
	 * Returns the last skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skills
	 * @throws NoSuchskillsException if a matching skills could not be found
	 */
	public static skills findByskill_Last(
			String skill, OrderByComparator<skills> orderByComparator)
		throws com.intranet.exception.NoSuchskillsException {

		return getPersistence().findByskill_Last(skill, orderByComparator);
	}

	/**
	 * Returns the last skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skills, or <code>null</code> if a matching skills could not be found
	 */
	public static skills fetchByskill_Last(
		String skill, OrderByComparator<skills> orderByComparator) {

		return getPersistence().fetchByskill_Last(skill, orderByComparator);
	}

	/**
	 * Returns the skillses before and after the current skills in the ordered set where skill = &#63;.
	 *
	 * @param skillId the primary key of the current skills
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next skills
	 * @throws NoSuchskillsException if a skills with the primary key could not be found
	 */
	public static skills[] findByskill_PrevAndNext(
			long skillId, String skill,
			OrderByComparator<skills> orderByComparator)
		throws com.intranet.exception.NoSuchskillsException {

		return getPersistence().findByskill_PrevAndNext(
			skillId, skill, orderByComparator);
	}

	/**
	 * Removes all the skillses where skill = &#63; from the database.
	 *
	 * @param skill the skill
	 */
	public static void removeByskill(String skill) {
		getPersistence().removeByskill(skill);
	}

	/**
	 * Returns the number of skillses where skill = &#63;.
	 *
	 * @param skill the skill
	 * @return the number of matching skillses
	 */
	public static int countByskill(String skill) {
		return getPersistence().countByskill(skill);
	}

	/**
	 * Caches the skills in the entity cache if it is enabled.
	 *
	 * @param skills the skills
	 */
	public static void cacheResult(skills skills) {
		getPersistence().cacheResult(skills);
	}

	/**
	 * Caches the skillses in the entity cache if it is enabled.
	 *
	 * @param skillses the skillses
	 */
	public static void cacheResult(List<skills> skillses) {
		getPersistence().cacheResult(skillses);
	}

	/**
	 * Creates a new skills with the primary key. Does not add the skills to the database.
	 *
	 * @param skillId the primary key for the new skills
	 * @return the new skills
	 */
	public static skills create(long skillId) {
		return getPersistence().create(skillId);
	}

	/**
	 * Removes the skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills that was removed
	 * @throws NoSuchskillsException if a skills with the primary key could not be found
	 */
	public static skills remove(long skillId)
		throws com.intranet.exception.NoSuchskillsException {

		return getPersistence().remove(skillId);
	}

	public static skills updateImpl(skills skills) {
		return getPersistence().updateImpl(skills);
	}

	/**
	 * Returns the skills with the primary key or throws a <code>NoSuchskillsException</code> if it could not be found.
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills
	 * @throws NoSuchskillsException if a skills with the primary key could not be found
	 */
	public static skills findByPrimaryKey(long skillId)
		throws com.intranet.exception.NoSuchskillsException {

		return getPersistence().findByPrimaryKey(skillId);
	}

	/**
	 * Returns the skills with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills, or <code>null</code> if a skills with the primary key could not be found
	 */
	public static skills fetchByPrimaryKey(long skillId) {
		return getPersistence().fetchByPrimaryKey(skillId);
	}

	/**
	 * Returns all the skillses.
	 *
	 * @return the skillses
	 */
	public static List<skills> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<skills> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<skills> findAll(
		int start, int end, OrderByComparator<skills> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<skills> findAll(
		int start, int end, OrderByComparator<skills> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the skillses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of skillses.
	 *
	 * @return the number of skillses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static skillsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile skillsPersistence _persistence;

}