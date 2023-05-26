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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.master.data.exception.NoSuchDocumentMappingException;
import com.master.data.model.DocumentMapping;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the document mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DocumentMappingUtil
 * @generated
 */
@ProviderType
public interface DocumentMappingPersistence
	extends BasePersistence<DocumentMapping> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocumentMappingUtil} to access the document mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the document mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching document mappings
	 */
	public java.util.List<DocumentMapping> findByUuid(String uuid);

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
	public java.util.List<DocumentMapping> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<DocumentMapping> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapping>
			orderByComparator);

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
	public java.util.List<DocumentMapping> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapping>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapping
	 * @throws NoSuchDocumentMappingException if a matching document mapping could not be found
	 */
	public DocumentMapping findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentMapping>
				orderByComparator)
		throws NoSuchDocumentMappingException;

	/**
	 * Returns the first document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching document mapping, or <code>null</code> if a matching document mapping could not be found
	 */
	public DocumentMapping fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapping>
			orderByComparator);

	/**
	 * Returns the last document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapping
	 * @throws NoSuchDocumentMappingException if a matching document mapping could not be found
	 */
	public DocumentMapping findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentMapping>
				orderByComparator)
		throws NoSuchDocumentMappingException;

	/**
	 * Returns the last document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching document mapping, or <code>null</code> if a matching document mapping could not be found
	 */
	public DocumentMapping fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapping>
			orderByComparator);

	/**
	 * Returns the document mappings before and after the current document mapping in the ordered set where uuid = &#63;.
	 *
	 * @param recordId the primary key of the current document mapping
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next document mapping
	 * @throws NoSuchDocumentMappingException if a document mapping with the primary key could not be found
	 */
	public DocumentMapping[] findByUuid_PrevAndNext(
			long recordId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<DocumentMapping>
				orderByComparator)
		throws NoSuchDocumentMappingException;

	/**
	 * Removes all the document mappings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of document mappings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching document mappings
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the document mapping in the entity cache if it is enabled.
	 *
	 * @param documentMapping the document mapping
	 */
	public void cacheResult(DocumentMapping documentMapping);

	/**
	 * Caches the document mappings in the entity cache if it is enabled.
	 *
	 * @param documentMappings the document mappings
	 */
	public void cacheResult(java.util.List<DocumentMapping> documentMappings);

	/**
	 * Creates a new document mapping with the primary key. Does not add the document mapping to the database.
	 *
	 * @param recordId the primary key for the new document mapping
	 * @return the new document mapping
	 */
	public DocumentMapping create(long recordId);

	/**
	 * Removes the document mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping that was removed
	 * @throws NoSuchDocumentMappingException if a document mapping with the primary key could not be found
	 */
	public DocumentMapping remove(long recordId)
		throws NoSuchDocumentMappingException;

	public DocumentMapping updateImpl(DocumentMapping documentMapping);

	/**
	 * Returns the document mapping with the primary key or throws a <code>NoSuchDocumentMappingException</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping
	 * @throws NoSuchDocumentMappingException if a document mapping with the primary key could not be found
	 */
	public DocumentMapping findByPrimaryKey(long recordId)
		throws NoSuchDocumentMappingException;

	/**
	 * Returns the document mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recordId the primary key of the document mapping
	 * @return the document mapping, or <code>null</code> if a document mapping with the primary key could not be found
	 */
	public DocumentMapping fetchByPrimaryKey(long recordId);

	/**
	 * Returns all the document mappings.
	 *
	 * @return the document mappings
	 */
	public java.util.List<DocumentMapping> findAll();

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
	public java.util.List<DocumentMapping> findAll(int start, int end);

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
	public java.util.List<DocumentMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapping>
			orderByComparator);

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
	public java.util.List<DocumentMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DocumentMapping>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the document mappings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of document mappings.
	 *
	 * @return the number of document mappings
	 */
	public int countAll();

}