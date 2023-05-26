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

package com.prime.data.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.prime.data.service.model.DocumentMapper;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the document mapper service. This utility wraps <code>com.prime.data.service.service.persistence.impl.DocumentMapperPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMapperPersistence
 * @generated
 */
public class DocumentMapperUtil {

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
	public static void clearCache(DocumentMapper documentMapper) {
		getPersistence().clearCache(documentMapper);
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
	public static Map<Serializable, DocumentMapper> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DocumentMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DocumentMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DocumentMapper> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DocumentMapper> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DocumentMapper update(DocumentMapper documentMapper) {
		return getPersistence().update(documentMapper);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DocumentMapper update(
		DocumentMapper documentMapper, ServiceContext serviceContext) {

		return getPersistence().update(documentMapper, serviceContext);
	}

	/**
	 * Returns all the document mappers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document mappers
	 */
	public static List<DocumentMapper> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<DocumentMapper> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<DocumentMapper> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentMapper> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<DocumentMapper> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<DocumentMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	public static DocumentMapper findByUuid_First(
			String uuid, OrderByComparator<DocumentMapper> orderByComparator)
		throws com.prime.data.service.exception.NoSuchDocumentMapperException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public static DocumentMapper fetchByUuid_First(
		String uuid, OrderByComparator<DocumentMapper> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	public static DocumentMapper findByUuid_Last(
			String uuid, OrderByComparator<DocumentMapper> orderByComparator)
		throws com.prime.data.service.exception.NoSuchDocumentMapperException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public static DocumentMapper fetchByUuid_Last(
		String uuid, OrderByComparator<DocumentMapper> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static DocumentMapper[] findByUuid_PrevAndNext(
			long recordId, String uuid,
			OrderByComparator<DocumentMapper> orderByComparator)
		throws com.prime.data.service.exception.NoSuchDocumentMapperException {

		return getPersistence().findByUuid_PrevAndNext(
			recordId, uuid, orderByComparator);
	}

	/**
	 * Removes all the document mappers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of document mappers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document mappers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the document mapper where classPk = &#63; or throws a <code>NoSuchDocumentMapperException</code> if it could not be found.
	 *
	 * @param classPk the class pk
	 * @return the matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	public static DocumentMapper findByClassPK(long classPk)
		throws com.prime.data.service.exception.NoSuchDocumentMapperException {

		return getPersistence().findByClassPK(classPk);
	}

	/**
	 * Returns the document mapper where classPk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classPk the class pk
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public static DocumentMapper fetchByClassPK(long classPk) {
		return getPersistence().fetchByClassPK(classPk);
	}

	/**
	 * Returns the document mapper where classPk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classPk the class pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public static DocumentMapper fetchByClassPK(
		long classPk, boolean useFinderCache) {

		return getPersistence().fetchByClassPK(classPk, useFinderCache);
	}

	/**
	 * Removes the document mapper where classPk = &#63; from the database.
	 *
	 * @param classPk the class pk
	 * @return the document mapper that was removed
	 */
	public static DocumentMapper removeByClassPK(long classPk)
		throws com.prime.data.service.exception.NoSuchDocumentMapperException {

		return getPersistence().removeByClassPK(classPk);
	}

	/**
	 * Returns the number of document mappers where classPk = &#63;.
	 *
	 * @param classPk the class pk
	 * @return the number of matching document mappers
	 */
	public static int countByClassPK(long classPk) {
		return getPersistence().countByClassPK(classPk);
	}

	/**
	 * Returns the document mapper where documentId = &#63; or throws a <code>NoSuchDocumentMapperException</code> if it could not be found.
	 *
	 * @param documentId the document ID
	 * @return the matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	public static DocumentMapper findByDocumentId(long documentId)
		throws com.prime.data.service.exception.NoSuchDocumentMapperException {

		return getPersistence().findByDocumentId(documentId);
	}

	/**
	 * Returns the document mapper where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentId the document ID
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public static DocumentMapper fetchByDocumentId(long documentId) {
		return getPersistence().fetchByDocumentId(documentId);
	}

	/**
	 * Returns the document mapper where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentId the document ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public static DocumentMapper fetchByDocumentId(
		long documentId, boolean useFinderCache) {

		return getPersistence().fetchByDocumentId(documentId, useFinderCache);
	}

	/**
	 * Removes the document mapper where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @return the document mapper that was removed
	 */
	public static DocumentMapper removeByDocumentId(long documentId)
		throws com.prime.data.service.exception.NoSuchDocumentMapperException {

		return getPersistence().removeByDocumentId(documentId);
	}

	/**
	 * Returns the number of document mappers where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching document mappers
	 */
	public static int countByDocumentId(long documentId) {
		return getPersistence().countByDocumentId(documentId);
	}

	/**
	 * Caches the document mapper in the entity cache if it is enabled.
	 *
	 * @param documentMapper the document mapper
	 */
	public static void cacheResult(DocumentMapper documentMapper) {
		getPersistence().cacheResult(documentMapper);
	}

	/**
	 * Caches the document mappers in the entity cache if it is enabled.
	 *
	 * @param documentMappers the document mappers
	 */
	public static void cacheResult(List<DocumentMapper> documentMappers) {
		getPersistence().cacheResult(documentMappers);
	}

	/**
	 * Creates a new document mapper with the primary key. Does not add the document mapper to the database.
	 *
	 * @param recordId the primary key for the new document mapper
	 * @return the new document mapper
	 */
	public static DocumentMapper create(long recordId) {
		return getPersistence().create(recordId);
	}

	/**
	 * Removes the document mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper that was removed
	 * @throws NoSuchDocumentMapperException if a document mapper with the primary key could not be found
	 */
	public static DocumentMapper remove(long recordId)
		throws com.prime.data.service.exception.NoSuchDocumentMapperException {

		return getPersistence().remove(recordId);
	}

	public static DocumentMapper updateImpl(DocumentMapper documentMapper) {
		return getPersistence().updateImpl(documentMapper);
	}

	/**
	 * Returns the document mapper with the primary key or throws a <code>NoSuchDocumentMapperException</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper
	 * @throws NoSuchDocumentMapperException if a document mapper with the primary key could not be found
	 */
	public static DocumentMapper findByPrimaryKey(long recordId)
		throws com.prime.data.service.exception.NoSuchDocumentMapperException {

		return getPersistence().findByPrimaryKey(recordId);
	}

	/**
	 * Returns the document mapper with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper, or <code>null</code> if a document mapper with the primary key could not be found
	 */
	public static DocumentMapper fetchByPrimaryKey(long recordId) {
		return getPersistence().fetchByPrimaryKey(recordId);
	}

	/**
	 * Returns all the document mappers.
	 *
	 * @return the document mappers
	 */
	public static List<DocumentMapper> findAll() {
		return getPersistence().findAll();
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
	public static List<DocumentMapper> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<DocumentMapper> findAll(
		int start, int end,
		OrderByComparator<DocumentMapper> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<DocumentMapper> findAll(
		int start, int end, OrderByComparator<DocumentMapper> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the document mappers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of document mappers.
	 *
	 * @return the number of document mappers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DocumentMapperPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DocumentMapperPersistence _persistence;

}