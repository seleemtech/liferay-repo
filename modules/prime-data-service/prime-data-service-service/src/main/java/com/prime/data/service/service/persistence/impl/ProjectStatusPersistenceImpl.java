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

package com.prime.data.service.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.prime.data.service.exception.NoSuchProjectStatusException;
import com.prime.data.service.model.ProjectStatus;
import com.prime.data.service.model.ProjectStatusTable;
import com.prime.data.service.model.impl.ProjectStatusImpl;
import com.prime.data.service.model.impl.ProjectStatusModelImpl;
import com.prime.data.service.service.persistence.ProjectStatusPersistence;
import com.prime.data.service.service.persistence.ProjectStatusUtil;
import com.prime.data.service.service.persistence.impl.constants.PRIMEPersistenceConstants;

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
 * The persistence implementation for the project status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {ProjectStatusPersistence.class, BasePersistence.class})
public class ProjectStatusPersistenceImpl
	extends BasePersistenceImpl<ProjectStatus>
	implements ProjectStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProjectStatusUtil</code> to access the project status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProjectStatusImpl.class.getName();

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
	 * Returns all the project statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project statuses
	 */
	@Override
	public List<ProjectStatus> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @return the range of matching project statuses
	 */
	@Override
	public List<ProjectStatus> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the project statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project statuses
	 */
	@Override
	public List<ProjectStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project statuses
	 */
	@Override
	public List<ProjectStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator,
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

		List<ProjectStatus> list = null;

		if (useFinderCache) {
			list = (List<ProjectStatus>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectStatus projectStatus : list) {
					if (!uuid.equals(projectStatus.getUuid())) {
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

			sb.append(_SQL_SELECT_PROJECTSTATUS_WHERE);

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
				sb.append(ProjectStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProjectStatus>)QueryUtil.list(
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
	 * Returns the first project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project status
	 * @throws NoSuchProjectStatusException if a matching project status could not be found
	 */
	@Override
	public ProjectStatus findByUuid_First(
			String uuid, OrderByComparator<ProjectStatus> orderByComparator)
		throws NoSuchProjectStatusException {

		ProjectStatus projectStatus = fetchByUuid_First(
			uuid, orderByComparator);

		if (projectStatus != null) {
			return projectStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProjectStatusException(sb.toString());
	}

	/**
	 * Returns the first project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project status, or <code>null</code> if a matching project status could not be found
	 */
	@Override
	public ProjectStatus fetchByUuid_First(
		String uuid, OrderByComparator<ProjectStatus> orderByComparator) {

		List<ProjectStatus> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project status
	 * @throws NoSuchProjectStatusException if a matching project status could not be found
	 */
	@Override
	public ProjectStatus findByUuid_Last(
			String uuid, OrderByComparator<ProjectStatus> orderByComparator)
		throws NoSuchProjectStatusException {

		ProjectStatus projectStatus = fetchByUuid_Last(uuid, orderByComparator);

		if (projectStatus != null) {
			return projectStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProjectStatusException(sb.toString());
	}

	/**
	 * Returns the last project status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project status, or <code>null</code> if a matching project status could not be found
	 */
	@Override
	public ProjectStatus fetchByUuid_Last(
		String uuid, OrderByComparator<ProjectStatus> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectStatus> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the project statuses before and after the current project status in the ordered set where uuid = &#63;.
	 *
	 * @param projectStatusId the primary key of the current project status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project status
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus[] findByUuid_PrevAndNext(
			long projectStatusId, String uuid,
			OrderByComparator<ProjectStatus> orderByComparator)
		throws NoSuchProjectStatusException {

		uuid = Objects.toString(uuid, "");

		ProjectStatus projectStatus = findByPrimaryKey(projectStatusId);

		Session session = null;

		try {
			session = openSession();

			ProjectStatus[] array = new ProjectStatusImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, projectStatus, uuid, orderByComparator, true);

			array[1] = projectStatus;

			array[2] = getByUuid_PrevAndNext(
				session, projectStatus, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectStatus getByUuid_PrevAndNext(
		Session session, ProjectStatus projectStatus, String uuid,
		OrderByComparator<ProjectStatus> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROJECTSTATUS_WHERE);

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
			sb.append(ProjectStatusModelImpl.ORDER_BY_JPQL);
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
						projectStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectStatus projectStatus :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projectStatus);
		}
	}

	/**
	 * Returns the number of project statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project statuses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTSTATUS_WHERE);

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
		"projectStatus.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(projectStatus.uuid IS NULL OR projectStatus.uuid = '')";

	public ProjectStatusPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProjectStatus.class);

		setModelImplClass(ProjectStatusImpl.class);
		setModelPKClass(long.class);

		setTable(ProjectStatusTable.INSTANCE);
	}

	/**
	 * Caches the project status in the entity cache if it is enabled.
	 *
	 * @param projectStatus the project status
	 */
	@Override
	public void cacheResult(ProjectStatus projectStatus) {
		entityCache.putResult(
			ProjectStatusImpl.class, projectStatus.getPrimaryKey(),
			projectStatus);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the project statuses in the entity cache if it is enabled.
	 *
	 * @param projectStatuses the project statuses
	 */
	@Override
	public void cacheResult(List<ProjectStatus> projectStatuses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (projectStatuses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProjectStatus projectStatus : projectStatuses) {
			if (entityCache.getResult(
					ProjectStatusImpl.class, projectStatus.getPrimaryKey()) ==
						null) {

				cacheResult(projectStatus);
			}
		}
	}

	/**
	 * Clears the cache for all project statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectStatusImpl.class);

		finderCache.clearCache(ProjectStatusImpl.class);
	}

	/**
	 * Clears the cache for the project status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectStatus projectStatus) {
		entityCache.removeResult(ProjectStatusImpl.class, projectStatus);
	}

	@Override
	public void clearCache(List<ProjectStatus> projectStatuses) {
		for (ProjectStatus projectStatus : projectStatuses) {
			entityCache.removeResult(ProjectStatusImpl.class, projectStatus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProjectStatusImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProjectStatusImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new project status with the primary key. Does not add the project status to the database.
	 *
	 * @param projectStatusId the primary key for the new project status
	 * @return the new project status
	 */
	@Override
	public ProjectStatus create(long projectStatusId) {
		ProjectStatus projectStatus = new ProjectStatusImpl();

		projectStatus.setNew(true);
		projectStatus.setPrimaryKey(projectStatusId);

		String uuid = PortalUUIDUtil.generate();

		projectStatus.setUuid(uuid);

		return projectStatus;
	}

	/**
	 * Removes the project status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status that was removed
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus remove(long projectStatusId)
		throws NoSuchProjectStatusException {

		return remove((Serializable)projectStatusId);
	}

	/**
	 * Removes the project status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project status
	 * @return the project status that was removed
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus remove(Serializable primaryKey)
		throws NoSuchProjectStatusException {

		Session session = null;

		try {
			session = openSession();

			ProjectStatus projectStatus = (ProjectStatus)session.get(
				ProjectStatusImpl.class, primaryKey);

			if (projectStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(projectStatus);
		}
		catch (NoSuchProjectStatusException noSuchEntityException) {
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
	protected ProjectStatus removeImpl(ProjectStatus projectStatus) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectStatus)) {
				projectStatus = (ProjectStatus)session.get(
					ProjectStatusImpl.class, projectStatus.getPrimaryKeyObj());
			}

			if (projectStatus != null) {
				session.delete(projectStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (projectStatus != null) {
			clearCache(projectStatus);
		}

		return projectStatus;
	}

	@Override
	public ProjectStatus updateImpl(ProjectStatus projectStatus) {
		boolean isNew = projectStatus.isNew();

		if (!(projectStatus instanceof ProjectStatusModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					projectStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectStatus implementation " +
					projectStatus.getClass());
		}

		ProjectStatusModelImpl projectStatusModelImpl =
			(ProjectStatusModelImpl)projectStatus;

		if (Validator.isNull(projectStatus.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectStatus.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(projectStatus);
			}
			else {
				projectStatus = (ProjectStatus)session.merge(projectStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProjectStatusImpl.class, projectStatusModelImpl, false, true);

		if (isNew) {
			projectStatus.setNew(false);
		}

		projectStatus.resetOriginalValues();

		return projectStatus;
	}

	/**
	 * Returns the project status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project status
	 * @return the project status
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectStatusException {

		ProjectStatus projectStatus = fetchByPrimaryKey(primaryKey);

		if (projectStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return projectStatus;
	}

	/**
	 * Returns the project status with the primary key or throws a <code>NoSuchProjectStatusException</code> if it could not be found.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status
	 * @throws NoSuchProjectStatusException if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus findByPrimaryKey(long projectStatusId)
		throws NoSuchProjectStatusException {

		return findByPrimaryKey((Serializable)projectStatusId);
	}

	/**
	 * Returns the project status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectStatusId the primary key of the project status
	 * @return the project status, or <code>null</code> if a project status with the primary key could not be found
	 */
	@Override
	public ProjectStatus fetchByPrimaryKey(long projectStatusId) {
		return fetchByPrimaryKey((Serializable)projectStatusId);
	}

	/**
	 * Returns all the project statuses.
	 *
	 * @return the project statuses
	 */
	@Override
	public List<ProjectStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @return the range of project statuses
	 */
	@Override
	public List<ProjectStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project statuses
	 */
	@Override
	public List<ProjectStatus> findAll(
		int start, int end,
		OrderByComparator<ProjectStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the project statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project statuses
	 * @param end the upper bound of the range of project statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project statuses
	 */
	@Override
	public List<ProjectStatus> findAll(
		int start, int end, OrderByComparator<ProjectStatus> orderByComparator,
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

		List<ProjectStatus> list = null;

		if (useFinderCache) {
			list = (List<ProjectStatus>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROJECTSTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTSTATUS;

				sql = sql.concat(ProjectStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProjectStatus>)QueryUtil.list(
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
	 * Removes all the project statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectStatus projectStatus : findAll()) {
			remove(projectStatus);
		}
	}

	/**
	 * Returns the number of project statuses.
	 *
	 * @return the number of project statuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROJECTSTATUS);

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
		return "projectStatusId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROJECTSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProjectStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project status persistence.
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

		_setProjectStatusUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProjectStatusUtilPersistence(null);

		entityCache.removeCache(ProjectStatusImpl.class.getName());
	}

	private void _setProjectStatusUtilPersistence(
		ProjectStatusPersistence projectStatusPersistence) {

		try {
			Field field = ProjectStatusUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, projectStatusPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = PRIMEPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = PRIMEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = PRIMEPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PROJECTSTATUS =
		"SELECT projectStatus FROM ProjectStatus projectStatus";

	private static final String _SQL_SELECT_PROJECTSTATUS_WHERE =
		"SELECT projectStatus FROM ProjectStatus projectStatus WHERE ";

	private static final String _SQL_COUNT_PROJECTSTATUS =
		"SELECT COUNT(projectStatus) FROM ProjectStatus projectStatus";

	private static final String _SQL_COUNT_PROJECTSTATUS_WHERE =
		"SELECT COUNT(projectStatus) FROM ProjectStatus projectStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "projectStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProjectStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProjectStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProjectStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private ProjectStatusModelArgumentsResolver
		_projectStatusModelArgumentsResolver;

}