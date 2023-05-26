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

package com.master.data.service.persistence.impl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.master.data.exception.NoSuchDocumentMappingException;
import com.master.data.model.DocumentMapping;
import com.master.data.model.DocumentMappingTable;
import com.master.data.model.impl.DocumentMappingImpl;
import com.master.data.model.impl.DocumentMappingModelImpl;
import com.master.data.service.persistence.DocumentMappingPersistence;
import com.master.data.service.persistence.DocumentMappingUtil;
import com.master.data.service.persistence.impl.constants.MasterPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the document mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DocumentMappingPersistence.class, BasePersistence.class})
public class DocumentMappingPersistenceImpl
	extends BasePersistenceImpl<DocumentMapping>
	implements DocumentMappingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DocumentMappingUtil</code> to access the document mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DocumentMappingImpl.class.getName();

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
	 * Returns all the document mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document mappings
	 */
	@Override
	public List<DocumentMapping> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document mappings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMappingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document mappings
	 * @param end the upper bound of the range of document mappings (not inclusive)
	 * @return the range of matching document mappings
	 */
	@Override
	public List<DocumentMapping> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the document mappings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMappingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document mappings
	 * @param end the upper bound of the range of document mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching document mappings
	 */
	@Override
	public List<DocumentMapping> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentMapping> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document mappings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMappingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of document mappings
	 * @param end the upper bound of the range of document mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching document mappings
	 */
	@Override
	public List<DocumentMapping> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentMapping> orderByComparator,
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

		List<DocumentMapping> list = null;

		if (useFinderCache) {
			list = (List<DocumentMapping>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (DocumentMapping documentMapping : list) {
					if (!uuid.equals(documentMapping.getUuid())) {
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

			sb.append(_SQL_SELECT_DOCUMENTMAPPING_WHERE);

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
				sb.append(DocumentMappingModelImpl.ORDER_BY_JPQL);
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

				list = (List<DocumentMapping>)QueryUtil.list(
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
	 * Returns the first document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapping
	 * @throws NoSuchDocumentMappingException if a matching document mapping could not be found
	 */
	@Override
	public DocumentMapping findByUuid_First(
			String uuid, OrderByComparator<DocumentMapping> orderByComparator)
		throws NoSuchDocumentMappingException {

		DocumentMapping documentMapping = fetchByUuid_First(
			uuid, orderByComparator);

		if (documentMapping != null) {
			return documentMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocumentMappingException(sb.toString());
	}

	/**
	 * Returns the first document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapping, or <code>null</code> if a matching document mapping could not be found
	 */
	@Override
	public DocumentMapping fetchByUuid_First(
		String uuid, OrderByComparator<DocumentMapping> orderByComparator) {

		List<DocumentMapping> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapping
	 * @throws NoSuchDocumentMappingException if a matching document mapping could not be found
	 */
	@Override
	public DocumentMapping findByUuid_Last(
			String uuid, OrderByComparator<DocumentMapping> orderByComparator)
		throws NoSuchDocumentMappingException {

		DocumentMapping documentMapping = fetchByUuid_Last(
			uuid, orderByComparator);

		if (documentMapping != null) {
			return documentMapping;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDocumentMappingException(sb.toString());
	}

	/**
	 * Returns the last document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapping, or <code>null</code> if a matching document mapping could not be found
	 */
	@Override
	public DocumentMapping fetchByUuid_Last(
		String uuid, OrderByComparator<DocumentMapping> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<DocumentMapping> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the document mappings before and after the current document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param recordId the primary key of the current document mapping
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document mapping
	 * @throws NoSuchDocumentMappingException if a document mapping with the primary key could not be found
	 */
	@Override
	public DocumentMapping[] findByUuid_PrevAndNext(
			long recordId, String uuid,
			OrderByComparator<DocumentMapping> orderByComparator)
		throws NoSuchDocumentMappingException {

		uuid = Objects.toString(uuid, "");

		DocumentMapping documentMapping = findByPrimaryKey(recordId);

		Session session = null;

		try {
			session = openSession();

			DocumentMapping[] array = new DocumentMappingImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, documentMapping, uuid, orderByComparator, true);

			array[1] = documentMapping;

			array[2] = getByUuid_PrevAndNext(
				session, documentMapping, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected DocumentMapping getByUuid_PrevAndNext(
		Session session, DocumentMapping documentMapping, String uuid,
		OrderByComparator<DocumentMapping> orderByComparator,
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

		sb.append(_SQL_SELECT_DOCUMENTMAPPING_WHERE);

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
			sb.append(DocumentMappingModelImpl.ORDER_BY_JPQL);
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
						documentMapping)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<DocumentMapping> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the document mappings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (DocumentMapping documentMapping :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(documentMapping);
		}
	}

	/**
	 * Returns the number of document mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document mappings
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DOCUMENTMAPPING_WHERE);

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
		"documentMapping.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(documentMapping.uuid IS NULL OR documentMapping.uuid = '')";

	public DocumentMappingPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DocumentMapping.class);

		setModelImplClass(DocumentMappingImpl.class);
		setModelPKClass(long.class);

		setTable(DocumentMappingTable.INSTANCE);
	}

	/**
	 * Caches the document mapping in the entity cache if it is enabled.
	 *
	 * @param documentMapping the document mapping
	 */
	@Override
	public void cacheResult(DocumentMapping documentMapping) {
		entityCache.putResult(
			DocumentMappingImpl.class, documentMapping.getPrimaryKey(),
			documentMapping);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the document mappings in the entity cache if it is enabled.
	 *
	 * @param documentMappings the document mappings
	 */
	@Override
	public void cacheResult(List<DocumentMapping> documentMappings) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (documentMappings.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DocumentMapping documentMapping : documentMappings) {
			if (entityCache.getResult(
					DocumentMappingImpl.class,
					documentMapping.getPrimaryKey()) == null) {

				cacheResult(documentMapping);
			}
		}
	}

	/**
	 * Clears the cache for all document mappings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DocumentMappingImpl.class);

		finderCache.clearCache(DocumentMappingImpl.class);
	}

	/**
	 * Clears the cache for the document mapping.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DocumentMapping documentMapping) {
		entityCache.removeResult(DocumentMappingImpl.class, documentMapping);
	}

	@Override
	public void clearCache(List<DocumentMapping> documentMappings) {
		for (DocumentMapping documentMapping : documentMappings) {
			entityCache.removeResult(
				DocumentMappingImpl.class, documentMapping);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DocumentMappingImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DocumentMappingImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new document mapping with the primary key. Does not add the document mapping to the database.
	 *
	 * @param recordId the primary key for the new document mapping
	 * @return the new document mapping
	 */
	@Override
	public DocumentMapping create(long recordId) {
		DocumentMapping documentMapping = new DocumentMappingImpl();

		documentMapping.setNew(true);
		documentMapping.setPrimaryKey(recordId);

		String uuid = PortalUUIDUtil.generate();

		documentMapping.setUuid(uuid);

		return documentMapping;
	}

	/**
	 * Removes the document mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping that was removed
	 * @throws NoSuchDocumentMappingException if a document mapping with the primary key could not be found
	 */
	@Override
	public DocumentMapping remove(long recordId)
		throws NoSuchDocumentMappingException {

		return remove((Serializable)recordId);
	}

	/**
	 * Removes the document mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the document mapping
	 * @return the document mapping that was removed
	 * @throws NoSuchDocumentMappingException if a document mapping with the primary key could not be found
	 */
	@Override
	public DocumentMapping remove(Serializable primaryKey)
		throws NoSuchDocumentMappingException {

		Session session = null;

		try {
			session = openSession();

			DocumentMapping documentMapping = (DocumentMapping)session.get(
				DocumentMappingImpl.class, primaryKey);

			if (documentMapping == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocumentMappingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(documentMapping);
		}
		catch (NoSuchDocumentMappingException noSuchEntityException) {
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
	protected DocumentMapping removeImpl(DocumentMapping documentMapping) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(documentMapping)) {
				documentMapping = (DocumentMapping)session.get(
					DocumentMappingImpl.class,
					documentMapping.getPrimaryKeyObj());
			}

			if (documentMapping != null) {
				session.delete(documentMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (documentMapping != null) {
			clearCache(documentMapping);
		}

		return documentMapping;
	}

	@Override
	public DocumentMapping updateImpl(DocumentMapping documentMapping) {
		boolean isNew = documentMapping.isNew();

		if (!(documentMapping instanceof DocumentMappingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(documentMapping.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					documentMapping);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in documentMapping proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom DocumentMapping implementation " +
					documentMapping.getClass());
		}

		DocumentMappingModelImpl documentMappingModelImpl =
			(DocumentMappingModelImpl)documentMapping;

		if (Validator.isNull(documentMapping.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			documentMapping.setUuid(uuid);
		}

		if (!documentMappingModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				documentMapping.setModifiedDate(date);
			}
			else {
				documentMapping.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(documentMapping);
			}
			else {
				documentMapping = (DocumentMapping)session.merge(
					documentMapping);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DocumentMappingImpl.class, documentMappingModelImpl, false, true);

		if (isNew) {
			documentMapping.setNew(false);
		}

		documentMapping.resetOriginalValues();

		return documentMapping;
	}

	/**
	 * Returns the document mapping with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the document mapping
	 * @return the document mapping
	 * @throws NoSuchDocumentMappingException if a document mapping with the primary key could not be found
	 */
	@Override
	public DocumentMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDocumentMappingException {

		DocumentMapping documentMapping = fetchByPrimaryKey(primaryKey);

		if (documentMapping == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDocumentMappingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return documentMapping;
	}

	/**
	 * Returns the document mapping with the primary key or throws a <code>NoSuchDocumentMappingException</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping
	 * @throws NoSuchDocumentMappingException if a document mapping with the primary key could not be found
	 */
	@Override
	public DocumentMapping findByPrimaryKey(long recordId)
		throws NoSuchDocumentMappingException {

		return findByPrimaryKey((Serializable)recordId);
	}

	/**
	 * Returns the document mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping, or <code>null</code> if a document mapping with the primary key could not be found
	 */
	@Override
	public DocumentMapping fetchByPrimaryKey(long recordId) {
		return fetchByPrimaryKey((Serializable)recordId);
	}

	/**
	 * Returns all the document mappings.
	 *
	 * @return the document mappings
	 */
	@Override
	public List<DocumentMapping> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the document mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document mappings
	 * @param end the upper bound of the range of document mappings (not inclusive)
	 * @return the range of document mappings
	 */
	@Override
	public List<DocumentMapping> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the document mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document mappings
	 * @param end the upper bound of the range of document mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of document mappings
	 */
	@Override
	public List<DocumentMapping> findAll(
		int start, int end,
		OrderByComparator<DocumentMapping> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the document mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DocumentMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of document mappings
	 * @param end the upper bound of the range of document mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of document mappings
	 */
	@Override
	public List<DocumentMapping> findAll(
		int start, int end,
		OrderByComparator<DocumentMapping> orderByComparator,
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

		List<DocumentMapping> list = null;

		if (useFinderCache) {
			list = (List<DocumentMapping>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DOCUMENTMAPPING);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DOCUMENTMAPPING;

				sql = sql.concat(DocumentMappingModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DocumentMapping>)QueryUtil.list(
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
	 * Removes all the document mappings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DocumentMapping documentMapping : findAll()) {
			remove(documentMapping);
		}
	}

	/**
	 * Returns the number of document mappings.
	 *
	 * @return the number of document mappings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DOCUMENTMAPPING);

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
		return _SQL_SELECT_DOCUMENTMAPPING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DocumentMappingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the document mapping persistence.
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

		_setDocumentMappingUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDocumentMappingUtilPersistence(null);

		entityCache.removeCache(DocumentMappingImpl.class.getName());
	}

	private void _setDocumentMappingUtilPersistence(
		DocumentMappingPersistence documentMappingPersistence) {

		try {
			Field field = DocumentMappingUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, documentMappingPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = MasterPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = MasterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = MasterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_DOCUMENTMAPPING =
		"SELECT documentMapping FROM DocumentMapping documentMapping";

	private static final String _SQL_SELECT_DOCUMENTMAPPING_WHERE =
		"SELECT documentMapping FROM DocumentMapping documentMapping WHERE ";

	private static final String _SQL_COUNT_DOCUMENTMAPPING =
		"SELECT COUNT(documentMapping) FROM DocumentMapping documentMapping";

	private static final String _SQL_COUNT_DOCUMENTMAPPING_WHERE =
		"SELECT COUNT(documentMapping) FROM DocumentMapping documentMapping WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "documentMapping.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DocumentMapping exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No DocumentMapping exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DocumentMappingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private DocumentMappingModelArgumentsResolver
		_documentMappingModelArgumentsResolver;

}