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

package com.esquare.intranet.project.management.service.persistence.impl;

import com.esquare.intranet.project.management.exception.NoSuchTeamMembersException;
import com.esquare.intranet.project.management.model.TeamMembers;
import com.esquare.intranet.project.management.model.TeamMembersTable;
import com.esquare.intranet.project.management.model.impl.TeamMembersImpl;
import com.esquare.intranet.project.management.model.impl.TeamMembersModelImpl;
import com.esquare.intranet.project.management.service.persistence.TeamMembersPersistence;
import com.esquare.intranet.project.management.service.persistence.TeamMembersUtil;
import com.esquare.intranet.project.management.service.persistence.impl.constants.EsquarePersistenceConstants;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
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
 * The persistence implementation for the team members service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @generated
 */
@Component(service = TeamMembersPersistence.class)
public class TeamMembersPersistenceImpl
	extends BasePersistenceImpl<TeamMembers> implements TeamMembersPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TeamMembersUtil</code> to access the team members persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TeamMembersImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the team memberses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching team memberses
	 */
	@Override
	public List<TeamMembers> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @return the range of matching team memberses
	 */
	@Override
	public List<TeamMembers> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the team memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team memberses
	 */
	@Override
	public List<TeamMembers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamMembers> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team memberses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team memberses
	 */
	@Override
	public List<TeamMembers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TeamMembers> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<TeamMembers> list = null;

		if (useFinderCache) {
			list = (List<TeamMembers>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TeamMembers teamMembers : list) {
					if (!uuid.equals(teamMembers.getUuid())) {
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

			sb.append(_SQL_SELECT_TEAMMEMBERS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TeamMembersModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<TeamMembers>)QueryUtil.list(
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
	 * Returns the first team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	@Override
	public TeamMembers findByUuid_First(
			String uuid, OrderByComparator<TeamMembers> orderByComparator)
		throws NoSuchTeamMembersException {

		TeamMembers teamMembers = fetchByUuid_First(uuid, orderByComparator);

		if (teamMembers != null) {
			return teamMembers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTeamMembersException(sb.toString());
	}

	/**
	 * Returns the first team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members, or <code>null</code> if a matching team members could not be found
	 */
	@Override
	public TeamMembers fetchByUuid_First(
		String uuid, OrderByComparator<TeamMembers> orderByComparator) {

		List<TeamMembers> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	@Override
	public TeamMembers findByUuid_Last(
			String uuid, OrderByComparator<TeamMembers> orderByComparator)
		throws NoSuchTeamMembersException {

		TeamMembers teamMembers = fetchByUuid_Last(uuid, orderByComparator);

		if (teamMembers != null) {
			return teamMembers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTeamMembersException(sb.toString());
	}

	/**
	 * Returns the last team members in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members, or <code>null</code> if a matching team members could not be found
	 */
	@Override
	public TeamMembers fetchByUuid_Last(
		String uuid, OrderByComparator<TeamMembers> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TeamMembers> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the team memberses before and after the current team members in the ordered set where uuid = &#63;.
	 *
	 * @param memberId the primary key of the current team members
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team members
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	@Override
	public TeamMembers[] findByUuid_PrevAndNext(
			long memberId, String uuid,
			OrderByComparator<TeamMembers> orderByComparator)
		throws NoSuchTeamMembersException {

		uuid = Objects.toString(uuid, "");

		TeamMembers teamMembers = findByPrimaryKey(memberId);

		Session session = null;

		try {
			session = openSession();

			TeamMembers[] array = new TeamMembersImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, teamMembers, uuid, orderByComparator, true);

			array[1] = teamMembers;

			array[2] = getByUuid_PrevAndNext(
				session, teamMembers, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TeamMembers getByUuid_PrevAndNext(
		Session session, TeamMembers teamMembers, String uuid,
		OrderByComparator<TeamMembers> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TEAMMEMBERS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
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
			sb.append(TeamMembersModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(teamMembers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TeamMembers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team memberses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TeamMembers teamMembers :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(teamMembers);
		}
	}

	/**
	 * Returns the number of team memberses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching team memberses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TEAMMEMBERS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"teamMembers.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(teamMembers.uuid IS NULL OR teamMembers.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByProjectId;
	private FinderPath _finderPathWithoutPaginationFindByProjectId;
	private FinderPath _finderPathCountByProjectId;

	/**
	 * Returns all the team memberses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching team memberses
	 */
	@Override
	public List<TeamMembers> findByProjectId(long projectId) {
		return findByProjectId(
			projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team memberses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @return the range of matching team memberses
	 */
	@Override
	public List<TeamMembers> findByProjectId(
		long projectId, int start, int end) {

		return findByProjectId(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the team memberses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching team memberses
	 */
	@Override
	public List<TeamMembers> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<TeamMembers> orderByComparator) {

		return findByProjectId(projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team memberses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching team memberses
	 */
	@Override
	public List<TeamMembers> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<TeamMembers> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProjectId;
				finderArgs = new Object[] {projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProjectId;
			finderArgs = new Object[] {
				projectId, start, end, orderByComparator
			};
		}

		List<TeamMembers> list = null;

		if (useFinderCache) {
			list = (List<TeamMembers>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TeamMembers teamMembers : list) {
					if (projectId != teamMembers.getProjectId()) {
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

			sb.append(_SQL_SELECT_TEAMMEMBERS_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TeamMembersModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

				list = (List<TeamMembers>)QueryUtil.list(
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
	 * Returns the first team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	@Override
	public TeamMembers findByProjectId_First(
			long projectId, OrderByComparator<TeamMembers> orderByComparator)
		throws NoSuchTeamMembersException {

		TeamMembers teamMembers = fetchByProjectId_First(
			projectId, orderByComparator);

		if (teamMembers != null) {
			return teamMembers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchTeamMembersException(sb.toString());
	}

	/**
	 * Returns the first team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching team members, or <code>null</code> if a matching team members could not be found
	 */
	@Override
	public TeamMembers fetchByProjectId_First(
		long projectId, OrderByComparator<TeamMembers> orderByComparator) {

		List<TeamMembers> list = findByProjectId(
			projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	@Override
	public TeamMembers findByProjectId_Last(
			long projectId, OrderByComparator<TeamMembers> orderByComparator)
		throws NoSuchTeamMembersException {

		TeamMembers teamMembers = fetchByProjectId_Last(
			projectId, orderByComparator);

		if (teamMembers != null) {
			return teamMembers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchTeamMembersException(sb.toString());
	}

	/**
	 * Returns the last team members in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching team members, or <code>null</code> if a matching team members could not be found
	 */
	@Override
	public TeamMembers fetchByProjectId_Last(
		long projectId, OrderByComparator<TeamMembers> orderByComparator) {

		int count = countByProjectId(projectId);

		if (count == 0) {
			return null;
		}

		List<TeamMembers> list = findByProjectId(
			projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the team memberses before and after the current team members in the ordered set where projectId = &#63;.
	 *
	 * @param memberId the primary key of the current team members
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next team members
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	@Override
	public TeamMembers[] findByProjectId_PrevAndNext(
			long memberId, long projectId,
			OrderByComparator<TeamMembers> orderByComparator)
		throws NoSuchTeamMembersException {

		TeamMembers teamMembers = findByPrimaryKey(memberId);

		Session session = null;

		try {
			session = openSession();

			TeamMembers[] array = new TeamMembersImpl[3];

			array[0] = getByProjectId_PrevAndNext(
				session, teamMembers, projectId, orderByComparator, true);

			array[1] = teamMembers;

			array[2] = getByProjectId_PrevAndNext(
				session, teamMembers, projectId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TeamMembers getByProjectId_PrevAndNext(
		Session session, TeamMembers teamMembers, long projectId,
		OrderByComparator<TeamMembers> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TEAMMEMBERS_WHERE);

		sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

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
			sb.append(TeamMembersModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(teamMembers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TeamMembers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the team memberses where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByProjectId(long projectId) {
		for (TeamMembers teamMembers :
				findByProjectId(
					projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(teamMembers);
		}
	}

	/**
	 * Returns the number of team memberses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching team memberses
	 */
	@Override
	public int countByProjectId(long projectId) {
		FinderPath finderPath = _finderPathCountByProjectId;

		Object[] finderArgs = new Object[] {projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TEAMMEMBERS_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

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

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 =
		"teamMembers.projectId = ?";

	private FinderPath _finderPathFetchByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns the team members where userId = &#63; or throws a <code>NoSuchTeamMembersException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching team members
	 * @throws NoSuchTeamMembersException if a matching team members could not be found
	 */
	@Override
	public TeamMembers findByUserId(long userId)
		throws NoSuchTeamMembersException {

		TeamMembers teamMembers = fetchByUserId(userId);

		if (teamMembers == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTeamMembersException(sb.toString());
		}

		return teamMembers;
	}

	/**
	 * Returns the team members where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching team members, or <code>null</code> if a matching team members could not be found
	 */
	@Override
	public TeamMembers fetchByUserId(long userId) {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the team members where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching team members, or <code>null</code> if a matching team members could not be found
	 */
	@Override
	public TeamMembers fetchByUserId(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUserId, finderArgs, this);
		}

		if (result instanceof TeamMembers) {
			TeamMembers teamMembers = (TeamMembers)result;

			if (userId != teamMembers.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TEAMMEMBERS_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<TeamMembers> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"TeamMembersPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TeamMembers teamMembers = list.get(0);

					result = teamMembers;

					cacheResult(teamMembers);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TeamMembers)result;
		}
	}

	/**
	 * Removes the team members where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the team members that was removed
	 */
	@Override
	public TeamMembers removeByUserId(long userId)
		throws NoSuchTeamMembersException {

		TeamMembers teamMembers = findByUserId(userId);

		return remove(teamMembers);
	}

	/**
	 * Returns the number of team memberses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching team memberses
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TEAMMEMBERS_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"teamMembers.userId = ?";

	public TeamMembersPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TeamMembers.class);

		setModelImplClass(TeamMembersImpl.class);
		setModelPKClass(long.class);

		setTable(TeamMembersTable.INSTANCE);
	}

	/**
	 * Caches the team members in the entity cache if it is enabled.
	 *
	 * @param teamMembers the team members
	 */
	@Override
	public void cacheResult(TeamMembers teamMembers) {
		entityCache.putResult(
			TeamMembersImpl.class, teamMembers.getPrimaryKey(), teamMembers);

		finderCache.putResult(
			_finderPathFetchByUserId, new Object[] {teamMembers.getUserId()},
			teamMembers);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the team memberses in the entity cache if it is enabled.
	 *
	 * @param teamMemberses the team memberses
	 */
	@Override
	public void cacheResult(List<TeamMembers> teamMemberses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (teamMemberses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TeamMembers teamMembers : teamMemberses) {
			if (entityCache.getResult(
					TeamMembersImpl.class, teamMembers.getPrimaryKey()) ==
						null) {

				cacheResult(teamMembers);
			}
		}
	}

	/**
	 * Clears the cache for all team memberses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TeamMembersImpl.class);

		finderCache.clearCache(TeamMembersImpl.class);
	}

	/**
	 * Clears the cache for the team members.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TeamMembers teamMembers) {
		entityCache.removeResult(TeamMembersImpl.class, teamMembers);
	}

	@Override
	public void clearCache(List<TeamMembers> teamMemberses) {
		for (TeamMembers teamMembers : teamMemberses) {
			entityCache.removeResult(TeamMembersImpl.class, teamMembers);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TeamMembersImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TeamMembersImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TeamMembersModelImpl teamMembersModelImpl) {

		Object[] args = new Object[] {teamMembersModelImpl.getUserId()};

		finderCache.putResult(_finderPathCountByUserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUserId, args, teamMembersModelImpl);
	}

	/**
	 * Creates a new team members with the primary key. Does not add the team members to the database.
	 *
	 * @param memberId the primary key for the new team members
	 * @return the new team members
	 */
	@Override
	public TeamMembers create(long memberId) {
		TeamMembers teamMembers = new TeamMembersImpl();

		teamMembers.setNew(true);
		teamMembers.setPrimaryKey(memberId);

		String uuid = _portalUUID.generate();

		teamMembers.setUuid(uuid);

		return teamMembers;
	}

	/**
	 * Removes the team members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members that was removed
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	@Override
	public TeamMembers remove(long memberId) throws NoSuchTeamMembersException {
		return remove((Serializable)memberId);
	}

	/**
	 * Removes the team members with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the team members
	 * @return the team members that was removed
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	@Override
	public TeamMembers remove(Serializable primaryKey)
		throws NoSuchTeamMembersException {

		Session session = null;

		try {
			session = openSession();

			TeamMembers teamMembers = (TeamMembers)session.get(
				TeamMembersImpl.class, primaryKey);

			if (teamMembers == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTeamMembersException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(teamMembers);
		}
		catch (NoSuchTeamMembersException noSuchEntityException) {
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
	protected TeamMembers removeImpl(TeamMembers teamMembers) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(teamMembers)) {
				teamMembers = (TeamMembers)session.get(
					TeamMembersImpl.class, teamMembers.getPrimaryKeyObj());
			}

			if (teamMembers != null) {
				session.delete(teamMembers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (teamMembers != null) {
			clearCache(teamMembers);
		}

		return teamMembers;
	}

	@Override
	public TeamMembers updateImpl(TeamMembers teamMembers) {
		boolean isNew = teamMembers.isNew();

		if (!(teamMembers instanceof TeamMembersModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(teamMembers.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(teamMembers);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in teamMembers proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TeamMembers implementation " +
					teamMembers.getClass());
		}

		TeamMembersModelImpl teamMembersModelImpl =
			(TeamMembersModelImpl)teamMembers;

		if (Validator.isNull(teamMembers.getUuid())) {
			String uuid = _portalUUID.generate();

			teamMembers.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(teamMembers);
			}
			else {
				teamMembers = (TeamMembers)session.merge(teamMembers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TeamMembersImpl.class, teamMembersModelImpl, false, true);

		cacheUniqueFindersCache(teamMembersModelImpl);

		if (isNew) {
			teamMembers.setNew(false);
		}

		teamMembers.resetOriginalValues();

		return teamMembers;
	}

	/**
	 * Returns the team members with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the team members
	 * @return the team members
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	@Override
	public TeamMembers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTeamMembersException {

		TeamMembers teamMembers = fetchByPrimaryKey(primaryKey);

		if (teamMembers == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTeamMembersException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return teamMembers;
	}

	/**
	 * Returns the team members with the primary key or throws a <code>NoSuchTeamMembersException</code> if it could not be found.
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members
	 * @throws NoSuchTeamMembersException if a team members with the primary key could not be found
	 */
	@Override
	public TeamMembers findByPrimaryKey(long memberId)
		throws NoSuchTeamMembersException {

		return findByPrimaryKey((Serializable)memberId);
	}

	/**
	 * Returns the team members with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param memberId the primary key of the team members
	 * @return the team members, or <code>null</code> if a team members with the primary key could not be found
	 */
	@Override
	public TeamMembers fetchByPrimaryKey(long memberId) {
		return fetchByPrimaryKey((Serializable)memberId);
	}

	/**
	 * Returns all the team memberses.
	 *
	 * @return the team memberses
	 */
	@Override
	public List<TeamMembers> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the team memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @return the range of team memberses
	 */
	@Override
	public List<TeamMembers> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the team memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of team memberses
	 */
	@Override
	public List<TeamMembers> findAll(
		int start, int end, OrderByComparator<TeamMembers> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the team memberses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TeamMembersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of team memberses
	 * @param end the upper bound of the range of team memberses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of team memberses
	 */
	@Override
	public List<TeamMembers> findAll(
		int start, int end, OrderByComparator<TeamMembers> orderByComparator,
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

		List<TeamMembers> list = null;

		if (useFinderCache) {
			list = (List<TeamMembers>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TEAMMEMBERS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TEAMMEMBERS;

				sql = sql.concat(TeamMembersModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TeamMembers>)QueryUtil.list(
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
	 * Removes all the team memberses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TeamMembers teamMembers : findAll()) {
			remove(teamMembers);
		}
	}

	/**
	 * Returns the number of team memberses.
	 *
	 * @return the number of team memberses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TEAMMEMBERS);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "memberId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TEAMMEMBERS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TeamMembersModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the team members persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"projectId"}, true);

		_finderPathWithoutPaginationFindByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectId",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			true);

		_finderPathCountByProjectId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectId",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			false);

		_finderPathFetchByUserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setTeamMembersUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTeamMembersUtilPersistence(null);

		entityCache.removeCache(TeamMembersImpl.class.getName());
	}

	private void _setTeamMembersUtilPersistence(
		TeamMembersPersistence teamMembersPersistence) {

		try {
			Field field = TeamMembersUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, teamMembersPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = EsquarePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = EsquarePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = EsquarePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TEAMMEMBERS =
		"SELECT teamMembers FROM TeamMembers teamMembers";

	private static final String _SQL_SELECT_TEAMMEMBERS_WHERE =
		"SELECT teamMembers FROM TeamMembers teamMembers WHERE ";

	private static final String _SQL_COUNT_TEAMMEMBERS =
		"SELECT COUNT(teamMembers) FROM TeamMembers teamMembers";

	private static final String _SQL_COUNT_TEAMMEMBERS_WHERE =
		"SELECT COUNT(teamMembers) FROM TeamMembers teamMembers WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "teamMembers.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TeamMembers exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TeamMembers exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TeamMembersPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}