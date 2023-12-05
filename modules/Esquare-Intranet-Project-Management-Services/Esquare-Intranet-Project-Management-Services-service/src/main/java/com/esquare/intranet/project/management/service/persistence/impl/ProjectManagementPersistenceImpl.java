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

import com.esquare.intranet.project.management.exception.NoSuchProjectManagementException;
import com.esquare.intranet.project.management.model.ProjectManagement;
import com.esquare.intranet.project.management.model.ProjectManagementTable;
import com.esquare.intranet.project.management.model.impl.ProjectManagementImpl;
import com.esquare.intranet.project.management.model.impl.ProjectManagementModelImpl;
import com.esquare.intranet.project.management.service.persistence.ProjectManagementPersistence;
import com.esquare.intranet.project.management.service.persistence.ProjectManagementUtil;
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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the project management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @generated
 */
@Component(service = ProjectManagementPersistence.class)
public class ProjectManagementPersistenceImpl
	extends BasePersistenceImpl<ProjectManagement>
	implements ProjectManagementPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProjectManagementUtil</code> to access the project management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProjectManagementImpl.class.getName();

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
	 * Returns all the project managements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project managements
	 */
	@Override
	public List<ProjectManagement> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project managements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @return the range of matching project managements
	 */
	@Override
	public List<ProjectManagement> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project managements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project managements
	 */
	@Override
	public List<ProjectManagement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectManagement> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project managements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project managements
	 */
	@Override
	public List<ProjectManagement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectManagement> orderByComparator,
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

		List<ProjectManagement> list = null;

		if (useFinderCache) {
			list = (List<ProjectManagement>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectManagement projectManagement : list) {
					if (!uuid.equals(projectManagement.getUuid())) {
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

			sb.append(_SQL_SELECT_PROJECTMANAGEMENT_WHERE);

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
				sb.append(ProjectManagementModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProjectManagement>)QueryUtil.list(
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
	 * Returns the first project management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project management
	 * @throws NoSuchProjectManagementException if a matching project management could not be found
	 */
	@Override
	public ProjectManagement findByUuid_First(
			String uuid, OrderByComparator<ProjectManagement> orderByComparator)
		throws NoSuchProjectManagementException {

		ProjectManagement projectManagement = fetchByUuid_First(
			uuid, orderByComparator);

		if (projectManagement != null) {
			return projectManagement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProjectManagementException(sb.toString());
	}

	/**
	 * Returns the first project management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project management, or <code>null</code> if a matching project management could not be found
	 */
	@Override
	public ProjectManagement fetchByUuid_First(
		String uuid, OrderByComparator<ProjectManagement> orderByComparator) {

		List<ProjectManagement> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project management
	 * @throws NoSuchProjectManagementException if a matching project management could not be found
	 */
	@Override
	public ProjectManagement findByUuid_Last(
			String uuid, OrderByComparator<ProjectManagement> orderByComparator)
		throws NoSuchProjectManagementException {

		ProjectManagement projectManagement = fetchByUuid_Last(
			uuid, orderByComparator);

		if (projectManagement != null) {
			return projectManagement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProjectManagementException(sb.toString());
	}

	/**
	 * Returns the last project management in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project management, or <code>null</code> if a matching project management could not be found
	 */
	@Override
	public ProjectManagement fetchByUuid_Last(
		String uuid, OrderByComparator<ProjectManagement> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectManagement> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project managements before and after the current project management in the ordered set where uuid = &#63;.
	 *
	 * @param projectMgmtId the primary key of the current project management
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project management
	 * @throws NoSuchProjectManagementException if a project management with the primary key could not be found
	 */
	@Override
	public ProjectManagement[] findByUuid_PrevAndNext(
			long projectMgmtId, String uuid,
			OrderByComparator<ProjectManagement> orderByComparator)
		throws NoSuchProjectManagementException {

		uuid = Objects.toString(uuid, "");

		ProjectManagement projectManagement = findByPrimaryKey(projectMgmtId);

		Session session = null;

		try {
			session = openSession();

			ProjectManagement[] array = new ProjectManagementImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, projectManagement, uuid, orderByComparator, true);

			array[1] = projectManagement;

			array[2] = getByUuid_PrevAndNext(
				session, projectManagement, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectManagement getByUuid_PrevAndNext(
		Session session, ProjectManagement projectManagement, String uuid,
		OrderByComparator<ProjectManagement> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROJECTMANAGEMENT_WHERE);

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
			sb.append(ProjectManagementModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						projectManagement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectManagement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project managements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectManagement projectManagement :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projectManagement);
		}
	}

	/**
	 * Returns the number of project managements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project managements
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTMANAGEMENT_WHERE);

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
		"projectManagement.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(projectManagement.uuid IS NULL OR projectManagement.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the project management where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectManagementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project management
	 * @throws NoSuchProjectManagementException if a matching project management could not be found
	 */
	@Override
	public ProjectManagement findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectManagementException {

		ProjectManagement projectManagement = fetchByUUID_G(uuid, groupId);

		if (projectManagement == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProjectManagementException(sb.toString());
		}

		return projectManagement;
	}

	/**
	 * Returns the project management where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project management, or <code>null</code> if a matching project management could not be found
	 */
	@Override
	public ProjectManagement fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the project management where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project management, or <code>null</code> if a matching project management could not be found
	 */
	@Override
	public ProjectManagement fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof ProjectManagement) {
			ProjectManagement projectManagement = (ProjectManagement)result;

			if (!Objects.equals(uuid, projectManagement.getUuid()) ||
				(groupId != projectManagement.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROJECTMANAGEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<ProjectManagement> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProjectManagement projectManagement = list.get(0);

					result = projectManagement;

					cacheResult(projectManagement);
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
			return (ProjectManagement)result;
		}
	}

	/**
	 * Removes the project management where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project management that was removed
	 */
	@Override
	public ProjectManagement removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectManagementException {

		ProjectManagement projectManagement = findByUUID_G(uuid, groupId);

		return remove(projectManagement);
	}

	/**
	 * Returns the number of project managements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project managements
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTMANAGEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"projectManagement.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(projectManagement.uuid IS NULL OR projectManagement.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"projectManagement.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the project managements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project managements
	 */
	@Override
	public List<ProjectManagement> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project managements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @return the range of matching project managements
	 */
	@Override
	public List<ProjectManagement> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project managements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project managements
	 */
	@Override
	public List<ProjectManagement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectManagement> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project managements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project managements
	 */
	@Override
	public List<ProjectManagement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectManagement> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ProjectManagement> list = null;

		if (useFinderCache) {
			list = (List<ProjectManagement>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectManagement projectManagement : list) {
					if (!uuid.equals(projectManagement.getUuid()) ||
						(companyId != projectManagement.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PROJECTMANAGEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectManagementModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<ProjectManagement>)QueryUtil.list(
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
	 * Returns the first project management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project management
	 * @throws NoSuchProjectManagementException if a matching project management could not be found
	 */
	@Override
	public ProjectManagement findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProjectManagement> orderByComparator)
		throws NoSuchProjectManagementException {

		ProjectManagement projectManagement = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (projectManagement != null) {
			return projectManagement;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProjectManagementException(sb.toString());
	}

	/**
	 * Returns the first project management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project management, or <code>null</code> if a matching project management could not be found
	 */
	@Override
	public ProjectManagement fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProjectManagement> orderByComparator) {

		List<ProjectManagement> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project management
	 * @throws NoSuchProjectManagementException if a matching project management could not be found
	 */
	@Override
	public ProjectManagement findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProjectManagement> orderByComparator)
		throws NoSuchProjectManagementException {

		ProjectManagement projectManagement = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (projectManagement != null) {
			return projectManagement;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProjectManagementException(sb.toString());
	}

	/**
	 * Returns the last project management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project management, or <code>null</code> if a matching project management could not be found
	 */
	@Override
	public ProjectManagement fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProjectManagement> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProjectManagement> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project managements before and after the current project management in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectMgmtId the primary key of the current project management
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project management
	 * @throws NoSuchProjectManagementException if a project management with the primary key could not be found
	 */
	@Override
	public ProjectManagement[] findByUuid_C_PrevAndNext(
			long projectMgmtId, String uuid, long companyId,
			OrderByComparator<ProjectManagement> orderByComparator)
		throws NoSuchProjectManagementException {

		uuid = Objects.toString(uuid, "");

		ProjectManagement projectManagement = findByPrimaryKey(projectMgmtId);

		Session session = null;

		try {
			session = openSession();

			ProjectManagement[] array = new ProjectManagementImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, projectManagement, uuid, companyId, orderByComparator,
				true);

			array[1] = projectManagement;

			array[2] = getByUuid_C_PrevAndNext(
				session, projectManagement, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectManagement getByUuid_C_PrevAndNext(
		Session session, ProjectManagement projectManagement, String uuid,
		long companyId, OrderByComparator<ProjectManagement> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROJECTMANAGEMENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(ProjectManagementModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						projectManagement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectManagement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project managements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProjectManagement projectManagement :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(projectManagement);
		}
	}

	/**
	 * Returns the number of project managements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project managements
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTMANAGEMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"projectManagement.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(projectManagement.uuid IS NULL OR projectManagement.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"projectManagement.companyId = ?";

	public ProjectManagementPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProjectManagement.class);

		setModelImplClass(ProjectManagementImpl.class);
		setModelPKClass(long.class);

		setTable(ProjectManagementTable.INSTANCE);
	}

	/**
	 * Caches the project management in the entity cache if it is enabled.
	 *
	 * @param projectManagement the project management
	 */
	@Override
	public void cacheResult(ProjectManagement projectManagement) {
		entityCache.putResult(
			ProjectManagementImpl.class, projectManagement.getPrimaryKey(),
			projectManagement);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				projectManagement.getUuid(), projectManagement.getGroupId()
			},
			projectManagement);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the project managements in the entity cache if it is enabled.
	 *
	 * @param projectManagements the project managements
	 */
	@Override
	public void cacheResult(List<ProjectManagement> projectManagements) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (projectManagements.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProjectManagement projectManagement : projectManagements) {
			if (entityCache.getResult(
					ProjectManagementImpl.class,
					projectManagement.getPrimaryKey()) == null) {

				cacheResult(projectManagement);
			}
		}
	}

	/**
	 * Clears the cache for all project managements.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectManagementImpl.class);

		finderCache.clearCache(ProjectManagementImpl.class);
	}

	/**
	 * Clears the cache for the project management.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectManagement projectManagement) {
		entityCache.removeResult(
			ProjectManagementImpl.class, projectManagement);
	}

	@Override
	public void clearCache(List<ProjectManagement> projectManagements) {
		for (ProjectManagement projectManagement : projectManagements) {
			entityCache.removeResult(
				ProjectManagementImpl.class, projectManagement);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProjectManagementImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProjectManagementImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectManagementModelImpl projectManagementModelImpl) {

		Object[] args = new Object[] {
			projectManagementModelImpl.getUuid(),
			projectManagementModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, projectManagementModelImpl);
	}

	/**
	 * Creates a new project management with the primary key. Does not add the project management to the database.
	 *
	 * @param projectMgmtId the primary key for the new project management
	 * @return the new project management
	 */
	@Override
	public ProjectManagement create(long projectMgmtId) {
		ProjectManagement projectManagement = new ProjectManagementImpl();

		projectManagement.setNew(true);
		projectManagement.setPrimaryKey(projectMgmtId);

		String uuid = _portalUUID.generate();

		projectManagement.setUuid(uuid);

		projectManagement.setCompanyId(CompanyThreadLocal.getCompanyId());

		return projectManagement;
	}

	/**
	 * Removes the project management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectMgmtId the primary key of the project management
	 * @return the project management that was removed
	 * @throws NoSuchProjectManagementException if a project management with the primary key could not be found
	 */
	@Override
	public ProjectManagement remove(long projectMgmtId)
		throws NoSuchProjectManagementException {

		return remove((Serializable)projectMgmtId);
	}

	/**
	 * Removes the project management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project management
	 * @return the project management that was removed
	 * @throws NoSuchProjectManagementException if a project management with the primary key could not be found
	 */
	@Override
	public ProjectManagement remove(Serializable primaryKey)
		throws NoSuchProjectManagementException {

		Session session = null;

		try {
			session = openSession();

			ProjectManagement projectManagement =
				(ProjectManagement)session.get(
					ProjectManagementImpl.class, primaryKey);

			if (projectManagement == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectManagementException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(projectManagement);
		}
		catch (NoSuchProjectManagementException noSuchEntityException) {
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
	protected ProjectManagement removeImpl(
		ProjectManagement projectManagement) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectManagement)) {
				projectManagement = (ProjectManagement)session.get(
					ProjectManagementImpl.class,
					projectManagement.getPrimaryKeyObj());
			}

			if (projectManagement != null) {
				session.delete(projectManagement);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (projectManagement != null) {
			clearCache(projectManagement);
		}

		return projectManagement;
	}

	@Override
	public ProjectManagement updateImpl(ProjectManagement projectManagement) {
		boolean isNew = projectManagement.isNew();

		if (!(projectManagement instanceof ProjectManagementModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectManagement.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					projectManagement);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectManagement proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectManagement implementation " +
					projectManagement.getClass());
		}

		ProjectManagementModelImpl projectManagementModelImpl =
			(ProjectManagementModelImpl)projectManagement;

		if (Validator.isNull(projectManagement.getUuid())) {
			String uuid = _portalUUID.generate();

			projectManagement.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(projectManagement);
			}
			else {
				projectManagement = (ProjectManagement)session.merge(
					projectManagement);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProjectManagementImpl.class, projectManagementModelImpl, false,
			true);

		cacheUniqueFindersCache(projectManagementModelImpl);

		if (isNew) {
			projectManagement.setNew(false);
		}

		projectManagement.resetOriginalValues();

		return projectManagement;
	}

	/**
	 * Returns the project management with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project management
	 * @return the project management
	 * @throws NoSuchProjectManagementException if a project management with the primary key could not be found
	 */
	@Override
	public ProjectManagement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectManagementException {

		ProjectManagement projectManagement = fetchByPrimaryKey(primaryKey);

		if (projectManagement == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectManagementException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return projectManagement;
	}

	/**
	 * Returns the project management with the primary key or throws a <code>NoSuchProjectManagementException</code> if it could not be found.
	 *
	 * @param projectMgmtId the primary key of the project management
	 * @return the project management
	 * @throws NoSuchProjectManagementException if a project management with the primary key could not be found
	 */
	@Override
	public ProjectManagement findByPrimaryKey(long projectMgmtId)
		throws NoSuchProjectManagementException {

		return findByPrimaryKey((Serializable)projectMgmtId);
	}

	/**
	 * Returns the project management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectMgmtId the primary key of the project management
	 * @return the project management, or <code>null</code> if a project management with the primary key could not be found
	 */
	@Override
	public ProjectManagement fetchByPrimaryKey(long projectMgmtId) {
		return fetchByPrimaryKey((Serializable)projectMgmtId);
	}

	/**
	 * Returns all the project managements.
	 *
	 * @return the project managements
	 */
	@Override
	public List<ProjectManagement> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @return the range of project managements
	 */
	@Override
	public List<ProjectManagement> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project managements
	 */
	@Override
	public List<ProjectManagement> findAll(
		int start, int end,
		OrderByComparator<ProjectManagement> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectManagementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project managements
	 * @param end the upper bound of the range of project managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project managements
	 */
	@Override
	public List<ProjectManagement> findAll(
		int start, int end,
		OrderByComparator<ProjectManagement> orderByComparator,
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

		List<ProjectManagement> list = null;

		if (useFinderCache) {
			list = (List<ProjectManagement>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROJECTMANAGEMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTMANAGEMENT;

				sql = sql.concat(ProjectManagementModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProjectManagement>)QueryUtil.list(
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
	 * Removes all the project managements from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectManagement projectManagement : findAll()) {
			remove(projectManagement);
		}
	}

	/**
	 * Returns the number of project managements.
	 *
	 * @return the number of project managements
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROJECTMANAGEMENT);

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
		return "projectMgmtId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROJECTMANAGEMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProjectManagementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project management persistence.
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

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_setProjectManagementUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProjectManagementUtilPersistence(null);

		entityCache.removeCache(ProjectManagementImpl.class.getName());
	}

	private void _setProjectManagementUtilPersistence(
		ProjectManagementPersistence projectManagementPersistence) {

		try {
			Field field = ProjectManagementUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, projectManagementPersistence);
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

	private static final String _SQL_SELECT_PROJECTMANAGEMENT =
		"SELECT projectManagement FROM ProjectManagement projectManagement";

	private static final String _SQL_SELECT_PROJECTMANAGEMENT_WHERE =
		"SELECT projectManagement FROM ProjectManagement projectManagement WHERE ";

	private static final String _SQL_COUNT_PROJECTMANAGEMENT =
		"SELECT COUNT(projectManagement) FROM ProjectManagement projectManagement";

	private static final String _SQL_COUNT_PROJECTMANAGEMENT_WHERE =
		"SELECT COUNT(projectManagement) FROM ProjectManagement projectManagement WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "projectManagement.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProjectManagement exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProjectManagement exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProjectManagementPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}