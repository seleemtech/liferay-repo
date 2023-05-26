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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.prime.data.service.exception.NoSuchDocumentMapperException;
import com.prime.data.service.model.DocumentMapper;
import com.prime.data.service.model.DocumentMapperTable;
import com.prime.data.service.model.impl.DocumentMapperImpl;
import com.prime.data.service.model.impl.DocumentMapperModelImpl;
import com.prime.data.service.service.persistence.DocumentMapperPersistence;
import com.prime.data.service.service.persistence.DocumentMapperUtil;
import com.prime.data.service.service.persistence.impl.constants.PRIMEPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the document mapper service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DocumentMapperPersistence.class, BasePersistence.class})
public class DocumentMapperPersistenceImpl
	extends BasePersistenceImpl<DocumentMapper>
	implements DocumentMapperPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocumentMapperUtil</code> to access the document mapper persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocumentMapperImpl.class.getName();

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
	 * Returns all the document mappers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document mappers
	 */
	@Override
	public List<DocumentMapper> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document mappers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMapperModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document mappers
	 * @param end the upper bound of the range of document mappers (not inclusive)
	 * @return the range of matching document mappers
	 */
	@Override
	public List<DocumentMapper> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the document mappers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMapperModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document mappers
	 * @param end the upper bound of the range of document mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document mappers
	 */
	@Override
	public List<DocumentMapper> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentMapper> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document mappers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMapperModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document mappers
	 * @param end the upper bound of the range of document mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document mappers
	 */
	@Override
	public List<DocumentMapper> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentMapper> orderByComparator,
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

		List<DocumentMapper> list = null;

		if (useFinderCache) {
			list = (List<DocumentMapper>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentMapper documentMapper : list) {
					if (!uuid.equals(documentMapper.getUuid())) {
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

			sb.append(_SQL_SELECT_DOCUMENTMAPPER_WHERE);

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
				sb.append(DocumentMapperModelImpl.ORDER_BY_JPQL);
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

				list = (List<DocumentMapper>)QueryUtil.list(
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
	 * Returns the first document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	@Override
	public DocumentMapper findByUuid_First(
			String uuid, OrderByComparator<DocumentMapper> orderByComparator)
		throws NoSuchDocumentMapperException {

		DocumentMapper documentMapper = fetchByUuid_First(
			uuid, orderByComparator);

		if (documentMapper != null) {
			return documentMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocumentMapperException(sb.toString());
	}

	/**
	 * Returns the first document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	@Override
	public DocumentMapper fetchByUuid_First(
		String uuid, OrderByComparator<DocumentMapper> orderByComparator) {

		List<DocumentMapper> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	@Override
	public DocumentMapper findByUuid_Last(
			String uuid, OrderByComparator<DocumentMapper> orderByComparator)
		throws NoSuchDocumentMapperException {

		DocumentMapper documentMapper = fetchByUuid_Last(
			uuid, orderByComparator);

		if (documentMapper != null) {
			return documentMapper;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocumentMapperException(sb.toString());
	}

	/**
	 * Returns the last document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	@Override
	public DocumentMapper fetchByUuid_Last(
		String uuid, OrderByComparator<DocumentMapper> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DocumentMapper> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the document mappers before and after the current document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param recordId the primary key of the current document mapper
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document mapper
	 * @throws NoSuchDocumentMapperException if a document mapper with the primary key could not be found
	 */
	@Override
	public DocumentMapper[] findByUuid_PrevAndNext(
			long recordId, String uuid,
			OrderByComparator<DocumentMapper> orderByComparator)
		throws NoSuchDocumentMapperException {

		uuid = Objects.toString(uuid, "");

		DocumentMapper documentMapper = findByPrimaryKey(recordId);

		Session session = null;

		try {
			session = openSession();

			DocumentMapper[] array = new DocumentMapperImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, documentMapper, uuid, orderByComparator, true);

			array[1] = documentMapper;

			array[2] = getByUuid_PrevAndNext(
				session, documentMapper, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocumentMapper getByUuid_PrevAndNext(
		Session session, DocumentMapper documentMapper, String uuid,
		OrderByComparator<DocumentMapper> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DOCUMENTMAPPER_WHERE);

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
			sb.append(DocumentMapperModelImpl.ORDER_BY_JPQL);
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
						documentMapper)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DocumentMapper> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document mappers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DocumentMapper documentMapper :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(documentMapper);
		}
	}

	/**
	 * Returns the number of document mappers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document mappers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTMAPPER_WHERE);

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
		"documentMapper.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(documentMapper.uuid IS NULL OR documentMapper.uuid = '')";

	private FinderPath _finderPathFetchByClassPK;
	private FinderPath _finderPathCountByClassPK;

	/**
	 * Returns the document mapper where classPk = &#63; or throws a <code>NoSuchDocumentMapperException</code> if it could not be found.
	 *
	 * @param classPk the class pk
	 * @return the matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	@Override
	public DocumentMapper findByClassPK(long classPk)
		throws NoSuchDocumentMapperException {

		DocumentMapper documentMapper = fetchByClassPK(classPk);

		if (documentMapper == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("classPk=");
			sb.append(classPk);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDocumentMapperException(sb.toString());
		}

		return documentMapper;
	}

	/**
	 * Returns the document mapper where classPk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classPk the class pk
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	@Override
	public DocumentMapper fetchByClassPK(long classPk) {
		return fetchByClassPK(classPk, true);
	}

	/**
	 * Returns the document mapper where classPk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classPk the class pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	@Override
	public DocumentMapper fetchByClassPK(long classPk, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {classPk};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByClassPK, finderArgs);
		}

		if (result instanceof DocumentMapper) {
			DocumentMapper documentMapper = (DocumentMapper)result;

			if (classPk != documentMapper.getClassPk()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCUMENTMAPPER_WHERE);

			sb.append(_FINDER_COLUMN_CLASSPK_CLASSPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classPk);

				List<DocumentMapper> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByClassPK, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {classPk};
							}

							_log.warn(
								"DocumentMapperPersistenceImpl.fetchByClassPK(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocumentMapper documentMapper = list.get(0);

					result = documentMapper;

					cacheResult(documentMapper);
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
			return (DocumentMapper)result;
		}
	}

	/**
	 * Removes the document mapper where classPk = &#63; from the database.
	 *
	 * @param classPk the class pk
	 * @return the document mapper that was removed
	 */
	@Override
	public DocumentMapper removeByClassPK(long classPk)
		throws NoSuchDocumentMapperException {

		DocumentMapper documentMapper = findByClassPK(classPk);

		return remove(documentMapper);
	}

	/**
	 * Returns the number of document mappers where classPk = &#63;.
	 *
	 * @param classPk the class pk
	 * @return the number of matching document mappers
	 */
	@Override
	public int countByClassPK(long classPk) {
		FinderPath finderPath = _finderPathCountByClassPK;

		Object[] finderArgs = new Object[] {classPk};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTMAPPER_WHERE);

			sb.append(_FINDER_COLUMN_CLASSPK_CLASSPK_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(classPk);

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

	private static final String _FINDER_COLUMN_CLASSPK_CLASSPK_2 =
		"documentMapper.classPk = ?";

	private FinderPath _finderPathFetchByDocumentId;
	private FinderPath _finderPathCountByDocumentId;

	/**
	 * Returns the document mapper where documentId = &#63; or throws a <code>NoSuchDocumentMapperException</code> if it could not be found.
	 *
	 * @param documentId the document ID
	 * @return the matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	@Override
	public DocumentMapper findByDocumentId(long documentId)
		throws NoSuchDocumentMapperException {

		DocumentMapper documentMapper = fetchByDocumentId(documentId);

		if (documentMapper == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("documentId=");
			sb.append(documentId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchDocumentMapperException(sb.toString());
		}

		return documentMapper;
	}

	/**
	 * Returns the document mapper where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentId the document ID
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	@Override
	public DocumentMapper fetchByDocumentId(long documentId) {
		return fetchByDocumentId(documentId, true);
	}

	/**
	 * Returns the document mapper where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentId the document ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	@Override
	public DocumentMapper fetchByDocumentId(
		long documentId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {documentId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByDocumentId, finderArgs);
		}

		if (result instanceof DocumentMapper) {
			DocumentMapper documentMapper = (DocumentMapper)result;

			if (documentId != documentMapper.getDocumentId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_DOCUMENTMAPPER_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

				List<DocumentMapper> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByDocumentId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {documentId};
							}

							_log.warn(
								"DocumentMapperPersistenceImpl.fetchByDocumentId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					DocumentMapper documentMapper = list.get(0);

					result = documentMapper;

					cacheResult(documentMapper);
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
			return (DocumentMapper)result;
		}
	}

	/**
	 * Removes the document mapper where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @return the document mapper that was removed
	 */
	@Override
	public DocumentMapper removeByDocumentId(long documentId)
		throws NoSuchDocumentMapperException {

		DocumentMapper documentMapper = findByDocumentId(documentId);

		return remove(documentMapper);
	}

	/**
	 * Returns the number of document mappers where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching document mappers
	 */
	@Override
	public int countByDocumentId(long documentId) {
		FinderPath finderPath = _finderPathCountByDocumentId;

		Object[] finderArgs = new Object[] {documentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTMAPPER_WHERE);

			sb.append(_FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(documentId);

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

	private static final String _FINDER_COLUMN_DOCUMENTID_DOCUMENTID_2 =
		"documentMapper.documentId = ?";

	public DocumentMapperPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DocumentMapper.class);

		setModelImplClass(DocumentMapperImpl.class);
		setModelPKClass(long.class);

		setTable(DocumentMapperTable.INSTANCE);
	}

	/**
	 * Caches the document mapper in the entity cache if it is enabled.
	 *
	 * @param documentMapper the document mapper
	 */
	@Override
	public void cacheResult(DocumentMapper documentMapper) {
		entityCache.putResult(
			DocumentMapperImpl.class, documentMapper.getPrimaryKey(),
			documentMapper);

		finderCache.putResult(
			_finderPathFetchByClassPK,
			new Object[] {documentMapper.getClassPk()}, documentMapper);

		finderCache.putResult(
			_finderPathFetchByDocumentId,
			new Object[] {documentMapper.getDocumentId()}, documentMapper);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the document mappers in the entity cache if it is enabled.
	 *
	 * @param documentMappers the document mappers
	 */
	@Override
	public void cacheResult(List<DocumentMapper> documentMappers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (documentMappers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DocumentMapper documentMapper : documentMappers) {
			if (entityCache.getResult(
					DocumentMapperImpl.class, documentMapper.getPrimaryKey()) ==
						null) {

				cacheResult(documentMapper);
			}
		}
	}

	/**
	 * Clears the cache for all document mappers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentMapperImpl.class);

		finderCache.clearCache(DocumentMapperImpl.class);
	}

	/**
	 * Clears the cache for the document mapper.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentMapper documentMapper) {
		entityCache.removeResult(DocumentMapperImpl.class, documentMapper);
	}

	@Override
	public void clearCache(List<DocumentMapper> documentMappers) {
		for (DocumentMapper documentMapper : documentMappers) {
			entityCache.removeResult(DocumentMapperImpl.class, documentMapper);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DocumentMapperImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DocumentMapperImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DocumentMapperModelImpl documentMapperModelImpl) {

		Object[] args = new Object[] {documentMapperModelImpl.getClassPk()};

		finderCache.putResult(_finderPathCountByClassPK, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByClassPK, args, documentMapperModelImpl);

		args = new Object[] {documentMapperModelImpl.getDocumentId()};

		finderCache.putResult(
			_finderPathCountByDocumentId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByDocumentId, args, documentMapperModelImpl);
	}

	/**
	 * Creates a new document mapper with the primary key. Does not add the document mapper to the database.
	 *
	 * @param recordId the primary key for the new document mapper
	 * @return the new document mapper
	 */
	@Override
	public DocumentMapper create(long recordId) {
		DocumentMapper documentMapper = new DocumentMapperImpl();

		documentMapper.setNew(true);
		documentMapper.setPrimaryKey(recordId);

		String uuid = PortalUUIDUtil.generate();

		documentMapper.setUuid(uuid);

		return documentMapper;
	}

	/**
	 * Removes the document mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper that was removed
	 * @throws NoSuchDocumentMapperException if a document mapper with the primary key could not be found
	 */
	@Override
	public DocumentMapper remove(long recordId)
		throws NoSuchDocumentMapperException {

		return remove((Serializable)recordId);
	}

	/**
	 * Removes the document mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document mapper
	 * @return the document mapper that was removed
	 * @throws NoSuchDocumentMapperException if a document mapper with the primary key could not be found
	 */
	@Override
	public DocumentMapper remove(Serializable primaryKey)
		throws NoSuchDocumentMapperException {

		Session session = null;

		try {
			session = openSession();

			DocumentMapper documentMapper = (DocumentMapper)session.get(
				DocumentMapperImpl.class, primaryKey);

			if (documentMapper == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentMapperException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(documentMapper);
		}
		catch (NoSuchDocumentMapperException noSuchEntityException) {
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
	protected DocumentMapper removeImpl(DocumentMapper documentMapper) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentMapper)) {
				documentMapper = (DocumentMapper)session.get(
					DocumentMapperImpl.class,
					documentMapper.getPrimaryKeyObj());
			}

			if (documentMapper != null) {
				session.delete(documentMapper);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (documentMapper != null) {
			clearCache(documentMapper);
		}

		return documentMapper;
	}

	@Override
	public DocumentMapper updateImpl(DocumentMapper documentMapper) {
		boolean isNew = documentMapper.isNew();

		if (!(documentMapper instanceof DocumentMapperModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(documentMapper.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					documentMapper);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in documentMapper proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocumentMapper implementation " +
					documentMapper.getClass());
		}

		DocumentMapperModelImpl documentMapperModelImpl =
			(DocumentMapperModelImpl)documentMapper;

		if (Validator.isNull(documentMapper.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			documentMapper.setUuid(uuid);
		}

		if (!documentMapperModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				documentMapper.setModifiedDate(date);
			}
			else {
				documentMapper.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(documentMapper);
			}
			else {
				documentMapper = (DocumentMapper)session.merge(documentMapper);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DocumentMapperImpl.class, documentMapperModelImpl, false, true);

		cacheUniqueFindersCache(documentMapperModelImpl);

		if (isNew) {
			documentMapper.setNew(false);
		}

		documentMapper.resetOriginalValues();

		return documentMapper;
	}

	/**
	 * Returns the document mapper with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document mapper
	 * @return the document mapper
	 * @throws NoSuchDocumentMapperException if a document mapper with the primary key could not be found
	 */
	@Override
	public DocumentMapper findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentMapperException {

		DocumentMapper documentMapper = fetchByPrimaryKey(primaryKey);

		if (documentMapper == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentMapperException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return documentMapper;
	}

	/**
	 * Returns the document mapper with the primary key or throws a <code>NoSuchDocumentMapperException</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper
	 * @throws NoSuchDocumentMapperException if a document mapper with the primary key could not be found
	 */
	@Override
	public DocumentMapper findByPrimaryKey(long recordId)
		throws NoSuchDocumentMapperException {

		return findByPrimaryKey((Serializable)recordId);
	}

	/**
	 * Returns the document mapper with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper, or <code>null</code> if a document mapper with the primary key could not be found
	 */
	@Override
	public DocumentMapper fetchByPrimaryKey(long recordId) {
		return fetchByPrimaryKey((Serializable)recordId);
	}

	/**
	 * Returns all the document mappers.
	 *
	 * @return the document mappers
	 */
	@Override
	public List<DocumentMapper> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMapperModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document mappers
	 * @param end the upper bound of the range of document mappers (not inclusive)
	 * @return the range of document mappers
	 */
	@Override
	public List<DocumentMapper> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the document mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMapperModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document mappers
	 * @param end the upper bound of the range of document mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document mappers
	 */
	@Override
	public List<DocumentMapper> findAll(
		int start, int end,
		OrderByComparator<DocumentMapper> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document mappers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMapperModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document mappers
	 * @param end the upper bound of the range of document mappers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document mappers
	 */
	@Override
	public List<DocumentMapper> findAll(
		int start, int end, OrderByComparator<DocumentMapper> orderByComparator,
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

		List<DocumentMapper> list = null;

		if (useFinderCache) {
			list = (List<DocumentMapper>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCUMENTMAPPER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTMAPPER;

				sql = sql.concat(DocumentMapperModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DocumentMapper>)QueryUtil.list(
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
	 * Removes all the document mappers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentMapper documentMapper : findAll()) {
			remove(documentMapper);
		}
	}

	/**
	 * Returns the number of document mappers.
	 *
	 * @return the number of document mappers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCUMENTMAPPER);

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
		return "recordId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DOCUMENTMAPPER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentMapperModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document mapper persistence.
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

		_finderPathFetchByClassPK = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByClassPK",
			new String[] {Long.class.getName()}, new String[] {"classPk"},
			true);

		_finderPathCountByClassPK = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClassPK",
			new String[] {Long.class.getName()}, new String[] {"classPk"},
			false);

		_finderPathFetchByDocumentId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDocumentId",
			new String[] {Long.class.getName()}, new String[] {"documentId"},
			true);

		_finderPathCountByDocumentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocumentId",
			new String[] {Long.class.getName()}, new String[] {"documentId"},
			false);

		_setDocumentMapperUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDocumentMapperUtilPersistence(null);

		entityCache.removeCache(DocumentMapperImpl.class.getName());
	}

	private void _setDocumentMapperUtilPersistence(
		DocumentMapperPersistence documentMapperPersistence) {

		try {
			Field field = DocumentMapperUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, documentMapperPersistence);
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

	private static final String _SQL_SELECT_DOCUMENTMAPPER =
		"SELECT documentMapper FROM DocumentMapper documentMapper";

	private static final String _SQL_SELECT_DOCUMENTMAPPER_WHERE =
		"SELECT documentMapper FROM DocumentMapper documentMapper WHERE ";

	private static final String _SQL_COUNT_DOCUMENTMAPPER =
		"SELECT COUNT(documentMapper) FROM DocumentMapper documentMapper";

	private static final String _SQL_COUNT_DOCUMENTMAPPER_WHERE =
		"SELECT COUNT(documentMapper) FROM DocumentMapper documentMapper WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "documentMapper.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DocumentMapper exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DocumentMapper exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentMapperPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DocumentMapperModelArgumentsResolver
		_documentMapperModelArgumentsResolver;

}