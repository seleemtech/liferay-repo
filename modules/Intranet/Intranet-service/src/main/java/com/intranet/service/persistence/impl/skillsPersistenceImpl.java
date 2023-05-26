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

package com.intranet.service.persistence.impl;

import com.intranet.exception.NoSuchskillsException;
import com.intranet.model.impl.skillsImpl;
import com.intranet.model.impl.skillsModelImpl;
import com.intranet.model.skills;
import com.intranet.model.skillsTable;
import com.intranet.service.persistence.impl.constants.INTRANETPersistenceConstants;
import com.intranet.service.persistence.skillsPersistence;
import com.intranet.service.persistence.skillsUtil;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the skills service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {skillsPersistence.class, BasePersistence.class})
public class skillsPersistenceImpl
	extends BasePersistenceImpl<skills> implements skillsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>skillsUtil</code> to access the skills persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		skillsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByskill;
	private FinderPath _finderPathWithoutPaginationFindByskill;
	private FinderPath _finderPathCountByskill;

	/**
	 * Returns all the skillses where skill = &#63;.
	 *
	 * @param skill the skill
	 * @return the matching skillses
	 */
	@Override
	public List<skills> findByskill(String skill) {
		return findByskill(skill, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<skills> findByskill(String skill, int start, int end) {
		return findByskill(skill, start, end, null);
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
	@Override
	public List<skills> findByskill(
		String skill, int start, int end,
		OrderByComparator<skills> orderByComparator) {

		return findByskill(skill, start, end, orderByComparator, true);
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
	@Override
	public List<skills> findByskill(
		String skill, int start, int end,
		OrderByComparator<skills> orderByComparator, boolean useFinderCache) {

		skill = Objects.toString(skill, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByskill;
				finderArgs = new Object[] {skill};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByskill;
			finderArgs = new Object[] {skill, start, end, orderByComparator};
		}

		List<skills> list = null;

		if (useFinderCache) {
			list = (List<skills>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (skills skills : list) {
					if (!skill.equals(skills.getSkill())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_SKILLS_WHERE);

			boolean bindSkill = false;

			if (skill.isEmpty()) {
				sb.append(_FINDER_COLUMN_SKILL_SKILL_3);
			}
			else {
				bindSkill = true;

				sb.append(_FINDER_COLUMN_SKILL_SKILL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(skillsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSkill) {
					queryPos.add(skill);
				}

				list = (List<skills>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skills
	 * @throws NoSuchskillsException if a matching skills could not be found
	 */
	@Override
	public skills findByskill_First(
			String skill, OrderByComparator<skills> orderByComparator)
		throws NoSuchskillsException {

		skills skills = fetchByskill_First(skill, orderByComparator);

		if (skills != null) {
			return skills;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("skill=");
		sb.append(skill);

		sb.append("}");

		throw new NoSuchskillsException(sb.toString());
	}

	/**
	 * Returns the first skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skills, or <code>null</code> if a matching skills could not be found
	 */
	@Override
	public skills fetchByskill_First(
		String skill, OrderByComparator<skills> orderByComparator) {

		List<skills> list = findByskill(skill, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skills
	 * @throws NoSuchskillsException if a matching skills could not be found
	 */
	@Override
	public skills findByskill_Last(
			String skill, OrderByComparator<skills> orderByComparator)
		throws NoSuchskillsException {

		skills skills = fetchByskill_Last(skill, orderByComparator);

		if (skills != null) {
			return skills;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("skill=");
		sb.append(skill);

		sb.append("}");

		throw new NoSuchskillsException(sb.toString());
	}

	/**
	 * Returns the last skills in the ordered set where skill = &#63;.
	 *
	 * @param skill the skill
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skills, or <code>null</code> if a matching skills could not be found
	 */
	@Override
	public skills fetchByskill_Last(
		String skill, OrderByComparator<skills> orderByComparator) {

		int count = countByskill(skill);

		if (count == 0) {
			return null;
		}

		List<skills> list = findByskill(
			skill, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public skills[] findByskill_PrevAndNext(
			long skillId, String skill,
			OrderByComparator<skills> orderByComparator)
		throws NoSuchskillsException {

		skill = Objects.toString(skill, "");

		skills skills = findByPrimaryKey(skillId);

		Session session = null;

		try {
			session = openSession();

			skills[] array = new skillsImpl[3];

			array[0] = getByskill_PrevAndNext(
				session, skills, skill, orderByComparator, true);

			array[1] = skills;

			array[2] = getByskill_PrevAndNext(
				session, skills, skill, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected skills getByskill_PrevAndNext(
		Session session, skills skills, String skill,
		OrderByComparator<skills> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SKILLS_WHERE);

		boolean bindSkill = false;

		if (skill.isEmpty()) {
			sb.append(_FINDER_COLUMN_SKILL_SKILL_3);
		}
		else {
			bindSkill = true;

			sb.append(_FINDER_COLUMN_SKILL_SKILL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(skillsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSkill) {
			queryPos.add(skill);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(skills)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<skills> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the skillses where skill = &#63; from the database.
	 *
	 * @param skill the skill
	 */
	@Override
	public void removeByskill(String skill) {
		for (skills skills :
				findByskill(
					skill, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(skills);
		}
	}

	/**
	 * Returns the number of skillses where skill = &#63;.
	 *
	 * @param skill the skill
	 * @return the number of matching skillses
	 */
	@Override
	public int countByskill(String skill) {
		skill = Objects.toString(skill, "");

		FinderPath finderPath = _finderPathCountByskill;

		Object[] finderArgs = new Object[] {skill};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SKILLS_WHERE);

			boolean bindSkill = false;

			if (skill.isEmpty()) {
				sb.append(_FINDER_COLUMN_SKILL_SKILL_3);
			}
			else {
				bindSkill = true;

				sb.append(_FINDER_COLUMN_SKILL_SKILL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSkill) {
					queryPos.add(skill);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SKILL_SKILL_2 =
		"skills.skill = ?";

	private static final String _FINDER_COLUMN_SKILL_SKILL_3 =
		"(skills.skill IS NULL OR skills.skill = '')";

	public skillsPersistenceImpl() {
		setModelClass(skills.class);

		setModelImplClass(skillsImpl.class);
		setModelPKClass(long.class);

		setTable(skillsTable.INSTANCE);
	}

	/**
	 * Caches the skills in the entity cache if it is enabled.
	 *
	 * @param skills the skills
	 */
	@Override
	public void cacheResult(skills skills) {
		entityCache.putResult(skillsImpl.class, skills.getPrimaryKey(), skills);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the skillses in the entity cache if it is enabled.
	 *
	 * @param skillses the skillses
	 */
	@Override
	public void cacheResult(List<skills> skillses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (skillses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (skills skills : skillses) {
			if (entityCache.getResult(
					skillsImpl.class, skills.getPrimaryKey()) == null) {

				cacheResult(skills);
			}
		}
	}

	/**
	 * Clears the cache for all skillses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(skillsImpl.class);

		finderCache.clearCache(skillsImpl.class);
	}

	/**
	 * Clears the cache for the skills.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(skills skills) {
		entityCache.removeResult(skillsImpl.class, skills);
	}

	@Override
	public void clearCache(List<skills> skillses) {
		for (skills skills : skillses) {
			entityCache.removeResult(skillsImpl.class, skills);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(skillsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(skillsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new skills with the primary key. Does not add the skills to the database.
	 *
	 * @param skillId the primary key for the new skills
	 * @return the new skills
	 */
	@Override
	public skills create(long skillId) {
		skills skills = new skillsImpl();

		skills.setNew(true);
		skills.setPrimaryKey(skillId);

		return skills;
	}

	/**
	 * Removes the skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills that was removed
	 * @throws NoSuchskillsException if a skills with the primary key could not be found
	 */
	@Override
	public skills remove(long skillId) throws NoSuchskillsException {
		return remove((Serializable)skillId);
	}

	/**
	 * Removes the skills with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the skills
	 * @return the skills that was removed
	 * @throws NoSuchskillsException if a skills with the primary key could not be found
	 */
	@Override
	public skills remove(Serializable primaryKey) throws NoSuchskillsException {
		Session session = null;

		try {
			session = openSession();

			skills skills = (skills)session.get(skillsImpl.class, primaryKey);

			if (skills == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchskillsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(skills);
		}
		catch (NoSuchskillsException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected skills removeImpl(skills skills) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skills)) {
				skills = (skills)session.get(
					skillsImpl.class, skills.getPrimaryKeyObj());
			}

			if (skills != null) {
				session.delete(skills);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (skills != null) {
			clearCache(skills);
		}

		return skills;
	}

	@Override
	public skills updateImpl(skills skills) {
		boolean isNew = skills.isNew();

		if (!(skills instanceof skillsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(skills.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(skills);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in skills proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom skills implementation " +
					skills.getClass());
		}

		skillsModelImpl skillsModelImpl = (skillsModelImpl)skills;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(skills);
			}
			else {
				skills = (skills)session.merge(skills);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(skillsImpl.class, skillsModelImpl, false, true);

		if (isNew) {
			skills.setNew(false);
		}

		skills.resetOriginalValues();

		return skills;
	}

	/**
	 * Returns the skills with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the skills
	 * @return the skills
	 * @throws NoSuchskillsException if a skills with the primary key could not be found
	 */
	@Override
	public skills findByPrimaryKey(Serializable primaryKey)
		throws NoSuchskillsException {

		skills skills = fetchByPrimaryKey(primaryKey);

		if (skills == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchskillsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return skills;
	}

	/**
	 * Returns the skills with the primary key or throws a <code>NoSuchskillsException</code> if it could not be found.
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills
	 * @throws NoSuchskillsException if a skills with the primary key could not be found
	 */
	@Override
	public skills findByPrimaryKey(long skillId) throws NoSuchskillsException {
		return findByPrimaryKey((Serializable)skillId);
	}

	/**
	 * Returns the skills with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param skillId the primary key of the skills
	 * @return the skills, or <code>null</code> if a skills with the primary key could not be found
	 */
	@Override
	public skills fetchByPrimaryKey(long skillId) {
		return fetchByPrimaryKey((Serializable)skillId);
	}

	/**
	 * Returns all the skillses.
	 *
	 * @return the skillses
	 */
	@Override
	public List<skills> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<skills> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<skills> findAll(
		int start, int end, OrderByComparator<skills> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<skills> findAll(
		int start, int end, OrderByComparator<skills> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<skills> list = null;

		if (useFinderCache) {
			list = (List<skills>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SKILLS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SKILLS;

				sql = sql.concat(skillsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<skills>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the skillses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (skills skills : findAll()) {
			remove(skills);
		}
	}

	/**
	 * Returns the number of skillses.
	 *
	 * @return the number of skillses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SKILLS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "skillId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SKILLS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return skillsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the skills persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByskill = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByskill",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"skill"}, true);

		_finderPathWithoutPaginationFindByskill = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByskill",
			new String[] {String.class.getName()}, new String[] {"skill"},
			true);

		_finderPathCountByskill = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByskill",
			new String[] {String.class.getName()}, new String[] {"skill"},
			false);

		_setskillsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setskillsUtilPersistence(null);

		entityCache.removeCache(skillsImpl.class.getName());
	}

	private void _setskillsUtilPersistence(
		skillsPersistence skillsPersistence) {

		try {
			Field field = skillsUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, skillsPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = INTRANETPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SKILLS =
		"SELECT skills FROM skills skills";

	private static final String _SQL_SELECT_SKILLS_WHERE =
		"SELECT skills FROM skills skills WHERE ";

	private static final String _SQL_COUNT_SKILLS =
		"SELECT COUNT(skills) FROM skills skills";

	private static final String _SQL_COUNT_SKILLS_WHERE =
		"SELECT COUNT(skills) FROM skills skills WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "skills.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No skills exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No skills exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		skillsPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private skillsModelArgumentsResolver _skillsModelArgumentsResolver;

}