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

import com.esquare.intranet.project.management.exception.NoSuchTasksException;
import com.esquare.intranet.project.management.model.Tasks;
import com.esquare.intranet.project.management.model.TasksTable;
import com.esquare.intranet.project.management.model.impl.TasksImpl;
import com.esquare.intranet.project.management.model.impl.TasksModelImpl;
import com.esquare.intranet.project.management.service.persistence.TasksPersistence;
import com.esquare.intranet.project.management.service.persistence.TasksUtil;
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
 * The persistence implementation for the tasks service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @generated
 */
@Component(service = TasksPersistence.class)
public class TasksPersistenceImpl
	extends BasePersistenceImpl<Tasks> implements TasksPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TasksUtil</code> to access the tasks persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TasksImpl.class.getName();

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
	 * Returns all the taskses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching taskses
	 */
	@Override
	public List<Tasks> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the taskses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @return the range of matching taskses
	 */
	@Override
	public List<Tasks> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the taskses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching taskses
	 */
	@Override
	public List<Tasks> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Tasks> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the taskses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching taskses
	 */
	@Override
	public List<Tasks> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Tasks> orderByComparator, boolean useFinderCache) {

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

		List<Tasks> list = null;

		if (useFinderCache) {
			list = (List<Tasks>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Tasks tasks : list) {
					if (!uuid.equals(tasks.getUuid())) {
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

			sb.append(_SQL_SELECT_TASKS_WHERE);

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
				sb.append(TasksModelImpl.ORDER_BY_JPQL);
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

				list = (List<Tasks>)QueryUtil.list(
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
	 * Returns the first tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	@Override
	public Tasks findByUuid_First(
			String uuid, OrderByComparator<Tasks> orderByComparator)
		throws NoSuchTasksException {

		Tasks tasks = fetchByUuid_First(uuid, orderByComparator);

		if (tasks != null) {
			return tasks;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTasksException(sb.toString());
	}

	/**
	 * Returns the first tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	@Override
	public Tasks fetchByUuid_First(
		String uuid, OrderByComparator<Tasks> orderByComparator) {

		List<Tasks> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	@Override
	public Tasks findByUuid_Last(
			String uuid, OrderByComparator<Tasks> orderByComparator)
		throws NoSuchTasksException {

		Tasks tasks = fetchByUuid_Last(uuid, orderByComparator);

		if (tasks != null) {
			return tasks;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTasksException(sb.toString());
	}

	/**
	 * Returns the last tasks in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	@Override
	public Tasks fetchByUuid_Last(
		String uuid, OrderByComparator<Tasks> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Tasks> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the taskses before and after the current tasks in the ordered set where uuid = &#63;.
	 *
	 * @param taskId the primary key of the current tasks
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tasks
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	@Override
	public Tasks[] findByUuid_PrevAndNext(
			long taskId, String uuid,
			OrderByComparator<Tasks> orderByComparator)
		throws NoSuchTasksException {

		uuid = Objects.toString(uuid, "");

		Tasks tasks = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			Tasks[] array = new TasksImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, tasks, uuid, orderByComparator, true);

			array[1] = tasks;

			array[2] = getByUuid_PrevAndNext(
				session, tasks, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tasks getByUuid_PrevAndNext(
		Session session, Tasks tasks, String uuid,
		OrderByComparator<Tasks> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TASKS_WHERE);

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
			sb.append(TasksModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tasks)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Tasks> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the taskses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Tasks tasks :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tasks);
		}
	}

	/**
	 * Returns the number of taskses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching taskses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TASKS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "tasks.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(tasks.uuid IS NULL OR tasks.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByProjectId;
	private FinderPath _finderPathWithoutPaginationFindByProjectId;
	private FinderPath _finderPathCountByProjectId;

	/**
	 * Returns all the taskses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching taskses
	 */
	@Override
	public List<Tasks> findByProjectId(long projectId) {
		return findByProjectId(
			projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the taskses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @return the range of matching taskses
	 */
	@Override
	public List<Tasks> findByProjectId(long projectId, int start, int end) {
		return findByProjectId(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the taskses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching taskses
	 */
	@Override
	public List<Tasks> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<Tasks> orderByComparator) {

		return findByProjectId(projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the taskses where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching taskses
	 */
	@Override
	public List<Tasks> findByProjectId(
		long projectId, int start, int end,
		OrderByComparator<Tasks> orderByComparator, boolean useFinderCache) {

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

		List<Tasks> list = null;

		if (useFinderCache) {
			list = (List<Tasks>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Tasks tasks : list) {
					if (projectId != tasks.getProjectId()) {
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

			sb.append(_SQL_SELECT_TASKS_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TasksModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

				list = (List<Tasks>)QueryUtil.list(
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
	 * Returns the first tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	@Override
	public Tasks findByProjectId_First(
			long projectId, OrderByComparator<Tasks> orderByComparator)
		throws NoSuchTasksException {

		Tasks tasks = fetchByProjectId_First(projectId, orderByComparator);

		if (tasks != null) {
			return tasks;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchTasksException(sb.toString());
	}

	/**
	 * Returns the first tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	@Override
	public Tasks fetchByProjectId_First(
		long projectId, OrderByComparator<Tasks> orderByComparator) {

		List<Tasks> list = findByProjectId(projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks
	 * @throws NoSuchTasksException if a matching tasks could not be found
	 */
	@Override
	public Tasks findByProjectId_Last(
			long projectId, OrderByComparator<Tasks> orderByComparator)
		throws NoSuchTasksException {

		Tasks tasks = fetchByProjectId_Last(projectId, orderByComparator);

		if (tasks != null) {
			return tasks;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchTasksException(sb.toString());
	}

	/**
	 * Returns the last tasks in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tasks, or <code>null</code> if a matching tasks could not be found
	 */
	@Override
	public Tasks fetchByProjectId_Last(
		long projectId, OrderByComparator<Tasks> orderByComparator) {

		int count = countByProjectId(projectId);

		if (count == 0) {
			return null;
		}

		List<Tasks> list = findByProjectId(
			projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the taskses before and after the current tasks in the ordered set where projectId = &#63;.
	 *
	 * @param taskId the primary key of the current tasks
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tasks
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	@Override
	public Tasks[] findByProjectId_PrevAndNext(
			long taskId, long projectId,
			OrderByComparator<Tasks> orderByComparator)
		throws NoSuchTasksException {

		Tasks tasks = findByPrimaryKey(taskId);

		Session session = null;

		try {
			session = openSession();

			Tasks[] array = new TasksImpl[3];

			array[0] = getByProjectId_PrevAndNext(
				session, tasks, projectId, orderByComparator, true);

			array[1] = tasks;

			array[2] = getByProjectId_PrevAndNext(
				session, tasks, projectId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tasks getByProjectId_PrevAndNext(
		Session session, Tasks tasks, long projectId,
		OrderByComparator<Tasks> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TASKS_WHERE);

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
			sb.append(TasksModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tasks)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Tasks> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the taskses where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByProjectId(long projectId) {
		for (Tasks tasks :
				findByProjectId(
					projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tasks);
		}
	}

	/**
	 * Returns the number of taskses where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching taskses
	 */
	@Override
	public int countByProjectId(long projectId) {
		FinderPath finderPath = _finderPathCountByProjectId;

		Object[] finderArgs = new Object[] {projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TASKS_WHERE);

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
		"tasks.projectId = ?";

	public TasksPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Tasks.class);

		setModelImplClass(TasksImpl.class);
		setModelPKClass(long.class);

		setTable(TasksTable.INSTANCE);
	}

	/**
	 * Caches the tasks in the entity cache if it is enabled.
	 *
	 * @param tasks the tasks
	 */
	@Override
	public void cacheResult(Tasks tasks) {
		entityCache.putResult(TasksImpl.class, tasks.getPrimaryKey(), tasks);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the taskses in the entity cache if it is enabled.
	 *
	 * @param taskses the taskses
	 */
	@Override
	public void cacheResult(List<Tasks> taskses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (taskses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Tasks tasks : taskses) {
			if (entityCache.getResult(TasksImpl.class, tasks.getPrimaryKey()) ==
					null) {

				cacheResult(tasks);
			}
		}
	}

	/**
	 * Clears the cache for all taskses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TasksImpl.class);

		finderCache.clearCache(TasksImpl.class);
	}

	/**
	 * Clears the cache for the tasks.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tasks tasks) {
		entityCache.removeResult(TasksImpl.class, tasks);
	}

	@Override
	public void clearCache(List<Tasks> taskses) {
		for (Tasks tasks : taskses) {
			entityCache.removeResult(TasksImpl.class, tasks);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TasksImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TasksImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new tasks with the primary key. Does not add the tasks to the database.
	 *
	 * @param taskId the primary key for the new tasks
	 * @return the new tasks
	 */
	@Override
	public Tasks create(long taskId) {
		Tasks tasks = new TasksImpl();

		tasks.setNew(true);
		tasks.setPrimaryKey(taskId);

		String uuid = _portalUUID.generate();

		tasks.setUuid(uuid);

		return tasks;
	}

	/**
	 * Removes the tasks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks that was removed
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	@Override
	public Tasks remove(long taskId) throws NoSuchTasksException {
		return remove((Serializable)taskId);
	}

	/**
	 * Removes the tasks with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tasks
	 * @return the tasks that was removed
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	@Override
	public Tasks remove(Serializable primaryKey) throws NoSuchTasksException {
		Session session = null;

		try {
			session = openSession();

			Tasks tasks = (Tasks)session.get(TasksImpl.class, primaryKey);

			if (tasks == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTasksException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tasks);
		}
		catch (NoSuchTasksException noSuchEntityException) {
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
	protected Tasks removeImpl(Tasks tasks) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tasks)) {
				tasks = (Tasks)session.get(
					TasksImpl.class, tasks.getPrimaryKeyObj());
			}

			if (tasks != null) {
				session.delete(tasks);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tasks != null) {
			clearCache(tasks);
		}

		return tasks;
	}

	@Override
	public Tasks updateImpl(Tasks tasks) {
		boolean isNew = tasks.isNew();

		if (!(tasks instanceof TasksModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tasks.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tasks);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tasks proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Tasks implementation " +
					tasks.getClass());
		}

		TasksModelImpl tasksModelImpl = (TasksModelImpl)tasks;

		if (Validator.isNull(tasks.getUuid())) {
			String uuid = _portalUUID.generate();

			tasks.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tasks);
			}
			else {
				tasks = (Tasks)session.merge(tasks);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(TasksImpl.class, tasksModelImpl, false, true);

		if (isNew) {
			tasks.setNew(false);
		}

		tasks.resetOriginalValues();

		return tasks;
	}

	/**
	 * Returns the tasks with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tasks
	 * @return the tasks
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	@Override
	public Tasks findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTasksException {

		Tasks tasks = fetchByPrimaryKey(primaryKey);

		if (tasks == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTasksException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tasks;
	}

	/**
	 * Returns the tasks with the primary key or throws a <code>NoSuchTasksException</code> if it could not be found.
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks
	 * @throws NoSuchTasksException if a tasks with the primary key could not be found
	 */
	@Override
	public Tasks findByPrimaryKey(long taskId) throws NoSuchTasksException {
		return findByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns the tasks with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskId the primary key of the tasks
	 * @return the tasks, or <code>null</code> if a tasks with the primary key could not be found
	 */
	@Override
	public Tasks fetchByPrimaryKey(long taskId) {
		return fetchByPrimaryKey((Serializable)taskId);
	}

	/**
	 * Returns all the taskses.
	 *
	 * @return the taskses
	 */
	@Override
	public List<Tasks> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the taskses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @return the range of taskses
	 */
	@Override
	public List<Tasks> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the taskses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of taskses
	 */
	@Override
	public List<Tasks> findAll(
		int start, int end, OrderByComparator<Tasks> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the taskses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TasksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of taskses
	 * @param end the upper bound of the range of taskses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of taskses
	 */
	@Override
	public List<Tasks> findAll(
		int start, int end, OrderByComparator<Tasks> orderByComparator,
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

		List<Tasks> list = null;

		if (useFinderCache) {
			list = (List<Tasks>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TASKS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TASKS;

				sql = sql.concat(TasksModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Tasks>)QueryUtil.list(
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
	 * Removes all the taskses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Tasks tasks : findAll()) {
			remove(tasks);
		}
	}

	/**
	 * Returns the number of taskses.
	 *
	 * @return the number of taskses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TASKS);

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
		return "taskId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TASKS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TasksModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tasks persistence.
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

		_setTasksUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTasksUtilPersistence(null);

		entityCache.removeCache(TasksImpl.class.getName());
	}

	private void _setTasksUtilPersistence(TasksPersistence tasksPersistence) {
		try {
			Field field = TasksUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, tasksPersistence);
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

	private static final String _SQL_SELECT_TASKS =
		"SELECT tasks FROM Tasks tasks";

	private static final String _SQL_SELECT_TASKS_WHERE =
		"SELECT tasks FROM Tasks tasks WHERE ";

	private static final String _SQL_COUNT_TASKS =
		"SELECT COUNT(tasks) FROM Tasks tasks";

	private static final String _SQL_COUNT_TASKS_WHERE =
		"SELECT COUNT(tasks) FROM Tasks tasks WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tasks.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Tasks exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Tasks exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TasksPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}