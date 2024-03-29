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

import com.esquare.intranet.project.management.exception.NoSuchNotesException;
import com.esquare.intranet.project.management.model.Notes;
import com.esquare.intranet.project.management.model.NotesTable;
import com.esquare.intranet.project.management.model.impl.NotesImpl;
import com.esquare.intranet.project.management.model.impl.NotesModelImpl;
import com.esquare.intranet.project.management.service.persistence.NotesPersistence;
import com.esquare.intranet.project.management.service.persistence.NotesUtil;
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
 * The persistence implementation for the notes service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahammed Seleem
 * @generated
 */
@Component(service = NotesPersistence.class)
public class NotesPersistenceImpl
	extends BasePersistenceImpl<Notes> implements NotesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NotesUtil</code> to access the notes persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NotesImpl.class.getName();

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
	 * Returns all the noteses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching noteses
	 */
	@Override
	public List<Notes> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the noteses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @return the range of matching noteses
	 */
	@Override
	public List<Notes> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the noteses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching noteses
	 */
	@Override
	public List<Notes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Notes> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the noteses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching noteses
	 */
	@Override
	public List<Notes> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Notes> orderByComparator, boolean useFinderCache) {

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

		List<Notes> list = null;

		if (useFinderCache) {
			list = (List<Notes>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Notes notes : list) {
					if (!uuid.equals(notes.getUuid())) {
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

			sb.append(_SQL_SELECT_NOTES_WHERE);

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
				sb.append(NotesModelImpl.ORDER_BY_JPQL);
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

				list = (List<Notes>)QueryUtil.list(
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
	 * Returns the first notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notes
	 * @throws NoSuchNotesException if a matching notes could not be found
	 */
	@Override
	public Notes findByUuid_First(
			String uuid, OrderByComparator<Notes> orderByComparator)
		throws NoSuchNotesException {

		Notes notes = fetchByUuid_First(uuid, orderByComparator);

		if (notes != null) {
			return notes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNotesException(sb.toString());
	}

	/**
	 * Returns the first notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notes, or <code>null</code> if a matching notes could not be found
	 */
	@Override
	public Notes fetchByUuid_First(
		String uuid, OrderByComparator<Notes> orderByComparator) {

		List<Notes> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notes
	 * @throws NoSuchNotesException if a matching notes could not be found
	 */
	@Override
	public Notes findByUuid_Last(
			String uuid, OrderByComparator<Notes> orderByComparator)
		throws NoSuchNotesException {

		Notes notes = fetchByUuid_Last(uuid, orderByComparator);

		if (notes != null) {
			return notes;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNotesException(sb.toString());
	}

	/**
	 * Returns the last notes in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notes, or <code>null</code> if a matching notes could not be found
	 */
	@Override
	public Notes fetchByUuid_Last(
		String uuid, OrderByComparator<Notes> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Notes> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the noteses before and after the current notes in the ordered set where uuid = &#63;.
	 *
	 * @param noteId the primary key of the current notes
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notes
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	@Override
	public Notes[] findByUuid_PrevAndNext(
			long noteId, String uuid,
			OrderByComparator<Notes> orderByComparator)
		throws NoSuchNotesException {

		uuid = Objects.toString(uuid, "");

		Notes notes = findByPrimaryKey(noteId);

		Session session = null;

		try {
			session = openSession();

			Notes[] array = new NotesImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, notes, uuid, orderByComparator, true);

			array[1] = notes;

			array[2] = getByUuid_PrevAndNext(
				session, notes, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Notes getByUuid_PrevAndNext(
		Session session, Notes notes, String uuid,
		OrderByComparator<Notes> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_NOTES_WHERE);

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
			sb.append(NotesModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(notes)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Notes> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the noteses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Notes notes :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(notes);
		}
	}

	/**
	 * Returns the number of noteses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching noteses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NOTES_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "notes.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(notes.uuid IS NULL OR notes.uuid = '')";

	public NotesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Notes.class);

		setModelImplClass(NotesImpl.class);
		setModelPKClass(long.class);

		setTable(NotesTable.INSTANCE);
	}

	/**
	 * Caches the notes in the entity cache if it is enabled.
	 *
	 * @param notes the notes
	 */
	@Override
	public void cacheResult(Notes notes) {
		entityCache.putResult(NotesImpl.class, notes.getPrimaryKey(), notes);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the noteses in the entity cache if it is enabled.
	 *
	 * @param noteses the noteses
	 */
	@Override
	public void cacheResult(List<Notes> noteses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (noteses.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Notes notes : noteses) {
			if (entityCache.getResult(NotesImpl.class, notes.getPrimaryKey()) ==
					null) {

				cacheResult(notes);
			}
		}
	}

	/**
	 * Clears the cache for all noteses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NotesImpl.class);

		finderCache.clearCache(NotesImpl.class);
	}

	/**
	 * Clears the cache for the notes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Notes notes) {
		entityCache.removeResult(NotesImpl.class, notes);
	}

	@Override
	public void clearCache(List<Notes> noteses) {
		for (Notes notes : noteses) {
			entityCache.removeResult(NotesImpl.class, notes);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(NotesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NotesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new notes with the primary key. Does not add the notes to the database.
	 *
	 * @param noteId the primary key for the new notes
	 * @return the new notes
	 */
	@Override
	public Notes create(long noteId) {
		Notes notes = new NotesImpl();

		notes.setNew(true);
		notes.setPrimaryKey(noteId);

		String uuid = _portalUUID.generate();

		notes.setUuid(uuid);

		return notes;
	}

	/**
	 * Removes the notes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes that was removed
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	@Override
	public Notes remove(long noteId) throws NoSuchNotesException {
		return remove((Serializable)noteId);
	}

	/**
	 * Removes the notes with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notes
	 * @return the notes that was removed
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	@Override
	public Notes remove(Serializable primaryKey) throws NoSuchNotesException {
		Session session = null;

		try {
			session = openSession();

			Notes notes = (Notes)session.get(NotesImpl.class, primaryKey);

			if (notes == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(notes);
		}
		catch (NoSuchNotesException noSuchEntityException) {
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
	protected Notes removeImpl(Notes notes) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notes)) {
				notes = (Notes)session.get(
					NotesImpl.class, notes.getPrimaryKeyObj());
			}

			if (notes != null) {
				session.delete(notes);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (notes != null) {
			clearCache(notes);
		}

		return notes;
	}

	@Override
	public Notes updateImpl(Notes notes) {
		boolean isNew = notes.isNew();

		if (!(notes instanceof NotesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(notes.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(notes);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in notes proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Notes implementation " +
					notes.getClass());
		}

		NotesModelImpl notesModelImpl = (NotesModelImpl)notes;

		if (Validator.isNull(notes.getUuid())) {
			String uuid = _portalUUID.generate();

			notes.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(notes);
			}
			else {
				notes = (Notes)session.merge(notes);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(NotesImpl.class, notesModelImpl, false, true);

		if (isNew) {
			notes.setNew(false);
		}

		notes.resetOriginalValues();

		return notes;
	}

	/**
	 * Returns the notes with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notes
	 * @return the notes
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	@Override
	public Notes findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotesException {

		Notes notes = fetchByPrimaryKey(primaryKey);

		if (notes == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return notes;
	}

	/**
	 * Returns the notes with the primary key or throws a <code>NoSuchNotesException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes
	 * @throws NoSuchNotesException if a notes with the primary key could not be found
	 */
	@Override
	public Notes findByPrimaryKey(long noteId) throws NoSuchNotesException {
		return findByPrimaryKey((Serializable)noteId);
	}

	/**
	 * Returns the notes with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the notes
	 * @return the notes, or <code>null</code> if a notes with the primary key could not be found
	 */
	@Override
	public Notes fetchByPrimaryKey(long noteId) {
		return fetchByPrimaryKey((Serializable)noteId);
	}

	/**
	 * Returns all the noteses.
	 *
	 * @return the noteses
	 */
	@Override
	public List<Notes> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the noteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @return the range of noteses
	 */
	@Override
	public List<Notes> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the noteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of noteses
	 */
	@Override
	public List<Notes> findAll(
		int start, int end, OrderByComparator<Notes> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the noteses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of noteses
	 * @param end the upper bound of the range of noteses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of noteses
	 */
	@Override
	public List<Notes> findAll(
		int start, int end, OrderByComparator<Notes> orderByComparator,
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

		List<Notes> list = null;

		if (useFinderCache) {
			list = (List<Notes>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NOTES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NOTES;

				sql = sql.concat(NotesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Notes>)QueryUtil.list(
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
	 * Removes all the noteses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Notes notes : findAll()) {
			remove(notes);
		}
	}

	/**
	 * Returns the number of noteses.
	 *
	 * @return the number of noteses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NOTES);

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
		return "noteId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NOTES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NotesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the notes persistence.
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

		_setNotesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNotesUtilPersistence(null);

		entityCache.removeCache(NotesImpl.class.getName());
	}

	private void _setNotesUtilPersistence(NotesPersistence notesPersistence) {
		try {
			Field field = NotesUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, notesPersistence);
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

	private static final String _SQL_SELECT_NOTES =
		"SELECT notes FROM Notes notes";

	private static final String _SQL_SELECT_NOTES_WHERE =
		"SELECT notes FROM Notes notes WHERE ";

	private static final String _SQL_COUNT_NOTES =
		"SELECT COUNT(notes) FROM Notes notes";

	private static final String _SQL_COUNT_NOTES_WHERE =
		"SELECT COUNT(notes) FROM Notes notes WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "notes.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Notes exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Notes exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NotesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}