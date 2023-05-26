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

package com.master.data.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.master.data.model.DocumentMapping;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the document mapping service. This utility wraps <code>com.master.data.service.persistence.impl.DocumentMappingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMappingPersistence
 * @generated
 */
public class DocumentMappingUtil {

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
	public static void clearCache(DocumentMapping documentMapping) {
		getPersistence().clearCache(documentMapping);
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
	public static Map<Serializable, DocumentMapping> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocumentMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentMapping> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentMapping update(DocumentMapping documentMapping) {
		return getPersistence().update(documentMapping);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentMapping update(
		DocumentMapping documentMapping, ServiceContext serviceContext) {

		return getPersistence().update(documentMapping, serviceContext);
	}

	/**
	 * Returns all the document mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document mappings
	 */
	public static List<DocumentMapping> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<DocumentMapping> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<DocumentMapping> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentMapping> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<DocumentMapping> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapping
	 * @throws NoSuchDocumentMappingException if a matching document mapping could not be found
	 */
	public static DocumentMapping findByUuid_First(
			String uuid, OrderByComparator<DocumentMapping> orderByComparator)
		throws com.master.data.exception.NoSuchDocumentMappingException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapping, or <code>null</code> if a matching document mapping could not be found
	 */
	public static DocumentMapping fetchByUuid_First(
		String uuid, OrderByComparator<DocumentMapping> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapping
	 * @throws NoSuchDocumentMappingException if a matching document mapping could not be found
	 */
	public static DocumentMapping findByUuid_Last(
			String uuid, OrderByComparator<DocumentMapping> orderByComparator)
		throws com.master.data.exception.NoSuchDocumentMappingException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapping, or <code>null</code> if a matching document mapping could not be found
	 */
	public static DocumentMapping fetchByUuid_Last(
		String uuid, OrderByComparator<DocumentMapping> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static DocumentMapping[] findByUuid_PrevAndNext(
			long recordId, String uuid,
			OrderByComparator<DocumentMapping> orderByComparator)
		throws com.master.data.exception.NoSuchDocumentMappingException {

		return getPersistence().findByUuid_PrevAndNext(
			recordId, uuid, orderByComparator);
	}

	/**
	 * Removes all the document mappings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of document mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document mappings
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the document mapping in the entity cache if it is enabled.
	 *
	 * @param documentMapping the document mapping
	 */
	public static void cacheResult(DocumentMapping documentMapping) {
		getPersistence().cacheResult(documentMapping);
	}

	/**
	 * Caches the document mappings in the entity cache if it is enabled.
	 *
	 * @param documentMappings the document mappings
	 */
	public static void cacheResult(List<DocumentMapping> documentMappings) {
		getPersistence().cacheResult(documentMappings);
	}

	/**
	 * Creates a new document mapping with the primary key. Does not add the document mapping to the database.
	 *
	 * @param recordId the primary key for the new document mapping
	 * @return the new document mapping
	 */
	public static DocumentMapping create(long recordId) {
		return getPersistence().create(recordId);
	}

	/**
	 * Removes the document mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping that was removed
	 * @throws NoSuchDocumentMappingException if a document mapping with the primary key could not be found
	 */
	public static DocumentMapping remove(long recordId)
		throws com.master.data.exception.NoSuchDocumentMappingException {

		return getPersistence().remove(recordId);
	}

	public static DocumentMapping updateImpl(DocumentMapping documentMapping) {
		return getPersistence().updateImpl(documentMapping);
	}

	/**
	 * Returns the document mapping with the primary key or throws a <code>NoSuchDocumentMappingException</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping
	 * @throws NoSuchDocumentMappingException if a document mapping with the primary key could not be found
	 */
	public static DocumentMapping findByPrimaryKey(long recordId)
		throws com.master.data.exception.NoSuchDocumentMappingException {

		return getPersistence().findByPrimaryKey(recordId);
	}

	/**
	 * Returns the document mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping, or <code>null</code> if a document mapping with the primary key could not be found
	 */
	public static DocumentMapping fetchByPrimaryKey(long recordId) {
		return getPersistence().fetchByPrimaryKey(recordId);
	}

	/**
	 * Returns all the document mappings.
	 *
	 * @return the document mappings
	 */
	public static List<DocumentMapping> findAll() {
		return getPersistence().findAll();
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
	public static List<DocumentMapping> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<DocumentMapping> findAll(
		int start, int end,
		OrderByComparator<DocumentMapping> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<DocumentMapping> findAll(
		int start, int end,
		OrderByComparator<DocumentMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the document mappings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of document mappings.
	 *
	 * @return the number of document mappings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentMappingPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DocumentMappingPersistence _persistence;

}