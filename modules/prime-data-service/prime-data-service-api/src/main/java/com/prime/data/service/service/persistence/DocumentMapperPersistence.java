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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.prime.data.service.exception.NoSuchDocumentMapperException;
import com.prime.data.service.model.DocumentMapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the document mapper service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMapperUtil
 * @generated
 */
@ProviderType
public interface DocumentMapperPersistence
	extends BasePersistence<DocumentMapper> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentMapperUtil} to access the document mapper persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the document mappers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document mappers
	 */
	public java.util.List<DocumentMapper> findByUuid(String uuid);

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
	public java.util.List<DocumentMapper> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<DocumentMapper> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapper>
			orderByComparator);

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
	public java.util.List<DocumentMapper> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	public DocumentMapper findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentMapper>
				orderByComparator)
		throws NoSuchDocumentMapperException;

	/**
	 * Returns the first document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public DocumentMapper fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapper>
			orderByComparator);

	/**
	 * Returns the last document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	public DocumentMapper findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentMapper>
				orderByComparator)
		throws NoSuchDocumentMapperException;

	/**
	 * Returns the last document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public DocumentMapper fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapper>
			orderByComparator);

	/**
	 * Returns the document mappers before and after the current document mapper in the ordered set where uuid = &#63;.
	 *
	 * @param recordId the primary key of the current document mapper
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document mapper
	 * @throws NoSuchDocumentMapperException if a document mapper with the primary key could not be found
	 */
	public DocumentMapper[] findByUuid_PrevAndNext(
			long recordId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentMapper>
				orderByComparator)
		throws NoSuchDocumentMapperException;

	/**
	 * Removes all the document mappers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of document mappers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document mappers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the document mapper where classPk = &#63; or throws a <code>NoSuchDocumentMapperException</code> if it could not be found.
	 *
	 * @param classPk the class pk
	 * @return the matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	public DocumentMapper findByClassPK(long classPk)
		throws NoSuchDocumentMapperException;

	/**
	 * Returns the document mapper where classPk = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classPk the class pk
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public DocumentMapper fetchByClassPK(long classPk);

	/**
	 * Returns the document mapper where classPk = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classPk the class pk
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public DocumentMapper fetchByClassPK(long classPk, boolean useFinderCache);

	/**
	 * Removes the document mapper where classPk = &#63; from the database.
	 *
	 * @param classPk the class pk
	 * @return the document mapper that was removed
	 */
	public DocumentMapper removeByClassPK(long classPk)
		throws NoSuchDocumentMapperException;

	/**
	 * Returns the number of document mappers where classPk = &#63;.
	 *
	 * @param classPk the class pk
	 * @return the number of matching document mappers
	 */
	public int countByClassPK(long classPk);

	/**
	 * Returns the document mapper where documentId = &#63; or throws a <code>NoSuchDocumentMapperException</code> if it could not be found.
	 *
	 * @param documentId the document ID
	 * @return the matching document mapper
	 * @throws NoSuchDocumentMapperException if a matching document mapper could not be found
	 */
	public DocumentMapper findByDocumentId(long documentId)
		throws NoSuchDocumentMapperException;

	/**
	 * Returns the document mapper where documentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param documentId the document ID
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public DocumentMapper fetchByDocumentId(long documentId);

	/**
	 * Returns the document mapper where documentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param documentId the document ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching document mapper, or <code>null</code> if a matching document mapper could not be found
	 */
	public DocumentMapper fetchByDocumentId(
		long documentId, boolean useFinderCache);

	/**
	 * Removes the document mapper where documentId = &#63; from the database.
	 *
	 * @param documentId the document ID
	 * @return the document mapper that was removed
	 */
	public DocumentMapper removeByDocumentId(long documentId)
		throws NoSuchDocumentMapperException;

	/**
	 * Returns the number of document mappers where documentId = &#63;.
	 *
	 * @param documentId the document ID
	 * @return the number of matching document mappers
	 */
	public int countByDocumentId(long documentId);

	/**
	 * Caches the document mapper in the entity cache if it is enabled.
	 *
	 * @param documentMapper the document mapper
	 */
	public void cacheResult(DocumentMapper documentMapper);

	/**
	 * Caches the document mappers in the entity cache if it is enabled.
	 *
	 * @param documentMappers the document mappers
	 */
	public void cacheResult(java.util.List<DocumentMapper> documentMappers);

	/**
	 * Creates a new document mapper with the primary key. Does not add the document mapper to the database.
	 *
	 * @param recordId the primary key for the new document mapper
	 * @return the new document mapper
	 */
	public DocumentMapper create(long recordId);

	/**
	 * Removes the document mapper with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper that was removed
	 * @throws NoSuchDocumentMapperException if a document mapper with the primary key could not be found
	 */
	public DocumentMapper remove(long recordId)
		throws NoSuchDocumentMapperException;

	public DocumentMapper updateImpl(DocumentMapper documentMapper);

	/**
	 * Returns the document mapper with the primary key or throws a <code>NoSuchDocumentMapperException</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper
	 * @throws NoSuchDocumentMapperException if a document mapper with the primary key could not be found
	 */
	public DocumentMapper findByPrimaryKey(long recordId)
		throws NoSuchDocumentMapperException;

	/**
	 * Returns the document mapper with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapper
	 * @return the document mapper, or <code>null</code> if a document mapper with the primary key could not be found
	 */
	public DocumentMapper fetchByPrimaryKey(long recordId);

	/**
	 * Returns all the document mappers.
	 *
	 * @return the document mappers
	 */
	public java.util.List<DocumentMapper> findAll();

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
	public java.util.List<DocumentMapper> findAll(int start, int end);

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
	public java.util.List<DocumentMapper> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapper>
			orderByComparator);

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
	public java.util.List<DocumentMapper> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapper>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the document mappers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of document mappers.
	 *
	 * @return the number of document mappers
	 */
	public int countAll();

}